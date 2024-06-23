package cn.damai.seat.bean.biz;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.seat.support.combine.SeatStateChild;
import cn.damai.seat.support.combine.SeatStateParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import tb.f92;
import tb.kf1;
import tb.s72;

/* compiled from: Taobao */
public class CompressSeatStatus implements SeatStateParent, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayMap<String, RegionCompressSeatState> regionId2SeatStateMap;
    public HashMap<String, String> seatStatus;

    public void decompress() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "559029503")) {
            ipChange.ipc$dispatch("559029503", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!f92.f(this.seatStatus)) {
            kf1 kf1 = new kf1(true);
            this.regionId2SeatStateMap = new ArrayMap<>();
            for (String str : this.seatStatus.keySet()) {
                i++;
                this.regionId2SeatStateMap.put(str, new RegionCompressSeatState(str, this.seatStatus.get(str)));
            }
            kf1.c(kf1.TYPE_SEAT_STATE_DECOMPRESS, 0);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        s72.f("动态压缩还原" + i + "个区域座位状态耗时" + currentTimeMillis2 + "ms");
    }

    public RegionCompressSeatState get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052041345")) {
            return (RegionCompressSeatState) ipChange.ipc$dispatch("-2052041345", new Object[]{this, str});
        }
        ArrayMap<String, RegionCompressSeatState> arrayMap = this.regionId2SeatStateMap;
        if (arrayMap != null) {
            return arrayMap.get(str);
        }
        return null;
    }

    @Override // cn.damai.seat.support.combine.SeatStateParent
    @Nullable
    public SeatStateChild getChild(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "172381712")) {
            return get(str);
        }
        return (SeatStateChild) ipChange.ipc$dispatch("172381712", new Object[]{this, str});
    }

    @Override // cn.damai.seat.support.combine.SeatStateParent
    public boolean isCompress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1727926118")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1727926118", new Object[]{this})).booleanValue();
    }
}
