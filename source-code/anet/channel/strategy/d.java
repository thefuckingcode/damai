package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class d {
    Map<String, ConnProtocol> a = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        static d a = new d();
    }

    public static d b() {
        return a.a;
    }

    public ConnProtocol a(String str) {
        return this.a.get(str);
    }

    public void c(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.a.put(str, connProtocol);
            try {
                IStrategyInstance a2 = a.a();
                if (a2 instanceof StrategyInstance) {
                    ((StrategyInstance) a2).b.c.h(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
