package tb;

import android.text.TextUtils;
import com.uploader.implement.a.f;
import java.util.Map;

/* compiled from: Taobao */
public class f13 implements f {
    final int a;
    final Map<String, String> b;
    public final Object[] c;

    public f13(int i, Map<String, String> map, Object... objArr) {
        this.a = i;
        this.b = map;
        this.c = objArr;
    }

    public int a() {
        return this.a;
    }

    public String b(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.b) == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, String> c() {
        return this.b;
    }

    public f13(int i, Map<String, String> map) {
        this.a = i;
        this.b = map;
        this.c = null;
    }
}
