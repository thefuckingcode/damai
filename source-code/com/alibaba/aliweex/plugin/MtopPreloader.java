package com.alibaba.aliweex.plugin;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.alibaba.aliweex.plugin.MtopHandler;
import com.alibaba.fastjson.JSON;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import com.taobao.weaver.prefetch.PrefetchDataCallback;
import com.taobao.weaver.prefetch.PrefetchDataResponse;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;
import tb.o70;
import tb.qx2;

/* compiled from: Taobao */
public class MtopPreloader {
    public static String a = "MtopPreloader";
    public static String b = "mtop_prefetch_status";
    public static String c = "init";
    public static String d = "resquesting";
    public static String e = "got_response";
    public static String f = "got_response_fail";
    public static String g = "saved_to_storage";
    public static String h = "saved_to_storage_fail";
    public static String i = "$_geo_longitude_$";
    public static String j = "$_geo_latitude_$";
    private static volatile long k = 0;
    public static volatile String l = "";
    public static volatile String m = "";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class MtopPrefetchLocationListener implements LocationListener, Handler.Callback {
        private Context a;
        private Handler b;
        private LocationManager c;

        public MtopPrefetchLocationListener(Context context, LocationManager locationManager) {
            this.a = context;
            this.c = locationManager;
            Handler handler = new Handler(this);
            this.b = handler;
            handler.post(WXThread.secure(new Runnable() {
                /* class com.alibaba.aliweex.plugin.MtopPreloader.MtopPrefetchLocationListener.AnonymousClass1 */

                public void run() {
                    MtopPrefetchLocationListener.this.b.sendEmptyMessageDelayed(3235841, 10000);
                }
            }));
        }

        public boolean handleMessage(Message message) {
            try {
                if (message.what == 3235841) {
                    WXLogUtils.d(MtopPreloader.a, "into--[handleMessage] Location Time Out!");
                    if (this.a != null) {
                        LocationManager locationManager = this.c;
                        if (locationManager != null) {
                            locationManager.removeUpdates(this);
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }

        public void onLocationChanged(Location location) {
            this.b.removeMessages(3235841);
            if (location != null) {
                MtopPreloader.l = String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location));
                MtopPreloader.m = String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location));
                long unused = MtopPreloader.k = SystemClock.uptimeMillis();
                this.c.removeUpdates(this);
            }
        }

        public void onProviderDisabled(String str) {
            String str2 = MtopPreloader.a;
            WXLogUtils.i(str2, "into--[onProviderDisabled] provider111:" + str);
            this.c.removeUpdates(this);
        }

        public void onProviderEnabled(String str) {
            String str2 = MtopPreloader.a;
            WXLogUtils.i(str2, "into--[onProviderEnabled] provider111:" + str);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            String str2 = MtopPreloader.a;
            WXLogUtils.i(str2, "into--[onStatusChanged] provider111:" + str + " status:" + i);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements MtopHandler.MtopFinshCallback {
        final /* synthetic */ String a;
        final /* synthetic */ WXSDKInstance b;
        final /* synthetic */ PrefetchDataCallback c;

        a(String str, WXSDKInstance wXSDKInstance, PrefetchDataCallback prefetchDataCallback) {
            this.a = str;
            this.b = wXSDKInstance;
            this.c = prefetchDataCallback;
        }

        @Override // com.alibaba.aliweex.plugin.MtopHandler.MtopFinshCallback
        public void onError(String str) {
            qx2.r(MtopPreloader.f, this.a);
            qx2.m(this.b, this.a, "-1", str);
            String str2 = "system error";
            if (str != null) {
                qx2.c("mtop query error", "received mtop failed. params is " + this.a + "error message is" + str);
            } else {
                qx2.c("mtop query error", str2);
            }
            String str3 = MtopPreloader.a;
            StringBuilder sb = new StringBuilder();
            sb.append("received mtop failed. params is ");
            sb.append(this.a);
            sb.append(",error msg is ");
            if (str != null) {
                str2 = str;
            }
            sb.append(str2);
            WXLogUtils.d(str3, sb.toString());
            PrefetchDataCallback prefetchDataCallback = this.c;
            if (prefetchDataCallback != null) {
                prefetchDataCallback.onError("500", str);
            }
        }

        @Override // com.alibaba.aliweex.plugin.MtopHandler.MtopFinshCallback
        public void onSuccess(String str) {
            qx2.r(MtopPreloader.e, this.a);
            qx2.n(this.b, this.a, str);
            if (this.c != null) {
                PrefetchDataResponse prefetchDataResponse = new PrefetchDataResponse();
                prefetchDataResponse.data = JSON.parseObject(str);
                this.c.onComplete(prefetchDataResponse);
            }
        }
    }

    public static Map<String, String> b(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("wh_prefetch");
        String queryParameter2 = parse.getQueryParameter("wh_prefetch_id");
        String queryParameter3 = parse.getQueryParameter("data_prefetch");
        String queryParameter4 = parse.getQueryParameter("mtop_prefetch");
        String queryParameter5 = parse.getQueryParameter("mtop_prefetch_enable");
        String queryParameter6 = parse.getQueryParameter("mtop_prefetch_id");
        HashMap hashMap = new HashMap();
        String c2 = (TextUtils.isEmpty(queryParameter3) || !queryParameter3.equals("true")) ? null : c(str);
        if (TextUtils.isEmpty(queryParameter5) || !queryParameter5.equals("true")) {
            if (TextUtils.isEmpty(queryParameter)) {
                if (!TextUtils.isEmpty(queryParameter4)) {
                    hashMap.put("keyIsMtopPrefetch", "true");
                    queryParameter = i(queryParameter4, qx2.j(str));
                } else if (!TextUtils.isEmpty(queryParameter2)) {
                    String i2 = qx2.i(queryParameter2);
                    if (TextUtils.isEmpty(i2)) {
                        qx2.c("package cache not exists error", "package cache get error ");
                        return null;
                    }
                    queryParameter = i(i2, qx2.j(str));
                } else if (!TextUtils.isEmpty(queryParameter6)) {
                    String i3 = qx2.i(queryParameter6);
                    if (TextUtils.isEmpty(i3)) {
                        qx2.c("package cache not exists error", "package cache get error by mtop_prefetch_id");
                        return null;
                    }
                    hashMap.put("keyIsMtopPrefetch", "true");
                    queryParameter = i(i3, qx2.j(str));
                }
            }
            hashMap.put("prefetch", queryParameter);
            return hashMap;
        }
        try {
            String l2 = qx2.l(str);
            if (l2.endsWith("\\")) {
                l2 = l2.substring(0, l2.length() - 1);
            }
            String i4 = qx2.i(l2);
            if (TextUtils.isEmpty(i4)) {
                qx2.c("package cache not exists error", "package cache get error by mtop_prefetch_enable at " + str);
                return null;
            }
            hashMap.put("keyIsMtopPrefetch", "true");
            queryParameter = i(i4, qx2.j(str));
            hashMap.put("prefetch", queryParameter);
            return hashMap;
        } catch (Exception e2) {
            qx2.c("mtop params parse failed", e2.getMessage());
        }
        queryParameter = c2;
        hashMap.put("prefetch", queryParameter);
        return hashMap;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical()) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("data_prefetch");
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("true")) {
            String l2 = qx2.l(str);
            try {
                if (l2.endsWith("\\")) {
                    l2 = l2.substring(0, l2.length() - 1);
                }
                return i(qx2.i(l2), qx2.j(str));
            } catch (Exception e2) {
                qx2.c("mtop params parse failed", e2.getMessage());
            }
        }
        return "";
    }

