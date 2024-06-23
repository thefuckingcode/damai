package com.google.common.math;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.e;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static Stats fromByteArray(byte[] bArr) {
        ds1.p(bArr);
        ds1.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        f fVar = new f();
        fVar.b(iterable);
        return fVar.h();
    }

    static Stats readFrom(ByteBuffer byteBuffer) {
        ds1.p(byteBuffer);
        ds1.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        if (this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return rk1.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        ds1.w(this.count != 0);
        return this.max;
    }

    public double mean() {
        ds1.w(this.count != 0);
        return this.mean;
    }

    public double min() {
        ds1.w(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        ds1.w(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return b.a(this.sumOfSquaresOfDeltas) / ((double) count());
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        ds1.w(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return b.a(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public double sum() {
        return this.mean * ((double) this.count);
    }

    /* access modifiers changed from: package-private */
    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return e.b(this).c(AdUtConstants.XAD_UT_ARG_COUNT, this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString();
        }
        return e.b(this).c(AdUtConstants.XAD_UT_ARG_COUNT, this.count).toString();
    }

    /* access modifiers changed from: package-private */
    public void writeTo(ByteBuffer byteBuffer) {
        ds1.p(byteBuffer);
        ds1.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        ds1.d(it.hasNext());
        double doubleValue = ((Number) it.next()).doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            j++;
            if (!Doubles.f(doubleValue2) || !Doubles.f(doubleValue)) {
                doubleValue = f.g(doubleValue, doubleValue2);
            } else {
                doubleValue += (doubleValue2 - doubleValue) / ((double) j);
            }
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        f fVar = new f();
        fVar.c(it);
        return fVar.h();
    }

    public static Stats of(double... dArr) {
        f fVar = new f();
        fVar.d(dArr);
        return fVar.h();
    }

    public static double meanOf(double... dArr) {
        ds1.d(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (!Doubles.f(d2) || !Doubles.f(d)) {
                d = f.g(d, d2);
            } else {
                d += (d2 - d) / ((double) (i + 1));
            }
        }
        return d;
    }

    public static Stats of(int... iArr) {
        f fVar = new f();
        fVar.e(iArr);
        return fVar.h();
    }

    public static Stats of(long... jArr) {
        f fVar = new f();
        fVar.f(jArr);
        return fVar.h();
    }

    public static double meanOf(int... iArr) {
        ds1.d(iArr.length > 0);
        double d = (double) iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d2 = (double) iArr[i];
            if (!Doubles.f(d2) || !Doubles.f(d)) {
                d = f.g(d, d2);
            } else {
                d += (d2 - d) / ((double) (i + 1));
            }
        }
        return d;
    }

    public static double meanOf(long... jArr) {
        ds1.d(jArr.length > 0);
        double d = (double) jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d2 = (double) jArr[i];
            if (!Doubles.f(d2) || !Doubles.f(d)) {
                d = f.g(d, d2);
            } else {
                d += (d2 - d) / ((double) (i + 1));
            }
        }
        return d;
    }
}
