package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.s;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g {
    private final Set<s> a = new LinkedHashSet();

    g() {
    }

    public synchronized void a(s sVar) {
        this.a.remove(sVar);
    }

    public synchronized void b(s sVar) {
        this.a.add(sVar);
    }

    public synchronized boolean c(s sVar) {
        return this.a.contains(sVar);
    }
}
