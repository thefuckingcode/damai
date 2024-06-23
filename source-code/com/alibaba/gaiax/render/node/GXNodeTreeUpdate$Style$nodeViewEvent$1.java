package com.alibaba.gaiax.render.node;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/node/GXNodeTreeUpdate$Style$nodeViewEvent$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXNodeTreeUpdate$Style$nodeViewEvent$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ wq0 a;

    GXNodeTreeUpdate$Style$nodeViewEvent$1(wq0 wq0) {
        this.a = wq0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        GXTemplateEngine.GXIEventListener c;
        k21.i(recyclerView, "recyclerView");
        GXTemplateEngine.f fVar = new GXTemplateEngine.f();
        fVar.i(GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED);
        fVar.j(recyclerView);
        fVar.h(i);
        GXTemplateEngine.g j = this.a.j();
        if (j != null && (c = j.c()) != null) {
            c.onScrollEvent(fVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        GXTemplateEngine.GXIEventListener c;
        k21.i(recyclerView, "recyclerView");
        GXTemplateEngine.f fVar = new GXTemplateEngine.f();
        fVar.i(GXTemplateEngine.f.TYPE_ON_SCROLLED);
        fVar.j(recyclerView);
        fVar.f(i);
        fVar.g(i2);
        GXTemplateEngine.g j = this.a.j();
        if (j != null && (c = j.c()) != null) {
            c.onScrollEvent(fVar);
        }
    }
}
