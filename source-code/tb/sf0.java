package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory;
import com.google.common.util.concurrent.ListeningExecutorService;

/* compiled from: Taobao */
public class sf0 {
    private IExecutorServiceFactory a;
    private ListeningExecutorService b;
    private ListeningExecutorService c;
    private ListeningExecutorService d;
    private ListeningExecutorService e;

    /* compiled from: Taobao */
    private static class b {
        private static final sf0 a = new sf0();
    }

    @NonNull
    public static sf0 c() {
        return b.a;
    }

    public ListeningExecutorService a() {
        if (this.b == null) {
            this.b = this.a.createCpuExecutorService(qf0.c().a());
        }
        return this.b;
    }

    public ListeningExecutorService b() {
        if (this.c == null) {
            this.c = this.a.createIOExecutorService(qf0.c().b());
        }
        return this.c;
    }

    public ListeningExecutorService d() {
        if (this.d == null) {
            this.d = this.a.createNormalExecutorService(qf0.c().d());
        }
        return this.d;
    }

    public ListeningExecutorService e() {
        if (this.e == null) {
            this.e = this.a.createRpcExecutorService(qf0.c().e());
        }
        return this.e;
    }

    private sf0() {
        this.a = new rf0();
    }
}
