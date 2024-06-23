package com.alibaba.gaiax.render.view.container;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXViewHolder extends RecyclerView.ViewHolder {
    @Nullable
    private Object a;
    @Nullable
    private GXTemplateEngine.h b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
    }

    @Nullable
    public final Object a() {
        return this.a;
    }

    @Nullable
    public final GXTemplateEngine.h b() {
        return this.b;
    }

    public final void c(@Nullable Object obj) {
        this.a = obj;
    }

    public final void d(@Nullable GXTemplateEngine.h hVar) {
        this.b = hVar;
    }
}
