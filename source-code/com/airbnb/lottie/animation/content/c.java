package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.m;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;
import tb.l61;
import tb.o92;
import tb.pa1;
import tb.s5;
import tb.xt2;
import tb.z51;

/* compiled from: Taobao */
public class c implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<Content> h;
    private final LottieDrawable i;
    @Nullable
    private List<PathContent> j;
    @Nullable
    private m k;

    public c(LottieDrawable lottieDrawable, a aVar, o92 o92) {
        this(lottieDrawable, aVar, o92.b(), o92.c(), a(lottieDrawable, aVar, o92.a()), b(o92.a()));
    }

    private static List<Content> a(LottieDrawable lottieDrawable, a aVar, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2).toContent(lottieDrawable, aVar);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    static s5 b(List<ContentModel> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            ContentModel contentModel = list.get(i2);
            if (contentModel instanceof s5) {
                return (s5) contentModel;
            }
        }
        return null;
    }

    private boolean e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            if ((this.h.get(i3) instanceof DrawingContent) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        m mVar = this.k;
        if (mVar != null) {
            mVar.c(t, pa1);
        }
    }

    /* access modifiers changed from: package-private */
    public List<PathContent> c() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                Content content = this.h.get(i2);
                if (content instanceof PathContent) {
                    this.j.add((PathContent) content);
                }
            }
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public Matrix d() {
        m mVar = this.k;
        if (mVar != null) {
            return mVar.f();
        }
        this.c.reset();
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        if (!this.g) {
            this.c.set(matrix);
            m mVar = this.k;
            if (mVar != null) {
                this.c.preConcat(mVar.f());
                i2 = (int) ((((((float) (this.k.h() == null ? 100 : this.k.h().h().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            boolean z = this.i.isApplyingOpacityToLayersEnabled() && e() && i2 != 255;
            if (z) {
                this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
                getBounds(this.b, this.c, true);
                this.a.setAlpha(i2);
                xt2.m(canvas, this.b, this.a);
            }
            if (z) {
                i2 = 255;
            }
            for (int size = this.h.size() - 1; size >= 0; size--) {
                Content content = this.h.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas, this.c, i2);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        m mVar = this.k;
        if (mVar != null) {
            this.c.preConcat(mVar.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.c.reset();
        m mVar = this.k;
        if (mVar != null) {
            this.c.set(mVar.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            if (content instanceof PathContent) {
                this.d.addPath(((PathContent) content).getPath(), this.c);
            }
        }
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        if (z51.g(getName(), i2) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                z512 = z512.a(getName());
                if (z51.c(getName(), i2)) {
                    list.add(z512.i(this));
                }
            }
            if (z51.h(getName(), i2)) {
                int e2 = i2 + z51.e(getName(), i2);
                for (int i3 = 0; i3 < this.h.size(); i3++) {
                    Content content = this.h.get(i3);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(z51, e2, list, z512);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            content.setContents(arrayList, this.h.subList(0, size));
            arrayList.add(content);
        }
    }

    c(LottieDrawable lottieDrawable, a aVar, String str, boolean z, List<Content> list, @Nullable s5 s5Var) {
        this.a = new l61();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = lottieDrawable;
        this.g = z;
        this.h = list;
        if (s5Var != null) {
            m a2 = s5Var.a();
            this.k = a2;
            a2.a(aVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
