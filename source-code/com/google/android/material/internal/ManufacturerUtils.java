package com.google.android.material.internal;

import androidx.annotation.RestrictTo;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: Taobao */
public class ManufacturerUtils {
    private static final String LGE = "lge";
    private static final String MEIZU = "meizu";
    private static final String SAMSUNG = "samsung";

    private ManufacturerUtils() {
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        return isLGEDevice() || isSamsungDevice();
    }

    public static boolean isLGEDevice() {
        return Build.getMANUFACTURER().toLowerCase(Locale.ENGLISH).equals(LGE);
    }

    public static boolean isMeizuDevice() {
        return Build.getMANUFACTURER().toLowerCase(Locale.ENGLISH).equals("meizu");
    }

    public static boolean isSamsungDevice() {
        return Build.getMANUFACTURER().toLowerCase(Locale.ENGLISH).equals(SAMSUNG);
    }
}
