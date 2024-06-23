package com.youku.gaiax.impl;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXViewHolder;
import com.youku.gaiax.GaiaX;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\n\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXContainerHelper;", "", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "Lkotlin/Function1;", "Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Lkotlin/ParameterName;", "name", "holder", "Ltb/ur2;", "callBack", "findVisibleItems", "onPageVisible", "onPageInvisible", "Lcom/youku/gaiax/impl/GaiaXContext;", "gaiaXContext", "notifyOnPageVisible", "notifyOnPageInvisible", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContainerHelper {
    @NotNull
    public static final GaiaXContainerHelper INSTANCE = new GaiaXContainerHelper();

    private GaiaXContainerHelper() {
    }

    private final void findVisibleItems(GXContainer gXContainer, Function1<? super GXViewHolder, ur2> function1) {
        try {
            if (gXContainer.getLayoutManager() instanceof LinearLayoutManager) {
                RecyclerView.LayoutManager layoutManager = gXContainer.getLayoutManager();
                if (layoutManager != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                        while (true) {
                            int i = findFirstVisibleItemPosition + 1;
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition = gXContainer.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                            GXViewHolder gXViewHolder = findViewHolderForLayoutPosition instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition : null;
                            if (gXViewHolder != null) {
                                function1.invoke(gXViewHolder);
                            }
                            if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                                findFirstVisibleItemPosition = i;
                            } else {
                                return;
                            }
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
            } else if (gXContainer.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.LayoutManager layoutManager2 = gXContainer.getLayoutManager();
                if (layoutManager2 != null) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
                    int findFirstVisibleItemPosition2 = gridLayoutManager.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition2 = gridLayoutManager.findLastVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition2 <= findLastVisibleItemPosition2) {
                        while (true) {
                            int i2 = findFirstVisibleItemPosition2 + 1;
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition2 = gXContainer.findViewHolderForLayoutPosition(findFirstVisibleItemPosition2);
                            GXViewHolder gXViewHolder2 = findViewHolderForLayoutPosition2 instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition2 : null;
                            if (gXViewHolder2 != null) {
                                function1.invoke(gXViewHolder2);
                            }
                            if (findFirstVisibleItemPosition2 != findLastVisibleItemPosition2) {
                                findFirstVisibleItemPosition2 = i2;
                            } else {
                                return;
                            }
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void onPageInvisible(GXViewHolder gXViewHolder) {
        Object a = gXViewHolder.a();
        GaiaX.Params params = a instanceof GaiaX.Params ? (GaiaX.Params) a : null;
        if (params != null) {
            GaiaX.Companion.getInstance().invisibleView(params);
        }
    }

    /* access modifiers changed from: private */
    public final void onPageVisible(GXViewHolder gXViewHolder) {
        Object a = gXViewHolder.a();
        GaiaX.Params params = a instanceof GaiaX.Params ? (GaiaX.Params) a : null;
        if (params != null) {
            GaiaX.Companion.getInstance().visibleView(params);
        }
    }

    public final void notifyOnPageInvisible(@NotNull GaiaXContext gaiaXContext) {
        CopyOnWriteArraySet<GXIContainer> b;
        k21.i(gaiaXContext, "gaiaXContext");
        wq0 gxTemplateContext = gaiaXContext.getGxTemplateContext();
        if (!(gxTemplateContext == null || (b = gxTemplateContext.b()) == null)) {
            for (T t : b) {
                if (t != null) {
                    INSTANCE.findVisibleItems(t, GaiaXContainerHelper$notifyOnPageInvisible$1$1.INSTANCE);
                }
            }
        }
    }

    public final void notifyOnPageVisible(@NotNull GaiaXContext gaiaXContext) {
        CopyOnWriteArraySet<GXIContainer> b;
        k21.i(gaiaXContext, "gaiaXContext");
        wq0 gxTemplateContext = gaiaXContext.getGxTemplateContext();
        if (!(gxTemplateContext == null || (b = gxTemplateContext.b()) == null)) {
            for (T t : b) {
                if (t != null) {
                    INSTANCE.findVisibleItems(t, GaiaXContainerHelper$notifyOnPageVisible$1$1.INSTANCE);
                }
            }
        }
    }
}
