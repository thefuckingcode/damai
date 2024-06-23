package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@Immutable
@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((Integer) obj2).intValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.parent.hashCode();
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int size() {
            return this.parent.length();
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Integer> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        @Override // java.util.List, java.util.AbstractList
        public Integer get(int i) {
            return Integer.valueOf(this.parent.get(i));
        }
    }

    @CanIgnoreReturnValue
    /* compiled from: Taobao */
    public static final class b {
        private int[] a;
        private int b = 0;

        b(int i) {
            this.a = new int[i];
        }

        private void e(int i) {
            int i2 = this.b + i;
            int[] iArr = this.a;
            if (i2 > iArr.length) {
                int[] iArr2 = new int[f(iArr.length, i2)];
                System.arraycopy(this.a, 0, iArr2, 0, this.b);
                this.a = iArr2;
            }
        }

        private static int f(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i3;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public b a(int i) {
            e(1);
            int[] iArr = this.a;
            int i2 = this.b;
            iArr[i2] = i;
            this.b = i2 + 1;
            return this;
        }

        public b b(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            for (Integer num : iterable) {
                a(num.intValue());
            }
            return this;
        }

        public b c(Collection<Integer> collection) {
            e(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.a;
                int i = this.b;
                this.b = i + 1;
                iArr[i] = num.intValue();
            }
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray d() {
            return this.b == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.a, 0, this.b);
        }
    }

    public static b builder(int i) {
        ds1.f(i >= 0, "Invalid initialCapacity: %s", i);
        return new b(i);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        ds1.n(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Ints.f(this.array[i2]);
        }
        return i;
    }

    public int indexOf(int i) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == i) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i) {
        int i2 = this.end;
        while (true) {
            i2--;
            int i3 = this.start;
            if (i2 < i3) {
                return -1;
            }
            if (this.array[i2] == i) {
                return i2 - i3;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i, int i2) {
        ds1.v(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
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

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.k(collection));
    }

    public static ImmutableIntArray of(int i) {
        return new ImmutableIntArray(new int[]{i});
    }

    private ImmutableIntArray(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) ((Collection) iterable));
        }
        return builder().b(iterable).d();
    }

    public static ImmutableIntArray of(int i, int i2) {
        return new ImmutableIntArray(new int[]{i, i2});
    }

    public static ImmutableIntArray of(int i, int i2, int i3) {
        return new ImmutableIntArray(new int[]{i, i2, i3});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i, int... iArr) {
        ds1.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
