package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@Immutable
/* compiled from: Taobao */
final class SipHashFunction extends b implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    /* compiled from: Taobao */
    private static final class a extends d {
        private final int d;
        private final int e;
        private long f = 8317987319222330741L;
        private long g = 7237128888997146477L;
        private long h = 7816392313619706465L;
        private long i = 8387220255154660723L;
        private long j = 0;
        private long k = 0;

        a(int i2, int i3, long j2, long j3) {
            super(8);
            this.d = i2;
            this.e = i3;
            this.f = 8317987319222330741L ^ j2;
            this.g = 7237128888997146477L ^ j3;
            this.h = 7816392313619706465L ^ j2;
            this.i = 8387220255154660723L ^ j3;
        }

        private void g(long j2) {
            this.i ^= j2;
            h(this.d);
            this.f = j2 ^ this.f;
        }

        private void h(int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = this.f;
                long j3 = this.g;
                this.f = j2 + j3;
                this.h += this.i;
                this.g = Long.rotateLeft(j3, 13);
                long rotateLeft = Long.rotateLeft(this.i, 16);
                this.i = rotateLeft;
                long j4 = this.g;
                long j5 = this.f;
                this.g = j4 ^ j5;
                this.i = rotateLeft ^ this.h;
                long rotateLeft2 = Long.rotateLeft(j5, 32);
                this.f = rotateLeft2;
                long j6 = this.h;
                long j7 = this.g;
                this.h = j6 + j7;
                this.f = rotateLeft2 + this.i;
                this.g = Long.rotateLeft(j7, 17);
                long rotateLeft3 = Long.rotateLeft(this.i, 21);
                this.i = rotateLeft3;
                long j8 = this.g;
                long j9 = this.h;
                this.g = j8 ^ j9;
                this.i = rotateLeft3 ^ this.f;
                this.h = Long.rotateLeft(j9, 32);
            }
        }

        @Override // com.google.common.hash.d
        public HashCode a() {
            long j2 = this.k ^ (this.j << 56);
            this.k = j2;
            g(j2);
            this.h ^= 255;
            h(this.e);
            return HashCode.fromLong(((this.f ^ this.g) ^ this.h) ^ this.i);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.d
        public void d(ByteBuffer byteBuffer) {
            this.j += 8;
            g(byteBuffer.getLong());
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.d
        public void e(ByteBuffer byteBuffer) {
            this.j += (long) byteBuffer.remaining();
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (((long) byteBuffer.get()) & 255) << i2;
                i2 += 8;
            }
        }
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        boolean z = true;
        ds1.f(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        ds1.f(i2 <= 0 ? false : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.c = i;
        this.d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.c) ^ this.d)) ^ this.k0) ^ this.k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.c + "" + this.d + jl1.BRACKET_START_STR + this.k0 + AVFSCacheConstants.COMMA_SEP + this.k1 + jl1.BRACKET_END_STR;
    }
}
