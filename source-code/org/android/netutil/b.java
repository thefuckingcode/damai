package org.android.netutil;

/* compiled from: Taobao */
public class b {
    private String a = null;
    private String b = null;
    private int c;
    private int d;
    private a[] e;
    private PingTaskWatcher f;

    b(int i) {
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.e = new a[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.e[i2] = new a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2, double d2) {
        this.e[i].a(i, i2, d2);
        if (d2 >= 0.0d) {
            this.d++;
        }
        PingTaskWatcher pingTaskWatcher = this.f;
        if (pingTaskWatcher != null) {
            pingTaskWatcher.OnEntry(i, i2, d2);
        }
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public a[] e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void g(PingTaskWatcher pingTaskWatcher) {
        this.f = pingTaskWatcher;
    }

    /* access modifiers changed from: package-private */
    public void h(int i) {
        this.c = i;
        PingTaskWatcher pingTaskWatcher = this.f;
        if (pingTaskWatcher == null) {
            return;
        }
        if (i == 0) {
            pingTaskWatcher.OnFinished();
        } else {
            pingTaskWatcher.OnFailed(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(String str) {
        this.b = str;
    }

    /* access modifiers changed from: package-private */
    public void j(String str) {
        this.a = str;
    }
}
