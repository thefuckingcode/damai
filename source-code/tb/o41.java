package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class o41 {
    public static final int ARRAY_INDEX_NO = -1;
    public static final double ERROR_RESULT_DOUBLE = -1.0d;
    public static final float ERROR_RESULT_FLOAT = -1.0f;
    public static final int ERROR_RESULT_INT = -1;
    public static final long ERROR_RESULT_LONG = -1;
    @NotNull
    public static final o41 INSTANCE = new o41();

    private o41() {
    }

    private final boolean d(String str) {
        return (str.length() > 0) && (StringsKt__StringsKt.Q(str, jl1.ARRAY_START_STR, false, 2, null));
    }

    private final int e(String str, int i) {
        try {
            Pattern pattern = zo0.a;
            Matcher matcher = pattern == null ? null : pattern.matcher(str);
            if (matcher == null || !matcher.find()) {
                return i;
            }
            String group = matcher.group();
            k21.h(group, "m.group()");
            return Integer.parseInt(group);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public final int a(@NotNull String str) {
        k21.i(str, "arrayKey");
        if (!d(str)) {
            return -1;
        }
        if (zo0.a == null) {
            zo0.a = Pattern.compile("(?<=\\[)(.+?)(?=\\])");
        }
        return e(str, -1);
    }

    @NotNull
    public final String b(@NotNull String str) {
        int i;
        k21.i(str, "arrayKey");
        if (!(str.length() > 0) || (i = StringsKt__StringsKt.f0(str, jl1.ARRAY_START_STR, 0, false, 6, null)) < 0) {
            return "";
        }
        String substring = str.substring(0, i);
        k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @Nullable
    public final Object c(@NotNull Object obj, @NotNull String str, int i) {
        k21.i(obj, "src");
        k21.i(str, "arrayIndexKey");
        String b = b(str);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.containsKey(b)) {
                JSONArray jSONArray = jSONObject.getJSONArray(b);
                if (jSONArray.size() > i) {
                    return jSONArray.get(i);
                }
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2.size() > i) {
                return jSONArray2.get(i);
            }
        }
        return null;
    }

    @NotNull
    public final String[] f(@NotNull String str) {
        String[] strArr;
        k21.i(str, "key");
        String[] strArr2 = new String[0];
        if (!(str.length() > 0)) {
            return strArr2;
        }
        int i = StringsKt__StringsKt.f0(str, ".", 0, false, 6, null);
        if (i == -1) {
            return new String[]{str};
        }
        int i2 = i + 1;
        if (i2 < str.length()) {
            String substring = str.substring(0, i);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = str.substring(i2);
            k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
            strArr = new String[]{substring, substring2};
        } else {
            String substring3 = str.substring(0, i);
            k21.h(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            strArr = new String[]{substring3};
        }
        return strArr;
    }
}
