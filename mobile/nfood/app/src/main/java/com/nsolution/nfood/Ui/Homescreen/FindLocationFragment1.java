package com.nsolution.nfood.Ui.Homescreen;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.nsolution.nfood.R;
import com.nsolution.nfood.Ui.Base.BaseFragment1;


public class FindLocationFragment1 extends BaseFragment1 {

    private static String LOG_TAG = "FindingLocationFragment";

    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private final int REQUEST_CHECK_SETTINGS = 0x1;
    private final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    private final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    private final String KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates";
    private final String KEY_LOCATION = "location";
    private final String KEY_LAST_UPDATED_TIME_STRING = "last-updated-time-string";
    private FusedLocationProviderClient mFusedLocationClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private Location mCurrentLocation;
    private Boolean mRequestingLocationUpdates;
    private LocationCallback locationCallback;
    private LottieAnimationView markerAnimateView;
    private TextView currentAddressTextView;


    public FindLocationFragment1() {
        super(R.layout.fragment_find_location);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        markerAnimateView = view.findViewById(R.id.markerAnimateView);
        currentAddressTextView = view.findViewById(R.id.currentAddressTextView);

        markerAnimateView.setAnimation(R.raw.find_location);
    }

    private void setupLocationRequest() {
        mRequestingLocationUpdates = true;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getFragmentActivity());
        mSettingsClient = LocationServices.getSettingsClient(getFragmentActivity());

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder locationReqBuilder = new LocationSettingsRequest.Builder();
        LocationSettingsRequest locationSettingsRequest = locationReqBuilder
                .addLocationRequest(mLocationRequest)
                .build();

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);

                mCurrentLocation = locationResult.getLastLocation();
                // mLastUpdateTime = DateFormat.getTimeInstance().format(Date())

                if (mCurrentLocation != null) {
                    Log.i(LOG_TAG, mCurrentLocation.toString());

                    stopLocationUpdate();
                    //AddressFromLocation
                    currentAddressTextView.setText("");


                } else {
                    currentAddressTextView.setText("Location not found");
                }
            }
        };

        mSettingsClient
                .checkLocationSettings(locationSettingsRequest)
                .addOnSuccessListener(getFragmentActivity(), new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        mFusedLocationClient.requestLocationUpdates(mLocationRequest, locationCallback, Looper.myLooper());
                    }
                })
                .addOnFailureListener(getFragmentActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();

                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                try {
                                    ResolvableApiException resolveApiExection = (ResolvableApiException) e;
                                    resolveApiExection.startResolutionForResult(getFragmentActivity(), REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException ex) {
                                    Log.e(LOG_TAG, ex.getMessage());
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errMsg = "Location settings are inadequate, and cannot be fixed here. Fix in Settings.";
                                Log.e(LOG_TAG, errMsg);
                                mRequestingLocationUpdates = false;
                                break;
                        }
                    }
                });
    }

    @Override
    public void onStop() {
        Log.i(LOG_TAG, "onStop -> stopLocationUpdate");
        stopLocationUpdate();
        markerAnimateView.pauseAnimation();
        super.onStop();
    }

    @Override
    public void onResume() {
        markerAnimateView.pauseAnimation();
        markerAnimateView.playAnimation();
        requirePermissions();
        super.onResume();
    }

    public void requirePermissions() {
        int permissionState = ActivityCompat
                .checkSelfPermission(getFragmentActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionState != PackageManager.PERMISSION_GRANTED) {

            Log.i(LOG_TAG, "Permissions are not allowed by user. Request permissions");
            ActivityCompat.requestPermissions(
                    getFragmentActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE
            );
            return;
        }

        Log.i(LOG_TAG, "Permissions are allowed by user. Getting new location");
        setupLocationRequest();
    }

    @SuppressLint("MissingPermission")
    private void stopLocationUpdate() {
        if (!mRequestingLocationUpdates) {
            Log.i(LOG_TAG, "stopLocationUpdates: updates never requested, no-op.");
        }

        mFusedLocationClient
                .removeLocationUpdates(locationCallback)
                .addOnCompleteListener(getFragmentActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        mRequestingLocationUpdates = false;
                        Log.i(LOG_TAG, "Stop requesting location");
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHECK_SETTINGS && resultCode == Activity.RESULT_OK) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    Log.i(LOG_TAG, "User agreed to make required location settings changes.");
                    break;
                case Activity.RESULT_CANCELED:
                    mRequestingLocationUpdates = false;
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE && grantResults.length > 0) {
            Log.i(LOG_TAG, "Permissions are allowed by user");
            setupLocationRequest();
        }
    }
}