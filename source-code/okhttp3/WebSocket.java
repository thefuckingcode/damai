package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;
import tb.cz2;

/* compiled from: Taobao */
public interface WebSocket {

    /* compiled from: Taobao */
    public interface Factory {
        WebSocket newWebSocket(o oVar, cz2 cz2);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    o request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
