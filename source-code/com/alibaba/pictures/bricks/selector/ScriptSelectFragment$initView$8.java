package com.alibaba.pictures.bricks.selector;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptSelectFragment$initView$8 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment a;

    ScriptSelectFragment$initView$8(ScriptSelectFragment scriptSelectFragment) {
        this.a = scriptSelectFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789870852")) {
            ipChange.ipc$dispatch("-789870852", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        this.a.hideSoftInput();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317089187")) {
            ipChange.ipc$dispatch("317089187", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
    }
}
