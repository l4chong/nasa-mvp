package com.lc.mvppictureoftheday.view.main;

import com.lc.mvppictureoftheday.LifecyclePresenter;


/**
 * Created by larrychong on 2017-07-30.
 */


public interface MainPresenter extends LifecyclePresenter {
    void setView(MainView view);
    void loadNasaImageOfDay();
}
