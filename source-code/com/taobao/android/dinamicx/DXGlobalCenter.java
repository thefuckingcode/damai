package com.taobao.android.dinamicx;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.eventchain.DXEventChainEventHandler;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.view.DXNativeLinearLayout;
import com.taobao.android.dinamicx.view.DXNativeTextView;
import com.taobao.android.dinamicx.widget.DXAdaptiveLinearLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXCheckBoxWidgetNode;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXListLayout;
import com.taobao.android.dinamicx.widget.DXOverlayWidgetNode;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXScrollableLayout;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.taobao.android.dinamicx.widget.DXSectionLayout;
import com.taobao.android.dinamicx.widget.DXSliderLayout;
import com.taobao.android.dinamicx.widget.DXStackCardLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXSwitchWidgetNode;
import com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXViewPager;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import com.taobao.android.dinamicx.widget.a;
import com.taobao.android.dinamicx.widget.b;
import com.taobao.android.dinamicx.widget.c;
import com.taobao.android.dinamicx.widget.d;
import com.taobao.android.dinamicx.widget.e;
import com.taobao.android.dinamicx.widget.h;
import com.taobao.android.dinamicx.widget.i;
import com.taobao.android.dinamicx.widget.j;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;
import com.taobao.android.dinamicx.widget.viewpager.tab.DXTabItemWidgetNode;
import tb.a00;
import tb.at;
import tb.au;
import tb.av;
import tb.aw;
import tb.ax;
import tb.b00;
import tb.bu;
import tb.bv;
import tb.bw;
import tb.bx;
import tb.ct;
import tb.cu;
import tb.cv;
import tb.cw;
import tb.cx;
import tb.du;
import tb.dv;
import tb.dw;
import tb.eu;
import tb.ev;
import tb.ew;
import tb.fu;
import tb.fv;
import tb.fw;
import tb.gu;
import tb.gv;
import tb.gw;
import tb.gy;
import tb.gz;
import tb.hu;
import tb.hv;
import tb.hw;
import tb.iu;
import tb.iv;
import tb.iw;
import tb.ju;
import tb.jv;
import tb.jw;
import tb.kv;
import tb.kw;
import tb.ky;
import tb.lv;
import tb.lw;
import tb.ly;
import tb.mv;
import tb.mw;
import tb.ns;
import tb.nv;
import tb.nw;
import tb.nx;
import tb.ov;
import tb.ow;
import tb.oy;
import tb.p00;
import tb.pv;
import tb.pw;
import tb.px;
import tb.q00;
import tb.qv;
import tb.qw;
import tb.qy;
import tb.rv;
import tb.rw;
import tb.sv;
import tb.sw;
import tb.tv;
import tb.tw;
import tb.us;
import tb.uv;
import tb.uw;
import tb.vu;
import tb.vv;
import tb.vw;
import tb.wu;
import tb.wv;
import tb.xu;
import tb.xv;
import tb.xw;
import tb.y00;
import tb.yt;
import tb.yu;
import tb.yv;
import tb.yw;
import tb.zt;
import tb.zu;
import tb.zv;
import tb.zw;

/* compiled from: Taobao */
public final class DXGlobalCenter {
    static DXLongSparseArray<IDXDataParser> a = new DXLongSparseArray<>();
    static DXLongSparseArray<IDXEventHandler> b = new DXLongSparseArray<>();
    static DXLongSparseArray<IDXBuilderWidgetNode> c = new DXLongSparseArray<>();
    static IDXDownloader d;
    static IDXWebImageInterface e;
    static IDXRichTextImageInterface f;
    static IDXAbTestInterface g;
    static IDXHardwareInterface h;
    static IDXWebImageInterface i;
    static IDXConfigInterface j;
    static IDXWebImageUrlInterface k;

