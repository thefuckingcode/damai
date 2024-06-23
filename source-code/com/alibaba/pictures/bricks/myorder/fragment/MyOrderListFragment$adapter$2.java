package com.alibaba.pictures.bricks.myorder.fragment;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class MyOrderListFragment$adapter$2 extends Lambda implements Function0<MyOrderListAdapter> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MyOrderListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyOrderListFragment$adapter$2(MyOrderListFragment myOrderListFragment) {
        super(0);
        this.this$0 = myOrderListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MyOrderListAdapter invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479425140")) {
            return (MyOrderListAdapter) ipChange.ipc$dispatch("-479425140", new Object[]{this});
        }
        Context context = this.this$0.getContext();
        k21.f(context);
        return new MyOrderListAdapter(context);
    }
}
