package com.mavsforlife.victor.mylab.lab;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mavsforlife.victor.mylab.BuildConfig;
import com.mavsforlife.victor.mylab.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LabActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTvShare, mTvShare2;
    ImageView mIv1, mIv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
        initView();
    }

    private void initView() {
        mTvShare = findViewById(R.id.tv_share);
        mTvShare2 = findViewById(R.id.tv_share2);
        mIv1 = findViewById(R.id.iv1);
        mIv2 = findViewById(R.id.iv2);
        mTvShare.setOnClickListener(this);
        mTvShare2.setOnClickListener(this);

        Bitmap flower = getBitmap("flower.jpg");
        Bitmap thunder = getBitmap("thunder.jpg");
        saveBitmap(flower, "flower.jpg");
        saveBitmap(thunder, "thunder.jpg");
        mIv1.setImageBitmap(flower);
        mIv2.setImageBitmap(thunder);

    }

    private Bitmap getBitmap(String fileName) {
        AssetManager assetManager = getAssets();
        InputStream is = null;
        try {
            is = assetManager.open(fileName);
        } catch (IOException e) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        return BitmapFactory.decodeStream(is, null, options);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_share) {
            intentToShare();
        } else if (v.getId() == R.id.tv_share2) {
            share();
        }
    }

    private void intentToShare() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
//        shareIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));//微信朋友圈
//        shareIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));//微信好友
        shareIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));//qq
//        shareIntent.setComponent(new ComponentName("com.sina.weibo", "com.sina.weibo.EditActivity"));//微博
//        shareIntent.setComponent(new ComponentName("com.qzone", "com.qzonex.module.operation.ui.QZonePublishMoodActivity"));//qq空间
        Uri uri;
        Uri uri2;
        File file = new File(getExternalCacheDir() + File.separator + "flower.jpg");
        File file2 = new File(getExternalCacheDir() + File.separator + "thunder.jpg");
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
            uri2 = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file2);
        } else {
            uri = Uri.fromFile(file);
            uri2 = Uri.fromFile(file2);
        }
        ArrayList<Uri> uris = new ArrayList<>();
        uris.add(uri);
        uris.add(uri2);
//        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra("Kdescription", "测试一键分享图文到朋友圈");
        startActivity(shareIntent);

    }

    private void share() {
        ClipboardManager cmb = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", "测试一键分享文字内容啦啦啦啦啦啦");
        cmb.setPrimaryClip(clipData);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");
        Uri uri;
        Uri uri2;
        File file = new File(getExternalCacheDir() + File.separator + "flower.jpg");
        File file2 = new File(getExternalCacheDir() + File.separator + "thunder.jpg");
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
            uri2 = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file2);
        } else {
            uri = Uri.fromFile(file);
            uri2 = Uri.fromFile(file2);
        }
        ArrayList<Uri> uris = new ArrayList<>();
        uris.add(uri);
        uris.add(uri2);
        intent.putExtra(Intent.EXTRA_STREAM, uris);
        intent.putExtra(Intent.EXTRA_TEXT, "测试一键分享文字内容啦啦啦啦啦啦");
        intent.putExtra("Kdescription", "测试一键分享图文到朋友圈");
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            intent = Intent.createChooser(intent, "share");
        }
        startActivity(intent);
    }

    private void saveBitmap(Bitmap bitmap, String name) {
        File f = new File(getExternalCacheDir() + File.separator + name);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            Log.d("share", "saveFileFail");
        }
    }
}
