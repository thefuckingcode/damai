package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pz0 extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final float c = 0.71428573f;
    private static final int d = (((Integer) Float.valueOf(ky0.Companion.a())).intValue() / 5);
    @NotNull
    private final Drawable a;
    @Nullable
    private WeakReference<Drawable> b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public pz0(@Nullable String str, @NotNull Drawable drawable) {
        k21.i(drawable, "drawable");
        this.a = drawable;
    }

    private final Drawable a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639292777")) {
            return (Drawable) ipChange.ipc$dispatch("-639292777", new Object[]{this});
        }
        WeakReference<Drawable> weakReference = this.b;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = this.a;
        this.b = new WeakReference<>(drawable2);
        return drawable2;
    }

    private final boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-514549166")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-514549166", new Object[]{this})).booleanValue();
    }

    public void draw(@NotNull Canvas canvas, @NotNull CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NotNull Paint paint) {
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223312436")) {
            ipChange.ipc$dispatch("1223312436", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        k21.i(canvas, "canvas");
        k21.i(charSequence, "text");
        k21.i(paint, "paint");
        Drawable a2 = a();
        canvas.save();
        if (b()) {
            k21.f(a2);
            i6 = (i5 - a2.getBounds().bottom) - paint.getFontMetricsInt().descent;
        } else {
            i6 = i3 + d;
        }
        canvas.translate(f, (float) i6);
        k21.f(a2);
        a2.draw(canvas);
        canvas.restore();
    }

    public int getSize(@NotNull Paint paint, @Nullable CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896007828")) {
            return ((Integer) ipChange.ipc$dispatch("1896007828", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        k21.i(paint, "paint");
        Drawable a2 = a();
        k21.f(a2);
        Rect bounds = a2.getBounds();
        k21.h(bounds, "d!!.bounds");
        if (fontMetricsInt != null) {
            if (b()) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
            } else {
                int i3 = d;
                fontMetricsInt.ascent = ((int) (-(((float) bounds.bottom) * c))) - i3;
                fontMetricsInt.descent = ((Integer) Float.valueOf(ky0.Companion.a() * 0.39999998f)).intValue() + i3;
            }
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return bounds.right;
    }
}
