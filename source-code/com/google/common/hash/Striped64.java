package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public abstract class Striped64 extends Number {
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final Random rng = new Random();
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    volatile transient long base;
    volatile transient int busy;
    @NullableDecl
    volatile transient b[] cells;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields = Unsafe.class.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b {
        private static final Unsafe b;
        private static final long c;
        volatile long a;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                b = unsafe;
                c = unsafe.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        b(long j) {
            this.a = j;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.Striped64.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    public static Unsafe getUnsafe() {
        return Unsafe.getUnsafe();
    }

    /* access modifiers changed from: package-private */
    public final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* access modifiers changed from: package-private */
    public abstract long fn(long j, long j2);

    /* access modifiers changed from: package-private */
    public final void internalReset(long j) {
        b[] bVarArr = this.cells;
        this.base = j;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.a = j;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0023 A[SYNTHETIC] */
    public final void retryUpdate(long j, @NullableDecl int[] iArr, boolean z) {
        int[] iArr2;
        int i;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i = rng.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr2[0] = i;
        } else {
            i = iArr[0];
            iArr2 = iArr;
        }
        int i2 = i;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i2];
                if (bVar != null) {
                    if (!z5) {
                        z5 = true;
                    } else {
                        long j2 = bVar.a;
                        if (bVar.a(j2, fn(j2, j))) {
                            return;
                        }
                        if (length < NCPU && this.cells == bVarArr) {
                            if (!z4) {
                                z4 = true;
                            } else if (this.busy == 0 && casBusy()) {
                                try {
                                    if (this.cells == bVarArr) {
                                        b[] bVarArr2 = new b[(length << 1)];
                                        for (int i3 = 0; i3 < length; i3++) {
                                            bVarArr2[i3] = bVarArr[i3];
                                        }
                                        this.cells = bVarArr2;
                                    }
                                    this.busy = 0;
                                    z4 = false;
                                } catch (Throwable th) {
                                    this.busy = 0;
                                    throw th;
                                }
                            }
                        }
                    }
                    int i4 = i2 ^ (i2 << 13);
                    int i5 = i4 ^ (i4 >>> 17);
                    i2 = i5 ^ (i5 << 5);
                    iArr2[0] = i2;
                } else if (this.busy == 0) {
                    b bVar2 = new b(j);
                    if (this.busy == 0 && casBusy()) {
                        try {
                            b[] bVarArr3 = this.cells;
                            if (bVarArr3 != null && (length2 = bVarArr3.length) > 0) {
                                int i6 = (length2 - 1) & i2;
                                if (bVarArr3[i6] == null) {
                                    bVarArr3[i6] = bVar2;
                                    z3 = true;
                                    if (!z3) {
                                        return;
                                    }
                                }
                            }
                            z3 = false;
                            if (!z3) {
                            }
                        } finally {
                            this.busy = 0;
                        }
                    }
                }
                z4 = false;
                int i42 = i2 ^ (i2 << 13);
                int i52 = i42 ^ (i42 >>> 17);
                i2 = i52 ^ (i52 << 5);
                iArr2[0] = i2;
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i2 & 1] = new b(j);
                        this.cells = bVarArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                    this.busy = 0;
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
