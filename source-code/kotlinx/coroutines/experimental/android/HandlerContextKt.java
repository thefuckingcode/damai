package kotlinx.coroutines.experimental.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"MAX_DELAY", "", "UI", "Lkotlinx/coroutines/experimental/android/HandlerContext;", "getUI", "()Lkotlinx/coroutines/experimental/android/HandlerContext;", "asCoroutineDispatcher", "Landroid/os/Handler;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 1, 10})
/* compiled from: HandlerContext.kt */
public final class HandlerContextKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    private static final HandlerContext UI = new HandlerContext(new Handler(Looper.getMainLooper()), "UI");

    public static final HandlerContext getUI() {
        return UI;
    }

    public static final HandlerContext asCoroutineDispatcher(Handler handler) {
        Intrinsics.checkParameterIsNotNull(handler, "$receiver");
        return new HandlerContext(handler, null, 2, null);
    }
}
