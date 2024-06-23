package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/page/GenericActivity;", "HOST", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ActivityLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ ActivityLoader<HOST> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityLoader$handleLoadSuccess$1(ActivityLoader<HOST> activityLoader, IResponse iResponse) {
        super(0);
        this.this$0 = activityLoader;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448527604")) {
            ipChange.ipc$dispatch("448527604", new Object[]{this});
            return;
        }
        Callback callBack = this.this$0.getCallBack();
        if (callBack != null) {
            callBack.onResponse(this.$response);
        }
        this.this$0.getHost().onTabDataLoaded(this.$response.getJsonObject());
        this.this$0.setLoadingState(0);
    }
}
