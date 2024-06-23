package tb;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class lu0<K, V> {
    private final HashMap<K, ArrayList<V>> a = new HashMap<>();

    public ArrayList<V> a(K k) {
        return this.a.get(k);
    }

    public HashMap<K, ArrayList<V>> b() {
        return this.a;
    }

    public void c(K k, V v) {
        ArrayList<V> a2 = a(k);
        if (a2 == null) {
            a2 = new ArrayList<>();
        }
        a2.add(v);
        this.a.put(k, a2);
    }
}
