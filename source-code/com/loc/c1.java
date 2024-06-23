package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class c1 {
    private Context a;
    private boolean b = false;
    private boolean c = false;
    ArrayList<b1> d = new ArrayList<>();
    private String e = null;
    private ArrayList<b1> f = new ArrayList<>();
    TelephonyManager g = null;
    private a1 h = null;
    private long i = 0;
    PhoneStateListener j = null;
    SignalStrength k;
    private Object l = new Object();
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback m;
    private boolean n = false;
    boolean o = false;
    StringBuilder p = null;
    private String q = null;
    private String r = null;
    String s = null;
    private ek t;

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    /* compiled from: Taobao */
    public class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                if (m1.B() - c1.this.i >= 500) {
                    c1.this.n = true;
                    c1.this.j(c1.this.O());
                    c1.this.m(list);
                    c1.this.i = m1.B();
                }
            } catch (SecurityException e) {
                c1.this.s = e.getMessage();
            } catch (Throwable th) {
                j1.h(th, "Cgi", "cellInfo");
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
                if (c1.this.t != null) {
                    c1.this.t.o();
                }
                if (m1.B() - c1.this.i >= 500) {
                    c1.this.j(c1.this.O());
                    c1.this.m(list);
                    c1.this.i = m1.B();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void onCellLocationChanged(CellLocation cellLocation) {
            if (m1.B() - c1.this.i >= 500) {
                try {
                    c1.this.j(cellLocation);
                    c1.this.m(c1.this.P());
                    c1.this.i = m1.B();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
        }

        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    c1.this.o(false, false);
                } else if (state == 1) {
                    c1.this.E();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                c1 c1Var = c1.this;
                c1Var.k = signalStrength;
                try {
                    if (c1Var.t != null) {
                        c1.this.t.o();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public c1(Context context, Handler handler) {
        this.a = context;
        this.g = (TelephonyManager) m1.h(context, "phone");
        J();
        a1 a1Var = new a1(context, "cellAge", handler);
        this.h = a1Var;
        a1Var.c();
    }

    private void J() {
        if (this.g != null) {
            K();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    private void K() {
        PhoneStateListener phoneStateListener;
        try {
            if (this.j == null) {
                this.j = new b();
            }
            int i2 = 320;
            int i3 = Build.VERSION.SDK_INT;
            String str = "hasFineLocPerm";
            if (i3 >= 31) {
                if (this.a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                    this.r = str;
                } else {
                    this.r = "hasNoFineLocPerm";
                    if (i3 >= 17) {
                        if (i3 >= 31) {
                            boolean z = true;
                            boolean z2 = this.a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                            if (this.a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                                z = false;
                            }
                            if (z2 && z) {
                                i2 |= 1024;
                            }
                            this.q = z2 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                            if (!z) {
                                str = "hasNoFineLocPerm";
                            }
                            this.r = str;
                        } else {
                            i2 |= 1024;
                        }
                    }
                    phoneStateListener = this.j;
                    if (phoneStateListener == null) {
                        this.g.listen(phoneStateListener, i2);
                        return;
                    }
                    return;
                }
            }
            i2 = 336;
            if (i3 >= 17) {
            }
            phoneStateListener = this.j;
            if (phoneStateListener == null) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int L() {
        b1 z = z();
        if (z != null) {
            return z.l;
        }
        return 0;
    }

    private CellLocation M() {
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager);
                this.s = null;
                return cellLocation;
            } catch (SecurityException e2) {
                this.s = e2.getMessage();
            } catch (Throwable th) {
                this.s = null;
                j1.h(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean N() {
        return !this.o && m1.B() - this.i >= 45000;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CellLocation O() {
        if (this.g == null) {
            return null;
        }
        return M();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private List<CellInfo> P() {
        TelephonyManager telephonyManager;
        List<CellInfo> list;
        SecurityException e2;
        try {
            if (m1.K() < 18 || (telephonyManager = this.g) == null) {
                return null;
            }
            try {
                list = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager);
                try {
                    this.s = null;
                } catch (SecurityException e3) {
                    e2 = e3;
                }
            } catch (SecurityException e4) {
                e2 = e4;
                list = null;
                this.s = e2.getMessage();
                return list;
            }
            return list;
        } catch (Throwable th) {
            j1.h(th, "Cgi", "getNewCells");
            return null;
        }
    }

    private static b1 c(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        b1 b1Var = new b1(i2, z);
        b1Var.a = i3;
        b1Var.b = i4;
        b1Var.c = i5;
        b1Var.d = i6;
        b1Var.k = i7;
        return b1Var;
    }

    private b1 d(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        if (!(cellInfoCdma == null || cellInfoCdma.getCellIdentity() == null)) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] y = m1.y(this.g);
                try {
                    i4 = Integer.parseInt(y[0]);
                    try {
                        i2 = Integer.parseInt(y[1]);
                        i3 = i4;
                    } catch (Throwable unused) {
                        i3 = i4;
                        i2 = 0;
                        b1 c2 = c(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        c2.h = cellIdentity2.getSystemId();
                        c2.i = cellIdentity2.getNetworkId();
                        c2.j = cellIdentity2.getBasestationId();
                        c2.f = cellIdentity2.getLatitude();
                        c2.g = cellIdentity2.getLongitude();
                        c2.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return c2;
                    }
                } catch (Throwable unused2) {
                    i4 = 0;
                    i3 = i4;
                    i2 = 0;
                    b1 c22 = c(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    c22.h = cellIdentity2.getSystemId();
                    c22.i = cellIdentity2.getNetworkId();
                    c22.j = cellIdentity2.getBasestationId();
                    c22.f = cellIdentity2.getLatitude();
                    c22.g = cellIdentity2.getLongitude();
                    c22.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    return c22;
                }
                b1 c222 = c(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                c222.h = cellIdentity2.getSystemId();
                c222.i = cellIdentity2.getNetworkId();
                c222.j = cellIdentity2.getBasestationId();
                c222.f = cellIdentity2.getLatitude();
                c222.g = cellIdentity2.getLongitude();
                c222.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return c222;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private static b1 e(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        b1 c2 = c(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        c2.o = cellInfoGsm.getCellIdentity().getBsic();
        c2.p = cellInfoGsm.getCellIdentity().getArfcn();
        c2.q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        c2.s = cellInfoGsm.getCellSignalStrength().getDbm();
        return c2;
    }

    private static b1 f(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        b1 c2 = c(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        c2.o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            c2.p = cellIdentity.getEarfcn();
        }
        c2.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        c2.s = cellInfoLte.getCellSignalStrength().getDbm();
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    private static b1 g(CellInfoNr cellInfoNr, boolean z) {
        int i2;
        int i3;
        Throwable th;
        int i4;
        if (cellInfoNr == null || cellInfoNr.getCellIdentity() == null) {
            return null;
        }
        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
        int tac = cellIdentityNr.getTac();
        if (tac == Integer.MAX_VALUE && "HUAWEI".equals(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER())) {
            try {
                tac = k1.f(cellIdentityNr, "getHwTac", new Object[0]);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        long nci = cellIdentityNr.getNci();
        try {
            i4 = Integer.parseInt(cellIdentityNr.getMccString());
            try {
                i3 = i4;
                i2 = Integer.parseInt(cellIdentityNr.getMncString());
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                i3 = i4;
                i2 = 0;
                b1 c2 = c(5, z, i3, i2, cellIdentityNr.getTac(), 0, ((CellSignalStrengthNr) cellInfoNr.getCellSignalStrength()).getSsRsrp());
                c2.e = nci;
                if (tac > 16777215) {
                }
                c2.o = cellIdentityNr.getPci();
                c2.p = cellIdentityNr.getNrarfcn();
                c2.s = cellInfoNr.getCellSignalStrength().getDbm();
                return c2;
            }
        } catch (Throwable th4) {
            th = th4;
            i4 = 0;
            th.printStackTrace();
            i3 = i4;
            i2 = 0;
            b1 c22 = c(5, z, i3, i2, cellIdentityNr.getTac(), 0, ((CellSignalStrengthNr) cellInfoNr.getCellSignalStrength()).getSsRsrp());
            c22.e = nci;
            if (tac > 16777215) {
            }
            c22.o = cellIdentityNr.getPci();
            c22.p = cellIdentityNr.getNrarfcn();
            c22.s = cellInfoNr.getCellSignalStrength().getDbm();
            return c22;
        }
        b1 c222 = c(5, z, i3, i2, cellIdentityNr.getTac(), 0, ((CellSignalStrengthNr) cellInfoNr.getCellSignalStrength()).getSsRsrp());
        c222.e = nci;
        if (tac > 16777215) {
            c222.c = 65535;
        } else if (tac > 65535) {
            c222.c = 65535;
            c222.q = tac;
        } else {
            c222.c = tac;
        }
        c222.o = cellIdentityNr.getPci();
        c222.p = cellIdentityNr.getNrarfcn();
        c222.s = cellInfoNr.getCellSignalStrength().getDbm();
        return c222;
    }

    private static b1 h(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        b1 c2 = c(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        c2.o = cellIdentity.getPsc();
        c2.p = cellInfoWcdma.getCellIdentity().getUarfcn();
        c2.s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return c2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void j(CellLocation cellLocation) {
        String[] y = m1.y(this.g);
        this.d.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            b1 b1Var = new b1(1, true);
            b1Var.a = m1.S(y[0]);
            b1Var.b = m1.S(y[1]);
            b1Var.c = gsmCellLocation.getLac();
            b1Var.d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.k;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                b1Var.s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : q(gsmSignalStrength);
            }
            b1Var.r = false;
            this.h.d(b1Var);
            this.d.add(b1Var);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            b1 b1Var2 = new b1(2, true);
            b1Var2.a = Integer.parseInt(y[0]);
            b1Var2.b = Integer.parseInt(y[1]);
            b1Var2.f = cdmaCellLocation.getBaseStationLatitude();
            b1Var2.g = cdmaCellLocation.getBaseStationLongitude();
            b1Var2.h = cdmaCellLocation.getSystemId();
            b1Var2.i = cdmaCellLocation.getNetworkId();
            b1Var2.j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.k;
            if (signalStrength2 != null) {
                b1Var2.s = signalStrength2.getCdmaDbm();
            }
            b1Var2.r = false;
            this.h.d(b1Var2);
            this.d.add(b1Var2);
        }
    }

    public static boolean p(int i2) {
        return i2 > 0 && i2 <= 15;
    }

    private static int q(int i2) {
        return (i2 * 2) - 113;
    }

    @SuppressLint({"NewApi"})
    private void s(boolean z, boolean z2) {
        if (!this.o && this.g != null && Build.VERSION.SDK_INT >= 29 && this.a.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.m == null) {
                this.m = new a();
            }
            this.g.requestCellInfoUpdate(o0.f().c(), this.m);
            if (z2 || z) {
                int i2 = 0;
                while (!this.n && i2 < 20) {
                    try {
                        Thread.sleep(5);
                    } catch (Throwable unused) {
                    }
                    i2++;
                }
            }
        }
        this.c = false;
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.e = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.c = true;
            }
        }
        this.i = m1.B();
    }

    public final synchronized b1 A() {
        if (this.o) {
            return null;
        }
        ArrayList<b1> arrayList = this.f;
        if (arrayList.size() <= 0) {
            return null;
        }
        Iterator<b1> it = arrayList.iterator();
        while (it.hasNext()) {
            b1 next = it.next();
            if (next.n) {
                return next.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int B() {
        int i2 = 0;
        int L = L() | (this.b ? 4 : 0);
        if (this.c) {
            i2 = 8;
        }
        return L | i2;
    }

    public final int C() {
        return L() & 3;
    }

    public final TelephonyManager D() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void E() {
        this.s = null;
        this.d.clear();
        this.f.clear();
        this.b = false;
        this.c = false;
    }

    public final String F() {
        return this.s;
    }

    public final String G() {
        return this.e;
    }

    public final synchronized String H() {
        if (this.o) {
            E();
        }
        StringBuilder sb = this.p;
        if (sb == null) {
            this.p = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (C() == 1) {
            for (int i2 = 1; i2 < this.d.size(); i2++) {
                StringBuilder sb2 = this.p;
                sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                sb2.append(this.d.get(i2).b);
                StringBuilder sb3 = this.p;
                sb3.append("|");
                sb3.append(this.d.get(i2).c);
                StringBuilder sb4 = this.p;
                sb4.append("|");
                sb4.append(this.d.get(i2).d);
            }
        }
        for (int i3 = 1; i3 < this.f.size(); i3++) {
            b1 b1Var = this.f.get(i3);
            int i4 = b1Var.l;
            if (!(i4 == 1 || i4 == 3 || i4 == 4)) {
                if (i4 != 5) {
                    if (i4 == 2) {
                        StringBuilder sb5 = this.p;
                        sb5.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb5.append(b1Var.l);
                        StringBuilder sb6 = this.p;
                        sb6.append("|");
                        sb6.append(b1Var.a);
                        StringBuilder sb7 = this.p;
                        sb7.append("|");
                        sb7.append(b1Var.h);
                        StringBuilder sb8 = this.p;
                        sb8.append("|");
                        sb8.append(b1Var.i);
                        StringBuilder sb9 = this.p;
                        sb9.append("|");
                        sb9.append(b1Var.j);
                    }
                }
            }
            StringBuilder sb10 = this.p;
            sb10.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb10.append(b1Var.l);
            StringBuilder sb11 = this.p;
            sb11.append("|");
            sb11.append(b1Var.a);
            StringBuilder sb12 = this.p;
            sb12.append("|");
            sb12.append(b1Var.b);
            StringBuilder sb13 = this.p;
            sb13.append("|");
            sb13.append(b1Var.c);
            StringBuilder sb14 = this.p;
            sb14.append("|");
            sb14.append(b1Var.a());
        }
        if (this.p.length() > 0) {
            this.p.deleteCharAt(0);
        }
        return this.p.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(1:9)|10|11|(1:21)(1:24)) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    public final boolean I() {
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null && (!TextUtils.isEmpty(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator(telephonyManager)) || !TextUtils.isEmpty(this.g.getSimCountryIso()))) {
            return true;
        }
        int f2 = m1.f(m1.L(this.a));
        return f2 != 0 || f2 == 4 || f2 == 2 || f2 == 5 || f2 == 3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: com.loc.ds */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<dr> i() {
        du duVar;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(this.g);
        if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    ds dsVar = new ds(cellInfo.isRegistered(), true);
                    dsVar.m = cellIdentity.getLatitude();
                    dsVar.n = cellIdentity.getLongitude();
                    dsVar.j = cellIdentity.getSystemId();
                    dsVar.k = cellIdentity.getNetworkId();
                    dsVar.l = cellIdentity.getBasestationId();
                    dsVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    dsVar.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    duVar = dsVar;
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    dt dtVar = new dt(cellInfo.isRegistered(), true);
                    dtVar.a = String.valueOf(cellIdentity2.getMcc());
                    dtVar.b = String.valueOf(cellIdentity2.getMnc());
                    dtVar.j = cellIdentity2.getLac();
                    dtVar.k = cellIdentity2.getCid();
                    dtVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    dtVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        dtVar.m = cellIdentity2.getArfcn();
                        dtVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(dtVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    du duVar2 = new du(cellInfo.isRegistered());
                    duVar2.a = String.valueOf(cellIdentity3.getMcc());
                    duVar2.b = String.valueOf(cellIdentity3.getMnc());
                    duVar2.l = cellIdentity3.getPci();
                    duVar2.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    duVar2.k = cellIdentity3.getCi();
                    duVar2.j = cellIdentity3.getTac();
                    duVar2.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    duVar2.c = cellInfoLte.getCellSignalStrength().getDbm();
                    duVar = duVar2;
                    if (Build.VERSION.SDK_INT >= 24) {
                        duVar2.m = cellIdentity3.getEarfcn();
                        duVar = duVar2;
                    }
                } else {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        dv dvVar = new dv(cellInfo.isRegistered(), true);
                        dvVar.a = String.valueOf(cellIdentity4.getMcc());
                        dvVar.b = String.valueOf(cellIdentity4.getMnc());
                        dvVar.j = cellIdentity4.getLac();
                        dvVar.k = cellIdentity4.getCid();
                        dvVar.l = cellIdentity4.getPsc();
                        dvVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        dvVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i2 >= 24) {
                            dvVar.m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(dvVar);
                    }
                }
                arrayList.add(duVar == 1 ? 1 : 0);
            }
        }
        return arrayList;
    }

    public final void k(ek ekVar) {
        this.t = ekVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void m(List<CellInfo> list) {
        ArrayList<b1> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null) {
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    CellInfo cellInfo = list.get(i2);
                    if (cellInfo != null) {
                        b1 b1Var = null;
                        boolean isRegistered = cellInfo.isRegistered();
                        if (cellInfo instanceof CellInfoCdma) {
                            b1Var = d((CellInfoCdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoGsm) {
                            b1Var = e((CellInfoGsm) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            b1Var = h((CellInfoWcdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoLte) {
                            b1Var = f((CellInfoLte) cellInfo, isRegistered);
                        } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                            b1Var = g((CellInfoNr) cellInfo, isRegistered);
                        }
                        if (b1Var != null) {
                            this.h.d(b1Var);
                            b1Var.m = (short) ((int) Math.min(65535L, this.h.r(b1Var)));
                            b1Var.r = true;
                            this.f.add(b1Var);
                        }
                    }
                }
                this.b = false;
                ArrayList<b1> arrayList2 = this.f;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.b = true;
                }
            }
        }
    }

    public final void n(boolean z) {
        PhoneStateListener phoneStateListener;
        this.h.g(z);
        this.i = 0;
        synchronized (this.l) {
        }
        TelephonyManager telephonyManager = this.g;
        if (!(telephonyManager == null || (phoneStateListener = this.j) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                j1.h(th, "CgiManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            }
        }
        this.j = null;
        this.k = null;
        this.g = null;
    }

    public final void o(boolean z, boolean z2) {
        try {
            this.o = m1.n(this.a);
            if (N()) {
                s(z, z2);
                j(O());
                m(P());
            }
            if (this.o) {
                E();
            }
        } catch (SecurityException e2) {
            this.s = e2.getMessage();
        } catch (Throwable th) {
            j1.h(th, "CgiManager", "refresh");
        }
    }

    public final void r() {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z2 = true;
                if (!TextUtils.isEmpty(this.r) && !this.r.equals(str)) {
                    z = true;
                }
                if (TextUtils.isEmpty(this.q) || this.q.equals(str2)) {
                    z2 = z;
                }
                if (z2) {
                    K();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized ArrayList<b1> v() {
        ArrayList<b1> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<b1> arrayList2 = this.d;
        if (arrayList2 != null) {
            Iterator<b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<b1> w() {
        ArrayList<b1> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<b1> arrayList2 = this.f;
        if (arrayList2 != null) {
            Iterator<b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized b1 z() {
        if (this.o) {
            return null;
        }
        ArrayList<b1> arrayList = this.d;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }
}
