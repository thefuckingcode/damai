package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.as2;
import tb.jl1;

/* access modifiers changed from: package-private */
@Immutable
/* compiled from: Taobao */
public final class Murmur3_128HashFunction extends b implements Serializable {
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.a);
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    /* compiled from: Taobao */
    private static final class a extends d {
        private long d;
        private long e;
        private int f = 0;

        a(int i) {
            super(16);
            long j = (long) i;
            this.d = j;
            this.e = j;
        }

        private void g(long j, long j2) {
            long i = i(j) ^ this.d;
            this.d = i;
            long rotateLeft = Long.rotateLeft(i, 27);
            this.d = rotateLeft;
            long j3 = this.e;
            long j4 = rotateLeft + j3;
            this.d = j4;
            this.d = (j4 * 5) + 1390208809;
            long j5 = j(j2) ^ j3;
            this.e = j5;
            long rotateLeft2 = Long.rotateLeft(j5, 31);
            this.e = rotateLeft2;
            long j6 = rotateLeft2 + this.d;
            this.e = j6;
            this.e = (j6 * 5) + 944331445;
        }

        private static long h(long j) {
            long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
            long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j3 ^ (j3 >>> 33);
        }

        private static long i(long j) {
            return Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
        }

        private static long j(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * -8663945395140668459L;
        }

        @Override // com.google.common.hash.d
        public HashCode a() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ ((long) i);
            this.d = j2;
            long j3 = this.e ^ ((long) i);
            this.e = j3;
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = h(j4);
            long h = h(this.e);
            this.e = h;
            long j5 = this.d + h;
            this.d = j5;
            this.e = h + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.d
        public void d(ByteBuffer byteBuffer) {
            g(byteBuffer.getLong(), byteBuffer.getLong());
            this.f += 16;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.d
        public void e(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.f += byteBuffer.remaining();
            long j15 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j2 = 0;
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 2:
                    j3 = 0;
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 3:
                    j4 = 0;
                    j3 = j4 ^ (((long) as2.c(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 4:
                    j5 = 0;
                    j4 = j5 ^ (((long) as2.c(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) as2.c(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 5:
                    j6 = 0;
                    j5 = j6 ^ (((long) as2.c(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) as2.c(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) as2.c(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 6:
                    j7 = 0;
                    j6 = j7 ^ (((long) as2.c(byteBuffer.get(5))) << 40);
                    j5 = j6 ^ (((long) as2.c(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) as2.c(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) as2.c(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 7:
                    j7 = (((long) as2.c(byteBuffer.get(6))) << 48) ^ 0;
                    j6 = j7 ^ (((long) as2.c(byteBuffer.get(5))) << 40);
                    j5 = j6 ^ (((long) as2.c(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) as2.c(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) as2.c(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) as2.c(byteBuffer.get(1))) << 8);
                    j = ((long) as2.c(byteBuffer.get(0))) ^ j2;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 8:
                    j8 = 0;
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 9:
                    j9 = 0;
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ (((long) as2.c(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 12:
                    j12 = 0;
                    j11 = j12 ^ (((long) as2.c(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) as2.c(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ (((long) as2.c(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) as2.c(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) as2.c(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ (((long) as2.c(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) as2.c(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) as2.c(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) as2.c(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                case 15:
                    j14 = (((long) as2.c(byteBuffer.get(14))) << 48) ^ 0;
                    j13 = j14 ^ (((long) as2.c(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) as2.c(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) as2.c(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) as2.c(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) as2.c(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) as2.c(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= i(j);
                    this.e ^= j(j15);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Murmur3_128HashFunction) || this.seed != ((Murmur3_128HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + jl1.BRACKET_END_STR;
    }
}
