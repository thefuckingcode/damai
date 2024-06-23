package tb;

import android.text.TextUtils;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class jq2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;

    /* compiled from: Taobao */
    private static class b {
        private static final jq2 a = new jq2();
    }

    public static jq2 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-750495027") ? (jq2) ipChange.ipc$dispatch("-750495027", new Object[0]) : b.a;
    }

    private void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292794065")) {
            ipChange.ipc$dispatch("-1292794065", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        c.e().E(str, d20.i());
        c.e().A(tk.g().f(str, str2, null), ba1.CUSTOM_LOGIN, "login");
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602376519")) {
            ipChange.ipc$dispatch("1602376519", new Object[]{this});
        } else if (!this.a) {
            this.a = true;
            String r = d20.r();
            String F = d20.F();
            if (!TextUtils.isEmpty(F)) {
                String a2 = z10.a(F);
                if (!TextUtils.isEmpty(a2) && a2.contains("|")) {
                    String[] split = a2.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                    if (split.length > 1) {
                        b(r, split[1]);
                    }
                }
            }
        }
    }

    private jq2() {
        this.a = false;
    }
}
