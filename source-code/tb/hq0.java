package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hq0 {
    private boolean a;
    @Nullable
    private Path b;
    @Nullable
    private Paint c;
    @Nullable
    private float[] d;
    @Nullable
    private Path e;
    @Nullable
    private Paint f;
    private boolean g;
    @Nullable
    private float[] h;
    @Nullable
    private Integer i;
    @Nullable
    private Float j;

    private final void b(Canvas canvas, float f2, float f3) {
        Integer num = this.i;
        Float f4 = this.j;
        float[] fArr = this.h;
        if (num != null && f4 != null && fArr != null) {
            if (this.f == null) {
                Paint paint = new Paint(1);
                this.f = paint;
                paint.setStyle(Paint.Style.STROKE);
            }
            if (this.e == null) {
                this.e = new Path();
            }
            Paint paint2 = this.f;
            if (paint2 != null) {
                paint2.setStrokeWidth(f4.floatValue());
            }
            Paint paint3 = this.f;
            if (paint3 != null) {
                paint3.setColor(num.intValue());
            }
            if (this.g) {
                float f5 = (float) 2;
                RectF rectF = new RectF(f4.floatValue() / f5, f4.floatValue() / f5, f2 - (f4.floatValue() / f5), f3 - (f4.floatValue() / f5));
                Path path = this.e;
                if (path != null) {
                    path.addRoundRect(rectF, fArr, Path.Direction.CW);
                }
                this.g = false;
            }
            Path path2 = this.e;
            k21.f(path2);
            Paint paint4 = this.f;
            k21.f(paint4);
            canvas.drawPath(path2, paint4);
        }
    }

    private final void c(Canvas canvas, float f2, float f3) {
        float[] fArr = this.d;
        if (fArr != null) {
            if (this.c == null) {
                Paint paint = new Paint();
                this.c = paint;
                paint.setAntiAlias(true);
                Paint paint2 = this.c;
                if (paint2 != null) {
                    paint2.setStyle(Paint.Style.FILL);
                }
                Paint paint3 = this.c;
                if (paint3 != null) {
                    paint3.setColor(SupportMenu.CATEGORY_MASK);
                }
                Paint paint4 = this.c;
                if (paint4 != null) {
                    paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                }
            }
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.a) {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
                Path path = this.b;
                if (path != null) {
                    path.addRect(rectF, Path.Direction.CW);
                }
                Path path2 = this.b;
                if (path2 != null) {
                    path2.addRoundRect(rectF, fArr, Path.Direction.CCW);
                }
                this.a = false;
            }
            Path path3 = this.b;
            k21.f(path3);
            Paint paint5 = this.c;
            k21.f(paint5);
            canvas.drawPath(path3, paint5);
        }
    }

    public final void a(@Nullable Canvas canvas, float f2, float f3, @NotNull Function0<ur2> function0) {
        k21.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (canvas != null) {
            canvas.saveLayer(0.0f, 0.0f, f2, f3, null);
        }
        function0.invoke();
        if (canvas != null) {
            canvas.restore();
        }
    }

    public final boolean d(@Nullable Canvas canvas, float f2, float f3) {
        return canvas != null && f2 > 0.0f && f3 > 0.0f && !(this.d == null && (this.h == null || this.i == null || this.j == null));
    }

    public final void e(@Nullable Canvas canvas, float f2, float f3) {
        if (canvas != null) {
            c(canvas, f2, f3);
            b(canvas, f2, f3);
        }
    }

    public final void f(int i2, float f2, float f3, float f4, float f5, float f6) {
        float[] fArr = {f3, f3, f4, f4, f5, f5, f6, f6};
        ur2 ur2 = ur2.INSTANCE;
        g(i2, f2, fArr);
    }

    public final void g(int i2, float f2, @NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        this.i = Integer.valueOf(i2);
        this.j = Float.valueOf(f2);
        this.h = fArr;
        this.e = null;
        this.g = true;
    }

    public final void h(float f2, float f3, float f4, float f5) {
        float[] fArr = {f2, f2, f3, f3, f4, f4, f5, f5};
        ur2 ur2 = ur2.INSTANCE;
        i(fArr);
    }

    public final void i(@NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        this.d = fArr;
        this.b = null;
        this.a = true;
    }
}
