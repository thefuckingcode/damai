package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class s21 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963094342")) {
            ipChange.ipc$dispatch("-963094342", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        zu0.Companion.a(textPaint, 2);
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401846640")) {
            ipChange.ipc$dispatch("401846640", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "p");
        zu0.Companion.a(textPaint, 2);
    }
}
