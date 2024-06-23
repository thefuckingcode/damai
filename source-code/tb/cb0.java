package tb;

import android.os.SystemClock;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.business.Result;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.expection.DoloresException;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.request.BaseMtopRequest;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.Mtop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tb.ua0;

/* compiled from: Taobao */
public final class cb0<BizResponse> extends DoloresKernel<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private MtopBusiness t;
    @Nullable
    private DoloresRequest<BizResponse> u;
    @Nullable
    private IRemoteDataTransformer<BizResponse> v;

    private final void M(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632422673")) {
            ipChange.ipc$dispatch("-1632422673", new Object[]{this, Integer.valueOf(i), str, str2, str3, str4, str5, str6});
            return;
        }
        try {
            C("commitMtopFailMsg:errorCode=" + str3 + ",errorMsg" + str4);
            if (i == 0) {
                bb0.e(str, str2, str3, str4, str5, str6);
            } else if (i == 1) {
                bb0.d(str, str2, str3, str4, str5, str6);
            }
        } catch (Exception e) {
            vp.b(DoloresKernel.Companion.a(), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b2, code lost:
        if (((com.alibaba.pictures.request.BaseRequest) r1).NEED_ECODE != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01e9, code lost:
        if (((mtopsdk.mtop.domain.MtopRequest) r1).isNeedEcode() != false) goto L_0x01eb;
     */
    private final void O() {
        MtopBusiness mtopBusiness;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1762360578")) {
            ipChange.ipc$dispatch("-1762360578", new Object[]{this});
            return;
        }
        String a = DoloresKernel.Companion.a();
        vp.a(a, this + " initMtopBusiness");
        IRequestInterceptor q = q();
        if (q != null) {
            q.onRequestConfig(this, m());
        }
        DoloresRequest<BizResponse> m = m();
        if (m instanceof BaseRequest) {
            Mtop P = P();
            DoloresRequest<BizResponse> m2 = m();
            Objects.requireNonNull(m2, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseRequest<BizResponse>");
            mtopBusiness = MtopBusiness.build(P, (BaseRequest) m2, ua0.Companion.g().n());
        } else if (m instanceof BaseMtopRequest) {
            Mtop P2 = P();
            DoloresRequest<BizResponse> m3 = m();
            Objects.requireNonNull(m3, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseMtopRequest<BizResponse>");
            mtopBusiness = MtopBusiness.build(P2, (MtopRequest) ((BaseMtopRequest) m3), ua0.Companion.g().n());
        } else if (m instanceof MtopRequest) {
            Mtop P3 = P();
            DoloresRequest<BizResponse> m4 = m();
            Objects.requireNonNull(m4, "null cannot be cast to non-null type mtopsdk.mtop.domain.MtopRequest");
            mtopBusiness = MtopBusiness.build(P3, (MtopRequest) m4, ua0.Companion.g().n());
        } else if (m instanceof IMTOPDataObject) {
            Mtop P4 = P();
            DoloresRequest<BizResponse> m5 = m();
            Objects.requireNonNull(m5, "null cannot be cast to non-null type mtopsdk.mtop.domain.IMTOPDataObject");
            mtopBusiness = MtopBusiness.build(P4, (IMTOPDataObject) m5, ua0.Companion.g().n());
        } else {
            throw new DoloresException("There is no request,you need set a request [BaseMtopRequest|BaseRequest]!");
        }
        this.t = mtopBusiness;
        C("initMtopBusiness");
        MtopBusiness mtopBusiness2 = this.t;
        if (mtopBusiness2 != null) {
            a02 p = p();
            if (p != null) {
                Map<String, String> a2 = p.a();
                if (!(a2 == null || a2.isEmpty())) {
                    mtopBusiness2.headers(p.a());
                }
                String o = o();
                if (!(o == null || o.length() == 0)) {
                    mtopBusiness2.addHttpQueryParameter("tb_eagleeyex_scm_project", o());
                }
                Boolean g = p.g();
                if (g != null) {
                    mtopBusiness2.showLoginUI(g.booleanValue());
                }
                JsonTypeEnum b = p.b();
                if (b != null) {
                    mtopBusiness2.setJsonType(b);
                }
            }
            a02 p2 = p();
            String str = null;
            Boolean h = p2 != null ? p2.h() : null;
            Boolean bool = Boolean.TRUE;
            if (k21.d(h, bool) || k21.d(v(), bool)) {
                mtopBusiness2.reqMethod(MethodEnum.GET);
            } else {
                mtopBusiness2.reqMethod(MethodEnum.POST);
            }
            a02 p3 = p();
            if (k21.d(p3 != null ? p3.f() : null, bool) || k21.d(w(), bool)) {
                mtopBusiness2.protocol(ProtocolEnum.HTTPSECURE);
            } else {
                mtopBusiness2.protocol(ProtocolEnum.HTTP);
            }
            a02 p4 = p();
            if (k21.d(p4 != null ? p4.i() : null, bool) && k21.d(s(), bool)) {
                mtopBusiness2.useWua();
            }
            DoloresRequest<BizResponse> m6 = m();
            if (m6 instanceof BaseRequest) {
                a02 p5 = p();
                if (p5 == null || !p5.e()) {
                    DoloresRequest<BizResponse> m7 = m();
                    Objects.requireNonNull(m7, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseRequest<BizResponse>");
                }
                z = true;
                J(z);
                DoloresRequest<BizResponse> m8 = m();
                Objects.requireNonNull(m8, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseRequest<BizResponse>");
                K(((BaseRequest) m8).NEED_SESSION);
            } else if ((m6 instanceof BaseMtopRequest) || (m6 instanceof MtopRequest)) {
                a02 p6 = p();
                if (p6 == null || !p6.e()) {
                    DoloresRequest<BizResponse> m9 = m();
                    Objects.requireNonNull(m9, "null cannot be cast to non-null type mtopsdk.mtop.domain.MtopRequest");
                }
                z = true;
                J(z);
                DoloresRequest<BizResponse> m10 = m();
                Objects.requireNonNull(m10, "null cannot be cast to non-null type mtopsdk.mtop.domain.MtopRequest");
                K(((MtopRequest) m10).isNeedSession());
            } else if (m6 instanceof IMTOPDataObject) {
                a02 p7 = p();
                if (p7 == null || !p7.e()) {
                    z2 = false;
                }
                J(z2);
                K(false);
            }
            MtopRequest mtopRequest = mtopBusiness2.request;
            F(mtopRequest != null ? mtopRequest.getApiName() : null);
            MtopRequest mtopRequest2 = mtopBusiness2.request;
            if (mtopRequest2 != null) {
                str = mtopRequest2.getVersion();
            }
            G(str);
        }
    }

    private final Mtop P() {
        String str;
        Double[] c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915558038")) {
            return (Mtop) ipChange.ipc$dispatch("1915558038", new Object[]{this});
        }
        a02 p = p();
        if (p == null || (str = p.d()) == null) {
            str = Mtop.Id.INNER;
        }
        ua0.a aVar = ua0.Companion;
        Mtop instance = Mtop.instance(str, aVar.g().i(), aVar.g().n());
        a02 p2 = p();
        if (!(p2 == null || (c = p2.c()) == null)) {
            if (!(c.length >= 2)) {
                c = null;
            }
            if (c != null) {
                instance.setCoordinates(String.valueOf(c[0].doubleValue()), String.valueOf(c[1].doubleValue()));
            }
        }
        return instance;
    }

    private final MtopResponse Q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099905906")) {
            return (MtopResponse) ipChange.ipc$dispatch("-1099905906", new Object[]{this});
        }
        C("mtopRequest begin");
        MtopBusiness mtopBusiness = this.t;
        MtopResponse syncRequest = mtopBusiness != null ? mtopBusiness.syncRequest() : null;
        C("mtopRequest end");
        return syncRequest;
    }

    private final void R(fb0<BizResponse> fb0, BizResponseType bizResponseType, MtopResponse mtopResponse) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067613422")) {
            ipChange.ipc$dispatch("2067613422", new Object[]{this, fb0, bizResponseType, mtopResponse});
        } else if (fb0 != null) {
            fb0.h(bizResponseType.getCode());
            IGlobalConfig a = ua0.Companion.a();
            if (a == null || (str = a.getGlobalConfig(IGlobalConfig.Key.GENERAL_REQUEST_ERROR_MSG, "小二很忙，系统很累，稍后再试吧")) == null) {
                str = bizResponseType.getDesc();
            }
            fb0.j(str);
            if (mtopResponse == null) {
                fb0.i(bizResponseType.getLocalDes());
                return;
            }
            fb0.i(bizResponseType.getLocalDes() + "-[" + mtopResponse.getRetCode() + jl1.CONDITION_IF_MIDDLE + mtopResponse.getRetMsg() + jl1.ARRAY_END);
            fb0.m(mtopResponse.getRetCode());
            fb0.n(mtopResponse.getRetMsg());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:177:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03b2  */
    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @NotNull
    public fb0<BizResponse> D(@NotNull Result<BizResponse> result) {
        fb0<BizResponse> fb0;
        IRequestInterceptor q;
        String str;
        MtopRequest mtopRequest;
        String mtopRequest2;
        MtopRequest mtopRequest3;
        String mtopRequest4;
        String str2;
        MtopRequest mtopRequest5;
        String str3;
        MtopRequest mtopRequest6;
        byte[] bArr;
        fb0<BizResponse> fb02;
        boolean z;
        je l;
        je l2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227252099")) {
            return (fb0) ipChange.ipc$dispatch("227252099", new Object[]{this, result});
        }
        k21.i(result, "result");
        O();
        y(1);
        C("processRealRequest start...");
        fb0<BizResponse> fb03 = new fb0<>();
        byte[] bArr2 = null;
        if (this.t == null) {
            vp.c(DoloresKernel.Companion.a(), this + " mtopBusiness has not been init!");
            R(fb03, BizResponseType.MTOP_INIT_ERROR, null);
            return fb03;
        } else if (n() == 2) {
            R(fb03, BizResponseType.REQUEST_TASK_CANCELED, null);
            C("isCancelled");
            return fb03;
        } else {
            je l3 = l();
            if (l3 != null && !l3.e()) {
                C("check cache");
                ie a = va0.a(l());
                if (a != null) {
                    if (!(!(a.b() == 1 || (a.b() == 2 && (l2 = l()) != null && l2.g())) || a.d() == null || k() == null)) {
                        MtopResponse mtopResponse = new MtopResponse();
                        String d = a.d();
                        if (d != null) {
                            bArr = d.getBytes(ph.UTF_8);
                            k21.h(bArr, "(this as java.lang.String).getBytes(charset)");
                        } else {
                            bArr = null;
                        }
                        mtopResponse.setBytedata(bArr);
                        mtopResponse.parseJsonByte();
                        ur2 ur2 = ur2.INSTANCE;
                        IRemoteDataTransformer<BizResponse> N = N();
                        if (N != null) {
                            DoloresRequest<BizResponse> m = m();
                            JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
                            Type k = k();
                            k21.f(k);
                            fb02 = N.transform(m, dataJsonObject, k);
                        } else {
                            fb02 = null;
                        }
                        if ((fb02 != null ? fb02.a() : null) != null) {
                            if (a.b() == 1) {
                                R(fb02, BizResponseType.RESULT_CACHED, null);
                            } else if (a.b() == 2) {
                                R(fb02, BizResponseType.RESULT_CACHE_EXPIRED, null);
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        C("is hit cache = " + z);
                        if (result instanceof AsyncResult) {
                            ((AsyncResult) result).onHitCache(z, fb02 != null ? fb02.a() : null);
                        }
                        if (z && (((l = l()) == null || !l.d()) && fb02 != null)) {
                            return fb02;
                        }
                    }
                    ur2 ur22 = ur2.INSTANCE;
                } else {
                    C("is hit cache = " + false);
                    if (result instanceof AsyncResult) {
                        ((AsyncResult) result).onHitCache(false, null);
                    }
                }
            }
            IRequestInterceptor q2 = q();
            if (q2 != null) {
                C("requestInterceptor: process");
                if (q2.onPreRequest(this, m())) {
                    vp.a(DoloresKernel.Companion.a(), "requestInterceptor: process request false, return!!!!!");
                    R(fb03, BizResponseType.RESULT_CODE_INTERCEPTOR_ERROR, null);
                    return fb03;
                }
                ur2 ur23 = ur2.INSTANCE;
            }
            ua0.a aVar = ua0.Companion;
            if (!hb0.b(aVar.g().i())) {
                C("network error, sleep and retry");
                SystemClock.sleep(500);
                if (!hb0.b(aVar.g().i())) {
                    C("network error, retry error, return");
                    R(fb03, BizResponseType.NET_WORK_ERROR, null);
                    return fb03;
                }
                C("network error, retry ok, continue...");
            }
            fb0<BizResponse> e = e(true);
            if (e != null) {
                return e;
            }
            y(2);
            MtopResponse Q = Q();
            y(3);
            if (g() == null) {
                F(Q != null ? Q.getApi() : null);
            }
            if (j() == null) {
                G(Q != null ? Q.getV() : null);
            }
            if (n() == 2) {
                C("after check session, isCancelled return");
                return fb03;
            }
            if (Q != null && Q.isSessionInvalid()) {
                C("response Session 失效");
                fb0<BizResponse> e2 = e(false);
                if (e2 != null) {
                    C("return sessionInvalid，and checkSessionValid again but still get invalid, so return!");
                    return e2;
                }
                C("return Session Invalid，the try login finish, retry");
                Q = Q();
            }
            if (Q != null && Q.isIllegelSign()) {
                C("illegelSign retry");
                Q = Q();
            }
            if (result instanceof AsyncResult) {
                ((AsyncResult) result).onReceiveOriResponse(Q);
            }
            String a2 = hb0.a(Q);
            IRequestInterceptor q3 = q();
            if (q3 != null) {
                C("requestInterceptor: process");
                if (q3.onPreProcessData(this, Q)) {
                    vp.a(DoloresKernel.Companion.a(), "requestInterceptor: process-remoteResponse return false, return!!!!!");
                    R(fb03, BizResponseType.RESULT_CODE_INTERCEPTOR_ERROR, Q);
                    return fb03;
                }
                ur2 ur24 = ur2.INSTANCE;
            }
            String str4 = "unKnown";
            if (Q == null) {
                R(fb03, BizResponseType.RESPONSE_NULL_ERROR, null);
            } else if (Q.isIllegelSign()) {
                R(fb03, BizResponseType.RESULT_CODE_ILLEGAL_SIGN, Q);
            } else if (Q.isSessionInvalid()) {
                R(fb03, BizResponseType.RESULT_CODE_SESSION_EXPIRED, Q);
            } else if (!Q.isApiSuccess()) {
                R(fb03, BizResponseType.RESULT_FAIL, Q);
            } else if (k() == null) {
                R(fb03, BizResponseType.PARSE_ERROR_MISS_TRANSFORM_TYPE, Q);
                vp.c(DoloresKernel.Companion.a(), this + " bizType==null,没有找到业务侧的返回模型标识");
            } else if (Q.getDataJsonObject() == null) {
                R(fb03, BizResponseType.PARSE_ERROR, Q);
                String g = g();
                HashMap hashMap = new HashMap();
                MtopBusiness mtopBusiness = this.t;
                if (mtopBusiness == null || (mtopRequest6 = mtopBusiness.request) == null || (str3 = mtopRequest6.toString()) == null) {
                    str3 = str4;
                }
                hashMap.put("Request", str3);
                ur2 ur25 = ur2.INSTANCE;
                bb0.a(g, hashMap);
            } else if (N() == null) {
                R(fb03, BizResponseType.PARSE_ERROR_MISS_TRANSFORMER, Q);
            } else {
                IRemoteDataTransformer<BizResponse> N2 = N();
                fb0<BizResponse> transform = N2 != null ? N2.transform(m(), Q.getDataJsonObject(), k()) : null;
                if (transform == null || transform.b() == -1) {
                    R(fb03, BizResponseType.RESULT_FAIL, Q);
                } else {
                    int b = transform.b();
                    BizResponseType bizResponseType = BizResponseType.PARSE_ERROR;
                    if (b == bizResponseType.getCode()) {
                        R(transform, bizResponseType, Q);
                        String g2 = g();
                        String j = j();
                        HashMap hashMap2 = new HashMap();
                        MtopBusiness mtopBusiness2 = this.t;
                        if (mtopBusiness2 == null || (mtopRequest5 = mtopBusiness2.request) == null || (str2 = mtopRequest5.toString()) == null) {
                            str2 = str4;
                        }
                        hashMap2.put("Request", str2);
                        ur2 ur26 = ur2.INSTANCE;
                        bb0.b(g2, j, hashMap2, a2);
                    } else {
                        transform.m(Q.getRetCode());
                        transform.n(Q.getRetMsg());
                    }
                    fb0 = transform;
                    fb0.l(Q);
                    q = q();
                    if (q != null) {
                        C("onAfterProcessData process");
                        q.onAfterProcessData(this, fb0);
                        ur2 ur27 = ur2.INSTANCE;
                    }
                    str = "";
                    if (fb0.b() != BizResponseType.RESULT_SUCCESS.getCode()) {
                        if (l() != null) {
                            C("syncRequest saveCache");
                            je l4 = l();
                            if (Q != null) {
                                bArr2 = Q.getBytedata();
                            }
                            va0.c(l4, bArr2);
                            ur2 ur28 = ur2.INSTANCE;
                        }
                        String g3 = g();
                        if (g3 == null) {
                            g3 = str4;
                        }
                        String j2 = j();
                        if (j2 != null) {
                            str4 = j2;
                        }
                        bb0.f(g3, str4, a2);
                    } else {
                        int i = (Q == null || !Q.isApiSuccess()) ? 0 : 1;
                        String g4 = g();
                        if (g4 == null) {
                            g4 = str4;
                        }
                        String j3 = j();
                        if (j3 == null) {
                            j3 = str4;
                        }
                        String valueOf = String.valueOf(fb0.b());
                        String c = fb0.c();
                        String str5 = c != null ? c : str;
                        MtopBusiness mtopBusiness3 = this.t;
                        String str6 = (mtopBusiness3 == null || (mtopRequest3 = mtopBusiness3.request) == null || (mtopRequest4 = mtopRequest3.toString()) == null) ? str : mtopRequest4;
                        k21.h(str6, "mtopBusiness?.request?.toString() ?: \"\"");
                        M(i, g4, j3, valueOf, str5, str6, a2);
                    }
                    MtopBusiness mtopBusiness4 = this.t;
                    if (!(mtopBusiness4 == null || (mtopRequest = mtopBusiness4.request) == null || (mtopRequest2 = mtopRequest.toString()) == null)) {
                        str = mtopRequest2;
                    }
                    bb0.c(str, fb0, a2);
                    return fb0;
                }
            }
            fb0 = fb03;
            fb0.l(Q);
            q = q();
            if (q != null) {
            }
            str = "";
            if (fb0.b() != BizResponseType.RESULT_SUCCESS.getCode()) {
            }
            MtopBusiness mtopBusiness42 = this.t;
            str = mtopRequest2;
            bb0.c(str, fb0, a2);
            return fb0;
        }
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891206017")) {
            ipChange.ipc$dispatch("891206017", new Object[]{this});
            return;
        }
        super.E();
        this.t = null;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void H(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812174055")) {
            ipChange.ipc$dispatch("-812174055", new Object[]{this, doloresRequest});
            return;
        }
        this.u = doloresRequest;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964687732")) {
            ipChange.ipc$dispatch("-1964687732", new Object[]{this, iRemoteDataTransformer});
            return;
        }
        this.v = iRemoteDataTransformer;
    }

    @Nullable
    public IRemoteDataTransformer<BizResponse> N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072553208")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("1072553208", new Object[]{this});
        }
        if (this.v == null) {
            this.v = new dn2();
        }
        return this.v;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114853636")) {
            return ((Boolean) ipChange.ipc$dispatch("-2114853636", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        MtopBusiness mtopBusiness = this.t;
        if (mtopBusiness != null) {
            mtopBusiness.cancelRequest();
        }
        return super.d(z);
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @Nullable
    public DoloresRequest<BizResponse> m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1326615711")) {
            return this.u;
        }
        return (DoloresRequest) ipChange.ipc$dispatch("1326615711", new Object[]{this});
    }
}
