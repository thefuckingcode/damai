package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.List;

/* compiled from: Taobao */
public class LinkProxyActivity extends Activity {
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6 A[Catch:{ Exception -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca A[Catch:{ Exception -> 0x00d8 }] */
    public void onCreate(Bundle bundle) {
        PackageManager packageManager;
        List<ResolveInfo> queryIntentServices;
        ServiceInfo serviceInfo;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            p.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
            return;
        }
        boolean z = true;
        try {
            Window window = getWindow();
            window.setGravity(BadgeDrawable.TOP_START);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (Throwable th) {
            p.b("LinkProxyActivity", "enter onCreate error ", th);
        }
        String packageName = getPackageName();
        p.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
        if ("com.vivo.abe".equals(packageName)) {
            try {
                if (intent.getExtras() == null) {
                    p.d("LinkProxyActivity", "adapterToService getExtras() is null");
                } else {
                    Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        p.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                    } else {
                        z.a(this, intent2);
                    }
                }
            } catch (Exception e) {
                p.a("LinkProxyActivity", e.toString(), e);
            }
        } else {
            try {
                if (intent.getExtras() != null) {
                    Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                    if (!(intent3 == null || (packageManager = getPackageManager()) == null || (queryIntentServices = packageManager.queryIntentServices(intent3, 576)) == null)) {
                        if (!queryIntentServices.isEmpty()) {
                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                            if (!(resolveInfo == null || (serviceInfo = resolveInfo.serviceInfo) == null || !serviceInfo.exported)) {
                                if (!z) {
                                    startService(intent3);
                                } else {
                                    p.b("LinkProxyActivity", "service's exported is ".concat(String.valueOf(z)));
                                }
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            } catch (Exception e2) {
                p.a("LinkProxyActivity", e2.toString(), e2);
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
