package com.youku.phone.xcdnengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    private List<NetWorkCallBack> callBackList = new ArrayList();

    /* compiled from: Taobao */
    public enum NetType {
        WIFI,
        MOBILE,
        NONE
    }

    /* compiled from: Taobao */
    public interface NetWorkCallBack {
        void netWorkChange(NetType netType);
    }

    private void notifyCallBack(NetType netType) {
        List<NetWorkCallBack> list = this.callBackList;
        if (list != null) {
            for (NetWorkCallBack netWorkCallBack : list) {
                netWorkCallBack.netWorkChange(netType);
            }
        }
    }

    public void addNetWorkCallBack(NetWorkCallBack netWorkCallBack) {
        this.callBackList.add(netWorkCallBack);
    }

    public void onReceive(Context context, Intent intent) {
        if (!ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(context)) {
            notifyCallBack(NetType.NONE);
        } else if (NetworkUtils.isWifi(context)) {
            notifyCallBack(NetType.WIFI);
        } else {
            notifyCallBack(NetType.MOBILE);
        }
    }
}
