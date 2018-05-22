package com.mavsforlife.victor.mylab.util;

import android.text.TextUtils;

/**
 * Created by victor on 2017/11/28.
 * Email: wwmdirk@gmail.com
 */

public class StringUtil {

    public static String getImgName(String url) {
        if (TextUtils.isEmpty(url)) {
            return "1.jpg";
        }
        String[] strs = url.split("/");
        return strs[strs.length - 1];
    }
}
