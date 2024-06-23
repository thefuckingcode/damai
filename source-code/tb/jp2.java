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
public final class jp2 implements Collection<ip2>, KMappedMarker {

    /* compiled from: Taobao */
    private static final class a implements Iterator<ip2>, KMappedMarker {
        @NotNull
        private final byte[] a;
        private int b;

        public a(@NotNull byte[] bArr) {
            k21.i(bArr, "array");
            this.a = bArr;
        }

        public byte a() {
            int i = this.b;
            byte[] bArr = this.a;
            if (i < bArr.length) {
                this.b = i + 1;
                return ip2.b(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public boolean hasNext() {
            return this.b < this.a.length;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ip2 next() {
            return ip2.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<ip2> a(byte[] bArr) {
        return new a(bArr);
    }
}
