package com.youku.gaiax.impl.utils;

import android.os.Handler;
import android.os.Looper;
import com.youku.arch.v3.event.Subject;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.tr0;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bJ\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/impl/utils/GaiaXUiExecutor;", "", "", "isMainThread", "Ljava/util/concurrent/FutureTask;", "Ltb/ur2;", "runnable", "action", "Ljava/lang/Runnable;", "Lkotlin/Function0;", Subject.FUNCTION, "removeAction", "Landroid/os/Handler;", "ui", "Landroid/os/Handler;", "getUi", "()Landroid/os/Handler;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXUiExecutor {
    @NotNull
    public static final GaiaXUiExecutor INSTANCE = new GaiaXUiExecutor();
    @NotNull
    private static final Handler ui = new Handler(Looper.getMainLooper());

    private GaiaXUiExecutor() {
    }

    /* access modifiers changed from: private */
    /* renamed from: action$lambda-0  reason: not valid java name */
    public static final void m898action$lambda0(Function0 function0) {
        k21.i(function0, "$function");
        function0.invoke();
    }

    public final void action(@NotNull FutureTask<ur2> futureTask) {
        k21.i(futureTask, "runnable");
        ui.post(futureTask);
    }

    @NotNull
    public final Handler getUi() {
        return ui;
    }

    public final boolean isMainThread() {
        return Looper.myLooper() == null || k21.d(Looper.myLooper(), Looper.getMainLooper());
    }

    public final void removeAction(@NotNull Runnable runnable) {
        k21.i(runnable, "runnable");
        ui.removeCallbacks(runnable);
    }

    public final void action(@NotNull Runnable runnable) {
        k21.i(runnable, "runnable");
        ui.post(runnable);
    }

    public final void action(@NotNull Function0<ur2> function0) {
        k21.i(function0, Subject.FUNCTION);
        ui.post(new tr0(function0));
    }
}
