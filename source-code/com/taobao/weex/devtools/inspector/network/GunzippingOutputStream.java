package com.taobao.weex.devtools.inspector.network;

import com.taobao.weex.devtools.common.Util;
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

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class GunzippingOutputStream extends FilterOutputStream {
    private static final ExecutorService sExecutor = Executors.newCachedThreadPool();
    private final Future<Void> mCopyFuture;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class GunzippingCallable implements Callable<Void> {
        private final InputStream mIn;
        private final OutputStream mOut;

        public GunzippingCallable(InputStream inputStream, OutputStream outputStream) {
            this.mIn = inputStream;
            this.mOut = outputStream;
        }

        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws IOException {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.mIn);
            try {
                Util.copy(gZIPInputStream, this.mOut, new byte[1024]);
                gZIPInputStream.close();
                this.mOut.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.mOut.close();
                throw th;
            }
        }
    }

    private GunzippingOutputStream(OutputStream outputStream, Future<Void> future) throws IOException {
        super(outputStream);
        this.mCopyFuture = future;
    }

    public static GunzippingOutputStream create(OutputStream outputStream) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), sExecutor.submit(new GunzippingCallable(pipedInputStream, outputStream)));
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
        com.taobao.weex.devtools.common.ExceptionUtil.propagateIfInstanceOf(r0, java.io.IOException.class);
        com.taobao.weex.devtools.common.ExceptionUtil.propagate(r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x0000, LOOP_START, PHI: r2 
      PHI: (r2v1 T) = (r2v0 java.util.concurrent.Future<T>), (r2v2 ??) binds: [B:9:?, B:5:0x0000] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:0:0x0000] */
    private static <T> T getAndRethrow(Future<T> future) throws IOException {
        while (true) {
            future = (T) future.get();
            return future;
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
                getAndRethrow(this.mCopyFuture);
            } catch (IOException unused) {
            }
        }
    }
}
