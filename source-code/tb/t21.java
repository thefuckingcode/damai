package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class t21 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346696258")) {
            ipChange.ipc$dispatch("-346696258", new Object[]{this, textPaint});
            return;
        }
        av0.a(textPaint, 2);
    }

    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762990612")) {
            ipChange.ipc$dispatch("-1762990612", new Object[]{this, textPaint});
            return;
        }
        av0.a(textPaint, 2);
    }
}
