package com.mavsforlife.victor.mylab.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by victor on 2017/7/21.
 */

public class AudioView extends View {

    private int mRectCount = 4;
    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private Paint mPaint;
    private int offset = 4;
    private float mLastHeight = 0.0f;

    public AudioView(Context context) {
        this(context, null);
    }

    public AudioView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AudioView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public AudioView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            double random = Math.random();
            float currentHeight = (float) (mRectHeight * random);

            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint
            );

            canvas.scale(1, (currentHeight / mLastHeight));
            mLastHeight = currentHeight;

            postInvalidateDelayed(300);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        mRectHeight = getHeight();

        LinearGradient mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP
        );
        mPaint.setShader(mLinearGradient);
    }
}
