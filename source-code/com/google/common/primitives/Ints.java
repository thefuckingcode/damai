package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible
/* compiled from: Taobao */
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    @GwtCompatible
    /* compiled from: Taobao */
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.g(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Ints.f(this.array[i2]);
            }
            return i;
        }

        public int indexOf(Object obj) {
            int g;
            if (!(obj instanceof Integer) || (g = Ints.g(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int h;
            if (!(obj instanceof Integer) || (h = Ints.h(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return h - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Integer> subList(int i, int i2) {
            ds1.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i3 = this.start;
            return new IntArrayAsList(iArr, i + i3, i3 + i2);
        }

        /* access modifiers changed from: package-private */
        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.AbstractList
        public Integer get(int i) {
            ds1.n(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public Integer set(int i, Integer num) {
            ds1.n(i, size());
            int[] iArr = this.array;
            int i2 = this.start;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) ds1.p(num)).intValue();
            return Integer.valueOf(i3);
        }
    }

    /* compiled from: Taobao */
    private static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        /* access modifiers changed from: protected */
        public String doBackward(Integer num) {
            return num.toString();
        }

        /* access modifiers changed from: protected */
        public Integer doForward(String str) {
            return Integer.decode(str);
        }
    }

    /* compiled from: Taobao */
    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int d = Ints.d(iArr[i], iArr2[i]);
                if (d != 0) {
                    return d;
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int c(long j) {
        int i = (int) j;
        ds1.h(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int d(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int e(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static int f(int i) {
        return i;
    }

    /* access modifiers changed from: private */
    public static int g(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int h(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int i(int... iArr) {
        ds1.d(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int j(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] k(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) ds1.p(array[i])).intValue();
        }
        return iArr;
    }
}
