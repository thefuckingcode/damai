package tb;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: Taobao */
public class h4 {
    private static h4 d;
    public float a;
    public int b;
    public int c;

    public static h4 a(Context context) {
        if (context == null) {
            return null;
        }
        h4 h4Var = d;
        if (h4Var != null) {
            return h4Var;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        h4 h4Var2 = new h4();
        d = h4Var2;
        h4Var2.a = displayMetrics.density;
        h4Var2.c = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        h4Var2.b = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        return h4Var2;
    }
}
