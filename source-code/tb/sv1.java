package tb;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;

/* compiled from: Taobao */
public class sv1 {
    public static int a;
    public static int b;
    public static float c;

    public static int a(float f) {
        return (int) ((f * c) + 0.5f);
    }

    public static void b(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
            a = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            b = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            c = displayMetrics.density;
        }
    }
}
