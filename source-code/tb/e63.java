package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.loc.i1;
import com.loc.j1;
import com.loc.k1;
import com.loc.l1;
import com.loc.m1;
import com.loc.v1;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class e63 {
    static AMapLocation D;
    static long E;
    static Object F = new Object();
    static long G;
    static boolean H;
    static boolean I;
    public static volatile AMapLocation J;
    private boolean A = false;
    private int B = 0;
    private boolean C = false;
    Handler a;
    private Context b;
    LocationManager c;
    AMapLocationClientOption d;
    private long e = 0;
    long f = 0;
    boolean g = false;
    private int h = 0;
    g53 i = null;
    int j = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
    int k = 80;
    AMapLocation l = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    private int q = 0;
    private GpsStatus r = null;
    private GpsStatus.Listener s = null;
    private GnssStatus.Callback t;
    AMapLocationClientOption.GeoLanguage u = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean v = true;
    long w = 0;
    int x = 0;
    LocationListener y = null;
    private String z = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends GnssStatus.Callback {
        a() {
        }

        public final void onFirstFix(int i) {
            e63.N();
        }

        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            e63.this.f(gnssStatus);
        }

        public final void onStarted() {
            e63.L();
        }

        public final void onStopped() {
            e63.this.M();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements GpsStatus.Listener {
        b() {
        }

        public final void onGpsStatusChanged(int i) {
            try {
                e63 e63 = e63.this;
                LocationManager locationManager = e63.c;
                if (locationManager != null) {
                    e63.r = locationManager.getGpsStatus(e63.r);
                    if (i == 1) {
                        e63.L();
                    } else if (i == 2) {
                        e63.this.M();
                    } else if (i == 3) {
                        e63.N();
                    } else if (i == 4) {
                        e63.this.O();
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                j1.h(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements LocationListener {
        private e63 a;

        c(e63 e63) {
            this.a = e63;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.a = null;
        }

        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                e63 e63 = this.a;
                if (e63 != null) {
                    e63.g(location);
                }
            } catch (Throwable unused) {
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                e63 e63 = this.a;
                if (e63 != null) {
                    e63.l(str);
                }
            } catch (Throwable unused) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                e63 e63 = this.a;
                if (e63 != null) {
                    e63.d(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public e63(Context context, Handler handler) {
        this.b = context;
        this.a = handler;
        try {
            this.c = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            j1.h(th, "GpsLocation", "<init>");
        }
        this.i = new g53();
    }

    private void B(AMapLocation aMapLocation) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    private void D(AMapLocation aMapLocation) {
        try {
            if (!j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.d.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint d2 = v53.d(this.b, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(d2.getLatitude());
            aMapLocation.setLongitude(d2.getLongitude());
            aMapLocation.setOffset(this.d.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private void E(AMapLocation aMapLocation) {
        try {
            int i2 = this.q;
            if (i2 >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i2 == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private AMapLocation G(AMapLocation aMapLocation) {
        if (!m1.q(aMapLocation) || this.h < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.i.a(aMapLocation);
    }

    private static void J(AMapLocation aMapLocation) {
        if (m1.q(aMapLocation) && i1.H()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long c2 = u53.c(time, currentTimeMillis, i1.I());
            if (c2 != time) {
                aMapLocation.setTime(c2);
                l1.b(time, currentTimeMillis);
            }
        }
    }

    private void K() {
        if (this.c != null) {
            try {
                P();
                this.v = true;
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    myLooper = this.b.getMainLooper();
                }
                this.e = m1.B();
                if (r(this.c)) {
                    try {
                        if (m1.g() - G >= 259200000) {
                            if (m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                                this.c.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                                G = m1.g();
                                SharedPreferences.Editor c2 = x53.c(this.b, "pref");
                                x53.i(c2, "lagt", G);
                                x53.f(c2);
                            } else {
                                j1.h(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                            }
                        }
                    } catch (Throwable th) {
                        new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                    }
                    if (this.y == null) {
                        this.y = new c(this);
                    }
                    com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.c, GeocodeSearch.GPS, this.d.getInterval(), this.d.getDeviceModeDistanceFilter(), this.y, myLooper);
                    if (Build.VERSION.SDK_INT >= 24) {
                        a aVar = new a();
                        this.t = aVar;
                        this.c.registerGnssStatusCallback(aVar);
                    } else {
                        b bVar = new b();
                        this.s = bVar;
                        this.c.addGpsStatusListener(bVar);
                    }
                    e(8, 14, "no enough satellites#1401", this.d.getHttpTimeOut());
                    return;
                }
                e(8, 14, "no gps provider#1402", 0);
            } catch (SecurityException e2) {
                this.v = false;
                l1.p(null, 2121);
                e(2, 12, e2.getMessage() + "#1201", 0);
            } catch (Throwable th2) {
                new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
                j1.h(th2, "GpsLocation", "requestLocationUpdates part2");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void L() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void M() {
        this.q = 0;
    }

    /* access modifiers changed from: private */
    public static void N() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O() {
        Iterable<GpsSatellite> satellites;
        int i2 = 0;
        try {
            GpsStatus gpsStatus = this.r;
            if (!(gpsStatus == null || (satellites = gpsStatus.getSatellites()) == null)) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.r.getMaxSatellites();
                while (it.hasNext() && i2 < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i2++;
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.q = i2;
    }

    private void P() {
        if (m1.B() - E <= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V && m1.q(D)) {
            if (this.d.isMockEnable() || !D.isMock()) {
                this.f = m1.B();
                y(D);
            }
        }
    }

    private static boolean Q() {
        try {
            return ((Boolean) k1.e(v1.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), v1.v("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private AMapLocation R() {
        float f2;
        float f3;
        try {
            if (m1.q(this.l) && i1.z() && Q()) {
                JSONObject jSONObject = new JSONObject((String) k1.e(v1.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), v1.v("UZ2V0TmF2aUxvY2F0aW9u"), null, null));
                long optLong = jSONObject.optLong("time");
                if (!this.C) {
                    this.C = true;
                    l1.q("useNaviLoc", "use NaviLoc");
                }
                if (m1.g() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f4 = 0.0f;
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f2 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f3 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f3 = 0.0f;
                    }
                    try {
                        f4 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f3);
                    aMapLocation.setSpeed(f4);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (m1.c(aMapLocation, this.l) <= 300.0f) {
                        synchronized (this.p) {
                            this.l.setLongitude(optDouble2);
                            this.l.setLatitude(optDouble);
                            this.l.setAccuracy(f2);
                            this.l.setBearing(f3);
                            this.l.setSpeed(f4);
                            this.l.setTime(optLong);
                            this.l.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(int i2) {
        if (i2 == 0) {
            try {
                this.f = 0;
                this.q = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void e(int i2, int i3, String str, long j2) {
        try {
            if (this.a != null && this.d.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setErrorCode(i3);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(1);
                obtain.obj = aMapLocation;
                obtain.what = i2;
                this.a.sendMessageDelayed(obtain, j2);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(GnssStatus gnssStatus) {
        Throwable th;
        int i2 = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i3 = 0;
                    while (i2 < satelliteCount) {
                        try {
                            if (gnssStatus.usedInFix(i2)) {
                                i3++;
                            }
                            i2++;
                        } catch (Throwable th2) {
                            th = th2;
                            i2 = i3;
                            j1.h(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.q = i2;
                        }
                    }
                    i2 = i3;
                }
            } catch (Throwable th3) {
                th = th3;
                j1.h(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                this.q = i2;
            }
        }
        this.q = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(Location location) {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location != null) {
            try {
                AMapLocation aMapLocation = new AMapLocation(location);
                if (m1.q(aMapLocation)) {
                    aMapLocation.setProvider(GeocodeSearch.GPS);
                    aMapLocation.setLocationType(1);
                    if (!this.g && m1.q(aMapLocation)) {
                        l1.f(this.b, m1.B() - this.e, j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                        this.g = true;
                    }
                    if (m1.p(aMapLocation, this.q)) {
                        aMapLocation.setMock(true);
                        aMapLocation.setTrustedLevel(4);
                        if (!this.d.isMockEnable()) {
                            int i2 = this.x;
                            if (i2 > 3) {
                                l1.p(null, 2152);
                                aMapLocation.setErrorCode(15);
                                aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                                aMapLocation.setLatitude(0.0d);
                                aMapLocation.setLongitude(0.0d);
                                aMapLocation.setAltitude(0.0d);
                                aMapLocation.setSpeed(0.0f);
                                aMapLocation.setAccuracy(0.0f);
                                aMapLocation.setBearing(0.0f);
                                aMapLocation.setExtras(null);
                                y(aMapLocation);
                                return;
                            }
                            this.x = i2 + 1;
                            return;
                        }
                    } else {
                        this.x = 0;
                    }
                    aMapLocation.setSatellites(this.q);
                    D(aMapLocation);
                    E(aMapLocation);
                    J(aMapLocation);
                    AMapLocation G2 = G(aMapLocation);
                    i(G2);
                    t(G2);
                    synchronized (this.o) {
                        j(G2, J);
                    }
                    try {
                        if (m1.q(G2)) {
                            if (this.l != null) {
                                this.m = location.getTime() - this.l.getTime();
                                this.n = m1.c(this.l, G2);
                            }
                            synchronized (this.p) {
                                this.l = G2.clone();
                            }
                            this.z = null;
                            this.A = false;
                            this.B = 0;
                        }
                    } catch (Throwable th) {
                        j1.h(th, "GpsLocation", "onLocationChangedLast");
                    }
                    y(G2);
                }
            } catch (Throwable th2) {
                j1.h(th2, "GpsLocation", "onLocationChanged");
            }
        }
    }

    private void i(AMapLocation aMapLocation) {
        if (m1.q(aMapLocation)) {
            this.f = m1.B();
            synchronized (F) {
                E = m1.B();
                D = aMapLocation.clone();
            }
            this.h++;
        }
    }

    private void j(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && this.d.isNeedAddress() && m1.c(aMapLocation, aMapLocation2) < ((float) this.j)) {
            j1.b(aMapLocation, aMapLocation2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.f = 0;
                this.q = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (H) {
                return I;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                I = false;
            } else {
                I = allProviders.contains(GeocodeSearch.GPS);
            }
            H = true;
            return I;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            return I;
        }
    }

    private void t(AMapLocation aMapLocation) {
        Handler handler;
        if (m1.q(aMapLocation) && this.a != null) {
            long B2 = m1.B();
            if (this.d.getInterval() <= DanmakuFactory.DEFAULT_DANMAKU_DURATION || B2 - this.w > this.d.getInterval() - DanmakuFactory.DEFAULT_DANMAKU_DURATION) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat(BQCCameraParam.FOCUS_AREA_RADIUS, aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.o) {
                    if (J == null) {
                        handler = this.a;
                    } else if (m1.c(aMapLocation, J) > ((float) this.k)) {
                        handler = this.a;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    private boolean w(String str) {
        try {
            ArrayList<String> E2 = m1.E(str);
            ArrayList<String> E3 = m1.E(this.z);
            if (E2.size() < 8 || E3.size() < 8) {
                return false;
            }
            return m1.t(this.z, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private void y(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.d.getLocationMode())) {
            return;
        }
        if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.d.getDeviceModeDistanceFilter() > 0.0f) {
            B(aMapLocation);
        } else if (m1.B() - this.w >= this.d.getInterval() - 200) {
            this.w = m1.B();
            B(aMapLocation);
        }
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager locationManager = this.c;
        if (locationManager == null || !r(locationManager)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int i2 = Settings.Secure.getInt(this.b.getContentResolver(), "location_mode", 0);
            if (i2 == 0) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
        } else if (!this.c.isProviderEnabled(GeocodeSearch.GPS)) {
            return 2;
        }
        return !this.v ? 4 : 0;
    }

    public final int C() {
        return this.q;
    }

    public final boolean F() {
        AMapLocationClientOption aMapLocationClientOption = this.d;
        return aMapLocationClientOption != null && !aMapLocationClientOption.isOnceLocation() && m1.B() - this.f > 300000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    public final AMapLocation b(AMapLocation aMapLocation, String str) {
        long j2;
        long B2;
        if (this.l == null) {
            return aMapLocation;
        }
        if ((!this.d.isMockEnable() && this.l.isMock()) || !m1.q(this.l)) {
            return aMapLocation;
        }
        AMapLocation R = R();
        if (R == null || !m1.q(R)) {
            float speed = this.l.getSpeed();
            if (speed == 0.0f) {
                long j3 = this.m;
                if (j3 > 0 && j3 < 8) {
                    float f2 = this.n;
                    if (f2 > 0.0f) {
                        speed = f2 / ((float) j3);
                    }
                }
            }
            if (aMapLocation != null && m1.q(aMapLocation)) {
                if (aMapLocation.getAccuracy() < 200.0f) {
                    int i2 = this.B + 1;
                    this.B = i2;
                    if (this.z == null && i2 >= 2) {
                        this.A = true;
                    }
                    j2 = speed > 5.0f ? 10000 : 15000;
                } else {
                    if (!TextUtils.isEmpty(this.z)) {
                        this.A = false;
                        this.B = 0;
                    }
                    if (speed > 5.0f) {
                        j2 = 20000;
                    }
                }
                B2 = m1.B() - this.f;
                if (B2 <= 30000) {
                    return aMapLocation;
                }
                if (B2 < j2) {
                    if (this.z == null && this.B >= 2) {
                        this.z = str;
                    }
                    AMapLocation clone = this.l.clone();
                    clone.setTrustedLevel(2);
                    return clone;
                } else if (!this.A || !w(str)) {
                    this.z = null;
                    this.B = 0;
                    synchronized (this.p) {
                        this.l = null;
                    }
                    this.m = 0;
                    this.n = 0.0f;
                    return aMapLocation;
                } else {
                    AMapLocation clone2 = this.l.clone();
                    clone2.setTrustedLevel(3);
                    return clone2;
                }
            }
            j2 = 30000;
            B2 = m1.B() - this.f;
            if (B2 <= 30000) {
            }
        } else {
            R.setTrustedLevel(2);
            return R;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|(1:7)|8|9|(1:11)|12|13|(1:15)|16|17|(1:19)|20|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[Catch:{ all -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ all -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[Catch:{ all -> 0x0031 }] */
    public final void c() {
        LocationManager locationManager = this.c;
        if (locationManager != null) {
            LocationListener locationListener = this.y;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((c) this.y).a();
                this.y = null;
            }
            GpsStatus.Listener listener = this.s;
            if (listener != null) {
                this.c.removeGpsStatusListener(listener);
            }
            GnssStatus.Callback callback = this.t;
            if (callback != null) {
                this.c.unregisterGnssStatusCallback(callback);
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeMessages(8);
            }
            this.q = 0;
            this.e = 0;
            this.w = 0;
            this.f = 0;
            this.h = 0;
            this.x = 0;
            this.i.c();
            this.l = null;
            this.m = 0;
            this.n = 0.0f;
            this.z = null;
            this.C = false;
        }
    }

    public final void h(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.j = bundle.getInt("I_MAX_GEO_DIS");
                this.k = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    synchronized (this.o) {
                        J = aMapLocation;
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void k(AMapLocationClientOption aMapLocationClientOption) {
        this.d = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.d = new AMapLocationClientOption();
        }
        try {
            G = x53.b(this.b, "pref", "lagt", G);
        } catch (Throwable unused) {
        }
        K();
    }

    public final void u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.d = aMapLocationClientOption;
        if (!(aMapLocationClientOption.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors || (handler = this.a) == null)) {
            handler.removeMessages(8);
        }
        if (this.u != this.d.getGeoLanguage()) {
            synchronized (this.o) {
                J = null;
            }
        }
        this.u = this.d.getGeoLanguage();
    }

    public final boolean v() {
        return m1.B() - this.f <= 2800;
    }

    public final void x() {
        this.x = 0;
    }
}
