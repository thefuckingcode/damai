package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import tb.l61;
import tb.pa1;
import tb.xt2;

/* compiled from: Taobao */
public class c extends a {
    private final Rect A = new Rect();
    private final Rect B = new Rect();
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> C;
    private final Paint z = new l61(3);

    c(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Nullable
    private Bitmap E() {
        return this.n.getImageAsset(this.o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        super.addValueCallback(t, pa1);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (pa1 == null) {
            this.C = null;
        } else {
            this.C = new n(pa1);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z2) {
        super.getBounds(rectF, matrix, z2);
        Bitmap E = E();
        if (E != null) {
            rectF.set(0.0f, 0.0f, ((float) E.getWidth()) * xt2.e(), ((float) E.getHeight()) * xt2.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap E = E();
        if (E != null && !E.isRecycled()) {
            float e = xt2.e();
            this.z.setAlpha(i);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.C;
            if (baseKeyframeAnimation != null) {
                this.z.setColorFilter(baseKeyframeAnimation.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.A.set(0, 0, E.getWidth(), E.getHeight());
            this.B.set(0, 0, (int) (((float) E.getWidth()) * e), (int) (((float) E.getHeight()) * e));
            canvas.drawBitmap(E, this.A, this.B, this.z);
            canvas.restore();
        }
    }
}
