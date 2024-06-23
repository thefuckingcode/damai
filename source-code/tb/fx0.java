package tb;

import com.alibaba.pictures.bricks.component.home.HomeProjectItemView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class fx0 implements IImageFailListener {
    public final /* synthetic */ HomeProjectItemView a;

    public /* synthetic */ fx0(HomeProjectItemView homeProjectItemView) {
        this.a = homeProjectItemView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeProjectItemView.m104bindView$lambda1(this.a, failEvent);
    }
}
