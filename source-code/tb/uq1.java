package tb;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class uq1 extends a2 {
    @Override // tb.a2
    @NotNull
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k21.h(current, "current()");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d) {
        return ThreadLocalRandom.current().nextDouble(d);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j, long j2) {
        return ThreadLocalRandom.current().nextLong(j, j2);
    }
}
