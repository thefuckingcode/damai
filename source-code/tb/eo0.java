package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(api = 17)
/* compiled from: Taobao */
public final class eo0 {
    @NotNull
    private final GXView a;
    private int b = 4;
    private float c = 25.0f;
    private int d;
    private int e;
    private boolean f;
    @NotNull
    private final fo0 g = new fo0();
    @Nullable
    private Bitmap h;
    @Nullable
    private Bitmap i;
    @Nullable
    private Canvas j;
    private boolean k;
    @NotNull
    private final Paint l = new Paint();
    @NotNull
    private final Rect m = new Rect();
    @NotNull
    private final Rect n = new Rect();
    @Nullable
    private View o;
    @NotNull
    private final ViewTreeObserver.OnPreDrawListener p = new do0(this);

    public eo0(@NotNull GXView gXView) {
        k21.i(gXView, "host");
        this.a = gXView;
    }

    private final void d(Canvas canvas, Bitmap bitmap) {
        this.m.right = bitmap.getWidth();
        this.m.bottom = bitmap.getHeight();
        this.n.right = this.a.getLayoutParams().width;
        this.n.bottom = this.a.getLayoutParams().height;
        this.l.setFlags(3);
        this.l.setColorFilter(new PorterDuffColorFilter(this.d, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, this.m, this.n, this.l);
    }

    /* access modifiers changed from: private */
    public static final boolean l(eo0 eo0) {
        Bitmap bitmap;
        k21.i(eo0, "this$0");
        int[] iArr = new int[2];
        View view = eo0.o;
        if (view != null && eo0.a.isShown() && eo0.m()) {
            view.getLocationOnScreen(iArr);
            eo0.a.getLocationOnScreen(iArr);
            int i2 = (-iArr[0]) + iArr[0];
            int i3 = (-iArr[1]) + iArr[1];
            Canvas canvas = eo0.j;
            if (!(canvas == null || (bitmap = eo0.h) == null)) {
                bitmap.eraseColor(eo0.f() & 16777215);
                int save = canvas.save();
                eo0.q(true);
                eo0.r(eo0.g() + 1);
                try {
                    canvas.scale(1.0f / ((float) eo0.h()), 1.0f / ((float) eo0.h()));
                    canvas.translate(-((float) i2), -((float) i3));
                    if (view.getBackground() != null) {
                        view.getBackground().draw(canvas);
                    }
                    eo0.o(true);
                    view.draw(canvas);
                    eo0.o(false);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    eo0.q(false);
                    eo0.r(eo0.g() - 1);
                    canvas.restoreToCount(save);
                    throw th;
                }
                eo0.q(false);
                eo0.r(eo0.g() - 1);
                canvas.restoreToCount(save);
                eo0.g.a(bitmap, eo0.e());
                eo0.a.invalidate();
            }
        }
        return true;
    }

    private final boolean m() {
        Canvas canvas;
        int i2 = this.a.getLayoutParams().width;
        int i3 = this.a.getLayoutParams().height;
        if ((this.c == 0.0f) || (i2 == 0 && i3 == 0)) {
            i();
            return false;
        }
        int i4 = this.b;
        int i5 = i2 / i4;
        int i6 = i3 / i4;
        if (this.h == null || this.i == null) {
            n();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.h = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                if (createBitmap == null) {
                    canvas = null;
                } else {
                    canvas = new Canvas(createBitmap);
                }
                this.j = canvas;
                Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.i = createBitmap2;
                if (createBitmap2 == null) {
                    i();
                    return false;
                }
                this.g.b(this.a.getContext(), this.h, this.c);
            } catch (OutOfMemoryError unused) {
            } finally {
                i();
            }
        }
        wq0 gxTemplateContext = this.a.getGxTemplateContext();
        if (gxTemplateContext != null) {
            if (gxTemplateContext.a() <= 0) {
                return false;
            }
            gxTemplateContext.u(gxTemplateContext.a() - 1);
        }
        return true;
    }

    private final void n() {
        this.j = null;
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.h = null;
        Bitmap bitmap2 = this.i;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.i = null;
    }

    public final void b(@NotNull Canvas canvas, @NotNull Function0<ur2> function0) {
        k21.i(canvas, "canvas");
        k21.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (!this.f) {
            Bitmap bitmap = this.i;
            if (bitmap != null) {
                d(canvas, bitmap);
            }
            function0.invoke();
        }
    }

    public final void c(@NotNull Canvas canvas, @NotNull Function0<ur2> function0) {
        k21.i(canvas, "canvas");
        k21.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (!this.k && this.e <= 0) {
            function0.invoke();
        }
    }

    @Nullable
    public final Bitmap e() {
        return this.i;
    }

    public final int f() {
        return this.d;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.b;
    }

    public final void i() {
        n();
        this.g.c();
    }

    public final void j() {
        ViewTreeObserver viewTreeObserver;
        if (this.a.getGxBackdropFilter() != null) {
            wq0 gxTemplateContext = this.a.getGxTemplateContext();
            View h2 = gxTemplateContext == null ? null : gxTemplateContext.h();
            this.o = h2;
            if (h2 != null && h2 != null && (viewTreeObserver = h2.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnPreDrawListener(this.p);
            }
        }
    }

    public final void k() {
        View view;
        ViewTreeObserver viewTreeObserver;
        if (this.a.getGxBackdropFilter() != null && (view = this.o) != null && view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this.p);
        }
    }

    public final void o(boolean z) {
        this.f = z;
    }

    public final void p(float f2) {
        this.c = f2;
    }

    public final void q(boolean z) {
        this.k = z;
    }

    public final void r(int i2) {
        this.e = i2;
    }

    public final void s(int i2) {
        this.b = i2;
    }
}
