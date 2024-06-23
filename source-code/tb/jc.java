package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class jc extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059460041")) {
            ipChange.ipc$dispatch("1059460041", new Object[]{this, textPaint});
            return;
        }
        av0.a(textPaint, 1);
    }

    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223275009")) {
            ipChange.ipc$dispatch("223275009", new Object[]{this, textPaint});
            return;
        }
        av0.a(textPaint, 1);
    }
}
