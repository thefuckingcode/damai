package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.e;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public final class ke {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public ke(long j, long j2, long j3, long j4, long j5, long j6) {
        boolean z = true;
        ds1.d(j >= 0);
        ds1.d(j2 >= 0);
        ds1.d(j3 >= 0);
        ds1.d(j4 >= 0);
        ds1.d(j5 >= 0);
        ds1.d(j6 < 0 ? false : z);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public long a() {
        return this.f;
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.c;
    }

    public long e() {
        return this.b;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof ke)) {
            return false;
        }
        ke keVar = (ke) obj;
        if (this.a == keVar.a && this.b == keVar.b && this.c == keVar.c && this.d == keVar.d && this.e == keVar.e && this.f == keVar.f) {
            return true;
        }
        return false;
    }

    public long f() {
        return this.e;
    }

    public int hashCode() {
        return rk1.b(Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public String toString() {
        return e.b(this).c("hitCount", this.a).c("missCount", this.b).c("loadSuccessCount", this.c).c("loadExceptionCount", this.d).c("totalLoadTime", this.e).c("evictionCount", this.f).toString();
    }
}
