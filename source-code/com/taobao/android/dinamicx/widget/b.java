package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeCountDownTimerView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.d00;
import tb.lx;

/* compiled from: Taobao */
public class b extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_BOLD = 1;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_NONE = -1;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_NORMAL = 0;
    private boolean A = true;
    private boolean B = false;
    private int C = 1;
    private boolean D = false;
    private boolean E = false;
    private int F = -1;
    private String a = ":";
    private int b = -16777216;
    private int c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h = -16777216;
    private int i;
    private int j;
    private int k;
    private int l;
    private double m = 12.0d;
    private int n = -16777216;
    private int o;
    private int p = -1;
    private int q = 0;
    private int r = 0;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private long x;
    private double y = 10.0d;
    private double z = 12.0d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements DXNativeCountDownTimerView.OnFinishListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.OnFinishListener
        public void onFinish() {
            b.this.postEvent(new lx(-6786364507638278416L));
        }
    }

    /* renamed from: com.taobao.android.dinamicx.widget.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0211b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new b();
        }
    }

    public b() {
        if (DinamicXEngine.i() != null) {
            this.y = (double) d00.c(DinamicXEngine.i(), 10.0f);
            this.z = (double) d00.c(DinamicXEngine.i(), 12.0f);
            this.m = (double) d00.c(DinamicXEngine.i(), 12.0f);
        }
    }

    private Typeface a(int i2) {
        return Typeface.defaultFromStyle(i2 != 0 ? 1 : 0);
    }

    private void b(DXNativeCountDownTimerView dXNativeCountDownTimerView, int i2, int i3, int i4, int i5, double d2, int i6, String str) {
        TextView colonFirst = dXNativeCountDownTimerView.getColonFirst();
        TextView colonSecond = dXNativeCountDownTimerView.getColonSecond();
        TextView colonThird = dXNativeCountDownTimerView.getColonThird();
        e(colonFirst, i2, i3, i4, i5, 0, 0, d2, i6);
        e(colonSecond, i2, i3, i4, i5, 0, 0, d2, i6);
        if (this.B) {
            colonThird.setVisibility(0);
            e(colonThird, i2, i3, i4, i5, 0, 0, d2, i6);
        } else {
            colonThird.setVisibility(8);
        }
        colonFirst.setText(str);
        colonSecond.setText(str);
        colonThird.setText(str);
        int i7 = this.F;
        if (i7 != -1) {
            Typeface a2 = a(i7);
            colonFirst.setTypeface(a2);
            colonSecond.setTypeface(a2);
            colonThird.setTypeface(a2);
        }
    }

    private void c(DXNativeCountDownTimerView dXNativeCountDownTimerView, long j2, long j3) {
        dXNativeCountDownTimerView.setFutureTime(j2);
        dXNativeCountDownTimerView.setCurrentTime(j3);
        if (dXNativeCountDownTimerView.getLastTime() > 0) {
            dXNativeCountDownTimerView.showCountDown();
            dXNativeCountDownTimerView.updateCountView();
            dXNativeCountDownTimerView.getTimer().start();
            dXNativeCountDownTimerView.setOnFinishListener(new a());
            return;
        }
        dXNativeCountDownTimerView.hideCountDown();
        dXNativeCountDownTimerView.getTimer().stop();
        postEvent(new lx(-6786364507638278416L));
    }

    private void d(DXNativeCountDownTimerView dXNativeCountDownTimerView, String str, int i2, int i3, int i4, int i5, double d2, int i6) {
        TextView seeMoreView = dXNativeCountDownTimerView.getSeeMoreView();
        seeMoreView.setText(str);
        e(seeMoreView, i2, i3, i4, i5, 0, 0, d2, i6);
    }

    private void e(TextView textView, int i2, int i3, int i4, int i5, int i6, int i7, double d2, int i8) {
        textView.setTextSize(0, (float) d2);
        textView.setTextColor(i8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (i6 != 0) {
            marginLayoutParams.width = i6;
        }
        if (i7 != 0) {
            marginLayoutParams.height = i7;
        }
        marginLayoutParams.setMargins(i2, i3, i4, i5);
        textView.setLayoutParams(marginLayoutParams);
    }

    private void f(TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f2 = (float) i3;
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(i2);
        textView.setBackgroundDrawable(gradientDrawable);
        textView2.setBackgroundDrawable(gradientDrawable);
        textView3.setBackgroundDrawable(gradientDrawable);
        if (!this.B) {
            return;
        }
        if (this.C != 1 || !this.D) {
            textView4.setBackgroundDrawable(gradientDrawable);
            return;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f2);
        gradientDrawable2.setColor(i2);
        textView4.setBackgroundDrawable(gradientDrawable2);
    }

    private void g(DXNativeCountDownTimerView dXNativeCountDownTimerView, int i2, int i3, int i4, int i5, int i6, int i7, double d2, int i8, int i9, int i10) {
        TextView hour = dXNativeCountDownTimerView.getHour();
        TextView minute = dXNativeCountDownTimerView.getMinute();
        TextView second = dXNativeCountDownTimerView.getSecond();
        TextView milli = dXNativeCountDownTimerView.getMilli();
        e(hour, i2, i3, i4, i5, i6, i7, d2, i8);
        e(minute, i2, i3, i4, i5, i6, i7, d2, i8);
        e(second, i2, i3, i4, i5, i6, i7, d2, i8);
        if (this.B) {
            milli.setVisibility(0);
            e(milli, i2, i3, i4, i5, (this.C != 1 || !this.D || i6 <= 0) ? i6 : i6 / 2, i7, d2, i8);
        } else {
            milli.setVisibility(8);
        }
        f(hour, minute, second, milli, i9, i10);
        int i11 = this.F;
        if (i11 != -1) {
            Typeface a2 = a(i11);
            hour.setTypeface(a2);
            milli.setTypeface(a2);
            minute.setTypeface(a2);
            second.setTypeface(a2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new b();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == 836506953899434884L || j2 == -7569082268550024243L) {
            return -16777216;
        }
        if (j2 == 3586614778875286483L) {
            return -1;
        }
        if (j2 == -502340563974947291L || j2 == -7371269035395216254L) {
            return 1;
        }
        if (j2 == -8574960089337605395L) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z2) {
        super.onClone(dXWidgetNode, z2);
        if (dXWidgetNode instanceof b) {
            b bVar = (b) dXWidgetNode;
            this.w = bVar.w;
            this.x = bVar.x;
            this.b = bVar.b;
            this.a = bVar.a;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.y = bVar.y;
            this.g = bVar.g;
            this.m = bVar.m;
            this.h = bVar.h;
            this.j = bVar.j;
            this.l = bVar.l;
            this.k = bVar.k;
            this.i = bVar.i;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.v = bVar.v;
            this.u = bVar.u;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeCountDownTimerView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z2 = true;
        int i4 = 0;
        boolean z3 = a2 == 1073741824;
        if (a3 != 1073741824) {
            z2 = false;
        }
        int b2 = z3 ? DXWidgetNode.DXMeasureSpec.b(i2) : 0;
        if (z2) {
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(b2, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof DXNativeCountDownTimerView)) {
            DXNativeCountDownTimerView dXNativeCountDownTimerView = (DXNativeCountDownTimerView) view;
            if (!(getDXRuntimeContext() == null || getDXRuntimeContext().getEngineContext() == null)) {
                long a2 = getDXRuntimeContext().getEngineContext().a();
                if (this.E && a2 > 0) {
                    this.w = a2;
                }
            }
            dXNativeCountDownTimerView.setShowMilliSecond(this.B);
            dXNativeCountDownTimerView.setMilliSecondDigitCount(this.C);
            int tryFetchDarkModeColor = tryFetchDarkModeColor("colonTextColor", 0, this.b);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("seeMoreTextColor", 0, this.h);
            int tryFetchDarkModeColor3 = tryFetchDarkModeColor("timerBackgroundColor", 1, this.n);
            g(dXNativeCountDownTimerView, this.t, this.v, this.u, this.s, this.r, this.q, this.z, tryFetchDarkModeColor("timerTextColor", 0, this.p), tryFetchDarkModeColor3, this.o);
            b(dXNativeCountDownTimerView, this.d, this.f, this.e, this.c, this.y, tryFetchDarkModeColor, this.a);
            d(dXNativeCountDownTimerView, this.g, this.j, this.l, this.k, this.i, this.m, tryFetchDarkModeColor2);
            dXNativeCountDownTimerView.setShowSeeMoreText(this.A);
            c(dXNativeCountDownTimerView, this.x, this.w);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (-7569082268550024243L == j2) {
            this.b = i2;
        } else if (-5446467777356887384L == j2) {
            this.c = i2;
        } else if (-2349968600282703684L == j2) {
            this.d = i2;
        } else if (-4097512581907102928L == j2) {
            this.e = i2;
        } else if (2974479846771431523L == j2) {
            this.f = i2;
        } else if (836506953899434884L == j2) {
            this.h = i2;
        } else if (-6389039416330352289L == j2) {
            this.i = i2;
        } else if (-991465590347635341L == j2) {
            this.j = i2;
        } else if (6878642454060075239L == j2) {
            this.k = i2;
        } else if (-1982127542287307750L == j2) {
            this.l = i2;
        } else if (-2066932502216216012L == j2) {
            this.n = i2;
        } else if (-7541914668888054013L == j2) {
            this.o = i2;
        } else if (3586614778875286483L == j2) {
            this.p = i2;
        } else if (-5195705055003868114L == j2) {
            this.q = i2;
        } else if (3588042683016644308L == j2) {
            this.r = i2;
        } else if (4113718844605699246L == j2) {
            this.s = i2;
        } else if (4975799217651406530L == j2) {
            this.t = i2;
        } else if (-5434794314794449098L == j2) {
            this.u = i2;
        } else if (-3498357187900469143L == j2) {
            this.v = i2;
        } else if (-5268712888762272737L == j2) {
            this.m = (double) i2;
        } else if (9031654720231161192L == j2) {
            this.y = (double) i2;
        } else if (5087222913038931822L == j2) {
            this.z = (double) i2;
        } else {
            boolean z2 = true;
            if (-502340563974947291L == j2) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.A = z2;
            } else if (-2361257553306292445L == j2) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.B = z2;
            } else if (-7371269035395216254L == j2) {
                this.C = i2;
            } else if (-8574960089337605395L == j2) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.D = z2;
            } else if (-1047143332071710891L == j2) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.E = z2;
            } else if (j2 == -435593654112940591L) {
                this.F = i2;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j2, long j3) {
        if (8195572952744500637L == j2) {
            this.w = j3;
        } else if (8766053855851211060L == j2) {
            this.x = j3;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (7523271490450403529L == j2) {
            this.a = str;
        } else if (4189101800495477120L == j2) {
            this.g = str;
        }
    }
}
