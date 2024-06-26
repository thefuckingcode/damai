package com.huawei.secure.android.common.util;

/* compiled from: Taobao */
public class a {
    private String a;
    private Character b;
    private Character c;
    private int d = 0;
    private int e = 0;

    public a(String str) {
        this.a = str;
    }

    public static boolean c(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    public void a(Character ch) {
        this.b = ch;
    }

    public int b() {
        return this.d;
    }

    public Character d() {
        Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.d >= this.a.length()) {
            return null;
        }
        String str2 = this.a;
        int i = this.d;
        this.d = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    public Character e() {
        Character d2 = d();
        if (d2 != null && b(d2)) {
            return d2;
        }
        return null;
    }

    public Character f() {
        Character d2 = d();
        if (d2 != null && c(d2)) {
            return d2;
        }
        return null;
    }

    public Character g() {
        Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.d >= this.a.length()) {
            return null;
        }
        return Character.valueOf(this.a.charAt(this.d));
    }

    /* access modifiers changed from: protected */
    public String h() {
        String substring = this.a.substring(this.d);
        if (this.b == null) {
            return substring;
        }
        return this.b + substring;
    }

    public void i() {
        this.b = this.c;
        this.d = this.e;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.d >= this.a.length()) {
            return false;
        }
        return true;
    }

    public void c() {
        this.c = this.b;
        this.e = this.d;
    }

    public boolean a(char c2) {
        Character ch = this.b;
        if (ch != null && ch.charValue() == c2) {
            return true;
        }
        String str = this.a;
        if (str != null && str.length() != 0 && this.d < this.a.length() && this.a.charAt(this.d) == c2) {
            return true;
        }
        return false;
    }
}
