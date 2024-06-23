package tb;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class t01<T> implements Iterable<s01<? extends T>>, KMappedMarker {
    @NotNull
    private final Function0<Iterator<T>> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.Iterator<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public t01(@NotNull Function0<? extends Iterator<? extends T>> function0) {
        k21.i(function0, "iteratorFactory");
        this.a = function0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<s01<T>> iterator() {
        return new u01(this.a.invoke());
    }
}
