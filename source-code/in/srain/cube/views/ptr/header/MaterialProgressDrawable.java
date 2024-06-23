package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.ArrayList;
import tb.sv1;

/* compiled from: Taobao */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;
    private static final Interpolator o = new LinearInterpolator();
    private static final Interpolator p = new d(null);
    private static final Interpolator q = new f(null);
    private static final Interpolator r = new AccelerateDecelerateInterpolator();
    private final int[] a;
    private final ArrayList<Animation> b = new ArrayList<>();
    private final e c;
    private final Drawable.Callback d;
    private float e;
    private Resources f;
    private View g;
    private Animation h;
    private float i;
    private double j;
    private double k;
    private Animation l;
    private int m;
    private ShapeDrawable n;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            RadialGradient radialGradient = new RadialGradient((float) (i3 / 2), (float) (i3 / 2), (float) this.mShadowRadius, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            float width = (float) (Rect.width(MaterialProgressDrawable.this.getBounds()) / 2);
            float height = (float) (Rect.height(MaterialProgressDrawable.this.getBounds()) / 2);
            canvas.drawCircle(width, height, (float) ((this.mCircleDiameter / 2) + this.mShadowRadius), this.mShadowPaint);
            canvas.drawCircle(width, height, (float) (this.mCircleDiameter / 2), paint);
        }
    }

    /* compiled from: Taobao */
    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Animation.AnimationListener {
        final /* synthetic */ e a;

        b(e eVar) {
            this.a = eVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.a.k();
            this.a.B();
            this.a.y(false);
            MaterialProgressDrawable.this.g.startAnimation(MaterialProgressDrawable.this.h);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements Animation.AnimationListener {
        final /* synthetic */ e a;

        c(e eVar) {
            this.a = eVar;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.a.B();
            this.a.k();
            e eVar = this.a;
            eVar.z(eVar.e());
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            materialProgressDrawable.i = (materialProgressDrawable.i + 1.0f) % 5.0f;
        }

        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.i = 0.0f;
        }
    }

    /* compiled from: Taobao */
    private static class d extends AccelerateDecelerateInterpolator {
        private d() {
        }

        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e {
        private final RectF a = new RectF();
        private final Paint b;
        private final Paint c;
        private final Drawable.Callback d;
        private final Paint e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private int[] k;
        private int l;
        private float m;
        private float n;
        private float o;
        private boolean p;
        private Path q;
        private float r;
        private double s;
        private int t;
        private int u;
        private int v;
        private int w;

        public e(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            Paint paint3 = new Paint();
            this.e = paint3;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.i = 5.0f;
            this.j = 2.5f;
            this.d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setAntiAlias(true);
        }

        private void b(Canvas canvas, float f2, float f3, android.graphics.Rect rect) {
            if (this.p) {
                Path path = this.q;
                if (path == null) {
                    Path path2 = new Path();
                    this.q = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f4 = ((float) (((int) this.j) / 2)) * this.r;
                float sin = (float) ((this.s * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.q.moveTo(0.0f, 0.0f);
                this.q.lineTo(((float) this.t) * this.r, 0.0f);
                Path path3 = this.q;
                float f5 = this.r;
                path3.lineTo((((float) this.t) * f5) / 2.0f, ((float) this.u) * f5);
                this.q.offset(((float) ((this.s * Math.cos(0.0d)) + ((double) rect.exactCenterX()))) - f4, sin);
                this.q.close();
                this.c.setColor(this.k[this.l]);
                this.c.setAlpha(this.v);
                canvas.rotate((f2 + f3) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.q, this.c);
            }
        }

        private void l() {
            this.d.invalidateDrawable(null);
        }

        public void A(float f2) {
            this.i = f2;
            this.b.setStrokeWidth(f2);
            l();
        }

        public void B() {
            this.m = this.f;
            this.n = this.g;
            this.o = this.h;
        }

        public void a(Canvas canvas, android.graphics.Rect rect) {
            this.e.setColor(this.w);
            this.e.setAlpha(this.v);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (Rect.width(rect) / 2), this.e);
            RectF rectF = this.a;
            rectF.set(rect);
            float f2 = this.j;
            rectF.inset(f2, f2);
            float f3 = this.f;
            float f4 = this.h;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.g + f4) * 360.0f) - f5;
            this.b.setColor(this.k[this.l]);
            this.b.setAlpha(this.v);
            canvas.drawArc(rectF, f5, f6, false, this.b);
            b(canvas, f5, f6, rect);
        }

        public int c() {
            return this.v;
        }

        public double d() {
            return this.s;
        }

        public float e() {
            return this.g;
        }

        public float f() {
            return this.f;
        }

        public float g() {
            return this.n;
        }

        public float h() {
            return this.o;
        }

        public float i() {
            return this.m;
        }

        public float j() {
            return this.i;
        }

        public void k() {
            this.l = (this.l + 1) % this.k.length;
        }

        public void m() {
            this.m = 0.0f;
            this.n = 0.0f;
            this.o = 0.0f;
            z(0.0f);
            v(0.0f);
            x(0.0f);
        }

        public void n(int i2) {
            this.v = i2;
        }

        public void o(float f2, float f3) {
            this.t = (int) f2;
            this.u = (int) f3;
        }

        public void p(float f2) {
            if (f2 != this.r) {
                this.r = f2;
                l();
            }
        }

        public void q(int i2) {
            this.w = i2;
        }

        public void r(double d2) {
            this.s = d2;
        }

        public void s(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
            l();
        }

        public void t(int i2) {
            this.l = i2;
        }

        public void u(int[] iArr) {
            this.k = iArr;
            t(0);
        }

        public void v(float f2) {
            this.g = f2;
            l();
        }

        public void w(int i2, int i3) {
            double d2;
            float min = (float) Math.min(i2, i3);
            double d3 = this.s;
            if (d3 <= 0.0d || min < 0.0f) {
                d2 = Math.ceil((double) (this.i / 2.0f));
            } else {
                d2 = ((double) (min / 2.0f)) - d3;
            }
            this.j = (float) d2;
        }

        public void x(float f2) {
            this.h = f2;
            l();
        }

        public void y(boolean z) {
            if (this.p != z) {
                this.p = z;
                l();
            }
        }

        public void z(float f2) {
            this.f = f2;
            l();
        }
    }

    /* compiled from: Taobao */
    private static class f extends AccelerateDecelerateInterpolator {
        private f() {
        }

        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        int[] iArr = {-3591113, -13149199, -536002, -13327536};
        this.a = iArr;
        a aVar = new a();
        this.d = aVar;
        this.g = view;
        this.f = context.getResources();
        e eVar = new e(aVar);
        this.c = eVar;
        eVar.u(iArr);
        q(1);
        o();
    }

    private void l(double d2, double d3, double d4, double d5, float f2, float f3) {
        e eVar = this.c;
        float f4 = this.f.getDisplayMetrics().density;
        double d6 = (double) f4;
        this.j = d2 * d6;
        this.k = d3 * d6;
        eVar.A(((float) d5) * f4);
        eVar.r(d4 * d6);
        eVar.t(0);
        eVar.o(f2 * f4, f3 * f4);
        eVar.w((int) this.j, (int) this.k);
        n(this.j);
    }

    private void n(double d2) {
        sv1.b(this.g.getContext());
        int a2 = sv1.a(1.75f);
        int a3 = sv1.a(0.0f);
        int a4 = sv1.a(3.5f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShadow(a4, (int) d2));
        this.n = shapeDrawable;
        if (Build.VERSION.SDK_INT >= 11) {
            this.g.setLayerType(1, shapeDrawable.getPaint());
        }
        this.n.getPaint().setShadowLayer((float) a4, (float) a3, (float) a2, ConfigReporter.INSTANCE_ROUTE_MASK);
    }

    private void o() {
        final e eVar = this.c;
        AnonymousClass2 r1 = new Animation() {
            /* class in.srain.cube.views.ptr.header.MaterialProgressDrawable.AnonymousClass2 */

            public void applyTransformation(float f, Transformation transformation) {
                float floor = (float) (Math.floor((double) (eVar.h() / 0.8f)) + 1.0d);
                eVar.z(eVar.i() + ((eVar.g() - eVar.i()) * f));
                eVar.x(eVar.h() + ((floor - eVar.h()) * f));
                eVar.p(1.0f - f);
            }
        };
        r1.setInterpolator(r);
        r1.setDuration(666);
        r1.setAnimationListener(new b(eVar));
        AnonymousClass4 r2 = new Animation() {
            /* class in.srain.cube.views.ptr.header.MaterialProgressDrawable.AnonymousClass4 */

            public void applyTransformation(float f, Transformation transformation) {
                float radians = (float) Math.toRadians(((double) eVar.j()) / (eVar.d() * 6.283185307179586d));
                float g = eVar.g();
                float i = eVar.i();
                float h = eVar.h();
                eVar.v(g + ((0.8f - radians) * MaterialProgressDrawable.q.getInterpolation(f)));
                eVar.z(i + (MaterialProgressDrawable.p.getInterpolation(f) * 0.8f));
                eVar.x(h + (0.25f * f));
                MaterialProgressDrawable.this.k((f * 144.0f) + ((MaterialProgressDrawable.this.i / 5.0f) * 720.0f));
            }
        };
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(o);
        r2.setDuration(1333);
        r2.setAnimationListener(new c(eVar));
        this.l = r1;
        this.h = r2;
    }

    public void draw(Canvas canvas) {
        ShapeDrawable shapeDrawable = this.n;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(this.m);
            this.n.draw(canvas);
        }
        android.graphics.Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.e, bounds.exactCenterX(), bounds.exactCenterY());
        this.c.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void g(float f2) {
        this.c.p(f2);
    }

    public int getAlpha() {
        return this.c.c();
    }

    public int getIntrinsicHeight() {
        return (int) this.k;
    }

    public int getIntrinsicWidth() {
        return (int) this.j;
    }

    public int getOpacity() {
        return -3;
    }

    public void h(int i2) {
        this.m = i2;
        this.c.q(i2);
    }

    public void i(int... iArr) {
        this.c.u(iArr);
        this.c.t(0);
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = arrayList.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f2) {
        this.c.x(f2);
    }

    /* access modifiers changed from: package-private */
    public void k(float f2) {
        this.e = f2;
        invalidateSelf();
    }

    public void m(float f2, float f3) {
        this.c.z(f2);
        this.c.v(f3);
    }

    public void p(boolean z) {
        this.c.y(z);
    }

    public void q(int i2) {
        if (i2 == 0) {
            l(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            l(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void setAlpha(int i2) {
        this.c.n(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c.s(colorFilter);
    }

    public void start() {
        this.h.reset();
        this.c.B();
        if (this.c.e() != this.c.f()) {
            this.g.startAnimation(this.l);
            return;
        }
        this.c.t(0);
        this.c.m();
        this.g.startAnimation(this.h);
    }

    public void stop() {
        this.g.clearAnimation();
        k(0.0f);
        this.c.y(false);
        this.c.t(0);
        this.c.m();
    }
}
