package tb;

import cn.damai.comment.view.DMTagView;
import cn.damai.common.image.DMImageCreator;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class ur implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ ur(Function0 function0) {
        this.a = function0;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        DMTagView.a(this.a, dVar);
    }
}
