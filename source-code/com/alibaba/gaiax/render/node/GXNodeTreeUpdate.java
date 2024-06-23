package com.alibaba.gaiax.render.node;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Node;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.gaiax.render.view.basic.GXProgressView;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import tb.aq0;
import tb.ar0;
import tb.bp0;
import tb.cp0;
import tb.fp0;
import tb.gp0;
import tb.hp0;
import tb.k21;
import tb.lq0;
import tb.m70;
import tb.no0;
import tb.ob2;
import tb.ox1;
import tb.po0;
import tb.sq0;
import tb.up0;
import tb.uq0;
import tb.ur2;
import tb.wn0;
import tb.wo0;
import tb.wq0;
import tb.xo0;
import tb.xp0;
import tb.xq0;
import tb.yq0;

/* compiled from: Taobao */
public final class GXNodeTreeUpdate {
    @NotNull
    private final wq0 a;

    /* compiled from: Taobao */
    public static final class Style {
        @NotNull
        public static final Style INSTANCE = new Style();

        private Style() {
        }

        private final void A(wq0 wq0, up0 up0, JSONObject jSONObject) {
            y(wq0, up0, jSONObject);
            List<up0> d = up0.d();
            if (d != null) {
                Iterator<T> it = d.iterator();
                while (it.hasNext()) {
                    INSTANCE.z(wq0, it.next(), jSONObject);
                }
            }
        }

        private final void a(wq0 wq0, up0 up0, no0 no0, View view) {
            if (up0.I() && no0.b().a() != null) {
                ((GXView) view).setBackdropFilter(wq0, no0.b().a());
            }
        }

        private final void b(up0 up0, no0 no0) {
            GXShadowLayout b;
            if ((up0.I() || up0.x()) && (b = up0.b()) != null) {
                b.setStyle(no0.b());
            }
        }

        private final void c(wq0 wq0, View view, no0 no0, up0 up0) {
            GXViewExtKt.e(view, no0.b().h());
            if (!up0.t()) {
                GXViewExtKt.r(view, no0.b().h(), no0.b().s());
                GXViewExtKt.u(view, no0.b().u());
                GXViewExtKt.v(view, no0.b().v());
                GXViewExtKt.d(view, no0.b());
                GXViewExtKt.x(view, no0.b());
            }
        }

        private final void d(wq0 wq0, no0 no0, View view, up0 up0) {
            if (!up0.s()) {
                return;
            }
            if (up0.v()) {
                f(wq0, view, up0);
            } else if (up0.F()) {
                l(wq0, view, up0);
            }
        }

        private final void e(wq0 wq0, GXIViewBindData gXIViewBindData, xq0 xq0, JSONObject jSONObject) {
            gXIViewBindData.onBindData(xq0.d(jSONObject));
        }

        private final void f(wq0 wq0, View view, up0 up0) {
            fp0 j = up0.n().j();
            if (j != null) {
                GXViewExtKt.p(view, wq0, j, up0.m().b());
                GXViewExtKt.q(view, j.e(), j.f(), j.g());
            }
        }

        private final void g(GXIViewBindData gXIViewBindData, xq0 xq0, JSONObject jSONObject) {
            gXIViewBindData.onBindData(xq0.d(jSONObject));
        }

        private final void h(GXIViewBindData gXIViewBindData, xq0 xq0, JSONObject jSONObject) {
            gXIViewBindData.onBindData(xq0.d(jSONObject));
        }

        private final void i(GXIViewBindData gXIViewBindData, xq0 xq0, JSONObject jSONObject) {
            GXProgressView gXProgressView = gXIViewBindData instanceof GXProgressView ? (GXProgressView) gXIViewBindData : null;
            if (gXProgressView != null) {
                gXProgressView.setConfig(xq0.k());
            }
            if (gXProgressView != null) {
                gXProgressView.onBindData(xq0.d(jSONObject));
            }
        }

