package tb;

import android.view.View;
import cn.damai.commonbusiness.share.bean.ShareParams;
import cn.damai.h5container.DMH5Activity;

/* compiled from: Taobao */
public final /* synthetic */ class qq implements View.OnClickListener {
    public final /* synthetic */ ShareParams.TypeInfo a;
    public final /* synthetic */ DMH5Activity b;

    public /* synthetic */ qq(ShareParams.TypeInfo typeInfo, DMH5Activity dMH5Activity) {
        this.a = typeInfo;
        this.b = dMH5Activity;
    }

    public final void onClick(View view) {
        DMH5Activity.m23getEditView$lambda2(this.a, this.b, view);
    }
}
