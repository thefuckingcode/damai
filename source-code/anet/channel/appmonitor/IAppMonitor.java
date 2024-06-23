package anet.channel.appmonitor;

import anet.channel.statist.StatObject;
import tb.ao;
import tb.e4;

/* compiled from: Taobao */
public interface IAppMonitor {
    void commitAlarm(e4 e4Var);

    void commitCount(ao aoVar);

    void commitStat(StatObject statObject);

    @Deprecated
    void register();

    @Deprecated
    void register(Class<?> cls);
}
