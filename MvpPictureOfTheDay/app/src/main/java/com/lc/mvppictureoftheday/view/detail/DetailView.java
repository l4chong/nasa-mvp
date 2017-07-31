package com.lc.mvppictureoftheday.view.detail;

/**
 * Created by larrychong on 2017-07-31.
 */
public interface DetailView {
    void displayImage(String imageUrl);
    void showErrorMessage(String message);
}
