package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u001d\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\b\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001d\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\b\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00072\u001d\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\b\u001a'\u0010\b\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\f*\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"UI", "Lorg/jetbrains/anko/AnkoContext;", "Landroid/app/Fragment;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Landroid/content/Context;", "setContentView", "", "Landroid/view/View;", "T", "Landroid/app/Activity;", "Lorg/jetbrains/anko/AnkoComponent;", "activity", "(Lorg/jetbrains/anko/AnkoComponent;Landroid/app/Activity;)Landroid/view/View;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: AnkoContext.kt */
public final class AnkoContextKt {
    public static final AnkoContext<Context> UI(Context context, boolean z, Function1<? super AnkoContext<? extends Context>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    public static final AnkoContext<Context> UI(Context context, Function1<? super AnkoContext<? extends Context>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final AnkoContext<Fragment> UI(Fragment fragment, Function1<? super AnkoContext<? extends Fragment>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(activity, fragment, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    public static final <T extends Activity> View setContentView(AnkoComponent<? super T> ankoComponent, T t) {
        Intrinsics.checkParameterIsNotNull(ankoComponent, "$receiver");
        Intrinsics.checkParameterIsNotNull(t, "activity");
        return ankoComponent.createView(new AnkoContextImpl(t, t, true));
    }
}
