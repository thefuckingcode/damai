package com.xiaomi.push.service;

import com.xiaomi.push.hj;

/* compiled from: Taobao */
/* synthetic */ class cf {
    static final /* synthetic */ int[] a;

    /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
    static {
        int[] iArr = new int[hj.values().length];
        a = iArr;
        iArr[hj.Registration.ordinal()] = 1;
        a[hj.UnRegistration.ordinal()] = 2;
        a[hj.Subscription.ordinal()] = 3;
        a[hj.UnSubscription.ordinal()] = 4;
        a[hj.SendMessage.ordinal()] = 5;
        a[hj.AckMessage.ordinal()] = 6;
        a[hj.SetConfig.ordinal()] = 7;
        a[hj.ReportFeedback.ordinal()] = 8;
        a[hj.Notification.ordinal()] = 9;
        try {
            a[hj.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused) {
        }
    }
}
