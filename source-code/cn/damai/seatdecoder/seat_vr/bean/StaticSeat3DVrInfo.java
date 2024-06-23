package cn.damai.seatdecoder.seat_vr.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StaticSeat3DVrInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Long floorId;
    private double fov;
    private double horizontal;
    private String img;
    private String imgHash;
    private Long sid;
    private String thumb;
    private double vertical;

    public Long getFloorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1826755080")) {
            return this.floorId;
        }
        return (Long) ipChange.ipc$dispatch("1826755080", new Object[]{this});
    }

    public double getFov() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1137811093")) {
            return this.fov;
        }
        return ((Double) ipChange.ipc$dispatch("1137811093", new Object[]{this})).doubleValue();
    }

    public double getHorizontal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-506815296")) {
            return this.horizontal;
        }
        return ((Double) ipChange.ipc$dispatch("-506815296", new Object[]{this})).doubleValue();
    }

    public String getImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1523944655")) {
            return this.img;
        }
        return (String) ipChange.ipc$dispatch("1523944655", new Object[]{this});
    }

    public String getImgHash() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1228260099")) {
            return this.imgHash;
        }
        return (String) ipChange.ipc$dispatch("-1228260099", new Object[]{this});
    }

    public Long getSid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "350939471")) {
            return this.sid;
        }
        return (Long) ipChange.ipc$dispatch("350939471", new Object[]{this});
    }

    public String getThumb() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1654443230")) {
            return this.thumb;
        }
        return (String) ipChange.ipc$dispatch("-1654443230", new Object[]{this});
    }

    public double getVertical() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-806013842")) {
            return this.vertical;
        }
        return ((Double) ipChange.ipc$dispatch("-806013842", new Object[]{this})).doubleValue();
    }

    public void setFloorId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283505592")) {
            ipChange.ipc$dispatch("283505592", new Object[]{this, l});
            return;
        }
        this.floorId = l;
    }

    public void setFov(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445731349")) {
            ipChange.ipc$dispatch("-1445731349", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.fov = d;
    }

    public void setHorizontal(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "528467384")) {
            ipChange.ipc$dispatch("528467384", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.horizontal = d;
    }

    public void setImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416192135")) {
            ipChange.ipc$dispatch("1416192135", new Object[]{this, str});
            return;
        }
        this.img = str;
    }

    public void setImgHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037610983")) {
            ipChange.ipc$dispatch("-1037610983", new Object[]{this, str});
            return;
        }
        this.imgHash = str;
    }

    public void setSid(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401099439")) {
            ipChange.ipc$dispatch("-1401099439", new Object[]{this, l});
            return;
        }
        this.sid = l;
    }

    public void setThumb(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551732332")) {
            ipChange.ipc$dispatch("-1551732332", new Object[]{this, str});
            return;
        }
        this.thumb = str;
    }

    public void setVertical(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694152394")) {
            ipChange.ipc$dispatch("1694152394", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.vertical = d;
    }
}
