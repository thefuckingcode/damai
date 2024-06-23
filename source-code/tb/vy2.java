package tb;

import com.alibaba.pictures.bricks.component.home.feed.WaterFlowRankListViewHolder;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class vy2 implements IImageSuccListener {
    public final /* synthetic */ WaterFlowRankListViewHolder a;
    public final /* synthetic */ String b;

    public /* synthetic */ vy2(WaterFlowRankListViewHolder waterFlowRankListViewHolder, String str) {
        this.a = waterFlowRankListViewHolder;
        this.b = str;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        WaterFlowRankListViewHolder.b(this.a, this.b, successEvent);
    }
}
