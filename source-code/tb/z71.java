package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.live.LiveShareImageViewHolder;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public final /* synthetic */ class z71 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ LiveShareImageViewHolder a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ LiveShareImageViewHolder.IFinishCallBack c;

    public /* synthetic */ z71(LiveShareImageViewHolder liveShareImageViewHolder, AtomicInteger atomicInteger, LiveShareImageViewHolder.IFinishCallBack iFinishCallBack) {
        this.a = liveShareImageViewHolder;
        this.b = atomicInteger;
        this.c = iFinishCallBack;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        LiveShareImageViewHolder.c(this.a, this.b, this.c, eVar);
    }
}
