package com.google.protobuf;

import com.alibaba.aliweex.adapter.module.location.ILocatable;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class n {
    private static final Unsafe a = j();
    private static final boolean b = o();
    private static final boolean c = n();
    private static final long d = ((long) b());
    private static final long e = d(c(Buffer.class, ILocatable.ADDRESS));

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
            return null;
        }
    }

    static long a(ByteBuffer byteBuffer) {
        return a.getLong(byteBuffer, e);
    }

    private static int b() {
        if (c) {
            return a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static Field c(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long d(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = a) == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(field);
    }

    static long e() {
        return d;
    }

    static byte f(long j) {
        return a.getByte(j);
    }

    static byte g(byte[] bArr, long j) {
        return a.getByte(bArr, j);
    }

    static long h(long j) {
        return a.getLong(j);
    }

    static long i(byte[] bArr, long j) {
        return a.getLong(bArr, j);
    }

    private static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean k() {
        return c;
    }

    static boolean l() {
        return b;
    }

    static void m(byte[] bArr, long j, byte b2) {
        a.putByte(bArr, j, b2);
    }

    private static boolean n() {
        Unsafe unsafe = a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean o() {
        Unsafe unsafe = a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
