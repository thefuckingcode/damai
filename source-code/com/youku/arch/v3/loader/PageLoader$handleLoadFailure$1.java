package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageLoader$handleLoadFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ PageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageLoader$handleLoadFailure$1(PageLoader pageLoader, IResponse iResponse) {
        super(0);
        this.this$0 = pageLoader;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322155835")) {
            ipChange.ipc$dispatch("1322155835", new Object[]{this});
            return;
        }
        try {
            if (this.this$0.getLoadingPage() <= 1 && k21.d("local_cache_missing", this.$response.getRetCode())) {
                this.this$0.reload();
            }
            PageLoader pageLoader = this.this$0;
            pageLoader.handleLoadFinish(this.$response, true, pageLoader.getLoadingPage());
        } catch (Exception unused) {
            PageLoader pageLoader2 = this.this$0;
            pageLoader2.handleLoadFinish(this.$response, false, pageLoader2.getLoadingPage());
        }
    }
}
