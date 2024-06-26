package com.youku.alixplayer.opensdk.utils;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;

/* compiled from: Taobao */
public class NetworkUtil {
    public static boolean isConnectedCellular(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isConnectedNet(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isConnectedWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
