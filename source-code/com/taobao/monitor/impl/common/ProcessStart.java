package com.taobao.monitor.impl.common;

import androidx.annotation.Keep;

/* compiled from: Taobao */
public class ProcessStart {
    private static int a;

    public static int a() {
        return a;
    }

    @Keep
    public static void setProcessStartType(int i) {
        a = i;
    }
}
