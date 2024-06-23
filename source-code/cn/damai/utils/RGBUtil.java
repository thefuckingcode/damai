package cn.damai.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import tb.gl2;

/* compiled from: Taobao */
public class RGBUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static a a = new a();
    private static HashMap<String, Integer> b = new HashMap<>();

    /* compiled from: Taobao */
    public interface OnFetchColorListener {
        void onFetchColor(int i);
    }

    /* compiled from: Taobao */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }
    }

    private static int c(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537121930")) {
            return ((Integer) ipChange.ipc$dispatch("537121930", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        int round = Math.round(f * 255.0f);
        if (((double) f4) <= 0.35d) {
            return Color.argb(round, Integer.valueOf("53", 16).intValue(), Integer.valueOf("63", 16).intValue(), Integer.valueOf("88", 16).intValue());
        }
        if (((double) f3) <= 0.05d) {
            return Color.argb(round, Integer.valueOf("6E", 16).intValue(), Integer.valueOf("82", 16).intValue(), Integer.valueOf("AB", 16).intValue());
        }
        String str = "49";
        if (f2 <= 10.0f) {
            return Color.argb(round, Integer.valueOf("E6", 16).intValue(), Integer.valueOf("55", 16).intValue(), Integer.valueOf(str, 16).intValue());
        }
        if (f2 <= 30.0f) {
            return Color.argb(round, Integer.valueOf("E8", 16).intValue(), Integer.valueOf("79", 16).intValue(), Integer.valueOf("34", 16).intValue());
        }
        if (f2 <= 50.0f) {
            return Color.argb(round, Integer.valueOf("EE", 16).intValue(), Integer.valueOf("A4", 16).intValue(), Integer.valueOf("46", 16).intValue());
        }
        if (f2 <= 150.0f) {
            return Color.argb(round, Integer.valueOf("89", 16).intValue(), Integer.valueOf("B9", 16).intValue(), Integer.valueOf("59", 16).intValue());
        }
        if (f2 <= 180.0f) {
            return Color.argb(round, Integer.valueOf("4E", 16).intValue(), Integer.valueOf(UCCore.OPTION_HARDWARE_ACCELERATED, 16).intValue(), Integer.valueOf("98", 16).intValue());
        }
        if (f2 <= 200.0f) {
            return Color.argb(round, Integer.valueOf(gl2.PERFORM_CANCEL, 16).intValue(), Integer.valueOf("AA", 16).intValue(), Integer.valueOf("C8", 16).intValue());
        }
        if (f2 <= 230.0f) {
            return Color.argb(round, Integer.valueOf("3F", 16).intValue(), Integer.valueOf("96", 16).intValue(), Integer.valueOf("D8", 16).intValue());
        }
        if (f2 <= 250.0f) {
            return Color.argb(round, Integer.valueOf("71", 16).intValue(), Integer.valueOf("76", 16).intValue(), Integer.valueOf("D4", 16).intValue());
        }
        if (f2 <= 280.0f) {
            return Color.argb(round, Integer.valueOf("96", 16).intValue(), Integer.valueOf("5B", 16).intValue(), Integer.valueOf("BD", 16).intValue());
        }
        if (f2 <= 340.0f) {
            i2 = Integer.valueOf("DE", 16).intValue();
            i3 = Integer.valueOf("3F", 16).intValue();
            str = "64";
        } else {
            i2 = Integer.valueOf("E6", 16).intValue();
            i3 = Integer.valueOf("55", 16).intValue();
        }
        return Color.argb(round, i2, i3, Integer.valueOf(str, 16).intValue());
    }

    @Deprecated
    public static int d(@FloatRange(from = 0.0d, to = 1.0d) float f, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366228917")) {
            return ((Integer) ipChange.ipc$dispatch("1366228917", new Object[]{Float.valueOf(f), bitmap})).intValue();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i2 += Color.red(iArr[i6]);
            i3 += Color.green(iArr[i6]);
            i4 += Color.blue(iArr[i6]);
            i5 += Color.alpha(iArr[i6]);
        }
        return c(f, Color.argb(i5 / i, i2 / i, i3 / i, i4 / i));
    }

    @Deprecated
    public static int e(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-758969779")) {
            return d(1.0f, bitmap);
        }
        return ((Integer) ipChange.ipc$dispatch("-758969779", new Object[]{bitmap})).intValue();
    }
}
