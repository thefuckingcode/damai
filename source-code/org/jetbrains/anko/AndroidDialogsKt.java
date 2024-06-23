package org.jetbrains.anko;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aO\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\r\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00032\u001f\b\b\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052!\b\u0002\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b\u001aL\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2!\b\u0002\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\u0011\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u000e2\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aS\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0004\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0013\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u0006\u0012\u0002\b\u00030\u00122\u001f\b\b\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001aB\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aG\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0016\u001aA\u0010\u0014\u001a\u00020\u0015*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0007\u001aF\u0010\u0014\u001a\u00020\u0015*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0017\u001aF\u0010\u0014\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aK\u0010\u0014\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0018\u001aB\u0010\u0019\u001a\u00020\u0015*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aG\u0010\u0019\u001a\u00020\u0015*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0016\u001aI\u0010\u0019\u001a\u00020\u0015*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0003\u001aA\u0010\u0019\u001a\u00020\u0015*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0007\u001aF\u0010\u0019\u001a\u00020\u0015*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0017\u001aF\u0010\u0019\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b\u001aK\u0010\u0019\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\f2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0018¨\u0006\u001c"}, d2 = {"alert", "Lorg/jetbrains/anko/AlertBuilder;", "Landroid/app/AlertDialog;", "Landroid/app/Fragment;", "message", "", "title", "init", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "", "Lkotlin/ExtensionFunctionType;", "", "(Landroid/app/Fragment;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "Landroid/content/Context;", "messageResource", "titleResource", "(Landroid/content/Context;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "Lorg/jetbrains/anko/AnkoContext;", "(Lorg/jetbrains/anko/AnkoContext;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "indeterminateProgressDialog", "Landroid/app/ProgressDialog;", "(Landroid/app/Fragment;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/app/ProgressDialog;", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/app/ProgressDialog;", "(Lorg/jetbrains/anko/AnkoContext;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/app/ProgressDialog;", "progressDialog", "indeterminate", "", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: AndroidDialogs.kt */
public final class AndroidDialogsKt {
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        return alert(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    public static final AlertBuilder<AlertDialog> alert(AnkoContext<?> ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        return alert(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final AlertBuilder<AlertDialog> alert(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, charSequence, charSequence2, function1);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return alert(context, charSequence, charSequence2, function1);
    }

    public static final AlertBuilder<AlertDialog> alert(Context context, CharSequence charSequence, CharSequence charSequence2, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        if (charSequence2 != null) {
            androidAlertBuilder.setTitle(charSequence2);
        }
        androidAlertBuilder.setMessage(charSequence);
        if (function1 != null) {
            function1.invoke(androidAlertBuilder);
        }
        return androidAlertBuilder;
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return alert(ankoContext.getCtx(), i, num, function1);
    }

    public static final AlertBuilder<DialogInterface> alert(AnkoContext<?> ankoContext, int i, Integer num, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return alert(ankoContext.getCtx(), i, num, function1);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, i, num, function1);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final AlertBuilder<DialogInterface> alert(Fragment fragment, int i, Integer num, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, i, num, function1);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Context context, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return alert(context, i, num, function1);
    }

    public static final AlertBuilder<DialogInterface> alert(Context context, int i, Integer num, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        if (num != null) {
            androidAlertBuilder.setTitleResource(num.intValue());
        }
        androidAlertBuilder.setMessageResource(i);
        if (function1 != null) {
            function1.invoke(androidAlertBuilder);
        }
        return androidAlertBuilder;
    }

    public static final AlertBuilder<DialogInterface> alert(AnkoContext<?> ankoContext, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        return alert(ankoContext.getCtx(), function1);
    }

    public static final AlertBuilder<DialogInterface> alert(Fragment fragment, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert(activity, function1);
    }

    public static final AlertBuilder<DialogInterface> alert(Context context, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        function1.invoke(androidAlertBuilder);
        return androidAlertBuilder;
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(AnkoContext ankoContext, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return progressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(AnkoContext<?> ankoContext, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return progressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog(activity, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Fragment fragment, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog(activity, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Context context, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return progressDialog(context, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Context context, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        String str = null;
        String string = num != null ? context.getString(num.intValue()) : null;
        if (num2 != null) {
            str = context.getString(num2.intValue());
        }
        return progressDialog(context, false, string, str, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(AnkoContext ankoContext, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return indeterminateProgressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(AnkoContext<?> ankoContext, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return indeterminateProgressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog(activity, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Fragment fragment, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog(activity, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Context context, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return indeterminateProgressDialog(context, num, num2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Context context, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        String str = null;
        String string = num != null ? context.getString(num.intValue()) : null;
        if (num2 != null) {
            str = context.getString(num2.intValue());
        }
        return progressDialog(context, true, string, str, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return progressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(AnkoContext<?> ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return progressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog(activity, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog(activity, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return progressDialog(context, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Context context, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return progressDialog(context, false, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return indeterminateProgressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(AnkoContext<?> ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return indeterminateProgressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog(activity, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog(activity, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return indeterminateProgressDialog(context, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Context context, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return progressDialog(context, true, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Context context, boolean z, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        return progressDialog(context, z, charSequence, charSequence2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    private static final ProgressDialog progressDialog(Context context, boolean z, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(z);
        if (!z) {
            progressDialog.setProgressStyle(1);
        }
        if (charSequence != null) {
            progressDialog.setMessage(charSequence);
        }
        if (charSequence2 != null) {
            progressDialog.setTitle(charSequence2);
        }
        if (function1 != null) {
            function1.invoke(progressDialog);
        }
        progressDialog.show();
        return progressDialog;
    }
}
