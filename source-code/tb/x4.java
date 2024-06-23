package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.pictures.piclocation.LocateQueueManager;
import com.alibaba.pictures.piclocation.LocationDataStatus;
import com.alibaba.pictures.piclocation.LocationErrorReporter;
import com.alibaba.pictures.piclocation.LocationInterface;
import com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.alibaba.pictures.piclocation.listener.LocateMapListener;
import com.alibaba.pictures.piclocation.listener.LocateRegionPicListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class x4 implements LocationInterface, GeocodeSearch.OnGeocodeSearchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean m = true;
    @Nullable
    private static x4 n;
    private final Context a;
    private LocateQueueManager b;
    private AMapLocationClient c;
    @Nullable
    private m81 d;
    private GeocodeSearch e;
    private LocationDataStatus f;
    private LocateMapListener g;
    private long h;
    private long i;
    private AMapLocation j;
    private final AMapLocationListener k;
    @Nullable
    private GetLocationInfoInterface l;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2134141015")) {
                return x4.m;
            }
            return ((Boolean) ipChange.ipc$dispatch("2134141015", new Object[]{this})).booleanValue();
        }

        @Nullable
        public final x4 b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1129794563")) {
                return x4.n;
            }
            return (x4) ipChange.ipc$dispatch("1129794563", new Object[]{this});
        }

        @NotNull
        public final synchronized x4 c(@Nullable Context context, @Nullable LocateQueueManager locateQueueManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1712532737")) {
                return (x4) ipChange.ipc$dispatch("1712532737", new Object[]{this, context, locateQueueManager});
            }
            if (b() == null) {
                d(new x4(context, null));
                x4 b = b();
                if (b != null) {
                    b.b = locateQueueManager;
                }
            }
            x4 b2 = b();
            k21.f(b2);
            return b2;
        }

        public final void d(@Nullable x4 x4Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-884450273")) {
                ipChange.ipc$dispatch("-884450273", new Object[]{this, x4Var});
                return;
            }
            x4.n = x4Var;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements AMapLocationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ x4 a;

        b(x4 x4Var) {
            this.a = x4Var;
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "480486944")) {
                ipChange.ipc$dispatch("480486944", new Object[]{this, aMapLocation});
                return;
            }
            if (x4.Companion.a() && aMapLocation != null) {
                if (aMapLocation.getErrorCode() != 0) {
                    Log.v("Locate_AmapImpl", "onLocationChanged:" + aMapLocation.getErrorCode() + "," + aMapLocation.getErrorInfo());
                } else {
                    Log.v("Locate_AmapImpl", "onLocationChanged:" + aMapLocation);
                }
            }
            if (aMapLocation != null) {
                if (this.a.g != null) {
                    this.a.m(aMapLocation);
                }
                if (aMapLocation.getErrorCode() == 0 && aMapLocation.getLatitude() != 0.0d && aMapLocation.getLongitude() != 0.0d) {
                    this.a.j = aMapLocation;
                    GetLocationInfoInterface o = this.a.o();
                    if (o != null) {
                        o.getLocationInfoSuccess(aMapLocation, System.currentTimeMillis());
                    }
                    LocateQueueManager locateQueueManager = this.a.b;
                    if (locateQueueManager != null) {
                        locateQueueManager.q(true);
                    }
                    if (!TextUtils.isEmpty(aMapLocation.getAddress())) {
                        m81 m81 = new m81(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                        m81.e = aMapLocation.getAddress();
                        m81.g = LocationDataStatus.NOCACHE;
                        m81.d = aMapLocation.getCity();
                        m81.c = aMapLocation.getCityCode();
                        this.a.r(m81);
                        LocateQueueManager locateQueueManager2 = this.a.b;
                        if (locateQueueManager2 != null) {
                            locateQueueManager2.o(m81);
                            return;
                        }
                        return;
                    }
                    this.a.f = LocationDataStatus.NOCACHE;
                    RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), 500.0f, GeocodeSearch.AMAP);
                    GeocodeSearch geocodeSearch = this.a.e;
                    if (geocodeSearch != null) {
                        geocodeSearch.getFromLocationAsyn(regeocodeQuery);
                    }
                } else if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    this.a.s(errorCode);
                    Log.e("Locate_AmapImpl", "errCode=" + errorCode);
                    if (errorCode == 12) {
                        LocateQueueManager locateQueueManager3 = this.a.b;
                        if (locateQueueManager3 != null) {
                            LocationDataStatus locationDataStatus = LocationDataStatus.NOPERMISSION;
                            locateQueueManager3.p(locationDataStatus.getCode(), locationDataStatus.getDes());
                        }
                    } else {
                        LocateQueueManager locateQueueManager4 = this.a.b;
                        if (locateQueueManager4 != null) {
                            LocationDataStatus locationDataStatus2 = LocationDataStatus.UNKNOW;
                            locateQueueManager4.p(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                        }
                    }
                    if (errorCode != 0) {
                        m81 m812 = new m81(-1.0d, -1.0d);
                        if (errorCode == 12) {
                            m812.g = LocationDataStatus.NOPERMISSION;
                            LocateQueueManager locateQueueManager5 = this.a.b;
                            if (locateQueueManager5 != null) {
                                locateQueueManager5.q(false);
                            }
                        } else {
                            LocateQueueManager locateQueueManager6 = this.a.b;
                            if (locateQueueManager6 != null) {
                                locateQueueManager6.q(true);
                            }
                        }
                        LocateQueueManager locateQueueManager7 = this.a.b;
                        if (locateQueueManager7 != null) {
                            locateQueueManager7.t(m812);
                        }
                    }
                }
            }
        }
    }

    private x4(Context context) {
        this.a = context;
        this.h = 300000;
        this.i = 300000;
        this.k = new b(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void m(AMapLocation aMapLocation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251847866")) {
            ipChange.ipc$dispatch("251847866", new Object[]{this, aMapLocation});
            return;
        }
        if (aMapLocation == null || aMapLocation.getErrorCode() != 0) {
            LocateMapListener locateMapListener = this.g;
            if (locateMapListener != null) {
                locateMapListener.onMapLocationFailed(aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
            }
        } else {
            LocateMapListener locateMapListener2 = this.g;
            if (locateMapListener2 != null) {
                locateMapListener2.onMapLocationSuccess(aMapLocation);
            }
        }
        this.g = null;
        n();
    }

    private final void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255520156")) {
            ipChange.ipc$dispatch("-255520156", new Object[]{this});
            return;
        }
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.unRegisterLocationListener(this.k);
            aMapLocationClient.onDestroy();
            this.c = null;
        }
        if (m) {
            Log.v("Locate_AmapImpl", "stop location server");
        }
    }

    private final void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7738412")) {
            ipChange.ipc$dispatch("7738412", new Object[]{this});
            return;
        }
        GeocodeSearch geocodeSearch = new GeocodeSearch(this.a);
        this.e = geocodeSearch;
        geocodeSearch.setOnGeocodeSearchListener(this);
    }

    private final void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933231432")) {
            ipChange.ipc$dispatch("-933231432", new Object[]{this});
            return;
        }
        AMapLocationClient aMapLocationClient = new AMapLocationClient(this.a);
        this.c = aMapLocationClient;
        aMapLocationClient.setLocationListener(this.k);
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setHttpTimeOut((long) 15000);
        aMapLocationClientOption.setOnceLocation(true);
        AMapLocationClient aMapLocationClient2 = this.c;
        if (aMapLocationClient2 != null) {
            aMapLocationClient2.setLocationOption(aMapLocationClientOption);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void r(m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602278741")) {
            ipChange.ipc$dispatch("602278741", new Object[]{this, m81});
            return;
        }
        if (m81 != null && getDangerousLocationPic() != null && TextUtils.isEmpty(m81.d) && TextUtils.isEmpty(m81.c)) {
            m81 dangerousLocationPic = getDangerousLocationPic();
            String str = null;
            String str2 = dangerousLocationPic != null ? dangerousLocationPic.c : null;
            m81 dangerousLocationPic2 = getDangerousLocationPic();
            if (dangerousLocationPic2 != null) {
                str = dangerousLocationPic2.d;
            }
            double d2 = m81.a;
            m81 dangerousLocationPic3 = getDangerousLocationPic();
            if (dangerousLocationPic3 != null && d2 == dangerousLocationPic3.a) {
                double d3 = m81.b;
                m81 dangerousLocationPic4 = getDangerousLocationPic();
                if (dangerousLocationPic4 != null && d3 == dangerousLocationPic4.b) {
                    t(m81);
                    m81 dangerousLocationPic5 = getDangerousLocationPic();
                    if (dangerousLocationPic5 != null) {
                        dangerousLocationPic5.c = str2;
                    }
                    m81 dangerousLocationPic6 = getDangerousLocationPic();
                    if (dangerousLocationPic6 != null) {
                        dangerousLocationPic6.d = str;
                        return;
                    }
                    return;
                }
            }
        }
        t(m81);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void s(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882727232")) {
            ipChange.ipc$dispatch("-1882727232", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        LocationErrorReporter b2 = o81.INSTANCE.b();
        if (b2 != null) {
            b2.reportGpsLocateFailed(i2);
        }
    }

    private final boolean x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897123476")) {
            return ((Boolean) ipChange.ipc$dispatch("-897123476", new Object[]{this})).booleanValue();
        }
        AMapLocation lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation == null || lastKnownLocation.getLatitude() == 0.0d || lastKnownLocation.getLongitude() == 0.0d || this.b == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LocateQueueManager locateQueueManager = this.b;
        k21.f(locateQueueManager);
        if (currentTimeMillis - locateQueueManager.m() > this.i) {
            this.j = null;
            this.i = this.h;
            return false;
        }
        this.i = this.h;
        if (!TextUtils.isEmpty(lastKnownLocation.getAddress())) {
            m81 m81 = new m81(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            m81.e = lastKnownLocation.getAddress();
            m81.g = LocationDataStatus.CACHE;
            r(m81);
            LocateQueueManager locateQueueManager2 = this.b;
            if (locateQueueManager2 != null) {
                locateQueueManager2.o(m81);
            }
        } else {
            this.f = LocationDataStatus.CACHE;
            RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), 500.0f, GeocodeSearch.AMAP);
            GeocodeSearch geocodeSearch = this.e;
            if (geocodeSearch != null) {
                geocodeSearch.getFromLocationAsyn(regeocodeQuery);
            }
        }
        return true;
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    @Nullable
    public m81 getDangerousLocationPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-301827962")) {
            return this.d;
        }
        return (m81) ipChange.ipc$dispatch("-301827962", new Object[]{this});
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    @Nullable
    public AMapLocation getLastKnownLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594746138")) {
            return (AMapLocation) ipChange.ipc$dispatch("594746138", new Object[]{this});
        }
        AMapLocation aMapLocation = this.j;
        if (aMapLocation != null) {
            return aMapLocation;
        }
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            if (aMapLocationClient != null) {
                return aMapLocationClient.getLastKnownLocation();
            }
            return null;
        } else if (getDangerousLocationPic() == null) {
            return null;
        } else {
            AMapLocation aMapLocation2 = new AMapLocation("");
            m81 dangerousLocationPic = getDangerousLocationPic();
            k21.f(dangerousLocationPic);
            aMapLocation2.setLatitude(dangerousLocationPic.a);
            m81 dangerousLocationPic2 = getDangerousLocationPic();
            k21.f(dangerousLocationPic2);
            aMapLocation2.setLongitude(dangerousLocationPic2.b);
            m81 dangerousLocationPic3 = getDangerousLocationPic();
            k21.f(dangerousLocationPic3);
            aMapLocation2.setAddress(dangerousLocationPic3.e);
            LocateQueueManager locateQueueManager = this.b;
            aMapLocation2.setTime(locateQueueManager != null ? locateQueueManager.m() : 0);
            return aMapLocation2;
        }
    }

    @Nullable
    public final GetLocationInfoInterface o() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1056619687")) {
            return this.l;
        }
        return (GetLocationInfoInterface) ipChange.ipc$dispatch("1056619687", new Object[]{this});
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onGeocodeSearched(@NotNull GeocodeResult geocodeResult, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146199598")) {
            ipChange.ipc$dispatch("1146199598", new Object[]{this, geocodeResult, Integer.valueOf(i2)});
            return;
        }
        k21.i(geocodeResult, "geocodeResult");
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onRegeocodeSearched(@NotNull RegeocodeResult regeocodeResult, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398816696")) {
            ipChange.ipc$dispatch("-398816696", new Object[]{this, regeocodeResult, Integer.valueOf(i2)});
            return;
        }
        k21.i(regeocodeResult, "regeocodeResult");
        RegeocodeQuery regeocodeQuery = regeocodeResult.getRegeocodeQuery();
        k21.h(regeocodeQuery, "regeocodeResult.regeocodeQuery");
        LatLonPoint point = regeocodeQuery.getPoint();
        k21.h(point, "regeocodeResult.regeocodeQuery.point");
        double latitude = point.getLatitude();
        RegeocodeQuery regeocodeQuery2 = regeocodeResult.getRegeocodeQuery();
        k21.h(regeocodeQuery2, "regeocodeResult.regeocodeQuery");
        LatLonPoint point2 = regeocodeQuery2.getPoint();
        k21.h(point2, "regeocodeResult.regeocodeQuery.point");
        m81 m81 = new m81(latitude, point2.getLongitude());
        RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
        k21.h(regeocodeAddress, "regeocodeResult.regeocodeAddress");
        m81.d = regeocodeAddress.getCity();
        RegeocodeAddress regeocodeAddress2 = regeocodeResult.getRegeocodeAddress();
        k21.h(regeocodeAddress2, "regeocodeResult.regeocodeAddress");
        m81.e = regeocodeAddress2.getFormatAddress();
        m81.g = this.f;
        r(m81);
        LocateQueueManager locateQueueManager = this.b;
        if (locateQueueManager != null) {
            locateQueueManager.o(m81);
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450683842")) {
            ipChange.ipc$dispatch("450683842", new Object[]{this, locateGpsPicListener});
            return;
        }
        startLocation(locateGpsPicListener, 15000);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024430396")) {
            ipChange.ipc$dispatch("-2024430396", new Object[]{this, locateRegionPicListener});
            return;
        }
        startLocationRegion(locateRegionPicListener, 15000);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithCacheTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086916329")) {
            ipChange.ipc$dispatch("-1086916329", new Object[]{this, locateGpsPicListener, Long.valueOf(j2)});
            return;
        }
        this.i = j2;
        startLocation(locateGpsPicListener, 15000);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithCacheTimeAndRequestTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584722392")) {
            ipChange.ipc$dispatch("-1584722392", new Object[]{this, locateGpsPicListener, Long.valueOf(j2), Long.valueOf(j3)});
            return;
        }
        this.i = j2;
        startLocation(locateGpsPicListener, j3);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithNoCache(@NotNull LocateMapListener locateMapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316717489")) {
            ipChange.ipc$dispatch("1316717489", new Object[]{this, locateMapListener});
            return;
        }
        k21.i(locateMapListener, "locateMapListener");
        if (this.a == null) {
            LocationDataStatus locationDataStatus = LocationDataStatus.NOTINIT;
            locateMapListener.onMapLocationFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
            return;
        }
        if (this.c == null) {
            try {
                q();
            } catch (Exception e2) {
                locateMapListener.onMapLocationFailed(LocationDataStatus.UNKNOW.getCode(), e2.getMessage());
            }
        }
        this.g = locateMapListener;
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            aMapLocationClient.startLocation();
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863136710")) {
            ipChange.ipc$dispatch("1863136710", new Object[]{this});
            return;
        }
        n();
    }

    public void t(@Nullable m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840908806")) {
            ipChange.ipc$dispatch("840908806", new Object[]{this, m81});
            return;
        }
        this.d = m81;
    }

    public final void u(@Nullable GetLocationInfoInterface getLocationInfoInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892596771")) {
            ipChange.ipc$dispatch("-1892596771", new Object[]{this, getLocationInfoInterface});
            return;
        }
        this.l = getLocationInfoInterface;
    }

    public final void v(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298431353")) {
            ipChange.ipc$dispatch("-298431353", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.h = j2;
    }

    public final void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105295442")) {
            ipChange.ipc$dispatch("-1105295442", new Object[]{this});
            return;
        }
        if (m) {
            Log.d("Locate_AmapImpl", "start location server");
        }
        if (!x()) {
            if (this.c == null) {
                q();
            }
            AMapLocationClient aMapLocationClient = this.c;
            if (aMapLocationClient != null) {
                aMapLocationClient.startLocation();
            }
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener, long j2) {
        LocateQueueManager locateQueueManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086327618")) {
            ipChange.ipc$dispatch("1086327618", new Object[]{this, locateGpsPicListener, Long.valueOf(j2)});
        } else if (this.a != null) {
            if (!dc.Companion.a(o81.INSTANCE.a())) {
                if (!(locateGpsPicListener == null || (locateQueueManager = this.b) == null)) {
                    locateQueueManager.h(locateGpsPicListener, j2);
                }
                if (this.e == null) {
                    try {
                        p();
                    } catch (AMapException unused) {
                        if (locateGpsPicListener != null) {
                            LocationDataStatus locationDataStatus = LocationDataStatus.NOTAGREEPRIVACY;
                            locateGpsPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
                            return;
                        }
                        return;
                    }
                }
                w();
            } else if (locateGpsPicListener != null) {
                LocationDataStatus locationDataStatus2 = LocationDataStatus.BLACKLIST;
                locateGpsPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
            }
        } else if (locateGpsPicListener != null) {
            LocationDataStatus locationDataStatus3 = LocationDataStatus.NOTINIT;
            locateGpsPicListener.onFailed(locationDataStatus3.getCode(), locationDataStatus3.getDes());
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667197568")) {
            ipChange.ipc$dispatch("1667197568", new Object[]{this, locateRegionPicListener, Long.valueOf(j2)});
        } else if (this.a == null) {
            if (locateRegionPicListener != null) {
                LocationDataStatus locationDataStatus = LocationDataStatus.NOTINIT;
                locateRegionPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
            }
        } else if (locateRegionPicListener != null) {
            if (dc.Companion.a(o81.INSTANCE.a())) {
                LocationDataStatus locationDataStatus2 = LocationDataStatus.BLACKLIST;
                locateRegionPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                return;
            }
            LocateQueueManager locateQueueManager = this.b;
            if (locateQueueManager != null) {
                locateQueueManager.i(locateRegionPicListener, j2);
            }
            w();
        }
    }

    public /* synthetic */ x4(Context context, m40 m40) {
        this(context);
    }
}
