package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.mapcore.util.br;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: Taobao */
public class az extends OfflineMapCity implements bi, bz {
    public static final Parcelable.Creator<az> o = new Parcelable.Creator<az>() {
        /* class com.amap.api.mapcore.util.az.AnonymousClass2 */

        /* renamed from: a */
        public az createFromParcel(Parcel parcel) {
            return new az(parcel);
        }

        /* renamed from: a */
        public az[] newArray(int i) {
            return new az[i];
        }
    };
    public final cd a;
    public final cd b;
    public final cd c;
    public final cd d;
    public final cd e;
    public final cd f;
    public final cd g;
    public final cd h;
    public final cd i;
    public final cd j;
    public final cd k;
    cd l;
    Context m;
    boolean n;
    private String p;
    private String q;
    private long r;

    /* renamed from: com.amap.api.mapcore.util.az$3  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[ca.a.values().length];
            a = iArr;
            iArr[ca.a.amap_exception.ordinal()] = 1;
            a[ca.a.file_io_exception.ordinal()] = 2;
            try {
                a[ca.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public az(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        t();
    }

    @Override // com.amap.api.mapcore.util.bz
    public String A() {
        return getAdcode();
    }

    @Override // com.amap.api.mapcore.util.bt
    public String B() {
        return u();
    }

    @Override // com.amap.api.mapcore.util.bt
    public String C() {
        return v();
    }

    @Override // com.amap.api.mapcore.util.bi
    public String b() {
        return getUrl();
    }

    public cd c() {
        return this.l;
    }

    public void d() {
        ba a2 = ba.a(this.m);
        if (a2 != null) {
            a2.c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City
    public int describeContents() {
        return 0;
    }

    public void e() {
        ba a2 = ba.a(this.m);
        if (a2 != null) {
            a2.e(this);
            d();
        }
    }

    public void f() {
        bx.a("CityOperation current State==>" + c().b());
        if (this.l.equals(this.d)) {
            this.l.d();
        } else if (this.l.equals(this.c)) {
            this.l.e();
        } else if (this.l.equals(this.g) || this.l.equals(this.h)) {
            k();
            this.n = true;
        } else if (this.l.equals(this.j) || this.l.equals(this.i) || this.l.a(this.k)) {
            this.l.c();
        } else {
            c().h();
        }
    }

    public void g() {
        this.l.e();
    }

    public void h() {
        this.l.a(this.k.b());
    }

    public void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public void j() {
        this.l.equals(this.f);
        this.l.f();
    }

    public void k() {
        ba a2 = ba.a(this.m);
        if (a2 != null) {
            a2.a(this);
        }
    }

    public void l() {
        ba a2 = ba.a(this.m);
        if (a2 != null) {
            a2.b(this);
        }
    }

    public void m() {
        ba a2 = ba.a(this.m);
        if (a2 != null) {
            a2.d(this);
        }
    }

    @Override // com.amap.api.mapcore.util.ca
    public void n() {
        this.r = 0;
        if (!this.l.equals(this.b)) {
            bx.a("state must be waiting when download onStart");
        }
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.ca
    public void o() {
        if (!this.l.equals(this.c)) {
            bx.a("state must be Loading when download onFinish");
        }
        this.l.g();
    }

    @Override // com.amap.api.mapcore.util.ca
    public void p() {
        e();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void q() {
        this.r = 0;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void r() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    @Override // com.amap.api.mapcore.util.bs
    public void s() {
        e();
    }

    /* access modifiers changed from: protected */
    public void t() {
        String str = ba.a;
        String c2 = bx.c(getUrl());
        if (c2 != null) {
            this.p = str + c2 + ".zip.tmp";
            return;
        }
        this.p = str + getPinyin() + ".zip.tmp";
    }

