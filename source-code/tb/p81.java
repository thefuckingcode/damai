package tb;

import android.content.Context;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class p81 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long LOCATION_CACHE_TIME = 300000;

    /* compiled from: Taobao */
    public class a implements LocateGpsPicListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onFailed(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1055135300")) {
                ipChange.ipc$dispatch("1055135300", new Object[]{this, Integer.valueOf(i), str});
            }
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onLocationSuccess(m81 m81) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-87818105")) {
                ipChange.ipc$dispatch("-87818105", new Object[]{this, m81});
            }
        }
    }

    public p81(Context context) {
    }

    private static double[] a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285199776")) {
            return (double[]) ipChange.ipc$dispatch("-1285199776", new Object[0]);
        }
        try {
            AMapLocation lastKnownLocation = o81.INSTANCE.c().getLastKnownLocation();
            if (lastKnownLocation == null) {
                g91.b("LocationUtil", "getLastKnownLocation(), location is null");
                return null;
            }
            if (System.currentTimeMillis() - lastKnownLocation.getTime() > 300000) {
                c();
            }
            double longitude = lastKnownLocation.getLongitude();
            double latitude = lastKnownLocation.getLatitude();
            double[] dArr = {longitude, latitude};
            g91.b("LocationUtil", "getLastKnownLocation(), location lng = " + longitude + ", lat = " + latitude);
            return dArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static double[] b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113474306")) {
            return (double[]) ipChange.ipc$dispatch("2113474306", new Object[0]);
        }
        double[] a2 = a();
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443940602")) {
            ipChange.ipc$dispatch("1443940602", new Object[0]);
            return;
        }
        g91.b("LocationUtil", "requestSingleUpdates()");
        try {
            if (hp1.g("android.permission.ACCESS_COARSE_LOCATION") || hp1.g("android.permission.ACCESS_FINE_LOCATION")) {
                d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620666587")) {
            ipChange.ipc$dispatch("-620666587", new Object[0]);
        } else {
            o81.INSTANCE.c().startLocationWithCacheTime(new a(), 0);
        }
    }
}
