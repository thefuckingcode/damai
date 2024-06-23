package tb;

import cn.damai.ultron.net.UltronPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class q90 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659552825")) {
            ipChange.ipc$dispatch("1659552825", new Object[]{this, jn2});
            return;
        }
        ((UltronPresenter) this.c).createOrderValidateSuccess();
    }
}
