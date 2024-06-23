package cn.damai.fluttercommon.plugin.mtop;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.youku.live.livesdk.preloader.Preloader;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.mtop.domain.JsonTypeEnum;
import tb.g91;
import tb.gl1;
import tb.im0;
import tb.xk2;
import tb.yz2;
import tb.zp;

/* compiled from: Taobao */
public class MtopPlugin extends zp implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String d = "cn.movieshow.app/Mtop";
    private ConcurrentHashMap<String, im0> c = new ConcurrentHashMap<>();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(String str, String str2, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669887642")) {
            ipChange.ipc$dispatch("-669887642", new Object[]{this, str, str2, map});
            return;
        }
        HashMap hashMap = new HashMap();
        map.put("code", Boolean.FALSE);
        hashMap.put("errorMsg", str2);
        hashMap.put("errorCode", str);
        map.put("extra", hashMap);
    }

    private void f(final MethodChannel.Result result, final MethodCall methodCall, final String str, final String str2, Map<String, String> map, boolean z, String str3, final String str4, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134683527")) {
            ipChange.ipc$dispatch("1134683527", new Object[]{this, result, methodCall, str, str2, map, Boolean.valueOf(z), str3, str4, Boolean.valueOf(z2)});
            return;
        }
        FlutterRequest flutterRequest = new FlutterRequest();
        flutterRequest.API_NAME = str;
        flutterRequest.NEED_ECODE = z;
        flutterRequest.VERSION = str2;
        flutterRequest.params = map;
        flutterRequest.method = str3;
        flutterRequest.showLoginUI(z2);
        if (TextUtils.isEmpty(str4)) {
            flutterRequest.setJsonType(JsonTypeEnum.JSON);
        } else if (Preloader.KEY_JSON.equals(str4) || "originaljson".equals(str4)) {
            flutterRequest.setJsonType(JsonTypeEnum.valueOf(str4.toUpperCase()));
        } else {
            flutterRequest.setJsonType(JsonTypeEnum.JSON);
        }
        final HashMap hashMap = new HashMap();
        flutterRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.fluttercommon.plugin.mtop.MtopPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "307236810")) {
                    ipChange.ipc$dispatch("307236810", new Object[]{this, str, str2});
                    return;
                }
                MtopPlugin.this.e(str, str2, hashMap);
                g91.c("mtop", "onFail 失败huidddd " + methodCall.arguments);
                if (!"FAIL_SYS_SESSION_EXPIRED".equals(str) || !this.isShowLoginUI) {
                    result.success(hashMap);
                } else if (!MtopPlugin.this.c.containsKey(str)) {
                    im0 im0 = new im0();
                    im0.a = methodCall;
                    im0.b = result;
                    MtopPlugin.this.c.put(str, im0);
                }
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1904411933")) {
                    ipChange.ipc$dispatch("1904411933", new Object[]{this, str});
                    return;
                }
                hashMap.put("code", Boolean.TRUE);
                Map parseObject = JSON.parseObject(str);
                if ("originaljson".equals(str4)) {
                    parseObject = (Map) JSON.parseObject(str, JSONObject.class, JSON.DEFAULT_PARSER_FEATURE & (~Feature.UseBigDecimal.mask), new Feature[0]);
                }
                hashMap.put("data", parseObject);
                try {
                    result.success(hashMap);
                } catch (Exception e) {
                    g91.c("mtop", "onSuccess 回调失败" + xk2.a(e));
                    yz2.a(yz2.i("flutter网络请求", str + "-" + str2, "", "onSuccess 回调失败", str), "-71001", e.getMessage() + " trace=" + xk2.a(e));
                }
            }
        });
    }

    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1804924750")) {
            return d;
        }
        return (String) ipChange.ipc$dispatch("-1804924750", new Object[]{this});
    }

    @Override // tb.zp, io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241039651")) {
            ipChange.ipc$dispatch("-1241039651", new Object[]{this, activityPluginBinding});
            return;
        }
        super.onAttachedToActivity(activityPluginBinding);
        LoginManager.k().c(this);
    }

    @Override // tb.zp, io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956220292")) {
            ipChange.ipc$dispatch("-1956220292", new Object[]{this});
            return;
        }
        super.onDetachedFromActivity();
        LoginManager.k().C(this);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366022336")) {
            ipChange.ipc$dispatch("1366022336", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215333668")) {
            ipChange.ipc$dispatch("-1215333668", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071039277")) {
            ipChange.ipc$dispatch("1071039277", new Object[]{this});
            return;
        }
        for (Map.Entry<String, im0> entry : this.c.entrySet()) {
            im0 value = entry.getValue();
            onMethodCall(value.a, value.b);
            this.c.remove(entry.getKey());
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695315325")) {
            ipChange.ipc$dispatch("1695315325", new Object[]{this});
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1401935448")) {
            ipChange.ipc$dispatch("-1401935448", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("fetchRequest")) {
            Map map = (Map) methodCall.arguments;
            if (map.containsKey("apiName")) {
                f(result, methodCall, (String) map.get("apiName"), map.containsKey("apiVersion") ? (String) map.get("apiVersion") : "1.0", map.containsKey(PushConstants.PARAMS) ? (Map) map.get(PushConstants.PARAMS) : null, map.containsKey("enableLogin") ? ((Boolean) map.get("enableLogin")).booleanValue() : false, map.containsKey("method") ? (String) map.get("method") : gl1.TYPE_OPEN_URL_METHOD_GET, map.containsKey(MtopJSBridge.MtopJSParam.DATA_TYPE) ? (String) map.get(MtopJSBridge.MtopJSParam.DATA_TYPE) : Preloader.KEY_JSON, map.containsKey("enableLogin") ? ((Boolean) map.get("enableLogin")).booleanValue() : true);
                return;
            }
            HashMap hashMap = new HashMap();
            e("apiName", "apiName不能为null", hashMap);
            result.success(hashMap);
        } else if (!str.equals("getEnv")) {
            result.notImplemented();
        } else {
            try {
                i = AppConfig.g().ordinal();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            result.success(Integer.valueOf(i));
        }
    }
}
