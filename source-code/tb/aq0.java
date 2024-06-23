package tb;

import android.graphics.Rect;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.k;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m70;

/* compiled from: Taobao */
public final class aq0 {
    @NotNull
    public static final aq0 INSTANCE = new aq0();

    private aq0() {
    }

    private final void a(up0 up0, r61 r61) {
        r61.h(up0.m().d().getId());
        r61.i(up0.m().d().getIdPath());
        up0.m().h(r61);
        List<up0> d = up0.d();
        if (d != null) {
            int i = 0;
            for (T t : d) {
                int i2 = i + 1;
                if (i < 0) {
                    m.p();
                }
                INSTANCE.a(t, r61.c().get(i));
                i = i2;
            }
        }
    }

    private final void b(up0 up0, r61 r61) {
        r61.h(up0.m().d().getId());
        r61.i(up0.m().d().getIdPath());
        up0.m().i(r61);
        List<up0> d = up0.d();
        if (d != null) {
            int i = 0;
            for (T t : d) {
                int i2 = i + 1;
                if (i < 0) {
                    m.p();
                }
                INSTANCE.b(t, r61.c().get(i));
                i = i2;
            }
        }
    }

    private final r61 d(wq0 wq0, up0 up0, ob2<Float> ob2, GXTemplateEngine.h hVar, xq0 xq0, JSONObject jSONObject) {
        if (up0.F()) {
            return h(wq0, hVar, new GXTemplateEngine.e(ob2.b(), ob2.a()), new GXTemplateEngine.g(jSONObject), xq0).m().b();
        }
        if (up0.v()) {
            return h(wq0, hVar, new GXTemplateEngine.e(ob2.b(), ob2.a()), new GXTemplateEngine.g(jSONObject), xq0).m().b();
        }
        if (up0.G()) {
            return h(wq0, hVar, new GXTemplateEngine.e(ob2.b(), ob2.a()), new GXTemplateEngine.g(jSONObject), xq0).m().b();
        }
        return null;
    }

    private final ob2<m70> e(wq0 wq0, up0 up0, r61 r61, JSONArray jSONArray) {
        if (r61 != null) {
            if (up0.F()) {
                lq0 l = up0.n().l();
                if (l == null) {
                    throw new IllegalArgumentException("Want to computeContainerHeight, but finalScrollConfig is null");
                } else if (l.f()) {
                    return new ob2<>(new m70.c(r61.e()), new m70.c(r61.d()));
                } else {
                    if (l.g()) {
                        int max = Math.max(1, (int) Math.ceil((double) (((float) jSONArray.size()) * 1.0f)));
                        return new ob2<>(new m70.c(r61.e()), new m70.c((r61.d() * ((float) max)) + ((float) (l.e() * (max - 1)))));
                    }
                }
            } else if (up0.v()) {
                fp0 j = up0.n().j();
                if (j == null) {
                    throw new IllegalArgumentException("Want to computeContainerHeight, but finalGridConfig is null");
                } else if (j.j()) {
                    int max2 = Math.max(1, (int) Math.ceil((double) ((((float) jSONArray.size()) * 1.0f) / ((float) j.a(wq0)))));
                    float d = (r61.d() * ((float) max2)) + ((float) (j.g() * (max2 - 1)));
                    Rect e = j.e();
                    return new ob2<>(new m70.c((r61.e() - ((float) e.left)) - ((float) e.right)), new m70.c(d + ((float) (e.top + e.bottom))));
                } else {
                    j.i();
                    return null;
                }
            } else if (up0.G()) {
                return new ob2<>(new m70.c(r61.e()), new m70.c(r61.d()));
            }
        }
        return null;
    }

    private final up0 h(wq0 wq0, GXTemplateEngine.h hVar, GXTemplateEngine.e eVar, GXTemplateEngine.g gVar, xq0 xq0) {
        GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
        wq0 a = wq0.Companion.a(hVar, eVar, aVar.a().l().b(hVar), xq0);
        up0 d = aVar.a().p().d(a);
        a.C(gVar);
        aVar.a().p().a(a);
        return d;
    }

