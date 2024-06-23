package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/adapter/ContentAdapter;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$addChildAdapters$1 extends Lambda implements Function0<ContentAdapter> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> $adapters;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$addChildAdapters$1(PageContainer<VALUE> pageContainer, List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        super(0);
        this.this$0 = pageContainer;
        this.$adapters = list;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ContentAdapter invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243747228")) {
            return (ContentAdapter) ipChange.ipc$dispatch("243747228", new Object[]{this});
        }
        this.this$0.getPageLoader().getLoadingViewManager().onLoadNextSuccess();
        ContentAdapter contentAdapter = this.this$0.getContentAdapter();
        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list = this.$adapters;
        int adaptersCount = contentAdapter.getAdaptersCount();
        if (!(list instanceof List)) {
            list = null;
        }
        contentAdapter.addAdapters(adaptersCount, list);
        return contentAdapter;
    }
}
