package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.ai;
import com.amap.api.mapcore.util.ej;
import com.amap.api.mapcore.util.eo;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: Taobao */
public class CoordinateConverter {
    private Context a;
    private CoordType b = null;
    private LatLng c = null;

    /* renamed from: com.amap.api.maps.CoordinateConverter$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[CoordType.values().length];
            a = iArr;
            iArr[CoordType.BAIDU.ordinal()] = 1;
            a[CoordType.MAPBAR.ordinal()] = 2;
            a[CoordType.MAPABC.ordinal()] = 3;
            a[CoordType.SOSOMAP.ordinal()] = 4;
            a[CoordType.ALIYUN.ordinal()] = 5;
            a[CoordType.GOOGLE.ordinal()] = 6;
            try {
                a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.a = context;
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return ej.a(d, d2);
    }

    public LatLng convert() {
        CoordType coordType = this.b;
        LatLng latLng = null;
        if (coordType == null || this.c == null) {
            return null;
        }
        String str = "";
        try {
            switch (AnonymousClass1.a[coordType.ordinal()]) {
                case 1:
                    latLng = ai.a(this.c);
                    str = "baidu";
                    break;
                case 2:
                    latLng = ai.b(this.a, this.c);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.c;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.c;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.c;
                    break;
                case 6:
                    str = "google";
                    latLng = this.c;
                    break;
                case 7:
                    str = GeocodeSearch.GPS;
                    latLng = ai.a(this.a, this.c);
                    break;
            }
            eo.a(this.a, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            hd.c(th, "CoordinateConverter", "convert");
            return this.c;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
