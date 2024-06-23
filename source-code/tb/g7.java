package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g7 extends lc {
    @NotNull
    private final boolean[] a;
    private int b;

    public g7(@NotNull boolean[] zArr) {
        k21.i(zArr, "array");
        this.a = zArr;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.lc
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
