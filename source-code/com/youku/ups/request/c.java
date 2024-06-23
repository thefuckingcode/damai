package com.youku.ups.request;

import android.content.Context;
import android.text.TextUtils;
import com.youku.ups.a.b;
import com.youku.ups.data.RequestParams;
import com.youku.ups.data.a;
import com.youku.upsplayer.GetUps;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.VideoCacheInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class c {
    private static final ExecutorService d = Executors.newCachedThreadPool();
    public String a = "http://ups.youku.com";
    private final Context b;
    private final INetworkTask c;
    private a<List<VideoCacheInfo>> e;
    private RequestData f = null;
    private RequestParams g;
    private NetworkParameter h;
    private String i;
    private String j;
    private final Runnable k = new UpsQGetRequest$1(this);

    public c(Context context, INetworkTask iNetworkTask) {
        this.b = context;
        this.c = iNetworkTask;
    }

    /* access modifiers changed from: private */
    public String a(RequestParams requestParams, String str) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append(GetUps.UPS_MULTI_UPSIFO_PATH_NEW);
        this.f.ckey = str;
        b.a(sb, "ckey", str);
        for (Map.Entry entry : requestParams.entrySet()) {
            String str2 = (String) entry.getValue();
            if (!TextUtils.isEmpty((String) entry.getKey()) && !TextUtils.isEmpty(str2)) {
                b.a(sb, (String) entry.getKey(), (String) entry.getValue());
            }
        }
        return sb.toString();
    }

    public List<VideoCacheInfo> a(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        ConnectStat connectStat2;
        int i2;
        if (getInfoResult == null || (connectStat = getInfoResult.connectStat) == null || !connectStat.connect_success) {
            return null;
        }
        try {
            return ParseResult.parseMulUPSJSon(getInfoResult.data);
        } catch (Exception unused) {
            String str = getInfoResult.data;
            if (str == null) {
                return null;
            }
            if (str.contains("yk_web_anti_flow_limit_captcha_20171111")) {
                connectStat2 = getInfoResult.connectStat;
                connectStat2.connect_success = false;
                i2 = ErrorConstants.ERROR_UPS_WEB_ANTI;
            } else if (!getInfoResult.data.contains("yk_web_anti_flow_limit_wait_20171111")) {
                return null;
            } else {
                connectStat2 = getInfoResult.connectStat;
                connectStat2.connect_success = false;
                i2 = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
            }
            connectStat2.response_code = i2;
            return null;
        }
    }

    public void a(RequestParams requestParams, NetworkParameter networkParameter, a<List<VideoCacheInfo>> aVar) {
        RequestData requestData = new RequestData();
        this.f = requestData;
        if (networkParameter == null || requestParams == null) {
            aVar.onFailure(new a(0, "invalid parameter", requestData));
            return;
        }
        this.g = requestParams;
        this.h = networkParameter;
        this.e = aVar;
        d.submit(this.k);
    }
}
