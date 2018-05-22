package com.mavsforlife.victor.mylab.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.lab.LabActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvFriend;
    private TextView mTvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvFriend = findViewById(R.id.tv_friend);
        mTvShare = findViewById(R.id.tv_share);
        mTvFriend.setOnClickListener(this);
        mTvShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_friend) {
            startActivity(new Intent(this, FriendActivity.class));
        } else if (id == R.id.tv_share) {
            startActivity(new Intent(this, LabActivity.class));
        }
    }
}
