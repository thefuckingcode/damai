package tb;

import android.content.Intent;
import cn.damai.common.DamaiConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class z91 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BROADCAST_LOGIN_SUCCESS = "broadcast_login_success";
    public static final String BROADCAST_LOGOUT_SUCCESS = "broadcast_logout_success";

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736021668")) {
            ipChange.ipc$dispatch("-736021668", new Object[]{str});
            return;
        }
        b20.a();
        hi2.b(str);
        String valueOf = String.valueOf(2);
        String q = d20.q();
        d20.y0(z10.b(q + "|" + str + "|" + valueOf));
    }

    public static void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232867634")) {
            ipChange.ipc$dispatch("-232867634", new Object[]{str});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("userCode", str);
        intent.setAction(BROADCAST_LOGIN_SUCCESS);
        xs0.a().sendBroadcast(intent);
        d20.S(1);
        br.c(DamaiConstants.RED_PACKET, 1);
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728440212")) {
            ipChange.ipc$dispatch("1728440212", new Object[0]);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(BROADCAST_LOGOUT_SUCCESS);
        xs0.a().sendBroadcast(intent);
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139861525")) {
            ipChange.ipc$dispatch("-139861525", new Object[0]);
        } else {
            b20.b();
        }
    }
}
