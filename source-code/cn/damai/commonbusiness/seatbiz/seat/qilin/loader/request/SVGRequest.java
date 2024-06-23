package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.real.svg.decrypt.SvgDecrypt;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import tb.ez0;
import tb.f92;
import tb.gq;
import tb.k32;
import tb.kf1;
import tb.kl1;
import tb.l32;
import tb.s72;
import tb.vz0;
import tb.w72;
import tb.x72;
import tb.xs0;

/* compiled from: Taobao */
public class SVGRequest extends a<ImageData, vz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<WeakReference<a>> b = new ArrayList();
    private kf1 c = new kf1();

    /* compiled from: Taobao */
    public final class DownLoadListener implements OnDownLoadListener<BaseSVG> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RequestListener<ImageData, vz0> a;
        private l32 b;
        private String c;

        DownLoadListener(String str, RequestListener<ImageData, vz0> requestListener, l32 l32) {
            this.a = requestListener;
            this.b = l32;
            this.c = str;
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1024692492")) {
                ipChange.ipc$dispatch("-1024692492", new Object[]{this});
                return;
            }
            l32 l32 = this.b;
            if (l32 != null) {
                SVGRequest.this.b.add(new WeakReference(new a(new MtopBBCAreaInfoRequest(l32.g, l32.h, l32.d, gq.c()).request(new DMMtopResultRequestListener<RegionDataNew>(RegionDataNew.class) {
                    /* class cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest.DownLoadListener.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                    public void onFail(String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-494349680")) {
                            ipChange.ipc$dispatch("-494349680", new Object[]{this, str, str2});
                            return;
                        }
                        DownLoadListener.this.a.onFail(SVGRequest.this.a, str, str2);
                    }

                    public void onSuccess(RegionDataNew regionDataNew) {
                        RegionDataQuYu regionDataQuYu;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1524272018")) {
                            ipChange.ipc$dispatch("1524272018", new Object[]{this, regionDataNew});
                        } else if (regionDataNew == null || (regionDataQuYu = regionDataNew.seatQuYu) == null || TextUtils.isEmpty(regionDataQuYu.seatSvgImg)) {
                            DownLoadListener.this.a.onFail(SVGRequest.this.a, "", "seatSvgImg_url_null");
                        } else {
                            String str = regionDataNew.seatQuYu.seatSvgImg;
                            Application a = xs0.a();
                            DownLoadListener downLoadListener = DownLoadListener.this;
                            SVGRequest.this.b.add(new WeakReference(new a(NetApi.a(a, str, new DownLoadListener(str, downLoadListener.a, null)))));
                        }
                    }
                }))));
            }
        }

        private void e(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1566514176")) {
                ipChange.ipc$dispatch("-1566514176", new Object[]{this, str, str2});
                return;
            }
            ez0.a a2 = ez0.a(this.b.h);
            if (a2 != null) {
                String str3 = a2.c ? w72.SEAT_SVG_PAY_FIRST_PREFIX : w72.SEAT_SVG_NORMAL_PREFIX;
                x72.d(str2, a2.a + "", a2.b + "", str3 + str);
            }
        }

        @NonNull
        private b f(@NonNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-484537193")) {
                return (b) ipChange.ipc$dispatch("-484537193", new Object[]{this, str});
            }
            b bVar = new b();
            bVar.a = false;
            if (this.b.b()) {
                try {
                    l32 l32 = this.b;
                    String a2 = SvgDecrypt.a(l32.b, l32.f);
                    if (SvgDecrypt.d(a2, this.b.c)) {
                        String b2 = SvgDecrypt.b(str, a2);
                        if (SvgDecrypt.d(b2, this.b.e)) {
                            bVar.a = true;
                            bVar.b = b2;
                        } else {
                            bVar.c = w72.SEAT_SVG_DECRYPT_MD5_DIFF_MSG;
                        }
                    } else {
                        bVar.c = w72.SEAT_SVG_DECRYPT_KEY_MD5_DIFF_MSG;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    bVar.a = false;
                    bVar.c = e.getMessage();
                }
            } else {
                bVar.c = this.b.a();
            }
            return bVar;
        }

        /* renamed from: b */
        public BaseSVG callSubThread(byte[] bArr) throws Exception {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1723309313")) {
                return (BaseSVG) ipChange.ipc$dispatch("-1723309313", new Object[]{this, bArr});
            }
            String str = new String(bArr, "UTF-8");
            if (!TextUtils.isEmpty(str)) {
                SVGRequest.this.c.c(kf1.TYPE_SVG_DOWNLOAD, (long) bArr.length);
                l32 l32 = this.b;
                if (l32 != null && l32.c()) {
                    b f = f(str);
                    if (f.a) {
                        str = f.b;
                    } else {
                        e(f.c, this.c);
                        c();
                        str = null;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                kf1 kf1 = new kf1();
                kf1.i();
                long currentTimeMillis = System.currentTimeMillis();
                BaseSVG d2 = k32.d(str);
                kf1.c(kf1.TYPE_SVG_PARSE, (long) str.getBytes().length);
                s72.f("SVG解析耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                if (d2 != null && d2.getDrawable() != null) {
                    return d2;
                }
                throw new RuntimeException(ImageData.CODE_SVG_BUILD_FAIL);
            }
            throw new RuntimeException(ImageData.CODE_SVG_NONE_CONTENT);
        }

        /* renamed from: d */
        public void onSuccess(BaseSVG baseSVG) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "724557500")) {
                ipChange.ipc$dispatch("724557500", new Object[]{this, baseSVG});
            } else if (baseSVG != null) {
                this.a.onSuccess(SVGRequest.this.a, new ImageData(SVGRequest.this.a.d(), baseSVG));
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onFail(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351717250")) {
                ipChange.ipc$dispatch("-1351717250", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            RequestListener<ImageData, vz0> requestListener = this.a;
            kl1<E> kl1 = SVGRequest.this.a;
            requestListener.onFail(kl1, i + "", str);
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onLimit() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1986059586")) {
                ipChange.ipc$dispatch("1986059586", new Object[]{this});
                return;
            }
            this.a.onFail(SVGRequest.this.a, ImageData.CODE_NET_LIMIT, "场馆图加载失败");
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public boolean a;
        public String b;
        public String c;
    }

    public SVGRequest(kl1<vz0> kl1) {
        super(kl1);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524108024")) {
            ipChange.ipc$dispatch("-524108024", new Object[]{this});
        } else if (!f92.d(this.b)) {
            for (WeakReference<a> weakReference : this.b) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<ImageData, vz0> requestListener) {
        l32 l32;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294750038")) {
            ipChange.ipc$dispatch("294750038", new Object[]{this, requestListener});
            return;
        }
        this.c.i();
        String d = this.a.d();
        E a2 = this.a.a();
        if (a2.b()) {
            l32 = null;
        } else {
            l32 = a2.a();
        }
        this.b.add(new WeakReference<>(new a(NetApi.a(xs0.a(), d, new DownLoadListener(d, requestListener, l32)))));
    }

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        Future b;

        public a(MtopBusiness mtopBusiness) {
            this.a = mtopBusiness;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1118739984")) {
                ipChange.ipc$dispatch("-1118739984", new Object[]{this});
                return;
            }
            try {
                MtopBusiness mtopBusiness = this.a;
                if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
                    this.a.cancelRequest();
                }
                Future future = this.b;
                if (future != null && !future.isCancelled()) {
                    this.b.cancel(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public a(Future future) {
            this.b = future;
        }
    }
}
