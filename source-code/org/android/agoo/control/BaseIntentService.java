package org.android.agoo.control;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import tb.jl1;

/* compiled from: Taobao */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static boolean isBinded = false;
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private Context mContext = null;
    private MessageService messageService;
    private Messenger messenger = new Messenger(new Handler() {
        /* class org.android.agoo.control.BaseIntentService.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(BaseIntentService.TAG, "handleMessage on receive msg", "msg", message.toString());
                final Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(BaseIntentService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    ThreadPoolExecutorFactory.execute(new Runnable() {
                        /* class org.android.agoo.control.BaseIntentService.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            BaseIntentService.this.onHandleIntent(intent);
                        }
                    });
                }
            }
        }
    });
    private NotifManager notifyManager;

    private final String getTrace(Context context, long j) {
        String str = null;
        String str2 = TextUtils.isEmpty(null) ? "unknow" : null;
        if (TextUtils.isEmpty(null)) {
            str = "unknow";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append("|");
        stringBuffer.append(j);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(str2);
        stringBuffer.append("|");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02d7 A[Catch:{ all -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[Catch:{ all -> 0x035d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013d A[Catch:{ all -> 0x035d }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x020c A[Catch:{ all -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x035b }] */
    private final void handleRemoteMessage(Context context, Intent intent) {
        String str;
        String str2;
        Throwable th;
        String str3;
        String str4;
        TaoBaseService.ExtraInfo extraInfo;
        String str5;
        String str6;
        String str7;
        CharSequence charSequence;
        int i;
        String str8;
        String stringExtra;
        Throwable th2;
        Throwable th3;
        Object th4;
        try {
            String stringExtra2 = intent.getStringExtra("id");
            String stringExtra3 = intent.getStringExtra("body");
            String stringExtra4 = intent.getStringExtra("type");
            String stringExtra5 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra6 = intent.getStringExtra("report");
            String stringExtra7 = intent.getStringExtra(AgooConstants.MESSAGE_ENCRYPTED);
            String stringExtra8 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            try {
                String stringExtra9 = intent.getStringExtra(AgooConstants.MESSAGE_ORI);
                try {
                    str3 = "messageId=";
                    try {
                        getTrace(context, Long.valueOf(intent.getLongExtra(AgooConstants.MESSAGE_TRACE, -1)).longValue());
                        Bundle bundleExtra = intent.getBundleExtra(AgooConstants.MESSAGE_AGOO_BUNDLE);
                        extraInfo = bundleExtra != null ? (TaoBaseService.ExtraInfo) bundleExtra.getSerializable(AgooConstants.MESSAGE_ACCS_EXTRA) : null;
                        try {
                            str4 = intent.getStringExtra("source");
                            try {
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = "oldsdk";
                                }
                                str6 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_APPKEY);
                                str5 = TAG;
                            } catch (Throwable th5) {
                                th4 = th5;
                                try {
                                    str5 = TAG;
                                    ALog.e(str5, "_trace,t=" + th4, new Object[0]);
                                    str6 = null;
                                    extraInfo = extraInfo;
                                    if (ALog.isPrintLog(ALog.Level.I)) {
                                    }
                                    MsgDO msgDO = new MsgDO();
                                    msgDO.msgIds = stringExtra2;
                                    msgDO.extData = stringExtra8;
                                    msgDO.messageSource = stringExtra5;
                                    msgDO.msgStatus = "4";
                                    msgDO.reportStr = stringExtra6;
                                    msgDO.fromPkg = str4;
                                    msgDO.fromAppkey = str6;
                                    msgDO.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                                    msgDO.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                                    msgDO.triggerType = OrangeAdapter.getADaemonTriggerType(this.mContext);
                                    if (!TextUtils.isEmpty(stringExtra3)) {
                                    }
                                    if (TextUtils.isEmpty(stringExtra3)) {
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                                    str2 = "accs";
                                    AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
                                }
                            }
                        } catch (Throwable th7) {
                            th4 = th7;
                            str4 = null;
                            str5 = TAG;
                            ALog.e(str5, "_trace,t=" + th4, new Object[0]);
                            str6 = null;
                            extraInfo = extraInfo;
                            if (ALog.isPrintLog(ALog.Level.I)) {
                            }
                            MsgDO msgDO2 = new MsgDO();
                            msgDO2.msgIds = stringExtra2;
                            msgDO2.extData = stringExtra8;
                            msgDO2.messageSource = stringExtra5;
                            msgDO2.msgStatus = "4";
                            msgDO2.reportStr = stringExtra6;
                            msgDO2.fromPkg = str4;
                            msgDO2.fromAppkey = str6;
                            msgDO2.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                            msgDO2.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                            msgDO2.triggerType = OrangeAdapter.getADaemonTriggerType(this.mContext);
                            if (!TextUtils.isEmpty(stringExtra3)) {
                            }
                            if (TextUtils.isEmpty(stringExtra3)) {
                            }
                        }
                    } catch (Throwable th8) {
                        th4 = th8;
                        extraInfo = null;
                        str4 = null;
                        str5 = TAG;
                        ALog.e(str5, "_trace,t=" + th4, new Object[0]);
                        str6 = null;
                        extraInfo = extraInfo;
                        if (ALog.isPrintLog(ALog.Level.I)) {
                        }
                        MsgDO msgDO22 = new MsgDO();
                        msgDO22.msgIds = stringExtra2;
                        msgDO22.extData = stringExtra8;
                        msgDO22.messageSource = stringExtra5;
                        msgDO22.msgStatus = "4";
                        msgDO22.reportStr = stringExtra6;
                        msgDO22.fromPkg = str4;
                        msgDO22.fromAppkey = str6;
                        msgDO22.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                        msgDO22.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                        msgDO22.triggerType = OrangeAdapter.getADaemonTriggerType(this.mContext);
                        if (!TextUtils.isEmpty(stringExtra3)) {
                        }
                        if (TextUtils.isEmpty(stringExtra3)) {
                        }
                    }
                } catch (Throwable th9) {
                    th4 = th9;
                    str3 = "messageId=";
                    extraInfo = null;
                    str4 = null;
                    str5 = TAG;
                    ALog.e(str5, "_trace,t=" + th4, new Object[0]);
                    str6 = null;
                    extraInfo = extraInfo;
                    if (ALog.isPrintLog(ALog.Level.I)) {
                    }
                    MsgDO msgDO222 = new MsgDO();
                    msgDO222.msgIds = stringExtra2;
                    msgDO222.extData = stringExtra8;
                    msgDO222.messageSource = stringExtra5;
                    msgDO222.msgStatus = "4";
                    msgDO222.reportStr = stringExtra6;
                    msgDO222.fromPkg = str4;
                    msgDO222.fromAppkey = str6;
                    msgDO222.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                    msgDO222.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                    msgDO222.triggerType = OrangeAdapter.getADaemonTriggerType(this.mContext);
                    if (!TextUtils.isEmpty(stringExtra3)) {
                    }
                    if (TextUtils.isEmpty(stringExtra3)) {
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str5, "handleRemoteMessage", "message", stringExtra3, "source", stringExtra5, RemoteMessageConst.MSGID, stringExtra2, "utdid", AdapterUtilityImpl.getDeviceId(context), "fromPkg", str4, AgooConstants.MESSAGE_FROM_APPKEY, str6);
                }
                MsgDO msgDO2222 = new MsgDO();
                msgDO2222.msgIds = stringExtra2;
                msgDO2222.extData = stringExtra8;
                msgDO2222.messageSource = stringExtra5;
                msgDO2222.msgStatus = "4";
                msgDO2222.reportStr = stringExtra6;
                msgDO2222.fromPkg = str4;
                msgDO2222.fromAppkey = str6;
                msgDO2222.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                msgDO2222.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                msgDO2222.triggerType = OrangeAdapter.getADaemonTriggerType(this.mContext);
                if (!TextUtils.isEmpty(stringExtra3)) {
                    if (Integer.toString(4).equals(stringExtra7)) {
                        ALog.i(str5, "message is encrypted, attemp to decrypt msg", new Object[0]);
                        stringExtra3 = AgooFactory.parseEncryptedMsg(stringExtra3);
                        if (TextUtils.isEmpty(stringExtra3)) {
                            msgDO2222.errorCode = "22";
                            this.notifyManager.handlerACKMessage(msgDO2222, extraInfo);
                            return;
                        }
                    } else {
                        ALog.e(str5, "msg encrypted flag not exist~~", new Object[0]);
                        try {
                            msgDO2222.errorCode = "24";
                            this.notifyManager.report(msgDO2222, extraInfo);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                }
                if (TextUtils.isEmpty(stringExtra3)) {
                    try {
                        msgDO2222.errorCode = "21";
                        this.notifyManager.report(msgDO2222, extraInfo);
                    } catch (Throwable unused2) {
                    }
                    ALog.e(str5, "handleMessage--->[null]", new Object[0]);
                    return;
                }
                intent.putExtra("body", stringExtra3);
                try {
                    this.notifyManager.report(msgDO2222, extraInfo);
                    this.messageService.addAccsMessage(stringExtra2, stringExtra9, "0");
                    UTMini instance = UTMini.getInstance();
                    String[] strArr = new String[2];
                    strArr[0] = null;
                    StringBuilder sb = new StringBuilder();
                    str7 = str3;
                    try {
                        sb.append(str7);
                        sb.append(msgDO2222.msgIds);
                        strArr[1] = sb.toString();
                        instance.commitEvent(19999, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_ID, (Object) null, (Object) null, strArr);
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                        try {
                            AppMonitorAdapter.commitCount(str2, str, "arrive", 0.0d);
                        } catch (Throwable th10) {
                            th3 = th10;
                        }
                    } catch (Throwable th11) {
                        th3 = th11;
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                        try {
                            ALog.e(str5, "report message Throwable--->t=" + th3.toString(), new Object[0]);
                            if (this.messageService.hasMessageDuplicate(stringExtra2)) {
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
                        }
                    }
                } catch (Throwable th13) {
                    th3 = th13;
                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                    str2 = "accs";
                    str7 = str3;
                    ALog.e(str5, "report message Throwable--->t=" + th3.toString(), new Object[0]);
                    if (this.messageService.hasMessageDuplicate(stringExtra2)) {
                    }
                }
                if (this.messageService.hasMessageDuplicate(stringExtra2)) {
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(str5, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra2 + ",utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                    }
                    AppMonitorAdapter.commitCount(str2, str, "arrive_dup", 0.0d);
                    return;
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str5, "handleMessage--->[" + stringExtra3 + "],[" + stringExtra5 + jl1.ARRAY_END_STR, new Object[0]);
                }
                try {
                    String stringExtra10 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                    if (!TextUtils.isEmpty(stringExtra10)) {
                        charSequence = "1";
                        try {
                            if (TextUtils.equals(stringExtra10, charSequence)) {
                                if (this.messageService.hasMessageDuplicate(stringExtra2, stringExtra3.hashCode())) {
                                    AppMonitorAdapter.commitCount(str2, str, "arrive_dupbody", 0.0d);
                                    return;
                                }
                            }
                        } catch (Throwable th14) {
                            th2 = th14;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e(str5, "hasMessageDuplicate message,e=" + th2.toString(), new Object[0]);
                            }
                            i = -1;
                            i = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                            String str9 = "";
                            stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                            if (!TextUtils.isEmpty(stringExtra)) {
                            }
                            str8 = stringExtra4;
                            str9 = getClass().getName();
                            this.messageService.addMessage(stringExtra2, stringExtra3, str8, i);
                            UTMini.getInstance().commitEvent(19999, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str7 + msgDO2222.msgIds);
                            AppMonitorAdapter.commitCount(str2, str, "arrive_real_" + str9, 0.0d);
                            try {
                                intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                            } catch (Exception e) {
                                ALog.e(str5, "get NetPerformanceMonitor Error:", e, new Object[0]);
                            }
                            onMessage(context, intent);
                            return;
                        }
                    } else {
                        charSequence = "1";
                    }
                } catch (Throwable th15) {
                    th2 = th15;
                    charSequence = "1";
                    if (ALog.isPrintLog(ALog.Level.E)) {
                    }
                    i = -1;
                    i = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                    String str92 = "";
                    stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                    if (!TextUtils.isEmpty(stringExtra)) {
                    }
                    str8 = stringExtra4;
                    str92 = getClass().getName();
                    this.messageService.addMessage(stringExtra2, stringExtra3, str8, i);
                    UTMini.getInstance().commitEvent(19999, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str7 + msgDO2222.msgIds);
                    AppMonitorAdapter.commitCount(str2, str, "arrive_real_" + str92, 0.0d);
                    intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                    onMessage(context, intent);
                    return;
                }
                i = -1;
                try {
                    i = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                } catch (Throwable unused3) {
                }
                String str922 = "";
                try {
                    stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                    if (!TextUtils.isEmpty(stringExtra) || !TextUtils.equals(stringExtra, charSequence)) {
                        str8 = stringExtra4;
                        str922 = getClass().getName();
                        this.messageService.addMessage(stringExtra2, stringExtra3, str8, i);
                        UTMini.getInstance().commitEvent(19999, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str7 + msgDO2222.msgIds);
                        AppMonitorAdapter.commitCount(str2, str, "arrive_real_" + str922, 0.0d);
                        intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                        onMessage(context, intent);
                        return;
                    }
                    str8 = stringExtra4;
                    try {
                        this.messageService.addMessage(stringExtra2, stringExtra3, str8, i);
                        AppMonitorAdapter.commitCount(str2, str, "arrive_test", 0.0d);
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    str8 = stringExtra4;
                }
            } catch (Throwable th16) {
                th = th16;
                str2 = "accs";
                str = BaseMonitor.COUNT_AGOO_ARRIVE;
                AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
            }
        } catch (Throwable th17) {
            th = th17;
            str = BaseMonitor.COUNT_AGOO_ARRIVE;
            str2 = "accs";
            AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
        }
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent != null && context != null) {
            String str = null;
            Uri data = intent.getData();
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (!TextUtils.isEmpty(str)) {
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + str, new Object[0]);
                }
                if (!booleanExtra) {
                    this.notifyManager.doUninstall(str, booleanExtra);
                }
            }
        }
    }

    public static final void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    public IBinder onBind(Intent intent) {
        if (!isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(getApplication(), getClass()), new ServiceConnection() {
                /* class org.android.agoo.control.BaseIntentService.AnonymousClass2 */

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                public void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        }
        return this.messenger.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class org.android.agoo.control.BaseIntentService.AnonymousClass3 */

            public void run() {
                AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
                BaseIntentService.this.notifyManager = new NotifManager();
                BaseIntentService.this.notifyManager.init(BaseIntentService.this.getApplicationContext());
                BaseIntentService.this.messageService = new MessageService();
                BaseIntentService.this.messageService.init(BaseIntentService.this.getApplicationContext());
                BaseIntentService.this.agooFactory = new AgooFactory();
                BaseIntentService.this.agooFactory.init(BaseIntentService.this.getApplicationContext(), BaseIntentService.this.notifyManager, BaseIntentService.this.messageService);
            }
        });
    }

    /* access modifiers changed from: protected */
    public abstract void onError(Context context, String str);

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                String agooCommand = IntentUtil.getAgooCommand(this.mContext);
                String thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
                ALog.i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
                try {
                    if (TextUtils.equals(action, agooCommand)) {
                        String stringExtra = intent.getStringExtra("command");
                        ALog.d(TAG, "actionCommand --->[" + stringExtra + jl1.ARRAY_END_STR, new Object[0]);
                        if (TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                            onUserCommand(this.mContext, intent);
                        }
                    } else if (TextUtils.equals(action, thirdPushCommand)) {
                        String stringExtra2 = intent.getStringExtra("command");
                        String stringExtra3 = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                        if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                            this.notifyManager.reportThirdPushToken(stringExtra3, AssistConstant.TOKEN_TYPE_XM, false);
                        } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                            ALog.d(TAG, "HW_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra3, AssistConstant.TOKEN_TYPE_HW, false);
                        } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                            ALog.i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra3, "gcm", false);
                        } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HONORPUSHID_REPORT)) {
                            ALog.i(TAG, "HONOR_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra3, "HONOR_TOKEN", false);
                        }
                    } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                        handleRemoteMessage(this.mContext, intent);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        handleRemovePackage(this.mContext, intent);
                    } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION) || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        try {
                            ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.isReportCacheMsg(this.mContext), new Object[0]);
                            if (Config.isReportCacheMsg(this.mContext) && AdapterUtilityImpl.isNetworkConnected(this.mContext)) {
                                Config.clearReportTimes(this.mContext);
                                this.agooFactory.reportCacheMsg();
                                this.messageService.deleteCacheMessage();
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(TAG, "is clear all msg=" + Config.isClearTime(this.mContext, currentTimeMillis), new Object[0]);
                            }
                            if (Config.isClearTime(this.mContext, currentTimeMillis)) {
                                Config.setClearTimes(this.mContext, currentTimeMillis);
                                this.messageService.deleteCacheMessage();
                            }
                        } catch (Throwable th) {
                            ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
                    throw th2;
                }
                AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onMessage(Context context, Intent intent);

    /* access modifiers changed from: protected */
    public abstract void onRegistered(Context context, String str);

    public int onStartCommand(final Intent intent, int i, int i2) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class org.android.agoo.control.BaseIntentService.AnonymousClass4 */

            public void run() {
                BaseIntentService.this.onHandleIntent(intent);
            }
        });
        return 2;
    }

    /* access modifiers changed from: protected */
    public void onUserCommand(Context context, Intent intent) {
    }
}
