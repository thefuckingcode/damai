package tb;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mr2 extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634619132")) {
            ipChange.ipc$dispatch("-1634619132", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.setUnderlineText(true);
    }
}
