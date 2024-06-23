package com.alibaba.poplayer.trigger.view;

import java.util.Collection;
import java.util.LinkedHashSet;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a<T> {
    private Collection<T> a = new LinkedHashSet();
    private Collection<T> b;
    private final C0096a<T> c = new C0096a<>();
    private boolean d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.poplayer.trigger.view.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0096a<T> {
        Collection<T> a;
        private int b;

        C0096a() {
        }

        /* access modifiers changed from: package-private */
        public Collection<T> b() {
            return this.a;
        }
    }

    a() {
    }

    private Collection<T> c() {
        if (!this.d) {
            return this.a;
        }
        if (this.b == null) {
            this.b = new LinkedHashSet(this.a);
        }
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(T t) {
        Collection<T> c2 = c();
        if (!c2.contains(t)) {
            c2.add(t);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.d) {
            this.d = false;
            Collection<T> collection = this.b;
            if (collection != null) {
                this.a = collection;
                this.c.a.clear();
                ((C0096a) this.c).b = 0;
            }
            this.b = null;
            return;
        }
        throw new IllegalStateException("Iteration not started");
    }

    /* access modifiers changed from: package-private */
    public void d(T t) {
        c().remove(t);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return c().size();
    }

    /* access modifiers changed from: package-private */
    public C0096a<T> f() {
        if (!this.d) {
            this.d = true;
            this.b = null;
            C0096a<T> aVar = this.c;
            Collection<T> collection = this.a;
            aVar.a = collection;
            ((C0096a) aVar).b = collection.size();
            return this.c;
        }
        throw new IllegalStateException("Iteration already started");
    }
}
