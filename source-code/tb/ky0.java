package tb;

import android.content.Context;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ViewChangeNotify;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.q12;

/* compiled from: Taobao */
public final class ky0 implements ViewChangeNotify {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final float LINE_HEIGHT = 1.4f;
    public static final int TEXT_COLOR = -13421773;
    public static final int URL_COLOR = -12552000;
    private static final String g = ky0.class.getSimpleName();
    private static float h = 40.0f;
    @NotNull
    private final String a;
    @Nullable
    private ImageGetter b;
    private boolean c;
    @Nullable
    private Spanned d;
    @Nullable
    private WeakReference<TextView> e;
    @NotNull
    private final Runnable f;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final float a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-81218082")) {
                return ky0.h;
            }
            return ((Float) ipChange.ipc$dispatch("-81218082", new Object[]{this})).floatValue();
        }

        @NotNull
        public final ky0 b(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824174924")) {
                return (ky0) ipChange.ipc$dispatch("1824174924", new Object[]{this, str});
            }
            k21.i(str, "source");
            return new ky0(str, null);
        }
    }

    private ky0(String str) {
        this.a = str;
        this.f = new jy0(this);
    }

    public /* synthetic */ ky0(String str, m40 m40) {
        this(str);
    }

    /* access modifiers changed from: private */
    public static final void d(ky0 ky0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915406958")) {
            ipChange.ipc$dispatch("-915406958", new Object[]{ky0});
            return;
        }
        k21.i(ky0, "this$0");
        WeakReference<TextView> weakReference = ky0.e;
        k21.f(weakReference);
        TextView textView = weakReference.get();
        k21.f(textView);
        textView.setText(ky0.d);
        Log.d(g, "notifyViewChange postInvalidateDelayed");
    }

    public final void c(@NotNull Context context, @Nullable HtmlParserManager.OnSpanClickListener onSpanClickListener, @Nullable HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601056639")) {
            ipChange.ipc$dispatch("1601056639", new Object[]{this, context, onSpanClickListener, onParseFinishedListener});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (this.b == null) {
            this.b = new DefaultImageGetter("", bm.Companion.a().c(), context);
        }
        q12.a aVar = q12.Companion;
        String str = this.a;
        ImageGetter imageGetter = this.b;
        k21.f(imageGetter);
        aVar.a(str, imageGetter, new j40(onSpanClickListener), onParseFinishedListener);
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ViewChangeNotify
    public void notifyViewChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296009149")) {
            ipChange.ipc$dispatch("-296009149", new Object[]{this});
            return;
        }
        WeakReference<TextView> weakReference = this.e;
        if (weakReference != null) {
            k21.f(weakReference);
            TextView textView = weakReference.get();
            if (this.c && textView != null && this.d != null) {
                textView.removeCallbacks(this.f);
                textView.postDelayed(this.f, 200);
            }
        }
    }
}
