package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.m;
import okhttp3.s;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h {
    private final okhttp3.a a;
    private final g b;
    private final Call c;
    private final EventListener d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<s> h = new ArrayList();

    /* compiled from: Taobao */
    public static final class a {
        private final List<s> a;
        private int b = 0;

        a(List<s> list) {
            this.a = list;
        }

        public List<s> a() {
            return new ArrayList(this.a);
        }

        public boolean b() {
            return this.b < this.a.size();
        }

        public s c() {
            if (b()) {
                List<s> list = this.a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    h(okhttp3.a aVar, g gVar, Call call, EventListener eventListener) {
        this.a = aVar;
        this.b = gVar;
        this.c = call;
        this.d = eventListener;
        g(aVar.l(), aVar.g());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy e() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.l().m() + "; exhausted proxy configurations: " + this.e);
    }

    private void f(Proxy proxy) throws IOException {
        String str;
        int i;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.a.l().m();
            i = this.a.l().x();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.d.k(this.c, str);
            List<InetAddress> lookup = this.a.c().lookup(str);
            if (!lookup.isEmpty()) {
                this.d.j(this.c, str, lookup);
                int size = lookup.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.g.add(new InetSocketAddress(lookup.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.a.c() + " returned no addresses for " + str);
        }
    }

    private void g(m mVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.i().select(mVar.D());
            if (select == null || select.isEmpty()) {
                list = okhttp3.internal.a.u(Proxy.NO_PROXY);
            } else {
                list = okhttp3.internal.a.t(select);
            }
            this.e = list;
        }
        this.f = 0;
    }

    public boolean b() {
        return c() || !this.h.isEmpty();
    }

    public a d() throws IOException {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy e2 = e();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    s sVar = new s(this.a, e2, this.g.get(i));
                    if (this.b.c(sVar)) {
                        this.h.add(sVar);
                    } else {
                        arrayList.add(sVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
