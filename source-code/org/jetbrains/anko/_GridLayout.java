package org.jetbrains.anko;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u0006H\b¢\u0006\u0002\u0010\bJ0\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\b¢\u0006\u0002\u0010\fJI\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0012J&\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\b¢\u0006\u0002\u0010\u0015J?\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0016J&\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\b¢\u0006\u0002\u0010\u0018J?\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00172\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0019J5\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u001aJ&\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\b¢\u0006\u0002\u0010\u001cJ?\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u001dJ0\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\b¢\u0006\u0002\u0010!JI\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lorg/jetbrains/anko/_GridLayout;", "Landroid/widget/GridLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lparams", "T", "Landroid/view/View;", "(Landroid/view/View;)Landroid/view/View;", "context", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "init", "Lkotlin/Function1;", "Landroid/widget/GridLayout$LayoutParams;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/View;Landroid/view/ViewGroup$MarginLayoutParams;)Landroid/view/View;", "(Landroid/view/View;Landroid/view/ViewGroup$MarginLayoutParams;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "source", "(Landroid/view/View;Landroid/widget/GridLayout$LayoutParams;)Landroid/view/View;", "(Landroid/view/View;Landroid/widget/GridLayout$LayoutParams;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "rowSpec", "Landroid/widget/GridLayout$Spec;", "columnSpec", "(Landroid/view/View;Landroid/widget/GridLayout$Spec;Landroid/widget/GridLayout$Spec;)Landroid/view/View;", "(Landroid/view/View;Landroid/widget/GridLayout$Spec;Landroid/widget/GridLayout$Spec;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "anko-sdk27_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Layouts.kt */
public class _GridLayout extends GridLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public _GridLayout(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
    }

    public final <T extends View> T lparams(T t, GridLayout.Spec spec, GridLayout.Spec spec2, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (spec == null) {
            Intrinsics.throwNpe();
        }
        if (spec2 == null) {
            Intrinsics.throwNpe();
        }
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(spec, spec2);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public final <T extends View> T lparams(T t, GridLayout.Spec spec, GridLayout.Spec spec2) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (spec == null) {
            Intrinsics.throwNpe();
        }
        if (spec2 == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new GridLayout.LayoutParams(spec, spec2));
        return t;
    }

    public final <T extends View> T lparams(T t, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public final <T extends View> T lparams(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        t.setLayoutParams(new GridLayout.LayoutParams());
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.LayoutParams layoutParams, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams(layoutParams);
        function1.invoke(layoutParams2);
        t.setLayoutParams(layoutParams2);
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new GridLayout.LayoutParams(layoutParams));
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.MarginLayoutParams marginLayoutParams, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (marginLayoutParams == null) {
            Intrinsics.throwNpe();
        }
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(marginLayoutParams);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (marginLayoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new GridLayout.LayoutParams(marginLayoutParams));
        return t;
    }

    public final <T extends View> T lparams(T t, GridLayout.LayoutParams layoutParams, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams(layoutParams);
        function1.invoke(layoutParams2);
        t.setLayoutParams(layoutParams2);
        return t;
    }

    public final <T extends View> T lparams(T t, GridLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new GridLayout.LayoutParams(layoutParams));
        return t;
    }

    public final <T extends View> T lparams(T t, Context context, AttributeSet attributeSet, Function1<? super GridLayout.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(context, attributeSet);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public final <T extends View> T lparams(T t, Context context, AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new GridLayout.LayoutParams(context, attributeSet));
        return t;
    }
}
