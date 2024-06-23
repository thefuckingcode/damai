package com.alibaba.aliweex.adapter.module.location;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.thread.WVThreadPool;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.SimpleJSCallback;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class DefaultLocation implements ILocatable {
    private Map<String, WXLocationListener> a = new HashMap();
    private List<WXLocationListener> b = new ArrayList();
    private WXSDKInstance c;
    private LocationManager d;
    private int e = 20000;
    private int f = 5;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class WXLocationListener implements LocationListener, Handler.Callback {
        private Context a;
        private String b;
        private SimpleJSCallback c;
        private SimpleJSCallback d;
        private boolean e;
        private Handler f;
        private LocationManager g;

        private Address c(double d2, double d3) {
            List<Address> fromLocation;
            WXLogUtils.d("DefaultLocation", "into--[getAddress] latitude:" + d2 + " longitude:" + d3);
            try {
                if (!(this.a == null || (fromLocation = new Geocoder(this.a).getFromLocation(d2, d3, 1)) == null || fromLocation.size() <= 0)) {
                    return fromLocation.get(0);
                }
            } catch (Exception e2) {
                WXLogUtils.e("DefaultLocation", e2);
            }
            return null;
        }

        public void b() {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(17);
                this.a = null;
            }
        }

        public boolean handleMessage(Message message) {
            try {
                if (message.what == 17) {
                    WXLogUtils.d("DefaultLocation", "into--[handleMessage] Location Time Out!");
                    Context context = this.a;
                    if (context != null) {
                        if (this.g != null) {
                            if (DefaultLocation.a(context)) {
                                this.g.removeUpdates(this);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("errorCode", 9004);
                            hashMap.put("errorMsg", ILocatable.ErrorMsg.LOCATION_TIME_OUT);
                            if (!TextUtils.isEmpty(this.b)) {
                                hashMap.put(ILocatable.WATCH_ID, this.b);
                            }
                            SimpleJSCallback simpleJSCallback = this.d;
                            if (simpleJSCallback == null) {
                                return true;
                            }
                            simpleJSCallback.invoke(hashMap);
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }

        public void onLocationChanged(Location location) {
            Context context;
            this.f.removeMessages(17);
            StringBuilder sb = new StringBuilder();
            sb.append("into--[onLocationChanged] location:");
            sb.append(location);
            WXLogUtils.d("DefaultLocation", sb.toString() == null ? "Location is NULL!" : location.toString());
            if (location != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                double longitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location);
                double latitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location);
                hashMap2.put("longitude", Double.valueOf(longitude));
                hashMap2.put("latitude", Double.valueOf(latitude));
                hashMap2.put("altitude", Double.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(location)));
                hashMap2.put("accuracy", Float.valueOf(location.getAccuracy()));
                hashMap2.put("heading", Float.valueOf(location.getBearing()));
                hashMap2.put("speed", Float.valueOf(location.getSpeed()));
                hashMap.put(ILocatable.COORDS, hashMap2);
                if (this.e) {
                    Address c2 = c(latitude, longitude);
                    HashMap hashMap3 = new HashMap();
                    if (c2 != null) {
                        hashMap3.put(DistrictSearchQuery.KEYWORDS_COUNTRY, c2.getCountryName());
                        hashMap3.put(DistrictSearchQuery.KEYWORDS_PROVINCE, c2.getAdminArea());
                        hashMap3.put("city", c2.getLocality());
                        hashMap3.put("cityCode", c2.getPostalCode());
                        hashMap3.put(Constants.ACTION_PARAMS_AREA, c2.getSubLocality());
                        hashMap3.put("road", c2.getThoroughfare());
                        StringBuilder sb2 = new StringBuilder();
                        for (int i = 1; i <= 2; i++) {
                            if (!TextUtils.isEmpty(c2.getAddressLine(i))) {
                                sb2.append(c2.getAddressLine(i));
                            }
                        }
                        hashMap3.put("addressLine", sb2.toString());
                    }
                    hashMap.put(ILocatable.ADDRESS, hashMap3);
                }
                hashMap.put("errorCode", 90000);
                hashMap.put("errorMsg", "SUCCESS");
                if (!TextUtils.isEmpty(this.b)) {
                    hashMap.put(ILocatable.WATCH_ID, this.b);
                }
                if (this.c != null) {
                    if (!TextUtils.isEmpty(this.b)) {
                        this.c.invokeAndKeepAlive(hashMap);
                    } else {
                        this.c.invoke(hashMap);
                    }
                }
            } else {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("errorCode", 9003);
                hashMap4.put("errorMsg", ILocatable.ErrorMsg.LOCATION_ERROR);
                if (!TextUtils.isEmpty(this.b)) {
                    hashMap4.put(ILocatable.WATCH_ID, this.b);
                }
                if (this.d != null) {
                    if (!TextUtils.isEmpty(this.b)) {
                        this.d.invokeAndKeepAlive(hashMap4);
                    } else {
                        this.d.invoke(hashMap4);
                    }
                }
            }
            if (TextUtils.isEmpty(this.b) && (context = this.a) != null && DefaultLocation.a(context)) {
                this.g.removeUpdates(this);
            }
        }

        public void onProviderDisabled(String str) {
            WXLogUtils.i("DefaultLocation", "into--[onProviderDisabled] provider:" + str);
        }

        public void onProviderEnabled(String str) {
            WXLogUtils.i("DefaultLocation", "into--[onProviderEnabled] provider:" + str);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            WXLogUtils.i("DefaultLocation", "into--[onStatusChanged] provider:" + str + " status:" + i);
        }

        private WXLocationListener(LocationManager locationManager, WXSDKInstance wXSDKInstance, String str, String str2, String str3, boolean z) {
            this.a = null;
            this.c = null;
            this.d = null;
            this.b = str;
            if (wXSDKInstance != null) {
                this.c = new SimpleJSCallback(wXSDKInstance.getInstanceId(), str2);
                this.d = new SimpleJSCallback(wXSDKInstance.getInstanceId(), str3);
                this.a = wXSDKInstance.getContext();
            }
            this.e = z;
            this.f = new Handler(this);
            this.g = locationManager;
            WVThreadPool.getInstance().execute(new Runnable() {
                /* class com.alibaba.aliweex.adapter.module.location.DefaultLocation.WXLocationListener.AnonymousClass1 */

                public void run() {
                    WXLocationListener.this.f.sendEmptyMessageDelayed(17, 15000);
                }
            });
        }
    }

    public DefaultLocation(WXSDKInstance wXSDKInstance) {
        this.c = wXSDKInstance;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private WXLocationListener b(String str, String str2, String str3, boolean z, boolean z2) {
        WXLogUtils.d("DefaultLocation", "into--[findLocation] mWatchId:" + str + "\nsuccessCallback:" + str2 + "\nerrorCallback:" + str3 + "\nenableHighAccuracy:" + z + "\nmEnableAddress:" + z2);
        if (this.d == null) {
            WXSDKInstance wXSDKInstance = this.c;
            if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
                return null;
            }
            this.d = (LocationManager) this.c.getContext().getSystemService("location");
        }
        Criteria criteria = new Criteria();
        if (z) {
            criteria.setAccuracy(2);
        }
        WXSDKInstance wXSDKInstance2 = this.c;
        if (wXSDKInstance2 == null || !a(wXSDKInstance2.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", 90001);
            hashMap.put("errorMsg", ILocatable.ErrorMsg.NO_PERMISSION_ERROR);
            WXSDKInstance wXSDKInstance3 = this.c;
            if (wXSDKInstance3 != null) {
                new SimpleJSCallback(wXSDKInstance3.getInstanceId(), str3).invoke(hashMap);
            }
            return null;
        }
        WXLocationListener wXLocationListener = new WXLocationListener(this.d, this.c, str, str2, str3, z2);
        try {
            if (this.d.getAllProviders() != null && this.d.getAllProviders().contains(GeocodeSearch.GPS)) {
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.d, GeocodeSearch.GPS, (long) this.e, (float) this.f, wXLocationListener);
            }
            if (this.d.getAllProviders() != null && this.d.getAllProviders().contains("network")) {
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.d, "network", (long) this.e, (float) this.f, wXLocationListener);
            }
            return wXLocationListener;
        } catch (Exception e2) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorCode", 9003);
            hashMap2.put("errorMsg", ILocatable.ErrorMsg.LOCATION_ERROR);
            WXSDKInstance wXSDKInstance4 = this.c;
            if (wXSDKInstance4 != null) {
                new SimpleJSCallback(wXSDKInstance4.getInstanceId(), str3).invoke(hashMap2);
            }
            WXLogUtils.e("DefaultLocation", WXLogUtils.getStackTrace(e2));
            return null;
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.location.ILocatable
    public void clearWatch(String str) {
        WXLogUtils.d("into--[clearWatch] mWatchId:" + str);
        WXSDKInstance wXSDKInstance = this.c;
        if (wXSDKInstance != null && !wXSDKInstance.isDestroy() && this.d != null && a(this.c.getContext())) {
            WXLocationListener wXLocationListener = this.a.get(str);
            if (wXLocationListener != null) {
                wXLocationListener.b();
                this.d.removeUpdates(wXLocationListener);
            }
            this.a.remove(str);
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.location.ILocatable
    public void destroy() {
        WXLogUtils.d("into--[destroy]");
        WXSDKInstance wXSDKInstance = this.c;
        if (!(wXSDKInstance == null || wXSDKInstance.isDestroy() || this.d == null)) {
            List<WXLocationListener> list = this.b;
            if (list != null && list.size() > 0 && a(this.c.getContext())) {
                for (WXLocationListener wXLocationListener : this.b) {
                    if (wXLocationListener != null) {
                        wXLocationListener.b();
                        this.d.removeUpdates(wXLocationListener);
                    }
                }
                this.b.clear();
            }
            Map<String, WXLocationListener> map = this.a;
            if (map != null && map.size() > 0) {
                Collection<WXLocationListener> values = this.a.values();
                if (a(this.c.getContext())) {
                    for (WXLocationListener wXLocationListener2 : values) {
                        wXLocationListener2.b();
                        this.d.removeUpdates(wXLocationListener2);
                    }
                    this.a.clear();
                }
            }
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.location.ILocatable
    public void getCurrentPosition(String str, String str2, String str3) {
        WXLogUtils.d("DefaultLocation", "into--[getCurrentPosition] successCallback:" + str + " \nerrorCallback:" + str2 + " \nparams:" + str3);
        if (!TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                WXLocationListener b2 = b(null, str, str2, jSONObject.optBoolean("enableHighAccuracy"), jSONObject.optBoolean(ILocatable.ADDRESS));
                if (b2 != null) {
                    this.b.add(b2);
                    return;
                }
                return;
            } catch (JSONException e2) {
                WXLogUtils.e("DefaultLocation", e2);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", 90002);
        hashMap.put("errorMsg", ILocatable.ErrorMsg.PARAMS_ERROR);
        WXSDKInstance wXSDKInstance = this.c;
        if (wXSDKInstance != null) {
            new SimpleJSCallback(wXSDKInstance.getInstanceId(), str2).invoke(hashMap);
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.location.ILocatable
    public void setWXSDKInstance(WXSDKInstance wXSDKInstance) {
        this.c = wXSDKInstance;
    }

    @Override // com.alibaba.aliweex.adapter.module.location.ILocatable
    public void watchPosition(String str, String str2, String str3) {
        WXLogUtils.d("into--[watchPosition] successCallback:" + str + " errorCallback:" + str2 + "\nparams:" + str3);
        if (!TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                boolean optBoolean = jSONObject.optBoolean("enableHighAccuracy");
                boolean optBoolean2 = jSONObject.optBoolean(ILocatable.ADDRESS);
                String uuid = UUID.randomUUID().toString();
                WXLocationListener b2 = b(uuid, str, str2, optBoolean, optBoolean2);
                if (b2 != null) {
                    this.a.put(uuid, b2);
                    return;
                }
                return;
            } catch (JSONException e2) {
                WXLogUtils.e("DefaultLocation", e2);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", 90002);
        hashMap.put("errorMsg", ILocatable.ErrorMsg.PARAMS_ERROR);
        WXSDKInstance wXSDKInstance = this.c;
        if (wXSDKInstance != null) {
            new SimpleJSCallback(wXSDKInstance.getInstanceId(), str2).invoke(hashMap);
        }
    }
}
