package com.alient.onearch.adapter.loader.v2;

import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.PageStateManager;
import com.youku.arch.v3.page.state.StateView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "invoke", "()Ltb/ur2;", "com/alient/onearch/adapter/loader/v2/GenericPagerLoader$setLoadingViewState$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class GenericPagerLoader$setLoadingViewState$$inlined$apply$lambda$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ IResponse $response$inlined;
    final /* synthetic */ PageStateManager $this_apply;
    final /* synthetic */ GenericPagerLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericPagerLoader$setLoadingViewState$$inlined$apply$lambda$1(PageStateManager pageStateManager, GenericPagerLoader genericPagerLoader, IResponse iResponse) {
        super(0);
        this.$this_apply = pageStateManager;
        this.this$0 = genericPagerLoader;
        this.$response$inlined = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IStateView stateView;
        StateView stateView2 = this.$this_apply.stateView;
        if (stateView2 == null || (stateView = stateView2.getStateView(stateView2.getCurrentState())) == null) {
            return null;
        }
        stateView.update(this.$response$inlined.getRetCode(), this.$response$inlined.getRetMessage());
        return ur2.INSTANCE;
    }
}
