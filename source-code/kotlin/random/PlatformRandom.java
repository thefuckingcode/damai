package kotlin.random;

import java.io.Serializable;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import tb.a2;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
final class PlatformRandom extends a2 implements Serializable {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull
    private final Random impl;

    /* compiled from: Taobao */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public PlatformRandom(@NotNull Random random) {
        k21.i(random, "impl");
        this.impl = random;
    }

    @Override // tb.a2
    @NotNull
    public Random getImpl() {
        return this.impl;
    }
}
