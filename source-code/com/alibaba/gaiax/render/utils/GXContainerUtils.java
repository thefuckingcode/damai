package com.alibaba.gaiax.render.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXViewHolder;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;
import tb.wq0;

/* compiled from: Taobao */
public final class GXContainerUtils {
    @NotNull
    public static final GXContainerUtils INSTANCE = new GXContainerUtils();

    private GXContainerUtils() {
    }

    /* access modifiers changed from: private */
    public final void f(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                GXTemplateEngine a = GXTemplateEngine.Companion.a();
                View childAt = viewGroup.getChildAt(0);
                k21.h(childAt, "view.getChildAt(0)");
                a.w(childAt);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                GXTemplateEngine a = GXTemplateEngine.Companion.a();
                View childAt = viewGroup.getChildAt(0);
                k21.h(childAt, "view.getChildAt(0)");
                a.x(childAt);
            }
        }
    }

    public final void c(@NotNull GXIContainer gXIContainer, @NotNull Function1<? super View, ur2> function1) {
        ViewPager viewPager;
        View b;
        k21.i(gXIContainer, "container");
        k21.i(function1, "callBack");
        try {
            if (gXIContainer instanceof GXContainer) {
                if (((GXContainer) gXIContainer).getLayoutManager() instanceof LinearLayoutManager) {
                    RecyclerView.LayoutManager layoutManager = ((GXContainer) gXIContainer).getLayoutManager();
                    if (layoutManager != null) {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() + 1;
                        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            while (true) {
                                int i = findFirstVisibleItemPosition + 1;
                                RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((GXContainer) gXIContainer).findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                                GXViewHolder gXViewHolder = findViewHolderForLayoutPosition instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition : null;
                                if (gXViewHolder != null) {
                                    View view = gXViewHolder.itemView;
                                    k21.h(view, "it.itemView");
                                    function1.invoke(view);
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
                } else if (((GXContainer) gXIContainer).getLayoutManager() instanceof GridLayoutManager) {
                    RecyclerView.LayoutManager layoutManager2 = ((GXContainer) gXIContainer).getLayoutManager();
                    if (layoutManager2 != null) {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
                        int findFirstVisibleItemPosition2 = gridLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition2 = gridLayoutManager.findLastVisibleItemPosition() + 1;
                        if (findFirstVisibleItemPosition2 <= findLastVisibleItemPosition2) {
                            while (true) {
                                int i2 = findFirstVisibleItemPosition2 + 1;
                                RecyclerView.ViewHolder findViewHolderForLayoutPosition2 = ((GXContainer) gXIContainer).findViewHolderForLayoutPosition(findFirstVisibleItemPosition2);
                                GXViewHolder gXViewHolder2 = findViewHolderForLayoutPosition2 instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition2 : null;
                                if (gXViewHolder2 != null) {
                                    View view2 = gXViewHolder2.itemView;
                                    k21.h(view2, "it.itemView");
                                    function1.invoke(view2);
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
            } else if ((gXIContainer instanceof GXSliderView) && (viewPager = ((GXSliderView) gXIContainer).getViewPager()) != null) {
                PagerAdapter adapter = viewPager.getAdapter();
                if ((adapter instanceof GXSliderViewAdapter) && (b = ((GXSliderViewAdapter) adapter).b(viewPager.getCurrentItem())) != null) {
                    function1.invoke(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        CopyOnWriteArraySet<GXIContainer> b = wq0.b();
        if (b != null) {
            for (T t : b) {
                GXContainerUtils gXContainerUtils = INSTANCE;
                k21.h(t, "container");
                gXContainerUtils.c(t, GXContainerUtils$notifyOnAppear$1$1.INSTANCE);
            }
        }
    }

    public final void e(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        CopyOnWriteArraySet<GXIContainer> b = wq0.b();
        if (b != null) {
            for (T t : b) {
                GXContainerUtils gXContainerUtils = INSTANCE;
                k21.h(t, "container");
                gXContainerUtils.c(t, GXContainerUtils$notifyOnDisappear$1$1.INSTANCE);
            }
        }
    }
}
