package tb;

import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.a;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: Taobao */
public class ll {
    public static final int IP_COMPLEX = 2;
    public static final int IP_DEGRADE = 1;

    public static long a() {
        return h9.b();
    }

    public static List<hm> b(Session session, List<hm> list, int i) {
        if (i == 1) {
            return c(session, list);
        }
        return null;
    }

    private static List<hm> c(Session session, List<hm> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (session == null) {
            return arrayList;
        }
        try {
            boolean i = session.g().i();
            if (!(list == null || list.size() == 0)) {
                ListIterator<hm> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    hm next = listIterator.next();
                    if (ju2.c(next.e()) && !(next.a().i() ^ i)) {
                        String d = next.d();
                        arrayList.add(new hm(d, "COMPLEX-" + next.h(), next.a));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                List<IConnStrategy> ipv4ConnStrategyListByHost = a.a().getIpv4ConnStrategyListByHost(session.k(), session.h().startsWith("https"), session.g().e());
                if (ipv4ConnStrategyListByHost.isEmpty()) {
                    return arrayList;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < ipv4ConnStrategyListByHost.size(); i3++) {
                    IConnStrategy iConnStrategy = ipv4ConnStrategyListByHost.get(i3);
                    if (!(ConnType.l(iConnStrategy.getProtocol()).i() ^ i)) {
                        int retryTimes = iConnStrategy.getRetryTimes();
                        for (int i4 = 0; i4 <= retryTimes; i4++) {
                            i2++;
                            String h = session.h();
                            hm hmVar = new hm(h, "COMPLEX-" + session.r + JSMethod.NOT_SET + i2, iConnStrategy);
                            hmVar.d = i4;
                            hmVar.e = retryTimes;
                            arrayList.add(hmVar);
                        }
                    }
                }
            }
            str = null;
        } catch (Exception e) {
            str = null;
            ALog.d("awcn.ComplexUtils", "getIpDegradeList failed", null, e, new Object[0]);
        }
        ALog.c("awcn.ComplexUtils", "getIpDegradeList" + arrayList.toString(), str, new Object[0]);
        return arrayList;
    }

    public static boolean d(String str, String str2) {
        if (h9.p() && h9.j(str) && Inet64Util.n() == 3 && ju2.d(str2)) {
            return true;
        }
        return false;
    }
}
