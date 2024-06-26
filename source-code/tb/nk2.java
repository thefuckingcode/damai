package tb;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

@CanIgnoreReturnValue
@GwtIncompatible
/* compiled from: Taobao */
public final class nk2 {
    private String a = null;
    private Boolean b = null;
    private Integer c = null;
    private Thread.UncaughtExceptionHandler d = null;
    private ThreadFactory e = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        final /* synthetic */ ThreadFactory a;
        final /* synthetic */ String b;
        final /* synthetic */ AtomicLong c;
        final /* synthetic */ Boolean d;
        final /* synthetic */ Integer e;
        final /* synthetic */ Thread.UncaughtExceptionHandler f;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = threadFactory;
            this.b = str;
            this.c = atomicLong;
            this.d = bool;
            this.e = num;
            this.f = uncaughtExceptionHandler;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.a.newThread(runnable);
            String str = this.b;
            if (str != null) {
                newThread.setName(nk2.d(str, new Object[]{Long.valueOf(this.c.getAndIncrement())}));
            }
            Boolean bool = this.d;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.e;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    private static ThreadFactory c(nk2 nk2) {
        String str = nk2.a;
        Boolean bool = nk2.b;
        Integer num = nk2.c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = nk2.d;
        ThreadFactory threadFactory = nk2.e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0) : null, bool, num, uncaughtExceptionHandler);
    }

    /* access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @CheckReturnValue
    public ThreadFactory b() {
        return c(this);
    }

    public nk2 e(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public nk2 f(String str) {
        d(str, 0);
        this.a = str;
        return this;
    }
}
