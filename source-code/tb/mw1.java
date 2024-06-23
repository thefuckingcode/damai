package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.opendevice.c;
import org.jetbrains.annotations.NotNull;
import tb.ky0;

/* compiled from: Taobao */
public final class mw1 extends CharacterStyle implements LeadingMarginSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final float a;
    private static final float b;
    private static final float c = 0.89285713f;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        ky0.a aVar = ky0.Companion;
        a = aVar.a() / ((float) 4);
        b = aVar.a();
    }

    public void chooseHeight(@NotNull CharSequence charSequence, int i, int i2, int i3, int i4, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140790884")) {
            ipChange.ipc$dispatch("1140790884", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt});
            return;
        }
        k21.i(charSequence, "text");
        k21.i(fontMetricsInt, "fm");
        int i5 = fontMetricsInt.ascent;
        float f = c;
        fontMetricsInt.ascent = i5 * ((int) f);
        fontMetricsInt.descent *= (int) f;
        fontMetricsInt.top *= (int) f;
        fontMetricsInt.bottom *= (int) f;
    }

    public void drawLeadingMargin(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, boolean z, @NotNull Layout layout) {
        int i8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299685162")) {
            ipChange.ipc$dispatch("-1299685162", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            return;
        }
        k21.i(canvas, c.a);
        k21.i(paint, "p");
        k21.i(charSequence, "text");
        k21.i(layout, "layout");
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-2236963);
        if (!z) {
            i8 = i3 - (i5 - i4);
        } else {
            i8 = ((int) (((float) i3) - a)) + 5;
        }
        float f = (float) i;
        canvas.drawRect(f, (float) i8, (((float) i2) * a) + f, (float) (i4 + 5), paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1298958003")) {
            return (int) (a + b);
        }
        return ((Integer) ipChange.ipc$dispatch("1298958003", new Object[]{this, Boolean.valueOf(z)})).intValue();
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714819828")) {
            ipChange.ipc$dispatch("714819828", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.setColor(-8947849);
    }
}
