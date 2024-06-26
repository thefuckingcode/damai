package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.SortBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
public class ni0 extends bb1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public String a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            iArr[Type.FILTER.ordinal()] = 1;
            a[Type.NEW_CATEGORY.ordinal()] = 2;
            a[Type.SORT.ordinal()] = 3;
            a[Type.CITY.ordinal()] = 4;
            a[Type.DATE.ordinal()] = 5;
            try {
                a[Type.DATE_HOR_CALENDAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ni0(String str) {
        this.a = str;
    }

    private String x(FilterBean filterBean) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1331371049")) {
            return TextUtils.equals("groupId", filterBean.option) ? "other_item_" : "preset_item_";
        }
        return (String) ipChange.ipc$dispatch("-1331371049", new Object[]{this, filterBean});
    }

    private String y(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2122108973")) {
            return (String) ipChange.ipc$dispatch("-2122108973", new Object[]{this, type});
        }
        switch (a.a[type.ordinal()]) {
            case 1:
                return "more";
            case 2:
                return "category";
            case 3:
                return "sorttype";
            case 4:
                return "city";
            case 5:
            case 6:
                return "date";
            default:
                return "";
        }
    }

    public static HashMap<String, String> z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372667344")) {
            return (HashMap) ipChange.ipc$dispatch("-372667344", new Object[0]);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        nl nlVar = nl.INSTANCE;
        String userCode = nlVar.a().getUserCode();
        if (!TextUtils.isEmpty(userCode)) {
            hashMap.put("usercode", userCode);
        }
        String cityName = nlVar.a().getCityName();
        if (!TextUtils.isEmpty(cityName)) {
            hashMap.put("city", cityName);
        }
        return hashMap;
    }

    public void c(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722169919")) {
            ipChange.ipc$dispatch("722169919", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        HashMap<String, String> z = z();
        z.put("dateType", i + "");
        z.put("startDate", str);
        z.put("endDate", str2);
        nl.INSTANCE.a().reportClick(b(this.a, "date_selector", "confirm", z, Boolean.FALSE));
    }

    public void d(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644131681")) {
            ipChange.ipc$dispatch("-1644131681", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", str);
        String str2 = this.a;
        nl.INSTANCE.a().reportClick(b(str2, "date_selector", "item_" + i, z, Boolean.FALSE));
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808138841")) {
            ipChange.ipc$dispatch("-808138841", new Object[]{this});
            return;
        }
        nl.INSTANCE.a().reportClick(b(this.a, "date_selector", "reset", z(), Boolean.FALSE));
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260450999")) {
            ipChange.ipc$dispatch("-1260450999", new Object[]{this, str});
            return;
        }
        nl.INSTANCE.a().reportClick(b(this.a, "category_selector", str, z(), Boolean.FALSE));
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "536201849")) {
            ipChange.ipc$dispatch("536201849", new Object[]{this, str});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", str);
        nl.INSTANCE.a().reportClick(b(this.a, "city_selector", "city_item", z, Boolean.FALSE));
    }

    public void h(FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114095743")) {
            ipChange.ipc$dispatch("-1114095743", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        String x = x(filterBean);
        HashMap<String, String> z = z();
        z.put("titlelabel", filterBean.name);
        String str = this.a;
        nl.INSTANCE.a().reportClick(b(str, Constants.Name.FILTER, x + i, z, Boolean.FALSE));
    }

    public void i(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942401588")) {
            ipChange.ipc$dispatch("1942401588", new Object[]{this, type});
            return;
        }
        nl.INSTANCE.a().reportClick(b(this.a, Constants.Name.FILTER, y(type), z(), Boolean.FALSE));
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1064519503")) {
            ipChange.ipc$dispatch("1064519503", new Object[]{this, str});
            return;
        }
        nl.INSTANCE.a().reportClick(b(this.a, "more_selector", str, z(), Boolean.FALSE));
    }

    public void k(FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709455605")) {
            ipChange.ipc$dispatch("1709455605", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", filterBean.name);
        String str = this.a;
        nl.INSTANCE.a().reportClick(b(str, "more_selector", (filterBean.option + JSMethod.NOT_SET) + i, z, Boolean.FALSE));
    }

    public void l(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1566166310")) {
            ipChange.ipc$dispatch("1566166310", new Object[]{this, str, str2});
            return;
        }
        HashMap<String, String> z = z();
        z.put("startDate", str);
        z.put("endDate", str2);
        nl.INSTANCE.a().reportClick(b(this.a, "date", "item", z, Boolean.FALSE));
    }

    public void m(CategoryLevelOne categoryLevelOne, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306418480")) {
            ipChange.ipc$dispatch("-1306418480", new Object[]{this, categoryLevelOne, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", categoryLevelOne.name);
        String str = this.a;
        nl.INSTANCE.a().reportClick(b(str, "category_filter", "item_" + i, z, Boolean.FALSE));
    }

    public void n(CategoryLevelTwo categoryLevelTwo, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1768982029")) {
            ipChange.ipc$dispatch("-1768982029", new Object[]{this, categoryLevelTwo, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", categoryLevelTwo.name);
        nl.INSTANCE.a().reportClick(b(this.a, "category_filter_item_" + i2, "item_" + i, z, Boolean.FALSE));
    }

    public void o(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157102274")) {
            ipChange.ipc$dispatch("1157102274", new Object[]{this, sortBean});
            return;
        }
        int i = sortBean.index;
        HashMap<String, String> z = z();
        z.put("titlelabel", sortBean.name);
        String str = this.a;
        nl.INSTANCE.a().reportClick(b(str, "sorttype_selector", "item_" + i, z, Boolean.FALSE));
    }

    public void p(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067162486")) {
            ipChange.ipc$dispatch("1067162486", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        HashMap<String, String> z = z();
        z.put("titlelabel", "一周内");
        nl nlVar = nl.INSTANCE;
        nlVar.a().reportExposureSingleCustomEvent("item_1", "date_selector", this.a, "1.0", currentTimeMillis, z, 2201);
        HashMap<String, String> z2 = z();
        z2.put("titlelabel", "一月内");
        nlVar.a().reportExposureSingleCustomEvent("item_2", "date_selector", this.a, "1.0", currentTimeMillis, z2, 2201);
        HashMap<String, String> z3 = z();
        z3.put("titlelabel", "本周末");
        nlVar.a().reportExposureSingleCustomEvent("item_3", "date_selector", this.a, "1.0", currentTimeMillis, z3, 2201);
        HashMap<String, String> z4 = z();
        z4.put("titlelabel", "全部时间");
        nlVar.a().reportExposureSingleCustomEvent("item_0", "date_selector", this.a, "1.0", currentTimeMillis, z4, 2201);
    }

    public void q(View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394817011")) {
            ipChange.ipc$dispatch("1394817011", new Object[]{this, view, Long.valueOf(j)});
            return;
        }
        nl.INSTANCE.a().reportExposureSingleCustomEvent("confirm", "category_selector", this.a, "1.0", j, z(), 2201);
    }

    public void r(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444652448")) {
            ipChange.ipc$dispatch("444652448", new Object[]{this, Long.valueOf(j), str});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        HashMap<String, String> z = z();
        z.put("titlelabel", str);
        nl.INSTANCE.a().reportExposureSingleCustomEvent("city_item", "city_selector", this.a, "1.0", currentTimeMillis, z, 2201);
    }

    public void s(View view, FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145240455")) {
            ipChange.ipc$dispatch("-2145240455", new Object[]{this, view, filterBean, Integer.valueOf(i)});
            return;
        }
        String x = x(filterBean);
        HashMap<String, String> z = z();
        z.put("titlelabel", filterBean.name);
        ComponentFilterBridge a2 = nl.INSTANCE.a();
        a2.setExposureTag(view, x + i, Constants.Name.FILTER, this.a, z);
    }

    public void t(View view, Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796469884")) {
            ipChange.ipc$dispatch("1796469884", new Object[]{this, view, type});
            return;
        }
        nl.INSTANCE.a().setExposureTag(view, y(type), Constants.Name.FILTER, this.a, z());
    }

    public void u(View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863113069")) {
            ipChange.ipc$dispatch("863113069", new Object[]{this, view, Long.valueOf(j)});
            return;
        }
        nl.INSTANCE.a().reportExposureSingleCustomEvent("confirm", "more_selector", this.a, "1.0", j, z(), 2201);
    }

    public void v(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389109530")) {
            ipChange.ipc$dispatch("1389109530", new Object[]{this, view});
            return;
        }
        nl.INSTANCE.a().setExposureTag(view, "item", "date", this.a, z());
    }

    public void w(View view, SortBean sortBean, int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593661752")) {
            ipChange.ipc$dispatch("593661752", new Object[]{this, view, sortBean, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        HashMap<String, String> z = z();
        z.put("titlelabel", sortBean.name);
        ComponentFilterBridge a2 = nl.INSTANCE.a();
        a2.reportExposureSingleCustomEvent("item_" + i, "sorttype_selector", this.a, "1.0", j, z, 2201);
    }
}
