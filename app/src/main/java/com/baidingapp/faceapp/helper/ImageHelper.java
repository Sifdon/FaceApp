package com.baidingapp.faceapp.helper;

import android.content.Context;
import android.widget.ImageView;

import com.baidingapp.faceapp.GlideApp;
import com.baidingapp.faceapp.R;

public class ImageHelper {

    // ImageLoad Method
    public static void ImageLoad(Context context, String imageUrl, ImageView imageView) {
        GlideApp.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.face_image)
                .error(R.drawable.face_image)
                .into(imageView);
    }

}