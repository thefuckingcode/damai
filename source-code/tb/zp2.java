package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
@JvmInline
/* compiled from: Taobao */
public final class zp2 implements Collection<yp2>, KMappedMarker {

    /* compiled from: Taobao */
    private static final class a implements Iterator<yp2>, KMappedMarker {
        @NotNull
        private final long[] a;
        private int b;

        public a(@NotNull long[] jArr) {
            k21.i(jArr, "array");
            this.a = jArr;
        }

        public long a() {
            int i = this.b;
            long[] jArr = this.a;
            if (i < jArr.length) {
                this.b = i + 1;
                return yp2.b(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public boolean hasNext() {
            return this.b < this.a.length;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ yp2 next() {
            return yp2.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<yp2> a(long[] jArr) {
        return new a(jArr);
    }
}
