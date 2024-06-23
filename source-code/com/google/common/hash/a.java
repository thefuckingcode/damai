package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import tb.ds1;

@CanIgnoreReturnValue
/* compiled from: Taobao */
abstract class a extends c {
    private final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    a() {
    }

    private Hasher a(int i) {
        try {
            e(this.a.array(), 0, i);
            return this;
        } finally {
            this.a.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b(byte b);

    /* access modifiers changed from: protected */
    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            e(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            b(byteBuffer.get());
        }
    }

    /* access modifiers changed from: protected */
    public void d(byte[] bArr) {
        e(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public abstract void e(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putByte(byte b) {
        b(b);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putChar(char c) {
        this.a.putChar(c);
        return a(2);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putInt(int i) {
        this.a.putInt(i);
        return a(4);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putLong(long j) {
        this.a.putLong(j);
        return a(8);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putShort(short s) {
        this.a.putShort(s);
        return a(2);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putBytes(byte[] bArr) {
        ds1.p(bArr);
        d(bArr);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putBytes(byte[] bArr, int i, int i2) {
        ds1.v(i, i + i2, bArr.length);
        e(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putBytes(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return this;
    }
}
