package tb;

import java.net.Inet6Address;

/* compiled from: Taobao */
public class ug1 {
    public int a;
    public Inet6Address b;

    public ug1(Inet6Address inet6Address, int i) {
        this.a = i;
        this.b = inet6Address;
    }

    public String toString() {
        return this.b.getHostAddress() + "/" + this.a;
    }
}
