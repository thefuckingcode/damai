package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMDXCountDownView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import tb.v50;
import tb.xr;

/* compiled from: Taobao */
public class a extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMCOUNTDOWNVIEW = -3326767282906973476L;
    public static final long DX_DMCOUNTDOWNVIEW_FONTNAME = 2639694824232449600L;
    public static final long DX_DMCOUNTDOWNVIEW_GAP = 519766803;
    public static final long DX_DMCOUNTDOWNVIEW_ISBOLD = 9423384817756195L;
    public static final long DX_DMCOUNTDOWNVIEW_LARGETEXTBGWIDTH = -944937919103713175L;
    public static final long DX_DMCOUNTDOWNVIEW_POINTSIZE = -2396097246344434994L;
    public static final long DX_DMCOUNTDOWNVIEW_REMAINDINGTIME = -3414899041982555973L;
    public static final long DX_DMCOUNTDOWNVIEW_SEPARATORTEXT = -5104668076923637117L;
    public static final long DX_DMCOUNTDOWNVIEW_SMALLTEXTBGWIDTH = -6872017912810078857L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTBGCOLOR = -4542326850935165576L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTBGCORNERRADIUS = 7475260775521093201L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTBGHEIGHT = 5480473500272570323L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTCOLOR = 5737767606580872653L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTMARGINBOTTOM = 6025838122409811880L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTMARGINLEFT = -6690472992018319428L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTMARGINRIGHT = -692969671806018256L;
    public static final long DX_DMCOUNTDOWNVIEW_TEXTMARGINTOP = -4920505232627114909L;
    private String a;
    private int b;
    private boolean c;
    private int d;
    private int e;
    private String f;
    private String g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.temp.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0017a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2096560250")) {
                return new a();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("2096560250", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1473803505")) {
            return new a();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("1473803505", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4856916")) {
            ipChange.ipc$dispatch("4856916", new Object[]{this, context, view, Long.valueOf(j2)});
            return;
        }
        super.onBindEvent(context, view, j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954881899")) {
            ipChange.ipc$dispatch("954881899", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof a)) {
            super.onClone(dXWidgetNode, z);
            a aVar = (a) dXWidgetNode;
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "969590244")) {
            return new DMDXCountDownView(context);
        }
        return (View) ipChange.ipc$dispatch("969590244", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133242725")) {
            ipChange.ipc$dispatch("2133242725", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (xr.a(this.f) > 360000000) {
            i4 = v50.a(getDXRuntimeContext().getContext(), 58.0f);
        } else {
            i4 = v50.a(getDXRuntimeContext().getContext(), 52.0f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), View.MeasureSpec.getMode(i2)), i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975221398")) {
            ipChange.ipc$dispatch("1975221398", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXCountDownView)) {
            DMDXCountDownView dMDXCountDownView = (DMDXCountDownView) view;
            long c2 = xr.c(this.f);
            if (c2 != dMDXCountDownView.getCountTime()) {
                int i2 = this.h;
                int a2 = this.e + this.p + this.m + v50.a(context, 6.0f);
                this.n = 0;
                this.o = 0;
                DMDXCountDownView hourTvTextColor = dMDXCountDownView.setCountTime(c2).setHourTvBackgroundColorWithRadius(0, this.j).setHourTvTextColor(this.l);
                DMDXCountDownView.CountDownViewGravity countDownViewGravity = DMDXCountDownView.CountDownViewGravity.GRAVITY_CENTER;
                DMDXCountDownView hourTvSize = hourTvTextColor.setHourTvGravity(countDownViewGravity).setHourTvPadding(this.n, this.p, this.o, this.m).setHourTvTextSize((float) v50.e(context, (float) this.e)).setHourTvSize(0, a2);
                int i3 = this.b;
                DMDXCountDownView minuteTvSize = hourTvSize.setHourColonTvPadding(i3, 0, i3, 0).setHourColonTvTextColor(this.i).setHourColonTvGravity(countDownViewGravity).setHourColonTvText(this.g).setHourColonTvTextSize((float) v50.e(context, (float) this.e)).setMinuteTvBackgroundColorWidthRadius(0, this.j).setMinuteTvTextColor(this.l).setMinuteTvGravity(countDownViewGravity).setMinuteTvPadding(this.n, this.p, this.o, this.m).setMinuteTvTextSize((float) v50.e(context, (float) this.e)).setMinuteTvSize(i2, a2);
                int i4 = this.b;
                minuteTvSize.setMinuteColonTvPadding(i4, 0, i4, 0).setMinuteColonTvTextColor(this.i).setMinuteColonTvGravity(countDownViewGravity).setMinuteColonTvTextSize((float) v50.e(context, (float) this.e)).setSecondTvBackgroundColorWidthRadius(0, this.j).setSecondTvTextColor(this.l).setSecondTvGravity(countDownViewGravity).setSecondTvPadding(this.n, this.p, this.o, this.m).setSecondTvTextSize((float) v50.e(context, (float) this.e)).setSecondTvSize(i2, a2).setTimeTvFontName(this.a).startCountDown();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-118991661")) {
            ipChange.ipc$dispatch("-118991661", new Object[]{this, Long.valueOf(j2), Integer.valueOf(i2)});
        } else if (j2 == DX_DMCOUNTDOWNVIEW_GAP) {
            this.b = i2;
        } else if (j2 == 9423384817756195L) {
            if (i2 == 0) {
                z = false;
            }
            this.c = z;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_LARGETEXTBGWIDTH) {
            this.d = i2;
        } else if (j2 == -2396097246344434994L) {
            this.e = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_SMALLTEXTBGWIDTH) {
            this.h = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTBGCOLOR) {
            this.i = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTBGCORNERRADIUS) {
            this.j = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTBGHEIGHT) {
            this.k = i2;
        } else if (j2 == 5737767606580872653L) {
            this.l = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTMARGINBOTTOM) {
            this.m = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTMARGINLEFT) {
            this.n = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTMARGINRIGHT) {
            this.o = i2;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_TEXTMARGINTOP) {
            this.p = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725119888")) {
            ipChange.ipc$dispatch("-725119888", new Object[]{this, Long.valueOf(j2), str});
        } else if (j2 == 2639694824232449600L) {
            this.a = str;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_REMAINDINGTIME) {
            this.f = str;
        } else if (j2 == DX_DMCOUNTDOWNVIEW_SEPARATORTEXT) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
