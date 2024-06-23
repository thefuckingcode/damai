package tb;

import com.alibaba.pictures.bricks.component.home.feed.WaterFlowRankListViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class uy2 implements IImageFailListener {
    public final /* synthetic */ WaterFlowRankListViewHolder a;

    public /* synthetic */ uy2(WaterFlowRankListViewHolder waterFlowRankListViewHolder) {
        this.a = waterFlowRankListViewHolder;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        WaterFlowRankListViewHolder.c(this.a, failEvent);
    }
}
