package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AccsHandler;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.exception.IPCException;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class MsgDistribute {
    private static final String KEY_ROUTING_ACK = "routingAck";
    private static final String KEY_ROUTING_MSG = "routingMsg";
    private static final long MIN_SPACE = 5242880;
    private static final String TAG = "MsgDistribute";
    private static volatile MsgDistribute instance;
    private static Set<String> mRoutingDataIds;

    public static void distribMessage(final Context context, final Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra2 = intent.getStringExtra("serviceId");
            if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(stringExtra2)) {
                ALog.e(TAG, "distribMessage", Constants.KEY_DATA_ID, stringExtra);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
                /* class com.taobao.accs.data.MsgDistribute.AnonymousClass1 */

                public void run() {
                    MsgDistribute.getInstance().distribute(context, intent);
                }
            });
        } catch (Throwable th) {
            ALog.e(TAG, "distribMessage", th, new Object[0]);
            UTMini instance2 = UTMini.getInstance();
            instance2.commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf((int) Constants.SDK_VERSION_CODE));
        }
    }

    public static MsgDistribute getInstance() {
        if (instance == null) {
            synchronized (MsgDistribute.class) {
                if (instance == null) {
                    instance = new MsgDistribute();
                }
            }
        }
        return instance;
    }

    private boolean handleAgooTrigger(Context context, String str, Intent intent) {
        JSONArray jSONArray;
        if (!str.equals("agooControl")) {
            return false;
        }
        try {
            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
            if (!(byteArrayExtra == null || byteArrayExtra.length == 0)) {
                String str2 = new String(byteArrayExtra, "utf-8");
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.i(TAG, "handle agooControl message", "message", str2);
                }
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    boolean z = jSONObject.getBoolean(Constants.KEY_CONTROL);
                    OrangeAdapter.saveConfigToSP(context, Constants.KEY_CONTROL, z);
                    if (!(!z || (jSONArray = jSONObject.getJSONArray(Constants.KEY_PACKAGES)) == null || jSONArray.length() == 0)) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            NoTraceTriggerHelper.trigger(context, jSONArray.getString(i), 4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ALog.e(TAG, "handleBusinessMsg process agooControl message error", e, new Object[0]);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    private void handleControlMsg(Context context, Intent intent, String str, String str2, int i, String str3, String str4, String str5, IAppReceiver iAppReceiver, int i2) {
        int i3;
        int i4;
        IPCException e;
        String str6;
        String str7;
        Throwable th;
        if (ALog.isPrintLog(ALog.Level.D)) {
            Object[] objArr = new Object[12];
            objArr[0] = Constants.KEY_CONFIG_TAG;
            objArr[1] = str;
            objArr[2] = Constants.KEY_DATA_ID;
            objArr[3] = str5;
            objArr[4] = "serviceId";
            objArr[5] = str4;
            objArr[6] = "command";
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "errorCode";
            objArr[9] = Integer.valueOf(i2);
            objArr[10] = "appReceiver";
            objArr[11] = iAppReceiver == null ? null : iAppReceiver.getClass().getName();
            ALog.d(TAG, "handleControlMsg", objArr);
        }
        if (iAppReceiver != null) {
            if (i == 1) {
                try {
                    if (iAppReceiver instanceof IAppReceiverV1) {
                        ((IAppReceiverV1) iAppReceiver).onBindApp(i2, Config.getDeviceToken(context));
                    } else {
                        iAppReceiver.onBindApp(i2);
                    }
                } catch (IPCException e2) {
                    i3 = 0;
                    ALog.e(TAG, "handleControlMsg onBindApp", e2, new Object[0]);
                }
            } else if (i == 2) {
                if (i2 == 200) {
                    UtilityImpl.disableService(context);
                }
                try {
                    iAppReceiver.onUnbindApp(i2);
                } catch (IPCException e3) {
                    ALog.e(TAG, "handleControlMsg onUnbindApp", e3, new Object[0]);
                }
            } else if (i == 3) {
                try {
                    iAppReceiver.onBindUser(str3, i2);
                } catch (IPCException e4) {
                    ALog.e(TAG, "handleControlMsg onBindUser", e4, new Object[0]);
                }
            } else if (i == 4) {
                try {
                    iAppReceiver.onUnbindUser(i2);
                } catch (IPCException e5) {
                    ALog.e(TAG, "handleControlMsg onUnbindUser", e5, new Object[0]);
                }
            } else if (i != 100) {
                if (i == 101 && TextUtils.isEmpty(str4)) {
                    ALog.d(TAG, "handleControlMsg serviceId isEmpty", new Object[0]);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                    if (byteArrayExtra != null) {
                        try {
                            iAppReceiver.onData(str3, str5, byteArrayExtra);
                        } catch (IPCException e6) {
                            ALog.e(TAG, "handleControlMsg onData", e6, new Object[0]);
                        }
                    }
                }
            } else if (TextUtils.isEmpty(str4)) {
                try {
                    iAppReceiver.onSendData(str5, i2);
                } catch (IPCException e7) {
                    ALog.e(TAG, "handleControlMsg onSendData", e7, new Object[0]);
                }
            }
        }
        i3 = 0;
        if (i == 1 && GlobalClientInfo.mAgooAppReceiver != null && str2 != null && str2.equals(Config.getAgooAppKey(context))) {
            ALog.d(TAG, "handleControlMsg agoo receiver onBindApp", new Object[i3]);
            try {
                if (intent.getByteArrayExtra("data") != null) {
                    try {
                        str7 = null;
                        try {
                            str6 = JsonUtility.getString(new JSONObject(new String(intent.getByteArrayExtra("data"))), "deviceToken", null);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str7 = null;
                        i4 = 0;
                        try {
                            ALog.e(TAG, "handleControlMsg onBindApp", th, new Object[0]);
                            str6 = str7;
                            IAgooAppReceiver iAgooAppReceiver = GlobalClientInfo.mAgooAppReceiver;
                            if (OrangeAdapter.isRegIdSwitchEnableAndValid(context)) {
                            }
                            iAgooAppReceiver.onBindApp(i2, str6);
                        } catch (IPCException e8) {
                            e = e8;
                            ALog.e(TAG, "handleControlMsg onBindApp", e, new Object[i4]);
                        }
                    }
                } else {
                    str7 = null;
                    str6 = str7;
                }
                IAgooAppReceiver iAgooAppReceiver2 = GlobalClientInfo.mAgooAppReceiver;
                if (OrangeAdapter.isRegIdSwitchEnableAndValid(context)) {
                    str6 = Config.getDeviceToken(context);
                }
                iAgooAppReceiver2.onBindApp(i2, str6);
            } catch (IPCException e9) {
                e = e9;
                i4 = 0;
                ALog.e(TAG, "handleControlMsg onBindApp", e, new Object[i4]);
            }
        } else if (iAppReceiver == null && i != 100 && i != 104 && i != 103) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str4, "1", "appReceiver null return");
            UTMini.getInstance().commitEvent(66001, "MsgToBuss7", "commandId=" + i, "serviceId=" + str4 + " errorCode=" + i2 + " dataId=" + str5, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
        }
    }

    private boolean handleRoutingMsg(Context context, final Intent intent, final String str, final String str2, String str3) {
        AccsClientConfig configByTag = !TextUtils.isEmpty(str3) ? AccsClientConfig.getConfigByTag(str3) : null;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        try {
            NoTraceTriggerHelper.trigger(context, intent.getPackage(), 6);
            if (configByTag != null && configByTag.isPullUpEnable()) {
                ALog.e(TAG, "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), "serviceId", str2);
                intent.setClassName(intent.getPackage(), AdapterUtilityImpl.msgService);
                intent.putExtra(KEY_ROUTING_MSG, true);
                intent.putExtra("packageName", context.getPackageName());
                IntentDispatch.dispatchIntent(context, intent);
                if (mRoutingDataIds == null) {
                    mRoutingDataIds = new HashSet();
                }
                mRoutingDataIds.add(str);
                ThreadPoolExecutorFactory.schedule(new Runnable() {
                    /* class com.taobao.accs.data.MsgDistribute.AnonymousClass2 */

                    public void run() {
                        if (MsgDistribute.mRoutingDataIds != null && MsgDistribute.mRoutingDataIds.contains(str)) {
                            ALog.e(MsgDistribute.TAG, "routing msg time out, try election", Constants.KEY_DATA_ID, str, "serviceId", str2);
                            MsgDistribute.mRoutingDataIds.remove(str);
                            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + intent.getPackage());
                        }
                    }
                }, 10, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th.toString());
            ALog.e(TAG, "routing msg error, try election", th, "serviceId", str2, Constants.KEY_DATA_ID, str);
        }
        return true;
    }

    private boolean handleRoutingMsgAck(Context context, Intent intent, String str, String str2) {
        boolean z;
        boolean booleanExtra = intent.getBooleanExtra(KEY_ROUTING_ACK, false);
        boolean booleanExtra2 = intent.getBooleanExtra(KEY_ROUTING_MSG, false);
        if (booleanExtra) {
            ALog.e(TAG, "recieve routiong ack", Constants.KEY_DATA_ID, str, "serviceId", str2);
            Set<String> set = mRoutingDataIds;
            if (set != null) {
                set.remove(str);
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            z = true;
        } else {
            z = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent.getStringExtra("packageName");
                ALog.e(TAG, "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", stringExtra, "serviceId", str2);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra("command", 106);
                intent2.setClassName(stringExtra, AdapterUtilityImpl.channelService);
                intent2.putExtra(KEY_ROUTING_ACK, true);
                intent2.putExtra("packageName", stringExtra);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                IntentDispatch.dispatchIntent(context, intent2);
            } catch (Throwable th) {
                ALog.e(TAG, "send routing ack", th, "serviceId", str2);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean checkSpace(int i, String str, String str2) {
        if (i != 100 && !GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            long usableSpace = UtilityImpl.getUsableSpace();
            if (usableSpace != -1 && usableSpace <= 5242880) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "space low");
                ALog.e(TAG, "user space low, don't distribute", "size", Long.valueOf(usableSpace), "serviceId", str);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b7, code lost:
        if (com.taobao.accs.common.Constants.IMPAAS.equals(r9) != false) goto L_0x01b9;
     */
    public void distribute(Context context, Intent intent) {
        String str;
        Object obj;
        char c;
        String str2;
        String str3;
        int i;
        int i2;
        Throwable th;
        int i3;
        String str4;
        System.currentTimeMillis();
        String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
        String stringExtra2 = intent.getStringExtra("serviceId");
        String action = intent.getAction();
        boolean isEmpty = TextUtils.isEmpty(action);
        Integer valueOf = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        if (isEmpty) {
            ALog.e(TAG, "action null", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss9", "action null", valueOf);
            return;
        }
        try {
            if (TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
                int intExtra = intent.getIntExtra("command", -1);
                try {
                    String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
                    int intExtra2 = intent.getIntExtra("errorCode", 0);
                    String stringExtra4 = intent.getStringExtra("appKey");
                    String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                    if (intent.getPackage() == null) {
                        try {
                            intent.setPackage(context.getPackageName());
                        } catch (Throwable th2) {
                            th = th2;
                            i = intExtra;
                            obj = "serviceId";
                            str = stringExtra;
                            str2 = "accs";
                            i2 = 4;
                            c = 2;
                        }
                    }
                    if ("accs".equals(stringExtra2) || Constants.IMPAAS.equals(stringExtra2)) {
                        ALog.e(TAG, "distribute start", "appkey", stringExtra4, com.youku.arch.v3.core.Constants.CONFIG, stringExtra5);
                    } else {
                        ALog.d(TAG, "distribute start", "appkey", stringExtra4, com.youku.arch.v3.core.Constants.CONFIG, stringExtra5);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!handleRoutingMsgAck(context, intent, stringExtra, stringExtra2)) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (intExtra < 0) {
                            ALog.e(TAG, "command error:" + intExtra, "serviceId", stringExtra2);
                            return;
                        }
                        c = 2;
                        try {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                            long currentTimeMillis5 = System.currentTimeMillis();
                            if (!checkSpace(intExtra, stringExtra2, stringExtra)) {
                                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                                long currentTimeMillis7 = System.currentTimeMillis();
                                i3 = intExtra;
                                try {
                                    if (!handleRoutingMsg(context, intent, stringExtra, stringExtra2, stringExtra5)) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                                        long currentTimeMillis9 = System.currentTimeMillis();
                                        Map<String, IAppReceiver> appReceiver = GlobalClientInfo.getInstance(context).getAppReceiver();
                                        IAppReceiver iAppReceiver = null;
                                        if (TextUtils.isEmpty(stringExtra5) || appReceiver == null) {
                                            str4 = stringExtra5;
                                        } else {
                                            str4 = stringExtra5;
                                            try {
                                                iAppReceiver = appReceiver.get(str4);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                obj = "serviceId";
                                                str = stringExtra;
                                                str2 = "accs";
                                                i = i3;
                                                i2 = 4;
                                            }
                                        }
                                        if (!handleMsgInChannelProcess(context, stringExtra2, stringExtra, intent, iAppReceiver)) {
                                            long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis9;
                                            long currentTimeMillis11 = System.currentTimeMillis();
                                            str2 = "accs";
                                            str3 = TAG;
                                            obj = "serviceId";
                                            str = stringExtra;
                                            try {
                                                handleControlMsg(context, intent, str4, stringExtra4, i3, stringExtra3, stringExtra2, stringExtra, iAppReceiver, intExtra2);
                                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis11;
                                                if (!TextUtils.isEmpty(stringExtra2)) {
                                                    stringExtra2 = stringExtra2;
                                                    if (!ALog.isPrintLog(ALog.Level.D)) {
                                                        try {
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            i = i3;
                                                            i2 = 4;
                                                            Object[] objArr = new Object[i2];
                                                            objArr[0] = Constants.KEY_DATA_ID;
                                                            objArr[1] = str;
                                                            objArr[c] = obj;
                                                            objArr[3] = stringExtra2;
                                                            ALog.e(str3, "distribMessage", th, objArr);
                                                            AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
                                                        }
                                                    }
                                                    ALog.e(str3, "handleBusinessMsg start", Constants.KEY_DATA_ID, str, obj, stringExtra2, "command", Integer.valueOf(i3), "t1", Long.valueOf(currentTimeMillis2), "t2", Long.valueOf(currentTimeMillis4), "t3", Long.valueOf(currentTimeMillis6), "t4", Long.valueOf(currentTimeMillis8), "t5", Long.valueOf(currentTimeMillis10), "t6", Long.valueOf(currentTimeMillis12));
                                                    handleBusinessMsg(context, iAppReceiver, intent, stringExtra2, str, i3, intExtra2);
                                                    return;
                                                }
                                                handBroadCastMsg(context, appReceiver, intent, i3, intExtra2);
                                                return;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                stringExtra2 = stringExtra2;
                                                i = i3;
                                                i2 = 4;
                                                Object[] objArr2 = new Object[i2];
                                                objArr2[0] = Constants.KEY_DATA_ID;
                                                objArr2[1] = str;
                                                objArr2[c] = obj;
                                                objArr2[3] = stringExtra2;
                                                ALog.e(str3, "distribMessage", th, objArr2);
                                                AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    obj = "serviceId";
                                    str = stringExtra;
                                    str2 = "accs";
                                    str3 = TAG;
                                    i = i3;
                                    i2 = 4;
                                    Object[] objArr22 = new Object[i2];
                                    objArr22[0] = Constants.KEY_DATA_ID;
                                    objArr22[1] = str;
                                    objArr22[c] = obj;
                                    objArr22[3] = stringExtra2;
                                    ALog.e(str3, "distribMessage", th, objArr22);
                                    AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i3 = intExtra;
                            obj = "serviceId";
                            str = stringExtra;
                            str2 = "accs";
                            str3 = TAG;
                            i = i3;
                            i2 = 4;
                            Object[] objArr222 = new Object[i2];
                            objArr222[0] = Constants.KEY_DATA_ID;
                            objArr222[1] = str;
                            objArr222[c] = obj;
                            objArr222[3] = stringExtra2;
                            ALog.e(str3, "distribMessage", th, objArr222);
                            AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    i3 = intExtra;
                    obj = "serviceId";
                    str = stringExtra;
                    str2 = "accs";
                    c = 2;
                    str3 = TAG;
                    i = i3;
                    i2 = 4;
                    Object[] objArr2222 = new Object[i2];
                    objArr2222[0] = Constants.KEY_DATA_ID;
                    objArr2222[1] = str;
                    objArr2222[c] = obj;
                    objArr2222[3] = stringExtra2;
                    ALog.e(str3, "distribMessage", th, objArr2222);
                    AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
                }
            } else {
                obj = "serviceId";
                str = stringExtra;
                str2 = "accs";
                c = 2;
                str3 = TAG;
                try {
                    ALog.e(str3, "distribMessage action error", new Object[0]);
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss10", action, valueOf);
                    return;
                } catch (Throwable th9) {
                    th = th9;
                }
            }
        } catch (Throwable th10) {
            th = th10;
            obj = "serviceId";
            str = stringExtra;
            str2 = "accs";
            c = 2;
            str3 = TAG;
            i2 = 4;
            i = 0;
            Object[] objArr22222 = new Object[i2];
            objArr22222[0] = Constants.KEY_DATA_ID;
            objArr22222[1] = str;
            objArr22222[c] = obj;
            objArr22222[3] = stringExtra2;
            ALog.e(str3, "distribMessage", th, objArr22222);
            AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
        }
        str3 = TAG;
        Object[] objArr222222 = new Object[i2];
        objArr222222[0] = Constants.KEY_DATA_ID;
        objArr222222[1] = str;
        objArr222222[c] = obj;
        objArr222222[3] = stringExtra2;
        ALog.e(str3, "distribMessage", th, objArr222222);
        AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i + UtilityImpl.getStackMsg(th));
    }

    /* access modifiers changed from: protected */
    public String getChannelService(Context context) {
        return AdapterUtilityImpl.channelService;
    }

    /* access modifiers changed from: protected */
    public String getMsgDistributeService(Context context) {
        return AdapterUtilityImpl.msgService;
    }

    /* access modifiers changed from: protected */
    public void handBroadCastMsg(Context context, Map<String, IAppReceiver> map, Intent intent, int i, int i2) {
        ALog.e(TAG, "handBroadCastMsg", "command", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, IAppReceiver> entry : map.entrySet()) {
                Map<String, String> allService = GlobalClientInfo.getInstance(context).getAllService(entry.getKey());
                if (allService == null) {
                    try {
                        allService = entry.getValue().getAllServices();
                    } catch (IPCException e) {
                        ALog.e(TAG, "handBroadCastMsg getAllServices", e, new Object[0]);
                    }
                }
                if (allService != null) {
                    hashMap.putAll(allService);
                }
            }
        }
        if (i == 103) {
            for (String str : hashMap.keySet()) {
                if ("accs".equals(str) || "windvane".equals(str) || "motu-remote".equals(str)) {
                    String str2 = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setClassName(context, str2);
                        IntentDispatch.dispatchIntent(context, intent);
                    }
                }
            }
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra("host");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
            boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
            boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
            TaoBaseService.ConnectInfo connectInfo = null;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (booleanExtra) {
                    connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
                } else {
                    connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i2, stringExtra2);
                }
                connectInfo.connected = booleanExtra;
            }
            if (connectInfo != null) {
                ALog.d(TAG, "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
                Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
                intent2.setPackage(context.getPackageName());
                intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
                context.sendBroadcast(intent2);
                return;
            }
            ALog.e(TAG, "handBroadCastMsg connect info null, host empty", new Object[0]);
        } else if (i == 104) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (TextUtils.isEmpty(str4)) {
                    str4 = GlobalClientInfo.getInstance(context).getService(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.setClassName(context, str4);
                    IntentDispatch.dispatchIntent(context, intent);
                }
            }
        } else {
            ALog.w(TAG, "handBroadCastMsg not handled command", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void handleBusinessMsg(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i, int i2) {
        if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
            ALog.e(TAG, "handleBusinessMsg start", Constants.KEY_DATA_ID, str2, "serviceId", str, "command", Integer.valueOf(i));
        }
        if (!handleAgooTrigger(context, str, intent)) {
            String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service) && iAppReceiver != null) {
                try {
                    service = iAppReceiver.getService(str);
                } catch (IPCException e) {
                    ALog.e(TAG, "handleBusinessMsg onBindApp", e, new Object[0]);
                }
            }
            if (TextUtils.isEmpty(service)) {
                service = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service)) {
                if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
                    ALog.e(TAG, "handleBusinessMsg to start service", PushClientConstants.TAG_CLASS_NAME, service);
                }
                intent.setClassName(context, service);
                IntentDispatch.dispatchIntent(context, intent);
            } else {
                AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
                if (listener != null) {
                    if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
                        ALog.e(TAG, "handleBusinessMsg getListener not null", new Object[0]);
                    }
                    AccsHandler.onReceiveData(context, intent, listener);
                } else {
                    ALog.e(TAG, "handleBusinessMsg getListener also null", new Object[0]);
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "service is null");
                }
            }
            UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i, "serviceId=" + str + " errorCode=" + i2 + " dataId=" + str2, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
            StringBuilder sb = new StringBuilder();
            sb.append("2commandId=");
            sb.append(i);
            sb.append("serviceId=");
            sb.append(str);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
        }
    }

    /* access modifiers changed from: protected */
    public boolean handleMsgInChannelProcess(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service) && iAppReceiver != null) {
                service = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(service)) {
                service = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service) || UtilityImpl.isMainProcess(context)) {
                return false;
            }
            if ("accs".equals(str) || Constants.IMPAAS.equals(str)) {
                ALog.e(TAG, "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            } else {
                ALog.i(TAG, "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            }
            intent.setClassName(intent.getPackage(), getMsgDistributeService(context));
            IntentDispatch.dispatchIntent(context, intent);
            return true;
        } catch (Throwable th) {
            ALog.e(TAG, "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }
}
