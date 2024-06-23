package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import cn.damai.seatdecoder.seat.bean.SeatDataDecodeResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tb.b72;
import tb.d72;
import tb.f72;
import tb.gq;
import tb.io1;
import tb.kf1;
import tb.kl1;
import tb.s72;
import tb.sb0;
import tb.ub0;
import tb.x72;
import tb.xs0;

/* compiled from: Taobao */
public class d extends a<SeatBox, f72> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ub0 b = ub0.c();
    private int c;
    private e d;
    private kf1 e = new kf1();

    /* compiled from: Taobao */
    public class a extends com.taobao.downloader.request.a {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onDownloadError(String str, int i, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "411964496")) {
                ipChange.ipc$dispatch("411964496", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            d.this.i(this.a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x00e5 A[Catch:{ all -> 0x0185 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x010c A[Catch:{ all -> 0x0185 }] */
        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onDownloadFinish(String str, String str2) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "369290928")) {
                ipChange.ipc$dispatch("369290928", new Object[]{this, str, str2});
                return;
            }
            try {
                d.this.e.c(kf1.TYPE_SEAT_PB_DOWNLOAD, 0);
                E a2 = d.this.a.a();
                String str3 = a2.g + "";
                String str4 = a2.h + "";
                s72.f("当前座位的压缩方式是：" + a2.e);
                long currentTimeMillis = System.currentTimeMillis();
                kf1 kf1 = new kf1(true);
                SeatDataDecodeResult a3 = gq.a(a2.e, str2);
                kf1.c(kf1.TYPE_SEAT_PB_PARSE, 0);
                s72.f("解析座位耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                if (a3 != null) {
                    if (a3.getResultCode() == 1) {
                        if (!d72.b()) {
                            if ("pb_gzip".equalsIgnoreCase(a2.e)) {
                                s72.f("压缩数据跳过校验过程！！");
                                if (!z) {
                                    s72.f("压缩数据解析成功 ！！");
                                    SeatBox seatBox = new SeatBox();
                                    seatBox.seatNewMap = d.this.h((List) a3.getResult(), a2);
                                    seatBox.collectSeatDataInner();
                                    this.a.onSuccess(d.this.a, seatBox);
                                    return;
                                }
                                s72.f("压缩数据校验失败，降级去加载ZIP数据");
                                x72.f(str, String.valueOf(a3.getResultCode()), a3.getMessage(), str3, str4);
                                d.this.i(this.a);
                                return;
                            }
                        }
                        s72.f("压缩数据进入校验过程！！");
                        z = gq.f((List) a3.getResult(), a2.f);
                        if (!z) {
                        }
                    }
                }
                if (a3 == null) {
                    x72.e(str, "-1", "pb解析结果为null", str3, str4);
                } else {
                    if (a3.getResultCode() == -4033) {
                        x72.a(str, String.valueOf(a3.getResultCode()), a3.getMessage(), str3, str4);
                    } else if (a3.getResultCode() == -4037) {
                        x72.e(str, String.valueOf(a3.getResultCode()), a3.getMessage(), str3, str4);
                    }
                    s72.f("压缩数据解析失败，降级去加载ZIP数据： " + a3.getResultCode());
                }
                d.this.i(this.a);
            } catch (Throwable th) {
                s72.f("座位压缩数据处理过程发生其他异常：" + th.getMessage());
                th.printStackTrace();
                d.this.i(this.a);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1421362324")) {
                ipChange.ipc$dispatch("-1421362324", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                return;
            }
            this.a.onFail(d.this.a, "onNetLimit", "");
        }
    }

    static {
        ub0.e(xs0.a());
    }

    public d(kl1<f72> kl1) {
        super(kl1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayMap<String, List<SeatNew>> h(List<StaticStandSeat> list, f72 f72) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "838607150")) {
            return (ArrayMap) ipChange.ipc$dispatch("838607150", new Object[]{this, list, f72});
        } else if (list == null || f72 == null) {
            return null;
        } else {
            int i = f72.d ? 12 : 0;
            ArrayMap<String, List<SeatNew>> arrayMap = new ArrayMap<>(256);
            for (int i2 = 0; i2 < list.size(); i2++) {
                StaticStandSeat staticStandSeat = list.get(i2);
                if (!(staticStandSeat == null || staticStandSeat.getSeats() == null)) {
                    ArrayList arrayList = new ArrayList();
                    String valueOf = String.valueOf(staticStandSeat.getStand());
                    List<StaticSeat> seats = staticStandSeat.getSeats();
                    for (int i3 = 0; i3 < seats.size(); i3++) {
                        StaticSeat staticSeat = seats.get(i3);
                        SeatNew seatNew = new SeatNew();
                        seatNew.sid = staticSeat.getSid();
                        seatNew.x = (staticSeat.getX() / f72.c) + i;
                        seatNew.y = (staticSeat.getY() / f72.c) + i;
                        seatNew.priceLevel = staticSeat.getPlid();
                        seatNew.packageCombinedId = staticSeat.getGroupId();
                        seatNew.isPackaged = staticSeat.getGroupId() != 0;
                        seatNew.packagedPriceIndexId = staticSeat.getGroupPriceId();
                        seatNew.sn = staticSeat.getChint();
                        seatNew.rn = staticSeat.getRhint();
                        seatNew.fn = staticSeat.getFn();
                        seatNew.state = 8;
                        seatNew.kanTaiId = valueOf;
                        seatNew.angle = (float) staticSeat.getAngle();
                        seatNew.i = staticSeat.getI();
                        arrayList.add(seatNew);
                    }
                    arrayMap.put(valueOf, arrayList);
                }
            }
            return arrayMap;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(RequestListener<SeatBox, f72> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280528211")) {
            ipChange.ipc$dispatch("-280528211", new Object[]{this, requestListener});
            return;
        }
        this.a.a().c(true);
        e eVar = new e(this.a);
        this.d = eVar;
        eVar.d(requestListener);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970427163")) {
            ipChange.ipc$dispatch("-970427163", new Object[]{this});
            return;
        }
        this.b.a(this.c);
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, f72> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502652467")) {
            ipChange.ipc$dispatch("1502652467", new Object[]{this, requestListener});
            return;
        }
        this.e.i();
        String d2 = this.a.d();
        s72.f("Load seat url = " + d2);
        sb0 sb0 = new sb0(d2);
        b72.d(b72.a(b72.b));
        sb0.b.f = b72.a(b72.b).getAbsolutePath();
        sb0.a.get(0).d = "seat.gz";
        sb0.b.m = false;
        this.c = this.b.b(sb0, new a(requestListener));
    }
}
