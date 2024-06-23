package org.jetbrains.anko;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewManager;
import android.widget.ListAdapter;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Deprecated(message = "Use AlertBuilder class instead.")
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J9\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001aJ1\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u001f2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001aJ!\u0010 \u001a\u00020\u00142\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u0014H\u0002J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(J\u001f\u0010&\u001a\u00020\u00142\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(J\u001f\u0010+\u001a\u00020\u00142\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u001bJ<\u0010/\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\u00102J1\u0010/\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u001b2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001aJ7\u0010/\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u000201042!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001aJ\u000e\u00105\u001a\u00020\u00142\u0006\u00105\u001a\u000201J\u000e\u00105\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u001bJ)\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002012\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J)\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u001b2\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J)\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u0002012\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J+\u00108\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u001b2\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J!\u0010:\u001a\u00020\u00142\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u001f\u0010;\u001a\u00020\u00142\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u0014\u0010<\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140=J>\u0010>\u001a\u00020\u001426\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110A¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0?J'\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u0002012\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J'\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u001b2\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"J\u0006\u0010E\u001a\u00020\u0000J\u000e\u0010F\u001a\u00020\u00142\u0006\u0010F\u001a\u000201J\u000e\u0010F\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u001bJ\u001f\u0010G\u001a\u00020\u00142\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\"R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006H"}, d2 = {"Lorg/jetbrains/anko/AlertDialogBuilder;", "", "ankoContext", "Lorg/jetbrains/anko/AnkoContext;", "(Lorg/jetbrains/anko/AnkoContext;)V", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "builder", "Landroid/app/AlertDialog$Builder;", "getCtx", "()Landroid/content/Context;", "<set-?>", "Landroid/app/AlertDialog;", "dialog", "getDialog", "()Landroid/app/AlertDialog;", "setDialog", "(Landroid/app/AlertDialog;)V", "adapter", "", "cursor", "Landroid/database/Cursor;", "labelColumn", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "which", "Landroid/widget/ListAdapter;", "cancelButton", "Landroid/content/DialogInterface;", "Lkotlin/ExtensionFunctionType;", "cancellable", "", "checkBuilder", "customTitle", "view", "Landroid/view/View;", "dsl", "Landroid/view/ViewManager;", "customView", "dismiss", "icon", "Landroid/graphics/drawable/Drawable;", "items", "", "", "([Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "itemsId", "", "message", "negativeButton", "negativeText", "neutralButton", "neutralText", "noButton", "okButton", "onCancel", "Lkotlin/Function0;", "onKey", "Lkotlin/Function2;", "keyCode", "Landroid/view/KeyEvent;", "e", "positiveButton", "positiveText", "show", "title", "yesButton", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: AlertDialogBuilder.kt */
public final class AlertDialogBuilder {
    private AlertDialog.Builder builder;
    private final Context ctx;
    private AlertDialog dialog;

    public AlertDialogBuilder(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
        this.builder = new AlertDialog.Builder(context);
    }

    public final Context getCtx() {
        return this.ctx;
    }

    private final void setDialog(AlertDialog alertDialog) {
        this.dialog = alertDialog;
    }

    public final AlertDialog getDialog() {
        return this.dialog;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AlertDialogBuilder(AnkoContext<?> ankoContext) {
        this(ankoContext.getCtx());
        Intrinsics.checkParameterIsNotNull(ankoContext, "ankoContext");
    }

    public final void dismiss() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void checkBuilder() {
        if (this.builder == null) {
            throw new IllegalStateException("show() was already called for this AlertDialogBuilder");
        }
    }

    public final AlertDialogBuilder show() {
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        AlertDialog create = builder2.create();
        this.dialog = create;
        this.builder = null;
        if (create == null) {
            Intrinsics.throwNpe();
        }
        create.show();
        return this;
    }

    public final void title(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "title");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setTitle(charSequence);
    }

    public final void title(int i) {
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setTitle(i);
    }

    public final void message(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "message");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setMessage(charSequence);
    }

    public final void message(int i) {
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setMessage(i);
    }

    public final void icon(int i) {
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setIcon(i);
    }

    public final void icon(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "icon");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setIcon(drawable);
    }

    public final void customTitle(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCustomTitle(view);
    }

    public final void customTitle(Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        checkBuilder();
        Context context = this.ctx;
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        View view = ankoContextImpl.getView();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCustomTitle(view);
    }

    public final void customView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setView(view);
    }

    public final void customView(Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        checkBuilder();
        Context context = this.ctx;
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        View view = ankoContextImpl.getView();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setView(view);
    }

    public static /* bridge */ /* synthetic */ void cancellable$default(AlertDialogBuilder alertDialogBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        alertDialogBuilder.cancellable(z);
    }

    public final void cancellable(boolean z) {
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCancelable(z);
    }

    public final void onCancel(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setOnCancelListener(new AlertDialogBuilder$onCancel$1(function0));
    }

    public final void onKey(Function2<? super Integer, ? super KeyEvent, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setOnKeyListener(new AlertDialogBuilder$onKey$1(function2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void neutralButton$default(AlertDialogBuilder alertDialogBuilder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 17039370;
        }
        if ((i2 & 2) != 0) {
            function1 = AlertDialogBuilder$neutralButton$1.INSTANCE;
        }
        alertDialogBuilder.neutralButton(i, function1);
    }

    public final void neutralButton(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(neutralText)");
        neutralButton(string, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void neutralButton$default(AlertDialogBuilder alertDialogBuilder, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AlertDialogBuilder$neutralButton$2.INSTANCE;
        }
        alertDialogBuilder.neutralButton(charSequence, function1);
    }

    public final void neutralButton(CharSequence charSequence, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "neutralText");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setNeutralButton(charSequence, new AlertDialogBuilder$neutralButton$3(function1));
    }

    public final void positiveButton(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(positiveText)");
        positiveButton(string, function1);
    }

    public final void okButton(Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(17039370);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.ok)");
        positiveButton(string, function1);
    }

    public final void yesButton(Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(17039379);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.yes)");
        positiveButton(string, function1);
    }

    public final void positiveButton(CharSequence charSequence, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "positiveText");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setPositiveButton(charSequence, new AlertDialogBuilder$positiveButton$1(function1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void negativeButton$default(AlertDialogBuilder alertDialogBuilder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = AlertDialogBuilder$negativeButton$1.INSTANCE;
        }
        alertDialogBuilder.negativeButton(i, function1);
    }

    public final void negativeButton(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(negativeText)");
        negativeButton(string, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void cancelButton$default(AlertDialogBuilder alertDialogBuilder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlertDialogBuilder$cancelButton$1.INSTANCE;
        }
        alertDialogBuilder.cancelButton(function1);
    }

    public final void cancelButton(Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(17039360);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.cancel)");
        negativeButton(string, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void noButton$default(AlertDialogBuilder alertDialogBuilder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlertDialogBuilder$noButton$1.INSTANCE;
        }
        alertDialogBuilder.noButton(function1);
    }

    public final void noButton(Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        String string = this.ctx.getString(17039369);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.no)");
        negativeButton(string, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.jetbrains.anko.AlertDialogBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void negativeButton$default(AlertDialogBuilder alertDialogBuilder, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AlertDialogBuilder$negativeButton$2.INSTANCE;
        }
        alertDialogBuilder.negativeButton(charSequence, function1);
    }

    public final void negativeButton(CharSequence charSequence, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "negativeText");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setNegativeButton(charSequence, new AlertDialogBuilder$negativeButton$3(function1));
    }

    public final void items(int i, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        Resources resources = this.ctx.getResources();
        if (resources == null) {
            Intrinsics.throwNpe();
        }
        CharSequence[] textArray = resources.getTextArray(i);
        Intrinsics.checkExpressionValueIsNotNull(textArray, "ctx.resources!!.getTextArray(itemsId)");
        items(textArray, function1);
    }

    public final void items(List<? extends CharSequence> list, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        Object[] array = list.toArray(new CharSequence[0]);
        if (array != null) {
            items((CharSequence[]) array, function1);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void items(CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequenceArr, "items");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setItems(charSequenceArr, new AlertDialogBuilder$items$1(function1));
    }

    public final void adapter(ListAdapter listAdapter, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(listAdapter, "adapter");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setAdapter(listAdapter, new AlertDialogBuilder$adapter$1(function1));
    }

    public final void adapter(Cursor cursor, String str, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(cursor, "cursor");
        Intrinsics.checkParameterIsNotNull(str, "labelColumn");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        checkBuilder();
        AlertDialog.Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCursor(cursor, new AlertDialogBuilder$adapter$2(function1), str);
    }
}
