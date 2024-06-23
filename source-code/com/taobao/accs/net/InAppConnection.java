package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.c;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.a;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.d;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.data.Message;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.init.Launcher_InitAgooLifecycle;
import com.taobao.accs.ut.monitor.AccsForegroundMonitor;
import com.taobao.accs.ut.monitor.ConnectionMonitor;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.utl.ABAdapter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.a92;
import tb.h9;
import tb.pd;
import tb.ss0;
import tb.ue0;
import tb.w6;

/* compiled from: Taobao */
public class InAppConnection extends BaseConnection implements DataFrameCb {
    private static final int RESEND_CONNECTED_DELAY = 0;
    private static final int RESEND_DELAY = 2000;
    private static final String TAG = "InAppConn_";
    private static long foreOnlineTotalTimesInMill = 0;
    private static long lastOnlineTimeInMill = 0;
    public static long lastPingTimeMill;
    private static long lastReceiveTimeInMill = 0;
    private static long onForeTimeInMill = 0;
    private static final Map<String, String> retryIdMap = new LinkedHashMap<String, String>() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 200;
        }
    };
    private static EventCb sessionEventCb = new EventCb() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass12 */

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, ue0 ue0) {
            if (i == 128) {
                ALog.e(InAppConnection.TAG, "ping succ", new Object[0]);
                long unused = InAppConnection.lastReceiveTimeInMill = SystemClock.elapsedRealtime();
                InAppConnection.lastPingTimeMill = 0;
            } else if (i == 2048) {
                ALog.e(InAppConnection.TAG, "ping timeout", new Object[0]);
            }
        }
    };
    private ScheduledFuture accsHeartBeatFuture;
    private Runnable accsHeartBeatTask = new Runnable() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass2 */

        public void run() {
            ALog.d(InAppConnection.this.getTag(), "sendAccsHeartbeatMessage", new Object[0]);
            try {
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, new JsonUtility.JsonObjectBuilder().put(MtopJSBridge.MtopJSParam.DATA_TYPE, "pingreq").put("timeInterval", Long.valueOf(InAppConnection.this.accsHeartbeatInterval)).build().toString().getBytes("utf-8"), UUID.randomUUID().toString());
                accsRequest.setTarget("accs-iot");
                accsRequest.setTargetServiceName("sal");
                InAppConnection inAppConnection = InAppConnection.this;
                InAppConnection.this.sendMessage(Message.buildRequest(inAppConnection.mContext, inAppConnection.getHost(null), InAppConnection.this.getTag(), InAppConnection.this.mConfig.getStoreId(), InAppConnection.this.mContext.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
            } catch (Exception e) {
                ALog.e(InAppConnection.this.getTag(), "send accs heartbeat message", e, new Object[0]);
            }
        }
    };
    private long accsHeartbeatInterval = DateUtils.MILLIS_PER_HOUR;
    private volatile boolean connected = true;
    private IHeartbeat heartbeatWrapper = new IHeartbeat() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass11 */

        @Override // anet.channel.heartbeat.IHeartbeat
        public void reSchedule() {
        }

        @Override // anet.channel.heartbeat.IHeartbeat
        public void start(Session session) {
            if (InAppConnection.this.smartHeartbeat != null) {
                InAppConnection.this.smartHeartbeat.start(session);
            }
        }

        @Override // anet.channel.heartbeat.IHeartbeat
        public void stop() {
            if (InAppConnection.this.smartHeartbeat != null) {
                InAppConnection.this.smartHeartbeat.stop();
            }
        }
    };
    private volatile boolean innerConnected = false;
    private boolean isErrorConnectionCommitted = false;
    private long lastCheckConnectTimeInMill;
    private boolean mRunning = true;
    private Set<String> mSessionRegistered = Collections.synchronizedSet(new HashSet());
    private Runnable mTryStartServiceRunable = new Runnable() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass10 */

        public void run() {
            try {
                InAppConnection inAppConnection = InAppConnection.this;
                if (inAppConnection.mContext != null && !TextUtils.isEmpty(inAppConnection.getAppkey())) {
                    ALog.i(InAppConnection.this.getTag(), "mTryStartServiceRunable bindapp", new Object[0]);
                    InAppConnection.this.startChannelService();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private ISessionListener sessionListener = new ISessionListener() {
        /* class com.taobao.accs.net.InAppConnection.AnonymousClass3 */

        private void innerConnChanged(Context context, boolean z) {
            if (z) {
                h9.U(10000);
                long unused = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = SystemClock.elapsedRealtime();
                Collection<Message> unhandledMessages = InAppConnection.this.mMessageHandler.getUnhandledMessages();
                List<String> upRetryServiceIds = OrangeAdapter.getUpRetryServiceIds(context);
                if (!(unhandledMessages == null || upRetryServiceIds == null || upRetryServiceIds.isEmpty())) {
                    for (Message message : unhandledMessages) {
                        if (!message.isAck && !message.isTimeOut()) {
                            String str = message.serviceId;
                            if (!TextUtils.isEmpty(str) && upRetryServiceIds.contains(str) && !InAppConnection.retryIdMap.containsKey(message.getDataId()) && SystemClock.elapsedRealtime() - message.getSendTime() >= 3000) {
                                InAppConnection.this.reSend(message, 0);
                                InAppConnection.retryIdMap.put(message.getDataId(), null);
                            }
                        }
                    }
                }
            } else {
                InAppConnection.foreOnlineTotalTimesInMill += InAppConnection.lastReceiveTimeInMill - InAppConnection.lastOnlineTimeInMill;
                long unused2 = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = 0;
            }
            if (z && UtilityImpl.isMainProcess(context)) {
                Launcher_InitAgooLifecycle.monitorConnected();
            }
        }

        private void onConnectionChangedImpl(Context context, boolean z, Intent intent) {
            TaoBaseService.ConnectInfo connectInfo;
            boolean z2 = true;
            if (!OrangeAdapter.isChannelModeEnable() || !UtilityImpl.isMainProcessAlive(InAppConnection.this.mContext) || h9.L()) {
                z2 = false;
            } else {
                h9.z0(true);
            }
            innerConnChanged(context, z);
            String stringExtra = intent.getStringExtra("host");
            int intExtra = intent.getIntExtra("errorCode", -1);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
            boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
            if (!z) {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra, booleanExtra2, intExtra, stringExtra2);
            }
            connectInfo.connected = z;
            InAppConnection.this.notifyConnectionChanged2Main(context, z);
            if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                ALog.e(InAppConnection.this.getTag(), "onConnectionChanged not allow to notify", new Object[0]);
                c.m(InAppConnection.this.mConfig.getAppKey()).E(InAppConnection.this.sessionListener);
                return;
            }
            InAppConnection.this.notifyConnectionChangedListener(connectInfo, z2);
        }

        @Override // anet.channel.ISessionListener
        public void onConnectionChanged(Intent intent) {
            if (intent == null) {
                ALog.e(InAppConnection.this.getTag(), "onConnectionChanged", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "null");
                return;
            }
            Context context = GlobalClientInfo.getContext();
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra("host");
            String tag = InAppConnection.this.getTag();
            ALog.e(tag, "onConnectionChanged", "currentHost", "https://" + InAppConnection.this.mConfig.getInappHost(), "changeHost", stringExtra, "state", Boolean.valueOf(booleanExtra), "process", IPCUtils.getCurrentProcessName(), "hash", Integer.valueOf(InAppConnection.this.hashCode()));
            if (("https://" + InAppConnection.this.mConfig.getInappHost()).equals(stringExtra)) {
                InAppConnection inAppConnection = InAppConnection.this;
                inAppConnection.innerConnected = inAppConnection.connected = booleanExtra;
                HeartbeatManager.getInstance(context).set();
                InAppConnection.this.monitorFakeConn();
                InAppConnection.this.monitorWrongConn(booleanExtra);
                onConnectionChangedImpl(context, booleanExtra, intent);
            }
        }
    };
    private SmartHeartbeatImpl smartHeartbeat;
    private ScheduledFuture wcTask = null;

    /* compiled from: Taobao */
    public static class Auth implements IAuth {
        private String TAG;
        private String authUrl;
        private BaseConnection connection;
        private String host;

        public Auth(BaseConnection baseConnection, String str) {
            this.TAG = baseConnection.getTag();
            this.connection = baseConnection;
            this.host = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void startAuthRequest(final Session session, final IAuth.AuthCallback authCallback) {
            if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                if (session != null) {
                    session.b();
                }
                ALog.e(this.TAG, "current process is not allowed to startAuthRequest", new Object[0]);
                return;
            }
            this.connection.start();
            final ConnectionMonitor connectionMonitor = new ConnectionMonitor();
            connectionMonitor.startAuth();
            BaseConnection baseConnection = this.connection;
            this.authUrl = baseConnection.buildAuthUrl("https://" + this.host + "/accs/");
            if (OrangeAdapter.isChannelModeEnable()) {
                StringBuilder sb = new StringBuilder();
                String str = this.authUrl;
                sb.append(str.substring(0, str.indexOf("&21=")));
                sb.append("&21=");
                sb.append(BaseConnection.state);
                this.authUrl = sb.toString();
            }
            ALog.e(this.TAG, "auth", "utdid", UtilityImpl.getDeviceId(this.connection.mContext), "hash", Integer.valueOf(hashCode()), "URL", this.authUrl);
            connectionMonitor.authUrlGenerated();
            final int i = BaseConnection.state;
            final a J = new a.b().Z(this.authUrl).J();
            session.w(J, new RequestCb() {
                /* class com.taobao.accs.net.InAppConnection.Auth.AnonymousClass2 */

                @Override // anet.channel.RequestCb
                public void onDataReceive(pd pdVar, boolean z) {
                }

                @Override // anet.channel.RequestCb
                public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                    if (i < 0) {
                        ALog.e(Auth.this.TAG, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
                        authCallback.onAuthFail(i, "onFinish auth fail");
                    }
                }

                @Override // anet.channel.RequestCb
                public void onResponseCode(int i, Map<String, List<String>> map) {
                    ALog.e(Auth.this.TAG, "auth", "httpStatusCode", Integer.valueOf(i));
                    if (i == 200) {
                        ConnectionMonitor connectionMonitor = connectionMonitor;
                        RequestStatistic requestStatistic = J.r;
                        connectionMonitor.authFinish(requestStatistic == null ? 0 : requestStatistic.serverRT);
                        w6.b().commitStat(connectionMonitor);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, "auth", 0.0d);
                        authCallback.onAuthSuccess();
                        if (OrangeAdapter.isChannelModeEnable()) {
                            int i2 = i;
                            int i3 = BaseConnection.state;
                            if ((i2 == i3 && i3 == 0) && (Auth.this.connection instanceof InAppConnection)) {
                                ((InAppConnection) Auth.this.connection).setSendBackState(true);
                            }
                        }
                        if (Auth.this.connection instanceof InAppConnection) {
                            ((InAppConnection) Auth.this.connection).startAccsHeartBeat();
                        }
                        session.v(2176, InAppConnection.sessionEventCb);
                    } else {
                        authCallback.onAuthFail(i, "auth fail");
                    }
                    Map<String, String> header = UtilityImpl.getHeader(map);
                    ALog.d(Auth.this.TAG, "auth", "header", header);
                    String str = header.get("x-at");
                    if (!TextUtils.isEmpty(str)) {
                        Auth.this.connection.mConnToken = str;
                    }
                }
            });
        }

        @Override // anet.channel.IAuth
        public void auth(final Session session, final IAuth.AuthCallback authCallback) {
            if (!OrangeAdapter.isRegIdSwitchEnable(this.connection.mContext) || !OrangeAdapter.isRegIdNotExists(this.connection.mContext)) {
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_DISABLE, "regId disable", 0.0d);
                startAuthRequest(session, authCallback);
                return;
            }
            BaseConnection baseConnection = this.connection;
            session.w(new a.b().Z(baseConnection.buildCreateRegIdUrl("https://" + this.host + "/")).J(), new RequestCb() {
                /* class com.taobao.accs.net.InAppConnection.Auth.AnonymousClass1 */

                @Override // anet.channel.RequestCb
                public void onDataReceive(pd pdVar, boolean z) {
                }

                @Override // anet.channel.RequestCb
                public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                }

                @Override // anet.channel.RequestCb
                public void onResponseCode(int i, Map<String, List<String>> map) {
                    ALog.e(Auth.this.TAG, "getRegId resp", "httpStatusCode", Integer.valueOf(i));
                    String str = null;
                    if (i == 200) {
                        try {
                            Map<String, String> header = UtilityImpl.getHeader(map);
                            if (OrangeAdapter.isRegIdNotExists(Auth.this.connection.mContext)) {
                                str = header.get(Constants.KEY_X_REGID);
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_ONLINE, "get regId by online", 0.0d);
                            }
                        } catch (Exception e) {
                            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_EXCEPTION, "get regId exception: " + e.getMessage(), 0.0d);
                            ALog.e(Auth.this.TAG, "get regId error", e, new Object[0]);
                        } catch (Throwable th) {
                            Auth.this.startAuthRequest(session, authCallback);
                            throw th;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = UtilityImpl.createRegId();
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_NATIVE, "get regId by native", 0.0d);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        synchronized (InAppConnection.class) {
                            if (OrangeAdapter.isRegIdNotExists(Auth.this.connection.mContext)) {
                                OrangeAdapter.saveRegId(Auth.this.connection.mContext, str);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str) && !OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcess(Auth.this.connection.mContext) && UtilityImpl.isChannelProcessAlive(Auth.this.connection.mContext)) {
                        try {
                            ALog.e(Auth.this.TAG, "start channel service for reset regId", new Object[0]);
                            Intent intent = new Intent(Constants.ACTION_RESET_REG_ID);
                            intent.putExtra("regId", str);
                            intent.setClassName(GlobalClientInfo.getContext().getPackageName(), AdapterUtilityImpl.channelService);
                            IntentDispatch.dispatchIntent(GlobalClientInfo.getContext(), intent);
                        } catch (Exception e2) {
                            ALog.e(Auth.this.TAG, "reset channel regId error", e2, new Object[0]);
                        }
                    }
                    Auth.this.startAuthRequest(session, authCallback);
                }
            });
        }
    }

    public InAppConnection(Context context, int i, String str) {
        super(context, i, str);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.mTryStartServiceRunable, 120000, TimeUnit.MILLISECONDS);
    }

    private boolean checkCurProcessIsAllowed2SendMessage(Message message, boolean z) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            if (UtilityImpl.isChannelProcess(this.mContext)) {
                ALog.e(getTag(), "send in main", new Object[0]);
                Intent intent = new Intent(Constants.ACTION_SENDMESSAGE_INMAIN);
                intent.setClassName(this.mContext.getPackageName(), AdapterUtilityImpl.msgService);
                intent.putExtra(WXComponent.PROP_FS_MATCH_PARENT, message);
                intent.putExtra(com.huawei.hms.opendevice.c.a, z);
                IntentDispatch.dispatchIntent(this.mContext, intent);
                return false;
            } else if (UtilityImpl.isMainProcess(this.mContext)) {
                ConnectionServiceManager instance = ConnectionServiceManager.getInstance();
                if (!instance.isProxyConnection() && instance.isAllWeather()) {
                    ALog.e(getTag(), "force-proxy conn", new Object[0]);
                    instance.onChannelConnectionChanged(true);
                }
                try {
                    ALog.e(getTag(), "send in channel", new Object[0]);
                    instance.getConnectionWrapper().send(message, z);
                    return false;
                } catch (IPCException unused) {
                    String tag = getTag();
                    ALog.e(tag, "not running or msg null! " + this.mRunning, new Object[0]);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void monitorFakeConn() {
        if (!this.connected && BaseConnection.state == 1 && UtilityImpl.isNetworkConnected(this.mContext) && lastPingTimeMill > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - lastPingTimeMill;
            if (elapsedRealtime >= 10000 && elapsedRealtime <= 11000) {
                StringBuilder sb = new StringBuilder();
                sb.append(MonitorItemConstants.WS_MONITOR_TITLE_CONN);
                sb.append(ConnectionServiceManager.getInstance().isAllWeather() ? "_aw" : "");
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, sb.toString(), 0.0d);
                ALog.e(getTag(), "fake connection", "isAllWeather", Boolean.valueOf(ConnectionServiceManager.getInstance().isAllWeather()));
            }
        }
    }

    private void monitorForegroundOnline(boolean z) {
        long j = 0;
        if (z) {
            onForeTimeInMill = SystemClock.elapsedRealtime();
            if (this.innerConnected) {
                j = onForeTimeInMill;
            }
            lastOnlineTimeInMill = j;
            lastReceiveTimeInMill = j;
        } else if (onForeTimeInMill > 0) {
            foreOnlineTotalTimesInMill += lastReceiveTimeInMill - lastOnlineTimeInMill;
            AccsForegroundMonitor accsForegroundMonitor = new AccsForegroundMonitor();
            accsForegroundMonitor.aliveTime = SystemClock.elapsedRealtime() - onForeTimeInMill;
            accsForegroundMonitor.onlineTime = foreOnlineTotalTimesInMill;
            w6.b().commitStat(accsForegroundMonitor);
            onForeTimeInMill = 0;
            foreOnlineTotalTimesInMill = 0;
            lastOnlineTimeInMill = 0;
            lastReceiveTimeInMill = 0;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void monitorWrongConn(boolean z) {
        if (!this.isErrorConnectionCommitted) {
            if (!z) {
                try {
                    if (ForeBackManager.getManager().getState() != 0) {
                        if (UtilityImpl.isNetworkConnected(GlobalClientInfo.getContext())) {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (this.lastCheckConnectTimeInMill == 0) {
                                this.lastCheckConnectTimeInMill = elapsedRealtime;
                                this.wcTask = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
                                    /* class com.taobao.accs.net.InAppConnection.AnonymousClass4 */

                                    public void run() {
                                        if (InAppConnection.this.mRunning && !InAppConnection.this.isConnected() && InAppConnection.this.lastCheckConnectTimeInMill > 0 && SystemClock.elapsedRealtime() - InAppConnection.this.lastCheckConnectTimeInMill > 12000) {
                                            ALog.e(InAppConnection.TAG, "connection error ", new Object[0]);
                                            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, BaseMonitor.ARG_NET_FINE_NO_CONNECT, 0.0d);
                                            InAppConnection.this.isErrorConnectionCommitted = true;
                                        }
                                    }
                                }, 10, TimeUnit.SECONDS);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    ALog.e(getTag(), "monitorWrongConn error", e, new Object[0]);
                    return;
                }
            }
            this.lastCheckConnectTimeInMill = 0;
            ScheduledFuture scheduledFuture = this.wcTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.wcTask = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyConnectionChanged2Main(Context context, boolean z) {
        if (UtilityImpl.isChannelProcess(context) && UtilityImpl.isMainProcessAlive(context)) {
            ALog.e(getTag(), "notifyConnectionChanged2Main", new Object[0]);
            Intent intent = new Intent(Constants.ACTION_CHANNEL_CONNECTION_CHANGED);
            intent.setClassName(context.getPackageName(), AdapterUtilityImpl.msgService);
            intent.putExtra(com.huawei.hms.opendevice.c.a, z);
            IntentDispatch.dispatchIntent(context, intent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyConnectionChangedListener(TaoBaseService.ConnectInfo connectInfo, boolean z) {
        Iterator<AccsConnectStateListener> it = getAccsConnectStateListenerArrayList().iterator();
        while (it.hasNext()) {
            AccsConnectStateListener next = it.next();
            try {
                if (connectInfo.connected) {
                    next.onConnected(connectInfo);
                } else {
                    next.onDisconnected(connectInfo);
                }
            } catch (Exception e) {
                ALog.e(getTag(), "onConnectionChanged callback error", e, new Object[0]);
            }
        }
        if (z) {
            ALog.d(TAG, "handBroadCastMsg ACTION_CONNECT_INFO in sessionListener", connectInfo);
            Intent intent = new Intent(Constants.ACTION_CONNECT_INFO);
            intent.setPackage(this.mContext.getPackageName());
            intent.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            this.mContext.sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startAccsHeartBeat() {
        if (this.mConfig.isAccsHeartbeatEnable()) {
            ALog.e(getTag(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.accsHeartBeatFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.accsHeartBeatTask;
            long j = this.accsHeartbeatInterval;
            this.accsHeartBeatFuture = scheduledExecutor.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean cancel(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.mMessageHandler.reqTasks.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.e(getTag(), "cancel", "customDataId", str);
        }
        return cancel;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void close() {
        ALog.e(getTag(), "close", new Object[0]);
        try {
            if (ConnectionServiceManager.getInstance().isEnabled(this.mContext)) {
                c.m(this.mConfig.getAppKey()).E(this.sessionListener);
            }
        } catch (Exception e) {
            ALog.e(getTag(), "close error", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public int getChannelState() {
        return 1;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getTag() {
        return TAG + this.mConfigTag;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void initAwcn(Context context) {
        boolean z;
        try {
            if (!this.mAwcnInited) {
                super.initAwcn(context);
                if (OrangeAdapter.isChannelModeEnable() && !UtilityImpl.isMainProcessAlive(context)) {
                    h9.z0(false);
                }
                ALog.e(getTag(), "register accs session listener", new Object[0]);
                c.m(this.mConfig.getAppKey()).A(this.sessionListener);
                String inappHost = this.mConfig.getInappHost();
                if (!isKeepAlive() || !this.mConfig.isKeepalive()) {
                    ALog.d(getTag(), "initAwcn close keepalive", new Object[0]);
                    z = false;
                } else {
                    z = true;
                }
                if ((OrangeAdapter.isChannelModeEnable() && !UtilityImpl.isMainProcess(context)) || ConnectionServiceManager.getInstance().isAllWeather()) {
                    ALog.e(getTag(), "AwcnConfig.setAccsSessionCreateForbiddenInBg(false)", new Object[0]);
                    h9.V(false);
                }
                registerSessionInfo(c.m(this.mConfig.getAppKey()), inappHost, z);
                this.mAwcnInited = true;
                ALog.e(getTag(), "initAwcn success!", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e(getTag(), "initAwcn", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isAlive() {
        return this.mRunning;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isConnected() {
        ALog.e(TAG, "isConnected", "state", Boolean.valueOf(this.connected));
        return this.connected;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void notifyNetWorkChange(String str) {
        this.mTimeoutMsgNum = 0;
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(final TnetSpdySession tnetSpdySession, final byte[] bArr, final int i, final int i2) {
        SmartHeartbeatImpl smartHeartbeatImpl;
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(getTag(), "onDataReceive", "type", Integer.valueOf(i2), "dataid", Integer.valueOf(i));
        }
        if (ABAdapter.isFeatureOpened(Constants.AB.KEY_ACCS_HEARTBEAT) && (smartHeartbeatImpl = this.smartHeartbeat) != null) {
            smartHeartbeatImpl.reSchedule();
        }
        lastReceiveTimeInMill = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
            /* class com.taobao.accs.net.InAppConnection.AnonymousClass8 */

            public void run() {
                if (i2 == 200) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        ALog.e(InAppConnection.this.getTag(), "onDataScheduled", "dataid", Integer.valueOf(i));
                        InAppConnection.this.mMessageHandler.onMessage(bArr, tnetSpdySession.h(), currentTimeMillis);
                        ReceiveMsgStat receiveMsgStat = InAppConnection.this.mMessageHandler.getReceiveMsgStat();
                        if (receiveMsgStat != null) {
                            receiveMsgStat.receiveDate = String.valueOf(currentTimeMillis);
                            receiveMsgStat.messageType = InAppConnection.this.mConnectionType == 0 ? "service" : "inapp";
                            receiveMsgStat.commitUT();
                        }
                    } catch (Throwable th) {
                        ALog.e(InAppConnection.this.getTag(), "onDataReceive ", th, new Object[0]);
                        UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.getStackMsg(th));
                    }
                } else {
                    String tag = InAppConnection.this.getTag();
                    ALog.e(tag, "drop frame len:" + bArr.length + " frameType" + i2, new Object[0]);
                }
            }
        });
    }

    @Override // anet.channel.DataFrameCb
    public void onException(final int i, final int i2, final boolean z, String str) {
        String tag = getTag();
        ALog.e(tag, "errorId:" + i2 + "detail:" + str + " dataId:" + i + " needRetry:" + z, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
            /* class com.taobao.accs.net.InAppConnection.AnonymousClass9 */

            public void run() {
                Message removeUnhandledMessage;
                int i = i;
                if (i > 0) {
                    Message.Id id = new Message.Id(i, "");
                    Message.Id id2 = null;
                    Iterator<Message.Id> it = InAppConnection.this.mMessageHandler.getUnhandledMessageIds().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Message.Id next = it.next();
                        if (next.equals(id)) {
                            id2 = next;
                            break;
                        }
                    }
                    if (!(id2 == null || (removeUnhandledMessage = InAppConnection.this.mMessageHandler.removeUnhandledMessage(id2.getDataId())) == null)) {
                        if (z) {
                            if (!InAppConnection.this.reSend(removeUnhandledMessage, 2000)) {
                                InAppConnection.this.mMessageHandler.onResult(removeUnhandledMessage, i2);
                            }
                            if (removeUnhandledMessage.getNetPermanceMonitor() != null) {
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                            }
                        } else {
                            InAppConnection.this.mMessageHandler.onResult(removeUnhandledMessage, i2);
                        }
                    }
                }
                int i2 = i;
                if (i2 < 0 && z) {
                    InAppConnection.this.reSendAck(i2);
                }
            }
        });
    }

    public void onReceiveAccsHeartbeatResp(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.e(getTag(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(getTag(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i = jSONObject.getInt("timeInterval");
            if (i == -1) {
                ScheduledFuture scheduledFuture = this.accsHeartBeatFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    return;
                }
                return;
            }
            long j = (long) (i * 1000);
            if (this.accsHeartbeatInterval != j) {
                if (i == 0) {
                    j = DateUtils.MILLIS_PER_HOUR;
                }
                this.accsHeartbeatInterval = j;
                ScheduledFuture scheduledFuture2 = this.accsHeartBeatFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                }
                ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                Runnable runnable = this.accsHeartBeatTask;
                long j2 = this.accsHeartbeatInterval;
                this.accsHeartBeatFuture = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e) {
            ALog.e(getTag(), "onReceiveAccsHeartbeatResp", "e", e.getMessage());
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void onTimeOut(String str, boolean z, String str2) {
        Session session;
        try {
            Message removeUnhandledMessage = this.mMessageHandler.removeUnhandledMessage(str);
            if (removeUnhandledMessage != null && removeUnhandledMessage.host != null && (session = AccsSessionCenter.get(c.m(this.mConfig.getAppKey()), removeUnhandledMessage.host.toString(), 0)) != null) {
                if (z) {
                    ALog.e(getTag(), "close session by time out", new Object[0]);
                    session.c(true);
                    return;
                }
                session.t(true);
            }
        } catch (Exception e) {
            ALog.e(getTag(), "onTimeOut", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void ping(boolean z, boolean z2) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new Runnable() {
            /* class com.taobao.accs.net.InAppConnection.AnonymousClass7 */

            public void run() {
                if (InAppConnection.this.mAwcnInited) {
                    try {
                        String inappHost = ABAdapter.isFeatureOpened(Constants.AB.KEY_INAPP_PING) ? InAppConnection.this.mConfig.getInappHost() : InAppConnection.this.getHost(null);
                        InAppConnection inAppConnection = InAppConnection.this;
                        inAppConnection.registerSessionInfo(c.m(inAppConnection.mConfig.getAppKey()), inappHost, InAppConnection.this.mConfig.isKeepalive());
                        Session session = AccsSessionCenter.get(c.m(InAppConnection.this.mConfig.getAppKey()), InAppConnection.this.getHost(null), ConnType.TypeLevel.SPDY, 0);
                        if (session != null) {
                            ALog.e(InAppConnection.this.getTag(), "try session ping", new Object[0]);
                            int pingTimeout = InAppConnection.this.mConfig.getPingTimeout();
                            if (pingTimeout > 0) {
                                session.u(true, pingTimeout);
                            } else {
                                session.t(true);
                            }
                        }
                    } catch (Exception e) {
                        ALog.e(InAppConnection.this.getTag(), "ping error", e, new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void reConnect() {
        try {
            if (isConnected()) {
                Session session = AccsSessionCenter.get(c.m(this.mConfig.getAppKey()), getHost(null), 0);
                ALog.e(getTag(), "reConnecting", "appkey", this.mConfig.getAppKey(), "host", this.mConfig.getInappHost(), Preloader.KEY_SESSION, session);
                if (session != null) {
                    h9.U(0);
                    session.c(true);
                }
            }
        } catch (Exception e) {
            ALog.e(getTag(), "reConnect error", e, new Object[0]);
        }
    }

    public void registerSessionInfo(c cVar, String str, boolean z) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            ALog.e(getTag(), "current process is not allowed to connect", new Object[0]);
        } else if (!this.mSessionRegistered.contains(str)) {
            if (!OrangeAdapter.isChannelModeEnable()) {
                this.smartHeartbeat = null;
            } else if (this.smartHeartbeat == null) {
                this.smartHeartbeat = new SmartHeartbeatImpl(this, BaseConnection.state);
            }
            cVar.C(a92.a(str, z, true, new Auth(this, str), ABAdapter.isFeatureOpened(Constants.AB.KEY_ACCS_HEARTBEAT) ? this.heartbeatWrapper : this.smartHeartbeat, this));
            cVar.B(str, this.mConfig.getInappPubKey());
            this.mSessionRegistered.add(str);
            ALog.i(getTag(), "registerSessionInfo", "host", str);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void sendMessage(final Message message, boolean z) {
        if (checkCurProcessIsAllowed2SendMessage(message, z)) {
            if (!this.mRunning || message == null) {
                String tag = getTag();
                ALog.e(tag, "not running or msg null! " + this.mRunning, new Object[0]);
                return;
            }
            start();
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(message.serviceId)) {
                        ALog.e(getTag(), "sendMessage schedule", Constants.KEY_DATA_ID, message.getDataId());
                    }
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new Runnable() {
                        /* class com.taobao.accs.net.InAppConnection.AnonymousClass5 */

                        /* JADX WARNING: Removed duplicated region for block: B:64:0x0235  */
                        public void run() {
                            String str;
                            boolean z;
                            Session session;
                            String str2;
                            if (message.getNetPermanceMonitor() != null) {
                                message.getNetPermanceMonitor().onTakeFromQueue();
                            }
                            int type = message.getType();
                            try {
                                if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(message.serviceId)) {
                                    ALog.e(InAppConnection.this.getTag(), "sendMessage start", Constants.KEY_DATA_ID, message.getDataId(), "type", Message.MsgType.name(type));
                                }
                                if (type == 1) {
                                    Message message = message;
                                    if (message.host == null) {
                                        InAppConnection.this.mMessageHandler.onResult(message, -5);
                                    } else {
                                        c m = c.m(InAppConnection.this.mConfig.getAppKey());
                                        InAppConnection.this.registerSessionInfo(m, message.host.getHost(), InAppConnection.this.mConfig.isKeepalive());
                                        try {
                                            session = AccsSessionCenter.getThrowsException(m, message.host.toString(), ConnType.TypeLevel.SPDY, OrangeAdapter.getConnectTimeout(InAppConnection.this.mContext));
                                            str2 = null;
                                        } catch (Exception e) {
                                            ALog.e(InAppConnection.this.getTag(), "get session null", e, new Object[0]);
                                            str2 = e.toString();
                                            session = null;
                                        }
                                        if (session != null) {
                                            Message message2 = message;
                                            InAppConnection inAppConnection = InAppConnection.this;
                                            byte[] build = message2.build(inAppConnection.mContext, inAppConnection.mConnectionType, Boolean.valueOf(BaseConnection.state == 1));
                                            if ("accs".equals(message.serviceId) || Constants.IMPAAS.equals(message.serviceId) || message.isForeBgMessage()) {
                                                String tag = InAppConnection.this.getTag();
                                                Object[] objArr = new Object[10];
                                                objArr[0] = Constants.KEY_DATA_ID;
                                                objArr[1] = message.getDataId();
                                                objArr[2] = "command";
                                                Message message3 = message;
                                                objArr[3] = message3.command;
                                                objArr[4] = "host";
                                                objArr[5] = message3.host;
                                                objArr[6] = "len";
                                                objArr[7] = Integer.valueOf(build == null ? 0 : build.length);
                                                objArr[8] = "utdid";
                                                objArr[9] = InAppConnection.this.mUtdid;
                                                ALog.e(tag, "sendMessage", objArr);
                                            }
                                            message.setSendTime(SystemClock.elapsedRealtime());
                                            Objects.requireNonNull(build);
                                            if (build.length <= 49152 || message.command.intValue() == 102) {
                                                InAppConnection.this.mMessageHandler.onSend(message);
                                                Message message4 = message;
                                                int id = message4.isAck ? -message4.getMsgId().getId() : message4.getMsgId().getId();
                                                if (message.isAck) {
                                                    InAppConnection.this.mAckMessage.put(Integer.valueOf(id), message);
                                                }
                                                session.x(id, build, 200);
                                                if (OrangeAdapter.normalChangesEnabled() && message.isForeBgMessage()) {
                                                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FORE_BG, message.getTarget(), 0.0d);
                                                }
                                                if (message.getNetPermanceMonitor() != null) {
                                                    message.getNetPermanceMonitor().onSendData();
                                                    message.getNetPermanceMonitor().setServiceType(IPCUtils.getCurrentProcessName());
                                                }
                                                InAppConnection.this.setTimeOut(message.getDataId(), InAppConnection.this.mConfig.isQuickReconnect(), (long) message.timeout);
                                                InAppConnection.this.mMessageHandler.addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), message.host.toString(), (long) build.length));
                                            } else {
                                                InAppConnection.this.mMessageHandler.onResult(message, -4);
                                            }
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        str = str2;
                                        if (!z) {
                                            if (message.isTimeOut() || !InAppConnection.this.reSend(message, 2000)) {
                                                InAppConnection.this.mMessageHandler.onResult(message, -11);
                                                String str3 = message.serviceId;
                                                if (str == null) {
                                                    str = "conn time out";
                                                }
                                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.COUNT_SESSION_ERROR, str3, str, String.valueOf(-11));
                                            }
                                            Message message5 = message;
                                            if (message5.retryTimes == 1 && message5.getNetPermanceMonitor() != null) {
                                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                                            }
                                        }
                                        ALog.e(InAppConnection.this.getTag(), "sendMessage end", Constants.KEY_DATA_ID, message.getDataId(), "status", Boolean.valueOf(z));
                                    }
                                } else {
                                    ALog.e(InAppConnection.this.getTag(), "sendMessage skip", "type", Message.MsgType.name(type));
                                }
                                z = true;
                                str = null;
                                if (!z) {
                                }
                                ALog.e(InAppConnection.this.getTag(), "sendMessage end", Constants.KEY_DATA_ID, message.getDataId(), "status", Boolean.valueOf(z));
                            } catch (Throwable th) {
                                ALog.e(InAppConnection.this.getTag(), "sendMessage end", Constants.KEY_DATA_ID, message.getDataId(), "status", Boolean.TRUE);
                                throw th;
                            }
                        }
                    }, message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame() && cancel(message.cunstomDataId)) {
                            this.mMessageHandler.cancelControlMessage(message);
                        }
                        this.mMessageHandler.reqTasks.put(message.cunstomDataId, schedule);
                    }
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    if (netPermanceMonitor != null) {
                        netPermanceMonitor.setConnType(this.mConnectionType);
                        netPermanceMonitor.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.mMessageHandler.onResult(message, 70008);
                String tag2 = getTag();
                ALog.e(tag2, "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
            } catch (Throwable th) {
                this.mMessageHandler.onResult(message, -8);
                ALog.e(getTag(), "send error", th, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void setForeBackState(int i) {
        String tag = getTag();
        Object[] objArr = new Object[4];
        boolean z = false;
        objArr[0] = "state";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "smartHeartbeat";
        objArr[3] = Boolean.valueOf(this.smartHeartbeat != null);
        ALog.e(tag, "setForeBackStateInApp", objArr);
        super.setForeBackState(i);
        SmartHeartbeatImpl smartHeartbeatImpl = this.smartHeartbeat;
        if (smartHeartbeatImpl != null) {
            smartHeartbeatImpl.setState(i);
        }
        setSendBackState(i == 0);
        if (i == 1) {
            z = true;
        }
        monitorForegroundOnline(z);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void setTimeOut(final String str, final boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
            /* class com.taobao.accs.net.InAppConnection.AnonymousClass6 */

            public void run() {
                Message unhandledMessage = InAppConnection.this.mMessageHandler.getUnhandledMessage(str);
                if (unhandledMessage != null) {
                    InAppConnection.this.mMessageHandler.onResult(unhandledMessage, -9);
                    InAppConnection.this.onTimeOut(str, z, "receive data time out");
                    String tag = InAppConnection.this.getTag();
                    ALog.e(tag, str + "-> receive data time out!", new Object[0]);
                }
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void shutdown() {
        ALog.e(getTag(), "shut down", new Object[0]);
        this.mRunning = false;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public synchronized void start() {
        ALog.e(getTag(), "start", new Object[0]);
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            this.mRunning = true;
            initAwcn(this.mContext);
        }
    }

    public void unRegisterSessionInfo() {
        String inappHost = this.mConfig.getInappHost();
        c m = c.m(this.mConfig.getAppKey());
        if (m == null) {
            ALog.w(getTag(), "updateConfig not need update", new Object[0]);
            return;
        }
        m.F(inappHost);
        ALog.w(getTag(), "updateConfig unregisterSessionInfo", "host", inappHost);
        if (this.mSessionRegistered.contains(inappHost)) {
            this.mSessionRegistered.remove(inappHost);
            ALog.w(getTag(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
        }
    }

    public void updateConfig(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(getTag(), "updateConfig null", new Object[0]);
        } else if (accsClientConfig.equals(this.mConfig)) {
            ALog.w(getTag(), "updateConfig not any changed", new Object[0]);
        } else {
            boolean z = true;
            if (!AdapterUtilityImpl.isTaobao(this.mContext)) {
                boolean isRegidEnable = accsClientConfig.isRegidEnable();
                boolean isChannelModeEnable = accsClientConfig.isChannelModeEnable();
                ALog.e(TAG, "updateAppConfig", "regidEnable", Boolean.valueOf(isRegidEnable), "channelModeEnable", Boolean.valueOf(isChannelModeEnable));
                APreferencesManager.getSharedPreferences(this.mContext, Constants.SP_FILE_NAME, 4).edit().putBoolean(Constants.SP_KEY_REG_ID_ENABLE, isRegidEnable).putBoolean(Constants.SP_KEY_GLOBAL_CHANNEL_ENABLE, isChannelModeEnable).apply();
            }
            if (this.mAwcnInited) {
                try {
                    ALog.w(getTag(), "updateConfig", "old", this.mConfig, "new", accsClientConfig);
                    String inappHost = accsClientConfig.getInappHost();
                    c m = c.m(this.mConfig.getAppKey());
                    if (m == null) {
                        ALog.w(getTag(), "updateConfig not need update", new Object[0]);
                        return;
                    }
                    unRegisterSessionInfo();
                    this.mConfig = accsClientConfig;
                    if (!TextUtils.isEmpty(this.mAppkey) && !this.mAppkey.equals(this.mConfig.getAppKey())) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_APPKEY_CHANGED, "", 0.0d);
                    }
                    this.mAppkey = this.mConfig.getAppKey();
                    this.mConfigTag = this.mConfig.getTag();
                    String str = ConnType.PK_ACS;
                    if (this.mConfig.getInappPubKey() == 10 || this.mConfig.getInappPubKey() == 11) {
                        str = "open";
                    }
                    ALog.i(getTag(), "update config register new conn protocol host:", this.mConfig.getInappHost());
                    d.b().c(this.mConfig.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
                    if (!isKeepAlive() || !this.mConfig.isKeepalive()) {
                        ALog.i(getTag(), "updateConfig close keepalive", new Object[0]);
                        z = false;
                    }
                    registerSessionInfo(m, inappHost, z);
                } catch (Throwable th) {
                    ALog.e(getTag(), "updateConfig", th, new Object[0]);
                }
            } else if (OrangeAdapter.isChannelModeEnable() || UtilityImpl.isMainProcess(this.mContext)) {
                this.mConfig = accsClientConfig;
                initAwcn(this.mContext);
            }
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public MonitorStatistic updateMonitorInfo() {
        return null;
    }

    public InAppConnection(Context context, int i, String str, int i2) {
        super(context, i, str);
        setForeBackState(i2);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.mTryStartServiceRunable, 120000, TimeUnit.MILLISECONDS);
    }
}
