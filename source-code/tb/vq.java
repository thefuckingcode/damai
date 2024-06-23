package tb;

import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.h5container.DMH5Fragment;

/* compiled from: Taobao */
public final /* synthetic */ class vq implements ResponseErrorPage.ErrorRefreshListener {
    public final /* synthetic */ DMH5Fragment a;

    public /* synthetic */ vq(DMH5Fragment dMH5Fragment) {
        this.a = dMH5Fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public final void handleError(int i) {
        DMH5Fragment.m27initView$lambda4$lambda3$lambda2(this.a, i);
    }
}
