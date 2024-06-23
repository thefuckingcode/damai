package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.richtext.DXNativeRichText;
import com.taobao.android.dinamicx.view.richtext.node.RichText;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;
import java.util.ArrayList;
import java.util.List;
import tb.s12;

/* compiled from: Taobao */
public class a00 extends com.taobao.android.dinamicx.widget.f {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final long DXRICHTEXT_BASELINE = 1445754069157927243L;
    public static final int DXRICHTEXT_BASELINE_BOTTOM = 0;
    public static final int DXRICHTEXT_BASELINE_MIDDLE = 1;
    public static final int DXRICHTEXT_BASELINE_TOP = 2;
    public static final long DXRICHTEXT_ENABLECUSTOMTRUNCATION = -7904255114002670305L;
    public static final long DXRICHTEXT_ENABLETEXTSIZESTRATEGY = 4822617398935994384L;
    public static final long DXRICHTEXT_EXPANDED = 2355535793353806417L;
    public static final long DXRICHTEXT_EXPANDLINES = 8720999726396813958L;
    public static final long DXRICHTEXT_FIRSTLINEHEADINDENT = 4761283217210504855L;
    public static final long DXRICHTEXT_FONT = 34149272427L;
    public static final long DXRICHTEXT_FORCEORIGINAL = -6490331624039946159L;
    public static final long DXRICHTEXT_IGNOREUNTRUNCATEDTAP = 867831422994583882L;
    public static final long DXRICHTEXT_ISBOLD = 9423384817756195L;
    public static final long DXRICHTEXT_ISITALIC = 3527554185889034042L;
    public static final long DXRICHTEXT_LINEBREAKMODE = 1650157837879951391L;
    public static final int DXRICHTEXT_LINEBREAKMODE_CHAR = 4;
    public static final int DXRICHTEXT_LINEBREAKMODE_END = 3;
    public static final int DXRICHTEXT_LINEBREAKMODE_MIDDLE = 2;
    public static final int DXRICHTEXT_LINEBREAKMODE_NONE = 0;
    public static final int DXRICHTEXT_LINEBREAKMODE_START = 1;
    public static final long DXRICHTEXT_LINEHEIGHT = 6086495633913771275L;
    public static final long DXRICHTEXT_LINESPACING = -2369181291898902408L;
    public static final long DXRICHTEXT_LINK = 35873943762L;
    public static final long DXRICHTEXT_MAXHEIGHT = -2628143228636041048L;
    public static final long DXRICHTEXT_MAXLINES = 4685059187929305417L;
    public static final long DXRICHTEXT_MAXWIDTH = 4685059378591825230L;
    public static final long DXRICHTEXT_ONLINK = 9859228430928305L;
    public static final long DXRICHTEXT_ONPRESS = 5176476879387311985L;
    public static final long DXRICHTEXT_PRESS = 19050239308914L;
    public static final long DXRICHTEXT_RICHTEXT = -3256835378505648333L;
    public static final long DXRICHTEXT_SHADOWCOLOR = -7272671779511765872L;
    public static final long DXRICHTEXT_SHADOWOFFSET = -946588628814454279L;
    public static final long DXRICHTEXT_SHADOWRADIUS = -946376925464026374L;
    public static final long DXRICHTEXT_SHRINKLINES = 5091055928078111125L;
    public static final long DXRICHTEXT_STRIKETHROUGHCOLOR = -5920401438808043356L;
    public static final long DXRICHTEXT_STRIKETHROUGHSTYLE = -5902081368050436426L;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_DOUBLE = 3;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_NONE = 0;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_SINGLE = 1;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_THICK = 2;
    public static final long DXRICHTEXT_TEXTCOLOR = 5737767606580872653L;
    public static final long DXRICHTEXT_TEXTGRAVITY = -1564827143683948874L;
    public static final int DXRICHTEXT_TEXTGRAVITY_CENTER = 1;
    public static final int DXRICHTEXT_TEXTGRAVITY_LEFT = 0;
    public static final int DXRICHTEXT_TEXTGRAVITY_RIGHT = 2;
    public static final long DXRICHTEXT_TEXTSIZE = 6751005219504497256L;
    public static final long DXRICHTEXT_UNDERLINECOLOR = 2436253123551448787L;
    public static final long DXRICHTEXT_UNDERLINESTYLE = 2437398193491227877L;
    public static final int DXRICHTEXT_UNDERLINESTYLE_DOUBLE = 3;
    public static final int DXRICHTEXT_UNDERLINESTYLE_NONE = 0;
    public static final int DXRICHTEXT_UNDERLINESTYLE_SINGLE = 1;
    public static final int DXRICHTEXT_UNDERLINESTYLE_THICK = 2;
    public static final long DXRICHTEXT_WORDKERN = 7645877425838446932L;
    public static final CharSequence ELLIPSIS_TEXT = "…";
    public static int J = 0;
    public static int K = 1;
    private int A;
    private boolean B = true;
    private boolean C;
    private boolean D = true;
    private s12 E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int a = 0;
    private double b;
    private String c;
    private boolean d;
    private boolean e;
    private int f = 0;
    private double g = -1.0d;
    private double h = -1.0d;
    private String i;
    private int j = Integer.MAX_VALUE;
    private int k;
    private int l = Integer.MAX_VALUE;
    private String m;
    private int n;
    private JSONArray o;
    private double p;
    private int q;
    private int r = 0;
    private Integer s = -16777216;
    private int t = 0;
    private int u;
    private Integer v;
    private int w = 0;
    private double x;
    private int y;
    private boolean z;

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            a00.this.k();
            a00.this.m();
        }
    }

    /* compiled from: Taobao */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            a00.this.k();
        }
    }

    /* compiled from: Taobao */
    class c implements View.OnLongClickListener {
        c() {
        }

        public boolean onLongClick(View view) {
            a00.this.l();
            a00.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            a00.this.m();
        }
    }

    /* compiled from: Taobao */
    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            a00.this.k();
            a00.this.m();
        }
    }

    /* compiled from: Taobao */
    class f implements View.OnLongClickListener {
        f() {
        }

        public boolean onLongClick(View view) {
            a00.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    class g implements View.OnLongClickListener {
        g() {
        }

        public boolean onLongClick(View view) {
            a00.this.l();
            a00.this.onLongTap();
            return true;
        }
    }

    public a00() {
        if (J == 0 && DinamicXEngine.i() != null) {
            J = d00.c(DinamicXEngine.i(), 12.0f);
        }
        this.u = J;
        this.f = -1;
        this.t = 0;
        this.k = K;
    }

    private void e() {
        if (at.E0()) {
            try {
                List<DXWidgetNode> children = getChildren();
                if (children == null) {
                    return;
                }
                if (!children.isEmpty()) {
                    for (int i2 = 0; i2 < children.size(); i2++) {
                        DXWidgetNode dXWidgetNode = children.get(i2);
                        if ((dXWidgetNode instanceof y00) || (dXWidgetNode instanceof DXImageSpanWidgetNode)) {
                            if (at.j0(dXWidgetNode)) {
                                DXWidgetNode referenceNode = !dXWidgetNode.isFlatten() ? dXWidgetNode.getReferenceNode() : dXWidgetNode;
                                if (referenceNode != null) {
                                    referenceNode.bindEvent(dXWidgetNode.getDXRuntimeContext().getContext());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                vx.b(e2);
            }
        }
    }

    private RichText f() {
        com.taobao.android.dinamicx.view.richtext.node.a k2;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        List<DXWidgetNode> children = getChildren();
        for (int i2 = 0; i2 < children.size(); i2++) {
            DXWidgetNode dXWidgetNode = children.get(i2);
            if (dXWidgetNode.getVisibility() != 2) {
                if (dXWidgetNode instanceof y00) {
                    y00 y00 = (y00) dXWidgetNode;
                    com.taobao.android.dinamicx.view.richtext.node.b a2 = y00.a();
                    if (a2 != null) {
                        if (!y00.d()) {
                            arrayList.add(a2);
                        } else if (!this.z) {
                            RichText richText = new RichText();
                            richText.add(a2);
                            this.E.A(richText.renderText());
                            this.f = 3;
                            this.E.H(3);
                        }
                        sb.append(a2.getText());
                    }
                } else if ((dXWidgetNode instanceof DXImageSpanWidgetNode) && (k2 = ((DXImageSpanWidgetNode) dXWidgetNode).k(true, this.D)) != null) {
                    arrayList.add(k2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        RichText richText2 = new RichText();
        richText2.addAll(arrayList);
        if (getAccessibilityText() == null) {
            setAccessibilityText(sb.toString());
        }
        return richText2;
    }

    private int g() {
        int i2 = this.a;
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 2) {
            return 2;
        }
        return i2 == 1 ? 1 : 0;
    }

    private int h() {
        int i2 = this.r;
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 3) {
            return 3;
        }
        return i2 == 2 ? 2 : 0;
    }

    private int i() {
        int i2 = this.t;
        if (i2 == 1) {
            return 1;
        }
        return i2 == 2 ? 2 : 0;
    }

    private int j() {
        int i2 = this.w;
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 3) {
            return 3;
        }
        return i2 == 2 ? 2 : 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() {
        yz yzVar = new yz(9859228430928305L);
        yzVar.f(this.i);
        postEvent(yzVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        zz zzVar = new zz(5176476879387311985L);
        zzVar.f(this.m);
        postEvent(zzVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        if (!this.C || this.E.q()) {
            postEvent(new lx(18903999933159L));
        }
    }

    private void n() {
        s12 s12 = new s12();
        this.E = s12;
        int i2 = this.z ? this.y : this.A;
        this.k = i2;
        if (i2 <= 0) {
            this.k = Integer.MAX_VALUE;
        }
        s12.w(getBorderColor());
        this.E.x(Math.max(getBorderWidth(), 0));
        this.E.y(getDXRuntimeContext().getContext());
        this.E.z(getCornerRadius());
        this.E.B((int) this.b);
        this.E.C(this.c);
        this.E.D(this.d);
        this.E.E(this.e);
        this.E.F(getDirection());
        this.E.G((float) this.x);
        this.E.H(this.f);
        this.E.L(this.k);
        this.E.M(this.l);
        this.E.K(this.j);
        this.E.b0(this.v);
        this.E.c0(j());
        this.E.V(this.q);
        this.E.W(h());
        this.E.O(getPaddingLeft());
        this.E.P(getPaddingRight());
        this.E.N(getPaddingBottom());
        this.E.Q(getPaddingTop());
        this.E.Z(i());
        this.E.v(g());
        this.E.I((float) this.g);
        this.E.J((float) this.h);
        int i3 = this.u;
        if (i3 > 0) {
            this.E.a0(i3);
        }
        Integer num = this.s;
        if (num != null) {
            this.E.Y(tryFetchDarkModeColor("textColor", 0, num.intValue()));
        }
        JSONArray jSONArray = this.o;
        if (jSONArray != null) {
            if (jSONArray.size() >= 1) {
                this.E.S(this.o.getFloat(0).floatValue());
            }
            if (this.o.size() >= 2) {
                this.E.T(this.o.getFloat(1).floatValue());
            }
        }
        this.E.U((float) this.p);
        this.E.R(this.n);
        this.E.X(f());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    private void onLongTap() {
        postEvent(new lx(-6544685697300501093L));
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new a00();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public double getDefaultValueForDoubleAttr(long j2) {
        if (j2 == DXRICHTEXT_LINEHEIGHT || j2 == DXRICHTEXT_LINESPACING) {
            return -1.0d;
        }
        return super.getDefaultValueForDoubleAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == DXRICHTEXT_BASELINE || j2 == DXRICHTEXT_ENABLECUSTOMTRUNCATION || j2 == DXRICHTEXT_LINEBREAKMODE || j2 == -5902081368050436426L || j2 == 2437398193491227877L) {
            return 0;
        }
        if (j2 == 5737767606580872653L) {
            return -16777216;
        }
        if (j2 == 4822617398935994384L) {
            return 1;
        }
        if (j2 == 6751005219504497256L) {
            return J;
        }
        if (j2 == DXRICHTEXT_FORCEORIGINAL) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public boolean isDisableFlatten() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        if (j2 == 9859228430928305L && !TextUtils.isEmpty(this.i)) {
            this.F = true;
            if (this.H) {
                view.setOnClickListener(new a());
            } else {
                view.setOnClickListener(new b());
            }
        } else if (j2 == 5176476879387311985L && !TextUtils.isEmpty(this.m)) {
            this.G = true;
            if (this.I) {
                view.setOnLongClickListener(new c());
            }
        } else if (j2 == 18903999933159L) {
            this.H = true;
            if (!this.F) {
                view.setOnClickListener(new d());
            } else {
                view.setOnClickListener(new e());
            }
        } else if (j2 == -6544685697300501093L) {
            this.I = true;
            if (!this.G) {
                view.setOnLongClickListener(new f());
            } else {
                view.setOnLongClickListener(new g());
            }
        } else {
            super.onBindEvent(context, view, j2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z2) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof a00)) {
            super.onClone(dXWidgetNode, z2);
            a00 a00 = (a00) dXWidgetNode;
            this.a = a00.a;
            this.b = a00.b;
            this.c = a00.c;
            this.d = a00.d;
            this.e = a00.e;
            this.f = a00.f;
            this.g = a00.g;
            this.h = a00.h;
            this.i = a00.i;
            this.j = a00.j;
            this.k = a00.k;
            this.l = a00.l;
            this.m = a00.m;
            this.n = a00.n;
            this.o = a00.o;
            this.p = a00.p;
            this.q = a00.q;
            this.r = a00.r;
            this.s = a00.s;
            this.t = a00.t;
            this.u = a00.u;
            this.v = a00.v;
            this.w = a00.w;
            this.x = a00.x;
            this.z = a00.z;
            this.y = a00.y;
            this.A = a00.A;
            this.B = a00.B;
            this.C = a00.C;
            this.D = a00.D;
            this.E = a00.E;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeRichText(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        List<DXWidgetNode> children = getChildren();
        for (int i2 = 0; i2 < children.size(); i2++) {
            DXWidgetNode dXWidgetNode = children.get(i2);
            if (dXWidgetNode.getVisibility() != 2 && (dXWidgetNode instanceof y00)) {
                y00 y00 = (y00) dXWidgetNode;
                if (this.B && y00.c() && y00.b() > 0) {
                    y00.f((int) com.taobao.android.dinamicx.c.b(dXRuntimeContext, (float) y00.b()));
                }
                y00.e(this.B && y00.c());
            }
        }
        if (this.B && dXRuntimeContext != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.u = (int) com.taobao.android.dinamicx.c.b(dXRuntimeContext, (float) this.u);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        n();
        s12.a u2 = this.E.u(i2, i3);
        if (u2 == null) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(u2.b(), u2.a());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view instanceof DXNativeRichText) {
            ((DXNativeRichText) view).setRichTextRender(this.E);
            e();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j2, double d2) {
        if (j2 == DXRICHTEXT_FIRSTLINEHEADINDENT) {
            this.b = d2;
        } else if (j2 == DXRICHTEXT_LINEHEIGHT) {
            this.g = d2;
        } else if (j2 == DXRICHTEXT_LINESPACING) {
            this.h = d2;
        } else if (j2 == -946376925464026374L) {
            this.p = d2;
        } else if (j2 == DXRICHTEXT_WORDKERN) {
            this.x = d2;
        } else {
            super.onSetDoubleAttribute(j2, d2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (j2 == DXRICHTEXT_BASELINE) {
            this.a = i2;
        } else if (j2 == DXRICHTEXT_EXPANDLINES) {
            this.y = i2;
        } else {
            boolean z2 = true;
            if (j2 == DXRICHTEXT_EXPANDED) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.z = z2;
            } else if (j2 == DXRICHTEXT_SHRINKLINES) {
                this.A = i2;
            } else if (j2 == 9423384817756195L) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.d = z2;
            } else if (j2 == 3527554185889034042L) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.e = z2;
            } else if (j2 == DXRICHTEXT_LINEBREAKMODE) {
                this.f = i2;
            } else if (j2 == DXRICHTEXT_MAXHEIGHT) {
                this.j = i2;
            } else if (j2 == DXRICHTEXT_MAXWIDTH) {
                this.l = i2;
            } else if (j2 == -7272671779511765872L) {
                this.n = i2;
            } else if (j2 == -5920401438808043356L) {
                this.q = i2;
            } else if (j2 == -5902081368050436426L) {
                this.r = i2;
            } else if (j2 == 5737767606580872653L) {
                this.s = Integer.valueOf(i2);
            } else if (j2 == DXRICHTEXT_TEXTGRAVITY) {
                this.t = i2;
            } else if (j2 == 6751005219504497256L) {
                this.u = i2;
            } else if (j2 == 2436253123551448787L) {
                this.v = Integer.valueOf(i2);
            } else if (j2 == 2437398193491227877L) {
                this.w = i2;
            } else if (j2 == 4822617398935994384L) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.B = z2;
            } else if (j2 == DXRICHTEXT_IGNOREUNTRUNCATEDTAP) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.C = z2;
            } else if (j2 == DXRICHTEXT_FORCEORIGINAL) {
                if (i2 == 0) {
                    z2 = false;
                }
                this.D = z2;
            } else {
                super.onSetIntAttribute(j2, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j2, JSONArray jSONArray) {
        if (j2 == -946588628814454279L) {
            this.o = jSONArray;
        } else {
            super.onSetListAttribute(j2, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (j2 == 34149272427L) {
            this.c = str;
        } else if (j2 == 35873943762L) {
            this.i = str;
        } else if (j2 == 19050239308914L) {
            this.m = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
