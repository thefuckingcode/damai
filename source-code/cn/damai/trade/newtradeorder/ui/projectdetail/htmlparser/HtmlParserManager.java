package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.am;

/* compiled from: Taobao */
public class HtmlParserManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;

    /* compiled from: Taobao */
    public interface OnParseFinishedListener {
        void onParseFinished(List<a> list);
    }

    /* compiled from: Taobao */
    public interface OnSpanClickListener {
        void onSpanClick(int i, String str);
    }

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private Spanned b;
        private int c;
        private int d;
        private int e;
        private int f;
        private String g;

        public Spanned a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-868270498")) {
                return this.b;
            }
            return (Spanned) ipChange.ipc$dispatch("-868270498", new Object[]{this});
        }

        public int b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1892743277")) {
                return this.f;
            }
            return ((Integer) ipChange.ipc$dispatch("-1892743277", new Object[]{this})).intValue();
        }

        public int c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1534701840")) {
                return this.e;
            }
            return ((Integer) ipChange.ipc$dispatch("-1534701840", new Object[]{this})).intValue();
        }

        public String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1349031808")) {
                return this.g;
            }
            return (String) ipChange.ipc$dispatch("-1349031808", new Object[]{this});
        }

        public int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1039143332")) {
                return this.a;
            }
            return ((Integer) ipChange.ipc$dispatch("1039143332", new Object[]{this})).intValue();
        }

        public void f(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "737838429")) {
                ipChange.ipc$dispatch("737838429", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public void g(Spanned spanned) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-44233056")) {
                ipChange.ipc$dispatch("-44233056", new Object[]{this, spanned});
                return;
            }
            this.b = spanned;
        }

        public void h(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1920403241")) {
                ipChange.ipc$dispatch("-1920403241", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.f = i;
        }

        public void i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1271239758")) {
                ipChange.ipc$dispatch("-1271239758", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.e = i;
        }

        public void j(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-312701333")) {
                ipChange.ipc$dispatch("-312701333", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.d = i;
        }

        public void k(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "836930142")) {
                ipChange.ipc$dispatch("836930142", new Object[]{this, str});
                return;
            }
            this.g = str;
        }

        public void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2060122238")) {
                ipChange.ipc$dispatch("2060122238", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a = i;
        }

        public void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080831074")) {
                ipChange.ipc$dispatch("-1080831074", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.c = i;
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "312614691")) {
                return (String) ipChange.ipc$dispatch("312614691", new Object[]{this});
            }
            return ", content:" + ((CharSequence) this.b) + ", width:" + this.c + ", height:" + this.d + ", damaiWidth:" + this.e + ", damaiHeight:" + this.f + "}";
        }
    }

    private HtmlParserManager(int i, float f2, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.f = f2;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public static HtmlParserManager a(int i, float f2, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "615764478")) {
            return new HtmlParserManager(i, f2, i2, i3, i4, i5);
        }
        return (HtmlParserManager) ipChange.ipc$dispatch("615764478", new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772003772")) {
            ipChange.ipc$dispatch("1772003772", new Object[]{this});
            return;
        }
        am b2 = am.b();
        b2.h(this.b);
        b2.g(this.c);
        b2.d(this.d);
        b2.c(this.e);
        b2.f(this.f);
        b2.e(this.a);
    }

    public void c(Context context, String str, OnSpanClickListener onSpanClickListener, OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050761823")) {
            ipChange.ipc$dispatch("-1050761823", new Object[]{this, context, str, onSpanClickListener, onParseFinishedListener});
        } else if (!TextUtils.isEmpty(str)) {
            b();
            HtmlView.d(str).e(context, onSpanClickListener, onParseFinishedListener);
        }
    }
}
