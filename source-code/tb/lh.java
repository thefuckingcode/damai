package tb;

import java.util.NoSuchElementException;

/* compiled from: Taobao */
public final class lh extends ih {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public lh(char c2, char c3, int i) {
        this.a = i;
        this.b = c3;
        boolean z = true;
        if (i <= 0 ? k21.k(c2, c3) < 0 : k21.k(c2, c3) > 0) {
            z = false;
        }
        this.c = z;
        this.d = !z ? c3 : c2;
    }

    @Override // tb.ih
    public char a() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else if (this.c) {
            this.c = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i;
    }

    public boolean hasNext() {
        return this.c;
    }
}
