package tb;

import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.h5container.action.ActionShareByType;

/* compiled from: Taobao */
public final /* synthetic */ class w2 implements OnGrantListener {
    public final /* synthetic */ ActionShareByType a;
    public final /* synthetic */ DMShareMessage b;

    public /* synthetic */ w2(ActionShareByType actionShareByType, DMShareMessage dMShareMessage) {
        this.a = actionShareByType;
        this.b = dMShareMessage;
    }

    @Override // cn.damai.common.askpermission.OnGrantListener
    public final void onGranted() {
        this.a.lambda$generateImage4SHare$0(this.b);
    }
}
