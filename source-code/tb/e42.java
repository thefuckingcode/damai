package tb;

import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.tcommon.core.Pool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
public class e42 implements Pool<ScheduledAction> {
    private final Queue<ScheduledAction> a;
    private final int b;

    public e42() {
        this(50);
    }

    /* renamed from: a */
    public ScheduledAction offer() {
        if (l22.c()) {
            return this.a.poll();
        }
        return null;
    }

    /* renamed from: b */
    public boolean recycle(ScheduledAction scheduledAction) {
        if (scheduledAction != null) {
            scheduledAction.reset();
        }
        if (!l22.c() || this.a.size() >= this.b || !this.a.offer(scheduledAction)) {
            return false;
        }
        return true;
    }

    public e42(int i) {
        this.b = i;
        this.a = new ConcurrentLinkedQueue();
    }
}
