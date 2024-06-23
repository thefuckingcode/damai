package org.jetbrains.anko.support.v4;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.ContextUtilsKt;
import org.jetbrains.anko.Orientation;
import org.jetbrains.anko.ScreenSize;
import org.jetbrains.anko.UiMode;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u001d\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u001a¶\u0001\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\t*\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u001cH\b¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001e\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u001f*\u00020\u00022\u0006\u0010 \u001a\u00020\u000eH\b¢\u0006\u0002\u0010!\u001a(\u0010\"\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u001f*\u00020\u00022\u0006\u0010 \u001a\u00020\u000eH\b¢\u0006\u0002\u0010!\u001aI\u0010#\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u0002*\u0002H\b2.\u0010$\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0&0%\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0&¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"UI", "Lorg/jetbrains/anko/AnkoContext;", "Landroidx/fragment/app/Fragment;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "configuration", "T", "", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "", "language", "", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "Lkotlin/Function0;", "(Landroid/support/v4/app/Fragment;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "find", "Landroid/view/View;", "id", "(Landroid/support/v4/app/Fragment;I)Landroid/view/View;", "findOptional", "withArguments", "params", "", "Lkotlin/Pair;", "(Landroid/support/v4/app/Fragment;[Lkotlin/Pair;)Landroid/support/v4/app/Fragment;", "supportV4-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Support.kt */
public final class SupportKt {
    private static final <T extends View> T find(Fragment fragment, int i) {
        View view = fragment.getView();
        View findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(1, "T");
        return (T) findViewById;
    }

    private static final <T extends View> T findOptional(Fragment fragment, int i) {
        View view = fragment.getView();
        View findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) findViewById;
    }

    public static final AnkoContext<Fragment> UI(Fragment fragment, Function1<? super AnkoContext<? extends Fragment>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(requireActivity, fragment, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    public static /* bridge */ /* synthetic */ Object configuration$default(Fragment fragment, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        ScreenSize screenSize2 = (i & 1) != 0 ? null : screenSize;
        ClosedRange closedRange2 = (i & 2) != 0 ? null : closedRange;
        String str2 = (i & 4) != 0 ? null : str;
        Orientation orientation2 = (i & 8) != 0 ? null : orientation;
        Boolean bool4 = (i & 16) != 0 ? null : bool;
        Integer num4 = (i & 32) != 0 ? null : num;
        Integer num5 = (i & 64) != 0 ? null : num2;
        UiMode uiMode2 = (i & 128) != 0 ? null : uiMode;
        Boolean bool5 = (i & 256) != 0 ? null : bool2;
        Boolean bool6 = (i & 512) != 0 ? null : bool3;
        Integer num6 = (i & 1024) != 0 ? null : num3;
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "init");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize2, closedRange2, str2, orientation2, bool4, num4, num5, uiMode2, bool5, bool6, num6)) {
            return null;
        }
        return function0.invoke();
    }

    public static final <T> T configuration(Fragment fragment, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "init");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return (T) function0.invoke();
    }

    public static final <T extends Fragment> T withArguments(T t, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        t.setArguments(ContextUtilsKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return t;
    }
}
