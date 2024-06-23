package tb;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class nj extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280706913")) {
            ipChange.ipc$dispatch("1280706913", new Object[]{this, textPaint});
            return;
        }
        textPaint.bgColor = -921103;
        textPaint.setTextSize(textPaint.getTextSize() * 0.85f);
        textPaint.setTypeface(Typeface.MONOSPACE);
    }
}
