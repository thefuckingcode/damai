package cn.damai.common.badge.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.damai.common.badge.update.BadgeLoginMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n9;
import tb.v91;

/* compiled from: Taobao */
public class BadgeLoginMonitorImpl implements BadgeLoginMonitor {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeLoginMonitor.LoginCallback a;
    private LoginBroadcastReceiver b;

    /* compiled from: Taobao */
    public class LoginBroadcastReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        private LoginBroadcastReceiver(BadgeLoginMonitorImpl badgeLoginMonitorImpl) {
        }

        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "926974180")) {
                ipChange.ipc$dispatch("926974180", new Object[]{this, context, intent});
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void setLoginCallback(BadgeLoginMonitor.LoginCallback loginCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664255758")) {
            ipChange.ipc$dispatch("664255758", new Object[]{this, loginCallback});
            return;
        }
        this.a = loginCallback;
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void startLoginMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401736769")) {
            ipChange.ipc$dispatch("-401736769", new Object[]{this});
        } else if (this.b == null) {
            try {
                this.b = new LoginBroadcastReceiver();
                n9.a().registerReceiver(this.b, new IntentFilter());
            } catch (Throwable th) {
                this.b = null;
                v91.b("BadgeLoginMonitorImpl", th);
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void stopLoginMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290366523")) {
            ipChange.ipc$dispatch("-290366523", new Object[]{this});
        } else if (this.b != null) {
            try {
                n9.a().unregisterReceiver(this.b);
            } catch (Throwable th) {
                v91.b("BadgeLoginMonitorImpl", th);
            }
        }
    }
}
