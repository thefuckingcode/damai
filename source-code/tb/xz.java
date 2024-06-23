package tb;

import com.taobao.android.dinamicx.e;

/* compiled from: Taobao */
public class xz<T> {
    public T a;
    private e b;
    private hz c;

    public xz(T t) {
        this.a = t;
    }

    public e a() {
        return this.b;
    }

    public hz b() {
        if (this.c == null) {
            this.c = new hz();
        }
        return this.c;
    }

    public boolean c() {
        e eVar = this.b;
        return eVar != null && eVar.c.size() > 0;
    }

    public void d(e eVar) {
        this.b = eVar;
    }

    public void e(hz hzVar) {
        this.c = hzVar;
    }

    public void f(T t) {
        this.a = t;
    }

    public xz(e eVar) {
        this.b = eVar;
    }

    public xz(T t, e eVar) {
        this.a = t;
        this.b = eVar;
    }

    public xz() {
    }
}
