package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.m;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.k61;
import tb.l61;
import tb.lb1;
import tb.m92;
import tb.o91;
import tb.pa1;
import tb.xt2;
import tb.z51;

/* compiled from: Taobao */
public abstract class a implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new l61(1);
    private final Paint d = new l61(1, PorterDuff.Mode.DST_IN);
    private final Paint e = new l61(1, PorterDuff.Mode.DST_OUT);
    private final Paint f;
    private final Paint g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final String l;
    final Matrix m;
    final LottieDrawable n;
    final Layer o;
    @Nullable
    private lb1 p;
    @Nullable
    private com.airbnb.lottie.animation.keyframe.b q;
    @Nullable
    private a r;
    @Nullable
    private a s;
    private List<a> t;
    private final List<BaseKeyframeAnimation<?, ?>> u;
    final m v;
    private boolean w;
    private boolean x;
    @Nullable
    private Paint y;

    /* access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0068a implements BaseKeyframeAnimation.AnimationListener {
        C0068a() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
        public void onValueChanged() {
            a aVar = a.this;
            aVar.C(aVar.q.p() == 1.0f);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            a[Layer.LayerType.SOLID.ordinal()] = 3;
            a[Layer.LayerType.IMAGE.ordinal()] = 4;
            a[Layer.LayerType.NULL.ordinal()] = 5;
            a[Layer.LayerType.TEXT.ordinal()] = 6;
            try {
                a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    a(LottieDrawable lottieDrawable, Layer layer) {
        l61 l61 = new l61(1);
        this.f = l61;
        this.g = new l61(PorterDuff.Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = lottieDrawable;
        this.o = layer;
        this.l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            l61.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            l61.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        m a2 = layer.u().a();
        this.v = a2;
        a2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            lb1 lb1 = new lb1(layer.e());
            this.p = lb1;
            for (BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation : lb1.a()) {
                baseKeyframeAnimation.a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.p.c()) {
                c(baseKeyframeAnimation2);
                baseKeyframeAnimation2.a(this);
            }
        }
        D();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C(boolean z) {
        if (z != this.w) {
            this.w = z;
            u();
        }
    }

    private void D() {
        boolean z = true;
        if (!this.o.c().isEmpty()) {
            com.airbnb.lottie.animation.keyframe.b bVar = new com.airbnb.lottie.animation.keyframe.b(this.o.c());
            this.q = bVar;
            bVar.l();
            this.q.a(new C0068a());
            if (((Float) this.q.h()).floatValue() != 1.0f) {
                z = false;
            }
            C(z);
            c(this.q);
            return;
        }
        C(true);
    }

    private void d(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    private void e(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        xt2.m(canvas, this.h, this.d);
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void f(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        xt2.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void g(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        xt2.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void h(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        xt2.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void i(Canvas canvas, Matrix matrix) {
        k61.a("Layer#saveLayer");
        xt2.n(canvas, this.h, this.d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            m(canvas);
        }
        k61.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            Mask mask = this.p.b().get(i2);
            BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation = this.p.a().get(i2);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.p.c().get(i2);
            int i3 = b.b[mask.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.c.setColor(-16777216);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.h, this.c);
                    }
                    if (mask.d()) {
                        h(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        j(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (mask.d()) {
                            f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.d()) {
                    g(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (k()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.h, this.c);
            }
        }
        k61.a("Layer#restoreLayer");
        canvas.restore();
        k61.b("Layer#restoreLayer");
    }

    private void j(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<m92, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    private boolean k() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void l() {
        if (this.t == null) {
            if (this.s == null) {
                this.t = Collections.emptyList();
                return;
            }
            this.t = new ArrayList();
            for (a aVar = this.s; aVar != null; aVar = aVar.s) {
                this.t.add(aVar);
            }
        }
    }

    private void m(Canvas canvas) {
        k61.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        k61.b("Layer#clearLayer");
    }

    @Nullable
    static a o(Layer layer, LottieDrawable lottieDrawable, com.airbnb.lottie.a aVar) {
        switch (b.a[layer.d().ordinal()]) {
            case 1:
                return new e(lottieDrawable, layer);
            case 2:
                return new b(lottieDrawable, layer, aVar.n(layer.k()), aVar);
            case 3:
                return new f(lottieDrawable, layer);
            case 4:
                return new c(lottieDrawable, layer);
            case 5:
                return new d(lottieDrawable, layer);
            case 6:
                return new g(lottieDrawable, layer);
            default:
                o91.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void s(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (q()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                Mask mask = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).h());
                this.a.transform(matrix);
                int i3 = b.b[mask.a().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    if ((i3 != 3 && i3 != 4) || !mask.d()) {
                        this.a.computeBounds(this.k, false);
                        if (i2 == 0) {
                            this.i.set(this.k);
                        } else {
                            RectF rectF2 = this.i;
                            rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void t(RectF rectF, Matrix matrix) {
        if (r() && this.o.f() != Layer.MatteType.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.getBounds(this.j, matrix, true);
            if (!rectF.intersect(this.j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void u() {
        this.n.invalidateSelf();
    }

    private void v(float f2) {
        this.n.getComposition().m().a(this.o.g(), f2);
    }

    /* access modifiers changed from: package-private */
    public void A(@Nullable a aVar) {
        this.s = aVar;
    }

    /* access modifiers changed from: package-private */
    public void B(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).m(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        com.airbnb.lottie.animation.keyframe.b bVar = this.q;
        if (bVar != null) {
            bVar.m(f2 / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.B(aVar.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).m(f2);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t2, @Nullable pa1<T> pa1) {
        this.v.c(t2, pa1);
    }

    public void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.u.add(baseKeyframeAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        k61.a(this.l);
        if (!this.w || this.o.v()) {
            k61.b(this.l);
            return;
        }
        l();
        k61.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.b.preConcat(this.t.get(size).v.f());
        }
        k61.b("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) (this.v.h() == null ? 100 : this.v.h().h().intValue()))) / 100.0f) * 255.0f);
        if (r() || q()) {
            k61.a("Layer#computeBounds");
            getBounds(this.h, this.b, false);
            t(this.h, matrix);
            this.b.preConcat(this.v.f());
            s(this.h, this.b);
            if (!this.h.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            k61.b("Layer#computeBounds");
            if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
                k61.a("Layer#saveLayer");
                this.c.setAlpha(255);
                xt2.m(canvas, this.h, this.c);
                k61.b("Layer#saveLayer");
                m(canvas);
                k61.a("Layer#drawLayer");
                n(canvas, this.b, intValue);
                k61.b("Layer#drawLayer");
                if (q()) {
                    i(canvas, this.b);
                }
                if (r()) {
                    k61.a("Layer#drawMatte");
                    k61.a("Layer#saveLayer");
                    xt2.n(canvas, this.h, this.f, 19);
                    k61.b("Layer#saveLayer");
                    m(canvas);
                    this.r.draw(canvas, matrix, intValue);
                    k61.a("Layer#restoreLayer");
                    canvas.restore();
                    k61.b("Layer#restoreLayer");
                    k61.b("Layer#drawMatte");
                }
                k61.a("Layer#restoreLayer");
                canvas.restore();
                k61.b("Layer#restoreLayer");
            }
            if (this.x && (paint = this.y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.y.setColor(-251901);
                this.y.setStrokeWidth(4.0f);
                canvas.drawRect(this.h, this.y);
                this.y.setStyle(Paint.Style.FILL);
                this.y.setColor(1357638635);
                canvas.drawRect(this.h, this.y);
            }
            v(k61.b(this.l));
            return;
        }
        this.b.preConcat(this.v.f());
        k61.a("Layer#drawLayer");
        n(canvas, this.b, intValue);
        k61.b("Layer#drawLayer");
        v(k61.b(this.l));
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        l();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.o.g();
    }

    /* access modifiers changed from: package-private */
    public abstract void n(Canvas canvas, Matrix matrix, int i2);

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        u();
    }

    /* access modifiers changed from: package-private */
    public Layer p() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        lb1 lb1 = this.p;
        return lb1 != null && !lb1.a().isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.r != null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        a aVar = this.r;
        if (aVar != null) {
            z51 a2 = z512.a(aVar.getName());
            if (z51.c(this.r.getName(), i2)) {
                list.add(a2.i(this.r));
            }
            if (z51.h(getName(), i2)) {
                this.r.x(z51, z51.e(this.r.getName(), i2) + i2, list, a2);
            }
        }
        if (z51.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                z512 = z512.a(getName());
                if (z51.c(getName(), i2)) {
                    list.add(z512.i(this));
                }
            }
            if (z51.h(getName(), i2)) {
                x(z51, i2 + z51.e(getName(), i2), list, z512);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void w(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.u.remove(baseKeyframeAnimation);
    }

    /* access modifiers changed from: package-private */
    public void x(z51 z51, int i2, List<z51> list, z51 z512) {
    }

    /* access modifiers changed from: package-private */
    public void y(@Nullable a aVar) {
        this.r = aVar;
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z) {
        if (z && this.y == null) {
            this.y = new l61();
        }
        this.x = z;
    }
}
