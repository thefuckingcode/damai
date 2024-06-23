package org.jetbrains.anko.support.v4;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.anko.AndroidDialogsKt;
import org.jetbrains.anko.AndroidSelectorsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b¢\u0006\u0002\u0010\u000b\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r2!\b\n\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u001f\b\b\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\b\u001aG\u0010\u000e\u001a\u00020\u000f*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b¢\u0006\u0002\u0010\u0010\u001aB\u0010\u000e\u001a\u00020\u000f*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\b\u001aG\u0010\u0016\u001a\u00020\u000f*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0016\u001a\u00020\u000f*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r2\u001b\b\n\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\b\u001aC\u0010\u0017\u001a\u00020\t*\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\u001a\b\b\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u001bH\b\u001a\u0015\u0010\u001c\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\b¨\u0006\u001d"}, d2 = {"alert", "Lorg/jetbrains/anko/AlertBuilder;", "Landroid/content/DialogInterface;", "Landroidx/fragment/app/Fragment;", "message", "", "title", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/support/v4/app/Fragment;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lorg/jetbrains/anko/AlertBuilder;", "Landroid/app/AlertDialog;", "", "indeterminateProgressDialog", "Landroid/app/ProgressDialog;", "(Landroid/support/v4/app/Fragment;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/app/ProgressDialog;", "longToast", "Landroid/widget/Toast;", "text", "", "textResource", "progressDialog", "selector", "items", "", "onClick", "Lkotlin/Function2;", "toast", "supportV4-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SupportDialogs.kt */
public final class SupportDialogsKt {
    public static final Toast toast(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, i, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    public static final Toast toast(Fragment fragment, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, charSequence, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    public static final Toast longToast(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, i, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    public static final Toast longToast(Fragment fragment, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, charSequence, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    public static /* bridge */ /* synthetic */ void selector$default(Fragment fragment, CharSequence charSequence, List list, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onClick");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidSelectorsKt.selector(requireActivity, charSequence, list, function2);
    }

    public static final void selector(Fragment fragment, CharSequence charSequence, List<? extends CharSequence> list, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onClick");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidSelectorsKt.selector(requireActivity, charSequence, list, function2);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "message");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert(requireActivity, str, str2, function1);
    }

    public static final AlertBuilder<AlertDialog> alert(Fragment fragment, String str, String str2, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "message");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert(requireActivity, str, str2, function1);
    }

    public static /* bridge */ /* synthetic */ AlertBuilder alert$default(Fragment fragment, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert(requireActivity, i, num, function1);
    }

    public static final AlertBuilder<DialogInterface> alert(Fragment fragment, int i, Integer num, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert(requireActivity, i, num, function1);
    }

    public static final AlertBuilder<DialogInterface> alert(Fragment fragment, Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert(requireActivity, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.progressDialog(requireActivity, str, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Fragment fragment, String str, String str2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.progressDialog(requireActivity, str, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.indeterminateProgressDialog(requireActivity, str, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Fragment fragment, String str, String str2, Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.indeterminateProgressDialog(requireActivity, str, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        String str;
        String str2 = null;
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
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        if (num != null) {
            str = fragment.requireActivity().getString(num.intValue());
        } else {
            str = null;
        }
        String str3 = str;
        if (num2 != null) {
            str2 = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.progressDialog(fragmentActivity, str3, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog progressDialog(Fragment fragment, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        String str;
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        String str2 = null;
        if (num != null) {
            str = fragment.requireActivity().getString(num.intValue());
        } else {
            str = null;
        }
        String str3 = str;
        if (num2 != null) {
            str2 = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.progressDialog(fragmentActivity, str3, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static /* bridge */ /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        String str;
        String str2 = null;
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
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        if (num != null) {
            str = fragment.requireActivity().getString(num.intValue());
        } else {
            str = null;
        }
        String str3 = str;
        if (num2 != null) {
            str2 = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.indeterminateProgressDialog(fragmentActivity, str3, str2, function1);
    }

    @Deprecated(message = "Android progress dialogs are deprecated")
    public static final ProgressDialog indeterminateProgressDialog(Fragment fragment, Integer num, Integer num2, Function1<? super ProgressDialog, Unit> function1) {
        String str;
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        String str2 = null;
        if (num != null) {
            str = fragment.requireActivity().getString(num.intValue());
        } else {
            str = null;
        }
        String str3 = str;
        if (num2 != null) {
            str2 = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.indeterminateProgressDialog(fragmentActivity, str3, str2, function1);
    }
}
