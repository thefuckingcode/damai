package tb;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import cn.damai.common.util.ACache;

/* compiled from: Taobao */
public class ft1 extends go1 implements ValueAnimator.AnimatorUpdateListener, Animatable {
    protected int b = 0;
    protected int c = 0;
    protected int d = 0;
    protected ValueAnimator e;
    protected Path f = new Path();

    public ft1() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, ACache.TIME_HOUR);
        this.e = ofInt;
        ofInt.setDuration(10000L);
        this.e.setInterpolator(null);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        float f2 = (float) width;
        float max = Math.max(1.0f, f2 / 22.0f);
        if (!(this.b == width && this.c == height)) {
            this.f.reset();
            float f3 = f2 - max;
            float f4 = ((float) height) / 2.0f;
            this.f.addCircle(f3, f4, max, Path.Direction.CW);
            float f5 = f2 - (5.0f * max);
            this.f.addRect(f5, f4 - max, f3, f4 + max, Path.Direction.CW);
            this.f.addCircle(f5, f4, max, Path.Direction.CW);
            this.b = width;
            this.c = height;
        }
        canvas.save();
        float f6 = f2 / 2.0f;
        float f7 = ((float) height) / 2.0f;
        canvas.rotate((float) this.d, f6, f7);
        for (int i = 0; i < 12; i++) {
            this.a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f, this.a);
        }
        canvas.restore();
    }

    public boolean isRunning() {
        return this.e.isRunning();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public void start() {
        if (!this.e.isRunning()) {
            this.e.addUpdateListener(this);
            this.e.start();
        }
    }

    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
