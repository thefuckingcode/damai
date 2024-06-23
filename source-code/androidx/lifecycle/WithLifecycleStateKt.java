package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.f90;
import tb.k21;
import tb.p30;
import tb.xa1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000e\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000e\u001a5\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HHø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0007\u001aC\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function0;", "block", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "", "dispatchNeeded", "Lkotlinx/coroutines/CoroutineDispatcher;", "lifecycleDispatcher", "suspendWithStateAtLeastUnchecked", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class WithLifecycleStateKt {
    @PublishedApi
    @Nullable
    public static final <R> Object suspendWithStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, boolean z, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, lifecycle, state, function0, z, coroutineDispatcher);
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, lifecycle, state, function0, z, coroutineDispatcher));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1);
        }
        cancellableContinuationImpl.invokeOnCancellation(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, lifecycle, state, function0, z, coroutineDispatcher));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b.d()) {
            p30.c(continuation);
        }
        return result;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    private static final Object withCreated$$forInline(@NotNull Lifecycle lifecycle, @NotNull Function0 function0, @NotNull Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    private static final Object withResumed$$forInline(@NotNull Lifecycle lifecycle, @NotNull Function0 function0, @NotNull Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    private static final Object withStarted$$forInline(@NotNull Lifecycle lifecycle, @NotNull Function0 function0, @NotNull Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            xa1 a = f90.c().a();
            boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                    return function0.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @Nullable
    private static final Object withStateAtLeast$$forInline(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0 function0, @NotNull Continuation continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object withStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @PublishedApi
    @Nullable
    private static final Object withStateAtLeastUnchecked$$forInline(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0 function0, @NotNull Continuation continuation) {
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    private static final Object withCreated$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0 function0, @NotNull Continuation continuation) {
        k21.h(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    private static final Object withResumed$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0 function0, @NotNull Continuation continuation) {
        k21.h(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    private static final Object withStarted$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0 function0, @NotNull Continuation continuation) {
        k21.h(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    private static final Object withStateAtLeast$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function0 function0, @NotNull Continuation continuation) {
        k21.h(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        f90.c().a();
        b11.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        k21.h(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        k21.h(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        k21.h(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        xa1 a = f90.c().a();
        boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        k21.h(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            xa1 a = f90.c().a();
            boolean isDispatchNeeded = a.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo((Enum) state) >= 0) {
                    return function0.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, a, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
