//package com.lc.mvppictureoftheday.data;
//
//import android.database.Observable;
//import android.util.Log;
//
//import com.lc.mvppictureoftheday.api.NasaService;
//import com.lc.mvppictureoftheday.models.NasaItem;
//import com.lc.mvppictureoftheday.utils.Constants;
//import com.sample.mvp.dagger_rxjava_retrofit.api.MovieService;
//import com.sample.mvp.dagger_rxjava_retrofit.mvp.Movie;
//
//import javax.inject.Inject;
//
//import retrofit.RestAdapter;
//import retrofit.http.Query;
//import retrofit2.Retrofit;
//import retrofit2.http.Query;
//import rx.Observable;
//
///**
// * Created by smenesid on 21/11/2016.
// */
//
//public class AppRemoteDataStore implements NasaService {
//
//    @Inject
//    Retrofit retrofit;
//
//    public AppRemoteDataStore() {
//        MovieApplication.getAppComponent().inject(this);
//    }
//
//    @Override
//    public Observable<NasaItem> getItem(@Query("api_key") String apikey) {
//        Observable<NasaItem> call = null;
//        if (retrofit != null) {
//            NasaService apiService = retrofit.create(NasaService.class);
//            call = apiService.getItem(Constants.API_KEY) ;
//        }
//        return call;
//    }
//}
