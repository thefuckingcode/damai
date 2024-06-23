package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;
import tb.as2;

@VisibleForTesting
/* compiled from: Taobao */
enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator<byte[]> {
    INSTANCE;
    
    static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    static final int BYTE_ARRAY_BASE_OFFSET;
    static final Unsafe theUnsafe;

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

    static {
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
            throw new Error();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    private static Unsafe getUnsafe() {
        return Unsafe.getUnsafe();
    }

    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }

    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        int i = min & -8;
        int i2 = 0;
        while (i2 < i) {
            Unsafe unsafe = theUnsafe;
            int i3 = BYTE_ARRAY_BASE_OFFSET;
            long j = (long) i2;
            long j2 = unsafe.getLong(bArr, ((long) i3) + j);
            long j3 = unsafe.getLong(bArr2, ((long) i3) + j);
            if (j2 == j3) {
                i2 += 8;
            } else if (BIG_ENDIAN) {
                return UnsignedLongs.a(j2, j3);
            } else {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2 ^ j3) & -8;
                return ((int) ((j2 >>> numberOfTrailingZeros) & 255)) - ((int) ((j3 >>> numberOfTrailingZeros) & 255));
            }
        }
        while (i2 < min) {
            int b = as2.b(bArr[i2], bArr2[i2]);
            if (b != 0) {
                return b;
            }
            i2++;
        }
        return bArr.length - bArr2.length;
    }
}
