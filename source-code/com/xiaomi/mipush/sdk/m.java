package com.xiaomi.mipush.sdk;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class m {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    static {
        int[] iArr = new int[e.values().length];
        a = iArr;
        iArr[e.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
        a[e.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
        a[e.ASSEMBLE_PUSH_COS.ordinal()] = 3;
        try {
            a[e.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
