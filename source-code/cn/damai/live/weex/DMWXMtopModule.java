package cn.damai.live.weex;

import android.app.Activity;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopErrorHelper;
import com.alibaba.aliweex.adapter.module.mtop.WXMtopModule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dsl.network.INetCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;
import tb.a20;
import tb.d20;
import tb.gl1;
import tb.jl1;
import tb.m6;
import tb.xs0;
import tb.yz2;

/* compiled from: Taobao */
public class DMWXMtopModule extends WXMtopModule {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String MTOP_DAMAI = "INNER";
    private static final String MTOP_YOUKU = "havana-instance-youku";
    private String api;
    private String apiVersion;
    private boolean isPost;
    private WeakReference<Activity> mActivity;
    private MtopBusiness mMtopBusiness;
    private MtopRequest mMtopRequest;
    private INetCallback mNetCallback;
    private boolean needLogin;
    private Map<String, String> params;

    private void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306348312")) {
            ipChange.ipc$dispatch("1306348312", new Object[]{this, mtopRequest, str, str2, Boolean.valueOf(z), map});
            return;
        }
        mtopRequest.setApiName(str);
        if (TextUtils.isEmpty(str2)) {
            mtopRequest.setVersion("1.0");
        } else {
            mtopRequest.setVersion(str2);
        }
        mtopRequest.setNeedEcode(z);
        mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fail(JSCallback jSCallback, MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562112554")) {
            ipChange.ipc$dispatch("562112554", new Object[]{this, jSCallback, mtopResponse});
        } else if (jSCallback != null && mtopResponse != null) {
            try {
                DMMtopErrorHelper.instance().setIsShowLoginUI(true).error(mtopResponse);
                jSCallback.invoke(invokeData(mtopResponse));
                xflush(mtopResponse.getApi(), mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            } catch (Exception unused) {
                jSCallback.invoke(invokeData(mtopResponse));
                String api2 = mtopResponse.getApi();
                xflush(api2, "接口请求 " + mtopResponse.getRetCode(), mtopResponse.getDataJsonObject() != null ? mtopResponse.getDataJsonObject().toString() : "接口返回数据为null");
            }
        }
    }

    private static String failArg(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799285277")) {
            return (String) ipChange.ipc$dispatch("799285277", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("live_weex");
        sb.append(":jsondata={");
        if (!TextUtils.isEmpty(str)) {
            sb.append(" api:" + str);
        }
        if (!TextUtils.isEmpty(d20.E())) {
            sb.append(", userCode:" + d20.E());
        }
        if (!TextUtils.isEmpty(d20.i())) {
            sb.append(", havanaId:" + d20.i());
        }
        if (!TextUtils.isEmpty(d20.H())) {
            sb.append(", youkuUserId:" + d20.H());
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName:" + str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode:" + str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg:" + str4);
        }
        sb.append(" }");
        return sb.toString();
    }

    private Map<String, String> getHeaderMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1565636765")) {
            return m6.b();
        }
        return (Map) ipChange.ipc$dispatch("1565636765", new Object[]{this});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject invokeData(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155459716")) {
            return (JSONObject) ipChange.ipc$dispatch("1155459716", new Object[]{this, mtopResponse});
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("v", (Object) mtopResponse.getV());
        jSONObject.put("api", (Object) mtopResponse.getApi());
        jSONObject.put("code", (Object) Integer.valueOf(mtopResponse.getResponseCode()));
        jSONObject.put("ret", (Object) Arrays.asList(mtopResponse.getRetCode() + "::" + mtopResponse.getRetMsg()));
        if (mtopResponse.getDataJsonObject() != null) {
            jSONObject.put("data", (Object) JSON.parseObject(mtopResponse.getDataJsonObject().toString()));
        }
        return jSONObject;
    }

    private void mtopRequest(JSONObject jSONObject, final JSCallback jSCallback, final JSCallback jSCallback2, String str) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1017992840")) {
            ipChange.ipc$dispatch("-1017992840", new Object[]{this, jSONObject, jSCallback, jSCallback2, str});
            return;
        }
        if (jSONObject != null) {
            if (jSONObject.containsKey("api")) {
                this.api = jSONObject.getString("api");
                this.apiVersion = jSONObject.containsKey("v") ? jSONObject.getString("v") : jl1.MUL;
                JSONObject jSONObject2 = (!jSONObject.containsKey("data") || jSONObject.getJSONObject("data") == null) ? null : jSONObject.getJSONObject("data");
                HashMap hashMap = new HashMap();
                if (!(jSONObject2 == null || (keySet = jSONObject2.keySet()) == null)) {
                    for (String str2 : keySet) {
                        hashMap.put(str2, jSONObject2.getString(str2));
                    }
                }
                this.params = a20.b().c(this.api, hashMap);
                String string = jSONObject.getString("type");
                if ("GET".equalsIgnoreCase(string) || "POST".equalsIgnoreCase(string)) {
                    this.isPost = "POST".equalsIgnoreCase(string);
                } else {
                    Object obj = jSONObject.get(gl1.TYPE_OPEN_URL_METHOD_POST);
                    if (obj instanceof Boolean) {
                        this.isPost = ((Boolean) obj).booleanValue();
                    } else {
                        this.isPost = false;
                    }
                }
                if (jSONObject.containsKey(MtopJSBridge.MtopJSParam.NEED_LOGIN)) {
                    this.needLogin = jSONObject.getBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN).booleanValue();
                } else if (jSONObject.containsKey("loginRequest")) {
                    this.needLogin = jSONObject.getBoolean("loginRequest").booleanValue();
                } else {
                    if (!jSONObject.containsKey("ecode") || jSONObject.getInteger("ecode").intValue() == 0) {
                        z = false;
                    }
                    this.needLogin = z;
                }
            } else {
                jSCallback2.invoke("请问为返回api");
                return;
            }
        }
        MtopRequest mtopRequest = new MtopRequest();
        buildMtopRequest(mtopRequest, this.api, this.apiVersion, this.needLogin, this.params);
        MtopBusiness build = MtopBusiness.build(Mtop.instance(str, xs0.a(), AppConfig.p()).registerTtid(AppConfig.p()), mtopRequest);
        Map<String, String> c = a20.b().c(this.api, null);
        for (String str3 : c.keySet()) {
            build.addHttpQueryParameter(str3, c.get(str3));
        }
        if (d20.t()) {
            Map<String, String> headerMap = getHeaderMap();
            headerMap.put("EagleEye-UserData", "scm_project=" + d20.s());
            build.headers(headerMap);
        } else {
            build.headers(getHeaderMap());
        }
        if (!this.isPost) {
            build.reqMethod(MethodEnum.GET);
        } else {
            build.reqMethod(MethodEnum.POST);
        }
        build.registerListener((IRemoteListener) new IRemoteBaseListener() {
            /* class cn.damai.live.weex.DMWXMtopModule.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "118028209")) {
                    ipChange.ipc$dispatch("118028209", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    return;
                }
                DMWXMtopModule.this.fail(jSCallback2, mtopResponse);
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                JSCallback jSCallback;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1972458330")) {
                    ipChange.ipc$dispatch("-1972458330", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                    return;
                }
                try {
                    if (jSCallback != null && mtopResponse != null && mtopResponse.getDataJsonObject() != null && (jSCallback = jSCallback) != null) {
                        jSCallback.invoke(DMWXMtopModule.this.invokeData(mtopResponse));
                    }
                } catch (Exception unused) {
                    JSCallback jSCallback2 = jSCallback2;
                    if (jSCallback2 != null && mtopResponse != null) {
                        jSCallback2.invoke(DMWXMtopModule.this.invokeData(mtopResponse));
                        DMWXMtopModule dMWXMtopModule = DMWXMtopModule.this;
                        String api = mtopResponse.getApi();
                        dMWXMtopModule.xflush(api, "接口请求 " + mtopResponse.getRetCode(), mtopResponse.getDataJsonObject() != null ? mtopResponse.getDataJsonObject().toString() : "接口返回数据为null");
                    }
                }
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-806111166")) {
                    ipChange.ipc$dispatch("-806111166", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    return;
                }
                DMWXMtopModule.this.fail(jSCallback2, mtopResponse);
            }
        });
        build.startRequest();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void xflush(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693820403")) {
            ipChange.ipc$dispatch("693820403", new Object[]{this, str, str2, str3});
            return;
        }
        yz2.a(failArg("直播weex页面接口", str, str2, str3, ""), "-9000", "直播weex页面接口");
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097465572")) {
            ipChange.ipc$dispatch("-2097465572", new Object[]{this});
            return;
        }
        this.mMtopRequest = null;
        this.mMtopBusiness = null;
        this.mNetCallback = null;
        this.mActivity = null;
    }

    @Override // com.taobao.weex.common.Destroyable, com.alibaba.aliweex.adapter.module.mtop.WXMtopModule
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921132367")) {
            ipChange.ipc$dispatch("921132367", new Object[]{this});
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.mtop.WXMtopModule
    @JSMethod
    public void request(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455958550")) {
            ipChange.ipc$dispatch("1455958550", new Object[]{this, jSONObject, jSCallback, jSCallback2});
        } else if (jSONObject == null || !jSONObject.containsKey("instanceType") || !jSONObject.getString("instanceType").contains("damai")) {
            mtopRequest(jSONObject, jSCallback, jSCallback2, "havana-instance-youku");
        } else {
            mtopRequest(jSONObject, jSCallback, jSCallback2, "INNER");
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.mtop.WXMtopModule
    @JSMethod
    public void send(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377661755")) {
            ipChange.ipc$dispatch("-1377661755", new Object[]{this, str, jSCallback});
        } else if (str != null) {
            JSONObject parseObject = JSON.parseObject(str);
            if (!parseObject.containsKey("instanceType") || !parseObject.getString("instanceType").contains("damai")) {
                mtopRequest(parseObject, jSCallback, null, "havana-instance-youku");
            } else {
                mtopRequest(parseObject, jSCallback, null, "INNER");
            }
        }
    }
}
