package com.alipay.camera2.util;

import android.os.Trace;

/* compiled from: Taobao */
public class SystraceWrapper {
    public static boolean sTraceEnable;

    public static void beginTrace(String str) {
        if (sTraceEnable) {
            Trace.beginSection(str);
        }
    }

    public static void endTrace() {
        if (sTraceEnable) {
            Trace.endSection();
        }
    }
}
