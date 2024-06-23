package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ic extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840620603")) {
            ipChange.ipc$dispatch("-840620603", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        zu0.Companion.a(textPaint, 1);
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705196411")) {
            ipChange.ipc$dispatch("-1705196411", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "p");
        zu0.Companion.a(textPaint, 1);
    }
}
