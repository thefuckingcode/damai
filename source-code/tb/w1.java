package tb;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public abstract class w1<E> extends AbstractCollection<E> implements Collection<E> {
    protected w1() {
    }

    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
