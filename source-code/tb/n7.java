package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class n7 extends r11 {
    @NotNull
    private final int[] a;
    private int b;

    public n7(@NotNull int[] iArr) {
        k21.i(iArr, "array");
        this.a = iArr;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.r11
    public int nextInt() {
        try {
            int[] iArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
