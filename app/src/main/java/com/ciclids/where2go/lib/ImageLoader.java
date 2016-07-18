package com.ciclids.where2go.lib;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;


public interface ImageLoader {
    void load(ImageView imageView, String URL);

    void loadDrawable(ImageView placeListImage, Drawable drawable);
}
