package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.core.SoPatchLogic;
import com.taobao.android.sopatch.core.SoPatchLogicImpl2;

/* compiled from: Taobao */
public class nc2 {
    private SoPatchLogic a = new SoPatchLogicImpl2();
    private jc2 b;
    private jc2 c;

    private jc2 a(String str) {
        String c2 = ta1.c(str);
        s91.b("SoPatchLauncher", "remote md5", c2);
        jc2 jc2 = this.c;
        if (jc2 == null) {
            s91.b("SoPatchLauncher", "configure == null");
            jc2 = this.b;
        }
        if (!TextUtils.isEmpty(c2) && (jc2 == null || !TextUtils.equals(jc2.d(), c2))) {
            mc2.c().a();
            jc2 = new jf2().transfer(str);
            if (jc2 != null) {
                jc2.g(c2);
            } else {
                s91.b("SoPatchLauncher", " new configure == null");
            }
            ic2.a(jc2);
        }
        return jc2;
    }

    public void b(String str) {
        s91.b("SoPatchLauncher", "update  so patch data", str);
        jc2 a2 = a(str);
        if (a2 != null && a2 != this.c) {
            s91.b("SoPatchLauncher", "receiver from remote");
            a2.h("remote");
            this.c = a2;
            this.a.loadRemotePatch(a2);
        }
    }
}
