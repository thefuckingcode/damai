package tb;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class ps0 {
    private Context a;
    private String b;
    private Executor c;

    /* compiled from: Taobao */
    private static class b implements Executor {
        ThreadPoolExecutor a;

        /* compiled from: Taobao */
        class a implements ThreadFactory {
            a(b bVar) {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, js2.SOPATCH);
            }
        }

        private b() {
            this.a = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(this));
        }

        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }
    }

    /* compiled from: Taobao */
    private static class c {
        private static final ps0 a = new ps0();
    }

    public static ps0 d() {
        return c.a;
    }

    public String a() {
        return this.b;
    }

    public Context b() {
        return this.a;
    }

    public Executor c() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new b();
                }
            }
        }
        return this.c;
    }

    private ps0() {
    }
}
