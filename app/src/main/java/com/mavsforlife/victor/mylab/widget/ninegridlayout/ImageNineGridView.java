package com.mavsforlife.victor.mylab.widget.ninegridlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.glide.GlideApp;
import com.mavsforlife.victor.mylab.model.Image;
import com.mavsforlife.victor.mylab.photoview.PhotoViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 5/13/16.
 *
 */
public class ImageNineGridView extends AbstractNineGridLayout<List<Image>> {
    private ImageView[] imageViews;

    public ImageNineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void fill() {
        fill(R.layout.item_image_grid);
        imageViews = findInChildren(R.id.image, ImageView.class);
    }

    @Override
    public void render(final List<Image> images) {
        Glide.with(getContext())
                .asBitmap()
                .load(images.get(0).getUrl())
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        int width = resource.getWidth();
                        int height = resource.getHeight();
                        images.get(0).setWidth(width);
                        images.get(0).setHeight(height);
                        setSingleModeSize(images.get(0).getWidth(), images.get(0).getHeight());
                    }
                });
        setDisplayCount(images.size());
        if (images.size() == 1) {
            String url = images.get(0).getUrl();
            ImageView imageView = imageViews[0];
            GlideApp.with(getContext())
                    .asBitmap()
                    .load(url)
                    .fitCenter()
                    .error(R.color.gray)
                    .into(imageView);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(PhotoViewActivity.createIntent(getContext(), (ArrayList<Image>) images, 0));
                    ((Activity)getContext()).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
            });
        } else {
            for (int i = 0; i < images.size(); i++) {
                if (i > 8) return;
                String url = images.get(i).getUrl();
                GlideApp.with(getContext())
                        .asBitmap()
                        .load(url)
                        .error(R.color.gray)
                        .into(imageViews[i]);
                ImageView imageView = imageViews[i];
                final int finalI = i;
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getContext().startActivity(PhotoViewActivity.createIntent(getContext(), (ArrayList<Image>) images, finalI));
                        ((Activity)getContext()).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                });
            }
        }

    }
}
