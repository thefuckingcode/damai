package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bj;
import com.xiaomi.push.bo;
import com.xiaomi.push.db;
import com.xiaomi.push.eo;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ip;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.bn;
import com.xiaomi.push.service.i;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class ao {
    private static ao a;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f46a = new ArrayList<>();
    private static boolean b;

    /* renamed from: a  reason: collision with other field name */
    private long f47a;

    /* renamed from: a  reason: collision with other field name */
    private Context f48a;

    /* renamed from: a  reason: collision with other field name */
    private Intent f49a = null;

    /* renamed from: a  reason: collision with other field name */
    private Handler f50a = null;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f51a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f52a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f53a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f54a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f55a = false;
    private boolean c = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a<T extends iu<T, ?>> {
        hj a;

        /* renamed from: a  reason: collision with other field name */
        T f56a;

        /* renamed from: a  reason: collision with other field name */
        boolean f57a;

        a() {
        }
    }

    private ao(Context context) {
        this.f48a = context.getApplicationContext();
        this.f53a = null;
        this.f55a = m206c();
        b = m207d();
        this.f50a = new ap(this, Looper.getMainLooper());
        if (m.m735a(context)) {
            i.a(new aq(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f48a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m204a() {
        return (!m212a() || "com.xiaomi.xmsf".equals(this.f48a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ao a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            if (a == null) {
                a = new ao(context);
            }
            aoVar = a;
        }
        return aoVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m205a() {
        try {
            return this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        ii iiVar;
        String str2;
        if (b.m219a(this.f48a).m226b() && bj.b(this.f48a)) {
            ii iiVar2 = new ii();
            iiVar2.a(true);
            Intent a2 = m204a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                iiVar2.a(str);
                iiVar = z ? new ii(str, true) : null;
                synchronized (af.class) {
                    af.a(this.f48a).m200a(str);
                }
            } else {
                iiVar2.a(str);
                iiVar = z ? new ii(str, true) : null;
            }
            switch (at.a[auVar.ordinal()]) {
                case 1:
                    ht htVar = ht.DisablePushMessage;
                    iiVar2.c(htVar.f497a);
                    iiVar.c(htVar.f497a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        iiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 2:
                    ht htVar2 = ht.EnablePushMessage;
                    iiVar2.c(htVar2.f497a);
                    iiVar.c(htVar2.f497a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        iiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    iiVar2.c(ht.ThirdPartyRegUpdate.f497a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            b.e("type:" + auVar + AVFSCacheConstants.COMMA_SEP + str);
            iiVar2.b(b.m219a(this.f48a).m220a());
            iiVar2.d(this.f48a.getPackageName());
            hj hjVar = hj.Notification;
            a((iu) iiVar2, hjVar, false, (hw) null);
            if (z) {
                iiVar.b(b.m219a(this.f48a).m220a());
                iiVar.d(this.f48a.getPackageName());
                Context context = this.f48a;
                byte[] a3 = it.a(ai.a(context, iiVar, hjVar, false, context.getPackageName(), b.m219a(this.f48a).m220a()));
                if (a3 != null) {
                    db.a(this.f48a.getPackageName(), this.f48a, iiVar, hjVar, a3.length);
                    a2.putExtra("mipush_payload", a3);
                    a2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    a2.putExtra("mipush_app_id", b.m219a(this.f48a).m220a());
                    a2.putExtra("mipush_app_token", b.m219a(this.f48a).b());
                    c(a2);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f50a.sendMessageDelayed(obtain, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f48a.getPackageName())) {
            return c();
        }
        b.c("pushChannel xmsf create own channel");
        return e();
    }

    private void b(Intent intent) {
        try {
            if (m.m734a() || Build.VERSION.SDK_INT < 26) {
                this.f48a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            b.a(e);
        }
    }

    private Intent c() {
        if (m212a()) {
            b.c("pushChannel app start miui china channel");
            return d();
        }
        b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f48a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        ba a2 = ba.a(this.f48a);
        int a3 = ho.ServiceBootMode.a();
        hk hkVar = hk.a;
        int a4 = a2.a(a3, hkVar.a());
        int a5 = a();
        hk hkVar2 = hk.BIND;
        boolean z = a4 == hkVar2.a() && b;
        int a6 = z ? hkVar2.a() : hkVar.a();
        if (a6 != a5) {
            m213a(a6);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m206c() {
        try {
            PackageInfo packageInfo = this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f48a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m205a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f54a.size() >= 50) {
                this.f54a.remove(0);
            }
            this.f54a.add(a2);
            return;
        }
        if (this.f51a == null) {
            this.f48a.bindService(intent, new as(this), 1);
            this.c = true;
            this.f54a.clear();
            this.f54a.add(a(intent));
        } else {
            try {
                this.f51a.send(a(intent));
            } catch (RemoteException unused) {
                this.f51a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m207d() {
        if (m212a()) {
            try {
                return this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f48a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m208e() {
        String packageName = this.f48a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f48a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f47a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f48a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f48a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m209a() {
        return this.f47a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m210a() {
        b(m204a());
    }

    public void a(int i) {
        a(i, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2) {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(bk.B, this.f48a.getPackageName());
        a2.putExtra(bk.C, i);
        a2.putExtra(bk.D, i2);
        c(a2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.thirdparty");
        a2.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        a2.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(a2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m211a(Intent intent) {
        intent.fillIn(m204a(), 24);
        c(intent);
    }

    public final void a(hn hnVar) {
        Intent a2 = m204a();
        byte[] a3 = it.a(hnVar);
        if (a3 == null) {
            b.m182a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        a2.putExtra("mipush_payload", a3);
        b(a2);
    }

    public final void a(ij ijVar, boolean z) {
        eo.a(this.f48a.getApplicationContext()).a(this.f48a.getPackageName(), "E100003", ijVar.a(), 6001, null);
        this.f49a = null;
        b.m219a(this.f48a).f62a = ijVar.a();
        Intent a2 = m204a();
        byte[] a3 = it.a(ai.a(this.f48a, ijVar, hj.Registration));
        if (a3 == null) {
            b.m182a("register fail, because msgBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.REGISTER_APP");
        a2.putExtra("mipush_app_id", b.m219a(this.f48a).m220a());
        a2.putExtra("mipush_payload", a3);
        a2.putExtra("mipush_session", this.f53a);
        a2.putExtra("mipush_env_chanage", z);
        a2.putExtra("mipush_env_type", b.m219a(this.f48a).a());
        if (!bj.b(this.f48a) || !m215b()) {
            this.f49a = a2;
            return;
        }
        g();
        c(a2);
    }

    public final void a(ip ipVar) {
        byte[] a2 = it.a(ai.a(this.f48a, ipVar, hj.UnRegistration));
        if (a2 == null) {
            b.m182a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent a3 = m204a();
        a3.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a3.putExtra("mipush_app_id", b.m219a(this.f48a).m220a());
        a3.putExtra("mipush_payload", a2);
        c(a3);
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, hw hwVar) {
        a(t, hjVar, !hjVar.equals(hj.Registration), hwVar);
    }

    public <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z) {
        a aVar = new a();
        aVar.f56a = t;
        aVar.a = hjVar;
        aVar.f57a = z;
        ArrayList<a> arrayList = f46a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, hw hwVar) {
        a(t, hjVar, z, true, hwVar, true);
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, hw hwVar, boolean z2) {
        a(t, hjVar, z, true, hwVar, z2);
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3) {
        a(t, hjVar, z, z2, hwVar, z3, this.f48a.getPackageName(), b.m219a(this.f48a).m220a());
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2) {
        a(t, hjVar, z, z2, hwVar, z3, str, str2, true);
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2, boolean z4) {
        a(t, hjVar, z, z2, hwVar, z3, str, str2, z4, true);
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (!z5 || b.m219a(this.f48a).m228c()) {
            Cif a2 = z4 ? ai.a(this.f48a, t, hjVar, z, str, str2) : ai.b(this.f48a, t, hjVar, z, str, str2);
            if (hwVar != null) {
                a2.a(hwVar);
            }
            byte[] a3 = it.a(a2);
            if (a3 == null) {
                b.m182a("send message fail, because msgBytes is null.");
                return;
            }
            db.a(this.f48a.getPackageName(), this.f48a, t, hjVar, a3.length);
            Intent a4 = m204a();
            a4.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            a4.putExtra("mipush_payload", a3);
            a4.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(a4);
        } else if (z2) {
            a(t, hjVar, z);
        } else {
            b.m182a("drop the message before initialization.");
        }
    }

    public final void a(String str, au auVar, e eVar) {
        af.a(this.f48a).a(auVar, "syncing");
        a(str, auVar, false, i.m237a(this.f48a, eVar));
    }

    public void a(String str, String str2) {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(bk.B, this.f48a.getPackageName());
        a2.putExtra(bk.H, str);
        a2.putExtra(bk.I, str2);
        c(a2);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        af afVar;
        au auVar;
        au auVar2;
        if (z) {
            af a2 = af.a(this.f48a);
            auVar = au.DISABLE_PUSH;
            a2.a(auVar, "syncing");
            afVar = af.a(this.f48a);
            auVar2 = au.ENABLE_PUSH;
        } else {
            af a3 = af.a(this.f48a);
            auVar = au.ENABLE_PUSH;
            a3.a(auVar, "syncing");
            afVar = af.a(this.f48a);
            auVar2 = au.DISABLE_PUSH;
        }
        afVar.a(auVar2, "");
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m212a() {
        return this.f55a && 1 == b.m219a(this.f48a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m213a(int i) {
        if (!b.m219a(this.f48a).m226b()) {
            return false;
        }
        c(i);
        ii iiVar = new ii();
        iiVar.a(bd.a());
        iiVar.b(b.m219a(this.f48a).m220a());
        iiVar.d(this.f48a.getPackageName());
        iiVar.c(ht.ClientABTest.f497a);
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        hashMap.put("boot_mode", i + "");
        a(this.f48a).a((iu) iiVar, hj.Notification, false, (hw) null);
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m214b() {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(a2);
    }

    public void b(int i) {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(bk.B, this.f48a.getPackageName());
        a2.putExtra(bk.E, i);
        String str = bk.G;
        a2.putExtra(str, bo.b(this.f48a.getPackageName() + i));
        c(a2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m215b() {
        if (!m212a() || !m208e()) {
            return true;
        }
        if (this.f52a == null) {
            Integer valueOf = Integer.valueOf(bn.a(this.f48a).a());
            this.f52a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f48a.getContentResolver().registerContentObserver(bn.a(this.f48a).m832a(), false, new ar(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f52a.intValue() != 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m216c() {
        if (this.f49a != null) {
            g();
            c(this.f49a);
            this.f49a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m217d() {
        ArrayList<a> arrayList = f46a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f56a, next.a, next.f57a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f46a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m218e() {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) com.xiaomi.push.bk.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f48a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            b.m182a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        a2.putExtra(bk.B, packageName);
        c(a2);
    }

    public void f() {
        Intent a2 = m204a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(bk.B, this.f48a.getPackageName());
        a2.putExtra(bk.G, bo.b(this.f48a.getPackageName()));
        c(a2);
    }
}
