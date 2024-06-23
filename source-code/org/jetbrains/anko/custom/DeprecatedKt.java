package org.jetbrains.anko.custom;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoAsyncContext;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.anko.AsyncKt$runOnUiThread$2;
import org.jetbrains.anko.BackgroundExecutor;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0002H\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0002H\u00032\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u000b\u001aJ\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\r*\u0002H\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aB\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\r*\u0002H\u00032\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u000b\u001a2\u0010\u000e\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00020\u0007H\b¢\u0006\u0002\u0010\u0011\u001a-\u0010\u000e\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00122\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00020\u0007H\b\u001a\u001d\u0010\u0013\u001a\u00020\u0002*\u00020\u00142\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\b\u001a%\u0010\u0013\u001a\u00020\u0002*\u00020\u00162\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\b\tH\u0007\u001a/\u0010\u0017\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0018*\u0002H\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"async", "Ljava/util/concurrent/Future;", "", "T", "executorService", "Ljava/util/concurrent/ExecutorService;", "task", "Lkotlin/Function1;", "Lorg/jetbrains/anko/AnkoAsyncContext;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/util/concurrent/ExecutorService;Lkotlin/jvm/functions/Function1;)Ljava/util/concurrent/Future;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/concurrent/Future;", "asyncResult", "R", "forEachReversed", "", "f", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "", "onUiThread", "Landroid/app/Fragment;", "Lkotlin/Function0;", "Landroid/content/Context;", "style", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Deprecated.kt */
public final class DeprecatedKt {
    @Deprecated(message = "Use runOnUiThread(f) instead.", replaceWith = @ReplaceWith(expression = "runOnUiThread(f)", imports = {}))
    public static final void onUiThread(Context context, Function1<? super Context, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AsyncKt.runOnUiThread(context, function1);
    }

    @Deprecated(message = "Use doAsync(task) instead.", replaceWith = @ReplaceWith(expression = "doAsync(task)", imports = {}))
    public static final <T> Future<Unit> async(T t, Function1<? super AnkoAsyncContext<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "task");
        return BackgroundExecutor.INSTANCE.submit(new DeprecatedKt$async$1(function1, new AnkoAsyncContext(new WeakReference(t))));
    }

    @Deprecated(message = "Use doAsync(executorService, task) instead.", replaceWith = @ReplaceWith(expression = "doAsync(executorService, task)", imports = {}))
    public static final <T> Future<Unit> async(T t, ExecutorService executorService, Function1<? super AnkoAsyncContext<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function1, "task");
        Future<T> submit = executorService.submit(new DeprecatedKt$async$2(function1, new AnkoAsyncContext(new WeakReference(t))));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<Unit> { context.task() }");
        return submit;
    }

    @Deprecated(message = "Use doAsyncResult(task) instead.", replaceWith = @ReplaceWith(expression = "doAsyncResult(task)", imports = {}))
    public static final <T, R> Future<R> asyncResult(T t, Function1<? super AnkoAsyncContext<T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "task");
        return BackgroundExecutor.INSTANCE.submit(new DeprecatedKt$asyncResult$1(function1, new AnkoAsyncContext(new WeakReference(t))));
    }

    @Deprecated(message = "Use doAsyncResult(executorService, task) instead.", replaceWith = @ReplaceWith(expression = "doAsyncResult(executorService, task)", imports = {}))
    public static final <T, R> Future<R> asyncResult(T t, ExecutorService executorService, Function1<? super AnkoAsyncContext<T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function1, "task");
        Future<R> submit = executorService.submit(new DeprecatedKt$asyncResult$2(function1, new AnkoAsyncContext(new WeakReference(t))));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<R> { context.task() }");
        return submit;
    }

    @Deprecated(message = "Use forEachReversedByIndex(f) instead.", replaceWith = @ReplaceWith(expression = "forEachReversedByIndex(f)", imports = {"org.jetbrains.anko.collections.forEachReversedByIndex"}))
    public static final <T> void forEachReversed(T[] tArr, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function1.invoke(tArr[length]);
        }
    }

    @Deprecated(message = "Use forEachReversedByIndex(f) instead.", replaceWith = @ReplaceWith(expression = "forEachReversedByIndex(f)", imports = {"org.jetbrains.anko.collections.forEachReversedByIndex"}))
    public static final <T> void forEachReversed(List<? extends T> list, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function1.invoke((Object) list.get(size));
        }
    }

    @Deprecated(message = "Use runOnUiThread(f) instead.", replaceWith = @ReplaceWith(expression = "runOnUiThread(f)", imports = {}))
    public static final void onUiThread(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new AsyncKt$runOnUiThread$2(function0));
        }
    }

    @Deprecated(message = "Use applyRecursively(block) instead.", replaceWith = @ReplaceWith(expression = "applyRecursively(style)", imports = {}))
    public static final <T extends View> T style(T t, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "style");
        AnkoInternals.INSTANCE.applyRecursively(t, function1);
        return t;
    }
}
