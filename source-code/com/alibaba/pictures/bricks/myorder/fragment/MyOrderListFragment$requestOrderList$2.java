package com.alibaba.pictures.bricks.myorder.fragment;

import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class MyOrderListFragment$requestOrderList$2 extends Lambda implements Function1<DoloresRequest<MyOrderListResp>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final MyOrderListFragment$requestOrderList$2 INSTANCE = new MyOrderListFragment$requestOrderList$2();

    MyOrderListFragment$requestOrderList$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(DoloresRequest<MyOrderListResp> doloresRequest) {
        invoke(doloresRequest);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable DoloresRequest<MyOrderListResp> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741692420")) {
            ipChange.ipc$dispatch("-1741692420", new Object[]{this, doloresRequest});
        }
    }
}
