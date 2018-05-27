package com.mavsforlife.victor.mylab.animation;

import android.view.animation.Interpolator;

/**
 * Created by victor on 2018/5/25.
 * Email: wwmdirk@gmail.com
 */
public class MyInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        if (input < 0.166f) {
            return input * 5;
        } else {
            return (float) (0.8 + input * 0.2);
        }
    }
}
