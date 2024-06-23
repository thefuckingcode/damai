package com.youku.network.a;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.network.config.YKNetworkConfig;
import com.youku.network.config.a;
import com.youku.network.d;
import java.util.Map;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
public class c<I extends MtopBuilder, O extends MtopResponse> extends a<I, O> {
    private d b(O o) {
        d a = d.a();
        a.a(o);
        a.b(o.getResponseCode());
        a.a(o.getHeaderFields());
        if (!a.b(o.getRetCode())) {
            a.a(a.a(o.getRetCode()));
        }
        if (o.getMtopStat() != null) {
            a.a(o.getMtopStat().getNetStat());
        }
        return a;
    }

    private MtopBuilder b(com.youku.network.c cVar) {
        Mtop a = cVar.D() == null ? com.youku.d.a.a() : cVar.D();
        String w = !TextUtils.isEmpty(cVar.w()) ? cVar.w() : com.youku.d.a.b();
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(cVar.o());
        mtopRequest.setVersion(cVar.p());
        mtopRequest.setNeedEcode(cVar.r());
        mtopRequest.setNeedSession(cVar.s());
        if (!TextUtils.isEmpty(cVar.q())) {
            mtopRequest.setData(cVar.q());
        }
        if (cVar.t() != null) {
            mtopRequest.dataParams = cVar.t();
        }
        MtopBuilder build = YKNetworkConfig.c() ? MtopBusiness.build(a, mtopRequest, w) : a.build(mtopRequest, w);
        if (cVar.F() != null) {
            build.headers(cVar.F());
        }
        if (cVar.G() != null) {
            for (Map.Entry<String, String> entry : cVar.G().entrySet()) {
                build.addHttpQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        build.setConnectionTimeoutMilliSecond(cVar.I());
        build.setSocketTimeoutMilliSecond(cVar.J());
        build.reqMethod(cVar.K());
        build.retryTime(cVar.H());
        if (cVar.u() != null) {
            build.protocol(cVar.u());
        }
        if (!TextUtils.isEmpty(cVar.v())) {
            build.setCustomDomain(cVar.v());
        }
        if (!TextUtils.isEmpty(cVar.x())) {
            build.addMteeUa(cVar.x());
        }
        if (cVar.y() != -1) {
            build.useWua(cVar.y());
        }
        if (!TextUtils.isEmpty(cVar.z()) && !TextUtils.isEmpty(cVar.A())) {
            build.addOpenApiParams(cVar.z(), cVar.A());
        }
        if (cVar.C()) {
            build.useCache();
        }
        if (cVar.B()) {
            build.setCacheControlNoCache();
        }
        return build;
    }

    public d a(O o) {
        return b(o);
    }

    public I a(com.youku.network.c cVar) {
        return (I) b(cVar);
    }
}
