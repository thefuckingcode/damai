package tb;

import com.alibaba.pictures.bricks.component.home.feed.HomeFeedProjectViewHolder;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class sv0 implements IImageSuccListener {
    public final /* synthetic */ HomeFeedProjectViewHolder a;
    public final /* synthetic */ CharSequence b;

    public /* synthetic */ sv0(HomeFeedProjectViewHolder homeFeedProjectViewHolder, CharSequence charSequence) {
        this.a = homeFeedProjectViewHolder;
        this.b = charSequence;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeFeedProjectViewHolder.d(this.a, this.b, successEvent);
    }
}
