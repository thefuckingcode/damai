package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import tb.qa0;

/* compiled from: Taobao */
public interface Dns {
    public static final Dns SYSTEM = qa0.a;

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
