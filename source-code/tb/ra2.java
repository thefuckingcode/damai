package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ra2 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DISCOUNT_TICKET_PAGE = "discount";
    private static ra2 b;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r5.equals("pinpai") == false) goto L_0x002b;
     */
    public static String f(String str) {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-369028029")) {
            return (String) ipChange.ipc$dispatch("-369028029", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return str;
        } else {
            str.hashCode();
            switch (str.hashCode()) {
                case -988144925:
                    break;
                case -703049414:
                    if (str.equals("zhekou")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 50511102:
                    if (str.equals("category")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return sc.PAGE_NAME;
                case 1:
                    return "discount";
                case 2:
                    return "category";
                default:
                    return str;
            }
        }
    }

    public static ra2 h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440029157")) {
            return (ra2) ipChange.ipc$dispatch("-1440029157", new Object[0]);
        }
        if (b == null) {
            b = new ra2();
        }
        return b;
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1545393535")) {
            return new a.b().i(f(str));
        }
        return (a.b) ipChange.ipc$dispatch("1545393535", new Object[]{this, str});
    }
}
