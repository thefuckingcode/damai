package com.alibaba.gaiax.render.view.container.slider;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oq0;
import tb.r61;
import tb.up0;
import tb.ur2;
import tb.wq0;
import tb.xq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderViewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Ltb/wq0;", "gxTemplateContext", "Ltb/up0;", "gxNode", "<init>", "(Ltb/wq0;Ltb/up0;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXSliderViewAdapter extends PagerAdapter {
    @NotNull
    private final wq0 a;
    @NotNull
    private final up0 b;
    @NotNull
    private final Map<String, View> c = new LinkedHashMap();
    @Nullable
    private oq0 d;
    @NotNull
    private JSONArray e = new JSONArray();

    /* compiled from: Taobao */
    public static final class a implements GXTemplateEngine.GXIEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXSliderViewAdapter b;

        a(int i, GXSliderViewAdapter gXSliderViewAdapter) {
            this.a = i;
            this.b = gXSliderViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull GXTemplateEngine.b bVar) {
            GXTemplateEngine.GXIEventListener c;
            k21.i(bVar, "gxAnimation");
            GXTemplateEngine.GXIEventListener.a.a(this, bVar);
            GXTemplateEngine.g j = this.b.a().j();
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
            GXTemplateEngine.g j = this.b.a().j();
            if (j != null && (c = j.c()) != null) {
                c.onGestureEvent(dVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull GXTemplateEngine.f fVar) {
            GXTemplateEngine.GXIEventListener c;
            k21.i(fVar, "gxScroll");
            GXTemplateEngine.GXIEventListener.a.c(this, fVar);
            GXTemplateEngine.g j = this.b.a().j();
            if (j != null && (c = j.c()) != null) {
                c.onScrollEvent(fVar);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements GXTemplateEngine.GXITrackListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXSliderViewAdapter b;

        b(int i, GXSliderViewAdapter gXSliderViewAdapter) {
            this.a = i;
            this.b = gXSliderViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualClickTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.a().j();
            if (j != null && (f = j.f()) != null) {
                f.onManualClickTrackEvent(jVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualExposureTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.a().j();
            if (j != null && (f = j.f()) != null) {
                f.onManualExposureTrackEvent(jVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onTrackEvent(@NotNull GXTemplateEngine.j jVar) {
            GXTemplateEngine.GXITrackListener f;
            k21.i(jVar, "gxTrack");
            jVar.e(Integer.valueOf(this.a));
            GXTemplateEngine.g j = this.b.a().j();
            if (j != null && (f = j.f()) != null) {
                f.onTrackEvent(jVar);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements GXTemplateEngine.GXIDataListener {
        final /* synthetic */ GXSliderViewAdapter a;

        c(GXSliderViewAdapter gXSliderViewAdapter) {
            this.a = gXSliderViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIDataListener
        @Nullable
        public CharSequence onTextProcess(@NotNull GXTemplateEngine.i iVar) {
            GXTemplateEngine.GXIDataListener b;
            k21.i(iVar, "gxTextData");
            GXTemplateEngine.g j = this.a.a().j();
            if (j == null || (b = j.b()) == null) {
                return null;
            }
            return b.onTextProcess(iVar);
        }
    }

    public GXSliderViewAdapter(@NotNull wq0 wq0, @NotNull up0 up0) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        this.a = wq0;
        this.b = up0;
    }

    private final String c(int i) {
        return k21.r("item_", Integer.valueOf(i));
    }

    private final GXTemplateEngine.h d() {
        Pair pair;
        List<Pair<GXTemplateEngine.h, xq0>> c2 = this.b.c();
        if (c2 == null || (pair = (Pair) k.R(c2)) == null) {
            return null;
        }
        return (GXTemplateEngine.h) pair.getFirst();
    }

    @NotNull
    public final wq0 a() {
        return this.a;
    }

    @Nullable
    public final View b(int i) {
        return this.c.get(c(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        k21.i(viewGroup, "container");
        k21.i(obj, "obj");
        this.c.remove(c(i));
    }

    public final void e(@Nullable oq0 oq0) {
        this.d = oq0;
    }

    public final void f(@NotNull JSONArray jSONArray) {
        k21.i(jSONArray, "data");
        this.e = jSONArray;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        oq0 oq0 = this.d;
        boolean z = false;
        if (oq0 != null && !oq0.g()) {
            z = true;
        }
        if (z) {
            return this.e.size();
        }
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Float f;
        k21.i(viewGroup, "container");
        int size = this.e.size() > 0 ? i % this.e.size() : i;
        GXTemplateEngine.h d2 = d();
        if (d2 != null) {
            JSONObject jSONObject = this.e.getJSONObject(size);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            r61 b2 = this.b.m().b();
            if (b2 == null) {
                b2 = this.b.m().c();
            }
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            GXTemplateEngine a2 = aVar.a();
            Float f2 = null;
            if (b2 == null) {
                f = null;
            } else {
                f = Float.valueOf(b2.e());
            }
            if (b2 != null) {
                f2 = Float.valueOf(b2.d());
            }
            View h = GXTemplateEngine.h(a2, d2, new GXTemplateEngine.e(f, f2), null, 4, null);
            if (h != null) {
                GXTemplateEngine a3 = aVar.a();
                GXTemplateEngine.g gVar = new GXTemplateEngine.g(jSONObject);
                gVar.h(new a(size, this));
                gVar.k(new b(size, this));
                gVar.g(new c(this));
                ur2 ur2 = ur2.INSTANCE;
                GXTemplateEngine.c(a3, h, gVar, null, 4, null);
                viewGroup.addView(h);
            }
            this.c.put(c(i), h);
            if (h != null) {
                return h;
            }
            throw new IllegalArgumentException("Create Item View error");
        }
        throw new IllegalArgumentException(k21.r("GXTemplateItem not exist, gxNode = ", this.b));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        k21.i(view, "view");
        k21.i(obj, "obj");
        return k21.d(view, obj);
    }
}
