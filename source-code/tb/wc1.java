package tb;

import android.text.TextUtils;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.aranger.constant.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class wc1 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FOLLOW_REPLY_MSG = "follow_reply_msg";
    public static final String HOME_MESSAGE_LIST_PAGE = "messagelist";
    public static final String HOME_MESSAGE_PAGE = "message";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final wc1 a = new wc1();
    }

    public static final wc1 m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-863112603") ? (wc1) ipChange.ipc$dispatch("-863112603", new Object[0]) : a.a;
    }

    public a.b f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "588462712")) {
            return new a.b().k(str).i(str2);
        }
        return (a.b) ipChange.ipc$dispatch("588462712", new Object[]{this, str, str2});
    }

    public a.b g(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1243072313")) {
            return e(str, str2, str3, map, bool);
        }
        return (a.b) ipChange.ipc$dispatch("-1243072313", new Object[]{this, str, str2, str3, map, bool});
    }

    public a.b h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403965989")) {
            return (a.b) ipChange.ipc$dispatch("403965989", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        return e(FOLLOW_REPLY_MSG, "top", "tab_reply", hashMap, Boolean.FALSE);
    }

    public a.b i(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416279572")) {
            return (a.b) ipChange.ipc$dispatch("416279572", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        hashMap.put("titlelabel", str2);
        return e(FOLLOW_REPLY_MSG, Constants.PARAM_REPLY, "reply_" + i, hashMap, Boolean.TRUE);
    }

    public a.b j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444638433")) {
            return (a.b) ipChange.ipc$dispatch("1444638433", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        return e(FOLLOW_REPLY_MSG, "top", "tab_follow", hashMap, Boolean.FALSE);
    }

    public a.b k(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1669536602")) {
            return (a.b) ipChange.ipc$dispatch("1669536602", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("titlelabel", str2);
        }
        return e(FOLLOW_REPLY_MSG, StarFragment.KEY_FOLLOW, "account_homepage_" + i, hashMap, Boolean.TRUE);
    }

    public a.b l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "919398501")) {
            return b(FOLLOW_REPLY_MSG);
        }
        return (a.b) ipChange.ipc$dispatch("919398501", new Object[]{this});
    }

    public a.b n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-960753485")) {
            return b("message");
        }
        return (a.b) ipChange.ipc$dispatch("-960753485", new Object[]{this});
    }

    public a.b o(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "198716398")) {
            return f(str, HOME_MESSAGE_LIST_PAGE);
        }
        return (a.b) ipChange.ipc$dispatch("198716398", new Object[]{this, str});
    }

    public a.b p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405669807")) {
            return (a.b) ipChange.ipc$dispatch("-1405669807", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contentlabel", str);
        return e("message", "list", "suggestmessage", hashMap, Boolean.FALSE);
    }
}
