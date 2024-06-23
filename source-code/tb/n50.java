package tb;

import com.taobao.rxm.common.Releasable;
import com.taobao.tcommon.core.Pool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.c02;

/* compiled from: Taobao */
public class n50<OUT, NEXT_OUT extends Releasable, CONTEXT extends c02> implements Pool<ng<OUT, NEXT_OUT, CONTEXT>> {
    private final Queue<ng<OUT, NEXT_OUT, CONTEXT>> a;
    private final int b;

    public n50() {
        this(15);
    }

    /* renamed from: a */
    public ng<OUT, NEXT_OUT, CONTEXT> offer() {
        if (l22.c()) {
            return this.a.poll();
        }
        return null;
    }

    /* renamed from: b */
    public boolean recycle(ng<OUT, NEXT_OUT, CONTEXT> ngVar) {
        if (ngVar != null) {
            ngVar.c();
        }
        if (!l22.c() || this.a.size() >= this.b || !this.a.offer(ngVar)) {
            return false;
        }
        return true;
    }

    public n50(int i) {
        this.b = i;
        this.a = new ConcurrentLinkedQueue();
    }
}
