package com.taobao.android.dinamicx.log;

/* compiled from: Taobao */
public interface IDXRemoteDebugLog {
    void logd(String str, String str2);

    void logd(String str, String str2, String str3);

    void logd(String str, String... strArr);

    void loge(String str, String str2);

    void loge(String str, String str2, String str3);

    void loge(String str, String str2, Throwable th);

    void loge(String str, String... strArr);

    void logi(String str, String str2);

    void logi(String str, String str2, String str3);

    void logi(String str, String... strArr);

    void logv(String str, String str2);

    void logv(String str, String str2, String str3);

    void logv(String str, String... strArr);

    void logw(String str, String str2);

    void logw(String str, String str2, String str3);

    void logw(String str, String str2, Throwable th);

    void logw(String str, String... strArr);
}