    public static boolean d() {
        return RemoteLogin.isSessionValid();
    }

    private static String e(String str, Map<String, String> map, String str2, String str3, int i2) {
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        Matcher matcher = Pattern.compile(str).matcher(str2);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            if (matcher.group() != null) {
                str4 = matcher.group().replaceAll(str3, "");
            } else {
                str4 = "";
            }
            String str5 = map.get(Uri.decode(str4));
            if (i2 == 0) {
                str5 = Uri.decode(str5);
            } else if (i2 == 2) {
                str5 = Uri.encode(str5);
            }
            if (!TextUtils.isEmpty(str5)) {
                matcher.appendReplacement(stringBuffer, str5);
            } else {
                matcher.appendReplacement(stringBuffer, "");
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String f(@Nullable String str, WXSDKInstance wXSDKInstance) {
        return g(str, wXSDKInstance, null);
    }

    public static String g(@Nullable String str, WXSDKInstance wXSDKInstance, @Nullable PrefetchDataCallback prefetchDataCallback) {
        String str2;
        String str3 = str;
        if (!qx2.b()) {
            WXLogUtils.d(a, "preload is disabled");
            return str3;
        } else if (TextUtils.isEmpty(str)) {
            return str3;
        } else {
            List<String> g2 = qx2.g();
            boolean z = false;
            if (g2 != null && g2.size() > 0) {
                Iterator<String> it = g2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str3.contains(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                if (str3.contains("?")) {
                    str3 = str3.replaceFirst("\\?", "?data_prefetch=true&");
                } else {
                    str3 = str3 + "?" + "data_prefetch" + "=true";
                }
            }
            Uri parse = Uri.parse(str3);
            if (!parse.isHierarchical()) {
                return str3;
            }
            String queryParameter = parse.getQueryParameter("wh_prefetch");
            String queryParameter2 = parse.getQueryParameter("wh_needlogin");
            String queryParameter3 = parse.getQueryParameter("wh_prefetch_id");
            String queryParameter4 = parse.getQueryParameter("data_prefetch");
            String queryParameter5 = parse.getQueryParameter("mtop_prefetch");
            String queryParameter6 = parse.getQueryParameter("mtop_prefetch_enable");
            String queryParameter7 = parse.getQueryParameter("mtop_prefetch_id");
            String queryParameter8 = parse.getQueryParameter("mtop_needlogin");
            String queryParameter9 = parse.getQueryParameter("mtop_prefetch_lbs");
            if ((!TextUtils.isEmpty(queryParameter2) && queryParameter2.equals("1")) || (!TextUtils.isEmpty(queryParameter8) && (queryParameter8.equals("1") || queryParameter8.equals("true")))) {
                if (d()) {
                    str3 = str3.replaceAll("wh_needlogin=1", "");
                } else {
                    qx2.c("need user login", "user not login exception");
                    return str3;
                }
            }
            if (TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7)) {
                return str3;
            }
            if ("true".equals(queryParameter9)) {
                h(wXSDKInstance.getContext());
            }
            if (str3.contains(i) && !TextUtils.isEmpty(l)) {
                str3 = str3.replaceFirst(i, l);
            }
            if (str3.contains(j) && !TextUtils.isEmpty(m)) {
                str3 = str3.replaceFirst(j, m);
            }
            Map<String, String> b2 = b(str3);
            if (b2 == null) {
                return str3;
            }
            String str4 = b2.get("prefetch");
            boolean equals = Boolean.TRUE.toString().equals(b2.get("keyIsMtopPrefetch"));
            qx2.r(c, str4);
            String h2 = qx2.h(wXSDKInstance, str4);
            if (h2 == null) {
                return str3;
            }
            if (equals) {
                str2 = qx2.q(str3, "mtop_prefetch", str4);
            } else {
                str2 = qx2.q(str3, "wh_prefetch", str4);
            }
            j(wXSDKInstance, h2, str4, prefetchDataCallback);
            qx2.r(d, str4);
            return str2;
        }
    }

    static void h(Context context) {
        if (SystemClock.uptimeMillis() - k >= DateUtils.MILLIS_PER_HOUR && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            MtopPrefetchLocationListener mtopPrefetchLocationListener = new MtopPrefetchLocationListener(context, locationManager);
            if (locationManager.getAllProviders() != null && locationManager.getAllProviders().contains("network")) {
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(locationManager, "network", (long) 20000, (float) 5, mtopPrefetchLocationListener);
            }
            if (locationManager.getAllProviders() != null && locationManager.getAllProviders().contains(GeocodeSearch.GPS)) {
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(locationManager, GeocodeSearch.GPS, (long) 20000, (float) 5, mtopPrefetchLocationListener);
            }
        }
    }

    public static String i(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (map == null || map.size() == 0) {
            return str;
        }
        String e2 = e("(\\$).*?(\\$)", map, str, "\\$", 0);
        if (!TextUtils.isEmpty(e2)) {
            e2 = e("(#).*?(#)", map, e2, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, 1);
        }
        return !TextUtils.isEmpty(e2) ? e("(@).*?(@)", map, e2, o70.DINAMIC_PREFIX_AT, 2) : e2;
    }

    public static void j(WXSDKInstance wXSDKInstance, String str, String str2, PrefetchDataCallback prefetchDataCallback) {
        MtopHandler.d(str, new a(str2, wXSDKInstance, prefetchDataCallback));
    }
}
