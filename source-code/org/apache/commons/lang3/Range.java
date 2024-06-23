package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;
import tb.jl1;

/* compiled from: Taobao */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    /* compiled from: Taobao */
    private enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    private Range(T t, T t2, Comparator<T> comparator2) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + ((Object) t) + ", element2=" + ((Object) t2));
        }
        if (comparator2 == null) {
            this.comparator = ComparableComparator.INSTANCE;
        } else {
            this.comparator = comparator2;
        }
        if (this.comparator.compare(t, t2) < 1) {
            this.minimum = t;
            this.maximum = t2;
            return;
        }
        this.minimum = t2;
        this.maximum = t;
    }

    public static <T extends Comparable<T>> Range<T> between(T t, T t2) {
        return between(t, t2, null);
    }

    public static <T extends Comparable<T>> Range<T> is(T t) {
        return between(t, t, null);
    }

    public boolean contains(T t) {
        return t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1;
    }

    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    public int elementCompareTo(T t) {
        Validate.notNull(t, "Element is null", new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        if (isBefore(t)) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.minimum.equals(range.minimum) || !this.maximum.equals(range.maximum)) {
            return false;
        }
        return true;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = ((((629 + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37) + this.maximum.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public Range<T> intersectionWith(Range<T> range) {
        if (!isOverlappedBy(range)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
        } else if (equals(range)) {
            return this;
        } else {
            return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
        }
    }

    public boolean isAfter(T t) {
        return t != null && this.comparator.compare(t, this.minimum) < 0;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t) {
        return t != null && this.comparator.compare(t, this.maximum) > 0;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t) {
        return t != null && this.comparator.compare(t, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    public boolean isStartedBy(T t) {
        return t != null && this.comparator.compare(t, this.minimum) == 0;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = jl1.ARRAY_START_STR + ((Object) this.minimum) + ".." + ((Object) this.maximum) + jl1.ARRAY_END_STR;
        }
        return this.toString;
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator2) {
        return new Range<>(t, t2, comparator2);
    }

    public static <T> Range<T> is(T t, Comparator<T> comparator2) {
        return between(t, t, comparator2);
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }
}
