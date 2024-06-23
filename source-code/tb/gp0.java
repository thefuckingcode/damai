package tb;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXStyleConvert;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Regex;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class gp0 {
    @NotNull
    public static final gp0 INSTANCE = new gp0();
    @Nullable
    private static ConcurrentHashMap<String, Pattern> a;

    private gp0() {
    }

    private final String a(String str) {
        int hashCode = str.hashCode();
        return hashCode != 36 ? hashCode != 63 ? (hashCode == 94 && str.equals("^")) ? "\\^" : str : !str.equals("?") ? str : "\\?" : !str.equals("$") ? str : "\\$";
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
    @Nullable
    public final CharSequence b(@NotNull View view, @NotNull xq0 xq0, @NotNull JSONObject jSONObject, @NotNull String str) {
        Pattern pattern;
        Matcher matcher;
        Typeface u;
        ko0 a2;
        k21.i(view, "view");
        k21.i(xq0, "gxTemplateNode");
        k21.i(jSONObject, "templateData");
        k21.i(str, "data");
        JSONObject h = xq0.h(jSONObject);
        if (h == null) {
            return null;
        }
        String string = h.getString("highlight-tag");
        String string2 = h.getString("highlight-color");
        String string3 = h.getString("highlight-font-size");
        String string4 = h.getString("highlight-font-weight");
        String string5 = h.getString("highlight-font-family");
        if (string == null || !(!o.y(string))) {
            return null;
        }
        String a3 = a(string);
        ConcurrentHashMap<String, Pattern> concurrentHashMap = a;
        if (concurrentHashMap == null && concurrentHashMap == null) {
            a = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, Pattern> concurrentHashMap2 = a;
        if (concurrentHashMap2 != null) {
            k21.f(concurrentHashMap2);
            if (concurrentHashMap2.containsKey(a3)) {
                ConcurrentHashMap<String, Pattern> concurrentHashMap3 = a;
                k21.f(concurrentHashMap3);
                Pattern pattern2 = concurrentHashMap3.get(a3);
                k21.f(pattern2);
                pattern = pattern2;
                k21.h(pattern, "if (regexCache != null &…nvertTag]!!\n            }");
                matcher = pattern.matcher(str);
                SpannableString spannableString = new SpannableString(new Regex(a3).replace(str, ""));
                int i = 0;
                while (matcher.find()) {
                    i++;
                    int start = matcher.start() - ((i - 1) * 2);
                    int end = matcher.end() - (i * 2);
                    if (start < end) {
                        if (!(string2 == null || !(!o.y(string2)) || (a2 = ko0.Companion.a(string2)) == null)) {
                            spannableString.setSpan(new ForegroundColorSpan(a2.b(view.getContext())), start, end, 33);
                        }
                        if (string3 != null && (!o.y(string3))) {
                            spannableString.setSpan(new AbsoluteSizeSpan(nq0.Companion.d(string3).d()), start, end, 33);
                        }
                        if (string5 == null || !(!o.y(string5))) {
                            if (!(string4 == null || !(!o.y(string4)) || (u = GXStyleConvert.Companion.a().u(string4)) == null)) {
                                spannableString.setSpan(new StyleSpan(u.getStyle()), start, end, 33);
                            }
                        } else if (GXStyleConvert.Companion.a().o(string5) != null) {
                            spannableString.setSpan(new TypefaceSpan(string5), start, end, 33);
                        }
                    }
                }
                return spannableString;
            }
        }
        ConcurrentHashMap<String, Pattern> concurrentHashMap4 = a;
        k21.f(concurrentHashMap4);
        Pattern compile = Pattern.compile(a3 + "(.*?)" + a3);
        k21.h(compile, "compile(\"$convertTag${GX…GHT_REGEX}${convertTag}\")");
        concurrentHashMap4.put(a3, compile);
        ConcurrentHashMap<String, Pattern> concurrentHashMap5 = a;
        k21.f(concurrentHashMap5);
        Pattern pattern3 = concurrentHashMap5.get(a3);
        k21.f(pattern3);
        pattern = pattern3;
        k21.h(pattern, "if (regexCache != null &…nvertTag]!!\n            }");
        matcher = pattern.matcher(str);
        SpannableString spannableString2 = new SpannableString(new Regex(a3).replace(str, ""));
        int i2 = 0;
        while (matcher.find()) {
        }
        return spannableString2;
    }
}
