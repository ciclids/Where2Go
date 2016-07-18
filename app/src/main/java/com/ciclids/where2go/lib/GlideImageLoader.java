package com.ciclids.where2go.lib;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;

    public GlideImageLoader(Fragment fragment) {
        this.glideRequestManager = Glide.with(fragment);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .fitCenter()
                .into(imageView);
    }

    @Override
    public void loadDrawable(ImageView imageView, Drawable drawable) {
        glideRequestManager
                .load("")
                .placeholder(drawable)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .fitCenter()
                .into(imageView);

    }

}