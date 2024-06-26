package com.alibaba.pictures.bricks.component.channel;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ProjectTipsBean;
import com.alibaba.pictures.bricks.component.channel.ProjectTipsContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class ProjectTipsView extends AbsView<GenericItem<ItemValue>, ProjectTipsModel, ProjectTipsPresent> implements ProjectTipsContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @Nullable
    private TextView nearbyTitle;
    @Nullable
    private TextView tipsTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProjectTipsView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.tipsTitle = (TextView) view.findViewById(R$id.bricks_component_project_tips);
        this.nearbyTitle = (TextView) view.findViewById(R$id.bricks_component_project_nearby_title);
    }

    @Override // com.alibaba.pictures.bricks.component.channel.ProjectTipsContract.View
    public void bind(@Nullable ProjectTipsBean projectTipsBean) {
        ur2 ur2;
        TextView textView;
        TextView textView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182830659")) {
            ipChange.ipc$dispatch("-1182830659", new Object[]{this, projectTipsBean});
        } else if (projectTipsBean != null) {
            String str = projectTipsBean.loadTip;
            if (!(str == null || (textView2 = this.tipsTitle) == null)) {
                textView2.setText(str);
            }
            String str2 = projectTipsBean.nearByTip;
            if (str2 != null) {
                TextView textView3 = this.nearbyTitle;
                if (textView3 != null) {
                    textView3.setText(str2);
                }
                ur2 = ur2.INSTANCE;
            } else {
                ur2 = null;
            }
            if (ur2 == null && (textView = this.nearbyTitle) != null) {
                textView.setText("");
            }
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2077327795")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-2077327795", new Object[]{this});
    }

    @Nullable
    public final TextView getNearbyTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-785276222")) {
            return this.nearbyTitle;
        }
        return (TextView) ipChange.ipc$dispatch("-785276222", new Object[]{this});
    }

    @Nullable
    public final TextView getTipsTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "119317499")) {
            return this.tipsTitle;
        }
        return (TextView) ipChange.ipc$dispatch("119317499", new Object[]{this});
    }

    public final void setNearbyTitle(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400058666")) {
            ipChange.ipc$dispatch("1400058666", new Object[]{this, textView});
            return;
        }
        this.nearbyTitle = textView;
    }

    public final void setTipsTitle(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752095215")) {
            ipChange.ipc$dispatch("-1752095215", new Object[]{this, textView});
            return;
        }
        this.tipsTitle = textView;
    }
}
