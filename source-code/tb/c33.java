package tb;

import com.loc.an;
import java.io.File;

/* compiled from: Taobao */
public final class c33 extends g33 {
    private int b = 30;
    private String c;

    public c33(String str, g33 g33) {
        super(g33);
        this.c = str;
    }

    private static int f(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            an.m(th, "fus", "gfn");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.g33
    public final boolean c() {
        return f(this.c) >= this.b;
    }
}
