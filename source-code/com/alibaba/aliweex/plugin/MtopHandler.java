package com.alibaba.aliweex.plugin;

import com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.util.ReflectUtil;
import org.json.JSONException;
import org.json.JSONObject;
import tb.gl1;
import tb.jl1;
import tb.kx2;

/* compiled from: Taobao */
public class MtopHandler {

    /* compiled from: Taobao */
    public interface MtopFinshCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public String b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public String g;
        public int h;
        private Map<String, String> i;

        private a() {
            this.i = new HashMap();
        }

        public void a(String str, String str2) {
            this.i.put(str, str2);
        }

        public Map<String, String> b() {
            return this.i;
        }
    }

    private static RemoteBusiness a(MtopRequest mtopRequest, a aVar) {
        RemoteBusiness build = RemoteBusiness.build(mtopRequest, aVar.g);
        if (aVar.f) {
            build.protocol(ProtocolEnum.HTTPSECURE);
        } else {
            build.protocol(ProtocolEnum.HTTP);
        }
        if ("true".equals(kx2.j().h(kx2.j().m))) {
            build.useCache();
        }
        int i = aVar.h;
        if (i > 0) {
            build.setConnectionTimeoutMilliSecond(i);
        }
        if (aVar.e) {
            build.useWua();
        }
        build.reqMethod(aVar.c ? MethodEnum.POST : MethodEnum.GET);
        return build;
    }

    private static MtopRequest b(a aVar) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(aVar.a);
        mtopRequest.setVersion(aVar.b);
        mtopRequest.setNeedEcode(aVar.d);
        Map<String, String> b = aVar.b();
        mtopRequest.dataParams = b;
        mtopRequest.setData(ReflectUtil.converMapToDataStr(b));
        return mtopRequest;
    }

    private static a c(String str) {
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.a = jSONObject.getString("api");
            aVar.b = jSONObject.optString("v", jl1.MUL);
            boolean z = false;
            aVar.c = jSONObject.optInt(gl1.TYPE_OPEN_URL_METHOD_POST, 0) != 0;
            aVar.d = jSONObject.optInt("ecode", 0) != 0;
            aVar.e = jSONObject.optInt("isSec", 1) != 0;
            if (jSONObject.optInt("isHttps", 0) != 0) {
                z = true;
            }
            aVar.f = z;
            aVar.g = jSONObject.optString("ttid");
            aVar.h = jSONObject.optInt("timer", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("param");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    aVar.a(next, optJSONObject.getString(next));
                }
            }
            return aVar;
        } catch (JSONException unused) {
            WXLogUtils.e("parseParams error, param=" + str);
            return null;
        }
    }

    public static void d(String str, final MtopFinshCallback mtopFinshCallback) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("sendMtop >>> " + str);
        }
        if (mtopFinshCallback != null) {
            a c = c(str);
            if (c == null) {
                mtopFinshCallback.onError(WXMtopRequest.MSG_PARAM_ERR);
            } else {
                a(b(c), c).registeListener((IRemoteListener) new IRemoteBaseListener() {
                    /* class com.alibaba.aliweex.plugin.MtopHandler.AnonymousClass1 */

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onError(int i, MtopResponse mtopResponse, Object obj) {
                        mtopFinshCallback.onError("MSG_FAILED");
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                        try {
                            mtopFinshCallback.onSuccess(mtopResponse.getBytedata() == null ? "{}" : new String(mtopResponse.getBytedata()));
                        } catch (Exception e) {
                            mtopFinshCallback.onError(e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                        mtopFinshCallback.onError("MSG_FAILED");
                    }
                }).startRequest();
            }
        }
    }
}
