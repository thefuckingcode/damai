package tb;

import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.util.a;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class gh {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CHANNEL_TAB_CACHE = "channelTabList";

    private static List<HomeTabBean> a(List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931631067")) {
            return (List) ipChange.ipc$dispatch("1931631067", new Object[]{list});
        }
        for (int i = 0; i < list.size(); i++) {
            HomeTabBean homeTabBean = list.get(i);
            if (homeTabBean != null) {
                homeTabBean.index = i;
                HomeTabBean.Args parseArgs = homeTabBean.parseArgs();
                if (parseArgs != null) {
                    homeTabBean.categoryId = parseArgs.categoryId;
                    homeTabBean.groupId = parseArgs.groupId;
                }
            }
        }
        return list;
    }

    private static List<HomeTabBean> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66508108")) {
            return (List) ipChange.ipc$dispatch("-66508108", new Object[0]);
        }
        List<HomeTabBean> a = a(((HomeTabListBean) s41.a(a.n(xs0.a().getResources().openRawResource(R$raw.default_home_tab)), HomeTabListBean.class)).data);
        String str = null;
        try {
            str = JSON.toJSONString(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        d20.T(KEY_CHANNEL_TAB_CACHE, str);
        return a;
    }

    public static int c(TabExtra tabExtra, List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1729574681")) {
            return ((Integer) ipChange.ipc$dispatch("-1729574681", new Object[]{tabExtra, list})).intValue();
        }
        if (tabExtra != null && !f92.d(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                HomeTabBean homeTabBean = list.get(i);
                if (homeTabBean != null && f(tabExtra, homeTabBean)) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public static List<HomeTabBean> d(HomeTabListBean homeTabListBean) {
        List<HomeTabBean> parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962254035")) {
            return (List) ipChange.ipc$dispatch("962254035", new Object[]{homeTabListBean});
        }
        List<HomeTabBean> list = null;
        String str = null;
        list = null;
        if (homeTabListBean == null || s71.a(homeTabListBean.data)) {
            try {
                String B = d20.B(KEY_CHANNEL_TAB_CACHE);
                if (!TextUtils.isEmpty(B)) {
                    parseArray = JSON.parseArray(B, HomeTabBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list != null ? b() : list;
        }
        parseArray = a(homeTabListBean.data);
        try {
            str = JSON.toJSONString(parseArray);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("CMSTAB", "getHomeTabList error " + e2.getMessage());
        }
        d20.T(KEY_CHANNEL_TAB_CACHE, str);
        list = parseArray;
        if (list != null) {
        }
    }

    private static String e(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "926594157")) {
            return str == null ? "0" : str;
        }
        return (String) ipChange.ipc$dispatch("926594157", new Object[]{str});
    }

    private static boolean f(TabExtra tabExtra, HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752393539")) {
            return ((Boolean) ipChange.ipc$dispatch("-1752393539", new Object[]{tabExtra, homeTabBean})).booleanValue();
        } else if (tabExtra.type != homeTabBean.type) {
            return false;
        } else {
            boolean equals = TextUtils.equals(e(tabExtra.categoryId), e(homeTabBean.categoryId));
            boolean equals2 = TextUtils.equals(e(tabExtra.groupId), e(homeTabBean.groupId));
            if (!equals || !equals2) {
                return false;
            }
            return true;
        }
    }

    public static boolean g(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973166843")) {
            return ((Boolean) ipChange.ipc$dispatch("-1973166843", new Object[]{homeTabListBean})).booleanValue();
        }
        try {
            String B = d20.B(KEY_CHANNEL_TAB_CACHE);
            if (homeTabListBean != null && !s71.a(homeTabListBean.data)) {
                String jSONString = JSON.toJSONString(a(homeTabListBean.data));
                return B == null || jSONString == null || !B.equals(jSONString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
