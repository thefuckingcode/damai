package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class dy0 implements LineBackgroundSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final int a = ((Integer) Float.valueOf(ky0.Companion.a() / ((float) 4))).intValue();

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
        if (AndroidInstantRuntime.support(ipChange, "-157773022")) {
            ipChange.ipc$dispatch("-157773022", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
            return;
        }
        k21.i(canvas, "canvas");
        k21.i(paint, "paint");
        k21.i(charSequence, "charSequence");
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        float strokeWidth = paint.getStrokeWidth();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth((float) a);
        paint.setColor(-1579033);
        float f = ((float) ((i3 + i5) - 5)) / 2.0f;
        canvas.drawLine((float) i, f, (float) i2, f, paint);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(style);
        paint.setColor(color);
    }
}
