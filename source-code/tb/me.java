package tb;

import android.content.res.Resources;
import com.taobao.phenix.cache.memory.ReleasableReferenceListener;
import com.taobao.phenix.cache.memory.a;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public abstract class me implements ReleasableReferenceListener {
    private final String a;
    private final String b;
    private final int c;
    private final int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final Set<Integer> h = new HashSet(2);

    public me(String str, String str2, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    private synchronized void a(so1 so1) {
        if (so1 != null) {
            if (this.f) {
                this.f = false;
                g();
            }
            if (!this.g) {
                if (so1 instanceof pz1) {
                    Set<Integer> set = this.h;
                    Integer valueOf = Integer.valueOf(so1.hashCode());
                    if (set.contains(valueOf)) {
                        this.g = true;
                        vr2.i(a.TAG_RECYCLE, "references dirty now(last releasable drawable same with the hash is lost), refer=%d, image=%s, drawable=%s", Integer.valueOf(this.h.size()), this, so1);
                    } else {
                        this.h.add(valueOf);
                        ((pz1) so1).l(this);
                    }
                } else {
                    this.g = true;
                }
            }
        }
    }

    private void h() {
        if (!this.f && !this.g && this.e && this.h.size() == 0) {
            f();
            this.f = true;
        }
    }

    public String b() {
        return this.a;
    }

    public abstract int c();

    /* access modifiers changed from: protected */
    public abstract so1 d(String str, String str2, int i, int i2, boolean z, Resources resources);

    public so1 e(boolean z, Resources resources) {
        so1 d2 = d(this.a, this.b, this.c, this.d, z, resources);
        a(d2);
        return d2;
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public synchronized void i(boolean z) {
        if (this.f && !z) {
            this.f = false;
            g();
        }
        this.e = z;
        vr2.a(a.TAG_RECYCLE, "release from cache, result=%b, isDirty=%b, refer=%d, image=%s", Boolean.valueOf(z), Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this);
        h();
    }

    public synchronized void j() {
        this.g = true;
    }

    @Override // com.taobao.phenix.cache.memory.ReleasableReferenceListener
    public synchronized void onReferenceDowngrade2Passable(pz1 pz1) {
        if (pz1 != null) {
            this.g = true;
            pz1.l(null);
            this.h.remove(Integer.valueOf(pz1.hashCode()));
            vr2.a(a.TAG_RECYCLE, "image reference downgraded to passable, isDirty=%b, refer=%d, image=%s, drawable=%s", Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this, pz1);
        }
    }

    @Override // com.taobao.phenix.cache.memory.ReleasableReferenceListener
    public synchronized void onReferenceReleased(pz1 pz1) {
        if (pz1 != null) {
            this.h.remove(Integer.valueOf(pz1.hashCode()));
            vr2.a(a.TAG_RECYCLE, "image reference released, isDirty=%b, refer=%d, image=%s, drawable=%s", Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this, pz1);
            h();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + jl1.BRACKET_START_STR + Integer.toHexString(hashCode()) + ", key@" + this.a + jl1.BRACKET_END_STR;
    }
}
