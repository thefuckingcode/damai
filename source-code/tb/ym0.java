package tb;

import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class ym0 {
    private static ym0 b = new ym0();
    private ConcurrentHashMap<String, Typeface> a = new ConcurrentHashMap<>();

    public static ym0 a() {
        return b;
    }

    public Typeface b(String str, Typeface typeface) {
        Typeface typeface2 = this.a.get(str);
        if (typeface2 != null) {
            return typeface2;
        }
        this.a.put(str, typeface);
        return typeface;
    }
}
