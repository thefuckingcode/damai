package kotlin.collections;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.text.h;
import tb.do2;
import tb.k21;
import tb.s01;
import tb.t01;
import tb.ww1;

public class CollectionsKt___CollectionsKt extends t {

    public static final class a implements Sequence<T> {
        final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    public static <T> List<T> A0(Collection<? extends T> collection) {
        k21.i(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> B0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) v0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> C0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e0.f((Set) v0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return e0.d();
        }
        if (size != 1) {
            return (Set) v0(iterable, new LinkedHashSet(w.e(collection.size())));
        }
        return d0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static <T> Set<T> D0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        k21.i(iterable, "<this>");
        k21.i(iterable2, "other");
        Set<T> set = B0(iterable);
        boolean unused = r.v(set, iterable2);
        return set;
    }

    public static <T> Iterable<s01<T>> E0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        return new t01(new CollectionsKt___CollectionsKt$withIndex$1(iterable));
    }

    public static <T, R> List<Pair<T, R>> F0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        k21.i(iterable, "<this>");
        k21.i(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(n.q(iterable, 10), n.q(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(do2.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> boolean H(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        k21.i(iterable, "<this>");
        k21.i(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static <T> Sequence<T> I(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean J(Iterable<? extends T> iterable, T t) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return T(iterable, t) >= 0;
    }

    public static <T> List<T> K(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        return y0(B0(iterable));
    }

    public static <T> List<T> L(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        k21.i(iterable, "<this>");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return y0(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return m.g();
                }
                if (size == 1) {
                    return l.e(k.a0(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object obj : iterable) {
                if (i2 >= i) {
                    arrayList.add(obj);
                } else {
                    i2++;
                }
            }
            return m.n(arrayList);
        }
    }

    public static <T> List<T> M(List<? extends T> list, int i) {
        k21.i(list, "<this>");
        if (i >= 0) {
            return t0(list, ww1.a(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static <T> List<T> N(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        k21.i(iterable, "<this>");
        k21.i(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T O(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) k.P((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T P(List<? extends T> list) {
        k21.i(list, "<this>");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T Q(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return (T) it.next();
    }

    public static <T> T R(List<? extends T> list) {
        k21.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    public static <T> T S(List<? extends T> list, int i) {
        k21.i(list, "<this>");
        if (i < 0 || i > m.i(list)) {
            return null;
        }
        return (T) list.get(i);
    }

    public static final <T> int T(Iterable<? extends T> iterable, T t) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (Object obj : iterable) {
            if (i < 0) {
                m.p();
            }
            if (k21.d(t, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> int U(List<? extends T> list, T t) {
        k21.i(list, "<this>");
        return list.indexOf(t);
    }

    public static <T> Set<T> V(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        k21.i(iterable, "<this>");
        k21.i(iterable2, "other");
        Set<T> set = B0(iterable);
        r.A(set, iterable2);
        return set;
    }

    public static final <T, A extends Appendable> A W(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        k21.i(iterable, "<this>");
        k21.i(a2, "buffer");
        k21.i(charSequence, "separator");
        k21.i(charSequence2, Constants.Name.PREFIX);
        k21.i(charSequence3, "postfix");
        k21.i(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            h.a(a2, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ Appendable X(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? AVFSCacheConstants.COMMA_SEP : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return W(iterable, appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    public static <T> String Y(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        k21.i(iterable, "<this>");
        k21.i(charSequence, "separator");
        k21.i(charSequence2, Constants.Name.PREFIX);
        k21.i(charSequence3, "postfix");
        k21.i(charSequence4, "truncated");
        String sb = ((StringBuilder) W(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        k21.h(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String Z(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = AVFSCacheConstants.COMMA_SEP;
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return Y(iterable, charSequence, charSequence6, charSequence5, i3, charSequence4, function1);
    }

    public static <T> T a0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) k.b0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            while (it.hasNext()) {
                t = (T) it.next();
            }
            return t;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T b0(List<? extends T> list) {
        k21.i(list, "<this>");
        if (!list.isEmpty()) {
            return (T) list.get(m.i(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T c0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        while (it.hasNext()) {
            t = (T) it.next();
        }
        return t;
    }

    public static <T> T d0(List<? extends T> list) {
        k21.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(list.size() - 1);
    }

    public static <T, R> List<R> e0(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        k21.i(iterable, "<this>");
        k21.i(function1, "transform");
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((Object) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <T extends Comparable<? super T>> T f0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) ((Comparable) it.next());
        while (it.hasNext()) {
            ?? r1 = (Comparable) it.next();
            if (t.compareTo(r1) < 0) {
                t = r1;
            }
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <T extends Comparable<? super T>> T g0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) ((Comparable) it.next());
        while (it.hasNext()) {
            ?? r1 = (Comparable) it.next();
            if (t.compareTo(r1) > 0) {
                t = r1;
            }
        }
        return t;
    }

    public static <T> List<T> h0(Iterable<? extends T> iterable, T t) {
        k21.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        boolean z = false;
        for (Object obj : iterable) {
            boolean z2 = true;
            if (!z && k21.d(obj, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> List<T> i0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        k21.i(iterable, "<this>");
        k21.i(iterable2, "elements");
        if (iterable instanceof Collection) {
            return k0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        boolean unused = r.v(arrayList, iterable);
        boolean unused2 = r.v(arrayList, iterable2);
        return arrayList;
    }

    public static <T> List<T> j0(Iterable<? extends T> iterable, T t) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return l0((Collection) iterable, t);
        }
        ArrayList arrayList = new ArrayList();
        boolean unused = r.v(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> k0(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        k21.i(collection, "<this>");
        k21.i(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        boolean unused = r.v(arrayList2, iterable);
        return arrayList2;
    }

    public static <T> List<T> l0(Collection<? extends T> collection, T t) {
        k21.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> m0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return y0(iterable);
        }
        List<T> z0 = z0(iterable);
        t.G(z0);
        return z0;
    }

    public static <T> T n0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) k.o0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            if (!it.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T o0(List<? extends T> list) {
        k21.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return (T) list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T> T p0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        if (it.hasNext()) {
            return null;
        }
        return t;
    }

    public static <T> T q0(List<? extends T> list) {
        k21.i(list, "<this>");
        if (list.size() == 1) {
            return (T) list.get(0);
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> r0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return y0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sorted>");
            Comparable[] comparableArr = (Comparable[]) array;
            h.l(comparableArr);
            return h.d(comparableArr);
        }
        List<T> z0 = z0(iterable);
        q.t(z0);
        return z0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> s0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        k21.i(iterable, "<this>");
        k21.i(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return y0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
            h.m(array, comparator);
            return h.d(array);
        }
        List<T> z0 = z0(iterable);
        q.u(z0, comparator);
        return z0;
    }

    public static final <T> List<T> t0(Iterable<? extends T> iterable, int i) {
        k21.i(iterable, "<this>");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return m.g();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return y0(iterable);
                }
                if (i == 1) {
                    return l.e(k.O(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return m.n(arrayList);
        }
    }

    public static <T> List<T> u0(List<? extends T> list, int i) {
        k21.i(list, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return m.g();
        } else {
            int size = list.size();
            if (i >= size) {
                return y0(list);
            }
            if (i == 1) {
                return l.e(k.b0(list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i2 = size - i; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
    }

    public static final <T, C extends Collection<? super T>> C v0(Iterable<? extends T> iterable, C c) {
        k21.i(iterable, "<this>");
        k21.i(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> HashSet<T> w0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        return (HashSet) v0(iterable, new HashSet(w.e(n.q(iterable, 12))));
    }

    public static int[] x0(Collection<Integer> collection) {
        k21.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    public static <T> List<T> y0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m.n(z0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m.g();
        }
        if (size != 1) {
            return A0(collection);
        }
        return l.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> z0(Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return A0((Collection) iterable);
        }
        return (List) v0(iterable, new ArrayList());
    }
}
