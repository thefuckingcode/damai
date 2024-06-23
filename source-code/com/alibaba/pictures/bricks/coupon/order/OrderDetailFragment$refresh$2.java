package com.alibaba.pictures.bricks.coupon.order;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo;
import com.alibaba.pictures.bricks.view.LinearPullToRefreshView;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur0;
import tb.ur2;

/* compiled from: Taobao */
public final class OrderDetailFragment$refresh$2 extends Lambda implements Function1<OrderDetail, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OrderDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderDetailFragment$refresh$2(OrderDetailFragment orderDetailFragment) {
        super(1);
        this.this$0 = orderDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(OrderDetail orderDetail) {
        invoke(orderDetail);
        return ur2.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b9, code lost:
        if (tb.k21.d(r1, "1") != false) goto L_0x00bd;
     */
    public final void invoke(@NotNull OrderDetail orderDetail) {
        StatusInfo statusInfo;
        Long currentTime;
        StatusInfo statusInfo2;
        Long closeTime;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1775806832")) {
            ipChange.ipc$dispatch("1775806832", new Object[]{this, orderDetail});
            return;
        }
        k21.i(orderDetail, AdvanceSetting.NETWORK_TYPE);
        View rootView = this.this$0.getRootView();
        String str = null;
        ViewGroup viewGroup = rootView != null ? (ViewGroup) rootView.findViewById(R$id.ll_page) : null;
        if (viewGroup != null) {
            this.this$0.removeErrorView(viewGroup);
        }
        this.this$0.setMData(orderDetail);
        OrderDetail mData = this.this$0.getMData();
        if (!(mData == null || (statusInfo = mData.getStatusInfo()) == null || (currentTime = statusInfo.getCurrentTime()) == null)) {
            OrderDetailFragment orderDetailFragment = this.this$0;
            long longValue = currentTime.longValue();
            OrderDetail mData2 = orderDetailFragment.getMData();
            if (!(mData2 == null || (statusInfo2 = mData2.getStatusInfo()) == null || (closeTime = statusInfo2.getCloseTime()) == null)) {
                long longValue2 = closeTime.longValue();
                OrderDetail mData3 = orderDetailFragment.getMData();
                StatusInfo statusInfo3 = mData3 != null ? mData3.getStatusInfo() : null;
                if (statusInfo3 != null) {
                    statusInfo3.setOverdueTime((longValue2 - longValue) / ((long) 1000));
                }
            }
        }
        LinearPullToRefreshView refreshView = this.this$0.getRefreshView();
        if (refreshView != null) {
            refreshView.setVisibility(0);
        }
        this.this$0.setItemId(orderDetail.getItemId());
        if (OrderDetailFragment.mPayResultState && k21.d(OrderDetailFragment.mPayResultOrderId, this.this$0.getOrderId())) {
            StatusInfo statusInfo4 = orderDetail.getStatusInfo();
            if (statusInfo4 != null) {
                str = statusInfo4.getShowStatus();
            }
        }
        z = false;
        this.this$0.headerViewRender(orderDetail, z);
        this.this$0.bottomViewRender(orderDetail, z);
        TrackInfo trackInfo = new TrackInfo();
        OrderDetailAdapter adapter = this.this$0.getAdapter();
        if (adapter != null) {
            adapter.c(new ur0(orderDetail));
        }
        OrderDetailAdapter adapter2 = this.this$0.getAdapter();
        if (adapter2 != null) {
            adapter2.a(orderDetail, this.this$0.getCreate(trackInfo));
        }
    }
}
