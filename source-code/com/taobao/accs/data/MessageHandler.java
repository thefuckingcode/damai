package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.ut.monitor.DataReceiveMonitor;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.BindAppStatistic;
import com.taobao.accs.ut.statistics.BindUserStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.ut.statistics.SendAckStatistic;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.MessageStreamReader;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.youku.live.livesdk.preloader.Preloader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import mtopsdk.common.util.SymbolExpUtil;
import org.android.agoo.common.Config;
import org.apache.commons.net.SocketClient;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.ss0;
import tb.w6;

/* compiled from: Taobao */
public class MessageHandler {
    private static final int MESSAGE_ID_CACHE_SIZE = 50;
    private String TAG = "MsgRecv_";
    private Map<String, AssembleMessage> assembleMessageMap = new HashMap();
    private LinkedHashMap<String, String> handledMessageId = new LinkedHashMap<String, String>() {
        /* class com.taobao.accs.data.MessageHandler.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };
    public String mAccsDeviceToken = "";
    public AntiBrush mAntiBrush;
    public int mConnectType;
    private BaseConnection mConnection;
    private Context mContext;
    public String mDeviceToken = "";
    public FlowControl mFlowControl;
    private Message mLastSendMessage;
    private ReceiveMsgStat mReceiveMsgStat;
    private Runnable mRestoreTrafficsRunnable = new Runnable() {
        /* class com.taobao.accs.data.MessageHandler.AnonymousClass3 */

        public void run() {
            TrafficsMonitor trafficsMonitor = MessageHandler.this.mTrafficMonitor;
            if (trafficsMonitor != null) {
                trafficsMonitor.restoreTraffics();
            }
        }
    };
    protected TrafficsMonitor mTrafficMonitor;
    public ConcurrentMap<String, ScheduledFuture<?>> reqTasks = new ConcurrentHashMap();
    private ConcurrentMap<Message.Id, Message> unHandleMessage = new ConcurrentHashMap();
    private boolean unRevPing = false;

    public MessageHandler(Context context, BaseConnection baseConnection) {
        String str;
        this.mContext = context;
        this.mConnection = baseConnection;
        this.mTrafficMonitor = new TrafficsMonitor(context);
        this.mFlowControl = new FlowControl(this.mContext);
        this.mAntiBrush = new AntiBrush(this.mContext);
        if (baseConnection == null) {
            str = this.TAG;
        } else {
            str = this.TAG + baseConnection.mConfigTag;
        }
        this.TAG = str;
        restoreMessageId();
        restoreTraffics();
    }

    private Intent buildBaseReceiveIntent(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.packageName);
        intent.putExtra("command", message.command);
        intent.putExtra("serviceId", message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        return intent;
    }

