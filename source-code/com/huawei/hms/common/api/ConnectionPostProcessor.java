package com.huawei.hms.common.api;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public interface ConnectionPostProcessor {
    void run(HuaweiApiClient huaweiApiClient, WeakReference<Activity> weakReference);
}
