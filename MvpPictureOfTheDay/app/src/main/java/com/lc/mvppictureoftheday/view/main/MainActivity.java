package com.lc.mvppictureoftheday.view.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.lc.mvppictureoftheday.MvpApplication;
import com.lc.mvppictureoftheday.R;
import com.lc.mvppictureoftheday.utils.Constants;
import com.lc.mvppictureoftheday.view.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @Bind(R.id.image) ImageView mImageView;
    @Bind(R.id.title) TextView mTitle;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MvpApplication.getComponent().inject(this);
        mainPresenter.setView(this);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDetailActivity(mainPresenter.getUrl());
            }
        });
    }

    private void navigateToDetailActivity(String imageUrl) {

        mTitle.animate().alpha(0).setDuration(Constants.ANIMATION_DURATION)
                .setInterpolator(new DecelerateInterpolator()).start();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_IMAGE_URL, imageUrl);
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        mImageView,
                        getString(R.string.transition_image));
        startActivity(intent, options.toBundle());
    }



    @Override
    public void displayTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void displayImage(String imageUrl) {
        Picasso.with(this)
                .load(imageUrl)
                .into(mImageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
        mTitle.animate().alpha(1).setDuration(Constants.ANIMATION_DURATION)
                .setInterpolator(new DecelerateInterpolator()).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.onPause();
    }

    @Override
    public void showErrorMessage(String message) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.error_message_title))
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}
