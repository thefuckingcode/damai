package tb;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import cn.damai.common.util.ToastUtil;
import cn.damai.common.util.a;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class jx0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_HOME_TAB_CACHE = "homeTabList_v3";

    private static List<HomeTabBean> a(List<HomeTabBean> list) {
        HomeTabBean homeTabBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687843223")) {
            return (List) ipChange.ipc$dispatch("-687843223", new Object[]{list});
        }
        if (!(list == null || list.size() <= 0 || (homeTabBean = list.get(0)) == null || homeTabBean.type == 999)) {
            HomeTabBean homeTabBean2 = new HomeTabBean();
            homeTabBean2.type = 999;
            homeTabBean2.name = "精选";
            homeTabBean2.spmb = "home";
            list.add(0, homeTabBean2);
        }
        for (int i = 0; i < list.size(); i++) {
            HomeTabBean homeTabBean3 = list.get(i);
            if (homeTabBean3 != null) {
                homeTabBean3.index = i;
                HomeTabBean.Args parseArgs = homeTabBean3.parseArgs();
                if (parseArgs != null) {
                    homeTabBean3.categoryId = parseArgs.categoryId;
                    homeTabBean3.groupId = parseArgs.groupId;
                }
            }
        }
        return list;
    }

    private static List<HomeTabBean> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456931738")) {
            return (List) ipChange.ipc$dispatch("-456931738", new Object[0]);
        }
        List<HomeTabBean> a = a(((HomeTabListBean) s41.a(a.n(xs0.a().getResources().openRawResource(R$raw.default_home_tab)), HomeTabListBean.class)).data);
        String str = null;
        try {
            str = JSON.toJSONString(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        d20.T(KEY_HOME_TAB_CACHE, str);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public static List<HomeTabBean> c(HomeTabListBean homeTabListBean) {
        List<HomeTabBean> parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42537150")) {
            return (List) ipChange.ipc$dispatch("-42537150", new Object[]{homeTabListBean});
        }
        List<HomeTabBean> list = null;
        String str = null;
        list = null;
        if (homeTabListBean == null || s71.a(homeTabListBean.data)) {
            try {
                String B = d20.B(KEY_HOME_TAB_CACHE);
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
        d20.T(KEY_HOME_TAB_CACHE, str);
        list = parseArray;
        if (list != null) {
        }
    }

    public static BaseSection d(String str, BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113024454")) {
            return (BaseSection) ipChange.ipc$dispatch("2113024454", new Object[]{str, baseResponse});
        } else if (baseResponse == null || f92.d(baseResponse.layers)) {
            return null;
        } else {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                if (next != null && !f92.d(next.getSections())) {
                    for (BaseSection baseSection : next.getSections()) {
                        if (baseSection != null && TextUtils.equals(str, baseSection.getComponentId())) {
                            return baseSection;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static int e(TabExtra tabExtra, List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947395737")) {
            return ((Integer) ipChange.ipc$dispatch("947395737", new Object[]{tabExtra, list})).intValue();
        }
        if (tabExtra != null && !f92.d(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                HomeTabBean homeTabBean = list.get(i);
                if (homeTabBean != null && h(tabExtra, homeTabBean)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static String f(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "462636923")) {
            return str == null ? "0" : str;
        }
        return (String) ipChange.ipc$dispatch("462636923", new Object[]{str});
    }

    public static boolean g(BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958722107")) {
            return ((Boolean) ipChange.ipc$dispatch("-958722107", new Object[]{bottomSheetBean})).booleanValue();
        } else if (bottomSheetBean == null || !f92.g(bottomSheetBean.content)) {
            return false;
        } else {
            for (BottomSheetBean.Result result : bottomSheetBean.content) {
                if (!TextUtils.isEmpty(result.popText)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean h(TabExtra tabExtra, HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710678289")) {
            return ((Boolean) ipChange.ipc$dispatch("-710678289", new Object[]{tabExtra, homeTabBean})).booleanValue();
        } else if (tabExtra.type != homeTabBean.type) {
            return false;
        } else {
            boolean equals = TextUtils.equals(f(tabExtra.categoryId), f(homeTabBean.categoryId));
            boolean equals2 = TextUtils.equals(f(tabExtra.groupId), f(homeTabBean.groupId));
            if (!equals || !equals2) {
                return false;
            }
            return true;
        }
    }

    public static boolean i(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653616850")) {
            return ((Boolean) ipChange.ipc$dispatch("1653616850", new Object[]{homeTabListBean})).booleanValue();
        }
        try {
            String B = d20.B(KEY_HOME_TAB_CACHE);
            if (homeTabListBean != null && !s71.a(homeTabListBean.data)) {
                String jSONString = JSON.toJSONString(a(homeTabListBean.data));
                return B == null || jSONString == null || !B.equals(jSONString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BaseResponse j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507037568")) {
            return (BaseResponse) ipChange.ipc$dispatch("507037568", new Object[0]);
        }
        try {
            return (BaseResponse) JSON.parseObject(a.n(xs0.a().getResources().openRawResource(R$raw.default_home_cms)), BaseResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static HomeConfigBean k() {
        HomeConfigBean homeConfigBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542575730")) {
            return (HomeConfigBean) ipChange.ipc$dispatch("1542575730", new Object[0]);
        }
        String b = cw0.b();
        if (TextUtils.isEmpty(b) || (homeConfigBean = (HomeConfigBean) s41.a(cw0.a(), HomeConfigBean.class)) == null || homeConfigBean.headLottie == null) {
            return null;
        }
        ToastUtil a = ToastUtil.a();
        Application a2 = xs0.a();
        a.j(a2, "使用了mockLottie:" + b);
        homeConfigBean.headLottie.zipUrl = b;
        return homeConfigBean;
    }
}
