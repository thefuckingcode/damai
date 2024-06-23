package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.h5container.action.ActionShareByType;

/* compiled from: Taobao */
public final /* synthetic */ class a3 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ ActionShareByType a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Activity c;
    public final /* synthetic */ DMShareMessage d;
    public final /* synthetic */ String e;

    public /* synthetic */ a3(ActionShareByType actionShareByType, View view, Activity activity, DMShareMessage dMShareMessage, String str) {
        this.a = actionShareByType;
        this.b = view;
        this.c = activity;
        this.d = dMShareMessage;
        this.e = str;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        this.a.lambda$loadHeadImg$1(this.b, this.c, this.d, this.e, eVar);
    }
}
