package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a$\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\n"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/experimental/ThreadPoolDispatcher;", "nThreads", "", SerializableCookie.NAME, "", "Lkotlin/coroutines/experimental/CoroutineContext;", "parent", "Lkotlinx/coroutines/experimental/Job;", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: ThreadPoolDispatcher.kt */
public final class ThreadPoolDispatcherKt {
    public static final ThreadPoolDispatcher newSingleThreadContext(String str) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        return newFixedThreadPoolContext(1, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Parent job is no longer supported, `close` the resulting ThreadPoolDispatcher to release resources", replaceWith = @ReplaceWith(expression = "newSingleThreadContext(name)", imports = {}))
    public static /* bridge */ /* synthetic */ CoroutineContext newSingleThreadContext$default(String str, Job job, int i, Object obj) {
        if ((i & 2) != 0) {
            job = null;
        }
        return newSingleThreadContext(str, job);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Parent job is no longer supported, `close` the resulting ThreadPoolDispatcher to release resources", replaceWith = @ReplaceWith(expression = "newSingleThreadContext(name)", imports = {}))
    public static final CoroutineContext newSingleThreadContext(String str, Job job) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        return newFixedThreadPoolContext(1, str);
    }

    public static final ThreadPoolDispatcher newFixedThreadPoolContext(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            return new ThreadPoolDispatcher(i, str);
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Parent job is no longer supported, `close` the resulting ThreadPoolDispatcher to release resources", replaceWith = @ReplaceWith(expression = "newFixedThreadPoolContext(nThreads, name)", imports = {}))
    public static /* bridge */ /* synthetic */ CoroutineContext newFixedThreadPoolContext$default(int i, String str, Job job, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            job = null;
        }
        return newFixedThreadPoolContext(i, str, job);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Parent job is no longer supported, `close` the resulting ThreadPoolDispatcher to release resources", replaceWith = @ReplaceWith(expression = "newFixedThreadPoolContext(nThreads, name)", imports = {}))
    public static final CoroutineContext newFixedThreadPoolContext(int i, String str, Job job) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        return newFixedThreadPoolContext(i, str);
    }
}
