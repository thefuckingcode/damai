package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
public class a {
    public int a = 4;
    public String b;
    public b c = new e();

    public void a(Context context, int i, String str) {
        this.a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void b(int i, String str, String str2, Throwable th) {
        if (a(i)) {
            c a2 = a(i, str, str2, th);
            b bVar = this.c;
            bVar.a(a2.c() + a2.a(), i, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public b a() {
        return this.c;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public boolean a(int i) {
        return i >= this.a;
    }

    public void a(int i, String str, String str2) {
        if (a(i)) {
            c a2 = a(i, str, str2, null);
            this.c.a(a2.c() + a2.a(), i, str, str2);
        }
    }

    public void a(String str, String str2) {
        c a2 = a(4, str, str2, null);
        this.c.a(a2.c() + '\n' + a2.a(), 4, str, str2);
    }

    public final c a(int i, String str, String str2, Throwable th) {
        c cVar = new c(8, this.b, i, str);
        cVar.a(str2);
        cVar.a(th);
        return cVar;
    }
}
