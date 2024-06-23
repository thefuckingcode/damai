package com.taobao.android.dinamicx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.c;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.util.FontUtil;
import com.taobao.android.dinamicx.view.DXMeasuredTextView;
import com.taobao.android.dinamicx.view.DXNativeTextView;
import java.util.HashMap;
import tb.a00;
import tb.at;
import tb.c00;
import tb.d00;
import tb.h10;
import tb.pk1;
import tb.py;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class DXTextViewWidgetNode extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static int q = 0;
    public static int r = 1;
    private static ThreadLocal<py> s = new ThreadLocal<>();
    private static ThreadLocal<HashMap<Class, DXMeasuredTextView>> t = new ThreadLocal<>();
    private static int u = 0;
    private DXMeasuredTextView a;
    private py b;
    CharSequence c = "";
    int d = -16777216;
    float e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    private String l;
    private boolean m = true;
    private boolean n = false;
    private int o = 32767;
    private int p = 1;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXTextViewWidgetNode();
        }
    }

    public DXTextViewWidgetNode() {
        if (q == 0 && DinamicXEngine.i() != null) {
            q = d00.c(DinamicXEngine.i(), 12.0f);
        }
        HashMap<Class, DXMeasuredTextView> hashMap = t.get();
        if (hashMap == null) {
            hashMap = new HashMap<>();
            t.set(hashMap);
        }
        DXMeasuredTextView dXMeasuredTextView = hashMap.get(getClass());
        this.a = dXMeasuredTextView;
        if (dXMeasuredTextView == null) {
            if (!at.G0()) {
                DXMeasuredTextView dXMeasuredTextView2 = new DXMeasuredTextView(DinamicXEngine.i());
                this.a = dXMeasuredTextView2;
                u = dXMeasuredTextView2.getPaintFlags();
                hashMap.put(getClass(), this.a);
            } else if (DinamicXEngine.i() != null) {
                DXMeasuredTextView dXMeasuredTextView3 = new DXMeasuredTextView(DinamicXEngine.i());
                this.a = dXMeasuredTextView3;
                u = dXMeasuredTextView3.getPaintFlags();
                hashMap.put(getClass(), this.a);
            } else {
                wz.b("DXTextViewWidgetNode create textViewUtilForMeasure 时 context是空");
            }
        }
        py pyVar = s.get();
        this.b = pyVar;
        if (pyVar == null) {
            py pyVar2 = new py();
            this.b = pyVar2;
            s.set(pyVar2);
        }
        this.e = (float) q;
        this.f = 0;
        this.j = -1;
        this.h = 0;
        this.i = 1;
        this.k = -1;
        this.l = "";
    }

    @SuppressLint({"WrongCall"})
    private void c(final int i2, final int i3, final int i4, final int i5) {
        if (at.H0()) {
            try {
                c00.l(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXTextViewWidgetNode.AnonymousClass1 */

                    public void run() {
                        try {
                            DXMeasuredTextView dXMeasuredTextView = new DXMeasuredTextView(DinamicXEngine.i());
                            DXTextViewWidgetNode.this.h(dXMeasuredTextView);
                            int i = R$id.dx_textview_font_tag;
                            if (dXMeasuredTextView.getTag(i) != null) {
                                int intValue = ((Integer) dXMeasuredTextView.getTag(i)).intValue();
                                if (intValue == 0) {
                                    DXTextViewWidgetNode dXTextViewWidgetNode = DXTextViewWidgetNode.this;
                                    dXMeasuredTextView.setTypeface(dXTextViewWidgetNode.e(dXTextViewWidgetNode.f));
                                    dXMeasuredTextView.onMeasure(i2, i3);
                                } else if (intValue == 1) {
                                    DXTextViewWidgetNode dXTextViewWidgetNode2 = DXTextViewWidgetNode.this;
                                    dXMeasuredTextView.setTypeface(Typeface.defaultFromStyle(dXTextViewWidgetNode2.f(dXTextViewWidgetNode2.f)));
                                    dXMeasuredTextView.onMeasure(i2, i3);
                                }
                                int measuredWidthAndState = dXMeasuredTextView.getMeasuredWidthAndState();
                                int measuredHeightAndState = (!TextUtils.isEmpty(DXTextViewWidgetNode.this.c) || DXTextViewWidgetNode.this.layoutHeight != -2) ? dXMeasuredTextView.getMeasuredHeightAndState() : 0;
                                if (measuredWidthAndState != i4 || measuredHeightAndState != i5) {
                                    DXAppMonitor.p(DXTextViewWidgetNode.this.getDXRuntimeContext(), "DX_TextView_Font", "DX_TextView_Font_Measure_Error", e.DX_TEXTVIEW_FONT_MEASURE_ERROR, String.format("text view 宽高计算不一致[width=%s height=%s measuredWidth=%s measuredHeight=%s  manufacturer=%s romName=%s romverName=%s systemModel=%s brand=%s fontStyle=%s  useTypeface=%s]", Integer.valueOf(measuredWidthAndState), Integer.valueOf(measuredHeightAndState), Integer.valueOf(i4), Integer.valueOf(i5), pk1.a(), pk1.d(), pk1.e(), pk1.f(), Build.getBRAND(), intValue + "", at.I0() + ""));
                                }
                            }
                        } catch (Throwable th) {
                            vx.b(th);
                        }
                    }
                });
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    public static void d() {
        t = new ThreadLocal<>();
        q = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Typeface e(int i2) {
        Typeface typeface = Typeface.DEFAULT;
        if (i2 == 0) {
            return typeface;
        }
        if (i2 == 1) {
            return Typeface.DEFAULT_BOLD;
        }
        if (i2 == 2) {
            return Typeface.defaultFromStyle(2);
        }
        if (i2 != 3) {
            return typeface;
        }
        return Typeface.defaultFromStyle(3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int f(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                return i2 != 3 ? 0 : 3;
            }
            return 2;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXTextViewWidgetNode();
    }

    public int g() {
        return this.d;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == 5737767606580872653L) {
            return -16777216;
        }
        if (j2 == 6751005219504497256L) {
            return q;
        }
        if (j2 == a00.DXRICHTEXT_MAXLINES) {
            return r;
        }
        if (j2 == 4822617398935994384L) {
            return 1;
        }
        if (j2 == 1174195049226651996L) {
            return 0;
        }
        if (j2 == -7175398628172498739L) {
            return 32767;
        }
        if (j2 == 5734523154528465099L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j2) {
        return j2 == 38178040921L ? "" : super.getDefaultValueForStringAttr(j2);
    }

    /* access modifiers changed from: protected */
    public void h(TextView textView) {
        ViewGroup.LayoutParams layoutParams;
        i(textView);
        py pyVar = this.b;
        pyVar.a = this.layoutWidth;
        pyVar.b = this.layoutHeight;
        pyVar.c = this.weight;
        int i2 = this.layoutGravity;
        if (i2 != pyVar.e) {
            pyVar.d = h10.a(DXWidgetNode.getAbsoluteGravity(i2, getDirection()));
            this.b.e = this.layoutGravity;
        }
        f fVar = (f) this.parentWidget;
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = fVar.generateLayoutParams(this.b);
        } else {
            layoutParams = fVar.generateLayoutParams(this.b, layoutParams2);
        }
        textView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void i(TextView textView) {
        o(textView, this.c);
        float textSize = textView.getTextSize();
        float f2 = this.e;
        if (textSize != f2) {
            textView.setTextSize(0, f2);
        }
        if (!TextUtils.isEmpty(this.l)) {
            q(textView, this.l, this.f);
        } else {
            s(textView, this.f);
        }
        m(textView, this.i);
        l(textView, this.j);
        n(textView, this.k);
        p(textView, this.g);
    }

    /* access modifiers changed from: protected */
    public void j(TextView textView, int i2, int i3) {
        if (this.n && i3 > 0 && i2 > 0) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, 1, 0);
                } else {
                    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, i2, i3, 1, 0);
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(TextView textView, int i2) {
        textView.setTag(R$id.dx_textview_font_tag, 0);
        textView.setTypeface(Typeface.defaultFromStyle(f(i2)));
    }

    /* access modifiers changed from: protected */
    public void l(TextView textView, int i2) {
        if (i2 == 0) {
            textView.setEllipsize(null);
        } else if (i2 == 1) {
            textView.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i2 == 2) {
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i2 == 3) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    /* access modifiers changed from: protected */
    public void m(TextView textView, int i2) {
        if (i2 > 0) {
            textView.setMaxLines(i2);
        } else {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    /* access modifiers changed from: protected */
    public void n(TextView textView, int i2) {
        if (i2 > 0) {
            textView.setMaxWidth(i2);
        } else {
            textView.setMaxWidth(Integer.MAX_VALUE);
        }
    }

    /* access modifiers changed from: protected */
    public void o(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setText("");
        } else {
            textView.setText(charSequence);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXTextViewWidgetNode) {
            DXTextViewWidgetNode dXTextViewWidgetNode = (DXTextViewWidgetNode) dXWidgetNode;
            this.f = dXTextViewWidgetNode.f;
            this.h = dXTextViewWidgetNode.h;
            this.i = dXTextViewWidgetNode.i;
            this.j = dXTextViewWidgetNode.j;
            this.k = dXTextViewWidgetNode.k;
            this.c = dXTextViewWidgetNode.c;
            this.d = dXTextViewWidgetNode.d;
            this.e = dXTextViewWidgetNode.e;
            this.g = dXTextViewWidgetNode.g;
            this.l = dXTextViewWidgetNode.l;
            this.m = dXTextViewWidgetNode.m;
            this.n = dXTextViewWidgetNode.n;
            this.o = dXTextViewWidgetNode.o;
            this.p = dXTextViewWidgetNode.p;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeTextView(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext;
        if (this.m && (dXRuntimeContext = this.dXRuntimeContext) != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.e = c.b(this.dXRuntimeContext, this.e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i2, int i3) {
        DXMeasuredTextView dXMeasuredTextView;
        if (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) {
            setMeasuredDimension(i2, i3);
            return;
        }
        if (at.z0() && ((dXMeasuredTextView = this.a) == null || dXMeasuredTextView.getInitThreadId() != Thread.currentThread().getId())) {
            HashMap<Class, DXMeasuredTextView> hashMap = t.get();
            if (hashMap == null) {
                hashMap = new HashMap<>();
                t.set(hashMap);
            }
            DXMeasuredTextView dXMeasuredTextView2 = hashMap.get(getClass());
            this.a = dXMeasuredTextView2;
            if (dXMeasuredTextView2 == null) {
                DXMeasuredTextView dXMeasuredTextView3 = new DXMeasuredTextView(DinamicXEngine.i());
                this.a = dXMeasuredTextView3;
                u = dXMeasuredTextView3.getPaintFlags();
                hashMap.put(getClass(), this.a);
            }
        }
        h(this.a);
        this.a.onMeasure(i2, i3);
        if (!TextUtils.isEmpty(this.c) || this.layoutHeight != -2) {
            setMeasuredDimension(this.a.getMeasuredWidthAndState(), this.a.getMeasuredHeightAndState());
        } else {
            setMeasuredDimension(this.a.getMeasuredWidthAndState(), 0);
        }
        c(i2, i3, this.measuredWidth, this.measuredHeight);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            o(textView, this.c);
            textView.setTextColor(tryFetchDarkModeColor("textColor", 0, this.d));
            textView.setTextSize(0, this.e);
            if (!TextUtils.isEmpty(this.l)) {
                q(textView, this.l, this.f);
            } else {
                int i2 = this.f;
                if (i2 != -1) {
                    s(textView, i2);
                }
            }
            m(textView, this.i);
            r(textView, this.h);
            int i3 = this.j;
            if (i3 != -1) {
                l(textView, i3);
            }
            int i4 = this.k;
            if (i4 != -1) {
                n(textView, i4);
            }
            p(textView, this.g);
            j(textView, this.p, this.o);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j2, double d2) {
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (5737767606580872653L == j2) {
            this.d = i2;
        } else if (a00.DXRICHTEXT_TEXTGRAVITY == j2) {
            this.h = i2;
        } else if (a00.DXRICHTEXT_MAXLINES == j2) {
            if (i2 > 0) {
                this.i = i2;
            } else {
                this.i = Integer.MAX_VALUE;
            }
        } else if (a00.DXRICHTEXT_MAXWIDTH == j2) {
            if (i2 > 0) {
                this.k = i2;
            } else {
                this.k = Integer.MAX_VALUE;
            }
        } else if (a00.DXRICHTEXT_LINEBREAKMODE == j2) {
            this.j = i2;
        } else if (6751005219504497256L != j2) {
            boolean z = true;
            if (9423384817756195L == j2) {
                int i3 = this.f;
                this.f = i2 > 0 ? i3 | 1 : i3 & -2;
            } else if (3527554185889034042L == j2) {
                int i4 = this.f;
                this.f = i2 > 0 ? i4 | 2 : i4 & -3;
            } else if (-1740854880214056386L == j2) {
                int i5 = this.g;
                this.g = i2 > 0 ? i5 | 17 : i5 & -18;
            } else if (-8089424158689439347L == j2) {
                int i6 = this.g;
                this.g = i2 > 0 ? i6 | 9 : i6 & -10;
            } else if (4822617398935994384L == j2) {
                if (i2 == 0) {
                    z = false;
                }
                this.m = z;
            } else if (1174195049226651996L == j2) {
                if (i2 == 0) {
                    z = false;
                }
                this.n = z;
            } else if (-7175398628172498739L == j2) {
                if (i2 > 0) {
                    this.o = i2;
                } else {
                    this.o = 32767;
                }
            } else if (5734523154528465099L != j2) {
                super.onSetIntAttribute(j2, i2);
            } else if (i2 > 0) {
                this.p = i2;
            } else {
                this.p = 1;
            }
        } else if (i2 > 0) {
            this.e = (float) i2;
        } else {
            this.e = (float) q;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (38178040921L == j2) {
            this.c = str;
        } else if (j2 == 34149272427L) {
            this.l = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }

    /* access modifiers changed from: protected */
    public void p(TextView textView, int i2) {
        if (i2 != textView.getPaintFlags()) {
            if (i2 == 0) {
                i2 = u;
            }
            textView.getPaint().setFlags(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void q(TextView textView, String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (DinamicXEngine.i() == null) {
                    s(textView, i2);
                    return;
                }
                Typeface b2 = FontUtil.c().b(str, f(i2));
                if (b2 != null) {
                    textView.setTypeface(b2);
                    textView.setTag(R$id.dx_textview_font_tag, 2);
                    return;
                }
                s(textView, i2);
            } catch (Throwable th) {
                s(textView, i2);
                vx.c(th, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(TextView textView, int i2) {
        if (getDirection() == 1) {
            if (i2 == 0) {
                textView.setGravity(21);
            } else if (i2 == 1) {
                textView.setGravity(17);
            } else if (i2 == 2) {
                textView.setGravity(19);
            } else {
                textView.setGravity(16);
            }
        } else if (i2 == 0) {
            textView.setGravity(19);
        } else if (i2 == 1) {
            textView.setGravity(17);
        } else if (i2 == 2) {
            textView.setGravity(21);
        } else {
            textView.setGravity(16);
        }
    }

    /* access modifiers changed from: protected */
    public void s(TextView textView, int i2) {
        if (at.I0()) {
            v(textView, i2);
        } else {
            k(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            String str = this.accessibilityText;
            if (str != null) {
                view.setContentDescription(str);
            }
            int i2 = this.accessibility;
            if (i2 != 3) {
                if (i2 == 1 || i2 == -1) {
                    view.setImportantForAccessibility(1);
                    view.setFocusable(true);
                } else if (i2 == 2) {
                    view.setImportantForAccessibility(4);
                } else {
                    view.setImportantForAccessibility(2);
                }
            }
        } else {
            view.setContentDescription("");
        }
    }

    public void t(CharSequence charSequence) {
        this.c = charSequence;
    }

    public void u(int i2) {
        this.d = i2;
    }

    /* access modifiers changed from: protected */
    public void v(TextView textView, int i2) {
        textView.setTag(R$id.dx_textview_font_tag, 1);
        textView.setTypeface(e(i2));
    }
}
