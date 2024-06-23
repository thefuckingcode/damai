package com.ali.alihadeviceevaluator.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.live.dsl.config.IDynamicConfig;
import org.json.JSONObject;
import tb.i4;

/* compiled from: Taobao */
public class AliHADeviceEvaluationBridge extends WVApiPlugin {
    private boolean getPerformanceInfo(String str, WVCallBackContext wVCallBackContext) {
        String str2;
        boolean z;
        boolean z2;
        WVResult wVResult = new WVResult();
        try {
            str2 = new JSONObject(str).getString(Constants.Name.FILTER);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = "";
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                z2 = true;
            } else if ("all".equalsIgnoreCase(str2)) {
                z2 = false;
                z = true;
                if (str2.contains(com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE) || z2 || z) {
                    wVResult.addData("deviceLevel", Integer.valueOf(i4.d().f().a + 1));
                    wVResult.addData("deviceLevelEasy", Integer.valueOf(i4.d().f().b + 1));
                    wVResult.addData(IDynamicConfig.KEY_DEVICE_SCORE, Integer.valueOf(i4.d().f().c));
                }
                if (str2.contains("memory") || z) {
                    JSONObject jSONObject = new JSONObject();
                    i4.d e = i4.d().e();
                    jSONObject.put("jvmUsedMemory", e.d);
                    jSONObject.put("jvmTotalMemory", e.c);
                    jSONObject.put("nativeUsedMemory", e.f);
                    jSONObject.put("nativeTotalMemory", e.e);
                    jSONObject.put("deviceUsedMemory", e.b);
                    jSONObject.put("deviceTotalMemory", e.a);
                    jSONObject.put("dalvikPSSMemory", e.g);
                    jSONObject.put("nativePSSMemory", e.h);
                    jSONObject.put("totalPSSMemory", e.i);
                    jSONObject.put("deviceLevel", e.j);
                    jSONObject.put("runtimeLevel", e.k);
                    wVResult.addData("memoryInfo", jSONObject);
                }
                if (str2.contains("cpu") || z) {
                    JSONObject jSONObject2 = new JSONObject();
                    i4.b b = i4.d().b();
                    jSONObject2.put("frequency", (double) b.b);
                    jSONObject2.put("cpuUsageOfApp", (double) b.c);
                    jSONObject2.put("cpuUsageOfDevice", (double) b.d);
                    jSONObject2.put("cpuCoreNum", b.a);
                    jSONObject2.put("deviceLevel", b.f);
                    jSONObject2.put("runtimeLevel", b.g);
                    wVResult.addData("cpuInfo", jSONObject2);
                }
                if (str2.contains("opengl") || z) {
                    wVResult.addData("openGLVersion", i4.d().c().d);
                }
                wVCallBackContext.success(wVResult);
                return true;
            } else {
                z2 = false;
            }
            z = false;
            wVResult.addData("deviceLevel", Integer.valueOf(i4.d().f().a + 1));
            wVResult.addData("deviceLevelEasy", Integer.valueOf(i4.d().f().b + 1));
            wVResult.addData(IDynamicConfig.KEY_DEVICE_SCORE, Integer.valueOf(i4.d().f().c));
            JSONObject jSONObject3 = new JSONObject();
            i4.d e2 = i4.d().e();
            jSONObject3.put("jvmUsedMemory", e2.d);
            jSONObject3.put("jvmTotalMemory", e2.c);
            jSONObject3.put("nativeUsedMemory", e2.f);
            jSONObject3.put("nativeTotalMemory", e2.e);
            jSONObject3.put("deviceUsedMemory", e2.b);
            jSONObject3.put("deviceTotalMemory", e2.a);
            jSONObject3.put("dalvikPSSMemory", e2.g);
            jSONObject3.put("nativePSSMemory", e2.h);
            jSONObject3.put("totalPSSMemory", e2.i);
            jSONObject3.put("deviceLevel", e2.j);
            jSONObject3.put("runtimeLevel", e2.k);
            wVResult.addData("memoryInfo", jSONObject3);
            JSONObject jSONObject22 = new JSONObject();
            i4.b b2 = i4.d().b();
            jSONObject22.put("frequency", (double) b2.b);
            jSONObject22.put("cpuUsageOfApp", (double) b2.c);
            jSONObject22.put("cpuUsageOfDevice", (double) b2.d);
            jSONObject22.put("cpuCoreNum", b2.a);
            jSONObject22.put("deviceLevel", b2.f);
            jSONObject22.put("runtimeLevel", b2.g);
            wVResult.addData("cpuInfo", jSONObject22);
            wVResult.addData("openGLVersion", i4.d().c().d);
            wVCallBackContext.success(wVResult);
            return true;
        } catch (Throwable th2) {
            wVResult.addData("errMsg", th2.getMessage());
            wVCallBackContext.error(wVResult);
            return false;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getPerformanceInfo".equals(str)) {
            return getPerformanceInfo(str2, wVCallBackContext);
        }
        return false;
    }
}
