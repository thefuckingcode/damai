package com.alient.onearch.adapter;

import android.view.ViewGroup;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.OnCreateStateViewListener;
import com.youku.arch.v3.page.state.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b¸\u0006\u0000"}, d2 = {"com/alient/onearch/adapter/BaseFragment$initPageStateManager$1$2", "Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "Landroid/view/ViewGroup;", "parent", "Lcom/youku/arch/v3/page/state/State;", "state", "Lcom/youku/arch/v3/page/state/IStateView;", "onCreateStateView", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BaseFragment$initPageStateManager$$inlined$let$lambda$2 implements OnCreateStateViewListener {
    final /* synthetic */ String $it;
    final /* synthetic */ BaseFragment this$0;

    BaseFragment$initPageStateManager$$inlined$let$lambda$2(String str, BaseFragment baseFragment) {
        this.$it = str;
        this.this$0 = baseFragment;
    }

    @Override // com.youku.arch.v3.page.state.OnCreateStateViewListener
    @Nullable
    public IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state) {
        k21.i(viewGroup, "parent");
        k21.i(state, "state");
        return this.this$0.createStateView(this.$it, viewGroup, state);
    }
}
