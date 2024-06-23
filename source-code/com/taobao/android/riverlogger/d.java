package com.taobao.android.riverlogger;

import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
class d implements RVLLogInterface {
    public final boolean a = true;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[RVLLevel.values().length];
            a = iArr;
            iArr[RVLLevel.Error.ordinal()] = 1;
            a[RVLLevel.Warn.ordinal()] = 2;
            a[RVLLevel.Info.ordinal()] = 3;
            try {
                a[RVLLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public void log(c cVar) {
        int i = a.a[cVar.a.ordinal()];
        if (i == 1) {
            String str = cVar.b;
            TLog.loge(str, str, cVar.a());
        } else if (i == 2) {
            String str2 = cVar.b;
            TLog.logw(str2, str2, cVar.a());
        } else if (i == 3) {
            String str3 = cVar.b;
            TLog.logi(str3, str3, cVar.a());
        } else if (i != 4) {
            String str4 = cVar.b;
            TLog.logv(str4, str4, cVar.a());
        } else {
            String str5 = cVar.b;
            TLog.logd(str5, str5, cVar.a());
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        return RVLLevel.Verbose;
    }
}
