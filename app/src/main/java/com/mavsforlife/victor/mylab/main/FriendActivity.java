package com.mavsforlife.victor.mylab.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.list.MainFragment;

public class FriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        MainFragment fragment = MainFragment.newInstance("1", "2");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fr_container, fragment);
        ft.commitAllowingStateLoss();
    }
}
