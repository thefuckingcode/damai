package android.taobao.windvane.extra.mtop;

import android.content.ContextWrapper;
import android.net.Uri;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.IApiAdapter;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.security.SecurityManager;
import android.taobao.windvane.extra.security.TaoApiSign;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class MtopApiAdapter implements IApiAdapter {
    private ApiRequest request;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0099, code lost:
        if (r2 == 0) goto L_0x009b;
     */
    private void checkParams() {
        long j;
        this.request.addParam("ttid", GlobalConfig.getInstance().getTtid());
        String imei = GlobalConfig.getInstance().getImei();
        String str = "111111111111111";
        if (TextUtils.isEmpty(imei)) {
            imei = str;
        }
        String imsi = GlobalConfig.getInstance().getImsi();
        if (!TextUtils.isEmpty(imsi)) {
            str = imsi;
        }
        this.request.addParam("imei", imei);
        this.request.addParam("imsi", str);
        if (!TextUtils.isEmpty(GlobalConfig.getInstance().getDeviceId())) {
            this.request.addParam("deviceId", GlobalConfig.getInstance().getDeviceId());
        }
        if (this.request.getDataParams().size() > 0) {
            this.request.addParam("data", new JSONObject(this.request.getDataParams()).toString());
        }
        if (!this.request.getParams().containsKey("t")) {
            WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
            if (wVIAdapter != null) {
                j = wVIAdapter.getTimestamp();
            }
            j = System.currentTimeMillis();
            this.request.addParam("t", String.valueOf(j / 1000));
        }
        this.request.addParam("appKey", GlobalConfig.getInstance().getAppKey());
        if (this.request.isSec()) {
            this.request.addParam("wua", getSecBodyData(GlobalConfig.context));
        }
        this.request.addParam(ApiConstants.APPSECRET, GlobalConfig.getInstance().getAppSecret());
        this.request.addParam("sign", getSign());
        if (!this.request.getParams().containsKey("v")) {
            this.request.addParam("v", jl1.MUL);
        }
        if (this.request.getParams().containsKey(ApiConstants.APPSECRET)) {
            this.request.removeParam(ApiConstants.APPSECRET);
        }
        if (this.request.getParams().containsKey("ecode")) {
            this.request.removeParam("ecode");
        }
    }

    private String getSecBodyData(ContextWrapper contextWrapper) {
        return SecurityManager.getInstance().getSecBody(contextWrapper, this.request.getParam("t"), this.request.getParam("appKey"));
    }

    private String getSign() {
        String sign = SecurityManager.getInstance().getSign(0, this.request.getParams(), this.request.getParam("appKey"));
        if (TaoLog.getLogStatus()) {
            TaoLog.d("MtopApiAdapter", "appkey: " + this.request.getParam("appKey") + " params: " + this.request.getParams());
        }
        if (sign != null) {
            return sign;
        }
        TaoLog.w("MtopApiAdapter", "SecurityManager.getSign failed, execute TaoApiSign.getSign");
        return TaoApiSign.getSign(this.request.getParams());
    }

    private String wrapBody() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : this.request.getParams().entrySet()) {
            if (z) {
                sb.append("&");
            } else {
                z = true;
            }
            sb.append(Uri.encode(entry.getKey()));
            sb.append("=");
            sb.append(Uri.encode(entry.getValue()));
        }
        return sb.toString();
    }

    private String wrapUrl(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = parse.buildUpon();
        String path = parse.getPath();
        if (path == null || path.length() == 0) {
            buildUpon.appendPath("");
        }
        for (Map.Entry<String, String> entry : this.request.getParams().entrySet()) {
            buildUpon = buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.toString();
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatBody(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapBody();
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatUrl(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapUrl(GlobalConfig.getMtopUrl());
    }
}
