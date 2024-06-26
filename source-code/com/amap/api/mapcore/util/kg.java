package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public final class kg implements Inner_3dMap_locationManagerBase {
    Context a = null;
    ArrayList<Inner_3dMap_locationListener> b = new ArrayList<>();
    Object c = new Object();
    Handler d = null;
    a e = null;
    Handler f = null;
    Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
    kk h = null;
    Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    boolean j = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends HandlerThread {
        kg a;

        public a(String str, kg kgVar) {
            super(str);
            this.a = kgVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                kg kgVar = this.a;
                kg kgVar2 = this.a;
                kgVar.h = new kk(kgVar2.a, kgVar2.d);
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public kg(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
            e();
            return;
        }
        throw new IllegalArgumentException("Context参数不能为null");
    }

    private Handler a(Looper looper) {
        kh khVar;
        synchronized (this.c) {
            khVar = new kh(looper, this);
            this.f = khVar;
        }
        return khVar;
    }

    private void a(int i2) {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(i2);
            }
        }
    }

    private void a(int i2, Object obj, long j2) {
        synchronized (this.c) {
            if (this.f != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = obj;
                this.f.sendMessageDelayed(obtain, j2);
            }
        }
    }

    private void e() {
        try {
            this.d = Looper.myLooper() == null ? new ki(this.a.getMainLooper(), this) : new ki(this);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "initResultHandler");
        }
        try {
            a aVar = new a("locaitonClientActionThread", this);
            this.e = aVar;
            aVar.setPriority(5);
            this.e.start();
            this.f = a(this.e.getLooper());
        } catch (Throwable th2) {
            jy.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void f() {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            if (!this.j) {
                this.j = true;
                a(1005, null, 0);
            }
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (kn.a(inner_3dMap_location)) {
                    ke.a = inner_3dMap_location;
                }
            } catch (Throwable th) {
                jy.a(th, "MapLocationManager", "callBackLocation");
                return;
            }
        }
        if (this.j) {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                inner_3dMap_location.setProvider("lbs");
            }
            inner_3dMap_location.setAltitude(kc.b(inner_3dMap_location.getAltitude()));
            inner_3dMap_location.setBearing(kc.a(inner_3dMap_location.getBearing()));
            inner_3dMap_location.setSpeed(kc.a(inner_3dMap_location.getSpeed()));
            Iterator<Inner_3dMap_locationListener> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLocationChanged(inner_3dMap_location);
                } catch (Throwable unused) {
                }
            }
        }
        if (this.g.isOnceLocation()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                if (!this.b.contains(inner_3dMap_locationListener)) {
                    this.b.add(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                jy.a(th, "MapLocationManager", "doSetLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.g = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.g = new Inner_3dMap_locationOption();
        }
        kk kkVar = this.h;
        if (kkVar != null) {
            kkVar.a(this.g);
        }
        if (this.j && !this.i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.i = this.g.getLocationMode();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        long j2 = 1000;
        try {
            kk kkVar = this.h;
            if (kkVar != null) {
                kkVar.a();
            }
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(1005, null, j2);
            }
        } catch (Throwable th) {
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(1005, null, j2);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.b.isEmpty() && this.b.contains(inner_3dMap_locationListener)) {
                    this.b.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                jy.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.b.isEmpty()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            this.j = false;
            a(1004);
            a(1005);
            kk kkVar = this.h;
            if (kkVar != null) {
                kkVar.c();
            }
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        c();
        kk kkVar = this.h;
        if (kkVar != null) {
            kkVar.d();
        }
        ArrayList<Inner_3dMap_locationListener> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
        f();
        a aVar = this.e;
        if (aVar != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    ka.a(aVar, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    aVar = this.e;
                }
            }
            aVar.quit();
        }
        this.e = null;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void destroy() {
        try {
            a(1007, null, 0);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final Inner_3dMap_location getLastKnownLocation() {
        return ke.a;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0);
        } catch (Throwable th) {
            jy.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void startLocation() {
        try {
            a(1004, null, 0);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "startLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void stopLocation() {
        try {
            a(1006, null, 0);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            jy.a(th, "MapLocationManager", "stopLocation");
        }
    }
}
