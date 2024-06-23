package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public abstract class c<T extends BasicPushStatus> {
    protected final Context a;
    protected String b;
    protected String c;
    protected String d;
    protected final a e;
    protected boolean f = true;
    protected boolean g = true;
    private ScheduledExecutorService h;
    private String i = null;

    public c(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.h = scheduledExecutorService;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.e = aVar;
    }

    private boolean a(int i2) {
        return i2 >= 110000 && i2 <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.g && !this.a.getPackageName().equals(this.i);
    }

    /* access modifiers changed from: protected */
    public String a(Context context, String str) {
        List<ResolveInfo> queryIntentServices;
        String str2 = null;
        if (!TextUtils.isEmpty(str) && (queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0)) != null) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = next.serviceInfo;
                    this.i = serviceInfo.packageName;
                    str2 = serviceInfo.name;
                    break;
                }
            }
            if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                this.i = queryIntentServices.get(0).serviceInfo.packageName;
                str2 = queryIntentServices.get(0).serviceInfo.name;
            }
        }
        DebugLogger.i("Strategy", "current process packageName " + this.i);
        return str2;
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        try {
            intent.setPackage(this.i);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.a.startService(intent);
        } catch (Exception e2) {
            DebugLogger.e("Strategy", "start RemoteService error " + e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    public void a(boolean z) {
        this.f = z;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract T b();

    public void b(String str) {
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public abstract Intent c();

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    /* access modifiers changed from: protected */
    public Intent[] d() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract T e();

    /* access modifiers changed from: protected */
    public abstract T f();

    /* access modifiers changed from: protected */
    public abstract int g();

    /* access modifiers changed from: protected */
    public boolean k() {
        return this.g && this.f && !TextUtils.isEmpty(a(this.a, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.h;
        if (scheduledExecutorService == null) {
            return n();
        }
        scheduledExecutorService.execute(new Runnable() {
            /* class com.meizu.cloud.pushsdk.platform.b.c.AnonymousClass1 */

            public void run() {
                c.this.n();
            }
        });
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public boolean n() {
        T t;
        String str;
        if (!a()) {
            DebugLogger.e("Strategy", "Missing required parameters");
            t = b();
        } else {
            if (!k()) {
                t = e();
                DebugLogger.i("Strategy", "real response status " + t);
                if (t != null) {
                    if (l() && "20000".equals(t.getCode())) {
                        return true;
                    }
                    if (h()) {
                        str = "response all request in local app";
                    } else {
                        String code = t.getCode();
                        if (TextUtils.isEmpty(code)) {
                            code = "0";
                        }
                        if ("200".equals(t.getCode())) {
                            a(t);
                        }
                        int intValue = Integer.valueOf(code).intValue();
                        if (a(intValue)) {
                            str = "service error so notify pushManager invoker code=" + intValue + " message " + t.getMessage();
                        }
                    }
                    DebugLogger.e("Strategy", str);
                }
            } else {
                DebugLogger.i("Strategy", "send message to remote service");
                if (!l()) {
                    t = f();
                    if (t != null) {
                        DebugLogger.e("Strategy", "local response " + t);
                        a(t);
                    }
                } else {
                    t = null;
                }
                Intent c2 = c();
                if (c2 != null) {
                    a(c2);
                }
                Intent[] d2 = d();
                if (d2 != null) {
                    DebugLogger.e("Strategy", "send sendRpcRequests length " + d2.length);
                    for (Intent intent : d2) {
                        a(intent);
                    }
                }
                com.meizu.cloud.pushsdk.a.a(this.a);
            }
            if (t != null) {
                return true;
            }
            DebugLogger.e("Strategy", "current status code " + t.getCode());
            return true ^ b(t);
        }
        a(t);
        if (t != null) {
        }
    }
}
