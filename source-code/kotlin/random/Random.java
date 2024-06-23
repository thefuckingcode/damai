package kotlin.random;

import java.io.Serializable;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;
import tb.rw1;
import tb.sq1;
import tb.tq1;
import tb.w11;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public abstract class Random {
    @NotNull
    public static final Default Default = new Default(null);
    @NotNull
    private static final Random defaultRandom = sq1.IMPLEMENTATIONS.b();

    /* compiled from: Taobao */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Taobao */
        private static final class Serialized implements Serializable {
            @NotNull
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(m40 m40) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr) {
            k21.i(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int i) {
            return Random.defaultRandom.nextBytes(i);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d) {
            return Random.defaultRandom.nextDouble(d);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr, int i, int i2) {
            k21.i(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr, i, i2);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d, double d2) {
            return Random.defaultRandom.nextDouble(d, d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr, int i, int i2) {
        k21.i(bArr, "array");
        boolean z = true;
        if (new w11(0, bArr.length).f(i) && new w11(0, bArr.length).f(i2)) {
            if (i > i2) {
                z = false;
            }
            if (z) {
                int i3 = (i2 - i) / 4;
                for (int i4 = 0; i4 < i3; i4++) {
                    int nextInt = nextInt();
                    bArr[i] = (byte) nextInt;
                    bArr[i + 1] = (byte) (nextInt >>> 8);
                    bArr[i + 2] = (byte) (nextInt >>> 16);
                    bArr[i + 3] = (byte) (nextInt >>> 24);
                    i += 4;
                }
                int i5 = i2 - i;
                int nextBits = nextBits(i5 * 8);
                for (int i6 = 0; i6 < i5; i6++) {
                    bArr[i + i6] = (byte) (nextBits >>> (i6 * 8));
                }
                return bArr;
            }
            throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
        }
        throw new IllegalArgumentException(("fromIndex (" + i + ") or toIndex (" + i2 + ") are out of range: 0.." + bArr.length + '.').toString());
    }

    public double nextDouble() {
        return tq1.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return ((float) nextBits(24)) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d) {
        return nextDouble(0.0d, d);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public long nextLong(long j) {
        return nextLong(0, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public double nextDouble(double d, double d2) {
        double d3;
        rw1.b(d, d2);
        double d4 = d2 - d;
        if (Double.isInfinite(d4)) {
            boolean z = true;
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                if (Double.isInfinite(d2) || Double.isNaN(d2)) {
                    z = false;
                }
                if (z) {
                    double d5 = (double) 2;
                    double nextDouble = nextDouble() * ((d2 / d5) - (d / d5));
                    d3 = d + nextDouble + nextDouble;
                    return d3 < d2 ? Math.nextAfter(d2, Double.NEGATIVE_INFINITY) : d3;
                }
            }
        }
        d3 = d + (nextDouble() * d4);
        if (d3 < d2) {
        }
    }

    public int nextInt(int i, int i2) {
        int i3;
        int nextInt;
        int i4;
        int nextInt2;
        boolean z;
        rw1.c(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i3 = nextBits(rw1.e(i5));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i4 = nextInt % i5;
                } while ((nextInt - i4) + (i5 - 1) < 0);
                i3 = i4;
            }
            return i + i3;
        }
        do {
            nextInt2 = nextInt();
            z = false;
            if (i <= nextInt2 && nextInt2 < i2) {
                z = true;
                continue;
            }
        } while (!z);
        return nextInt2;
    }

    public long nextLong(long j, long j2) {
        long nextLong;
        boolean z;
        long j3;
        long nextLong2;
        long j4;
        int nextInt;
        rw1.d(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(rw1.e(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j3 = (((long) nextBits(rw1.e(i2))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                j3 = ((long) nextInt) & 4294967295L;
            } else {
                do {
                    nextLong2 = nextLong() >>> 1;
                    j4 = nextLong2 % j5;
                } while ((nextLong2 - j4) + (j5 - 1) < 0);
                j3 = j4;
            }
            return j + j3;
        }
        do {
            nextLong = nextLong();
            z = false;
            if (j <= nextLong && nextLong < j2) {
                z = true;
                continue;
            }
        } while (!z);
        return nextLong;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        k21.i(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    @NotNull
    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
