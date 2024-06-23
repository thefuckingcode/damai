package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import androidx.core.view.ViewCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b\u001a\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\nH\b\u001a\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\nH\b\u001a\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\nH\b\u001a¶\u0001\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0011*\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010$\u001a¶\u0001\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0011*\u00020%2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010&\u001a¶\u0001\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0011*\u00020'2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010(\u001aº\u0001\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0011*\u0006\u0012\u0002\b\u00030)2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020\u0001*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006-"}, d2 = {"gray", "", "getGray", "(I)I", "opaque", "getOpaque", "attempt", "Lorg/jetbrains/anko/AttemptResult;", "T", "f", "Lkotlin/Function0;", "doBeforeSdk", "", "version", "doFromSdk", "doIfSdk", "configuration", "", "Landroid/app/Activity;", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "language", "", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "(Landroid/app/Activity;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroid/app/Fragment;", "(Landroid/app/Fragment;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroid/content/Context;", "(Landroid/content/Context;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/jetbrains/anko/AnkoContext;", "(Lorg/jetbrains/anko/AnkoContext;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withAlpha", "alpha", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Helpers.kt */
public final class HelpersKt {
    public static final int getGray(int i) {
        return (i << 16) | (i << 8) | i;
    }

    public static final int getOpaque(int i) {
        return i | ((int) 4278190080L);
    }

    public static final int withAlpha(int i, int i2) {
        if (i2 >= 0 && 255 >= i2) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static /* bridge */ /* synthetic */ Object configuration$default(Context context, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
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
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(context, screenSize2, closedRange2, str2, orientation2, bool4, num4, num5, uiMode2, bool5, bool6, num6)) {
            return function0.invoke();
        }
        return null;
    }

    public static final <T> T configuration(Context context, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(context, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return (T) function0.invoke();
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ Object configuration$default(Activity activity, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
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
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(activity, screenSize2, closedRange2, str2, orientation2, bool4, num4, num5, uiMode2, bool5, bool6, num6)) {
            return function0.invoke();
        }
        return null;
    }

    public static final <T> T configuration(Activity activity, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return (T) function0.invoke();
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ Object configuration$default(AnkoContext ankoContext, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
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
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(ankoContext.getCtx(), screenSize2, closedRange2, str2, orientation2, bool4, num4, num5, uiMode2, bool5, bool6, num6)) {
            return function0.invoke();
        }
        return null;
    }

    public static final <T> T configuration(AnkoContext<?> ankoContext, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(ankoContext.getCtx(), screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return (T) function0.invoke();
        }
        return null;
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
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
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize2, closedRange2, str2, orientation2, bool4, num4, num5, uiMode2, bool5, bool6, num6)) {
            return null;
        }
        return function0.invoke();
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <T> T configuration(Fragment fragment, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return (T) function0.invoke();
    }

    public static final void doBeforeSdk(int i, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (Build.VERSION.SDK_INT <= i) {
            function0.invoke();
        }
    }

    public static final void doFromSdk(int i, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (Build.VERSION.SDK_INT >= i) {
            function0.invoke();
        }
    }

    public static final void doIfSdk(int i, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (Build.VERSION.SDK_INT == i) {
            function0.invoke();
        }
    }

    public static final <T> AttemptResult<T> attempt(Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Object obj = null;
        Throwable th = null;
        try {
            obj = function0.invoke();
        } catch (Throwable th2) {
            th = th2;
        }
        return new AttemptResult<>(obj, th);
    }
}
