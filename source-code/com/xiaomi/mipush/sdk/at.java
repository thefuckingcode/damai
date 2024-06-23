package com.xiaomi.mipush.sdk;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class at {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
    static {
        int[] iArr = new int[au.values().length];
        a = iArr;
        iArr[au.DISABLE_PUSH.ordinal()] = 1;
        a[au.ENABLE_PUSH.ordinal()] = 2;
        a[au.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
        a[au.UPLOAD_FCM_TOKEN.ordinal()] = 4;
        a[au.UPLOAD_COS_TOKEN.ordinal()] = 5;
        try {
            a[au.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
    }
}
