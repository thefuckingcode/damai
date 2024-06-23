package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class WebSocketReader {
    final boolean a;
    final BufferedSource b;
    final FrameCallback c;
    private final Buffer d = new Buffer();
    private final Buffer e = new Buffer();
    private final byte[] f;
    private final Buffer.c g;

    /* compiled from: Taobao */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.a = z;
        this.b = bufferedSource;
        this.c = frameCallback;
        Buffer.c cVar = null;
        this.f = z ? null : new byte[4];
        this.g = !z ? new Buffer.c() : cVar;
    }
}
