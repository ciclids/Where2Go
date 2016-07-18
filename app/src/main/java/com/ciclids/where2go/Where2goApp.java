package com.ciclids.where2go;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by max on 2016
 */
public class Where2goApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

}
