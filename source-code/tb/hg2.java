package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class hg2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997320816")) {
            ipChange.ipc$dispatch("997320816", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.baselineShift -= (int) (textPaint.ascent() / ((float) 2));
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164527610")) {
            ipChange.ipc$dispatch("164527610", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.baselineShift -= (int) (textPaint.ascent() / ((float) 2));
    }
}
