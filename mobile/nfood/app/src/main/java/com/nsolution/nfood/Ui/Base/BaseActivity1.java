package com.nsolution.nfood.Ui.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity1 extends AppCompatActivity {

    private int viewResource;
    private String title;

    public BaseActivity1(int viewResource) {
        this.viewResource = viewResource;
    }

    public BaseActivity1(int viewResource, String title) {
        this.viewResource = viewResource;
        this.title = title;
    }

    public int getViewResource() {
        return viewResource;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(viewResource);
    }
}
