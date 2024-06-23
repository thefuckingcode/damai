package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import tb.ds1;

@Immutable
/* compiled from: Taobao */
abstract class b implements HashFunction {
    b() {
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return newHasher(4).putInt(i).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        return newHasher(8).putLong(j).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return newHasher().putObject(t, funnel).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).putUnencodedChars(charSequence).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        ds1.f(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        ds1.v(i, i + i2, bArr.length);
        return newHasher(i2).putBytes(bArr, i, i2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }
}
