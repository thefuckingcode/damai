package okio;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"okio/RealBufferedSink$outputStream$1", "Ljava/io/OutputStream;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "flush", "toString", "", "write", CacheEntity.DATA, "", "offset", "", "byteCount", "b", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealBufferedSink.kt */
public final class RealBufferedSink$outputStream$1 extends OutputStream {
    final /* synthetic */ RealBufferedSink this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.this$0 = realBufferedSink;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (!this.this$0.closed) {
            this.this$0.bufferField.writeByte((int) ((byte) i));
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, CacheEntity.DATA);
        if (!this.this$0.closed) {
            this.this$0.bufferField.write(bArr, i, i2);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (!this.this$0.closed) {
            this.this$0.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.this$0.close();
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }
}
