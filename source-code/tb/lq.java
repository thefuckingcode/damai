package tb;

import android.view.View;
import cn.damai.common.image.DMImageCreator;
import cn.damai.issue.view.DMEvaluateSuccessHeadView;

/* compiled from: Taobao */
public final /* synthetic */ class lq implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ View a;

    public /* synthetic */ lq(View view) {
        this.a = view;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        DMEvaluateSuccessHeadView.m51loadBackground$lambda9(this.a, eVar);
    }
}