    public String u() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String str = this.p;
        return str.substring(0, str.lastIndexOf("."));
    }

    public String v() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String u = u();
        return u.substring(0, u.lastIndexOf(46));
    }

    public boolean w() {
        bx.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.q);
    }

    public bk x() {
        setState(this.l.b());
        bk bkVar = new bk(this, this.m);
        bkVar.a(a());
        bx.a("vMapFileNames: " + a());
        return bkVar;
    }

    @Override // com.amap.api.mapcore.util.bz
    public boolean y() {
        return w();
    }

    @Override // com.amap.api.mapcore.util.bz
    public String z() {
        StringBuffer stringBuffer = new StringBuffer();
        String c2 = bx.c(getUrl());
        if (c2 != null) {
            stringBuffer.append(c2);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void b(String str) {
        this.l.equals(this.e);
        this.q = str;
        String u = u();
        String v = v();
        if (TextUtils.isEmpty(u) || TextUtils.isEmpty(v)) {
            r();
            return;
        }
        File file = new File(v + "/");
        File file2 = new File(eq.a(this.m) + File.separator + "map/");
        File file3 = new File(eq.a(this.m));
        if (!file3.exists() && !file3.mkdir()) {
            return;
        }
        if (file2.exists() || file2.mkdir()) {
            a(file, file2, u);
        }
    }

    public void a(String str) {
        this.q = str;
    }

    public String a() {
        return this.q;
    }

    public void a(int i2) {
        if (i2 == -1) {
            this.l = this.h;
        } else if (i2 == 0) {
            this.l = this.c;
        } else if (i2 == 1) {
            this.l = this.e;
        } else if (i2 == 2) {
            this.l = this.b;
        } else if (i2 == 3) {
            this.l = this.d;
        } else if (i2 == 4) {
            this.l = this.f;
        } else if (i2 == 6) {
            this.l = this.a;
        } else if (i2 != 7) {
            switch (i2) {
                case 101:
                    this.l = this.i;
                    break;
                case 102:
                    this.l = this.j;
                    break;
                case 103:
                    this.l = this.k;
                    break;
                default:
                    if (i2 < 0) {
                        this.l = this.h;
                        break;
                    }
                    break;
            }
        } else {
            this.l = this.g;
        }
        setState(i2);
    }

    public az(Context context, int i2) {
        this.a = new cf(6, this);
        this.b = new cm(2, this);
        this.c = new ci(0, this);
        this.d = new ck(3, this);
        this.e = new cl(1, this);
        this.f = new ce(4, this);
        this.g = new cj(7, this);
        this.h = new cg(-1, this);
        this.i = new cg(101, this);
        this.j = new cg(102, this);
        this.k = new cg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.m = context;
        a(i2);
    }

    public cd b(int i2) {
        switch (i2) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }

    public void a(cd cdVar) {
        this.l = cdVar;
        setState(cdVar.b());
    }

    @Override // com.amap.api.mapcore.util.ca
    public void a(long j2, long j3) {
        int i2 = (int) ((j3 * 100) / j2);
        if (i2 != getcompleteCode()) {
            setCompleteCode(i2);
            d();
        }
    }

    @Override // com.amap.api.mapcore.util.ca
    public void a(ca.a aVar) {
        int i2;
        int i3 = AnonymousClass3.a[aVar.ordinal()];
        if (i3 == 1) {
            i2 = this.j.b();
        } else if (i3 == 2) {
            i2 = this.k.b();
        } else if (i3 != 3) {
            i2 = 6;
        } else {
            i2 = this.i.b();
        }
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.a(i2);
        }
    }

    @Override // com.amap.api.mapcore.util.bs
    public void a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r > 500) {
            int i2 = (int) j2;
            if (i2 > getcompleteCode()) {
                setCompleteCode(i2);
                d();
            }
            this.r = currentTimeMillis;
        }
    }

    public az(Parcel parcel) {
        super(parcel);
        this.a = new cf(6, this);
        this.b = new cm(2, this);
        this.c = new ci(0, this);
        this.d = new ck(3, this);
        this.e = new cl(1, this);
        this.f = new ce(4, this);
        this.g = new cj(7, this);
        this.h = new cg(-1, this);
        this.i = new cg(101, this);
        this.j = new cg(102, this);
        this.k = new cg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.q = parcel.readString();
    }

    private void a(final File file, File file2, final String str) {
        new br().a(file, file2, -1, bx.a(file), new br.a() {
            /* class com.amap.api.mapcore.util.az.AnonymousClass1 */

            @Override // com.amap.api.mapcore.util.br.a
            public void a(String str, String str2) {
            }

            @Override // com.amap.api.mapcore.util.br.a
            public void a(String str, String str2, float f) {
                int i = (int) ((((double) f) * 0.39d) + 60.0d);
                if (i - az.this.getcompleteCode() > 0 && System.currentTimeMillis() - az.this.r > 1000) {
                    az.this.setCompleteCode(i);
                    az.this.r = System.currentTimeMillis();
                }
            }

            @Override // com.amap.api.mapcore.util.br.a
            public void b(String str, String str2) {
                try {
                    if (new File(str).delete()) {
                        bx.b(file);
                        az.this.setCompleteCode(100);
                        az.this.l.g();
                    }
                } catch (Exception unused) {
                    az azVar = az.this;
                    azVar.l.a(azVar.k.b());
                }
            }

            @Override // com.amap.api.mapcore.util.br.a
            public void a(String str, String str2, int i) {
                az azVar = az.this;
                azVar.l.a(azVar.k.b());
            }
        });
    }
}
