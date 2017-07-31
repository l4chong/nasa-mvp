package com.lc.mvppictureoftheday.view.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.lc.mvppictureoftheday.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by larrychong on 2017-07-31.
 */

public class DetailActivity extends AppCompatActivity implements DetailView {

    public static final String KEY_IMAGE_URL = "key_image_url";
    @Bind(R.id.image_detail)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        ButterKnife.bind(this);
        setImage(getIntent().getStringExtra(KEY_IMAGE_URL));
    }

    @Override
    public void displayImage(String imageUrl) {
        setImage(imageUrl);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    private void setImage(String imageUrl){
        Picasso.with(this)
                .load(imageUrl)
                .into(mImageView);
    }
}
