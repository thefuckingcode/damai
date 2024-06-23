package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
@CanIgnoreReturnValue
/* compiled from: Taobao */
public abstract class c implements Hasher {
    c() {
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public abstract Hasher putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public abstract Hasher putChar(char c);

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public abstract Hasher putInt(int i);

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public abstract Hasher putLong(long j);

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : 0);
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public final Hasher putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putShort(short s) {
        putByte((byte) s);
        putByte((byte) (s >>> 8));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.PrimitiveSink, com.google.common.hash.Hasher
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }
}
