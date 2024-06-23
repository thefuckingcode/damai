package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.b01;
import tb.ep1;
import tb.ez0;
import tb.gq;
import tb.hd0;
import tb.i62;
import tb.l72;
import tb.ll1;
import tb.lz1;
import tb.m72;
import tb.md0;
import tb.r62;
import tb.sa;
import tb.zz0;

/* compiled from: Taobao */
public class SeatPrepare implements OnAreaInfoListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_COUNT_DOWN = 18;
    public static final int TYPE_RELOAD = 17;
    private final lz1 a = new lz1();
    private final Activity b;
    private long c;
    private final LongSparseArray<MtopBusiness> d = new LongSparseArray<>();
    private final LongSparseArray<Long> e = new LongSparseArray<>();
    private boolean f;
    private boolean g;
    private final long h;
    private boolean i;
    private ll1 j;

    /* compiled from: Taobao */
    public interface OnSeatPrepareListener {
        void onSeatPageOpened();

        void showLoading(boolean z);
    }

    /* compiled from: Taobao */
    public class a implements OnAreaInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSeatPrepareListener a;
        final /* synthetic */ ClickedPerform b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        a(OnSeatPrepareListener onSeatPrepareListener, ClickedPerform clickedPerform, String str, int i) {
            this.a = onSeatPrepareListener;
            this.b = clickedPerform;
            this.c = str;
            this.d = i;
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
        public void onFail(String str, long j, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1598031437")) {
                ipChange.ipc$dispatch("1598031437", new Object[]{this, str, Long.valueOf(j), str2, str3});
                return;
            }
            this.a.showLoading(false);
            SeatPrepare.this.k(str3);
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
        public void onSuccess(String str, long j, long j2, RegionData regionData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983274115")) {
                ipChange.ipc$dispatch("1983274115", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), regionData});
                return;
            }
            this.a.showLoading(false);
            this.a.onSeatPageOpened();
            SeatPrepare.this.j(j, j2, regionData);
            SeatPrepare.this.g(this.b, str, this.c, this.d, regionData);
        }
    }

    public SeatPrepare(@NonNull Activity activity, long j2) {
        boolean z = true;
        this.g = true;
        this.i = false;
        this.j = new ll1();
        this.b = activity;
        this.h = j2;
        this.f = OrangeConfigCenter.c().a("damai_seat_data_preload_switch", "damai_seat_data_preload", 1) != 1 ? false : z;
    }

    private synchronized MtopBusiness e(final String str, final long j2, final long j3, final OnAreaInfoListener onAreaInfoListener) {
        Throwable th;
        try {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1156198163")) {
                return (MtopBusiness) ipChange.ipc$dispatch("-1156198163", new Object[]{this, str, Long.valueOf(j2), Long.valueOf(j3), onAreaInfoListener});
            }
            ez0.c(this.h, j2, false);
            MtopBBCAreaInfoRequest mtopBBCAreaInfoRequest = new MtopBBCAreaInfoRequest(str, j3, (String) null, gq.c());
            try {
                AnonymousClass2 r12 = new MtopRegionDataListener(this.h, this.a, str, j2, j3) {
                    /* class cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
                    public void onBizFail(String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-244283923")) {
                            ipChange.ipc$dispatch("-244283923", new Object[]{this, str, str2});
                            return;
                        }
                        onAreaInfoListener.onFail(str, j3, str, str2);
                    }

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
                    public void onRegionData(@NonNull RegionData regionData) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-277819597")) {
                            ipChange.ipc$dispatch("-277819597", new Object[]{this, regionData});
                            return;
                        }
                        onAreaInfoListener.onSuccess(str, j2, j3, regionData);
                    }
                };
                try {
                    r12.setRequest4Preload(this.i);
                    return mtopBBCAreaInfoRequest.request(r12);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(@NonNull ClickedPerform clickedPerform, String str, @Nullable String str2, int i2, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692579324")) {
            ipChange.ipc$dispatch("1692579324", new Object[]{this, clickedPerform, str, str2, Integer.valueOf(i2), regionData});
            return;
        }
        PerformBean performBean = clickedPerform.perform;
        int i3 = performBean.limitQuantity;
        long j2 = 0;
        PriceBean priceBean = clickedPerform.price;
        if (priceBean != null && performBean.containSkuId(priceBean.skuId)) {
            j2 = clickedPerform.price.skuId;
        }
        BasicInfoBean basicInfoBean = clickedPerform.basic;
        TbParams tbParams = new TbParams(str, basicInfoBean.projectId, basicInfoBean.itemId, performBean.performId, i2, j2, i3, str2, clickedPerform.appNewUlTron(), clickedPerform.h5NewUlTron(), null, performBean.hasPromotion);
        boolean isJPG = regionData.isJPG();
        boolean isSmallVenue = regionData.isSmallVenue();
        if (isJPG) {
            sa.b(this.b, tbParams, isSmallVenue, 2000);
            return;
        }
        sa.a(this.b, tbParams, regionData);
        sa.c(this.b, tbParams, 2000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(long j2, long j3, RegionData regionData) {
        RegionSeatExtInfo regionSeatExtInfo;
        RegionSeat3DVrInfo regionSeat3DVrInfo;
        r62 g2;
        Option<ImageExtra>[] f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995228813")) {
            ipChange.ipc$dispatch("-1995228813", new Object[]{this, Long.valueOf(j2), Long.valueOf(j3), regionData});
            return;
        }
        if (!(regionData.isJPG() && regionData.isSmallVenue()) && (f2 = b01.f(regionData, true, j3)) != null) {
            zz0.t().r(new hd0(), f2);
            this.j.d(f2);
        }
        m72 g3 = m72.g(this.h, j2, regionData, true, j3);
        if (g3 != null) {
            l72.r().h(g3, new md0());
            this.j.e(g3);
        }
        RegionSeatData regionSeatData = regionData.regionSeatData;
        if (regionSeatData != null && (regionSeatExtInfo = regionSeatData.seatExtInfo) != null && (regionSeat3DVrInfo = regionSeatExtInfo.seat3dvrInfo) != null && (g2 = r62.g(regionSeat3DVrInfo, false, j3)) != null) {
            i62.r().h(g2, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058338751")) {
            ipChange.ipc$dispatch("1058338751", new Object[]{this, str});
        } else if (!this.b.isFinishing()) {
            ToastUtil.a().e(this.b, str);
        }
    }

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879554233")) {
            ipChange.ipc$dispatch("879554233", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.g = z;
    }

    public synchronized void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860040226")) {
            ipChange.ipc$dispatch("-860040226", new Object[]{this});
            return;
        }
        try {
            int size = this.d.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    MtopBusiness valueAt = this.d.valueAt(i2);
                    if (!valueAt.isTaskCanceled()) {
                        valueAt.cancelRequest();
                    }
                }
            }
            l72.r().p();
            i62.r().p();
            zz0.t().p();
            this.a.d(this.c);
            zz0.t().d(this.j.a());
            l72.r().d(this.j.b());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void h(@NonNull ClickedPerform clickedPerform, String str, @Nullable String str2, int i2, OnSeatPrepareListener onSeatPrepareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597874518")) {
            ipChange.ipc$dispatch("-1597874518", new Object[]{this, clickedPerform, str, str2, Integer.valueOf(i2), onSeatPrepareListener});
        } else if (clickedPerform.isHasPerform() && onSeatPrepareListener != null) {
            long j2 = clickedPerform.perform.performId;
            long a2 = ep1.a(j2);
            RegionData a3 = this.a.a(a2);
            if (a2 != this.c || a3 == null) {
                onSeatPrepareListener.showLoading(true);
                this.i = false;
                e(str, j2, a2, new a(onSeatPrepareListener, clickedPerform, str2, i2));
                return;
            }
            onSeatPrepareListener.onSeatPageOpened();
            g(clickedPerform, str, str2, i2, a3);
        }
    }

    public synchronized void i(int i2, String str, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225883769")) {
            ipChange.ipc$dispatch("-1225883769", new Object[]{this, Integer.valueOf(i2), str, Long.valueOf(j2)});
        } else if (this.f) {
            long a2 = ep1.a(j2);
            if (this.c != a2) {
                this.i = true;
                this.d.put(a2, e(str, j2, a2, this));
            } else {
                if (i2 == 18) {
                    long j3 = 0;
                    Long l = this.e.get(a2);
                    if (l != null) {
                        j3 = l.longValue();
                    }
                    if (System.currentTimeMillis() - j3 < 300000) {
                        return;
                    }
                }
                if (this.d.get(a2) == null) {
                    this.i = true;
                    this.d.put(a2, e(str, j2, a2, this));
                } else {
                    return;
                }
            }
            this.c = a2;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
    public synchronized void onFail(String str, long j2, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023621114")) {
            ipChange.ipc$dispatch("1023621114", new Object[]{this, str, Long.valueOf(j2), str2, str3});
            return;
        }
        this.d.remove(j2);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
    public synchronized void onSuccess(String str, long j2, long j3, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449065392")) {
            ipChange.ipc$dispatch("1449065392", new Object[]{this, str, Long.valueOf(j2), Long.valueOf(j3), regionData});
            return;
        }
        this.d.remove(j3);
        this.e.put(j3, Long.valueOf(System.currentTimeMillis()));
        if (this.g) {
            if (regionData != null && regionData.checkBaseValid()) {
                j(j2, j3, regionData);
            }
        }
    }
}
