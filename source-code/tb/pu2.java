package tb;

import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class pu2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152378371")) {
            ipChange.ipc$dispatch("152378371", new Object[]{str});
        } else if (!TextUtils.isEmpty(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter("utm");
            if (!TextUtils.isEmpty(queryParameter)) {
                c.e().H("utm", queryParameter);
            }
        }
    }
}
