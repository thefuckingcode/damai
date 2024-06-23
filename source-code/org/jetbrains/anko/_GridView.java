package org.jetbrains.anko;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0002\u0010\u000bJI\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u0011J&\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\b¢\u0006\u0002\u0010\u0014J?\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u0015J0\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\b¢\u0006\u0002\u0010\u0019JI\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001aJ8\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\b¢\u0006\u0002\u0010\u001cJQ\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lorg/jetbrains/anko/_GridView;", "Landroid/widget/GridView;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lparams", "T", "Landroid/view/View;", "c", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "init", "Lkotlin/Function1;", "Landroid/widget/AbsListView$LayoutParams;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)Landroid/view/View;", "(Landroid/view/View;IILkotlin/jvm/functions/Function1;)Landroid/view/View;", "viewType", "(Landroid/view/View;III)Landroid/view/View;", "(Landroid/view/View;IIILkotlin/jvm/functions/Function1;)Landroid/view/View;", "anko-sdk27_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Layouts.kt */
public class _GridView extends GridView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public _GridView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
    }

    public final <T extends View> T lparams(T t, Context context, AttributeSet attributeSet, Function1<? super AbsListView.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(context, attributeSet);
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
        t.setLayoutParams(new AbsListView.LayoutParams(context, attributeSet));
        return t;
    }

    public static /* bridge */ /* synthetic */ View lparams$default(_GridView _gridview, View view, int i, int i2, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = -2;
            }
            if ((i3 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "$receiver");
            Intrinsics.checkParameterIsNotNull(function1, "init");
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(i, i2);
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    public final <T extends View> T lparams(T t, int i, int i2, Function1<? super AbsListView.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(i, i2);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public static /* bridge */ /* synthetic */ View lparams$default(_GridView _gridview, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = -2;
            }
            if ((i3 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "$receiver");
            view.setLayoutParams(new AbsListView.LayoutParams(i, i2));
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    public final <T extends View> T lparams(T t, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        t.setLayoutParams(new AbsListView.LayoutParams(i, i2));
        return t;
    }

    public static /* bridge */ /* synthetic */ View lparams$default(_GridView _gridview, View view, int i, int i2, int i3, Function1 function1, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i = -2;
            }
            if ((i4 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "$receiver");
            Intrinsics.checkParameterIsNotNull(function1, "init");
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(i, i2, i3);
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    public final <T extends View> T lparams(T t, int i, int i2, int i3, Function1<? super AbsListView.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(i, i2, i3);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public static /* bridge */ /* synthetic */ View lparams$default(_GridView _gridview, View view, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i = -2;
            }
            if ((i4 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "$receiver");
            view.setLayoutParams(new AbsListView.LayoutParams(i, i2, i3));
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    public final <T extends View> T lparams(T t, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        t.setLayoutParams(new AbsListView.LayoutParams(i, i2, i3));
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.LayoutParams layoutParams, Function1<? super AbsListView.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        AbsListView.LayoutParams layoutParams2 = new AbsListView.LayoutParams(layoutParams);
        function1.invoke(layoutParams2);
        t.setLayoutParams(layoutParams2);
        return t;
    }

    public final <T extends View> T lparams(T t, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new AbsListView.LayoutParams(layoutParams));
        return t;
    }
}
