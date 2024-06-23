package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.wxapi.WXEntryActivity;

/* compiled from: Taobao */
public final /* synthetic */ class fx2 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ WXEntryActivity a;

    public /* synthetic */ fx2(WXEntryActivity wXEntryActivity) {
        this.a = wXEntryActivity;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        this.a.lambda$loadImgFromUrl$0(dVar);
    }
}
