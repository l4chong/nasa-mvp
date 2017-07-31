package com.lc.mvppictureoftheday;

import com.lc.mvppictureoftheday.repository.NasaRepository;
import com.lc.mvppictureoftheday.repository.NasaRepositoryImpl;
import com.lc.mvppictureoftheday.view.main.MainPresenter;
import com.lc.mvppictureoftheday.view.main.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by larrychong on 2017-07-30.
 */

@Module
public class AppModule {
    @Provides
    @Singleton
    public NasaRepository provideNasaRepository() {
        return new NasaRepositoryImpl();
    }

    @Provides
    public MainPresenter provideMainPresenter(NasaRepository nasaRepository) {
        return new MainPresenterImpl(nasaRepository);
    }
}