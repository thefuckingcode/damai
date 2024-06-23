package tb;

import javax.annotation.Nullable;
import okhttp3.r;
import okio.BufferedSource;

/* compiled from: Taobao */
public final class hx1 extends r {
    @Nullable
    private final String a;
    private final long b;
    private final BufferedSource c;

    public hx1(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.a = str;
        this.b = j;
        this.c = bufferedSource;
    }

    @Override // okhttp3.r
    public long f() {
        return this.b;
    }

    @Override // okhttp3.r
    public ac1 g() {
        String str = this.a;
        if (str != null) {
            return ac1.d(str);
        }
        return null;
    }

    @Override // okhttp3.r
    public BufferedSource j() {
        return this.c;
    }
}
