package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public abstract class c<E> extends AbstractSet<E> implements Set<E> {
    protected c() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e);

    public abstract int getSize();

    public final /* bridge */ int size() {
        return getSize();
    }
}
