package com.mavsforlife.victor.mylab.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mavsforlife.victor.mylab.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvFriend = findViewById(R.id.tv_friend);
        mTvFriend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_friend) {
            startActivity(new Intent(this, FriendActivity.class));
        }
    }
}
