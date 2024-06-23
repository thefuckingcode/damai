package tb;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.util.Log;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.pictures.bricks.util.htmlparser.ParserCallback;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack;
import com.alibaba.pictures.bricks.util.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fy0;

/* compiled from: Taobao */
public final class q12 implements ParserCallback, ImageGetterCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String m = ("htmlParser " + q12.class.getSimpleName());
    @NotNull
    private final String a;
    @NotNull
    private final SpanClickListener b;
    @Nullable
    private SpannableStringBuilder c;
    @Nullable
    private final ImageGetter d;
    @NotNull
    private final com.alibaba.pictures.bricks.util.htmlparser.a e;
    @NotNull
    private final Stack<fy0> f;
    private int g;
    @Nullable
    private final HtmlParserManager.OnParseFinishedListener h;
    @NotNull
    private List<HtmlParserManager.b> i;
    private int j;
    private boolean k;
    @Nullable
    private final List<HtmlParserManager.b> l;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final void a(@NotNull String str, @NotNull ImageGetter imageGetter, @NotNull SpanClickListener spanClickListener, @Nullable HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1953392204")) {
                ipChange.ipc$dispatch("-1953392204", new Object[]{this, str, imageGetter, spanClickListener, onParseFinishedListener});
                return;
            }
            k21.i(str, "source");
            k21.i(imageGetter, "imageGetter");
            k21.i(spanClickListener, "listener");
            new q12(str, imageGetter, spanClickListener, onParseFinishedListener, null).k();
        }
    }

    private q12(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        this.a = str;
        this.b = spanClickListener;
        this.d = imageGetter;
        com.alibaba.pictures.bricks.util.htmlparser.a aVar = new com.alibaba.pictures.bricks.util.htmlparser.a();
        this.e = aVar;
        aVar.p(this);
        this.f = new Stack<>();
        this.g = 0;
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.h = onParseFinishedListener;
        this.j = 1;
    }

    public /* synthetic */ q12(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener, m40 m40) {
        this(str, imageGetter, spanClickListener, onParseFinishedListener);
    }

    private final void b(fy0.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887360231")) {
            ipChange.ipc$dispatch("1887360231", new Object[]{this, bVar});
            return;
        }
        HtmlParserManager.b bVar2 = new HtmlParserManager.b();
        bVar2.m(this.j);
        bVar2.h(new SpannableStringBuilder().append((CharSequence) new SpannableString(bVar.h())));
        bVar2.g(bVar.a());
        bVar2.n(bVar.k());
        bVar2.k(bVar.f());
        bVar2.j(bVar.d());
        bVar2.i(bVar.c());
        this.i.add(bVar2);
        if (this.k) {
            List<HtmlParserManager.b> list = this.l;
            k21.f(list);
            list.add(bVar2);
        }
        this.c = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980846790")) {
            ipChange.ipc$dispatch("980846790", new Object[]{this});
            return;
        }
        HtmlParserManager.b bVar = new HtmlParserManager.b();
        bVar.m(this.j);
        if (this.j == 1) {
            SpannableStringBuilder spannableStringBuilder = this.c;
            k21.f(spannableStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 1) {
                SpannableStringBuilder spannableStringBuilder2 = this.c;
                k21.f(spannableStringBuilder2);
                int i2 = length - 1;
                if (spannableStringBuilder2.charAt(i2) == '\n') {
                    SpannableStringBuilder spannableStringBuilder3 = this.c;
                    k21.f(spannableStringBuilder3);
                    spannableStringBuilder3.delete(i2, length);
                }
                LogUtil.d(m, "mSpannedBuilder str = " + ((Object) this.c));
            }
        }
        bVar.h(this.c);
        this.i.add(bVar);
        this.c = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private final void d(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570239569")) {
            ipChange.ipc$dispatch("-570239569", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        j(i2, new mw1());
    }

    private final void e(int i2, boolean z, int i3, int i4, fy0.b bVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405438275")) {
            ipChange.ipc$dispatch("1405438275", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), bVar});
        } else if (this.g > 0) {
            SpannableStringBuilder spannableStringBuilder = this.c;
            k21.f(spannableStringBuilder);
            if (spannableStringBuilder.charAt(this.g - 1) != '\n') {
                SpannableStringBuilder spannableStringBuilder2 = this.c;
                k21.f(spannableStringBuilder2);
                spannableStringBuilder2.append('\n');
                this.g++;
            }
            if (!z && bVar != null) {
                if (bVar.a() == 0) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else if (bVar.a() == 2) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = bVar.a() == 1 ? Layout.Alignment.ALIGN_CENTER : null;
                }
                if (alignment != null) {
                    i(i4, this.g, new AlignmentSpan.Standard(alignment));
                }
            }
        }
    }

    private final void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798668106")) {
            ipChange.ipc$dispatch("798668106", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.c;
        k21.f(spannableStringBuilder);
        spannableStringBuilder.append(' ');
        this.g++;
        j(i2, new dy0());
    }

    private final void g(int i2, fy0.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100108691")) {
            ipChange.ipc$dispatch("1100108691", new Object[]{this, Integer.valueOf(i2), bVar});
        } else if (bVar != null) {
            int k2 = bVar.k();
            String h2 = bVar.h();
            if (k2 != -1) {
                if (k2 <= 36) {
                    ImageGetter imageGetter = this.d;
                    if (imageGetter != null) {
                        imageGetter.getDrawable(h2, i2, this.g, this);
                    }
                } else if (!TextUtils.isEmpty(h2)) {
                    this.j = 2;
                    b(bVar);
                }
            } else if (!TextUtils.isEmpty(h2)) {
                this.j = 2;
                b(bVar);
            }
        }
    }

    private final void h(int i2, fy0.b bVar) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946724960")) {
            ipChange.ipc$dispatch("-1946724960", new Object[]{this, Integer.valueOf(i2), bVar});
        } else if (bVar != null) {
            j(i2, new eg2(bVar));
            if (bVar.i() == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (bVar.i() == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = bVar.i() == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                i(i2, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private final void i(int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598783791")) {
            ipChange.ipc$dispatch("598783791", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), obj});
        } else if (i3 > i2) {
            SpannableStringBuilder spannableStringBuilder = this.c;
            k21.f(spannableStringBuilder);
            spannableStringBuilder.setSpan(obj, i2, i3, 33);
        }
    }

    private final void j(int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325539636")) {
            ipChange.ipc$dispatch("-1325539636", new Object[]{this, Integer.valueOf(i2), obj});
            return;
        }
        i(i2, this.g, obj);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001984739")) {
            ipChange.ipc$dispatch("2001984739", new Object[]{this});
            return;
        }
        try {
            this.e.g(this.a);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void characters(@Nullable char[] cArr, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595939927")) {
            ipChange.ipc$dispatch("-595939927", new Object[]{this, cArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        k21.f(cArr);
        String unescapeHtml4 = StringEscapeUtils.unescapeHtml4(new String(cArr, i2, i3));
        if (!TextUtils.isEmpty(unescapeHtml4)) {
            SpannableStringBuilder spannableStringBuilder = this.c;
            k21.f(spannableStringBuilder);
            spannableStringBuilder.append((CharSequence) unescapeHtml4);
            this.g += unescapeHtml4.length();
        }
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void endDocument() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711974167")) {
            ipChange.ipc$dispatch("-1711974167", new Object[]{this});
            return;
        }
        String str = m;
        Log.d(str, "end   document: " + SystemClock.elapsedRealtime());
        SpannableStringBuilder spannableStringBuilder = this.c;
        if (spannableStringBuilder != null) {
            k21.f(spannableStringBuilder);
            if (spannableStringBuilder.length() != 0) {
                c();
            }
        }
        if (this.i.size() == 0 && !TextUtils.isEmpty(this.a)) {
            HtmlParserManager.b bVar = new HtmlParserManager.b();
            bVar.m(1);
            bVar.h(new SpannableStringBuilder(this.a));
            this.i.add(bVar);
            this.c = new SpannableStringBuilder();
            this.g = 0;
            this.j = 1;
        }
        HtmlParserManager.OnParseFinishedListener onParseFinishedListener = this.h;
        if (onParseFinishedListener != null) {
            onParseFinishedListener.onParseFinished(this.i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void endElement(int i2, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227886371")) {
            ipChange.ipc$dispatch("227886371", new Object[]{this, Integer.valueOf(i2), str});
        } else if (i2 != -1 && i2 != 15 && i2 != 72 && !this.f.isEmpty()) {
            if (i2 == 16) {
                SpannableStringBuilder spannableStringBuilder = this.c;
                k21.f(spannableStringBuilder);
                spannableStringBuilder.append((CharSequence) StringUtils.LF);
            }
            if (this.f.peek().d() == i2) {
                fy0 pop = this.f.pop();
                k21.f(pop);
                int c2 = pop.c();
                if (!(i2 == 3 || i2 == 4 || i2 == 5)) {
                    if (i2 != 6) {
                        if (!(i2 == 24 || i2 == 25)) {
                            if (i2 == 54) {
                                h(c2, pop.a());
                            } else if (i2 == 57) {
                                j(c2, new f71());
                            } else if (i2 == 70) {
                                j(c2, new yr1());
                            } else if (i2 != 71) {
                                switch (i2) {
                                    case 9:
                                        break;
                                    case 10:
                                    case 11:
                                        j(c2, new ic());
                                        break;
                                    case 12:
                                        break;
                                    default:
                                        switch (i2) {
                                            case 17:
                                                j(c2, new hg2());
                                                break;
                                            case 18:
                                                j(c2, new yg2());
                                                break;
                                            case 20:
                                            case 21:
                                            case 22:
                                                j(c2, new bf2());
                                                break;
                                        }
                                }
                            } else {
                                d(c2);
                            }
                            if (!gy0.INSTANCE.a(i2)) {
                                e(1, false, i2, c2, pop.a());
                                return;
                            }
                            return;
                        }
                        j(c2, new mj());
                        if (!gy0.INSTANCE.a(i2)) {
                        }
                    }
                    j(c2, new mr2());
                    if (!gy0.INSTANCE.a(i2)) {
                    }
                }
                j(c2, new s21());
                if (!gy0.INSTANCE.a(i2)) {
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack
    public void onImageReady(@Nullable String str, int i2, int i3, @NotNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402298002")) {
            ipChange.ipc$dispatch("402298002", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3), drawable});
            return;
        }
        k21.i(drawable, "d");
        SpannableStringBuilder spannableStringBuilder = this.c;
        k21.f(spannableStringBuilder);
        pz0[] pz0Arr = (pz0[]) spannableStringBuilder.getSpans(i2, i3, pz0.class);
        k21.h(pz0Arr, "`is`");
        for (pz0 pz0 : pz0Arr) {
            SpannableStringBuilder spannableStringBuilder2 = this.c;
            k21.f(spannableStringBuilder2);
            spannableStringBuilder2.removeSpan(pz0);
        }
        i(i2, i3, new pz0(str, drawable));
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void startDocument(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039282369")) {
            ipChange.ipc$dispatch("2039282369", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        String str = m;
        Log.d(str, "start document: " + SystemClock.elapsedRealtime());
        this.i = new ArrayList();
        this.c = new SpannableStringBuilder();
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void startElement(@NotNull fy0 fy0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019764695")) {
            ipChange.ipc$dispatch("2019764695", new Object[]{this, fy0});
            return;
        }
        k21.i(fy0, "node");
        if (gy0.INSTANCE.a(fy0.d())) {
            e(0, true, fy0.d(), this.g, null);
        }
        int d2 = fy0.d();
        if (d2 == -1) {
            return;
        }
        if (d2 != 72) {
            switch (d2) {
                case 14:
                    this.k = true;
                    fy0.f(this.g);
                    this.f.push(fy0);
                    return;
                case 15:
                    SpannableStringBuilder spannableStringBuilder = this.c;
                    if (spannableStringBuilder != null) {
                        k21.f(spannableStringBuilder);
                        if (spannableStringBuilder.length() != 0) {
                            c();
                        }
                    }
                    g(this.g, fy0.a());
                    return;
                case 16:
                    e(-1, false, fy0.d(), this.g, fy0.a());
                    return;
                default:
                    fy0.f(this.g);
                    this.f.push(fy0);
                    return;
            }
        } else {
            f(this.g);
        }
    }
}
