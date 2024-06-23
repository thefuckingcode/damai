package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public interface Connection {
    @Nullable
    k handshake();

    Protocol protocol();

    s route();

    Socket socket();
}
