package io.flutter.plugins.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* compiled from: Taobao */
public class Connectivity {
    private ConnectivityManager connectivityManager;

    public Connectivity(ConnectivityManager connectivityManager2) {
        this.connectivityManager = connectivityManager2;
    }

    private String getNetworkTypeLegacy() {
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.connectivityManager);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return "mobile";
        }
        if (type == 1) {
            return "wifi";
        }
        if (type == 4 || type == 5) {
            return "mobile";
        }
        if (type == 6 || type == 9) {
            return "wifi";
        }
        return "none";
    }

    public ConnectivityManager getConnectivityManager() {
        return this.connectivityManager;
    }

    /* access modifiers changed from: package-private */
    public String getNetworkType() {
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(this.connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
                return "wifi";
            }
            if (networkCapabilities.hasTransport(0)) {
                return "mobile";
            }
        }
        return getNetworkTypeLegacy();
    }
}
