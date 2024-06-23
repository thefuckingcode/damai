package tb;

import android.view.View;
import cn.damai.commonbusiness.share.bean.ShareParams;
import cn.damai.h5container.DMH5Activity;

/* compiled from: Taobao */
public final /* synthetic */ class sq implements View.OnClickListener {
    public final /* synthetic */ ShareParams a;
    public final /* synthetic */ DMH5Activity b;

    public /* synthetic */ sq(ShareParams shareParams, DMH5Activity dMH5Activity) {
        this.a = shareParams;
        this.b = dMH5Activity;
    }

    public final void onClick(View view) {
        DMH5Activity.m26showShareMenu$lambda1(this.a, this.b, view);
    }
}
