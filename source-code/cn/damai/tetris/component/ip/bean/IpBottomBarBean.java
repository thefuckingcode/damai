package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class IpBottomBarBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String discount;
    public boolean focus;
    public String ipId;
    private String ipvuv;
    private List<BottomItem> items;
    private int prepareCities;
    private int tourCities;

    public String getDiscount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1368874089")) {
            return this.discount;
        }
        return (String) ipChange.ipc$dispatch("-1368874089", new Object[]{this});
    }

    public String getIpvuv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1332261456")) {
            return this.ipvuv;
        }
        return (String) ipChange.ipc$dispatch("-1332261456", new Object[]{this});
    }

    public List<BottomItem> getItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-999885817")) {
            return this.items;
        }
        return (List) ipChange.ipc$dispatch("-999885817", new Object[]{this});
    }

    public int getPrepareCities() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1712077251")) {
            return this.prepareCities;
        }
        return ((Integer) ipChange.ipc$dispatch("1712077251", new Object[]{this})).intValue();
    }

    public int getTourCities() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-257233828")) {
            return this.tourCities;
        }
        return ((Integer) ipChange.ipc$dispatch("-257233828", new Object[]{this})).intValue();
    }

    public void setDiscount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632248359")) {
            ipChange.ipc$dispatch("632248359", new Object[]{this, str});
            return;
        }
        this.discount = str;
    }

    public void setIpvuv(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154031930")) {
            ipChange.ipc$dispatch("-154031930", new Object[]{this, str});
            return;
        }
        this.ipvuv = str;
    }

    public void setItems(List<BottomItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392405565")) {
            ipChange.ipc$dispatch("1392405565", new Object[]{this, list});
            return;
        }
        this.items = list;
    }

    public void setPrepareCities(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923893671")) {
            ipChange.ipc$dispatch("923893671", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.prepareCities = i;
    }

    public void setTourCities(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324437050")) {
            ipChange.ipc$dispatch("-324437050", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tourCities = i;
    }
}
