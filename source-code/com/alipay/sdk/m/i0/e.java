package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class e extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0 == 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            boolean z = false;
            int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
            f.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
            if (intExtra != 1) {
                if (intExtra == 2) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                    if (stringArrayListExtra != null) {
                        z = stringArrayListExtra.contains(context.getPackageName());
                    }
                }
                if (!z) {
                    String stringExtra = intent.getStringExtra("openIdType");
                    f a = f.a();
                    a aVar = IRequestConst.OAID.equals(stringExtra) ? a.b : "vaid".equals(stringExtra) ? a.d : "aaid".equals(stringExtra) ? a.c : "udid".equals(stringExtra) ? a.a : null;
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
                return;
            }
            z = true;
            if (!z) {
            }
        }
    }
}
