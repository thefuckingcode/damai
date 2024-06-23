package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageLoader$handleLoadFinish$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ PageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageLoader$handleLoadFinish$1(IResponse iResponse, PageLoader pageLoader, int i) {
        super(0);
        this.$response = iResponse;
        this.this$0 = pageLoader;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "548100222")) {
            ipChange.ipc$dispatch("548100222", new Object[]{this});
            return;
        }
        if (this.$response.isSuccess()) {
            this.this$0.setLoadingPage(this.$index);
        }
        PageLoader pageLoader = this.this$0;
        IResponse iResponse = this.$response;
        if (pageLoader.getRealItemCount() > 0) {
            z = true;
        }
        pageLoader.setLoadingViewState(iResponse, z);
    }
}
