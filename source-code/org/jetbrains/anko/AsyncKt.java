package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\u0001\u001a;\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n0\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\b\u000b\u001a9\u0010\f\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f\u001aF\u0010\f\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n0\b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\b\u0010\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\"\u0004\b\u0000\u0010\u0006*\u0002H\u00062\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0017\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\"\u0004\b\u0000\u0010\u0006*\u0002H\u00062\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0018\u001a`\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0012\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u001a*\u0002H\u00062\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b\u0012\u0004\u0012\u0002H\u001a0\u0001¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0017\u001aX\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0012\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u001a*\u0002H\u00062\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b\u0012\u0004\u0012\u0002H\u001a0\u0001¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0018\u001a0\u0010\u001b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u001c*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\u0001H\u0007\u001a;\u0010\u001d\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u001c*\b\u0012\u0004\u0012\u0002H\u00060\b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000fH\u0007\u001a,\u0010\u001e\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001d\u0010\u001f\u001a\u00020\u0003*\u00020\u001c2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030 H\b\u001a#\u0010\u001f\u001a\u00020\u0003*\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u000f\u001a*\u0010!\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00030\u0001\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"crashLogger", "Lkotlin/Function1;", "", "", "activityUiThread", "", "T", "Landroid/app/Activity;", "Lorg/jetbrains/anko/AnkoAsyncContext;", "f", "Lorg/jetbrains/anko/AnkoContext;", "activityContextUiThread", "activityUiThreadWithContext", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ExtensionFunctionType;", "activityContextUiThreadWithContext", "doAsync", "Ljava/util/concurrent/Future;", "exceptionHandler", "executorService", "Ljava/util/concurrent/ExecutorService;", "task", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/util/concurrent/ExecutorService;Lkotlin/jvm/functions/Function1;)Ljava/util/concurrent/Future;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/concurrent/Future;", "doAsyncResult", "R", "fragmentUiThread", "Landroid/app/Fragment;", "fragmentUiThreadWithContext", "onComplete", "runOnUiThread", "Lkotlin/Function0;", "uiThread", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Async.kt */
public final class AsyncKt {
    private static final Function1<Throwable, Unit> crashLogger = AsyncKt$crashLogger$1.INSTANCE;

