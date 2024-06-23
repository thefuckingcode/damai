package com.alient.onearch.adapter;

import com.alient.onearch.adapter.responsive.util.ResponsiveLayoutDataUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class BaseFragment$onResponsiveLayout$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ BaseFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFragment$onResponsiveLayout$1(BaseFragment baseFragment, CountDownLatch countDownLatch) {
        super(0);
        this.this$0 = baseFragment;
        this.$countDownLatch = countDownLatch;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<T> it = this.this$0.getPageContainer().getModules().iterator();
            while (it.hasNext()) {
                this.this$0.traverseModule(it.next(), arrayList);
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
        ResponsiveLayoutDataUtil.INSTANCE.notifyResponsiveLayoutAdapterChanged(this.this$0.getPageContext(), arrayList);
        this.$countDownLatch.countDown();
    }
}
