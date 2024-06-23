package org.jetbrains.anko.support.v4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoAsyncContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u001d\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a.\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\b0\t2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\n\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\b¨\u0006\f"}, d2 = {"onUiThread", "", "Landroidx/fragment/app/Fragment;", "f", "Lkotlin/Function0;", "runOnUiThread", "supportFragmentUiThread", "", "T", "Lorg/jetbrains/anko/AnkoAsyncContext;", "Lkotlin/Function1;", "uiThread", "supportV4-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SupportAsync.kt */
public final class SupportAsyncKt {
    public static final <T extends Fragment> boolean supportFragmentUiThread(AnkoAsyncContext<T> ankoAsyncContext, Function1<? super T, Unit> function1) {
        FragmentActivity activity;
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        T t = ankoAsyncContext.getWeakRef().get();
        if (t != null) {
            Intrinsics.checkExpressionValueIsNotNull(t, "fragment");
            if (!t.isDetached() && (activity = t.getActivity()) != null) {
                activity.runOnUiThread(new SupportAsyncKt$supportFragmentUiThread$1(function1, t));
            }
        }
        return true;
    }

    @Deprecated(message = "Use onUiThread() instead", replaceWith = @ReplaceWith(expression = "onUiThread(f)", imports = {}))
    public static final void uiThread(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$uiThread$1(function0));
    }

    @Deprecated(message = "Use runOnUiThread() instead", replaceWith = @ReplaceWith(expression = "runOnUiThread(f)", imports = {}))
    public static final void onUiThread(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$onUiThread$1(function0));
    }

    public static final void runOnUiThread(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$runOnUiThread$1(function0));
    }
}
