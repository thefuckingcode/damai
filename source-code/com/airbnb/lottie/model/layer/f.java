package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import tb.l61;
import tb.pa1;

/* compiled from: Taobao */
public class f extends a {
    private final Paint A;
    private final float[] B;
    private final Path C;
    private final Layer D;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> E;
    private final RectF z = new RectF();

    f(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        l61 l61 = new l61();
        this.A = l61;
        this.B = new float[8];
        this.C = new Path();
        this.D = layer;
        l61.setAlpha(0);
        l61.setStyle(Paint.Style.FILL);
        l61.setColor(layer.m());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        super.addValueCallback(t, pa1);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (pa1 == null) {
            this.E = null;
        } else {
            this.E = new n(pa1);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z2) {
        super.getBounds(rectF, matrix, z2);
        this.z.set(0.0f, 0.0f, (float) this.D.o(), (float) this.D.n());
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.D.m());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.v.h() == null ? 100 : this.v.h().h().intValue()))) / 100.0f) * 255.0f);
            this.A.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.E;
            if (baseKeyframeAnimation != null) {
                this.A.setColorFilter(baseKeyframeAnimation.h());
            }
            if (intValue > 0) {
                float[] fArr = this.B;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.D.o();
                float[] fArr2 = this.B;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.D.o();
                this.B[5] = (float) this.D.n();
                float[] fArr3 = this.B;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.D.n();
                matrix.mapPoints(this.B);
                this.C.reset();
                Path path = this.C;
                float[] fArr4 = this.B;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.C;
                float[] fArr5 = this.B;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.C;
                float[] fArr6 = this.B;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.C;
                float[] fArr7 = this.B;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.C;
                float[] fArr8 = this.B;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.C.close();
                canvas.drawPath(this.C, this.A);
            }
        }
    }
}
