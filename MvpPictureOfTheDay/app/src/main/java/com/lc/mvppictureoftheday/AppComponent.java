package com.lc.mvppictureoftheday;

import com.lc.mvppictureoftheday.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by larrychong on 2017-07-30.
 */
@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {
    void inject(MainActivity activity);
}