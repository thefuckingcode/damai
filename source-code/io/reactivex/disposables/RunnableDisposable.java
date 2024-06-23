package io.reactivex.disposables;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.reactivex.annotations.NonNull;
import tb.jl1;

/* compiled from: Taobao */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + AVFSCacheConstants.COMMA_SEP + get() + jl1.BRACKET_END_STR;
    }

    /* access modifiers changed from: protected */
    public void onDisposed(@NonNull Runnable runnable) {
        runnable.run();
    }
}
