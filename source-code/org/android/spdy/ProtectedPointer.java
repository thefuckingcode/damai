package org.android.spdy;

import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ProtectedPointer {
    private AtomicLong a = new AtomicLong(1);
    private Object b;
    protected ProtectedPointerOnClose c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface ProtectedPointerOnClose {
        void close(Object obj);
    }

    ProtectedPointer(Object obj) {
        this.b = obj;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        long j;
        do {
            j = this.a.get();
            if (j == 3) {
                return false;
            }
        } while (!this.a.compareAndSet(j, 16 + j));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.a.addAndGet(-16);
        if (this.a.compareAndSet(2, 3)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.c;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.b);
            }
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.a.incrementAndGet();
        if (this.a.compareAndSet(2, 3)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.c;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.b);
            }
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(ProtectedPointerOnClose protectedPointerOnClose) {
        this.c = protectedPointerOnClose;
    }
}
