package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class SelfKillHeartbeatImpl implements IHeartbeat, Runnable {
    private volatile long expectSelfKillTime = System.currentTimeMillis();
    private volatile boolean isCancelled = false;
    private Session session = null;

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.expectSelfKillTime = System.currentTimeMillis() + 45000;
    }

    public void run() {
        if (!this.isCancelled) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.expectSelfKillTime - 1000) {
                ThreadPoolExecutorFactory.j(this, this.expectSelfKillTime - currentTimeMillis, TimeUnit.MILLISECONDS);
            } else {
                this.session.c(false);
            }
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session2) {
        Objects.requireNonNull(session2, "session is null");
        this.session = session2;
        this.expectSelfKillTime = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.j(this, 45000, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.isCancelled = true;
    }
}
