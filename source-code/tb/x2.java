package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.common.image.DMImageCreator;
import cn.damai.h5container.action.ActionShareByType;

/* compiled from: Taobao */
public final /* synthetic */ class x2 implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ ActionShareByType a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ View c;
    public final /* synthetic */ String d;

    public /* synthetic */ x2(ActionShareByType actionShareByType, Activity activity, View view, String str) {
        this.a = actionShareByType;
        this.b = activity;
        this.c = view;
        this.d = str;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        this.a.lambda$loadBgImg$4(this.b, this.c, this.d, dVar);
    }
}
