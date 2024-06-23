package org.jetbrains.anko;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u000e\u001a\u00020\u000f*\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u000e\u001a\u00020\u000f*\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a$\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0014\u001aB\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u0007H\u0011¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0015\u001a$\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0016\u001aB\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u0007H\u0011¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u0017\u001a$\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0019\u001aB\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u0007H\u0011¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u001a\u001a$\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u001b\u001aB\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u0007H\u0011¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b¢\u0006\u0002\u0010\u001c\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u001d\u001a\u00020\u001e*\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a5\u0010\u001d\u001a\u00020\u001e*\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\b¨\u0006 "}, d2 = {"editText", "Landroid/widget/EditText;", "Landroid/app/Activity;", "constraints", "Lorg/jetbrains/anko/InputConstraints;", "theme", "", "init", "Lkotlin/Function1;", "Lorg/jetbrains/anko/AnkoViewDslMarker;", "", "Lkotlin/ExtensionFunctionType;", "Landroid/content/Context;", "Landroid/view/ViewManager;", "horizontalProgressBar", "Landroid/widget/ProgressBar;", "include", "T", "Landroid/view/View;", "layoutId", "(Landroid/app/Activity;I)Landroid/view/View;", "(Landroid/app/Activity;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/content/Context;I)Landroid/view/View;", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/view/ViewManager;I)Landroid/view/View;", "(Landroid/view/ViewManager;ILkotlin/jvm/functions/Function1;)Landroid/view/View;", "verticalLayout", "Landroid/widget/LinearLayout;", "Lorg/jetbrains/anko/_LinearLayout;", "platform-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: CustomViews.kt */
public final class CustomViewsKt {
    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static final LinearLayout verticalLayout(ViewManager viewManager, int i, Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static final LinearLayout verticalLayout(Context context, int i, Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ LinearLayout verticalLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    public static final LinearLayout verticalLayout(Activity activity, int i, Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(ViewManager viewManager, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(ViewManager viewManager, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final EditText editText(ViewManager viewManager, InputConstraints inputConstraints, int i, Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(Context context, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(context, invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(Context context, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final EditText editText(Context context, InputConstraints inputConstraints, int i, Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(Activity activity, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ EditText editText$default(Activity activity, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final EditText editText(Activity activity, InputConstraints inputConstraints, int i, Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        EditText editText = invoke;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return progressBar;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static final ProgressBar horizontalProgressBar(ViewManager viewManager, int i, Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(context, invoke);
        return progressBar;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static final ProgressBar horizontalProgressBar(Context context, int i, Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return progressBar;
    }

    public static /* bridge */ /* synthetic */ ProgressBar horizontalProgressBar$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    public static final ProgressBar horizontalProgressBar(Activity activity, int i, Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(invoke);
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T include(ViewGroup viewGroup, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ViewGroup viewGroup2 = viewGroup;
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewGroup2), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(i, viewGroup, false);
            if (inflate != 0) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(viewGroup2, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public static final LinearLayout verticalLayout(ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return invoke;
    }

    public static final LinearLayout verticalLayout(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        AnkoInternals.INSTANCE.addView(context, invoke);
        return invoke;
    }

    public static final LinearLayout verticalLayout(Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        _LinearLayout invoke = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return invoke;
    }

    public static final EditText editText(ViewManager viewManager, InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final EditText editText(Context context, InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(context, invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final EditText editText(Activity activity, InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        EditText invoke = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        EditText editText = invoke;
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    public static final ProgressBar horizontalProgressBar(ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(viewManager, invoke);
        return progressBar;
    }

    public static final ProgressBar horizontalProgressBar(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(context, invoke);
        return progressBar;
    }

    public static final ProgressBar horizontalProgressBar(Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        ProgressBar invoke = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ProgressBar progressBar = invoke;
        AnkoInternals.INSTANCE.addView(activity, (View) invoke);
        return progressBar;
    }

    public static final <T extends View> T include(ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T t = (T) ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (t != null) {
                AnkoInternals.INSTANCE.addView(viewManager, t);
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T include(ViewManager viewManager, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewManager), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (inflate != 0) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(viewManager, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public static final <T extends View> T include(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        ViewGroup viewGroup2 = viewGroup;
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(AnkoInternals.INSTANCE.getContext(viewGroup2), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T t = (T) ((LayoutInflater) systemService).inflate(i, viewGroup, false);
            if (t != null) {
                AnkoInternals.INSTANCE.addView(viewGroup2, t);
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public static final <T extends View> T include(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T t = (T) ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (t != null) {
                AnkoInternals.INSTANCE.addView(context, t);
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T include(Context context, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (inflate != 0) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(context, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public static final <T extends View> T include(Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T t = (T) ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (t != null) {
                AnkoInternals.INSTANCE.addView(activity, (View) t);
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: org.jetbrains.anko.internals.AnkoInternals */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T extends android.view.View, android.view.View, java.lang.Object] */
    public static final <T extends View> T include(Activity activity, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            if (inflate != 0) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(activity, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
