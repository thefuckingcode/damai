package com.alipay.sdk.m.i0;

import android.text.TextUtils;

/* compiled from: Taobao */
public class c {
    public String a;
    public Boolean b;

    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    public boolean a() {
        return this.b != null;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    public void b(String str) {
        this.a = str;
    }

    public boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
