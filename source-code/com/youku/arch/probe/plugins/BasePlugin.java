package com.youku.arch.probe.plugins;

import android.content.Context;

/* compiled from: Taobao */
public abstract class BasePlugin {
    public static String a = "BasePlugin";
    protected Context b;
    private boolean c;
    private volatile a d;

    /* renamed from: com.youku.arch.probe.plugins.BasePlugin$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[NotiType.values().length];
            a = iArr;
            iArr[NotiType.IDLE.ordinal()] = 1;
            a[NotiType.ONCE.ordinal()] = 2;
            a[NotiType.LOOP.ordinal()] = 3;
            try {
                a[NotiType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    protected enum NotiType {
        IDLE,
        ONCE,
        LOOP,
        CANCEL
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        public NotiType a;
        public long b;
    }

    public abstract com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar);

    public abstract void a();

    public abstract void a(NotiType notiType);
}
