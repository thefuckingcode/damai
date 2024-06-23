package tb;

import android.content.Context;
import android.text.TextUtils;
import com.loc.al;
import com.loc.o;
import com.loc.v1;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public final class d33 extends g33 {
    private String b = "iKey";
    private Context c;
    private boolean d;
    private int e;
    private int f;
    private int g = 0;

    public d33(Context context, boolean z, int i, int i2, String str) {
        f(context, z, i, i2, str, 0);
    }

    public d33(Context context, boolean z, int i, int i2, String str, int i3) {
        f(context, z, i, i2, str, i3);
    }

    private void f(Context context, boolean z, int i, int i2, String str, int i3) {
        this.c = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.b = str;
        this.g = i3;
    }

    @Override // tb.g33
    public final void a(int i) {
        if (o.a0(this.c) != 1) {
            String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
            String a = al.a(this.c, this.b);
            if (!TextUtils.isEmpty(a)) {
                String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                if (split == null || split.length < 2) {
                    al.g(this.c, this.b);
                } else if (c2.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.c;
            String str = this.b;
            al.d(context, str, c2 + "|" + i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.g33
    public final boolean c() {
        if (o.a0(this.c) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String a = al.a(this.c, this.b);
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        if (split == null || split.length < 2) {
            al.g(this.c, this.b);
            return true;
        }
        return !v1.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
    }

    @Override // tb.g33
    public final int d() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((o.a0(this.c) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        g33 g33 = this.a;
        return g33 != null ? Math.max(i2, g33.d()) : i2;
    }
}
