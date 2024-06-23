package tb;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.h5container.action.ActionShareByType;

/* compiled from: Taobao */
public final /* synthetic */ class z2 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ ActionShareByType a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ ImageView c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ View e;
    public final /* synthetic */ String f;

    public /* synthetic */ z2(ActionShareByType actionShareByType, Activity activity, ImageView imageView, ImageView imageView2, View view, String str) {
        this.a = actionShareByType;
        this.b = activity;
        this.c = imageView;
        this.d = imageView2;
        this.e = view;
        this.f = str;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        this.a.lambda$loadBgImg$3(this.b, this.c, this.d, this.e, this.f, eVar);
    }
}
