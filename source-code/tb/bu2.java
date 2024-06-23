package tb;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: Taobao */
public class bu2 {
    public static int dpToPx(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
