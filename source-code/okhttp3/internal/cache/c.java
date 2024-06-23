package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;

/* compiled from: Taobao */
class c extends okio.c {
    private boolean a;

    c(Sink sink) {
        super(sink);
    }

    @Override // java.io.Closeable, okio.c, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (!this.a) {
            try {
                super.close();
            } catch (IOException e) {
                this.a = true;
                onException(e);
            }
        }
    }

    @Override // okio.c, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.a = true;
                onException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
        throw null;
    }

    @Override // okio.c, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.a = true;
            onException(e);
        }
    }
}
