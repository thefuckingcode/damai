package tb;

import android.graphics.drawable.Drawable;
import cn.damai.commonbusiness.share.evaluate.EvaluateShareViewHolder;
import cn.damai.commonbusiness.share.inf.OnFinishListener;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
public final /* synthetic */ class qe0 implements Function1 {
    public final /* synthetic */ EvaluateShareViewHolder a;
    public final /* synthetic */ OnFinishListener b;

    public /* synthetic */ qe0(EvaluateShareViewHolder evaluateShareViewHolder, OnFinishListener onFinishListener) {
        this.a = evaluateShareViewHolder;
        this.b = onFinishListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return EvaluateShareViewHolder.a(this.a, this.b, (Drawable) obj);
    }
}
