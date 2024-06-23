package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import com.taobao.weex.common.Constants;
import java.util.Locale;
import tb.v;

/* compiled from: Taobao */
public class d {
    private static String a;
    private static String b;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (context == null) {
            return "";
        }
        a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            a = width + Constants.Name.X + height;
        }
        return a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
