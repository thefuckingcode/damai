package tb;

import java.util.NoSuchElementException;

/* compiled from: Taobao */
public final class ha1 extends fa1 {
    private final long a;
    private final long b;
    private boolean c;
    private long d;

    public ha1(long j, long j2, long j3) {
        this.a = j3;
        this.b = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i <= 0 ? i2 < 0 : i2 > 0) {
            z = false;
        }
        this.c = z;
        this.d = !z ? j2 : j;
    }

    public boolean hasNext() {
        return this.c;
    }

    @Override // tb.fa1
    public long nextLong() {
        long j = this.d;
        if (j != this.b) {
            this.d = this.a + j;
        } else if (this.c) {
            this.c = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
