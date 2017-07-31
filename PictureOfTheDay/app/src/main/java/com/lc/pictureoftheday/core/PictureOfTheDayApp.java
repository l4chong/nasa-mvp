package com.lc.pictureoftheday.core;

import android.app.Application;

import com.lc.pictureoftheday.BuildConfig;

import timber.log.Timber;

public class PictureOfTheDayApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
