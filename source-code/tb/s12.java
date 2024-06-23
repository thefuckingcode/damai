package tb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.taobao.android.dinamicx.view.richtext.node.RichText;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.node.b;
import com.taobao.android.dinamicx.view.richtext.span.VerticalCenterSpan;
import com.taobao.android.dinamicx.view.richtext.span.VerticalTopSpan;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class s12 {
    public static final CharSequence DEFAULT_ELLIPSIS_TEXT = "…";
    private int A;
    private int B;
    private float C;
    private float D;
    private int E = 0;
    private float F;
    private int G = Integer.MAX_VALUE;
    private int H = Integer.MAX_VALUE;
    private int I = 1;
    private int J;
    private int K;
    private int L;
    private int M;
    private float N = -1.0f;
    private float O;
    private CharSequence P = DEFAULT_ELLIPSIS_TEXT;
    private float Q = 0.0f;
    private boolean R = true;
    private boolean S = false;
    private int T = 0;
    private Context a;
    private RichText b;
    private Layout c;
    private float d;
    private float e;
    private CharSequence f;
    private TextPaint g;
    private Paint h;
    private TextUtils.TruncateAt i;
    private Layout.Alignment j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private float q = -1.0f;
    private int r;
    private CharSequence s;
    private int t = 32;
    private int u = -16777216;
    private boolean v = false;
    private boolean w = false;
    private String x;
    private int y = 0;
    private int z = 0;

    /* compiled from: Taobao */
    public static class a {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    private CharSequence a(CharSequence charSequence, int i2) {
        int i3;
        int i4 = 1;
        boolean z2 = this.M == 0;
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        boolean z3 = valueOf.length() < this.s.length() && this.i == TextUtils.TruncateAt.END;
        int length = valueOf.length() - (z3 ? this.P.length() : 0);
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.b.size()) {
            int lineForOffset = this.c.getLineForOffset(i6);
            RichTextNode richTextNode = (RichTextNode) this.b.get(i5);
            if ((richTextNode instanceof b) && !z2) {
                if (i6 >= length) {
                    break;
                }
                int min = Math.min(richTextNode.getText().length() + i6, length);
                int lineForOffset2 = this.c.getLineForOffset(min - 1);
                int i7 = lineForOffset;
                while (i7 <= lineForOffset2) {
                    int lineTop = this.c.getLineTop(i7) - this.c.getLineBaseline(i7);
                    int lineBottom = this.c.getLineBottom(i7) - this.c.getLineBaseline(i7);
                    if (i7 == this.c.getLineCount() - i4) {
                        lineBottom = (int) (((float) lineBottom) + this.c.getSpacingAdd());
                    }
                    valueOf.setSpan(this.M == i4 ? new VerticalCenterSpan(lineTop, lineBottom, ((int) this.c.getSpacingAdd()) / 2) : new VerticalTopSpan(lineTop, lineBottom), Math.max(i6, this.c.getLineStart(i7)), Math.min(min, this.c.getLineEnd(i7)), 33);
                    i7++;
                    i4 = 1;
                }
            }
            if (richTextNode instanceof com.taobao.android.dinamicx.view.richtext.node.a) {
                com.taobao.android.dinamicx.view.richtext.node.a aVar = (com.taobao.android.dinamicx.view.richtext.node.a) richTextNode;
                int lineBottom2 = this.c.getLineBottom(lineForOffset) - this.c.getLineTop(lineForOffset);
                if (this.M == 1) {
                    int q2 = ((lineBottom2 - aVar.q()) >> 1) + ((int) (this.c.getSpacingAdd() / 2.0f));
                    i3 = lineForOffset == this.c.getLineCount() - 1 ? (int) (((float) q2) - (this.c.getSpacingAdd() / 2.0f)) : q2;
                } else {
                    i3 = 0;
                }
                if (this.M == 2) {
                    i3 = lineBottom2 - aVar.q();
                }
                if (this.M == 0) {
                    i3 = (int) this.c.getSpacingAdd();
                }
                aVar.t(-i3);
            }
            i6 += richTextNode.getText().length();
            i5++;
            i4 = 1;
        }
        if (z3 && !z2) {
            int lineCount = this.c.getLineCount() - 1;
            int lineTop2 = this.c.getLineTop(lineCount) - this.c.getLineBaseline(lineCount);
            int lineBottom3 = (this.c.getLineBottom(lineCount) - this.c.getLineBaseline(lineCount)) + ((int) this.c.getSpacingAdd());
            valueOf.setSpan(this.M == 1 ? new VerticalCenterSpan(lineTop2, lineBottom3, ((int) this.c.getSpacingAdd()) / 2) : new VerticalTopSpan(lineTop2, lineBottom3), Math.max(valueOf.length() - this.P.length(), 0), valueOf.length(), 33);
        }
        if (charSequence instanceof SpannableStringBuilder) {
            return null;
        }
        this.c = t(((i2 - j()) - k()) - (this.z * 2), valueOf, false);
        return valueOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018f, code lost:
        r17 = r0;
     */
    private CharSequence b(CharSequence charSequence) {
        int i2;
        Exception e2;
        float f2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int lineEnd = this.c.getLineEnd(this.I - 1);
        try {
            TextUtils.TruncateAt truncateAt = this.i;
            if (truncateAt != null && truncateAt == TextUtils.TruncateAt.END) {
                if (charSequence.length() != 1) {
                    CharSequence charSequence2 = this.P;
                    if (charSequence2 instanceof Spannable) {
                        f2 = Layout.getDesiredWidth(charSequence2, 0, charSequence2.length(), this.g);
                    } else {
                        f2 = this.g.measureText(charSequence2, 0, charSequence2.length());
                    }
                    float width = ((float) this.c.getWidth()) - f2;
                    int lineStart = this.c.getLineStart(this.I - 1);
                    Iterator descendingIterator = this.b.descendingIterator();
                    int length = this.b.originText().length();
                    TextPaint textPaint = new TextPaint();
                    if (Build.VERSION.SDK_INT >= 21) {
                        textPaint.setLetterSpacing(this.g.getLetterSpacing());
                    }
                    float min = Math.min(Math.max(0.0f, this.c.getLineWidth(this.I - 1)), (float) this.c.getWidth());
                    b bVar = null;
                    int i6 = 0;
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        RichTextNode richTextNode = (RichTextNode) descendingIterator.next();
                        int max = Math.max(length - richTextNode.getText().length(), lineStart);
                        if (length > lineEnd) {
                            int lineForOffset = this.c.getLineForOffset(length);
                            int lineForOffset2 = this.c.getLineForOffset(length - richTextNode.getText().length());
                            if (lineForOffset > this.I - 1 && descendingIterator.hasNext() && lineForOffset2 > this.I - 1) {
                                length -= richTextNode.getText().length();
                            } else if (!(richTextNode instanceof com.taobao.android.dinamicx.view.richtext.node.a)) {
                                i4 = lineEnd;
                            }
                        } else {
                            i4 = length;
                        }
                        if (max < lineStart) {
                            break;
                        }
                        if (!(richTextNode instanceof b)) {
                            i3 = lineStart;
                            if (richTextNode instanceof com.taobao.android.dinamicx.view.richtext.node.a) {
                                com.taobao.android.dinamicx.view.richtext.node.a aVar = (com.taobao.android.dinamicx.view.richtext.node.a) richTextNode;
                                min -= (float) aVar.r();
                                if (min < width) {
                                    i6 = i4 - aVar.getText().length();
                                    break;
                                }
                            }
                        } else {
                            bVar = (b) richTextNode;
                            textPaint.setTextSize((float) (bVar.H() == 0 ? this.t : bVar.H()));
                            int i7 = i4 - 1;
                            boolean z3 = charSequence.charAt(i7) == ' ';
                            while (true) {
                                if (i7 < max) {
                                    i3 = lineStart;
                                    break;
                                }
                                i3 = lineStart;
                                if (charSequence.charAt(i7) != ' ' || !z3) {
                                    break;
                                }
                                i7--;
                                lineStart = i3;
                            }
                            int i8 = i7 + 1;
                            int i9 = i8 - 1;
                            float f3 = min;
                            while (true) {
                                if (i9 < max) {
                                    z2 = false;
                                    break;
                                }
                                f3 = min - textPaint.measureText(charSequence, i9, i8);
                                if (f3 < width) {
                                    if (!r(charSequence.charAt(i9)) && i9 - 1 >= max && s(charSequence.subSequence(i5, i9 + 1).toString())) {
                                        i9--;
                                    }
                                    i6 = i9;
                                    z2 = true;
                                } else {
                                    i9--;
                                }
                            }
                            if (z2) {
                                break;
                            }
                            min = f3;
                        }
                        length -= richTextNode.getText().length();
                        lineStart = i3;
                    }
                    int i10 = i6 == 0 ? i3 : i6;
                    CharSequence charSequence3 = this.P;
                    if (!((charSequence3 instanceof Spannable) || bVar == null || bVar.G() == null)) {
                        SpannableString spannableString = new SpannableString(charSequence3);
                        spannableString.setSpan(new ForegroundColorSpan(bVar.G().intValue()), 0, charSequence3.length(), 33);
                        charSequence3 = spannableString;
                    }
                    return TextUtils.concat(charSequence.subSequence(0, i10), charSequence3);
                }
            }
            i2 = 0;
            try {
                return charSequence.subSequence(0, lineEnd);
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            CharSequence subSequence = charSequence.subSequence(i2, lineEnd);
            e2.printStackTrace();
            return subSequence;
        }
    }

    private float c(int i2, int i3) {
        Layout layout = this.c;
        int height = layout != null ? layout.getHeight() : 0;
        int i4 = ((i2 - this.o) - this.p) - (this.z * 2);
        if (height <= 0 || i4 <= 0 || height >= i4 || i3 != 1073741824) {
            return 0.0f;
        }
        return (float) ((i4 - height) >> 1);
    }

    private TextUtils.TruncateAt g(int i2) {
        if (i2 == 1) {
            return TextUtils.TruncateAt.START;
        }
        if (i2 == 2) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        if (i2 != 3) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private Typeface o() {
        if (this.x != null) {
            return Typeface.createFromAsset(f().getAssets(), this.x);
        }
        boolean z2 = this.v;
        if (z2 && this.w) {
            return Typeface.defaultFromStyle(3);
        }
        if (z2) {
            return Typeface.defaultFromStyle(1);
        }
        if (this.w) {
            return Typeface.defaultFromStyle(2);
        }
        return Typeface.defaultFromStyle(0);
    }

    private void p() {
        int i2;
        RichText richText = this.b;
        if (richText != null) {
            CharSequence renderText = richText.renderText();
            if (!renderText.equals(this.s)) {
                this.s = renderText;
            }
        }
        if (this.s != null) {
            if (this.g == null) {
                this.g = new TextPaint();
            }
            if (this.h == null) {
                this.h = new Paint();
            }
            this.g.setAntiAlias(true);
            int i3 = this.t;
            if (i3 >= 0) {
                this.g.setTextSize((float) i3);
            }
            this.g.setColor(this.u);
            this.g.setTypeface(o());
            this.i = g(this.J);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 17) {
                this.j = e(this.L);
            }
            TextPaint textPaint = this.g;
            textPaint.bgColor = this.y;
            float f2 = this.F;
            if (!(f2 == 0.0f || (i2 = this.E) == 0)) {
                textPaint.setShadowLayer(f2, this.C, this.D, i2);
            }
            float f3 = this.O;
            if (f3 >= 0.0f && i4 >= 21) {
                this.g.setLetterSpacing(f3);
            }
            if (this.K > 0) {
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.s);
                valueOf.setSpan(new LeadingMarginSpan.Standard(this.K, 0), 0, valueOf.length(), 33);
                this.s = valueOf;
            }
            if (this.A == 1) {
                this.g.setUnderlineText(true);
            }
            if (this.B == 1) {
                this.g.setStrikeThruText(true);
            }
        }
    }

    private boolean r(char c2) {
        return c2 >= 9728 && c2 <= 10239;
    }

    private boolean s(String str) {
        return Pattern.compile("[🀀-🏿]|[🐀-🟿]").matcher(str).find();
    }

    private Layout t(int i2, CharSequence charSequence, boolean z2) {
        int i3 = i2 < 0 ? 0 : i2;
        boolean z3 = true;
        boolean z4 = this.q >= 0.0f;
        float f2 = (float) this.t;
        float descent = this.g.descent() - this.g.ascent();
        if (this.N < descent) {
            z3 = false;
        }
        this.o = l();
        this.p = i();
        if (z2) {
            if (z4 && !z3) {
                float f3 = this.q - (descent - f2);
                this.Q = f3;
                this.Q = Math.max(f3, 0.0f);
                this.R = false;
            }
            if (z3) {
                float f4 = descent - f2;
                float f5 = this.N;
                int i4 = (int) (((f5 - descent) + f4) / 2.0f);
                int max = Math.max((int) (((f5 - descent) - f4) / 2.0f), 0);
                int max2 = Math.max(i4, 0);
                this.o = l() + max;
                this.p = i() + max2;
                if (z4) {
                    this.Q = ((float) (max + max2)) + this.q;
                } else {
                    this.Q = (float) (max + max2);
                }
                this.R = false;
            }
        }
        return new StaticLayout(charSequence, this.g, i3, this.j, 1.0f, this.Q, this.R);
    }

    public void A(CharSequence charSequence) {
        this.P = charSequence;
        this.S = true;
    }

    public void B(int i2) {
        this.K = i2;
    }

    public void C(String str) {
        this.x = str;
    }

    public void D(boolean z2) {
        this.v = z2;
    }

    public void E(boolean z2) {
        this.w = z2;
    }

    public void F(int i2) {
        this.r = i2;
    }

    public void G(float f2) {
        this.O = f2;
        this.S = true;
    }

    public void H(int i2) {
        this.J = i2;
    }

    public void I(float f2) {
        this.N = f2;
    }

    public void J(float f2) {
        this.q = f2;
    }

    public void K(int i2) {
        this.H = i2;
        this.S = true;
    }

    public void L(int i2) {
        this.I = i2;
        this.S = true;
    }

    public void M(int i2) {
        this.G = i2;
        this.S = true;
    }

    public void N(int i2) {
        this.n = i2;
    }

    public void O(int i2) {
        this.k = i2;
        this.S = true;
    }

    public void P(int i2) {
        this.l = i2;
        this.S = true;
    }

    public void Q(int i2) {
        this.m = i2;
    }

    public void R(int i2) {
        this.E = i2;
    }

    public void S(float f2) {
        this.C = f2;
    }

    public void T(float f2) {
        this.D = f2;
    }

    public void U(float f2) {
        this.F = f2;
    }

    public void V(int i2) {
    }

    public void W(int i2) {
        this.B = i2;
    }

    public void X(RichText richText) {
        this.s = null;
        this.b = richText;
    }

    public void Y(int i2) {
        this.u = i2;
    }

    public void Z(int i2) {
        this.L = i2;
    }

    public void a0(int i2) {
        this.t = i2;
    }

    public void b0(Integer num) {
    }

    public void c0(int i2) {
        this.A = i2;
    }

    public void d(Canvas canvas) {
        this.d = (float) j();
        canvas.save();
        float f2 = this.d;
        int i2 = this.z;
        canvas.translate(f2 + ((float) i2), this.e + ((float) this.o) + ((float) i2));
        Layout layout = this.c;
        if (layout != null) {
            layout.draw(canvas);
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    @RequiresApi(api = 17)
    public Layout.Alignment e(int i2) {
        if (h() == 1) {
            if (i2 == 1) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            if (i2 != 2) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        } else if (i2 == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        } else {
            if (i2 != 2) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    public Context f() {
        return this.a;
    }

    public int h() {
        return this.r;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    @Nullable
    public <T> T[] m(int i2, int i3, Class<T> cls) {
        CharSequence charSequence;
        Layout layout;
        if (this.b == null) {
            return null;
        }
        if ((this.P instanceof Spannable) && (charSequence = this.f) != null && this.J == 3) {
            int length = charSequence.length() - this.P.length();
            int length2 = this.f.length();
            if (i2 >= length && i3 <= length2 && (layout = this.c) != null && this.T > layout.getLineCount()) {
                CharSequence charSequence2 = this.P;
                return (T[]) ((Spannable) charSequence2).getSpans(0, charSequence2.length(), cls);
            }
        }
        CharSequence renderText = this.b.renderText();
        if (!(renderText instanceof Spannable)) {
            return null;
        }
        return (T[]) ((Spannable) renderText).getSpans(i2, i3, cls);
    }

    public int n(float f2, float f3) {
        int i2 = (int) f2;
        int i3 = (int) f3;
        Layout layout = this.c;
        if (layout == null) {
            return -1;
        }
        int i4 = i2 - this.k;
        int lineForVertical = layout.getLineForVertical(i3 - this.o);
        int offsetForHorizontal = this.c.getOffsetForHorizontal(lineForVertical, (float) i4);
        int i5 = this.c.getPrimaryHorizontal(offsetForHorizontal) < f2 ? offsetForHorizontal + 1 : offsetForHorizontal - 1;
        int lineStart = this.c.getLineStart(lineForVertical);
        int lineEnd = this.c.getLineEnd(lineForVertical);
        if (i5 < lineStart) {
            return lineStart;
        }
        return i5 > lineEnd ? lineEnd : i5;
    }

    public boolean q() {
        Layout layout;
        return !this.P.equals(DEFAULT_ELLIPSIS_TEXT) && (layout = this.c) != null && this.T > layout.getLineCount();
    }

    public a u(int i2, int i3) {
        int i4;
        p();
        CharSequence charSequence = this.s;
        int i5 = 0;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            i4 = View.MeasureSpec.getSize(i2);
        } else {
            i4 = View.MeasureSpec.getSize(i2);
            if (charSequence != null) {
                i4 = Math.min(Math.min(((int) Math.ceil((double) Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.g))) + j() + k() + (this.z * 2), i4), this.G);
            }
        }
        if (i4 != 0 && !TextUtils.isEmpty(charSequence)) {
            int j2 = ((i4 - j()) - k()) - (this.z * 2);
            boolean z2 = this.f != null && !this.b.renderText().equals(charSequence);
            Layout layout = this.c;
            if (layout == null) {
                this.c = t(j2, charSequence, true);
            } else if (layout.getWidth() > j2 || z2 || this.S) {
                this.c = t(j2, charSequence, true);
                this.S = false;
            } else if (this.c.getWidth() < j2) {
                this.c.increaseWidthTo(i4);
            }
            this.T = this.c.getLineCount();
            if (this.c.getLineCount() > this.I) {
                charSequence = SpannableStringBuilder.valueOf(b(charSequence));
                this.c = t(j2, charSequence, false);
            } else {
                CharSequence charSequence2 = this.f;
                if (charSequence2 != null) {
                    charSequence = charSequence2;
                }
            }
        }
        if (this.c == null || charSequence == null) {
            return new a(i4, 0);
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            i5 = size;
        } else if (!TextUtils.isEmpty(charSequence)) {
            i5 = Math.min(Math.min(this.c.getHeight() + this.p + this.o + (this.z * 2), size), this.H);
        }
        this.e = c(i5, mode);
        CharSequence a2 = a(charSequence, i4);
        if (a2 != null) {
            charSequence = a2;
        }
        this.f = charSequence;
        return new a(i4, i5);
    }

    public void v(int i2) {
        this.M = i2;
    }

    public void w(int i2) {
    }

    public void x(int i2) {
        this.z = Math.max(i2, 0);
    }

    public void y(Context context) {
        this.a = context;
    }

    public void z(int i2) {
    }
}
