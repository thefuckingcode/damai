package tb;

import cn.damai.uikit.util.TDialog;
import cn.damai.wantsee.GuideUtProvider;

/* compiled from: Taobao */
public final /* synthetic */ class by2 implements TDialog.OnDialogShowTimeListener {
    public final /* synthetic */ GuideUtProvider a;

    public /* synthetic */ by2(GuideUtProvider guideUtProvider) {
        this.a = guideUtProvider;
    }

    @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
    public final void exposureTime(long j) {
        cy2.f(this.a, j);
    }
}
