package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class fy implements LocationSource.OnLocationChangedListener, LBSTraceBase {
    private static final TimeUnit s = TimeUnit.SECONDS;
    int a = Runtime.getRuntime().availableProcessors();
    private Context b;
    private CoordinateConverter c;
    private ExecutorService d;
    private ExecutorService e;
    private long f = 2000;
    private int g = 5;
    private TraceStatusListener h;
    private as i;
    private List<TraceLocation> j = new ArrayList();
    private int k = 0;
    private int l = 0;
    private long m = 0;
    private c n;
    private TraceLocation o = null;
    private List<LatLng> p = new ArrayList();
    private List<LatLng> q = new ArrayList();
    private List<LatLng> r = new ArrayList();
    private BlockingQueue<Runnable> t = new LinkedBlockingQueue();
    private BlockingQueue<Runnable> u = new LinkedBlockingQueue();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements TraceListener {
        private final List<TraceLocation> b;

        public b(List<TraceLocation> list) {
            this.b = list;
        }

        private void a(int i, List<LatLng> list) {
            try {
                synchronized (fy.this.r) {
                    fy.this.r.clear();
                    fy.this.r.addAll(list);
                }
                fy.this.q.clear();
                if (i == 0) {
                    fy.this.q.addAll(fy.this.r);
                } else {
                    fy.this.q.addAll(fy.this.p);
                    fy.this.q.addAll(fy.this.r);
                }
                fy.this.h.onTraceStatus(fy.this.j, fy.this.q, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public void onFinished(int i, List<LatLng> list, int i2, int i3) {
            a(i, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (fy.this.r != null) {
                arrayList.addAll(fy.this.r);
            }
            List<TraceLocation> list = this.b;
            if (list != null) {
                int size = list.size();
                if (this.b.size() > fy.this.g) {
                    for (int i2 = size - fy.this.g; i2 < size; i2++) {
                        TraceLocation traceLocation = this.b.get(i2);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends Handler {
        private TraceListener a;

        public c(Looper looper) {
            super(looper);
        }

        public void a(TraceListener traceListener) {
            this.a = traceListener;
        }

        public void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.a != null && (data = message.getData()) != null) {
                    int i = data.getInt("lineID");
                    switch (message.what) {
                        case 100:
                            this.a.onTraceProcessing(i, message.arg1, (List) message.obj);
                            return;
                        case 101:
                            this.a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                            return;
                        case 102:
                            this.a.onRequestFailed(i, (String) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public fy(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new CoordinateConverter(applicationContext);
        this.n = new c(Looper.getMainLooper());
        gi.a().a(this.b);
        int i2 = this.a * 2;
        TimeUnit timeUnit = s;
        this.d = new ThreadPoolExecutor(1, i2, 1, timeUnit, this.t, new ed("AMapTraceManagerProcess"), new ThreadPoolExecutor.AbortPolicy());
        this.e = new ThreadPoolExecutor(1, this.a * 2, 1, timeUnit, this.u, new ed("AMapTraceManagerRequest"), new ThreadPoolExecutor.AbortPolicy());
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void destroy() {
        try {
            stopTrace();
            ExecutorService executorService = this.d;
            if (executorService != null && !executorService.isShutdown()) {
                this.d.shutdownNow();
                this.d = null;
            }
            ExecutorService executorService2 = this.e;
            if (executorService2 != null && !executorService2.isShutdown()) {
                this.e.shutdownNow();
                this.e = null;
            }
            this.j = null;
            this.h = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b = null;
        this.c = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        TraceStatusListener traceStatusListener;
        if (this.h != null) {
            try {
                if (System.currentTimeMillis() - this.m >= 30000 && (traceStatusListener = this.h) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.m = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i2 = extras.getInt("errorCode");
                if (i2 != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i2 + "\"  errorInfo:" + extras.getString(MyLocationStyle.ERROR_INFO) + "\"]");
                    return;
                }
                synchronized (this.j) {
                    TraceLocation traceLocation = new TraceLocation(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location), location.getSpeed(), location.getBearing(), location.getTime());
                    if (!a(this.o, traceLocation)) {
                        this.j.add(traceLocation);
                        this.o = traceLocation;
                        int i3 = this.k + 1;
                        this.k = i3;
                        if (i3 == this.g) {
                            this.l += i3;
                            a();
                            this.k = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
        try {
            this.d.execute(new a(i2, list, i3, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setLocationInterval(long j2) {
        this.f = j2;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setTraceStatusInterval(int i2) {
        this.g = Math.max(i2, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void startTrace(TraceStatusListener traceStatusListener) {
        if (this.b == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.m = System.currentTimeMillis();
        this.h = traceStatusListener;
        if (this.i == null) {
            as asVar = new as(this.b);
            this.i = asVar;
            asVar.a(this.f);
            this.i.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void stopTrace() {
        b();
        c();
    }

    private boolean a(TraceLocation traceLocation, TraceLocation traceLocation2) {
        if (traceLocation == null || traceLocation2 == null || traceLocation.getLatitude() != traceLocation2.getLatitude() || traceLocation.getLongitude() != traceLocation2.getLongitude()) {
            return false;
        }
        return true;
    }

    private void b() {
        as asVar = this.i;
        if (asVar != null) {
            asVar.deactivate();
            this.i = null;
        }
    }

    private void c() {
        this.t.clear();
        this.u.clear();
        List<TraceLocation> list = this.j;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.j;
                if (list2 != null) {
                    list2.clear();
                }
                this.l = 0;
                this.k = 0;
                this.m = 0;
                this.o = null;
            }
        }
    }

    private void a() {
        int size = this.j.size();
        if (size >= this.g) {
            if (size <= 50) {
                ArrayList arrayList = new ArrayList(this.j);
                queryProcessedTrace(0, arrayList, 1, new b(arrayList));
                return;
            }
            int i2 = size - 50;
            if (i2 >= 0) {
                a(new ArrayList(this.j.subList(i2 - this.g, i2)));
                ArrayList arrayList2 = new ArrayList(this.j.subList(i2, size));
                queryProcessedTrace(i2, arrayList2, 1, new b(arrayList2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Runnable {
        private List<TraceLocation> b = new ArrayList();
        private int c;
        private int d;
        private List<TraceLocation> e;
        private String f;
        private TraceListener g;

        public a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.c = i2;
            this.d = i;
            this.e = list;
            this.f = ei.a();
            this.g = traceListener;
        }

        private int a() {
            List<TraceLocation> list = this.e;
            int i = 0;
            if (!(list == null || list.size() == 0)) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.e) {
                    if (traceLocation != null) {
                        if (((double) traceLocation.getSpeed()) < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i += a(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i;
        }

        public void run() {
            try {
                fy.this.n.a(this.g);
                int a2 = a();
                List<TraceLocation> list = this.e;
                if (list != null) {
                    if (list.size() >= 2) {
                        for (TraceLocation traceLocation : this.e) {
                            TraceLocation copy = traceLocation.copy();
                            if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                                this.b.add(copy);
                            }
                        }
                        int size = (this.b.size() - 2) / 500;
                        fz.a().a(this.f, this.d, size, a2);
                        int i = 500;
                        int i2 = 0;
                        while (i2 <= size) {
                            if (i2 == size) {
                                i = this.b.size();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < i; i3++) {
                                TraceLocation remove = this.b.remove(0);
                                if (remove != null) {
                                    int i4 = this.c;
                                    if (i4 != 1) {
                                        if (i4 == 3) {
                                            fy.this.c.from(CoordinateConverter.CoordType.BAIDU);
                                        } else if (i4 == 2) {
                                            fy.this.c.from(CoordinateConverter.CoordType.GPS);
                                        }
                                        fy.this.c.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                        LatLng convert = fy.this.c.convert();
                                        if (convert != null) {
                                            remove.setLatitude(convert.latitude);
                                            remove.setLongitude(convert.longitude);
                                        }
                                    }
                                    arrayList.add(remove);
                                }
                            }
                            if (arrayList.size() >= 2) {
                                if (arrayList.size() <= 500) {
                                    fy.this.e.execute(new fx(fy.this.b, fy.this.n, arrayList, this.c, this.f, this.d, i2));
                                    i2++;
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            i = i;
                        }
                        return;
                    }
                }
                fz.a().a(fy.this.n, this.d, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private int a(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }
    }

    private void a(List<TraceLocation> list) {
        synchronized (this.r) {
            if (list != null) {
                if (list.size() >= 1) {
                    if (this.r.size() >= 1) {
                        LatLng latLng = null;
                        double d2 = 0.0d;
                        TraceLocation traceLocation = null;
                        double d3 = 0.0d;
                        for (TraceLocation traceLocation2 : list) {
                            if (traceLocation2 != null) {
                                if (traceLocation != null) {
                                    double a2 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                                    if (a2 <= 100.0d) {
                                        d3 += a2;
                                    }
                                }
                                traceLocation = traceLocation2;
                            }
                        }
                        Iterator<LatLng> it = this.r.iterator();
                        while (it.hasNext()) {
                            LatLng next = it.next();
                            if (next == null) {
                                it.remove();
                            } else {
                                if (latLng != null) {
                                    d2 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                    if (d2 >= d3) {
                                        break;
                                    }
                                    this.p.add(next);
                                    it.remove();
                                } else {
                                    this.p.add(next);
                                    it.remove();
                                }
                                latLng = next;
                            }
                        }
                    }
                }
            }
        }
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        double d7 = d3 > d5 ? d3 - d5 : d5 - d3;
        return Math.sqrt((d6 * d6) + (d7 * d7));
    }
}
