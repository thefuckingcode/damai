package tb;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import java.util.List;

/* compiled from: Taobao */
public class he1 {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int f(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    static int g(float f, float f2) {
        return h((int) f, (int) f2);
    }

    private static int h(int i, int i2) {
        return i - (i2 * f(i, i2));
    }

    public static void i(m92 m92, Path path) {
        path.reset();
        PointF b = m92.b();
        path.moveTo(b.x, b.y);
        a.set(b.x, b.y);
        for (int i = 0; i < m92.a().size(); i++) {
            mp mpVar = m92.a().get(i);
            PointF a2 = mpVar.a();
            PointF b2 = mpVar.b();
            PointF c = mpVar.c();
            if (!a2.equals(a) || !b2.equals(c)) {
                path.cubicTo(a2.x, a2.y, b2.x, b2.y, c.x, c.y);
            } else {
                path.lineTo(c.x, c.y);
            }
            a.set(c.x, c.y);
        }
        if (m92.d()) {
            path.close();
        }
    }

    public static double j(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float k(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int l(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    public static void m(z51 z51, int i, List<z51> list, z51 z512, KeyPathElementContent keyPathElementContent) {
        if (z51.c(keyPathElementContent.getName(), i)) {
            list.add(z512.a(keyPathElementContent.getName()).i(keyPathElementContent));
        }
    }
}
