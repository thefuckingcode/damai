package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible
/* compiled from: Taobao */
public final class l {
    static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder c(int i) {
        k.b(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
    }

    static boolean d(Collection<?> collection, @NullableDecl Object obj) {
        ds1.p(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean e(Collection<?> collection, @NullableDecl Object obj) {
        ds1.p(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static String f(Collection<?> collection) {
        StringBuilder c = c(collection.size());
        c.append(jl1.ARRAY_START);
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                c.append(AVFSCacheConstants.COMMA_SEP);
            }
            z = false;
            if (obj == collection) {
                c.append("(this Collection)");
            } else {
                c.append(obj);
            }
        }
        c.append(jl1.ARRAY_END);
        return c.toString();
    }
}
