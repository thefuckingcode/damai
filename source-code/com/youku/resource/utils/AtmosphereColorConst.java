package com.youku.resource.utils;

import android.graphics.Color;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class AtmosphereColorConst {
    public static String galleryGradientBottomColor;
    public static String galleryGradientTopColor;
    public static String homeHotWordTextColor = "#CCFFFFFF";
    private static boolean isDark;
    public static String navBgColor = "#1C2029";
    public static String navBgImg = "";
    public static String navBgSubColor = "#12FFFFFF";
    public static String navColor = "#FFFFFF";
    public static String navIconColor = "#FFFFFF";
    public static String navIndicatorColor = "#FFFFFF";
    public static String navSelectImg = "";
    public static String navSubColor = "#CCFFFFFF";
    public static String refreshBgColor;

    static {
        boolean isDarkMode = UIMode.getInstance().isDarkMode();
        isDark = isDarkMode;
        String str = "#21283c";
        refreshBgColor = isDarkMode ? str : "#2E4F7B";
        if (!isDarkMode) {
            str = "#2E4F7B";
        }
        galleryGradientTopColor = str;
        galleryGradientBottomColor = isDarkMode ? "#455a64" : "#ADE8EB";
    }

    public static boolean isDefaultColor(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Field[] fields = AtmosphereColorConst.class.getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (str.equalsIgnoreCase(field.getName()) && i == Color.parseColor((String) field.get(null))) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isDefaultColor(String str, String str2) {
        try {
            return isDefaultColor(str, Color.parseColor(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