        private final void j(wq0 wq0, GXIViewBindData gXIViewBindData, no0 no0, hp0 hp0, xq0 xq0, JSONObject jSONObject) {
            Object obj;
            Object obj2;
            GXTemplateEngine.GXIDataListener b;
            CharSequence b2;
            JSONObject d = xq0.d(jSONObject);
            Object obj3 = null;
            if (d == null) {
                obj = null;
            } else {
                obj = d.get("value");
            }
            if (!(obj instanceof String) || (b2 = gp0.INSTANCE.b((View) gXIViewBindData, xq0, jSONObject, (String) obj)) == null) {
                GXTemplateEngine.g j = wq0.j();
                if ((j == null ? null : j.b()) != null) {
                    GXTemplateEngine.i iVar = new GXTemplateEngine.i();
                    iVar.m(obj instanceof CharSequence ? (CharSequence) obj : null);
                    iVar.g((View) gXIViewBindData);
                    iVar.e(hp0.d());
                    iVar.f(wq0.l());
                    iVar.k(no0);
                    iVar.l(d);
                    iVar.d(Integer.valueOf(wq0.e()));
                    iVar.j(xq0.h(jSONObject));
                    GXTemplateEngine.g j2 = wq0.j();
                    CharSequence onTextProcess = (j2 == null || (b = j2.b()) == null) ? null : b.onTextProcess(iVar);
                    if (onTextProcess != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put((Object) "value", (Object) onTextProcess);
                        if (d == null) {
                            obj2 = null;
                        } else {
                            obj2 = d.get("accessibilityDesc");
                        }
                        jSONObject2.put((Object) "accessibilityDesc", obj2);
                        if (d != null) {
                            obj3 = d.get("accessibilityEnable");
                        }
                        jSONObject2.put((Object) "accessibilityEnable", obj3);
                        gXIViewBindData.onBindData(jSONObject2);
                        return;
                    }
                    return;
                }
                gXIViewBindData.onBindData(d);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put((Object) "value", (Object) b2);
            jSONObject3.put((Object) "accessibilityDesc", d.get("accessibilityDesc"));
            jSONObject3.put((Object) "accessibilityEnable", d.get("accessibilityEnable"));
            gXIViewBindData.onBindData(jSONObject3);
        }

        private final void k(wq0 wq0, View view, up0 up0, xq0 xq0, JSONObject jSONObject) {
            GXContainerViewAdapter gXContainerViewAdapter;
            JSON f = xq0.f(jSONObject);
            JSONArray jSONArray = f instanceof JSONArray ? (JSONArray) f : null;
            if (jSONArray == null) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.isPreventContainerDataSourceThrowException()) {
                    z = true;
                }
                if (z) {
                    jSONArray = new JSONArray();
                } else {
                    throw new IllegalArgumentException("Scroll or Grid must be have a array data source");
                }
            }
            JSONObject h = xq0.h(jSONObject);
            GXContainer gXContainer = (GXContainer) view;
            wq0.n();
            CopyOnWriteArraySet<GXIContainer> b = wq0.b();
            if (b != null) {
                b.add(gXContainer);
            }
            if (gXContainer.getAdapter() != null) {
                RecyclerView.Adapter adapter = gXContainer.getAdapter();
                Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.container.GXContainerViewAdapter");
                gXContainerViewAdapter = (GXContainerViewAdapter) adapter;
            } else {
                gXContainerViewAdapter = new GXContainerViewAdapter(wq0, gXContainer);
                gXContainer.setAdapter(gXContainerViewAdapter);
            }
            gXContainerViewAdapter.r(up0);
            GXRegisterCenter.GXIExtensionScroll n = GXRegisterCenter.Companion.a().n();
            if (n != null) {
                n.scrollIndex(wq0, gXContainer, h);
            }
            gXContainer.setItemAnimator(null);
            gXContainerViewAdapter.q(jSONArray);
            gXContainerViewAdapter.m();
            if (gXContainerViewAdapter.l()) {
                GXViewExtKt.A(gXContainer);
            }
        }

        private final void l(wq0 wq0, View view, up0 up0) {
            lq0 l = up0.n().l();
            if (l != null) {
                GXViewExtKt.y(view, l.b(), up0.m().b());
                Rect c = l.c();
                int e = l.e();
                if (l.b() != 0) {
                    if (e != 0) {
                        GXViewExtKt.E(view, e);
                    }
                    GXViewExtKt.z(view, c);
                } else if (c.top == 0 && c.bottom == 0) {
                    GXViewExtKt.t(view, c.left, c.right, e);
                } else {
                    if (e != 0) {
                        GXViewExtKt.s(view, e);
                    }
                    GXViewExtKt.z(view, c);
                }
            }
        }

