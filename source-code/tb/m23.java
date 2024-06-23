package tb;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* compiled from: Taobao */
public abstract class m23 implements BinaryDecoder, BinaryEncoder {
    public static final int b = 76;
    public static final int c = 64;
    protected final int a;
    protected byte[] d;
    protected int e;
    private int f;
    protected boolean g;
    protected int h;
    protected int i;

    protected m23(int i2, int i3, int i4, int i5) {
        this.a = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
    }

    private void a() {
        byte[] bArr = this.d;
        if (bArr == null) {
            this.d = new byte[i()];
            this.e = 0;
            this.f = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.d = bArr2;
    }

    private void j() {
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.g = false;
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < this.e + i2) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void c(byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void d(byte[] bArr, int i2, int i3);

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return h((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d(bArr, 0, bArr.length);
        d(bArr, 0, -1);
        int i2 = this.e;
        byte[] bArr2 = new byte[i2];
        g(bArr2, 0, i2);
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public abstract boolean e(byte b2);

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        c(bArr, 0, bArr.length);
        c(bArr, 0, -1);
        int i2 = this.e - this.f;
        byte[] bArr2 = new byte[i2];
        g(bArr2, 0, i2);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        if (this.d != null) {
            return this.e - this.f;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int g(byte[] bArr, int i2, int i3) {
        if (this.d == null) {
            return this.g ? -1 : 0;
        }
        int min = Math.min(f(), i3);
        System.arraycopy(this.d, this.f, bArr, i2, min);
        int i4 = this.f + min;
        this.f = i4;
        if (i4 >= this.e) {
            this.d = null;
        }
        return min;
    }

    public byte[] h(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    /* access modifiers changed from: protected */
    public int i() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || e(b2)) {
                return true;
            }
        }
        return false;
    }
}