    private byte[] gzipInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
            }
            return byteArray;
        } catch (Exception e) {
            String str = this.TAG;
            ALog.e(str, "uncompress data error " + e.toString(), new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.mConnectType + " uncompress data error " + e.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return null;
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void handleControlMessage(Message message, byte[] bArr, byte[] bArr2, String str) {
        Throwable th;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        int i = -8;
        try {
            try {
                JSONObject jSONObject3 = new JSONObject(new String(bArr));
                int i2 = 2;
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.TAG, "handleControlMessage parse", Preloader.KEY_JSON, jSONObject3.toString());
                }
                if (message.command.intValue() == 100) {
                    i = 200;
                } else {
                    i = jSONObject3.getInt("code");
                }
                if (i == 200) {
                    int intValue = message.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.saveUtdid(Constants.SP_FILE_NAME, this.mContext);
                        try {
                            this.mConnection.getClientManager().onAppBind(this.mContext.getPackageName());
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                            this.mAccsDeviceToken = JsonUtility.getString(jSONObject4, Constants.KEY_ACCS_TOKEN, null);
                            this.mDeviceToken = JsonUtility.getString(jSONObject4, "deviceToken", null);
                            String string = JsonUtility.getString(jSONObject4, "regId", null);
                            if (!TextUtils.isEmpty(this.mDeviceToken)) {
                                Config.setDeviceToken(this.mContext, this.mDeviceToken);
                            }
                            if (!TextUtils.isEmpty(string) && !string.equals(OrangeAdapter.getRegId(this.mContext))) {
                                this.mConnection.getClientManager().clearClients();
                                OrangeAdapter.clearRegId(this.mContext);
                            }
                            if (jSONObject4 != null) {
                                JSONArray jSONArray2 = jSONObject4.getJSONArray(Constants.KEY_PACKAGE_NAMES);
                                if (jSONArray2 != null) {
                                    int i3 = 0;
                                    while (i3 < jSONArray2.length()) {
                                        String string2 = jSONArray2.getString(i3);
                                        if (UtilityImpl.packageExist(this.mContext, string2)) {
                                            this.mConnection.getClientManager().onAppBind(message.packageName);
                                        } else {
                                            String str2 = this.TAG;
                                            Object[] objArr = new Object[i2];
                                            objArr[0] = "pkg";
                                            objArr[1] = string2;
                                            ALog.d(str2, "unbind app", objArr);
                                            BaseConnection baseConnection = this.mConnection;
                                            baseConnection.send(Message.buildUnbindApp(baseConnection.getHost(null), string2), true);
                                        }
                                        i3++;
                                        i2 = 2;
                                    }
                                }
                                if (jSONObject4.has(Constants.KEY_EVENT_COLLECT_CONTROL) && (jSONObject2 = jSONObject4.getJSONObject(Constants.KEY_EVENT_COLLECT_CONTROL)) != null) {
                                    OrangeAdapter.saveConfigToSP(this.mContext, "switch", jSONObject2.getBoolean("switch"));
                                    OrangeAdapter.saveEventCollectStrategy(this.mContext, jSONObject2.toString());
                                }
                                if (jSONObject4.has("agooControl") && (jSONObject = jSONObject4.getJSONObject("agooControl")) != null) {
                                    boolean z = jSONObject.getBoolean(Constants.KEY_CONTROL);
                                    OrangeAdapter.saveConfigToSP(this.mContext, Constants.KEY_CONTROL, z);
                                    if (!(!z || (jSONArray = jSONObject.getJSONArray("strategy")) == null || jSONArray.length() == 0)) {
                                        NoTraceTriggerHelper.trigger(jSONArray.toString(), this.mContext, null, 7, -1);
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            ALog.i(this.TAG, "no token/invalid app", th2);
                        }
                    } else if (intValue == 2) {
                        this.mConnection.getClientManager().onAppUnbind(message.packageName);
                    } else if (intValue == 3) {
                        this.mConnection.getClientManager().onUserBind(message.packageName, message.userinfo);
                    } else if (intValue == 4) {
                        this.mConnection.getClientManager().onUserUnBind(message.packageName, message.userinfo);
                    } else if (intValue == 100) {
                        if ((this.mConnection instanceof InAppConnection) && "4|sal|accs-iot".equals(message.target)) {
                            ((InAppConnection) this.mConnection).onReceiveAccsHeartbeatResp(jSONObject3);
                        }
                    }
                } else if (message.command.intValue() == 3 && i == 300) {
                    this.mConnection.getClientManager().onAppUnbind(message.packageName);
                }
            } catch (Throwable th3) {
                th = th3;
                ALog.e(this.TAG, "handleControlMessage", th, new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.mConnectType + th.toString());
                onResult(message, i, null, bArr, null);
                addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), str, (long) bArr2.length));
            }
        } catch (Throwable th4) {
            th = th4;
            ALog.e(this.TAG, "handleControlMessage", th, new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.mConnectType + th.toString());
            onResult(message, i, null, bArr, null);
            addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), str, (long) bArr2.length));
        }
        onResult(message, i, null, bArr, null);
        addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), str, (long) bArr2.length));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:208:0x0680 */
    /* JADX DEBUG: Multi-variable search result rejected for r49v0, resolved type: com.taobao.accs.data.MessageHandler */
    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r11v13, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.taobao.accs.utl.ALog$Level] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.taobao.accs.ut.statistics.ReceiveMsgStat] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r1v40, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x05ab A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05b5 A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05be A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0601 A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x060f A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0678 A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x067a A[Catch:{ Exception -> 0x0751 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void handleMessage(int i, byte[] bArr, String str, int i2, int i3, long j) throws IOException {
        String str2;
        String str3;
        String str4;
        boolean z;
        byte[] bArr2;
        Map<Integer, String> map;
        boolean z2;
        String str5;
        String str6;
        int i4;
        String str7;
        String str8;
        String str9;
        Exception e;
        boolean z3;
        String str10;
        Map<Integer, String> map2;
        int i5;
        boolean z4;
        String str11;
        long j2;
        long j3;
        String str12;
        boolean z5;
        int i6;
        String str13;
        byte[] bArr3;
        String str14;
        String str15;
        String str16;
        String str17;
        long j4;
        String str18;
        String str19;
        String str20;
        long j5;
        Map<Integer, String> map3;
        DataReceiveMonitor dataReceiveMonitor;
        int i7;
        String str21;
        int i8;
        long j6;
        Message message;
        Map<Integer, String> map4;
        boolean z6;
        long currentTimeMillis = System.currentTimeMillis();
        MessageStreamReader messageStreamReader = new MessageStreamReader(bArr);
        long readShort = (long) messageStreamReader.readShort();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            String str22 = this.TAG;
            str4 = "1";
            StringBuilder sb = new StringBuilder();
            str3 = "";
            sb.append("flag:");
            sb.append(Integer.toHexString((int) readShort));
            str2 = "accs";
            ALog.d(str22, sb.toString(), new Object[0]);
        } else {
            str2 = "accs";
            str3 = "";
            str4 = "1";
        }
        String readString = messageStreamReader.readString(messageStreamReader.readByte());
        if (ALog.isPrintLog(level)) {
            ALog.d(this.TAG, "target:" + readString, new Object[0]);
        }
        String readString2 = messageStreamReader.readString(messageStreamReader.readByte());
        if (ALog.isPrintLog(level)) {
            ALog.d(this.TAG, "source:" + readString2, new Object[0]);
        }
        if (OrangeAdapter.normalChangesEnabled() && "1|grace-bye|".equals(readString2)) {
            if (i3 == 1) {
                String str23 = this.TAG;
                Object[] objArr = new Object[2];
                objArr[0] = "mConnection";
                objArr[1] = Boolean.valueOf(this.mConnection != null);
                ALog.e(str23, "received reconnect command", objArr);
                BaseConnection baseConnection = this.mConnection;
                if (baseConnection != null) {
                    baseConnection.reConnect();
                    return;
                }
                return;
            }
        }
        try {
            String readString3 = messageStreamReader.readString(messageStreamReader.readByte());
            ALog.e(this.TAG, "parseMessage", Constants.KEY_DATA_ID, readString3, "target", readString, "source", readString2, "accsFlag", Integer.valueOf(i3));
            if (readString2.contains(Constants.TARGET_SERVICE_ST) || readString2.contains(Constants.TARGET_FORE) || readString2.contains(Constants.TARGET_BACK)) {
                ALog.e(this.TAG, "ignore source 4|sal|sg/fg/bg message dataId:" + readString3, new Object[0]);
                this.unHandleMessage.remove(new Message.Id(0, readString3));
                return;
            }
            String str24 = readString2 + readString3;
            if (messageStreamReader.available() > 0) {
                if (i2 == 2) {
                    map = parseExtHeader(messageStreamReader);
                    if (map != null && map.containsKey(16) && map.containsKey(17)) {
                        z6 = true;
                        if (i != 0 || z6) {
                            z = z6;
                            bArr2 = messageStreamReader.readAll();
                            z2 = false;
                        } else if (i == 1) {
                            z = z6;
                            bArr2 = gzipInputStream(messageStreamReader);
                            z2 = true;
                        } else {
                            z = z6;
                            z2 = false;
                            bArr2 = null;
                        }
                    }
                } else {
                    map = null;
                }
                z6 = false;
                if (i != 0) {
                }
                z = z6;
                bArr2 = messageStreamReader.readAll();
                z2 = false;
            } else {
                z2 = false;
                map = null;
                bArr2 = null;
                z = false;
            }
            messageStreamReader.close();
            if (bArr2 == null) {
                z3 = z2;
                try {
                    map2 = map;
                    str10 = readString2;
                    ALog.d(this.TAG, "oriData is null", new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                    str6 = "handleMessage";
                    str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                    str5 = str4;
                    str19 = str3;
                    str7 = str2;
                    i4 = 0;
                    str9 = str19;
                    str8 = str20;
                    ALog.e(this.TAG, str6, e, new Object[i4]);
                    AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                }
            } else {
                z3 = z2;
                map2 = map;
                str10 = readString2;
                if (ALog.isPrintLog(level)) {
                    ALog.d(this.TAG, "oriData:" + String.valueOf(bArr2), new Object[0]);
                }
            }
            int valueOf = Message.MsgType.valueOf((int) ((readShort >> 15) & 1));
            Message.ReqType valueOf2 = Message.ReqType.valueOf((int) ((readShort >> 13) & 3));
            int i9 = (int) ((readShort >> 12) & 1);
            int valueOf3 = Message.MsgResType.valueOf((int) ((readShort >> 11) & 1));
            boolean z7 = ((int) ((readShort >> 6) & 1)) == 1;
            if (ALog.isPrintLog(ALog.Level.I) || readString.contains(Constants.IMPAAS)) {
                ALog.e(this.TAG, "handleMessage", Constants.KEY_DATA_ID, readString3, "type", Message.MsgType.name(valueOf), "reqType", valueOf2.name(), "resType", Message.MsgResType.name(valueOf3), "target", readString);
                i5 = 1;
            } else {
                i5 = 1;
            }
            if (valueOf == i5 && (valueOf2 == Message.ReqType.ACK || valueOf2 == Message.ReqType.RES)) {
                try {
                    Message remove = this.unHandleMessage.remove(new Message.Id(0, readString3));
                    if (remove != null) {
                        if (ALog.isPrintLog(level)) {
                            try {
                                String str25 = this.TAG;
                                str21 = Constants.IMPAAS;
                                ALog.d(str25, "handleMessage reqMessage not null", new Object[0]);
                            } catch (Exception e3) {
                                e = e3;
                                str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                                str5 = str4;
                                str19 = str3;
                                str7 = str2;
                                str6 = "handleMessage";
                            }
                        } else {
                            str21 = Constants.IMPAAS;
                        }
                        if (i9 == 1) {
                            try {
                                i8 = new JSONObject(new String(bArr2)).getInt("code");
                            } catch (Exception unused) {
                                i8 = -3;
                            }
                        } else {
                            i8 = 200;
                        }
                        if (remove.getNetPermanceMonitor() != null) {
                            remove.getNetPermanceMonitor().onRecUnParse(j);
                            j6 = currentTimeMillis;
                            remove.getNetPermanceMonitor().onStartParse(j6);
                            remove.getNetPermanceMonitor().onRecAck();
                        } else {
                            j6 = currentTimeMillis;
                        }
                        if (valueOf2 == Message.ReqType.RES) {
                            str6 = "handleMessage";
                            j3 = readShort;
                            str13 = str24;
                            message = remove;
                            j2 = j6;
                            i6 = valueOf3;
                            z5 = z7;
                            str11 = str21;
                            z4 = z3;
                            map4 = map2;
                            try {
                                onResult(remove, i8, valueOf2, bArr2, map4);
                            } catch (Exception e4) {
                                e = e4;
                                str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                                str5 = str4;
                                str19 = str3;
                                str7 = str2;
                                i4 = 0;
                                str9 = str19;
                                str8 = str20;
                                ALog.e(this.TAG, str6, e, new Object[i4]);
                                AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                            }
                        } else {
                            z4 = z3;
                            j2 = j6;
                            i6 = valueOf3;
                            z5 = z7;
                            str6 = "handleMessage";
                            str11 = str21;
                            map4 = map2;
                            j3 = readShort;
                            str13 = str24;
                            message = remove;
                            onResult(message, i8, map4);
                        }
                        bArr3 = bArr;
                        map2 = map4;
                        str12 = readString;
                        addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, ss0.i(), str, (long) bArr3.length));
                    } else {
                        z4 = z3;
                        str11 = Constants.IMPAAS;
                        str12 = readString;
                        str6 = "handleMessage";
                        j2 = currentTimeMillis;
                        j3 = readShort;
                        i6 = valueOf3;
                        z5 = z7;
                        str13 = str24;
                        bArr3 = bArr;
                        ALog.e(this.TAG, "handleMessage data ack/res reqMessage is null", Constants.KEY_DATA_ID, readString3);
                    }
                } catch (Exception e5) {
                    e = e5;
                    str6 = "handleMessage";
                    str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                    str5 = str4;
                    str19 = str3;
                    str7 = str2;
                    i4 = 0;
                    str9 = str19;
                    str8 = str20;
                    ALog.e(this.TAG, str6, e, new Object[i4]);
                    AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                }
            } else {
                z4 = z3;
                str6 = "handleMessage";
                str11 = Constants.IMPAAS;
                str13 = str24;
                str12 = readString;
                j2 = currentTimeMillis;
                j3 = readShort;
                bArr3 = bArr;
                i6 = valueOf3;
                z5 = z7;
            }
            if (valueOf == 0 && valueOf2 == Message.ReqType.RES) {
                Message remove2 = this.unHandleMessage.remove(new Message.Id(0, readString3));
                if (remove2 != null) {
                    handleControlMessage(remove2, bArr2, bArr3, str);
                    return;
                }
                str7 = str;
                ALog.e(this.TAG, "handleMessage contorl ACK reqMessage is null", Constants.KEY_DATA_ID, readString3);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.TAG, "handleMessage not handled", "body", new String(bArr2));
                }
            } else {
                str7 = str;
            }
            if (valueOf != 1 || valueOf2 != Message.ReqType.DATA) {
                return;
            }
            if (str12 == null) {
                ALog.e(this.TAG, "handleMessage target is null", new Object[0]);
                return;
            }
            String[] split = str12.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split.length < 2) {
                ALog.e(this.TAG, "handleMessage target length is invalid", new Object[0]);
                return;
            }
            ?? r1 = ALog.Level.D;
            if (ALog.isPrintLog(r1)) {
                ALog.d(this.TAG, "handleMessage onPush", "isBurstData", Boolean.valueOf(z));
            }
            ReceiveMsgStat receiveMsgStat = this.mReceiveMsgStat;
            if (receiveMsgStat != null) {
                receiveMsgStat.commitUT();
            }
            ReceiveMsgStat receiveMsgStat2 = new ReceiveMsgStat();
            this.mReceiveMsgStat = receiveMsgStat2;
            receiveMsgStat2.receiveDate = String.valueOf(System.currentTimeMillis());
            if (UtilityImpl.packageExist(this.mContext, split[1])) {
                String str26 = split.length >= 3 ? split[2] : null;
                this.mReceiveMsgStat.serviceId = str26;
                ?? r2 = str13;
                if (!isDuplicateMessage(r2) || GlobalClientInfo.AGOO_SERVICE_ID.equals(str26)) {
                    if (!(this.mConnection instanceof InAppConnection) || !UtilityImpl.isChannelProcess(this.mContext) || UtilityImpl.isMainProcessAlive(this.mContext)) {
                        str15 = str2;
                        str14 = str12;
                    } else {
                        ALog.e(this.TAG, "handleBgMessage", "serviceId", str26);
                        str15 = str2;
                        str14 = str12;
                        try {
                            AppMonitorAdapter.commitCount(str15, BaseMonitor.BACKGROUND_RECV_MSG, str26, 0.0d);
                        } catch (Exception e6) {
                            e = e6;
                            str7 = str15;
                            str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                            str5 = str4;
                            str19 = str3;
                            i4 = 0;
                            str9 = str19;
                            str8 = str20;
                            ALog.e(this.TAG, str6, e, new Object[i4]);
                            AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                        }
                    }
                    DataReceiveMonitor dataReceiveMonitor2 = new DataReceiveMonitor();
                    dataReceiveMonitor2.oriGzip = z4;
                    dataReceiveMonitor2.serviceId = str26;
                    dataReceiveMonitor2.receiveTime = j;
                    dataReceiveMonitor2.startParseTime = j2;
                    dataReceiveMonitor2.startGzipTime = System.currentTimeMillis();
                    if (z) {
                        bArr2 = putBurstMessage(r2, map2, bArr2);
                        if (bArr2 == null) {
                            ALog.e(this.TAG, "handleMessage completeOriData is null", new Object[0]);
                            return;
                        } else if (i == 1) {
                            MessageStreamReader messageStreamReader2 = new MessageStreamReader(bArr2);
                            bArr2 = gzipInputStream(messageStreamReader2);
                            if (ALog.isPrintLog(r1)) {
                                map2 = map2;
                                ALog.d(this.TAG, "handleMessage gzip completeOriData", Constants.KEY_DATA_ID, r2, "length", Integer.valueOf(bArr2.length));
                            } else {
                                map2 = map2;
                            }
                            messageStreamReader2.close();
                        } else {
                            map2 = map2;
                        }
                    }
                    dataReceiveMonitor2.endGzipTime = System.currentTimeMillis();
                    recordMessageId(r2);
                    dataReceiveMonitor2.recordIdTime = System.currentTimeMillis();
                    if (!str15.equals(str26)) {
                        if (!str11.equals(str26)) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.TAG, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, readString3, "target", split[1], "serviceId", str26);
                            }
                            Intent intent = new Intent(Constants.ACTION_RECEIVE);
                            intent.setPackage(split[1]);
                            intent.putExtra("command", 101);
                            if (split.length >= 3) {
                                intent.putExtra("serviceId", split[2]);
                            }
                            if (split.length < 4) {
                                str16 = split[3];
                                intent.putExtra(Constants.KEY_USER_ID, str16);
                            } else {
                                str16 = str3;
                            }
                            intent.putExtra("data", bArr2);
                            intent.putExtra(Constants.KEY_DATA_ID, readString3);
                            intent.putExtra("packageName", this.mContext.getPackageName());
                            intent.putExtra("host", str7);
                            intent.putExtra(Constants.KEY_CONN_TYPE, this.mConnectType);
                            intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z5);
                            intent.putExtra("appKey", this.mConnection.getAppkey());
                            intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConnection.mConfigTag);
                            putExtHeaderToIntent(map2, intent);
                            if (!z5) {
                                j4 = j3;
                                z5 = z5;
                                str7 = str14;
                                str17 = str10;
                                putBusinessAckInfoToIntent(intent, str17, str7, (short) ((int) j4));
                            } else {
                                z5 = z5;
                                str7 = str14;
                                str17 = str10;
                                j4 = j3;
                            }
                            MsgDistribute.getInstance().distribute(this.mContext, intent);
                            UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str26 + " dataId=" + readString3, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
                            str11 = str11;
                            str10 = str17;
                            AppMonitorAdapter.commitCount(str15, BaseMonitor.COUNT_POINT_TO_BUSS, "1commandId=101serviceId=" + str26, 0.0d);
                            r1 = this.mReceiveMsgStat;
                            r1.dataId = readString3;
                            r1.userId = str16;
                            StringBuilder sb2 = new StringBuilder();
                            r2 = bArr2 != null ? 0 : bArr2.length;
                            sb2.append((int) r2);
                            str18 = str3;
                            sb2.append(str18);
                            r1.dataLen = sb2.toString();
                            this.mReceiveMsgStat.deviceId = UtilityImpl.getDeviceId(this.mContext);
                            this.mReceiveMsgStat.toBzDate = String.valueOf(System.currentTimeMillis());
                            j5 = j4;
                            map3 = map2;
                            addTrafficsInfo(new TrafficsMonitor.TrafficInfo(str26, ss0.i(), str, (long) bArr.length));
                            dataReceiveMonitor = dataReceiveMonitor2;
                            i7 = i6;
                        }
                    }
                    ALog.e(this.TAG, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, readString3, "target", split[1], "serviceId", str26);
                    Intent intent2 = new Intent(Constants.ACTION_RECEIVE);
                    intent2.setPackage(split[1]);
                    intent2.putExtra("command", 101);
                    if (split.length >= 3) {
                    }
                    if (split.length < 4) {
                    }
                    intent2.putExtra("data", bArr2);
                    intent2.putExtra(Constants.KEY_DATA_ID, readString3);
                    intent2.putExtra("packageName", this.mContext.getPackageName());
                    intent2.putExtra("host", str7);
                    intent2.putExtra(Constants.KEY_CONN_TYPE, this.mConnectType);
                    intent2.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z5);
                    intent2.putExtra("appKey", this.mConnection.getAppkey());
                    intent2.putExtra(Constants.KEY_CONFIG_TAG, this.mConnection.mConfigTag);
                    putExtHeaderToIntent(map2, intent2);
                    if (!z5) {
                    }
                    MsgDistribute.getInstance().distribute(this.mContext, intent2);
                    UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str26 + " dataId=" + readString3, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
                    str11 = str11;
                    str10 = str17;
                    AppMonitorAdapter.commitCount(str15, BaseMonitor.COUNT_POINT_TO_BUSS, "1commandId=101serviceId=" + str26, 0.0d);
                    r1 = this.mReceiveMsgStat;
                    r1.dataId = readString3;
                    r1.userId = str16;
                    StringBuilder sb22 = new StringBuilder();
                    if (bArr2 != null) {
                    }
                    sb22.append((int) r2);
                    str18 = str3;
                    try {
                        sb22.append(str18);
                        r1.dataLen = sb22.toString();
                        this.mReceiveMsgStat.deviceId = UtilityImpl.getDeviceId(this.mContext);
                        this.mReceiveMsgStat.toBzDate = String.valueOf(System.currentTimeMillis());
                        j5 = j4;
                        map3 = map2;
                        addTrafficsInfo(new TrafficsMonitor.TrafficInfo(str26, ss0.i(), str, (long) bArr.length));
                        dataReceiveMonitor = dataReceiveMonitor2;
                        i7 = i6;
                    } catch (Exception e7) {
                        e = e7;
                        str7 = str15;
                        str19 = str18;
                        str20 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                        str5 = str4;
                        i4 = 0;
                        str9 = str19;
                        str8 = str20;
                        ALog.e(this.TAG, str6, e, new Object[i4]);
                        AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                    }
                } else {
                    ALog.e(this.TAG, "handleMessage msg duplicate", Constants.KEY_DATA_ID, readString3);
                    this.mReceiveMsgStat.repeat = true;
                    str7 = str12;
                    str18 = str3;
                    str15 = str2;
                    i7 = i6;
                    map3 = map2;
                    j5 = j3;
                    dataReceiveMonitor = null;
                }
                if (i7 == 1) {
                    if (str15.equals(str26) || str11.equals(str26)) {
                        ALog.e(this.TAG, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, readString3);
                    } else {
                        ALog.i(this.TAG, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, readString3);
                    }
                    String host = this.mConnection.getHost(null);
                    String tag = this.mConnection.getTag();
                    short s = (short) ((int) j5);
                    str7 = str15;
                    r1 = str18;
                    r2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                    str5 = str4;
                    try {
                        Message buildPushAck = Message.buildPushAck(host, tag, str7, str10, readString3, false, s, str, map3);
                        this.mConnection.send(buildPushAck, true);
                        if (dataReceiveMonitor != null) {
                            dataReceiveMonitor.reportAckTime = System.currentTimeMillis();
                            w6.b().commitStat(dataReceiveMonitor);
                        }
                        utStatSendAck(buildPushAck.dataId, str26);
                        if (z5) {
                            AppMonitorAdapter.commitCount(str7, BaseMonitor.COUNT_ACK, r1, 0.0d);
                        }
                    } catch (Exception e8) {
                        e = e8;
                        str19 = r1;
                        str20 = r2;
                        i4 = 0;
                        str9 = str19;
                        str8 = str20;
                        ALog.e(this.TAG, str6, e, new Object[i4]);
                        AppMonitorAdapter.commitAlarmFail(str7, str8, str9, str5, this.mConnectType + e.toString());
                    }
                }
            } else {
                str8 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                str5 = str4;
                str9 = str3;
                str7 = str2;
                String str27 = this.TAG;
                Object[] objArr2 = new Object[2];
                i4 = 0;
                try {
                    objArr2[0] = "package";
                    objArr2[1] = split[1];
                    ALog.e(str27, "handleMessage not exist, unbind it", objArr2);
                    BaseConnection baseConnection2 = this.mConnection;
                    baseConnection2.send(Message.buildUnbindApp(baseConnection2.getHost(null), split[1]), true);
                } catch (Exception e9) {
                    e = e9;
                }
            }
        } catch (Exception e10) {
            ALog.e(this.TAG, "dataId read error " + e10.toString(), new Object[0]);
            messageStreamReader.close();
            AppMonitorAdapter.commitAlarmFail(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, str3, str4, this.mConnectType + "data id read error" + e10.toString());
        }
    }

    private boolean isDuplicateMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.handledMessageId.containsKey(str);
    }

    private boolean isNetWorkError(int i) {
        return i == -1 || i == -9 || i == -18 || i == -10 || i == -11;
    }

    private void monitorPerf(Message message, int i, boolean z) {
        boolean z2;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor != null) {
                URL url = message.host;
                String url2 = url == null ? null : url.toString();
                if (i == 200) {
                    z2 = true;
                    if (message.retryTimes > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                    } else {
                        AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQUEST, url2);
                    }
                } else {
                    if (message.retryTimes > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i, 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                    } else if (i != -13) {
                        String int2String = UtilityImpl.int2String(i);
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQUEST, url2, int2String, this.mConnectType + message.serviceId + message.timeout);
                    }
                    netPermanceMonitor.setFailReason(i);
                    z2 = false;
                }
                netPermanceMonitor.setRet(z2);
                if (z) {
                    if (message.isCancel) {
                        netPermanceMonitor.setRet(false);
                        netPermanceMonitor.setFailReason("msg cancel");
                    }
                    w6.b().commitStat(netPermanceMonitor);
                }
            }
        } catch (Throwable th) {
            ALog.e(this.TAG, "monitorPerf", th, new Object[0]);
        }
    }

    private Map<Integer, String> parseExtHeader(MessageStreamReader messageStreamReader) {
        HashMap hashMap = null;
        if (messageStreamReader == null) {
            return null;
        }
        try {
            int readShort = messageStreamReader.readShort();
            if (ALog.isPrintLog(ALog.Level.D)) {
                String str = this.TAG;
                ALog.d(str, "extHeaderLen:" + readShort, new Object[0]);
            }
            int i = 0;
            while (i < readShort) {
                int readShort2 = messageStreamReader.readShort();
                int i2 = (64512 & readShort2) >> 10;
                int i3 = readShort2 & 1023;
                String readString = messageStreamReader.readString(i3);
                i = i + 2 + i3;
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(Integer.valueOf(i2), readString);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.TAG, "", "extHeaderType", Integer.valueOf(i2), "value", readString);
                }
            }
        } catch (Exception e) {
            ALog.e(this.TAG, "parseExtHeader", e, new Object[0]);
        }
        return hashMap;
    }

    private byte[] putBurstMessage(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    } else if (parseInt < 0 || parseInt >= parseInt2) {
                        throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                    } else {
                        String str2 = map.get(18);
                        long j = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.TAG, "putBurstMessage", th, new Object[0]);
                        }
                        AssembleMessage assembleMessage = this.assembleMessageMap.get(str);
                        if (assembleMessage == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.TAG, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            assembleMessage = new AssembleMessage(str, parseInt2, str2);
                            assembleMessage.setTimeOut(j);
                            this.assembleMessageMap.put(str, assembleMessage);
                        }
                        return assembleMessage.putBurst(parseInt, parseInt2, bArr);
                    }
                }
            } catch (Throwable th2) {
                ALog.w(this.TAG, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void putBusinessAckInfoToIntent(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("target", str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    private void putExtHeaderToIntent(Map<Integer, String> map, Intent intent) {
        if (map != null && intent != null) {
            intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
        }
    }

    private void recordMessageId(String str) {
        if (!TextUtils.isEmpty(str) && !this.handledMessageId.containsKey(str)) {
            this.handledMessageId.put(str, str);
            saveMessageId();
        }
    }

    private void restoreMessageId() {
        try {
            File dir = this.mContext.getDir("accs", 0);
            File file = new File(dir, "message" + this.mConnection.getAppkey());
            if (!file.exists()) {
                ALog.d(this.TAG, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    this.handledMessageId.put(readLine, readLine);
                } else {
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMessageId() {
        try {
            File dir = this.mContext.getDir("accs", 0);
            FileWriter fileWriter = new FileWriter(new File(dir, "message" + this.mConnection.getAppkey()));
            fileWriter.write("");
            for (String str : this.handledMessageId.keySet()) {
                fileWriter.append((CharSequence) str).append((CharSequence) SocketClient.NETASCII_EOL);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void utStat(Message message, int i) {
        if (message != null) {
            String deviceId = UtilityImpl.getDeviceId(this.mContext);
            String str = System.currentTimeMillis() + "";
            boolean z = i == 200;
            int intValue = message.command.intValue();
            if (intValue == 1) {
                BindAppStatistic bindAppStatistic = new BindAppStatistic();
                bindAppStatistic.deviceId = deviceId;
                bindAppStatistic.time = str;
                bindAppStatistic.ret = z;
                bindAppStatistic.setFailReason(i);
                bindAppStatistic.commitUT();
            } else if (intValue == 3) {
                BindUserStatistic bindUserStatistic = new BindUserStatistic();
                bindUserStatistic.deviceId = deviceId;
                bindUserStatistic.time = str;
                bindUserStatistic.ret = z;
                bindUserStatistic.userId = message.userinfo;
                bindUserStatistic.setFailReason(i);
                bindUserStatistic.commitUT();
            }
        }
    }

    private void utStatSendAck(String str, String str2) {
        SendAckStatistic sendAckStatistic = new SendAckStatistic();
        sendAckStatistic.deviceId = UtilityImpl.getDeviceId(this.mContext);
        sendAckStatistic.dataId = str;
        sendAckStatistic.sendTime = "" + System.currentTimeMillis();
        sendAckStatistic.failReason = "";
        sendAckStatistic.serviceId = str2;
        sendAckStatistic.sessionId = "";
        sendAckStatistic.commitUT();
    }

    public void addTrafficsInfo(final TrafficsMonitor.TrafficInfo trafficInfo) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
                /* class com.taobao.accs.data.MessageHandler.AnonymousClass2 */

                public void run() {
                    TrafficsMonitor trafficsMonitor = MessageHandler.this.mTrafficMonitor;
                    if (trafficsMonitor != null) {
                        trafficsMonitor.addTrafficInfo(trafficInfo);
                    }
                }
            });
        } catch (Throwable th) {
            ALog.e(this.TAG, "addTrafficsInfo", th, new Object[0]);
        }
    }

    public void cancelControlMessage(Message message) {
        if (this.unHandleMessage.keySet().size() > 0) {
            for (Message.Id id : this.unHandleMessage.keySet()) {
                Message message2 = this.unHandleMessage.get(id);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.TAG, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public ReceiveMsgStat getReceiveMsgStat() {
        return this.mReceiveMsgStat;
    }

    public int getUnhandledCount() {
        return this.unHandleMessage.size();
    }

    public Message getUnhandledMessage(String str) {
        return this.unHandleMessage.get(new Message.Id(0, str));
    }

    public Set<Message.Id> getUnhandledMessageIds() {
        return this.unHandleMessage.keySet();
    }

    public Collection<Message> getUnhandledMessages() {
        return this.unHandleMessage.values();
    }

    public boolean getUnrcvPing() {
        return this.unRevPing;
    }

    public void onMessage(byte[] bArr) throws IOException {
        onMessage(bArr, null);
    }

    public void onNetworkFail(int i) {
        this.unRevPing = false;
        Message.Id[] idArr = (Message.Id[]) this.unHandleMessage.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.TAG, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message remove = this.unHandleMessage.remove(id);
                if (remove != null) {
                    onResult(remove, i);
                }
            }
        }
    }

    public void onRcvPing() {
        ALog.d(this.TAG, "onRcvPing", new Object[0]);
        synchronized (MessageHandler.class) {
            this.unRevPing = false;
        }
    }

    public void onResult(Message message, int i) {
        onResult(message, i, null, null, null);
    }

    public void onSend(Message message) {
        String str;
        Message message2 = this.mLastSendMessage;
        if (!(message2 == null || (str = message.cunstomDataId) == null || message.serviceId == null || !message2.cunstomDataId.equals(str) || !this.mLastSendMessage.serviceId.equals(message.serviceId))) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() != -1 && message.getType() != 2 && !message.isAck) {
            this.unHandleMessage.put(message.getMsgId(), message);
        }
    }

    public void onSendPing() {
        ALog.d(this.TAG, "onSendPing", new Object[0]);
        synchronized (MessageHandler.class) {
            this.unRevPing = true;
        }
    }

    public Message removeUnhandledMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.unHandleMessage.remove(new Message.Id(0, str));
        }
        return null;
    }

    public void restoreTraffics() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.mRestoreTrafficsRunnable);
        } catch (Throwable th) {
            ALog.e(this.TAG, "restoreTraffics", th, new Object[0]);
        }
    }

    public void setReceiveMsgStat(ReceiveMsgStat receiveMsgStat) {
        this.mReceiveMsgStat = receiveMsgStat;
    }

    public void onMessage(byte[] bArr, String str) throws IOException {
        onMessage(bArr, str, 0);
    }

    public void onResult(Message message, int i, Map<Integer, String> map) {
        onResult(message, i, null, null, map);
    }

    public void onMessage(byte[] bArr, String str, long j) throws IOException {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.TAG, "onMessage", "host", str);
        }
        MessageStreamReader messageStreamReader = new MessageStreamReader(bArr);
        try {
            int readByte = messageStreamReader.readByte();
            int i = (readByte & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                String str2 = this.TAG;
                ALog.d(str2, "version:" + i, new Object[0]);
            }
            int i2 = readByte & 15;
            if (ALog.isPrintLog(level)) {
                String str3 = this.TAG;
                ALog.d(str3, "compress:" + i2, new Object[0]);
            }
            int readByte2 = messageStreamReader.readByte();
            int readShort = messageStreamReader.readShort();
            if (ALog.isPrintLog(level)) {
                String str4 = this.TAG;
                ALog.d(str4, "totalLen:" + readShort, new Object[0]);
            }
            int i3 = 0;
            while (i3 < readShort) {
                int readShort2 = messageStreamReader.readShort();
                int i4 = i3 + 2;
                if (readShort2 > 0) {
                    byte[] bArr2 = new byte[readShort2];
                    messageStreamReader.read(bArr2);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        String str5 = this.TAG;
                        ALog.d(str5, "buf len:" + readShort2, new Object[0]);
                    }
                    handleMessage(i2, bArr2, str, i, readByte2, j);
                    i3 = i4 + readShort2;
                } else {
                    throw new IOException("data format error");
                }
            }
        } catch (Throwable th) {
            messageStreamReader.close();
            throw th;
        }
        messageStreamReader.close();
    }

    public void onResult(Message message, int i, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command == null || message.getType() < 0 || message.getType() == 2) {
            ALog.d(this.TAG, "onError, skip ping/ack", new Object[0]);
            return;
        }
        String str = message.cunstomDataId;
        if (str != null) {
            this.reqTasks.remove(str);
        }
        Message.ReqType reqType2 = null;
        if (this.mAntiBrush.checkAntiBrush(message.host, map)) {
            i = 70022;
            reqType = null;
            bArr = null;
            map = null;
        }
        int updateFlowCtrlInfo = this.mFlowControl.updateFlowCtrlInfo(map, message.serviceId);
        if (updateFlowCtrlInfo != 0) {
            i = updateFlowCtrlInfo == 2 ? 70021 : updateFlowCtrlInfo == 3 ? 70023 : 70020;
            bArr = null;
            map = null;
        } else {
            reqType2 = reqType;
        }
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.TAG, "onResult", "command", message.command, "erorcode", Integer.valueOf(i));
        }
        if (message.command.intValue() != 102) {
            if (message.isCancel) {
                ALog.e(this.TAG, "onResult message is cancel", "command", message.command);
                monitorPerf(message, i, true);
            } else if (!isNetWorkError(i) || message.command.intValue() == 100 || message.retryTimes > Message.CONTROL_MAX_RETRY_TIMES) {
                monitorPerf(message, i, true);
                Intent buildBaseReceiveIntent = buildBaseReceiveIntent(message);
                buildBaseReceiveIntent.putExtra("errorCode", i);
                Message.ReqType valueOf = Message.ReqType.valueOf((message.flags >> 13) & 3);
                if (reqType2 == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                    buildBaseReceiveIntent.putExtra(Constants.KEY_SEND_TYPE, "res");
                }
                if (i == 200) {
                    buildBaseReceiveIntent.putExtra("data", bArr);
                }
                buildBaseReceiveIntent.putExtra("appKey", this.mConnection.mAppkey);
                buildBaseReceiveIntent.putExtra(Constants.KEY_CONFIG_TAG, this.mConnection.mConfigTag);
                putExtHeaderToIntent(map, buildBaseReceiveIntent);
                MsgDistribute.getInstance().distribute(this.mContext, buildBaseReceiveIntent);
                if (!TextUtils.isEmpty(message.serviceId)) {
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i + " dataId=" + message.dataId, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
                    StringBuilder sb = new StringBuilder();
                    sb.append("1commandId=");
                    sb.append(message.command);
                    sb.append("serviceId=");
                    sb.append(message.serviceId);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                }
            } else {
                message.startSendTime = System.currentTimeMillis();
                int i2 = message.retryTimes + 1;
                message.retryTimes = i2;
                ALog.d(this.TAG, "onResult", "retryTimes", Integer.valueOf(i2));
                this.mConnection.send(message, true);
                monitorPerf(message, i, true);
            }
            utStat(message, i);
        }
    }
}
