package tb;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class bf2 extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313409144")) {
            ipChange.ipc$dispatch("313409144", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "tp");
        textPaint.setStrikeThruText(true);
    }
}
