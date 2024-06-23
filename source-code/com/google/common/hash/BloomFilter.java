package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.primitives.SignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.as2;
import tb.ds1;
import tb.rk1;

@Beta
/* compiled from: Taobao */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* compiled from: Taobao */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.g(((BloomFilter) bloomFilter).bits.a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i, double d) {
        return create(funnel2, (long) i, d);
    }

    @VisibleForTesting
    static long optimalNumOfBits(long j, double d) {
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        return (long) ((((double) (-j)) * Math.log(d)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long j, long j2) {
        return Math.max(1, (int) Math.round((((double) j2) / ((double) j)) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel2) throws IOException {
        RuntimeException e;
        int i;
        int i2;
        int readInt;
        ds1.q(inputStream, "InputStream");
        ds1.q(funnel2, "Funnel");
        byte b = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = as2.c(dataInputStream.readByte());
            } catch (RuntimeException e2) {
                e = e2;
                i2 = -1;
                b = readByte;
                i = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (RuntimeException e3) {
                e = e3;
                b = readByte;
                i = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
            try {
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                long[] jArr = new long[readInt];
                for (int i3 = 0; i3 < readInt; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.a(jArr), i2, funnel2, bloomFilterStrategies);
            } catch (RuntimeException e4) {
                e = e4;
                b = readByte;
                i = readInt;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
        } catch (RuntimeException e5) {
            e = e5;
            i = -1;
            i2 = -1;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double b = (double) this.bits.b();
        return com.google.common.math.a.c(((-Math.log1p(-(((double) this.bits.a()) / b))) * b) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.numHashFunctions != bloomFilter.numHashFunctions || !this.funnel.equals(bloomFilter.funnel) || !this.bits.equals(bloomFilter.bits) || !this.strategy.equals(bloomFilter.strategy)) {
            return false;
        }
        return true;
    }

    public double expectedFpp() {
        return Math.pow(((double) this.bits.a()) / ((double) bitSize()), (double) this.numHashFunctions);
    }

    public int hashCode() {
        return rk1.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        ds1.p(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        ds1.p(bloomFilter);
        ds1.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i = this.numHashFunctions;
        int i2 = bloomFilter.numHashFunctions;
        ds1.g(i == i2, "BloomFilters must have the same number of hash functions (%s != %s)", i, i2);
        ds1.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        ds1.l(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        ds1.l(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a((long) this.strategy.ordinal()));
        dataOutputStream.writeByte(as2.a((long) this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.a.length());
        for (int i = 0; i < this.bits.a.length(); i++) {
            dataOutputStream.writeLong(this.bits.a.get(i));
        }
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i, Funnel<? super T> funnel2, Strategy strategy2) {
        boolean z = true;
        ds1.f(i > 0, "numHashFunctions (%s) must be > 0", i);
        ds1.f(i > 255 ? false : z, "numHashFunctions (%s) must be <= 255", i);
        this.bits = (BloomFilterStrategies.a) ds1.p(aVar);
        this.numHashFunctions = i;
        this.funnel = (Funnel) ds1.p(funnel2);
        this.strategy = (Strategy) ds1.p(strategy2);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d) {
        return create(funnel2, j, d, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d, Strategy strategy2) {
        ds1.p(funnel2);
        boolean z = true;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        ds1.h(i >= 0, "Expected insertions (%s) must be >= 0", j);
        ds1.k(d > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
        if (d >= 1.0d) {
            z = false;
        }
        ds1.k(z, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
        ds1.p(strategy2);
        if (i == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel2, strategy2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i) {
        return create(funnel2, (long) i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j) {
        return create(funnel2, j, 0.03d);
    }
}
