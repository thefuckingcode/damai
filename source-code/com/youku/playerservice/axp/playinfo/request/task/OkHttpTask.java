package com.youku.playerservice.axp.playinfo.request.task;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.b;
import com.youku.network.config.YKNetworkConfig;
import com.youku.network.d;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SwitchConfigUtil;
import org.json.JSONObject;
import tb.jl1;
import tb.ny0;

/* compiled from: Taobao */
public class OkHttpTask implements INetworkTask {
    private static final String STRENGY_NAME = "ups_per_flow_switch";
    private static final String TAG = "OkHttpTask";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private static final String YK_USER_AGENT = "yk-user-agent";
    private static long flowLimitTime;
    private long apiLockInterval = 0;
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;
    private Context mContext;
    private UpsProxyInfo mProxyInfo;
    private int[] mTimeOut = null;
    private boolean mtopUnit = true;
    private String recvData = null;

    public OkHttpTask(Context context, int[] iArr, UpsProxyInfo upsProxyInfo) {
        this.mTimeOut = iArr;
        this.mContext = context;
        this.mProxyInfo = upsProxyInfo;
        try {
            long longValue = Long.valueOf(ConfigFetcher.getInstance().getConfig("youku_player_config", SwitchConfigUtil.API_LOCK_INTERVAL_KEY, "0")).longValue();
            if (longValue > 0) {
                this.apiLockInterval = longValue * 1000;
            }
        } catch (Exception e) {
            if (Logger.DEBUG) {
                String str = TAG;
                Logger.d(str, "get config exception:" + e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x033a, code lost:
        if (r0 != 29405) goto L_0x0351;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014e  */
    private boolean connectAPI(RequestData requestData) {
        Exception e;
        String str;
        boolean z;
        String str2 = "POST";
        boolean z2 = false;
        if (TextUtils.isEmpty(requestData.url)) {
            return false;
        }
        UpsProxyInfo upsProxyInfo = this.mProxyInfo;
        if (upsProxyInfo != null) {
            requestData.url = upsProxyInfo.createUrlByType(requestData.url, requestData.vid);
        }
        String str3 = null;
        this.recvData = null;
        ConnectStat connectStat2 = this.connectStat;
        connectStat2.url = requestData.url;
        connectStat2.connect_success = false;
        connectStat2.mTopUpsRequest = requestData.mTopUpsRequest;
        try {
            if (System.currentTimeMillis() - flowLimitTime < this.apiLockInterval) {
                ConnectStat connectStat3 = this.connectStat;
                connectStat3.response_code = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                connectStat3.connect_success = false;
                return false;
            }
            TLogUtil.playLog("-----> connectAPI url :" + requestData.url);
            b.a aVar = new b.a();
            aVar.b(requestData.url);
            aVar.a(requestData.connect_timeout);
            aVar.b(requestData.read_timeout);
            aVar.a(IRequestConst.USER_AGENT, requestData.agent);
            aVar.a(true);
            if (!str2.equalsIgnoreCase(ConfigFetcher.getInstance().getConfig("youku_player_config", "ups_http_method", "GET"))) {
                str2 = "GET";
            }
            aVar.e(str2);
            if (!TextUtils.isEmpty(requestData.host)) {
                aVar.d(requestData.host);
            }
            if (!TextUtils.isEmpty(requestData.ip)) {
                aVar.c(requestData.ip);
            }
            if (!TextUtils.isEmpty(requestData.cookie)) {
                TLogUtil.httpLog("-----> cookie :" + requestData.cookie);
                aVar.a(IRequestConst.COOKIE, requestData.cookie);
            }
            String str4 = requestData.url;
            if (str4 == null || !str4.contains("//ups.youku.com/ups/get")) {
                aVar.a(YKNetworkConfig.a(requestData.url));
                str = "upstype--" + YKNetworkConfig.a(requestData.url);
            } else {
                aVar.a(YKNetworkConfig.CallType.OKHTTP);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (ApsUtil.httpDnsEnable()) {
                    try {
                        ArrayList<ny0.a> b = ny0.b("ups.youku.com", true);
                        if (b != null && b.size() > 0) {
                            String b2 = b.get(0).b();
                            aVar.c(b2);
                            Logger.e("upstype--okhttp,setIp:" + b2);
                            z = true;
                            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            Logger.e("upstype--okhttp, costTime:" + elapsedRealtime2);
                            this.connectStat.statsMap.put("okhttp_ip_cost_time", String.valueOf(elapsedRealtime2));
                            this.connectStat.statsMap.put("okhttp_use_httpdns", !z ? "1" : "0");
                            str = "upstype--okhttp";
                        }
                    } catch (Exception unused) {
                    }
                }
                z = false;
                long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime;
                Logger.e("upstype--okhttp, costTime:" + elapsedRealtime22);
                this.connectStat.statsMap.put("okhttp_ip_cost_time", String.valueOf(elapsedRealtime22));
                this.connectStat.statsMap.put("okhttp_use_httpdns", !z ? "1" : "0");
                str = "upstype--okhttp";
            }
            Logger.e(str);
            UpsProxyInfo upsProxyInfo2 = this.mProxyInfo;
            if (upsProxyInfo2 != null) {
                aVar.d(upsProxyInfo2.getHeader_host());
                aVar.c(this.mProxyInfo.getUps_host_ip());
                aVar.a(YKNetworkConfig.CallType.OKHTTP);
            }
            if (Logger.DEBUG) {
                Logger.d(TAG, "data.upsType=" + requestData.upsType);
            }
            b a = aVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            d b3 = a.b();
            this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            try {
                str3 = b3.c() ? b3.i().getMtopStat().getNetworkStats().ip_port : b3.g().ip_port;
            } catch (Exception unused2) {
            }
            hashMap.put("svip", str3);
            this.connectStat.statsMap = hashMap;
            boolean h = b3.h();
            TLogUtil.httpLog("http ups apiSuccess = " + h + ": " + requestData.url + " upsType=" + requestData.upsType + " ykResponse=" + b3);
            this.connectStat.response_code = b3.d();
            int b4 = b3.b();
            if (h) {
                ConnectStat connectStat4 = this.connectStat;
                int i = connectStat4.response_code;
                if (i == 200) {
                    connectStat4.connect_success = true;
                    try {
                        if (b3.c()) {
                            JSONObject dataJsonObject = b3.i().getDataJsonObject();
                            if (dataJsonObject != null) {
                                this.recvData = dataJsonObject.toString();
                            }
                        } else {
                            byte[] e2 = b3.e();
                            if (e2 != null) {
                                String str5 = new String(e2);
                                this.recvData = str5;
                                if (str5.contains(UPS_WEB_ANTI)) {
                                    ConnectStat connectStat5 = this.connectStat;
                                    connectStat5.response_code = ErrorConstants.ERROR_UPS_WEB_ANTI;
                                    connectStat5.connect_success = false;
                                }
                                if (this.recvData.contains(UPS_WEB_FLOW_LIMIT)) {
                                    flowLimitTime = System.currentTimeMillis();
                                    ConnectStat connectStat6 = this.connectStat;
                                    connectStat6.response_code = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                                    connectStat6.connect_success = false;
                                }
                            }
                        }
                        this.connectStat.read_time = System.currentTimeMillis() - currentTimeMillis2;
                        if (Logger.DEBUG) {
                            Logger.d(TAG, "httpConn read time=" + this.connectStat.read_time);
                        }
                        this.connectStat.header = b3.f();
                    } catch (Exception e3) {
                        e = e3;
                        this.connectStat.errMsg = e.toString();
                        e.printStackTrace();
                        Logger.e(TAG, e.getMessage());
                        TLogUtil.httpLog(Log.getStackTraceString(e));
                        return z2;
                    }
                    return z2;
                }
                connectStat4.response_code = com.youku.network.config.b.a(i, b4);
                TLogUtil.httpLog("http fail " + this.connectStat.response_code);
                Logger.e(TAG, "http fail " + this.connectStat.response_code);
            } else {
                ConnectStat connectStat7 = this.connectStat;
                connectStat7.response_code = com.youku.network.config.b.a(connectStat7.response_code, b4);
                Logger.e(TAG, "api call fail " + this.connectStat.response_code);
                TLogUtil.httpLog("api call fail " + this.connectStat.response_code);
                int i2 = this.connectStat.response_code;
                if (i2 != 28108) {
                    if (i2 == 28115 || i2 == 28168) {
                        TLogUtil.httpLog("downgrade to http");
                        requestData.upsType = 2;
                    } else if (i2 != 29202) {
                        if (i2 != 29204) {
                        }
                    }
                }
                if (this.mtopUnit) {
                    this.mtopUnit = false;
                    TLogUtil.httpLog("mtop unit downgrade");
                }
            }
            z2 = true;
            this.connectStat.header = b3.f();
            return z2;
        } catch (Exception e4) {
            e = e4;
            z2 = true;
            this.connectStat.errMsg = e.toString();
            e.printStackTrace();
            Logger.e(TAG, e.getMessage());
            TLogUtil.httpLog(Log.getStackTraceString(e));
            return z2;
        }
    }

    private String convertMapToDataStr(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(jl1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!(key == null || value == null)) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(value));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[converMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(value);
                        sb2.append(" to dataStr error.");
                        Logger.e("mtopsdk.ups ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        if (requestData == null) {
            return null;
        }
        Logger.d(TAG, "getData");
        if (this.mTimeOut == null) {
            this.mTimeOut = new int[]{5000, 15000};
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mTimeOut;
            if (i >= iArr.length) {
                break;
            }
            int i2 = iArr[i];
            requestData.connect_timeout = i2;
            requestData.read_timeout = i2;
            if (Logger.DEBUG) {
                String str = TAG;
                Logger.d(str, "connectAPI " + i + " timeout=" + requestData.connect_timeout);
            }
            if (!connectAPI(requestData)) {
                break;
            }
            i++;
        }
        TLogUtil.playLog("NewHttpTask getData done");
        return new GetInfoResult(this.recvData, this.header, this.connectStat);
    }
}
