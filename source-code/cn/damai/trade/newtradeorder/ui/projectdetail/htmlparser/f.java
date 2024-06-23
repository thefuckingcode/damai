package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.util.Log;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import tb.av0;
import tb.cf2;
import tb.ey0;
import tb.fg2;
import tb.g71;
import tb.g91;
import tb.hy0;
import tb.ig2;
import tb.jc;
import tb.m71;
import tb.nj;
import tb.nr2;
import tb.nw1;
import tb.qz0;
import tb.t21;
import tb.zg2;
import tb.zr1;

/* compiled from: Taobao */
public class f implements ParserCallback, ImageGetterCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String m = ("htmlParser " + f.class.getSimpleName());
    private String a;
    private SpannableStringBuilder b;
    private ImageGetter c;
    private SpanClickListener d;
    private d e;
    private Stack<c> f = new Stack<>();
    private int g = 0;
    private HtmlParserManager.OnParseFinishedListener h;
    private List<HtmlParserManager.a> i = new ArrayList();
    private int j;
    private boolean k;
    private List<HtmlParserManager.a> l = new ArrayList();

    private f(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        this.a = str;
        this.d = spanClickListener;
        this.c = imageGetter;
        d dVar = new d();
        this.e = dVar;
        dVar.p(this);
        this.h = onParseFinishedListener;
        this.j = 1;
    }

    private void a(c.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445838645")) {
            ipChange.ipc$dispatch("-445838645", new Object[]{this, aVar});
            return;
        }
        HtmlParserManager.a aVar2 = new HtmlParserManager.a();
        aVar2.l(this.j);
        aVar2.g(new SpannableStringBuilder().append((CharSequence) new SpannableString(aVar.a)));
        aVar2.f(aVar.g);
        aVar2.m(aVar.h);
        aVar2.j(aVar.i);
        aVar2.i(aVar.j);
        aVar2.h(aVar.k);
        this.i.add(aVar2);
        if (this.k) {
            this.l.add(aVar2);
        }
        this.b = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private void b() {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-925916982")) {
            ipChange.ipc$dispatch("-925916982", new Object[]{this});
            return;
        }
        HtmlParserManager.a aVar = new HtmlParserManager.a();
        aVar.l(this.j);
        if (this.j == 1 && (length = this.b.length()) > 1) {
            int i2 = length - 1;
            if (this.b.charAt(i2) == '\n') {
                this.b.delete(i2, length);
            }
            g91.b(m, "mSpannedBuilder str = " + this.b.toString());
        }
        aVar.g(this.b);
        this.i.add(aVar);
        this.b = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    public static void c(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798146420")) {
            ipChange.ipc$dispatch("-798146420", new Object[]{str, imageGetter, spanClickListener, onParseFinishedListener});
            return;
        }
        new f(str, imageGetter, spanClickListener, onParseFinishedListener).m();
    }

    private void d(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267685675")) {
            ipChange.ipc$dispatch("267685675", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        l(i2, new nw1());
    }

    private void e(int i2, boolean z, int i3, int i4, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849267337")) {
            ipChange.ipc$dispatch("-1849267337", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), aVar});
            return;
        }
        int i5 = this.g;
        if (i5 > 0) {
            if (this.b.charAt(i5 - 1) != '\n') {
                this.b.append('\n');
                this.g++;
            }
            if (!z && aVar != null) {
                int i6 = aVar.g;
                if (i6 == 0) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else if (i6 == 2) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = i6 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
                }
                if (alignment != null) {
                    k(i4, this.g, new AlignmentSpan.Standard(alignment));
                }
            }
        }
    }

    private void f(int i2, int i3, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104427085")) {
            ipChange.ipc$dispatch("2104427085", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), aVar});
            return;
        }
        l(i2, new av0(i3));
        if (aVar != null) {
            int i4 = aVar.e;
            if (i4 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = i4 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                k(i2, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private void g(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574196538")) {
            ipChange.ipc$dispatch("-1574196538", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.b.append(' ');
        this.g++;
        l(i2, new ey0());
    }

    private void h(int i2, c.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802027047")) {
            ipChange.ipc$dispatch("802027047", new Object[]{this, Integer.valueOf(i2), aVar});
        } else if (aVar != null) {
            int i3 = aVar.h;
            String str = aVar.a;
            if (i3 != -1) {
                if (i3 <= 36) {
                    ImageGetter imageGetter = this.c;
                    if (imageGetter != null) {
                        imageGetter.getDrawable(str, i2, this.g, this);
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    this.j = 2;
                    a(aVar);
                }
            } else if (!TextUtils.isEmpty(str)) {
                this.j = 2;
                a(aVar);
            }
        }
    }

    private void i(int i2, c.a aVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147372858")) {
            ipChange.ipc$dispatch("2147372858", new Object[]{this, Integer.valueOf(i2), aVar});
        } else if (aVar != null) {
            l(i2, new fg2(aVar));
            int i3 = aVar.e;
            if (i3 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i3 == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = i3 == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                k(i2, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private void j(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234007385")) {
            ipChange.ipc$dispatch("1234007385", new Object[]{this, Integer.valueOf(i2), str});
            return;
        }
        l(i2, new m71(str, this.d));
        List<HtmlParserManager.a> list = this.l;
        if (!(list == null || list.isEmpty())) {
            int size = this.l.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.l.get(i3).k(str);
            }
            this.l.clear();
        }
    }

    private void k(int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068120661")) {
            ipChange.ipc$dispatch("-1068120661", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), obj});
        } else if (i3 > i2) {
            this.b.setSpan(obj, i2, i3, 33);
        }
    }

    private void l(int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072047408")) {
            ipChange.ipc$dispatch("-2072047408", new Object[]{this, Integer.valueOf(i2), obj});
            return;
        }
        k(i2, this.g, obj);
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011962905")) {
            ipChange.ipc$dispatch("-2011962905", new Object[]{this});
            return;
        }
        try {
            this.e.g(this.a);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void characters(char[] cArr, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792263597")) {
            ipChange.ipc$dispatch("1792263597", new Object[]{this, cArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        String unescapeHtml4 = StringEscapeUtils.unescapeHtml4(new String(cArr, i2, i3));
        if (!TextUtils.isEmpty(unescapeHtml4)) {
            this.b.append((CharSequence) unescapeHtml4);
            this.g += unescapeHtml4.length();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void endDocument() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407262875")) {
            ipChange.ipc$dispatch("-1407262875", new Object[]{this});
            return;
        }
        String str = m;
        Log.d(str, "end   document: " + SystemClock.elapsedRealtime());
        SpannableStringBuilder spannableStringBuilder = this.b;
        if (!(spannableStringBuilder == null || spannableStringBuilder.length() == 0)) {
            b();
        }
        HtmlParserManager.OnParseFinishedListener onParseFinishedListener = this.h;
        if (onParseFinishedListener != null) {
            onParseFinishedListener.onParseFinished(this.i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void endElement(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355509407")) {
            ipChange.ipc$dispatch("355509407", new Object[]{this, Integer.valueOf(i2), str});
        } else if (i2 != -1 && i2 != 15 && i2 != 72 && !this.f.isEmpty()) {
            if (i2 == 16) {
                this.b.append((CharSequence) StringUtils.LF);
            }
            if (this.f.peek().a == i2) {
                c pop = this.f.pop();
                int i3 = pop.c;
                if (!(i2 == 3 || i2 == 4 || i2 == 5)) {
                    if (i2 != 6) {
                        if (i2 == 14) {
                            c.a aVar = pop.d;
                            if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                                j(i3, pop.d.b);
                            }
                            this.k = false;
                        } else if (i2 == 54) {
                            i(i3, pop.d);
                        } else if (i2 != 57) {
                            if (!(i2 == 24 || i2 == 25)) {
                                if (i2 == 70) {
                                    l(i3, new zr1());
                                } else if (i2 != 71) {
                                    switch (i2) {
                                        case 9:
                                            break;
                                        case 10:
                                        case 11:
                                            l(i3, new jc());
                                            break;
                                        case 12:
                                            break;
                                        default:
                                            switch (i2) {
                                                case 17:
                                                    l(i3, new ig2());
                                                    break;
                                                case 18:
                                                    l(i3, new zg2());
                                                    break;
                                                case 19:
                                                    break;
                                                case 20:
                                                case 21:
                                                case 22:
                                                    l(i3, new cf2());
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 61:
                                                        case 62:
                                                        case 63:
                                                        case 64:
                                                        case 65:
                                                        case 66:
                                                            f(i3, (i2 - 61) + 1, pop.d);
                                                            break;
                                                    }
                                            }
                                    }
                                } else {
                                    d(i3);
                                }
                            }
                            l(i3, new nj());
                        } else {
                            l(i3, new g71());
                        }
                        if (hy0.a(i2)) {
                            e(1, false, i2, i3, pop.d);
                            return;
                        }
                        return;
                    }
                    l(i3, new nr2());
                    if (hy0.a(i2)) {
                    }
                }
                l(i3, new t21());
                if (hy0.a(i2)) {
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack
    public void onImageReady(String str, int i2, int i3, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457717654")) {
            ipChange.ipc$dispatch("1457717654", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3), drawable});
            return;
        }
        for (qz0 qz0 : (qz0[]) this.b.getSpans(i2, i3, qz0.class)) {
            this.b.removeSpan(qz0);
        }
        k(i2, i3, new qz0(str, drawable));
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void startDocument(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132518597")) {
            ipChange.ipc$dispatch("132518597", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        String str = m;
        Log.d(str, "start document: " + SystemClock.elapsedRealtime());
        this.i = new ArrayList();
        this.b = new SpannableStringBuilder();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.ParserCallback
    public void startElement(c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377516657")) {
            ipChange.ipc$dispatch("-377516657", new Object[]{this, cVar});
            return;
        }
        if (hy0.a(cVar.a)) {
            e(0, true, cVar.a, this.g, null);
        }
        int i2 = cVar.a;
        if (i2 == -1) {
            return;
        }
        if (i2 != 72) {
            switch (i2) {
                case 14:
                    this.k = true;
                    break;
                case 15:
                    SpannableStringBuilder spannableStringBuilder = this.b;
                    if (!(spannableStringBuilder == null || spannableStringBuilder.length() == 0)) {
                        b();
                    }
                    h(this.g, cVar.d);
                    return;
                case 16:
                    e(-1, false, i2, this.g, cVar.d);
                    return;
            }
            cVar.c = this.g;
            this.f.push(cVar);
            return;
        }
        g(this.g);
    }
}
