package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.EncryptUtil;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.SendMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context mContext;
    private MessageService messageService = null;
    protected NotifManager notifyManager = null;

    /* compiled from: Taobao */
    class MessageConnection implements ServiceConnection {
        private Intent intent;
        private String messageId;
        private ServiceConnection sc = this;
        private SendMessage sendMessage;

        public MessageConnection(String str, Intent intent2) {
            this.messageId = str;
            this.intent = intent2;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.d(AgooFactory.TAG, "MessageConnection conneted:" + componentName, new Object[0]);
            this.sendMessage = SendMessage.Stub.asInterface(iBinder);
            ALog.d(AgooFactory.TAG, "onConnected current tid:" + Thread.currentThread().getId(), new Object[0]);
            ALog.d(AgooFactory.TAG, "MessageConnection sent:" + this.intent, new Object[0]);
            if (this.sendMessage != null) {
                ThreadPoolExecutorFactory.execute(new Runnable() {
                    /* class org.android.agoo.control.AgooFactory.MessageConnection.AnonymousClass1 */

                    public void run() {
                        try {
                            ALog.d(AgooFactory.TAG, "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
                            MessageConnection.this.sendMessage.doSend(MessageConnection.this.intent);
                            ALog.d(AgooFactory.TAG, "send finish. close this connection", new Object[0]);
                        } catch (RemoteException e) {
                            ALog.e(AgooFactory.TAG, "send error", e, new Object[0]);
                            ALog.d(AgooFactory.TAG, "send finish. close this connection", new Object[0]);
                        } catch (Throwable th) {
                            ALog.d(AgooFactory.TAG, "send finish. close this connection", new Object[0]);
                            MessageConnection.this.sendMessage = null;
                            AgooFactory.mContext.unbindService(MessageConnection.this.sc);
                            throw th;
                        }
                        MessageConnection.this.sendMessage = null;
                        AgooFactory.mContext.unbindService(MessageConnection.this.sc);
                    }
                });
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ALog.d(AgooFactory.TAG, "MessageConnection disConnected", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class SendMessageRunnable implements Runnable {
        private Intent intent;
        private String pack;

        public SendMessageRunnable(String str, Intent intent2) {
            this.pack = str;
            this.intent = intent2;
        }

        public void run() {
            try {
                ALog.d(AgooFactory.TAG, "running tid:" + Thread.currentThread().getId() + ",pack=" + this.pack, new Object[0]);
                AgooFactory.mContext.sendBroadcast(this.intent);
                StringBuilder sb = new StringBuilder();
                sb.append("SendMessageRunnable for accs,pack=");
                sb.append(this.pack);
                ALog.d(AgooFactory.TAG, sb.toString(), new Object[0]);
                try {
                    this.intent.setPackage(this.pack);
                    this.intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                    IntentDispatch.dispatchIntent(AgooFactory.mContext, this.intent);
                } catch (Throwable unused) {
                }
                Intent intent2 = new Intent(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                intent2.setPackage(this.pack);
                ALog.d(AgooFactory.TAG, "this message pack:" + this.pack, new Object[0]);
                ALog.d(AgooFactory.TAG, "start to service...", new Object[0]);
                boolean bindService = AgooFactory.mContext.bindService(intent2, new MessageConnection(this.intent.getStringExtra("id"), this.intent), 17);
                ALog.d(AgooFactory.TAG, "start service ret:" + bindService, new Object[0]);
                if (!bindService) {
                    ALog.d(AgooFactory.TAG, "SendMessageRunnable is error", new Object[0]);
                }
            } catch (Throwable th) {
                ALog.e(AgooFactory.TAG, "SendMessageRunnable is error,e=" + th.toString(), new Object[0]);
            }
        }
    }

    private static final boolean checkPackage(Context context, String str) {
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00aa  */
    public static String parseEncryptedMsg(String str) {
        byte[] bArr;
        try {
            String agooAppKey = Config.getAgooAppKey(mContext);
            String utdid = UtilityImpl.utdidChanged(Constants.SP_FILE_NAME, mContext) ? UtilityImpl.getUtdid(Constants.SP_FILE_NAME, mContext) : AdapterUtilityImpl.getDeviceId(mContext);
            if (TextUtils.isEmpty(utdid)) {
                utdid = AdapterUtilityImpl.getDeviceId(mContext);
            }
            if (AdapterGlobalClientInfo.mSecurityType != 2) {
                SecurityGuardManager instance = SecurityGuardManager.getInstance(mContext);
                if (instance != null) {
                    ALog.d(TAG, "SecurityGuardManager not null!", new Object[0]);
                    ISecureSignatureComponent secureSignatureComp = instance.getSecureSignatureComp();
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = agooAppKey;
                    securityGuardParamContext.paramMap.put("INPUT", agooAppKey + utdid);
                    securityGuardParamContext.requestType = 3;
                    bArr = EncryptUtil.hexStringToByteArray(secureSignatureComp.signRequest(securityGuardParamContext, AdapterGlobalClientInfo.mAuthCode));
                    if (bArr == null) {
                    }
                    ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
                    return null;
                }
                ALog.e(TAG, "SecurityGuardManager is null", new Object[0]);
            } else if (!TextUtils.isEmpty(AdapterUtilityImpl.mAgooAppSecret)) {
                bArr = EncryptUtil.hmacSha1(AdapterUtilityImpl.mAgooAppSecret.getBytes("utf-8"), (agooAppKey + utdid).getBytes("utf-8"));
                if (bArr == null && bArr.length > 0) {
                    return new String(EncryptUtil.aesDecrypt(Base64.decode(str, 8), new SecretKeySpec(EncryptUtil.md5(bArr), "AES"), EncryptUtil.md5(agooAppKey.getBytes("utf-8"))), "utf-8");
                }
                ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
                return null;
            } else {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
            }
            bArr = null;
            if (bArr == null) {
            }
            ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "onHandleMessage current tid:" + Thread.currentThread().getId(), new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new SendMessageRunnable(str, intent));
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgByBindService error >>", th, new Object[0]);
        }
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z, String str2, TaoBaseService.ExtraInfo extraInfo) {
        AccsClientConfig accsClientConfig;
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
            accsClientConfig = AccsClientConfig.getConfigByTag("default");
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBussiness", th, new Object[0]);
            accsClientConfig = null;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBussiness intent:" + bundle.toString() + ",utdid=" + AdapterUtilityImpl.getDeviceId(context) + ",pack=" + str + ",agooFlag=" + z, new Object[0]);
        }
        if (z) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(context), "agooMsg", "15");
            NoTraceTriggerHelper.trigger(context, str, 3);
            if (accsClientConfig != null && accsClientConfig.isPullUpEnable()) {
                sendMsgByBindService(str, intent);
                return;
            }
            return;
        }
        intent.setClassName(str, AdapterGlobalClientInfo.getAgooCustomServiceName(str));
        IntentDispatch.dispatchIntent(context, intent);
    }

    public void init(Context context, NotifManager notifManager, MessageService messageService2) {
        mContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (notifManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService2;
        if (messageService2 == null) {
            this.messageService = new MessageService();
        }
        this.messageService.init(mContext);
    }

    public Bundle msgReceiverPreHandler(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo, boolean z) {
        JSONArray jSONArray;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        StringBuilder sb;
        Bundle bundle;
        StringBuilder sb2;
        String str5;
        boolean z2;
        String str6 = ",";
        String str7 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str8 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgRecevie,message--->[" + str8 + jl1.ARRAY_END_STR + ",utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str8)) {
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "message==null");
                        ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str8);
                    int length = jSONArray2.length();
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder sb4 = new StringBuilder();
                    Bundle bundle2 = null;
                    String str9 = null;
                    int i3 = 0;
                    while (i3 < length) {
                        Bundle bundle3 = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            i2 = i3;
                            sb2 = sb4;
                            i = length;
                            str3 = str8;
                            str4 = str6;
                            str2 = str7;
                            bundle = bundle3;
                            sb = sb3;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            jSONArray = jSONArray2;
                            String string = jSONObject.getString("p");
                            String string2 = jSONObject.getString("i");
                            String string3 = jSONObject.getString("b");
                            long j = jSONObject.getLong("f");
                            String string4 = !jSONObject.isNull(str7) ? jSONObject.getString(str7) : str9;
                            str2 = str7;
                            int i4 = length - 1;
                            msgDO.msgIds = string2;
                            msgDO.extData = string4;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = "11";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = "12";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (j == -1) {
                                msgDO.errorCode = "13";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else {
                                if (!checkPackage(mContext, string)) {
                                    ALog.d(TAG, "msgRecevie checkpackage is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "deletePack", string);
                                    sb4.append(string);
                                    sb3.append(string2);
                                    if (i3 < i4) {
                                        sb4.append(str6);
                                        sb3.append(str6);
                                    }
                                    sb = sb3;
                                    str5 = string4;
                                    i2 = i3;
                                    sb2 = sb4;
                                    str4 = str6;
                                } else {
                                    sb = sb3;
                                    Bundle flag = getFlag(j, msgDO);
                                    String string5 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    if (!mContext.getPackageName().equals(string)) {
                                        z2 = true;
                                    } else if (TextUtils.equals(string5, Integer.toString(4))) {
                                        z2 = false;
                                    } else {
                                        ALog.e(TAG, "msgRecevie msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "encrypted!=4", "15");
                                        msgDO.errorCode = "24";
                                        this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                        str5 = string4;
                                        sb2 = sb4;
                                        str4 = str6;
                                        i2 = i3;
                                    }
                                    bundle3.putAll(flag);
                                    try {
                                        String string6 = jSONObject.getString("t");
                                        if (!TextUtils.isEmpty(string6)) {
                                            bundle3.putString("time", string6);
                                        }
                                    } catch (Throwable unused) {
                                        if (ALog.isPrintLog(ALog.Level.I)) {
                                            ALog.i(TAG, "agoo msg has no time", new Object[0]);
                                        }
                                    }
                                    str4 = str6;
                                    bundle3.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle3.putString("id", string2);
                                    bundle3.putString("body", string3);
                                    bundle3.putString("source", string);
                                    bundle3.putString(AgooConstants.MESSAGE_FROM_APPKEY, Config.getAgooAppKey(mContext));
                                    bundle3.putString(AgooConstants.MESSAGE_EXT, string4);
                                    bundle3.putString(AgooConstants.MESSAGE_ORI, str8);
                                    if (z) {
                                        str5 = string4;
                                        bundle = bundle3;
                                        i2 = i3;
                                        sb2 = sb4;
                                        sb = sb;
                                        i = length;
                                        str3 = str8;
                                        sendMsgToBussiness(mContext, string, bundle, z2, str, extraInfo);
                                    } else {
                                        str5 = string4;
                                        bundle = bundle3;
                                        sb2 = sb4;
                                        str3 = str8;
                                        i2 = i3;
                                        sb = sb;
                                        i = length;
                                        bundle.putString("type", "common-push");
                                        bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                    str9 = str5;
                                }
                                str3 = str8;
                                bundle = bundle3;
                                i = length;
                                str9 = str5;
                            }
                            str5 = string4;
                            i2 = i3;
                            i = length;
                            str4 = str6;
                            str3 = str8;
                            bundle = bundle3;
                            sb = sb3;
                            sb2 = sb4;
                            str9 = str5;
                        }
                        i3 = i2 + 1;
                        sb4 = sb2;
                        bundle2 = bundle;
                        sb3 = sb;
                        str6 = str4;
                        length = i;
                        str8 = str3;
                        str7 = str2;
                        jSONArray2 = jSONArray;
                    }
                    if (sb4.length() > 0) {
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = sb3.toString();
                        msgDO2.removePacks = sb4.toString();
                        msgDO2.errorCode = "10";
                        msgDO2.messageSource = str;
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                    }
                    return bundle2;
                }
            } catch (Throwable th) {
                if (!ALog.isPrintLog(ALog.Level.E)) {
                    return null;
                }
                ALog.e(TAG, "msgRecevie is error,e=" + th, new Object[0]);
                return null;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "data==null");
        ALog.i(TAG, "handleMessage data==null,utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
        return null;
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, null);
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new Runnable() {
                /* class org.android.agoo.control.AgooFactory.AnonymousClass3 */

                public void run() {
                    ArrayList<MsgDO> unReportMsg = AgooFactory.this.messageService.getUnReportMsg();
                    if (unReportMsg != null && unReportMsg.size() > 0) {
                        ALog.e(AgooFactory.TAG, "reportCacheMsg", "size", Integer.valueOf(unReportMsg.size()));
                        Iterator<MsgDO> it = unReportMsg.iterator();
                        while (it.hasNext()) {
                            MsgDO next = it.next();
                            if (next != null) {
                                next.isFromCache = true;
                                next.triggerType = OrangeAdapter.getADaemonTriggerType(AgooFactory.mContext);
                                AgooFactory.this.notifyManager.report(next, null);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, null);
    }

    public void updateMsg(final byte[] bArr, final boolean z) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class org.android.agoo.control.AgooFactory.AnonymousClass4 */

            public void run() {
                try {
                    String str = new String(bArr, "utf-8");
                    if (TextUtils.isEmpty(str)) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                        return;
                    }
                    ALog.i(AgooFactory.TAG, "message = " + str, new Object[0]);
                    JSONObject jSONObject = new JSONObject(str);
                    String str2 = null;
                    String string = jSONObject.getString("api");
                    String string2 = jSONObject.getString("id");
                    if (TextUtils.equals(string, "agooReport")) {
                        str2 = jSONObject.getString("status");
                    }
                    if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
                    }
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(str2)) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
                        return;
                    }
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(AgooFactory.TAG, "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + str2 + ",reportTimes=" + Config.getReportCacheMsg(AgooFactory.mContext), new Object[0]);
                    }
                    if (TextUtils.equals(string, "agooReport")) {
                        if (TextUtils.equals(str2, "4") && z) {
                            AgooFactory.this.messageService.updateAccsMessage(string2, "1");
                        } else if ((TextUtils.equals(str2, "8") || TextUtils.equals(str2, "9")) && z) {
                            AgooFactory.this.messageService.updateAccsMessage(string2, MessageService.MSG_DB_COMPLETE);
                        }
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, str2, 0.0d);
                    }
                } catch (Throwable th) {
                    ALog.e(AgooFactory.TAG, "updateMsg get data error,e=" + th, new Object[0]);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
                }
            }
        });
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.getReportCacheMsg(mContext), new Object[0]);
                }
                if (TextUtils.equals(str2, "8")) {
                    this.messageService.updateAccsMessage(str, "2");
                } else if (TextUtils.equals(str2, "9")) {
                    this.messageService.updateAccsMessage(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(final String str, final String str2) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class org.android.agoo.control.AgooFactory.AnonymousClass5 */

            public void run() {
                AgooFactory.this.updateMsgStatus(str, str2);
            }
        });
    }

    public void msgRecevie(final byte[] bArr, final String str, final TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgRecevie]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new Runnable() {
                /* class org.android.agoo.control.AgooFactory.AnonymousClass2 */

                public void run() {
                    AgooFactory.this.msgReceiverPreHandler(bArr, str, extraInfo, true);
                }
            });
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(final byte[] bArr, final String str) {
        if (bArr != null && bArr.length > 0) {
            ThreadPoolExecutorFactory.execute(new Runnable() {
                /* class org.android.agoo.control.AgooFactory.AnonymousClass1 */

                public void run() {
                    try {
                        String str = new String(bArr, "utf-8");
                        JSONArray jSONArray = new JSONArray(str);
                        int length = jSONArray.length();
                        if (length == 1) {
                            String str2 = null;
                            String str3 = null;
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                if (jSONObject != null) {
                                    str2 = jSONObject.getString("i");
                                    str3 = jSONObject.getString("p");
                                }
                            }
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(AgooFactory.TAG, "saveMsg msgId:" + str2 + ",message=" + str + ",currentPack=" + str3 + ",reportTimes=" + Config.getReportCacheMsg(AgooFactory.mContext), new Object[0]);
                            }
                            if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, AgooFactory.mContext.getPackageName())) {
                                if (TextUtils.isEmpty(str)) {
                                    AgooFactory.this.messageService.addAccsMessage(str2, str, "0");
                                } else {
                                    AgooFactory.this.messageService.addAccsMessage(str2, str, str);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ALog.e(AgooFactory.TAG, "saveMsg fail:" + th.toString(), new Object[0]);
                    }
                }
            });
        }
    }
}
