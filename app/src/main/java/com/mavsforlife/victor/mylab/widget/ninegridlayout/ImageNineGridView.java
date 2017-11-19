package com.mavsforlife.victor.mylab.widget.ninegridlayout;

import android.content.Context;
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

import java.util.List;

/**
 * Created by Victor on 5/13/16.
 *
 */
public class ImageNineGridView extends AbstractNineGridLayout<List<Image>> {
    private ImageView[] imageViews;
    private View[] gifViews;

    public ImageNineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void fill() {
        fill(R.layout.item_image_grid);
        imageViews = findInChildren(R.id.image, ImageView.class);
        gifViews = findInChildren(R.id.gif, View.class);
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
        for (int i = 0; i < images.size(); i++) {
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
                    Toast.makeText(getContext(), "点击了第" + (finalI + 1) + "张图片", Toast.LENGTH_SHORT).show();
                }
            });
            gifViews[i].setVisibility(url.endsWith(".gif") ? VISIBLE : INVISIBLE);
        }
    }
}
