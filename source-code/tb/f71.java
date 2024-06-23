package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ky0;

/* compiled from: Taobao */
public final class f71 implements LeadingMarginSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final float c;
    private static final int d;
    @Nullable
    private static Path e;
    private final float a = (ky0.Companion.a() * 0.6f);
    private final int b = -13421773;

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
        c = aVar.a();
        d = ((Integer) Float.valueOf(aVar.a() / ((float) 8))).intValue();
    }

    public void drawLeadingMargin(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, boolean z, @NotNull Layout layout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1550113519")) {
            ipChange.ipc$dispatch("1550113519", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            return;
        }
        k21.i(canvas, c.a);
        k21.i(paint, "p");
        k21.i(charSequence, "text");
        k21.i(layout, NotifyType.LIGHTS);
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.b);
            if (canvas.isHardwareAccelerated()) {
                if (e == null) {
                    Path path = new Path();
                    e = path;
                    k21.f(path);
                    path.addCircle(0.0f, 0.0f, ((float) d) * 1.2f, Path.Direction.CW);
                }
                canvas.save();
                float f = c;
                int i8 = d;
                canvas.translate(((float) i) + (((float) i2) * (f - ((float) i8))), (((float) (i3 + i4)) / 2.0f) + ((float) i8));
                Path path2 = e;
                k21.f(path2);
                canvas.drawPath(path2, paint);
                canvas.restore();
            } else {
                float f2 = c;
                int i9 = d;
                canvas.drawCircle(((float) i) + (((float) i2) * (f2 - ((float) i9))), (((float) (i3 + i4)) / 2.0f) + ((float) i9), (float) i9, paint);
            }
            paint.setColor(color);
            paint.setStyle(style);
        }
    }

    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "152417164")) {
            return (int) (c + this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("152417164", new Object[]{this, Boolean.valueOf(z)})).intValue();
    }
}
