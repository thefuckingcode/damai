package com.taobao.accs.init;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoConstants;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.analysis.v3.Tracer;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.intf.IReflect;
import com.taobao.mass.ServiceKey;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.control.NotifManager;
import tb.g02;
import tb.h9;

/* compiled from: Taobao */
public class Launcher_InitAccs implements Serializable {
    public static final Map<String, String> SERVICES;
    private static final String TAG = "Launcher_InitAccs";
    public static String defaultAppkey = "21646297";
    private static Class<?> keepAliveClazz;
    public static IAppReceiver mAppReceiver = new IAppReceiver() {
        /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass5 */

        @Override // com.taobao.accs.IAppReceiver
        public Map<String, String> getAllServices() {
            return Launcher_InitAccs.SERVICES;
        }

        @Override // com.taobao.accs.IAppReceiver
        public String getService(String str) {
            return Launcher_InitAccs.SERVICES.get(str);
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindApp(int i) {
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d(Launcher_InitAccs.TAG, "onBindApp,  errorCode:" + i, new Object[0]);
            }
            if (i == 200) {
                if (UtilityImpl.isMainProcess(Launcher_InitAccs.mContext)) {
                    if (Launcher_InitAccs.mRequestListener == null) {
                        g02 unused = Launcher_InitAccs.mRequestListener = new g02(Launcher_InitAccs.mContext);
                    }
                    GlobalClientInfo.getInstance(Launcher_InitAccs.mContext).registerListener(NotifManager.getServiceId(Launcher_InitAccs.mContext, TaobaoConstants.SERVICE_ID_DEVICECMD), Launcher_InitAccs.mRequestListener);
                }
                if (!TextUtils.isEmpty(Launcher_InitAccs.mUserId)) {
                    try {
                        ACCSClient.getAccsClient().bindUser(Launcher_InitAccs.mUserId, Launcher_InitAccs.mForceBindUser);
                        if (OrangeAdapter.isRegIdSwitchEnable(Launcher_InitAccs.mContext)) {
                            TaobaoRegister.setAlias(Launcher_InitAccs.mContext, Launcher_InitAccs.mUserId, new ICallback() {
                                /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass5.AnonymousClass1 */

                                @Override // com.taobao.agoo.ICallback
                                public void onFailure(String str, String str2) {
                                    if (ALog.isPrintLog(ALog.Level.D)) {
                                        ALog.d(Launcher_InitAccs.TAG, "setAlias fail, errDesc:" + str2 + " errorCode:" + str, new Object[0]);
                                    }
                                }

                                @Override // com.taobao.agoo.ICallback
                                public void onSuccess() {
                                    if (ALog.isPrintLog(ALog.Level.D)) {
                                        ALog.d(Launcher_InitAccs.TAG, "setAlias success", new Object[0]);
                                    }
                                }
                            });
                        }
                    } catch (AccsException e) {
                        ALog.e(Launcher_InitAccs.TAG, "bindUser", e, new Object[0]);
                    }
                    Launcher_InitAccs.mForceBindUser = false;
                } else if (ALog.isPrintLog(level)) {
                    ALog.d(Launcher_InitAccs.TAG, "onBindApp,  bindUser userid :" + Launcher_InitAccs.mUserId, new Object[0]);
                }
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindUser(String str, int i) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(Launcher_InitAccs.TAG, "onBindUser, userId:" + str + " errorCode:" + i, new Object[0]);
            }
            if (i == 300) {
                try {
                    ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                } catch (AccsException e) {
                    ALog.e(Launcher_InitAccs.TAG, "bindApp", e, new Object[0]);
                }
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onData(String str, String str2, byte[] bArr) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                StringBuilder sb = new StringBuilder();
                sb.append("onData,  userId:");
                sb.append(str);
                sb.append("dataId:");
                sb.append(str2);
                sb.append(" dataLen:");
                sb.append(bArr == null ? 0 : bArr.length);
                ALog.d(Launcher_InitAccs.TAG, sb.toString(), new Object[0]);
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onSendData(String str, int i) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(Launcher_InitAccs.TAG, "onSendData,  dataId:" + str + " errorCode:" + i, new Object[0]);
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindApp(int i) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(Launcher_InitAccs.TAG, "onUnbindApp,  errorCode:" + i, new Object[0]);
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindUser(int i) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(Launcher_InitAccs.TAG, "onUnbindUser, errorCode:" + i, new Object[0]);
            }
        }
    };
    public static String mAppkey;
    public static Context mContext;
    public static boolean mForceBindUser;
    public static boolean mIsInited;
    private static g02 mRequestListener;
    public static String mSid;
    public static String mTtid;
    public static String mUserId;
    private static Class<?> restrictionClazz;

    /* compiled from: Taobao */
    static class AccsLoginInfo implements ILoginInfo {
        AccsLoginInfo() {
        }

