package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
public class gc1<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public gc1(int i) {
        if (i > 0) {
            this.c = i;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int f(K k, V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951218295")) {
            return ((Integer) ipChange.ipc$dispatch("-1951218295", new Object[]{this, k, v})).intValue();
        }
        int g2 = g(k, v);
        if (g2 >= 0) {
            return g2;
        }
        throw new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
    }

    public synchronized void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966064358")) {
            ipChange.ipc$dispatch("-966064358", new Object[]{this});
            return;
        }
        this.a.clear();
    }

    /* access modifiers changed from: protected */
    public V b(K k) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-63576241")) {
            return null;
        }
        return (V) ipChange.ipc$dispatch("-63576241", new Object[]{this, k});
    }

    /* access modifiers changed from: protected */
    public void c(boolean z, K k, V v, V v2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389539571")) {
            ipChange.ipc$dispatch("389539571", new Object[]{this, Boolean.valueOf(z), k, v, v2});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r0 = b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5.e++;
        r1 = r5.a.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r1 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        r5.a.put(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r5.b += f(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r1 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        c(false, r6, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        h(r5.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        return r0;
     */
    public final V d(K k) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225788229")) {
            return (V) ipChange.ipc$dispatch("1225788229", new Object[]{this, k});
        }
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.g++;
                return v;
            }
            this.h++;
        }
    }

    public final V e(K k, V v) {
        V put;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716767518")) {
            return (V) ipChange.ipc$dispatch("-1716767518", new Object[]{this, k, v});
        } else if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        } else {
            synchronized (this) {
                this.d++;
                this.b += f(k, v);
                put = this.a.put(k, v);
                if (put != null) {
                    this.b -= f(k, put);
                }
            }
            if (put != null) {
                c(false, k, put, v);
            }
            h(this.c);
            return put;
        }
    }

    /* access modifiers changed from: protected */
    public int g(K k, V v) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "117848854")) {
            return 1;
        }
        return ((Integer) ipChange.ipc$dispatch("117848854", new Object[]{this, k, v})).intValue();
    }

    public void h(int i) {
        K key;
        V value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313841506")) {
            ipChange.ipc$dispatch("-1313841506", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    if (this.b < 0) {
                        this.b = 0;
                        this.a.clear();
                    } else if (this.a.isEmpty() && this.b != 0) {
                        this.b = 0;
                    }
                }
                if (this.b <= i) {
                    break;
                } else if (this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.b -= f(key, value);
                    this.f++;
                }
            }
            c(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813538231")) {
            return (String) ipChange.ipc$dispatch("-1813538231", new Object[]{this});
        }
        int i = this.g;
        int i2 = this.h + i;
        return String.format("MemLruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
