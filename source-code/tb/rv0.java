package tb;

import com.alibaba.pictures.bricks.component.home.feed.HomeFeedProjectViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class rv0 implements IImageFailListener {
    public final /* synthetic */ HomeFeedProjectViewHolder a;
    public final /* synthetic */ CharSequence b;

    public /* synthetic */ rv0(HomeFeedProjectViewHolder homeFeedProjectViewHolder, CharSequence charSequence) {
        this.a = homeFeedProjectViewHolder;
        this.b = charSequence;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeFeedProjectViewHolder.c(this.a, this.b, failEvent);
    }
}
