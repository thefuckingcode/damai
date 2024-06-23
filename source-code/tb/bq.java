package tb;

import cn.damai.uikit.tag.DMCommonTagView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class bq implements IImageSuccListener {
    public final /* synthetic */ DMCommonTagView a;

    public /* synthetic */ bq(DMCommonTagView dMCommonTagView) {
        this.a = dMCommonTagView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        this.a.lambda$setTagImage$0(successEvent);
    }
}
