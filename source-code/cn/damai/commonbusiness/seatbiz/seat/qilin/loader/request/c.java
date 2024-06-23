package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.seatdecoder.seat_vr.bean.Seat3DVrDataDecodeReulst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import java.util.Map;
import tb.b72;
import tb.gq;
import tb.io1;
import tb.j62;
import tb.kl1;
import tb.s72;
import tb.sb0;
import tb.ub0;
import tb.x72;
import tb.xs0;

/* compiled from: Taobao */
public class c extends a<SeatBox, j62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String d = ("damai-vr" + File.separator + "data");
    private final ub0 b = ub0.c();
    private int c;

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
            if (AndroidInstantRuntime.support(ipChange, "2021025453")) {
                ipChange.ipc$dispatch("2021025453", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            RequestListener requestListener = this.a;
            kl1<E> kl1 = c.this.a;
            requestListener.onFail(kl1, i + "", str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onDownloadFinish(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1978351885")) {
                ipChange.ipc$dispatch("1978351885", new Object[]{this, str, str2});
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                E a2 = c.this.a.a();
                Seat3DVrDataDecodeReulst b2 = gq.b(a2.a(), str2);
                if (b2 != null) {
                    if (b2.getResultCode() == 1) {
                        if (gq.g((Map) b2.getResult(), a2.b())) {
                            s72.f("VR PB 数据解析成功 ！！");
                            SeatBox seatBox = new SeatBox();
                            seatBox.seat3DVrInfoMap = (Map) b2.getResult();
                            this.a.onSuccess(c.this.a, seatBox);
                        } else {
                            s72.f("VR PB 数据校验失败");
                            x72.f(str, String.valueOf(b2.getResultCode()), b2.getMessage(), "-1", "-1");
                        }
                        s72.f("TB解析座位VR数据耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        return;
                    }
                }
                s72.f("VR PB 数据解析失败，降级去加载ZIP数据： " + b2.getResultCode());
            } catch (Exception e) {
                e.printStackTrace();
                this.a.onFail(c.this.a, OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, e.getMessage());
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener, com.taobao.downloader.request.a
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-992623825")) {
                ipChange.ipc$dispatch("-992623825", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                return;
            }
            this.a.onFail(c.this.a, "onNetLimit", "");
        }
    }

    static {
        ub0.e(xs0.a());
    }

    public c(kl1<j62> kl1) {
        super(kl1);
        StringBuilder sb = new StringBuilder();
        sb.append(b72.b());
        String str = File.separator;
        sb.append(str);
        sb.append(d);
        sb.append(str);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707853480")) {
            ipChange.ipc$dispatch("1707853480", new Object[]{this});
            return;
        }
        this.b.a(this.c);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, j62> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885073142")) {
            ipChange.ipc$dispatch("1885073142", new Object[]{this, requestListener});
            return;
        }
        String d2 = this.a.d();
        s72.f("Load seat vr url = " + d2);
        sb0 sb0 = new sb0(d2);
        b72.d(b72.a("damai-vr"));
        sb0.b.f = b72.a("damai-vr").getAbsolutePath();
        sb0.a.get(0).d = "seat_vr.zip";
        sb0.b.m = false;
        this.c = this.b.b(sb0, new a(requestListener));
    }
}
