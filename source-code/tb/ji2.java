package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
public class ji2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final ji2 a = new ji2();
    }

    public static final ji2 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2022436939") ? (ji2) ipChange.ipc$dispatch("2022436939", new Object[0]) : b.a;
    }

    public void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66609051")) {
            ipChange.ipc$dispatch("-66609051", new Object[]{this, str, str2});
            return;
        }
        c("", str, str2);
    }

    public void c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866297105")) {
            ipChange.ipc$dispatch("-866297105", new Object[]{this, str, str2, str3});
            return;
        }
        TLog.logd(str, str2, str3);
    }

    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394970948")) {
            ipChange.ipc$dispatch("1394970948", new Object[]{this, str, str2});
            return;
        }
        e("", str, str2);
    }

    public void e(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498051086")) {
            ipChange.ipc$dispatch("1498051086", new Object[]{this, str, str2, str3});
            return;
        }
        TLog.loge(str, str2, str3);
    }

    public void f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348643648")) {
            ipChange.ipc$dispatch("-1348643648", new Object[]{this, str, str2});
            return;
        }
        g("", str, str2);
    }

    public void g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929458038")) {
            ipChange.ipc$dispatch("-1929458038", new Object[]{this, str, str2, str3});
            return;
        }
        TLog.logi(str, str2, str3);
    }

    public void h(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472027155")) {
            ipChange.ipc$dispatch("472027155", new Object[]{this, str, str2});
            return;
        }
        i("", str, str2);
    }

    public void i(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257702627")) {
            ipChange.ipc$dispatch("-1257702627", new Object[]{this, str, str2, str3});
            return;
        }
        TLog.logv(str, str2, str3);
    }

    public void j(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933607154")) {
            ipChange.ipc$dispatch("1933607154", new Object[]{this, str, str2});
            return;
        }
        k("", str, str2);
    }

    public void k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1106645564")) {
            ipChange.ipc$dispatch("1106645564", new Object[]{this, str, str2, str3});
            return;
        }
        TLog.logw(str, str2, str3);
    }

    private ji2() {
    }
}
