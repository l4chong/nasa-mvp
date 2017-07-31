package com.lc.mvppictureoftheday;

import android.app.Application;


/**
 * Created by larrychong on 2017-07-30.
 */

public class MvpApplication extends Application{
    private static AppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }

    public static AppComponent getComponent() {
        return  component;
    }
}
