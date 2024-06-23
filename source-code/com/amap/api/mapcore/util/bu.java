package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.Cif;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
public class bu implements Cif.a {
    bv a = null;
    long b = 0;
    long c = 0;
    long d;
    boolean e = true;
    bp f;
    long g = 0;
    a h;
    private Context i;
    private ca j;
    private String k;
    private il l;
    private bq m;
    private boolean n = false;

    /* compiled from: Taobao */
    public interface a {
        void c();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends dp {
        private final String d;

        public b(String str) {
            this.d = str;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            return this.d;
        }

        @Override // com.amap.api.mapcore.util.ii
        public boolean isSupportIPV6() {
            return false;
        }
    }

    public bu(bv bvVar, String str, Context context, ca caVar) throws IOException {
        this.f = bp.a(context.getApplicationContext());
        this.a = bvVar;
        this.i = context;
        this.k = str;
        this.j = caVar;
        d();
    }

    private void c() throws IOException {
        cb cbVar = new cb(this.k);
        cbVar.setConnectionTimeout(30000);
        cbVar.setSoTimeout(30000);
        this.l = new il(cbVar, this.b, this.c, MapsInitializer.getProtocol() == 2);
        this.m = new bq(this.a.b() + File.separator + this.a.c(), this.b);
    }

    private void d() {
        File file = new File(this.a.b() + this.a.c());
        if (file.exists()) {
            this.e = false;
            this.b = file.length();
            try {
                long g2 = g();
                this.d = g2;
                this.c = g2;
            } catch (IOException unused) {
                ca caVar = this.j;
                if (caVar != null) {
                    caVar.a(ca.a.file_io_exception);
                }
            }
        } else {
            this.b = 0;
            this.c = 0;
        }
    }

    private boolean e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.b());
        sb.append(File.separator);
        sb.append(this.a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void f() throws AMapException {
        if (ge.a != 1) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    if (ge.a(this.i, eq.e())) {
                        return;
                    }
                } catch (Throwable th) {
                    hd.c(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    private long g() throws IOException {
        Map<String, String> map;
        try {
            map = ih.b().b(new b(this.a.a()), MapsInitializer.getProtocol() == 2);
        } catch (gb e2) {
            e2.printStackTrace();
            map = null;
        }
        int i2 = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if (Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(str)) {
                    i2 = Integer.parseInt(map.get(str));
                }
            }
        }
        return (long) i2;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a != null && currentTimeMillis - this.g > ((long) 500)) {
            i();
            this.g = currentTimeMillis;
            a(this.b);
        }
    }

    private void i() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public void a() {
        try {
            if (eq.d(this.i)) {
                f();
                if (ge.a != 1) {
                    ca caVar = this.j;
                    if (caVar != null) {
                        caVar.a(ca.a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!e()) {
                    this.e = true;
                }
                if (this.e) {
                    long g2 = g();
                    this.d = g2;
                    if (g2 == -1) {
                        bx.a("File Length is not known!");
                    } else if (g2 == ((long) -2)) {
                        bx.a("File is not access!");
                    } else {
                        this.c = g2;
                    }
                    this.b = 0;
                }
                ca caVar2 = this.j;
                if (caVar2 != null) {
                    caVar2.n();
                }
                if (this.b >= this.c) {
                    onFinish();
                    return;
                }
                c();
                this.l.a(this);
                return;
            }
            ca caVar3 = this.j;
            if (caVar3 != null) {
                caVar3.a(ca.a.network_exception);
            }
        } catch (AMapException e2) {
            hd.c(e2, "SiteFileFetch", "download");
            ca caVar4 = this.j;
            if (caVar4 != null) {
                caVar4.a(ca.a.amap_exception);
            }
        } catch (IOException unused) {
            ca caVar5 = this.j;
            if (caVar5 != null) {
                caVar5.a(ca.a.file_io_exception);
            }
        }
    }

    public void b() {
        il ilVar = this.l;
        if (ilVar != null) {
            ilVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onDownload(byte[] bArr, long j2) {
        try {
            this.m.a(bArr);
            this.b = j2;
            h();
        } catch (IOException e2) {
            e2.printStackTrace();
            hd.c(e2, "fileAccessI", "fileAccessI.write(byte[] data)");
            ca caVar = this.j;
            if (caVar != null) {
                caVar.a(ca.a.file_io_exception);
            }
            il ilVar = this.l;
            if (ilVar != null) {
                ilVar.a();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onException(Throwable th) {
        bq bqVar;
        this.n = true;
        b();
        ca caVar = this.j;
        if (caVar != null) {
            caVar.a(ca.a.network_exception);
        }
        if (!(th instanceof IOException) && (bqVar = this.m) != null) {
            bqVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onFinish() {
        h();
        ca caVar = this.j;
        if (caVar != null) {
            caVar.o();
        }
        bq bqVar = this.m;
        if (bqVar != null) {
            bqVar.a();
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onStop() {
        if (!this.n) {
            ca caVar = this.j;
            if (caVar != null) {
                caVar.p();
            }
            i();
        }
    }

    private void a(long j2) {
        ca caVar;
        long j3 = this.d;
        if (j3 > 0 && (caVar = this.j) != null) {
            caVar.a(j3, j2);
            this.g = System.currentTimeMillis();
        }
    }

    public void a(a aVar) {
        this.h = aVar;
    }
}
