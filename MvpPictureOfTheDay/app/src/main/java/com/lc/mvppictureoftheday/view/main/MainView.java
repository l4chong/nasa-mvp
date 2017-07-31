package com.lc.mvppictureoftheday.view.main;

/**
 * Created by larrychong on 2017-07-30.
 */

public interface MainView {
    void displayTitle(String title);
    void displayImage(String imageUrl);
    void showErrorMessage(String message);
}
