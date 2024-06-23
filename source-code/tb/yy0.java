package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import anet.channel.strategy.a;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
public class yy0 {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private volatile boolean g = false;

    private yy0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        if (r2 <= 65535) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0130  */
    public static yy0 g(String str) {
        int i;
        int i2;
        int i3;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        yy0 yy0 = new yy0();
        yy0.e = trim;
        int i4 = 0;
        if (trim.startsWith(WVUtils.URL_SEPARATOR)) {
            yy0.a = null;
            i = 0;
        } else if (trim.regionMatches(true, 0, "https:", 0, 6)) {
            yy0.a = "https";
            i = 6;
        } else {
            if (trim.regionMatches(true, 0, "http:", 0, 5)) {
                yy0.a = "http";
                i = 5;
            }
            return null;
        }
        int length = trim.length();
        int i5 = i + 2;
        int i6 = i5;
        boolean z = false;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = trim.charAt(i6);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == '/' || charAt == '?' || charAt == '#' || (charAt == ':' && !z)) {
                yy0.b = trim.substring(i5, i6);
            }
            i6++;
        }
        if (i6 == length) {
            yy0.b = trim.substring(i5);
        }
        int i7 = 0;
        while (true) {
            if (i6 >= length) {
                i2 = length;
                break;
            }
            char charAt2 = trim.charAt(i6);
            if (charAt2 == ':' && i7 == 0) {
                i7 = i6 + 1;
            } else if (charAt2 == '/' || charAt2 == '#' || charAt2 == '?') {
                i2 = i6;
            }
            i6++;
        }
        i2 = i6;
        if (i7 != 0) {
            try {
                int parseInt = Integer.parseInt(trim.substring(i7, i2));
                yy0.d = parseInt;
                if (parseInt > 0) {
                }
            } catch (NumberFormatException unused) {
            }
            return null;
        }
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt3 = trim.charAt(i6);
            if (charAt3 == '/' && i4 == 0) {
                i4 = i6;
            } else if (charAt3 == '?' || charAt3 == '#') {
                if (i4 != 0) {
                    i3 = i6;
                    if (i4 == 0) {
                        yy0.c = trim.substring(i4, i3);
                    } else {
                        yy0.c = null;
                    }
                    if (yy0.a == null) {
                        int i8 = yy0.d;
                        if (i8 == 80) {
                            yy0.a = "http";
                        } else if (i8 == 443) {
                            yy0.a = "https";
                        } else {
                            yy0.a = a.a().getSchemeByHost(yy0.b, null);
                        }
                    }
                    if (!TextUtils.isEmpty(yy0.a) && !TextUtils.isEmpty(yy0.b)) {
                        StringBuilder sb = new StringBuilder(yy0.a);
                        sb.append(ke1.SCHEME_SLASH);
                        sb.append(yy0.b);
                        if (yy0.a()) {
                            sb.append(":");
                            sb.append(yy0.d);
                        }
                        str2 = yy0.c;
                        if (str2 == null) {
                            sb.append(str2);
                        } else if (i6 != length) {
                            sb.append("/");
                        }
                        yy0.f = sb.toString();
                        sb.append(trim.substring(i6));
                        yy0.e = sb.toString();
                        return yy0;
                    }
                    return null;
                }
            }
            i6++;
        }
        if (i4 != 0) {
        }
        i3 = length;
        if (i4 == 0) {
        }
        if (yy0.a == null) {
        }
        StringBuilder sb2 = new StringBuilder(yy0.a);
        sb2.append(ke1.SCHEME_SLASH);
        sb2.append(yy0.b);
        if (yy0.a()) {
        }
        str2 = yy0.c;
        if (str2 == null) {
        }
        yy0.f = sb2.toString();
        sb2.append(trim.substring(i6));
        yy0.e = sb2.toString();
        return yy0;
    }

    public boolean a() {
        return this.d != 0 && (("http".equals(this.a) && this.d != 80) || ("https".equals(this.a) && this.d != 443));
    }

    public void b() {
        this.g = true;
        if (!"http".equals(this.a)) {
            this.a = "http";
            String str = this.e;
            this.e = ag2.e("http", ":", str.substring(str.indexOf(WVUtils.URL_SEPARATOR)));
        }
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.g;
    }

    public void f() {
        this.g = true;
    }

    public String h() {
        return this.c;
    }

    public void i(String str, int i) {
        if (str != null) {
            int indexOf = this.e.indexOf(WVUtils.URL_SEPARATOR) + 2;
            while (indexOf < this.e.length() && this.e.charAt(indexOf) != '/') {
                indexOf++;
            }
            boolean d2 = ju2.d(str);
            StringBuilder sb = new StringBuilder(this.e.length() + str.length());
            sb.append(this.a);
            sb.append(ke1.SCHEME_SLASH);
            if (d2) {
                sb.append(jl1.ARRAY_START);
            }
            sb.append(str);
            if (d2) {
                sb.append(jl1.ARRAY_END);
            }
            if (i != 0) {
                sb.append(jl1.CONDITION_IF_MIDDLE);
                sb.append(i);
            } else if (this.d != 0) {
                sb.append(jl1.CONDITION_IF_MIDDLE);
                sb.append(this.d);
            }
            sb.append(this.e.substring(indexOf));
            this.e = sb.toString();
        }
    }

    public String j() {
        return this.a;
    }

    public void k(String str) {
        if (!this.g && !str.equalsIgnoreCase(this.a)) {
            this.a = str;
            String str2 = this.e;
            String e2 = ag2.e(str, ":", str2.substring(str2.indexOf(WVUtils.URL_SEPARATOR)));
            this.e = e2;
            this.f = ag2.e(str, ":", this.f.substring(e2.indexOf(WVUtils.URL_SEPARATOR)));
        }
    }

    public String l() {
        return this.f;
    }

    public URL m() {
        try {
            return new URL(this.e);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String n() {
        return this.e;
    }

    public String toString() {
        return this.e;
    }

    public yy0(yy0 yy0) {
        this.a = yy0.a;
        this.b = yy0.b;
        this.c = yy0.c;
        this.e = yy0.e;
        this.f = yy0.f;
        this.g = yy0.g;
    }
}
