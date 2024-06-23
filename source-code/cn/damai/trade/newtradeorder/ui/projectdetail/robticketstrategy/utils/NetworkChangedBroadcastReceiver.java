package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* compiled from: Taobao */
public class NetworkChangedBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnNetworkChangedListener a;

    /* compiled from: Taobao */
    public interface OnNetworkChangedListener {
        void onNetworkChanged();
    }

    public NetworkChangedBroadcastReceiver(OnNetworkChangedListener onNetworkChangedListener) {
        this.a = onNetworkChangedListener;
    }

    public void onReceive(Context context, Intent intent) {
        OnNetworkChangedListener onNetworkChangedListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821335768")) {
            ipChange.ipc$dispatch("-821335768", new Object[]{this, context, intent});
        } else if (intent != null && ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction()) && (onNetworkChangedListener = this.a) != null) {
            onNetworkChangedListener.onNetworkChanged();
        }
    }
}
