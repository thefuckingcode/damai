package com.alibaba.wireless.security.aopsdk.g;

import com.alibaba.wireless.security.aopsdk.Invocation;

/* compiled from: NoArgCachePolicy */
public class b implements a {
    private long a = -1;
    private int b = 0;
    private double c = -1.0d;
    private Object d = null;
    private Throwable e = null;
    private boolean f = false;

    public b(double d2) {
        this.c = d2;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean a(Invocation invocation) {
        return this.b == 0;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Object b(Invocation invocation) {
        return this.d;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Throwable c(Invocation invocation) {
        return this.e;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void d(Invocation invocation) {
        this.e = invocation.getThrowable();
        this.f = true;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void e(Invocation invocation) {
        this.b++;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.a;
        double d2 = ((double) (currentTimeMillis - j)) / 1000.0d;
        double d3 = 60.0d / this.c;
        if (j == -1 || d2 > d3 || Integer.MAX_VALUE == this.b) {
            this.b = 0;
            this.a = currentTimeMillis;
            this.f = false;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean f(Invocation invocation) {
        return this.f;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void g(Invocation invocation) {
        this.d = invocation.getResult();
        this.f = true;
    }
}
