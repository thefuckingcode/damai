package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class m extends Thread {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public m(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public void run() {
        if (!p.b()) {
            HMSLog.d("ReportAaidToken", "Not HW Phone.");
        } else if (!(n.b(this.a))) {
            String a2 = o.a(this.a);
            if (TextUtils.isEmpty(a2)) {
                HMSLog.w("ReportAaidToken", "AAID is empty.");
            } else if (!(n.d(this.a, a2, this.b))) {
                HMSLog.d("ReportAaidToken", "This time need not report.");
            } else {
                String string = AGConnectServicesConfig.fromContext(this.a).getString(RegistConstants.REGION_INFO);
                if (TextUtils.isEmpty(string)) {
                    HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String a3 = e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, string);
                if (!TextUtils.isEmpty(a3)) {
                    String str = n.c(this.a, a2, this.b);
                    Context context = this.a;
                    n.b(this.a, d.a(context, a3 + "/rest/appdata/v1/aaid/report", str, (Map<String, String>) null), a2, this.b);
                }
            }
        }
    }
}
