package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class o extends n {

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        final /* synthetic */ Enumeration<T> a;

        a(Enumeration<T> enumeration) {
            this.a = enumeration;
        }

        public boolean hasNext() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.nextElement();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static <T> Iterator<T> s(@NotNull Enumeration<T> enumeration) {
        k21.i(enumeration, "<this>");
        return new a(enumeration);
    }
}
