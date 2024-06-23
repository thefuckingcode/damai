package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger ZERO = fromIntBits(0);
    private final int value;

    private UnsignedInteger(int i) {
        this.value = i & -1;
    }

    public static UnsignedInteger fromIntBits(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger valueOf(long j) {
        ds1.h((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.b(this.value, ((UnsignedInteger) ds1.p(unsignedInteger)).value));
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof UnsignedInteger) || this.value != ((UnsignedInteger) obj).value) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) longValue();
    }

    public int hashCode() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return UnsignedInts.f(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value - ((UnsignedInteger) ds1.p(unsignedInteger)).value);
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.e(this.value, ((UnsignedInteger) ds1.p(unsignedInteger)).value));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value + ((UnsignedInteger) ds1.p(unsignedInteger)).value);
    }

    @GwtIncompatible
    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value * ((UnsignedInteger) ds1.p(unsignedInteger)).value);
    }

    public String toString() {
        return toString(10);
    }

    public int compareTo(UnsignedInteger unsignedInteger) {
        ds1.p(unsignedInteger);
        return UnsignedInts.a(this.value, unsignedInteger.value);
    }

    public String toString(int i) {
        return UnsignedInts.g(this.value, i);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        ds1.p(bigInteger);
        ds1.k(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i) {
        return fromIntBits(UnsignedInts.d(str, i));
    }
}
