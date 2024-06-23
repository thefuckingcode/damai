package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class m7 extends lj0 {
    @NotNull
    private final float[] a;
    private int b;

    public m7(@NotNull float[] fArr) {
        k21.i(fArr, "array");
        this.a = fArr;
    }

    @Override // tb.lj0
    public float a() {
        try {
            float[] fArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
