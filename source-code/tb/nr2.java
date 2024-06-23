package tb;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class nr2 extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495510912")) {
            ipChange.ipc$dispatch("495510912", new Object[]{this, textPaint});
            return;
        }
        textPaint.setUnderlineText(true);
    }
}
