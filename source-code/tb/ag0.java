package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ag0 {
    public final String a;
    public final String b;
    public final JSONObject c;

    public ag0(String str, String str2, JSONObject jSONObject) {
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
    }

    public static ag0 a(@Nullable String str, @Nullable String str2) {
        return new ag0(str, str2, null);
    }

    public static ag0 b(@Nullable String str, @Nullable JSONObject jSONObject) {
        return new ag0(str, null, jSONObject);
    }

    public static boolean c(@Nullable ag0 ag0) {
        return ag0 != null && ((!TextUtils.isEmpty(ag0.b) && !"{}".equals(ag0.b)) || ag0.c != null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ag0.class != obj.getClass()) {
            return false;
        }
        ag0 ag0 = (ag0) obj;
        String str = this.a;
        if (str == null ? ag0.a != null : !str.equals(ag0.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = ag0.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
