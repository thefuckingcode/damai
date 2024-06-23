package android.taobao.windvane.jsbridge.api;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVLocation extends WVApiPlugin implements LocationListener, Handler.Callback {
    private static final int GPS_TIMEOUT = 15000;
    private static final String TAG = "WVLocation";
    private int MIN_DISTANCE;
    private int MIN_TIME;
    private boolean enableAddress;
    private boolean getLocationSuccess;
    private LocationManager locationManager;
    private ArrayList<WVCallBackContext> mCallbacks;
    private Handler mHandler;

    public WVLocation() {
        this.MIN_TIME = 20000;
        this.MIN_DISTANCE = 30;
        this.mHandler = null;
        this.mCallbacks = new ArrayList<>();
        this.getLocationSuccess = false;
        this.enableAddress = false;
        this.locationManager = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Address getAddress(double d, double d2) {
        try {
            List<Address> fromLocation = new Geocoder(this.mContext).getFromLocation(d, d2, 1);
            if (fromLocation == null || fromLocation.size() <= 0) {
                return null;
            }
            return fromLocation.get(0);
        } catch (Exception e) {
            TaoLog.e("WVLocation", "getAddress: getFromLocation error. " + e.getMessage());
            return null;
        }
    }

    private void registerLocation(boolean z) {
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) this.mContext.getSystemService("location");
        }
        try {
            this.getLocationSuccess = false;
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, "network", (long) this.MIN_TIME, (float) this.MIN_DISTANCE, this);
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, GeocodeSearch.GPS, (long) this.MIN_TIME, (float) this.MIN_DISTANCE, this);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVLocation", " registerLocation start provider GPS and NETWORK");
            }
        } catch (Exception e) {
            TaoLog.e("WVLocation", "registerLocation error: " + e.getMessage());
        }
    }

    private void wrapResult(final Location location) {
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList == null || arrayList.isEmpty()) {
            TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
        } else if (location == null) {
            TaoLog.w("WVLocation", "getLocation: location is null");
            Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().error(new WVResult());
            }
            this.mCallbacks.clear();
        } else {
            AsyncTask.execute(new Runnable() {
                /* class android.taobao.windvane.jsbridge.api.WVLocation.AnonymousClass4 */

                public void run() {
                    WVResult wVResult = new WVResult();
                    JSONObject jSONObject = new JSONObject();
                    double longitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location);
                    double latitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location);
                    try {
                        jSONObject.put("longitude", longitude);
                        jSONObject.put("latitude", latitude);
                        jSONObject.put("altitude", com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(location));
                        jSONObject.put("accuracy", (double) location.getAccuracy());
                        jSONObject.put("heading", (double) location.getBearing());
                        jSONObject.put("speed", (double) location.getSpeed());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    wVResult.addData(ILocatable.COORDS, jSONObject);
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVLocation", " getLocation success. latitude: " + latitude + "; longitude: " + longitude);
                    }
                    if (WVLocation.this.enableAddress) {
                        Address address = WVLocation.this.getAddress(latitude, longitude);
                        JSONObject jSONObject2 = new JSONObject();
                        if (address != null) {
                            try {
                                jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, address.getCountryName());
                                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, address.getAdminArea());
                                jSONObject2.put("city", address.getLocality());
                                jSONObject2.put("cityCode", address.getPostalCode());
                                jSONObject2.put(Constants.ACTION_PARAMS_AREA, address.getSubLocality());
                                jSONObject2.put("road", address.getThoroughfare());
                                StringBuilder sb = new StringBuilder();
                                for (int i = 1; i <= 2; i++) {
                                    if (!TextUtils.isEmpty(address.getAddressLine(i))) {
                                        sb.append(address.getAddressLine(i));
                                    }
                                }
                                jSONObject2.put("addressLine", sb.toString());
                                if (TaoLog.getLogStatus()) {
                                    TaoLog.d("WVLocation", " getAddress success. " + address.getAddressLine(0));
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } else if (TaoLog.getLogStatus()) {
                            TaoLog.w("WVLocation", " getAddress fail. ");
                        }
                        wVResult.addData(ILocatable.ADDRESS, jSONObject2);
                    }
                    try {
                        Iterator it = WVLocation.this.mCallbacks.iterator();
                        while (it.hasNext()) {
                            ((WVCallBackContext) it.next()).success(wVResult);
                        }
                        WVLocation.this.mCallbacks.clear();
                        if (TaoLog.getLogStatus()) {
                            TaoLog.d("WVLocation", "callback success. retString: " + wVResult.toJsonString());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"getLocation".equals(str)) {
            return false;
        }
        getLocation(wVCallBackContext, str2);
        return true;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public synchronized void getLocation(final WVCallBackContext wVCallBackContext, final String str) {
        PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}).setTaskOnPermissionGranted(new Runnable() {
            /* class android.taobao.windvane.jsbridge.api.WVLocation.AnonymousClass2 */

            public void run() {
                WVLocation.this.requestLocation(wVCallBackContext, str);
            }
        }).setTaskOnPermissionDenied(new Runnable() {
            /* class android.taobao.windvane.jsbridge.api.WVLocation.AnonymousClass1 */

            public void run() {
                WVResult wVResult = new WVResult();
                wVResult.addData("msg", "no permission");
                wVCallBackContext.error(wVResult);
            }
        }).execute();
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 != null) {
            try {
                locationManager2.removeUpdates(this);
                ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
                if (arrayList != null) {
                    if (!arrayList.isEmpty()) {
                        if (!this.getLocationSuccess) {
                            Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
                            while (it.hasNext()) {
                                it.next().error(new WVResult());
                            }
                            this.mCallbacks.clear();
                        }
                    }
                }
                TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
                return false;
            } catch (Exception e) {
                TaoLog.e("WVLocation", "GetLocation timeout" + e.getMessage());
                Iterator<WVCallBackContext> it2 = this.mCallbacks.iterator();
                while (it2.hasNext()) {
                    it2.next().error(new WVResult());
                }
                this.mCallbacks.clear();
            }
        }
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 != null) {
            if (!this.getLocationSuccess) {
                try {
                    locationManager2.removeUpdates(this);
                } catch (Exception unused) {
                }
            }
            this.locationManager = null;
        }
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void onLocationChanged(Location location) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onLocationChanged. ");
        }
        if (this.locationManager != null) {
            wrapResult(location);
            this.locationManager.removeUpdates(this);
            this.getLocationSuccess = true;
        }
    }

    public void onProviderDisabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderDisabled. provider: " + str);
        }
    }

    public void onProviderEnabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderEnabled. provider: " + str);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onStatusChanged. provider: " + str + ";status: " + i);
        }
    }

    public void requestLocation(WVCallBackContext wVCallBackContext, String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                z = jSONObject.optBoolean("enableHighAcuracy");
                this.enableAddress = jSONObject.optBoolean(ILocatable.ADDRESS);
            } catch (JSONException unused) {
                TaoLog.e("WVLocation", "getLocation: param parse to JSON error, param=" + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        } else {
            z = false;
        }
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        this.mCallbacks.add(wVCallBackContext);
        registerLocation(z);
        WVThreadPool.getInstance().execute(new Runnable() {
            /* class android.taobao.windvane.jsbridge.api.WVLocation.AnonymousClass3 */

            public void run() {
                WVLocation.this.mHandler.sendEmptyMessageDelayed(1, 15000);
            }
        });
    }
}
