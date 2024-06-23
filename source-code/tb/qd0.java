package tb;

import android.text.TextUtils;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.pexode.mimetype.a;

/* compiled from: Taobao */
public class qd0 extends pd0 {
    public static final int EXACT_SIZE_LEVEL = 1;
    public static final int LARGE_SIZE_LEVEL = 4;
    public static final int SMALL_SIZE_LEVEL = 2;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final String m;
    public int n;
    public int o;
    public boolean p;
    private MimeType q;
    private boolean r;

    public qd0(pd0 pd0, String str, int i2, boolean z, String str2) {
        this(pd0, str, i2, z, str2, false);
    }

    public static MimeType h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.indexOf(46) == 0) {
            str = str.substring(1);
        }
        try {
            for (MimeType mimeType : a.ALL_EXTENSION_TYPES) {
                if (mimeType != null && mimeType.e(str)) {
                    return mimeType;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public qd0 d(pd0 pd0, int i2) {
        return e(pd0, i2, this.j);
    }

    public qd0 e(pd0 pd0, int i2, boolean z) {
        qd0 qd0 = new qd0(pd0, this.i, i2, this.k, this.m, z);
        qd0.n = this.n;
        qd0.o = this.o;
        qd0.p = this.p;
        return qd0;
    }

    public qd0 f(boolean z) {
        this.r = z;
        return this;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            b(false);
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    public MimeType g() {
        if (this.q == null) {
            this.q = h(this.m);
        }
        return this.q;
    }

    public boolean i() {
        if (this.r || this.a != 1) {
            return true;
        }
        return (this.k && !this.j) || !this.g || this.c == null;
    }

    public void j(MimeType mimeType) {
        this.q = mimeType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qd0(pd0 pd0, String str, int i2, boolean z, String str2, boolean z2) {
        super(pd0 == null ? new pd0(false, null, 0, 0) : pd0);
        this.i = str;
        this.l = i2;
        this.k = z;
        this.m = str2;
        this.j = z2;
    }
}
