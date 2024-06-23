package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class g71 implements LeadingMarginSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final float b;
    private static final int c;
    private static Path d = null;
    private final float a = (HtmlView.h * 0.6f);

    static {
        float f = HtmlView.h;
        b = f;
        c = (int) (f / 8.0f);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130311181")) {
            ipChange.ipc$dispatch("-1130311181", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
        } else if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-13421773);
            if (canvas.isHardwareAccelerated()) {
                if (d == null) {
                    Path path = new Path();
                    d = path;
                    path.addCircle(0.0f, 0.0f, ((float) c) * 1.2f, Path.Direction.CW);
                }
                canvas.save();
                float f = b;
                int i8 = c;
                canvas.translate(((float) i) + (((float) i2) * (f - ((float) i8))), (((float) (i3 + i4)) / 2.0f) + ((float) i8));
                canvas.drawPath(d, paint);
                canvas.restore();
            } else {
                float f2 = b;
                int i9 = c;
                canvas.drawCircle(((float) i) + (((float) i2) * (f2 - ((float) i9))), (((float) (i3 + i4)) / 2.0f) + ((float) i9), (float) i9, paint);
            }
            paint.setColor(color);
            paint.setStyle(style);
        }
    }

    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-391942768")) {
            return (int) (b + this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-391942768", new Object[]{this, Boolean.valueOf(z)})).intValue();
    }
}
