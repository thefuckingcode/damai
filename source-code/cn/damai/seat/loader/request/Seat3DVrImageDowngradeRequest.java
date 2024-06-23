package cn.damai.seat.loader.request;

import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConstant;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.br;
import tb.f92;
import tb.gq;
import tb.i62;
import tb.j62;
import tb.k62;
import tb.kl1;
import tb.r62;
import tb.s72;
import tb.v72;

/* compiled from: Taobao */
public class Seat3DVrImageDowngradeRequest extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<SeatBox, k62.a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private k62.a b;
    private List<WeakReference<b>> c = new ArrayList();

    /* compiled from: Taobao */
    public class a implements RequestListener<SeatBox, j62> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        a(RequestListener requestListener) {
            this.a = requestListener;
        }

        /* renamed from: a */
        public void onSuccess(kl1<j62> kl1, SeatBox seatBox) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-968143879")) {
                ipChange.ipc$dispatch("-968143879", new Object[]{this, kl1, seatBox});
            } else if (seatBox == null) {
                this.a.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_LOAD_CACHE, "VR 图降级失败， ");
            } else {
                br.c("seat_vr_data_bind", seatBox);
                s72.f("----------------- VR 降级，静态数据请求成功！");
                this.a.onSuccess(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) Seat3DVrImageDowngradeRequest.this).a, seatBox);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        public void onFail(kl1<j62> kl1, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1473348208")) {
                ipChange.ipc$dispatch("-1473348208", new Object[]{this, kl1, str, str2});
                return;
            }
            this.a.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) Seat3DVrImageDowngradeRequest.this).a, str, str2);
            s72.f("-----------------降级请求： Seat VRInfo Loader fail code" + str + " msg" + str2);
        }
    }

    public Seat3DVrImageDowngradeRequest(kl1<k62.a> kl1) {
        super(kl1);
        if (kl1 != null) {
            this.b = kl1.a();
        }
    }

    private void k(final RequestListener<SeatBox, k62.a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642485482")) {
            ipChange.ipc$dispatch("-642485482", new Object[]{this, requestListener});
            return;
        }
        k62.a aVar = this.b;
        if (aVar == null) {
            s72.f("------------------ VR 降级，降级参数错误");
            requestListener.onFail(this.a, OConstant.CODE_POINT_EXP_BIND_SERVICE, "VR 降级，降级参数错误");
            return;
        }
        this.c.add(new WeakReference<>(new b(new MtopBBCAreaInfoRequest(aVar.b(), String.valueOf(this.b.c()), null, this.b.a(), gq.c()).request(new DMMtopResultRequestListener<RegionDataNew>(RegionDataNew.class) {
            /* class cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "301271759")) {
                    ipChange.ipc$dispatch("301271759", new Object[]{this, str, str2});
                    return;
                }
                s72.f("------------------ VR 图降级数据请求失败：BBC—AREA-INFO");
                requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_BIND_SERVICE, str2);
            }

            public void onSuccess(RegionDataNew regionDataNew) {
                RegionDataQuYu regionDataQuYu;
                RegionSeatExtInfo regionSeatExtInfo;
                RegionSeat3DVrInfo regionSeat3DVrInfo;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1184472209")) {
                    ipChange.ipc$dispatch("1184472209", new Object[]{this, regionDataNew});
                } else if (regionDataNew == null || (regionDataQuYu = regionDataNew.seatQuYu) == null || (regionSeatExtInfo = regionDataQuYu.seatExtInfo) == null || (regionSeat3DVrInfo = regionSeatExtInfo.seat3dvrInfo) == null) {
                    requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_BIND_SERVICE, "seat3dVrImg downgrade data is null");
                    s72.f("------------------ VR 图降级数据为空：BBC—AREA-INFO");
                } else {
                    Seat3DVrImageDowngradeRequest.this.l(regionSeat3DVrInfo, requestListener);
                    v72.b().c(regionDataNew.seatQuYu.seatExtInfo.seat3dvrInfo.imgDecrypt);
                }
            }
        }))));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(RegionSeat3DVrInfo regionSeat3DVrInfo, RequestListener<SeatBox, k62.a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487361966")) {
            ipChange.ipc$dispatch("-1487361966", new Object[]{this, regionSeat3DVrInfo, requestListener});
            return;
        }
        s72.f("------------------ VR 图降级：请求静态数据:" + regionSeat3DVrInfo.seat3dvrEncodeUri);
        r62 g = r62.g(regionSeat3DVrInfo, true, this.b.c());
        this.c.add(new WeakReference<>(new b(g)));
        i62.r().h(g, new a(requestListener));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574689731")) {
            ipChange.ipc$dispatch("574689731", new Object[]{this});
        } else if (!f92.d(this.c)) {
            for (WeakReference<b> weakReference : this.c) {
                b bVar = weakReference.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, k62.a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985634577")) {
            ipChange.ipc$dispatch("985634577", new Object[]{this, requestListener});
            return;
        }
        s72.f("------------------ VR 降级请求流程。。。。");
        k(requestListener);
    }

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        r62 b;

        public b(MtopBusiness mtopBusiness) {
            this.a = mtopBusiness;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736052245")) {
                ipChange.ipc$dispatch("-1736052245", new Object[]{this});
                return;
            }
            try {
                MtopBusiness mtopBusiness = this.a;
                if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
                    this.a.cancelRequest();
                }
                if (this.b != null) {
                    i62.r().b(this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public b(r62 r62) {
            this.b = r62;
        }
    }
}
