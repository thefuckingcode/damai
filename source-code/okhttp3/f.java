package okhttp3;

import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class f {
    final okhttp3.internal.connection.f a;

    public f() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public f(int i, long j, TimeUnit timeUnit) {
        this.a = new okhttp3.internal.connection.f(i, j, timeUnit);
    }
}
