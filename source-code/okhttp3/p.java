package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.BufferedSink;
import tb.ac1;

/* compiled from: Taobao */
public abstract class p {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends p {
        final /* synthetic */ ac1 a;
        final /* synthetic */ int b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        a(ac1 ac1, int i, byte[] bArr, int i2) {
            this.a = ac1;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // okhttp3.p
        public long a() {
            return (long) this.b;
        }

        @Override // okhttp3.p
        @Nullable
        public ac1 b() {
            return this.a;
        }

        @Override // okhttp3.p
        public void h(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.c, this.d, this.b);
        }
    }

    public static p c(@Nullable ac1 ac1, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (ac1 != null && (charset = ac1.a()) == null) {
            charset = StandardCharsets.UTF_8;
            ac1 = ac1.d(ac1 + "; charset=utf-8");
        }
        return d(ac1, str.getBytes(charset));
    }

    public static p d(@Nullable ac1 ac1, byte[] bArr) {
        return e(ac1, bArr, 0, bArr.length);
    }

    public static p e(@Nullable ac1 ac1, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        okhttp3.internal.a.f((long) bArr.length, (long) i, (long) i2);
        return new a(ac1, i2, bArr, i);
    }

    public abstract long a() throws IOException;

    @Nullable
    public abstract ac1 b();

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract void h(BufferedSink bufferedSink) throws IOException;
}
