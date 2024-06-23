package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class i {
    Object a = new Object();
    private Context b;
    private AMapLocationClient c = null;
    private WebView d = null;
    private String e = "AMap.Geolocation.cbk";
    AMapLocationClientOption f = null;
    private volatile boolean g = false;
    a h = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (i.this.g) {
                i.this.i(i.g(aMapLocation));
            }
        }
    }

    public i(Context context, WebView webView) {
        this.b = context.getApplicationContext();
        this.d = webView;
        this.h = new a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(1:2)|3|4|5|(1:7)(1:8)|9|10|11|(1:13)(1:14)|15|16|17|(1:20)|19|25|26|(1:28)(1:30)|29|31|(1:33)(1:34)|35|(2:37|39)(1:41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    private void e(String str) {
        boolean z;
        boolean z2;
        AMapLocationClientOption aMapLocationClientOption;
        AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        if (this.f == null) {
            this.f = new AMapLocationClientOption();
        }
        int i = 5;
        long j = 30000;
        boolean z3 = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            j = jSONObject.optLong("to", 30000);
            z = jSONObject.optInt("useGPS", 1) == 1;
            try {
                z2 = jSONObject.optInt("watch", 0) == 1;
                i = jSONObject.optInt(Constants.Name.INTERVAL, 5);
                String optString = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK, null);
                if (TextUtils.isEmpty(optString)) {
                    optString = "AMap.Geolocation.cbk";
                }
                this.e = optString;
            } catch (Throwable unused) {
                z2 = false;
                this.f.setHttpTimeOut(j);
                if (!z) {
                }
                aMapLocationClientOption.setLocationMode(aMapLocationMode);
                AMapLocationClientOption aMapLocationClientOption2 = this.f;
                if (!z2) {
                }
                aMapLocationClientOption2.setOnceLocation(z3);
                if (!z2) {
                }
            }
        } catch (Throwable unused2) {
            z = false;
            z2 = false;
            this.f.setHttpTimeOut(j);
            if (!z) {
            }
            aMapLocationClientOption.setLocationMode(aMapLocationMode);
            AMapLocationClientOption aMapLocationClientOption22 = this.f;
            if (!z2) {
            }
            aMapLocationClientOption22.setOnceLocation(z3);
            if (!z2) {
            }
        }
        this.f.setHttpTimeOut(j);
        if (!z) {
            aMapLocationClientOption = this.f;
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        } else {
            aMapLocationClientOption = this.f;
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
        }
        aMapLocationClientOption.setLocationMode(aMapLocationMode);
        AMapLocationClientOption aMapLocationClientOption222 = this.f;
        if (!z2) {
            z3 = false;
        }
        aMapLocationClientOption222.setOnceLocation(z3);
        if (!z2) {
            this.f.setInterval((long) (i * 1000));
        }
    }

    /* access modifiers changed from: private */
    public static String g(AMapLocation aMapLocation) {
        String locationDetail;
        JSONObject jSONObject = new JSONObject();
        String str = MyLocationStyle.ERROR_INFO;
        if (aMapLocation == null) {
            try {
                jSONObject.put("errorCode", -1);
                locationDetail = "unknownError";
            } catch (Throwable unused) {
            }
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put("errorCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Constants.Name.X, aMapLocation.getLongitude());
            jSONObject2.put(Constants.Name.Y, aMapLocation.getLatitude());
            jSONObject2.put("precision", (double) aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.getLocationType());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, aMapLocation.getCountry());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
            jSONObject2.put("city", aMapLocation.getCity());
            jSONObject2.put("cityCode", aMapLocation.getCityCode());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
            jSONObject2.put("adCode", aMapLocation.getAdCode());
            jSONObject2.put("street", aMapLocation.getStreet());
            jSONObject2.put("streetNum", aMapLocation.getStreetNum());
            jSONObject2.put("floor", aMapLocation.getFloor());
            jSONObject2.put(ILocatable.ADDRESS, aMapLocation.getAddress());
            jSONObject.put("result", jSONObject2);
            return jSONObject.toString();
        } else {
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(str, aMapLocation.getErrorInfo());
            str = "locationDetail";
            locationDetail = aMapLocation.getLocationDetail();
        }
        jSONObject.put(str, locationDetail);
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void i(final String str) {
        try {
            WebView webView = this.d;
            if (webView == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + this.e + "('" + str + "')", new ValueCallback<String>() {
                    /* class com.loc.i.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                    }
                });
                return;
            }
            webView.post(new Runnable() {
                /* class com.loc.i.AnonymousClass2 */

                public final void run() {
                    WebView webView = i.this.d;
                    webView.loadUrl("javascript:" + i.this.e + "('" + str + "')");
                }
            });
        } catch (Throwable th) {
            j1.h(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void c() {
        if (this.d != null && this.b != null && Build.VERSION.SDK_INT >= 17 && !this.g) {
            try {
                this.d.getSettings().setJavaScriptEnabled(true);
                this.d.addJavascriptInterface(this, "AMapAndroidLoc");
                if (!TextUtils.isEmpty(this.d.getUrl())) {
                    this.d.reload();
                }
                if (this.c == null) {
                    AMapLocationClient aMapLocationClient = new AMapLocationClient(this.b);
                    this.c = aMapLocationClient;
                    aMapLocationClient.setLocationListener(this.h);
                }
                this.g = true;
            } catch (Throwable unused) {
            }
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.a) {
            if (this.g) {
                e(str);
                AMapLocationClient aMapLocationClient = this.c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f);
                    this.c.stopLocation();
                    this.c.startLocation();
                }
            }
        }
    }

    public final void h() {
        synchronized (this.a) {
            this.g = false;
            AMapLocationClient aMapLocationClient = this.c;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.h);
                this.c.stopLocation();
                this.c.onDestroy();
                this.c = null;
            }
            this.f = null;
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.g && (aMapLocationClient = this.c) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
