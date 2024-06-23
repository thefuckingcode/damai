package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import okhttp3.l;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import tb.ac1;
import tb.jl1;

/* compiled from: Taobao */
public final class n extends p {
    public static final ac1 ALTERNATIVE = ac1.c("multipart/alternative");
    public static final ac1 DIGEST = ac1.c("multipart/digest");
    public static final ac1 FORM = ac1.c("multipart/form-data");
    public static final ac1 MIXED = ac1.c("multipart/mixed");
    public static final ac1 PARALLEL = ac1.c("multipart/parallel");
    private static final byte[] e = {58, 32};
    private static final byte[] f = {13, 10};
    private static final byte[] g = {45, 45};
    private final ByteString a;
    private final ac1 b;
    private final List<b> c;
    private long d = -1;

    /* compiled from: Taobao */
    public static final class a {
        private final ByteString a;
        private ac1 b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(String str, String str2) {
            return c(b.b(str, str2));
        }

        public a b(String str, @Nullable String str2, p pVar) {
            return c(b.c(str, str2, pVar));
        }

        public a c(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.c.add(bVar);
            return this;
        }

        public n d() {
            if (!this.c.isEmpty()) {
                return new n(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public a(String str) {
            this.b = n.MIXED;
            this.c = new ArrayList();
            this.a = ByteString.encodeUtf8(str);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @Nullable
        final l a;
        final p b;

        private b(@Nullable l lVar, p pVar) {
            this.a = lVar;
            this.b = pVar;
        }

        public static b a(@Nullable l lVar, p pVar) {
            Objects.requireNonNull(pVar, "body == null");
            if (lVar != null && lVar.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (lVar == null || lVar.c(Constants.Protocol.CONTENT_LENGTH) == null) {
                return new b(lVar, pVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static b b(String str, String str2) {
            return c(str, null, p.c(null, str2));
        }

        public static b c(String str, @Nullable String str2, p pVar) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            n.i(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                n.i(sb, str2);
            }
            return a(new l.a().d("Content-Disposition", sb.toString()).e(), pVar);
        }
    }

    n(ByteString byteString, ac1 ac1, List<b> list) {
        this.a = byteString;
        this.b = ac1.c(ac1 + "; boundary=" + byteString.utf8());
        this.c = okhttp3.internal.a.t(list);
    }

    static void i(StringBuilder sb, String str) {
        sb.append(jl1.QUOTE);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(jl1.QUOTE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: okio.Buffer */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: okio.Buffer */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: okio.Buffer */
    /* JADX WARN: Multi-variable type inference failed */
    private long j(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.c.get(i);
            l lVar = bVar.a;
            p pVar = bVar.b;
            bufferedSink.write(g);
            bufferedSink.write(this.a);
            bufferedSink.write(f);
            if (lVar != null) {
                int h = lVar.h();
                for (int i2 = 0; i2 < h; i2++) {
                    bufferedSink.writeUtf8(lVar.e(i2)).write(e).writeUtf8(lVar.j(i2)).write(f);
                }
            }
            ac1 b2 = pVar.b();
            if (b2 != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(b2.toString()).write(f);
            }
            long a2 = pVar.a();
            if (a2 != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(a2).write(f);
            } else if (z) {
                buffer.clear();
                return -1;
            }
            byte[] bArr = f;
            bufferedSink.write(bArr);
            if (z) {
                j += a2;
            } else {
                pVar.h(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = g;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.a);
        bufferedSink.write(bArr2);
        bufferedSink.write(f);
        if (!z) {
            return j;
        }
        long size2 = j + buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.p
    public long a() throws IOException {
        long j = this.d;
        if (j != -1) {
            return j;
        }
        long j2 = j(null, true);
        this.d = j2;
        return j2;
    }

    @Override // okhttp3.p
    public ac1 b() {
        return this.b;
    }

    @Override // okhttp3.p
    public void h(BufferedSink bufferedSink) throws IOException {
        j(bufferedSink, false);
    }
}
