package cn.damai.seatdecoder.seat_vr.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class StaticStandSeat3DVrInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Long floorId;
    private List<StaticSeat3DVrInfo> seats;

    public Long getFloorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1372833372")) {
            return this.floorId;
        }
        return (Long) ipChange.ipc$dispatch("1372833372", new Object[]{this});
    }

    public List<StaticSeat3DVrInfo> getSeats() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2018698709")) {
            return this.seats;
        }
        return (List) ipChange.ipc$dispatch("2018698709", new Object[]{this});
    }

    public void setFloorId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903165468")) {
            ipChange.ipc$dispatch("-903165468", new Object[]{this, l});
            return;
        }
        this.floorId = l;
    }

    public void setSeats(List<StaticSeat3DVrInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479245359")) {
            ipChange.ipc$dispatch("479245359", new Object[]{this, list});
            return;
        }
        this.seats = list;
    }
}
