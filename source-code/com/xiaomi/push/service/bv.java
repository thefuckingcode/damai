package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.ab;
import com.xiaomi.push.ao;
import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.gz;
import com.xiaomi.push.j;
import com.xiaomi.push.v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class bv {
    private static bv a = new bv();

    /* renamed from: a  reason: collision with other field name */
    private static String f942a;

    /* renamed from: a  reason: collision with other field name */
    private ao.b f943a;

    /* renamed from: a  reason: collision with other field name */
    private dw.a f944a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f945a = new ArrayList();

    /* compiled from: Taobao */
    public static abstract class a {
        public void a(dw.a aVar) {
        }

        public void a(dx.b bVar) {
        }
    }

    private bv() {
    }

    public static bv a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m837a() {
        String str;
        synchronized (bv.class) {
            if (f942a == null) {
                SharedPreferences sharedPreferences = v.m879a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f942a = string;
                if (string == null) {
                    String a2 = j.a(v.m879a(), false);
                    f942a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f942a).commit();
                    }
                }
            }
            str = f942a;
        }
        return str;
    }

    private void b() {
        if (this.f944a == null) {
            d();
        }
    }

    private void c() {
        if (this.f943a == null) {
            bw bwVar = new bw(this);
            this.f943a = bwVar;
            gz.a(bwVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    private void d() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        try {
            bufferedInputStream = new BufferedInputStream(v.m879a().openFileInput("XMCloudCfg"));
            try {
                this.f944a = dw.a.b(b.a(bufferedInputStream));
                bufferedInputStream.close();
            } catch (Exception e2) {
                e = e2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m182a("load config failure: " + e.getMessage());
                    ab.a(bufferedInputStream);
                    if (this.f944a == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
            com.xiaomi.channel.commonutils.logger.b.m182a("load config failure: " + e.getMessage());
            ab.a(bufferedInputStream);
            if (this.f944a == null) {
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            ab.a(bufferedInputStream);
            throw th;
        }
        ab.a(bufferedInputStream);
        if (this.f944a == null) {
            this.f944a = new dw.a();
        }
    }

    private void e() {
        try {
            if (this.f944a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(v.m879a().openFileOutput("XMCloudCfg", 0));
                c a2 = c.a(bufferedOutputStream);
                this.f944a.a(a2);
                a2.m303a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m182a("save config failure: " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m838a() {
        b();
        dw.a aVar = this.f944a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dw.a m839a() {
        b();
        return this.f944a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m840a() {
        this.f945a.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(dx.b bVar) {
        a[] aVarArr;
        if (bVar.m383d() && bVar.d() > m838a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f945a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f945a.add(aVar);
    }
}
