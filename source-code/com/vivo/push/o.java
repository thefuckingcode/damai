package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.p;

/* compiled from: Taobao */
public abstract class o {
    private int a = -1;
    private String b;

    public o(int i) {
        if (i >= 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(a aVar) {
        aVar.a("command", this.a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.a);
        e(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(a aVar) {
        String a2 = p.a(this.a);
        if (a2 == null) {
            a2 = "";
        }
        aVar.a("method", a2);
        e(aVar);
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.b = a2;
        } else {
            this.b = aVar.a("client_pkgname");
        }
        d(aVar);
    }
}
