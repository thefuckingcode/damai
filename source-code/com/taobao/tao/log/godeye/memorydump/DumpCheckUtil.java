package com.taobao.tao.log.godeye.memorydump;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;

/* compiled from: Taobao */
public class DumpCheckUtil {
    public static boolean isLimitDump() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return false;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() < 209715200) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
