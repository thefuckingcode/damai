package okio;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;

/* compiled from: Taobao */
final class j implements Source {
    private final BufferedSource a;
    private final Buffer b;
    private m c;
    private int d;
    private boolean e;
    private long f;

    j(BufferedSource bufferedSource) {
        this.a = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.b = buffer;
        m mVar = buffer.head;
        this.c = mVar;
        this.d = mVar != null ? mVar.b : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e = true;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        m mVar;
        m mVar2;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.e) {
            m mVar3 = this.c;
            if (mVar3 != null && (mVar3 != (mVar2 = this.b.head) || this.d != mVar2.b)) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            } else if (i == 0) {
                return 0;
            } else {
                if (!this.a.request(this.f + 1)) {
                    return -1;
                }
                if (this.c == null && (mVar = this.b.head) != null) {
                    this.c = mVar;
                    this.d = mVar.b;
                }
                long min = Math.min(j, this.b.size - this.f);
                this.b.copyTo(buffer, this.f, min);
                this.f += min;
                return min;
            }
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.Source
    public o timeout() {
        return this.a.timeout();
    }
}
