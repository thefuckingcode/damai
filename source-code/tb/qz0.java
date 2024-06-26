package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class qz0 extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int c = (((int) HtmlView.h) / 5);
    private Drawable a;
    private WeakReference<Drawable> b;

    public qz0(String str, Drawable drawable) {
        this.a = drawable;
    }

    private Drawable a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136687003")) {
            return (Drawable) ipChange.ipc$dispatch("2136687003", new Object[]{this});
        }
        WeakReference<Drawable> weakReference = this.b;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable != null) {
            return drawable;
        }
        Drawable b2 = b();
        this.b = new WeakReference<>(b2);
        return b2;
    }

    private boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "69674838")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("69674838", new Object[]{this})).booleanValue();
    }

    public Drawable b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1155287129")) {
            return this.a;
        }
        return (Drawable) ipChange.ipc$dispatch("1155287129", new Object[]{this});
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349025104")) {
            ipChange.ipc$dispatch("-349025104", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        Drawable a2 = a();
        canvas.save();
        if (c()) {
            i6 = (i5 - a2.getBounds().bottom) - paint.getFontMetricsInt().descent;
        } else {
            i6 = i3 + c;
        }
        canvas.translate(f, (float) i6);
        a2.draw(canvas);
        canvas.restore();
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427125144")) {
            return ((Integer) ipChange.ipc$dispatch("427125144", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            if (c()) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
            } else {
                int i3 = c;
                fontMetricsInt.ascent = (-((int) (((float) bounds.bottom) * 0.71428573f))) - i3;
                fontMetricsInt.descent = ((int) (HtmlView.h * 0.39999998f)) + i3;
            }
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return bounds.right;
    }
}
