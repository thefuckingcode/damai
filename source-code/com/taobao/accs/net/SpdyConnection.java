package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.IConnStrategy;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MessageHandler;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.LoadSoFailUtil;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.weex.annotation.JSMethod;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import tb.ss0;
import tb.w6;

/* compiled from: Taobao */
public class SpdyConnection extends BaseConnection implements SessionCb, Spdycb {
    private static final int ACCS_CONN_TIMEOUT = 120000;
    private static final int CONN_TIMEOUT = 40000;
    private static final int DEFAULT_RETRY_TIME = 5000;
    private static final String HTTP_STATUS = ":status";
    private static final int MAX_RETRY_TIMES = 4;
    protected static final int MAX_TIMEOUT_DATA = 3;
    private static final int REQ_TIMEOUT = 80000;
    private static final String TAG = "SilenceConn_";
    public static String channelAuthRegId = null;
    private static final long nanoToMs = 1000000;
    private long lastPingTime;
    private long lastPingTimeNano;
    private SpdyAgent mAgent = null;
    private boolean mCanUserProxy = false;
    private Object mConnLock = new Object();
    private long mConnStartTime;
    private long mConnStartTimeNano;
    protected ScheduledFuture<?> mConnTimoutFuture;
    private String mFinalUrl;
    private HttpDnsProvider mHttpDnsProvider = new HttpDnsProvider(getChannelHost());
    protected String mIp;
    private boolean mLastConnectFail = false;
    private LinkedList<Message> mMessageList = new LinkedList<>();
    private MonitorStatistic mMonitorInfo;
    protected int mPort;
    private String mProxy = "";
    protected String mProxyIp;
    protected int mProxyPort;
    private boolean mRunning = true;
    private SpdySession mSession = null;
    private String mSessionId;
    private SessionMonitor mStatistic;
    private int mStatus = 3;
    private NetworkThread mThread;
    private String mUrl;
    private int sessionConnectInterval = -1;
    private String testUrl = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class NetworkThread extends Thread {
        private final String TAG = getName();
        public int failTimes = 0;
        long lastConnectTime;

        public NetworkThread(String str) {
            super(str);
        }

        private void tryConnect(boolean z) {
            if (SpdyConnection.this.mStatus != 1) {
                ALog.d(SpdyConnection.this.getTag(), "tryConnect", "force", Boolean.valueOf(z));
                if (!UtilityImpl.isNetworkConnected(SpdyConnection.this.mContext)) {
                    ALog.e(this.TAG, "Network not available", new Object[0]);
                    return;
                }
                if (z) {
                    this.failTimes = 0;
                }
                ALog.i(this.TAG, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.failTimes));
                if (SpdyConnection.this.mStatus != 1 && this.failTimes >= 4) {
                    SpdyConnection.this.mCanUserProxy = true;
                    ALog.e(this.TAG, "tryConnect fail", "maxTimes", 4);
                } else if (SpdyConnection.this.mStatus != 1) {
                    if (SpdyConnection.this.mConnectionType == 1 && this.failTimes == 0) {
                        ALog.i(this.TAG, "tryConnect in app, no sleep", new Object[0]);
                    } else {
                        ALog.i(this.TAG, "tryConnect, need sleep", new Object[0]);
                        if (OrangeAdapter.isSpdyConnectSleepEnable() || UtilityImpl.isForeground(SpdyConnection.this.mContext)) {
                            try {
                                Thread.sleep(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    SpdyConnection.this.mProxy = "";
                    if (this.failTimes == 3) {
                        SpdyConnection.this.mHttpDnsProvider.forceUpdateStrategy(SpdyConnection.this.getChannelHost());
                    }
                    SpdyConnection.this.connect(null);
                    SpdyConnection.this.mStatistic.setRetryTimes(this.failTimes);
                    if (SpdyConnection.this.mStatus != 1) {
                        this.failTimes++;
                        ALog.e(this.TAG, "try connect fail, ready for reconnect", new Object[0]);
                        tryConnect(false);
                        return;
                    }
                    this.lastConnectTime = System.currentTimeMillis();
                }
            } else if (SpdyConnection.this.mStatus == 1 && System.currentTimeMillis() - this.lastConnectTime > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                this.failTimes = 0;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:106:0x034f  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x03ae A[SYNTHETIC, Splitter:B:124:0x03ae] */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x0425  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02d8 A[SYNTHETIC, Splitter:B:81:0x02d8] */
        public void run() {
            boolean z;
            Throwable th;
            Integer num;
            Integer num2;
            Integer num3;
            ALog.i(this.TAG, "NetworkThread run", new Object[0]);
            this.failTimes = 0;
            Message message = null;
            while (SpdyConnection.this.mRunning) {
                ALog.d(this.TAG, "ready to get message", new Object[0]);
                synchronized (SpdyConnection.this.mMessageList) {
                    if (SpdyConnection.this.mMessageList.size() == 0) {
                        try {
                            ALog.d(this.TAG, "no message, wait", new Object[0]);
                            SpdyConnection.this.mMessageList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ALog.d(this.TAG, "try get message", new Object[0]);
                    if (SpdyConnection.this.mMessageList.size() != 0) {
                        message = (Message) SpdyConnection.this.mMessageList.getFirst();
                        if (message.getNetPermanceMonitor() != null) {
                            message.getNetPermanceMonitor().onTakeFromQueue();
                        }
                    }
                }
                if (!SpdyConnection.this.mRunning) {
                    break;
                }
                if (message != null) {
                    ALog.d(this.TAG, "sendMessage not null", new Object[0]);
                    try {
                        int type = message.getType();
                        ALog.i(this.TAG, "sendMessage", "type", Message.MsgType.name(type), "status", Integer.valueOf(SpdyConnection.this.mStatus));
                        if (type != 2) {
                            if (type == 1) {
                                tryConnect(true);
                                if (SpdyConnection.this.mStatus == 1 && SpdyConnection.this.mSession != null) {
                                    SpdyConnection spdyConnection = SpdyConnection.this;
                                    byte[] build = message.build(spdyConnection.mContext, spdyConnection.mConnectionType);
                                    message.setSendTime(System.currentTimeMillis());
                                    if (build.length <= 49152 || message.command.intValue() == 102) {
                                        int id = message.isAck ? -message.getMsgId().getId() : message.getMsgId().getId();
                                        SpdyConnection.this.mSession.sendCustomControlFrame(id, 200, 0, build.length, build);
                                        ALog.e(this.TAG, "send data", "length", Integer.valueOf(build.length), Constants.KEY_DATA_ID, message.getDataId(), "utdid", SpdyConnection.this.mUtdid);
                                        SpdyConnection.this.mMessageHandler.onSend(message);
                                        if (message.isAck) {
                                            ALog.e(this.TAG, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(id));
                                            SpdyConnection.this.mAckMessage.put(Integer.valueOf(id), message);
                                        }
                                        if (message.getNetPermanceMonitor() != null) {
                                            message.getNetPermanceMonitor().onSendData();
                                        }
                                        SpdyConnection.this.setTimeOut(message.getDataId(), SpdyConnection.this.mConfig.isQuickReconnect(), (long) message.timeout);
                                        SpdyConnection.this.mMessageHandler.addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), SpdyConnection.this.getChannelHost(), (long) build.length));
                                    } else {
                                        SpdyConnection.this.mMessageHandler.onResult(message, -4);
                                    }
                                }
                            } else {
                                tryConnect(false);
                                ALog.e(this.TAG, "skip msg", "type", Integer.valueOf(type));
                            }
                            z = true;
                            SpdyConnection.this.setHeartbeat(true);
                            if (z) {
                            }
                        } else if (SpdyConnection.this.mConnectionType == 1) {
                            ALog.d(this.TAG, "sendMessage INAPP ping, skip", new Object[0]);
                            try {
                                ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                synchronized (SpdyConnection.this.mMessageList) {
                                    SpdyConnection.this.mMessageList.remove(message);
                                }
                            } catch (Throwable th2) {
                                ALog.e(this.TAG, " run finally error", th2, new Object[0]);
                            }
                        } else if (System.currentTimeMillis() - SpdyConnection.this.lastPingTime >= ((long) ((HeartbeatManager.getInstance(SpdyConnection.this.mContext).getInterval() - 1) * 1000)) || message.force) {
                            ALog.d(this.TAG, "sendMessage", "force", Boolean.valueOf(message.force), "last ping", Long.valueOf(System.currentTimeMillis() - SpdyConnection.this.lastPingTime));
                            tryConnect(true);
                            if (SpdyConnection.this.mSession != null && SpdyConnection.this.mStatus == 1) {
                                if (System.currentTimeMillis() - SpdyConnection.this.lastPingTime >= ((long) ((HeartbeatManager.getInstance(SpdyConnection.this.mContext).getInterval() - 1) * 1000))) {
                                    ALog.i(this.TAG, "sendMessage onSendPing", new Object[0]);
                                    SpdyConnection.this.mMessageHandler.onSendPing();
                                    SpdyConnection.this.mSession.submitPing();
                                    SpdyConnection.this.mStatistic.onSendPing();
                                    SpdyConnection.this.lastPingTime = System.currentTimeMillis();
                                    SpdyConnection.this.lastPingTimeNano = System.nanoTime();
                                    SpdyConnection.this.setPingTimeOut();
                                }
                                z = true;
                                SpdyConnection.this.setHeartbeat(true);
                                if (z) {
                                    try {
                                        SpdyConnection.this.close();
                                        if (SpdyConnection.this.mStatistic != null) {
                                            SpdyConnection.this.mStatistic.setCloseReason("send fail");
                                        }
                                        synchronized (SpdyConnection.this.mMessageList) {
                                            for (int size = SpdyConnection.this.mMessageList.size() - 1; size >= 0; size--) {
                                                Message message2 = (Message) SpdyConnection.this.mMessageList.get(size);
                                                if (!(message2 == null || (num3 = message2.command) == null || !(num3.intValue() == 100 || message2.command.intValue() == 201))) {
                                                    SpdyConnection.this.mMessageHandler.onResult(message2, -1);
                                                    SpdyConnection.this.mMessageList.remove(size);
                                                }
                                            }
                                            ALog.e(this.TAG, "network disconnected, wait", new Object[0]);
                                            SpdyConnection.this.mMessageList.wait();
                                        }
                                    } catch (Throwable th3) {
                                        ALog.e(this.TAG, " run finally error", th3, new Object[0]);
                                    }
                                } else {
                                    ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                    synchronized (SpdyConnection.this.mMessageList) {
                                        SpdyConnection.this.mMessageList.remove(message);
                                    }
                                }
                            }
                        } else {
                            tryConnect(false);
                            z = true;
                            SpdyConnection.this.setHeartbeat(true);
                            if (z) {
                            }
                        }
                        z = false;
                        try {
                            SpdyConnection.this.setHeartbeat(true);
                            if (z) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", SpdyConnection.this.mConnectionType + th.toString());
                                th.printStackTrace();
                                ALog.e(this.TAG, "service connection run", th, new Object[0]);
                                if (z) {
                                    try {
                                        SpdyConnection.this.close();
                                        if (SpdyConnection.this.mStatistic != null) {
                                            SpdyConnection.this.mStatistic.setCloseReason("send fail");
                                        }
                                        synchronized (SpdyConnection.this.mMessageList) {
                                            for (int size2 = SpdyConnection.this.mMessageList.size() - 1; size2 >= 0; size2--) {
                                                Message message3 = (Message) SpdyConnection.this.mMessageList.get(size2);
                                                if (!(message3 == null || (num2 = message3.command) == null || !(num2.intValue() == 100 || message3.command.intValue() == 201))) {
                                                    SpdyConnection.this.mMessageHandler.onResult(message3, -1);
                                                    SpdyConnection.this.mMessageList.remove(size2);
                                                }
                                            }
                                            ALog.e(this.TAG, "network disconnected, wait", new Object[0]);
                                            SpdyConnection.this.mMessageList.wait();
                                        }
                                    } catch (Throwable th5) {
                                        ALog.e(this.TAG, " run finally error", th5, new Object[0]);
                                    }
                                } else {
                                    ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                    synchronized (SpdyConnection.this.mMessageList) {
                                        SpdyConnection.this.mMessageList.remove(message);
                                    }
                                }
                                message = message;
                            } catch (Throwable th6) {
                                ALog.e(this.TAG, " run finally error", th6, new Object[0]);
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z = true;
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", SpdyConnection.this.mConnectionType + th.toString());
                        th.printStackTrace();
                        ALog.e(this.TAG, "service connection run", th, new Object[0]);
                        if (z) {
                        }
                        message = message;
                    }
                }
                message = message;
            }
            SpdyConnection.this.close();
            return;
            throw th;
        }
    }

    public SpdyConnection(Context context, int i, String str) {
        super(context, i, str);
        initClient();
    }

    private void auth() {
        if (this.mSession == null) {
            notifyStatus(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.getDeviceId(this.mContext));
            String appsign = UtilityImpl.getAppsign(this.mContext, getAppkey(), this.mConfig.getAppSecret(), UtilityImpl.getDeviceId(this.mContext), this.mConfigTag, isSecurityOff() ? 0 : 1);
            String buildAuthUrl = buildAuthUrl(this.mUrl);
            channelAuthRegId = OrangeAdapter.getRegId(this.mContext);
            ALog.e(getTag(), "auth", "url", buildAuthUrl);
            this.mFinalUrl = buildAuthUrl;
            if (!checkParam(encode, getAppkey(), appsign)) {
                ALog.e(getTag(), "auth param error!", new Object[0]);
                onAuthFail(-6);
                return;
            }
            new URL(buildAuthUrl);
            SpdyRequest spdyRequest = new SpdyRequest(new URL(buildAuthUrl), "GET", RequestPriority.DEFAULT_PRIORITY, (int) REQ_TIMEOUT, 40000);
            spdyRequest.setDomain(getChannelHost());
            this.mSession.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), getChannelHost(), this);
        } catch (Throwable th) {
            ALog.e(getTag(), "auth exception ", th, new Object[0]);
            onAuthFail(-7);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    private boolean checkParam(String str, String str2, String str3) {
        if (Utils.getMode(this.mContext) == 2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        int i = 3;
        notifyStatus(3);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i = 2;
            }
            this.mStatistic.setFailReason(i);
            this.mStatistic.onConnectStop();
            String str4 = this.mConnectionType != 0 ? "service" : "inapp";
            NetworkThread networkThread = this.mThread;
            int i2 = networkThread == null ? networkThread.failTimes : 0;
            UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
            AppMonitorAdapter.commitAlarmFail("accs", "connect", "retrytimes:" + i2, i + "", "");
            return false;
        }
        i = 1;
        this.mStatistic.setFailReason(i);
        this.mStatistic.onConnectStop();
        if (this.mConnectionType != 0) {
        }
        NetworkThread networkThread2 = this.mThread;
        if (networkThread2 == null) {
        }
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmFail("accs", "connect", "retrytimes:" + i2, i + "", "");
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRepeatControlCommand(Message message) {
        if (!(message.command == null || this.mMessageList.size() == 0)) {
            for (int size = this.mMessageList.size() - 1; size >= 0; size--) {
                Message message2 = this.mMessageList.get(size);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                this.mMessageList.remove(size);
                                break;
                            }
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                this.mMessageList.remove(size);
                                break;
                            }
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                this.mMessageList.remove(size);
                                break;
                            }
                    }
                    ALog.d(getTag(), "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
                }
            }
            MessageHandler messageHandler = this.mMessageHandler;
            if (messageHandler != null) {
                messageHandler.cancelControlMessage(message);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void connect(String str) {
        SessionInfo sessionInfo;
        int i = this.mStatus;
        if (i != 2 && i != 1) {
            if (this.mHttpDnsProvider == null) {
                this.mHttpDnsProvider = new HttpDnsProvider(getChannelHost());
            }
            List<IConnStrategy> availableStrategy = this.mHttpDnsProvider.getAvailableStrategy(getChannelHost());
            int i2 = 443;
            if (availableStrategy == null || availableStrategy.size() <= 0) {
                if (str != null) {
                    this.mIp = str;
                } else {
                    this.mIp = getChannelHost();
                }
                if (System.currentTimeMillis() % 2 == 0) {
                    i2 = 80;
                }
                this.mPort = i2;
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
                ALog.i(getTag(), "connect get ip from amdc fail!!", new Object[0]);
            } else {
                for (IConnStrategy iConnStrategy : availableStrategy) {
                    if (iConnStrategy != null) {
                        ALog.e(getTag(), "connect", TbAuthConstants.IP, iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                    }
                }
                if (this.mLastConnectFail) {
                    this.mHttpDnsProvider.updateStrategyPos();
                    this.mLastConnectFail = false;
                }
                IConnStrategy strategy = this.mHttpDnsProvider.getStrategy();
                this.mIp = strategy == null ? getChannelHost() : strategy.getIp();
                if (strategy != null) {
                    i2 = strategy.getPort();
                }
                this.mPort = i2;
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
                ALog.e(getTag(), "connect from amdc succ", TbAuthConstants.IP, this.mIp, "port", Integer.valueOf(this.mPort), "originPos", Integer.valueOf(this.mHttpDnsProvider.getStrategyPos()));
            }
            this.mUrl = "https://" + this.mIp + ":" + this.mPort + "/accs/";
            ALog.e(getTag(), "connect", "URL", this.mUrl);
            this.mSessionId = String.valueOf(System.currentTimeMillis());
            if (this.mStatistic != null) {
                w6.b().commitStat(this.mStatistic);
            }
            SessionMonitor sessionMonitor = new SessionMonitor();
            this.mStatistic = sessionMonitor;
            sessionMonitor.setConnectType(this.mConnectionType == 0 ? "service" : "inapp");
            if (this.mAgent != null) {
                try {
                    this.mConnStartTime = System.currentTimeMillis();
                    this.mConnStartTimeNano = System.nanoTime();
                    this.mProxyIp = UtilityImpl.getProxyHost(this.mContext);
                    this.mProxyPort = UtilityImpl.getProxyPort(this.mContext);
                    this.lastPingTime = System.currentTimeMillis();
                    this.mStatistic.onStartConnect();
                    notifyStatus(2);
                    synchronized (this.mConnLock) {
                        try {
                            if (TextUtils.isEmpty(this.mProxyIp) || this.mProxyPort < 0 || !this.mCanUserProxy) {
                                ALog.e(getTag(), "connect normal", new Object[0]);
                                String str2 = this.mIp;
                                int i3 = this.mPort;
                                sessionInfo = new SessionInfo(str2, i3, getChannelHost() + JSMethod.NOT_SET + this.mAppkey, null, 0, this.mSessionId, this, 4226);
                                this.mProxy = "";
                            } else {
                                ALog.e(getTag(), "connect", "proxy", this.mProxyIp, "port", Integer.valueOf(this.mProxyPort));
                                String str3 = this.mIp;
                                int i4 = this.mPort;
                                sessionInfo = new SessionInfo(str3, i4, getChannelHost() + JSMethod.NOT_SET + this.mAppkey, this.mProxyIp, this.mProxyPort, this.mSessionId, this, 4226);
                                this.mProxy = this.mProxyIp + ":" + this.mProxyPort;
                            }
                            sessionInfo.setPubKeySeqNum(getPublicKeyType());
                            sessionInfo.setConnectionTimeoutMs(40000);
                            this.mSession = this.mAgent.createSession(sessionInfo);
                            this.mStatistic.connection_stop_date = 0;
                            this.mConnLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.mCanUserProxy = false;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private int getPublicKeyType() {
        boolean isSecurityOff = isSecurityOff();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.mConfig.getChannelPubKey();
        if (channelPubKey <= 0) {
            return isSecurityOff ? 4 : 3;
        }
        ALog.i(getTag(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void initClient() {
        try {
            SpdyAgent.enableDebug = true;
            this.mAgent = SpdyAgent.getInstance(this.mContext, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                LoadSoFailUtil.loadSoSuccess();
                if (!isSecurityOff()) {
                    this.mAgent.setAccsSslCallback(new AccsSSLCallback() {
                        /* class com.taobao.accs.net.SpdyConnection.AnonymousClass4 */

                        @Override // org.android.spdy.AccsSSLCallback
                        public byte[] getSSLPublicKey(int i, byte[] bArr) {
                            SpdyConnection spdyConnection = SpdyConnection.this;
                            return UtilityImpl.staticBinarySafeDecryptNoB64(spdyConnection.mContext, spdyConnection.mConfigTag, spdyConnection.mAppkey, bArr);
                        }
                    });
                    return;
                }
                return;
            }
            ALog.e(getTag(), "initClient", new Object[0]);
            this.mAgent = null;
            LoadSoFailUtil.loadSoFail();
        } catch (Throwable th) {
            ALog.e(getTag(), "initClient", th, new Object[0]);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0092 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009e */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096 A[SYNTHETIC, Splitter:B:38:0x0096] */
    private synchronized void notifyStatus(int i) {
        ALog.e(getTag(), "notifyStatus start", "status", getStatus(i));
        if (i == this.mStatus) {
            ALog.i(getTag(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.mStatus = i;
        if (i == 1) {
            HeartbeatManager.getInstance(this.mContext).resetLevel();
            setHeartbeat(true);
            ScheduledFuture<?> scheduledFuture = this.mConnTimoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            synchronized (this.mConnLock) {
                this.mConnLock.notifyAll();
            }
            synchronized (this.mMessageList) {
                this.mMessageList.notifyAll();
            }
        } else if (i == 2) {
            ScheduledFuture<?> scheduledFuture2 = this.mConnTimoutFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            final String str = this.mSessionId;
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
                /* class com.taobao.accs.net.SpdyConnection.AnonymousClass3 */

                public void run() {
                    String str = str;
                    if (str != null && str.equals(SpdyConnection.this.mSessionId) && SpdyConnection.this.mStatus == 2) {
                        SpdyConnection.this.mCanUserProxy = false;
                        SpdyConnection.this.mLastConnectFail = true;
                        SpdyConnection.this.close();
                        SpdyConnection.this.mStatistic.setCloseReason("conn timeout");
                    }
                }
            }, 120000, TimeUnit.MILLISECONDS);
        } else if (i == 3) {
            setHeartbeat(true);
            HeartbeatManager.getInstance(this.mContext).onNetworkFail();
            synchronized (this.mConnLock) {
                this.mConnLock.notifyAll();
            }
            this.mMessageHandler.onNetworkFail(-10);
            ping(false, true);
        }
        ALog.i(getTag(), "notifyStatus end", "status", getStatus(i));
        return;
    }

    private void onAuthFail(int i) {
        this.mConnToken = null;
        close();
        NetworkThread networkThread = this.mThread;
        int i2 = networkThread != null ? networkThread.failTimes : 0;
        SessionMonitor sessionMonitor = this.mStatistic;
        sessionMonitor.setCloseReason("code not 200 is" + i);
        this.mLastConnectFail = true;
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini instance = UTMini.getInstance();
        instance.commitEvent(66001, "CONNECTED NO 200 " + str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmFail("accs", "auth", "", i + "", "");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void setHeartbeat(boolean z) {
        if (this.mConnectionType != 1) {
            this.lastPingTime = System.currentTimeMillis();
            this.lastPingTimeNano = System.nanoTime();
            HeartbeatManager.getInstance(this.mContext).set();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        String tag = getTag();
        ALog.w(tag, "bioPingRecvCallback uniId:" + i, new Object[0]);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean cancel(String str) {
        boolean z;
        String str2;
        synchronized (this.mMessageList) {
            z = true;
            int size = this.mMessageList.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.mMessageList.get(size);
                    if (message != null && message.getType() == 1 && (str2 = message.cunstomDataId) != null && str2.equals(str)) {
                        this.mMessageList.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void close() {
        ALog.e(getTag(), " force close!", new Object[0]);
        try {
            this.mSession.closeSession();
            this.mStatistic.setCloseType(1);
        } catch (Exception unused) {
        }
        notifyStatus(3);
    }

    public String getChannelHost() {
        String channelHost = this.mConfig.getChannelHost();
        ALog.i(getTag(), "getChannelHost", "host", channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public int getChannelState() {
        return this.mStatus;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getHost(String str) {
        return "https://" + this.mConfig.getChannelHost();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public int getMaxTimeOutData() {
        return 3;
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        return UtilityImpl.SecurityGuardGetSslTicket2(this.mContext, this.mConfigTag, this.mAppkey, spdySession.getDomain());
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getTag() {
        return TAG + this.mConfigTag;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void initAwcn(Context context) {
        if (!this.mAwcnInited) {
            super.initAwcn(context);
            ss0.k(false);
            this.mAwcnInited = true;
            ALog.i(getTag(), "init awcn success!", new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isAlive() {
        return this.mRunning;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public boolean isKeepAlive() {
        return false;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void notifyNetWorkChange(String str) {
        this.mCanUserProxy = false;
        this.mTimeoutMsgNum = 0;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void onTimeOut(String str, boolean z, String str2) {
        try {
            notifyStatus(4);
            close();
            this.mStatistic.setCloseReason(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void ping(boolean z, boolean z2) {
        String tag = getTag();
        ALog.d(tag, "try ping, force:" + z, new Object[0]);
        if (this.mConnectionType == 1) {
            ALog.d(getTag(), "INAPP, skip", new Object[0]);
            return;
        }
        Message BuildPing = Message.BuildPing(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.mConfig.getPingTimeout();
        if (pingTimeout > 0) {
            BuildPing.timeout = pingTimeout;
        }
        send(BuildPing, z);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return UtilityImpl.SecurityGuardPutSslTicket2(this.mContext, this.mConfigTag, this.mAppkey, spdySession.getDomain(), bArr);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void reConnect() {
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void sendMessage(final Message message, final boolean z) {
        if (!this.mRunning || message == null) {
            String tag = getTag();
            ALog.e(tag, "not running or msg null! " + this.mRunning, new Object[0]);
            return;
        }
        try {
            if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
                    /* class com.taobao.accs.net.SpdyConnection.AnonymousClass1 */

                    public void run() {
                        synchronized (SpdyConnection.this.mMessageList) {
                            SpdyConnection.this.clearRepeatControlCommand(message);
                            if (SpdyConnection.this.mMessageList.size() == 0) {
                                SpdyConnection.this.mMessageList.add(message);
                            } else {
                                Message message = (Message) SpdyConnection.this.mMessageList.getFirst();
                                if (message.getType() != 1) {
                                    if (message.getType() != 0) {
                                        if (message.getType() != 2 || message.getType() != 2) {
                                            SpdyConnection.this.mMessageList.addLast(message);
                                        } else if (!message.force && message.force) {
                                            SpdyConnection.this.mMessageList.removeFirst();
                                            SpdyConnection.this.mMessageList.addFirst(message);
                                        }
                                    }
                                }
                                SpdyConnection.this.mMessageList.addLast(message);
                                if (message.getType() == 2) {
                                    SpdyConnection.this.mMessageList.removeFirst();
                                }
                            }
                            if (z || SpdyConnection.this.mStatus == 3) {
                                try {
                                    SpdyConnection.this.mMessageList.notifyAll();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, message.delyTime, TimeUnit.MILLISECONDS);
                if (message.getType() == 1 && message.cunstomDataId != null) {
                    if (message.isControlFrame()) {
                        cancel(message.cunstomDataId);
                    }
                    this.mMessageHandler.reqTasks.put(message.cunstomDataId, schedule);
                }
                if (message.getNetPermanceMonitor() != null) {
                    message.getNetPermanceMonitor().setConnType(this.mConnectionType);
                    message.getNetPermanceMonitor().onEnterQueueData();
                    return;
                }
                return;
            }
            throw new RejectedExecutionException("accs");
        } catch (RejectedExecutionException unused) {
            this.mMessageHandler.onResult(message, 70008);
            String tag2 = getTag();
            ALog.e(tag2, "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
        } catch (Throwable th) {
            this.mMessageHandler.onResult(message, -8);
            ALog.e(getTag(), "send error", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void shutdown() {
        super.shutdown();
        this.mRunning = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
            /* class com.taobao.accs.net.SpdyConnection.AnonymousClass2 */

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002b */
            public void run() {
                SpdyConnection.this.close();
                if (SpdyConnection.this.mStatistic != null) {
                    SpdyConnection.this.mStatistic.setCloseReason("shut down");
                }
                synchronized (SpdyConnection.this.mMessageList) {
                    SpdyConnection.this.mMessageList.notifyAll();
                }
            }
        });
        ALog.e(getTag(), "shut down", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        reSendAck(i);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        setHeartbeat(true);
        ALog.e(getTag(), "onFrame", "type", Integer.valueOf(i2), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b : bArr) {
                sb.append(Integer.toHexString(b & 255));
                sb.append(" ");
            }
            ALog.d(getTag(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i2 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.mMessageHandler.onMessage(bArr);
                ReceiveMsgStat receiveMsgStat = this.mMessageHandler.getReceiveMsgStat();
                if (receiveMsgStat != null) {
                    receiveMsgStat.receiveDate = String.valueOf(currentTimeMillis2);
                    receiveMsgStat.messageType = this.mConnectionType == 0 ? "service" : "inapp";
                    receiveMsgStat.commitUT();
                }
            } catch (Throwable th) {
                ALog.e(getTag(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.getStackMsg(th));
            }
            ALog.d(getTag(), "try handle msg", new Object[0]);
            cancelPingTimeOut();
        } else {
            ALog.e(getTag(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(getTag(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(getTag(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(getTag(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(getTag(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        this.lastPingTime = System.currentTimeMillis();
        this.lastPingTimeNano = System.nanoTime();
        try {
            Map<String, String> header = UtilityImpl.getHeader(map);
            ALog.d(TAG, "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(header.get(":status"));
            ALog.e(getTag(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
            if (parseInt == 200) {
                notifyStatus(1);
                String str = header.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.mConnToken = str;
                }
                SessionMonitor sessionMonitor = this.mStatistic;
                long j2 = 0;
                if (sessionMonitor.connection_stop_date > 0) {
                    j2 = System.currentTimeMillis() - this.mStatistic.connection_stop_date;
                }
                sessionMonitor.auth_time = j2;
                String str2 = this.mConnectionType == 0 ? "service" : "inapp";
                UTMini instance = UTMini.getInstance();
                instance.commitEvent(66001, "CONNECTED 200 " + str2, this.mFinalUrl, this.mProxy, Integer.valueOf((int) Constants.SDK_VERSION_CODE), "0");
                AppMonitorAdapter.commitAlarmSuccess("accs", "auth", "");
            } else {
                onAuthFail(parseInt);
            }
        } catch (Exception e) {
            ALog.e(getTag(), e.toString(), new Object[0]);
            close();
            this.mStatistic.setCloseReason("exception");
        }
        ALog.d(getTag(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        String tag = getTag();
        ALog.d(tag, "spdyPingRecvCallback uniId:" + j, new Object[0]);
        if (j >= 0) {
            this.mMessageHandler.onRcvPing();
            HeartbeatManager.getInstance(this.mContext).onHeartbeatSucc();
            HeartbeatManager.getInstance(this.mContext).set();
            this.mStatistic.onPingCBReceive();
            if (this.mStatistic.ping_rec_times % 2 == 0) {
                UtilityImpl.setServiceTime(this.mContext, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
            }
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(getTag(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.e(getTag(), "spdySessionCloseCallback", "errorCode", Integer.valueOf(i));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                String tag = getTag();
                ALog.e(tag, "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        notifyStatus(3);
        this.mStatistic.onCloseConnect();
        if (this.mStatistic.getConCloseDate() > 0 && this.mStatistic.getConStopDate() > 0) {
            this.mStatistic.getConCloseDate();
            this.mStatistic.getConStopDate();
        }
        this.mStatistic.setCloseReason(this.mStatistic.getCloseReason() + "tnet error:" + i);
        if (superviseConnectInfo != null) {
            this.mStatistic.live_time = (long) superviseConnectInfo.keepalive_period_second;
        }
        w6.b().commitStat(this.mStatistic);
        for (Message message : this.mMessageHandler.getUnhandledMessages()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                w6.b().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        String tag2 = getTag();
        ALog.d(tag2, "spdySessionCloseCallback, conKeepTime:" + this.mStatistic.live_time + " connectType:" + str, new Object[0]);
        UTMini instance = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        instance.commitEvent(66001, sb.toString(), Integer.valueOf(i), Long.valueOf(this.mStatistic.live_time), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.sessionConnectInterval = superviseConnectInfo.connectTime;
        int i = superviseConnectInfo.handshakeTime;
        ALog.e(getTag(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.sessionConnectInterval), "sslTime", Integer.valueOf(i), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        auth();
        this.mStatistic.setRet(true);
        this.mStatistic.onConnectStop();
        SessionMonitor sessionMonitor = this.mStatistic;
        sessionMonitor.tcp_time = (long) this.sessionConnectInterval;
        sessionMonitor.ssl_time = (long) i;
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini instance = UTMini.getInstance();
        instance.commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.sessionConnectInterval), String.valueOf(i), Integer.valueOf((int) Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmSuccess("accs", "connect", "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.e(getTag(), "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        NetworkThread networkThread = this.mThread;
        int i2 = networkThread != null ? networkThread.failTimes : 0;
        ALog.e(getTag(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i2), "errorId", Integer.valueOf(i));
        this.mCanUserProxy = false;
        this.mLastConnectFail = true;
        notifyStatus(3);
        this.mStatistic.setFailReason(i);
        this.mStatistic.onConnectStop();
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmFail("accs", "connect", "retrytimes:" + i2, i + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
        ALog.d(getTag(), "spdyStreamCloseCallback", new Object[0]);
        if (i != 0) {
            ALog.e(getTag(), "spdyStreamCloseCallback", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
            onAuthFail(i);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void start() {
        this.mRunning = true;
        ALog.d(getTag(), "start", new Object[0]);
        initAwcn(this.mContext);
        if (this.mThread == null) {
            ALog.i(getTag(), "start thread", new Object[0]);
            NetworkThread networkThread = new NetworkThread("NetworkThread_" + this.mConfigTag);
            this.mThread = networkThread;
            networkThread.setPriority(2);
            this.mThread.start();
        }
        ping(false, false);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public MonitorStatistic updateMonitorInfo() {
        if (this.mMonitorInfo == null) {
            this.mMonitorInfo = new MonitorStatistic();
        }
        MonitorStatistic monitorStatistic = this.mMonitorInfo;
        monitorStatistic.connType = this.mConnectionType;
        monitorStatistic.messageNum = this.mMessageList.size();
        this.mMonitorInfo.networkAvailable = UtilityImpl.isNetworkConnected(this.mContext);
        MonitorStatistic monitorStatistic2 = this.mMonitorInfo;
        monitorStatistic2.proxy = this.mProxy;
        monitorStatistic2.status = this.mStatus;
        SessionMonitor sessionMonitor = this.mStatistic;
        int i = 0;
        monitorStatistic2.tcpConnected = sessionMonitor != null && sessionMonitor.getRet();
        this.mMonitorInfo.threadIsalive = isAlive();
        MonitorStatistic monitorStatistic3 = this.mMonitorInfo;
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            i = messageHandler.getUnhandledCount();
        }
        monitorStatistic3.unHandleMessageNum = i;
        MonitorStatistic monitorStatistic4 = this.mMonitorInfo;
        monitorStatistic4.url = this.mFinalUrl;
        return monitorStatistic4;
    }
}
