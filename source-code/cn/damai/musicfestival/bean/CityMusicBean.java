package cn.damai.musicfestival.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.lk1;

/* compiled from: Taobao */
public class CityMusicBean implements Marker, Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATUS_SHOW_FULL = 0;
    public static final int STATUS_SHOW_NONE = 2;
    public static final int STATUS_SHOW_POINT = 1;
    public String abscissa;
    public String cityId;
    public String cityName;
    public boolean high;
    public List<MusicIpBean> musicIpInfos;
    public String ordinate;
    public String shiningIpId;
    public int status = 0;

    public CityMusicBean() {
    }

    public float getXRatioInWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1181842509")) {
            return lk1.i(this.abscissa, 0.0f);
        }
        return ((Float) ipChange.ipc$dispatch("1181842509", new Object[]{this})).floatValue();
    }

    public float getYRatioInHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2069062705")) {
            return lk1.i(this.ordinate, 0.0f);
        }
        return ((Float) ipChange.ipc$dispatch("2069062705", new Object[]{this})).floatValue();
    }

    public boolean isCanShowInAllMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1023552259")) {
            return this.status != 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1023552259", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.musicfestival.bean.Marker
    public boolean isHighlight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1575980369")) {
            return this.high;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1575980369", new Object[]{this})).booleanValue();
    }

    public boolean isShowFull() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-166638813")) {
            return this.status == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-166638813", new Object[]{this})).booleanValue();
    }

    public CityMusicBean(float f, float f2) {
        this.abscissa = f + "";
        this.ordinate = f2 + "";
    }
}
