package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class DefaultBgAccsHeartbeatImpl implements IHeartbeat, Runnable {
    volatile boolean isCancelled = false;
    Session session = null;

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
    }

    public void run() {
        if (!this.isCancelled) {
            this.session.t(true);
            ThreadPoolExecutorFactory.j(this, 45000, TimeUnit.MILLISECONDS);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session2) {
        Objects.requireNonNull(session2, "session is null");
        this.session = session2;
        run();
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.isCancelled = true;
    }
}
