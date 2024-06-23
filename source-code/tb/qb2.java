package tb;

import android.content.Context;

/* compiled from: Taobao */
public class qb2 {
    public static int a(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) (context.getResources().getDisplayMetrics().density * f);
    }
}
