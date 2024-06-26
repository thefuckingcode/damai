package android.taobao.windvane.util;

import android.content.Context;
import android.content.MutableContextWrapper;

/* compiled from: Taobao */
public class WVContextUtil {
    public static Context getRealContext(Context context) {
        if (context == null) {
            return null;
        }
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }
}
