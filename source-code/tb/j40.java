package tb;

import android.util.Log;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.pictures.bricks.util.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class j40 implements SpanClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final String b = j40.class.getSimpleName();
    @Nullable
    private final HtmlParserManager.OnSpanClickListener a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public j40(@Nullable HtmlParserManager.OnSpanClickListener onSpanClickListener) {
        this.a = onSpanClickListener;
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.SpanClickListener
    public void onSpanClick(int i, @NotNull String str) {
        HtmlParserManager.OnSpanClickListener onSpanClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1171342246")) {
            ipChange.ipc$dispatch("1171342246", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        k21.i(str, "source");
        String str2 = b;
        Log.d(str2, "span click type is " + i + " source is:" + str);
        if (i == 14 && (onSpanClickListener = this.a) != null) {
            onSpanClickListener.onSpanClick(0, str);
        }
    }
}
