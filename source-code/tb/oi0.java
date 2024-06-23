package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.SortBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
public class oi0 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    public String b;

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
            a[Type.CATEGORY.ordinal()] = 2;
            a[Type.NEW_CATEGORY.ordinal()] = 3;
            a[Type.SORT.ordinal()] = 4;
            a[Type.CITY.ordinal()] = 5;
            try {
                a[Type.DATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public oi0(String str) {
        this.b = str;
    }

    private String y(FilterBean filterBean) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2091628499")) {
            return TextUtils.equals("groupId", filterBean.option) ? "other_item_" : "preset_item_";
        }
        return (String) ipChange.ipc$dispatch("-2091628499", new Object[]{this, filterBean});
    }

    private String z(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130758861")) {
            return (String) ipChange.ipc$dispatch("-2130758861", new Object[]{this, type});
        }
        switch (a.a[type.ordinal()]) {
            case 1:
                return "more";
            case 2:
            case 3:
                return "category";
            case 4:
                return "sorttype";
            case 5:
                return "city";
            case 6:
                return "date";
            default:
                return "";
        }
    }

    public void f(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1154694356")) {
            ipChange.ipc$dispatch("1154694356", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("dateType", i + "");
        f.put("startDate", str);
        f.put("endDate", str2);
        c.e().x(e(this.b, "date_selector", "confirm", f, Boolean.FALSE));
    }

    public void g(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799308758")) {
            ipChange.ipc$dispatch("-799308758", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", str);
        String str2 = this.b;
        c.e().x(e(str2, "date_selector", "item_" + i, f, Boolean.FALSE));
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475378866")) {
            ipChange.ipc$dispatch("475378866", new Object[]{this});
            return;
        }
        c.e().x(e(this.b, "date_selector", "reset", a03.f(), Boolean.FALSE));
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423868588")) {
            ipChange.ipc$dispatch("-423868588", new Object[]{this, str});
            return;
        }
        c.e().x(e(this.b, "category_selector", str, a03.f(), Boolean.FALSE));
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616337358")) {
            ipChange.ipc$dispatch("1616337358", new Object[]{this, str});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", str);
        c.e().x(e(this.b, "city_selector", "city_item", f, Boolean.FALSE));
    }

    public void k(FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915306017")) {
            ipChange.ipc$dispatch("1915306017", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        String y = y(filterBean);
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", filterBean.name);
        String str = this.b;
        c.e().x(e(str, Constants.Name.FILTER, y + i, f, Boolean.FALSE));
    }

    public void l(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022154028")) {
            ipChange.ipc$dispatch("-2022154028", new Object[]{this, type});
            return;
        }
        c.e().x(e(this.b, Constants.Name.FILTER, z(type), a03.f(), Boolean.FALSE));
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190529562")) {
            ipChange.ipc$dispatch("1190529562", new Object[]{this, str});
            return;
        }
        c.e().x(e(this.b, "more_selector", str, a03.f(), Boolean.FALSE));
    }

    public void n(FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088620395")) {
            ipChange.ipc$dispatch("-2088620395", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", filterBean.name);
        String str = this.b;
        c.e().x(e(str, "more_selector", (filterBean.option + JSMethod.NOT_SET) + i, f, Boolean.FALSE));
    }

    public void o(CategoryLevelOne categoryLevelOne, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019282650")) {
            ipChange.ipc$dispatch("-2019282650", new Object[]{this, categoryLevelOne, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", categoryLevelOne.name);
        String str = this.b;
        c.e().x(e(str, "category_filter", "item_" + i, f, Boolean.FALSE));
    }

    public void p(CategoryLevelTwo categoryLevelTwo, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576494755")) {
            ipChange.ipc$dispatch("-1576494755", new Object[]{this, categoryLevelTwo, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", categoryLevelTwo.name);
        c.e().x(e(this.b, "category_filter_item_" + i2, "item_" + i, f, Boolean.FALSE));
    }

    public void q(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-544264990")) {
            ipChange.ipc$dispatch("-544264990", new Object[]{this, sortBean});
            return;
        }
        int i = sortBean.index;
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", sortBean.name);
        String str = this.b;
        c.e().x(e(str, "sorttype_selector", "item_" + i, f, Boolean.FALSE));
    }

    public void r(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385657227")) {
            ipChange.ipc$dispatch("1385657227", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "一周内");
        c.e().C("item_1", "date_selector", this.b, "1.0", currentTimeMillis, f, 2201);
        HashMap<String, String> f2 = a03.f();
        f2.put("titlelabel", "一月内");
        c.e().C("item_2", "date_selector", this.b, "1.0", currentTimeMillis, f2, 2201);
        HashMap<String, String> f3 = a03.f();
        f3.put("titlelabel", "本周末");
        c.e().C("item_3", "date_selector", this.b, "1.0", currentTimeMillis, f3, 2201);
        HashMap<String, String> f4 = a03.f();
        f4.put("titlelabel", "全部时间");
        c.e().C("item_0", "date_selector", this.b, "1.0", currentTimeMillis, f4, 2201);
    }

    public void s(View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114806024")) {
            ipChange.ipc$dispatch("2114806024", new Object[]{this, view, Long.valueOf(j)});
            return;
        }
        c.e().C("confirm", "category_selector", this.b, "1.0", j, a03.f(), 2201);
    }

    public void t(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640727157")) {
            ipChange.ipc$dispatch("640727157", new Object[]{this, Long.valueOf(j), str});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", str);
        c.e().C("city_item", "city_selector", this.b, "1.0", System.currentTimeMillis() - j, f, 2201);
    }

    public void u(View view, FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103985191")) {
            ipChange.ipc$dispatch("-2103985191", new Object[]{this, view, filterBean, Integer.valueOf(i)});
            return;
        }
        String y = y(filterBean);
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", filterBean.name);
        c e = c.e();
        e.G(view, y + i, Constants.Name.FILTER, this.b, f);
    }

    public void v(View view, Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589941340")) {
            ipChange.ipc$dispatch("589941340", new Object[]{this, view, type});
            return;
        }
        c.e().G(view, z(type), Constants.Name.FILTER, this.b, a03.f());
    }

    public void w(View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141723198")) {
            ipChange.ipc$dispatch("-141723198", new Object[]{this, view, Long.valueOf(j)});
            return;
        }
        c.e().C("confirm", "more_selector", this.b, "1.0", j, a03.f(), 2201);
    }

    public void x(View view, SortBean sortBean, int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941589352")) {
            ipChange.ipc$dispatch("-941589352", new Object[]{this, view, sortBean, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", sortBean.name);
        c e = c.e();
        e.C("item_" + i, "sorttype_selector", this.b, "1.0", j, f, 2201);
    }
}
