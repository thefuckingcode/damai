package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.bricks.component.script.ScriptInfoContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptInfoView extends AbsView<GenericItem<ItemValue>, ScriptInfoModel, ScriptInfoPresent> implements ScriptInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private View itemView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptInfoView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
    }

    @Override // com.alibaba.pictures.bricks.component.script.ScriptInfoContract.View
    @NotNull
    public ViewGroup getHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809591785")) {
            return (ViewGroup) ipChange.ipc$dispatch("-809591785", new Object[]{this});
        }
        View view = this.itemView;
        k21.g(view, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) view;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1398509205")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1398509205", new Object[]{this});
    }

    public final void setItemView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137170709")) {
            ipChange.ipc$dispatch("-2137170709", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.itemView = view;
    }
}
