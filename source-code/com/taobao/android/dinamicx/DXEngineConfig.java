package com.taobao.android.dinamicx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.dt;
import tb.h;
import tb.jx;
import tb.xv2;

/* compiled from: Taobao */
public class DXEngineConfig {
    public static final int DEFAULT_MAX_CACHE_COUNT = 100;
    public static final int DEFAULT_PERIOD_TIME = (DXSignalProduce.f * 20);
    public static final int DOWN_GRADE_ONCE = 2;
    public static final int DOWN_GRADE_TO_PRESET = 1;
    public static final String DX_DEFAULT_BIZTYPE = "default_bizType";
    public static final int NOTIFICATION_TYPE_EVERY_ONE = 1;
    public static final int NOTIFICATION_TYPE_ONLY_ONE = 2;
    String a;
    int b;
    long c;
    int d;
    boolean e;
    boolean f;
    int g;
    boolean h;
    long i;
    private String j;
    private int k;
    private dt l;
    private boolean m;
    private h n;
    private boolean o;
    private jx p;
    private boolean q;
    private DXVideoControlConfig<xv2> r;
    private boolean s;
    private int t;
    private boolean u;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DownGradeType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface RemoteTemplateDownloadNotificationType {
    }

    /* compiled from: Taobao */
    public static final class b {
        private String a;
        private int b;
        private int c;
        private boolean d;
        private long e;
        boolean f;
        private int g;
        private boolean h;
        private long i;
        private String j;
        private int k;
        private h l;
        private dt m;
        private boolean n;
        private IDXElderTextSizeStrategy o;
        private boolean p;
        private boolean q = true;
        private DXVideoControlConfig<xv2> r;
        private boolean s = false;
        private int t;
        private boolean u = true;

        public b(String str) {
            this.a = str;
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
            } else {
                this.a = DXEngineConfig.DX_DEFAULT_BIZTYPE;
            }
            this.e = System.currentTimeMillis();
            this.c = 1;
            this.d = false;
            this.g = 100;
            this.h = true;
            this.b = DXEngineConfig.DEFAULT_PERIOD_TIME;
            this.f = false;
            this.i = 100;
            this.k = -1;
            this.j = "";
            this.t = 1;
        }

        public DXEngineConfig t() {
            return new DXEngineConfig(this.a, this);
        }

        public b u(int i2) {
            this.c = i2;
            return this;
        }

        public b v(boolean z) {
            this.p = z;
            return this;
        }

        public b w(int i2) {
            this.t = i2;
            return this;
        }

        public b x(boolean z) {
            this.h = z;
            return this;
        }
    }

    public h a() {
        return this.n;
    }

    public String b() {
        return this.a;
    }

    public dt c() {
        return this.l;
    }

    public jx d() {
        return this.p;
    }

    public long e() {
        return this.c;
    }

    public int f() {
        return this.k;
    }

    public String g() {
        return this.j;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.g;
    }

    public int j() {
        return this.t;
    }

    public long k() {
        return this.i;
    }

    public DXVideoControlConfig<xv2> l() {
        return this.r;
    }

    public boolean m() {
        return this.f;
    }

    public boolean n() {
        return this.u;
    }

    public boolean o() {
        return this.q;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.s;
    }

    public boolean r() {
        return this.m;
    }

    public boolean s() {
        return this.h;
    }

    public DXEngineConfig(@NonNull String str) {
        this(str, new b(str));
    }

    private DXEngineConfig(@NonNull String str, b bVar) {
        this.d = 1;
        this.q = true;
        this.t = 1;
        this.u = true;
        this.a = str;
        this.b = bVar.b;
        this.c = bVar.e;
        this.d = bVar.c;
        this.e = bVar.d;
        this.g = bVar.g;
        this.h = bVar.h;
        this.f = bVar.f;
        this.i = Math.max(bVar.i, 100L);
        if (TextUtils.isEmpty(str)) {
            this.a = DX_DEFAULT_BIZTYPE;
        }
        this.k = bVar.k;
        this.j = bVar.j;
        this.n = bVar.l;
        dt unused = bVar.m;
        this.m = bVar.n;
        if (bVar.o != null) {
            this.p = new jx(bVar.o);
        } else {
            this.p = c.b;
        }
        this.o = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
    }
}
