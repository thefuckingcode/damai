package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.SortBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class zc {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    public boolean b;

    public zc(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static zc a(List<CategoryBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815357327")) {
            return (zc) ipChange.ipc$dispatch("-815357327", new Object[]{list});
        } else if (f92.d(list)) {
            return new zc("品类", false);
        } else {
            StringBuilder sb = new StringBuilder();
            for (CategoryBean categoryBean : list) {
                sb.append(",");
                sb.append(categoryBean.name);
            }
            sb.deleteCharAt(0);
            return new zc(sb.toString(), true);
        }
    }

    public static zc b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798231688")) {
            return (zc) ipChange.ipc$dispatch("1798231688", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "品类";
        }
        return new zc(str, !TextUtils.equals("品类", str));
    }

    public static zc c(CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139028801")) {
            return (zc) ipChange.ipc$dispatch("2139028801", new Object[]{cityBean});
        }
        if (cityBean == null) {
            cityBean = CityBean.defaultCity();
        }
        return new zc(cityBean.cityName, !TextUtils.equals(cityBean.cityCode, d20.c()));
    }

    public static zc d(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111738088")) {
            return (zc) ipChange.ipc$dispatch("111738088", new Object[]{calendarBean});
        }
        String str = "全部时间";
        if (calendarBean == null) {
            return new zc(str, false);
        }
        boolean equals = calendarBean.equals(CalendarBean.defaultAllTime());
        if (!equals) {
            str = calendarBean.name;
        }
        return new zc(str, !equals);
    }

    public static zc e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-70748385") ? (zc) ipChange.ipc$dispatch("-70748385", new Object[0]) : new zc("默认", false);
    }

    public static zc f(HashMap<String, List<FilterBean>> hashMap, List<String> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1271321022")) {
            return (zc) ipChange.ipc$dispatch("1271321022", new Object[]{hashMap, list});
        }
        if (!f92.d(list) && !f92.f(hashMap)) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!f92.d(hashMap.get(next)) && list.contains(next)) {
                    break;
                }
            }
            return new zc("筛选", z);
        }
        z = false;
        return new zc("筛选", z);
    }

    @NotNull
    public static String h(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelOne> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735640397")) {
            return (String) ipChange.ipc$dispatch("-1735640397", new Object[]{list, list2});
        }
        if (!f92.d(list) && !f92.d(list2)) {
            StringBuilder sb = new StringBuilder();
            for (CategoryLevelOne categoryLevelOne : list) {
                int indexOf = list2.indexOf(categoryLevelOne);
                if (indexOf >= 0 && !f92.d(categoryLevelOne.lineItemList)) {
                    CategoryLevelOne categoryLevelOne2 = list2.get(indexOf);
                    if (!f92.d(categoryLevelOne2.lineItemList)) {
                        if (!categoryLevelOne2.lineItemList.get(0).isAll()) {
                            for (CategoryLevelTwo categoryLevelTwo : categoryLevelOne.lineItemList) {
                                if (categoryLevelOne2.lineItemList.contains(categoryLevelTwo)) {
                                    sb.append(categoryLevelTwo.name);
                                    sb.append(",");
                                }
                            }
                        } else if (categoryLevelOne.lineItemList.size() == 1) {
                            sb.append(categoryLevelOne.name);
                            sb.append(",");
                        } else {
                            for (CategoryLevelTwo categoryLevelTwo2 : categoryLevelOne.lineItemList) {
                                if (!categoryLevelTwo2.isAll()) {
                                    sb.append(categoryLevelTwo2.name);
                                    sb.append(",");
                                }
                            }
                        }
                    }
                }
                if (sb.length() >= 12) {
                    break;
                }
            }
            if (sb.length() >= 1) {
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        }
        return "品类";
    }

    public static zc i(SortBean sortBean, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "808921878")) {
            return (zc) ipChange.ipc$dispatch("808921878", new Object[]{sortBean, list});
        } else if (sortBean == null || f92.d(list)) {
            return new zc("默认", false);
        } else {
            if (list.indexOf(sortBean) == 0) {
                z = false;
            }
            return new zc(sortBean.name, z);
        }
    }

    public String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46945864")) {
            return (String) ipChange.ipc$dispatch("-46945864", new Object[]{this});
        }
        String str = this.a;
        return str == null ? "默认" : str;
    }
}
