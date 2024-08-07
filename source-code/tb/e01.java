package tb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class e01 extends ImageSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = -1;
    private int b = -1;

    public e01(Context context, int i) {
        super(context, i);
    }

    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53216464")) {
            ipChange.ipc$dispatch("53216464", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        Drawable drawable = getDrawable();
        if (this.b > 0 && this.a > 0) {
            Rect bounds = drawable.getBounds();
            int i6 = bounds.left;
            int i7 = bounds.top;
            drawable.setBounds(i6, i7, this.a + i6, this.b + i7);
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f, (float) (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)));
        drawable.draw(canvas);
        canvas.restore();
    }

    public e01(Context context, int i, int i2, int i3) {
        super(context, i);
        this.b = i3;
        this.a = i2;
    }
}
