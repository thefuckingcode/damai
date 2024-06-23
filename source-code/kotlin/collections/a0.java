package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a0<T> extends b<T> {
    @NotNull
    private final List<T> a;

    public a0(@NotNull List<T> list) {
        k21.i(list, "delegate");
        this.a = list;
    }

    @Override // kotlin.collections.b, java.util.List, java.util.AbstractList
    public void add(int i, T t) {
        this.a.add(s.F(this, i), t);
    }

    public void clear() {
        this.a.clear();
    }

    @Override // java.util.List, java.util.AbstractList
    public T get(int i) {
        return this.a.get(s.E(this, i));
    }

    @Override // kotlin.collections.b
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.b
    public T removeAt(int i) {
        return this.a.remove(s.E(this, i));
    }

    @Override // kotlin.collections.b, java.util.List, java.util.AbstractList
    public T set(int i, T t) {
        return this.a.set(s.E(this, i), t);
    }
}
