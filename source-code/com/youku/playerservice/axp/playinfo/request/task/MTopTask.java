package com.youku.playerservice.axp.playinfo.request.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.arch.ntk.interfere.g;
import com.youku.d.a;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.b;
import com.youku.network.config.YKNetworkConfig;
import com.youku.network.d;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.UpsUtil;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SwitchConfigUtil;
import mtopsdk.mtop.domain.MethodEnum;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class MTopTask implements INetworkTask {
    private static final String STRENGY_NAME = "ups_per_flow_switch";
    private static final String TAG = "MTopTask";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private static final String YK_USER_AGENT = "yk-user-agent";
    private static long flowLimitTime;
    private long apiLockInterval = 0;
    private ConnectStat connectStat = new ConnectStat();
    private String detectInfo;
    private Map<String, List<String>> header = null;
    private Context mContext;
    private UpsProxyInfo mProxyInfo;
    private int[] mTimeOut = null;
    private boolean mtopUnit = true;
    private String recvData = null;

    public MTopTask(Context context, int[] iArr, UpsProxyInfo upsProxyInfo) {
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

    /* JADX WARNING: Removed duplicated region for block: B:105:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x022a A[Catch:{ Exception -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0239 A[Catch:{ Exception -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0342  */
    private boolean connectAPI(RequestData requestData) {
        Exception e;
        String str;
        boolean h;
        boolean z;
        String str2;
        String str3;
        boolean z2 = false;
        if (TextUtils.isEmpty(requestData.url)) {
            return false;
        }
        UpsProxyInfo upsProxyInfo = this.mProxyInfo;
        if (upsProxyInfo != null) {
            requestData.url = upsProxyInfo.createUrlByType(requestData.url, requestData.vid);
        }
        this.recvData = null;
        ConnectStat connectStat2 = this.connectStat;
        connectStat2.url = requestData.url;
        connectStat2.connect_success = false;
        connectStat2.mTopUpsRequest = requestData.mTopUpsRequest;
        connectStat2.statsMap = new HashMap();
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
            aVar.e("POST".equalsIgnoreCase(ConfigFetcher.getInstance().getConfig("youku_player_config", "ups_http_method", "GET")) ? "POST" : "GET");
            if (!TextUtils.isEmpty(requestData.cookie)) {
                TLogUtil.httpLog("-----> cookie :" + requestData.cookie);
                aVar.a(IRequestConst.COOKIE, requestData.cookie);
            }
            if (requestData.mTopUpsRequest != null) {
                aVar.a(STRENGY_NAME);
                aVar.f(requestData.mTopUpsRequest.API_NAME);
                aVar.g(requestData.mTopUpsRequest.VERSION);
                aVar.b(requestData.mTopUpsRequest.NEED_ECODE);
                aVar.c(requestData.connect_timeout);
                aVar.d(requestData.read_timeout);
                aVar.b(YK_USER_AGENT, requestData.agent);
                MethodEnum methodEnum = MethodEnum.POST;
                if ("GET".equalsIgnoreCase(ConfigFetcher.getInstance().getConfig("youku_player_config", "ups_mtop_method", "POST"))) {
                    methodEnum = MethodEnum.GET;
                }
                aVar.a(methodEnum);
                HashMap hashMap = new HashMap();
                hashMap.put(MTopUpsRequest.STEAL_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.stealParamsMap));
                hashMap.put(MTopUpsRequest.BIZ_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.bizParamsMap));
                hashMap.put(MTopUpsRequest.AD_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.adParamsMap));
                aVar.h(convertMapToDataStr(hashMap));
                if ("1".equalsIgnoreCase(ConfigFetcher.getInstance().getConfig("youku_player_config", "ups_with_wua", "1"))) {
                    aVar.e(0);
                }
                boolean enableUpsMtopServerUnit = this.mtopUnit & ApsUtil.enableUpsMtopServerUnit();
                this.mtopUnit = enableUpsMtopServerUnit;
                if (enableUpsMtopServerUnit) {
                    int envMode = a.a().getMtopConfig().envMode.getEnvMode();
                    if (envMode == 0) {
                        str3 = "un-acs.youku.com";
                    } else if (envMode == 1) {
                        str3 = "pre-un-acs.youku.com";
                    }
                    aVar.i(str3);
                }
            }
            UpsProxyInfo upsProxyInfo2 = this.mProxyInfo;
            if (upsProxyInfo2 != null) {
                aVar.d(upsProxyInfo2.getHeader_host());
                aVar.c(this.mProxyInfo.getUps_host_ip());
                aVar.a(YKNetworkConfig.CallType.OKHTTP);
                this.connectStat.statsMap.put("okhttp_host", requestData.host);
                this.connectStat.statsMap.put("okhttp_ip", requestData.ip);
            } else {
                if (requestData.upsType == 3) {
                    aVar.a(YKNetworkConfig.CallType.MTOP);
                    str2 = "upstype--mtop";
                } else if (TextUtils.isEmpty(requestData.host) || TextUtils.isEmpty(requestData.ip)) {
                    YKNetworkConfig.CallType a = YKNetworkConfig.a(requestData.url);
                    aVar.a(a);
                    str2 = "upstype--" + a;
                } else {
                    aVar.d(requestData.host);
                    aVar.c(requestData.ip);
                    aVar.a(YKNetworkConfig.CallType.OKHTTP);
                    this.connectStat.statsMap.put("okhttp_host", requestData.host);
                    this.connectStat.statsMap.put("okhttp_ip", requestData.ip);
                }
                Logger.e(str2);
                b a2 = aVar.a();
                long currentTimeMillis = System.currentTimeMillis();
                d b = a2.b();
                this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis2 = System.currentTimeMillis();
                str = !b.c() ? b.i().getMtopStat().getNetworkStats().ip_port : b.g().ip_port;
                this.connectStat.statsMap.put("svip", str);
                h = b.h();
                TLogUtil.httpLog("http ups apiSuccess = " + h + ": " + requestData.url + " upsType=" + requestData.upsType + " ykResponse=" + b);
                this.connectStat.response_code = b.d();
                int b2 = b.b();
                if (!h) {
                    ConnectStat connectStat4 = this.connectStat;
                    int i = connectStat4.response_code;
                    if (i == 200) {
                        connectStat4.connect_success = true;
                        try {
                            if (b.c()) {
                                JSONObject dataJsonObject = b.i().getDataJsonObject();
                                if (dataJsonObject != null) {
                                    this.recvData = dataJsonObject.toString();
                                }
                            } else {
                                byte[] e2 = b.e();
                                if (e2 != null) {
                                    String str4 = new String(e2);
                                    this.recvData = str4;
                                    if (str4.contains(UPS_WEB_ANTI)) {
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
                            this.connectStat.header = b.f();
                            if (!TextUtils.isEmpty(this.detectInfo)) {
                                this.connectStat.statsMap.put("detectInfo", this.detectInfo);
                            }
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
                    connectStat4.response_code = com.youku.network.config.b.a(i, b2);
                    TLogUtil.httpLog("http fail " + this.connectStat.response_code);
                    Logger.e(TAG, "http fail " + this.connectStat.response_code);
                } else {
                    ConnectStat connectStat7 = this.connectStat;
                    connectStat7.response_code = com.youku.network.config.b.a(connectStat7.response_code, b2);
                    Logger.e(TAG, "api call fail " + this.connectStat.response_code);
                    TLogUtil.httpLog("api call fail " + this.connectStat.response_code);
                    if (!TextUtils.isEmpty(requestData.url) && (TextUtils.isEmpty(requestData.host) || TextUtils.isEmpty(requestData.ip))) {
                        String config = ConfigFetcher.getInstance().getConfig("player_switch", "netWorkDetectErrorCode", null);
                        if (!TextUtils.isEmpty(config) && Arrays.asList(config.split(",")).contains(String.valueOf(this.connectStat.response_code))) {
                            String config2 = ConfigFetcher.getInstance().getConfig("player_switch", "detectTimeOutMS", "200");
                            if (!TextUtils.isEmpty(config2) && TextUtils.isDigitsOnly(config2)) {
                                Uri parse = Uri.parse(requestData.url);
                                g.b a3 = g.a().a(requestData.url, Integer.parseInt(config2)).a();
                                if (!TextUtils.isEmpty(a3.a)) {
                                    requestData.host = parse.getHost();
                                    requestData.ip = a3.a;
                                    TLogUtil.httpLog("getDetectResult get ip " + a3.a);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                this.detectInfo = "errorCode:" + this.connectStat.response_code + ",ip:" + UpsUtil.getTextEncoder(a3.a) + ",detectErrorCode:" + a3.b + ",info:" + UpsUtil.getTextEncoder(a3.c);
                                if (!z) {
                                    TLogUtil.httpLog("downgrade to http");
                                } else {
                                    int i2 = this.connectStat.response_code;
                                    if (i2 != 28108) {
                                        if (i2 == 28115 || i2 == 28168) {
                                            TLogUtil.httpLog("downgrade to http");
                                        } else if (!(i2 == 29202 || i2 == 29204 || i2 == 29405)) {
                                            if (i2 == 29910 || i2 == 29911) {
                                                TLogUtil.httpLog("downgrade to mtop");
                                                requestData.upsType = 3;
                                            }
                                        }
                                    }
                                    if (this.mtopUnit) {
                                        this.mtopUnit = false;
                                        TLogUtil.httpLog("mtop unit downgrade");
                                    }
                                }
                                requestData.upsType = 2;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    requestData.upsType = 2;
                }
                z2 = true;
                this.connectStat.header = b.f();
                if (!TextUtils.isEmpty(this.detectInfo)) {
                }
                return z2;
            }
            Logger.e("upstype--okhttp");
            b a22 = aVar.a();
            long currentTimeMillis3 = System.currentTimeMillis();
            d b3 = a22.b();
            this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis3;
            long currentTimeMillis22 = System.currentTimeMillis();
            try {
                if (!b3.c()) {
                }
            } catch (Exception unused) {
                str = null;
            }
            this.connectStat.statsMap.put("svip", str);
            h = b3.h();
            TLogUtil.httpLog("http ups apiSuccess = " + h + ": " + requestData.url + " upsType=" + requestData.upsType + " ykResponse=" + b3);
            this.connectStat.response_code = b3.d();
            int b22 = b3.b();
            if (!h) {
            }
            z2 = true;
            this.connectStat.header = b3.f();
            if (!TextUtils.isEmpty(this.detectInfo)) {
            }
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
        if (requestData.upsType == 1) {
            requestData.upsType = 3;
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
