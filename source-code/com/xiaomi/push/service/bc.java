package com.xiaomi.push.service;

import com.xiaomi.push.hp;
import com.xiaomi.push.hq;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class bc {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
    static {
        int[] iArr = new int[hq.values().length];
        b = iArr;
        try {
            iArr[hq.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        b[hq.LONG.ordinal()] = 2;
        b[hq.STRING.ordinal()] = 3;
        try {
            b[hq.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[hp.values().length];
        a = iArr2;
        iArr2[hp.MISC_CONFIG.ordinal()] = 1;
        a[hp.PLUGIN_CONFIG.ordinal()] = 2;
    }
}
