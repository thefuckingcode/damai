package com.alibaba.pictures.dolores.business;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.fb0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"BizResponse", "Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AsyncResult$onFail$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ fb0 $response;
    final /* synthetic */ AsyncResult this$0;

    AsyncResult$onFail$1(AsyncResult asyncResult, fb0 fb0) {
        this.this$0 = asyncResult;
        this.$response = fb0;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789693604")) {
            ipChange.ipc$dispatch("-1789693604", new Object[]{this});
            return;
        }
        this.this$0.onInnerFail(this.$response);
    }
}
