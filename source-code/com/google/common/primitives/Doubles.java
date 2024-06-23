package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Doubles {
    public static final int BYTES = 8;

    @GwtCompatible
    /* compiled from: Taobao */
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != doubleArrayAsList.array[doubleArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Doubles.d(this.array[i2]);
            }
            return i;
        }

        public int indexOf(Object obj) {
            int e;
            if (!(obj instanceof Double) || (e = Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int g;
            if (!(obj instanceof Double) || (g = Doubles.g(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Double> subList(int i, int i2) {
            ds1.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i3 = this.start;
            return new DoubleArrayAsList(dArr, i + i3, i3 + i2);
        }

        /* access modifiers changed from: package-private */
        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append(jl1.ARRAY_START);
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append(this.array[i]);
                } else {
                    sb.append(jl1.ARRAY_END);
                    return sb.toString();
                }
            }
        }

        DoubleArrayAsList(double[] dArr, int i, int i2) {
            this.array = dArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.AbstractList
        public Double get(int i) {
            ds1.n(i, size());
            return Double.valueOf(this.array[this.start + i]);
        }

        public Double set(int i, Double d) {
            ds1.n(i, size());
            double[] dArr = this.array;
            int i2 = this.start;
            double d2 = dArr[i2 + i];
            dArr[i2 + i] = ((Double) ds1.p(d)).doubleValue();
            return Double.valueOf(d2);
        }
    }

    /* compiled from: Taobao */
    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }

        /* access modifiers changed from: protected */
        public String doBackward(Double d) {
            return d.toString();
        }

        /* access modifiers changed from: protected */
        public Double doForward(String str) {
            return Double.valueOf(str);
        }
    }

    /* compiled from: Taobao */
    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Double.compare(dArr[i], dArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }
    }

    static {
        c();
    }

    @GwtIncompatible
    private static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)" + "(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX]" + "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)" + "[pP][+-]?\\d+#[fFdD]?") + jl1.BRACKET_END_STR).replace(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, jl1.PLUS));
    }

    public static int d(double d) {
        return Double.valueOf(d).hashCode();
    }

    /* access modifiers changed from: private */
    public static int e(double[] dArr, double d, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean f(double d) {
        return Double.NEGATIVE_INFINITY < d && d < Double.POSITIVE_INFINITY;
    }

    /* access modifiers changed from: private */
    public static int g(double[] dArr, double d, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (dArr[i3] == d) {
                return i3;
            }
        }
        return -1;
    }

    public static double[] h(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = ((Number) ds1.p(array[i])).doubleValue();
        }
        return dArr;
    }
}