    @Nullable
    public final r61 c(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull ob2<Float> ob2, @NotNull GXTemplateEngine.h hVar, @Nullable xq0 xq0, @NotNull JSONArray jSONArray) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(ob2, "itemViewPort");
        k21.i(hVar, "gxItemTemplateItem");
        k21.i(jSONArray, "containerData");
        if (up0.F()) {
            return h(wq0, hVar, new GXTemplateEngine.e(ob2.b(), ob2.a()), new GXTemplateEngine.g(new JSONObject()), xq0).m().b();
        } else if (!up0.v()) {
            return null;
        } else {
            return h(wq0, hVar, new GXTemplateEngine.e(ob2.b(), ob2.a()), new GXTemplateEngine.g(new JSONObject()), xq0).m().b();
        }
    }

    @Nullable
    public final ob2<m70> f(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONArray jSONArray) {
        T t;
        r61 r61;
        aq0 aq0;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONArray, "containerData");
        List<Pair<GXTemplateEngine.h, xq0>> c = up0.c();
        boolean z = false;
        r61 r612 = null;
        if (c != null && c.isEmpty()) {
            return null;
        }
        Map<GXTemplateEngine.h, r61> j = up0.j();
        if (j == null) {
            j = new LinkedHashMap<>();
            up0.R(j);
        }
        j.clear();
        ob2<Float> i = i(wq0, up0);
        List<Pair<GXTemplateEngine.h, xq0>> c2 = up0.c();
        if (c2 != null && c2.size() == 1) {
            z = true;
        }
        if (z) {
            List<Pair<GXTemplateEngine.h, xq0>> c3 = up0.c();
            Pair pair = c3 == null ? null : (Pair) k.R(c3);
            if (pair == null) {
                return null;
            }
            GXTemplateEngine.h hVar = (GXTemplateEngine.h) pair.getFirst();
            xq0 xq0 = (xq0) pair.getSecond();
            if (!j.containsKey(hVar)) {
                Object R = k.R(jSONArray);
                JSONObject jSONObject = R instanceof JSONObject ? (JSONObject) R : null;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                r61 d = d(wq0, up0, i, hVar, xq0, jSONObject);
                if (d != null) {
                    j.put(hVar, d);
                    aq0 = this;
                    r612 = d;
                    return aq0.e(wq0, up0, r612, jSONArray);
                }
            } else {
                r612 = j.get(hVar);
            }
            aq0 = this;
            return aq0.e(wq0, up0, r612, jSONArray);
        }
        ArrayList<ob2<m70>> arrayList = new ArrayList();
        for (Object obj : jSONArray) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj;
            up0.n().H();
            JSONObject h = up0.n().h(jSONObject2);
            if (h != null) {
                String j2 = zo0.j(h, k21.r("item-type.config.", zo0.i(h, "item-type.path")));
                List<Pair<GXTemplateEngine.h, xq0>> c4 = up0.c();
                if (!(c4 == null || j2 == null)) {
                    Iterator<T> it = c4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = (T) r612;
                            break;
                        }
                        t = it.next();
                        if (k21.d(((GXTemplateEngine.h) t.getFirst()).d(), j2)) {
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        GXTemplateEngine.h hVar2 = (GXTemplateEngine.h) t2.getFirst();
                        xq0 xq02 = (xq0) t2.getSecond();
                        if (!j.containsKey(hVar2)) {
                            r61 = INSTANCE.d(wq0, up0, i, hVar2, xq02, jSONObject2);
                            if (r61 == null) {
                                r61 = null;
                            } else {
                                j.put(hVar2, r61);
                            }
                        } else {
                            r61 = j.get(hVar2);
                        }
                        ob2<m70> e = INSTANCE.e(wq0, up0, r61, jSONArray);
                        if (e != null) {
                            arrayList.add(e);
                        }
                    }
                }
            }
            r612 = null;
        }
        ob2<m70> ob2 = null;
        for (ob2<m70> ob22 : arrayList) {
            if (ob2 != null) {
                m70 a = ob2.a();
                Float valueOf = a == null ? null : Float.valueOf(a.b());
                m70 a2 = ob22.a();
                Float valueOf2 = a2 == null ? null : Float.valueOf(a2.b());
                if (valueOf != null) {
                    if (valueOf2 != null) {
                        if (valueOf2.floatValue() <= valueOf.floatValue()) {
                        }
                    }
                }
            }
            ob2 = ob22;
        }
        return ob2;
    }

    @NotNull
    public final ob2<Float> g(@NotNull wq0 wq0, @NotNull up0 up0) {
        Object convert;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        if (up0.F()) {
            lq0 l = up0.n().l();
            if (l != null) {
                GXRegisterCenter.GXIExtensionScroll n = GXRegisterCenter.Companion.a().n();
                if (n != null && (convert = n.convert("view-port-width", wq0, l)) != null) {
                    return new ob2<>((Float) convert, null);
                }
                float f = (float) l.c().left;
                float f2 = (float) l.c().right;
                Float b = wq0.i().b();
                if (b != null) {
                    return new ob2<>(Float.valueOf((b.floatValue() - f) - f2), null);
                }
            } else {
                throw new IllegalArgumentException("Want to computeItemViewPort, but finalScrollConfig is null");
            }
        } else if (up0.v()) {
            r61 b2 = up0.m().b();
            Float valueOf = b2 == null ? null : Float.valueOf(b2.e());
            if (valueOf == null) {
                r61 c = up0.m().c();
                valueOf = c == null ? null : Float.valueOf(c.e());
                if (valueOf == null) {
                    throw new IllegalArgumentException("Want to computeFooterItemViewPort, but containerWith is null");
                }
            }
            float floatValue = valueOf.floatValue();
            fp0 j = up0.n().j();
            if (j == null) {
                throw new IllegalArgumentException("Want to computeFooterItemViewPort, but finalGridConfig is null");
            } else if (j.j()) {
                return new ob2<>(Float.valueOf(floatValue - ((float) (j.e().left + j.e().right))), null);
            } else {
                if (j.i()) {
                    return new ob2<>(null, null);
                }
                return new ob2<>(null, null);
            }
        }
        return new ob2<>(null, null);
    }

    @NotNull
    public final ob2<Float> i(@NotNull wq0 wq0, @NotNull up0 up0) {
        cp0 a;
        ob2<m70> u;
        Object convert;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        if (up0.F()) {
            lq0 l = up0.n().l();
            if (l != null) {
                GXRegisterCenter.GXIExtensionScroll n = GXRegisterCenter.Companion.a().n();
                if (n != null && (convert = n.convert("view-port-width", wq0, l)) != null) {
                    return new ob2<>((Float) convert, null);
                }
                float f = (float) l.c().left;
                float f2 = (float) l.c().right;
                Float b = wq0.i().b();
                if (b != null) {
                    return new ob2<>(Float.valueOf((b.floatValue() - f) - f2), null);
                }
            } else {
                throw new IllegalArgumentException("Want to computeItemViewPort, but finalScrollConfig is null");
            }
        } else if (up0.v()) {
            r61 b2 = up0.m().b();
            Float valueOf = b2 == null ? null : Float.valueOf(b2.e());
            if (valueOf == null) {
                r61 c = up0.m().c();
                valueOf = c == null ? null : Float.valueOf(c.e());
                if (valueOf == null) {
                    throw new IllegalArgumentException("Want to computeItemViewPort, but containerWith is null");
                }
            }
            float floatValue = valueOf.floatValue();
            fp0 j = up0.n().j();
            if (j == null) {
                throw new IllegalArgumentException("Want to computeItemViewPort, but finalGridConfig is null");
            } else if (j.j()) {
                return new ob2<>(Float.valueOf((((floatValue - ((float) (j.f() * (j.a(wq0) - 1)))) - ((float) (j.e().left + j.e().right))) * 1.0f) / ((float) j.a(wq0))), null);
            } else {
                if (j.i()) {
                    return new ob2<>(null, null);
                }
                return new ob2<>(null, null);
            }
        } else if (up0.G()) {
            no0 i = up0.n().i();
            m70 b3 = (i == null || (a = i.a()) == null || (u = a.u()) == null) ? null : u.b();
            if (b3 instanceof m70.b) {
                Float b4 = wq0.i().b();
                if (b4 != null) {
                    return new ob2<>(Float.valueOf(b4.floatValue() * ((m70.b) b3).b()), null);
                }
            } else {
                Float b5 = wq0.i().b();
                if (b5 != null) {
                    return new ob2<>(Float.valueOf(b5.floatValue()), null);
                }
            }
        }
        return new ob2<>(null, null);
    }

    public final void j(@NotNull up0 up0, @NotNull ob2<Float> ob2) {
        k21.i(up0, "gxNode");
        k21.i(ob2, "size");
        a(up0, up0.m().d().computeLayout(ob2));
    }

    public final void k(@NotNull up0 up0, @NotNull ob2<Float> ob2) {
        k21.i(up0, "gxNode");
        k21.i(ob2, "size");
        b(up0, up0.m().d().computeLayout(ob2));
    }
}
