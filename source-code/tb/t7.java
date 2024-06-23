package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class t7 extends pa2 {
    @NotNull
    private final short[] a;
    private int b;

    public t7(@NotNull short[] sArr) {
        k21.i(sArr, "array");
        this.a = sArr;
    }

    @Override // tb.pa2
    public short a() {
        try {
            short[] sArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
