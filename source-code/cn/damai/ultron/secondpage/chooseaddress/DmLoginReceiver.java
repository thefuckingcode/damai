package cn.damai.ultron.secondpage.chooseaddress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z91;

/* compiled from: Taobao */
public class DmLoginReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnLoginListener a;

    /* compiled from: Taobao */
    public interface OnLoginListener {
        void onLoginFail();

        void onLoginSuccess();
    }

    public DmLoginReceiver(OnLoginListener onLoginListener) {
        this.a = onLoginListener;
    }

    public void onReceive(Context context, Intent intent) {
        OnLoginListener onLoginListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110943813")) {
            ipChange.ipc$dispatch("110943813", new Object[]{this, context, intent});
        } else if (intent != null) {
            String action = intent.getAction();
            if (z91.BROADCAST_LOGIN_SUCCESS.equals(action)) {
                OnLoginListener onLoginListener2 = this.a;
                if (onLoginListener2 != null) {
                    onLoginListener2.onLoginSuccess();
                }
            } else if (z91.BROADCAST_LOGOUT_SUCCESS.equals(action) && (onLoginListener = this.a) != null) {
                onLoginListener.onLoginFail();
            }
        }
    }
}
