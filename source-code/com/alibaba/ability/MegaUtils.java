package com.alibaba.ability;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ability.utils.OrangeUtils;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.android.schedule.MegaScheduler;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class MegaUtils {
    @NotNull
    public static final MegaUtils INSTANCE = new MegaUtils();
    private static final Lazy a = b.b(MegaUtils$sThreadPool$2.INSTANCE);
    private static final Lazy b = b.b(MegaUtils$sMegaSchedule$2.INSTANCE);
    private static final Lazy c = b.b(MegaUtils$sHandler$2.INSTANCE);

    private MegaUtils() {
    }

    private final Handler a() {
        return (Handler) c.getValue();
    }

    private final MegaScheduler b() {
        return (MegaScheduler) b.getValue();
    }

    private final ExecutorService c() {
        return (ExecutorService) a.getValue();
    }

    @JvmStatic
    public static final void d(@NotNull Runnable runnable, long j) {
        k21.i(runnable, "run");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        k21.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread != mainLooper.getThread() || j > 0) {
            INSTANCE.a().postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    @JvmStatic
    public static final void e(@NotNull Runnable runnable) {
        k21.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        k21.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread != mainLooper.getThread()) {
            runnable.run();
        }
        if (OrangeUtils.b()) {
            MegaScheduler.i(INSTANCE.b(), runnable, 0, 2, null);
        } else {
            INSTANCE.c().submit(runnable);
        }
    }
}
