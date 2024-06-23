package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.evaluate.EvaluateScriptMurderShopView;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
public final /* synthetic */ class oe0 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ EvaluateScriptMurderShopView a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ oe0(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1) {
        this.a = evaluateScriptMurderShopView;
        this.b = function1;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        EvaluateScriptMurderShopView.a(this.a, this.b, dVar);
    }
}
