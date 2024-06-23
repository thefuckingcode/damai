package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import tb.ac1;

/* compiled from: Taobao */
public abstract class r implements Closeable {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends r {
        final /* synthetic */ ac1 a;
        final /* synthetic */ long b;
        final /* synthetic */ BufferedSource c;

        a(ac1 ac1, long j, BufferedSource bufferedSource) {
            this.a = ac1;
            this.b = j;
            this.c = bufferedSource;
        }

        @Override // okhttp3.r
        public long f() {
            return this.b;
        }

        @Override // okhttp3.r
        @Nullable
        public ac1 g() {
            return this.a;
        }

        @Override // okhttp3.r
        public BufferedSource j() {
            return this.c;
        }
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    private Charset e() {
        ac1 g = g();
        return g != null ? g.b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static r h(@Nullable ac1 ac1, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new a(ac1, j, bufferedSource);
    }

    public static r i(@Nullable ac1 ac1, byte[] bArr) {
        return h(ac1, (long) bArr.length, new Buffer().write(bArr));
    }

    public final InputStream c() {
        return j().inputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.a.g(j());
    }

    public abstract long f();

    @Nullable
    public abstract ac1 g();

    public abstract BufferedSource j();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r0 != null) goto L_0x001a;
     */
    public final String k() throws IOException {
        BufferedSource j = j();
        String readString = j.readString(okhttp3.internal.a.c(j, e()));
        a(null, j);
        return readString;
    }
}
