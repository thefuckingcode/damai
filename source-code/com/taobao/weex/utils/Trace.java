package com.taobao.weex.utils;

import android.annotation.TargetApi;
import android.util.Log;

/* compiled from: Taobao */
public class Trace {
    private static final AbstractTrace a = new TraceDummy();
    private static final boolean b = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class AbstractTrace {
        private AbstractTrace() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(String str);

        /* access modifiers changed from: package-private */
        public abstract void b();
    }

    /* compiled from: Taobao */
    private static final class TraceDummy extends AbstractTrace {
        private TraceDummy() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        public void a(String str) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        public void b() {
        }
    }

    @TargetApi(18)
    /* compiled from: Taobao */
    private static final class TraceJBMR2 extends AbstractTrace {
        private TraceJBMR2() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        public void a(String str) {
            android.os.Trace.beginSection(str);
        }

        /* access modifiers changed from: package-private */
        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        public void b() {
            android.os.Trace.endSection();
        }
    }

    public static void beginSection(String str) {
        Log.i("Weex_Trace", "beginSection() " + str);
        a.a(str);
    }

    public static void endSection() {
        a.b();
        Log.i("Weex_Trace", "endSection()");
    }

    public static final boolean getTraceEnabled() {
        return b;
    }
}
