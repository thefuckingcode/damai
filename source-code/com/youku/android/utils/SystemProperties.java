package com.youku.android.utils;

import android.content.Context;
import tb.gl1;

/* compiled from: Taobao */
public class SystemProperties {
    public static String getPropString(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
