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
public final class eq2 implements Collection<dq2>, KMappedMarker {

    /* compiled from: Taobao */
    private static final class a implements Iterator<dq2>, KMappedMarker {
        @NotNull
        private final short[] a;
        private int b;

        public a(@NotNull short[] sArr) {
            k21.i(sArr, "array");
            this.a = sArr;
        }

        public short a() {
            int i = this.b;
            short[] sArr = this.a;
            if (i < sArr.length) {
                this.b = i + 1;
                return dq2.b(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public boolean hasNext() {
            return this.b < this.a.length;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ dq2 next() {
            return dq2.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<dq2> a(short[] sArr) {
        return new a(sArr);
    }
}
