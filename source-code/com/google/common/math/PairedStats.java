package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.e;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    PairedStats(Stats stats, Stats stats2, double d) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d;
    }

    private static double ensureInUnitRange(double d) {
        if (d >= 1.0d) {
            return 1.0d;
        }
        if (d <= -1.0d) {
            return -1.0d;
        }
        return d;
    }

    private static double ensurePositive(double d) {
        if (d > 0.0d) {
            return d;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        ds1.p(bArr);
        ds1.g(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        if (!this.xStats.equals(pairedStats.xStats) || !this.yStats.equals(pairedStats.yStats) || Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return rk1.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public d leastSquaresFit() {
        boolean z = true;
        ds1.w(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return d.a();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= 0.0d) {
            if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) {
                z = false;
            }
            ds1.w(z);
            return d.d(this.xStats.mean());
        } else if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
            return d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        } else {
            return d.b(this.yStats.mean());
        }
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z = true;
        ds1.w(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        ds1.w(sumOfSquaresOfDeltas > 0.0d);
        if (sumOfSquaresOfDeltas2 <= 0.0d) {
            z = false;
        }
        ds1.w(z);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        ds1.w(count() != 0);
        return this.sumOfProductsOfDeltas / ((double) count());
    }

    public double sampleCovariance() {
        ds1.w(count() > 1);
        return this.sumOfProductsOfDeltas / ((double) (count() - 1));
    }

    /* access modifiers changed from: package-private */
    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return e.b(this).d("xStats", this.xStats).d("yStats", this.yStats).a("populationCovariance", populationCovariance()).toString();
        }
        return e.b(this).d("xStats", this.xStats).d("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
