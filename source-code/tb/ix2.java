package tb;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.adapter.adapter.IFeedBackCallBack;
import com.alibaba.fastjson.JSON;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.arch.v3.event.Subject;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class ix2 implements IWXJSExceptionAdapter {
    public static String a() {
        try {
            Application b = a.l().b();
            if (b == null) {
                return "";
            }
            return b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            WXLogUtils.e("WXExceptionAdapter getAppVersionName Exception: ", e);
            return "";
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        double d = 100.0d;
        double random = Math.random() * 100.0d;
        if ("weex_native_error".equals(str)) {
            String a = a();
            if (TextUtils.isEmpty(a) || a.split(".").length == 3) {
                d = 10.0d;
            }
        }
        IConfigAdapter c = a.l().c();
        if (c != null) {
            try {
                d = Double.valueOf(c.getConfig(kx2.WXAPM_CONFIG_GROUP, str, String.valueOf(d))).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (random < d) {
            return true;
        }
        return false;
    }

    @Override // com.taobao.weex.adapter.IWXJSExceptionAdapter
    public void onJSException(WXJSExceptionInfo wXJSExceptionInfo) {
        Map<String, Object> map;
        IGodEyeStageAdapter h;
        WXSDKInstance wXSDKInstance;
        Map<String, String> containerInfo;
        String str;
        if (wXJSExceptionInfo == null) {
            Log.e("WXJSExceptionAdapter", "null == exception");
            return;
        }
        try {
            Log.i("weex js err", "js err start");
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            WXErrorCode errCode = wXJSExceptionInfo.getErrCode();
            if (errCode.getErrorGroup() == WXErrorCode.ErrorGroup.NATIVE && errCode.getErrorType() == WXErrorCode.ErrorType.NATIVE_ERROR) {
                bizErrorModule.businessType = "weex_native_error";
                bizErrorModule.exceptionCode = errCode.getErrorCode();
            } else {
                bizErrorModule.businessType = "WEEX_ERROR";
                String bundleUrl = wXJSExceptionInfo.getBundleUrl();
                if (bundleUrl != null) {
                    String b = tx2.b(bundleUrl, true);
                    if (b.length() > 1024) {
                        b = b.substring(0, 1024);
                    }
                    bizErrorModule.exceptionCode = b;
                } else {
                    Log.i("weex js err", "bundle url is null");
                }
            }
            if (b(bizErrorModule.businessType)) {
                bizErrorModule.exceptionDetail = wXJSExceptionInfo.getBundleUrl();
                bizErrorModule.exceptionId = errCode.getErrorCode();
                String weexVersion = wXJSExceptionInfo.getWeexVersion();
                if (weexVersion != null) {
                    bizErrorModule.exceptionVersion = weexVersion;
                }
                String exception = wXJSExceptionInfo.getException();
                if (exception != null) {
                    int indexOf = exception.indexOf(StringUtils.LF);
                    bizErrorModule.exceptionArg1 = indexOf > 0 ? exception.substring(0, indexOf) : exception;
                    bizErrorModule.exceptionArg3 = exception + "\nend_weex_stack\n";
                }
                String function = wXJSExceptionInfo.getFunction();
                if (function != null) {
                    bizErrorModule.exceptionArg2 = function;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errorCode", errCode.getErrorCode());
                hashMap.put("errorGroup", errCode.getErrorGroup());
                hashMap.put("errorType", errCode.getErrorType());
                WXSDKInstance y = WXSDKManager.v().y(wXJSExceptionInfo.getInstanceId());
                if (y != null && errCode.getErrorGroup() == WXErrorCode.ErrorGroup.JS) {
                    String str2 = y.getWXPerformance().pageName;
                    hashMap.put("wxBundlePageName", str2 == null ? "unKnowPageNameCaseUnSet" : str2);
                    if (y.getContext() instanceof IFeedBackCallBack) {
                        IFeedBackCallBack iFeedBackCallBack = (IFeedBackCallBack) y.getContext();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("useWeex", Boolean.TRUE);
                        hashMap2.put("infoType", bizErrorModule.businessType);
                        if (exception != null) {
                            int i = 200;
                            if (exception.length() <= 200) {
                                i = exception.length();
                            }
                            hashMap2.put("shortErrorMsg", exception.substring(0, i));
                        }
                        hashMap2.put("weexRealPageName", str2);
                        try {
                            iFeedBackCallBack.addFeedCallBackInfo(bizErrorModule.businessType, JSON.toJSONString(hashMap2));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                String instanceId = wXJSExceptionInfo.getInstanceId();
                if (instanceId != null) {
                    hashMap.put("instanceId", instanceId);
                } else {
                    hashMap.put("instanceId", "no instanceId");
                }
                String jsFrameworkVersion = wXJSExceptionInfo.getJsFrameworkVersion();
                if (jsFrameworkVersion != null) {
                    hashMap.put("frameWorkVersion", jsFrameworkVersion);
                } else {
                    hashMap.put("frameWorkVersion", "no framework version");
                }
                Map<String, String> extParams = wXJSExceptionInfo.getExtParams();
                if (extParams != null && extParams.size() > 0) {
                    hashMap.putAll(extParams);
                    if (!TextUtils.isEmpty(extParams.get("wxGreyBundle"))) {
                        bizErrorModule.exceptionId = extParams.get("wxGreyBundle");
                    }
                }
                try {
                    if (!(TextUtils.isEmpty(instanceId) || (wXSDKInstance = WXSDKManager.v().i().get(instanceId)) == null || (containerInfo = wXSDKInstance.getContainerInfo()) == null || !containerInfo.containsKey(AliWXSDKEngine.f) || (str = containerInfo.get(AliWXSDKEngine.f)) == null)) {
                        hashMap.put(AliWXSDKEngine.f, str);
                    }
                } catch (Throwable unused) {
                }
                bizErrorModule.exceptionArgs = hashMap;
                if (!(!b("god_eye_stage_data") || errCode == WXErrorCode.WX_ERROR_WHITE_SCREEN || (h = a.l().h()) == null)) {
                    h.onException("exception_weex_check", bizErrorModule.exceptionArg1, hashMap);
                }
                bizErrorModule.thread = Thread.currentThread();
                BizErrorReporter.getInstance().send(a.l().b(), bizErrorModule);
                Log.i("weex js err", "js err end");
                if (errCode.getErrorGroup() == WXErrorCode.ErrorGroup.JS && y != null) {
                    try {
                        map = JSON.parseObject(JSON.toJSONString(wXJSExceptionInfo));
                    } catch (Exception unused2) {
                        map = new HashMap<>();
                        map.put("bundleUrl", wXJSExceptionInfo.getBundleUrl());
                        map.put("errorCode", wXJSExceptionInfo.getErrCode());
                        map.put("exception", wXJSExceptionInfo.getException());
                        map.put("extParams", wXJSExceptionInfo.getExtParams());
                        map.put(Subject.FUNCTION, wXJSExceptionInfo.getFunction());
                        map.put("instanceId", wXJSExceptionInfo.getInstanceId());
                        map.put("jsFrameworkVersion", wXJSExceptionInfo.getJsFrameworkVersion());
                        map.put("weexVersion", wXJSExceptionInfo.getWeexVersion());
                    }
                    y.fireGlobalEventCallback("exception", map);
                }
            }
        } catch (Exception e) {
            Log.e("weex js err", "build weex callback data err", e);
        }
    }
}
