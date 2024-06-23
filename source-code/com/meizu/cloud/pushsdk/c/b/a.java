package com.meizu.cloud.pushsdk.c.b;

import com.meizu.cloud.pushsdk.c.c.k;

/* compiled from: Taobao */
public class a extends Exception {
    private String a;
    private int b = 0;
    private String c;
    private k d;

    public a() {
    }

    public a(k kVar) {
        this.d = kVar;
    }

    public a(Throwable th) {
        super(th);
    }

    public k a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}
