package tb;

/* compiled from: Taobao */
public class xr0 {
    private static float a(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    private static float b(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float a = a(((float) ((i >> 16) & 255)) / 255.0f);
        float a2 = a(((float) ((i >> 8) & 255)) / 255.0f);
        float a3 = a(((float) (i & 255)) / 255.0f);
        float a4 = a(((float) ((i2 >> 16) & 255)) / 255.0f);
        float a5 = a(((float) ((i2 >> 8) & 255)) / 255.0f);
        float a6 = a3 + (f * (a(((float) (i2 & 255)) / 255.0f) - a3));
        return (Math.round(b(a + ((a4 - a) * f)) * 255.0f) << 16) | (Math.round((f2 + (((((float) ((i2 >> 24) & 255)) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(b(a2 + ((a5 - a2) * f)) * 255.0f) << 8) | Math.round(b(a6) * 255.0f);
    }
}
