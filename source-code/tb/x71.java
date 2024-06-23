package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.live.LiveShareImageViewHolder;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public final /* synthetic */ class x71 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ LiveShareImageViewHolder a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ LiveShareImageViewHolder.IFinishCallBack c;

    public /* synthetic */ x71(LiveShareImageViewHolder liveShareImageViewHolder, AtomicInteger atomicInteger, LiveShareImageViewHolder.IFinishCallBack iFinishCallBack) {
        this.a = liveShareImageViewHolder;
        this.b = atomicInteger;
        this.c = iFinishCallBack;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        LiveShareImageViewHolder.a(this.a, this.b, this.c, dVar);
    }
}
