package tb;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
public class be {
    private float a;
    private float b;
    private float c;
    private float d;
    private Paint e;
    private Paint f;
    private boolean g = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends ViewOutlineProvider {
        final /* synthetic */ int a;

        a(be beVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends ViewOutlineProvider {
        final /* synthetic */ int a;

        b(be beVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, -this.a, view.getWidth(), view.getHeight(), (float) this.a);
            outline.offset(0, this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends ViewOutlineProvider {
        final /* synthetic */ int a;

        c(be beVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            int i = this.a;
            outline.setRoundRect(0, 0, width, height + i, (float) i);
            outline.offset(0, -this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends ViewOutlineProvider {
        final /* synthetic */ int a;

        d(be beVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(-this.a, 0, view.getWidth(), view.getHeight(), (float) this.a);
            outline.offset(this.a, 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e extends ViewOutlineProvider {
        final /* synthetic */ int a;

        e(be beVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth() + this.a, view.getHeight(), (float) this.a);
            outline.offset(-this.a, 0);
        }
    }

    private void c(View view, Canvas canvas) {
        if (this.c > 0.0f) {
            int height = view.getHeight();
            Path path = new Path();
            float f2 = (float) height;
            path.moveTo(0.0f, f2 - this.c);
            path.lineTo(0.0f, f2);
            path.lineTo(this.c, f2);
            float f3 = this.c;
            path.arcTo(new RectF(0.0f, f2 - (f3 * 2.0f), f3 * 2.0f, f2), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void d(View view, Canvas canvas) {
        if (this.d > 0.0f) {
            int height = view.getHeight();
            int width = view.getWidth();
            Path path = new Path();
            float f2 = (float) width;
            float f3 = (float) height;
            path.moveTo(f2 - this.d, f3);
            path.lineTo(f2, f3);
            path.lineTo(f2, f3 - this.d);
            float f4 = this.d;
            path.arcTo(new RectF(f2 - (f4 * 2.0f), f3 - (f4 * 2.0f), f2, f3), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void e(View view, Canvas canvas) {
        if (this.a > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.a);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.a, 0.0f);
            float f2 = this.a;
            path.arcTo(new RectF(0.0f, 0.0f, f2 * 2.0f, f2 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void f(View view, Canvas canvas) {
        if (this.b > 0.0f) {
            int width = view.getWidth();
            Path path = new Path();
            float f2 = (float) width;
            path.moveTo(f2 - this.b, 0.0f);
            path.lineTo(f2, 0.0f);
            path.lineTo(f2, this.b);
            float f3 = this.b;
            path.arcTo(new RectF(f2 - (f3 * 2.0f), 0.0f, f2, f3 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void i(View view) {
        if (g()) {
            float f2 = this.a;
            float f3 = this.b;
            if (f2 == f3) {
                float f4 = this.c;
                if (f2 == f4 && f4 == this.d) {
                    view.setOutlineProvider(new a(this, (int) f2));
                    view.setClipToOutline(true);
                    this.g = true;
                    return;
                }
            }
            if (f2 == f3 && this.c == 0.0f && this.d == 0.0f) {
                view.setOutlineProvider(new b(this, (int) f2));
                view.setClipToOutline(true);
                this.g = true;
                return;
            }
            float f5 = this.c;
            float f6 = this.d;
            if (f5 == f6 && f2 == 0.0f && f3 == 0.0f) {
                view.setOutlineProvider(new c(this, (int) f5));
                view.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f2 == f5 && f3 == 0.0f && f6 == 0.0f) {
                view.setOutlineProvider(new d(this, (int) f2));
                view.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f3 == f6 && f2 == 0.0f && f5 == 0.0f) {
                view.setOutlineProvider(new e(this, (int) f3));
                view.setClipToOutline(true);
                this.g = true;
                return;
            }
        }
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(-1);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setXfermode(null);
    }

    public void a(View view, Canvas canvas) {
        e(view, canvas);
        f(view, canvas);
        c(view, canvas);
        d(view, canvas);
        canvas.restore();
    }

    public void b(View view, Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.f, 31);
    }

    public boolean g() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public boolean h() {
        return this.g;
    }

    public void j(View view, float f2) {
        k(view, f2, f2, f2, f2);
    }

    public void k(View view, float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        i(view);
    }
}
