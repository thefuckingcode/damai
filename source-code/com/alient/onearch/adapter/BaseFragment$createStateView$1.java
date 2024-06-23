package com.alient.onearch.adapter;

import com.alient.onearch.adapter.state.StateViewManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/alient/onearch/adapter/BaseFragment$createStateView$1", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "Ltb/ur2;", "onRefreshClick", "onReportClick", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BaseFragment$createStateView$1 implements StateViewManager.IStateViewListener {
    final /* synthetic */ BaseFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFragment$createStateView$1(BaseFragment baseFragment) {
        this.this$0 = baseFragment;
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewListener
    public void onRefreshClick() {
        this.this$0.getPageContainer().reload();
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewListener
    public void onReportClick() {
    }
}
