package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import tb.ds1;

/* access modifiers changed from: package-private */
@CanIgnoreReturnValue
/* compiled from: Taobao */
public abstract class d extends c {
    private final ByteBuffer a;
    private final int b;
    private final int c;

    protected d(int i) {
        this(i, i);
    }

    private void b() {
        this.a.flip();
        while (this.a.remaining() >= this.c) {
            d(this.a);
        }
        this.a.compact();
    }

    private void c() {
        if (this.a.remaining() < 8) {
            b();
        }
    }

    private Hasher f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            c();
            return this;
        }
        int position = this.b - this.a.position();
        for (int i = 0; i < position; i++) {
            this.a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.c) {
            d(byteBuffer);
        }
        this.a.put(byteBuffer);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract HashCode a();

    /* access modifiers changed from: protected */
    public abstract void d(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract void e(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        b();
        this.a.flip();
        if (this.a.remaining() > 0) {
            e(this.a);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return a();
    }

    protected d(int i, int i2) {
        ds1.d(i2 % i == 0);
        this.a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putByte(byte b2) {
        this.a.put(b2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putChar(char c2) {
        this.a.putChar(c2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putShort(short s) {
        this.a.putShort(s);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return f(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Hasher f = f(byteBuffer);
            byteBuffer.order(order);
            return f;
        } catch (Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }
}
