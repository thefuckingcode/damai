package kotlin.random;

import java.util.Random;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
final class KotlinRandom extends Random {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull
    private final Random impl;
    private boolean seedInitialized;

    /* compiled from: Taobao */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public KotlinRandom(@NotNull Random random) {
        k21.i(random, "impl");
        this.impl = random;
    }

    @NotNull
    public final Random getImpl() {
        return this.impl;
    }

    /* access modifiers changed from: protected */
    public int next(int i) {
        return this.impl.nextBits(i);
    }

    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    public void nextBytes(@NotNull byte[] bArr) {
        k21.i(bArr, "bytes");
        this.impl.nextBytes(bArr);
    }

    public double nextDouble() {
        return this.impl.nextDouble();
    }

    public float nextFloat() {
        return this.impl.nextFloat();
    }

    public int nextInt() {
        return this.impl.nextInt();
    }

    public long nextLong() {
        return this.impl.nextLong();
    }

    public void setSeed(long j) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }
}
