package com.alibaba.pictures.bricks.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptDetailFragment$setDefaultHeaderBg$1 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptDetailFragment a;

    ScriptDetailFragment$setDefaultHeaderBg$1(ScriptDetailFragment scriptDetailFragment) {
        this.a = scriptDetailFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654749714")) {
            ipChange.ipc$dispatch("654749714", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        View realView = this.a.getRealView();
        TextView textView = null;
        FrameLayout frameLayout = realView != null ? (FrameLayout) realView.findViewById(R$id.scriptkill_top_gaussimg_cover) : null;
        if (frameLayout != null) {
            frameLayout.setTranslationY((float) (-computeVerticalScrollOffset));
        }
        if (computeVerticalScrollOffset == 0) {
            this.a.getMAppNavbar().setBackgroundColor(this.a.getResources().getColor(R$color.transparent));
            View realView2 = this.a.getRealView();
            if (realView2 != null) {
                textView = (TextView) realView2.findViewById(R$id.title_navbar_title);
            }
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        this.a.getMAppNavbar().setBackgroundColor(Color.parseColor("#211616"));
        View realView3 = this.a.getRealView();
        if (realView3 != null) {
            textView = (TextView) realView3.findViewById(R$id.title_navbar_title);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
