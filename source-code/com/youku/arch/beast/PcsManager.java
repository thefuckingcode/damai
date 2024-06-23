package com.youku.arch.beast;

import android.content.Context;
import android.util.Log;
import com.ali.user.open.core.exception.RpcException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsException;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.orange.OrangeConfig;
import com.ut.device.UTDevice;
import com.youku.arch.beast.PcsAccsService;
import com.youku.arch.beast.apas.Apas;
import com.youku.arch.beast.stats.ApasUtProxy;

/* compiled from: Taobao */
public class PcsManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DOWNSTREAM_SERVICE_CLASS_NAME = "com.youku.player.accs.PlayerAccsService";
    public static final String SERVICE_ID = "accs-youku-scheduler";
    private static TaoBaseService downstreamService;
    private static Context sApplicationContext;

    /* compiled from: Taobao */
    public static class PcsCommandConfirmation {
        private static transient /* synthetic */ IpChange $ipChange;
        private String cmdId;
        private int cmdType;
        private PcsResponseCode responseCode;

        PcsCommandConfirmation(int i, String str, PcsResponseCode pcsResponseCode) {
            this.cmdType = i;
            this.cmdId = str;
            this.responseCode = pcsResponseCode;
        }

        /* access modifiers changed from: package-private */
        public String formJSONString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1057075558")) {
                return (String) ipChange.ipc$dispatch("1057075558", new Object[]{this});
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", (Object) 99);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cmdId", (Object) this.cmdId);
            jSONObject2.put("cmdType", (Object) Integer.valueOf(this.cmdType));
            jSONObject2.put("deviceId", (Object) UTDevice.getUtdid(PcsManager.sApplicationContext));
            jSONObject2.put("success", (Object) Integer.valueOf(this.responseCode.code));
            jSONObject2.put("ext", (Object) "");
            jSONObject.put("content", (Object) jSONObject2);
            return jSONObject.toJSONString();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum PcsResponseCode {
        RSPN_SUCCESS(200),
        RSPN_REDUNDANT(402),
        RSPN_ILLEGAL(400),
        RSPN_CONTENT_ILLEGAL(RpcException.ErrorCode.API_UNAUTHORIZED);
        
        public final int code;

        private PcsResponseCode(int i) {
            this.code = i;
        }
    }

    private static void ensureDownstreamService() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199624394")) {
            ipChange.ipc$dispatch("-1199624394", new Object[0]);
        } else if (downstreamService == null) {
            synchronized (PcsManager.class) {
                if (downstreamService == null) {
                    try {
                        downstreamService = (TaoBaseService) Class.forName(DOWNSTREAM_SERVICE_CLASS_NAME).newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337554055")) {
            ipChange.ipc$dispatch("-1337554055", new Object[]{context});
            return;
        }
        sApplicationContext = context.getApplicationContext();
        Log.d("BeastLib", "pcsManager registered");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0129 A[SYNTHETIC, Splitter:B:42:0x0129] */
    public static String parseAndUpdate(String str, PcsAccsService.PackedRawAccsData packedRawAccsData, String str2) {
        PcsCommandConfirmation pcsCommandConfirmation;
        String str3;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317447439")) {
            return (String) ipChange.ipc$dispatch("-1317447439", new Object[]{str, packedRawAccsData, str2});
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            int intValue = parseObject.getIntValue("cmdType");
            str3 = parseObject.getString("cmdId");
            if (intValue == 1 || intValue == 2) {
                ensureDownstreamService();
                downstreamService.onData(packedRawAccsData.s, packedRawAccsData.s1, packedRawAccsData.s2, packedRawAccsData.data, packedRawAccsData.extraInfo);
            } else {
                switch (intValue) {
                    case 32:
                    case 33:
                        if (str3 != null) {
                            try {
                                if (!str3.equals(str2)) {
                                    JSONObject jSONObject = parseObject.getJSONObject("content");
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("data", (Object) jSONObject);
                                    Apas.getInstance().setInitialRequest(true);
                                    Apas.getInstance().updateConfigData(jSONObject2.toJSONString());
                                    pcsCommandConfirmation = new PcsCommandConfirmation(intValue, str3, PcsResponseCode.RSPN_SUCCESS);
                                    try {
                                        ApasUtProxy.getInstance().reportApsStats("push");
                                        Log.d("BeastLib", "data:" + parseObject.toJSONString());
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    if (pcsCommandConfirmation != null) {
                                        try {
                                            ACCSClient.getAccsClient("youku").sendData(new ACCSManager.AccsRequest(null, SERVICE_ID, pcsCommandConfirmation.formJSONString().getBytes(), null));
                                        } catch (AccsException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    return str3;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                pcsCommandConfirmation = null;
                                th.printStackTrace();
                                if (pcsCommandConfirmation != null) {
                                }
                                return str3;
                            }
                        }
                        pcsCommandConfirmation = new PcsCommandConfirmation(intValue, str3, PcsResponseCode.RSPN_REDUNDANT);
                        Log.d("BeastLib", "data:" + parseObject.toJSONString());
                        if (pcsCommandConfirmation != null) {
                        }
                        return str3;
                    case 34:
                        if ("1".equals(OrangeConfig.getInstance().getConfig("aps_config", "aps_heartbeat_update_enable", "0")) && !Apas.getInstance().isLocalMode() && parseObject.getJSONObject("content") != null && parseObject.getJSONObject("content").getJSONObject("apsConfigJson") != null) {
                            JSONObject jSONObject3 = parseObject.getJSONObject("content").getJSONObject("apsConfigJson");
                            if (!jSONObject3.getBoolean("reload").booleanValue()) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("data", (Object) jSONObject3);
                                Apas.getInstance().setInitialRequest(true);
                                Apas.getInstance().updateConfigData(jSONObject4.toJSONString());
                                ApasUtProxy.getInstance().reportApsStats("heartbeat");
                                break;
                            }
                        }
                        break;
                    case 35:
                        break;
                    default:
                        pcsCommandConfirmation = new PcsCommandConfirmation(intValue, str3, PcsResponseCode.RSPN_ILLEGAL);
                        str3 = null;
                        Log.d("BeastLib", "data:" + parseObject.toJSONString());
                        if (pcsCommandConfirmation != null) {
                        }
                        return str3;
                }
            }
            pcsCommandConfirmation = null;
            str3 = null;
            Log.d("BeastLib", "data:" + parseObject.toJSONString());
        } catch (Throwable th4) {
            th = th4;
            pcsCommandConfirmation = null;
            str3 = null;
            th.printStackTrace();
            if (pcsCommandConfirmation != null) {
            }
            return str3;
        }
        if (pcsCommandConfirmation != null) {
        }
        return str3;
    }
}
