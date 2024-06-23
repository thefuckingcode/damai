package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hj;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class an {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
    static {
        int[] iArr = new int[hj.values().length];
        a = iArr;
        iArr[hj.SendMessage.ordinal()] = 1;
        a[hj.Registration.ordinal()] = 2;
        a[hj.UnRegistration.ordinal()] = 3;
        a[hj.Subscription.ordinal()] = 4;
        a[hj.UnSubscription.ordinal()] = 5;
        a[hj.Command.ordinal()] = 6;
        try {
            a[hj.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused) {
        }
    }
}
