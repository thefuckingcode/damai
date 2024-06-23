package cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayList;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.helper.OrderPayListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailPayViewModel;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.OrderDetailPayAdapter;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.bk2;
import tb.ln2;
import tb.n42;
import tb.nm1;
import tb.rm1;

/* compiled from: Taobao */
public class OrderDetailPayFragment extends rm1 implements View.OnClickListener, ResponseErrorPage.ErrorRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private DMIconFontTextView d;
    private RelativeLayout e;
    private RecyclerView f;
    private OrderDetailPayAdapter g;
    private LinearLayout h;
    private RelativeLayout i;
    private OrderDetailPayViewModel j;
    private Observer<OrderDetailPayInfo> k = new Observer<OrderDetailPayInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable OrderDetailPayInfo orderDetailPayInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1462230091")) {
                ipChange.ipc$dispatch("-1462230091", new Object[]{this, orderDetailPayInfo});
            } else if (OrderDetailPayFragment.this.j != null) {
                if (OrderDetailPayFragment.this.j.isHouNiaoOrder()) {
                    OrderDetailPayFragment.this.p(orderDetailPayInfo);
                } else {
                    OrderDetailPayFragment.this.j.setZLSelectPayInfo(orderDetailPayInfo);
                }
            }
        }
    };
    DMMtopRequestListener<OrderPayDTO> l = new DMMtopRequestListener<OrderPayDTO>(OrderPayDTO.class) {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-706404104")) {
                ipChange.ipc$dispatch("-706404104", new Object[]{this, str, str2});
                return;
            }
            OrderDetailPayFragment.this.s();
            OrderDetailPayFragment orderDetailPayFragment = OrderDetailPayFragment.this;
            orderDetailPayFragment.n = false;
            if (orderDetailPayFragment.j != null) {
                c.e().A(ln2.r().K(OrderDetailPayFragment.this.j.getProjectId(), OrderDetailPayFragment.this.j.getOrderId(), str2, OrderDetailPayFragment.this.j.isSeatProject()), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
            }
            OrderDetailPayFragment.this.o(str, str2);
        }

        public void onSuccess(OrderPayDTO orderPayDTO) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-135273362")) {
                ipChange.ipc$dispatch("-135273362", new Object[]{this, orderPayDTO});
                return;
            }
            OrderDetailPayFragment.this.s();
            OrderDetailPayFragment orderDetailPayFragment = OrderDetailPayFragment.this;
            orderDetailPayFragment.n = false;
            if (orderPayDTO != null) {
                if (orderDetailPayFragment.j != null) {
                    c.e().A(ln2.r().M(OrderDetailPayFragment.this.j.getProjectId(), OrderDetailPayFragment.this.j.getOrderId(), OrderDetailPayFragment.this.j.isSeatProject()), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
                    orderPayDTO.payTypeId = OrderDetailPayFragment.this.j.getSelectPayInfo().payTypeId;
                }
                nm1.b(OrderDetailPayFragment.this.getActivity(), orderPayDTO);
                if (OrderDetailPayFragment.this.j.isCoupon()) {
                    OrderDetailPayFragment.this.dismiss();
                }
            }
        }
    };
    OrderPayListener<OrderParmasResult> m = new OrderPayListener<OrderParmasResult>(OrderParmasResult.class) {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment.AnonymousClass4 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-714163463")) {
                ipChange.ipc$dispatch("-714163463", new Object[]{this, str, str2});
                return;
            }
            OrderDetailPayFragment.this.s();
            OrderDetailPayFragment orderDetailPayFragment = OrderDetailPayFragment.this;
            orderDetailPayFragment.n = false;
            if (orderDetailPayFragment.j != null) {
                c.e().A(ln2.r().K(OrderDetailPayFragment.this.j.getProjectId(), OrderDetailPayFragment.this.j.getOrderId(), str2, OrderDetailPayFragment.this.j.isSeatProject()), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
            }
            OrderDetailPayFragment.this.o(str, str2);
        }

        public void onSuccess(OrderParmasResult orderParmasResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-526942585")) {
                ipChange.ipc$dispatch("-526942585", new Object[]{this, orderParmasResult});
                return;
            }
            OrderDetailPayFragment.this.s();
            OrderDetailPayFragment orderDetailPayFragment = OrderDetailPayFragment.this;
            orderDetailPayFragment.n = false;
            if (orderDetailPayFragment.j != null) {
                c.e().A(ln2.r().M(OrderDetailPayFragment.this.j.getProjectId(), OrderDetailPayFragment.this.j.getOrderId(), OrderDetailPayFragment.this.j.isSeatProject()), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
            }
            nm1.c(OrderDetailPayFragment.this.getActivity(), orderParmasResult, OrderDetailPayFragment.this.j.getOrderId());
        }
    };
    boolean n = false;
    private OrderDetailPayInfo o;
    protected ResponseErrorPage p;
    private long q = 0;

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465473363")) {
            ipChange.ipc$dispatch("465473363", new Object[]{this});
            return;
        }
        OrderDetailPayViewModel orderDetailPayViewModel = this.j;
        if (orderDetailPayViewModel != null) {
            OrderDetailPayInfo selectPayInfo = orderDetailPayViewModel.getSelectPayInfo();
            if (selectPayInfo == null || TextUtils.isEmpty(selectPayInfo.payCode)) {
                ToastUtil.i("你当前没有选择支付方式");
            } else if (!this.n) {
                c.e().x(ln2.r().Q(this.j.getProjectId(), this.j.getOrderId(), selectPayInfo.payName, this.j.isCoupon()));
                r();
                this.n = true;
                if (this.j.isHouNiaoOrder() || this.j.isCoupon()) {
                    this.j.requestHNOrderPay(this.l);
                } else {
                    this.j.requestSelfOrderPay(this.m);
                }
            }
        }
    }

    private void i(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108489908")) {
            ipChange.ipc$dispatch("108489908", new Object[]{this, view});
            return;
        }
        this.h = (LinearLayout) view.findViewById(R$id.ll_error_page);
        this.i = (RelativeLayout) view.findViewById(R$id.ll_progress);
        this.f = (RecyclerView) view.findViewById(R$id.rc);
        this.f.setLayoutManager(new LinearLayoutManager(getActivity()));
        k(false);
        this.f.setAdapter(this.g);
    }

    private void j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1402565653")) {
            ipChange.ipc$dispatch("1402565653", new Object[]{this, view});
            return;
        }
        this.a = view.findViewById(R$id.v_outside);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_bottom);
        this.e = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((double) DisplayMetrics.getheightPixels(n42.b(getActivity()))) * 0.75d);
        this.e.setLayoutParams(layoutParams);
        this.d = (DMIconFontTextView) view.findViewById(R$id.text_ok);
        this.c = (TextView) view.findViewById(R$id.tv_amount);
        this.b = (TextView) view.findViewById(R$id.tv_pay);
        i(view);
        this.e.setOnClickListener(null);
        this.a.setOnClickListener(this);
        this.d.setOnClickListener(this);
        view.findViewById(R$id.rl_title).setOnClickListener(null);
        this.b.setOnClickListener(this);
        if (this.j != null) {
            TextView textView = this.c;
            textView.setText("需支付 ¥" + this.j.getAmount());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027446531")) {
            ipChange.ipc$dispatch("2027446531", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.h.setVisibility(8);
            this.f.setVisibility(0);
            this.b.setVisibility(0);
        } else {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            this.b.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871728494")) {
            ipChange.ipc$dispatch("1871728494", new Object[]{this, str, str2});
        } else if (str == null || !"MAPIE98087".equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = bk2.b(getActivity(), R$string.damai_base_net_toast);
            }
            ToastUtil.i(str2);
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = "该订单已经付款，请勿重复支付~";
            }
            ToastUtil.i(str2);
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(final OrderDetailPayInfo orderDetailPayInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568793462")) {
            ipChange.ipc$dispatch("-568793462", new Object[]{this, orderDetailPayInfo});
        } else if (this.j != null && orderDetailPayInfo != null) {
            r();
            this.j.requestHNOrderPayList(orderDetailPayInfo, new DMMtopRequestListener<OrderDetailPayList>(OrderDetailPayList.class) {
                /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-698644745")) {
                        ipChange.ipc$dispatch("-698644745", new Object[]{this, str, str2});
                        return;
                    }
                    OrderDetailPayFragment.this.s();
                    OrderDetailPayFragment.this.k(true);
                    OrderDetailPayFragment.this.o = orderDetailPayInfo;
                    OrderDetailPayFragment.this.m(str2, str);
                }

                public void onSuccess(OrderDetailPayList orderDetailPayList) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1905678955")) {
                        ipChange.ipc$dispatch("-1905678955", new Object[]{this, orderDetailPayList});
                        return;
                    }
                    OrderDetailPayFragment.this.s();
                    if (orderDetailPayList != null) {
                        OrderDetailPayFragment.this.n();
                        OrderDetailPayFragment.this.j.updatePayList(orderDetailPayList.paymentInfoList);
                        if (OrderDetailPayFragment.this.g != null) {
                            OrderDetailPayFragment.this.g.notifyDataSetChanged();
                        }
                    }
                }
            });
        }
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "524161774")) {
            ipChange.ipc$dispatch("524161774", new Object[]{this});
            return;
        }
        OrderDetailPayViewModel orderDetailPayViewModel = this.j;
        if (orderDetailPayViewModel != null && orderDetailPayViewModel.isCoupon()) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", this.j.getProjectId());
            hashMap.put("orderid", this.j.getOrderId());
            long currentTimeMillis = System.currentTimeMillis() - this.q;
            c.e().C("confirm_pay", "bottom", ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE, "1.0", currentTimeMillis, hashMap, 2201);
            List<OrderDetailPayInfo> payInfoList = this.j.getPayInfoList();
            for (int i2 = 0; i2 < payInfoList.size(); i2++) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("orderid", this.j.getOrderId());
                hashMap2.put("item_id", this.j.getProjectId());
                hashMap2.put("titlelabel", payInfoList.get(i2).payName);
                c e2 = c.e();
                e2.C("pay_" + i2, "bottom", ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE, "1.0", currentTimeMillis, hashMap, 2201);
            }
        }
        super.dismiss();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075047563")) {
            ipChange.ipc$dispatch("2075047563", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        p(this.o);
    }

    public void l(FragmentActivity fragmentActivity, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541195768")) {
            ipChange.ipc$dispatch("-541195768", new Object[]{this, fragmentActivity, intent});
            return;
        }
        OrderDetailPayViewModel orderDetailPayViewModel = (OrderDetailPayViewModel) ViewModelProviders.of(fragmentActivity).get(OrderDetailPayViewModel.class);
        this.j = orderDetailPayViewModel;
        orderDetailPayViewModel.initParam(intent);
        this.j.getPayChangeLiveData().observe(fragmentActivity, this.k);
        if (this.g == null) {
            this.g = new OrderDetailPayAdapter(fragmentActivity, this.j.getPayInfoList());
        }
        TextView textView = this.c;
        if (textView != null && this.j != null) {
            textView.setText("需支付 ¥" + this.j.getAmount());
        }
    }

    /* access modifiers changed from: protected */
    public void m(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786499036")) {
            ipChange.ipc$dispatch("-1786499036", new Object[]{this, str, str2});
            return;
        }
        ResponseErrorPage responseErrorPage = this.p;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.p.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(getActivity(), 1, str2, str, OrderDetailConstantsApi.API_HN_ORDER_DETAIL_PAY_LIST_ORDER);
            this.p = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.p.setRefreshListener(this);
            if (this.h instanceof LinearLayout) {
                this.p.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.h.addView(this.p, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143871371")) {
            ipChange.ipc$dispatch("-143871371", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.p;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.h.removeView(this.p);
                this.p = null;
            }
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223001533")) {
            ipChange.ipc$dispatch("-1223001533", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.v_outside || id == R$id.text_ok) {
            dismiss();
        } else if (R$id.tv_pay == id) {
            h();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124512231")) {
            return (View) ipChange.ipc$dispatch("2124512231", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(R$layout.activity_order_detail_pay, viewGroup);
        j(inflate);
        return inflate;
    }

    public void q(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333885816")) {
            ipChange.ipc$dispatch("333885816", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.q = j2;
    }

    public void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43342079")) {
            ipChange.ipc$dispatch("-43342079", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151045499")) {
            ipChange.ipc$dispatch("1151045499", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }
}
