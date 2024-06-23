package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class r7 extends fa1 {
    @NotNull
    private final long[] a;
    private int b;

    public r7(@NotNull long[] jArr) {
        k21.i(jArr, "array");
        this.a = jArr;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.fa1
    public long nextLong() {
        try {
            long[] jArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
