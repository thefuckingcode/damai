package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001ay\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b0\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2 \b\b\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH\b\u001ar\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b0\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f\u001a}\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00112$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b0\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2 \b\b\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH\b¨\u0006\u0012"}, d2 = {"selector", "", "D", "Landroid/content/DialogInterface;", "Landroid/app/Fragment;", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lorg/jetbrains/anko/AlertBuilder;", "Lorg/jetbrains/anko/AlertBuilderFactory;", "title", "", "items", "", "onClick", "Lkotlin/Function3;", "", "Lorg/jetbrains/anko/AnkoContext;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Selectors.kt */
public final class SelectorsKt {
    public static /* bridge */ /* synthetic */ void selector$default(AnkoContext ankoContext, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        selector(ankoContext.getCtx(), function1, charSequence, list, function3);
    }

    public static final <D extends DialogInterface> void selector(AnkoContext<?> ankoContext, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, CharSequence charSequence, List<? extends CharSequence> list, Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        selector(ankoContext.getCtx(), function1, charSequence, list, function3);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ void selector$default(Fragment fragment, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        selector(activity, function1, charSequence, list, function3);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <D extends DialogInterface> void selector(Fragment fragment, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, CharSequence charSequence, List<? extends CharSequence> list, Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        selector(activity, function1, charSequence, list, function3);
    }

    public static /* bridge */ /* synthetic */ void selector$default(Context context, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        selector(context, function1, charSequence, list, function3);
    }

    public static final <D extends DialogInterface> void selector(Context context, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, CharSequence charSequence, List<? extends CharSequence> list, Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        AlertBuilder alertBuilder = (AlertBuilder) function1.invoke(context);
        if (charSequence != null) {
            alertBuilder.setTitle(charSequence);
        }
        alertBuilder.items(list, function3);
        alertBuilder.show();
    }
}
