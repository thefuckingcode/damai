package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.node.b;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class y00 extends DXWidgetNode {
    public static final long DXTEXTSPAN_ENABLETEXTSIZESTRATEGY = 4822617398935994384L;
    public static final long DXTEXTSPAN_FONT = 34149272427L;
    public static final long DXTEXTSPAN_ISBOLD = 9423384817756195L;
    public static final long DXTEXTSPAN_ISITALIC = 3527554185889034042L;
    public static final long DXTEXTSPAN_ISTRUNCATED = -1735247218921453423L;
    public static final long DXTEXTSPAN_LINK = 35873943762L;
    public static final long DXTEXTSPAN_ONLINK = 9859228430928305L;
    public static final long DXTEXTSPAN_ONPRESS = 5176476879387311985L;
    public static final long DXTEXTSPAN_PRESS = 19050239308914L;
    public static final long DXTEXTSPAN_SHADOWCOLOR = -7272671779511765872L;
    public static final long DXTEXTSPAN_SHADOWOFFSET = -946588628814454279L;
    public static final long DXTEXTSPAN_SHADOWRADIUS = -946376925464026374L;
    public static final long DXTEXTSPAN_STRIKETHROUGHCOLOR = -5920401438808043356L;
    public static final long DXTEXTSPAN_STRIKETHROUGHSTYLE = -5902081368050436426L;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_DOUBLE = 3;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_NONE = 0;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_SINGLE = 1;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_THICK = 2;
    public static final long DXTEXTSPAN_TEXT = 38178040921L;
    public static final long DXTEXTSPAN_TEXTCOLOR = 5737767606580872653L;
    public static final long DXTEXTSPAN_TEXTSIZE = 6751005219504497256L;
    public static final long DXTEXTSPAN_TEXTSPAN = -2672364301597372865L;
    public static final long DXTEXTSPAN_UNDERLINECOLOR = 2436253123551448787L;
    public static final long DXTEXTSPAN_UNDERLINESTYLE = 2437398193491227877L;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_DOUBLE = 3;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_NONE = 0;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_SINGLE = 1;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_THICK = 2;
    private boolean a = true;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    private String g = "none";
    private int h;
    private JSONArray i;
    private double j;
    private int k;
    private int l = 0;
    private String m;
    private Integer n;
    private int o;
    private int p;
    private int q = 0;
    private com.taobao.android.dinamicx.view.richtext.node.b r;

    /* compiled from: Taobao */
    class a implements RichTextNode.OnLinkTapListener {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLinkTapListener
        public void onLinkTap(String str) {
            yz yzVar = new yz(this.a);
            yzVar.f(str);
            y00.this.postEvent(yzVar);
        }
    }

    /* compiled from: Taobao */
    class b implements RichTextNode.OnLongPressListener {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongPressListener
        public boolean onLongPress(String str) {
            zz zzVar = new zz(this.a);
            zzVar.f(str);
            y00.this.postEvent(zzVar);
            return true;
        }
    }

    /* compiled from: Taobao */
    class c implements RichTextNode.OnTapListener {
        c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnTapListener
        public void onTap() {
            y00.this.postEvent(new lx(18903999933159L));
        }
    }

    /* compiled from: Taobao */
    class d implements RichTextNode.OnLongTapListener {
        d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongTapListener
        public void onLongTap() {
            y00.this.postEvent(new lx(-6544685697300501093L));
        }
    }

    public com.taobao.android.dinamicx.view.richtext.node.b a() {
        if (TextUtils.isEmpty(this.m)) {
            return null;
        }
        b.i o2 = new b.i(this.m).q(this.o).b(getBackGroundColor()).c(getBorderColor()).d(getBorderWidth()).e(getCornerRadius()).g(this.c).h(this.d).i(this.f).j(this.g).m((float) this.j).r(this.p).s(this.q).n(this.k).o(this.l);
        Integer num = this.n;
        if (num != null) {
            o2.p(num.intValue());
        }
        JSONArray jSONArray = this.i;
        if (jSONArray != null) {
            if (jSONArray.size() >= 1) {
                o2.k(this.i.getFloat(0).floatValue());
            }
            if (this.i.size() >= 2) {
                o2.l(this.i.getFloat(1).floatValue());
            }
        }
        if (!(getDXRuntimeContext() == null || getDXRuntimeContext().getContext() == null)) {
            o2.f(getDXRuntimeContext().getContext().getAssets(), this.b);
        }
        com.taobao.android.dinamicx.view.richtext.node.b a2 = o2.a();
        this.r = a2;
        return a2;
    }

    public int b() {
        return this.o;
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new y00();
    }

    public boolean c() {
        return this.a;
    }

    public boolean d() {
        return this.e;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public void f(int i2) {
        this.o = i2;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == -5902081368050436426L || j2 == 2437398193491227877L) {
            return 0;
        }
        if (j2 == 5737767606580872653L) {
            return -16777216;
        }
        if (j2 == 4822617398935994384L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j2) {
        return j2 == 19050239308914L ? "none" : super.getDefaultValueForStringAttr(j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        com.taobao.android.dinamicx.view.richtext.node.b bVar = this.r;
        if (bVar == null) {
            if (!at.j0(this)) {
                super.onBindEvent(context, view, j2);
            }
        } else if (j2 == 9859228430928305L) {
            bVar.I(new a(j2));
        } else if (j2 == 5176476879387311985L) {
            bVar.J(new b(j2));
        } else if (j2 == 18903999933159L) {
            bVar.L(new c());
        } else if (j2 == -6544685697300501093L) {
            bVar.K(new d());
        } else if (!at.j0(this)) {
            super.onBindEvent(context, view, j2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof y00)) {
            super.onClone(dXWidgetNode, z);
            y00 y00 = (y00) dXWidgetNode;
            this.b = y00.b;
            this.c = y00.c;
            this.d = y00.d;
            this.e = y00.e;
            this.f = y00.f;
            this.g = y00.g;
            this.h = y00.h;
            this.i = y00.i;
            this.j = y00.j;
            this.k = y00.k;
            this.l = y00.l;
            this.m = y00.m;
            this.n = y00.n;
            this.o = y00.o;
            this.p = y00.p;
            this.q = y00.q;
            this.r = y00.r;
            this.a = y00.a;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (at.j0(this)) {
            return null;
        }
        return super.onCreateView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j2, double d2) {
        if (j2 == -946376925464026374L) {
            this.j = d2;
        } else {
            super.onSetDoubleAttribute(j2, d2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        boolean z = true;
        if (j2 == 9423384817756195L) {
            if (i2 == 0) {
                z = false;
            }
            this.c = z;
        } else if (j2 == 3527554185889034042L) {
            if (i2 == 0) {
                z = false;
            }
            this.d = z;
        } else if (j2 == DXTEXTSPAN_ISTRUNCATED) {
            if (i2 == 0) {
                z = false;
            }
            this.e = z;
        } else if (j2 == -7272671779511765872L) {
            this.h = i2;
        } else if (j2 == -5920401438808043356L) {
            this.k = i2;
        } else if (j2 == -5902081368050436426L) {
            this.l = i2;
        } else if (j2 == 5737767606580872653L) {
            this.n = Integer.valueOf(i2);
        } else if (j2 == 6751005219504497256L) {
            this.o = i2;
        } else if (j2 == 2436253123551448787L) {
            this.p = i2;
        } else if (j2 == 2437398193491227877L) {
            this.q = i2;
        } else if (j2 == 4822617398935994384L) {
            if (i2 == 0) {
                z = false;
            }
            this.a = z;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j2, JSONArray jSONArray) {
        if (j2 == -946588628814454279L) {
            this.i = jSONArray;
        } else {
            super.onSetListAttribute(j2, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (j2 == 34149272427L) {
            this.b = str;
        } else if (j2 == 35873943762L) {
            this.f = str;
        } else if (j2 == 19050239308914L) {
            this.g = str;
        } else if (j2 == 38178040921L) {
            this.m = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
