package tb;

import anet.channel.appmonitor.IAppMonitor;
import anet.channel.statist.StatObject;

/* compiled from: Taobao */
public class w6 {
    private static volatile IAppMonitor a = new a(null);
    private static volatile IAppMonitor b = null;

    /* compiled from: Taobao */
    static class a implements IAppMonitor {
        IAppMonitor a = null;

        a(IAppMonitor iAppMonitor) {
            this.a = iAppMonitor;
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitAlarm(e4 e4Var) {
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitAlarm(e4Var);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitCount(ao aoVar) {
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitCount(aoVar);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitStat(StatObject statObject) {
            if (w6.b != null) {
                w6.b.commitStat(statObject);
            }
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitStat(statObject);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        @Deprecated
        public void register() {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        @Deprecated
        public void register(Class<?> cls) {
        }
    }

    public static IAppMonitor b() {
        return a;
    }

    public static void c(IAppMonitor iAppMonitor) {
        b = iAppMonitor;
    }

    public static void d(IAppMonitor iAppMonitor) {
        a = new a(iAppMonitor);
    }
}
