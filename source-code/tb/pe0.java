package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.evaluate.EvaluateScriptMurderShopView;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
public final /* synthetic */ class pe0 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ EvaluateScriptMurderShopView a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ pe0(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1) {
        this.a = evaluateScriptMurderShopView;
        this.b = function1;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        EvaluateScriptMurderShopView.b(this.a, this.b, eVar);
    }
}
