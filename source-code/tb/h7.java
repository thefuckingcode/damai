package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h7 extends ud {
    @NotNull
    private final byte[] a;
    private int b;

    public h7(@NotNull byte[] bArr) {
        k21.i(bArr, "array");
        this.a = bArr;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.ud
    public byte nextByte() {
        try {
            byte[] bArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
