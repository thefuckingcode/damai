package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import tb.k21;
import tb.s1;

public class h extends g {

    public static final class a extends s1<Byte> implements RandomAccess {
        final /* synthetic */ byte[] a;

        a(byte[] bArr) {
            this.a = bArr;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.a.length;
        }

        public boolean b(byte b) {
            return ArraysKt___ArraysKt.p(this.a, b);
        }

        /* renamed from: c */
        public Byte get(int i) {
            return Byte.valueOf(this.a[i]);
        }

        @Override // kotlin.collections.AbstractCollection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Byte)) {
                return false;
            }
            return b(((Number) obj).byteValue());
        }

        public int d(byte b) {
            return ArraysKt___ArraysKt.z(this.a, b);
        }

        public int e(byte b) {
            return ArraysKt___ArraysKt.H(this.a, b);
        }

        @Override // tb.s1
        public final /* bridge */ int indexOf(Byte b) {
            if (!(b instanceof Byte)) {
                return -1;
            }
            return d(b.byteValue());
        }

        @Override // kotlin.collections.AbstractCollection
        public boolean isEmpty() {
            return this.a.length == 0;
        }

        @Override // tb.s1
        public final /* bridge */ int lastIndexOf(Byte b) {
            if (!(b instanceof Byte)) {
                return -1;
            }
            return e(b.byteValue());
        }
    }

    public static final class b extends s1<Integer> implements RandomAccess {
        final /* synthetic */ int[] a;

        b(int[] iArr) {
            this.a = iArr;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.a.length;
        }

        public boolean b(int i) {
            return ArraysKt___ArraysKt.q(this.a, i);
        }

        /* renamed from: c */
        public Integer get(int i) {
            return Integer.valueOf(this.a[i]);
        }

        @Override // kotlin.collections.AbstractCollection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return b(((Number) obj).intValue());
        }

        public int d(int i) {
            return ArraysKt___ArraysKt.A(this.a, i);
        }

        public int e(int i) {
            return ArraysKt___ArraysKt.I(this.a, i);
        }

        @Override // tb.s1
        public final /* bridge */ int indexOf(Integer num) {
            if (!(num instanceof Integer)) {
                return -1;
            }
            return d(num.intValue());
        }

        @Override // kotlin.collections.AbstractCollection
        public boolean isEmpty() {
            return this.a.length == 0;
        }

        @Override // tb.s1
        public final /* bridge */ int lastIndexOf(Integer num) {
            if (!(num instanceof Integer)) {
                return -1;
            }
            return e(num.intValue());
        }
    }

    public static final List<Byte> b(byte[] bArr) {
        k21.i(bArr, "<this>");
        return new a(bArr);
    }

    public static List<Integer> c(int[] iArr) {
        k21.i(iArr, "<this>");
        return new b(iArr);
    }

    public static <T> List<T> d(T[] tArr) {
        k21.i(tArr, "<this>");
        List<T> a2 = i.a(tArr);
        k21.h(a2, "asList(this)");
        return a2;
    }

    public static <T> T[] e(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        k21.i(tArr, "<this>");
        k21.i(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return e.e(objArr, objArr2, i, i2, i3);
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        k21.i(bArr, "<this>");
        f.a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        k21.h(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> T[] h(T[] tArr, int i, int i2) {
        k21.i(tArr, "<this>");
        f.a(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        k21.h(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static void i(int[] iArr, int i, int i2, int i3) {
        k21.i(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static <T> void j(T[] tArr, T t, int i, int i2) {
        k21.i(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void k(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        j(objArr, obj, i, i2);
    }

    public static final <T> void l(T[] tArr) {
        k21.i(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void m(T[] tArr, Comparator<? super T> comparator) {
        k21.i(tArr, "<this>");
        k21.i(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
