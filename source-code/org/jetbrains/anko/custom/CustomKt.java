package org.jetbrains.anko.custom;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewManager;
import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a`\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u000f\u001a`\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00062!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0010\u001a`\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00112!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0012\u001aA\u0010\u0013\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0014\u001aA\u0010\u0013\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0015\u001aA\u0010\u0013\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"ankoView", "T", "Landroid/view/View;", "Landroid/app/Activity;", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "ctx", "theme", "", "init", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "Landroid/view/ViewManager;", "(Landroid/view/ViewManager;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "customView", "(Landroid/app/Activity;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/view/ViewManager;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Custom.kt */
public final class CustomKt {
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T ankoView(ViewManager viewManager, Function1<? super Context, ? extends T> function1, int i, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        View view = (View) function1.invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function12.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T ankoView(Context context, Function1<? super Context, ? extends T> function1, int i, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        View view = (View) function1.invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function12.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T ankoView(Activity activity, Function1<? super Context, ? extends T> function1, int i, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        View view = (View) function1.invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function12.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    private static final <T extends View> T customView(ViewManager viewManager, int i, Function1<? super T, Unit> function1) {
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(viewManager, initiateView);
        return initiateView;
    }

    static /* bridge */ /* synthetic */ View customView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(viewManager, initiateView);
        return initiateView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    private static final <T extends View> T customView(Context context, int i, Function1<? super T, Unit> function1) {
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(context, initiateView);
        return initiateView;
    }

    static /* bridge */ /* synthetic */ View customView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(context, initiateView);
        return initiateView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    private static final <T extends View> T customView(Activity activity, int i, Function1<? super T, Unit> function1) {
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(activity, initiateView);
        return initiateView;
    }

    static /* bridge */ /* synthetic */ View customView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i);
        Intrinsics.reifiedOperationMarker(4, "T");
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(activity, initiateView);
        return initiateView;
    }
}
