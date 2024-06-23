package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;
import tb.jl1;

/* compiled from: Taobao */
public final class eu {
    private static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static a f318a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f319a = XMJobService.class.getCanonicalName();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m464a();
    }

    public static synchronized void a() {
        synchronized (eu.class) {
            if (f318a != null) {
                b.m182a("[Alarm] stop alarm.");
                f318a.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r7.equals(com.xiaomi.push.v.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    public static void a(Context context) {
        ev evVar;
        Exception e;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            evVar = new ev(applicationContext);
        } else {
            int i = 0;
            try {
                ServiceInfo[] serviceInfoArr = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    int length = serviceInfoArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        try {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                String str = f319a;
                                if (!str.equals(serviceInfo.name)) {
                                }
                                i2 = 1;
                                if (i2 == 1) {
                                    break;
                                }
                            }
                            if (f319a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                i = 1;
                                break;
                            }
                            i++;
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            b.m182a("check service err : " + e.getMessage());
                            if (i == 0) {
                            }
                            int i3 = Build.VERSION.SDK_INT;
                            evVar = new ev(applicationContext);
                            f318a = evVar;
                        }
                    }
                    i = i2;
                }
            } catch (Exception e3) {
                e = e3;
                b.m182a("check service err : " + e.getMessage());
                if (i == 0) {
                }
                int i32 = Build.VERSION.SDK_INT;
                evVar = new ev(applicationContext);
                f318a = evVar;
            }
            if (i == 0 || !v.m882a(applicationContext)) {
                int i322 = Build.VERSION.SDK_INT;
                evVar = new ev(applicationContext);
            } else {
                throw new RuntimeException("Should export service: " + f319a + " with permission " + "android.permission.BIND_JOB_SERVICE" + " in AndroidManifest.xml file");
            }
        }
        f318a = evVar;
    }

    public static synchronized void a(Context context, int i) {
        synchronized (eu.class) {
            int i2 = a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    a = 2;
                } else {
                    a = 0;
                }
            }
            int i3 = a;
            if (i2 != i3 && i3 == 2) {
                a();
                f318a = new ex(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (eu.class) {
            if (f318a == null) {
                b.m182a("timer is not initialized");
                return;
            }
            b.m182a("[Alarm] register alarm. (" + z + jl1.BRACKET_END_STR);
            f318a.a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m463a() {
        synchronized (eu.class) {
            a aVar = f318a;
            if (aVar == null) {
                return false;
            }
            return aVar.m464a();
        }
    }
}
