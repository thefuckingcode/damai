package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.Cif;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: Taobao */
public class l implements Cif.a {
    a a;
    private final Context b;
    private RandomAccessFile c;
    private il d;
    private String e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        protected String a;
        protected String b;
        protected String c;
        protected String d;
        protected String e;
        protected c f;

        public a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4 + ".tmp";
            this.e = str4;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        public c e() {
            return this.f;
        }

        public void a(c cVar) {
            this.f = cVar;
        }
    }

    /* compiled from: Taobao */
    static class b extends dp {
        private final a d;

        b(a aVar) {
            this.d = aVar;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            a aVar = this.d;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public boolean isSupportIPV6() {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c {
        protected String a;
        protected String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b);
        }
    }

    /* compiled from: Taobao */
    static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public void a(String str, String str2) {
            a(new c(str, str2));
        }
    }

    public l(Context context, a aVar, gm gmVar) {
        this.b = context.getApplicationContext();
        if (aVar != null) {
            this.a = aVar;
            this.d = new il(new b(aVar));
            this.e = aVar.c();
        }
    }

    private boolean b() {
        c e2 = this.a.e();
        return e2 == null || !e2.c() || !eg.a(this.b, e2.a(), e2.b(), "").equalsIgnoreCase(this.a.b());
    }

    public void a() {
        il ilVar;
        try {
            if (b() && (ilVar = this.d) != null) {
                ilVar.a(this);
            }
        } catch (Throwable th) {
            hd.c(th, "AuthTaskDownload", "startDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onDownload(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new RandomAccessFile(file, "rw");
            }
            this.c.seek(j);
            this.c.write(bArr);
        } catch (Throwable th) {
            hd.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Throwable th2) {
            hd.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                    hd.c(th, "AuthTaskDownload", "onFinish3");
                }
                String b2 = this.a.b();
                String a2 = gk.a(this.e);
                if (a2 == null || !b2.equalsIgnoreCase(a2)) {
                    try {
                        new File(this.e).delete();
                    } catch (Throwable th2) {
                        hd.c(th2, "AuthTaskDownload", DAttrConstant.VIEW_EVENT_FINISH);
                    }
                } else {
                    String d2 = this.a.d();
                    try {
                        br brVar = new br();
                        File file = new File(this.e);
                        brVar.a(file, new File(d2), -1, bx.a(file), null);
                        c e2 = this.a.e();
                        if (e2 != null && e2.c()) {
                            eg.a(this.b, e2.a(), e2.b(), (Object) a2);
                        }
                        new File(this.e).delete();
                    } catch (Throwable th3) {
                        hd.c(th3, "AuthTaskDownload", "onFinish1");
                    }
                }
            }
        } catch (Throwable th4) {
            hd.c(th4, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.mapcore.util.Cif.a
    public void onStop() {
    }
}
