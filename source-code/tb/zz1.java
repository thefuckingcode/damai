package tb;

import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterOutputStream;

/* compiled from: Taobao */
public class zz1 {
    private final th1 a;
    private final String b;
    private ByteArrayOutputStream c;
    private a d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends FilterOutputStream {
        private static final ExecutorService b = Executors.newCachedThreadPool();
        private final Future<Void> a;

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class a implements Callable<Void> {
            private final InputStream a;
            private final OutputStream b;

            public a(InputStream inputStream, OutputStream outputStream) {
                this.a = inputStream;
                this.b = outputStream;
            }

            /* JADX INFO: finally extract failed */
            /* renamed from: a */
            public Void call() throws IOException {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(this.a);
                try {
                    b.b(gZIPInputStream, this.b, new byte[1024]);
                    gZIPInputStream.close();
                    this.b.close();
                    return null;
                } catch (Throwable th) {
                    gZIPInputStream.close();
                    this.b.close();
                    throw th;
                }
            }
        }

        private b(OutputStream outputStream, Future<Void> future) throws IOException {
            super(outputStream);
            this.a = future;
        }

        /* access modifiers changed from: private */
        public static void b(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        }

        public static b c(OutputStream outputStream) throws IOException {
            PipedInputStream pipedInputStream = new PipedInputStream();
            return new b(new PipedOutputStream(pipedInputStream), b.submit(new a(pipedInputStream, outputStream)));
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:? */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0000 */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.Future<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Object] */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|6|2|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
            r0 = r0.getCause();
            f(r0, java.io.IOException.class);
            e(r0);
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x0000, LOOP_START, PHI: r2 
          PHI: (r2v1 T) = (r2v0 java.util.concurrent.Future<T>), (r2v2 ??) binds: [B:9:?, B:5:0x0000] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:0:0x0000] */
        private static <T> T d(Future<T> future) throws IOException {
            while (true) {
                future = (T) future.get();
                return future;
            }
        }

        private static RuntimeException e(Throwable th) {
            f(th, Error.class);
            f(th, RuntimeException.class);
            throw new RuntimeException(th);
        }

        private static <T extends Throwable> void f(Throwable th, Class<T> cls) throws Throwable {
            if (cls.isInstance(th)) {
                throw th;
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
                try {
                } catch (IOException e) {
                    throw e;
                }
            } finally {
                try {
                    d(this.a);
                } catch (IOException unused) {
                }
            }
        }
    }

    public zz1(th1 th1, String str) {
        this.a = th1;
        this.b = str;
    }

    private void e() {
        if (!c()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }

    public OutputStream a(@Nullable String str) throws IOException {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if ("gzip".equals(str)) {
            outputStream = b.c(byteArrayOutputStream);
        } else {
            outputStream = "deflate".equals(str) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        }
        a aVar = new a(this, outputStream);
        this.d = aVar;
        this.c = byteArrayOutputStream;
        return aVar;
    }

    public byte[] b() {
        e();
        return this.c.toByteArray();
    }

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        e();
        this.a.b(this.b, this.c.size(), (int) this.d.getCount());
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a extends FilterOutputStream {
        private long a;

        public a(zz1 zz1, OutputStream outputStream) {
            super(outputStream);
        }

        public long getCount() {
            return this.a;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(int i) throws IOException {
            ((FilterOutputStream) this).out.write(i);
            this.a++;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            this.a += (long) i2;
        }
    }
}
