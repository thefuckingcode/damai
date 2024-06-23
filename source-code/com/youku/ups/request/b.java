package com.youku.ups.request;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.ups.data.RequestParams;
import com.youku.ups.data.a;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.Logger;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class b {
    private static Set<String> d = new UpsGetRequest$1();
    private static ExecutorService m = Executors.newCachedThreadPool();
    public String a = "http://ups.youku.com";
    protected final int b = 15000;
    protected final int c = 15000;
    private INetworkTask e;
    private NetworkParameter f;
    private RequestParams g;
    private RequestParams h;
    private a<VideoInfo> i;
    private String j;
    private String k;
    private RequestData l = null;
    private boolean n;
    private Context o;
    private final Runnable p = new UpsGetRequest$2(this);

    public b(Context context, INetworkTask iNetworkTask, boolean z) {
        this.o = context;
        this.e = iNetworkTask;
        this.n = z;
    }

    public b(Context context, INetworkTask iNetworkTask, boolean z, String str, String str2) {
        this.o = context;
        this.e = iNetworkTask;
        this.n = z;
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith("/")) {
                String str3 = this.j;
                str = str3.substring(0, str3.length() - 1);
            }
            this.a = str;
            this.j = Uri.parse(str).getHost();
            this.k = str2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MTopUpsRequest a(String str) {
        MTopUpsRequest mTopUpsRequest = new MTopUpsRequest();
        mTopUpsRequest.API_NAME = "mtop.youku.play.ups.appinfo.get";
        mTopUpsRequest.VERSION = "1.1";
        mTopUpsRequest.NEED_ECODE = true;
        a(mTopUpsRequest, str);
        return mTopUpsRequest;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private VideoInfo a(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i2;
        Logger.d("UpsGetRequest", "processData");
        if (getInfoResult == null || getInfoResult.connectStat == null) {
            return null;
        }
        Logger.d("UpsGetRequest", "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
        StringBuilder sb = new StringBuilder();
        sb.append("http result data =");
        sb.append(getInfoResult.data);
        Logger.d("UpsGetRequest", sb.toString());
        if (!getInfoResult.connectStat.connect_success) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(getInfoResult.data)) {
                return null;
            }
            VideoInfo parseData = ParseResult.parseData(getInfoResult.data);
            parseData.setStream(a(parseData.getStreamJson()));
            return parseData;
        } catch (Exception e2) {
            Logger.e("UpsGetRequest", e2.toString());
            String str = getInfoResult.data;
            if (str == null) {
                return null;
            }
            if (str.contains("yk_web_anti_flow_limit_captcha_20171111")) {
                connectStat = getInfoResult.connectStat;
                connectStat.connect_success = false;
                i2 = ErrorConstants.ERROR_UPS_WEB_ANTI;
            } else if (!getInfoResult.data.contains("yk_web_anti_flow_limit_wait_20171111")) {
                return null;
            } else {
                connectStat = getInfoResult.connectStat;
                connectStat.connect_success = false;
                i2 = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
            }
            connectStat.response_code = i2;
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a(RequestParams requestParams, String str) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append("/ups/get.json?");
        com.youku.ups.a.b.a(sb, "ckey", str);
        for (Map.Entry entry : requestParams.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                com.youku.ups.a.b.a(sb, str2, str3);
            }
        }
        RequestParams requestParams2 = this.h;
        if (requestParams2 != null) {
            for (String str4 : requestParams2.keySet()) {
                String str5 = (String) requestParams2.get(str4);
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    com.youku.ups.a.b.a(sb, str4, str5);
                }
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(MTopUpsRequest mTopUpsRequest, String str) {
        RequestParams requestParams = this.g;
        mTopUpsRequest.stealParamsMap.put("ckey", str);
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ip, requestParams.get(RequestParams.client_ip));
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ts, requestParams.get(RequestParams.client_ts));
        mTopUpsRequest.stealParamsMap.put(RequestParams.utid, requestParams.get(RequestParams.utid));
        mTopUpsRequest.stealParamsMap.put("vid", requestParams.get("vid"));
        mTopUpsRequest.stealParamsMap.put("ccode", requestParams.get("ccode"));
        if ("01010301".equals((String) requestParams.get("ccode")) && !TextUtils.isEmpty((CharSequence) requestParams.get("p_device"))) {
            mTopUpsRequest.stealParamsMap.put("p_device", com.youku.ups.a.b.b((String) requestParams.get("p_device")));
        }
        for (String str2 : requestParams.keySet()) {
            String str3 = (String) requestParams.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                mTopUpsRequest.bizParamsMap.put(str2, str3);
            }
        }
        RequestParams requestParams2 = this.h;
        if (requestParams2 != null) {
            for (String str4 : requestParams2.keySet()) {
                String str5 = (String) requestParams2.get(str4);
                if (!TextUtils.isEmpty(str5)) {
                    if (d.contains(str4)) {
                        str5 = com.youku.ups.a.b.c(str5);
                    }
                    mTopUpsRequest.adParamsMap.put(str4, str5);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(VideoInfo videoInfo, GetInfoResult getInfoResult) {
        boolean z;
        UtAntiTheaftBean utAntiTheaftBean;
        getInfoResult.connectStat.utMsg = new UtAntiTheaftBean();
        UtAntiTheaftBean utAntiTheaftBean2 = getInfoResult.connectStat.utMsg;
        RequestData requestData = this.l;
        utAntiTheaftBean2.ccode = requestData.ccode;
        utAntiTheaftBean2.ckey = requestData.ckey;
        utAntiTheaftBean2.isCkeyError = requestData.isCkeyError;
        utAntiTheaftBean2.ckeyErrorMsg = requestData.ckeyErrorMsg;
        String str = null;
        if (videoInfo.getUps() != null) {
            getInfoResult.connectStat.utMsg.psid = videoInfo.getUps().psid;
            getInfoResult.connectStat.utMsg.upsClientNetip = videoInfo.getUps().ups_client_netip;
        } else {
            UtAntiTheaftBean utAntiTheaftBean3 = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean3.psid = null;
            utAntiTheaftBean3.upsClientNetip = null;
        }
        if (videoInfo.getVideo() != null) {
            getInfoResult.connectStat.utMsg.title = com.youku.ups.a.b.b(videoInfo.getVideo().title);
        } else {
            getInfoResult.connectStat.utMsg.title = null;
        }
        if (videoInfo.getUser() != null) {
            UtAntiTheaftBean utAntiTheaftBean4 = getInfoResult.connectStat.utMsg;
            if (!videoInfo.getUser().uid.isEmpty()) {
                str = videoInfo.getUser().uid;
            }
            utAntiTheaftBean4.uid = str;
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            z = videoInfo.getUser().vip;
        } else {
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean.uid = null;
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        utAntiTheaftBean.vip = i2;
        ConnectStat connectStat = getInfoResult.connectStat;
        UtAntiTheaftBean utAntiTheaftBean5 = connectStat.utMsg;
        RequestData requestData2 = this.l;
        utAntiTheaftBean5.utid = requestData2.utid;
        utAntiTheaftBean5.vid = requestData2.vid;
        utAntiTheaftBean5.log_type = 5;
        utAntiTheaftBean5.clientid = requestData2.clientid;
        videoInfo.setConnectStat(connectStat);
    }

    private Stream[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        Stream[] streamArr = new Stream[size];
        for (int i2 = 0; i2 < size; i2++) {
            streamArr[i2] = (Stream) ((JSONObject) jSONArray.get(i2)).toJavaObject(Stream.class);
        }
        return streamArr;
    }

    public void a(RequestParams requestParams, RequestParams requestParams2, NetworkParameter networkParameter, a<VideoInfo> aVar) {
        Logger.d("UpsGetRequest", "getUrlInfo");
        this.l = new RequestData();
        if (networkParameter == null || requestParams == null) {
            Logger.d("UpsGetRequest", "invalid parameter");
            aVar.onFailure(new a(0, "invalid parameter", this.l));
            return;
        }
        this.g = requestParams;
        this.h = requestParams2;
        this.f = networkParameter;
        this.i = aVar;
        m.submit(this.p);
    }
}
