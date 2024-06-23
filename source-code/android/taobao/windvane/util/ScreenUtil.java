package android.taobao.windvane.util;

import android.content.res.Resources;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;

/* compiled from: Taobao */
public class ScreenUtil {
    public static int getScreenHeight() {
        return DisplayMetrics.getheightPixels(Resources.getSystem().getDisplayMetrics());
    }

    public static int getScreenWidth() {
        return DisplayMetrics.getwidthPixels(Resources.getSystem().getDisplayMetrics());
    }
}
