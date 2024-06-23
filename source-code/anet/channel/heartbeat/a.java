package anet.channel.heartbeat;

/* compiled from: Taobao */
public class a {
    public static IHeartbeat a() {
        return new DefaultBgAccsHeartbeatImpl();
    }

    public static IHeartbeat b() {
        return new DefaultHeartbeatImpl();
    }
}
