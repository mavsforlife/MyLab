package com.mavsforlife.victor.mylab.photoview;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.base.IntentFlag;
import com.mavsforlife.victor.mylab.glide.GlideApp;
import com.mavsforlife.victor.mylab.list.MainFragmentContract;
import com.mavsforlife.victor.mylab.model.Image;
import com.mavsforlife.victor.mylab.widget.ZoomImageView;

import java.util.ArrayList;
import java.util.List;

public class PhotoViewActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ImageView[] mDots;
    private ImageView[] mPhotos;

    private List<Image> mList;
    private int mInitPos;

    public static Intent createIntent(Context context, ArrayList<Image> list, int position) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putParcelableArrayListExtra(IntentFlag.IMAGE_URL_LIST, list);
        intent.putExtra(IntentFlag.IMAGE_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        mList = getIntent().getParcelableArrayListExtra(IntentFlag.IMAGE_URL_LIST);
        mInitPos = getIntent().getIntExtra(IntentFlag.IMAGE_POSITION, IntentFlag.IMAGE_DEFAULT_POSITION);
        mViewPager = findViewById(R.id.view_pager);
        initPhoto();
    }

    private void initPhoto() {
        for (int i = 0; i < mList.size(); i++) {
            ZoomImageView imageView = new ZoomImageView(this);
            GlideApp.with(this)
                    .asBitmap()
                    .load(mList.get(i).getUrl())
                    .into(imageView);
        }
        mViewPager.setAdapter(new Adapter());
        mViewPager.setCurrentItem(mInitPos);
    }

    class Adapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String imagePath = mList.get(position).getUrl();
            View v = LayoutInflater.from(PhotoViewActivity.this).inflate(R.layout.item_pager_image, null);
            ZoomImageView imageView = v.findViewById(R.id.iv_zoom);

            GlideApp.with(PhotoViewActivity.this)
                    .asBitmap()
                    .load(imagePath)
                    .into(imageView);

            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
