package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.SortBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class yc {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    public boolean b;

    public yc(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static yc a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793267288")) {
            return (yc) ipChange.ipc$dispatch("-793267288", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "品类";
        }
        return new yc(str, !TextUtils.equals("品类", str));
    }

    public static yc b(CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723125068")) {
            return (yc) ipChange.ipc$dispatch("1723125068", new Object[]{cityBean});
        }
        if (cityBean == null) {
            cityBean = CityBean.defaultCity();
        }
        return new yc(cityBean.cityName, !TextUtils.equals(cityBean.cityCode, nl.INSTANCE.a().getCityId()));
    }

    public static yc c(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189698995")) {
            return (yc) ipChange.ipc$dispatch("1189698995", new Object[]{calendarBean});
        }
        String str = "全部时间";
        if (calendarBean == null) {
            return new yc(str, false);
        }
        boolean equals = calendarBean.equals(CalendarBean.defaultAllTime());
        if (!equals) {
            str = calendarBean.name;
        }
        return new yc(str, !equals);
    }

    public static yc d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-967212033") ? (yc) ipChange.ipc$dispatch("-967212033", new Object[0]) : new yc("默认", false);
    }

    public static yc e(HashMap<String, List<FilterBean>> hashMap, List<String> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1786641502")) {
            return (yc) ipChange.ipc$dispatch("1786641502", new Object[]{hashMap, list});
        }
        if (!e92.d(list) && !e92.e(hashMap)) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!e92.d(hashMap.get(next)) && list.contains(next)) {
                    break;
                }
            }
            return new yc("筛选", z);
        }
        z = false;
        return new yc("筛选", z);
    }

    @NotNull
    public static String g(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelOne> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635504926")) {
            return (String) ipChange.ipc$dispatch("1635504926", new Object[]{list, list2});
        }
        if (!e92.d(list) && !e92.d(list2)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (CategoryLevelOne categoryLevelOne : list) {
                int indexOf = list2.indexOf(categoryLevelOne);
                if (indexOf >= 0 && !e92.d(categoryLevelOne.lineItemList)) {
                    CategoryLevelOne categoryLevelOne2 = list2.get(indexOf);
                    if (!e92.d(categoryLevelOne2.lineItemList)) {
                        if (!categoryLevelOne2.lineItemList.get(0).isAll()) {
                            for (CategoryLevelTwo categoryLevelTwo : categoryLevelOne.lineItemList) {
                                if (categoryLevelOne2.lineItemList.contains(categoryLevelTwo)) {
                                    sb.append(categoryLevelTwo.name);
                                    sb.append(",");
                                    i++;
                                }
                            }
                        } else if (categoryLevelOne.lineItemList.size() == 1) {
                            sb.append(categoryLevelOne.name);
                            sb.append(",");
                            i++;
                        } else {
                            for (CategoryLevelTwo categoryLevelTwo2 : categoryLevelOne.lineItemList) {
                                if (!categoryLevelTwo2.isAll()) {
                                    sb.append(categoryLevelTwo2.name);
                                    sb.append(",");
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            if (sb.length() >= 1) {
                sb.deleteCharAt(sb.length() - 1);
                if (i > 2) {
                    sb.append("等");
                    sb.append(i);
                    sb.append("类");
                }
                return sb.toString();
            }
        }
        return "品类";
    }

    public static yc h(SortBean sortBean, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-104294623")) {
            return (yc) ipChange.ipc$dispatch("-104294623", new Object[]{sortBean, list});
        } else if (sortBean == null || e92.d(list)) {
            return new yc("默认", false);
        } else {
            if (list.indexOf(sortBean) == 0) {
                z = false;
            }
            return new yc(sortBean.name, z);
        }
    }

    public String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820084515")) {
            return (String) ipChange.ipc$dispatch("1820084515", new Object[]{this});
        }
        String str = this.a;
        return str == null ? "默认" : str;
    }
}
