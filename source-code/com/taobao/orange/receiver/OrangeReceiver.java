package com.taobao.orange.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* compiled from: Taobao */
public class OrangeReceiver extends BroadcastReceiver {
    private static final String TAG = "OrangeReceiver";
    public static volatile boolean networkValid;

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            return;
        }
        if (!AndroidUtil.isNetworkConnected(context)) {
            networkValid = false;
        } else if (!networkValid) {
            networkValid = true;
            OLog.i(TAG, "onReceive network valid", new Object[0]);
            OThreadFactory.execute(new Runnable() {
                /* class com.taobao.orange.receiver.OrangeReceiver.AnonymousClass1 */

                public void run() {
                    ConfigCenter.getInstance().retryFailRequests();
                }
            });
        }
    }
}
