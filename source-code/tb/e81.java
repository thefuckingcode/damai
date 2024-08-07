package tb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class e81 extends sk {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String a = "damai_processer_project_live";

    private String[] a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709959623")) {
            return (String[]) ipChange.ipc$dispatch("1709959623", new Object[]{this});
        }
        String b = OrangeConfigCenter.c().b(a, "ids", "");
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return b.split(",");
    }

    private String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1269726140")) {
            return (String) ipChange.ipc$dispatch("-1269726140", new Object[]{this, str});
        }
        String b = OrangeConfigCenter.c().b(a, "url", "");
        if (!TextUtils.isEmpty(b)) {
            return b + str;
        }
        return "https://t.damai.cn/yep/page/m/dmlive?itemId=" + str;
    }

    private boolean c(String str, String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903854252")) {
            return ((Boolean) ipChange.ipc$dispatch("903854252", new Object[]{this, str, strArr})).booleanValue();
        }
        if (!(TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395324770")) {
            return ((Boolean) ipChange.ipc$dispatch("-395324770", new Object[]{this, intent, context})).booleanValue();
        }
        if (intent != null && !TextUtils.isEmpty(intent.getDataString())) {
            String dataString = intent.getDataString();
            g91.b("LiveTempProcessor", "LiveTempProcessor url : " + dataString);
            if (dataString.startsWith(sb2.PROJECT_SCHEMA)) {
                String str = in2.a(intent.getExtras()) + "";
                if (c(str, a())) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", b(str));
                    DMNav.from(context).withExtras(bundle).toUri(NavUri.b(a.c.d));
                    g91.b("LiveTempProcessor", "LiveTempProcessor intercept id : " + b(str));
                    return true;
                }
            }
            g91.b("LiveTempProcessor", "LiveTempProcessor return false : " + dataString);
        }
        return false;
    }
}
