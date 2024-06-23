package tb;

import android.taobao.windvane.util.FixedSizeLinkedHashMap;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class za2<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a = -1;
    private final FixedSizeLinkedHashMap<String, T> b = new FixedSizeLinkedHashMap<>(3);
    private final FixedSizeLinkedHashMap<String, SoftReference<T>> c = new FixedSizeLinkedHashMap<>(5);

    private void c() {
        int size;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997262817")) {
            ipChange.ipc$dispatch("-1997262817", new Object[]{this});
        } else if (AppConfig.v() && (size = this.c.size()) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("缓存软引用数量:");
            sb.append(size);
            sb.append(",");
            sb.append(jl1.BLOCK_START_STR);
            for (Map.Entry<String, SoftReference<T>> entry : this.c.entrySet()) {
                T t = entry.getValue().get();
                if (t != null) {
                    sb.append(t.getClass().getSimpleName());
                    sb.append(o70.DINAMIC_PREFIX_AT);
                    sb.append(t.hashCode());
                    sb.append(",");
                }
            }
            sb.append("}");
            s72.f(sb.toString());
        }
    }

    public synchronized void a(List<kl1<?>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332443161")) {
            ipChange.ipc$dispatch("-332443161", new Object[]{this, list});
            return;
        }
        if (!f92.d(list)) {
            for (kl1<?> kl1 : list) {
                String b2 = kl1.b();
                long c2 = kl1.c();
                this.c.remove(b2);
                this.b.remove(b2);
                if (this.a == c2) {
                    this.a = -1;
                }
            }
        }
    }

    @Nullable
    public synchronized T b(kl1 kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501738745")) {
            return (T) ipChange.ipc$dispatch("-501738745", new Object[]{this, kl1});
        }
        T t = null;
        SoftReference<T> softReference = this.c.get(kl1.b());
        if (softReference != null) {
            t = softReference.get();
        }
        return t;
    }

    public synchronized void d(kl1 kl1, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958332832")) {
            ipChange.ipc$dispatch("1958332832", new Object[]{this, kl1, t});
            return;
        }
        long c2 = kl1.c();
        String b2 = kl1.b();
        if (c2 == this.a) {
            this.b.remove(b2);
            this.b.put(b2, t);
        } else {
            this.a = c2;
            this.b.clear();
            this.b.put(b2, t);
        }
        this.c.remove(b2);
        this.c.put(b2, new SoftReference<>(t));
        c();
    }

    public synchronized void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401774222")) {
            ipChange.ipc$dispatch("-401774222", new Object[]{this});
            return;
        }
        this.a = -1;
        this.b.clear();
    }
}
