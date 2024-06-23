package tb;

/* compiled from: Taobao */
public class d12 {
    private volatile int a;
    private volatile int b;
    private volatile int c;
    private volatile int d;

    public d12() {
        g(1000);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(int i) {
        this.c = i;
    }

    public void f(int i) {
        this.b = i;
    }

    public void g(int i) {
        this.a = i;
    }
}
