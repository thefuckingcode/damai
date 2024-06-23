package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u00104\u001a\u00020\u0002H\u0016Ji\u00105\u001a\u000206\"\u0004\b\u0000\u001072\f\u00105\u001a\b\u0012\u0004\u0012\u0002H7082K\u00109\u001aG\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H7¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002060:H\u0016JN\u00105\u001a\u0002062\f\u00105\u001a\b\u0012\u0004\u0012\u00020%0826\u00109\u001a2\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002060AH\u0016J3\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020\u001a2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J3\u0010B\u001a\u0002062\u0006\u0010F\u001a\u00020G2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J3\u0010H\u001a\u0002062\u0006\u0010C\u001a\u00020\u001a2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J3\u0010H\u001a\u0002062\u0006\u0010F\u001a\u00020G2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J\u001c\u0010I\u001a\u0002062\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u0002060EH\u0016JU\u0010K\u001a\u0002062K\u0010J\u001aG\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110M¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020 0:H\u0016J3\u0010O\u001a\u0002062\u0006\u0010C\u001a\u00020\u001a2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J3\u0010O\u001a\u0002062\u0006\u0010F\u001a\u00020G2!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060EH\u0016J\b\u0010P\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8W@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8W@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00148W@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8W@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8W@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\n\u001a\u00020%8W@VX\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8W@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR$\u0010.\u001a\u00020%2\u0006\u0010\n\u001a\u00020%8W@VX\u000e¢\u0006\f\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R$\u00101\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8W@VX\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001f¨\u0006Q"}, d2 = {"Lorg/jetbrains/anko/appcompat/v7/AppcompatAlertBuilder;", "Lorg/jetbrains/anko/AlertBuilder;", "Landroidx/appcompat/app/AlertDialog;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "builder", "Landroidx/appcompat/app/AlertDialog$Builder;", "getCtx", "()Landroid/content/Context;", "value", "Landroid/view/View;", "customTitle", "getCustomTitle", "()Landroid/view/View;", "setCustomTitle", "(Landroid/view/View;)V", "customView", "getCustomView", "setCustomView", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "iconResource", "getIconResource", "()I", "setIconResource", "(I)V", "", "isCancelable", "()Z", "setCancelable", "(Z)V", "", "message", "getMessage", "()Ljava/lang/CharSequence;", "setMessage", "(Ljava/lang/CharSequence;)V", "messageResource", "getMessageResource", "setMessageResource", "title", "getTitle", "setTitle", "titleResource", "getTitleResource", "setTitleResource", "build", "items", "", "T", "", "onItemSelected", "Lkotlin/Function3;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "dialog", "item", "index", "Lkotlin/Function2;", "negativeButton", "buttonTextResource", "onClicked", "Lkotlin/Function1;", "buttonText", "", "neutralPressed", "onCancelled", "handler", "onKeyPressed", "keyCode", "Landroid/view/KeyEvent;", "e", "positiveButton", "show", "appcompatV7-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SupportAlertBuilder.kt */
public final class AppcompatAlertBuilder implements AlertBuilder<AlertDialog> {
    private final AlertDialog.Builder builder = new AlertDialog.Builder(getCtx());
    private final Context ctx;

    public AppcompatAlertBuilder(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public Context getCtx() {
        return this.ctx;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public CharSequence getTitle() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setTitle(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "value");
        this.builder.setTitle(charSequence);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public int getTitleResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setTitleResource(int i) {
        this.builder.setTitle(i);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public CharSequence getMessage() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setMessage(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "value");
        this.builder.setMessage(charSequence);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public int getMessageResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setMessageResource(int i) {
        this.builder.setMessage(i);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public Drawable getIcon() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setIcon(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "value");
        this.builder.setIcon(drawable);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public int getIconResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setIconResource(int i) {
        this.builder.setIcon(i);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public View getCustomTitle() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setCustomTitle(View view) {
        Intrinsics.checkParameterIsNotNull(view, "value");
        this.builder.setCustomTitle(view);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public View getCustomView() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setCustomView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "value");
        this.builder.setView(view);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public boolean isCancelable() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void setCancelable(boolean z) {
        this.builder.setCancelable(z);
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void onCancelled(Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        this.builder.setOnCancelListener(new SupportAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void onKeyPressed(Function3<? super DialogInterface, ? super Integer, ? super KeyEvent, Boolean> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        this.builder.setOnKeyListener(new SupportAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0(function3));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void positiveButton(String str, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setPositiveButton(str, new AppcompatAlertBuilder$positiveButton$1(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void positiveButton(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setPositiveButton(i, new AppcompatAlertBuilder$positiveButton$2(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void negativeButton(String str, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNegativeButton(str, new AppcompatAlertBuilder$negativeButton$1(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void negativeButton(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNegativeButton(i, new AppcompatAlertBuilder$negativeButton$2(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void neutralPressed(String str, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNeutralButton(str, new AppcompatAlertBuilder$neutralPressed$1(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void neutralPressed(int i, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNeutralButton(i, new AppcompatAlertBuilder$neutralPressed$2(function1));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public void items(List<? extends CharSequence> list, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onItemSelected");
        AlertDialog.Builder builder2 = this.builder;
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).toString();
        }
        builder2.setItems(strArr, new AppcompatAlertBuilder$items$2(function2));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public <T> void items(List<? extends T> list, Function3<? super DialogInterface, ? super T, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onItemSelected");
        AlertDialog.Builder builder2 = this.builder;
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = String.valueOf(list.get(i));
        }
        builder2.setItems(strArr, new AppcompatAlertBuilder$items$4(function3, list));
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public AlertDialog build() {
        AlertDialog create = this.builder.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
        return create;
    }

    @Override // org.jetbrains.anko.AlertBuilder
    public AlertDialog show() {
        AlertDialog show = this.builder.show();
        Intrinsics.checkExpressionValueIsNotNull(show, "builder.show()");
        return show;
    }
}
