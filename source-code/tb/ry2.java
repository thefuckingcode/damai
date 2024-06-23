package tb;

import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.component.home.feed.WaterFlowBrandViewHolder;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class ry2 implements IImageSuccListener {
    public final /* synthetic */ WaterFlowBrandViewHolder a;
    public final /* synthetic */ WaterFlowRecommendItem b;

    public /* synthetic */ ry2(WaterFlowBrandViewHolder waterFlowBrandViewHolder, WaterFlowRecommendItem waterFlowRecommendItem) {
        this.a = waterFlowBrandViewHolder;
        this.b = waterFlowRecommendItem;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        WaterFlowBrandViewHolder.a(this.a, this.b, successEvent);
    }
}
