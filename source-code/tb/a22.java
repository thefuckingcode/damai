package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a22 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private Paint c;
    private RectF d;
    private RectF e;
    private Path f;
    private Path g;
    private Xfermode h;
    private boolean i;
    private float[] j;
    private float[] k;
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065826080")) {
            ipChange.ipc$dispatch("-2065826080", new Object[]{this});
            return;
        }
        float[] fArr = this.j;
        float f2 = this.p;
        float f3 = this.o;
        float f4 = f2 - f3;
        fArr[1] = f4;
        fArr[0] = f4;
        float f5 = this.q;
        float f6 = f5 - f3;
        fArr[3] = f6;
        fArr[2] = f6;
        float f7 = this.s;
        float f8 = f7 - f3;
        fArr[5] = f8;
        fArr[4] = f8;
        float f9 = this.r;
        float f10 = f9 - f3;
        fArr[7] = f10;
        fArr[6] = f10;
        float[] fArr2 = this.k;
        fArr2[1] = f2;
        fArr2[0] = f2;
        fArr2[3] = f5;
        fArr2[2] = f5;
        fArr2[5] = f7;
        fArr2[4] = f7;
        fArr2[7] = f9;
        fArr2[6] = f9;
    }

    public void a(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733821928")) {
            ipChange.ipc$dispatch("-1733821928", new Object[]{this, canvas});
            return;
        }
        this.c.reset();
        this.f.reset();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setXfermode(this.h);
        this.f.addRoundRect(this.d, this.j, Path.Direction.CCW);
        if (Build.VERSION.SDK_INT >= 19) {
            this.g.reset();
            this.g.addRect(this.d, Path.Direction.CCW);
            this.g.op(this.f, Path.Op.DIFFERENCE);
            canvas.drawPath(this.g, this.c);
        } else {
            canvas.drawPath(this.f, this.c);
        }
        this.c.setXfermode(null);
        canvas.restore();
        if (this.o > 0.0f) {
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(this.o);
            this.c.setColor(this.n);
            this.f.reset();
            this.f.addRoundRect(this.e, this.k, Path.Direction.CCW);
            canvas.drawPath(this.f, this.c);
        }
    }

    public void b(Context context, AttributeSet attributeSet, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588677754")) {
            ipChange.ipc$dispatch("-1588677754", new Object[]{this, context, attributeSet, view});
            return;
        }
        if ((view instanceof ViewGroup) && view.getBackground() == null) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
        }
        this.a = context;
        this.b = view;
        this.j = new float[8];
        this.k = new float[8];
        this.c = new Paint();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Path();
        this.g = new Path();
        this.h = new PorterDuffXfermode(Build.VERSION.SDK_INT >= 19 ? PorterDuff.Mode.DST_OUT : PorterDuff.Mode.DST_IN);
        this.n = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundCorner);
        if (obtainStyledAttributes != null) {
            float dimension = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rRadius, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rLeftRadius, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rRightRadius, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rTopRadius, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rBottomRadius, dimension);
            int i2 = (dimension4 > 0.0f ? 1 : (dimension4 == 0.0f ? 0 : -1));
            this.p = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rTopLeftRadius, i2 > 0 ? dimension4 : dimension2);
            int i3 = R$styleable.RoundCorner_rTopRightRadius;
            if (i2 <= 0) {
                dimension4 = dimension3;
            }
            this.q = obtainStyledAttributes.getDimension(i3, dimension4);
            int i4 = R$styleable.RoundCorner_rBottomLeftRadius;
            int i5 = (dimension5 > 0.0f ? 1 : (dimension5 == 0.0f ? 0 : -1));
            if (i5 > 0) {
                dimension2 = dimension5;
            }
            this.r = obtainStyledAttributes.getDimension(i4, dimension2);
            int i6 = R$styleable.RoundCorner_rBottomRightRadius;
            if (i5 > 0) {
                dimension3 = dimension5;
            }
            this.s = obtainStyledAttributes.getDimension(i6, dimension3);
            this.o = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rStrokeWidth, 0.0f);
            this.n = obtainStyledAttributes.getColor(R$styleable.RoundCorner_rStrokeColor, this.n);
            obtainStyledAttributes.recycle();
            if (!this.i) {
                e();
            }
        }
    }

    public void c(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145900224")) {
            ipChange.ipc$dispatch("-1145900224", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.l = i2;
        this.m = i3;
        if (this.i) {
            float min = ((((float) Math.min(i3, i2)) * 1.0f) / 2.0f) - this.o;
            this.p = min;
            this.q = min;
            this.s = min;
            this.r = min;
            e();
        }
        RectF rectF = this.d;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, (float) i2, (float) i3);
        }
        RectF rectF2 = this.e;
        if (rectF2 != null) {
            float f2 = this.o;
            rectF2.set(f2 / 2.0f, f2 / 2.0f, ((float) i2) - (f2 / 2.0f), ((float) i3) - (f2 / 2.0f));
        }
    }

    public void d(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346078520")) {
            ipChange.ipc$dispatch("1346078520", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(this.d, null, 31);
        float f2 = this.o;
        if (f2 > 0.0f) {
            int i2 = this.l;
            int i3 = this.m;
            canvas.scale((((float) i2) - (f2 * 2.0f)) / ((float) i2), (((float) i3) - (f2 * 2.0f)) / ((float) i3), ((float) i2) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    public void f(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "383927520")) {
            ipChange.ipc$dispatch("383927520", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            float a2 = t50.a(context, f2);
            this.p = a2;
            this.q = a2;
            this.r = a2;
            this.s = a2;
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void g(float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113213152")) {
            ipChange.ipc$dispatch("113213152", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.p = t50.a(context, f2);
            this.q = t50.a(this.a, f3);
            this.r = t50.a(this.a, f4);
            this.s = t50.a(this.a, f5);
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void h(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248764395")) {
            ipChange.ipc$dispatch("1248764395", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            float a2 = t50.a(context, f2);
            this.r = a2;
            this.s = a2;
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void i(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165833582")) {
            ipChange.ipc$dispatch("-1165833582", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.r = t50.a(context, f2);
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void j(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746346521")) {
            ipChange.ipc$dispatch("-746346521", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.s = t50.a(context, f2);
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void k(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "231860999")) {
            ipChange.ipc$dispatch("231860999", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            float a2 = t50.a(context, f2);
            this.p = a2;
            this.r = a2;
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void l(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367487470")) {
            ipChange.ipc$dispatch("-367487470", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            float a2 = t50.a(context, f2);
            this.q = a2;
            this.s = a2;
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void m(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720358795")) {
            ipChange.ipc$dispatch("1720358795", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            float a2 = t50.a(context, f2);
            this.p = a2;
            this.q = a2;
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void n(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697634766")) {
            ipChange.ipc$dispatch("-697634766", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.p = t50.a(context, f2);
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void o(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882914887")) {
            ipChange.ipc$dispatch("882914887", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.q = t50.a(context, f2);
            View view = this.b;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412842954")) {
            ipChange.ipc$dispatch("-412842954", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.n = i2;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void q(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849658838")) {
            ipChange.ipc$dispatch("1849658838", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.o = t50.a(context, f2);
            if (this.b != null) {
                e();
                c(this.l, this.m);
                this.b.invalidate();
            }
        }
    }

    public void r(float f2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739483328")) {
            ipChange.ipc$dispatch("739483328", new Object[]{this, Float.valueOf(f2), Integer.valueOf(i2)});
            return;
        }
        Context context = this.a;
        if (context != null) {
            this.o = t50.a(context, f2);
            this.n = i2;
            if (this.b != null) {
                e();
                c(this.l, this.m);
                this.b.invalidate();
            }
        }
    }

    public void s(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596983937")) {
            ipChange.ipc$dispatch("596983937", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.a != null) {
            this.o = (float) i2;
            if (this.b != null) {
                e();
                c(this.l, this.m);
                this.b.invalidate();
            }
        }
    }
}
