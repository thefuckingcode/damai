package tb;

import cn.damai.commonbusiness.seatbiz.utils.Cancelable;
import cn.damai.tool2.bufferkit.BufferRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class mv1 implements Cancelable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BufferRequest a;

    public mv1(BufferRequest bufferRequest) {
        this.a = bufferRequest;
    }

    @Override // cn.damai.commonbusiness.seatbiz.utils.Cancelable
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862876675")) {
            ipChange.ipc$dispatch("-862876675", new Object[]{this});
            return;
        }
        BufferRequest bufferRequest = this.a;
        if (bufferRequest != null) {
            bufferRequest.cancel();
        }
    }
}
