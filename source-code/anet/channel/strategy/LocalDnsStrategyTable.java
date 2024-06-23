package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.taobao.accs.net.SmartHeartbeatImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import tb.a90;
import tb.d92;
import tb.gm;
import tb.h9;
import tb.ju2;
import tb.y4;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class LocalDnsStrategyTable {
    final ConcurrentHashMap<String, List<IPConnStrategy>> a = new ConcurrentHashMap<>();
    final HashMap<String, Object> b = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Comparator<IPConnStrategy> {
        a(LocalDnsStrategyTable localDnsStrategyTable) {
        }

        /* renamed from: a */
        public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
            return (!ju2.c(iPConnStrategy2.ip) || !ju2.d(iPConnStrategy.ip)) ? 0 : -1;
        }
    }

    LocalDnsStrategyTable() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(String str, String str2) {
        List<IPConnStrategy> list = this.a.get(str);
        if (list == null || list.isEmpty()) {
            list = new LinkedList<>();
        }
        ConnProtocol a2 = d.b().a(str);
        if (a2 != null) {
            list.add(IPConnStrategy.create(str2, !c(a2) ? 80 : 443, a2, 0, 0, 1, SmartHeartbeatImpl.FOREGROUND_INTERVAL));
        }
        list.add(IPConnStrategy.create(str2, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
        list.add(IPConnStrategy.create(str2, 443, ConnProtocol.HTTPS, 0, 0, 0, 0));
        if (h9.z()) {
            Collections.sort(list, new a(this));
        }
        this.a.put(str, list);
    }

    private boolean c(ConnProtocol connProtocol) {
        return connProtocol.protocol.equalsIgnoreCase("https") || connProtocol.protocol.equalsIgnoreCase(ConnType.H2S) || !TextUtils.isEmpty(connProtocol.publicKey);
    }

    private void i(final String str, final Object obj) {
        y4.d(new Runnable() {
            /* class anet.channel.strategy.LocalDnsStrategyTable.AnonymousClass1 */

            public void run() {
                try {
                    if (Inet64Util.n() == 3) {
                        InetAddress[] allByName = InetAddress.getAllByName(str);
                        int length = allByName.length;
                        int i = 0;
                        boolean z = false;
                        boolean z2 = false;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            String hostAddress = allByName[i].getHostAddress();
                            if (!z && ju2.d(hostAddress)) {
                                LocalDnsStrategyTable.this.b(str, hostAddress);
                                z = true;
                            } else if (!z2 && ju2.c(hostAddress)) {
                                LocalDnsStrategyTable.this.b(str, hostAddress);
                                z2 = true;
                            }
                            if (z2 && z) {
                                break;
                            }
                            i++;
                        }
                    } else {
                        LocalDnsStrategyTable.this.b(str, InetAddress.getByName(str).getHostAddress());
                    }
                    if (ALog.g(1)) {
                        String str = str;
                        ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str, "list", LocalDnsStrategyTable.this.a.get(str));
                    }
                    synchronized (LocalDnsStrategyTable.this.b) {
                        LocalDnsStrategyTable.this.b.remove(str);
                    }
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                } catch (Exception unused) {
                    try {
                        ALog.e("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, "host", str);
                        if (ALog.g(1)) {
                            String str2 = str;
                            ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str2, "list", LocalDnsStrategyTable.this.a.get(str2));
                        }
                        synchronized (LocalDnsStrategyTable.this.b) {
                            LocalDnsStrategyTable.this.b.remove(str);
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        if (ALog.g(1)) {
                            String str3 = str;
                            ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str3, "list", LocalDnsStrategyTable.this.a.get(str3));
                        }
                        synchronized (LocalDnsStrategyTable.this.b) {
                            LocalDnsStrategyTable.this.b.remove(str);
                            synchronized (obj) {
                                obj.notifyAll();
                                throw th;
                            }
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void d(String str, IConnStrategy iConnStrategy, gm gmVar) {
        List<IPConnStrategy> list;
        if (!gmVar.a && !TextUtils.isEmpty(str) && !gmVar.b && (list = this.a.get(str)) != null && list != Collections.EMPTY_LIST) {
            Iterator<IPConnStrategy> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == iConnStrategy) {
                    it.remove();
                }
            }
            if (list.isEmpty()) {
                this.a.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List e(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || !ju2.a(str) || a90.a().equalsIgnoreCase(str)) {
            return Collections.EMPTY_LIST;
        }
        if (ALog.g(1)) {
            ALog.c("awcn.LocalDnsStrategyTable", "try resolve ip with local dns", null, "host", str);
        }
        List list = Collections.EMPTY_LIST;
        if (!this.a.containsKey(str)) {
            synchronized (this.b) {
                if (!this.b.containsKey(str)) {
                    obj = new Object();
                    this.b.put(str, obj);
                    i(str, obj);
                } else {
                    obj = this.b.get(str);
                }
            }
            if (obj != null) {
                try {
                    synchronized (obj) {
                        obj.wait(500);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        List<IPConnStrategy> list2 = this.a.get(str);
        if (!(list2 == null || list2 == Collections.EMPTY_LIST)) {
            list = new ArrayList(list2);
        }
        ALog.f("awcn.LocalDnsStrategyTable", "get local strategy", null, "strategyList", list2);
        return list;
    }

    /* access modifiers changed from: package-private */
    public List f(String str, boolean z, int i) {
        List e = e(str);
        ListIterator listIterator = e.listIterator();
        while (listIterator.hasNext()) {
            IPConnStrategy iPConnStrategy = (IPConnStrategy) listIterator.next();
            if (ju2.d(iPConnStrategy.getIp())) {
                listIterator.remove();
            } else {
                ConnType l = ConnType.l(iPConnStrategy.getProtocol());
                if (l == null) {
                    listIterator.remove();
                } else if (!(l.k() == z && (i == d92.c || l.e() == i))) {
                    listIterator.remove();
                }
            }
        }
        return e;
    }

    public List<IConnStrategy> g(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        List<IPConnStrategy> list2 = this.a.get(str);
        if (!(list2 == null || list2.size() == 0)) {
            list = new ArrayList<>(list2);
        }
        ALog.f("awcn.LocalDnsStrategyTable", "queryWithoutWait local strategy", null, "strategyList", list2);
        return list;
    }

    /* access modifiers changed from: package-private */
    public void h(String str, ConnProtocol connProtocol) {
        List<IPConnStrategy> list = this.a.get(str);
        if (!(list == null || list.isEmpty())) {
            for (IPConnStrategy iPConnStrategy : list) {
                if (iPConnStrategy.getProtocol().equals(connProtocol)) {
                    return;
                }
            }
            list.add(IPConnStrategy.create(list.get(0).getIp(), !c(connProtocol) ? 80 : 443, connProtocol, 0, 0, 1, SmartHeartbeatImpl.FOREGROUND_INTERVAL));
            ALog.f("awcn.LocalDnsStrategyTable", "setProtocolForHost", null, "strategyList", list);
        }
    }
}
