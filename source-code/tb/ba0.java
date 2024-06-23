package tb;

import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.android.ultron.datamodel.imp.a;

/* compiled from: Taobao */
public class ba0 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165418531")) {
            ipChange.ipc$dispatch("-1165418531", new Object[]{this, jn2});
        } else if (jn2 != null) {
            DMComponent dMComponent = (DMComponent) jn2.e("data");
            IPresenter iPresenter = this.c;
            if (iPresenter != null && ((a) iPresenter.getDataContext()) != null) {
                this.c.getDataManager().respondToLinkage(dMComponent);
            }
        }
    }
}