    public static final void runOnUiThread(Context context, Function1<? super Context, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(context);
        } else {
            ContextHelper.INSTANCE.getHandler().post(new AsyncKt$runOnUiThread$1(context, function1));
        }
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final void runOnUiThread(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new AsyncKt$runOnUiThread$2(function0));
        }
    }

    public static final <T> void onComplete(AnkoAsyncContext<T> ankoAsyncContext, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(t);
        } else {
            ContextHelper.INSTANCE.getHandler().post(new AsyncKt$onComplete$1(function1, t));
        }
    }

    public static final <T> boolean uiThread(AnkoAsyncContext<T> ankoAsyncContext, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t == null) {
            return false;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(t);
            return true;
        }
        ContextHelper.INSTANCE.getHandler().post(new AsyncKt$uiThread$1(function1, t));
        return true;
    }

    public static final <T extends Activity> boolean activityUiThread(AnkoAsyncContext<T> ankoAsyncContext, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(t, "activity");
        if (t.isFinishing()) {
            return false;
        }
        t.runOnUiThread(new AsyncKt$activityUiThread$1(function1, t));
        return true;
    }

    public static final <T extends Activity> boolean activityUiThreadWithContext(AnkoAsyncContext<T> ankoAsyncContext, Function2<? super Context, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(t, "activity");
        if (t.isFinishing()) {
            return false;
        }
        t.runOnUiThread(new AsyncKt$activityUiThreadWithContext$1(function2, t));
        return true;
    }

    public static final <T extends Activity> boolean activityContextUiThread(AnkoAsyncContext<AnkoContext<T>> ankoAsyncContext, Function1<? super T, Unit> function1) {
        T owner;
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AnkoContext<T> ankoContext = ankoAsyncContext.getWeakRef().get();
        if (ankoContext == null || (owner = ankoContext.getOwner()) == null || owner.isFinishing()) {
            return false;
        }
        owner.runOnUiThread(new AsyncKt$activityUiThread$2(function1, owner));
        return true;
    }

    public static final <T extends Activity> boolean activityContextUiThreadWithContext(AnkoAsyncContext<AnkoContext<T>> ankoAsyncContext, Function2<? super Context, ? super T, Unit> function2) {
        T owner;
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        AnkoContext<T> ankoContext = ankoAsyncContext.getWeakRef().get();
        if (ankoContext == null || (owner = ankoContext.getOwner()) == null || owner.isFinishing()) {
            return false;
        }
        owner.runOnUiThread(new AsyncKt$activityUiThreadWithContext$2(function2, owner));
        return true;
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <T extends Fragment> boolean fragmentUiThread(AnkoAsyncContext<T> ankoAsyncContext, Function1<? super T, Unit> function1) {
        Activity activity;
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t != null) {
            Intrinsics.checkExpressionValueIsNotNull(t, "fragment");
            if (!t.isDetached() && (activity = t.getActivity()) != null) {
                activity.runOnUiThread(new AsyncKt$fragmentUiThread$1(function1, t));
                return true;
            }
        }
        return false;
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <T extends Fragment> boolean fragmentUiThreadWithContext(AnkoAsyncContext<T> ankoAsyncContext, Function2<? super Context, ? super T, Unit> function2) {
        Activity activity;
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t != null) {
            Intrinsics.checkExpressionValueIsNotNull(t, "fragment");
            if (!t.isDetached() && (activity = t.getActivity()) != null) {
                activity.runOnUiThread(new AsyncKt$fragmentUiThreadWithContext$1(function2, activity, t));
                return true;
            }
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ Future doAsync$default(Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = crashLogger;
        }
        return doAsync(obj, function1, function12);
    }

    public static final <T> Future<Unit> doAsync(T t, Function1<? super Throwable, Unit> function1, Function1<? super AnkoAsyncContext<T>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(function12, "task");
        return BackgroundExecutor.INSTANCE.submit(new AsyncKt$doAsync$1(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
    }

    public static /* bridge */ /* synthetic */ Future doAsync$default(Object obj, Function1 function1, ExecutorService executorService, Function1 function12, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = crashLogger;
        }
        return doAsync(obj, function1, executorService, function12);
    }

    public static final <T> Future<Unit> doAsync(T t, Function1<? super Throwable, Unit> function1, ExecutorService executorService, Function1<? super AnkoAsyncContext<T>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function12, "task");
        Future<T> submit = executorService.submit(new AsyncKt$doAsync$2(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<U…voke(thr)\n        }\n    }");
        return submit;
    }

    public static /* bridge */ /* synthetic */ Future doAsyncResult$default(Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = crashLogger;
        }
        return doAsyncResult(obj, function1, function12);
    }

    public static final <T, R> Future<R> doAsyncResult(T t, Function1<? super Throwable, Unit> function1, Function1<? super AnkoAsyncContext<T>, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function12, "task");
        return BackgroundExecutor.INSTANCE.submit(new AsyncKt$doAsyncResult$1(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
    }

    public static /* bridge */ /* synthetic */ Future doAsyncResult$default(Object obj, Function1 function1, ExecutorService executorService, Function1 function12, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = crashLogger;
        }
        return doAsyncResult(obj, function1, executorService, function12);
    }

    public static final <T, R> Future<R> doAsyncResult(T t, Function1<? super Throwable, Unit> function1, ExecutorService executorService, Function1<? super AnkoAsyncContext<T>, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function12, "task");
        Future<R> submit = executorService.submit(new AsyncKt$doAsyncResult$2(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<R…throw thr\n        }\n    }");
        return submit;
    }
}
