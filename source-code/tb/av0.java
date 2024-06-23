package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class av0 extends MetricAffectingSpan implements LineBackgroundSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final float[] b = {1.4f, 1.3f, 1.2f, 1.1f, 1.0f, 0.9f};
    private static final int[] c = {-13421773, -13421773, -13421773, -13421773, -13421773, -8947849};
    private int a;

    public av0(int i) {
        this.a = i;
    }

    public static void a(Paint paint, int i) {
        Typeface typeface;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "644250741")) {
            ipChange.ipc$dispatch("644250741", new Object[]{paint, Integer.valueOf(i)});
            return;
        }
        Typeface typeface2 = null;
        if (paint != null) {
            typeface2 = paint.getTypeface();
        }
        if (typeface2 != null) {
            i2 = typeface2.getStyle();
        }
        int i3 = i | i2;
        if (typeface2 == null) {
            typeface = Typeface.defaultFromStyle(i3);
        } else {
            typeface = Typeface.create(typeface2, i3);
        }
        int i4 = i3 & (~typeface.getStyle());
        if ((i4 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i4 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5264038")) {
            ipChange.ipc$dispatch("-5264038", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt});
            return;
        }
        fontMetricsInt.top = (int) (((float) fontMetricsInt.top) * 0.89285713f);
        fontMetricsInt.ascent = (int) (((float) fontMetricsInt.ascent) * 0.89285713f);
        fontMetricsInt.descent = (int) (((float) fontMetricsInt.descent) * 0.89285713f);
        fontMetricsInt.bottom = (int) (((float) fontMetricsInt.bottom) * 0.89285713f);
    }

    public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869544556")) {
            ipChange.ipc$dispatch("1869544556", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
        } else if (this.a <= 2 && ((Spanned) charSequence).getSpanEnd(this) == i7 - 1) {
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(-1118482);
            paint.setStrokeWidth(HtmlView.h / 14.0f);
            float f = (float) i4;
            float f2 = HtmlView.h;
            canvas.drawLine((float) i, (f2 / 2.0f) + f, (float) i2, f + (f2 / 2.0f), paint);
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269054486")) {
            ipChange.ipc$dispatch("-269054486", new Object[]{this, textPaint});
            return;
        }
        textPaint.setTextSize(textPaint.getTextSize() * b[this.a - 1]);
        textPaint.setColor(c[this.a - 1]);
        a(textPaint, 1);
    }

    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570633792")) {
            ipChange.ipc$dispatch("570633792", new Object[]{this, textPaint});
            return;
        }
        textPaint.setTextSize(textPaint.getTextSize() * b[this.a - 1]);
        textPaint.setColor(c[this.a - 1]);
        a(textPaint, 1);
    }
}
