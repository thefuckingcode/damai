package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.content.Context;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ViewChangeNotify;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import tb.am;

/* compiled from: Taobao */
public class HtmlView implements ViewChangeNotify {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final float LINE_HEIGHT = 1.4f;
    public static final int TEXT_COLOR = -13421773;
    public static final int URL_COLOR = -12552000;
    private static final String g = "HtmlView";
    public static float h = 40.0f;
    private String a;
    private ImageGetter b;
    private boolean c;
    private Spanned d;
    private WeakReference<TextView> e;
    private Runnable f = new Runnable() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-548712651")) {
                ipChange.ipc$dispatch("-548712651", new Object[]{this});
                return;
            }
            ((TextView) HtmlView.this.e.get()).setText(HtmlView.this.d);
            Log.d(HtmlView.g, "notifyViewChange postInvalidateDelayed");
        }
    };

    private HtmlView(String str) {
        this.a = str;
        this.c = false;
    }

    public static HtmlView d(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1833548522")) {
            return new HtmlView(str);
        }
        return (HtmlView) ipChange.ipc$dispatch("1833548522", new Object[]{str});
    }

    public void e(Context context, HtmlParserManager.OnSpanClickListener onSpanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573678645")) {
            ipChange.ipc$dispatch("573678645", new Object[]{this, context, onSpanClickListener, onParseFinishedListener});
            return;
        }
        if (this.b == null) {
            this.b = new DefaultImageGetter("", am.b().a(), context);
        }
        f.c(this.a, this.b, new b(onSpanClickListener), onParseFinishedListener);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ViewChangeNotify
    public void notifyViewChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626093503")) {
            ipChange.ipc$dispatch("1626093503", new Object[]{this});
            return;
        }
        WeakReference<TextView> weakReference = this.e;
        if (weakReference != null) {
            TextView textView = weakReference.get();
            if (this.c && textView != null && this.d != null) {
                textView.removeCallbacks(this.f);
                textView.postDelayed(this.f, 200);
            }
        }
    }
}
