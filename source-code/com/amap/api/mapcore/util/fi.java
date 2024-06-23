package com.amap.api.mapcore.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
public class fi {
    Context a;
    Inner_3dMap_locationManagerBase b = null;
    Object c = null;
    boolean d = false;
    ke e = null;
    gm f = null;

    public fi(Context context) {
        try {
            this.f = kn.a();
        } catch (Throwable unused) {
        }
        this.e = new ke();
        a(context);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                try {
                    ServiceInfo serviceInfo = null;
                    try {
                        serviceInfo = this.a.getPackageManager().getServiceInfo(new ComponentName(this.a, "com.amap.api.location.APSService"), 128);
                    } catch (Throwable unused) {
                    }
                    if (serviceInfo != null) {
                        this.d = true;
                    }
                } catch (Throwable unused2) {
                    this.d = false;
                }
                if (this.d) {
                    this.c = new AMapLocationClient(this.a);
                } else {
                    this.b = b(this.a);
                }
            } catch (Throwable th) {
                jy.a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private static Inner_3dMap_locationManagerBase b(Context context) {
        return new kg(context);
    }

    public void a() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            jy.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.d) {
                    this.e.a(this.c, inner_3dMap_locationListener);
                } else {
                    this.b.setLocationListener(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                jy.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption != null) {
            try {
                if (this.d) {
                    ke.a(this.c, inner_3dMap_locationOption);
                } else {
                    this.b.setLocationOption(inner_3dMap_locationOption);
                }
            } catch (Throwable th) {
                jy.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public void b() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            jy.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void c() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
            if (this.e != null) {
                this.e = null;
            }
        } catch (Throwable th) {
            jy.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
