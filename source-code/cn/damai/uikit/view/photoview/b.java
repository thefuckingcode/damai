package cn.damai.uikit.view.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static void a(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617152401")) {
            ipChange.ipc$dispatch("1617152401", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        } else if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static int b(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-646963896")) {
            return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        }
        return ((Integer) ipChange.ipc$dispatch("-646963896", new Object[]{Integer.valueOf(i)})).intValue();
    }

    static boolean c(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1442848641")) {
            return imageView.getDrawable() != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1442848641", new Object[]{imageView})).booleanValue();
    }

    static boolean d(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869310321")) {
            return ((Boolean) ipChange.ipc$dispatch("-1869310321", new Object[]{scaleType})).booleanValue();
        } else if (scaleType == null) {
            return false;
        } else {
            if (a.a[scaleType.ordinal()] != 1) {
                return true;
            }
            throw new IllegalStateException("Matrix scale type is not supported");
        }
    }
}
