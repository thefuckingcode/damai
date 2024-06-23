package com.alimm.xadsdk.base.connectivity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.utils.LogUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class NetworkStateObserver {
    public static final int NETWORK_TYPE_ETHERNET = 9;
    public static final int NETWORK_TYPE_MOBILE = 0;
    public static final int NETWORK_TYPE_NONE = -1;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "NetworkStateObserver";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private int mCurrentNetworkType;
    private final BroadcastReceiver mNetworkBroadcastReceiver;
    @TargetApi(21)
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private List<NetworkChangeListener> mNetworkChangeListeners;
    private int mPrevNetworkType;

    /* compiled from: Taobao */
    public interface NetworkChangeListener {
        void onNetworkChanged(int i);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        static final NetworkStateObserver INSTANCE = new NetworkStateObserver();

        private SingletonHolder() {
        }
    }

    private NetworkStateObserver() {
        this.mPrevNetworkType = -1;
        this.mCurrentNetworkType = -1;
        this.mNetworkBroadcastReceiver = new BroadcastReceiver() {
            /* class com.alimm.xadsdk.base.connectivity.NetworkStateObserver.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (LogUtils.DEBUG) {
                    LogUtils.d(NetworkStateObserver.TAG, "onReceive: action = " + action);
                }
                if (TextUtils.equals(action, ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                    NetworkStateObserver.this.getActiveNetworkType();
                    if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                        NetworkStateObserver.this.notifyNetworkStateChanged();
                        NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                        networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                    }
                }
            }
        };
        this.mContext = AdSdkManager.getInstance().getAppContext();
        this.mNetworkChangeListeners = new LinkedList();
        try {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        } catch (Exception e) {
            LogUtils.d(TAG, "get ConnectivityManager exception", e);
        }
        registerNetworkState();
        getActiveNetworkType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        if (r1.isConnected() != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    private void getActiveNetworkType() {
        NetworkInfo networkInfo;
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.mConnectivityManager);
        } catch (Exception e) {
            LogUtils.d(TAG, "getActiveNetworkType exception.", e);
            networkInfo = null;
        }
        int i = -1;
        if (networkInfo == null) {
            this.mCurrentNetworkType = -1;
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getActiveNetworkType with null network info.");
                return;
            }
            return;
        }
        int i2 = 1;
        if (networkInfo.getType() != 1 || !networkInfo.isConnected()) {
            if (networkInfo.getType() != 0 || !networkInfo.isConnected()) {
                i2 = 9;
                if (networkInfo.getType() == 9) {
                }
            } else {
                i = 0;
            }
            this.mCurrentNetworkType = i;
            if (!LogUtils.DEBUG) {
                LogUtils.d(TAG, "getActiveNetworkType: mPrevNetworkType = " + this.mPrevNetworkType + ", mCurrentNetworkType = " + this.mCurrentNetworkType + ", networkInfo = " + networkInfo);
                return;
            }
            return;
        }
        this.mCurrentNetworkType = i2;
        if (!LogUtils.DEBUG) {
        }
    }

    public static NetworkStateObserver getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void notifyNetworkStateChanged() {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "notifyNetworkStateChanged: mPrevNetworkType = " + this.mPrevNetworkType + ", mCurrentNetworkType = " + this.mCurrentNetworkType);
        }
        for (NetworkChangeListener networkChangeListener : this.mNetworkChangeListeners) {
            networkChangeListener.onNetworkChanged(this.mCurrentNetworkType);
        }
    }

    private void registerNetworkState() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkRequest build = new NetworkRequest.Builder().build();
                if (this.mNetworkCallback == null) {
                    this.mNetworkCallback = new ConnectivityManager.NetworkCallback() {
                        /* class com.alimm.xadsdk.base.connectivity.NetworkStateObserver.AnonymousClass2 */

                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                            if (networkCapabilities.hasCapability(16)) {
                                if (networkCapabilities.hasTransport(1)) {
                                    NetworkStateObserver.this.mCurrentNetworkType = 1;
                                } else if (networkCapabilities.hasTransport(0)) {
                                    NetworkStateObserver.this.getActiveNetworkType();
                                } else if (networkCapabilities.hasTransport(3)) {
                                    NetworkStateObserver.this.mCurrentNetworkType = 9;
                                }
                            }
                            if (LogUtils.DEBUG) {
                                LogUtils.d(NetworkStateObserver.TAG, "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + NetworkStateObserver.this.mCurrentNetworkType + ", prevType = " + NetworkStateObserver.this.mPrevNetworkType);
                            }
                            if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                                NetworkStateObserver.this.notifyNetworkStateChanged();
                                NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                                networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                            }
                        }

                        public void onLost(Network network) {
                            super.onLost(network);
                            if (LogUtils.DEBUG) {
                                LogUtils.d(NetworkStateObserver.TAG, "onLost: currentType = " + NetworkStateObserver.this.mCurrentNetworkType + ", prev = " + NetworkStateObserver.this.mPrevNetworkType + ", network = " + network);
                            }
                            NetworkStateObserver.this.getActiveNetworkType();
                            if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                                NetworkStateObserver.this.notifyNetworkStateChanged();
                                NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                                networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                            }
                        }
                    };
                }
                this.mConnectivityManager.registerNetworkCallback(build, this.mNetworkCallback);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            this.mContext.registerReceiver(this.mNetworkBroadcastReceiver, intentFilter);
        } catch (Throwable th) {
            LogUtils.d(TAG, "registerNetworkState exception.", th);
        }
    }

    private void unregisterNetworkState() {
        ConnectivityManager.NetworkCallback networkCallback;
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager != null && (networkCallback = this.mNetworkCallback) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
                return;
            }
            return;
        }
        this.mContext.unregisterReceiver(this.mNetworkBroadcastReceiver);
    }

    public synchronized void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "addNetworkChangeListener: listener = " + networkChangeListener);
        }
        this.mNetworkChangeListeners.add(networkChangeListener);
        networkChangeListener.onNetworkChanged(this.mCurrentNetworkType);
    }

    public void dispose() {
        unregisterNetworkState();
    }

    public int getCurrentNetworkType() {
        return this.mCurrentNetworkType;
    }

    public boolean hasInternet() {
        return this.mCurrentNetworkType != -1;
    }

    public boolean isWifiConnected() {
        return this.mCurrentNetworkType == 1;
    }

    public synchronized void removeNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkChangeListeners.remove(networkChangeListener);
    }
}
