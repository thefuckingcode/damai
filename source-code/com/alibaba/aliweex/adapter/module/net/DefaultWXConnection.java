package com.alibaba.aliweex.adapter.module.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.taobao.weex.utils.WXLogUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DefaultWXConnection implements IWXConnection {
    private Context a;
    private ConnectivityManager b;
    private ConnectivityReceiver c;
    private List<IWXConnection.OnNetworkChangeListener> d;
    private boolean e = false;
    private String f = "";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ConnectivityReceiver extends BroadcastReceiver {
        private ConnectivityReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                try {
                    DefaultWXConnection.this.b();
                } catch (Exception e) {
                    WXLogUtils.e("WXConnectionModule", e.getMessage());
                }
            }
        }
    }

    DefaultWXConnection(@NonNull Context context) {
        this.a = context.getApplicationContext();
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.c = new ConnectivityReceiver();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        List<IWXConnection.OnNetworkChangeListener> list = this.d;
        if (!(list == null || list.isEmpty())) {
            String type = getType();
            if (type.equals(IWXConnection.TYPE_CELLULAR)) {
                type = getNetworkType();
            }
            if (!type.equalsIgnoreCase(this.f)) {
                this.f = type;
                WXLogUtils.d("WXConnectionModule", "network type changed to " + this.f);
                for (IWXConnection.OnNetworkChangeListener onNetworkChangeListener : this.d) {
                    onNetworkChangeListener.onNetworkChange();
                }
            }
        }
    }

    private void c() {
        if (this.a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            this.a.registerReceiver(this.c, intentFilter);
        }
    }

    private void d() {
        Context context = this.a;
        if (context != null) {
            try {
                context.unregisterReceiver(this.c);
            } catch (Exception e2) {
                WXLogUtils.e("WXConnectionModule", e2.getMessage());
            }
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public void addNetworkChangeListener(@Nullable IWXConnection.OnNetworkChangeListener onNetworkChangeListener) {
        if (onNetworkChangeListener != null) {
            if (this.d == null) {
                this.d = new ArrayList(4);
            }
            this.d.add(onNetworkChangeListener);
            if (!this.e) {
                this.e = true;
                c();
            }
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public void destroy() {
        if (this.e) {
            d();
        }
        List<IWXConnection.OnNetworkChangeListener> list = this.d;
        if (list != null) {
            list.clear();
            this.d = null;
        }
        this.e = false;
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public double getDownlinkMax() {
        String type = getType();
        type.hashCode();
        char c2 = 65535;
        switch (type.hashCode()) {
            case -1419358249:
                if (type.equals(IWXConnection.TYPE_ETHERNET)) {
                    c2 = 0;
                    break;
                }
                break;
            case -916596374:
                if (type.equals(IWXConnection.TYPE_CELLULAR)) {
                    c2 = 1;
                    break;
                }
                break;
            case -284840886:
                if (type.equals("unknown")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3649301:
                if (type.equals("wifi")) {
                    c2 = 3;
                    break;
                }
                break;
            case 106069776:
                if (type.equals("other")) {
                    c2 = 4;
                    break;
                }
                break;
            case 113134930:
                if (type.equals(IWXConnection.TYPE_WIMAX)) {
                    c2 = 5;
                    break;
                }
                break;
            case 1968882350:
                if (type.equals(IWXConnection.TYPE_BLUETOOTH)) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 10000.0d;
            case 1:
                String networkType = getNetworkType();
                if ("2g".equals(networkType)) {
                    return 0.384d;
                }
                if ("3g".equals(networkType)) {
                    return 42.0d;
                }
                if ("4g".equals(networkType)) {
                    return 100.0d;
                }
                return Double.MAX_VALUE;
            case 2:
                return Double.MAX_VALUE;
            case 3:
                return 7000.0d;
            case 4:
                return Double.MAX_VALUE;
            case 5:
                return 365.0d;
            case 6:
                return 24.0d;
            default:
                return 0.0d;
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    @NonNull
    public String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.b);
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "none";
            }
            if (!activeNetworkInfo.isAvailable()) {
                return "none";
            }
            int type = activeNetworkInfo.getType();
            if (!ConnectivityManager.isNetworkTypeValid(type)) {
                return "unknown";
            }
            if (type == 1) {
                return "wifi";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3g";
                case 13:
                    return "4g";
                default:
                    return "other";
            }
        } catch (Exception e2) {
            WXLogUtils.e("WXConnectionModule", e2.getMessage());
            return "unknown";
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    @NonNull
    public String getType() {
        try {
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.b);
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "none";
            }
            if (!activeNetworkInfo.isAvailable()) {
                return "none";
            }
            int type = activeNetworkInfo.getType();
            if (!ConnectivityManager.isNetworkTypeValid(type)) {
                return "unknown";
            }
            if (type == 1) {
                return "wifi";
            }
            if (type == 7) {
                return IWXConnection.TYPE_BLUETOOTH;
            }
            if (type == 6) {
                return IWXConnection.TYPE_WIMAX;
            }
            if (type == 9) {
                return IWXConnection.TYPE_ETHERNET;
            }
            return type == 0 ? IWXConnection.TYPE_CELLULAR : "other";
        } catch (SecurityException e2) {
            WXLogUtils.e("WXConnectionModule", e2.getMessage());
            return "unknown";
        }
    }
}
