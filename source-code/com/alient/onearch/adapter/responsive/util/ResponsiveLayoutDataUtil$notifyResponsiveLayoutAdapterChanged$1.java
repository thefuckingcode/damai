package com.alient.onearch.adapter.responsive.util;

import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ResponsiveLayoutDataUtil$notifyResponsiveLayoutAdapterChanged$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ IContext $pageContext;
    final /* synthetic */ List $updatedComponents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResponsiveLayoutDataUtil$notifyResponsiveLayoutAdapterChanged$1(IContext iContext, List list) {
        super(0);
        this.$pageContext = iContext;
        this.$updatedComponents = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        try {
            IContainer<ModelValue> pageContainer = this.$pageContext.getPageContainer();
            if (pageContainer != null) {
                pageContainer.updateContentAdapter();
            }
            for (IComponent<ComponentValue> iComponent : this.$updatedComponents) {
                ResponsiveLayoutDataUtil.INSTANCE.responsiveLayoutAdapter(iComponent);
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemRangeChanged(0, iComponent.getChildCount());
                }
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }
}
