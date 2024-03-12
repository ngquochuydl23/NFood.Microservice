package com.nsolution.nfood.Utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.nsolution.nfood.Models.ShippingAddressDto;

import java.io.IOException;

public class LocationUtil {

    private Context ctx;
    private Geocoder geocoder;

    public LocationUtil(Context ctx) {
        this.ctx = ctx;
        this.geocoder = new Geocoder(ctx);
    }

    public ShippingAddressDto getGeoLocation(Location location) {
        LatLng latLng = new LatLng(location);

        Double lat = latLng.getLatitude();
        Double lng = latLng.getLongitude();
        try {
            Address address = geocoder
                    .getFromLocation(latLng.getLatitude(), latLng.getLongitude(), 1)
                    .get(0);

            if (address == null) {
                return null;
            }
            return new ShippingAddressDto(address.getAddressLine(0), lat, lng);
        } catch (IOException e) {

            Log.e("LocationUtil", "Cannot not fetch address info");
            e.printStackTrace();
            return null;
        }
    }
}
