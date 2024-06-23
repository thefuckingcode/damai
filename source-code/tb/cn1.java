package tb;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class cn1 {
    public static boolean a(Activity activity) {
        boolean z;
        Exception e;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    public static void b(Activity activity, int i) {
        if (i == -1 || Build.VERSION.SDK_INT != 26 || !a(activity)) {
            try {
                activity.setRequestedOrientation(i);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (Build.VERSION.SDK_INT == 26) {
                    activity.setRequestedOrientation(-1);
                }
            }
        } else {
            activity.setRequestedOrientation(-1);
        }
    }
}
