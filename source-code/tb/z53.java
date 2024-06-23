package tb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* compiled from: Taobao */
public class z53 {
    static final Charset o = Charset.forName("UTF-8");
    static final /* synthetic */ boolean p = true;
    ByteBuffer a;
    int b;
    int c = 1;
    int[] d = null;
    int e = 0;
    boolean f = false;
    boolean g = false;
    int h;
    int[] i = new int[16];
    int j = 0;
    int k = 0;
    boolean l = false;
    CharsetEncoder m = o.newEncoder();
    ByteBuffer n;

    public z53(ByteBuffer byteBuffer) {
        c(byteBuffer);
    }

    private int A() {
        return this.a.capacity() - this.b;
    }

    private static ByteBuffer B(int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] C(int i2, int i3) {
        D();
        byte[] bArr = new byte[i3];
        this.a.position(i2);
        this.a.get(bArr);
        return bArr;
    }

    private void D() {
        if (!this.g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void E(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBuffer = this.a;
            int i4 = this.b - 1;
            this.b = i4;
            byteBuffer.put(i4, (byte) 0);
        }
    }

    private void F() {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void G(int i2) {
        ByteBuffer byteBuffer = this.a;
        int i3 = this.b - 4;
        this.b = i3;
        byteBuffer.putInt(i3, i2);
    }

    private void H(int i2) {
        x(4, 0);
        G(i2);
    }

    private void I(int i2) {
        this.d[i2] = A();
    }

    private void k(long j2) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 8;
        this.b = i2;
        byteBuffer.putLong(i2, j2);
    }

    private void l(short s) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 2;
        this.b = i2;
        byteBuffer.putShort(i2, s);
    }

    private static ByteBuffer o(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) == 0) {
            int i2 = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer B = B(i2);
            B.position(i2 - capacity);
            B.put(byteBuffer);
            return B;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void p(byte b2) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 1;
        this.b = i2;
        byteBuffer.put(i2, b2);
    }

    private void s(long j2) {
        x(8, 0);
        k(j2);
    }

    private void t(short s) {
        x(2, 0);
        l(s);
    }

    private void u(boolean z) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 1;
        this.b = i2;
        byteBuffer.put(i2, z ? (byte) 1 : 0);
    }

    private int v(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        d((byte) 0);
        h(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.a;
        int i2 = this.b - remaining;
        this.b = i2;
        byteBuffer2.position(i2);
        this.a.put(byteBuffer);
        return a();
    }

    private void x(int i2, int i3) {
        if (i2 > this.c) {
            this.c = i2;
        }
        int i4 = ((~((this.a.capacity() - this.b) + i3)) + 1) & (i2 - 1);
        while (this.b < i4 + i2 + i3) {
            int capacity = this.a.capacity();
            ByteBuffer o2 = o(this.a);
            this.a = o2;
            this.b += o2.capacity() - capacity;
        }
        E(i4);
    }

    private void y(boolean z) {
        x(1, 0);
        u(z);
    }

    public final int a() {
        if (this.f) {
            this.f = false;
            G(this.k);
            return A();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int b(CharSequence charSequence) {
        int length = (int) (((float) charSequence.length()) * this.m.maxBytesPerChar());
        ByteBuffer byteBuffer = this.n;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.n = ByteBuffer.allocate(Math.max(128, length));
        }
        this.n.clear();
        CoderResult encode = this.m.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.n, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e2) {
                throw new Error(e2);
            }
        }
        this.n.flip();
        return v(this.n);
    }

    public final z53 c(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.clear();
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        this.c = 1;
        this.b = this.a.capacity();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = 0;
        this.j = 0;
        this.k = 0;
        return this;
    }

    public final void d(byte b2) {
        x(1, 0);
        p(b2);
    }

    public final void e(int i2) {
        x(4, 0);
        if (p || i2 <= A()) {
            G((A() - i2) + 4);
            return;
        }
        throw new AssertionError();
    }

    public final void f(int i2, byte b2) {
        if (this.l || b2 != 0) {
            d(b2);
            I(i2);
        }
    }

    public final void g(int i2, int i3) {
        if (this.l || i3 != 0) {
            H(i3);
            I(i2);
        }
    }

    public final void h(int i2, int i3, int i4) {
        F();
        this.k = i3;
        int i5 = i2 * i3;
        x(4, i5);
        x(i4, i5);
        this.f = true;
    }

    public final void i(int i2, long j2) {
        if (this.l || j2 != 0) {
            s(j2);
            I(i2);
        }
    }

    public final void j(int i2, short s) {
        if (this.l || s != 0) {
            t(s);
            I(i2);
        }
    }

    public final void m(boolean z) {
        if (this.l || z) {
            y(z);
            I(0);
        }
    }

    public final int n() {
        int i2;
        if (this.d == null || !this.f) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        H(0);
        int A = A();
        for (int i3 = this.e - 1; i3 >= 0; i3--) {
            int[] iArr = this.d;
            t((short) (iArr[i3] != 0 ? A - iArr[i3] : 0));
        }
        t((short) (A - this.h));
        t((short) ((this.e + 2) * 2));
        int i4 = 0;
        loop1:
        while (true) {
            if (i4 >= this.j) {
                i2 = 0;
                break;
            }
            int capacity = this.a.capacity() - this.i[i4];
            int i5 = this.b;
            short s = this.a.getShort(capacity);
            if (s == this.a.getShort(i5)) {
                for (int i6 = 2; i6 < s; i6 += 2) {
                    if (this.a.getShort(capacity + i6) == this.a.getShort(i5 + i6)) {
                    }
                }
                i2 = this.i[i4];
                break loop1;
            }
            i4++;
        }
        if (i2 != 0) {
            int capacity2 = this.a.capacity() - A;
            this.b = capacity2;
            this.a.putInt(capacity2, i2 - A);
        } else {
            int i7 = this.j;
            int[] iArr2 = this.i;
            if (i7 == iArr2.length) {
                this.i = Arrays.copyOf(iArr2, i7 * 2);
            }
            int[] iArr3 = this.i;
            int i8 = this.j;
            this.j = i8 + 1;
            iArr3[i8] = A();
            ByteBuffer byteBuffer = this.a;
            byteBuffer.putInt(byteBuffer.capacity() - A, A() - A);
        }
        this.f = false;
        return A;
    }

    public final void q(int i2) {
        F();
        int[] iArr = this.d;
        if (iArr == null || iArr.length < i2) {
            this.d = new int[i2];
        }
        this.e = i2;
        Arrays.fill(this.d, 0, i2, 0);
        this.f = true;
        this.h = A();
    }

    public final void r(int i2, int i3) {
        if (this.l || i3 != 0) {
            e(i3);
            I(i2);
        }
    }

    public final void w(int i2) {
        x(this.c, 4);
        e(i2);
        this.a.position(this.b);
        this.g = true;
    }

    public final byte[] z() {
        return C(this.b, this.a.capacity() - this.b);
    }
}
