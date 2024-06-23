package com.taobao.analysis.v3;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public final class FalcoGlobalTracer {
    private static FalcoTracer sTracer;

    private FalcoGlobalTracer() {
    }

    public static FalcoTracer get() {
        return sTracer;
    }

    static void setTracerDelegate(FalcoTracer falcoTracer) {
        sTracer = falcoTracer;
    }
}
