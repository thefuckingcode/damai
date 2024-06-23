package tb;

import anet.channel.flow.INetworkAnalysis;

/* compiled from: Taobao */
public class rh1 {
    private static volatile INetworkAnalysis a = new a(null);

    /* compiled from: Taobao */
    private static class a implements INetworkAnalysis {
        private INetworkAnalysis a = null;

        a(INetworkAnalysis iNetworkAnalysis) {
            this.a = iNetworkAnalysis;
        }

        @Override // anet.channel.flow.INetworkAnalysis
        public void commitFlow(il0 il0) {
            INetworkAnalysis iNetworkAnalysis = this.a;
            if (iNetworkAnalysis != null) {
                iNetworkAnalysis.commitFlow(il0);
            }
        }
    }

    public static INetworkAnalysis a() {
        return a;
    }

    public static void b(INetworkAnalysis iNetworkAnalysis) {
        a = new a(iNetworkAnalysis);
    }
}
