package tb;

import cn.damai.comment.view.DMTagView;
import cn.damai.common.image.DMImageCreator;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class vr implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ DMTagView a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ vr(DMTagView dMTagView, Function0 function0) {
        this.a = dMTagView;
        this.b = function0;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        DMTagView.b(this.a, this.b, eVar);
    }
}
