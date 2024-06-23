package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    /* compiled from: Taobao */
    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i = 0; i < min; i++) {
                int c = Shorts.c(sArr[i], sArr2[i]);
                if (c != 0) {
                    return c;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @GwtCompatible
    /* compiled from: Taobao */
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        public boolean contains(@NullableDecl Object obj) {
            return (obj instanceof Short) && Shorts.e(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != shortArrayAsList.array[shortArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Shorts.d(this.array[i2]);
            }
            return i;
        }

        public int indexOf(@NullableDecl Object obj) {
            int e;
            if (!(obj instanceof Short) || (e = Shorts.e(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@NullableDecl Object obj) {
            int f;
            if (!(obj instanceof Short) || (f = Shorts.f(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Short> subList(int i, int i2) {
            ds1.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i3 = this.start;
            return new ShortArrayAsList(sArr, i + i3, i3 + i2);
        }

        /* access modifiers changed from: package-private */
        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append(jl1.ARRAY_START);
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append((int) this.array[i]);
                } else {
                    sb.append(jl1.ARRAY_END);
                    return sb.toString();
                }
            }
        }

        ShortArrayAsList(short[] sArr, int i, int i2) {
            this.array = sArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.AbstractList
        public Short get(int i) {
            ds1.n(i, size());
            return Short.valueOf(this.array[this.start + i]);
        }

        public Short set(int i, Short sh) {
            ds1.n(i, size());
            short[] sArr = this.array;
            int i2 = this.start;
            short s = sArr[i2 + i];
            sArr[i2 + i] = ((Short) ds1.p(sh)).shortValue();
            return Short.valueOf(s);
        }
    }

    /* compiled from: Taobao */
    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        /* access modifiers changed from: protected */
        public String doBackward(Short sh) {
            return sh.toString();
        }

        /* access modifiers changed from: protected */
        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    public static int c(short s, short s2) {
        return s - s2;
    }

    public static int d(short s) {
        return s;
    }

    /* access modifiers changed from: private */
    public static int e(short[] sArr, short s, int i, int i2) {
        while (i < i2) {
            if (sArr[i] == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int f(short[] sArr, short s, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (sArr[i3] == s) {
                return i3;
            }
        }
        return -1;
    }
}
