package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* compiled from: Taobao */
public final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @NullableDecl
    private final T lowerEndpoint;
    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @NullableDecl
    private final T upperEndpoint;

    private GeneralRange(Comparator<? super T> comparator2, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.comparator = (Comparator) ds1.p(comparator2);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) ds1.p(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) ds1.p(boundType2);
        if (z) {
            comparator2.compare(t, t);
        }
        if (z2) {
            comparator2.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator2.compare(t, t2);
            boolean z3 = true;
            ds1.l(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                ds1.d((boundType != boundType3) | (boundType2 == boundType3 ? false : z3));
            }
        }
    }

    static <T> GeneralRange<T> all(Comparator<? super T> comparator2) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator2, false, null, boundType, false, null, boundType);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator2, true, t, boundType, false, null, BoundType.OPEN);
    }

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t = null;
        T lowerEndpoint2 = range.hasLowerBound() ? range.lowerEndpoint() : null;
        BoundType lowerBoundType2 = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        if (range.hasUpperBound()) {
            t = range.upperEndpoint();
        }
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), lowerEndpoint2, lowerBoundType2, range.hasUpperBound(), t, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType, @NullableDecl T t2, BoundType boundType2) {
        return new GeneralRange<>(comparator2, true, t, boundType, true, t2, boundType2);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator2, false, null, BoundType.OPEN, true, t, boundType);
    }

    /* access modifiers changed from: package-private */
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public boolean contains(@NullableDecl T t) {
        return !tooLow(t) && !tooHigh(t);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !getLowerBoundType().equals(generalRange.getLowerBoundType()) || !getUpperBoundType().equals(generalRange.getUpperBoundType()) || !rk1.a(getLowerEndpoint(), generalRange.getLowerEndpoint()) || !rk1.a(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* access modifiers changed from: package-private */
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* access modifiers changed from: package-private */
    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    /* access modifiers changed from: package-private */
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* access modifiers changed from: package-private */
    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* access modifiers changed from: package-private */
    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return rk1.b(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    /* access modifiers changed from: package-private */
    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        BoundType boundType;
        BoundType boundType2;
        T t;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        ds1.p(generalRange);
        ds1.d(this.comparator.equals(generalRange.comparator));
        boolean z = this.hasLowerBound;
        T lowerEndpoint2 = getLowerEndpoint();
        BoundType lowerBoundType2 = getLowerBoundType();
        if (!hasLowerBound()) {
            z = generalRange.hasLowerBound;
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare3 = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare3 == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        }
        boolean z2 = this.hasUpperBound;
        T upperEndpoint2 = getUpperEndpoint();
        BoundType upperBoundType2 = getUpperBoundType();
        if (!hasUpperBound()) {
            z2 = generalRange.hasUpperBound;
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        }
        if (!z || !z2 || ((compare = this.comparator.compare(lowerEndpoint2, upperEndpoint2)) <= 0 && !(compare == 0 && lowerBoundType2 == (boundType3 = BoundType.OPEN) && upperBoundType2 == boundType3))) {
            t = lowerEndpoint2;
            boundType2 = lowerBoundType2;
            boundType = upperBoundType2;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t = upperEndpoint2;
        }
        return new GeneralRange<>(this.comparator, z, t, boundType2, z2, upperEndpoint2, boundType);
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    /* access modifiers changed from: package-private */
    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? jl1.ARRAY_START : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == boundType2 ? jl1.ARRAY_END : ')');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean tooHigh(@NullableDecl T t) {
        boolean z = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (getUpperBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: package-private */
    public boolean tooLow(@NullableDecl T t) {
        boolean z = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (getLowerBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }
}
