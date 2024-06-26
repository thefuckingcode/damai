package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class nw1 extends CharacterStyle implements LeadingMarginSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final float a;
    private static final float b;

    static {
        float f = HtmlView.h;
        a = f / 4.0f;
        b = f;
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874246880")) {
            ipChange.ipc$dispatch("1874246880", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt});
            return;
        }
        fontMetricsInt.ascent = (int) (((float) fontMetricsInt.ascent) * 0.89285713f);
        fontMetricsInt.descent = (int) (((float) fontMetricsInt.descent) * 0.89285713f);
        fontMetricsInt.top = (int) (((float) fontMetricsInt.top) * 0.89285713f);
        fontMetricsInt.bottom = (int) (((float) fontMetricsInt.bottom) * 0.89285713f);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799955630")) {
            ipChange.ipc$dispatch("-1799955630", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            return;
        }
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
        canvas.drawRect(f, (float) i8, (((float) i2) * a) + f, (float) (5 + i4), paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2068733487")) {
            return (int) (a + b);
        }
        return ((Integer) ipChange.ipc$dispatch("2068733487", new Object[]{this, Boolean.valueOf(z)})).intValue();
    }

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-512222352")) {
            ipChange.ipc$dispatch("-512222352", new Object[]{this, textPaint});
            return;
        }
        textPaint.setColor(-8947849);
    }
}
