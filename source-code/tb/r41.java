package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public class r41 {
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(@NonNull Class<T> cls, @Nullable JSONObject jSONObject, @NonNull String str, @Nullable T t) {
        String str2;
        if (jSONObject == null || jSONObject.get(str) == null) {
            return t;
        }
        T t2 = null;
        if (cls == String.class) {
            try {
                str2 = jSONObject.getString(str);
            } catch (Exception unused) {
            }
        } else {
            str2 = jSONObject.getObject(str, cls);
        }
        t2 = str2;
        return t2 != null ? t2 : t;
    }

    public static boolean b(@Nullable JSONObject jSONObject, @NonNull String str, boolean z) {
        return ((Boolean) a(Boolean.class, jSONObject, str, Boolean.valueOf(z))).booleanValue();
    }

    public static String c(@Nullable JSONObject jSONObject, @NonNull String str, @Nullable String str2) {
        return (String) a(String.class, jSONObject, str, str2);
    }
}
