package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.o;
import com.vivo.push.util.p;
import com.vivo.push.util.t;

/* compiled from: Taobao */
public class c extends o {
    private String a = null;
    private String b;
    private long c = -1;
    private int d = -1;
    private int e;
    private String f;

    public c(int i, String str) {
        super(i);
        this.b = str;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.a = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void c(a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("package_name", this.b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.d);
        if (!TextUtils.isEmpty(this.f)) {
            aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void d(a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.a("package_name");
        this.c = aVar.b("sdk_version", 0L);
        this.d = aVar.b("PUSH_APP_STATUS", 0);
        this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.e;
    }

    public final void g() {
        this.f = null;
    }

    public final String h() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                p.a("BaseAppCommand", "pkg name is null");
                String a2 = a();
                if (TextUtils.isEmpty(a2)) {
                    p.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a2;
            }
            this.d = t.b(context, str);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }
}
