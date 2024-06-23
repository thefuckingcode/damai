package cn.damai.onearch.component.project;

import android.view.View;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.onearch.component.project.OneProject;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.xs0;

/* compiled from: Taobao */
public final class OneProjectView extends AbsView<GenericItem<ItemValue>, OneProjectModel, OneProjectPresent> implements OneProject.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @NotNull
    private final ProjectItemViewHolder mViewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneProjectView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.mViewHolder = new ProjectItemViewHolder(xs0.a(), view);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "238335315")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("238335315", new Object[]{this});
    }

    @Override // cn.damai.onearch.component.project.OneProject.View
    @NotNull
    public ProjectItemViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-370460884")) {
            return this.mViewHolder;
        }
        return (ProjectItemViewHolder) ipChange.ipc$dispatch("-370460884", new Object[]{this});
    }
}
