package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.inf.OnFinishListener;

/* compiled from: Taobao */
public final /* synthetic */ class lg1 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ ng1 a;
    public final /* synthetic */ OnFinishListener b;

    public /* synthetic */ lg1(ng1 ng1, OnFinishListener onFinishListener) {
        this.a = ng1;
        this.b = onFinishListener;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        ng1.g(this.a, this.b, dVar);
    }
}
