package tb;

import anet.channel.flow.INetworkAnalysis;
import anet.channel.util.ALog;
import com.taobao.analysis.FlowCenter;

/* compiled from: Taobao */
public class c50 implements INetworkAnalysis {
    private boolean a;

    public c50() {
        try {
            Class.forName("com.taobao.analysis.FlowCenter");
            FlowCenter.getInstance();
            this.a = true;
        } catch (Exception unused) {
            this.a = false;
            ALog.e("DefaultNetworkAnalysis", "no NWNetworkAnalysisSDK sdk", null, new Object[0]);
        }
    }

    @Override // anet.channel.flow.INetworkAnalysis
    public void commitFlow(il0 il0) {
        if (this.a) {
            FlowCenter.getInstance().commitFlow(ss0.c(), il0.a, il0.b, il0.c, il0.d, il0.e);
        }
    }
}
