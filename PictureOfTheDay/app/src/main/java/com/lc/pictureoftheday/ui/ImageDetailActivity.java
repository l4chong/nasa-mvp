package com.lc.pictureoftheday.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lc.pictureoftheday.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageDetailActivity extends AppCompatActivity {
    public static final String KEY_IMAGE_URL = "key_image_url";
    @BindView(R.id.image_detail) ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        ButterKnife.bind(this);
        setImage(getIntent().getStringExtra(KEY_IMAGE_URL));
    }

    private void setImage(String imageUrl){
        Picasso.with(this)
                .load(imageUrl)
                .into(mImageView);
    }
}
