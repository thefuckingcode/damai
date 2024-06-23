package com.alibaba.mobsec.privacydoublelist;

import com.alibaba.mobsec.privacydoublelist.c.a;
import com.alibaba.mobsec.privacydoublelist.e.e;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class a extends AopBridge {
    public static volatile a b;
    public final Map<Invocation, Long> a = new ConcurrentHashMap();

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callAfterBridge(Invocation invocation) {
        Long l = this.a.get(invocation);
        if (l != null) {
            e.b().a(invocation, l.longValue() / 1000, false);
            this.a.remove(invocation);
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean callBeforeBridge(Invocation invocation) {
        com.alibaba.mobsec.privacydoublelist.c.a a2 = com.alibaba.mobsec.privacydoublelist.c.a.a();
        a.C0089a aVar = a2.a.get(invocation.getProxyName());
        if (aVar != null) {
            boolean a3 = aVar.a(invocation);
            if (a3) {
                this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
            }
            return a3;
        }
        this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
        return true;
    }
}
