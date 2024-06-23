package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class NoLock implements Lock {
    public static final Lock INSTANCE = new NoLock();

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unit", "kotlin/reflect/jvm/internal/impl/storage/NoLock", "tryLock"));
    }

    public void lock() {
    }

    public void unlock() {
    }

    private NoLock() {
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException("Should not be called");
    }

    public boolean tryLock() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            $$$reportNull$$$0(0);
        }
        throw new UnsupportedOperationException("Should not be called");
    }

    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }
}
