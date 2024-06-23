package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileFilter;

/* compiled from: TbsCheckUtils */
public class m {
    private static File c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (!file.isDirectory() || !file.exists()) {
            return null;
        }
        return file;
    }

    public static boolean a(Context context) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return b(context);
        }
        return true;
    }

    public static boolean b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (Build.VERSION.SDK_INT <= 25) {
                    File c = c(context);
                    if (c == null) {
                        return true;
                    }
                    File[] listFiles = c.listFiles(new FileFilter() {
                        /* class com.tencent.smtt.utils.m.AnonymousClass1 */

                        public boolean accept(File file) {
                            String name = file.getName();
                            return !TextUtils.isEmpty(name) && name.endsWith(".dex");
                        }
                    });
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            if (file.exists()) {
                                if (a(file)) {
                                    TbsLog.w("TbsCheckUtils", "" + file + " is invalid --> check failed!");
                                    file.delete();
                                    return false;
                                }
                                TbsLog.i("TbsCheckUtils", "" + file + " #4 check success!");
                            }
                        }
                    }
                    TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
                    return true;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(File file) {
        try {
            if (!e.b(file)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("TbsCheckUtils", "isOatFileBroken exception: " + th);
            return false;
        }
    }
}
