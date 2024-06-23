package com.alient.onearch.adapter.component.pager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001*Ba\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00120\u0010&\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020%0$0!0 ¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR@\u0010&\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020%0$0!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/GridPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "view", "Ltb/ur2;", "destroyItem", "Landroid/view/View;", "p0", "p1", "", "isViewFromObject", "getCount", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, Constants.Name.COLUMN_COUNT, "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "childComponentAdapters", "Ljava/util/List;", "<init>", "(Landroid/content/Context;IIIILjava/util/List;)V", "HorizontalViewItemDecoration", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GridPagerAdapter extends PagerAdapter {
    private final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> childComponentAdapters;
    private final int columnCount;
    private final Context context;
    private final int gap;
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    private final int marginLeft;
    private final int marginRight;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/GridPagerAdapter$HorizontalViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/ur2;", "getItemOffsets", com.youku.arch.v3.data.Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/pager/GridPagerAdapter;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class HorizontalViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;

        public HorizontalViewItemDecoration(int i, int i2, int i3) {
            this.gap = i;
            this.marginLeft = i2;
            this.marginRight = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            k21.i(rect, "outRect");
            k21.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return;
            }
            if (i == 0) {
                int i2 = this.marginLeft;
                if (i2 != 0) {
                    rect.left = i2;
                } else {
                    rect.left = this.gap;
                }
            } else if (i == adapter.getItemCount() - 1) {
                int i3 = this.marginRight;
                if (i3 != 0) {
                    rect.right = i3;
                } else {
                    rect.right = this.gap;
                }
                rect.left = this.gap;
            } else {
                rect.left = this.gap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.youku.arch.v3.adapter.VBaseAdapter<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public GridPagerAdapter(@NotNull Context context2, int i, int i2, int i3, int i4, @NotNull List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(list, "childComponentAdapters");
        this.context = context2;
        this.gap = i;
        this.marginLeft = i2;
        this.marginRight = i3;
        this.columnCount = i4;
        this.childComponentAdapters = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        k21.i(viewGroup, "container");
        k21.i(obj, "view");
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.childComponentAdapters.size();
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        k21.i(viewGroup, "container");
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = this.childComponentAdapters.get(i);
        RecyclerView recyclerView = new RecyclerView(this.context);
        recyclerView.setItemAnimator(null);
        HorizontalViewItemDecoration horizontalViewItemDecoration = new HorizontalViewItemDecoration(this.gap, this.marginLeft, this.marginRight);
        recyclerView.addItemDecoration(horizontalViewItemDecoration);
        ur2 ur2 = ur2.INSTANCE;
        this.itemDecoration = horizontalViewItemDecoration;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), this.columnCount));
        recyclerView.setAdapter(vBaseAdapter);
        vBaseAdapter.notifyDataSetChanged();
        viewGroup.addView(recyclerView);
        return recyclerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        k21.i(view, "p0");
        k21.i(obj, "p1");
        return k21.d(view, obj);
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration2) {
        this.itemDecoration = itemDecoration2;
    }
}
