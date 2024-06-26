package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b = aVar.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!aVar.d(((long) i5) % b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b = aVar.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= aVar.f(((long) i5) % b);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 {
        private long lowerEight(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!aVar.d((AbsPerformance.LONG_NIL & lowerEight) % b)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= aVar.f((AbsPerformance.LONG_NIL & lowerEight) % b);
                lowerEight += upperEight;
            }
            return z;
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a {
        final AtomicLongArray a;
        private final LongAddable b;

        a(long j) {
            ds1.e(j > 0, "data length is zero!");
            this.a = new AtomicLongArray(Ints.c(LongMath.a(j, 64, RoundingMode.CEILING)));
            this.b = LongAddables.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.b.sum();
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return ((long) this.a.length()) * 64;
        }

        /* access modifiers changed from: package-private */
        public a c() {
            return new a(g(this.a));
        }

        /* access modifiers changed from: package-private */
        public boolean d(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        /* access modifiers changed from: package-private */
        public void e(a aVar) {
            long j;
            long j2;
            boolean z;
            ds1.g(this.a.length() == aVar.a.length(), "BitArrays must be of equal length (%s != %s)", this.a.length(), aVar.a.length());
            for (int i = 0; i < this.a.length(); i++) {
                long j3 = aVar.a.get(i);
                while (true) {
                    j = this.a.get(i);
                    j2 = j | j3;
                    if (j != j2) {
                        if (this.a.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.b.add((long) (Long.bitCount(j2) - Long.bitCount(j)));
                }
            }
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(g(this.a), g(((a) obj).a));
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean f(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.a));
        }

        a(long[] jArr) {
            ds1.e(jArr.length > 0, "data length is zero!");
            this.a = new AtomicLongArray(jArr);
            this.b = LongAddables.a();
            long j = 0;
            for (long j2 : jArr) {
                j += (long) Long.bitCount(j2);
            }
            this.b.add(j);
        }
    }
}
