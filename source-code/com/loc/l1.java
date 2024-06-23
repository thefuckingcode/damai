package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.x53;

/* compiled from: Taobao */
public final class l1 {
    private static List<d0> g = new ArrayList();
    private static JSONArray h = null;
    static AMapLocation i = null;
    static boolean j = false;
    public SparseArray<Long> a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static String a(int i2) {
        if (i2 == 2011) {
            return "ContextIsNull";
        }
        if (i2 == 2031) {
            return "CreateApsReqException";
        }
        if (i2 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i2 == 2081) {
            return "LocalLocException";
        }
        if (i2 == 2091) {
            return "InitException";
        }
        if (i2 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i2 == 2121) {
            return "NotLocPermission";
        }
        if (i2 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i2 == 2021) {
            return "OnlyMainWifi";
        }
        if (i2 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i2 == 2061) {
            return "ServerRetypeError";
        }
        if (i2 == 2062) {
            return "ServerLocFail";
        }
        switch (i2) {
            case 2051:
                return "NeedLoginNetWork\t";
            case 2052:
                return "MaybeIntercepted";
            case 2053:
                return "DecryptResponseException";
            case 2054:
                return "ParserDataException";
            default:
                switch (i2) {
                    case 2101:
                        return "BindAPSServiceException";
                    case 2102:
                        return "AuthClientScodeFail";
                    case 2103:
                        return "NotConfigAPSService";
                    default:
                        switch (i2) {
                            case 2131:
                                return "NoCgiOAndWifiInfo";
                            case 2132:
                                return "AirPlaneModeAndWifiOff";
                            case 2133:
                                return "NoCgiAndWifiOff";
                            default:
                                switch (i2) {
                                    case 2151:
                                        return "MaybeMockNetLoc";
                                    case 2152:
                                        return "MaybeMockGPSLoc";
                                    case 2153:
                                        return "UNSUPPORT_COARSE_LBSLOC";
                                    case 2154:
                                        return "UNSUPPORT_CONTINUE_LOC";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public static void b(long j2, long j3) {
        try {
            if (!j) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("gpsTime:");
                stringBuffer.append(m1.j(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                stringBuffer.append("sysTime:");
                stringBuffer.append(m1.j(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                long J = i1.J();
                String str = "0";
                int i2 = (0 > J ? 1 : (0 == J ? 0 : -1));
                if (i2 != 0) {
                    str = m1.j(J, "yyyy-MM-dd HH:mm:ss.SSS");
                }
                stringBuffer.append("serverTime:");
                stringBuffer.append(str);
                q("checkgpstime", stringBuffer.toString());
                if (i2 != 0 && Math.abs(j2 - J) < 31536000000L) {
                    stringBuffer.append(", correctError");
                    q("checkgpstimeerror", stringBuffer.toString());
                }
                stringBuffer.delete(0, stringBuffer.length());
                j = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(Context context) {
        synchronized (l1.class) {
            if (context != null) {
                try {
                    if (i1.e()) {
                        List<d0> list = g;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(g);
                            bs.h(arrayList, context);
                            g.clear();
                        }
                        z(context);
                    }
                } catch (Throwable th) {
                    j1.h(th, "ReportUtil", Constants.Event.SLOT_LIFECYCLE.DESTORY);
                }
            }
        }
    }

    public static void e(Context context, int i2, int i3, long j2, long j3) {
        if (i2 != -1 && i3 != -1) {
            try {
                k(context, "O012", i2, i3, j2, j3);
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static void f(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (i1.e()) {
                    g(context, j2, z, "O015");
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void g(Context context, long j2, boolean z, String str) {
        l(context, str, !z ? "abroad" : "domestic", Long.valueOf(j2).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0034  */
    public static synchronized void h(Context context, AMapLocation aMapLocation) {
        int i2;
        synchronized (l1.class) {
            try {
                if (m1.q(aMapLocation)) {
                    int locationType = aMapLocation.getLocationType();
                    boolean z = false;
                    if (locationType == 1) {
                        i2 = 0;
                    } else if (locationType == 2 || locationType == 4) {
                        i2 = 1;
                    } else if (locationType == 11) {
                        i2 = 4;
                    } else if (locationType == 8) {
                        i2 = 3;
                    } else if (locationType != 9) {
                        i2 = 0;
                        if (z) {
                            int l = i1.l();
                            if (l != 0) {
                                if (i2 == 0 || i2 == 4) {
                                    if (l == 2) {
                                        return;
                                    }
                                } else if (l == 1) {
                                    return;
                                }
                            }
                            if (h == null) {
                                h = new JSONArray();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("lon", m1.z(aMapLocation.getLongitude()));
                            jSONObject.put("lat", m1.z(aMapLocation.getLatitude()));
                            jSONObject.put("type", i2);
                            jSONObject.put("timestamp", m1.g());
                            if (aMapLocation.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84)) {
                                jSONObject.put("coordType", 1);
                            } else {
                                jSONObject.put("coordType", 2);
                            }
                            if (i2 == 0) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("accuracy", m1.I((double) aMapLocation.getAccuracy()));
                                jSONObject2.put("altitude", m1.I(aMapLocation.getAltitude()));
                                jSONObject2.put("bearing", m1.I((double) aMapLocation.getBearing()));
                                jSONObject2.put("speed", m1.I((double) aMapLocation.getSpeed()));
                                jSONObject.put("extension", jSONObject2);
                            }
                            JSONArray put = h.put(jSONObject);
                            h = put;
                            if (put.length() >= i1.i()) {
                                z(context);
                            }
                        }
                    } else {
                        i2 = 2;
                    }
                    z = true;
                    if (z) {
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "recordOfflineLocLog");
            }
        }
    }

    public static void i(Context context, AMapLocation aMapLocation, ei eiVar) {
        int i2;
        if (aMapLocation != null) {
            try {
                if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                    return;
                }
                if (aMapLocation.getLocationType() != 1) {
                    String str = "domestic";
                    if (t(aMapLocation)) {
                        str = "abroad";
                    }
                    String str2 = "cache";
                    if (aMapLocation.getErrorCode() != 0) {
                        int errorCode = aMapLocation.getErrorCode();
                        if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                            str2 = "net";
                        }
                        i2 = 0;
                    } else {
                        int locationType = aMapLocation.getLocationType();
                        if (locationType == 5 || locationType == 6) {
                            str2 = "net";
                        }
                        i2 = 1;
                    }
                    m(context, "O016", str2, str, i2, aMapLocation.getErrorCode(), eiVar);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportBatting");
            }
        }
    }

    private static void k(Context context, String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void l(Context context, String str, String str2, int i2) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void m(Context context, String str, String str2, String str3, int i2, int i3, ei eiVar) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (eiVar != null) {
                        if (!TextUtils.isEmpty(eiVar.d())) {
                            jSONObject.put(BaseMonitor.COUNT_POINT_DNS, eiVar.d());
                        }
                        if (!TextUtils.isEmpty(eiVar.e())) {
                            jSONObject.put("domain", eiVar.e());
                        }
                        if (!TextUtils.isEmpty(eiVar.f())) {
                            jSONObject.put("type", eiVar.f());
                        }
                        if (!TextUtils.isEmpty(eiVar.g())) {
                            jSONObject.put("reason", eiVar.g());
                        }
                        if (!TextUtils.isEmpty(eiVar.c())) {
                            jSONObject.put(TbAuthConstants.IP, eiVar.c());
                        }
                        if (!TextUtils.isEmpty(eiVar.b())) {
                            jSONObject.put("stack", eiVar.b());
                        }
                        if (eiVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(eiVar.h()));
                        }
                        if (eiVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(eiVar.a()));
                        }
                    }
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void n(Context context, String str, JSONObject jSONObject) {
        synchronized (l1.class) {
            if (context != null) {
                try {
                    if (i1.e()) {
                        d0 d0Var = new d0(context, "loc", "6.1.0", str);
                        if (jSONObject != null) {
                            d0Var.a(jSONObject.toString());
                        }
                        g.add(d0Var);
                        if (g.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(g);
                            bs.h(arrayList, context);
                            g.clear();
                        }
                    }
                } catch (Throwable th) {
                    j1.h(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static void o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (i == null) {
                if (!m1.q(aMapLocation)) {
                    i = aMapLocation2;
                    return;
                }
                i = aMapLocation.clone();
            }
            if (m1.q(i) && m1.q(aMapLocation2)) {
                AMapLocation clone = aMapLocation2.clone();
                if (!(i.getLocationType() == 1 || i.getLocationType() == 9 || GeocodeSearch.GPS.equalsIgnoreCase(i.getProvider()) || i.getLocationType() == 7 || clone.getLocationType() == 1 || clone.getLocationType() == 9 || GeocodeSearch.GPS.equalsIgnoreCase(clone.getProvider()) || clone.getLocationType() == 7)) {
                    long abs = Math.abs(clone.getTime() - i.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float c2 = m1.c(i, clone);
                        float f2 = c2 / ((float) abs);
                        if (c2 > 30000.0f && f2 > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(i.getLatitude());
                            sb.append(",");
                            sb.append(i.getLongitude());
                            sb.append(",");
                            sb.append(i.getAccuracy());
                            sb.append(",");
                            sb.append(i.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(m1.j(i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(i.getTime());
                            }
                            sb.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(clone.getLatitude());
                            sb.append(",");
                            sb.append(clone.getLongitude());
                            sb.append(",");
                            sb.append(clone.getAccuracy());
                            sb.append(",");
                            sb.append(clone.getLocationType());
                            sb.append(",");
                            if (clone.getTime() != 0) {
                                sb.append(m1.j(clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(clone.getTime());
                            }
                            q("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                i = clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void p(String str, int i2) {
        r(str, String.valueOf(i2), a(i2));
    }

    public static void q(String str, String str2) {
        try {
            an.l(j1.q(), str2, str);
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "reportLog");
        }
    }

    public static void r(String str, String str2, String str3) {
        try {
            an.i(j1.q(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void s(String str, Throwable th) {
        try {
            if (th instanceof k) {
                an.h(j1.q(), str, (k) th);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean t(AMapLocation aMapLocation) {
        return m1.q(aMapLocation) ? !j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(j1.c);
    }

    public static void v(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (i1.e()) {
                    g(context, j2, z, "O024");
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void z(Context context) {
        try {
            JSONArray jSONArray = h;
            if (jSONArray != null && jSONArray.length() > 0) {
                bq.d(new c0(context, j1.q(), h.toString()), context);
                h = null;
            }
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void d(Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 != i2) {
                if (!(i3 == -1 || i3 == i2)) {
                    this.a.append(this.b, Long.valueOf((m1.B() - this.c) + this.a.get(this.b, 0L).longValue()));
                }
                this.c = m1.B() - x53.b(context, "pref1", this.d[i2], 0);
                this.b = i2;
            }
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "setLocationType");
        }
    }

    public final void j(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i2 = a.a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i3 = 3;
            if (i2 == 1) {
                i3 = 4;
            } else if (i2 == 2) {
                i3 = 5;
            } else if (i2 != 3) {
                i3 = -1;
            }
            int i4 = this.e;
            if (i4 != i3) {
                if (!(i4 == -1 || i4 == i3)) {
                    this.a.append(this.e, Long.valueOf((m1.B() - this.f) + this.a.get(this.e, 0L).longValue()));
                }
                this.f = m1.B() - x53.b(context, "pref1", this.d[i3], 0);
                this.e = i3;
            }
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void u(Context context) {
        try {
            long B = m1.B() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.a.append(this.b, Long.valueOf(B + this.a.get(i2, 0L).longValue()));
            }
            long B2 = m1.B() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.a.append(this.e, Long.valueOf(B2 + this.a.get(i3, 0L).longValue()));
            }
            SharedPreferences.Editor c2 = x53.c(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long longValue = this.a.get(i4, 0L).longValue();
                if (longValue > 0 && longValue > x53.b(context, "pref1", this.d[i4], 0)) {
                    x53.i(c2, this.d[i4], longValue);
                }
            }
            x53.f(c2);
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int w(Context context) {
        try {
            long b2 = x53.b(context, "pref1", this.d[2], 0);
            long b3 = x53.b(context, "pref1", this.d[0], 0);
            long b4 = x53.b(context, "pref1", this.d[1], 0);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            long j2 = b3 - b2;
            long j3 = b4 - b2;
            return b2 > j2 ? b2 > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int x(Context context) {
        try {
            long b2 = x53.b(context, "pref1", this.d[3], 0);
            long b3 = x53.b(context, "pref1", this.d[4], 0);
            long b4 = x53.b(context, "pref1", this.d[5], 0);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            return b2 > b3 ? b2 > b4 ? 3 : 5 : b3 > b4 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void y(Context context) {
        try {
            SharedPreferences.Editor c2 = x53.c(context, "pref1");
            int i2 = 0;
            while (true) {
                String[] strArr = this.d;
                if (i2 < strArr.length) {
                    x53.i(c2, strArr[i2], 0);
                    i2++;
                } else {
                    x53.f(c2);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
