package com.alibaba.pictures.bricks.myorder.fragment;

import android.view.ViewGroup;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class MyOrderListFragment$requestOrderList$4 extends Lambda implements Function1<fb0<MyOrderListResp>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ MyOrderListFragment this$0;

    /* compiled from: Taobao */
    public static final class a implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MyOrderListFragment a;

        a(MyOrderListFragment myOrderListFragment) {
            this.a = myOrderListFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1444710706")) {
                ipChange.ipc$dispatch("1444710706", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.requestOrderList(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyOrderListFragment$requestOrderList$4(boolean z, MyOrderListFragment myOrderListFragment) {
        super(1);
        this.$isRefresh = z;
        this.this$0 = myOrderListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<MyOrderListResp> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<MyOrderListResp> fb0) {
        String str;
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881092530")) {
            ipChange.ipc$dispatch("1881092530", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        SmartRefreshLayout smartRefreshLayout = null;
        if (this.$isRefresh) {
            SmartRefreshLayout smartRefreshLayout2 = this.this$0.refreshLayout;
            if (smartRefreshLayout2 == null) {
                k21.A("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.finishRefresh();
            ViewGroup viewGroup2 = this.this$0.errorContainer;
            if (viewGroup2 == null) {
                k21.A("errorContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            MyOrderListFragment myOrderListFragment = this.this$0;
            String f = fb0.f();
            if (f == null) {
                str = "加载异常，请稍候重试";
            } else {
                str = f;
            }
            String e = fb0.e();
            if (e == null) {
                e = "";
            }
            ViewGroup viewGroup3 = this.this$0.errorContainer;
            if (viewGroup3 == null) {
                k21.A("errorContainer");
                viewGroup = null;
            } else {
                viewGroup = viewGroup3;
            }
            myOrderListFragment.showErrorView(1, str, e, viewGroup, true, false, true, new a(this.this$0));
            return;
        }
        SmartRefreshLayout smartRefreshLayout3 = this.this$0.refreshLayout;
        if (smartRefreshLayout3 == null) {
            k21.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout3;
        }
        smartRefreshLayout.finishLoadMore();
        BricksToastUtil.INSTANCE.b("加载异常，请稍候重试");
    }
}
