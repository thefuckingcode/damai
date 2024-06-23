package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zg2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021655343")) {
            ipChange.ipc$dispatch("-2021655343", new Object[]{this, textPaint});
            return;
        }
        textPaint.baselineShift += (int) (textPaint.ascent() / 2.0f);
    }

    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539046919")) {
            ipChange.ipc$dispatch("-1539046919", new Object[]{this, textPaint});
            return;
        }
        textPaint.baselineShift += (int) (textPaint.ascent() / 2.0f);
    }
}
