package tb;

import android.os.SystemClock;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.business.Result;
import com.alibaba.pictures.dolores.business.a;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.dolores.utils.ReqMethodEnum;
import com.alibaba.pictures.dolores.utils.ReqProtocolEnum;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tb.ua0;

/* compiled from: Taobao */
public final class ya0<BizResponse> extends DoloresKernel<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DoloresRequest<BizResponse> t;
    @Nullable
    private IRemoteDataTransformer<BizResponse> u;
    private a v;

    private final void M(int i, String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928544037")) {
            ipChange.ipc$dispatch("928544037", new Object[]{this, Integer.valueOf(i), str, str2, str3, str4, str5});
            return;
        }
        try {
            C("commitMtopFailMsg:errorCode=" + str3 + ",errorMsg" + str4);
            if (i == 0) {
                bb0.e(str, str2, str3, str4, str5, null);
            } else if (i == 1) {
                bb0.d(str, str2, str3, str4, str5, null);
            }
        } catch (Exception e) {
            vp.b(DoloresKernel.Companion.a(), e);
        }
    }

    private final zy0 O() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624581519")) {
            return (zy0) ipChange.ipc$dispatch("1624581519", new Object[]{this});
        }
        C("httpUrlRequest:begin");
        a aVar = this.v;
        zy0 i = aVar != null ? aVar.i() : null;
        C("httpUrlRequest:end");
        return i;
    }

    private final void P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493174471")) {
            ipChange.ipc$dispatch("493174471", new Object[]{this});
            return;
        }
        C("initNetBusiness");
        IRequestInterceptor q = q();
        if (q != null) {
            q.onRequestConfig(this, m());
        }
        if (m() instanceof aa) {
            a aVar = new a();
            DoloresRequest<BizResponse> m = m();
            Objects.requireNonNull(m, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseHttpRequest<BizResponse>");
            aVar.h((aa) m);
            a02 p = p();
            if (p != null) {
                Boolean f = p.f();
                Boolean bool = Boolean.TRUE;
                if (k21.d(f, bool) || k21.d(w(), bool)) {
                    aVar.e(ReqProtocolEnum.HTTP_SECURE);
                } else {
                    aVar.e(ReqProtocolEnum.HTTP);
                }
                if (k21.d(p.h(), bool) || k21.d(v(), bool)) {
                    aVar.g(ReqMethodEnum.GET);
                } else {
                    aVar.g(ReqMethodEnum.POST);
                }
                Map<String, String> a = p.a();
                if (a != null) {
                    if (!(true ^ a.isEmpty())) {
                        a = null;
                    }
                    if (a != null) {
                        aVar.c(a);
                    }
                }
                J(p.e());
            }
            ur2 ur2 = ur2.INSTANCE;
            this.v = aVar;
        }
    }

    private final void Q(fb0<BizResponse> fb0, BizResponseType bizResponseType, zy0 zy0) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25545592")) {
            ipChange.ipc$dispatch("-25545592", new Object[]{this, fb0, bizResponseType, zy0});
        } else if (fb0 != null) {
            fb0.h(bizResponseType.getCode());
            fb0.j(bizResponseType.getDesc());
            if (zy0 == null) {
                fb0.i(bizResponseType.getLocalDes());
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(bizResponseType.getLocalDes());
            sb.append("-[");
            Integer d = zy0.d();
            String str2 = "";
            if (d == null) {
                d = str2;
            }
            sb.append(d);
            sb.append(jl1.CONDITION_IF_MIDDLE);
            String e = zy0.e();
            if (e == null) {
                e = str2;
            }
            sb.append(e);
            sb.append(jl1.ARRAY_END);
            fb0.i(sb.toString());
            Integer d2 = zy0.d();
            if (d2 == null || (str = String.valueOf(d2.intValue())) == null) {
                str = str2;
            }
            fb0.m(str);
            String e2 = zy0.e();
            if (e2 != null) {
                str2 = e2;
            }
            fb0.n(str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0346  */
    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @NotNull
    public fb0<BizResponse> D(@NotNull Result<BizResponse> result) {
        fb0<BizResponse> fb0;
        IRequestInterceptor q;
        String str;
        aa<?> b;
        String obj;
        aa<?> b2;
        String obj2;
        String str2;
        aa<?> b3;
        byte[] bArr;
        fb0<BizResponse> fb02;
        boolean z;
        je l;
        je l2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449549245")) {
            return (fb0) ipChange.ipc$dispatch("-1449549245", new Object[]{this, result});
        }
        k21.i(result, "result");
        C("processRealRequest start");
        P();
        fb0<BizResponse> fb03 = new fb0<>();
        if (this.v == null) {
            vp.c(DoloresKernel.Companion.a(), this + " HttpUrlBusiness has not been init!");
            Q(fb03, BizResponseType.MTOP_INIT_ERROR, null);
            return fb03;
        } else if (n() == 2) {
            Q(fb03, BizResponseType.REQUEST_TASK_CANCELED, null);
            C("isCancelled");
            return fb03;
        } else {
            je l3 = l();
            if (l3 != null && !l3.e()) {
                C("check cache");
                ie a = va0.a(l());
                if (a != null) {
                    if (!(!(a.b() == 1 || (a.b() == 2 && (l2 = l()) != null && l2.g())) || a.d() == null || k() == null)) {
                        zy0 zy0 = new zy0();
                        String d = a.d();
                        if (d != null) {
                            bArr = d.getBytes(ph.UTF_8);
                            k21.h(bArr, "(this as java.lang.String).getBytes(charset)");
                        } else {
                            bArr = null;
                        }
                        zy0.l(bArr);
                        zy0.j(zy0, null, 1, null);
                        IRemoteDataTransformer<BizResponse> N = N();
                        if (N != null) {
                            DoloresRequest<BizResponse> m = m();
                            JSONObject c = zy0.c();
                            Type k = k();
                            k21.f(k);
                            fb02 = N.transform(m, c, k);
                        } else {
                            fb02 = null;
                        }
                        if ((fb02 != null ? fb02.a() : null) != null) {
                            if (a.b() == 1) {
                                Q(fb02, BizResponseType.RESULT_CACHED, null);
                            } else if (a.b() == 2) {
                                Q(fb02, BizResponseType.RESULT_CACHE_EXPIRED, null);
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        C("is hit cache = " + z);
                        if (result instanceof AsyncResult) {
                            ((AsyncResult) result).onHitCache(z, fb02 != null ? fb02.a() : null);
                        }
                        if (z && fb02 != null && ((l = l()) == null || !l.d())) {
                            return fb02;
                        }
                    }
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
                    C("requestInterceptor: onPreRequest return false, return!!!!!");
                    Q(fb03, BizResponseType.RESULT_CODE_INTERCEPTOR_ERROR, null);
                    return fb03;
                }
            }
            ua0.a aVar = ua0.Companion;
            if (!hb0.b(aVar.g().i())) {
                C("network error, sleep and retry");
                SystemClock.sleep(500);
                if (!hb0.b(aVar.g().i())) {
                    C("network error, retry error, return");
                    Q(fb03, BizResponseType.NET_WORK_ERROR, null);
                    return fb03;
                }
                C("network error, retry ok, continue...");
            }
            fb0<BizResponse> e = e(true);
            if (e != null) {
                return e;
            }
            zy0 O = O();
            if (n() == 2) {
                C("after check session isCancelled return");
                Q(fb03, BizResponseType.REQUEST_TASK_CANCELED, null);
                return fb03;
            }
            Boolean h = O != null ? O.h() : null;
            Boolean bool = Boolean.TRUE;
            if (k21.d(h, bool)) {
                C("response Session 失效");
                fb0<BizResponse> e2 = e(false);
                if (e2 != null) {
                    C("return sessionInvalid，and checkSessionValid again but still get invalid, so return!");
                    return e2;
                }
                C("return Session Invalid，the try login finish, retry");
                O = O();
            }
            if (k21.d(O != null ? O.g() : null, bool)) {
                C("illegelSign retry");
                O = O();
            }
            if (result instanceof AsyncResult) {
                ((AsyncResult) result).onReceiveOriResponse(O);
            }
            IRequestInterceptor q3 = q();
            if (q3 != null) {
                C("PostInterceptor process");
                if (q3.onPreProcessData(this, O)) {
                    Q(fb03, BizResponseType.RESULT_CODE_INTERCEPTOR_ERROR, null);
                    return fb03;
                }
            }
            fb03.l(O);
            String str3 = "unKnown";
            if (O == null) {
                Q(fb03, BizResponseType.RESPONSE_NULL_ERROR, null);
            } else if (k21.d(O.g(), bool)) {
                Q(fb03, BizResponseType.RESULT_CODE_ILLEGAL_SIGN, O);
            } else if (k21.d(O.h(), bool)) {
                Q(fb03, BizResponseType.RESULT_CODE_SESSION_EXPIRED, O);
            } else if (k21.d(O.f(), Boolean.FALSE)) {
                Q(fb03, BizResponseType.RESULT_FAIL, O);
            } else if (k() == null) {
                Q(fb03, BizResponseType.PARSE_ERROR_MISS_TRANSFORM_TYPE, O);
                vp.c(DoloresKernel.Companion.a(), this + " bizType==null,没有找到业务侧的返回模型标识");
            } else if (N() == null) {
                Q(fb03, BizResponseType.PARSE_ERROR_MISS_TRANSFORMER, O);
            } else {
                IRemoteDataTransformer<BizResponse> N2 = N();
                fb0<BizResponse> transform = N2 != null ? N2.transform(m(), O.c(), k()) : null;
                if (transform == null || transform.b() == -1) {
                    Q(fb03, BizResponseType.RESULT_FAIL, O);
                } else {
                    if (transform.b() == BizResponseType.PARSE_ERROR.getCode()) {
                        String a2 = O.a();
                        HashMap hashMap = new HashMap();
                        a aVar2 = this.v;
                        if (aVar2 == null || (b3 = aVar2.b()) == null || (str2 = b3.toString()) == null) {
                            str2 = str3;
                        }
                        hashMap.put("Request", str2);
                        ur2 ur2 = ur2.INSTANCE;
                        bb0.b(a2, jl1.MUL, hashMap, null);
                    }
                    fb0 = transform;
                    q = q();
                    if (q != null) {
                        C("PostInterceptor process");
                        q.onAfterProcessData(this, fb0);
                    }
                    str = "";
                    if (fb0.b() != BizResponseType.RESULT_SUCCESS.getCode()) {
                        if (l() != null) {
                            C("syncRequest saveCache");
                            va0.c(l(), O != null ? O.b() : null);
                        }
                        String g = g();
                        if (g == null) {
                            g = str3;
                        }
                        String j = j();
                        if (j != null) {
                            str3 = j;
                        }
                        bb0.f(g, str3, null);
                    } else {
                        int i = (!k21.d(O != null ? O.f() : null, bool) ? 1 : 0) ^ 1;
                        String g2 = g();
                        if (g2 == null) {
                            g2 = str3;
                        }
                        String j2 = j();
                        if (j2 == null) {
                            j2 = str3;
                        }
                        String valueOf = String.valueOf(fb0.b());
                        String c2 = fb0.c();
                        String str4 = c2 != null ? c2 : str;
                        a aVar3 = this.v;
                        M(i, g2, j2, valueOf, str4, (aVar3 == null || (b2 = aVar3.b()) == null || (obj2 = b2.toString()) == null) ? str : obj2);
                    }
                    a aVar4 = this.v;
                    if (!(aVar4 == null || (b = aVar4.b()) == null || (obj = b.toString()) == null)) {
                        str = obj;
                    }
                    bb0.c(str, fb0, null);
                    return fb0;
                }
            }
            fb0 = fb03;
            q = q();
            if (q != null) {
            }
            str = "";
            if (fb0.b() != BizResponseType.RESULT_SUCCESS.getCode()) {
            }
            a aVar42 = this.v;
            str = obj;
            bb0.c(str, fb0, null);
            return fb0;
        }
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19105473")) {
            ipChange.ipc$dispatch("19105473", new Object[]{this});
            return;
        }
        super.E();
        this.v = null;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void H(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-613564455")) {
            ipChange.ipc$dispatch("-613564455", new Object[]{this, doloresRequest});
            return;
        }
        if (doloresRequest instanceof aa) {
            F(((aa) doloresRequest).a);
            G(jl1.MUL);
        }
        this.t = doloresRequest;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514759860")) {
            ipChange.ipc$dispatch("-1514759860", new Object[]{this, iRemoteDataTransformer});
            return;
        }
        this.u = iRemoteDataTransformer;
    }

    @Nullable
    public IRemoteDataTransformer<BizResponse> N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406784968")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("-1406784968", new Object[]{this});
        }
        if (this.u == null) {
            this.u = new dn2();
        }
        return this.u;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308013116")) {
            return ((Boolean) ipChange.ipc$dispatch("1308013116", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        return super.d(z);
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @Nullable
    public DoloresRequest<BizResponse> m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-52450849")) {
            return this.t;
        }
        return (DoloresRequest) ipChange.ipc$dispatch("-52450849", new Object[]{this});
    }
}
