package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.p;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class a {
    private Bundle a;
    private String b;
    private String c;

    public a(String str, String str2, Bundle bundle) {
        this.b = str;
        this.c = str2;
        this.a = bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x001f;
     */
    public static a a(Intent intent) {
        String str;
        String str2 = null;
        if (intent == null) {
            p.a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("client_pkgname");
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            p.b("BundleWapper", "create warning: pkgName is null");
        }
        String str3 = intent.getPackage();
        if (TextUtils.isEmpty(str3)) {
            if (intent.getComponent() != null) {
                str2 = intent.getComponent().getPackageName();
            }
            if (TextUtils.isEmpty(str2)) {
                p.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str3 = str2;
        }
        return new a(str, str3, extras);
    }

    public final int b(String str, int i) {
        Bundle bundle = this.a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j) {
        Bundle bundle = this.a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final Bundle b() {
        return this.a;
    }

    public final void a(String str, int i) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putBoolean(str, z);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.b;
    }
}
