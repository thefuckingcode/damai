package tb;

import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zq implements IImageLoader.ImageTicket {
    private static transient /* synthetic */ IpChange $ipChange;
    private cq1 a;

    public zq(cq1 cq1) {
        this.a = cq1;
    }

    @Override // cn.damai.uikit.image.IImageLoader.ImageTicket
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572024260")) {
            ipChange.ipc$dispatch("1572024260", new Object[]{this});
            return;
        }
        this.a.cancel();
    }
}
