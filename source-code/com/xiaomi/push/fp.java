package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
public class fp {
    public static final byte[] a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    private byte f381a;

    /* renamed from: a  reason: collision with other field name */
    private int f382a;

    /* renamed from: a  reason: collision with other field name */
    private short f383a;
    private byte[] b;

    /* compiled from: Taobao */
    public static class a {
        public static final c a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f384a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f384a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!fp.m491a(bArr)) {
                return bArr;
            }
            fp a2 = fp.a(bArr);
            return (a2.f381a == 0 || a2.f381a != bVar.a()) ? a2.b : bVar.a(a2.b, a2.f382a);
        }
    }

    /* compiled from: Taobao */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* compiled from: Taobao */
    public static final class c {
    }

    /* compiled from: Taobao */
    public static final class d implements b {
        @Override // com.xiaomi.push.fp.b
        public byte a() {
            return 2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0023 A[SYNTHETIC, Splitter:B:21:0x0023] */
        @Override // com.xiaomi.push.fp.b
        public byte[] a(byte[] bArr, int i) {
            Throwable th;
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    protected fp(byte b2, int i, byte[] bArr) {
        this(1, b2, i, bArr);
    }

    protected fp(short s, byte b2, int i, byte[] bArr) {
        this.f383a = 1;
        this.f383a = s;
        this.f381a = b2;
        this.f382a = i;
        this.b = bArr;
    }

    public static fp a(byte b2, int i, byte[] bArr) {
        return new fp(b2, i, bArr);
    }

    public static fp a(short s, byte b2, int i, byte[] bArr) {
        return new fp(s, b2, i, bArr);
    }

    public static fp a(byte[] bArr) {
        if (!m491a(bArr)) {
            return a((byte) 0, bArr.length, bArr);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s = order.getShort();
        byte b2 = order.get();
        int i = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return a(s, b2, i, bArr2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m491a(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
