package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class b0 {
    @CanIgnoreReturnValue
    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }

    @CanIgnoreReturnValue
    static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    @CanIgnoreReturnValue
    static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    @CanIgnoreReturnValue
    private static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i) {
        return (T[]) e0.b(tArr, i);
    }

    static Object[] f(Collection<?> collection) {
        return d(collection, new Object[collection.size()]);
    }

    static <T> T[] g(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    static <T> T[] h(Object[] objArr, int i, int i2, T[] tArr) {
        ds1.v(i, i + i2, objArr.length);
        if (tArr.length < i2) {
            tArr = (T[]) e(tArr, i2);
        } else if (tArr.length > i2) {
            tArr[i2] = null;
        }
        System.arraycopy(objArr, i, tArr, 0, i2);
        return tArr;
    }
}
