package com.alibaba.gaiax.render.view.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.basic.GXItemContainer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aq0;
import tb.k21;
import tb.lq0;
import tb.ob2;
import tb.r61;
import tb.up0;
import tb.wq0;
import tb.xq0;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Ltb/wq0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "gxContainer", "<init>", "(Ltb/wq0;Lcom/alibaba/gaiax/render/view/container/GXContainer;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXContainerViewAdapter extends RecyclerView.Adapter<GXViewHolder> {
    @NotNull
    private final wq0 a;
    @NotNull
    private final GXContainer b;
    public up0 c;
    @NotNull
    private JSONArray d = new JSONArray();
    @Nullable
    private GXTemplateEngine.h e;
    private boolean f;
    @NotNull
    private final Map<Integer, GXTemplateEngine.h> g = new LinkedHashMap();
    @NotNull
    private final Map<Integer, GXTemplateEngine.h> h = new LinkedHashMap();

    /* compiled from: Taobao */
    public static final class a implements GXTemplateEngine.GXIEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXContainerViewAdapter b;

        a(int i, GXContainerViewAdapter gXContainerViewAdapter) {
            this.a = i;
            this.b = gXContainerViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull GXTemplateEngine.b bVar) {
            GXTemplateEngine.GXIEventListener c;
            k21.i(bVar, "gxAnimation");
            GXTemplateEngine.GXIEventListener.a.a(this, bVar);
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (c = j.c()) != null) {
                c.onAnimationEvent(bVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull GXTemplateEngine.d dVar) {
            GXTemplateEngine.GXIEventListener c;
            k21.i(dVar, "gxGesture");
            GXTemplateEngine.GXIEventListener.a.b(this, dVar);
            dVar.setIndex(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (c = j.c()) != null) {
                c.onGestureEvent(dVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull GXTemplateEngine.f fVar) {
            GXTemplateEngine.GXIEventListener c;
            k21.i(fVar, "gxScroll");
            GXTemplateEngine.GXIEventListener.a.c(this, fVar);
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (c = j.c()) != null) {
                c.onScrollEvent(fVar);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements GXTemplateEngine.GXITrackListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXContainerViewAdapter b;

        b(int i, GXContainerViewAdapter gXContainerViewAdapter) {
            this.a = i;
            this.b = gXContainerViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualClickTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (f = j.f()) != null) {
                f.onManualClickTrackEvent(jVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualExposureTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (f = j.f()) != null) {
                f.onManualExposureTrackEvent(jVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.i().j();
            if (j != null && (f = j.f()) != null) {
                f.onTrackEvent(jVar);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements GXTemplateEngine.GXIDataListener {
        final /* synthetic */ GXContainerViewAdapter a;

        c(GXContainerViewAdapter gXContainerViewAdapter) {
            this.a = gXContainerViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIDataListener
        @Nullable
        public CharSequence onTextProcess(@NotNull GXTemplateEngine.i iVar) {
            GXTemplateEngine.GXIDataListener b;
            k21.i(iVar, "gxTextData");
            GXTemplateEngine.g j = this.a.i().j();
            if (j == null || (b = j.b()) == null) {
                return null;
            }
            return b.onTextProcess(iVar);
        }
    }

    public GXContainerViewAdapter(@NotNull wq0 wq0, @NotNull GXContainer gXContainer) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(gXContainer, "gxContainer");
        this.a = wq0;
        this.b = gXContainer;
    }

    private final void a(GXViewHolder gXViewHolder) {
        JSONObject jSONObject;
        View view;
        GXTemplateEngine.h b2 = gXViewHolder.b();
        if (b2 != null) {
            boolean d2 = k21.d(b2, this.e);
            xq0 k = k(b2);
            ob2<Float> e2 = e(d2);
            GXTemplateEngine.e j = j(e2);
            FrameLayout.LayoutParams d3 = d(c(d2, b2, j, k, e2));
            GXItemContainer gXItemContainer = (GXItemContainer) gXViewHolder.itemView;
            lq0 l = h().n().l();
            if (l != null && l.f()) {
                gXItemContainer.setGravity(l.d());
            }
            gXItemContainer.setLayoutParams(d3);
            int adapterPosition = gXViewHolder.getAdapterPosition();
            if (adapterPosition < this.d.size()) {
                jSONObject = this.d.getJSONObject(adapterPosition);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            GXRegisterCenter.GXIExtensionContainerItemBind f2 = GXRegisterCenter.Companion.a().f();
            if (f2 != null) {
                GXTemplateEngine.g j2 = this.a.j();
                gXViewHolder.c(f2.bindViewHolder(j2 == null ? null : j2.e(), gXItemContainer, j, b2, adapterPosition, k, jSONObject));
                return;
            }
            if (gXItemContainer.getChildCount() != 0) {
                view = gXItemContainer.getChildAt(0);
            } else {
                view = GXTemplateEngine.Companion.a().g(b2, j, k);
                gXItemContainer.addView(view);
            }
            GXTemplateEngine.g gVar = new GXTemplateEngine.g(jSONObject);
            gVar.h(new a(adapterPosition, this));
            gVar.k(new b(adapterPosition, this));
            gVar.g(new c(this));
            if (view != null) {
                GXTemplateEngine.Companion.a().b(view, gVar, j);
                gXItemContainer.getLayoutParams().width = view.getLayoutParams().width;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("childTemplateItem is null");
    }

    private final GXViewHolder b(int i, ViewGroup viewGroup) {
        GXTemplateEngine.h hVar = this.g.get(Integer.valueOf(i));
        if (hVar != null) {
            boolean d2 = k21.d(hVar, this.e);
            xq0 k = k(hVar);
            ob2<Float> e2 = e(d2);
            FrameLayout.LayoutParams d3 = d(c(d2, hVar, j(e2), k, e2));
            Context context = viewGroup.getContext();
            k21.h(context, "parent.context");
            GXItemContainer gXItemContainer = new GXItemContainer(context);
            lq0 l = h().n().l();
            if (l != null && l.f()) {
                gXItemContainer.setGravity(l.d());
            }
            gXItemContainer.setLayoutParams(d3);
            GXViewHolder gXViewHolder = new GXViewHolder(gXItemContainer);
            gXViewHolder.d(hVar);
            return gXViewHolder;
        }
        throw new IllegalArgumentException("GXTemplateItem not exist, viewType = " + i + ", viewTypeMap = " + this.g);
    }

    private final r61 c(boolean z, GXTemplateEngine.h hVar, GXTemplateEngine.e eVar, xq0 xq0, ob2<Float> ob2) {
        if (z) {
            return aq0.INSTANCE.c(GXTemplateEngine.Companion.a().f(hVar, eVar, xq0), h(), ob2, hVar, xq0, this.d);
        }
        Map<GXTemplateEngine.h, r61> j = h().j();
        r61 r61 = j == null ? null : j.get(hVar);
        if (r61 != null) {
            return r61;
        }
        aq0.INSTANCE.f(i(), h(), this.d);
        Map<GXTemplateEngine.h, r61> j2 = h().j();
        if (j2 == null) {
            return null;
        }
        return j2.get(hVar);
    }

    private final FrameLayout.LayoutParams d(r61 r61) {
        Integer num;
        int i = -2;
        int e2 = r61 == null ? -2 : (int) r61.e();
        lq0 l = h().n().l();
        if (l == null) {
            num = null;
        } else {
            num = Integer.valueOf(l.f() ? g().getLayoutParams().height : r61 == null ? -2 : (int) r61.d());
        }
        if (num != null) {
            i = num.intValue();
        } else if (r61 != null) {
            i = (int) r61.d();
        }
        return new FrameLayout.LayoutParams(e2, i);
    }

    private final ob2<Float> e(boolean z) {
        if (z) {
            return aq0.INSTANCE.g(this.a, h());
        }
        return aq0.INSTANCE.i(this.a, h());
    }

    private final GXTemplateEngine.h f(int i) {
        String j;
        T t;
        List<Pair<GXTemplateEngine.h, xq0>> c2 = h().c();
        if (c2 == null) {
            return null;
        }
        if (c2.size() > 1) {
            JSONObject jSONObject = this.d.getJSONObject(i);
            h().n().H();
            JSONObject h2 = h().n().h(jSONObject);
            if (h2 == null || (j = zo0.j(h2, k21.r("item-type.config.", zo0.i(h2, "item-type.path")))) == null) {
                return null;
            }
            Iterator<T> it = c2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (k21.d(((GXTemplateEngine.h) t.getFirst()).d(), j)) {
                    break;
                }
            }
            T t2 = t;
            if (t2 == null) {
                return null;
            }
            return (GXTemplateEngine.h) t2.getFirst();
        }
        Pair pair = (Pair) k.R(c2);
        if (pair == null) {
            return null;
        }
        return (GXTemplateEngine.h) pair.getFirst();
    }

    private final GXTemplateEngine.e j(ob2<Float> ob2) {
        return new GXTemplateEngine.e(ob2.b(), ob2.a());
    }

    private final xq0 k(GXTemplateEngine.h hVar) {
        List<Pair<GXTemplateEngine.h, xq0>> c2 = h().c();
        if (c2 == null) {
            return null;
        }
        for (T t : c2) {
            if (k21.d(((GXTemplateEngine.h) t.getFirst()).d(), hVar.d())) {
                return (xq0) t.getSecond();
            }
        }
        return null;
    }

    @NotNull
    public final GXContainer g() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (l()) {
            return this.d.size() + 1;
        }
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        GXTemplateEngine.h hVar = this.e;
        if (!this.f || hVar == null || i != this.d.size()) {
            GXTemplateEngine.h f2 = f(i);
            if (f2 == null) {
                return super.getItemViewType(i);
            }
            int hashCode = f2.d().hashCode();
            this.g.put(Integer.valueOf(hashCode), f2);
            this.h.put(Integer.valueOf(i), f2);
            return hashCode;
        }
        int hashCode2 = hVar.hashCode();
        this.g.put(Integer.valueOf(hashCode2), hVar);
        this.h.put(Integer.valueOf(i), hVar);
        return hashCode2;
    }

    @NotNull
    public final up0 h() {
        up0 up0 = this.c;
        if (up0 != null) {
            return up0;
        }
        k21.A("gxNode");
        return null;
    }

    @NotNull
    public final wq0 i() {
        return this.a;
    }

    public final boolean l() {
        return this.e != null && this.f;
    }

    public final void m() {
        GXTemplateEngine.g j = this.a.j();
        JSONObject jSONObject = null;
        JSONObject a2 = j == null ? null : j.a();
        if (a2 != null) {
            JSONObject h2 = h().n().h(a2);
            if (h2 != null) {
                jSONObject = h2.getJSONObject("item-footer-type");
            }
            if (jSONObject != null) {
                String string = jSONObject.getString("id");
                Context c2 = this.a.c();
                String a3 = this.a.l().a();
                k21.h(string, "templateId");
                this.e = new GXTemplateEngine.h(c2, a3, string);
                Boolean bool = jSONObject.getBoolean("hasMore");
                this.f = bool == null ? false : bool.booleanValue();
            }
        }
    }

    public final boolean n(float f2) {
        Float f3;
        r61 b2 = h().m().b();
        if (b2 == null) {
            f3 = null;
        } else {
            f3 = Float.valueOf(b2.e());
        }
        return !k21.b(f3, f2);
    }

    /* renamed from: o */
    public void onBindViewHolder(@NotNull GXViewHolder gXViewHolder, int i) {
        k21.i(gXViewHolder, "holder");
        try {
            a(gXViewHolder);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                return;
            }
            throw e2;
        }
    }

    @NotNull
    /* renamed from: p */
    public GXViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        k21.i(viewGroup, "parent");
        try {
            return b(i, viewGroup);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                Context context = viewGroup.getContext();
                k21.h(context, "parent.context");
                return new GXViewHolder(new GXItemContainer(context));
            }
            throw e2;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void q(@NotNull JSONArray jSONArray) {
        k21.i(jSONArray, "data");
        this.g.clear();
        this.h.clear();
        GXRegisterCenter.GXIExtensionContainerDataUpdate e2 = GXRegisterCenter.Companion.a().e();
        if (e2 != null) {
            JSONArray jSONArray2 = this.d;
            this.d = jSONArray;
            e2.update(this.a, this, jSONArray2, jSONArray);
            return;
        }
        this.d = jSONArray;
        notifyDataSetChanged();
    }

    public final void r(@NotNull up0 up0) {
        k21.i(up0, "<set-?>");
        this.c = up0;
    }
}
