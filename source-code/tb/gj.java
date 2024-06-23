package tb;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class gj implements ClosedFloatingPointRange<Double> {
    private final double a;
    private final double b;

    public boolean a(double d) {
        return d >= this.a && d <= this.b;
    }

    @NotNull
    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    @NotNull
    /* renamed from: c */
    public Double getStart() {
        return Double.valueOf(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Double d) {
        return a(d.doubleValue());
    }

    public boolean d(double d, double d2) {
        return d <= d2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof gj) {
            if (isEmpty() && ((gj) obj).isEmpty()) {
                return true;
            }
            gj gjVar = (gj) obj;
            if (this.a == gjVar.a) {
                if (this.b == gjVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.a).hashCode() * 31) + Double.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Double d, Double d2) {
        return d(d.doubleValue(), d2.doubleValue());
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
