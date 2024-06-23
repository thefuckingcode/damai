package tb;

import anet.channel.request.a;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.c;
import anetwork.channel.aidl.ParcelableRequest;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
public class b02 {
    private ParcelableRequest a;
    private a b = null;
    private int c = 0;
    private int d = 0;
    public int e = 0;
    public RequestStatistic f;
    public final int g;
    public final int h;
    public final String i;
    public final int j;
    private final boolean k;
    private final String l;

    public b02(ParcelableRequest parcelableRequest, int i2, boolean z) {
        String str = null;
        if (parcelableRequest != null) {
            this.a = parcelableRequest;
            this.j = i2;
            this.k = z;
            this.i = q82.a(parcelableRequest.seqNo, i2 == 0 ? "HTTP" : "DGRD");
            int i3 = parcelableRequest.connectTimeout;
            this.g = i3 <= 0 ? (int) (c.f() * 12000.0f) : i3;
            int i4 = parcelableRequest.readTimeout;
            this.h = i4 <= 0 ? (int) (c.f() * 12000.0f) : i4;
            int i5 = parcelableRequest.retryTime;
            this.d = (i5 < 0 || i5 > 3) ? 2 : i5;
            yy0 k2 = k();
            RequestStatistic requestStatistic = new RequestStatistic(k2.d(), String.valueOf(parcelableRequest.bizId));
            this.f = requestStatistic;
            requestStatistic.url = k2.l();
            this.f.maxRetryTime = this.d;
            this.b = a(k2);
            Map<String, String> map = parcelableRequest.headers;
            this.l = map != null ? map.get(HttpHeaderConstant.F_REFER) : str;
            return;
        }
        throw new IllegalArgumentException("request is null");
    }

    private a a(yy0 yy0) {
        a.b W = new a.b().a0(yy0).R(this.a.method).M(this.a.bodyEntry).T(this.h).O(this.g).U(this.a.allowRedirect).V(this.c).L(this.a.bizId).X(this.i).W(this.f);
        W.S(this.a.params);
        String str = this.a.charset;
        if (str != null) {
            W.N(str);
        }
        W.P(j(yy0));
        return W.J();
    }

    private Map<String, String> j(yy0 yy0) {
        String d2 = yy0.d();
        boolean z = !ju2.c(d2);
        if (d2.length() > 2 && d2.charAt(0) == '[' && d2.charAt(d2.length() - 1) == ']' && ju2.d(d2.substring(1, d2.length() - 1))) {
            z = false;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.a.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!BizTime.HOST.equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean equalsIgnoreCase = "true".equalsIgnoreCase(this.a.getExtProperty("KeepCustomCookie"));
                    if (!IRequestConst.COOKIE.equalsIgnoreCase(key) || equalsIgnoreCase) {
                        hashMap.put(key, entry.getValue());
                    }
                } else if (!z) {
                    hashMap.put(BizTime.HOST, entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private yy0 k() {
        yy0 g2 = yy0.g(this.a.url);
        if (g2 != null) {
            if (!sh1.E()) {
                ALog.f("anet.RequestConfig", "request ssl disabled.", this.i, new Object[0]);
                g2.b();
            } else if ("false".equalsIgnoreCase(this.a.getExtProperty("EnableSchemeReplace"))) {
                g2.f();
            }
            return g2;
        }
        throw new IllegalArgumentException("url is invalid. url=" + this.a.url);
    }

    public a b() {
        return this.b;
    }

    public String c() {
        return this.l;
    }

    public Map<String, String> d() {
        return this.b.g();
    }

    public yy0 e() {
        return this.b.j();
    }

    public Map<String, String> f() {
        return this.a.extProperties;
    }

    public String g(String str) {
        return this.a.getExtProperty(str);
    }

    public String h() {
        return this.b.q();
    }

    public int i() {
        return this.h * (this.d + 1);
    }

    public boolean l() {
        return this.e < this.d;
    }

    public boolean m() {
        return sh1.q() && !"false".equalsIgnoreCase(this.a.getExtProperty("EnableHttpDns")) && (sh1.g() || this.e == 0);
    }

    public boolean n() {
        return !"false".equalsIgnoreCase(this.a.getExtProperty("EnableCookie"));
    }

    public boolean o() {
        return this.k;
    }

    public void p(yy0 yy0) {
        ALog.f("anet.RequestConfig", "redirect", this.i, "to url", yy0.toString());
        this.c++;
        this.f.url = yy0.l();
        this.b = a(yy0);
    }

    public void q() {
        int i2 = this.e + 1;
        this.e = i2;
        this.f.retryTimes = i2;
    }

    public void r(a aVar) {
        this.b = aVar;
    }

    public boolean s() {
        return "true".equals(this.a.getExtProperty("CheckContentLength"));
    }
}
