package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.a;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.a92;
import tb.ag2;
import tb.h9;
import tb.ke1;
import tb.ss0;

/* compiled from: Taobao */
class AccsSessionManager {
    private static CopyOnWriteArraySet<ISessionListener> c = new CopyOnWriteArraySet<>();
    c a = null;
    Set<String> b = Collections.EMPTY_SET;

    AccsSessionManager(c cVar) {
        this.a = cVar;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            ALog.c("awcn.AccsSessionManager", "closeSessions", this.a.b, "host", str);
            this.a.p(str).p(false);
        }
    }

    private boolean e() {
        if ((!ss0.i() || !h9.i()) && NetworkStatusHelper.n()) {
            return true;
        }
        return false;
    }

    public synchronized void b() {
        Collection<a92> c2 = this.a.f.c();
        Set<String> set = Collections.EMPTY_SET;
        if (!c2.isEmpty()) {
            set = new TreeSet<>();
        }
        for (a92 a92 : c2) {
            if (a92.b) {
                set.add(ag2.e(a.a().getSchemeByHost(a92.a, a92.c ? "https" : "http"), ke1.SCHEME_SLASH, a92.a));
            }
        }
        for (String str : this.b) {
            if (!set.contains(str)) {
                c(str);
            }
        }
        if (e()) {
            for (String str2 : set) {
                try {
                    this.a.i(str2, ConnType.TypeLevel.SPDY, 0);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, "host", str2);
                }
            }
            this.b = set;
        }
    }

    public synchronized void d(boolean z) {
        if (ALog.g(1)) {
            ALog.c("awcn.AccsSessionManager", "forceCloseSession", this.a.b, "reCreate", Boolean.valueOf(z));
        }
        for (String str : this.b) {
            c(str);
        }
        if (z) {
            b();
        }
    }

    public void f(final Intent intent) {
        ThreadPoolExecutorFactory.i(new Runnable() {
            /* class anet.channel.AccsSessionManager.AnonymousClass1 */

            public void run() {
                Iterator it = AccsSessionManager.c.iterator();
                while (it.hasNext()) {
                    try {
                        ((ISessionListener) it.next()).onConnectionChanged(intent);
                    } catch (Exception e) {
                        ALog.d("awcn.AccsSessionManager", "notifyListener exception.", null, e, new Object[0]);
                    }
                }
            }
        });
    }

    public void g(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            c.add(iSessionListener);
        }
    }

    public void h(ISessionListener iSessionListener) {
        c.remove(iSessionListener);
    }
}
