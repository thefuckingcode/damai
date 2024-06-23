package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.live.LiveArtistView;

/* compiled from: Taobao */
public final /* synthetic */ class v71 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ LiveArtistView a;
    public final /* synthetic */ DMImageCreator.DMImageSuccListener b;

    public /* synthetic */ v71(LiveArtistView liveArtistView, DMImageCreator.DMImageSuccListener dMImageSuccListener) {
        this.a = liveArtistView;
        this.b = dMImageSuccListener;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        LiveArtistView.a(this.a, this.b, eVar);
    }
}
