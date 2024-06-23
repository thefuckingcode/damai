package com.taobao.accs.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.c;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IGlobalClientInfoService;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.connection.ConnectionWrapper;
import com.taobao.accs.connection.IConnection;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MessageV2;
import com.taobao.accs.data.MsgDistribute;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.net.AccsSessionCenter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.ProcessStateListener;
import com.taobao.mass.MassClient;
import com.taobao.mass.ServiceKey;
import io.flutter.wpkbridge.WPKFactory;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class ACCSManagerImpl implements IACCSManager {
    private static String TAG = "ACCSMgrImpl_";
    private int baseDataId = 0;
    private IConnection connectionService;
    private ForeBackManager.ForeBackStateListener forebackStateReceiver = new ForeBackManager.ForeBackStateListener() {
        /* class com.taobao.accs.internal.ACCSManagerImpl.AnonymousClass2 */
        private String host;

        @Override // com.taobao.accs.utl.ForeBackManager.ForeBackStateListener
        public void onBackState(Context context) {
            ALog.e(ACCSManagerImpl.TAG, "onBackState", new Object[0]);
            try {
                if (OrangeAdapter.isChannelModeEnable()) {
                    if (!OrangeAdapter.normalChangesEnabled()) {
                        this.host = ACCSManagerImpl.this.getConnection().getHost(null);
                    } else if (TextUtils.isEmpty(this.host) || ACCSManagerImpl.this.inappHostMayUpdate) {
                        this.host = ACCSManagerImpl.this.getConnection().getHost(null);
                        ACCSManagerImpl.this.inappHostMayUpdate = false;
                    }
                    ACCSManagerImpl.this.getConnection().sendMessage(Message.buildBackground(this.host));
                    ACCSManagerImpl.this.getConnection().setForeBackState(0);
                    if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                        ALog.i(ACCSManagerImpl.TAG, "send mass background state frame", new Object[0]);
                        ACCSManagerImpl.this.getConnection().sendMessage(Message.buildMassMessage(ACCSManagerImpl.this.getConnection().getAppkey(), "back", ServiceKey.POWER_MSG, ACCSManagerImpl.this.getConnection().getHost(null), ACCSManagerImpl.this.mConfigTag, context));
                    }
                }
                ConnectionServiceManager.getInstance().onBackground();
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "onBackState error, Error:", e, new Object[0]);
            }
        }

        @Override // com.taobao.accs.utl.ForeBackManager.ForeBackStateListener
        public void onForeState(Context context) {
            boolean z;
            try {
                ALog.e(ACCSManagerImpl.TAG, "onForeState", new Object[0]);
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(ACCSManagerImpl.this.mConfigTag);
                if (OrangeAdapter.isChannelModeEnable()) {
                    ACCSManagerImpl aCCSManagerImpl = ACCSManagerImpl.this;
                    aCCSManagerImpl.schedulePing(aCCSManagerImpl.getConnection());
                    if (ACCSManagerImpl.this.getConnection().getSendBackState()) {
                        ALog.e(ACCSManagerImpl.TAG, "send foreground state frame", new Object[0]);
                        ACCSManagerImpl.this.getConnection().sendMessage(Message.buildForeground(ACCSManagerImpl.this.getConnection().getHost(null)));
                        if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                            ALog.e(ACCSManagerImpl.TAG, "send mass foreground state frame", new Object[0]);
                            ACCSManagerImpl.this.getConnection().sendMessage(Message.buildMassMessage(ACCSManagerImpl.this.getConnection().getAppkey(), "front", ServiceKey.POWER_MSG, ACCSManagerImpl.this.getConnection().getHost(null), ACCSManagerImpl.this.mConfigTag, context));
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    ACCSManagerImpl.this.getConnection().setForeBackState(1);
                } else {
                    z = false;
                }
                if (configByTag.isForePingEnable() && !z) {
                    ACCSManagerImpl aCCSManagerImpl2 = ACCSManagerImpl.this;
                    aCCSManagerImpl2.schedulePing(aCCSManagerImpl2.getConnection());
                }
                ConnectionServiceManager.getInstance().onForeground();
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "onForeState error, Error:", e, new Object[0]);
            }
        }
    };
    private volatile boolean inappHostMayUpdate = false;
    private String mConfigTag;
    private ProcessStateListener processStateListener = new ProcessStateListener() {
        /* class com.taobao.accs.internal.ACCSManagerImpl.AnonymousClass1 */

        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStart(String str) {
        }

        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStop(String str) {
            String str2 = ACCSManagerImpl.TAG;
            ALog.e(str2, "onProcessStop: " + str, new Object[0]);
            try {
                IGlobalClientInfoService iGlobalClientInfoService = (IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, ARanger.getContext()));
                IAgooAppReceiver iAgooAppReceiver = GlobalClientInfo.mAgooAppReceiver;
                if (iAgooAppReceiver != null) {
                    iGlobalClientInfoService.setRemoteAgooAppReceiver(iAgooAppReceiver);
                }
                if (GlobalClientInfo.getInstance(ARanger.getContext()).getAppReceiver() != null) {
                    for (Map.Entry<String, IAppReceiver> entry : GlobalClientInfo.getInstance(ARanger.getContext()).getAppReceiver().entrySet()) {
                        iGlobalClientInfoService.setRemoteAppReceiver(entry.getKey(), entry.getValue());
                    }
                }
                GlobalClientInfo.getInstance(ARanger.getContext()).recoverListener(ACCSManagerImpl.this.mConfigTag);
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "on receive action error, Error:", e, new Object[0]);
            }
            try {
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(ACCSManagerImpl.this.mConfigTag);
                ACCSManagerImpl.this.connectionService = (IConnection) ARanger.create(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, configByTag), new Pair(Integer.class, Integer.valueOf(ForeBackManager.getManager().getState())));
            } catch (IPCException unused) {
                OrangeAdapter.resetChannelModeEnable();
                ACCSManagerImpl aCCSManagerImpl = ACCSManagerImpl.this;
                aCCSManagerImpl.connectionService = new ConnectionWrapper(aCCSManagerImpl.mConfigTag);
            }
            try {
                ACCSManagerImpl.this.connectionService.start();
                ACCSManagerImpl.this.connectionService.setForeBackState(ForeBackManager.getManager().getState());
            } catch (IPCException e2) {
                ALog.e(ACCSManagerImpl.TAG, "start connect error:", e2, new Object[0]);
            }
        }
    };
    private Random random = new Random();

    public ACCSManagerImpl(Context context, String str) {
        int i = 0;
        GlobalClientInfo.mContext = context.getApplicationContext();
        this.mConfigTag = str;
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            try {
                configByTag = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (AccsException e) {
                ALog.e(TAG, "ACCSManagerImpl build config", e, new Object[0]);
            }
        }
        if (ConnectionServiceManager.getInstance().isEnabled(GlobalClientInfo.mContext)) {
            ConnectionServiceManager.getInstance().init(str, configByTag);
        } else if (OrangeAdapter.isChannelModeEnable()) {
            try {
                ComponentName componentName = new ComponentName(context, AccsIPCProvider.class);
                Pair[] pairArr = new Pair[2];
                pairArr[0] = new Pair(AccsClientConfig.class, configByTag);
                if (ForeBackManager.getManager().getState() == 1 && UtilityImpl.isForeground(context)) {
                    i = 1;
                }
                pairArr[1] = new Pair(Integer.class, Integer.valueOf(i));
                this.connectionService = (IConnection) ARanger.create(componentName, IConnection.class, pairArr);
                if (Utils.isMainProcess(context)) {
                    ARanger.registerProcessStateListener(this.processStateListener);
                }
            } catch (IPCException unused) {
                OrangeAdapter.resetChannelModeEnable();
                this.connectionService = new ConnectionWrapper(str);
            }
        } else {
            this.connectionService = new ConnectionWrapper(str);
        }
        if (Utils.isMainProcess(context)) {
            ForeBackManager.getManager().registerForeBackStateListener(this.forebackStateReceiver);
        }
        TAG += this.mConfigTag;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private IConnection getConnection() {
        if (ConnectionServiceManager.getInstance().isEnabled(GlobalClientInfo.mContext)) {
            return ConnectionServiceManager.getInstance().getConnectionWrapper();
        }
        return this.connectionService;
    }

    private Intent getIntent(Context context, int i) {
        if (i == 1 || !UtilityImpl.getFocusDisableStatus(context)) {
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.setClassName(context.getPackageName(), AdapterUtilityImpl.channelService);
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("command", i);
            try {
                intent.putExtra("appKey", getConnection().getAppkey());
            } catch (IPCException e) {
                ALog.e(TAG, "getIntent getAppkey exception", e, new Object[0]);
            }
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
            return intent;
        }
        ALog.e(TAG, "getIntent null command:" + i + " accs enabled:" + UtilityImpl.getFocusDisableStatus(context), new Object[0]);
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void schedulePing(final IConnection iConnection) {
        ThreadPoolExecutorFactory.schedule(new Runnable() {
            /* class com.taobao.accs.internal.ACCSManagerImpl.AnonymousClass3 */

            public void run() {
                try {
                    IConnection iConnection = iConnection;
                    if (iConnection != null) {
                        iConnection.ping(true, false);
                    }
                } catch (IPCException e) {
                    ALog.e(ACCSManagerImpl.TAG, "schedulePing exception", e, new Object[0]);
                }
            }
        }, (long) this.random.nextInt(6), TimeUnit.SECONDS);
    }

    private void sendAppNotBind(Context context, int i, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i);
        intent.putExtra("serviceId", str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        try {
            intent.putExtra("appKey", getConnection().getAppkey());
        } catch (IPCException e) {
            ALog.e(TAG, "sendAppNotBind getAppkey exception", e, new Object[0]);
        }
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
        intent.putExtra("errorCode", i == 2 ? 200 : 300);
        MsgDistribute.distribMessage(context, intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    private void sendControlMessage(Context context, Message message, int i, boolean z) {
        boolean z2;
        boolean z3;
        IPCException e;
        try {
            getConnection().start();
        } catch (IPCException e2) {
            ALog.e(TAG, "sendControlMessage start exception", e2, new Object[0]);
        }
        if (message == null) {
            ALog.e(TAG, "message is null", new Object[0]);
            try {
                getConnection().onResult(Message.buildParameterError(context.getPackageName(), i), -2);
            } catch (IPCException e3) {
                ALog.e(TAG, "sendControlMessage onResult exception", e3, new Object[0]);
            }
        } else {
            if (i == 1) {
                String packageName = message.getPackageName();
                try {
                    if (getConnection().isAppBinded(packageName) && !z) {
                        ALog.i(TAG, "isAppBinded", "package", packageName);
                        getConnection().onResult(message, 200);
                        try {
                            NoTraceTriggerHelper.trigger(context, null, 1);
                        } catch (IPCException e4) {
                            e = e4;
                            z3 = false;
                        }
                    }
                    z2 = true;
                } catch (IPCException e5) {
                    e = e5;
                    z3 = true;
                    ALog.e(TAG, "sendControlMessage isAppBinded exception", e, new Object[0]);
                    z2 = z3;
                    if (z2) {
                    }
                }
                if (z2) {
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (getConnection().isUserBinded(message.getPackageName(), message.userinfo) && !z) {
                            String str = TAG;
                            ALog.i(str, message.getPackageName() + "/" + message.userinfo + " isUserBinded", "isForceBind", Boolean.valueOf(z));
                            getConnection().onResult(message, 200);
                        }
                    } catch (IPCException e6) {
                        ALog.e(TAG, "sendControlMessage isUserBinded exception", e6, new Object[0]);
                    }
                }
                z2 = true;
                if (z2) {
                    ALog.i(TAG, "sendControlMessage", "command", Integer.valueOf(i));
                    try {
                        getConnection().send(message, true);
                        return;
                    } catch (IPCException e7) {
                        ALog.e(TAG, "sendControlMessage send exception", e7, new Object[0]);
                        return;
                    }
                } else {
                    return;
                }
            } else {
                try {
                    if (getConnection().isAppUnbinded(message.getPackageName())) {
                        String str2 = TAG;
                        ALog.i(str2, message.getPackageName() + " isAppUnbinded", new Object[0]);
                        getConnection().onResult(message, 200);
                    }
                } catch (IPCException e8) {
                    ALog.e(TAG, "sendControlMessage isAppUnbinded exception", e8, new Object[0]);
                }
                z2 = true;
                if (z2) {
                }
            }
            z2 = false;
            if (z2) {
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, "accs", str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent intent = getIntent(context, 5);
            if (intent == null) {
                sendAppNotBind(context, 5, str, null);
                return;
            }
            try {
                String appkey = getConnection().getAppkey();
                if (!TextUtils.isEmpty(appkey)) {
                    intent.putExtra("appKey", appkey);
                    intent.putExtra("serviceId", str);
                    if (UtilityImpl.isMainProcess(context)) {
                        try {
                            Message buildBindService = Message.buildBindService(getConnection().getHost(null), this.mConfigTag, intent);
                            if (!(buildBindService == null || buildBindService.getNetPermanceMonitor() == null)) {
                                buildBindService.getNetPermanceMonitor().setDataId(buildBindService.dataId);
                                buildBindService.getNetPermanceMonitor().setHost(buildBindService.host.toString());
                            }
                            sendControlMessage(context, buildBindService, 5, false);
                        } catch (IPCException e) {
                            ALog.e(TAG, "bindService getHost exception", e, new Object[0]);
                        }
                    }
                    try {
                        getConnection().startChannelService();
                    } catch (IPCException e2) {
                        ALog.e(TAG, "bindService startChannelService exception", e2, new Object[0]);
                    }
                }
            } catch (IPCException e3) {
                ALog.e(TAG, "bindService getAppkey exception", e3, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean cancel(Context context, String str) {
        try {
            return getConnection().cancel(str);
        } catch (IPCException e) {
            ALog.e(TAG, "cancel exception", e, new Object[0]);
            return true;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceDisableService(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceEnableService(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        c.m(getConnection().getAppkey()).g();
        return getChannelState();
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> getChannelState() throws Exception {
        String host = getConnection().getHost(null);
        HashMap hashMap = new HashMap();
        hashMap.put(host, Boolean.FALSE);
        if (AccsSessionCenter.getThrowsException(c.m(getConnection().getAppkey()), host, DateUtils.MILLIS_PER_MINUTE) != null) {
            hashMap.put(host, Boolean.TRUE);
        }
        String str = TAG;
        ALog.d(str, "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    @Override // com.taobao.accs.IACCSManager
    public String getUserUnit() {
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isAccsConnected() {
        try {
            return getConnection() != null && getConnection().isConnected();
        } catch (Exception e) {
            if (e instanceof IPCException) {
                ALog.e(TAG, "isAccsConnected isConnected exception", e, new Object[0]);
                if (((IPCException) e).getErrorCode() == 22) {
                    try {
                        IConnection iConnection = (IConnection) ARanger.create(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, AccsClientConfig.getConfigByTag(this.mConfigTag)), new Pair(Integer.class, Integer.valueOf(ForeBackManager.getManager().getState())));
                        this.connectionService = iConnection;
                        iConnection.start();
                    } catch (IPCException unused) {
                        ALog.e(TAG, "create connectionService exception", e, new Object[0]);
                    }
                }
            }
            return true;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isChannelError(int i) {
        return ErrorCode.isChannelError(i);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.isNetworkConnected(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            try {
                getConnection().registerConnectStateListener(accsConnectStateListener);
            } catch (IPCException e) {
                ALog.e(TAG, "registerConnectStateListener exception", e, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.IACCSManager
    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        IPCException e;
        try {
            try {
                getConnection().send(Message.buildPushAck(getConnection().getHost(null), this.mConfigTag, str, str2, str3, true, s, str4, map), true);
            } catch (IPCException e2) {
                e = e2;
            }
        } catch (IPCException e3) {
            e = e3;
            ALog.e(TAG, "sendBusinessAck exception", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0059 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.taobao.accs.IACCSManager
    public String sendPushResponse(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        String str;
        Throwable th;
        boolean z;
        if (context == null || accsRequest == null) {
            ALog.e(TAG, "sendPushResponse input null", WPKFactory.INIT_KEY_CONTEXT, context, "response", accsRequest, "extraInfo", extraInfo);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
            return null;
        }
        try {
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (UtilityImpl.getFocusDisableStatus(context)) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse accs disable");
                return null;
            }
            String appkey = getConnection().getAppkey();
            ?? r19 = TextUtils.isEmpty(appkey);
            if (r19 != 0) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                ALog.e(TAG, "sendPushResponse appkey null", new Object[0]);
                return null;
            }
            TaoBaseService.ExtraInfo extraInfo2 = extraInfo == null ? new TaoBaseService.ExtraInfo() : extraInfo;
            accsRequest.host = null;
            try {
                extraInfo2.fromPackage = context.getPackageName();
                if (extraInfo2.connType == 0 || extraInfo2.fromHost == null) {
                    extraInfo2.connType = 0;
                    ALog.w(TAG, "pushresponse use channel", "host", extraInfo2.fromHost);
                    z = false;
                } else {
                    z = true;
                }
                ALog.i(TAG, "sendPushResponse", "sendbyInapp", Boolean.valueOf(z), "host", extraInfo2.fromHost, "pkg", extraInfo2.fromPackage);
                if (z) {
                    ALog.i(TAG, "sendPushResponse inapp by", "app", extraInfo2.fromPackage);
                    accsRequest.host = new URL(extraInfo2.fromHost);
                    if (context.getPackageName().equals(extraInfo2.fromPackage) && UtilityImpl.isMainProcess(context)) {
                        sendRequest(context, accsRequest, context.getPackageName(), false);
                        return null;
                    } else if (!OrangeAdapter.isChannelModeEnable() || !ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                        Intent intent = new Intent(Constants.ACTION_SEND);
                        intent.setClassName(extraInfo2.fromPackage, AdapterUtilityImpl.msgService);
                        intent.putExtra("packageName", context.getPackageName());
                        intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                        intent.putExtra("appKey", appkey);
                        intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
                        IntentDispatch.dispatchIntent(context, intent);
                        return null;
                    } else {
                        ALog.i(TAG, "sendPushResponse inapp in channel", "app", extraInfo2.fromPackage);
                        r19 = 0;
                        Message buildRequest = Message.buildRequest(context, getConnection().getHost(null), this.mConfigTag, "", context.getPackageName(), Constants.TARGET_SERVICE_PRE, accsRequest, false);
                        if (!(buildRequest == null || buildRequest.getNetPermanceMonitor() == null)) {
                            buildRequest.getNetPermanceMonitor().onSend();
                        }
                        getConnection().send(buildRequest, true);
                        return null;
                    }
                } else {
                    Intent intent2 = getIntent(context, 100);
                    if (intent2 == null) {
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response intent null");
                        sendAppNotBind(context, 100, accsRequest.serviceId, accsRequest.dataId);
                        ALog.e(TAG, "sendPushResponse input null", WPKFactory.INIT_KEY_CONTEXT, context, "response", accsRequest, "extraInfo", extraInfo2);
                        return null;
                    }
                    ALog.i(TAG, "sendPushResponse channel by", "app", extraInfo2.fromPackage);
                    intent2.setClassName(extraInfo2.fromPackage, AdapterUtilityImpl.channelService);
                    intent2.putExtra(Constants.KEY_SEND_TYPE, Message.ReqType.REQ);
                    intent2.putExtra("appKey", appkey);
                    intent2.putExtra(Constants.KEY_USER_ID, accsRequest.userId);
                    intent2.putExtra("serviceId", accsRequest.serviceId);
                    intent2.putExtra("data", accsRequest.data);
                    intent2.putExtra(Constants.KEY_DATA_ID, accsRequest.dataId);
                    intent2.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
                    if (!TextUtils.isEmpty(accsRequest.businessId)) {
                        intent2.putExtra(Constants.KEY_BUSINESSID, accsRequest.businessId);
                    }
                    if (!TextUtils.isEmpty(accsRequest.tag)) {
                        intent2.putExtra(Constants.KEY_EXT_TAG, accsRequest.tag);
                    }
                    String str2 = accsRequest.target;
                    if (str2 != null) {
                        intent2.putExtra("target", str2);
                    }
                    IntentDispatch.dispatchIntent(context, intent2);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                str = r19;
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
                ALog.e(TAG, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
            ALog.e(TAG, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
            return str;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.mConfigTag, iLoginInfo);
    }

    @Override // com.taobao.accs.IACCSManager
    @Deprecated
    public void setMode(Context context, int i) {
        ACCSClient.setEnvironment(context, i);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setProxy(Context context, String str, int i) {
        SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i);
        edit.apply();
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, null, str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            try {
                getConnection().unRegisterConnectStateListener(accsConnectStateListener);
            } catch (IPCException e) {
                ALog.e(TAG, "registerConnectStateListener exception", e, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterSerivce(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindApp(Context context) {
        String str = TAG;
        ALog.e(str, "unbindApp" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent intent = getIntent(context, 2);
            if (intent == null) {
                sendAppNotBind(context, 2, null, null);
            } else if (UtilityImpl.isMainProcess(context)) {
                try {
                    sendControlMessage(context, Message.buildUnbindApp(getConnection().getHost(null), intent), 2, false);
                } catch (IPCException e) {
                    ALog.e(TAG, "unbindApp getHost exception", e, new Object[0]);
                }
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent intent = getIntent(context, 6);
            if (intent == null) {
                sendAppNotBind(context, 6, str, null);
                return;
            }
            try {
                String appkey = getConnection().getAppkey();
                if (!TextUtils.isEmpty(appkey)) {
                    intent.putExtra("appKey", appkey);
                    intent.putExtra("serviceId", str);
                    if (UtilityImpl.isMainProcess(context)) {
                        try {
                            sendControlMessage(context, Message.buildUnbindService(getConnection().getHost(null), this.mConfigTag, intent), 6, false);
                        } catch (IPCException e) {
                            ALog.e(TAG, "unbindService getHost exception", e, new Object[0]);
                        }
                    }
                }
            } catch (IPCException e2) {
                ALog.e(TAG, "unbindService getAppkey exception", e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindUser(Context context) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent intent = getIntent(context, 4);
            if (intent == null) {
                sendAppNotBind(context, 4, null, null);
                return;
            }
            try {
                String appkey = getConnection().getAppkey();
                if (!TextUtils.isEmpty(appkey)) {
                    intent.putExtra("appKey", appkey);
                    if (UtilityImpl.isMainProcess(context)) {
                        try {
                            sendControlMessage(context, Message.buildUnbindUser(getConnection().getHost(null), this.mConfigTag, intent), 4, false);
                        } catch (IPCException e) {
                            ALog.e(TAG, "unbindUser getHost exception", e, new Object[0]);
                        }
                    }
                }
            } catch (IPCException e2) {
                ALog.e(TAG, "unbindUser getAppkey exception", e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void updateConfig(AccsClientConfig accsClientConfig) {
        try {
            this.inappHostMayUpdate = true;
            getConnection().updateConfig(accsClientConfig);
        } catch (IPCException e) {
            ALog.e(TAG, "updateConfig exception", e, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011b A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012f A[Catch:{ all -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        boolean z;
        Message message;
        if (context != null) {
            ALog.i(TAG, "bindApp", "appKey", str);
            Message buildParameterError = Message.buildParameterError(context.getPackageName(), 1);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                ALog.e(TAG, "accs disabled, try enable", new Object[0]);
                UtilityImpl.focusEnableService(context);
            }
            if (TextUtils.isEmpty(str)) {
                try {
                    getConnection().onResult(buildParameterError, -14);
                } catch (IPCException e) {
                    ALog.e(TAG, "bindApp onResult exception", e, new Object[0]);
                }
            } else {
                try {
                    getConnection().setTTid(str3);
                    getConnection().setAppkey(str);
                } catch (IPCException e2) {
                    ALog.e(TAG, "bindApp setTTid/setAppkey exception", e2, new Object[0]);
                }
                UtilityImpl.saveAppKey(context, str);
                if (iAppReceiver != null) {
                    GlobalClientInfo.getInstance(context).setAppReceiver(this.mConfigTag, iAppReceiver);
                }
                UtilityImpl.enableService(context);
                Intent intent = getIntent(context, 1);
                if (intent != null) {
                    try {
                        String str4 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
                        if (!UtilityImpl.appVersionChanged(context) && !UtilityImpl.utdidChanged(Constants.SP_FILE_NAME, context)) {
                            if (!UtilityImpl.notificationStateChanged(Constants.SP_FILE_NAME, context)) {
                                z = false;
                                if (z) {
                                    ALog.d(TAG, "bindApp", "need force bind");
                                    intent.putExtra(Constants.KEY_FOUCE_BIND, true);
                                }
                                intent.putExtra("appKey", str);
                                intent.putExtra("ttid", str3);
                                intent.putExtra("appVersion", str4);
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = getConnection().getAppSecret();
                                }
                                intent.putExtra("app_sercet", str2);
                                if (!UtilityImpl.isMainProcess(context)) {
                                    if (OrangeAdapter.isRegIdSwitchEnable(context)) {
                                        message = MessageV2.buildBindApp(getConnection().getHost(null), this.mConfigTag, context, intent);
                                    } else {
                                        message = Message.buildBindApp(getConnection().getHost(null), this.mConfigTag, context, intent);
                                    }
                                    if (!(message == null || message.getNetPermanceMonitor() == null)) {
                                        message.getNetPermanceMonitor().setDataId(message.dataId);
                                        message.getNetPermanceMonitor().setHost(message.host.toString());
                                    }
                                    sendControlMessage(context, message, 1, z);
                                } else {
                                    ALog.w(TAG, "bindApp only allow in main process", new Object[0]);
                                }
                                getConnection().startChannelService();
                                if (!OrangeAdapter.mOrangeValid) {
                                    OrangeAdapter.registerListener(new String[]{"accs"}, new OrangeAdapter.OrangeListener());
                                    OrangeAdapter.checkAccsEnabled();
                                    return;
                                }
                                return;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        intent.putExtra("appKey", str);
                        intent.putExtra("ttid", str3);
                        intent.putExtra("appVersion", str4);
                        if (TextUtils.isEmpty(str2)) {
                        }
                        intent.putExtra("app_sercet", str2);
                        if (!UtilityImpl.isMainProcess(context)) {
                        }
                        getConnection().startChannelService();
                        try {
                            if (!OrangeAdapter.mOrangeValid) {
                            }
                        } catch (Throwable unused) {
                            ALog.w(TAG, "no orange sdk", new Object[0]);
                        }
                    } catch (Throwable th) {
                        ALog.e(TAG, "bindApp exception", th, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str, boolean z) {
        try {
            ALog.i(TAG, "bindUser", "userId", str);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                ALog.e(TAG, "accs disabled", new Object[0]);
                return;
            }
            Intent intent = getIntent(context, 3);
            if (intent == null) {
                ALog.e(TAG, "intent null", new Object[0]);
                sendAppNotBind(context, 3, null, null);
                return;
            }
            String appkey = getConnection().getAppkey();
            if (TextUtils.isEmpty(appkey)) {
                ALog.e(TAG, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.appVersionChanged(context) || z) {
                ALog.i(TAG, "force bind User", new Object[0]);
                intent.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            intent.putExtra("appKey", appkey);
            intent.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                Message buildBindUser = Message.buildBindUser(getConnection().getHost(null), this.mConfigTag, intent);
                if (!(buildBindUser == null || buildBindUser.getNetPermanceMonitor() == null)) {
                    buildBindUser.getNetPermanceMonitor().setDataId(buildBindUser.dataId);
                    buildBindUser.getNetPermanceMonitor().setHost(buildBindUser.host.toString());
                }
                sendControlMessage(context, buildBindUser, 3, z);
            }
            getConnection().startChannelService();
        } catch (Throwable th) {
            ALog.e(TAG, "bindUser", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.mConfigTag, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(TAG, "inapp only init in main process!", new Object[0]);
            return;
        }
        String str4 = TAG;
        ALog.d(str4, "startInAppConnection APPKEY:" + str, new Object[0]);
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.equals(getConnection().getAppkey(), str)) {
                    getConnection().setTTid(str3);
                    getConnection().setAppkey(str);
                    UtilityImpl.saveAppKey(context, str);
                }
                getConnection().start();
            }
        } catch (IPCException e) {
            ALog.e(TAG, "startInAppConnection exception", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z) {
        Throwable th;
        if (accsRequest == null) {
            try {
                ALog.e(TAG, "sendRequest request null", new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (accsRequest != null) {
                }
                return accsRequest.dataId;
            }
        } else if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(TAG, "sendRequest not in mainprocess", new Object[0]);
            return null;
        } else if (UtilityImpl.getFocusDisableStatus(context)) {
            ALog.e(TAG, "sendRequest disable", new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        } else if (TextUtils.isEmpty(getConnection().getAppkey())) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
            ALog.e(TAG, "sendRequest appkey null", new Object[0]);
            return null;
        } else {
            getConnection().start();
            try {
                Message buildRequest = Message.buildRequest(context, getConnection().getHost(null), this.mConfigTag, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z);
                if (!(buildRequest == null || buildRequest.getNetPermanceMonitor() == null)) {
                    buildRequest.getNetPermanceMonitor().onSend();
                }
                getConnection().send(buildRequest, true);
            } catch (Throwable th3) {
                th = th3;
                if (accsRequest != null) {
                    String str2 = accsRequest.serviceId;
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "request " + th.toString());
                    ALog.e(TAG, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest.dataId);
                }
                return accsRequest.dataId;
            }
            return accsRequest.dataId;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, ACCSManager.AccsRequest accsRequest) {
        Throwable th;
        try {
            boolean focusDisableStatus = UtilityImpl.getFocusDisableStatus(context);
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.e(TAG, "sendData not in mainprocess", new Object[0]);
                return null;
            }
            if (!focusDisableStatus) {
                if (accsRequest != null) {
                    if (TextUtils.isEmpty(getConnection().getAppkey())) {
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data appkey null");
                        ALog.e(TAG, "sendData appkey null", new Object[0]);
                        return null;
                    }
                    getConnection().start();
                    try {
                        Message buildSendData = Message.buildSendData(getConnection().getHost(null), this.mConfigTag, getConnection().getStoreId(), context, context.getPackageName(), accsRequest);
                        if (!(buildSendData == null || buildSendData.getNetPermanceMonitor() == null)) {
                            buildSendData.getNetPermanceMonitor().onSend();
                        }
                        if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(buildSendData.serviceId)) {
                            ALog.e(TAG, "sendMessage", Constants.KEY_DATA_ID, buildSendData.getDataId());
                        }
                        getConnection().send(buildSendData, true);
                    } catch (Throwable th2) {
                        th = th2;
                        String str = accsRequest.serviceId;
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "data " + th.toString());
                        ALog.e(TAG, "sendData", th, "dataid", accsRequest.dataId);
                        return accsRequest.dataId;
                    }
                    return accsRequest.dataId;
                }
            }
            if (focusDisableStatus) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            } else {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
            }
            String str2 = TAG;
            ALog.e(str2, "sendData dataInfo null or disable:" + focusDisableStatus, new Object[0]);
            return null;
        } catch (Throwable th3) {
            th = th3;
            String str3 = accsRequest.serviceId;
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str3, "1", "data " + th.toString());
            ALog.e(TAG, "sendData", th, "dataid", accsRequest.dataId);
            return accsRequest.dataId;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }
}
