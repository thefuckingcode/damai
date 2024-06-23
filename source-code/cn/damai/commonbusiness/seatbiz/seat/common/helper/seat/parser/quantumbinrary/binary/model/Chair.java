package cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ca;

/* compiled from: Taobao */
public class Chair {
    private static transient /* synthetic */ IpChange $ipChange;
    public long groupId;
    public long groupPriceId;
    private ChairId mChairId = new ChairId();
    private FloorId mFloorId = new FloorId();
    private RowId mRowId = new RowId();
    public long priceId;
    public long sid;
    public short x;
    public short y;

    /* compiled from: Taobao */
    public class ChairId extends ca {
        public ChairId() {
        }
    }

    /* compiled from: Taobao */
    public class FloorId extends ca {
        public FloorId() {
        }
    }

    /* compiled from: Taobao */
    public class RowId extends ca {
        public RowId() {
        }
    }

    public ChairId chairId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "228588084")) {
            return this.mChairId;
        }
        return (ChairId) ipChange.ipc$dispatch("228588084", new Object[]{this});
    }

    public FloorId floorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1897350292")) {
            return this.mFloorId;
        }
        return (FloorId) ipChange.ipc$dispatch("1897350292", new Object[]{this});
    }

    public RowId rowId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "295137172")) {
            return this.mRowId;
        }
        return (RowId) ipChange.ipc$dispatch("295137172", new Object[]{this});
    }
}
