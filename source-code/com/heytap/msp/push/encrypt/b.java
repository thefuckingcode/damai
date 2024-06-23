package com.heytap.msp.push.encrypt;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* compiled from: Taobao */
public abstract class b implements BinaryDecoder, BinaryEncoder {
    private static final int a = 2;
    public static final int b = 76;
    public static final int c = 64;
    protected static final int d = 255;
    protected static final byte e = 61;
    private static final int m = 8192;
    protected final byte f = e;
    protected final int g;
    protected byte[] h;
    protected int i;
    protected boolean j;
    protected int k;
    protected int l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    protected b(int i2, int i3, int i4, int i5) {
        this.n = i2;
        this.o = i3;
        this.g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.p = i5;
    }

    private void a() {
        byte[] bArr = this.h;
        if (bArr == null) {
            this.h = new byte[d()];
            this.i = 0;
            this.q = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.h = bArr2;
    }

    protected static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.h = null;
        this.i = 0;
        this.q = 0;
        this.k = 0;
        this.l = 0;
        this.j = false;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        byte[] bArr = this.h;
        if (bArr == null || bArr.length < this.i + i2) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void b(byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.h != null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!(b(bArr[i2]) || (z && (bArr[i2] == 61 || c(bArr[i2]))))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if (this.h != null) {
            return this.i - this.q;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int c(byte[] bArr, int i2, int i3) {
        if (this.h == null) {
            return this.j ? -1 : 0;
        }
        int min = Math.min(c(), i3);
        System.arraycopy(this.h, this.q, bArr, i2, min);
        int i4 = this.q + min;
        this.q = i4;
        if (i4 >= this.i) {
            this.h = null;
        }
        return min;
    }

    public byte[] c(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    /* access modifiers changed from: protected */
    public int d() {
        return 8192;
    }

    public boolean d(String str) {
        return b(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i2 = this.i;
        byte[] bArr2 = new byte[i2];
        c(bArr2, 0, i2);
        return bArr2;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i2 = this.i - this.q;
        byte[] bArr2 = new byte[i2];
        c(bArr2, 0, i2);
        return bArr2;
    }

    public String j(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String k(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* access modifiers changed from: protected */
    public boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.n;
        long j2 = ((long) (((length + i2) - 1) / i2)) * ((long) this.o);
        int i3 = this.g;
        return i3 > 0 ? j2 + ((((((long) i3) + j2) - 1) / ((long) i3)) * ((long) this.p)) : j2;
    }
}
