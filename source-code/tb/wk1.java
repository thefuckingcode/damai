package tb;

import cn.damai.commonbusiness.base.ResponseErrorPage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class wk1 implements ResponseErrorPage.ErrorRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract void a(int i);

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826972658")) {
            ipChange.ipc$dispatch("1826972658", new Object[]{this, Integer.valueOf(i)});
        } else if (!s72.c()) {
            a(i);
        }
    }
}
