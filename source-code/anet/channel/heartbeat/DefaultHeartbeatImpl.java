package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import tb.ss0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class DefaultHeartbeatImpl implements IHeartbeat, Runnable {
    private static final String TAG = "awcn.DefaultHeartbeatImpl";
    private volatile long executeTime = 0;
    private long interval = 0;
    private volatile boolean isCancelled = false;
    private Session session;

    DefaultHeartbeatImpl() {
    }

    private void submit(long j) {
        try {
            this.executeTime = System.currentTimeMillis() + j;
            ThreadPoolExecutorFactory.j(this, j + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ALog.d(TAG, "Submit heartbeat task failed.", this.session.r, e, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.executeTime = System.currentTimeMillis() + this.interval;
    }

    public void run() {
        if (!this.isCancelled) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.executeTime - 1000) {
                submit(this.executeTime - currentTimeMillis);
            } else if (!ss0.i()) {
                if (ALog.g(1)) {
                    Session session2 = this.session;
                    ALog.c(TAG, "heartbeat", session2.r, Preloader.KEY_SESSION, session2);
                }
                this.session.t(true);
                submit(this.interval);
            } else {
                Session session3 = this.session;
                ALog.e(TAG, "close session in background", session3.r, Preloader.KEY_SESSION, session3);
                this.session.c(false);
            }
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session2) {
        Objects.requireNonNull(session2, "session is null");
        this.session = session2;
        long heartbeat = (long) session2.f().getHeartbeat();
        this.interval = heartbeat;
        if (heartbeat <= 0) {
            this.interval = 45000;
        }
        ALog.f(TAG, "heartbeat start", session2.r, Preloader.KEY_SESSION, session2, Constants.Name.INTERVAL, Long.valueOf(this.interval));
        submit(this.interval);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session2 = this.session;
        if (session2 != null) {
            ALog.f(TAG, "heartbeat stop", session2.r, Preloader.KEY_SESSION, session2);
            this.isCancelled = true;
        }
    }
}
