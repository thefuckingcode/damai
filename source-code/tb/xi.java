package tb;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xi extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private View.OnClickListener b;
    private final int c;

    @JvmOverloads
    public xi(@NotNull Context context, @Nullable View.OnClickListener onClickListener, int i) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = onClickListener;
        this.c = i;
    }

    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140824532")) {
            ipChange.ipc$dispatch("-1140824532", new Object[]{this, view});
            return;
        }
        k21.i(view, "widget");
        View.OnClickListener onClickListener = this.b;
        if (onClickListener != null) {
            k21.f(onClickListener);
            onClickListener.onClick(view);
        }
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68146421")) {
            ipChange.ipc$dispatch("-68146421", new Object[]{this, textPaint});
            return;
        }
        k21.i(textPaint, "ds");
        textPaint.setColor(this.a.getResources().getColor(this.c));
        textPaint.setUnderlineText(false);
    }
}
