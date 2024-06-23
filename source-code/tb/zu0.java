package tb;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zu0 extends MetricAffectingSpan implements LineBackgroundSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final void a(@Nullable Paint paint, int i) {
            Typeface typeface;
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1499252879")) {
                ipChange.ipc$dispatch("-1499252879", new Object[]{this, paint, Integer.valueOf(i)});
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
                k21.h(typeface, "{\n                Typefa…Style(want)\n            }");
            } else {
                typeface = Typeface.create(typeface2, i3);
                k21.h(typeface, "{\n                Typefa…(old, want)\n            }");
            }
            int i4 = i3 & (~typeface.getStyle());
            if ((i4 & 1) != 0) {
                k21.f(paint);
                paint.setFakeBoldText(true);
            }
            if ((i4 & 2) != 0) {
                k21.f(paint);
                paint.setTextSkewX(-0.25f);
            }
            k21.f(paint);
            paint.setTypeface(typeface);
        }
    }
}
