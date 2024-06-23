package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.loc.j1;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        /* class com.amap.api.location.AMapLocationClientOption.AnonymousClass1 */

        private static AMapLocationClientOption a(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        private static AMapLocationClientOption[] a(int i) {
            return new AMapLocationClientOption[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int i) {
            return a(i);
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;
    static String a = "";
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static int g = 4;
    private static AMapLocationProtocol p = AMapLocationProtocol.HTTP;
    private boolean A;
    private int B;
    private int C;
    private float D;
    private AMapLocationPurpose E;
    boolean b;
    String c;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private AMapLocationMode o;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private long x;
    private long y;
    private GeoLanguage z;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            a = iArr;
            iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            a[AMapLocationPurpose.Transport.ordinal()] = 2;
            try {
                a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* compiled from: Taobao */
    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int a;

        private AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    /* compiled from: Taobao */
    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.h = 2000;
        this.i = (long) j1.i;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        this.z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = 0.0f;
        this.E = null;
        this.b = false;
        this.c = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.h = 2000;
        this.i = (long) j1.i;
        boolean z2 = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.o = aMapLocationMode;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.z = geoLanguage;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.E = null;
        this.b = false;
        this.c = null;
        this.h = parcel.readLong();
        this.i = parcel.readLong();
        this.j = parcel.readByte() != 0;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.o = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.q = parcel.readByte() != 0;
        this.r = parcel.readByte() != 0;
        this.s = parcel.readByte() != 0;
        this.t = parcel.readByte() != 0;
        this.u = parcel.readByte() != 0;
        this.v = parcel.readByte() != 0;
        this.w = parcel.readByte() != 0;
        this.x = parcel.readLong();
        int readInt2 = parcel.readInt();
        p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.z = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.D = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.E = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : aMapLocationPurpose;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0 ? true : z2;
        this.y = parcel.readLong();
    }

    private AMapLocationClientOption a(AMapLocationClientOption aMapLocationClientOption) {
        this.h = aMapLocationClientOption.h;
        this.j = aMapLocationClientOption.j;
        this.o = aMapLocationClientOption.o;
        this.k = aMapLocationClientOption.k;
        this.q = aMapLocationClientOption.q;
        this.r = aMapLocationClientOption.r;
        this.l = aMapLocationClientOption.l;
        this.m = aMapLocationClientOption.m;
        this.i = aMapLocationClientOption.i;
        this.s = aMapLocationClientOption.s;
        this.t = aMapLocationClientOption.t;
        this.u = aMapLocationClientOption.u;
        this.v = aMapLocationClientOption.isSensorEnable();
        this.w = aMapLocationClientOption.isWifiScan();
        this.x = aMapLocationClientOption.x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.z = aMapLocationClientOption.z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.D = aMapLocationClientOption.D;
        this.E = aMapLocationClientOption.E;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.y = aMapLocationClientOption.y;
        this.C = aMapLocationClientOption.getCacheTimeOut();
        this.A = aMapLocationClientOption.getCacheCallBack();
        this.B = aMapLocationClientOption.getCacheCallBackTime();
        return this;
    }

    public static String getAPIKEY() {
        return a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z2) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z2) {
        OPEN_ALWAYS_SCAN_WIFI = z2;
    }

    public static void setScanWifiInterval(long j2) {
        SCAN_WIFI_INTERVAL = j2;
    }

    @Override // java.lang.Object
    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().a(this);
    }

    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.D;
    }

    public GeoLanguage getGeoLanguage() {
        return this.z;
    }

    public long getGpsFirstTimeout() {
        return this.y;
    }

    public long getHttpTimeOut() {
        return this.i;
    }

    public long getInterval() {
        return this.h;
    }

    public long getLastLocationLifeCycle() {
        return this.x;
    }

    public AMapLocationMode getLocationMode() {
        return this.o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.E;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isGpsFirst() {
        return this.r;
    }

    public boolean isKillProcess() {
        return this.q;
    }

    public boolean isLocationCacheEnable() {
        return this.t;
    }

    public boolean isMockEnable() {
        return this.k;
    }

    public boolean isNeedAddress() {
        return this.l;
    }

    public boolean isOffset() {
        return this.s;
    }

    public boolean isOnceLocation() {
        return this.j;
    }

    public boolean isOnceLocationLatest() {
        return this.u;
    }

    public boolean isSensorEnable() {
        return this.v;
    }

    public boolean isWifiActiveScan() {
        return this.m;
    }

    public boolean isWifiScan() {
        return this.w;
    }

    public void setCacheCallBack(boolean z2) {
        this.A = z2;
    }

    public void setCacheCallBackTime(int i2) {
        this.B = i2;
    }

    public void setCacheTimeOut(int i2) {
        this.C = i2;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.D = f2;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z2) {
        this.r = z2;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j2) {
        if (j2 < DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            j2 = 5000;
        }
        if (j2 > 30000) {
            j2 = 30000;
        }
        this.y = j2;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j2) {
        this.i = j2;
        return this;
    }

    public AMapLocationClientOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.h = j2;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z2) {
        this.q = z2;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j2) {
        this.x = j2;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z2) {
        this.t = z2;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        String str;
        this.E = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i2 = AnonymousClass2.a[aMapLocationPurpose.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = d;
                    int i4 = f;
                    if ((i3 & i4) == 0) {
                        this.b = true;
                        d = i3 | i4;
                        str = NotificationCompat.CATEGORY_TRANSPORT;
                    }
                    this.o = AMapLocationMode.Hight_Accuracy;
                    this.j = false;
                    this.u = false;
                    this.r = true;
                    this.k = false;
                    this.w = true;
                } else if (i2 == 3) {
                    int i5 = d;
                    int i6 = g;
                    if ((i5 & i6) == 0) {
                        this.b = true;
                        d = i5 | i6;
                        str = "sport";
                    }
                    this.o = AMapLocationMode.Hight_Accuracy;
                    this.j = false;
                    this.u = false;
                    this.r = true;
                    this.k = false;
                    this.w = true;
                }
                this.c = str;
                this.o = AMapLocationMode.Hight_Accuracy;
                this.j = false;
                this.u = false;
                this.r = true;
                this.k = false;
                this.w = true;
            } else {
                this.o = AMapLocationMode.Hight_Accuracy;
                this.j = true;
                this.u = true;
                this.r = false;
                this.k = false;
                this.w = true;
                int i7 = d;
                int i8 = e;
                if ((i7 & i8) == 0) {
                    this.b = true;
                    d = i7 | i8;
                    this.c = "signin";
                }
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z2) {
        this.k = z2;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z2) {
        this.l = z2;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z2) {
        this.s = z2;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z2) {
        this.j = z2;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z2) {
        this.u = z2;
        return this;
    }

    public AMapLocationClientOption setSensorEnable(boolean z2) {
        this.v = z2;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z2) {
        this.m = z2;
        this.n = z2;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z2) {
        this.w = z2;
        this.m = z2 ? this.n : false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.h) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isOnceLocation:" + String.valueOf(this.j) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "locationMode:" + String.valueOf(this.o) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "locationProtocol:" + String.valueOf(p) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isMockEnable:" + String.valueOf(this.k) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isKillProcess:" + String.valueOf(this.q) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isGpsFirst:" + String.valueOf(this.r) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isNeedAddress:" + String.valueOf(this.l) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isWifiActiveScan:" + String.valueOf(this.m) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "wifiScan:" + String.valueOf(this.w) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "httpTimeOut:" + String.valueOf(this.i) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isLocationCacheEnable:" + String.valueOf(this.t) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isOnceLocationLatest:" + String.valueOf(this.u) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "sensorEnable:" + String.valueOf(this.v) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "geoLanguage:" + String.valueOf(this.z) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "locationPurpose:" + String.valueOf(this.E) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "callback:" + String.valueOf(this.A) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "time:" + String.valueOf(this.B) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeByte(this.j ? (byte) 1 : 0);
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        AMapLocationMode aMapLocationMode = this.o;
        int i3 = -1;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeByte(this.r ? (byte) 1 : 0);
        parcel.writeByte(this.s ? (byte) 1 : 0);
        parcel.writeByte(this.t ? (byte) 1 : 0);
        parcel.writeByte(this.u ? (byte) 1 : 0);
        parcel.writeByte(this.v ? (byte) 1 : 0);
        parcel.writeByte(this.w ? (byte) 1 : 0);
        parcel.writeLong(this.x);
        parcel.writeInt(p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.D);
        AMapLocationPurpose aMapLocationPurpose = this.E;
        if (aMapLocationPurpose != null) {
            i3 = aMapLocationPurpose.ordinal();
        }
        parcel.writeInt(i3);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.y);
    }
}
