package cn.damai.trade.coupon.ui.orderdeatile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCancelRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailListener;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.an1;
import tb.bk2;
import tb.gr;
import tb.k21;
import tb.ln2;
import tb.m40;
import tb.ne2;
import tb.wl1;
import tb.xl1;
import tb.yl1;

public final class OrderDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    private static final String ERROR_CODE_ORDER_HAS_PAY;
    private static final String ERROR_CODE_ORDER_NO_CANCEL;
    private final int BACK_FROM_PAGE = 3;
    private final int FROM_COUPON_CREATE_ORDER = 1;
    private final int FROM_ORDER_LIST;
    private final int FROM_PUSH = 2;
    private OrderDetailPayFragment dialogFragment;
    private OrderDetailFragment fragment;
    private int mFromPage = this.FROM_ORDER_LIST;
    private String mOrderId;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public static final class b implements OrderDetailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailActivity a;

        b(OrderDetailActivity orderDetailActivity) {
            this.a = orderDetailActivity;
        }

        public static final void c(OrderDetailActivity orderDetailActivity, DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "958299782")) {
                ipChange.ipc$dispatch("958299782", new Object[]{orderDetailActivity, dialogInterface, Integer.valueOf(i)});
                return;
            }
            k21.i(orderDetailActivity, "this$0");
            dialogInterface.dismiss();
            orderDetailActivity.requestCancelOrder();
        }

        public static final void d(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-256903890")) {
                ipChange.ipc$dispatch("-256903890", new Object[]{dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }

        @Override // com.alibaba.pictures.bricks.coupon.order.OrderDetailListener
        public void cancelOrder(OrderDetail orderDetail) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1452481632")) {
                ipChange.ipc$dispatch("-1452481632", new Object[]{this, orderDetail});
                return;
            }
            k21.i(orderDetail, "detail");
            DMDialog dMDialog = new DMDialog(this.a);
            dMDialog.v("取消订单");
            dMDialog.q("订单取消后将自动关闭，确定取消?");
            dMDialog.i("取消", null);
            dMDialog.n("确定", new xl1(this.a));
            dMDialog.show();
        }

        @Override // com.alibaba.pictures.bricks.coupon.order.OrderDetailListener
        public void gotoPay(OrderDetail orderDetail) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1694097969")) {
                ipChange.ipc$dispatch("1694097969", new Object[]{this, orderDetail});
                return;
            }
            k21.i(orderDetail, "detail");
            ArrayList<OrderDetailPayInfo> paymentInfoList = orderDetail.getPaymentInfoList();
            String str = null;
            Boolean bool = null;
            if (!(paymentInfoList == null || paymentInfoList.isEmpty())) {
                Intent intent = new Intent();
                k21.g(paymentInfoList, "null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable?>{ kotlin.collections.TypeAliasesKt.ArrayList<out android.os.Parcelable?> }");
                intent.putExtra("payList", paymentInfoList);
                intent.putExtra("isHouNiaoOrder", false);
                StatusInfo statusInfo = orderDetail.getStatusInfo();
                intent.putExtra("amount", statusInfo != null ? statusInfo.getTotalAmount() : null);
                intent.putExtra("orderId", this.a.mOrderId);
                intent.putExtra("projectId", orderDetail.getItemId());
                intent.putExtra("isSeat", false);
                intent.putExtra("isCoupon", true);
                if (this.a.dialogFragment == null) {
                    this.a.dialogFragment = new OrderDetailPayFragment();
                    OrderDetailPayFragment orderDetailPayFragment = this.a.dialogFragment;
                    if (orderDetailPayFragment != null) {
                        orderDetailPayFragment.l(this.a, intent);
                    }
                }
                try {
                    OrderDetailPayFragment orderDetailPayFragment2 = this.a.dialogFragment;
                    if (orderDetailPayFragment2 != null) {
                        bool = Boolean.valueOf(orderDetailPayFragment2.isAdded());
                    }
                    k21.f(bool);
                    if (!bool.booleanValue()) {
                        OrderDetailPayFragment orderDetailPayFragment3 = this.a.dialogFragment;
                        if (orderDetailPayFragment3 != null) {
                            orderDetailPayFragment3.q(System.currentTimeMillis());
                        }
                        OrderDetailPayFragment orderDetailPayFragment4 = this.a.dialogFragment;
                        if (orderDetailPayFragment4 != null) {
                            orderDetailPayFragment4.a(this.a.getFragmentManager());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                StatusInfo statusInfo2 = orderDetail.getStatusInfo();
                if (!TextUtils.isEmpty(statusInfo2 != null ? statusInfo2.getDialogTips() : null)) {
                    StatusInfo statusInfo3 = orderDetail.getStatusInfo();
                    if (statusInfo3 != null) {
                        str = statusInfo3.getDialogTips();
                    }
                } else {
                    str = "当前订单不支持此渠道支付，请前往下单渠道完成支付";
                }
                DMDialog dMDialog = new DMDialog(this.a);
                dMDialog.q(str);
                dMDialog.n("我知道了", yl1.a);
                dMDialog.show();
            }
        }
    }

    private final void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460027931")) {
            ipChange.ipc$dispatch("-460027931", new Object[]{this});
            return;
        }
        OrderDetailFragment orderDetailFragment = new OrderDetailFragment();
        orderDetailFragment.setListener(new b(this));
        Bundle bundle = new Bundle();
        String str = this.mOrderId;
        if (str != null) {
            bundle.putString("orderId", str);
        }
        orderDetailFragment.setArguments(bundle);
        this.fragment = orderDetailFragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R$id.coupon_confirm_container, orderDetailFragment);
        beginTransaction.commit();
    }

    private final void addUtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429096025")) {
            ipChange.ipc$dispatch("-429096025", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(new a.b().i(ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE));
        c.e().K(this);
    }

    private final void backOrderListPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244629438")) {
            ipChange.ipc$dispatch("-1244629438", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("refresh", true);
        setResult(-1, intent);
        finish();
    }

    private final void handleParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906937574")) {
            ipChange.ipc$dispatch("1906937574", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
            this.mOrderId = extras.getString(DamaiConstants.PUSH_MSG_SUMMARY);
            this.mFromPage = this.FROM_PUSH;
        } else if (extras.containsKey("backPage")) {
            this.mOrderId = extras.getString("orderId", "");
            this.mFromPage = this.BACK_FROM_PAGE;
        } else {
            this.mOrderId = extras.getString("orderId", "");
            this.mFromPage = this.FROM_ORDER_LIST;
            if (extras.containsKey("CouponCreateOrderPage")) {
                if (k21.d(extras.getString("CouponCreateOrderPage", "false"), "true")) {
                    this.mFromPage = this.FROM_COUPON_CREATE_ORDER;
                } else if (extras.getBoolean("CouponCreateOrderPage", false)) {
                    this.mFromPage = this.FROM_COUPON_CREATE_ORDER;
                }
            }
            if (extras.containsKey("payResult")) {
                OrderDetailFragment.mPayResultState = extras.getBoolean("payResult", false);
                OrderDetailFragment.mPayResultOrderId = this.mOrderId;
            }
        }
    }

    /* renamed from: initView$lambda-0 */
    public static final void m76initView$lambda0(OrderDetailActivity orderDetailActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659140485")) {
            ipChange.ipc$dispatch("659140485", new Object[]{orderDetailActivity, view});
            return;
        }
        k21.i(orderDetailActivity, "this$0");
        orderDetailActivity.onBackPressed();
    }

    private final void orderDetailCancelXflush(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-255675131")) {
            ipChange.ipc$dispatch("-255675131", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str) || !k21.d("FCADE0002", str)) {
            z = true;
        }
        if (z) {
            an1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_CANCEL_ORDER, str, str2, this.mOrderId, "订单取消按钮接口失败");
        }
    }

    private final void requestCancelOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852669137")) {
            ipChange.ipc$dispatch("-1852669137", new Object[]{this});
            return;
        }
        OrderDetailCancelRequest orderDetailCancelRequest = new OrderDetailCancelRequest();
        orderDetailCancelRequest.orderId = this.mOrderId;
        orderDetailCancelRequest.request(new OrderDetailActivity$requestCancelOrder$listener$1(this, String.class));
    }

    private final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094614606")) {
            ipChange.ipc$dispatch("1094614606", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.coupon_title_bar_space_view);
        if (findViewById != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
                ne2.f(this, true, R$color.black);
                ne2.d(true, this);
                return;
            }
            ne2.f(this, false, R$color.black);
            findViewById.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1039271346")) {
            return R$layout.coupon_order_detail_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-1039271346", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456597761")) {
            ipChange.ipc$dispatch("-456597761", new Object[]{this});
            return;
        }
        super.initView();
        setImmersionStyle();
        View findViewById = findViewById(R$id.coupon_iv_left_icon);
        if (findViewById != null) {
            findViewById.setOnClickListener(new wl1(this));
        }
        handleParams();
        addFragment();
        addUtPage();
    }

    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean booleanExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319359194")) {
            ipChange.ipc$dispatch("-319359194", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 2000 && intent != null && (booleanExtra = intent.getBooleanExtra("payResult", false))) {
            OrderDetailFragment.mPayResultState = booleanExtra;
            OrderDetailFragment.mPayResultOrderId = this.mOrderId;
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828631546")) {
            ipChange.ipc$dispatch("1828631546", new Object[]{this});
            return;
        }
        int i = this.mFromPage;
        if (i == this.FROM_PUSH) {
            DMNav.from(this).toUri(NavUri.b(gr.n));
            finish();
        } else if (i == this.FROM_COUPON_CREATE_ORDER) {
            Bundle bundle = new Bundle();
            bundle.putString("pageType", "jubensha");
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(gr.f));
            finish();
        } else if (i == this.BACK_FROM_PAGE) {
            finish();
        } else if (i == this.FROM_ORDER_LIST) {
            backOrderListPage();
        } else {
            backOrderListPage();
        }
    }

    public final void returnOrderDetailCancelFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631592899")) {
            ipChange.ipc$dispatch("1631592899", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "errorCode");
        k21.i(str2, "errorMsg");
        orderDetailCancelXflush(str, str2);
        if (k21.d(ERROR_CODE_ORDER_NO_CANCEL, str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "该订单状态已经生效，无法操作取消~";
            }
            ToastUtil.i(str2);
            OrderDetailFragment orderDetailFragment = this.fragment;
            if (orderDetailFragment != null) {
                orderDetailFragment.refresh();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = bk2.b(this, R$string.damai_base_net_toast);
            k21.h(str2, "getTextFormat(this@Order…ing.damai_base_net_toast)");
        }
        ToastUtil.i(str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124202050")) {
            return (String) ipChange.ipc$dispatch("2124202050", new Object[]{this});
        }
        this.bese_head_view.setVisibility(8);
        return "";
    }
}
