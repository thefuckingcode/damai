package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ba1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CUSTOM_LOGIN = "logininfo";
    public static final String LOGIN_BINDTEL_PAGE = "bindtel";
    public static final String LOGIN_CODECHECK_PAGE = "codecheck";
    public static final String LOGIN_FASTLOGIN_PAGE = "fastlogin";
    public static final String LOGIN_FINDPWD = "findpassword";
    public static final String LOGIN_PAGE = "login";
    public static final String REGISTER_PAGE = "register";

    /* compiled from: Taobao */
    private static class b {
        private static final ba1 a = new ba1();
    }

    public static final ba1 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-198388379") ? (ba1) ipChange.ipc$dispatch("-198388379", new Object[0]) : b.a;
    }

    public Map<String, String> f(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1511479057")) {
            return (Map) ipChange.ipc$dispatch("-1511479057", new Object[]{this, str, str2, str3});
        } else if (str2 == null || str == null) {
            return null;
        } else {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("tel", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("usercode", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("titlelabel", str3);
            }
            return hashMap;
        }
    }

    private ba1() {
    }
}
