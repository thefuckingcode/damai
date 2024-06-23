package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class l7 extends mb0 {
    @NotNull
    private final double[] a;
    private int b;

    public l7(@NotNull double[] dArr) {
        k21.i(dArr, "array");
        this.a = dArr;
    }

    @Override // tb.mb0
    public double a() {
        try {
            double[] dArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