        private final void m(wq0 wq0, View view, up0 up0, xq0 xq0, JSONObject jSONObject) {
            GXSliderViewAdapter gXSliderViewAdapter;
            JSON f = xq0.f(jSONObject);
            PagerAdapter pagerAdapter = null;
            JSONArray jSONArray = f instanceof JSONArray ? (JSONArray) f : null;
            if (jSONArray == null) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.isPreventContainerDataSourceThrowException()) {
                    z = true;
                }
                if (z) {
                    jSONArray = new JSONArray();
                } else {
                    throw new IllegalArgumentException("Slider or Grid must be have a array data source");
                }
            }
            GXSliderView gXSliderView = (GXSliderView) view;
            wq0.n();
            CopyOnWriteArraySet<GXIContainer> b = wq0.b();
            if (b != null) {
                b.add(gXSliderView);
            }
            gXSliderView.setTemplateContext(wq0);
            ViewPager viewPager = gXSliderView.getViewPager();
            if ((viewPager == null ? null : viewPager.getAdapter()) != null) {
                ViewPager viewPager2 = gXSliderView.getViewPager();
                if (viewPager2 != null) {
                    pagerAdapter = viewPager2.getAdapter();
                }
                Objects.requireNonNull(pagerAdapter, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter");
                gXSliderViewAdapter = (GXSliderViewAdapter) pagerAdapter;
            } else {
                gXSliderViewAdapter = new GXSliderViewAdapter(wq0, up0);
                ViewPager viewPager3 = gXSliderView.getViewPager();
                if (viewPager3 != null) {
                    viewPager3.setAdapter(gXSliderViewAdapter);
                }
            }
            gXSliderViewAdapter.e(up0.n().m());
            gXSliderView.setConfig(up0.n().m());
            gXSliderViewAdapter.f(jSONArray);
            gXSliderView.setPageSize(jSONArray.size());
            gXSliderView.onBindData(jSONObject);
        }

        private final void n(wq0 wq0, GXIViewBindData gXIViewBindData, no0 no0, hp0 hp0, xq0 xq0, JSONObject jSONObject) {
            String str;
            GXTemplateEngine.GXIDataListener b;
            CharSequence onTextProcess;
            Object obj;
            Object obj2;
            JSONObject d = xq0.d(jSONObject);
            GXTemplateEngine.g j = wq0.j();
            Object obj3 = null;
            if ((j == null ? null : j.b()) != null) {
                GXTemplateEngine.i iVar = new GXTemplateEngine.i();
                if (d == null || (obj2 = d.get("value")) == null) {
                    str = null;
                } else {
                    str = obj2.toString();
                }
                iVar.m(str);
                iVar.g((View) gXIViewBindData);
                iVar.e(hp0.d());
                iVar.f(wq0.l());
                iVar.k(no0);
                iVar.l(d);
                iVar.d(Integer.valueOf(wq0.e()));
                iVar.j(xq0.h(jSONObject));
                GXTemplateEngine.g j2 = wq0.j();
                if (!(j2 == null || (b = j2.b()) == null || (onTextProcess = b.onTextProcess(iVar)) == null)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put((Object) "value", (Object) onTextProcess);
                    if (d == null) {
                        obj = null;
                    } else {
                        obj = d.get("accessibilityDesc");
                    }
                    jSONObject2.put((Object) "accessibilityDesc", obj);
                    if (d != null) {
                        obj3 = d.get("accessibilityEnable");
                    }
                    jSONObject2.put((Object) "accessibilityEnable", obj3);
                    gXIViewBindData.onBindData(jSONObject2);
                    return;
                }
            }
            gXIViewBindData.onBindData(d);
        }

        private final void o(GXIViewBindData gXIViewBindData, xq0 xq0, JSONObject jSONObject) {
            gXIViewBindData.onBindData(xq0.d(jSONObject));
        }

        private final void p(wq0 wq0, up0 up0, JSONObject jSONObject) {
            wn0 a = up0.n().a();
            if (a != null) {
                a.a(wq0, up0, jSONObject);
            }
        }

        private final void q(wq0 wq0, up0 up0) {
            no0 i;
            View p = up0.p();
            if (p != null && (i = up0.n().i()) != null) {
                a(wq0, up0, i, p);
                b(up0, i);
                if ((p instanceof GXText) && (up0.H() || up0.E() || up0.w())) {
                    ((GXText) p).setTextStyle(i);
                } else if ((p instanceof GXIImageView) && up0.x()) {
                    ((GXIImageView) p).setImageStyle(wq0, i);
                } else if (up0.s()) {
                    d(wq0, i, p, up0);
                }
                c(wq0, p, i, up0);
            }
        }

        private final void r(wq0 wq0, up0 up0, JSONObject jSONObject) {
            View p;
            if (up0.n().e() != null && (p = up0.p()) != null && (p instanceof GXIViewBindData)) {
                no0 b = up0.n().b();
                hp0 n = up0.n().n();
                if (up0.t()) {
                    e(wq0, (GXIViewBindData) p, up0.n(), jSONObject);
                } else if (up0.H()) {
                    n(wq0, (GXIViewBindData) p, b, n, up0.n(), jSONObject);
                } else if (up0.E()) {
                    j(wq0, (GXIViewBindData) p, b, n, up0.n(), jSONObject);
                } else if (up0.w()) {
                    g((GXIViewBindData) p, up0.n(), jSONObject);
                } else if (up0.x()) {
                    h((GXIViewBindData) p, up0.n(), jSONObject);
                } else if (up0.D()) {
                    i((GXIViewBindData) p, up0.n(), jSONObject);
                } else if (up0.F() || up0.v()) {
                    k(wq0, p, up0, up0.n(), jSONObject);
                } else if (up0.G()) {
                    m(wq0, p, up0, up0.n(), jSONObject);
                } else if (up0.I() || up0.u()) {
                    o((GXIViewBindData) p, up0.n(), jSONObject);
                }
                wq0.u(wq0.a() + 1);
            }
        }

        private final void s(wq0 wq0, up0 up0, JSON json) {
            uq0 b;
            if (json instanceof JSONObject) {
                no0 i = up0.n().i();
                boolean z = false;
                if (!(i == null || (b = i.b()) == null)) {
                    z = b.y();
                }
                if (!z) {
                    View p = up0.p();
                    GXINodeEvent gXINodeEvent = null;
                    if (p instanceof RecyclerView) {
                        GXTemplateEngine.g j = wq0.j();
                        if ((j == null ? null : j.c()) != null) {
                            RecyclerView recyclerView = (RecyclerView) p;
                            recyclerView.clearOnScrollListeners();
                            recyclerView.addOnScrollListener(new GXNodeTreeUpdate$Style$nodeViewEvent$1(wq0));
                        }
                    }
                    if (up0.n().g() != null) {
                        GXINodeEvent f = up0.f();
                        if (f == null) {
                            GXRegisterCenter.GXIExtensionNodeEvent m = GXRegisterCenter.Companion.a().m();
                            if (m != null) {
                                gXINodeEvent = m.create();
                            }
                            f = gXINodeEvent == null ? new xp0() : gXINodeEvent;
                        }
                        up0.O(f);
                        GXINodeEvent f2 = up0.f();
                        if (f2 != null) {
                            f2.addDataBindingEvent(wq0, up0, (JSONObject) json);
                            return;
                        }
                        throw new IllegalArgumentException(k21.r("Not support the event ", f2));
                    }
                }
            }
        }

        private final void t(wq0 wq0, up0 up0, JSONObject jSONObject) {
            GXTemplateEngine.GXITrackListener f;
            uq0 b;
            View p = up0.p();
            if (p != null) {
                xq0 n = up0.n();
                no0 i = n.i();
                boolean z = false;
                if (!(i == null || (b = i.b()) == null)) {
                    z = b.y();
                }
                if (!z) {
                    ar0 q = n.q();
                    JSONObject jSONObject2 = null;
                    if (q != null) {
                        Object value = q.a().value(jSONObject);
                        if (value instanceof JSONObject) {
                            jSONObject2 = (JSONObject) value;
                        }
                        if (jSONObject2 != null) {
                            GXTemplateEngine.j jVar = new GXTemplateEngine.j();
                            jVar.i(p);
                            jVar.h(jSONObject2);
                            jVar.f(n.n().d());
                            jVar.g(wq0.l());
                            jVar.e(-1);
                            if (wq0.f() == null) {
                                wq0.y(new LinkedHashMap());
                            }
                            Map<String, GXTemplateEngine.j> f2 = wq0.f();
                            if (f2 != null) {
                                f2.put(n.o(), jVar);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    xo0 g = n.g();
                    if (g != null) {
                        Object value2 = g.a().value(jSONObject);
                        if (value2 instanceof JSONObject) {
                            jSONObject2 = (JSONObject) value2;
                        }
                        if (jSONObject2 != null) {
                            GXTemplateEngine.j jVar2 = new GXTemplateEngine.j();
                            jVar2.i(p);
                            jVar2.h(jSONObject2);
                            jVar2.f(n.n().d());
                            jVar2.g(wq0.l());
                            jVar2.e(-1);
                            GXTemplateEngine.g j = wq0.j();
                            if (j != null && (f = j.f()) != null) {
                                f.onTrackEvent(jVar2);
                            }
                        }
                    }
                }
            }
        }

        private final void u(wq0 wq0, up0 up0, JSONObject jSONObject) {
            y(wq0, up0, jSONObject);
        }

        private final void v(wq0 wq0, up0 up0, JSONObject jSONObject) {
            xq0 r = up0.n().r();
            JSONObject jSONObject2 = null;
            JSON f = r == null ? null : r.f(jSONObject);
            if (f instanceof JSONObject) {
                jSONObject2 = (JSONObject) f;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            y(wq0, up0, jSONObject2);
        }

        private final void w(wq0 wq0, up0 up0, JSONObject jSONObject) {
            if (up0.n().u()) {
                v(wq0, up0, jSONObject);
            } else {
                x(wq0, up0, jSONObject);
            }
        }

        private final void x(wq0 wq0, up0 up0, JSONObject jSONObject) {
            xq0 r = up0.n().r();
            JSONObject jSONObject2 = null;
            JSON f = r == null ? null : r.f(jSONObject);
            if (f instanceof JSONObject) {
                jSONObject2 = (JSONObject) f;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            y(wq0, up0, jSONObject2);
            List<up0> d = up0.d();
            if (d != null) {
                Iterator<T> it = d.iterator();
                while (it.hasNext()) {
                    INSTANCE.z(wq0, it.next(), jSONObject2);
                }
            }
        }

        private final void y(wq0 wq0, up0 up0, JSONObject jSONObject) {
            q(wq0, up0);
            r(wq0, up0, jSONObject);
            t(wq0, up0, jSONObject);
            s(wq0, up0, jSONObject);
            p(wq0, up0, jSONObject);
        }

        public final void z(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
            k21.i(wq0, "gxTemplateContext");
            k21.i(up0, "gxNode");
            k21.i(jSONObject, "templateData");
            if (up0.A()) {
                w(wq0, up0, jSONObject);
            } else if (up0.s()) {
                u(wq0, up0, jSONObject);
            } else {
                A(wq0, up0, jSONObject);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        private final boolean a(up0 up0) {
            if (up0 == null) {
                return true;
            }
            if (!(up0.m().d().getStyle().getDisplay() == Display.Flex) || !a(up0.k())) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x01bd A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01a0  */
        private final boolean b(wq0 wq0, up0 up0, JSONObject jSONObject) {
            cp0 cp0;
            uq0 uq0;
            boolean z;
            Boolean f;
            ob2<m70> f2;
            m70 a;
            ob2<m70> f3;
            m70 a2;
            ob2<m70> f4;
            m70 a3;
            JSON f5 = up0.n().f(jSONObject);
            m70 m70 = null;
            JSONArray jSONArray = f5 instanceof JSONArray ? (JSONArray) f5 : null;
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            app.visly.stretch.Style style = up0.m().d().getStyle();
            no0 i = up0.n().i();
            if (i == null) {
                cp0 = null;
            } else {
                cp0 = i.a();
            }
            if (i == null) {
                uq0 = null;
            } else {
                uq0 = i.b();
            }
            if (cp0 == null) {
                throw new IllegalArgumentException("final flexbox is null, please check!");
            } else if (uq0 != null) {
                ob2<m70> u = cp0.u();
                if (u != null) {
                    m70 = u.a();
                }
                Float j = cp0.j();
                if (up0.F()) {
                    lq0 l = up0.n().l();
                    if (l != null) {
                        boolean z2 = l.f() && j == null && (m70 == null || k21.d(m70, m70.a.INSTANCE) || k21.d(m70, m70.d.INSTANCE));
                        GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
                        if (h != null) {
                            GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("scroll-compute-container-height", Boolean.valueOf(z2));
                            aVar.f(cp0);
                            ur2 ur2 = ur2.INSTANCE;
                            Object convert = h.convert(aVar);
                            if (convert != null) {
                                z2 = ((Boolean) convert).booleanValue();
                            }
                        }
                        if (!(!z2 || (f4 = aq0.INSTANCE.f(wq0, up0, jSONArray)) == null || (a3 = f4.a()) == null)) {
                            ob2<m70> u2 = cp0.u();
                            if (u2 != null) {
                                u2.c(a3);
                            }
                        }
                        z = false;
                        f = f(wq0, up0);
                        if (f != null) {
                            z = f.booleanValue();
                        }
                        if (z) {
                            return false;
                        }
                        style.free();
                        style.init();
                        up0.m().d().setStyle(style);
                        up0.m().d().markDirty();
                        return true;
                    }
                    throw new IllegalArgumentException("Want to updateContainerLayout, but finalScrollConfig is null");
                } else if (up0.v()) {
                    fp0 j2 = up0.n().j();
                    if (j2 != null) {
                        boolean z3 = j2.j() && j == null && (m70 == null || k21.d(m70, m70.a.INSTANCE) || k21.d(m70, m70.d.INSTANCE));
                        GXRegisterCenter.GXIExtensionDynamicProperty h2 = GXRegisterCenter.Companion.a().h();
                        if (h2 != null) {
                            GXRegisterCenter.GXIExtensionDynamicProperty.a aVar2 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("grid-compute-container-height", Boolean.valueOf(z3));
                            aVar2.g(j2);
                            aVar2.f(cp0);
                            ur2 ur22 = ur2.INSTANCE;
                            Object convert2 = h2.convert(aVar2);
                            if (convert2 != null) {
                                z3 = ((Boolean) convert2).booleanValue();
                            }
                        }
                        if (!(!z3 || (f3 = aq0.INSTANCE.f(wq0, up0, jSONArray)) == null || (a2 = f3.a()) == null)) {
                            ob2<m70> u3 = cp0.u();
                            if (u3 != null) {
                                u3.c(a2);
                            }
                        }
                        z = false;
                        f = f(wq0, up0);
                        if (f != null) {
                        }
                        if (z) {
                        }
                    } else {
                        throw new IllegalArgumentException("Want to updateContainerLayout, but finalGridConfig is null");
                    }
                } else {
                    if (up0.G()) {
                        if (!(!(m70 == null || k21.d(m70, m70.a.INSTANCE) || k21.d(m70, m70.d.INSTANCE)) || (f2 = aq0.INSTANCE.f(wq0, up0, jSONArray)) == null || (a = f2.a()) == null)) {
                            ob2<m70> u4 = cp0.u();
                            if (u4 != null) {
                                u4.c(a);
                            }
                        }
                    }
                    z = false;
                    f = f(wq0, up0);
                    if (f != null) {
                    }
                    if (z) {
                    }
                }
                z = true;
                f = f(wq0, up0);
                if (f != null) {
                }
                if (z) {
                }
            } else {
                throw new IllegalArgumentException("final css style is null, please check!");
            }
        }

        private final void c(wq0 wq0, up0 up0, JSONObject jSONObject) {
            up0.m().e();
            up0.n().s(wq0, null, jSONObject);
            j(wq0, up0, jSONObject);
        }

        private final Boolean d(wq0 wq0, up0 up0, JSONObject jSONObject) {
            no0 i = up0.n().i();
            uq0 b = i == null ? null : i.b();
            if (b == null || !k21.d(b.i(), Boolean.TRUE) || !a(up0)) {
                return null;
            }
            if (!wq0.q()) {
                return e(wq0, up0, up0.n(), up0.m(), b, jSONObject, up0.m().d().getStyle());
            }
            if (wq0.d() == null) {
                wq0.w(new LinkedHashSet());
            }
            Set<wo0> d = wq0.d();
            if (d != null) {
                d.add(new wo0(wq0, up0, jSONObject));
            }
            return null;
        }

        private final Boolean e(wq0 wq0, up0 up0, xq0 xq0, sq0 sq0, uq0 uq0, JSONObject jSONObject, app.visly.stretch.Style style) {
            ob2<m70> a = bp0.INSTANCE.a(wq0, up0, xq0, sq0, jSONObject);
            if (a == null) {
                return null;
            }
            yq0.INSTANCE.e(a, style.getSize());
            GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
            if (h != null) {
                GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("size", style.getSize());
                aVar.e(uq0);
                ur2 ur2 = ur2.INSTANCE;
                h.convert(aVar);
            }
            if (!(style.getFlexGrow() == 0.0f)) {
                style.setFlexGrow(0.0f);
            }
            return Boolean.TRUE;
        }

        private final Boolean f(wq0 wq0, up0 up0) {
            ox1<m70> s;
            no0 i = up0.n().i();
            Boolean bool = null;
            cp0 a = i == null ? null : i.a();
            if (a == null) {
                return null;
            }
            no0 i2 = up0.n().i();
            uq0 b = i2 == null ? null : i2.b();
            if (b == null) {
                return null;
            }
            app.visly.stretch.Style style = up0.m().d().getStyle();
            Display g = a.g();
            if (g != null) {
                style.setDisplay(g);
                bool = Boolean.TRUE;
            }
            Float d = a.d();
            if (d != null) {
                style.setAspectRatio(Float.valueOf(d.floatValue()));
                bool = Boolean.TRUE;
            }
            Direction f = a.f();
            if (f != null) {
                style.setDirection(f);
                bool = Boolean.TRUE;
            }
            FlexDirection i3 = a.i();
            if (i3 != null) {
                style.setFlexDirection(i3);
                bool = Boolean.TRUE;
            }
            FlexWrap l = a.l();
            if (l != null) {
                style.setFlexWrap(l);
                bool = Boolean.TRUE;
            }
            Overflow q = a.q();
            if (q != null) {
                style.setOverflow(q);
                bool = Boolean.TRUE;
            }
            AlignItems b2 = a.b();
            if (b2 != null) {
                style.setAlignItems(b2);
                bool = Boolean.TRUE;
            }
            AlignSelf c = a.c();
            if (c != null) {
                style.setAlignSelf(c);
                bool = Boolean.TRUE;
            }
            AlignContent a2 = a.a();
            if (a2 != null) {
                style.setAlignContent(a2);
                bool = Boolean.TRUE;
            }
            JustifyContent m = a.m();
            if (m != null) {
                style.setJustifyContent(m);
                bool = Boolean.TRUE;
            }
            PositionType t = a.t();
            if (t != null) {
                style.setPositionType(t);
                bool = Boolean.TRUE;
            }
            if (style.getPositionType() == PositionType.Absolute && (s = a.s()) != null) {
                yq0.INSTANCE.d(s, style.getPosition());
                bool = Boolean.TRUE;
            }
            ox1<m70> n = a.n();
            if (n != null) {
                yq0.INSTANCE.d(n, style.getMargin());
                bool = Boolean.TRUE;
            }
            ox1<m70> r = a.r();
            if (r != null) {
                yq0.INSTANCE.d(r, style.getPadding());
                bool = Boolean.TRUE;
            }
            ox1<m70> e = a.e();
            if (e != null) {
                yq0.INSTANCE.d(e, style.getBorder());
                bool = Boolean.TRUE;
            }
            Float j = a.j();
            if (j != null) {
                style.setFlexGrow(j.floatValue());
                wq0.x(true);
                bool = Boolean.TRUE;
            }
            Float k = a.k();
            if (k != null) {
                style.setFlexShrink(k.floatValue());
                bool = Boolean.TRUE;
            }
            ob2<m70> u = a.u();
            if (u != null) {
                yq0.INSTANCE.e(u, style.getSize());
                GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
                if (h != null) {
                    GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("size", style.getSize());
                    aVar.e(b);
                    ur2 ur2 = ur2.INSTANCE;
                    h.convert(aVar);
                }
                bool = Boolean.TRUE;
            }
            ob2<m70> p = a.p();
            if (p != null) {
                yq0.INSTANCE.e(p, style.getMinSize());
                GXRegisterCenter.GXIExtensionDynamicProperty h2 = GXRegisterCenter.Companion.a().h();
                if (h2 != null) {
                    GXRegisterCenter.GXIExtensionDynamicProperty.a aVar2 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("min-size", style.getMinSize());
                    aVar2.e(b);
                    ur2 ur22 = ur2.INSTANCE;
                    h2.convert(aVar2);
                }
                bool = Boolean.TRUE;
            }
            ob2<m70> o = a.o();
            if (o == null) {
                return bool;
            }
            yq0.INSTANCE.e(o, style.getMaxSize());
            GXRegisterCenter.GXIExtensionDynamicProperty h3 = GXRegisterCenter.Companion.a().h();
            if (h3 != null) {
                GXRegisterCenter.GXIExtensionDynamicProperty.a aVar3 = new GXRegisterCenter.GXIExtensionDynamicProperty.a("max-size", style.getMaxSize());
                aVar3.e(b);
                ur2 ur23 = ur2.INSTANCE;
                h3.convert(aVar3);
            }
            return Boolean.TRUE;
        }

        private final void g(wq0 wq0, up0 up0, JSONObject jSONObject) {
            xq0 r = up0.n().r();
            JSONObject jSONObject2 = null;
            JSON f = r == null ? null : r.f(jSONObject);
            if (f instanceof JSONArray) {
                GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
                boolean z = false;
                if (d != null && d.isCompatibilityContainerDataPassSequence()) {
                    z = true;
                }
                if (z) {
                    xq0 r2 = up0.n().r();
                    po0 e = r2 == null ? null : r2.e();
                    xq0 r3 = up0.n().r();
                    if (r3 != null) {
                        r3.I(up0.n().e());
                    }
                    up0.n().I(e);
                    xq0 r4 = up0.n().r();
                    if (r4 != null) {
                        r4.H();
                    }
                    up0.n().H();
                    xq0 r5 = up0.n().r();
                    f = r5 == null ? null : r5.f(jSONObject);
                } else {
                    throw new IllegalArgumentException("update nest container need a JSONObject, but the result is a JSONArray");
                }
            }
            if (f instanceof JSONObject) {
                jSONObject2 = (JSONObject) f;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            up0.m().e();
            up0.n().s(wq0, jSONObject, jSONObject2);
            j(wq0, up0, jSONObject2);
        }

        private final void h(wq0 wq0, up0 up0, JSONObject jSONObject) {
            if (up0.n().u()) {
                g(wq0, up0, jSONObject);
            } else {
                i(wq0, up0, jSONObject);
            }
        }

        private final void i(wq0 wq0, up0 up0, JSONObject jSONObject) {
            xq0 r = up0.n().r();
            JSONObject jSONObject2 = null;
            JSON f = r == null ? null : r.f(jSONObject);
            if (f instanceof JSONObject) {
                jSONObject2 = (JSONObject) f;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            up0.m().e();
            up0.n().s(wq0, jSONObject, jSONObject2);
            j(wq0, up0, jSONObject2);
            List<up0> d = up0.d();
            if (d != null) {
                Iterator<T> it = d.iterator();
                while (it.hasNext()) {
                    INSTANCE.k(wq0, it.next(), jSONObject2);
                }
            }
        }

        private final void j(wq0 wq0, up0 up0, JSONObject jSONObject) {
            if (up0.s()) {
                boolean b = b(wq0, up0, jSONObject);
                if (b) {
                    wq0.v(b);
                    return;
                }
                return;
            }
            boolean n = n(wq0, up0, jSONObject);
            if (n) {
                wq0.v(n);
            }
        }

        private final void k(wq0 wq0, up0 up0, JSONObject jSONObject) {
            up0.n().G();
            up0.m().f(wq0, up0.n());
            if (up0.A()) {
                h(wq0, up0, jSONObject);
            } else if (up0.s()) {
                c(wq0, up0, jSONObject);
            } else {
                o(wq0, up0, jSONObject);
            }
        }

        private final boolean n(wq0 wq0, up0 up0, JSONObject jSONObject) {
            boolean z;
            Boolean f = f(wq0, up0);
            if (f == null) {
                z = false;
            } else {
                z = f.booleanValue();
            }
            Boolean d = d(wq0, up0, jSONObject);
            if (d != null) {
                z = d.booleanValue();
            }
            Node d2 = up0.m().d();
            app.visly.stretch.Style style = d2.getStyle();
            if (!z) {
                return false;
            }
            style.free();
            style.init();
            d2.setStyle(style);
            d2.markDirty();
            return true;
        }

        private final void o(wq0 wq0, up0 up0, JSONObject jSONObject) {
            up0.m().e();
            up0.n().s(wq0, null, jSONObject);
            j(wq0, up0, jSONObject);
            List<up0> d = up0.d();
            if (d != null) {
                Iterator<T> it = d.iterator();
                while (it.hasNext()) {
                    INSTANCE.k(wq0, it.next(), jSONObject);
                }
            }
        }

        private final boolean p(wq0 wq0, up0 up0, JSONObject jSONObject) {
            xq0 n = up0.n();
            sq0 m = up0.m();
            app.visly.stretch.Style style = m.d().getStyle();
            no0 i = up0.n().i();
            uq0 b = i == null ? null : i.b();
            if (b == null || !k21.d(e(wq0, up0, n, m, b, jSONObject, style), Boolean.TRUE)) {
                return false;
            }
            style.free();
            style.init();
            m.d().setStyle(style);
            m.d().markDirty();
            return true;
        }

        public final void l(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject, @NotNull ob2<Float> ob2) {
            k21.i(wq0, "gxTemplateContext");
            k21.i(up0, "rootNode");
            k21.i(jSONObject, "templateData");
            k21.i(ob2, "size");
            k(wq0, up0, jSONObject);
            if (wq0.p()) {
                aq0.INSTANCE.j(up0, ob2);
            }
        }

        public final void m(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull ob2<Float> ob2) {
            k21.i(wq0, "gxTemplateContext");
            k21.i(up0, "rootNode");
            k21.i(ob2, "size");
            Set<wo0> d = wq0.d();
            boolean z = false;
            if (d != null && (d.isEmpty() ^ true)) {
                Set<wo0> d2 = wq0.d();
                if (d2 != null) {
                    for (T t : d2) {
                        if (INSTANCE.p(t.b(), t.a(), t.c())) {
                            z = true;
                        }
                    }
                }
                Set<wo0> d3 = wq0.d();
                if (d3 != null) {
                    d3.clear();
                }
                if (z) {
                    aq0.INSTANCE.j(up0, ob2);
                }
            }
        }
    }

    public GXNodeTreeUpdate(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        this.a = wq0;
    }

    public final void a() {
        up0 g = this.a.g();
        if (g != null) {
            GXTemplateEngine.g j = this.a.j();
            JSONObject a2 = j == null ? null : j.a();
            if (a2 != null) {
                ob2<Float> ob2 = new ob2<>(this.a.i().b(), this.a.i().a());
                a aVar = a.INSTANCE;
                aVar.l(this.a, g, a2, ob2);
                aVar.m(this.a, g, ob2);
                Style.INSTANCE.z(this.a, g, a2);
                return;
            }
            throw new IllegalArgumentException("Data is null");
        }
        throw new IllegalArgumentException("RootNode is null(buildLayoutAndStyle)");
    }

    public final void b() {
        up0 g = this.a.g();
        if (g != null) {
            GXTemplateEngine.g j = this.a.j();
            JSONObject a2 = j == null ? null : j.a();
            if (a2 != null) {
                ob2<Float> ob2 = new ob2<>(this.a.i().b(), this.a.i().a());
                a aVar = a.INSTANCE;
                aVar.l(this.a, g, a2, ob2);
                aVar.m(this.a, g, ob2);
                return;
            }
            throw new IllegalArgumentException("Data is null");
        }
        throw new IllegalArgumentException("RootNode is null(buildNodeLayout)");
    }

    public final void c() {
        up0 g = this.a.g();
        if (g != null) {
            GXTemplateEngine.g j = this.a.j();
            JSONObject a2 = j == null ? null : j.a();
            if (a2 != null) {
                Style.INSTANCE.z(this.a, g, a2);
                return;
            }
            throw new IllegalArgumentException("Data is null");
        }
        throw new IllegalArgumentException("RootNode is null(buildViewStyle)");
    }
}
