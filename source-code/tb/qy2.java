package tb;

import com.alibaba.pictures.bricks.component.home.feed.WaterFlowBrandViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class qy2 implements IImageFailListener {
    public final /* synthetic */ WaterFlowBrandViewHolder a;

    public /* synthetic */ qy2(WaterFlowBrandViewHolder waterFlowBrandViewHolder) {
        this.a = waterFlowBrandViewHolder;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        WaterFlowBrandViewHolder.b(this.a, failEvent);
    }
}
