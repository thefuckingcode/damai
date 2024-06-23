package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LineBackgroundSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.opendevice.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class yr1 extends CharacterStyle implements LineBackgroundSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public void drawBackground(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, int i8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683556241")) {
            ipChange.ipc$dispatch("-683556241", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
            return;
        }
        k21.i(canvas, c.a);
        k21.i(paint, "p");
        k21.i(charSequence, "text");
        int color = paint.getColor();
        paint.setColor(16777215);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) (i2 - i), (float) (i3 - i5)), 4.0f, 4.0f, paint);
        paint.setColor(color);
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510619373")) {
            ipChange.ipc$dispatch("1510619373", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.setTextSize(textPaint.getTextSize() * 0.85f);
        textPaint.setTypeface(Typeface.MONOSPACE);
    }
}
