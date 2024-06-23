package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import java.util.ArrayList;
import tb.b72;
import tb.f72;
import tb.io1;
import tb.kf1;
import tb.kl1;
import tb.m03;
import tb.o03;
import tb.s72;
import tb.sb0;
import tb.ub0;
import tb.xs0;

/* compiled from: Taobao */
public class e extends a<SeatBox, f72> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ub0 b = ub0.c();
    private int c;
    private kf1 d = new kf1();

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
            if (AndroidInstantRuntime.support(ipChange, "510943777")) {
                ipChange.ipc$dispatch("510943777", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            RequestListener requestListener = this.a;
            kl1<E> kl1 = e.this.a;
            requestListener.onFail(kl1, i + "", str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onDownloadFinish(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "468270209")) {
                ipChange.ipc$dispatch("468270209", new Object[]{this, str, str2});
                return;
            }
            try {
                e.this.d.c(kf1.TYPE_SEAT_ZIP_DOWNLOAD, 0);
                long currentTimeMillis = System.currentTimeMillis();
                kf1 kf1 = new kf1(true);
                SeatBox seatBox = new SeatBox();
                seatBox.seatNewMap = new ArrayMap<>(256);
                b72.a("damai" + File.separator + "1111");
                o03.a(str2, b72.c);
                File[] listFiles = new File(b72.c).listFiles();
                E a2 = e.this.a.a();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        String[] split = listFiles[i].getPath().split("\\/");
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(new m03(a2.d).d(b72.c(listFiles[i]), a2.c, split[split.length - 1]).seatNewList);
                        seatBox.seatNewMap.put(listFiles[i].getName(), arrayList);
                    }
                }
                seatBox.collectSeatDataInner();
                kf1.c(kf1.TYPE_SEAT_ZIP_PARSE, 0);
                s72.f("TB解析座位耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                this.a.onSuccess(e.this.a, seatBox);
            } catch (Exception e) {
                e.printStackTrace();
                this.a.onFail(e.this.a, OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, e.getMessage());
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2124386245")) {
                ipChange.ipc$dispatch("-2124386245", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                return;
            }
            this.a.onFail(e.this.a, "onNetLimit", "");
        }
    }

    static {
        ub0.e(xs0.a());
    }

    public e(kl1<f72> kl1) {
        super(kl1);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112171956")) {
            ipChange.ipc$dispatch("112171956", new Object[]{this});
            return;
        }
        this.b.a(this.c);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, f72> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570529794")) {
            ipChange.ipc$dispatch("570529794", new Object[]{this, requestListener});
            return;
        }
        this.d.i();
        String d2 = this.a.d();
        s72.f("Load seat url = " + d2);
        sb0 sb0 = new sb0(d2);
        b72.d(b72.a(b72.b));
        sb0.b.f = b72.a(b72.b).getAbsolutePath();
        sb0.a.get(0).d = "1111.zip";
        sb0.b.m = false;
        this.c = this.b.b(sb0, new a(requestListener));
    }
}