        @Override // com.taobao.accs.ILoginInfo
        public boolean getCommentUsed() {
            return false;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getEcode() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getHeadPicLink() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getNick() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSid() {
            return Launcher_InitAccs.mSid;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSsoToken() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getUserId() {
            return Launcher_InitAccs.mUserId;
        }
    }

    static {
        try {
            keepAliveClazz = Class.forName("com.taobao.keepalive.KeepAliveManager");
            restrictionClazz = Class.forName("com.taobao.keepalive.reflect.Restriction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        SERVICES = hashMap;
        hashMap.put(IRequestConst.IM, "com.taobao.tao.amp.remote.AccsReceiverCallback");
        hashMap.put(ServiceKey.POWER_MSG, "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        hashMap.put("pmmonitor", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        hashMap.put("cloudsync", "com.taobao.datasync.network.accs.AccsCloudSyncService");
        hashMap.put("acds", "com.taobao.acds.compact.AccsACDSService");
        hashMap.put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        hashMap.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        hashMap.put("agooTokenReport", "org.android.agoo.accs.AgooService");
        hashMap.put("AliLive", "com.taobao.playbudyy.gameplugin.danmu.DanmuCallbackService");
        hashMap.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        hashMap.put("tsla", "com.taobao.android.festival.accs.HomepageAccsMassService");
        hashMap.put("taobaoWaimaiAccsService", "com.taobao.takeout.order.detail.service.TakeoutOrderDetailACCSService");
        hashMap.put("login", "com.taobao.android.sso.v2.service.LoginAccsService");
        hashMap.put("ranger_abtest", "com.taobao.ranger3.RangerACCSService");
        hashMap.put("accs_poplayer", "com.taobao.tbpoplayer.AccsPopLayerService");
        hashMap.put("dm_abtest", "com.tmall.wireless.ant.accs.AntAccsService");
        hashMap.put("family", "com.taobao.family.FamilyAccsService");
        hashMap.put("taobao-dingtalk", "com.laiwang.protocol.android.LwpAccsService");
        hashMap.put("amp-sync", "com.taobao.message.init.accs.AccsReceiverCallback");
        hashMap.put("friend_invite_msg", "com.taobao.message.init.accs.TaoFriendAccsReceiverCallback");
        hashMap.put("slider", "com.taobao.slide.accs.SlideAccsService");
    }

    private void initADaemon(final Application application, int i) {
        if (Launcher_InitAgooLifecycle.mADaemonValid) {
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
                /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass1 */

                public void run() {
                    try {
                        Launcher_InitAgooLifecycle.adaemonClazz.getMethod("initialize", Context.class).invoke(null, application);
                    } catch (Exception e) {
                        ALog.e(Launcher_InitAccs.TAG, "adaemon initializeLifecycle error", e, new Object[0]);
                    }
                }
            }, (long) i, TimeUnit.SECONDS);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083  */
    private void initAccs(Application application, HashMap<String, Object> hashMap) throws Exception {
        String str;
        int i;
        Throwable th;
        boolean z;
        String str2 = null;
        try {
            int intValue = ((Integer) hashMap.get("envIndex")).intValue();
            mAppkey = (String) hashMap.get("onlineAppKey");
            if (intValue == 1) {
                mAppkey = (String) hashMap.get("preAppKey");
                i = 1;
            } else {
                if ((intValue == 3) || (intValue == 2)) {
                    mAppkey = (String) hashMap.get("dailyAppkey");
                    i = 2;
                } else {
                    i = 0;
                }
            }
            try {
                str = (String) hashMap.get("process");
                try {
                    mTtid = (String) hashMap.get("ttid");
                    mUserId = (String) hashMap.get("userId");
                    mSid = (String) hashMap.get("sid");
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str;
                }
            } catch (Throwable th3) {
                th = th3;
                ALog.e(TAG, "init get param error", th, new Object[0]);
                str = str2;
                if (TextUtils.isEmpty(mAppkey)) {
                }
                ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, "appkey", mAppkey, "mode", Integer.valueOf(i), "process", str);
                ACCSManager.setAppkey(application, mAppkey, i);
                ACCSClient.init(mContext, new AccsClientConfig.Builder().setAppKey(mAppkey).setConfigEnv(i).setTag("default").build());
            }
        } catch (Throwable th4) {
            th = th4;
            i = 0;
            ALog.e(TAG, "init get param error", th, new Object[0]);
            str = str2;
            if (TextUtils.isEmpty(mAppkey)) {
            }
            ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, "appkey", mAppkey, "mode", Integer.valueOf(i), "process", str);
            ACCSManager.setAppkey(application, mAppkey, i);
            ACCSClient.init(mContext, new AccsClientConfig.Builder().setAppKey(mAppkey).setConfigEnv(i).setTag("default").build());
        }
        if (TextUtils.isEmpty(mAppkey)) {
            ALog.e(TAG, "init get appkey null！！", new Object[0]);
            mAppkey = defaultAppkey;
        }
        ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, "appkey", mAppkey, "mode", Integer.valueOf(i), "process", str);
        ACCSManager.setAppkey(application, mAppkey, i);
        ACCSClient.init(mContext, new AccsClientConfig.Builder().setAppKey(mAppkey).setConfigEnv(i).setTag("default").build());
    }

    private void initAwcnBgConfig() {
        boolean isChannelModeEnable = OrangeAdapter.isChannelModeEnable();
        boolean isMainProcess = UtilityImpl.isMainProcess(mContext);
        boolean isAllWeather = ConnectionServiceManager.getInstance().isAllWeather();
        ALog.e(TAG, "initAwcnBgConfig", "isChannelMode", Boolean.valueOf(isChannelModeEnable), "isMainProcess", Boolean.valueOf(isMainProcess), "isAllWeather", Boolean.valueOf(isAllWeather));
        if (!isChannelModeEnable || (isMainProcess && !isAllWeather)) {
            h9.V(true);
        }
    }

    private void initSecurity() {
    }

    private void launchInChannel() throws Exception {
        if (OrangeAdapter.isChannelInitOptimizeEnable(mContext)) {
            GlobalClientInfo.TAG_SERVICES.put("default", mAppReceiver.getAllServices());
            Intent intent = new Intent(Constants.ACTION_START_SERVICE);
            intent.putExtra("appKey", mAppkey);
            intent.putExtra("ttid", mTtid);
            intent.putExtra("packageName", mContext.getPackageName());
            intent.putExtra("app_sercet", "");
            intent.putExtra("mode", AccsClientConfig.mEnv);
            intent.putExtra(Config.PROPERTY_APP_KEY, Config.getAgooAppKey(GlobalClientInfo.getContext()));
            intent.putExtra(Constants.KEY_CONFIG_TAG, "default");
            intent.putExtra("start", true);
            intent.setClassName(mContext.getPackageName(), AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(mContext, intent);
        } else {
            ACCSClient.getAccsClient().bindApp(mTtid, mAppReceiver);
        }
        if (OrangeAdapter.isSetMaxThreadsEnable()) {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
                /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass3 */

                public void run() {
                    ARanger.setMaxThread(Launcher_InitAccs.restrictionClazz != null ? new IReflect() {
                        /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass3.AnonymousClass1 */

                        public Method getHideMethod(Class cls, String str, Class... clsArr) {
                            try {
                                return (Method) Launcher_InitAccs.restrictionClazz.getMethod("getDeclaredMethod", Object.class, String.class, Class[].class).invoke(null, cls, str, clsArr);
                            } catch (Exception e) {
                                ALog.e(Launcher_InitAccs.TAG, "get Restriction method error", e, new Object[0]);
                                return null;
                            }
                        }
                    } : null, 30);
                }
            });
        }
        if (keepAliveClazz != null && OrangeAdapter.isKeepAliveInit()) {
            try {
                keepAliveClazz.getMethod(UCCore.LEGACY_EVENT_INIT, Context.class).invoke(null, mContext);
            } catch (Exception e) {
                ALog.e(TAG, "keepAlive module initialize error", e, new Object[0]);
            }
        }
    }

