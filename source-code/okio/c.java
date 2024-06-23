package okio;

import java.io.IOException;
import tb.jl1;

/* compiled from: Taobao */
public abstract class c implements Sink {
    private final Sink delegate;

    public c(Sink sink) {
        if (sink != null) {
            this.delegate = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public o timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + jl1.BRACKET_START_STR + this.delegate.toString() + jl1.BRACKET_END_STR;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        this.delegate.write(buffer, j);
    }
}
