package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: Taobao */
public final class kd {
    Context a;
    LocationManager b;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    Object g = null;
    boolean h = false;
    boolean i = false;
    LocationListener j = new LocationListener() {
        /* class com.amap.api.mapcore.util.kd.AnonymousClass1 */

        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setProvider(GeocodeSearch.GPS);
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i);
                    inner_3dMap_location.setTime(jz.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                    kd.this.f = inner_3dMap_location;
                    kd.this.c = kc.b();
                    kd.this.d = true;
                } catch (Throwable th) {
                    jy.a(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equals(str)) {
                    kd.this.d = false;
                }
            } catch (Throwable th) {
                jy.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public kd(Context context) {
        Object newInstance;
        if (context != null) {
            this.a = context;
            e();
            try {
                if (this.g == null && !this.i) {
                    if (this.h) {
                        newInstance = CoordinateConverter.class.getConstructor(Context.class).newInstance(context);
                    } else {
                        newInstance = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    this.g = newInstance;
                }
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = (LocationManager) this.a.getSystemService("location");
            }
        }
    }

    private void e() {
        try {
            this.h = true;
        } catch (Throwable unused) {
        }
    }

    private void f() {
        try {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.a.getMainLooper();
            }
            try {
                this.b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", new Bundle());
            } catch (Throwable unused) {
            }
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.b, GeocodeSearch.GPS, 800, 0.0f, this.j, myLooper);
        } catch (SecurityException unused2) {
        } catch (Throwable th) {
            jy.a(th, "MAPGPSLocation", "requestLocationUpdates");
        }
    }

    private void g() {
        this.d = false;
        this.c = 0;
        this.f = null;
    }

    public final void a() {
        if (!this.e) {
            f();
            this.e = true;
        }
    }

    public final void b() {
        LocationListener locationListener;
        this.e = false;
        g();
        LocationManager locationManager = this.b;
        if (locationManager != null && (locationListener = this.j) != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    public final boolean c() {
        if (!this.d) {
            return false;
        }
        if (kc.b() - this.c <= 10000) {
            return true;
        }
        this.f = null;
        return false;
    }

    public final Inner_3dMap_location d() {
        double[] a2;
        Object obj;
        Object obj2;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location clone = this.f.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (jy.a(clone.getLatitude(), clone.getLongitude())) {
                        Object[] objArr = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.h) {
                            obj2 = ka.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            Class<?> cls = Class.forName("com.amap.api.maps.model.LatLng");
                            Class<?> cls2 = Double.TYPE;
                            obj = cls.getConstructor(cls2, cls2).newInstance(Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude()));
                        } else {
                            obj2 = ka.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            Class<?> cls3 = Class.forName("com.amap.api.maps2d.model.LatLng");
                            Class<?> cls4 = Double.TYPE;
                            obj = cls3.getConstructor(cls4, cls4).newInstance(Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude()));
                        }
                        ka.a(this.g, "coord", obj);
                        ka.a(this.g, "from", obj2);
                        Object a3 = ka.a(this.g, "convert", new Object[0]);
                        double doubleValue = ((Double) a3.getClass().getDeclaredField("latitude").get(a3)).doubleValue();
                        double doubleValue2 = ((Double) a3.getClass().getDeclaredField("longitude").get(a3)).doubleValue();
                        clone.setLatitude(doubleValue);
                        clone.setLongitude(doubleValue2);
                    }
                } else if (this.i && jy.a(clone.getLatitude(), clone.getLongitude()) && (a2 = jq.a(clone.getLongitude(), clone.getLatitude())) != null) {
                    clone.setLatitude(a2[1]);
                    clone.setLongitude(a2[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return clone;
    }
}
