package com.xiaomi.push;

import com.xiaomi.push.service.bg;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class fe {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    static {
        int[] iArr = new int[bg.c.values().length];
        a = iArr;
        iArr[bg.c.unbind.ordinal()] = 1;
        a[bg.c.binding.ordinal()] = 2;
        try {
            a[bg.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
    }
}
