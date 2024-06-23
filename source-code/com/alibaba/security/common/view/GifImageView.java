package com.alibaba.security.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.math.BigDecimal;

/* compiled from: Taobao */
public class GifImageView extends ImageView {
    private static final int b = 1000;
    float a;
    private float c;
    private float d;
    private float e;
    private Movie f;
    private long g;
    private long h;
    private long i;
    private int j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private boolean n;
    private a o;
    private int p;
    private final boolean q;

    /* compiled from: Taobao */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public GifImageView(Context context) {
        this(context, null);
        setLayerType(1, null);
    }

    private void a(String str, a aVar) {
        Bitmap decodeFile;
        this.f = Movie.decodeFile(str);
        this.o = aVar;
        d();
        if (this.f != null || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
            requestLayout();
            return;
        }
        setImageBitmap(decodeFile);
    }

    private void b() {
        if (this.f != null) {
            d();
            this.k = true;
            invalidate();
        }
    }

    private void c() {
        this.j = -1;
        d();
        invalidate();
    }

    private void d() {
        this.k = false;
        this.g = SystemClock.uptimeMillis();
        this.l = false;
        this.m = true;
        this.h = 0;
        this.i = 0;
    }

    private void e() {
        if (this.f != null) {
            if (!this.m) {
                c();
            } else if (this.l && this.h > 0) {
                this.l = false;
                this.i = (this.i + SystemClock.uptimeMillis()) - this.h;
                invalidate();
            }
        }
    }

    private void f() {
        if (this.f != null && !this.l && this.m) {
            this.l = true;
            invalidate();
            this.h = SystemClock.uptimeMillis();
        }
    }

    private boolean g() {
        return this.l;
    }

    private int getCurrentFrameTime() {
        if (this.p == 0) {
            return 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.i;
        long j2 = this.g;
        int i2 = this.p;
        int i3 = (int) ((uptimeMillis - j2) / ((long) i2));
        int i4 = this.j;
        if (i4 == -1 || i3 < i4) {
            float f2 = (float) ((uptimeMillis - j2) % ((long) i2));
            this.a = f2 / ((float) i2);
            if (this.o != null && this.m) {
                new BigDecimal((double) this.a).setScale(2, 4).doubleValue();
            }
            return (int) f2;
        }
        this.m = false;
        return 0;
    }

    private boolean h() {
        return !this.l && this.m;
    }

    private void i() {
        if (!this.n) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private void setGifResource$4de0f83e(int i2) {
        Bitmap decodeResource;
        d();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(i2));
        this.f = decodeStream;
        if (decodeStream != null || (decodeResource = BitmapFactory.decodeResource(getResources(), i2)) == null) {
            this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
            requestLayout();
            return;
        }
        setImageBitmap(decodeResource);
    }

    public int getDuration() {
        Movie movie = this.f;
        if (movie != null) {
            return movie.duration();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f == null) {
            return;
        }
        if (this.l || !this.m) {
            a(canvas);
            return;
        }
        if (this.k) {
            this.f.setTime(this.p - getCurrentFrameTime());
        } else {
            this.f.setTime(getCurrentFrameTime());
        }
        a(canvas);
        i();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Movie movie = this.f;
        if (movie != null) {
            int width = movie.width();
            int height = this.f.height();
            if (mode == 1073741824) {
                this.c = ((float) width) / ((float) size);
            }
            if (mode2 == 1073741824) {
                this.d = ((float) height) / ((float) size2);
            }
            this.e = Math.max(this.c, this.d);
            if (mode != 1073741824) {
                size = width;
            }
            if (mode2 != 1073741824) {
                size2 = height;
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        this.n = z;
        i();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.n = i2 == 0;
        i();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.n = i2 == 0;
        i();
    }

    public void setGifResource(int i2) {
        Bitmap decodeResource;
        d();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(i2));
        this.f = decodeStream;
        if (decodeStream != null || (decodeResource = BitmapFactory.decodeResource(getResources(), i2)) == null) {
            this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
            requestLayout();
            return;
        }
        setImageBitmap(decodeResource);
    }

    public void setPercent(float f2) {
        int i2;
        Movie movie = this.f;
        if (movie != null && (i2 = this.p) > 0) {
            this.a = f2;
            movie.setTime((int) (((float) i2) * f2));
            i();
        }
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        setLayerType(1, null);
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.j = -1;
        this.k = false;
        this.n = true;
        this.q = false;
        setLayerType(1, null);
    }

    private void a() {
        if (this.f != null) {
            c();
        }
    }

    private void a(Canvas canvas) {
        canvas.save();
        float f2 = this.e;
        canvas.scale(1.0f / f2, 1.0f / f2);
        this.f.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }
}
