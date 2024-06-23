package com.autonavi.base.amap.mapcore.maploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class NetworkState {
    private boolean isNetReceiverRegistered = false;
    private NetworkChangeListener mNetworkListener;
    private MyBroadcastReceiver netChangeReceiver = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class MyBroadcastReceiver extends BroadcastReceiver {
        WeakReference<NetworkChangeListener> reference = null;

        public MyBroadcastReceiver(NetworkChangeListener networkChangeListener) {
            this.reference = new WeakReference<>(networkChangeListener);
        }

        public void onReceive(Context context, Intent intent) {
            WeakReference<NetworkChangeListener> weakReference = this.reference;
            if (weakReference != null && weakReference.get() != null) {
                this.reference.get().networkStateChanged(context);
            }
        }
    }

    /* compiled from: Taobao */
    public interface NetworkChangeListener {
        void networkStateChanged(Context context);
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return null;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i] != null) {
                    if (allNetworkInfo[i].isConnected()) {
                        return allNetworkInfo[i];
                    }
                }
            }
            return activeNetworkInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void registerNetChangeReceiver(Context context, boolean z) {
        MyBroadcastReceiver myBroadcastReceiver;
        if (z) {
            if (!this.isNetReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                if (this.netChangeReceiver == null) {
                    this.netChangeReceiver = new MyBroadcastReceiver(this.mNetworkListener);
                }
                context.registerReceiver(this.netChangeReceiver, intentFilter);
            }
        } else if (this.isNetReceiverRegistered && (myBroadcastReceiver = this.netChangeReceiver) != null) {
            context.unregisterReceiver(myBroadcastReceiver);
            this.netChangeReceiver = null;
        }
        this.isNetReceiverRegistered = z;
    }

    public void setNetworkListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkListener = networkChangeListener;
    }
}
