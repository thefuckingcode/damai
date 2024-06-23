package tb;

import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.h5container.DMH5Activity;

/* compiled from: Taobao */
public final /* synthetic */ class tq implements OnGrantListener {
    public final /* synthetic */ DMH5Activity a;
    public final /* synthetic */ DMShareMessage b;

    public /* synthetic */ tq(DMH5Activity dMH5Activity, DMShareMessage dMShareMessage) {
        this.a = dMH5Activity;
        this.b = dMShareMessage;
    }

    @Override // cn.damai.common.askpermission.OnGrantListener
    public final void onGranted() {
        DMH5Activity.m25getGenerateImageView$lambda4$lambda3(this.a, this.b);
    }
}
