package tb;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import tb.pf0;

/* compiled from: Taobao */
public class qf0 {
    private pf0 a;
    private pf0 b;
    private pf0 c;
    private pf0 d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        a(qf0 qf0) {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Cpu-" + this.a.getAndIncrement());
            thread.setPriority(10);
            return thread;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        b(qf0 qf0) {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Normal-" + this.a.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        c(qf0 qf0) {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Rpc-" + this.a.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements ThreadFactory {
        @NonNull
        private final AtomicInteger a = new AtomicInteger(1);

        d(qf0 qf0) {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-IO-" + this.a.getAndIncrement());
            thread.setPriority(1);
            return thread;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e {
        private static final qf0 a = new qf0(null);
    }

    /* synthetic */ qf0(a aVar) {
        this();
    }

    @NonNull
    public static qf0 c() {
        return e.a;
    }

    public pf0 a() {
        if (this.a == null) {
            pf0.a aVar = new pf0.a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).j(2147483647L).l(20).m(new a(this));
            this.a = aVar.h();
        }
        return this.a;
    }

    public pf0 b() {
        if (this.d == null) {
            pf0.a aVar = new pf0.a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            int i = 6;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            int availableProcessors2 = (Runtime.getRuntime().availableProcessors() * 5) + 1;
            if (availableProcessors2 >= 6) {
                i = availableProcessors2;
            }
            aVar.i(availableProcessors).k(i).j(30000).g(true).m(new d(this));
            this.d = aVar.h();
        }
        return this.d;
    }

    public pf0 d() {
        if (this.b == null) {
            pf0.a aVar = new pf0.a();
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new b(this));
            this.b = aVar.h();
        }
        return this.b;
    }

    public pf0 e() {
        if (this.c == null) {
            pf0.a aVar = new pf0.a();
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            if (availableProcessors < 6) {
                availableProcessors = 6;
            }
            aVar.i(availableProcessors).k(availableProcessors).l(50).g(false).m(new c(this));
            this.c = aVar.h();
        }
        return this.c;
    }

    private qf0() {
    }
}
