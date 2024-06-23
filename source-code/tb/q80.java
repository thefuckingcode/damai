package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
public class q80 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "510319745")) {
            return TextUtils.isEmpty(str) ? d20.c() : str;
        }
        return (String) ipChange.ipc$dispatch("510319745", new Object[]{str});
    }

    public static boolean b(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1963382265")) {
            return collection == null || collection.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1963382265", new Object[]{collection})).booleanValue();
    }

    public static void c(int i, List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258989984")) {
            ipChange.ipc$dispatch("-258989984", new Object[]{Integer.valueOf(i), list});
        } else if (!b(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).pos = i;
                i++;
            }
        }
    }
}
