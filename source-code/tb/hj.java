package tb;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class hj implements ClosedFloatingPointRange<Float> {
    private final float a;
    private final float b;

    public boolean a(float f) {
        return f >= this.a && f <= this.b;
    }

    @NotNull
    /* renamed from: b */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @NotNull
    /* renamed from: c */
    public Float getStart() {
        return Float.valueOf(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Float f) {
        return a(f.floatValue());
    }

    public boolean d(float f, float f2) {
        return f <= f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof hj) {
            if (isEmpty() && ((hj) obj).isEmpty()) {
                return true;
            }
            hj hjVar = (hj) obj;
            if (this.a == hjVar.a) {
                if (this.b == hjVar.b) {
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
        return (Float.valueOf(this.a).hashCode() * 31) + Float.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f, Float f2) {
        return d(f.floatValue(), f2.floatValue());
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
