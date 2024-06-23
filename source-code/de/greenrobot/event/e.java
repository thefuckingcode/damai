package de.greenrobot.event;

import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class e {
    final Method a;
    final ThreadMode b;
    final Class<?> c;
    String d;

    e(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        a();
        e eVar = (e) obj;
        eVar.a();
        return this.d.equals(eVar.d);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
