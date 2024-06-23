package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2!\b\n\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u000f\u001az\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\t\u001a\u00020\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00102!\b\n\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000eH\b\u001ad\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u001f\b\b\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\b\u000eH\b\u001az\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2!\b\u0002\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0013\u001au\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\t\u001a\u00020\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00102!\b\u0002\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000e\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\b\u000e\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00142$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2!\b\n\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u0015\u001a~\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00142$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u0006\u0010\t\u001a\u00020\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00102!\b\n\u0010\f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\b\u000eH\b\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00142$\b\b\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\b2\u001f\b\b\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\b\u000eH\b*4\u0010\u0016\u001a\u0004\b\u0000\u0010\u0002\"\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u00062\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006¨\u0006\u0017"}, d2 = {"alert", "Lorg/jetbrains/anko/AlertBuilder;", "D", "Landroid/content/DialogInterface;", "Landroid/app/Fragment;", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lorg/jetbrains/anko/AlertBuilderFactory;", "message", "", "title", "init", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/app/Fragment;Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "", "messageResource", "titleResource", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "Lorg/jetbrains/anko/AnkoContext;", "(Lorg/jetbrains/anko/AnkoContext;Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "AlertBuilderFactory", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Dialogs.kt */
public final class DialogsKt {
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, "message");
        return alert(ankoContext.getCtx(), function1, str, str2, function12);
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(AnkoContext<?> ankoContext, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, String str, String str2, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, "message");
        return alert(ankoContext.getCtx(), function1, str, str2, function12);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1, str, str2, function12);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <D extends DialogInterface> AlertBuilder<D> alert(Fragment fragment, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, String str, String str2, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1, str, str2, function12);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Context context, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        return alert(context, function1, str, str2, function12);
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(Context context, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, String str, String str2, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, "message");
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        if (str2 != null) {
            alertBuilder.setTitle(str2);
        }
        alertBuilder.setMessage(str);
        if (function12 != null) {
            function12.invoke(alertBuilder);
        }
        return alertBuilder;
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        return alert(ankoContext.getCtx(), function1, i, num, function12);
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(AnkoContext<?> ankoContext, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, Integer num, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        return alert(ankoContext.getCtx(), function1, i, num, function12);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1, i, num, function12);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <D extends DialogInterface> AlertBuilder<D> alert(Fragment fragment, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, Integer num, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1, i, num, function12);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Context context, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        return alert(context, function1, i, num, function12);
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(Context context, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, Integer num, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        if (num != null) {
            alertBuilder.setTitleResource(num.intValue());
        }
        alertBuilder.setMessageResource(i);
        if (function12 != null) {
            function12.invoke(alertBuilder);
        }
        return alertBuilder;
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(AnkoContext<?> ankoContext, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        return alert(ankoContext.getCtx(), function1, function12);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final <D extends DialogInterface> AlertBuilder<D> alert(Fragment fragment, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1, function12);
    }

    public static final <D extends DialogInterface> AlertBuilder<D> alert(Context context, Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        function12.invoke(alertBuilder);
        return alertBuilder;
    }
}
