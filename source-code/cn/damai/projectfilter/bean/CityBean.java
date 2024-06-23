package cn.damai.projectfilter.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.d20;

/* compiled from: Taobao */
public class CityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityCode;
    public String cityName;

    public CityBean(String str, String str2) {
        this.cityCode = str2;
        this.cityName = str;
    }

    public static CityBean defaultCity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1374233860") ? (CityBean) ipChange.ipc$dispatch("-1374233860", new Object[0]) : new CityBean(d20.d(), d20.c());
    }
}
