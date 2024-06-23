package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.init.Launcher_InitPush;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import tb.g02;
import tb.gh2;
import tb.oz1;
import tb.s4;

/* compiled from: Taobao */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static AtomicBoolean isManuRegister = new AtomicBoolean(false);
    private static boolean isRegisterSuccess;
    private static g02 mRequestListener;

    /* compiled from: Taobao */
    static class RemoveAliasCallback extends ICallback {
        ICallback callback;

        public RemoveAliasCallback(ICallback iCallback) {
            this.callback = iCallback;
            this.extra = iCallback.extra;
        }

        @Override // com.taobao.agoo.ICallback
        public void onFailure(String str, String str2) {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onFailure(str, str2);
            }
            ALog.e(TaobaoRegister.TAG, "setAlias onFailure", "errCode", str, "errDesc", str2, "extra", this.extra);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_REMOVE_ALIAS, "", str, str2);
        }

        @Override // com.taobao.agoo.ICallback
        public void onSuccess() {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onSuccess();
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_REMOVE_ALIAS, "");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SetAliasCallback extends ICallback {
        ICallback callback;

        public SetAliasCallback(ICallback iCallback) {
            this.callback = iCallback;
            this.extra = iCallback.extra;
        }

        @Override // com.taobao.agoo.ICallback
        public void onFailure(String str, String str2) {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onFailure(str, str2);
            }
            ALog.e(TaobaoRegister.TAG, "setAlias onFailure", "errCode", str, "errDesc", str2, "extra", this.extra);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_SET_ALIAS, "", str, str2);
        }

        @Override // com.taobao.agoo.ICallback
        public void onSuccess() {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onSuccess();
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_SET_ALIAS, "");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements IAgooAppReceiver {
        final /* synthetic */ Context a;
        final /* synthetic */ Context b;
        final /* synthetic */ IRegister c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ IACCSManager f;

        a(Context context, Context context2, IRegister iRegister, String str, String str2, IACCSManager iACCSManager) {
            this.a = context;
            this.b = context2;
            this.c = iRegister;
            this.d = str;
            this.e = str2;
            this.f = iACCSManager;
        }

        @Override // com.taobao.accs.IAppReceiver
        public Map<String, String> getAllServices() {
            return null;
        }

        @Override // com.taobao.accs.IAgooAppReceiver
        public String getAppkey() {
            return this.d;
        }

        @Override // com.taobao.accs.IAppReceiver
        public String getService(String str) {
            return null;
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindApp(int i) {
        }

        @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAgooAppReceiver
        public void onBindApp(int i, String str) {
            try {
                ALog.i(TaobaoRegister.TAG, "onBindApp", "errorCode", Integer.valueOf(i));
                if (i == 200) {
                    if (TaobaoRegister.mRequestListener == null) {
                        g02 unused = TaobaoRegister.mRequestListener = new g02(this.a);
                    }
                    GlobalClientInfo.getInstance(this.b).registerListener(NotifManager.getServiceId(this.b, TaobaoConstants.SERVICE_ID_DEVICECMD), TaobaoRegister.mRequestListener);
                    if (OrangeAdapter.isRegIdSwitchEnableAndValid(this.b)) {
                        if (TextUtils.isEmpty(str)) {
                            this.c.onFailure(TaobaoConstants.REGISTER_ERROR, "agoo server error deviceid null");
                            return;
                        }
                        TaobaoRegister.setIsRegisterSuccess(true);
                        ForeBackManager.getManager().reportSaveClickMessage();
                        UtilityImpl.saveUtdid("Agoo_AppStore", GlobalClientInfo.getContext());
                        this.c.onSuccess(str);
                    } else if (!g02.b.b(this.a.getPackageName()) || UtilityImpl.notificationStateChanged(Constants.SP_CHANNEL_FILE_NAME, this.b)) {
                        byte[] b2 = oz1.b(this.a, this.d, this.e);
                        if (b2 == null) {
                            IRegister iRegister = this.c;
                            if (iRegister != null) {
                                iRegister.onFailure(TaobaoConstants.REGISTER_ERROR, "req data null");
                                return;
                            }
                            return;
                        }
                        String sendRequest = this.f.sendRequest(this.a, new ACCSManager.AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, b2, null));
                        if (TextUtils.isEmpty(sendRequest)) {
                            IRegister iRegister2 = this.c;
                            if (iRegister2 != null) {
                                iRegister2.onFailure(TaobaoConstants.REGISTER_ERROR, "accs channel disabled!");
                            }
                        } else if (this.c != null) {
                            TaobaoRegister.mRequestListener.a.put(sendRequest, this.c);
                        }
                    } else {
                        TaobaoRegister.setIsRegisterSuccess(true);
                        ForeBackManager.getManager().reportSaveClickMessage();
                        ALog.i(TaobaoRegister.TAG, "agoo already Registered return ", new Object[0]);
                        IRegister iRegister3 = this.c;
                        if (iRegister3 != null) {
                            iRegister3.onSuccess(Config.getDeviceToken(this.a));
                        }
                    }
                } else {
                    IRegister iRegister4 = this.c;
                    if (iRegister4 != null) {
                        iRegister4.onFailure(String.valueOf(i), "accs bindapp error!");
                    }
                }
            } catch (Throwable th) {
                ALog.e(TaobaoRegister.TAG, "register onBindApp", th, new Object[0]);
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindUser(String str, int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onData(String str, String str2, byte[] bArr) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onSendData(String str, int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindApp(int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindUser(int i) {
        }
    }

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    public static void clickMessage(Context context, String str, String str2) {
        clickMessage(context, str, str2, 0, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: org.android.agoo.common.MsgDO */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: org.android.agoo.control.AgooFactory */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.android.agoo.message.MessageService] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static void dismissMessage(Context context, String str, String str2) {
        Object th;
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = 0;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "dismissMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "9";
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, msgDO);
                agooFactory.updateMsgStatus(str, "9");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th2) {
                th = th2;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "dismissMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != 0) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            ALog.e(TAG, "dismissMessage,error=" + th, new Object[0]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: org.android.agoo.common.MsgDO */
    /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: org.android.agoo.control.AgooFactory */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.android.agoo.message.MessageService] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static void exposureMessage(Context context, String str, String str2) {
        Object th;
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = 0;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "exposureMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "10";
                new AgooFactory().init(context, notifManager, msgDO);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th2) {
                th = th2;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "exposureMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != 0) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            ALog.e(TAG, "exposureMessage,error=" + th, new Object[0]);
        }
    }

    public static boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            register(context, "default", str, str2, str3, iRegister);
        }
    }

    public static void registerManuMonitor(Context context) {
        if (!isManuRegister.getAndSet(true) && !AdapterUtilityImpl.isTaobao(context)) {
            Launcher_InitPush.monitorPush(context);
        }
    }

    public static synchronized void removeAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            if (OrangeAdapter.isAliasAlarmEnabled()) {
                iCallback = new RemoveAliasCallback(iCallback);
            }
            ALog.i(TAG, s4.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                String deviceToken = Config.getDeviceToken(context);
                String agooAppKey = Config.getAgooAppKey(context);
                if (!TextUtils.isEmpty(agooAppKey) && !TextUtils.isEmpty(deviceToken) && context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
                        if (mRequestListener == null) {
                            mRequestListener = new g02(context.getApplicationContext());
                        }
                        String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
                        GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
                        String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, serviceId, s4.d(agooAppKey, deviceToken, str), null));
                        if (TextUtils.isEmpty(sendRequest)) {
                            if (iCallback != null) {
                                iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.a.put(sendRequest, iCallback);
                        }
                        return;
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
                }
                ALog.e(TAG, "setAlias param null", "appkey", agooAppKey, "deviceId", deviceToken, "alias", str, WPKFactory.INIT_KEY_CONTEXT, context);
            } catch (Throwable th) {
                ALog.e(TAG, s4.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
        }
    }

    public static void removeAllAlias(Context context, ICallback iCallback) {
        ALog.i(TAG, "removeAllAlias", new Object[0]);
        try {
            String deviceToken = Config.getDeviceToken(context);
            String agooAppKey = Config.getAgooAppKey(context);
            if (TextUtils.isEmpty(agooAppKey) || TextUtils.isEmpty(deviceToken) || context == null) {
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
                }
                ALog.e(TAG, "removeAllAlias param null", "appkey", agooAppKey, "deviceId", deviceToken, WPKFactory.INIT_KEY_CONTEXT, context);
                return;
            }
            IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
            if (mRequestListener == null) {
                mRequestListener = new g02(context.getApplicationContext());
            }
            String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
            GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
            String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, serviceId, s4.b(agooAppKey, deviceToken), null));
            if (TextUtils.isEmpty(sendRequest)) {
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                }
            } else if (iCallback != null) {
                mRequestListener.a.put(sendRequest, iCallback);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "removeAllAlias", th, new Object[0]);
        }
    }

    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z) {
        synchronized (TaobaoRegister.class) {
            try {
                String deviceToken = Config.getDeviceToken(context);
                String agooAppKey = Config.getAgooAppKey(context);
                String deviceId = UtilityImpl.getDeviceId(context);
                if (!TextUtils.isEmpty(agooAppKey) && context != null) {
                    if (!TextUtils.isEmpty(deviceToken) || !TextUtils.isEmpty(deviceId)) {
                        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
                        if (mRequestListener == null) {
                            mRequestListener = new g02(context.getApplicationContext());
                        }
                        String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
                        GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
                        String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, serviceId, gh2.b(agooAppKey, deviceToken, deviceId, z), null));
                        ALog.e(TAG, "sendSwitch", Constants.KEY_DATA_ID, sendRequest, gh2.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z));
                        if (TextUtils.isEmpty(sendRequest)) {
                            if (iCallback != null) {
                                iCallback.onFailure(TaobaoConstants.BINDAGOO_ERROR, "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.a.put(sendRequest, iCallback);
                        }
                        return;
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.UNBINDAGOO_ERROR, "input params null!!");
                }
                ALog.e(TAG, "sendSwitch param null", "appkey", agooAppKey, "deviceId", deviceToken, WPKFactory.INIT_KEY_CONTEXT, context, gh2.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z));
                return;
            } catch (Throwable th) {
                ALog.e(TAG, "sendSwitch", th, new Object[0]);
            }
        }
    }

    public static synchronized void setAccsConfigTag(Context context, String str) {
        synchronized (TaobaoRegister.class) {
            Config.mAccsConfigTag = str;
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
            if (configByTag != null) {
                ALog.i(TAG, "setAccsConfigTag", com.youku.arch.v3.core.Constants.CONFIG, configByTag.toString());
                AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                Config.setAgooAppKey(context, configByTag.getAppKey());
                String appSecret = configByTag.getAppSecret();
                AdapterUtilityImpl.mAgooAppSecret = appSecret;
                if (!TextUtils.isEmpty(appSecret)) {
                    AdapterGlobalClientInfo.mSecurityType = 2;
                }
            } else {
                throw new RuntimeException("accs config not exist!! please set accs config first!!");
            }
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = str;
    }

    public static synchronized void setAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            if (OrangeAdapter.isAliasAlarmEnabled()) {
                iCallback = new SetAliasCallback(iCallback);
            }
            ALog.i(TAG, s4.JSON_CMD_SETALIAS, "alias", str);
            String deviceToken = Config.getDeviceToken(context);
            String agooAppKey = Config.getAgooAppKey(context);
            if (TextUtils.isEmpty(agooAppKey) || TextUtils.isEmpty(deviceToken) || context == null || TextUtils.isEmpty(str)) {
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
                }
                ALog.e(TAG, "setAlias param null", "appkey", agooAppKey, "deviceId", deviceToken, "alias", str, WPKFactory.INIT_KEY_CONTEXT, context);
                return;
            }
            try {
                if (mRequestListener == null) {
                    mRequestListener = new g02(context.getApplicationContext());
                }
                if (g02.b.a(str)) {
                    ALog.i(TAG, "setAlias already set", "alias", str);
                    if (iCallback != null) {
                        iCallback.onSuccess();
                    }
                    return;
                }
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
                if (OrangeAdapter.isRegIdSwitchEnableAndValid(context) || g02.b.b(context.getPackageName())) {
                    String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
                    GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
                    String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, NotifManager.getServiceId(context, serviceId), s4.e(agooAppKey, deviceToken, str), null));
                    if (TextUtils.isEmpty(sendRequest)) {
                        if (iCallback != null) {
                            iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                        }
                    } else if (iCallback != null) {
                        iCallback.extra = str;
                        mRequestListener.a.put(sendRequest, iCallback);
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "bindApp first!!");
                }
            } catch (Throwable th) {
                ALog.e(TAG, s4.JSON_CMD_SETALIAS, th, new Object[0]);
            }
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i) {
        ACCSClient.setEnvironment(context, i);
    }

    public static void setIsRegisterSuccess(boolean z) {
        isRegisterSuccess = z;
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(66001, MiPushClient.COMMAND_UNREGISTER, UtilityImpl.getDeviceId(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(66001, "bindAgoo", UtilityImpl.getDeviceId(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ff A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    public static void clickMessage(Context context, String str, String str2, int i, long j) {
        MsgDO msgDO;
        Object th;
        NotifManager notifManager = new NotifManager();
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "clickMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.evokeAppStatus = 1;
                boolean z = (i & 1) == 1;
                boolean z2 = (i & 2) == 2;
                boolean z3 = (i & 4) == 4;
                boolean z4 = (i & 8) == 8;
                boolean z5 = z ^ z2;
                msgDO2.isGlobalClick = z5;
                if (z5) {
                    ALog.e(TAG, "clickMessage", "isLaunchByAgoo", Boolean.valueOf(z2), "isEvokeByAgoo", Boolean.valueOf(z), "isComeFromBg", Boolean.valueOf(z3), "isSameDay", Boolean.valueOf(z4), "lastActiveTime", Long.valueOf(j));
                    msgDO2.lastActiveTime = j;
                    if ((z && z3) || z2) {
                        if (z4) {
                            msgDO2.evokeAppStatus = z2 ? 2 : 3;
                        } else {
                            msgDO2.evokeAppStatus = 4;
                        }
                    }
                }
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "8";
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, "8");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th2) {
                th = th2;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "clickMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            msgDO = null;
            ALog.e(TAG, "clickMessage,error=" + th, new Object[0]);
        }
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        if ((context.getApplicationInfo().flags & 2) != 0) {
                            ALog.isUseTlog = false;
                            anet.channel.util.ALog.i(false);
                        }
                        ALog.i(TAG, "register", "appKey", str2, Constants.KEY_CONFIG_TAG, str);
                        Context applicationContext = context.getApplicationContext();
                        Config.mAccsConfigTag = str;
                        Config.setAgooAppKey(context, str2);
                        AdapterUtilityImpl.mAgooAppSecret = str3;
                        if (!TextUtils.isEmpty(str3)) {
                            AdapterGlobalClientInfo.mSecurityType = 2;
                        }
                        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                        if (configByTag == null) {
                            new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                        } else {
                            AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                        }
                        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                        accsInstance.bindApp(applicationContext, str2, str3, str4, new a(applicationContext, context, iRegister, str2, str4, accsInstance));
                        return;
                    }
                }
            }
            ALog.e(TAG, "register params null", "appkey", str2, Constants.KEY_CONFIG_TAG, str);
        }
    }

    public static synchronized void removeAlias(Context context, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, s4.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                String deviceToken = Config.getDeviceToken(context);
                String pushAliasToken = Config.getPushAliasToken(context);
                String agooAppKey = Config.getAgooAppKey(context);
                if (!TextUtils.isEmpty(agooAppKey) && !TextUtils.isEmpty(deviceToken) && context != null) {
                    if (!TextUtils.isEmpty(pushAliasToken)) {
                        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
                        if (mRequestListener == null) {
                            mRequestListener = new g02(context.getApplicationContext());
                        }
                        String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
                        GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
                        String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, serviceId, s4.c(agooAppKey, deviceToken, pushAliasToken), null));
                        if (TextUtils.isEmpty(sendRequest)) {
                            if (iCallback != null) {
                                iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.a.put(sendRequest, iCallback);
                        }
                        return;
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
                }
                ALog.e(TAG, "removeAlias param null", "appkey", agooAppKey, "deviceId", deviceToken, s4.JSON_PUSH_USER_TOKEN, pushAliasToken, WPKFactory.INIT_KEY_CONTEXT, context);
            } catch (Throwable th) {
                ALog.e(TAG, s4.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
        }
    }
}
