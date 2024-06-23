package cn.damai.homepage.v2.feed;

import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.viewholder.HomeFeedProjectViewHolder;
import cn.damai.homepage.bean.WaterFlowRec2Project;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.dx0;
import tb.gw0;

/* compiled from: Taobao */
public class ProjectViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public final dx0 homeProjectItemListenerV2;
    private final HomeFeedProjectViewHolder<WaterFlowRecommendItem> viewHolder;

    public ProjectViewHolder(View view) {
        super(view);
        dx0 dx0 = new dx0(view.getContext());
        this.homeProjectItemListenerV2 = dx0;
        this.viewHolder = new HomeFeedProjectViewHolder<>(null, view, dx0);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818033962")) {
            ipChange.ipc$dispatch("-818033962", new Object[]{this, iItem});
            return;
        }
        try {
            this.homeProjectItemListenerV2.c(gw0.g(getComponentActions()), iItem.getIndex());
            this.viewHolder.a(new WaterFlowRec2Project((WaterFlowRecommendItem) getValue()), 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
