package tb;

import com.taobao.update.datasource.PatchRunnable;
import com.taobao.update.datasource.Task;
import com.taobao.update.types.PatchType;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class qs1 implements Comparable<qs1>, Task {
    private final a a;
    private PatchType b;
    private boolean c;
    private String d;
    private PatchRunnable e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        private AtomicInteger a = new AtomicInteger();
        private PatchType b;

        public a(PatchType patchType) {
            this.b = patchType;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.b.getKey() + "-thread-" + this.a.incrementAndGet());
        }
    }

    public qs1(PatchType patchType, PatchRunnable patchRunnable, String str, boolean z) {
        this.e = patchRunnable;
        this.b = patchType;
        this.d = str;
        this.c = z;
        this.a = new a(patchType);
    }

    @Override // com.taobao.update.datasource.Task
    public void asyncRun() {
        this.a.newThread(this.e).start();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof qs1) && this.b == ((qs1) obj).b) {
            return true;
        }
        return false;
    }

    public String from() {
        return this.d;
    }

    public PatchType getPatchType() {
        return this.b;
    }

    public PatchRunnable getRunnable() {
        return this.e;
    }

    public int hashCode() {
        PatchType patchType = this.b;
        if (patchType != null) {
            return patchType.hashCode();
        }
        return 0;
    }

    public boolean isBackground() {
        return this.c;
    }

    @Override // com.taobao.update.datasource.Task
    public void syncRun() {
        Thread newThread = this.a.newThread(this.e);
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public int compareTo(qs1 qs1) {
        return this.b.getPriority() - qs1.b.getPriority();
    }
}
