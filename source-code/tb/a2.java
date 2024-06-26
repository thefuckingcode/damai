package tb;

import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class a2 extends Random {
    @NotNull
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public int nextBits(int i) {
        return rw1.f(getImpl().nextInt(), i);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        k21.i(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
