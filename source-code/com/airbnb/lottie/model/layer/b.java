package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
import tb.i5;
import tb.k61;
import tb.pa1;
import tb.xt2;
import tb.z51;

/* compiled from: Taobao */
public class b extends a {
    private final List<a> A = new ArrayList();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private Paint D = new Paint();
    @Nullable
    private Boolean E;
    @Nullable
    private Boolean F;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> z;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            iArr[Layer.MatteType.ADD.ordinal()] = 1;
            a[Layer.MatteType.INVERT.ordinal()] = 2;
        }
    }

    public b(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, com.airbnb.lottie.a aVar) {
        super(lottieDrawable, layer);
        int i;
        a aVar2;
        i5 s = layer.s();
        if (s != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = s.createAnimation();
            this.z = createAnimation;
            c(createAnimation);
            this.z.a(this);
        } else {
            this.z = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(aVar.j().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a o = a.o(layer2, lottieDrawable, aVar);
            if (o != null) {
                longSparseArray.put(o.p().b(), o);
                if (aVar3 != null) {
                    aVar3.y(o);
                    aVar3 = null;
                } else {
                    this.A.add(0, o);
                    int i2 = a.a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar3 = o;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            a aVar4 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (!(aVar4 == null || (aVar2 = (a) longSparseArray.get(aVar4.p().h())) == null)) {
                aVar4.A(aVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void B(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.B(f);
        if (this.z != null) {
            f = ((this.z.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.getComposition().e() + 0.01f);
        }
        if (this.z == null) {
            f -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).B(f);
        }
    }

    public boolean E() {
        if (this.F == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                a aVar = this.A.get(size);
                if (aVar instanceof e) {
                    if (aVar.q()) {
                        this.F = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).E()) {
                    this.F = Boolean.TRUE;
                    return true;
                }
            }
            this.F = Boolean.FALSE;
        }
        return this.F.booleanValue();
    }

    public boolean F() {
        if (this.E == null) {
            if (r()) {
                this.E = Boolean.TRUE;
                return true;
            }
            for (int size = this.A.size() - 1; size >= 0; size--) {
                if (this.A.get(size).r()) {
                    this.E = Boolean.TRUE;
                    return true;
                }
            }
            this.E = Boolean.FALSE;
        }
        return this.E.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        super.addValueCallback(t, pa1);
        if (t != LottieProperty.TIME_REMAP) {
            return;
        }
        if (pa1 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.z;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.n(null);
                return;
            }
            return;
        }
        n nVar = new n(pa1);
        this.z = nVar;
        nVar.a(this);
        c(this.z);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z2) {
        super.getBounds(rectF, matrix, z2);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).getBounds(this.B, this.m, true);
            rectF.union(this.B);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        k61.a("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, (float) this.o.j(), (float) this.o.i());
        matrix.mapRect(this.C);
        boolean z2 = this.n.isApplyingOpacityToLayersEnabled() && this.A.size() > 1 && i != 255;
        if (z2) {
            this.D.setAlpha(i);
            xt2.m(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (!this.C.isEmpty() ? canvas.clipRect(this.C) : true) {
                this.A.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        k61.b("CompositionLayer#draw");
    }

    /* access modifiers changed from: protected */
    @Override // com.airbnb.lottie.model.layer.a
    public void x(z51 z51, int i, List<z51> list, z51 z512) {
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            this.A.get(i2).resolveKeyPath(z51, i, list, z512);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void z(boolean z2) {
        super.z(z2);
        for (a aVar : this.A) {
            aVar.z(z2);
        }
    }
}
