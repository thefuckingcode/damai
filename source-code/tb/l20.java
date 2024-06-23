package tb;

import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class l20 {
    private List<IDMComponent> a = new ArrayList();
    private List<IDMComponent> b = new ArrayList();
    private List<IDMComponent> c = new ArrayList();
    private List<mc0> d = new ArrayList();

    public List<IDMComponent> a() {
        return this.b;
    }

    public List<mc0> b() {
        return this.d;
    }

    public List<IDMComponent> c() {
        return this.c;
    }

    public List<IDMComponent> d() {
        return this.a;
    }

    public void e(List<IDMComponent> list) {
        if (list != null && list.size() > 0) {
            this.b.clear();
            this.b.addAll(list);
        }
    }

    public void f(List<mc0> list) {
        if (list != null && !list.isEmpty()) {
            this.d.clear();
            this.d.addAll(list);
        }
    }

    public void g(List<IDMComponent> list) {
        if (list != null && list.size() > 0) {
            this.c.clear();
            this.c.addAll(list);
        }
    }

    public void h(List<IDMComponent> list) {
        if (list != null && list.size() > 0) {
            this.a.clear();
            this.a.addAll(list);
        }
    }
}
