package org.jetbrains.anko.support.v4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u0006H\b¢\u0006\u0002\u0010\bJ0\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\b¢\u0006\u0002\u0010\fJI\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0012J5\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0002H\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lorg/jetbrains/anko/support/v4/_ViewPager;", "Landroidx/viewpager/widget/ViewPager;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lparams", "T", "Landroid/view/View;", "(Landroid/view/View;)Landroid/view/View;", "context", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "init", "Lkotlin/Function1;", "Landroidx/viewpager/widget/ViewPager$LayoutParams;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "anko-support-v4_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Layouts.kt */
public class _ViewPager extends ViewPager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public _ViewPager(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
    }

    public final <T extends View> T lparams(T t, Function1<? super ViewPager.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    public final <T extends View> T lparams(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        t.setLayoutParams(new ViewPager.LayoutParams());
        return t;
    }

    public final <T extends View> T lparams(T t, Context context, AttributeSet attributeSet, Function1<? super ViewPager.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams(context, attributeSet);
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
        t.setLayoutParams(new ViewPager.LayoutParams(context, attributeSet));
        return t;
    }
}
