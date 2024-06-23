package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.af;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class ai {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
    static {
        int[] iArr = new int[af.a.values().length];
        a = iArr;
        iArr[af.a.INIT_START.ordinal()] = 1;
        a[af.a.BUSINESS_INIT_START.ordinal()] = 2;
        a[af.a.CORE_DEX_LOADED.ordinal()] = 3;
        a[af.a.CORE_LIBRARY_LOADED.ordinal()] = 4;
        a[af.a.CORE_ENGINE_INITED.ordinal()] = 5;
        a[af.a.INIT_FINISHED.ordinal()] = 6;
        a[af.a.INIT_EXCEPTION.ordinal()] = 7;
        a[af.a.INIT_MULTI_CRASHED.ordinal()] = 8;
    }
}
