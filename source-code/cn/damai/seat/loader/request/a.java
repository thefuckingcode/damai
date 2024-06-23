package cn.damai.seat.loader.request;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener;
import cn.damai.seat.R$drawable;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import tb.f92;
import tb.i62;
import tb.k62;
import tb.kl1;
import tb.m62;
import tb.n62;
import tb.r62;
import tb.s72;
import tb.v72;
import tb.xs0;

/* compiled from: Taobao */
public class a extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<ImageData, k62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<WeakReference<C0041a>> b = new ArrayList();
    private boolean c;

    /* renamed from: cn.damai.seat.loader.request.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0041a {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        Future b;
        r62 c;

        public C0041a(Future future) {
            this.b = future;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "855807270")) {
                ipChange.ipc$dispatch("855807270", new Object[]{this});
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
                if (this.c != null) {
                    i62.r().b(this.c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public final class b implements OnDownLoadListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RequestListener<ImageData, k62> a;
        private String b;
        private k62 c;

        /* renamed from: cn.damai.seat.loader.request.a$b$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0042a implements RequestListener<SeatBox, k62.a> {
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.seat.loader.request.a$b$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public class C0043a implements DMImageCreator.DMImageFailListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0043a() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.d dVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-473511905")) {
                        ipChange.ipc$dispatch("-473511905", new Object[]{this, dVar});
                        return;
                    }
                    b bVar = b.this;
                    int i = dVar.a;
                    bVar.onFail(i, "降级图片加载失败：" + dVar.toString());
                }
            }

            /* renamed from: cn.damai.seat.loader.request.a$b$a$b  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public class C0044b implements DMImageCreator.DMImageSuccListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0044b() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-845814156")) {
                        ipChange.ipc$dispatch("-845814156", new Object[]{this, eVar});
                    } else if (eVar == null || eVar.b == null) {
                        b.this.onFail(-1, "降级图片错误");
                    } else {
                        s72.f("------------------ VR 图降级成功！");
                        b.this.onSuccess(eVar.b);
                    }
                }
            }

            C0042a() {
            }

            /* renamed from: a */
            public void onSuccess(kl1<k62.a> kl1, SeatBox seatBox) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1786937405")) {
                    ipChange.ipc$dispatch("-1786937405", new Object[]{this, kl1, seatBox});
                    return;
                }
                String str = null;
                if (seatBox == null) {
                    b.this.onFail(-1, "VR降级，数据错误：SeatBox");
                    return;
                }
                List<StaticSeat3DVrInfo> list = seatBox.seat3DVrInfoMap.get(b.this.c.b());
                if (list == null || list.isEmpty()) {
                    b.this.onFail(-1, "VR降级，数据错误：StaticSeat3DVrInfo");
                    return;
                }
                Iterator<StaticSeat3DVrInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StaticSeat3DVrInfo next = it.next();
                    if (next.getSid().longValue() == b.this.c.d()) {
                        str = next.getImg();
                        break;
                    }
                }
                s72.f("------------------ VR 图降级 图片地址：" + str);
                DMImageCreator c = cn.damai.common.image.a.b().c(str);
                int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
                c.i(i).c(i).n(new C0044b()).e(new C0043a()).f();
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kl1<k62.a> kl1, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1622741158")) {
                    ipChange.ipc$dispatch("-1622741158", new Object[]{this, kl1, str, str2});
                    return;
                }
                b.this.onFail(-1, str2);
                s72.f("----------------- VR 图降级请求失败， code：" + str + " msg：" + str2);
            }
        }

        b(String str, RequestListener<ImageData, k62> requestListener, k62 k62) {
            this.a = requestListener;
            this.b = str;
            this.c = k62;
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1189893890")) {
                ipChange.ipc$dispatch("-1189893890", new Object[]{this});
                return;
            }
            k62 k62 = this.c;
            if (k62 == null || k62.a() == null) {
                s72.f("------------------ VR 降级，请求参数错误");
                onFail(-1, "VR 降级，请求参数错误");
                return;
            }
            k62.a a2 = this.c.a();
            m62.r().h(n62.g(true, a2.c(), a2.b(), this.c.c()), new C0042a());
        }

        /* renamed from: b */
        public Bitmap callSubThread(byte[] bArr) throws Exception {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-675420895")) {
                return (Bitmap) ipChange.ipc$dispatch("-675420895", new Object[]{this, bArr});
            } else if (bArr == null || bArr.length == 0) {
                throw new RuntimeException("seat 3dvr image data empty");
            } else {
                s72.f("------------------ VR 图片下载成功");
                if (!a.this.c) {
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = v72.b().a(bArr, this.c.e(), this.b);
                if (a2 != null) {
                    s72.f("------------------ vr image decrypt success: cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return a2;
                }
                s72.f("------------------ VR 图片解密失败，请求降级数据");
                c();
                return null;
            }
        }

        /* renamed from: d */
        public void onSuccess(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-336685014")) {
                ipChange.ipc$dispatch("-336685014", new Object[]{this, bitmap});
            } else if (bitmap != null && this.a != null) {
                this.a.onSuccess(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, new ImageData(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a.d(), bitmap));
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onFail(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1912975608")) {
                ipChange.ipc$dispatch("-1912975608", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            RequestListener<ImageData, k62> requestListener = this.a;
            if (requestListener != null) {
                requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, str, "场馆图加载失败");
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onLimit() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "997895244")) {
                ipChange.ipc$dispatch("997895244", new Object[]{this});
                return;
            }
            RequestListener<ImageData, k62> requestListener = this.a;
            if (requestListener != null) {
                requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, ImageData.CODE_NET_LIMIT, "场馆图加载失败");
            }
        }
    }

    public a(kl1<k62> kl1) {
        super(kl1);
        E a;
        kl1<E> kl12 = this.a;
        if (kl12 != null && (a = kl12.a()) != null) {
            this.c = a.f();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139928642")) {
            ipChange.ipc$dispatch("-2139928642", new Object[]{this});
        } else if (!f92.d(this.b)) {
            for (WeakReference<C0041a> weakReference : this.b) {
                C0041a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<ImageData, k62> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450199564")) {
            ipChange.ipc$dispatch("1450199564", new Object[]{this, requestListener});
            return;
        }
        String d = this.a.d();
        s72.f("------------------ VR 图片开始下载");
        this.b.add(new WeakReference<>(new C0041a(NetApi.a(xs0.a(), d, new b(d, requestListener, this.a.a())))));
    }
}
