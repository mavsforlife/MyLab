package com.mavsforlife.victor.mylab.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.request.target.Target;
import com.mavsforlife.victor.mylab.glide.GlideApp;
import com.mavsforlife.victor.mylab.model.Image;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by victor on 2017/11/25.
 * Email: wwmdirk@gmail.com
 */

public class DownLoadImageUtil {

    public static File savePicture(Context context, final String fileName, String url) throws Exception {

        File f = new File(context.getExternalCacheDir() + File.separator + fileName);
        if (f.exists()) {
            return f;
        }
        Bitmap bitmap =
                GlideApp.with(context)
                        .asBitmap()
                        .load(url)
                        .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();
        if (bitmap != null) {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            return f;
        }
        return null;
    }
}
