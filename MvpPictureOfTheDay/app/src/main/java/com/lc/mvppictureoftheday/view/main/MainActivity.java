package com.lc.mvppictureoftheday.view.main;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lc.mvppictureoftheday.MvpApplication;
import com.lc.mvppictureoftheday.R;
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
//        ((MvpApplication) getApplication()).getComponent().inject(this);
        MvpApplication.getComponent().inject(this);
        mainPresenter.setView(this);
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
