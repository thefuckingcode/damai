package com.youku.upsplayer.util;

import android.text.TextUtils;
import com.youku.upsplayer.IVideoInfoCallBack;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.Segs;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.util.PlayStageTracker;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class GetInfoThread {
    public static final String TAG = "GetInfoThread";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private IVideoInfoCallBack callBack;
    private RequestData request;
    private INetworkTask task;

    public GetInfoThread(RequestData requestData, INetworkTask iNetworkTask, IVideoInfoCallBack iVideoInfoCallBack) {
        this.request = requestData;
        this.task = iNetworkTask;
        this.callBack = iVideoInfoCallBack;
    }

    private void checkStreamUrl(Stream[] streamArr, Stream[] streamArr2) {
        if (streamArr == null || streamArr2 == null) {
            String str = TAG;
            Logger.e(str, "will not check streamsOld:" + streamArr2);
            return;
        }
        for (int i = 0; i < streamArr.length; i++) {
            Segs[] segsArr = streamArr[i].segs;
            Segs[] segsArr2 = streamArr2[i].segs;
            for (int i2 = 0; i2 < segsArr.length; i2++) {
                if (segsArr2[i2].cdn_url != null) {
                    boolean checkUrlIfEquals = checkUrlIfEquals(segsArr[i2].cdn_url, segsArr2[i2].cdn_url);
                    if (!checkUrlIfEquals) {
                        AssertUtil.assertTrue(checkUrlIfEquals, "cdn url check failed i:" + i + ";j:" + i2 + ":" + segsArr[i2].cdn_url + StringUtils.LF + segsArr2[i2].cdn_url);
                    }
                    if (segsArr2[i2].cdn_backup.length >= 1) {
                        for (int i3 = 0; i3 < segsArr2[i2].cdn_backup.length; i3++) {
                            if (!checkUrlIfEquals(segsArr[i2].cdn_backup[i3], segsArr2[i2].cdn_backup[i3])) {
                                AssertUtil.assertTrue(checkUrlIfEquals, "i:" + i + ";j:" + i2 + ";k:" + i3 + ":" + segsArr[i3].cdn_backup + StringUtils.LF + segsArr2[i3].cdn_backup);
                            }
                        }
                    }
                }
                if (segsArr2[i2].rtmp_url != null) {
                    boolean equalsIgnoreCase = segsArr2[i2].rtmp_url.equalsIgnoreCase(segsArr[i2].rtmp_url);
                    if (!equalsIgnoreCase) {
                        AssertUtil.assertTrue(equalsIgnoreCase, "rtmp url check failed i:" + i + ";j:" + i2 + ":" + segsArr[i2].rtmp_url + StringUtils.LF + segsArr2[i2].rtmp_url);
                    }
                    if (segsArr2[i2].cdn_backup.length >= 1) {
                        for (int i4 = 0; i4 < segsArr2[i2].cdn_backup.length; i4++) {
                            if (!segsArr2[i2].cdn_backup[i4].equalsIgnoreCase(segsArr[i2].cdn_backup[i4])) {
                                AssertUtil.assertTrue(equalsIgnoreCase, "i:" + i + ";j:" + i2 + ";k:" + i4 + ":" + segsArr[i4].cdn_backup + StringUtils.LF + segsArr2[i4].cdn_backup);
                            }
                        }
                    }
                }
            }
        }
        Logger.d(TAG, "check url finished");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    private boolean checkUrlIfEquals(String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = TAG;
            str4 = "urla or urlb is null";
        } else {
            String[] split = str.split("\\?");
            String[] split2 = str2.split("\\?");
            if (!split[0].equalsIgnoreCase(split2[0]) || split.length < 2 || split2.length < 2) {
                str3 = TAG;
                str4 = "uri is not same";
            } else {
                Map<String, String> mapFromPath = getMapFromPath(split[1]);
                Map<String, String> mapFromPath2 = getMapFromPath(split2[1]);
                for (String str5 : mapFromPath.keySet()) {
                    if (!mapFromPath2.containsKey(str5) || !mapFromPath.get(str5).equals(mapFromPath2.get(str5))) {
                        return false;
                    }
                    while (r2.hasNext()) {
                    }
                }
                return true;
            }
        }
        Logger.d(str3, str4);
        return false;
    }

    public static String decode(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            Logger.e(str2, "decode " + e.toString());
            e.printStackTrace();
            return str;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            Logger.e(str2, "encode " + e.toString());
            e.printStackTrace();
            return str;
        }
    }

    private Map<String, String> getMapFromPath(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            if (split[0] != null) {
                hashMap.put(split[0], split.length > 1 ? split[1] : "");
            }
        }
        return hashMap;
    }

    private void setAntiTheftUtData(VideoInfo videoInfo, GetInfoResult getInfoResult) {
        boolean z;
        UtAntiTheaftBean utAntiTheaftBean;
        getInfoResult.connectStat.utMsg = new UtAntiTheaftBean();
        UtAntiTheaftBean utAntiTheaftBean2 = getInfoResult.connectStat.utMsg;
        RequestData requestData = this.request;
        utAntiTheaftBean2.ccode = requestData.ccode;
        utAntiTheaftBean2.ckey = decode(requestData.ckey);
        UtAntiTheaftBean utAntiTheaftBean3 = getInfoResult.connectStat.utMsg;
        RequestData requestData2 = this.request;
        utAntiTheaftBean3.isCkeyError = requestData2.isCkeyError;
        utAntiTheaftBean3.ckeyErrorMsg = requestData2.ckeyErrorMsg;
        String str = null;
        if (videoInfo.getUps() != null) {
            getInfoResult.connectStat.utMsg.psid = videoInfo.getUps().psid;
            getInfoResult.connectStat.utMsg.upsClientNetip = videoInfo.getUps().ups_client_netip;
        } else {
            UtAntiTheaftBean utAntiTheaftBean4 = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean4.psid = null;
            utAntiTheaftBean4.upsClientNetip = null;
        }
        if (videoInfo.getVideo() != null) {
            getInfoResult.connectStat.utMsg.title = encode(videoInfo.getVideo().title);
        } else {
            getInfoResult.connectStat.utMsg.title = null;
        }
        if (videoInfo.getUser() != null) {
            UtAntiTheaftBean utAntiTheaftBean5 = getInfoResult.connectStat.utMsg;
            if (!videoInfo.getUser().uid.isEmpty()) {
                str = videoInfo.getUser().uid;
            }
            utAntiTheaftBean5.uid = str;
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            z = videoInfo.getUser().vip;
        } else {
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean.uid = null;
            z = false;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        utAntiTheaftBean.vip = i;
        getInfoResult.connectStat.utMsg.utid = decode(this.request.utid);
        ConnectStat connectStat = getInfoResult.connectStat;
        UtAntiTheaftBean utAntiTheaftBean6 = connectStat.utMsg;
        RequestData requestData3 = this.request;
        utAntiTheaftBean6.vid = requestData3.vid;
        utAntiTheaftBean6.log_type = 5;
        utAntiTheaftBean6.clientid = requestData3.clientid;
        videoInfo.setConnectStat(connectStat);
    }

    public VideoInfo processData(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i;
        String str = TAG;
        Logger.d(str, "processData");
        if (getInfoResult == null || getInfoResult.connectStat == null) {
            return null;
        }
        Logger.d(str, "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
        StringBuilder sb = new StringBuilder();
        sb.append("http result data =");
        sb.append(getInfoResult.data);
        Logger.d(str, sb.toString());
        if (!getInfoResult.connectStat.connect_success) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(getInfoResult.data)) {
                return null;
            }
            VideoInfo parseData = ParseResult.parseData(getInfoResult.data);
            parseData.setStream(ParseResult.parseStream(parseData.getStreamJson()));
            return parseData;
        } catch (Exception e) {
            Logger.e(TAG, e.toString());
            String str2 = getInfoResult.data;
            if (str2 == null) {
                return null;
            }
            if (str2.contains(UPS_WEB_ANTI)) {
                connectStat = getInfoResult.connectStat;
                connectStat.connect_success = false;
                i = ErrorConstants.ERROR_UPS_WEB_ANTI;
            } else if (!getInfoResult.data.contains(UPS_WEB_FLOW_LIMIT)) {
                return null;
            } else {
                connectStat = getInfoResult.connectStat;
                connectStat.connect_success = false;
                i = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
            }
            connectStat.response_code = i;
            return null;
        }
    }

    public void run() {
        UpsTimeTraceBean upsTimeTraceBean;
        UpsTimeTraceBean upsTimeTraceBean2;
        UpsTimeTraceBean upsTimeTraceBean3;
        UpsTimeTraceBean upsTimeTraceBean4;
        String str = TAG;
        Logger.d(str, "run start");
        PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
        upsRequest.beginSection("apiRequest");
        RequestData requestData = this.request;
        if (!(requestData == null || (upsTimeTraceBean4 = requestData.upsTimeTraceBean) == null)) {
            upsTimeTraceBean4.traceTimeStartRequest();
        }
        GetInfoResult data = this.task.getData(this.request);
        upsRequest.endSection();
        RequestData requestData2 = this.request;
        if (!(requestData2 == null || (upsTimeTraceBean3 = requestData2.upsTimeTraceBean) == null)) {
            upsTimeTraceBean3.traceTimeStartParseResult();
        }
        VideoInfo processData = processData(data);
        RequestData requestData3 = this.request;
        if (!(requestData3 == null || (upsTimeTraceBean2 = requestData3.upsTimeTraceBean) == null)) {
            upsTimeTraceBean2.traceTimeEndParse();
        }
        RequestData requestData4 = this.request;
        if (!(requestData4 == null || requestData4.upsTimeTraceBean == null)) {
            Logger.d("UpsPlayer", this.request.vid + " total ups parse cost:" + this.request.upsTimeTraceBean.timeEndParse + "; compress:" + this.request.compress);
        }
        if (processData != null) {
            setAntiTheftUtData(processData, data);
        }
        if (this.callBack != null) {
            Logger.d("UpsPlayer", "call back result");
            RequestData requestData5 = this.request;
            if (!(requestData5 == null || (upsTimeTraceBean = requestData5.upsTimeTraceBean) == null)) {
                ConnectStat connectStat = data.connectStat;
                connectStat.mUpsTimeTraceBean = upsTimeTraceBean;
                connectStat.rawUpsData = data.data;
            }
            this.callBack.onGetVideoInfoResult(processData, data.connectStat);
        }
        Logger.d(str, "run finish");
    }
}
