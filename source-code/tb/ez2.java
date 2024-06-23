package tb;

import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Taobao */
public class ez2 {
    private String a;
    private IResponseDispatcher b;
    private boolean c;
    private boolean d = true;
    private int e = 60;
    private Proxy f;
    private Draft g;
    private Map<String, String> h;
    private int i = 0;
    private int j = 10;
    private ResponseDelivery k;

    public int a() {
        return this.i;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.e;
    }

    public Draft d() {
        return this.g;
    }

    public Map<String, String> e() {
        return this.h;
    }

    public Proxy f() {
        return this.f;
    }

    public int g() {
        return this.j;
    }

    public ResponseDelivery h() {
        return this.k;
    }

    public IResponseDispatcher i() {
        if (this.b == null) {
            this.b = new e50();
        }
        return this.b;
    }

    public boolean j() {
        return this.c;
    }

    public boolean k() {
        return this.d;
    }

    public void l(int i2) {
        this.i = i2;
    }

    public void m(String str) {
        this.a = str;
    }

    public void n(int i2) {
        this.e = i2;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(boolean z) {
        this.d = z;
    }
}
