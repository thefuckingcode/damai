package cn.damai.user.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import cn.damai.homepage.R$attr;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dg2;

/* compiled from: Taobao */
public class HighlightView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    RectF a;
    Rect b;
    Matrix c;
    private RectF d;
    private final Paint e = new Paint();
    private final Paint f = new Paint();
    private final Paint g = new Paint();
    private View h;
    private boolean i;
    private boolean j;
    private int k;
    private ModifyMode l = ModifyMode.None;
    private HandleMode m = HandleMode.Changing;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private boolean r;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum HandleMode {
        Changing,
        Always,
        Never
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.h = view;
        m(view.getContext());
    }

    private Rect a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321634746")) {
            return (Rect) ipChange.ipc$dispatch("321634746", new Object[]{this});
        }
        RectF rectF = this.a;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.c.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    private float b(float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1508248761")) {
            return f2 * this.h.getResources().getDisplayMetrics().density;
        }
        return ((Float) ipChange.ipc$dispatch("-1508248761", new Object[]{this, Float.valueOf(f2)})).floatValue();
    }

    private void d(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487363233")) {
            ipChange.ipc$dispatch("487363233", new Object[]{this, canvas});
            return;
        }
        this.f.setStrokeWidth(1.0f);
        canvas.drawOval(new RectF(this.b), this.f);
    }

    private void e(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147132474")) {
            ipChange.ipc$dispatch("1147132474", new Object[]{this, canvas});
            return;
        }
        Rect rect = this.b;
        int i2 = rect.left;
        int i3 = ((rect.right - i2) / 2) + i2;
        int i4 = rect.top;
        int i5 = i4 + ((rect.bottom - i4) / 2);
        float f2 = (float) i2;
        float f3 = (float) i5;
        canvas.drawCircle(f2, f3, this.p, this.g);
        float f4 = (float) i3;
        canvas.drawCircle(f4, (float) this.b.top, this.p, this.g);
        canvas.drawCircle((float) this.b.right, f3, this.p, this.g);
        canvas.drawCircle(f4, (float) this.b.bottom, this.p, this.g);
    }

    private void f(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233840022")) {
            ipChange.ipc$dispatch("233840022", new Object[]{this, canvas});
            return;
        }
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) this.b.top, this.e);
        canvas.drawRect(0.0f, (float) this.b.bottom, (float) canvas.getWidth(), (float) canvas.getHeight(), this.e);
        Rect rect = this.b;
        canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) rect.bottom, this.e);
        Rect rect2 = this.b;
        canvas.drawRect((float) rect2.right, (float) rect2.top, (float) canvas.getWidth(), (float) this.b.bottom, this.e);
    }

    private void g(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530624957")) {
            ipChange.ipc$dispatch("1530624957", new Object[]{this, canvas});
            return;
        }
        this.f.setStrokeWidth(1.0f);
        Rect rect = this.b;
        int i2 = rect.right;
        int i3 = rect.left;
        float f2 = (float) ((i2 - i3) / 3);
        int i4 = rect.bottom;
        int i5 = rect.top;
        float f3 = (float) ((i4 - i5) / 3);
        canvas.drawLine(((float) i3) + f2, (float) i5, ((float) i3) + f2, (float) i4, this.f);
        Rect rect2 = this.b;
        int i6 = rect2.left;
        float f4 = f2 * 2.0f;
        canvas.drawLine(((float) i6) + f4, (float) rect2.top, ((float) i6) + f4, (float) rect2.bottom, this.f);
        Rect rect3 = this.b;
        float f5 = (float) rect3.left;
        int i7 = rect3.top;
        canvas.drawLine(f5, ((float) i7) + f3, (float) rect3.right, ((float) i7) + f3, this.f);
        Rect rect4 = this.b;
        float f6 = (float) rect4.left;
        int i8 = rect4.top;
        float f7 = f3 * 2.0f;
        canvas.drawLine(f6, ((float) i8) + f7, (float) rect4.right, ((float) i8) + f7, this.f);
    }

    private void m(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636774686")) {
            ipChange.ipc$dispatch("-636774686", new Object[]{this, context});
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.cropImageStyle, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, R$styleable.CropImageView);
        try {
            this.i = obtainStyledAttributes.getBoolean(R$styleable.CropImageView_showThirds, false);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.CropImageView_showCircle, false);
            this.k = obtainStyledAttributes.getColor(R$styleable.CropImageView_highlightColor, dg2.holoBlueLight);
            this.m = HandleMode.values()[obtainStyledAttributes.getInt(R$styleable.CropImageView_showHandles, 0)];
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean o(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411863142")) {
            return ((Boolean) ipChange.ipc$dispatch("1411863142", new Object[]{this, canvas})).booleanValue();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 17) {
            return false;
        }
        if (i2 < 14 || i2 > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881335921")) {
            ipChange.ipc$dispatch("881335921", new Object[]{this, canvas});
            return;
        }
        canvas.save();
        Path path = new Path();
        this.f.setStrokeWidth(this.q);
        if (!l()) {
            this.f.setColor(-16777216);
            canvas.drawRect(this.b, this.f);
            return;
        }
        Rect rect = new Rect();
        this.h.getDrawingRect(rect);
        path.addRect(new RectF(this.b), Path.Direction.CW);
        this.f.setColor(this.k);
        if (o(canvas)) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.e);
        } else {
            f(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.f);
        if (this.i) {
            g(canvas);
        }
        if (this.j) {
            d(canvas);
        }
        HandleMode handleMode = this.m;
        if (handleMode == HandleMode.Always || (handleMode == HandleMode.Changing && this.l == ModifyMode.Grow)) {
            e(canvas);
        }
    }

    public int h(float f2, float f3) {
        IpChange ipChange = $ipChange;
        int i2 = 3;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "898862126")) {
            return ((Integer) ipChange.ipc$dispatch("898862126", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)})).intValue();
        }
        Rect a2 = a();
        boolean z2 = f3 >= ((float) a2.top) - 20.0f && f3 < ((float) a2.bottom) + 20.0f;
        int i3 = a2.left;
        if (f2 >= ((float) i3) - 20.0f && f2 < ((float) a2.right) + 20.0f) {
            z = true;
        }
        if (Math.abs(((float) i3) - f2) >= 20.0f || !z2) {
            i2 = 1;
        }
        if (Math.abs(((float) a2.right) - f2) < 20.0f && z2) {
            i2 |= 4;
        }
        if (Math.abs(((float) a2.top) - f3) < 20.0f && z) {
            i2 |= 8;
        }
        if (Math.abs(((float) a2.bottom) - f3) < 20.0f && z) {
            i2 |= 16;
        }
        if (i2 != 1 || !a2.contains((int) f2, (int) f3)) {
            return i2;
        }
        return 32;
    }

    public Rect i(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058153157")) {
            return (Rect) ipChange.ipc$dispatch("-1058153157", new Object[]{this, Float.valueOf(f2)});
        }
        RectF rectF = this.a;
        return new Rect((int) (rectF.left * f2), (int) (rectF.top * f2), (int) (rectF.right * f2), (int) (rectF.bottom * f2));
    }

    /* access modifiers changed from: package-private */
    public void j(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010528018")) {
            ipChange.ipc$dispatch("-1010528018", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        if (this.n) {
            if (f2 != 0.0f) {
                f3 = f2 / this.o;
            } else if (f3 != 0.0f) {
                f2 = this.o * f3;
            }
        }
        RectF rectF = new RectF(this.a);
        if (f2 > 0.0f && rectF.width() + (f2 * 2.0f) > this.d.width()) {
            f2 = (this.d.width() - rectF.width()) / 2.0f;
            if (this.n) {
                f3 = f2 / this.o;
            }
        }
        if (f3 > 0.0f && rectF.height() + (f3 * 2.0f) > this.d.height()) {
            f3 = (this.d.height() - rectF.height()) / 2.0f;
            if (this.n) {
                f2 = this.o * f3;
            }
        }
        rectF.inset(-f2, -f3);
        float f4 = 25.0f;
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.n) {
            f4 = 25.0f / this.o;
        }
        if (rectF.height() < f4) {
            rectF.inset(0.0f, (-(f4 - rectF.height())) / 2.0f);
        }
        float f5 = rectF.left;
        RectF rectF2 = this.d;
        float f6 = rectF2.left;
        if (f5 < f6) {
            rectF.offset(f6 - f5, 0.0f);
        } else {
            float f7 = rectF.right;
            float f8 = rectF2.right;
            if (f7 > f8) {
                rectF.offset(-(f7 - f8), 0.0f);
            }
        }
        float f9 = rectF.top;
        RectF rectF3 = this.d;
        float f10 = rectF3.top;
        if (f9 < f10) {
            rectF.offset(0.0f, f10 - f9);
        } else {
            float f11 = rectF.bottom;
            float f12 = rectF3.bottom;
            if (f11 > f12) {
                rectF.offset(0.0f, -(f11 - f12));
            }
        }
        this.a.set(rectF);
        this.b = a();
        this.h.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void k(int i2, float f2, float f3) {
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-791348599")) {
            ipChange.ipc$dispatch("-791348599", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        Rect a2 = a();
        if (i2 == 32) {
            p(f2 * (this.a.width() / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(a2))), f3 * (this.a.height() / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(a2))));
            return;
        }
        if ((i2 & 6) == 0) {
            f2 = 0.0f;
        }
        if ((i2 & 24) == 0) {
            f3 = 0.0f;
        }
        float width = f2 * (this.a.width() / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(a2)));
        float height = f3 * (this.a.height() / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(a2)));
        float f4 = ((float) ((i2 & 2) != 0 ? -1 : 1)) * width;
        if ((i2 & 8) != 0) {
            i3 = -1;
        }
        j(f4, ((float) i3) * height);
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1174419298")) {
            return this.r;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1174419298", new Object[]{this})).booleanValue();
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585608157")) {
            ipChange.ipc$dispatch("585608157", new Object[]{this});
            return;
        }
        this.b = a();
    }

    /* access modifiers changed from: package-private */
    public void p(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609111920")) {
            ipChange.ipc$dispatch("609111920", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        Rect rect = new Rect(this.b);
        this.a.offset(f2, f3);
        RectF rectF = this.a;
        rectF.offset(Math.max(0.0f, this.d.left - rectF.left), Math.max(0.0f, this.d.top - this.a.top));
        RectF rectF2 = this.a;
        rectF2.offset(Math.min(0.0f, this.d.right - rectF2.right), Math.min(0.0f, this.d.bottom - this.a.bottom));
        Rect a2 = a();
        this.b = a2;
        rect.union(a2);
        float f4 = this.p;
        rect.inset(-((int) f4), -((int) f4));
        this.h.invalidate(rect);
    }

    public void q(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578311346")) {
            ipChange.ipc$dispatch("578311346", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.r = z;
    }

    public void r(ModifyMode modifyMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648887530")) {
            ipChange.ipc$dispatch("-648887530", new Object[]{this, modifyMode});
        } else if (modifyMode != this.l) {
            this.l = modifyMode;
            this.h.invalidate();
        }
    }

    public void s(Matrix matrix, Rect rect, RectF rectF, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739309809")) {
            ipChange.ipc$dispatch("739309809", new Object[]{this, matrix, rect, rectF, Boolean.valueOf(z)});
            return;
        }
        this.c = new Matrix(matrix);
        this.a = rectF;
        this.d = new RectF(rect);
        this.n = z;
        this.o = this.a.width() / this.a.height();
        this.b = a();
        this.e.setARGB(125, 50, 50, 50);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setAntiAlias(true);
        this.q = b(2.0f);
        this.g.setColor(this.k);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.p = b(12.0f);
        this.l = ModifyMode.None;
    }
}
