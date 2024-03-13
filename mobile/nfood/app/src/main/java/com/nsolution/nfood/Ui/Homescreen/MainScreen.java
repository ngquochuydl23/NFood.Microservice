package com.nsolution.nfood.Ui.Homescreen;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.nsolution.nfood.Network.InterfaceService.IProfile;
import com.nsolution.nfood.R;
import com.nsolution.nfood.Ui.Base.BaseActivity1;
import com.nsolution.nfood.https.HttpClient;
import com.nsolution.nfood.https.IHttpClient;

public class MainScreen extends BaseActivity1 {
    private IProfile profileService;
    public MainScreen() {
        super(R.layout.activity_homescreen);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profileService = new HttpClient(MainScreen.this)
                .getRetrofit()
                .create(IProfile.class);
    }

    private void fetchProfile() {
        profileService.getProfile();
    }
}
