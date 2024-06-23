package tb;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Hashtable;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.a;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fy0;

/* compiled from: Taobao */
public final class k8 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COLOR_NONE = 1;
    @NotNull
    public static final String DAMAI_HEIGHT = "damai_height";
    @NotNull
    public static final String DAMAI_WIDTH = "damai_width";
    @NotNull
    public static final k8 INSTANCE = new k8();
    @Nullable
    private static Hashtable<String, Integer> a;

    static {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        a = hashtable;
        hashtable.put("aqua", -16711681);
        hashtable.put("black", -16777216);
        hashtable.put("blue", -16776961);
        hashtable.put("darkgrey", -5658199);
        hashtable.put("fuchsia", -65281);
        hashtable.put("gray", -8355712);
        hashtable.put("grey", -8355712);
        hashtable.put("green", -16744448);
        hashtable.put("lightblue", -5383962);
        hashtable.put("lightgrey", -2894893);
        hashtable.put("lime", -16711936);
        hashtable.put("maroon", -8388608);
        hashtable.put("navy", -16777088);
        hashtable.put("olive", -8355840);
        hashtable.put("orange", -23296);
        hashtable.put("purple", -8388480);
        hashtable.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        hashtable.put("silver", -4144960);
        hashtable.put("teal", -16744320);
        hashtable.put("white", -1);
        hashtable.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        hashtable.put("sienna", -6270419);
        hashtable.put("darkolivegreen", -11179217);
        hashtable.put("darkgreen", -16751616);
        hashtable.put("darkslateblue", -12042869);
        hashtable.put("indigo", -11861886);
        hashtable.put("darkslategray", -13676721);
        hashtable.put("darkred", -7667712);
        hashtable.put("darkorange", -29696);
        hashtable.put("slategray", -9404272);
        hashtable.put("dimgray", -9868951);
        hashtable.put("sandybrown", -744352);
        hashtable.put("yellowgreen", -5374161);
        hashtable.put("seagreen", -13726889);
        hashtable.put("mediumturquoise", -12004916);
        hashtable.put("royalblue", -12490271);
        hashtable.put("magenta", -65281);
        hashtable.put("cyan", -16711681);
        hashtable.put("deepskyblue", -16728065);
        hashtable.put("darkorchid", -6737204);
        hashtable.put("pink", -16181);
        hashtable.put("wheat", -663885);
        hashtable.put("lemonchiffon", -1331);
        hashtable.put("palegreen", -6751336);
        hashtable.put("paleturquoise", -5247250);
        hashtable.put("plum", -2252579);
    }

    private k8() {
    }

    private final int a(boolean z, String str, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688209098")) {
            return ((Integer) ipChange.ipc$dispatch("1688209098", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)})).intValue();
        }
        if (z) {
            i2 = j(str, i, "text-align", 15);
        } else {
            i2 = j(str, i, "align", 10);
        }
        if (i2 <= 0) {
            return -1;
        }
        while (true) {
            k21.f(str);
            if (i2 < str.length() && (k21.k(str.charAt(i2), 97) < 0 || k21.k(str.charAt(i2), 122) > 0)) {
                i2++;
            }
        }
        if (o.K(str, "right", i2, false, 4, null)) {
            return 2;
        }
        if (o.K(str, "center", i2, false, 4, null)) {
            return 1;
        }
        if (o.K(str, "left", i2, false, 4, null)) {
            return 0;
        }
        return -1;
    }

    private final String b(String str, int i, String str2) {
        int j;
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660403506")) {
            return (String) ipChange.ipc$dispatch("1660403506", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        k21.f(str);
        if ((str.length() - i) - 4 < str2.length() || (j = j(str, i, str2, str2.length() + 4)) < 0 || (i2 = StringsKt__StringsKt.f0(str, "=", j, false, 4, null)) < 0 || (i3 = StringsKt__StringsKt.f0(str, "\"", i2, false, 4, null)) < 0 || (i4 = i3 + 1) > str.length() - 2) {
            return null;
        }
        while (i4 < str.length() - 2 && (str.charAt(i4) == ' ' || str.charAt(i4) == '\n')) {
            i4++;
        }
        int i5 = i4 + 1;
        while (i5 < str.length() - 1 && str.charAt(i5) != '\"' && str.charAt(i5) != ' ' && str.charAt(i5) != '\n') {
            i5++;
        }
        if (i5 > str.length() - 1) {
            return null;
        }
        String substring = str.substring(i4, i5);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986687341")) {
            return ((Integer) ipChange.ipc$dispatch("-986687341", new Object[]{this, str})).intValue();
        }
        String replaceAll = Pattern.compile("[^0-9]").matcher(str).replaceAll("");
        try {
            k21.h(replaceAll, "result");
            return Integer.parseInt(replaceAll);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final int d(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169044823")) {
            return ((Integer) ipChange.ipc$dispatch("-1169044823", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        String b = b(str, i, "size");
        if (b != null && TextUtils.isDigitsOnly(b)) {
            return Integer.parseInt(b);
        }
        return -1;
    }

    private final int e(int i, int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433699836")) {
            return ((Integer) ipChange.ipc$dispatch("433699836", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str})).intValue();
        }
        int i3 = i2 - i;
        if (i3 < 3) {
            return 1;
        }
        k21.f(str);
        if (str.charAt(i) == '#') {
            if (i3 == 9) {
                i += 2;
            }
            if (i2 - i != 7) {
                return 1;
            }
            String substring = str.substring(i + 1, i2);
            k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return Integer.parseInt(substring, a.a(16)) | -16777216;
        }
        Hashtable<String, Integer> hashtable = a;
        k21.f(hashtable);
        String substring2 = str.substring(i, i2);
        k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        Locale locale = Locale.US;
        k21.h(locale, "US");
        String lowerCase = substring2.toLowerCase(locale);
        k21.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Integer num = hashtable.get(lowerCase);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final int f(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "899299914")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("899299914", new Object[]{this, str})).intValue();
    }

    private final int g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2095476499")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("-2095476499", new Object[]{this, str})).intValue();
    }

    private final int i(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747560469")) {
            return ((Integer) ipChange.ipc$dispatch("-747560469", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        int j = j(str, i, "color", 10);
        if (j < 0) {
            return 1;
        }
        if (j > i + 5) {
            k21.f(str);
            int i2 = j - 6;
            if (str.charAt(i2) == '-' || str.charAt(i2) == 'g') {
                return 1;
            }
        }
        while (true) {
            k21.f(str);
            if (j >= str.length() - 3) {
                return 1;
            }
            if (str.charAt(j) == '=') {
                while (j < str.length() - 3 && str.charAt(j) != '\"') {
                    j++;
                }
                if (str.charAt(j) != '\"') {
                    return -1;
                }
                int i3 = j + 1;
                int i4 = i3;
                while (i4 < str.length() && str.charAt(i4) != '\"' && str.charAt(i4) != ' ' && str.charAt(i4) != '\n') {
                    i4++;
                }
                return e(i3, i4, str);
            } else if (str.charAt(j) == ':') {
                int i5 = j + 1;
                while (i5 < str.length() - 3 && (str.charAt(i5) == ' ' || str.charAt(i5) == '\n')) {
                    i5++;
                }
                int i6 = i5 + 1;
                while (i6 < str.length() && str.charAt(i6) != ';' && str.charAt(i6) != ' ' && str.charAt(i6) != '\n' && str.charAt(i6) != '\"') {
                    i6++;
                }
                return e(i5, i6, str);
            } else if (str.charAt(j) == '\"') {
                return 1;
            } else {
                j++;
            }
        }
    }

    private final int j(String str, int i, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147936715")) {
            return ((Integer) ipChange.ipc$dispatch("1147936715", new Object[]{this, str, Integer.valueOf(i), str2, Integer.valueOf(i2)})).intValue();
        }
        k21.f(str);
        int length = str.length() - i;
        if (length < i2) {
            return -1;
        }
        int i3 = 0;
        while (i3 <= length - i2) {
            int i4 = 0;
            while (str.charAt(i3) == str2.charAt(i4)) {
                i4++;
                i3++;
                if (i4 == str2.length()) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    private final String k(String str, int i, String str2) {
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878057923")) {
            return (String) ipChange.ipc$dispatch("878057923", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        if (str.length() - i < str2.length() || (i2 = StringsKt__StringsKt.f0(str, "=", i, false, 4, null)) < 0 || (i3 = StringsKt__StringsKt.f0(str, "\"", i2, false, 4, null)) < 0 || (i4 = i3 + 1) > str.length() - 2) {
            return null;
        }
        while (i4 < str.length() - 2 && (str.charAt(i4) == ' ' || str.charAt(i4) == '\n')) {
            i4++;
        }
        int i5 = i4 + 1;
        while (i5 < str.length() - 1 && str.charAt(i5) != '\"' && str.charAt(i5) != ' ' && str.charAt(i5) != '\n') {
            i5++;
        }
        if (i5 > str.length() - 1) {
            return null;
        }
        String substring = str.substring(i4, i5);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final int h(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183766978")) {
            return ((Integer) ipChange.ipc$dispatch("1183766978", new Object[]{this, str, str2})).intValue();
        } else if (str == null) {
            return -1;
        } else {
            k21.f(str2);
            if (!(StringsKt__StringsKt.Q(str, str2, false, 2, null)) || !(StringsKt__StringsKt.Q(str, ";", false, 2, null))) {
                return -1;
            }
            String substring = str.substring(StringsKt__StringsKt.f0(str, str2, 0, false, 6, null));
            k21.h(substring, "this as java.lang.String).substring(startIndex)");
            if (substring == null || !(StringsKt__StringsKt.Q(substring, ";", false, 2, null))) {
                return -1;
            }
            String substring2 = substring.substring(0, StringsKt__StringsKt.f0(str, ";", 0, false, 6, null));
            k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return c(substring2);
        }
    }

    public final boolean l(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844938474")) {
            return ((Boolean) ipChange.ipc$dispatch("-1844938474", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            k21.f(str);
            if (StringsKt__StringsKt.Q(str, ".", false, 2, null)) {
                String substring = str.substring(StringsKt__StringsKt.l0(str, ".", 0, false, 6, null));
                k21.h(substring, "this as java.lang.String).substring(startIndex)");
                if (!TextUtils.isEmpty(substring)) {
                    String lowerCase = substring.toLowerCase();
                    k21.h(lowerCase, "this as java.lang.String).toLowerCase()");
                    if ((StringsKt__StringsKt.Q(lowerCase, "jpg", false, 2, null)) || (StringsKt__StringsKt.Q(lowerCase, "png", false, 2, null))) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0109 A[SYNTHETIC, Splitter:B:38:0x0109] */
    @NotNull
    public final fy0.b m(int i, @Nullable char[] cArr, int i2) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380093475")) {
            return (fy0.b) ipChange.ipc$dispatch("1380093475", new Object[]{this, Integer.valueOf(i), cArr, Integer.valueOf(i2)});
        }
        fy0.b bVar = new fy0.b();
        k21.f(cArr);
        String str = new String(cArr, 0, i2);
        if (i == 1) {
            bVar.m(i(str, 0));
            bVar.p(d(str, 0));
        } else if (i == 14) {
            bVar.r(b(str, 0, "href"));
            if (bVar.g() != null) {
                String g = bVar.g();
                k21.f(g);
                if (StringsKt__StringsKt.Q(g, "&", false, 2, null)) {
                    String g2 = bVar.g();
                    k21.f(g2);
                    bVar.r(o.F(g2, "&amp;", "&", false, 4, null));
                }
            }
        } else if (i != 15) {
            switch (i) {
                case 53:
                case 55:
                    bVar.l(a(false, str, 0));
                    break;
                case 54:
                    bVar.m(i(str, 0));
                    bVar.t(a(true, str, 0));
                    break;
            }
        } else {
            bVar.s(b(str, 0, "src"));
            if (bVar.h() != null) {
                String h = bVar.h();
                k21.f(h);
                if (StringsKt__StringsKt.Q(h, "&", false, 2, null)) {
                    String h2 = bVar.h();
                    k21.f(h2);
                    bVar.s(o.F(h2, "&amp;", "&", false, 4, null));
                }
            }
            bVar.l(a(false, str, 0));
            bVar.v(g(str));
            bVar.q(f(str));
            if (bVar.h() != null) {
                boolean l = l(bVar.h());
                if (l) {
                    try {
                        if (StringsKt__StringsKt.Q(str, "style", false, 2, null)) {
                            obj = null;
                            try {
                                String substring = str.substring(StringsKt__StringsKt.f0(str, "style", 0, false, 6, null));
                                k21.h(substring, "this as java.lang.String).substring(startIndex)");
                                bVar.o(h(substring, "damai_width:"));
                                bVar.n(h(substring, "damai_height:"));
                                if (bVar.d() > 0 || bVar.c() > 0) {
                                    l = false;
                                }
                            } catch (Exception unused) {
                            }
                            if (l) {
                                try {
                                    if ((StringsKt__StringsKt.Q(str, "damai_width", false, 2, obj)) && (StringsKt__StringsKt.Q(str, "damai_height", false, 2, obj))) {
                                        String substring2 = str.substring(StringsKt__StringsKt.f0(str, "damai_width", 0, false, 6, null));
                                        k21.h(substring2, "this as java.lang.String).substring(startIndex)");
                                        bVar.o(c(k(substring2, 0, "damai_width")));
                                        String substring3 = str.substring(StringsKt__StringsKt.f0(str, "damai_height", 0, false, 6, null));
                                        k21.h(substring3, "this as java.lang.String).substring(startIndex)");
                                        bVar.n(c(k(substring3, 0, "damai_height")));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(bVar.d());
                            sb.append('*');
                            sb.append(bVar.c());
                            Log.d("AttrParser", sb.toString());
                        }
                    } catch (Exception unused2) {
                    }
                }
                obj = null;
                if (l) {
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bVar.d());
                sb2.append('*');
                sb2.append(bVar.c());
                Log.d("AttrParser", sb2.toString());
            }
        }
        return bVar;
    }
}
