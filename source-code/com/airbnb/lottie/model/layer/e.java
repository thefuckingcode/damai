package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.c;
import java.util.Collections;
import java.util.List;
import tb.o92;
import tb.z51;

/* compiled from: Taobao */
public class e extends a {
    private final c z;

    e(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        c cVar = new c(lottieDrawable, this, new o92("__container", layer.l(), false));
        this.z = cVar;
        cVar.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z2) {
        super.getBounds(rectF, matrix, z2);
        this.z.getBounds(rectF, this.m, z2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.layer.a
    public void n(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.z.draw(canvas, matrix, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.airbnb.lottie.model.layer.a
    public void x(z51 z51, int i, List<z51> list, z51 z512) {
        this.z.resolveKeyPath(z51, i, list, z512);
    }
}
