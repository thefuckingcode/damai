package com.alibaba.ut.comm;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.alibaba.security.common.track.model.a;
import com.alibaba.ut.IWebView;
import com.taobao.weex.bridge.WXBridgeManager;
import org.json.JSONException;
import org.json.JSONObject;
import tb.gq2;
import tb.iq2;
import tb.jl1;
import tb.lp2;
import tb.ph2;
import tb.q91;

/* compiled from: Taobao */
public class JsBridge {
    private IWebView a = null;

    public JsBridge(IWebView iWebView) {
        this.a = iWebView;
    }

    /* access modifiers changed from: private */
    public static String c(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (window.Aplus4UT && window.");
        sb.append(str);
        sb.append(") { window.");
        sb.append(str);
        sb.append(jl1.BRACKET_START_STR);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'");
                sb.append(strArr[i]);
                sb.append("'");
                if (i < strArr.length - 1) {
                    sb.append(',');
                }
            }
        }
        sb.append(");}");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String d(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jl1.BRACKET_START_STR);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'");
                sb.append(strArr[i]);
                sb.append("'");
                if (i < strArr.length - 1) {
                    sb.append(',');
                }
            }
        }
        sb.append(");");
        return sb.toString();
    }

    private void e(String str, String[] strArr) {
        g(this.a, str, strArr);
    }

    public static void g(final IWebView iWebView, final String str, final String[] strArr) {
        iWebView.post(new Runnable() {
            /* class com.alibaba.ut.comm.JsBridge.AnonymousClass1 */

            @TargetApi(19)
            public void run() {
                String str;
                Throwable th;
                String str2;
                try {
                    if (str.contains("Aplus4UT")) {
                        str2 = JsBridge.c(str, strArr);
                    } else {
                        str2 = JsBridge.d(str, strArr);
                    }
                    try {
                        q91.h("js:", str2);
                        iWebView.evaluateJavascript(str2, null);
                    } catch (Throwable th2) {
                        str = str2;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = null;
                    q91.j(null, th, "native to js", str);
                }
            }
        });
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void CALL(String str) {
        Object obj;
        q91.k("p", str);
        q91.k("wmg_test", str);
        if (TextUtils.isEmpty(str)) {
            q91.k("p", str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("methodName");
            String optString2 = jSONObject.optString("params");
            String optString3 = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK);
            String optString4 = jSONObject.optString("sid");
            String str2 = "0";
            String str3 = "SUCCESS";
            try {
                obj = f(this.a.getContext(), null, optString, optString2);
            } catch (Exception e) {
                str2 = "1";
                str3 = e.toString();
                q91.j(null, e, new Object[0]);
                obj = null;
            }
            if (!TextUtils.isEmpty(optString3)) {
                JSONObject jSONObject2 = new JSONObject();
                if (obj == null) {
                    obj = "";
                }
                jSONObject2.put("result", obj);
                jSONObject2.put("code", str2);
                jSONObject2.put("msg", str3);
                e(optString3, new String[]{optString4, jSONObject2.toString()});
            }
        } catch (JSONException e2) {
            q91.j(null, e2, new Object[0]);
        }
    }

    @JavascriptInterface
    public String UTEnv() {
        IWebView iWebView = this.a;
        if (iWebView == null) {
            return "default";
        }
        if (iWebView instanceof ph2) {
            return a.c.d;
        }
        return iWebView instanceof lp2 ? "ucwebview" : "iwebview";
    }

    @JavascriptInterface
    public String bridgeVersion() {
        return gq2.SDK_VERSION;
    }

    public Object f(Context context, String str, String str2, String str3) throws Exception {
        if (str2.equalsIgnoreCase("pageAppear")) {
            iq2.j(context, str3);
        } else if (str2.equalsIgnoreCase("pageDisAppear")) {
            iq2.k(context, str3);
        } else if (str2.equalsIgnoreCase("updatePageProperties")) {
            iq2.t(context, str3);
            return Boolean.TRUE;
        } else if (str2.equalsIgnoreCase("updatePageUtparam")) {
            iq2.v(context, str3);
        } else if (str2.equalsIgnoreCase("updateNextPageUtparam")) {
            iq2.r(str3);
        } else if (str2.equalsIgnoreCase("updateNextPageProperties")) {
            iq2.q(str3);
        } else if (str2.equalsIgnoreCase("getParam")) {
            return iq2.g();
        } else {
            if (str2.equalsIgnoreCase("getDeviceInfo")) {
                return iq2.d();
            }
            if (str2.equalsIgnoreCase("setAplusParams")) {
                iq2.n(context.hashCode() + "", str3);
            } else if (str2.equalsIgnoreCase("getAplusParams")) {
                return iq2.c(context.hashCode() + "");
            } else if (str2.equalsIgnoreCase("removeAplusParams")) {
                iq2.l(context.hashCode() + "");
            } else if (str2.equalsIgnoreCase("utCustomEvent")) {
                iq2.z(str3);
            } else if (str2.equalsIgnoreCase("getPageSpmUrl")) {
                return iq2.f(context);
            } else {
                if (str2.equalsIgnoreCase("getPageSpmPre")) {
                    return iq2.e(context);
                }
                if (str2.equalsIgnoreCase("updatePageURL")) {
                    iq2.u(context, str3);
                } else if (str2.equalsIgnoreCase("updatePageName")) {
                    iq2.s(context, str3);
                } else if (str2.equalsIgnoreCase("turnOnRealtimeDebug")) {
                    iq2.p(str3);
                } else if (str2.equalsIgnoreCase("userRegister")) {
                    iq2.y(str3);
                } else if (str2.equalsIgnoreCase("updateUserAccount")) {
                    iq2.x(str3);
                } else if (str2.equalsIgnoreCase("addTPKItem")) {
                    iq2.b(str3);
                } else if (str2.equalsIgnoreCase("updateSessionProperties")) {
                    iq2.w(str3);
                } else if (str2.equalsIgnoreCase("setGlobalProperty")) {
                    iq2.o(str3);
                } else if (str2.equalsIgnoreCase("setAplus4UT")) {
                    iq2.m(context);
                }
            }
        }
        return null;
    }

    @JavascriptInterface
    public void onPageShow() {
    }
}
