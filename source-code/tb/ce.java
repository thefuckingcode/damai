package tb;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import mtopsdk.common.util.HttpHeaderConstant;
import okhttp3.l;

/* compiled from: Taobao */
public final class ce {
    public static final ce FORCE_CACHE = new a().d().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    public static final ce FORCE_NETWORK = new a().c().a();
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    @Nullable
    String m;

    /* compiled from: Taobao */
    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public ce a() {
            return new ce(this);
        }

        public a b(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a c() {
            this.a = true;
            return this;
        }

        public a d() {
            this.f = true;
            return this;
        }
    }

    private ce(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.a = z;
        this.b = z2;
        this.c = i2;
        this.d = i3;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i4;
        this.i = i5;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    public static ce k(l lVar) {
        int i2;
        int i3;
        String str;
        l lVar2 = lVar;
        int h2 = lVar.h();
        int i4 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = -1;
        int i8 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i4 < h2) {
            String e2 = lVar2.e(i4);
            String j2 = lVar2.j(i4);
            if (e2.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = j2;
                    for (i2 = 0; i2 < j2.length(); i2 = i3) {
                        int h3 = qy0.h(j2, i2, "=,;");
                        String trim = j2.substring(i2, h3).trim();
                        if (h3 == j2.length() || j2.charAt(h3) == ',' || j2.charAt(h3) == ';') {
                            i3 = h3 + 1;
                            str = null;
                        } else {
                            int i9 = qy0.i(j2, h3 + 1);
                            if (i9 >= j2.length() || j2.charAt(i9) != '\"') {
                                i3 = qy0.h(j2, i9, ",;");
                                str = j2.substring(i9, i3).trim();
                            } else {
                                int i10 = i9 + 1;
                                int h4 = qy0.h(j2, i10, "\"");
                                str = j2.substring(i10, h4);
                                i3 = h4 + 1;
                            }
                        }
                        if (HttpHeaderConstant.NO_CACHE.equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(trim)) {
                            i5 = qy0.f(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i6 = qy0.f(str, -1);
                        } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i7 = qy0.f(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i8 = qy0.f(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                    }
                    i4++;
                    lVar2 = lVar;
                }
            } else if (!e2.equalsIgnoreCase("Pragma")) {
                i4++;
                lVar2 = lVar;
            }
            z = false;
            while (i2 < j2.length()) {
            }
            i4++;
            lVar2 = lVar;
        }
        return new ce(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.a;
    }

    public boolean i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.m = a2;
        return a2;
    }

    ce(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
    }
}