    static {
        new Thread(null, new Runnable() {
            /* class com.taobao.android.dinamicx.DXGlobalCenter.AnonymousClass1 */

            public void run() {
                try {
                    new DXWidgetNode();
                    new d();
                    new DXLinearLayoutWidgetNode();
                    new DXSwitchWidgetNode();
                    new DXTextViewWidgetNode();
                    new b();
                    new DXListLayout();
                    new DXImageWidgetNode();
                    new a();
                    new DXNativeTextView(DinamicXEngine.i());
                    new DXNativeFrameLayout(DinamicXEngine.i());
                    new DXNativeLinearLayout(DinamicXEngine.i());
                    new DXScrollerLayout();
                    new DXSliderLayout();
                } catch (Throwable unused) {
                }
            }
        }, "DXGlobalCenter").start();
        try {
            a.put(yt.DXDMVIEWFLIPPER_DATA, new gy());
            a.put(gz.DX_PARSER_PARENTSUBDATA, new gz());
            a.put(17177078638764L, new ct());
            a.put(5326177973899923051L, new p00());
            a.put(4390557269728183382L, new oy());
            a.put(qy.DX_PARSER_LISTDATA, new qy());
            a.put(nx.DX_PARSER_EVENTCHAINDATA, new nx());
            a.put(px.DX_PARSER_EVENTCHAINEVENTDATA, new px());
            a.put(b00.DX_PARSER_ROOTDATA, new b00());
            a.put(-8601334994478314885L, new kv());
            a.put(-7155988592997126393L, new jv());
            a.put(q00.DX_PARSER_SUBDATAINDEX, new q00());
            a.put(uw.DX_PARSER_TEMPLATEDATA, new uw());
            a.put(zt.DX_PARSER_ABILITYHUB, new zt());
            a.put(bv.DX_PARSER_DXEVENTPROP, new bv());
            a.put(10152737943856105L, new qw());
            a.put(2104823241333621454L, new pw());
            a.put(-2766900241128002095L, new rw());
            a.put(8985048662794750L, new ow());
            a.put(38192572096L, new ax());
            a.put(522748242, new wv());
            a.put(17466137112765L, new dv());
            a.put(516230118, new cu());
            a.put(803695, new hw());
            a.put(523960308, new fw());
            a.put(10224770040602390L, new bx());
            a.put(DXTemplateWidgetNode.DXTEMPLATE_IF, new pv());
            a.put(33857357437L, new cv());
            a.put(2311459087270464967L, new fu());
            a.put(6743940140328071192L, new gu());
            a.put(2043810233379508043L, new iv());
            a.put(-1423751599996947415L, new fv());
            a.put(-3695355688016560275L, new eu());
            a.put(3521945216952772436L, new qv());
            a.put(7193167627824317654L, new rv());
            a.put(18043027130931L, new uv());
            a.put(5581002430686265197L, new jw());
            a.put(vu.DX_PARSER_DX_ENV, new vu());
            a.put(bu.DX_PARSER_ADD, new bu());
            a.put(sw.DX_PARSER_SUB, new sw());
            a.put(ew.DX_PARSER_MUL, new ew());
            a.put(yu.DX_PARSER_DIV, new yu());
            a.put(dw.DX_PARSER_MOD, new dw());
            a.put(nv.DX_PARSER_GREATER, new nv());
            a.put(ov.DX_PARSER_GREATEREQUAL, new ov());
            a.put(xv.DX_PARSER_LESS, new xv());
            a.put(yv.DX_PARSER_LESSEQUAL, new yv());
            a.put(gw.DX_PARSER_NOTEQUAL, new gw());
            a.put(xw.DX_PARSER_TODOUBLE, new xw());
            a.put(yw.DX_PARSER_TOLONG, new yw());
            a.put(zw.DX_PARSER_TOSTR, new zw());
            a.put(hu.DX_PARSER_CEIL, new hu());
            a.put(gv.DX_PARSER_FLOOR, new gv());
            a.put(nw.DX_PARSER_ROUND, new nw());
            a.put(iw.DX_DATA_PARSER_ORANGE, new iw());
            a.put(au.DX_PARSER_ABS, new au());
            a.put(zv.DX_PARSER_LINEAR_GRADIENT, new zv());
            a.put(vw.DX_PARSER_TOBINDINGXUNIT, new vw());
            a.put(aw.DX_PARSER_MAX, new aw());
            a.put(cw.DX_PARSER_MIN, new cw());
            a.put(sv.DX_PARSER_ISDARKMODE, new sv());
            a.put(iu.DX_PARSER_COLORMAP, new iu());
            a.put(xu.DX_PARSER_DATAPARSERNOTFOUND, new xu());
            a.put(ev.DX_PARSER_EVENTHANDLERNOTFOUND, new ev());
            a.put(wu.DX_PARSER_DXVERSION_GREATERTHANOREQUALTO, new wu());
            a.put(mw.DX_PARSER_RECYCLERDATAINDEX, new mw());
            a.put(lv.DX_PARSER_GETRECYCLERSTATEDATASOURCE, new lv());
            a.put(du.DX_PARSER_ARRAY_CONCAT, new du());
            a.put(lw.DX_DATA_PARSER_RECYCLER_CURRENT_POSITION, new lw());
            a.put(kw.DX_PARSER_QUERYRECYCLERCELLINDEXBYUSERID, new kw());
            a.put(tw.DX_PARSER_SUB_ARRAY, new tw());
            a.put(hv.DX_PARSER_SIZEBYFACTOR, new hv());
            a.put(tv.DX_PARSER_ISELDER, new tv());
            a.put(ju.DX_PARSER_CONTAINSSTR, new ju());
            a.put(zu.DX_PARSER_DXAB, new zu());
            a.put(vv.DX_PARSER_KV, new vv());
            a.put(bw.DX_PARSER_MERGEOBJ, new bw());
            a.put(mv.DX_PARSER_GETTEMPLATEINFO, new mv());
            a.put(av.DX_PARSER_DXDEVICELEVEL, new av());
            a.put(-7801350391660369312L, new cx());
            a.put(ky.DX_PARSER_GETWIDGETPROPERTYVALUE, new ky());
            c.put(29525406863L, new DXWidgetNode.c());
            c.put(7821310614898040L, new DXSwitchWidgetNode.a());
            c.put(-7675176749284896753L, new DXCheckBoxWidgetNode.a());
            c.put(4596163952226405054L, new j.b());
            c.put(-2672364288628517304L, new DXTextViewWidgetNode.a());
            c.put(-3496644918488563383L, new b.C0211b());
            c.put(7700670404894374791L, new DXImageWidgetNode.b());
            c.put(8840950490744612256L, new DXImageWidgetNode.b());
            c.put(a.DX_WIDGET_ANIMATEDVIEW, new a.C0210a());
            c.put(6637736565700605658L, new c.a());
            c.put(ly.DXGRIDITEM_GRIDITEM, new ly.a());
            c.put(DXTabHeaderLayoutWidgetNode.DXTABHEADERLAYOUT_TABHEADERLAYOUT, new DXTabHeaderLayoutWidgetNode.c());
            c.put(DXTabItemWidgetNode.DXTABITEM_TABITEM, new DXTabItemWidgetNode.a());
            c.put(DXTextInputViewWidgetNode.DXTEXTINPUTVIEW_TEXTINPUTVIEW, new DXTextInputViewWidgetNode.c());
            c.put(us.DXCALENDARVIEW_CALENDARVIEW, new us.e());
            c.put(DXSectionLayout.DXSECTIONLAYOUT_SECTIONLAYOUT, new DXSectionLayout());
            c.put(8095935013984139892L, new d.a());
            c.put(5971992526290704869L, new DXLinearLayoutWidgetNode.a());
            c.put(2372426597927978788L, new DXListLayout.a());
            c.put(-7401881896881775333L, new DXAdaptiveLinearLayoutWidgetNode.a());
            c.put(DXScrollerLayout.DX_SCROLLER_LAYOUT, new DXScrollerLayout.a());
            c.put(DXRecyclerLayout.DXRECYCLERLAYOUT_RECYCLERLAYOUT, new DXRecyclerLayout.d());
            c.put(DXStackCardLayoutWidgetNode.DXSTACKCARDLAYOUT_STACKCARDLAYOUT, new DXStackCardLayoutWidgetNode.b());
            c.put(DXViewPager.DXVIEWPAGER_VIEWPAGER, new DXViewPager.b());
            c.put(DXOverlayWidgetNode.DXOVERLAY_OVERLAY, new DXOverlayWidgetNode.c());
            c.put(DXTemplateWidgetNode.DXTEMPLATE_TEMPLATE, new DXTemplateWidgetNode.a());
            c.put(DXSliderLayout.DX_SLIDER_LAYOUT, new DXSliderLayout.a());
            c.put(h.DX_PAGE_INDICATOR, new h.a());
            c.put(i.DX_SCROLLER_INDICATOR, new i.a());
            c.put(e.DX_GRID_LAYOUT, new e.a());
            c.put(DXScrollableLayout.DXSCROLLABLELAYOUT_SCROLLABLELAYOUT, new DXScrollableLayout.a());
            c.put(a00.DXRICHTEXT_RICHTEXT, new a00());
            c.put(y00.DXTEXTSPAN_TEXTSPAN, new y00());
            c.put(DXImageSpanWidgetNode.DXIMAGESPAN_IMAGESPAN, new DXImageSpanWidgetNode());
            b.put(ns.DX_EVENT_BINDINGX, new ns());
            b.put(DXEventChainEventHandler.DX_EVENT_EVENTCHAIN, new DXEventChainEventHandler());
        } catch (Throwable unused) {
        }
    }

    public static IDXAbTestInterface a() {
        return g;
    }

    @Nullable
    public static IDXConfigInterface b() {
        return j;
    }

    public static IDXHardwareInterface c() {
        return h;
    }

    public static IDXRichTextImageInterface d(DXRuntimeContext dXRuntimeContext) {
        return f;
    }

    public static IDXWebImageInterface e() {
        return e;
    }

    public static IDXWebImageInterface f(DXRuntimeContext dXRuntimeContext) {
        if (at.N0(dXRuntimeContext)) {
            return i;
        }
        return e;
    }

    public static IDXWebImageUrlInterface g() {
        return k;
    }
}
