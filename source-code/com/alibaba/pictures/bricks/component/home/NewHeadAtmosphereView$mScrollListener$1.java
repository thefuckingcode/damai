package com.alibaba.pictures.bricks.component.home;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class NewHeadAtmosphereView$mScrollListener$1 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ NewHeadAtmosphereView a;

    NewHeadAtmosphereView$mScrollListener$1(NewHeadAtmosphereView newHeadAtmosphereView) {
        this.a = newHeadAtmosphereView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901684790")) {
            ipChange.ipc$dispatch("1901684790", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        this.a.scrollChanged(recyclerView, i);
    }
}
