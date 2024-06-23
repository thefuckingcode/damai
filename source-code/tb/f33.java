package tb;

import android.content.Context;
import android.text.TextUtils;
import com.loc.al;

/* compiled from: Taobao */
public final class f33 extends g33 {
    protected int b;
    protected long c;
    private String d;
    private Context e;

    public f33(Context context, int i, String str, g33 g33) {
        super(g33);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    @Override // tb.g33
    public final void b(boolean z) {
        super.b(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            al.d(this.e, str, String.valueOf(currentTimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.g33
    public final boolean c() {
        long j = 0;
        if (this.c == 0) {
            String a = al.a(this.e, this.d);
            if (!TextUtils.isEmpty(a)) {
                j = Long.parseLong(a);
            }
            this.c = j;
        }
        return System.currentTimeMillis() - this.c >= ((long) this.b);
    }
}
