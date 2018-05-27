package com.mavsforlife.victor.mylab.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.animation.MyInterpolator;
import com.mavsforlife.victor.mylab.lab.LabActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvFriend;
    private TextView mTvShare;
    private TextView mTvTestTranslateIn;
    private TextView mTvTestTranslateOut;
    private LinearLayout mTransLate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvFriend = findViewById(R.id.tv_friend);
        mTvShare = findViewById(R.id.tv_share);
        mTvTestTranslateIn = findViewById(R.id.tv_translate_in);
        mTvTestTranslateOut = findViewById(R.id.tv_translate_out);

        mTransLate = findViewById(R.id.ll_target);
        mTvFriend.setOnClickListener(this);
        mTvShare.setOnClickListener(this);
        mTvTestTranslateIn.setOnClickListener(this);
        mTvTestTranslateOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_friend) {
            startActivity(new Intent(this, FriendActivity.class));
        } else if (id == R.id.tv_share) {
            startActivity(new Intent(this, LabActivity.class));
        } else if (id == R.id.tv_translate_in) {
            translateIn();
        } else if (id == R.id.tv_translate_out) {
            translateOut();
        }
    }

    private void translateIn() {
        mTransLate.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.from_right_to_left_in);
        animation.setInterpolator(new MyInterpolator());
        mTransLate.startAnimation(animation);
    }

    private void translateOut() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.from_left_to_right_out);
        animation.setInterpolator(new LinearInterpolator());
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mTransLate.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mTransLate.startAnimation(animation);
    }
}
