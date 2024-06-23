package com.loc;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.taobao.dp.http.ResCode;
import com.taobao.weex.common.Constants;
import com.youku.playerservice.axp.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.d23;
import tb.fw0;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class a {
    private static boolean z;
    l1 a = null;
    Context b = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    private Object f = new Object();
    volatile int g = 1;
    ArrayList<GeoFence> h = new ArrayList<>();
    d i = null;
    Object j = new Object();
    Object k = new Object();
    c l = null;
    b m = null;
    volatile boolean n = false;
    volatile boolean o = false;
    volatile boolean p = false;
    d23 q = null;
    l0 r = null;
    AMapLocationClient s = null;
    volatile AMapLocation t = null;
    long u = 0;
    AMapLocationClientOption v = null;
    int w = 0;
    AMapLocationListener x = new C0180a();
    volatile boolean y = false;

    /* renamed from: com.loc.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0180a implements AMapLocationListener {
        C0180a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!a.this.y && a.this.p) {
                    a.this.t = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.u = m1.B();
                            a.this.j(5, null, 0);
                            z = true;
                        } else {
                            int errorCode = aMapLocation.getErrorCode();
                            String errorInfo = aMapLocation.getErrorInfo();
                            a.o("定位失败", errorCode, errorInfo, "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        a aVar = a.this;
                        aVar.w = 0;
                        aVar.j(6, null, 0);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.n) {
                        a.this.C(7);
                        bundle.putLong(Constants.Name.INTERVAL, 2000);
                        a.this.j(8, bundle, 2000);
                    }
                    a aVar2 = a.this;
                    int i2 = aVar2.w + 1;
                    aVar2.w = i2;
                    if (i2 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        a.this.i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.E(message.getData());
                        return;
                    case 1:
                        a.this.L(message.getData());
                        return;
                    case 2:
                        a.this.R(message.getData());
                        return;
                    case 3:
                        a.this.O(message.getData());
                        return;
                    case 4:
                        a.this.T(message.getData());
                        return;
                    case 5:
                        a.this.Q();
                        return;
                    case 6:
                        a aVar = a.this;
                        aVar.m(aVar.t);
                        return;
                    case 7:
                        a.this.N();
                        return;
                    case 8:
                        a.this.b0(message.getData());
                        return;
                    case 9:
                        a.this.k(message.getData());
                        return;
                    case 10:
                        a.this.J();
                        return;
                    case 11:
                        a.this.X(message.getData());
                        return;
                    case 12:
                        a.this.V(message.getData());
                        return;
                    case 13:
                        a.this.U();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends Handler {
        public d() {
        }

        public d(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.Y(data);
                        return;
                    case 1001:
                        try {
                            a.this.F((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            a.this.K(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        try {
            this.b = context.getApplicationContext();
            a0();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManger", "<init>");
        }
    }

    private static DPoint A(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (DPoint dPoint2 : list) {
                d2 += dPoint2.getLatitude();
                d3 += dPoint2.getLongitude();
            }
            return new DPoint(m1.z(d2 / ((double) list.size())), m1.z(d3 / ((double) list.size())));
        } catch (Throwable th) {
            j1.h(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    private void D(int i2, Bundle bundle) {
        int i3;
        String str;
        Throwable th;
        int i4;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i4 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString("city");
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i5 = bundle.getInt("searchSize", 10);
                float f2 = bundle.getFloat("aroundRadius", 3000.0f);
                if (u(i2, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.d);
                    str4 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str3 = "errorCode";
                    try {
                        bundle3.putLong("expiration", -1);
                        bundle3.putInt("activatesAction", this.g);
                        if (i2 == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            str5 = this.q.b(this.b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i5));
                        } else if (i2 != 2) {
                            str5 = i2 != 3 ? null : this.q.a(this.b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double z2 = m1.z(dPoint.getLatitude());
                            double z3 = m1.z(dPoint.getLongitude());
                            int intValue = Float.valueOf(f2).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            str5 = this.q.c(this.b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i5), String.valueOf(z2), String.valueOf(z3), String.valueOf(intValue));
                        }
                        if (str5 != null) {
                            int b2 = 1 == i2 ? l0.b(str5, arrayList2, bundle3) : 0;
                            if (2 == i2) {
                                b2 = l0.e(str5, arrayList2, bundle3);
                            }
                            if (3 == i2) {
                                b2 = this.r.f(str5, arrayList2, bundle3);
                            }
                            if (b2 != 10000) {
                                i3 = M(b2);
                            } else if (arrayList2.isEmpty()) {
                                i3 = 16;
                            } else {
                                i3 = c(arrayList2);
                                if (i3 == 0) {
                                    try {
                                        arrayList.addAll(arrayList2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = str3;
                                    }
                                }
                            }
                        } else {
                            i3 = 4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str3;
                        i3 = 0;
                        try {
                            j1.h(th, "GeoFenceManager", "doAddGeoFenceNearby");
                            bundle2.putInt(str, 8);
                            i(1000, bundle2);
                        } catch (Throwable th4) {
                            bundle2.putInt(str, i3);
                            i(1000, bundle2);
                            throw th4;
                        }
                    }
                } else {
                    str4 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str3 = "errorCode";
                    i3 = 1;
                }
                bundle2.putString(str4, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i4 = i3;
                str2 = str3;
            }
            bundle2.putInt(str2, i4);
            i(1000, bundle2);
        } catch (Throwable th5) {
            th = th5;
            str = "errorCode";
            i3 = 0;
            j1.h(th, "GeoFenceManager", "doAddGeoFenceNearby");
            bundle2.putInt(str, 8);
            i(1000, bundle2);
        }
    }

    private static boolean G(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2 = true;
        try {
            if (x(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(m1.B());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && m1.B() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            j1.h(th, Utils.TAG, "isFenceStatusChanged");
            return z2;
        }
    }

    private static boolean H(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return j1.l(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private int I(GeoFence geoFence) {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            if (this.h.contains(geoFence)) {
                return 17;
            }
            this.h.add(geoFence);
            return 0;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addGeoFence2List");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static int M(int i2) {
        if (!(i2 == 1 || i2 == 7 || i2 == 4 || i2 == 5 || i2 == 16 || i2 == 17)) {
            switch (i2) {
                case 10000:
                    i2 = 0;
                    break;
                case 10001:
                case 10002:
                case ResCode.ENVIRONMENT_CHANGED /*{ENCODED_INT: 10007}*/:
                case 10008:
                case 10009:
                case 10012:
                case 10013:
                    i2 = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case 10006:
                case 10010:
                case 10011:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i2 = 4;
                    break;
                default:
                    switch (i2) {
                        case 20000:
                        case 20001:
                        case BaseBioNavigatorActivity.n:
                            i2 = 1;
                            break;
                        case BaseBioNavigatorActivity.o:
                        default:
                            i2 = 8;
                            break;
                    }
            }
        }
        if (i2 != 0) {
            o("添加围栏失败", i2, "searchErrCode is ".concat(String.valueOf(i2)), new String[0]);
        }
        return i2;
    }

    private void P(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        i(1001, bundle);
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f2 = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float d2 = m1.d(dPoint, geoFence.getCenter());
                    if (d2 > geoFence.getMinDis2Center() && d2 < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (d2 > geoFence.getMaxDis2Center()) {
                        f2 = Math.min(f2, d2 - geoFence.getMaxDis2Center());
                    }
                    if (d2 < geoFence.getMinDis2Center()) {
                        f2 = Math.min(f2, geoFence.getMinDis2Center() - d2);
                    }
                }
            }
        }
        return f2;
    }

    private void a0() {
        if (!this.p) {
            this.p = true;
        }
        if (!this.o) {
            try {
                this.i = Looper.myLooper() == null ? new d(this.b.getMainLooper()) : new d();
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManger", "init 1");
            }
            try {
                b bVar = new b("fenceActionThread");
                this.m = bVar;
                bVar.setPriority(5);
                this.m.start();
                this.l = new c(this.m.getLooper());
            } catch (Throwable th2) {
                j1.h(th2, "GeoFenceManger", "init 2");
            }
            try {
                this.q = new d23(this.b);
                this.r = new l0();
                this.v = new AMapLocationClientOption();
                this.s = new AMapLocationClient(this.b);
                this.v.setLocationCacheEnable(true);
                this.v.setNeedAddress(false);
                this.s.setLocationListener(this.x);
                if (this.a == null) {
                    this.a = new l1();
                }
            } catch (Throwable th3) {
                j1.h(th3, "GeoFenceManger", "initBase");
            }
            this.o = true;
            try {
                String str = this.d;
                if (str != null && this.c == null) {
                    d(str);
                }
            } catch (Throwable th4) {
                j1.h(th4, "GeoFenceManger", "init 4");
            }
            if (!z) {
                z = true;
                l1.n(this.b, "O020", null);
            }
        }
    }

    static float b(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.min(f2, m1.d(dPoint, dPoint2));
            }
        }
        return f2;
    }

    private int c(List<GeoFence> list) {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                I(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addGeoFenceList");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private boolean c0() {
        ArrayList<GeoFence> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    private void d0() {
        try {
            synchronized (this.k) {
                d dVar = this.i;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.i = null;
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private static Bundle e(GeoFence geoFence, String str, String str2, int i2, int i3) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i2);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i3);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private void e0() {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    cVar.removeCallbacksAndMessages(null);
                }
                this.l = null;
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private GeoFence f(Bundle bundle, boolean z2) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z2) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = A(arrayList);
            }
            geoFence.setMaxDis2Center(z(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f2 = 1000.0f;
            float f3 = bundle.getFloat("fenceRadius", 1000.0f);
            if (f3 > 0.0f) {
                f2 = f3;
            }
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.g);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1);
        geoFence.setPendingIntent(this.c);
        StringBuilder sb = new StringBuilder();
        sb.append(l0.c());
        geoFence.setFenceId(sb.toString());
        l1 l1Var = this.a;
        if (l1Var != null) {
            l1Var.d(this.b, 2);
        }
        return geoFence;
    }

    private void f0() {
        if (this.y || this.l == null) {
            return;
        }
        if (h0()) {
            j(6, null, 0);
            j(5, null, 0);
            return;
        }
        C(7);
        j(7, null, 0);
    }

    private void g0() {
        try {
            if (this.n) {
                C(8);
            }
            AMapLocationClient aMapLocationClient = this.s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.n = false;
        } catch (Throwable unused) {
        }
    }

    private boolean h0() {
        return this.t != null && m1.q(this.t) && m1.B() - this.u < 10000;
    }

    static void o(String str, int i2, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append(StringUtils.LF);
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i2)));
        stringBuffer.append(StringUtils.LF);
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append(StringUtils.LF);
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append(StringUtils.LF);
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean u(int i2, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    o("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    private static boolean w(GeoFence geoFence, int i2) {
        boolean z2 = true;
        boolean z3 = false;
        if ((i2 & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z3 = true;
                }
            } catch (Throwable th) {
                j1.h(th, Utils.TAG, "remindStatus");
                return false;
            }
        }
        if ((i2 & 2) == 2 && geoFence.getStatus() == 2) {
            z3 = true;
        }
        if (!((i2 & 4) == 4 && geoFence.getStatus() == 3)) {
            z2 = z3;
        }
        return z2;
    }

    private static boolean x(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2;
        boolean z3 = false;
        try {
            if (m1.q(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    for (List<DPoint> list : geoFence.getPointList()) {
                        try {
                            if (H(aMapLocation, list)) {
                                z3 = true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = z3;
                            j1.h(th, Utils.TAG, "isInGeoFence");
                            return z2;
                        }
                    }
                    return z3;
                }
                if (y(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            j1.h(th, Utils.TAG, "isInGeoFence");
            return z2;
        }
    }

    private static boolean y(AMapLocation aMapLocation, DPoint dPoint, float f2) {
        return m1.e(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f2;
    }

    static float z(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.max(f2, m1.d(dPoint, dPoint2));
            }
        }
        return f2;
    }

    public final List<GeoFence> B() {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            return (ArrayList) this.h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    public final void C(int i2) {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    cVar.removeMessages(i2);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void E(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i2 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint == null) {
                    str2 = str;
                } else if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    o("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("errorCode", i2);
                    bundle2.putParcelableArrayList("resultList", arrayList);
                    bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    i(1000, bundle2);
                } else {
                    GeoFence f2 = f(bundle, false);
                    i2 = I(f2);
                    if (i2 == 0) {
                        arrayList.add(f2);
                    }
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i2);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    i(1000, bundle22);
                }
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i2);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            i(1000, bundle222);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    /* access modifiers changed from: package-private */
    public final void F(GeoFence geoFence) {
        PendingIntent pendingIntent;
        Context context;
        try {
            synchronized (this.f) {
                if (this.b != null) {
                    if (this.c != null || geoFence.getPendingIntent() != null) {
                        Intent intent = new Intent();
                        intent.putExtras(e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                        String str = this.d;
                        if (str != null) {
                            intent.setAction(str);
                        }
                        intent.setPackage(l.g(this.b));
                        if (geoFence.getPendingIntent() != null) {
                            pendingIntent = geoFence.getPendingIntent();
                            context = this.b;
                        } else {
                            pendingIntent = this.c;
                            context = this.b;
                        }
                        pendingIntent.send(context, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void J() {
        try {
            if (this.o) {
                ArrayList<GeoFence> arrayList = this.h;
                if (arrayList != null) {
                    arrayList.clear();
                    this.h = null;
                }
                if (!this.p) {
                    e0();
                    AMapLocationClient aMapLocationClient = this.s;
                    if (aMapLocationClient != null) {
                        aMapLocationClient.stopLocation();
                        this.s.onDestroy();
                    }
                    this.s = null;
                    b bVar = this.m;
                    if (bVar != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            bVar.quitSafely();
                        } else {
                            bVar.quit();
                        }
                    }
                    this.m = null;
                    this.q = null;
                    synchronized (this.f) {
                        PendingIntent pendingIntent = this.c;
                        if (pendingIntent != null) {
                            pendingIntent.cancel();
                        }
                        this.c = null;
                    }
                    d0();
                    l1 l1Var = this.a;
                    if (l1Var != null) {
                        l1Var.u(this.b);
                    }
                    this.n = false;
                    this.o = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(int i2) {
        try {
            if (this.b != null) {
                synchronized (this.f) {
                    if (this.c != null) {
                        Intent intent = new Intent();
                        intent.putExtras(e(null, null, null, 4, i2));
                        this.c.send(this.b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* access modifiers changed from: package-private */
    public final void L(Bundle bundle) {
        GeoFence f2;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i2 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i2 = I((f2 = f(bundle, true)))) == 0) {
                    arrayList.add(f2);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i2);
            bundle2.putParcelableArrayList("resultList", arrayList);
            i(1000, bundle2);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    /* access modifiers changed from: package-private */
    public final void N() {
        try {
            if (this.s != null) {
                g0();
                this.v.setOnceLocation(true);
                this.s.setLocationOption(this.v);
                this.s.startLocation();
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O(Bundle bundle) {
        D(2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void Q() {
        try {
            if (!this.y && m1.q(this.t)) {
                float a2 = a(this.t, this.h);
                if (a2 != Float.MAX_VALUE) {
                    if (a2 < 1000.0f) {
                        C(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong(Constants.Name.INTERVAL, 2000);
                        j(8, bundle, 500);
                    } else if (a2 < 5000.0f) {
                        g0();
                        C(7);
                        j(7, null, 10000);
                    } else {
                        g0();
                        C(7);
                        j(7, null, (long) (((a2 - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    /* access modifiers changed from: package-private */
    public final void R(Bundle bundle) {
        D(1, bundle);
    }

    public final void S() {
        try {
            a0();
            this.y = true;
            j(13, null, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void T(Bundle bundle) {
        D(3, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void U() {
        try {
            C(7);
            C(8);
            AMapLocationClient aMapLocationClient = this.s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.n = false;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void V(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z2 = bundle.getBoolean(fw0.VALUE_MODEL_DEFAULT, true);
                        ArrayList<GeoFence> arrayList = this.h;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator<GeoFence> it = this.h.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                GeoFence next = it.next();
                                if (next.getFenceId().equals(string)) {
                                    next.setAble(z2);
                                    break;
                                }
                            }
                        }
                        if (z2) {
                            f0();
                        } else if (c0()) {
                            U();
                        }
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void W() {
        try {
            a0();
            if (this.y) {
                this.y = false;
                f0();
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void X(Bundle bundle) {
        try {
            if (this.h != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.h.contains(geoFence)) {
                    this.h.remove(geoFence);
                }
                if (this.h.size() <= 0) {
                    J();
                } else {
                    f0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void Y(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    int i2 = bundle.getInt("errorCode");
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                    if (parcelableArrayList == null) {
                        parcelableArrayList = new ArrayList();
                    }
                    String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    if (string == null) {
                        string = "";
                    }
                    GeoFenceListener geoFenceListener = this.e;
                    if (geoFenceListener != null) {
                        geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i2, string);
                    }
                    if (i2 == 0) {
                        f0();
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean Z() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public final void b0(Bundle bundle) {
        try {
            if (this.s != null) {
                long j2 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j2 = bundle.getLong(Constants.Name.INTERVAL, 2000);
                }
                this.v.setOnceLocation(false);
                this.v.setInterval(j2);
                this.s.setLocationOption(this.v);
                if (!this.n) {
                    this.s.stopLocation();
                    this.s.startLocation();
                    this.n = true;
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final PendingIntent d(String str) {
        synchronized (this.f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(l.g(this.b));
                this.c = (Build.VERSION.SDK_INT < 31 || this.b.getApplicationInfo().targetSdkVersion < 31) ? PendingIntent.getBroadcast(this.b, 0, intent, 0) : PendingIntent.getBroadcast(this.b, 0, intent, 33554432);
                this.d = str;
                ArrayList<GeoFence> arrayList = this.h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.c;
    }

    public final void g() {
        try {
            this.p = false;
            j(10, null, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void h(int i2) {
        try {
            a0();
            if (i2 > 7 || i2 <= 0) {
                i2 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i2);
            j(9, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "setActivateAction");
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(int i2, Bundle bundle) {
        try {
            synchronized (this.k) {
                d dVar = this.i;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.i.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(int i2, Bundle bundle, long j2) {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.l.sendMessageDelayed(obtainMessage, j2);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(Bundle bundle) {
        int i2 = 1;
        if (bundle != null) {
            try {
                i2 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.g != i2) {
            ArrayList<GeoFence> arrayList = this.h;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.h.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1);
                }
            }
            f0();
        }
        this.g = i2;
    }

    public final void l(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.y || (arrayList = this.h) == null) {
                return;
            }
            if (!arrayList.isEmpty()) {
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                    Iterator<GeoFence> it = this.h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        if (next.isAble() && G(aMapLocation, next) && w(next, this.g)) {
                            next.setCurrentLocation(aMapLocation);
                            P(next);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void n(DPoint dPoint, float f2, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(0, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void p(String str, String str2) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            j(4, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void q(String str, String str2, DPoint dPoint, float f2, int i2, String str3) {
        try {
            a0();
            if (f2 <= 0.0f || f2 > 50000.0f) {
                f2 = 3000.0f;
            }
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f2);
            bundle.putInt("searchSize", i2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            j(3, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void r(String str, String str2, String str3, int i2, String str4) {
        try {
            a0();
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            j(2, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void s(String str, boolean z2) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean(fw0.VALUE_MODEL_DEFAULT, z2);
            j(12, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void t(List<DPoint> list, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(1, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean v(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.h;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    if (!this.h.contains(geoFence)) {
                        return false;
                    }
                    if (this.h.size() == 1) {
                        this.p = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    j(11, bundle, 0);
                    return true;
                }
            }
            this.p = false;
            j(10, null, 0);
            return true;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }
}
