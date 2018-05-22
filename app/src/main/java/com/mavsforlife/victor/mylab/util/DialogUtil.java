package com.mavsforlife.victor.mylab.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.mavsforlife.victor.mylab.R;

/**
 * Created by victor on 2017/11/26.
 * Email: wwmdirk@gmail.com
 */

public class DialogUtil {

    private static ProgressDialog mProgressDialog;
    public static void showProgressDialog(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(context.getString(R.string.prapare_pic));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.show();
    }

    public static void hideProgressDialog() {
        if (null == mProgressDialog || !mProgressDialog.isShowing()){
            return;
        }
        mProgressDialog.dismiss();
    }
}
