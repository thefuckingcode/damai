package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.inf.OnFinishListener;

/* compiled from: Taobao */
public final /* synthetic */ class mg1 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ OnFinishListener a;
    public final /* synthetic */ ng1 b;

    public /* synthetic */ mg1(OnFinishListener onFinishListener, ng1 ng1) {
        this.a = onFinishListener;
        this.b = ng1;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        ng1.f(this.a, this.b, eVar);
    }
}
