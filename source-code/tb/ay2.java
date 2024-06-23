package tb;

import cn.damai.uikit.util.TDialog;
import cn.damai.wantsee.GuideUtHelper;

/* compiled from: Taobao */
public final /* synthetic */ class ay2 implements TDialog.OnDialogShowTimeListener {
    public final /* synthetic */ GuideUtHelper a;

    public /* synthetic */ ay2(GuideUtHelper guideUtHelper) {
        this.a = guideUtHelper;
    }

    @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
    public final void exposureTime(long j) {
        cy2.g(this.a, j);
    }
}
