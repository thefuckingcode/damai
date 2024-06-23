package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Callable;
import tb.k22;

/* compiled from: Taobao */
public final class a {
    @NonNull
    static final Scheduler a = k22.h(new h());
    @NonNull
    static final Scheduler b = k22.e(new b());
    @NonNull
    static final Scheduler c = TrampolineScheduler.instance();

    /* access modifiers changed from: package-private */
    /* renamed from: io.reactivex.schedulers.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0263a {
        static final Scheduler a = new ComputationScheduler();
    }

    /* compiled from: Taobao */
    static final class b implements Callable<Scheduler> {
        b() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C0263a.a;
        }
    }

    /* compiled from: Taobao */
    static final class c implements Callable<Scheduler> {
        c() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return d.a;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class d {
        static final Scheduler a = new IoScheduler();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class e {
        static final Scheduler a = new NewThreadScheduler();
    }

    /* compiled from: Taobao */
    static final class f implements Callable<Scheduler> {
        f() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return e.a;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class g {
        static final Scheduler a = new SingleScheduler();
    }

    /* compiled from: Taobao */
    static final class h implements Callable<Scheduler> {
        h() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return g.a;
        }
    }

    static {
        k22.f(new c());
        k22.g(new f());
    }

    @NonNull
    public static Scheduler a() {
        return k22.t(b);
    }

    @NonNull
    public static Scheduler b() {
        return k22.w(a);
    }

    @NonNull
    public static Scheduler c() {
        return c;
    }
}
