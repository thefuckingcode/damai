package cn.damai.seatdecoder.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class StaticStandSeat {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<StaticSeat> seats;
    private Long stand;

    public List<StaticSeat> getSeats() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2064448099")) {
            return this.seats;
        }
        return (List) ipChange.ipc$dispatch("2064448099", new Object[]{this});
    }

    public Long getStand() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1230786553")) {
            return this.stand;
        }
        return (Long) ipChange.ipc$dispatch("1230786553", new Object[]{this});
    }

    public void setSeats(List<StaticSeat> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897476449")) {
            ipChange.ipc$dispatch("1897476449", new Object[]{this, list});
            return;
        }
        this.seats = list;
    }

    public void setStand(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084469017")) {
            ipChange.ipc$dispatch("-2084469017", new Object[]{this, l});
            return;
        }
        this.stand = l;
    }
}
