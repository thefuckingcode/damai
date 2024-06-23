package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class yg2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794613163")) {
            ipChange.ipc$dispatch("-794613163", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.baselineShift += (int) (textPaint.ascent() / ((float) 2));
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1192118795")) {
            ipChange.ipc$dispatch("-1192118795", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.baselineShift += (int) (textPaint.ascent() / ((float) 2));
    }
}
