package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"BizResponse", "Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AsyncResult$onStart$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DoloresRequest $request;
    final /* synthetic */ AsyncResult this$0;

    AsyncResult$onStart$1(AsyncResult asyncResult, DoloresRequest doloresRequest) {
        this.this$0 = asyncResult;
        this.$request = doloresRequest;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2086788054")) {
            ipChange.ipc$dispatch("2086788054", new Object[]{this});
            return;
        }
        this.this$0.onInnerStart(this.$request);
    }
}
