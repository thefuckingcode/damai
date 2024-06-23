package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class pu0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static pu0 a;

    private pu0() {
    }

    public static pu0 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177665769")) {
            return (pu0) ipChange.ipc$dispatch("-1177665769", new Object[0]);
        }
        if (a == null) {
            synchronized (pu0.class) {
                a = new pu0();
            }
        }
        return a;
    }

    public void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561689395")) {
            ipChange.ipc$dispatch("1561689395", new Object[]{this, context});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(LoginManager.ACTION_DO_LOGIN, 0);
        if (context instanceof Activity) {
            DMNav.from(context).forResult(1005).withExtras(bundle).toUri(NavUri.b("login"));
        } else {
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("login"));
        }
    }
}
