package com.taobao.android.dinamicx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXNativeFastText;
import tb.a00;
import tb.d00;
import tb.v00;

/* compiled from: Taobao */
public class c extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final CharSequence ELLIPSIS_TEXT = "…";
    public static int v = 0;
    public static int w = 1;
    int a;
    int b;
    int c;
    int d;
    int e = -16777216;
    float f;
    CharSequence g = "";
    protected TextPaint h;
    StaticLayout i;
    int j;
    int k;
    CharSequence l = "";
    TextUtils.TruncateAt m;
    float n;
    int o;
    int p;
    private boolean q = true;
    Layout.Alignment r;
    int s = -1;
    int t = -1;
    int u;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new c();
        }
    }

    public c() {
        if (v == 0 && DinamicXEngine.i() != null) {
            v = d00.c(DinamicXEngine.i(), 12.0f);
        }
        this.f = (float) v;
        this.k = 0;
        this.c = -1;
        this.b = 0;
        this.j = w;
        this.d = Integer.MAX_VALUE;
    }

    private void a() {
        int i2;
        int lineEnd = this.i.getLineEnd(this.j - 1);
        if (lineEnd <= 0) {
            try {
                this.l = "";
            } catch (Exception e2) {
                this.l = this.g.subSequence(0, lineEnd);
                if (getDXRuntimeContext() == null || TextUtils.isEmpty(getDXRuntimeContext().getBizType())) {
                    e eVar = new e(v00.DB_NAME);
                    eVar.c.add(new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80005));
                    DXAppMonitor.n(eVar);
                } else {
                    e dxError = getDXRuntimeContext().getDxError();
                    dxError.b = getDXRuntimeContext().getDxTemplateItem();
                    dxError.c.add(new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80005));
                }
                if (DinamicXEngine.x()) {
                    e2.printStackTrace();
                }
            }
        } else {
            if (this.m != null) {
                if (this.g.length() != 1) {
                    TextPaint textPaint = this.h;
                    CharSequence charSequence = ELLIPSIS_TEXT;
                    float width = ((float) this.i.getWidth()) - textPaint.measureText(charSequence, 0, charSequence.length());
                    int lineStart = this.i.getLineStart(this.j - 1);
                    TextUtils.TruncateAt truncateAt = this.m;
                    if (truncateAt == TextUtils.TruncateAt.END) {
                        int i3 = lineEnd - 1;
                        while (true) {
                            if (i3 < lineStart) {
                                i3 = 0;
                                break;
                            }
                            CharSequence subSequence = this.g.subSequence(lineStart, i3);
                            if (this.h.measureText(subSequence, 0, subSequence.length()) < width) {
                                break;
                            }
                            i3--;
                        }
                        this.l = this.g.subSequence(0, i3).toString() + ((Object) ELLIPSIS_TEXT);
                        return;
                    } else if (truncateAt == TextUtils.TruncateAt.START && this.j == 1) {
                        int length = this.g.length();
                        int i4 = length - 1;
                        while (true) {
                            if (i4 < 0) {
                                i2 = 0;
                                break;
                            } else if (this.h.measureText(this.g, i4, length) > width) {
                                i2 = i4 + 1;
                                break;
                            } else {
                                i4--;
                            }
                        }
                        this.l = ((Object) ELLIPSIS_TEXT) + this.g.subSequence(i2, length).toString();
                        return;
                    } else if (truncateAt == TextUtils.TruncateAt.MIDDLE && this.j == 1) {
                        int length2 = this.g.length();
                        float f2 = 0.0f;
                        int i5 = length2;
                        float f3 = 0.0f;
                        int i6 = 0;
                        boolean z = true;
                        int i7 = 0;
                        while (true) {
                            if (i6 >= length2) {
                                break;
                            }
                            if (z) {
                                i7++;
                                f2 = this.h.measureText(this.g, 0, i7);
                                if (f2 + f3 > width) {
                                    i7--;
                                    break;
                                }
                                z = false;
                            } else {
                                i5--;
                                f3 = this.h.measureText(this.g, i5, length2);
                                if (f2 + f3 > width) {
                                    i5++;
                                    break;
                                }
                                z = true;
                            }
                            i6++;
                        }
                        this.l = this.g.subSequence(0, i7).toString() + ((Object) ELLIPSIS_TEXT) + ((Object) this.g.subSequence(i5, length2));
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.l = this.g.subSequence(0, lineEnd);
        }
    }

    private StaticLayout h(int i2, CharSequence charSequence) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = this.t >= 0;
        float e2 = e();
        float descent = this.h.descent() - this.h.ascent();
        boolean z4 = ((float) this.s) >= descent;
        this.o = getPaddingTop();
        this.p = getPaddingBottom();
        float f3 = 0.0f;
        if (z3 && !z4) {
            f3 = Math.max(((float) this.t) - (descent - e2), 0.0f);
            z2 = false;
        }
        if (z4) {
            float f4 = descent - e2;
            int i3 = this.s;
            int i4 = (int) (((((float) i3) - descent) + f4) / 2.0f);
            int max = Math.max((int) (((((float) i3) - descent) - f4) / 2.0f), 0);
            int max2 = Math.max(i4, 0);
            this.o = getPaddingTop() + max;
            this.p = getPaddingBottom() + max2;
            f2 = (float) (z3 ? max + max2 + this.t : max + max2);
            z = false;
        } else {
            z = z2;
            f2 = f3;
        }
        return new StaticLayout(charSequence, this.h, i2, this.r, 1.0f, f2, z);
    }

    /* access modifiers changed from: protected */
    public float b(int i2) {
        int height = this.i.getHeight();
        int measuredHeight = (getMeasuredHeight() - this.o) - this.p;
        if (height >= measuredHeight || i2 != 1073741824) {
            return 0.0f;
        }
        return (float) ((measuredHeight - height) >> 1);
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new c();
    }

    /* access modifiers changed from: protected */
    public Layout.Alignment c(int i2) {
        if (getDirection() == 1) {
            if (i2 == 0) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            if (i2 == 1) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            if (i2 != 2) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        } else if (i2 == 0) {
            return Layout.Alignment.ALIGN_NORMAL;
        } else {
            if (i2 == 1) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            if (i2 != 2) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    /* access modifiers changed from: protected */
    public TextUtils.TruncateAt d(int i2) {
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

    public float e() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public Typeface f(int i2) {
        if (i2 == 0) {
            return Typeface.defaultFromStyle(0);
        }
        if (i2 == 1) {
            return Typeface.defaultFromStyle(1);
        }
        if (i2 == 2) {
            return Typeface.defaultFromStyle(2);
        }
        if (i2 != 3) {
            return Typeface.defaultFromStyle(0);
        }
        return Typeface.defaultFromStyle(3);
    }

    /* access modifiers changed from: protected */
    public void g() {
        if (this.h == null) {
            this.h = new TextPaint();
        }
        this.h.setAntiAlias(true);
        this.h.setTextSize(this.f);
        this.h.setColor(tryFetchDarkModeColor("textColor", 0, this.e));
        this.h.setTypeface(f(this.k));
        int i2 = this.a;
        if (i2 > 0) {
            this.h.setFlags(i2);
        }
        this.m = d(this.c);
        this.r = c(this.b);
        if (this.accessibilityText == null) {
            setAccessibilityText(this.g.toString());
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == 5737767606580872653L) {
            return -16777216;
        }
        if (j2 == 6751005219504497256L) {
            return v;
        }
        if (j2 == a00.DXRICHTEXT_MAXLINES) {
            return w;
        }
        if (j2 == a00.DXRICHTEXT_LINESPACING || j2 == a00.DXRICHTEXT_LINEHEIGHT) {
            return -1;
        }
        if (j2 == 4822617398935994384L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j2) {
        return j2 == 38178040921L ? "" : super.getDefaultValueForStringAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof c) {
            c cVar = (c) dXWidgetNode;
            this.k = cVar.k;
            this.b = cVar.b;
            this.j = cVar.j;
            this.c = cVar.c;
            this.d = cVar.d;
            this.g = cVar.g;
            this.e = cVar.e;
            this.f = cVar.f;
            this.a = cVar.a;
            this.l = cVar.l;
            this.h = cVar.h;
            this.i = cVar.i;
            this.m = cVar.m;
            this.n = cVar.n;
            this.r = cVar.r;
            this.s = cVar.s;
            this.t = cVar.t;
            this.o = cVar.o;
            this.p = cVar.p;
            this.u = cVar.u;
            this.q = cVar.q;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeFastText(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext;
        if (this.q && (dXRuntimeContext = this.dXRuntimeContext) != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.f = com.taobao.android.dinamicx.c.b(this.dXRuntimeContext, this.f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i2, int i3) {
        int i4;
        this.l = this.g;
        g();
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            i4 = View.MeasureSpec.getSize(i2);
            this.i = h((i4 - getPaddingLeft()) - getPaddingRight(), this.l);
        } else {
            i4 = Math.min(Math.min(((int) this.h.measureText(this.g.toString())) + getPaddingLeft() + getPaddingRight(), View.MeasureSpec.getSize(i2)), this.d);
            this.i = h((i4 - getPaddingLeft()) - getPaddingRight(), this.g);
        }
        int i5 = this.j;
        if (i5 <= 0 || i5 >= this.i.getLineCount()) {
            this.l = this.g;
        } else {
            this.u = this.i.getLineCount();
            a();
            this.i = h((i4 - getPaddingLeft()) - getPaddingRight(), this.l);
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!TextUtils.isEmpty(this.g) || this.layoutHeight != -2) {
                int height = this.i.getHeight() + this.p + this.o;
                int i6 = this.j;
                if (i6 > 0 && i6 < this.i.getLineCount()) {
                    height = this.i.getLineTop(this.j);
                }
                size = Math.min(height, size);
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(i4, size);
        this.n = b(mode);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof DXNativeFastText)) {
            DXNativeFastText dXNativeFastText = (DXNativeFastText) view;
            StaticLayout staticLayout = this.i;
            if (staticLayout != null) {
                dXNativeFastText.setStaticLayout(staticLayout);
            }
            dXNativeFastText.setTranslateY(this.n + ((float) this.o));
            dXNativeFastText.setTranslateX((float) getPaddingLeft());
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (5737767606580872653L == j2) {
            this.e = i2;
        } else if (a00.DXRICHTEXT_TEXTGRAVITY == j2) {
            this.b = i2;
        } else if (a00.DXRICHTEXT_MAXLINES == j2) {
            if (i2 > 0) {
                this.j = i2;
            } else {
                this.j = Integer.MAX_VALUE;
            }
        } else if (a00.DXRICHTEXT_MAXWIDTH == j2) {
            if (i2 > 0) {
                this.d = i2;
            } else {
                this.d = Integer.MAX_VALUE;
            }
        } else if (a00.DXRICHTEXT_LINEBREAKMODE == j2) {
            this.c = i2;
        } else if (6751005219504497256L != j2) {
            boolean z = true;
            if (9423384817756195L == j2) {
                int i3 = this.k;
                this.k = i2 > 0 ? i3 | 1 : i3 & -2;
            } else if (3527554185889034042L == j2) {
                int i4 = this.k;
                this.k = i2 > 0 ? i4 | 2 : i4 & -3;
            } else if (-1740854880214056386L == j2) {
                int i5 = this.a;
                this.a = i2 > 0 ? i5 | 17 : i5 & -18;
            } else if (-8089424158689439347L == j2) {
                int i6 = this.a;
                this.a = i2 > 0 ? i6 | 9 : i6 & -10;
            } else if (a00.DXRICHTEXT_LINEHEIGHT == j2) {
                this.s = i2;
            } else if (a00.DXRICHTEXT_LINESPACING == j2) {
                this.t = i2;
            } else if (4822617398935994384L == j2) {
                if (i2 == 0) {
                    z = false;
                }
                this.q = z;
            } else {
                super.onSetIntAttribute(j2, i2);
            }
        } else if (i2 > 0) {
            this.f = (float) i2;
        } else {
            this.f = (float) v;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (38178040921L == j2) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j2, str);
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
}
