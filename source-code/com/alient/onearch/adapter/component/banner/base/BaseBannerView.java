package com.alient.onearch.adapter.component.banner.base;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.component.banner.base.BaseBannerContract;
import com.alient.onearch.adapter.view.AbsView;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ViewUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u000201B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0012\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J(\u0010\u0016\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u001a\u0010\u0019\u001a\u00020\t2\u0010\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010*¨\u00062"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerModel;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerPresenter;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerContract$View;", "", "position", "Ltb/ur2;", "pageChanged", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "getDimenId", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "params", "initRecyclerSettings", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "setAdapter", "resetViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "Landroidx/recyclerview/widget/PagerSnapHelper;", "pagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "getPagerSnapHelper", "()Landroidx/recyclerview/widget/PagerSnapHelper;", "setPagerSnapHelper", "(Landroidx/recyclerview/widget/PagerSnapHelper;)V", "selectedItemPosition", "I", "intermediateSelectedItemPosition", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "BannerViewItemDecoration", "InternalRecyclerScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class BaseBannerView extends AbsView<GenericItem<ItemValue>, BaseBannerModel, BaseBannerPresenter> implements BaseBannerContract.View {
    private int intermediateSelectedItemPosition;
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    @NotNull
    private PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
    private int selectedItemPosition;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView$BannerViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/ur2;", "getItemOffsets", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class BannerViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;

        public BannerViewItemDecoration(int i, int i2, int i3) {
            this.gap = i;
            this.marginLeft = i2;
            this.marginRight = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            k21.i(rect, "outRect");
            k21.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                if (i == 0) {
                    int i2 = this.marginLeft;
                    if (i2 != 0) {
                        rect.left = i2;
                    } else {
                        rect.left = this.gap;
                    }
                }
                if (i == adapter.getItemCount() - 1) {
                    int i3 = this.marginRight;
                    if (i3 != 0) {
                        rect.right = i3;
                    } else {
                        rect.right = this.gap;
                    }
                } else {
                    rect.right = this.gap / 2;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "getMostVisibleChild", "containerView", "child", "", "calculatePercentVisible", "mostVisibleChild", "Ltb/ur2;", "setSelectedItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED, "<init>", "(Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public InternalRecyclerScrollListener() {
        }

        private final float calculatePercentVisible(View view, View view2) {
            float width;
            int left = view2.getLeft();
            int right = view2.getRight();
            int width2 = view2.getWidth();
            if (left < 0) {
                width = (float) right;
            } else if (right <= view.getWidth()) {
                return 1.0f;
            } else {
                width = (float) (view.getWidth() - left);
            }
            return width / ((float) width2);
        }

        private final View getMostVisibleChild() {
            View renderView;
            RecyclerView.LayoutManager layoutManager = BaseBannerView.this.getRecyclerView().getLayoutManager();
            k21.f(layoutManager);
            k21.h(layoutManager, "recyclerView.layoutManager!!");
            View view = null;
            float f = 0.0f;
            for (int childCount = layoutManager.getChildCount() - 1; childCount >= 0; childCount--) {
                RecyclerView.LayoutManager layoutManager2 = BaseBannerView.this.getRecyclerView().getLayoutManager();
                k21.f(layoutManager2);
                View childAt = layoutManager2.getChildAt(childCount);
                if (!(childAt == null || (renderView = BaseBannerView.this.getRenderView()) == null)) {
                    k21.h(childAt, "this");
                    float calculatePercentVisible = calculatePercentVisible(renderView, childAt);
                    if (calculatePercentVisible >= f) {
                        view = childAt;
                        f = calculatePercentVisible;
                    }
                }
            }
            return view;
        }

        private final void setSelectedItemPosition(View view) {
            RecyclerView.ViewHolder findContainingViewHolder = BaseBannerView.this.getRecyclerView().findContainingViewHolder(view);
            if (findContainingViewHolder != null) {
                BaseBannerView.this.intermediateSelectedItemPosition = Integer.valueOf(findContainingViewHolder.getAdapterPosition()).intValue();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
            View mostVisibleChild;
            k21.i(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && (mostVisibleChild = getMostVisibleChild()) != null) {
                setSelectedItemPosition(mostVisibleChild);
                BaseBannerView baseBannerView = BaseBannerView.this;
                baseBannerView.selectedItemPosition = baseBannerView.intermediateSelectedItemPosition;
                BaseBannerView baseBannerView2 = BaseBannerView.this;
                baseBannerView2.pageChanged(baseBannerView2.selectedItemPosition);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseBannerView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void pageChanged(int i) {
        ((BaseBannerPresenter) getPresenter()).onPageChanged(i);
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @NotNull
    public final PagerSnapHelper getPagerSnapHelper() {
        return this.pagerSnapHelper;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        int i;
        int i2;
        int i3;
        RecyclerView recyclerView = getRecyclerView();
        if (map != null) {
            int dimenId = getDimenId(recyclerView.getContext(), map, com.youku.arch.v3.data.Constants.GAP);
            if (dimenId != 0) {
                Context context = recyclerView.getContext();
                k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
                i = context.getResources().getDimensionPixelSize(dimenId);
            } else {
                i = 0;
            }
            int dimenId2 = getDimenId(recyclerView.getContext(), map, Constants.Name.MARGIN_LEFT);
            if (dimenId2 != 0) {
                Context context2 = recyclerView.getContext();
                k21.h(context2, WPKFactory.INIT_KEY_CONTEXT);
                i2 = context2.getResources().getDimensionPixelSize(dimenId2);
            } else {
                i2 = 0;
            }
            int dimenId3 = getDimenId(recyclerView.getContext(), map, Constants.Name.MARGIN_RIGHT);
            if (dimenId3 != 0) {
                Context context3 = recyclerView.getContext();
                k21.h(context3, WPKFactory.INIT_KEY_CONTEXT);
                i3 = context3.getResources().getDimensionPixelSize(dimenId3);
            } else {
                i3 = 0;
            }
            RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
            if (itemDecoration2 != null) {
                recyclerView.removeItemDecoration(itemDecoration2);
            }
            BannerViewItemDecoration bannerViewItemDecoration = new BannerViewItemDecoration(i, i2, i3);
            recyclerView.addItemDecoration(bannerViewItemDecoration);
            ur2 ur2 = ur2.INSTANCE;
            this.itemDecoration = bannerViewItemDecoration;
        }
        if (recycledViewPool != null) {
            recyclerView.setRecycledViewPool(recycledViewPool);
        }
        this.pagerSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addOnScrollListener(new InternalRecyclerScrollListener());
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void resetViewHolder() {
        getRecyclerView().post(new BaseBannerView$resetViewHolder$1(this));
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        getRecyclerView().swapAdapter(vBaseAdapter, false);
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPosition(this.selectedItemPosition);
        }
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration2) {
        this.itemDecoration = itemDecoration2;
    }

    public final void setPagerSnapHelper(@NotNull PagerSnapHelper pagerSnapHelper2) {
        k21.i(pagerSnapHelper2, "<set-?>");
        this.pagerSnapHelper = pagerSnapHelper2;
    }
}
