package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/page/GenericActivity;", "HOST", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ActivityLoader$load$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IRequest $this_apply;
    final /* synthetic */ ActivityLoader<HOST> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityLoader$load$1$1(IRequest iRequest, ActivityLoader<HOST> activityLoader) {
        super(0);
        this.$this_apply = iRequest;
        this.this$0 = activityLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116335280")) {
            ipChange.ipc$dispatch("-1116335280", new Object[]{this});
            return;
        }
        Repository instance = Repository.Companion.getInstance();
        IRequest iRequest = this.$this_apply;
        final ActivityLoader<HOST> activityLoader = this.this$0;
        instance.request(iRequest, new Callback() {
            /* class com.youku.arch.v3.loader.ActivityLoader$load$1$1.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1030834774")) {
                    ipChange.ipc$dispatch("1030834774", new Object[]{this, iResponse});
                    return;
                }
                k21.i(iResponse, "response");
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.d("OneArch.ActivityLoader", k21.r("onResponse ", Boolean.valueOf(iResponse.isSuccess())));
                }
                if (iResponse.isSuccess()) {
                    activityLoader.handleLoadSuccess(iResponse, 0);
                } else {
                    activityLoader.handleLoadFailure(iResponse);
                }
            }
        });
    }
}
