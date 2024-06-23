package tb;

import cn.damai.uikit.tag.DMCommonTagView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class aq implements IImageFailListener {
    public final /* synthetic */ DMCommonTagView a;

    public /* synthetic */ aq(DMCommonTagView dMCommonTagView) {
        this.a = dMCommonTagView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        this.a.lambda$setTagImage$1(failEvent);
    }
}
