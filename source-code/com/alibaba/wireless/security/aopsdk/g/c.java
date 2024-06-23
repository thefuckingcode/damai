package com.alibaba.wireless.security.aopsdk.g;

import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.e.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: WithArgsCachePolicy */
public class c implements a {
    private static final String e = "AOP-CACHE";
    private long a = -1;
    private double b = -1.0d;
    private final Map<b, a> c = new ConcurrentHashMap();
    private int d = 5;

    /* compiled from: WithArgsCachePolicy */
    public static class a {
        public Object a;
        public Throwable b;
        public boolean c = false;
    }

    public c(double d2) {
        this.b = d2;
    }

    private void h(Invocation invocation) {
        b hashableArgs = invocation.getHashableArgs();
        if (this.c.get(hashableArgs) == null && !i(invocation)) {
            this.c.put(hashableArgs, new a());
        }
    }

    private boolean i(Invocation invocation) {
        return this.c.size() >= a() && !this.c.containsKey(invocation.getHashableArgs());
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean a(Invocation invocation) {
        Object[] objArr = invocation.args;
        if (objArr == null || objArr.length == 0) {
            com.alibaba.wireless.security.aopsdk.i.a.a(e, "Invocation args is unexpected empty");
            return true;
        } else if (i(invocation) || !f(invocation)) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Object b(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Throwable c(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.b;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void d(Invocation invocation) {
        b hashableArgs = invocation.getHashableArgs();
        a aVar = this.c.get(hashableArgs);
        if (aVar == null && !i(invocation)) {
            aVar = new a();
            this.c.put(hashableArgs, aVar);
        }
        if (aVar != null) {
            aVar.b = invocation.getThrowable();
            aVar.c = true;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void e(Invocation invocation) {
        Object[] objArr = invocation.args;
        if (objArr == null || objArr.length == 0) {
            com.alibaba.wireless.security.aopsdk.i.a.a(e, "Invocation args is unexpected empty");
            return;
        }
        h(invocation);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.a;
        double d2 = ((double) (currentTimeMillis - j)) / 1000.0d;
        double d3 = 60.0d / this.b;
        if (j == -1 || d2 > d3) {
            this.c.clear();
            this.a = currentTimeMillis;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean f(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.c;
        }
        return false;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void g(Invocation invocation) {
        b hashableArgs = invocation.getHashableArgs();
        a aVar = this.c.get(hashableArgs);
        if (aVar == null && !i(invocation)) {
            aVar = new a();
            this.c.put(hashableArgs, aVar);
        }
        if (aVar != null) {
            aVar.a = invocation.getResult();
            aVar.c = true;
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }
}
