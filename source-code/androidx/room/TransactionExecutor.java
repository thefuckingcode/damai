package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    TransactionExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            /* class androidx.room.TransactionExecutor.AnonymousClass1 */

            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
