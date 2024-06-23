package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j7 extends ih {
    @NotNull
    private final char[] a;
    private int b;

    public j7(@NotNull char[] cArr) {
        k21.i(cArr, "array");
        this.a = cArr;
    }

    @Override // tb.ih
    public char a() {
        try {
            char[] cArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
