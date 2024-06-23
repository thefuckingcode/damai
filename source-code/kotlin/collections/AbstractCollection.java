package kotlin.collections;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Collection;
import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;
import tb.pj;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    protected AbstractCollection() {
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        for (E e2 : this) {
            if (k21.d(e2, e)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    @NotNull
    public Object[] toArray() {
        return pj.a(this);
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.Z(this, AVFSCacheConstants.COMMA_SEP, jl1.ARRAY_START_STR, jl1.ARRAY_END_STR, 0, null, new AbstractCollection$toString$1(this), 24, null);
    }

    @Override // java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        k21.i(tArr, "array");
        T[] tArr2 = (T[]) pj.b(this, tArr);
        k21.g(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return tArr2;
    }
}
