package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.t;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public abstract class dn0<K, V> extends t implements Map.Entry<K, V> {
    protected dn0() {
    }

    /* access modifiers changed from: protected */
    public abstract Map.Entry<K, V> a();

    public boolean equals(@NullableDecl Object obj) {
        return a().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return a().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return a().getValue();
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        return a().setValue(v);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!rk1.a(getKey(), entry.getKey()) || !rk1.a(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }
}
