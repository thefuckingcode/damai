package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.phenix.loader.LocalSchemeHandler;
import java.util.List;

/* compiled from: Taobao */
public class i42 {
    public static final int LOCAL_URI = 32;
    public static final int NETWORK_URI = 1;
    public final int a;
    public String b;
    public String c;
    public String d = "";
    public int e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public String j;
    public int k;
    public int l;
    public boolean m;

    public i42(int i2) {
        this.a = i2;
    }

    private static boolean b(String str, int i2) {
        char charAt;
        int i3 = i2 + 1;
        if (i3 >= str.length() || (charAt = str.charAt(i3)) == '.' || charAt == '_') {
            return true;
        }
        return false;
    }

    public static i42 d(@NonNull String str) {
        i42 j2 = j(str);
        return (j2 == null && (j2 = e(str)) == null && (j2 = l(str)) == null && (j2 = f(str)) == null && (j2 = i(str)) == null) ? h(str) : j2;
    }

    private static i42 e(@NonNull String str) {
        if (!str.startsWith("asset://")) {
            return null;
        }
        i42 i42 = new i42(34);
        i42.b = str;
        i42.h = str.substring(8);
        i42.d = g(str);
        return i42;
    }

    private static i42 f(@NonNull String str) {
        int indexOf;
        if (!str.startsWith("data:image/") || (indexOf = str.indexOf(";base64,", 11)) <= 0 || indexOf >= 17) {
            return null;
        }
        i42 i42 = new i42(40);
        int i2 = indexOf + 8;
        i42.j = str.substring(i2);
        i42.b = str.substring(0, i2) + "hash=" + Integer.toHexString(i42.j.hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        sb.append(str.substring(11, indexOf));
        i42.d = sb.toString();
        return i42;
    }

    private static String g(@NonNull String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(lastIndexOf) : "";
    }

    private static i42 h(@NonNull String str) {
        int indexOf;
        i42 i42 = new i42(1);
        i42.b = str;
        int length = str.length();
        int indexOf2 = str.indexOf(63);
        if (indexOf2 < 0) {
            indexOf2 = length;
        }
        int lastIndexOf = str.lastIndexOf(47, indexOf2 - 1);
        if (lastIndexOf >= 0 && lastIndexOf < length - 1) {
            String substring = str.substring(lastIndexOf + 1, indexOf2);
            i42.d = g(substring);
            if (!m(substring, i42) && !k(str, lastIndexOf, substring, i42) && (indexOf = str.indexOf("//gw.alicdn.com")) >= 0 && indexOf <= 6) {
                if (substring.endsWith("_.webp")) {
                    i42.b = substring.substring(0, substring.length() - 6);
                } else {
                    i42.b = substring;
                }
                i42.f = 10000;
                i42.e = 10000;
                i42.g = true;
            }
            if (!TextUtils.isEmpty(i42.b)) {
                int lastIndexOf2 = i42.b.lastIndexOf(47);
                if (lastIndexOf2 > 0) {
                    i42.c = i42.b.substring(lastIndexOf2 + 1);
                } else {
                    i42.c = i42.b;
                }
            }
        }
        return i42;
    }

    private static i42 i(@NonNull String str) {
        List<LocalSchemeHandler> i2 = tp1.o().i();
        if (i2 == null) {
            return null;
        }
        int i3 = 0;
        for (LocalSchemeHandler localSchemeHandler : i2) {
            if (localSchemeHandler.isSupported(str)) {
                i42 i42 = new i42(48);
                i42.k = i3;
                i42.b = str;
                return i42;
            }
            i3++;
        }
        return null;
    }

    private static i42 j(@NonNull String str) {
        boolean startsWith = str.startsWith("file:///");
        if (startsWith || (str.length() > 1 && str.charAt(0) == '/' && str.charAt(1) != '/')) {
            i42 i42 = new i42(33);
            i42.d = g(str);
            if (startsWith) {
                i42.h = str.substring(7);
            } else {
                i42.h = str;
            }
            i42.b = i42.h;
            return i42;
        } else if (!str.startsWith("content://")) {
            return null;
        } else {
            i42 i422 = new i42(33);
            i422.h = str;
            i422.b = str;
            return i422;
        }
    }

    private static boolean k(String str, int i2, String str2, i42 i42) {
        int lastIndexOf = str2.lastIndexOf(64);
        int i3 = 0;
        if (lastIndexOf >= 0 && str2.indexOf(45, lastIndexOf) <= 0 && str2.indexOf(124, lastIndexOf) <= 0 && str2.indexOf("_2e", lastIndexOf) <= 0) {
            int n = n(str2, lastIndexOf, 'w');
            i42.e = n;
            if (n != 0) {
                int n2 = n(str2, lastIndexOf, 'h');
                i42.f = n2;
                if (n2 != 0 && i42.e == n2) {
                    i42.g = true;
                    int indexOf = str.indexOf(WVUtils.URL_SEPARATOR);
                    if (indexOf > 0 && str.charAt(indexOf - 1) == ':') {
                        i3 = indexOf;
                    }
                    i42.b = str.substring(i3, i2 + lastIndexOf + 1);
                    return true;
                }
            }
        }
        return false;
    }

    private static i42 l(@NonNull String str) {
        if (!str.startsWith("res://")) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            i42 i42 = new i42(36);
            i42.i = parseInt;
            i42.b = str;
            return i42;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean m(String str, i42 i42) {
        int indexOf = str.indexOf(95);
        if (indexOf < 0) {
            return false;
        }
        int indexOf2 = str.indexOf(120, indexOf);
        int length = str.length();
        while (indexOf2 > indexOf) {
            i42.e = o(str, indexOf2, false, indexOf);
            int o = o(str, indexOf2, true, length);
            i42.f = o;
            int i2 = i42.e;
            if (i2 > 0 && i2 == o) {
                int length2 = String.valueOf(o).length();
                int i3 = indexOf2 + length2;
                int i4 = i3 + 2;
                if (!(i4 < str.length() && str.charAt(i3 + 1) == 'x' && str.charAt(i4) == 'z')) {
                    i42.g = true;
                    int i5 = (indexOf2 - length2) - 1;
                    if (i5 > 0) {
                        i42.b = str.substring(0, i5);
                    }
                }
                return true;
            } else if ((i2 > 0 && o == 10000) || (o > 0 && i2 == 10000)) {
                return true;
            } else {
                i42.f = 0;
                i42.e = 0;
                indexOf = indexOf2 + 1;
                indexOf2 = str.indexOf(120, indexOf);
            }
        }
        return false;
    }

    private static int n(String str, int i2, char c2) {
        int o;
        int indexOf = str.indexOf(c2, i2);
        while (indexOf > i2) {
            if (b(str, indexOf) && (o = o(str, indexOf, false, i2)) != 0) {
                return o;
            }
            i2 = indexOf + 1;
            indexOf = str.indexOf(c2, i2);
        }
        return 0;
    }

    private static int o(String str, int i2, boolean z, int i3) {
        int charAt;
        int i4 = 0;
        if (i2 < 0) {
            return 0;
        }
        if (z) {
            while (true) {
                i2++;
                if (i2 >= i3 || str.charAt(i2) - '0' < 0 || charAt > 9) {
                    return i4;
                }
                i4 = (i4 * 10) + charAt;
            }
        } else {
            int i5 = i2 - 1;
            int i6 = 0;
            while (i5 > i3) {
                int charAt2 = str.charAt(i5) - '0';
                if (charAt2 < 0 || charAt2 > 9) {
                    break;
                }
                i6 += charAt2 * ((int) Math.pow(10.0d, (double) i4));
                i5--;
                i4++;
            }
            return i6;
        }
    }

    public static String p(String str) {
        return "asset://" + str;
    }

    public static String q(String str) {
        return "file://" + str;
    }

    public static String r(int i2) {
        return "res://" + i2;
    }

    public boolean a() {
        return (this.a & 32) > 0;
    }

    public boolean c() {
        return (this.a & 32) == 0;
    }

    public String toString() {
        return "type=" + this.a + ", baseName=" + this.b + ", extension=" + this.d + ", width=" + this.e + ", height=" + this.f + ", cdnSize=" + this.g + ", path=" + this.h + ", resId=" + this.i + ", base64=" + this.j;
    }
}
