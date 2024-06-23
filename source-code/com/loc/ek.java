package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.loc.v;
import com.loc.v0;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;
import org.apache.commons.lang3.time.DateUtils;
import tb.a53;
import tb.d33;
import tb.f33;
import tb.i53;
import tb.j33;
import tb.p43;
import tb.q23;
import tb.q53;
import tb.r23;
import tb.z43;

/* compiled from: Taobao */
public final class ek implements ee {
    private static long k;
    Context a = null;
    private ArrayList<j33> b = new ArrayList<>();
    private Handler c;
    i53 d = null;
    c1 e = null;
    x0 f;
    private LocationManager g;
    private a h;
    r23 i;
    private volatile boolean j = false;

    /* compiled from: Taobao */
    static class a implements LocationListener {
        private ek a;

        a(ek ekVar) {
            this.a = ekVar;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.a = null;
        }

        /* access modifiers changed from: package-private */
        public final void b(ek ekVar) {
            this.a = ekVar;
        }

        public final void onLocationChanged(Location location) {
            try {
                ek ekVar = this.a;
                if (ekVar != null) {
                    ekVar.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends ck {
        private int b;
        private Location c;

        b(int i) {
            this.b = 0;
            this.b = i;
        }

        b(ek ekVar, Location location) {
            this(1);
            this.c = location;
        }

        private void b() {
            try {
                if (this.c != null && ek.this.j && !m1.f0(ek.this.a)) {
                    Bundle extras = this.c.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    if (!m1.p(this.c, i)) {
                        i53 i53 = ek.this.d;
                        if (i53 != null && !i53.o) {
                            i53.q();
                        }
                        ArrayList<y0> c2 = ek.this.d.c();
                        List<dr> i2 = ek.this.e.i();
                        v0.a aVar = new v0.a();
                        p43 p43 = new p43();
                        p43.g = this.c.getAccuracy();
                        p43.d = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(this.c);
                        p43.b = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(this.c);
                        p43.f = this.c.getBearing();
                        p43.c = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(this.c);
                        this.c.isFromMockProvider();
                        this.c.getProvider();
                        p43.e = this.c.getSpeed();
                        p43.i = (byte) i;
                        System.currentTimeMillis();
                        p43.a = this.c.getTime();
                        p43.h = this.c.getTime();
                        aVar.a = p43;
                        aVar.b = c2;
                        WifiInfo l = ek.this.d.l();
                        if (l != null) {
                            aVar.c = y0.a(l.getBSSID());
                        }
                        aVar.d = i53.E;
                        aVar.f = this.c.getTime();
                        aVar.g = (byte) o.Z(ek.this.a);
                        aVar.h = o.e0(ek.this.a);
                        aVar.e = ek.this.d.v();
                        aVar.j = m1.n(ek.this.a);
                        aVar.i = i2;
                        j33 d = x0.d(aVar);
                        if (d != null) {
                            synchronized (ek.this.b) {
                                ek.this.b.add(d);
                                if (ek.this.b.size() >= 5) {
                                    ek.this.s();
                                }
                            }
                            ek.this.r();
                        }
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "cl", "coll");
            }
        }

        private void c() {
            if (!m1.f0(ek.this.a)) {
                v vVar = null;
                try {
                    long unused = ek.k = System.currentTimeMillis();
                    if (ek.this.i.f.e()) {
                        vVar = v.b(new File(ek.this.i.a), ek.this.i.b);
                        ArrayList arrayList = new ArrayList();
                        byte[] i = ek.i(128);
                        if (i == null) {
                            try {
                                vVar.close();
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        } else {
                            List k = ek.k(vVar, ek.this.i, arrayList, i);
                            if (k == null || k.size() == 0) {
                                try {
                                    vVar.close();
                                    return;
                                } catch (Throwable unused3) {
                                    return;
                                }
                            } else {
                                ek.this.i.f.b(true);
                                if (x0.f(v1.u(x0.h(e1.d(i), p1.h(i, x0.g(), v1.w()), k)))) {
                                    ek.m(vVar, arrayList);
                                }
                            }
                        }
                    }
                    if (vVar != null) {
                        try {
                            vVar.close();
                        } catch (Throwable unused4) {
                        }
                    }
                } catch (Throwable unused5) {
                }
            }
        }

        @Override // com.loc.ck
        public final void a() {
            int i = this.b;
            if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            } else if (i == 3) {
                ek.this.u();
            }
        }
    }

    ek(Context context) {
        this.a = context;
        r23 r23 = new r23();
        this.i = r23;
        e0.e(this.a, r23, al.k, 100, 1024000, "0");
        r23 r232 = this.i;
        int i2 = i1.F;
        boolean z = i1.D;
        int i3 = i1.E;
        r232.f = new f33(context, i2, "kKey", new d33(context, z, i3, i3 * 10, "carrierLocKey"));
        this.i.e = new n();
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    /* access modifiers changed from: private */
    public static byte[] i(int i2) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            if (instance == null) {
                return null;
            }
            instance.init(i2);
            return instance.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(0)(3:23|24|(1:(2:27|28))(6:29|(10:33|(7:36|37|38|39|40|41|34)|89|46|47|48|49|50|51|(6:57|58|59|60|88|78))|53|54|55|56))|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:29|(10:33|(7:36|37|38|39|40|41|34)|89|46|47|48|49|50|51|(6:57|58|59|60|88|78))|53|54|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r9 != null) goto L_0x003b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e9 A[SYNTHETIC, Splitter:B:71:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fb A[SYNTHETIC] */
    public static List<j33> k(v vVar, r23 r23, List<String> list, byte[] bArr) {
        String[] list2;
        String[] strArr;
        v.e eVar;
        byte[] e2;
        byte[] bArr2;
        ArrayList arrayList = new ArrayList();
        try {
            File m = vVar.m();
            if (m == null || !m.exists() || (list2 = m.list()) == null) {
                return arrayList;
            }
            int length = list2.length;
            char c2 = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = list2[i2];
                if (str.contains(".0")) {
                    InputStream inputStream = null;
                    try {
                        String str2 = str.split("\\.")[c2];
                        try {
                            eVar = vVar.a(str2);
                            if (eVar != null) {
                                try {
                                    inputStream = eVar.a();
                                    if (inputStream != null) {
                                        byte[] bArr3 = new byte[2];
                                        inputStream.read(bArr3);
                                        int A = m1.A(bArr3);
                                        if (A != 0 && A <= 65535) {
                                            byte[] bArr4 = new byte[A];
                                            inputStream.read(bArr4);
                                            byte[] bArr5 = new byte[2];
                                            int i4 = 0;
                                            while (inputStream.read(bArr5) >= 0) {
                                                try {
                                                    byte[] bArr6 = new byte[m1.A(bArr5)];
                                                    inputStream.read(bArr6);
                                                    e2 = p1.e(bArr4, bArr6, v1.w());
                                                    i4 += e2.length;
                                                    bArr2 = new byte[4];
                                                    inputStream.read(bArr2);
                                                    strArr = list2;
                                                } catch (Throwable unused) {
                                                    strArr = list2;
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                    if (eVar == null) {
                                                        i2++;
                                                        list2 = strArr;
                                                        c2 = 0;
                                                    }
                                                    try {
                                                        eVar.close();
                                                    } catch (Throwable unused3) {
                                                    }
                                                    i2++;
                                                    list2 = strArr;
                                                    c2 = 0;
                                                }
                                                try {
                                                    arrayList.add(new j33(a(bArr2), p1.h(bArr, v1.u(e2), v1.w())));
                                                    list2 = strArr;
                                                } catch (Throwable unused4) {
                                                    if (inputStream != null) {
                                                    }
                                                    if (eVar == null) {
                                                    }
                                                    eVar.close();
                                                    i2++;
                                                    list2 = strArr;
                                                    c2 = 0;
                                                }
                                            }
                                            strArr = list2;
                                            i3 += i4;
                                            try {
                                                list.add(str2);
                                                try {
                                                    if (i3 <= r23.f.d()) {
                                                        inputStream.close();
                                                        eVar.close();
                                                        i2++;
                                                        list2 = strArr;
                                                        c2 = 0;
                                                    }
                                                } catch (Throwable unused5) {
                                                    if (inputStream != null) {
                                                    }
                                                    if (eVar == null) {
                                                    }
                                                    eVar.close();
                                                    i2++;
                                                    list2 = strArr;
                                                    c2 = 0;
                                                }
                                            } catch (Throwable unused6) {
                                                if (inputStream != null) {
                                                }
                                                if (eVar == null) {
                                                }
                                                eVar.close();
                                                i2++;
                                                list2 = strArr;
                                                c2 = 0;
                                            }
                                        }
                                        inputStream.close();
                                        eVar.close();
                                    } else if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Throwable unused7) {
                                    strArr = list2;
                                    if (inputStream != null) {
                                    }
                                    if (eVar == null) {
                                    }
                                    eVar.close();
                                    i2++;
                                    list2 = strArr;
                                    c2 = 0;
                                }
                            }
                            eVar.close();
                        } catch (Throwable unused8) {
                            strArr = list2;
                            eVar = null;
                            if (inputStream != null) {
                            }
                            if (eVar == null) {
                            }
                            eVar.close();
                            i2++;
                            list2 = strArr;
                            c2 = 0;
                        }
                    } catch (Throwable unused9) {
                        strArr = list2;
                        eVar = null;
                        if (inputStream != null) {
                        }
                        if (eVar == null) {
                        }
                        eVar.close();
                        i2++;
                        list2 = strArr;
                        c2 = 0;
                    }
                }
                strArr = list2;
                i2++;
                list2 = strArr;
                c2 = 0;
            }
            return arrayList;
        } catch (Throwable th) {
            an.m(th, "aps", "upc");
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void m(v vVar, List<String> list) {
        if (vVar != null) {
            try {
                for (String str : list) {
                    vVar.r(str);
                }
                vVar.close();
            } catch (Throwable th) {
                an.m(th, "aps", "dlo");
            }
        }
    }

    private static byte[] n(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    private static byte[] q(int i2) {
        byte[] bArr = new byte[2];
        bArr[1] = (byte) (i2 & 255);
        bArr[0] = (byte) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u() {
        ArrayList<j33> arrayList;
        try {
            if (m1.f0(this.a) || (arrayList = this.b) == null) {
                return;
            }
            if (arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.b) {
                    arrayList2.addAll(this.b);
                    this.b.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] i2 = i(256);
                if (i2 != null) {
                    byteArrayOutputStream.write(q(i2.length));
                    byteArrayOutputStream.write(i2);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        j33 j33 = (j33) it.next();
                        byte[] b2 = j33.b();
                        if (b2.length >= 10 && b2.length <= 65535) {
                            byte[] h2 = p1.h(i2, b2, v1.w());
                            byteArrayOutputStream.write(q(h2.length));
                            byteArrayOutputStream.write(h2);
                            byteArrayOutputStream.write(n(j33.a()));
                        }
                    }
                    b0.c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.i);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "clm", "wtD");
        }
    }

    @Override // com.loc.ee
    public final a53 a(z43 z43) {
        try {
            q53 q53 = new q53();
            q53.J(z43.b);
            q53.L(z43.a);
            q53.K(z43.c);
            bg.b();
            q23 c2 = bg.c(q53);
            a53 a53 = new a53();
            a53.c = c2.a;
            a53.b = c2.b;
            a53.a = 200;
            return a53;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        LocationManager locationManager;
        if (!m1.f0(this.a)) {
            try {
                a aVar = this.h;
                if (!(aVar == null || (locationManager = this.g) == null)) {
                    locationManager.removeUpdates(aVar);
                }
                a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a();
                }
                if (this.j) {
                    u();
                    this.d.d(null);
                    this.e.k(null);
                    this.e = null;
                    this.d = null;
                    this.c = null;
                    this.j = false;
                }
            } catch (Throwable th) {
                j1.h(th, "clm", ReportManager.f);
            }
        }
    }

    public final void e(Location location) {
        try {
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            an.m(th, "cl", "olcc");
        }
    }

    public final void g(c1 c1Var, i53 i53, Handler handler) {
        LocationManager locationManager;
        if (!this.j && c1Var != null && i53 != null && handler != null && !m1.f0(this.a)) {
            this.j = true;
            this.e = c1Var;
            this.d = i53;
            i53.d(this);
            this.e.k(this);
            this.c = handler;
            try {
                if (this.g == null) {
                    this.g = (LocationManager) this.a.getSystemService("location");
                }
                if (this.h == null) {
                    this.h = new a(this);
                }
                this.h.b(this);
                a aVar = this.h;
                if (!(aVar == null || (locationManager = this.g) == null)) {
                    com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(locationManager, "passive", 1000, -1.0f, aVar);
                }
                if (this.f == null) {
                    x0 x0Var = new x0("6.1.0", l.j(this.a), "S128DF1572465B890OE3F7A13167KLEI", l.g(this.a), this);
                    this.f = x0Var;
                    x0Var.c(o.h0(this.a)).i(o.R(this.a)).l(o.w(this.a)).m(o.Q(this.a)).n(o.k0(this.a)).o(o.T(this.a)).p(Build.getMODEL()).q(Build.getMANUFACTURER()).r(Build.getBRAND()).a(Build.VERSION.SDK_INT).s(Build.VERSION.getRELEASE()).b(y0.a(o.W(this.a))).t(o.W(this.a));
                    x0.j();
                }
            } catch (Throwable th) {
                j1.h(th, "col", UCCore.LEGACY_EVENT_INIT);
            }
        }
    }

    public final void l() {
        try {
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new Runnable() {
                    /* class com.loc.ek.AnonymousClass1 */

                    public final void run() {
                        i53 i53;
                        try {
                            ek ekVar = ek.this;
                            if (ekVar.f != null && (i53 = ekVar.d) != null) {
                                x0.k(i53.c());
                            }
                        } catch (Throwable th) {
                            j1.h(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            j1.h(th, "cl", "upw");
        }
    }

    public final void o() {
        c1 c1Var;
        try {
            if (this.f != null && (c1Var = this.e) != null) {
                x0.e(c1Var.i());
            }
        } catch (Throwable th) {
            j1.h(th, "cl", "upc");
        }
    }

    public final void r() {
        try {
            if (!m1.f0(this.a) && System.currentTimeMillis() - k >= DateUtils.MILLIS_PER_MINUTE) {
                o0.f().d(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void s() {
        try {
            o0.f().d(new b(3));
        } catch (Throwable unused) {
        }
    }
}
