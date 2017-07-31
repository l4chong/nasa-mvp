package com.lc.mvppictureoftheday.view.main;

import com.lc.mvppictureoftheday.models.NasaItem;
import com.lc.mvppictureoftheday.repository.NasaRepository;

/**
 * Created by larrychong on 2017-07-30.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mView;
    private NasaRepository mNasaRepository;
    private NasaItem mItem;

    public MainPresenterImpl(NasaRepository nasaRepository){
        this.mNasaRepository = nasaRepository;
    }
    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setView(MainView view) {
        this.mView = view;
        loadNasaImageOfDay();
    }

    @Override
    public void loadNasaImageOfDay() {
        mItem = mNasaRepository.getNasaItem();
        if(mItem == null) {
            mView.showErrorMessage("There seems to be a problem");
        } else {
            mView.displayImage(mItem.getUrl());
            mView.displayTitle(mItem.getTitle());
        }
    }

    public String getUrl(){
        return mItem.getUrl();
    }

}
