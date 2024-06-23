package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public abstract class b<E> extends AbstractList<E> implements List<E> {
    protected b() {
    }

    @Override // java.util.List, java.util.AbstractList
    public abstract void add(int i, E e);

    public abstract int getSize();

    @Override // java.util.List, java.util.AbstractList
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    public abstract E removeAt(int i);

    @Override // java.util.List, java.util.AbstractList
    public abstract E set(int i, E e);

    public final /* bridge */ int size() {
        return getSize();
    }
}
