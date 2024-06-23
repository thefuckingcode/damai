package com.taobao.android.abilitykit.ability.pop.render.util;

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
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    @Nullable
    private Paint a;
    @Nullable
    private Paint b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g = false;
    @NonNull
    private ViewGroup h;

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.android.abilitykit.ability.pop.render.util.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0200a extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C0200a(a aVar, int i) {
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

        b(a aVar, int i) {
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

        c(a aVar, int i) {
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

        d(a aVar, int i) {
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

        e(a aVar, int i) {
            this.a = i;
        }

        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth() + this.a, view.getHeight(), (float) this.a);
            outline.offset(-this.a, 0);
        }
    }

    public a(@NonNull ViewGroup viewGroup) {
        this.h = viewGroup;
    }

    private void b(Canvas canvas) {
        if (this.e > 0.0f && this.a != null) {
            int height = this.h.getHeight();
            Path path = new Path();
            float f2 = (float) height;
            path.moveTo(0.0f, f2 - this.e);
            path.lineTo(0.0f, f2);
            path.lineTo(this.e, f2);
            float f3 = this.e;
            path.arcTo(new RectF(0.0f, f2 - (f3 * 2.0f), f3 * 2.0f, f2), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.a);
        }
    }

    private void c(Canvas canvas) {
        if (this.f > 0.0f && this.a != null) {
            int height = this.h.getHeight();
            int width = this.h.getWidth();
            Path path = new Path();
            float f2 = (float) width;
            float f3 = (float) height;
            path.moveTo(f2 - this.f, f3);
            path.lineTo(f2, f3);
            path.lineTo(f2, f3 - this.f);
            float f4 = this.f;
            path.arcTo(new RectF(f2 - (f4 * 2.0f), f3 - (f4 * 2.0f), f2, f3), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.a);
        }
    }

    private void d(Canvas canvas) {
        if (this.c > 0.0f && this.a != null) {
            Path path = new Path();
            path.moveTo(0.0f, this.c);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.c, 0.0f);
            float f2 = this.c;
            path.arcTo(new RectF(0.0f, 0.0f, f2 * 2.0f, f2 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.a);
        }
    }

    private void e(Canvas canvas) {
        if (this.d > 0.0f && this.a != null) {
            int width = this.h.getWidth();
            Path path = new Path();
            float f2 = (float) width;
            path.moveTo(f2 - this.d, 0.0f);
            path.lineTo(f2, 0.0f);
            path.lineTo(f2, this.d);
            float f3 = this.d;
            path.arcTo(new RectF(f2 - (f3 * 2.0f), 0.0f, f2, f3 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.a);
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 22;
    }

    private void g() {
        if (f()) {
            float f2 = this.c;
            float f3 = this.d;
            if (f2 == f3) {
                float f4 = this.e;
                if (f2 == f4 && f4 == this.f) {
                    this.h.setOutlineProvider(new C0200a(this, (int) f2));
                    this.h.setClipToOutline(true);
                    this.g = true;
                    return;
                }
            }
            if (f2 == f3 && this.e == 0.0f && this.f == 0.0f) {
                this.h.setOutlineProvider(new b(this, (int) f2));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            }
            float f5 = this.e;
            float f6 = this.f;
            if (f5 == f6 && f2 == 0.0f && f3 == 0.0f) {
                this.h.setOutlineProvider(new c(this, (int) f5));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f2 == f5 && f3 == 0.0f && f6 == 0.0f) {
                this.h.setOutlineProvider(new d(this, (int) f2));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f3 == f6 && f2 == 0.0f && f5 == 0.0f) {
                this.h.setOutlineProvider(new e(this, (int) f3));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            }
        }
        if (this.a == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(-1);
            this.a.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        if (this.b == null) {
            Paint paint2 = new Paint();
            this.b = paint2;
            paint2.setXfermode(null);
        }
    }

    public void a(@NonNull Canvas canvas, @NonNull Runnable runnable) {
        if (this.g || this.b == null || this.a == null) {
            runnable.run();
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.b, 31);
        runnable.run();
        d(canvas);
        e(canvas);
        b(canvas);
        c(canvas);
        canvas.restore();
    }

    public void h(float f2, float f3, float f4, float f5) {
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        g();
    }
}
