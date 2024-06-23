package com.taobao.accs.net;

import android.os.SystemClock;
import anet.channel.Session;
import anet.channel.c;
import anet.channel.heartbeat.IHeartbeat;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.mass.MassClient;
import com.taobao.mass.ServiceKey;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class SmartHeartbeatImpl implements IHeartbeat, Runnable {
    public static final int BACKGROUND_INTERVAL = 270000;
    public static final int FOREGROUND_INTERVAL = 45000;
    private static final String TAG = SmartHeartbeatImpl.class.getSimpleName();
    private Future future;
    private InAppConnection inAppConnection;
    private long interval;
    private boolean isForeSendState = false;
    private long lastRescheduleTimeMill = 0;
    private Session session;
    private volatile int state;

    public SmartHeartbeatImpl(InAppConnection inAppConnection2, int i) {
        this.inAppConnection = inAppConnection2;
        this.state = i;
    }

    private void setInterval() {
        if (this.state == 0) {
            this.interval = OrangeAdapter.getBackInterval(GlobalClientInfo.getContext());
        } else {
            this.interval = OrangeAdapter.getForeInterval(GlobalClientInfo.getContext());
        }
    }

    private synchronized void submit(long j) {
        try {
            String str = TAG;
            ALog.e(str, "submit ping current delay: " + (j / 1000) + "s", new Object[0]);
            Future future2 = this.future;
            if (future2 != null) {
                future2.cancel(false);
                this.future = null;
            }
            this.future = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(this, j + 50, TimeUnit.MILLISECONDS);
            this.lastRescheduleTimeMill = SystemClock.elapsedRealtime();
        } catch (Exception e) {
            ALog.e(TAG, "Submit heartbeat task failed.", this.session.r, e);
        }
        return;
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        ALog.e(TAG, "reSchedule ", new Object[0]);
        if (OrangeAdapter.normalChangesEnabled() || this.interval == 0) {
            setInterval();
        }
        submit(this.interval);
        HeartbeatManager.getInstance(GlobalClientInfo.getContext()).set();
    }

    public void run() {
        ALog.e(TAG, "ping ", new Object[0]);
        if (this.lastRescheduleTimeMill > 0 && this.interval == 45000) {
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_HB_DELAY, "", (double) ((int) ((SystemClock.elapsedRealtime() - this.lastRescheduleTimeMill) / 1000)));
        }
        try {
            Session session2 = AccsSessionCenter.get(c.m(this.inAppConnection.getAppkey()), this.inAppConnection.getHost(null), 0);
            this.session = session2;
            if (session2 != null) {
                session2.t(true);
                InAppConnection.lastPingTimeMill = SystemClock.elapsedRealtime();
            }
        } catch (Exception e) {
            ALog.e(TAG, "get session null", e, new Object[0]);
        }
        String str = TAG;
        ALog.e(str, "logBackState", "state", Integer.valueOf(this.state), "sendBackState", Boolean.valueOf(this.inAppConnection.getSendBackState()));
        if (this.state == 0 && !this.inAppConnection.getSendBackState()) {
            this.inAppConnection.setSendBackState(true);
            InAppConnection inAppConnection2 = this.inAppConnection;
            inAppConnection2.sendMessage(Message.buildBackground(inAppConnection2.getHost(null)), true);
            if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                ALog.i(str, "send mass background state frame", new Object[0]);
                InAppConnection inAppConnection3 = this.inAppConnection;
                inAppConnection3.sendMessage(Message.buildMassMessage(inAppConnection3.getAppkey(), "back", ServiceKey.POWER_MSG, this.inAppConnection.getHost(null), this.inAppConnection.mConfigTag, GlobalClientInfo.getContext()), true);
            }
            ALog.i(str, "send background state frame", new Object[0]);
        }
        if (OrangeAdapter.isSendForeStateInHeartbeat() && this.state == 1 && !this.isForeSendState) {
            ALog.i(str, "resend fore state", new Object[0]);
            InAppConnection inAppConnection4 = this.inAppConnection;
            inAppConnection4.sendMessage(Message.buildForeground(inAppConnection4.getHost(null)), true);
            this.isForeSendState = true;
        }
        if (this.state == 0 && this.inAppConnection.getSendBackState()) {
            this.interval = OrangeAdapter.getBackInterval(GlobalClientInfo.getContext());
        }
        reSchedule();
    }

    /* access modifiers changed from: package-private */
    public void setState(int i) {
        if (this.state != i) {
            String str = TAG;
            ALog.e(str, "reset state, last state: " + this.state + " current state: " + i, new Object[0]);
            this.state = i;
            this.isForeSendState = false;
            if (this.state == 1) {
                setInterval();
                reSchedule();
            }
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session2) {
        Objects.requireNonNull(session2, "session is null");
        HeartbeatManager.getInstance(GlobalClientInfo.getContext()).set();
        this.session = session2;
        setInterval();
        ALog.i(TAG, "heartbeat start", session2.r, Preloader.KEY_SESSION, session2, Constants.Name.INTERVAL, Long.valueOf(this.interval));
        submit(this.interval);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Future future2;
        String str = TAG;
        Session session2 = this.session;
        ALog.i(str, "heartbeat stop", session2.r, Preloader.KEY_SESSION, session2);
        if (this.session != null && (future2 = this.future) != null) {
            future2.cancel(true);
        }
    }
}
