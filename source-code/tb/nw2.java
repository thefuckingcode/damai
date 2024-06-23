package tb;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;

/* compiled from: Taobao */
public class nw2 {
    public static final int screenHeight;
    public static final int screenWidth;

    static {
        a();
        f();
        Display defaultDisplay = ((WindowManager) qs0.e().a().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        screenHeight = defaultDisplay.getHeight();
        screenWidth = defaultDisplay.getWidth();
    }

    private static int a() {
        return f70.a(48);
    }

    public static int[] b(View view, View view2) {
        int[] iArr = {0, 0};
        while (view != view2) {
            iArr[1] = iArr[1] + view.getTop();
            iArr[0] = iArr[0] + view.getLeft();
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return iArr;
    }

    public static View[] c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        View[] viewArr = new View[childCount];
        for (int i = 0; i < childCount; i++) {
            viewArr[i] = viewGroup.getChildAt(i);
        }
        return viewArr;
    }

    public static boolean d(View view, View view2) {
        int[] b = b(view, view2);
        int i = b[1];
        int height = b[1] + view.getHeight();
        int i2 = b[0];
        int width = b[0] + view.getWidth();
        if (i >= screenHeight || height <= 0 || width <= 0 || i2 >= screenWidth || height - i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean e(View view, View view2, float f) {
        zv2 a = zv2.a(view, view2);
        return ((float) ((a.b - a.a) * (a.d - a.c))) / ((float) (screenHeight * screenWidth)) > f;
    }

    private static int f() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return qs0.e().a().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            Log.d("ViewUtils", "get status bar height fail");
            e.printStackTrace();
            return f70.a(24);
        }
    }
}
