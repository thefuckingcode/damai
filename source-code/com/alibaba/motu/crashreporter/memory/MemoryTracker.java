package com.alibaba.motu.crashreporter.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

@TargetApi(14)
/* compiled from: Taobao */
public class MemoryTracker {
    private MemoryTracker() {
    }

    public static Debug.MemoryInfo getRealTimeStatus(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) == null || processMemoryInfo.length <= 0) {
                return null;
            }
            return processMemoryInfo[0];
        } catch (Exception unused) {
            return null;
        }
    }
}
