package com.alibaba.pictures.bricks.myorder.fragment;

import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class MyOrderListFragment$requestOrderList$3 extends Lambda implements Function1<MyOrderListResp, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ MyOrderListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyOrderListFragment$requestOrderList$3(boolean z, MyOrderListFragment myOrderListFragment) {
        super(1);
        this.$isRefresh = z;
        this.this$0 = myOrderListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(MyOrderListResp myOrderListResp) {
        invoke(myOrderListResp);
        return ur2.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00be, code lost:
        if (r0 < r8.intValue()) goto L_0x00c2;
     */
    public final void invoke(@NotNull MyOrderListResp myOrderListResp) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1955345280")) {
            ipChange.ipc$dispatch("-1955345280", new Object[]{this, myOrderListResp});
            return;
        }
        k21.i(myOrderListResp, AdvanceSetting.NETWORK_TYPE);
        SmartRefreshLayout smartRefreshLayout = null;
        if (this.$isRefresh) {
            ViewGroup viewGroup = this.this$0.errorContainer;
            if (viewGroup == null) {
                k21.A("errorContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
            MyOrderListFragment myOrderListFragment = this.this$0;
            ViewGroup viewGroup2 = myOrderListFragment.errorContainer;
            if (viewGroup2 == null) {
                k21.A("errorContainer");
                viewGroup2 = null;
            }
            myOrderListFragment.removeErrorView(viewGroup2);
            this.this$0.hideLoading();
            this.this$0.getAdapter().setData(myOrderListResp.getOrderList());
            SmartRefreshLayout smartRefreshLayout2 = this.this$0.refreshLayout;
            if (smartRefreshLayout2 == null) {
                k21.A("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.finishRefresh();
            ArrayList<JSONObject> orderList = myOrderListResp.getOrderList();
            if (orderList == null || orderList.isEmpty()) {
                this.this$0.showEmpty();
            }
        } else {
            this.this$0.getAdapter().a(myOrderListResp.getOrderList());
            SmartRefreshLayout smartRefreshLayout3 = this.this$0.refreshLayout;
            if (smartRefreshLayout3 == null) {
                k21.A("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.finishLoadMore();
        }
        SmartRefreshLayout smartRefreshLayout4 = this.this$0.refreshLayout;
        if (smartRefreshLayout4 == null) {
            k21.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        if (myOrderListResp.getTotalPageNum() != null) {
            int i = this.this$0.pageNumber;
            Integer totalPageNum = myOrderListResp.getTotalPageNum();
            k21.f(totalPageNum);
        }
        z = false;
        smartRefreshLayout.setEnableLoadMore(z);
    }
}