    private void launchInMain() {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass2 */

            public void run() {
                try {
                    if (OrangeAdapter.isChannelModeEnable() && !ConnectionServiceManager.getInstance().isAllWeather()) {
                        GlobalClientInfo.getInstance(Launcher_InitAccs.mContext).recoverListener("default");
                    }
                    ACCSClient.getAccsClient().setLoginInfo(new AccsLoginInfo());
                    ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                    ForeBackManager.getManager().reportSaveClickMessage();
                } catch (AccsException e) {
                    ALog.e(Launcher_InitAccs.TAG, "bindApp", e, new Object[0]);
                }
            }
        });
    }

    private void traceAccs() {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
            /* class com.taobao.accs.init.Launcher_InitAccs.AnonymousClass4 */

            public void run() {
                String str;
                try {
                    if (!Launcher_InitAgooLifecycle.hasConnected) {
                        if (!ACCSClient.getAccsClient().isAccsConnected()) {
                            str = "fail";
                            Tracer.getInstance().buildSpan("accs", "connect").start().setTag("status", str).finish();
                        }
                    }
                    str = "success";
                    Tracer.getInstance().buildSpan("accs", "connect").start().setTag("status", str).finish();
                } catch (Throwable th) {
                    ALog.e(Launcher_InitAccs.TAG, "traceAccs error", th, new Object[0]);
                }
            }
        }, 20, TimeUnit.SECONDS);
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        initImpl(application, hashMap, 0);
        if (UtilityImpl.isMainProcess(application)) {
            traceAccs();
        }
    }

    public void initImpl(Application application, HashMap<String, Object> hashMap, int i) {
        ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, new Object[0]);
        try {
            if (!mIsInited || !ConnectionServiceManager.getInstance().isAllWeather()) {
                Context applicationContext = application.getApplicationContext();
                mContext = applicationContext;
                UtilityImpl.debug(applicationContext);
                initADaemon(application, i);
                initSecurity();
                initAwcnBgConfig();
                initAccs(application, hashMap);
                if (UtilityImpl.isMainProcess(mContext)) {
                    mIsInited = true;
                    launchInMain();
                } else if (UtilityImpl.isChannelProcess(mContext)) {
                    launchInChannel();
                }
            } else {
                ALog.e(TAG, "init return", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
        }
    }
}
