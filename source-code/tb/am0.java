package tb;

import android.app.Activity;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
public class am0 {
    private final Map<String, FlutterViewContainer> a;
    private final LinkedList<FlutterViewContainer> b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static final am0 a = new am0();
    }

    public static am0 h() {
        return b.a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j(StringBuilder sb, FlutterViewContainer flutterViewContainer) {
        sb.append(flutterViewContainer.getUrl() + ',');
    }

    public void b(String str, FlutterViewContainer flutterViewContainer) {
        if (str != null && flutterViewContainer != null) {
            if (this.b.contains(flutterViewContainer)) {
                this.b.remove(flutterViewContainer);
            }
            this.b.add(flutterViewContainer);
        }
    }

    public void c(String str, FlutterViewContainer flutterViewContainer) {
        this.a.put(str, flutterViewContainer);
    }

    public FlutterViewContainer d(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        return null;
    }

    public int e() {
        return this.a.size();
    }

    public FlutterViewContainer f() {
        int size = this.b.size();
        if (size == 0) {
            return null;
        }
        for (int i = size - 1; i >= 0; i--) {
            FlutterViewContainer flutterViewContainer = this.b.get(i);
            if (flutterViewContainer instanceof Activity) {
                return flutterViewContainer;
            }
        }
        return null;
    }

    public FlutterViewContainer g() {
        if (this.b.size() > 0) {
            return this.b.getLast();
        }
        return null;
    }

    public boolean i(FlutterViewContainer flutterViewContainer) {
        return this.b.contains(flutterViewContainer);
    }

    public void k(String str) {
        if (str != null) {
            this.b.remove(this.a.remove(str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("activeContainers=" + this.b.size() + ", [");
        this.b.forEach(new zl0(sb));
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    private am0() {
        this.a = new HashMap();
        this.b = new LinkedList<>();
    }
}
