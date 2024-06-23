package tb;

import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class s9 {
    private static volatile s9 c;
    private Map<INetworkQualityChangeListener, gw1> a = new ConcurrentHashMap();
    private gw1 b = new gw1();

    private s9() {
    }

    public static s9 b() {
        if (c == null) {
            synchronized (s9.class) {
                if (c == null) {
                    c = new s9();
                }
            }
        }
        return c;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, gw1 gw1) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
        } else if (gw1 == null) {
            this.b.c = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, this.b);
        } else {
            gw1.c = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, gw1);
        }
    }

    public void c(double d) {
        boolean b2;
        for (Map.Entry<INetworkQualityChangeListener, gw1> entry : this.a.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            gw1 value = entry.getValue();
            if (!(key == null || value == null || value.a() || value.d() == (b2 = value.b(d)))) {
                value.e(b2);
                key.onNetworkQualityChanged(b2 ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }

    public void d(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.a.remove(iNetworkQualityChangeListener);
    }
}
