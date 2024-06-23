package tb;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
public class pb2 {
    public static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    public static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int c(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            double d2 = (double) i2;
            return ((double) i) * d > d2 ? (int) (d2 / d) : i;
        }
    }

    public static int d(int i) {
        return i & 65535;
    }

    public static int e(int i) {
        return (i & SupportMenu.CATEGORY_MASK) >> 16;
    }

    public static int f(int i, int i2) {
        return (i << 16) | (i2 & 65535);
    }
}
