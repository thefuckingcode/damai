package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import tb.af0;

/* compiled from: Taobao */
public abstract class EventListener {
    public static final EventListener NONE = new a();

    /* compiled from: Taobao */
    public interface Factory {
        EventListener create(Call call);
    }

    /* compiled from: Taobao */
    class a extends EventListener {
        a() {
        }
    }

    static Factory l(EventListener eventListener) {
        return new af0(eventListener);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ EventListener m(EventListener eventListener, Call call) {
        return eventListener;
    }

    public void b(Call call) {
    }

    public void c(Call call, IOException iOException) {
    }

    public void d(Call call) {
    }

    public void e(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
    }

    public void f(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
    }

    public void g(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void h(Call call, Connection connection) {
    }

    public void i(Call call, Connection connection) {
    }

    public void j(Call call, String str, List<InetAddress> list) {
    }

    public void k(Call call, String str) {
    }

    public void n(Call call, long j) {
    }

    public void o(Call call) {
    }

    public void p(Call call, IOException iOException) {
    }

    public void q(Call call, o oVar) {
    }

    public void r(Call call) {
    }

    public void s(Call call, long j) {
    }

    public void t(Call call) {
    }

    public void u(Call call, IOException iOException) {
    }

    public void v(Call call, q qVar) {
    }

    public void w(Call call) {
    }

    public void x(Call call, @Nullable k kVar) {
    }

    public void y(Call call) {
    }
}
