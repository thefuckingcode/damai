package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
public final class ke {
    public static Inner_3dMap_location a;
    jr b = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.ke$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.values().length];
            a = iArr;
            iArr[Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving.ordinal()] = 1;
            a[Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors.ordinal()] = 2;
            try {
                a[Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static AMapLocationClientOption a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setInterval(inner_3dMap_locationOption.getInterval());
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        int i = AnonymousClass1.a[inner_3dMap_locationOption.getLocationMode().ordinal()];
        if (i == 1) {
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
        } else if (i == 2) {
            aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
        }
        aMapLocationClientOption.setLocationMode(aMapLocationMode);
        aMapLocationClientOption.setOnceLocation(inner_3dMap_locationOption.isOnceLocation());
        aMapLocationClientOption.setNeedAddress(inner_3dMap_locationOption.isNeedAddress());
        aMapLocationClientOption.setLocationCacheEnable(inner_3dMap_locationOption.isLocationCacheEnable());
        return aMapLocationClientOption;
    }

    public static Inner_3dMap_location a(AMapLocation aMapLocation) {
        Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
        if (aMapLocation != null) {
            try {
                inner_3dMap_location.setLatitude(aMapLocation.getLatitude());
                inner_3dMap_location.setLongitude(aMapLocation.getLongitude());
                inner_3dMap_location.setAccuracy(aMapLocation.getAccuracy());
                inner_3dMap_location.setBearing(aMapLocation.getBearing());
                inner_3dMap_location.setAltitude(aMapLocation.getAltitude());
                inner_3dMap_location.setProvider(aMapLocation.getProvider());
                inner_3dMap_location.setSpeed(aMapLocation.getSpeed());
                inner_3dMap_location.setTime(aMapLocation.getTime());
                inner_3dMap_location.setErrorCode(aMapLocation.getErrorCode());
                inner_3dMap_location.setErrorInfo(aMapLocation.getErrorInfo());
                inner_3dMap_location.setLocationType(aMapLocation.getLocationType());
                inner_3dMap_location.setLocationDetail(aMapLocation.getLocationDetail());
                inner_3dMap_location.setProvince(aMapLocation.getProvince());
                inner_3dMap_location.setCity(aMapLocation.getCity());
                inner_3dMap_location.setCityCode(aMapLocation.getCityCode());
                inner_3dMap_location.setCountry(aMapLocation.getCountry());
                inner_3dMap_location.setDistrict(aMapLocation.getDistrict());
                inner_3dMap_location.setAddress(aMapLocation.getAddress());
                inner_3dMap_location.setAdCode(aMapLocation.getAdCode());
                inner_3dMap_location.setExtras(aMapLocation.getExtras());
                inner_3dMap_location.setRoad(aMapLocation.getRoad());
            } catch (Throwable th) {
                jy.a(th, "Util", "converterLocation");
            }
        }
        return inner_3dMap_location;
    }

    public static void a(Object obj, Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (obj != null) {
            ((AMapLocationClient) obj).setLocationOption(a(inner_3dMap_locationOption));
        }
    }

    public final void a(Object obj, Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (this.b == null) {
            this.b = new jr();
        }
        this.b.a(inner_3dMap_locationListener);
        ((AMapLocationClient) obj).setLocationListener(this.b);
    }
}
