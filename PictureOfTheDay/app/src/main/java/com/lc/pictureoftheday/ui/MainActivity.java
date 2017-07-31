package com.lc.pictureoftheday.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.pictureoftheday.R;
import com.lc.pictureoftheday.api.NasaService;
import com.lc.pictureoftheday.core.BaseActivity;
import com.lc.pictureoftheday.models.NasaItem;
import com.lc.pictureoftheday.utils.Connectivity;
import com.lc.pictureoftheday.utils.Constants;
import com.lc.pictureoftheday.utils.NetworkUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends BaseActivity {
    @BindView(R.id.image) ImageView mImageView;
    @BindView(R.id.title) TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (Connectivity.isConnected(this)){
            getNasaPictureOfTheDay();
        }else{
            showErrorMessage(getString(R.string.error_message_no_connection));
        }

    }

    private void getNasaPictureOfTheDay(){
        NasaService api = NasaService.retrofit.create(NasaService.class);
        Call<NasaItem> call = api.getItem(Constants.API_KEY);
        call.enqueue(new Callback<NasaItem>() {
            @Override
            public void onResponse(Call<NasaItem> call, final Response<NasaItem> response) {
                if(NetworkUtil.isResponseCodeOK(response.code())){
                    Timber.v("response " + response.body().getUrl());
                    setViews(response);
                } else {
                    showErrorMessage(getString(R.string.error_message));
                }
            }

            @Override
            public void onFailure(Call<NasaItem> call, Throwable t) {
                Timber.v("response failed");
                showErrorMessage(getString(R.string.error_message));
            }
        });
    }

    private void setViews(final Response<NasaItem> response) {
        setImage(response.body().getUrl());
        mTitle.setText(response.body().getTitle());
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDetailActivity(response.body().getUrl());
            }
        });
    }

    private void navigateToDetailActivity(String imageUrl) {

        mTitle.animate().alpha(0).setDuration(Constants.ANIMATION_DURATION)
                .setInterpolator(new DecelerateInterpolator()).start();

        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra(ImageDetailActivity.KEY_IMAGE_URL, imageUrl);
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        mImageView,
                        getString(R.string.transition_image));
        startActivity(intent, options.toBundle());
    }

    private void showErrorMessage(String message){
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.error_message_title))
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    private void setImage(String imageUrl){
        Picasso.with(this)
                .load(imageUrl)
                .into(mImageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTitle.animate().alpha(1).setDuration(Constants.ANIMATION_DURATION)
                .setInterpolator(new DecelerateInterpolator()).start();
    }
}
