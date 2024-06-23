package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.huawei.hms.api.ConnectionResult;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.uc.startup.a;
import com.uc.webview.export.internal.utility.e;
import com.uc.webview.export.internal.utility.p;
import java.util.HashMap;

/* compiled from: Taobao */
public final class i extends a {
    public i() {
        this.a = "InitCoreEngineJob";
        this.b = new Pair<>(261, 262);
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.internal.setup.a
    public final void a() {
        String str;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        bt btVar = af.c;
        int i = 0;
        if (btVar != null) {
            hashMap.put("ucm_corelib_path", btVar.soDirPath);
            hashMap.put("ucm_paks_resource_dir", btVar.resDirPath);
            Pair<String, String> pair = btVar.coreImplModule;
            if (pair != null) {
                hashMap.put("ucm_dex_path", pair.first);
                hashMap.put("ucm_odex_path", btVar.coreImplModule.second);
            }
            String str4 = (String) af.a(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
            if (str4 != null) {
                hashMap.put("ucm_private_data_dir_suffix", str4);
            }
            String str5 = "1";
            hashMap.put(UCCore.OPTION_DISABLE_CRITICAL_MEMORY_PRESSURE, p.b(af.a(UCCore.OPTION_DISABLE_CRITICAL_MEMORY_PRESSURE)) ? str5 : "0");
            Integer num = (Integer) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS);
            if (num == null) {
                num = 0;
            }
            Integer num2 = (Integer) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_FALLBACK_TIMEOUT);
            if (num2 == null) {
                num2 = 0;
            }
            Boolean bool = (Boolean) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SERVICE_SPEEDUP);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            hashMap.put("ucm_multi_process", String.valueOf(num));
            hashMap.put("ucm_multi_process_fallback_timeout", String.valueOf(num2));
            hashMap.put("ucm_multi_process_enable_service_speedup", String.valueOf(bool));
            if (p.b(af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SECCOMP))) {
                str = str5;
            } else {
                str = "0";
            }
            hashMap.put(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SECCOMP, str);
            Integer num3 = (Integer) af.a(UCCore.OPTION_MULTI_PROCESS_STARTUP_TIMEOUT);
            if (num3 == null) {
                num3 = 0;
            }
            hashMap.put(UCCore.OPTION_MULTI_PROCESS_STARTUP_TIMEOUT, String.valueOf(num3));
            if (p.b(af.a(UCCore.OPTION_MULTI_PROCESS_DISABLE_FALLBACK_TO_SINGLE_PROCESS))) {
                str2 = str5;
            } else {
                str2 = "0";
            }
            hashMap.put(UCCore.OPTION_MULTI_PROCESS_DISABLE_FALLBACK_TO_SINGLE_PROCESS, str2);
            Integer num4 = (Integer) af.a(UCCore.OPTION_GPU_PROCESS_MODE);
            if (num4 != null) {
                i = num4;
            }
            hashMap.put("ucm_gpu_process_mode", String.valueOf(i));
            String str6 = (String) af.a("GpuProcBL");
            if (str6 != null) {
                hashMap.put("GpuProcBL", str6);
            }
            Integer num5 = (Integer) af.a(UCCore.OPTION_GPU_WARM_UP_TIME);
            if (num5 != null) {
                hashMap.put(UCCore.OPTION_GPU_WARM_UP_TIME, String.valueOf(num5));
            } else {
                hashMap.put(UCCore.OPTION_GPU_WARM_UP_TIME, "-1");
            }
            Integer num6 = (Integer) af.a(UCCore.OPTION_GPU_PROC_INIT_TIMEOUT);
            if (num6 != null) {
                hashMap.put(UCCore.OPTION_GPU_PROC_INIT_TIMEOUT, String.valueOf(num6));
            }
            Boolean bool2 = (Boolean) af.a("AloneLauncherThread");
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    str3 = str5;
                } else {
                    str3 = "0";
                }
                hashMap.put("AloneLauncherThread", str3);
            }
            Boolean bool3 = (Boolean) af.a("GPUInfoCache");
            if (bool3 != null) {
                if (!bool3.booleanValue()) {
                    str5 = "0";
                }
                hashMap.put("GPUInfoCache", str5);
            }
            String str7 = (String) af.a("GpuImageViewWL");
            if (str7 != null) {
                hashMap.put("GpuImageViewWL", str7);
            }
            hashMap.put("ucm_skip_init_setting", String.valueOf(!af.b));
            hashMap.put("ucm_is_hardware_ac", String.valueOf(af.e));
            hashMap.put("ucm_sup", String.valueOf(af.a()));
            Object c = e.c(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST);
            if (c == null) {
                c = af.a(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST);
            }
            if (c != null) {
                hashMap.put("ucm_twd_watch_list", String.valueOf(c));
            }
            Object c2 = e.c(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION);
            if (c2 == null) {
                c2 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION);
            }
            if (c2 != null) {
                hashMap.put("ucm_twd_alarm_duration", String.valueOf(c2));
            }
            Object c3 = e.c(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE);
            if (c3 == null) {
                c3 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE);
            }
            if (c3 != null) {
                hashMap.put("ucm_twd_dump_js_rate", String.valueOf(c3));
            }
            Object c4 = e.c(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE);
            if (c4 == null) {
                c4 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE);
            }
            if (c4 != null) {
                hashMap.put("ucm_twd_dump_native_rate", String.valueOf(c4));
            }
        }
        try {
            a.a(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, new Object[]{af.a, hashMap});
            af.a(af.a.CORE_LIBRARY_LOADED, new Object[0]);
        } catch (Throwable th) {
            throw new UCSetupException(3007, th);
        }
    }
}
