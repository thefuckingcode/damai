package org.jetbrains.anko;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/ContextHelper;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Async.kt */
final class ContextHelper {
    public static final ContextHelper INSTANCE = new ContextHelper();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private ContextHelper() {
    }

    public final Handler getHandler() {
        return handler;
    }
}
