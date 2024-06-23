package tb;

import android.os.Handler;
import android.os.HandlerThread;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.listener.OnTListener;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import cn.damai.seat.support.combine.ICombiner;
import cn.damai.seat.support.combine.OnSeatCombineListener;
import cn.damai.seat.support.combine.SeatCombineTask;
import cn.damai.seat.support.combine.SeatStateParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class x62 implements RegionSeatRequestChecker, ICombiner {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HandlerThread a;
    private final List<String> b = new ArrayList();
    private final Handler c;
    private SeatBox d;
    private IPriceManager e;
    private SeatStateParent f;
    private OnSeatCombineListener g;
    private boolean h = false;
    private boolean i = false;
    private final long j;
    private final long k;
    private final int l;

    /* compiled from: Taobao */
    public class a implements OnTListener<List<String>> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1829537108")) {
                ipChange.ipc$dispatch("-1829537108", new Object[]{this, list});
                return;
            }
            x62.this.b.addAll(list);
            if (x62.this.g != null) {
                OnSeatCombineListener onSeatCombineListener = x62.this.g;
                x62 x62 = x62.this;
                onSeatCombineListener.onSeatCombineFinish(x62, x62.d);
            }
        }
    }

    public x62(OnSeatCombineListener onSeatCombineListener, long j2, long j3, int i2) {
        HandlerThread handlerThread = new HandlerThread("seat_combine");
        this.a = handlerThread;
        this.j = j2;
        this.k = j3;
        this.l = i2;
        this.g = onSeatCombineListener;
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void combineIfNeed() {
        SeatBox seatBox;
        SeatStateParent seatStateParent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120109876")) {
            ipChange.ipc$dispatch("-1120109876", new Object[]{this});
        } else if (!this.i && (seatBox = this.d) != null && (seatStateParent = this.f) != null && this.h) {
            this.c.post(new SeatCombineTask(this.j, this.k, this.l, seatBox, this.e, seatStateParent, new a()));
        }
    }

    public SeatBox d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2068033719")) {
            return this.d;
        }
        return (SeatBox) ipChange.ipc$dispatch("2068033719", new Object[]{this});
    }

    public void e(SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680629451")) {
            ipChange.ipc$dispatch("-680629451", new Object[]{this, seatBox});
            return;
        }
        s72.f("put SeatBox");
        this.d = seatBox;
        combineIfNeed();
    }

    public void f(IPriceManager iPriceManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005101089")) {
            ipChange.ipc$dispatch("2005101089", new Object[]{this, iPriceManager});
            return;
        }
        this.h = true;
        this.e = iPriceManager;
        combineIfNeed();
    }

    public void g(CompressSeatStatus compressSeatStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715524077")) {
            ipChange.ipc$dispatch("715524077", new Object[]{this, compressSeatStatus});
            return;
        }
        s72.f("put CompressSeatStatus");
        if (compressSeatStatus != null) {
            compressSeatStatus.decompress();
        }
        this.f = compressSeatStatus;
        combineIfNeed();
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207428765")) {
            ipChange.ipc$dispatch("1207428765", new Object[]{this});
            return;
        }
        this.i = true;
        this.a.quit();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public boolean isPrepared() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1196546775")) {
            return this.b.size() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1196546775", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.seat.listener.RegionSeatRequestChecker
    public boolean isRegionSeatRequestFinished(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "279883022")) {
            return this.b.contains(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("279883022", new Object[]{this, str})).booleanValue();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void removeDynamic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077181571")) {
            ipChange.ipc$dispatch("1077181571", new Object[]{this});
            return;
        }
        this.c.removeCallbacksAndMessages(null);
        this.h = false;
        this.f = null;
        this.e = null;
        this.b.clear();
    }
}
