package tb;

import com.alibaba.pictures.bricks.component.home.feed.WaterFlowRankListViewHolder;
import com.alibaba.pictures.bricks.util.DMRGBUtil;

/* compiled from: Taobao */
public final /* synthetic */ class ty2 implements DMRGBUtil.OnFetchColorListener {
    public final /* synthetic */ WaterFlowRankListViewHolder a;

    public /* synthetic */ ty2(WaterFlowRankListViewHolder waterFlowRankListViewHolder) {
        this.a = waterFlowRankListViewHolder;
    }

    @Override // com.alibaba.pictures.bricks.util.DMRGBUtil.OnFetchColorListener
    public final void onFetchColor(int i) {
        WaterFlowRankListViewHolder.a(this.a, i);
    }
}
