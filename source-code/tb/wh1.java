package tb;

import com.taobao.monitor.network.INetworkSender;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class wh1 implements INetworkSender {
    private static volatile wh1 b;
    private final List<INetworkSender> a = new ArrayList();

    private wh1() {
    }

    public static wh1 b() {
        if (b == null) {
            synchronized (wh1.class) {
                if (b == null) {
                    b = new wh1();
                }
            }
        }
        return b;
    }

    public wh1 a(INetworkSender iNetworkSender) {
        if (iNetworkSender != null) {
            this.a.add(iNetworkSender);
        }
        return this;
    }

    @Override // com.taobao.monitor.network.INetworkSender
    public void send(String str, String str2) {
        for (INetworkSender iNetworkSender : this.a) {
            if (iNetworkSender != null) {
                iNetworkSender.send(str, str2);
            }
        }
    }
}
