package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.h5container.action.ActionShareByType;

/* compiled from: Taobao */
public final /* synthetic */ class y2 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ ActionShareByType a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ DMShareMessage c;
    public final /* synthetic */ View d;
    public final /* synthetic */ String e;

    public /* synthetic */ y2(ActionShareByType actionShareByType, Activity activity, DMShareMessage dMShareMessage, View view, String str) {
        this.a = actionShareByType;
        this.b = activity;
        this.c = dMShareMessage;
        this.d = view;
        this.e = str;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        this.a.lambda$loadHeadImg$2(this.b, this.c, this.d, this.e, dVar);
    }
}
