package com.taobao.android.ultron.datamodel.imp;

import android.content.Context;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import com.taobao.android.ultron.datamodel.IRequestCallback;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import tb.am2;
import tb.f1;
import tb.lv1;
import tb.mr;
import tb.tr2;

/* compiled from: Taobao */
public class DMRequester implements IDMRequester {
    public static final String HEADER_FEATURE_KEY = "feature";
    public static final String HEADER_FEATURE_VAL = "{\"gzip\":\"true\"}";
    public static final String KEY_FEATURE_DATA_PARSE = "dataProcess";
    public static final String KEY_FEATURE_REQUEST_ERROR = "netRequest";
    public static final String KEY_FEATURE_VERSION = "1.0";
    public static final String KEY_IS_CACHE_DATA = "isCachaData";
    MtopRequest a;
    IDMContext b;
    boolean c = true;
    boolean d = false;
    boolean e = false;
    boolean f = true;
    String g;
    String h;
    int i = -1;
    boolean j = false;
    Map<String, String> k;
    IDMComponent l;
    Map<String, String> m;
    Class<?> n;
    String o = "default";
    Context p;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class Response implements IRemoteBaseListener, IRemoteCacheListener {
        a mDMContext;
        f1 mOuterCallback;

        Response(f1 f1Var, a aVar) {
            this.mDMContext = aVar;
            this.mOuterCallback = f1Var;
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
        public void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
            tr2.b("DMRequester", "onCached,request: " + DMRequester.this.a.toString());
            if (mtopCacheEvent.getMtopResponse() != null) {
                tr2.b("DMRequester", "onCached, response: " + mtopCacheEvent.getMtopResponse().getDataJsonObject());
            }
            am2.d("DMRequester-" + DMRequester.this.a.getApiName(), "onCached: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(true);
            MtopResponse mtopResponse = mtopCacheEvent.getMtopResponse();
            try {
                if (this.mOuterCallback.isDealDataOuter(10000, mtopResponse, obj)) {
                    return;
                }
            } catch (Throwable unused) {
            }
            if (DMRequester.this.e) {
                try {
                    this.mOuterCallback.onSuccess(10000, mtopResponse, obj, this.mDMContext, null);
                } catch (Throwable th) {
                    tr2.b("DMRequester", "submit onSuccess callback error", th.getMessage());
                }
            } else {
                ParseResponseHelper parseResponseHelper = new ParseResponseHelper(this.mDMContext);
                parseResponseHelper.p(mtopResponse);
                if (parseResponseHelper.i()) {
                    try {
                        this.mOuterCallback.onSuccess(10000, mtopResponse, obj, this.mDMContext, parseResponseHelper.f());
                    } catch (Throwable th2) {
                        tr2.b("DMRequester", "submit onSuccess callback error", th2.getMessage());
                    }
                } else {
                    parseResponseHelper.d(DMRequester.KEY_IS_CACHE_DATA, "true");
                    this.mOuterCallback.onError(10000, mtopResponse, obj, true, parseResponseHelper.f());
                }
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onError(int i, MtopResponse mtopResponse, Object obj) {
            tr2.b("DMRequester", "onError: errorCode:" + mtopResponse.getRetCode() + ",errorMsg:" + mtopResponse.getRetMsg() + ",request: " + DMRequester.this.a.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("DMRequester-");
            sb.append(DMRequester.this.a.getApiName());
            String sb2 = sb.toString();
            am2.a(sb2, "onError: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(false);
            try {
                f1 f1Var = this.mOuterCallback;
                if (f1Var != null && !f1Var.isDealDataOuter(i, mtopResponse, obj)) {
                    this.mOuterCallback.onError(i, mtopResponse, obj, false, null);
                }
            } catch (Exception e) {
                tr2.b("DMRequester", "onError 节点onError回调处理错误出错", e.getMessage());
            }
            UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_REQUEST_ERROR, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            tr2.b("DMRequester", "onSuccess, request: " + DMRequester.this.a.toString());
            if (mtopResponse != null) {
                tr2.b("DMRequester", "onSuccess, response: " + mtopResponse.getDataJsonObject());
            }
            am2.a("DMRequester-" + DMRequester.this.a.getApiName(), "DMRequester onSuccess: " + DMRequester.this.a.getApiName());
            am2.c(am2.KEY_ULTRON_PROFILE, "onSucess: " + DMRequester.this.a.getApiName());
            if (this.mDMContext.isCacheData()) {
                this.mDMContext.t();
                this.mDMContext.u(false);
            }
            try {
                try {
                    if (this.mOuterCallback.isDealDataOuter(i, mtopResponse, obj)) {
                        return;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            am2.c(am2.KEY_ULTRON_PROFILE, "isDealDataOuter");
            if (DMRequester.this.e) {
                try {
                    this.mOuterCallback.onSuccess(i, mtopResponse, obj, this.mDMContext, null);
                } catch (Throwable th) {
                    tr2.b("DMRequester", "submit onSuccess callback error", th.getMessage());
                }
            } else {
                ParseResponseHelper parseResponseHelper = new ParseResponseHelper(this.mDMContext);
                JSONObject jSONObject = (JSONObject) JSON.parseObject(mtopResponse.getBytedata(), JSONObject.class, new Feature[0]);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                parseResponseHelper.n(jSONObject2);
                if (parseResponseHelper.h(lv1.FEATURE_CONTAINER_CACHE)) {
                    DMRequester dMRequester = DMRequester.this;
                    parseResponseHelper.s(dMRequester.p, dMRequester.o, jSONObject2, true, true);
                }
                parseResponseHelper.o(jSONObject);
                am2.c(am2.KEY_ULTRON_PROFILE, "parse complete");
                if (parseResponseHelper.i()) {
                    try {
                        this.mOuterCallback.onSuccess(i, mtopResponse, obj, this.mDMContext, parseResponseHelper.f());
                    } catch (Throwable th2) {
                        tr2.b("DMRequester", "submit onSuccess callback error", th2.getMessage());
                    }
                } else {
                    this.mOuterCallback.onError(i, mtopResponse, obj, true, parseResponseHelper.f());
                    Map<String, Object> f = parseResponseHelper.f();
                    if (f != null) {
                        Object obj2 = f.get("protocolVersion");
                        if (obj2 instanceof String) {
                            try {
                                if (((double) Float.parseFloat((String) obj2)) > 2.1d) {
                                    UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_DATA_PARSE, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, "parse response error", "error msg");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                am2.c(am2.KEY_ULTRON_PROFILE, "callback complete");
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
        public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            tr2.b("DMRequester", "onSystemError: errorCode:" + mtopResponse.getRetCode() + ",errorMsg:" + mtopResponse.getRetMsg() + ",request: " + DMRequester.this.a.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("DMRequester-");
            sb.append(DMRequester.this.a.getApiName());
            String sb2 = sb.toString();
            am2.a(sb2, "onSystemError: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(false);
            try {
                f1 f1Var = this.mOuterCallback;
                if (f1Var != null && !f1Var.isDealDataOuter(i, mtopResponse, obj)) {
                    this.mOuterCallback.onError(i, mtopResponse, obj, false, null);
                }
            } catch (Exception e) {
                tr2.b("DMRequester", "onSystemError 节点onError回调处理错误出错", e.getMessage());
            }
            UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_REQUEST_ERROR, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
        }
    }

    /* compiled from: Taobao */
    class a extends f1 {
        private IRequestCallback a;

        public a(DMRequester dMRequester, IRequestCallback iRequestCallback) {
            this.a = iRequestCallback;
        }

        @Override // com.taobao.android.ultron.datamodel.IRequestCallback
        public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ?> map) {
            IRequestCallback iRequestCallback = this.a;
            if (iRequestCallback != null) {
                iRequestCallback.onError(i, mtopResponse, obj, false, map);
            }
        }

        @Override // com.taobao.android.ultron.datamodel.IRequestCallback
        public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ?> map) {
            IRequestCallback iRequestCallback = this.a;
            if (iRequestCallback != null) {
                iRequestCallback.onSuccess(i, mtopResponse, obj, iDMContext, map);
            }
        }
    }

    public DMRequester(mr mrVar) {
        if (mrVar != null) {
            this.f = mrVar.v();
            if (mrVar.m() != null) {
                this.b = mrVar.m();
            } else {
                this.b = new a(this.f);
            }
            this.k = mrVar.o();
            this.g = mrVar.n();
            this.h = mrVar.s();
            this.d = mrVar.u();
            this.e = mrVar.z();
            this.j = mrVar.A();
            this.c = mrVar.y();
            this.i = mrVar.j();
            this.l = mrVar.r();
            this.m = mrVar.p();
            this.n = mrVar.q();
            this.o = mrVar.k();
            MtopRequest mtopRequest = new MtopRequest();
            this.a = mtopRequest;
            mtopRequest.setApiName(mrVar.i());
            this.a.setVersion(mrVar.t());
            this.a.setNeedSession(mrVar.x());
            this.a.setNeedEcode(mrVar.w());
            this.p = mrVar.l();
            this.b.setBizName(this.o);
            ((a) this.b).x(mrVar.l());
        }
    }

    private boolean a(Object obj, f1 f1Var) {
        IDMContext iDMContext = this.b;
        if (!(iDMContext instanceof a)) {
            return false;
        }
        a aVar = (a) iDMContext;
        if (this.m == null) {
            this.m = new HashMap();
        }
        if (this.d) {
            if (this.f) {
                this.m.put("feature", "{\"gzip\":\"true\"}");
            }
            this.m.put("params", aVar.g().a(aVar, this.l));
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll(this.m);
            this.a.setData(jSONObject.toJSONString());
        } else if (this.e) {
            if (this.f) {
                this.m.put("feature", "{\"gzip\":\"true\"}");
            }
            this.m.put("params", aVar.g().g(aVar));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putAll(this.m);
            this.a.setData(jSONObject2.toJSONString());
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putAll(this.m);
            this.a.setData(jSONObject3.toJSONString());
        }
        MtopBusiness build = MtopBusiness.build(this.a);
        if (this.j) {
            build.useWua();
        }
        if (this.c) {
            build.reqMethod(MethodEnum.POST);
        }
        String str = this.g;
        if (str != null) {
            build.setCustomDomain(str);
        }
        int i2 = this.i;
        if (-1 != i2) {
            build.setBizId(i2);
        }
        String str2 = this.h;
        if (str2 != null) {
            build.setUnitStrategy(str2);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            build.mtopProp.setRequestHeaders(map);
        }
        if (obj != null) {
            build.reqContext(obj);
        }
        build.setErrorNotifyAfterCache(true);
        Response response = new Response(f1Var, aVar);
        if (this.n == null) {
            build.addListener((MtopListener) response).startRequest();
        } else {
            build.addListener((MtopListener) response).startRequest(this.n);
        }
        tr2.b("DMRequester", "send request: " + this.a.toString());
        am2.e("DMRequester-" + this.a.getApiName(), "begin request: " + this.a.getApiName());
        return true;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(f1 f1Var) {
        return a(null, f1Var);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(Object obj, f1 f1Var) {
        return a(obj, f1Var);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(IRequestCallback iRequestCallback) {
        return a(null, new a(this, iRequestCallback));
    }
}
