package tb;

import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ji {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int GROUP_CITY = 2;
    public static final int HOT_CITY = 1;
    public static final int LOCATION_CITY = 0;
    public static final int LOC_CITY_STATUS_HAS_LOCATION = 136;
    public static final int LOC_CITY_STATUS_IN_LOCATION = 119;
    public static final int LOC_CITY_STATUS_NONE_PERMISSION = 102;
    private int a;
    private SitesBean b;
    public int c;
    private List<HotCityBean> d;
    private List<SitesBean> e;

    public ji(int i) {
        this.a = i;
    }

    public List<HotCityBean> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1216362937")) {
            return this.d;
        }
        return (List) ipChange.ipc$dispatch("1216362937", new Object[]{this});
    }

    public SitesBean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "914716416")) {
            return this.b;
        }
        return (SitesBean) ipChange.ipc$dispatch("914716416", new Object[]{this});
    }

    public List<SitesBean> c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "112788986")) {
            return this.e;
        }
        return (List) ipChange.ipc$dispatch("112788986", new Object[]{this});
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "708048349")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("708048349", new Object[]{this})).intValue();
    }

    public void e(List<HotCityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845507637")) {
            ipChange.ipc$dispatch("-1845507637", new Object[]{this, list});
            return;
        }
        this.d = list;
    }

    public void f(SitesBean sitesBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171171722")) {
            ipChange.ipc$dispatch("171171722", new Object[]{this, sitesBean});
            return;
        }
        this.b = sitesBean;
    }

    public void g(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "224710162")) {
            ipChange.ipc$dispatch("224710162", new Object[]{this, list});
            return;
        }
        this.e = list;
    }
}
