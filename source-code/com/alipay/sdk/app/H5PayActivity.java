package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.m.j.b;
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.c;
import com.youku.network.HttpIntent;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class H5PayActivity extends Activity {
    public c a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public WeakReference<a> h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    public void a() {
        Object obj = PayTask.h;
        synchronized (obj) {
            obj.notify();
        }
    }

    public void finish() {
        a();
        super.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            d.a((a) n.a(this.h), i, i2, intent);
        }
    }

    public void onBackPressed() {
        c cVar = this.a;
        if (cVar == null) {
            finish();
        } else if (cVar.a()) {
            cVar.b();
        } else {
            if (!cVar.b()) {
                super.onBackPressed();
            }
            b.a(b.a());
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a a2 = a.C0134a.a(getIntent());
            if (a2 == null) {
                finish();
                return;
            }
            this.h = new WeakReference<>(a2);
            if (!com.alipay.sdk.m.m.a.D().y()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.b = string;
                if (!n.f(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString(HttpIntent.COOKIE, null);
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", c.c);
                this.f = extras.getBoolean("backisexit", false);
                try {
                    com.alipay.sdk.m.x.d dVar = new com.alipay.sdk.m.x.d(this, a2, this.g);
                    setContentView(dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.a = dVar;
                } catch (Throwable th) {
                    com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.a;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }
}
