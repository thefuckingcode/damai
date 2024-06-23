package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericComponent$request$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Callback $callback;
    final /* synthetic */ IRequest $request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericComponent$request$1(IRequest iRequest, Callback callback) {
        super(0);
        this.$request = iRequest;
        this.$callback = callback;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774712504")) {
            ipChange.ipc$dispatch("774712504", new Object[]{this});
            return;
        }
        Repository.Companion.getInstance().request(this.$request, this.$callback);
    }
}
