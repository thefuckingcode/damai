package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.playerservice.axp.utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class lb {
    private static boolean v;
    int a = 0;
    ArrayList<la> b = new ArrayList<>();
    ArrayList<ks> c = new ArrayList<>();
    TelephonyManager d = null;
    long e = 0;
    CellLocation f;
    boolean g = false;
    PhoneStateListener h = null;
    String i = null;
    boolean j = false;
    StringBuilder k = null;
    private Context l;
    private String m = null;
    private ArrayList<la> n = new ArrayList<>();
    private int o = -113;
    private kz p = null;
    private Object q;
    private int r = 0;
    private long s = 0;
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback t;
    private boolean u = false;
    private ky w;
    private boolean x = false;
    private Object y = new Object();

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    /* compiled from: Taobao */
    public class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            lb.this.u = true;
            CellLocation a2 = lb.this.a((lb) list);
            if (a2 != null) {
                lb lbVar = lb.this;
                lbVar.f = a2;
                lbVar.g = true;
                lbVar.r();
                lb.this.s = kc.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (lb.this.w != null) {
                    lb.this.w.a();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onCellLocationChanged(CellLocation cellLocation) {
            try {
                if (lb.this.a(cellLocation)) {
                    lb lbVar = lb.this;
                    lbVar.f = cellLocation;
                    lbVar.g = true;
                    lbVar.r();
                    lb.this.s = kc.b();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    lb.this.b();
                } else if (state == 1) {
                    lb.this.i();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onSignalStrengthChanged(int i) {
            int i2 = -113;
            try {
                int i3 = lb.this.a;
                if (i3 == 1 || i3 == 2) {
                    i2 = kc.a(i);
                }
                lb.this.b((lb) i2);
            } catch (Throwable unused) {
            }
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                int i = -113;
                try {
                    int i2 = lb.this.a;
                    if (i2 == 1) {
                        i = kc.a(signalStrength.getGsmSignalStrength());
                    } else if (i2 == 2) {
                        i = signalStrength.getCdmaDbm();
                    }
                    lb.this.b((lb) i);
                    if (lb.this.w != null) {
                        lb.this.w.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public lb(Context context) {
        this.l = context;
        this.d = (TelephonyManager) kc.a(context, "phone");
        k();
        this.p = new kz();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = ka.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.telephony.cdma.CdmaCellLocation] */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
        if (r0 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
        return r0;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @SuppressLint({"NewApi"})
    private synchronized CellLocation a(List<CellInfo> list) {
        GsmCellLocation gsmCellLocation;
        ?? r11;
        GsmCellLocation gsmCellLocation2 = null;
        if (list != null) {
            if (!list.isEmpty()) {
                la laVar = null;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    CellInfo cellInfo = list.get(i2);
                    if (cellInfo != null) {
                        try {
                            laVar = a(cellInfo);
                            if (laVar != null) {
                                break;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
                if (laVar != null) {
                    try {
                        if (laVar.k == 2) {
                            r11 = new CdmaCellLocation();
                            try {
                                r11.setCellLocationData(laVar.i, laVar.e, laVar.f, laVar.g, laVar.h);
                            } catch (Throwable unused2) {
                            }
                            gsmCellLocation2 = r11;
                            gsmCellLocation = gsmCellLocation2;
                        } else {
                            gsmCellLocation = new GsmCellLocation();
                            try {
                                gsmCellLocation.setLacAndCid(laVar.c, laVar.d);
                            } catch (Throwable unused3) {
                                gsmCellLocation2 = gsmCellLocation;
                                r11 = 0;
                            }
                        }
                    } catch (Throwable unused4) {
                        r11 = 0;
                    }
                } else {
                    gsmCellLocation = null;
                }
            }
        }
        return null;
    }

    private static la a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        la laVar = new la(i2, z);
        laVar.a = i3;
        laVar.b = i4;
        laVar.c = i5;
        laVar.d = i6;
        laVar.j = i7;
        return laVar;
    }

    private la a(CellInfo cellInfo) {
        boolean isRegistered = cellInfo.isRegistered();
        if (cellInfo instanceof CellInfoCdma) {
            return a((CellInfoCdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoGsm) {
            return a((CellInfoGsm) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return a((CellInfoWcdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoLte) {
            return a((CellInfoLte) cellInfo, isRegistered);
        }
        return null;
    }

    private la a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        if (!(cellInfoCdma == null || cellInfoCdma.getCellIdentity() == null)) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a2 = kc.a(this.d);
                try {
                    i4 = Integer.parseInt(a2[0]);
                    try {
                        i2 = Integer.parseInt(a2[1]);
                        i3 = i4;
                    } catch (Throwable unused) {
                        i3 = i4;
                        i2 = 0;
                        la a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a3.g = cellIdentity2.getSystemId();
                        a3.h = cellIdentity2.getNetworkId();
                        a3.i = cellIdentity2.getBasestationId();
                        a3.e = cellIdentity2.getLatitude();
                        a3.f = cellIdentity2.getLongitude();
                        return a3;
                    }
                } catch (Throwable unused2) {
                    i4 = 0;
                    i3 = i4;
                    i2 = 0;
                    la a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    a32.g = cellIdentity2.getSystemId();
                    a32.h = cellIdentity2.getNetworkId();
                    a32.i = cellIdentity2.getBasestationId();
                    a32.e = cellIdentity2.getLatitude();
                    a32.f = cellIdentity2.getLongitude();
                    return a32;
                }
                la a322 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a322.g = cellIdentity2.getSystemId();
                a322.h = cellIdentity2.getNetworkId();
                a322.i = cellIdentity2.getBasestationId();
                a322.e = cellIdentity2.getLatitude();
                a322.f = cellIdentity2.getLongitude();
                return a322;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private static la a(CellInfoGsm cellInfoGsm, boolean z) {
        if (!(cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null)) {
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
            }
        }
        return null;
    }

    private static la a(CellInfoLte cellInfoLte, boolean z) {
        if (!(cellInfoLte == null || cellInfoLte.getCellIdentity() == null)) {
            CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
            if (c(cellIdentity.getTac()) && d(cellIdentity.getCi())) {
                la a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
                a2.o = cellIdentity.getPci();
                return a2;
            }
        }
        return null;
    }

    private static la a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (!(cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null)) {
            CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                la a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
                a2.o = cellIdentity.getPsc();
                return a2;
            }
        }
        return null;
    }

    private la a(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        la laVar = new la(1, true);
        laVar.a = kc.d(strArr[0]);
        laVar.b = kc.d(strArr[1]);
        laVar.c = gsmCellLocation.getLac();
        laVar.d = gsmCellLocation.getCid();
        laVar.j = this.o;
        return laVar;
    }

    private static la a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            la laVar = new la(1, false);
            laVar.a = Integer.parseInt(strArr[0]);
            laVar.b = Integer.parseInt(strArr[1]);
            laVar.c = ka.b(neighboringCellInfo, "getLac", new Object[0]);
            laVar.d = neighboringCellInfo.getCid();
            laVar.j = kc.a(neighboringCellInfo.getRssi());
            return laVar;
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private synchronized void a(CellLocation cellLocation, String[] strArr, boolean z) {
        la a2;
        if (cellLocation != null) {
            if (this.d != null) {
                this.b.clear();
                if (b(cellLocation)) {
                    this.a = 1;
                    this.b.add(a(cellLocation, strArr));
                    if (Build.VERSION.SDK_INT <= 28) {
                        List<NeighboringCellInfo> list = (List) ka.a(this.d, "getNeighboringCellInfo", new Object[0]);
                        if (list != null && !list.isEmpty()) {
                            for (NeighboringCellInfo neighboringCellInfo : list) {
                                if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (a2 = a(neighboringCellInfo, strArr)) != null && !this.b.contains(a2)) {
                                    this.b.add(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 15;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void b(int i2) {
        ArrayList<la> arrayList;
        if (i2 == -113) {
            this.o = -113;
            return;
        }
        this.o = i2;
        int i3 = this.a;
        if ((i3 == 1 || i3 == 2) && (arrayList = this.b) != null && !arrayList.isEmpty()) {
            try {
                this.b.get(0).j = this.o;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[RETURN] */
    private void b(CellLocation cellLocation, String[] strArr) {
        boolean z;
        if (cellLocation != null) {
            this.b.clear();
            try {
                boolean z2 = true;
                if (this.q != null) {
                    try {
                        Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                        if (gsmCellLocation != null && b(gsmCellLocation)) {
                            a((CellLocation) gsmCellLocation, strArr, false);
                            z = true;
                            if (z) {
                                return;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    z = false;
                    if (z) {
                    }
                }
                if (b(cellLocation)) {
                    this.a = 2;
                    la laVar = new la(2, true);
                    laVar.a = Integer.parseInt(strArr[0]);
                    laVar.b = Integer.parseInt(strArr[1]);
                    laVar.g = ka.b(cellLocation, "getSystemId", new Object[0]);
                    laVar.h = ka.b(cellLocation, "getNetworkId", new Object[0]);
                    laVar.i = ka.b(cellLocation, "getBaseStationId", new Object[0]);
                    laVar.j = this.o;
                    laVar.e = ka.b(cellLocation, "getBaseStationLatitude", new Object[0]);
                    int b2 = ka.b(cellLocation, "getBaseStationLongitude", new Object[0]);
                    laVar.f = b2;
                    int i2 = laVar.e;
                    if (i2 != b2 || i2 <= 0) {
                        z2 = false;
                    }
                    if (i2 < 0 || b2 < 0 || i2 == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE || z2) {
                        laVar.e = 0;
                        laVar.f = 0;
                    }
                    if (!this.b.contains(laVar)) {
                        this.b.add(laVar);
                    }
                }
            } catch (Throwable th) {
                jy.a(th, "CgiManager", "hdlCdmaLocChange");
            }
        }
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.j || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            jy.a(th, Utils.TAG, "getCellLocT");
            return 0;
        }
    }

    private static boolean c(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean d(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    private void k() {
        Object a2;
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                this.a = c(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager));
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            } catch (Throwable th) {
                this.i = null;
                jy.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                int w2 = w();
                this.r = w2;
                if (w2 != 1) {
                    a2 = kc.a(w2 != 2 ? this.l : this.l, "phone2");
                } else {
                    a2 = kc.a(this.l, "phone_msim");
                }
                this.q = a2;
            } catch (Throwable unused) {
            }
            hd.d().submit(new Runnable() {
                /* class com.amap.api.mapcore.util.lb.AnonymousClass1 */

                public final void run() {
                    synchronized (lb.this.y) {
                        if (!lb.this.x) {
                            lb.this.l();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        int i2;
        this.h = new b();
        try {
            i2 = ka.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            try {
                this.d.listen(this.h, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                this.d.listen(this.h, i2 | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private CellLocation m() {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager);
                this.i = null;
                if (b(cellLocation)) {
                    this.f = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            } catch (Throwable th) {
                this.i = null;
                jy.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean n() {
        return !this.j && kc.b() - this.e >= 10000;
    }

    private void o() {
        i();
    }

    private synchronized void p() {
        int f2 = f();
        if (f2 != 1) {
            if (f2 == 2) {
                if (this.b.isEmpty()) {
                    this.a = 0;
                }
            }
        } else if (this.b.isEmpty()) {
            this.a = 0;
        }
    }

    @SuppressLint({"NewApi"})
    private synchronized void q() {
        if (!this.j && this.d != null) {
            if (Build.VERSION.SDK_INT >= 29 && this.l.getApplicationInfo().targetSdkVersion >= 29) {
                if (this.t == null) {
                    this.t = new a();
                }
                this.d.requestCellInfoUpdate(hd.d(), this.t);
            }
            CellLocation s2 = s();
            if (!b(s2)) {
                s2 = t();
            }
            if (b(s2)) {
                this.f = s2;
                this.s = kc.b();
            } else if (kc.b() - this.s > DateUtils.MILLIS_PER_MINUTE) {
                this.f = null;
                this.b.clear();
                this.n.clear();
            }
        }
        this.g = true;
        if (b(this.f)) {
            r();
        }
        try {
            if (kc.c() >= 18) {
                v();
            }
        } catch (Throwable unused) {
        }
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.a |= 8;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void r() {
        String[] a2 = kc.a(this.d);
        int c2 = c(this.f);
        if (c2 != 1) {
            if (c2 == 2) {
                b(this.f, a2);
            }
            return;
        }
        a(this.f, a2, false);
    }

    @SuppressLint({"NewApi"})
    private CellLocation s() {
        TelephonyManager telephonyManager = this.d;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        if (kc.c() >= 18) {
            try {
                cellLocation = a(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager));
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation m2 = m();
        if (b(m2)) {
            return m2;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        return a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation t() {
        if (!v) {
            v = true;
        }
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> u2 = u();
            if (u2.isInstance(obj)) {
                Object cast = u2.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> u() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i2 = this.r;
        try {
            return systemClassLoader.loadClass(i2 != 0 ? i2 != 1 ? i2 != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d  */
    @SuppressLint({"NewApi"})
    private void v() {
        List list;
        int size;
        int i2;
        SecurityException e2;
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            ArrayList<la> arrayList = this.n;
            kz kzVar = this.p;
            try {
                list = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager);
                try {
                    this.i = null;
                } catch (SecurityException e3) {
                    e2 = e3;
                }
            } catch (SecurityException e4) {
                e2 = e4;
                list = null;
                this.i = e2.getMessage();
                if (arrayList != null) {
                }
                while (i2 < size) {
                }
                if (arrayList != null) {
                    return;
                }
            }
            if (!(list == null || (size = list.size()) == 0)) {
                if (arrayList != null) {
                    arrayList.clear();
                }
                for (i2 = 0; i2 < size; i2++) {
                    CellInfo cellInfo = (CellInfo) list.get(i2);
                    if (cellInfo != null) {
                        try {
                            la a2 = a(cellInfo);
                            if (a2 != null) {
                                a2.l = (short) ((int) Math.min(65535L, kzVar.a(a2)));
                                arrayList.add(a2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.a |= 4;
                kzVar.a(arrayList);
            }
        }
    }

    private int w() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable unused) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.r;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: com.amap.api.mapcore.util.kt */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ks> a() {
        kv kvVar;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(this.d);
        if (Build.VERSION.SDK_INT >= 17) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kt ktVar = new kt(cellInfo.isRegistered(), true);
                    ktVar.m = cellIdentity.getLatitude();
                    ktVar.n = cellIdentity.getLongitude();
                    ktVar.j = cellIdentity.getSystemId();
                    ktVar.k = cellIdentity.getNetworkId();
                    ktVar.l = cellIdentity.getBasestationId();
                    ktVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    ktVar.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    kvVar = ktVar;
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    ku kuVar = new ku(cellInfo.isRegistered(), true);
                    kuVar.a = String.valueOf(cellIdentity2.getMcc());
                    kuVar.b = String.valueOf(cellIdentity2.getMnc());
                    kuVar.j = cellIdentity2.getLac();
                    kuVar.k = cellIdentity2.getCid();
                    kuVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kuVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        kuVar.m = cellIdentity2.getArfcn();
                        kuVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(kuVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kv kvVar2 = new kv(cellInfo.isRegistered());
                    kvVar2.a = String.valueOf(cellIdentity3.getMcc());
                    kvVar2.b = String.valueOf(cellIdentity3.getMnc());
                    kvVar2.l = cellIdentity3.getPci();
                    kvVar2.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    kvVar2.k = cellIdentity3.getCi();
                    kvVar2.m = cellIdentity3.getEarfcn();
                    kvVar2.j = cellIdentity3.getTac();
                    kvVar2.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    kvVar2.c = cellInfoLte.getCellSignalStrength().getDbm();
                    kvVar = kvVar2;
                    if (Build.VERSION.SDK_INT >= 24) {
                        kvVar2.m = cellIdentity3.getEarfcn();
                        kvVar = kvVar2;
                    }
                } else {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        kw kwVar = new kw(cellInfo.isRegistered(), true);
                        kwVar.a = String.valueOf(cellIdentity4.getMcc());
                        kwVar.b = String.valueOf(cellIdentity4.getMnc());
                        kwVar.j = cellIdentity4.getLac();
                        kwVar.k = cellIdentity4.getCid();
                        kwVar.l = cellIdentity4.getPsc();
                        kwVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        kwVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i2 >= 24) {
                            kwVar.m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(kwVar);
                    }
                }
                arrayList.add(kvVar == 1 ? 1 : 0);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(CellLocation cellLocation) {
        Throwable th;
        String str;
        boolean z = false;
        if (cellLocation == null) {
            return false;
        }
        int c2 = c(cellLocation);
        if (c2 == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_GSM_T";
            }
        } else if (c2 != 2) {
            return true;
        } else {
            try {
                if (ka.b(cellLocation, "getSystemId", new Object[0]) > 0 && ka.b(cellLocation, "getNetworkId", new Object[0]) >= 0 && ka.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                    z = true;
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                str = "cgiUseful Cgi.I_CDMA_T";
                jy.a(th, "CgiManager", str);
                return true;
            }
        }
    }

    public final synchronized void b() {
        try {
            this.j = kc.a(this.l);
            if (n() || this.b.isEmpty()) {
                q();
                this.e = kc.b();
            }
            if (this.j) {
                o();
            } else {
                p();
            }
        } catch (SecurityException e2) {
            this.i = e2.getMessage();
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "refresh");
        }
    }

    public final synchronized ArrayList<la> c() {
        return this.b;
    }

    public final ArrayList<la> d() {
        return this.n;
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.a & 3;
    }

    public final TelephonyManager g() {
        return this.d;
    }

    public final void h() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0;
        synchronized (this.y) {
            this.x = true;
        }
        TelephonyManager telephonyManager = this.d;
        if (!(telephonyManager == null || (phoneStateListener = this.h) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                jy.a(th, "CgiManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            }
        }
        this.h = null;
        this.o = -113;
        this.d = null;
        this.q = null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void i() {
        this.i = null;
        this.f = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String j() {
        return this.m;
    }
}
