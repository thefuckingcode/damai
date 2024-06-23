package com.alient.onearch.adapter.responsive.util;

import android.app.Activity;
import com.alibaba.android.vlayout.a;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.recyclerview.layouthelper.FeedStaggeredGridLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.bd2;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u000f"}, d2 = {"Lcom/alient/onearch/adapter/responsive/util/ResponsiveLayoutDataUtil;", "", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "updatedComponents", "Ltb/ur2;", "notifyResponsiveLayoutAdapterChanged", "component", "responsiveLayoutAdapter", "responsiveLayoutHelper", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ResponsiveLayoutDataUtil {
    @NotNull
    public static final ResponsiveLayoutDataUtil INSTANCE = new ResponsiveLayoutDataUtil();

    private ResponsiveLayoutDataUtil() {
    }

    public final void notifyResponsiveLayoutAdapterChanged(@NotNull IContext iContext, @NotNull List<? extends IComponent<ComponentValue>> list) {
        k21.i(iContext, Constants.PAGE_CONTEXT);
        k21.i(list, "updatedComponents");
        if (!list.isEmpty()) {
            iContext.runOnUIThread(new ResponsiveLayoutDataUtil$notifyResponsiveLayoutAdapterChanged$1(iContext, list));
        }
    }

    public final void responsiveLayoutAdapter(@NotNull IComponent<ComponentValue> iComponent) {
        k21.i(iComponent, "component");
        if (iComponent.getAdapter() != null) {
            INSTANCE.responsiveLayoutHelper(iComponent);
        }
    }

    public final void responsiveLayoutHelper(@NotNull IComponent<ComponentValue> iComponent) {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter;
        a layoutHelper;
        k21.i(iComponent, "component");
        Activity activity = iComponent.getPageContext().getActivity();
        if (activity != null && (adapter = iComponent.getAdapter()) != null && (layoutHelper = adapter.getLayoutHelper()) != null) {
            if (layoutHelper instanceof GridFixAutoStatLayoutHelper) {
                GridFixAutoStatLayoutHelper gridFixAutoStatLayoutHelper = (GridFixAutoStatLayoutHelper) layoutHelper;
                gridFixAutoStatLayoutHelper.setSpanCount(bd2.INSTANCE.d(activity, gridFixAutoStatLayoutHelper.getRawSpanCount()));
            } else if (layoutHelper instanceof StaggeredGridLayoutHelper) {
                StaggeredGridLayoutHelper staggeredGridLayoutHelper = (StaggeredGridLayoutHelper) layoutHelper;
                staggeredGridLayoutHelper.setLane(bd2.INSTANCE.d(activity, staggeredGridLayoutHelper.getRawLane()));
            } else if (layoutHelper instanceof FeedStaggeredGridLayoutHelper) {
                FeedStaggeredGridLayoutHelper feedStaggeredGridLayoutHelper = (FeedStaggeredGridLayoutHelper) layoutHelper;
                feedStaggeredGridLayoutHelper.setLane(bd2.INSTANCE.d(activity, feedStaggeredGridLayoutHelper.getRawLane()));
            }
        }
    }
}
