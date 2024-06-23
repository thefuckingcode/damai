package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: Taobao */
enum LittleEndianByteArray$UnsafeByteArray implements LittleEndianByteArray$LittleEndianBytes {
    UNSAFE_LITTLE_ENDIAN {
        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i) {
            return LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i) + ((long) LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
        }

        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i) + ((long) LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), j);
        }
    },
    UNSAFE_BIG_ENDIAN {
        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i) {
            return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i) + ((long) LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)));
        }

        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i) + ((long) LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), Long.reverseBytes(j));
        }
    };
    
    private static final int BYTE_ARRAY_BASE_OFFSET;
    private static final Unsafe theUnsafe;

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
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (unsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.a());
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
}
