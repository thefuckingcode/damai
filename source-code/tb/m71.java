package tb;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class m71 extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final SpanClickListener b;

    public m71(String str, SpanClickListener spanClickListener) {
        this.a = str;
        this.b = spanClickListener;
    }

    public void onClick(View view) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787657693")) {
            ipChange.ipc$dispatch("-1787657693", new Object[]{this, view});
        } else if (this.b != null && (str = this.a) != null && !str.isEmpty()) {
            this.b.onSpanClick(14, this.a);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587237260")) {
            ipChange.ipc$dispatch("-587237260", new Object[]{this, textPaint});
            return;
        }
        textPaint.setColor(-12552000);
        textPaint.setUnderlineText(false);
    }
}
