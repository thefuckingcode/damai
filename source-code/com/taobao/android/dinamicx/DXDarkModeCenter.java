package com.taobao.android.dinamicx;

import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public class DXDarkModeCenter {
    public static final int DRAW_TYPE_BACKGROUND = 1;
    public static final int DRAW_TYPE_TEXT = 0;
    public static final int DRAW_TYPE_UNSPECIFIED = 2;
    static boolean a;
    static IDXDarkModeInterface b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXDrawType {
    }

    public static void a(View view) {
        if (b()) {
            b.disableForceDark(view);
        } else if (Build.VERSION.SDK_INT >= 29) {
            view.setForceDarkAllowed(false);
        }
    }

    public static boolean b() {
        return b != null;
    }

    public static boolean c() {
        if (DinamicXEngine.i() == null) {
            return false;
        }
        if (b()) {
            return b.isDark(DinamicXEngine.i());
        }
        if ((DinamicXEngine.i().getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        return a;
    }

    @ColorInt
    public static int e(int i, @ColorInt int i2) {
        IDXDarkModeInterface iDXDarkModeInterface = b;
        return iDXDarkModeInterface != null ? iDXDarkModeInterface.switchDarkModeColor(i, i2) : i2;
    }
}
