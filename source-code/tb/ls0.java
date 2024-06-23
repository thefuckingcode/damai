package tb;

import android.text.TextUtils;
import cn.damai.mine.bean.AccountUrlOrangeConfig;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ls0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        JSONObject c;
        AccountUrlOrangeConfig accountUrlOrangeConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747421104")) {
            return (String) ipChange.ipc$dispatch("-1747421104", new Object[]{str});
        }
        String b = d20.b();
        return (TextUtils.isEmpty(b) || (c = s41.c(b)) == null || !c.containsKey(str) || !(c.get(str) instanceof JSONObject) || (accountUrlOrangeConfig = (AccountUrlOrangeConfig) s41.d((JSONObject) c.get(str), AccountUrlOrangeConfig.class)) == null || TextUtils.isEmpty(accountUrlOrangeConfig.url)) ? "" : accountUrlOrangeConfig.url;
    }
}
