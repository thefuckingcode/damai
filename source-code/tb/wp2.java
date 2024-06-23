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
public final class wp2 implements Collection<vp2>, KMappedMarker {

    /* compiled from: Taobao */
    private static final class a implements Iterator<vp2>, KMappedMarker {
        @NotNull
        private final int[] a;
        private int b;

        public a(@NotNull int[] iArr) {
            k21.i(iArr, "array");
            this.a = iArr;
        }

        public int a() {
            int i = this.b;
            int[] iArr = this.a;
            if (i < iArr.length) {
                this.b = i + 1;
                return vp2.b(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public boolean hasNext() {
            return this.b < this.a.length;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ vp2 next() {
            return vp2.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<vp2> a(int[] iArr) {
        return new a(iArr);
    }
}
