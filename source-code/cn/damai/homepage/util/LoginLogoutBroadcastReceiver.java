package cn.damai.homepage.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z91;

/* compiled from: Taobao */
public class LoginLogoutBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private Runnable a;
    private LoginCallback b;

    /* compiled from: Taobao */
    public interface LoginCallback {
        void loginLogout();

        void loginSuccess();
    }

    public LoginLogoutBroadcastReceiver(Runnable runnable, LoginCallback loginCallback) {
        this.a = runnable;
        this.b = loginCallback;
    }

    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290313216")) {
            ipChange.ipc$dispatch("290313216", new Object[]{this, context, intent});
            return;
        }
        if (z91.BROADCAST_LOGIN_SUCCESS.equals(intent.getAction())) {
            this.b.loginSuccess();
        } else if (z91.BROADCAST_LOGOUT_SUCCESS.equals(intent.getAction())) {
            this.b.loginLogout();
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
