package anet.channel.heartbeat;

import anet.channel.Session;

/* compiled from: Taobao */
public interface IHeartbeat {
    void reSchedule();

    void start(Session session);

    void stop();
}
