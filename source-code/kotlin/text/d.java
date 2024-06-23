package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.w11;
import tb.ww1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d implements Sequence<w11> {
    @NotNull
    private final CharSequence a;
    private final int b;
    private final int c;
    @NotNull
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* compiled from: Taobao */
    public static final class a implements Iterator<w11>, KMappedMarker {
        private int a = -1;
        private int b;
        private int c;
        @Nullable
        private w11 d;
        private int e;
        final /* synthetic */ d f;

        a(d dVar) {
            this.f = dVar;
            int i = ww1.f(dVar.b, 0, dVar.a.length());
            this.b = i;
            this.c = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < r6.f.c) goto L_0x0023;
         */
        private final void a() {
            int i = 0;
            if (this.c < 0) {
                this.a = 0;
                this.d = null;
                return;
            }
            if (this.f.c > 0) {
                int i2 = this.e + 1;
                this.e = i2;
            }
            if (this.c <= this.f.a.length()) {
                Pair pair = (Pair) this.f.d.invoke(this.f.a, Integer.valueOf(this.c));
                if (pair == null) {
                    this.d = new w11(this.b, StringsKt__StringsKt.Z(this.f.a));
                    this.c = -1;
                } else {
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    this.d = ww1.h(this.b, intValue);
                    int i3 = intValue + intValue2;
                    this.b = i3;
                    if (intValue2 == 0) {
                        i = 1;
                    }
                    this.c = i3 + i;
                }
                this.a = 1;
            }
            this.d = new w11(this.b, StringsKt__StringsKt.Z(this.f.a));
            this.c = -1;
            this.a = 1;
        }

        @NotNull
        /* renamed from: b */
        public w11 next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                w11 w11 = this.d;
                k21.g(w11, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.d = null;
                this.a = -1;
                return w11;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull CharSequence charSequence, int i, int i2, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        k21.i(charSequence, "input");
        k21.i(function2, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<w11> iterator() {
        return new a(this);
    }
}
