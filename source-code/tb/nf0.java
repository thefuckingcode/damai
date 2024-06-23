package tb;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
/* compiled from: Taobao */
public final class nf0 {
    private static final Logger c = Logger.getLogger(nf0.class.getName());
    @NullableDecl
    @GuardedBy("this")
    private a a;
    @GuardedBy("this")
    private boolean b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        final Runnable a;
        final Executor b;
        @NullableDecl
        a c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.a = runnable;
            this.b = executor;
            this.c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        ds1.q(runnable, "Runnable was null.");
        ds1.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.b) {
                this.a = new a(runnable, executor, this.a);
            } else {
                c(runnable, executor);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        c(r1.a, r1.b);
        r1 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r0 == null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r2 = r0.c;
        r0.c = r1;
        r1 = r0;
        r0 = r2;
     */
    public void b() {
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                a aVar = this.a;
                a aVar2 = null;
                this.a = null;
            }
        }
    }
}
