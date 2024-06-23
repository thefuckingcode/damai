package org.jetbrains.anko.support.v4;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: Listeners.kt */
public final class SupportV4ListenersKt$sam$i$android_support_v4_view_ViewPager_OnAdapterChangeListener$0 implements ViewPager.OnAdapterChangeListener {
    private final /* synthetic */ Function3 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_view_ViewPager_OnAdapterChangeListener$0(Function3 function3) {
        this.function = function3;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public final /* synthetic */ void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        Intrinsics.checkParameterIsNotNull(viewPager, "p0");
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(viewPager, pagerAdapter, pagerAdapter2), "invoke(...)");
    }
}
