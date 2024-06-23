package com.alibaba.pictures.bricks.orderresult;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.DmCouponPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.PayResultDataHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.PaySuccessRequest;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.RecommendRequest;
import com.alibaba.pictures.bricks.view.PullToRefreshHeaderView;
import com.alibaba.pictures.bricks.view.irecycler.IRecyclerView;
import com.alibaba.pictures.bricks.view.irecycler.OnRefreshListener;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.eb0;
import tb.jo;
import tb.k21;
import tb.m40;
import tb.pp2;
import tb.ta0;

/* compiled from: Taobao */
public final class CouponPayResultFragment extends BricksBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String CITYID = "cityId";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String HOME_CLICK = "home_action";
    @NotNull
    public static final String ORDERID = "orderId";
    @NotNull
    public static final String ORDER_CLICK = "order_action";
    public static final int PAYRESULT_LOGIN_RESULT = 2008;
    @Nullable
    private String cityID;
    @Nullable
    private CouponPayResultAdapter mGaiaXAdapter;
    @NotNull
    private ArrayList<PayResultDataHolder> mGaiaXList = new ArrayList<>();
    public IRecyclerView mGaiaXRecyclerView;
    @NotNull
    private OnRefreshListener onFreshListener = new jo(this);
    @Nullable
    private String orderId;
    @Nullable
    private PayResultUtListener payResultUtListener;
    public View rootView;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128477920")) {
            ipChange.ipc$dispatch("2128477920", new Object[]{this});
            return;
        }
        ca1.Companion.d(this, 2008);
    }

    private final void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215557584")) {
            ipChange.ipc$dispatch("-1215557584", new Object[]{this});
            return;
        }
        Context context = getContext();
        if (context != null) {
            CouponPayResultAdapter couponPayResultAdapter = new CouponPayResultAdapter(context, this.orderId);
            this.mGaiaXAdapter = couponPayResultAdapter;
            couponPayResultAdapter.a(this.mGaiaXList);
            IRecyclerView mGaiaXRecyclerView2 = getMGaiaXRecyclerView();
            if (mGaiaXRecyclerView2 != null) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(1);
                mGaiaXRecyclerView2.setLayoutManager(linearLayoutManager);
                mGaiaXRecyclerView2.setRefreshEnabled(true);
                mGaiaXRecyclerView2.setAdapter(this.mGaiaXAdapter);
                mGaiaXRecyclerView2.setIsAutoToDefault(false);
                mGaiaXRecyclerView2.getLoadMoreFooterView().setVisibility(8);
                mGaiaXRecyclerView2.setLoadMoreEnabled(true);
                mGaiaXRecyclerView2.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(context));
                mGaiaXRecyclerView2.setOnRefreshListener(this.onFreshListener);
                mGaiaXRecyclerView2.setItemAnimator(null);
            }
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776124817")) {
            ipChange.ipc$dispatch("-1776124817", new Object[]{this});
            return;
        }
        View findViewById = getRootView().findViewById(R$id.rc);
        k21.h(findViewById, "rootView.findViewById(R.id.rc)");
        setMGaiaXRecyclerView((IRecyclerView) findViewById);
        initRecyclerView();
        requestPayResultData();
    }

    /* access modifiers changed from: private */
    /* renamed from: onFreshListener$lambda-0  reason: not valid java name */
    public static final void m171onFreshListener$lambda0(CouponPayResultFragment couponPayResultFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478607137")) {
            ipChange.ipc$dispatch("1478607137", new Object[]{couponPayResultFragment});
            return;
        }
        k21.i(couponPayResultFragment, "this$0");
        couponPayResultFragment.requestPayResultData();
    }

    private final void requestPayResultData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620806660")) {
            ipChange.ipc$dispatch("1620806660", new Object[]{this});
        } else if (DoloresLoginHandler.Companion.a().c()) {
            IRecyclerView mGaiaXRecyclerView2 = getMGaiaXRecyclerView();
            if (mGaiaXRecyclerView2 != null) {
                mGaiaXRecyclerView2.setRefreshing(true);
            }
            ta0.a aVar = ta0.Companion;
            PaySuccessRequest paySuccessRequest = new PaySuccessRequest();
            paySuccessRequest.setOrderId(this.orderId);
            aVar.b(paySuccessRequest).c(getContext()).a().doOnKTSuccess(new CouponPayResultFragment$requestPayResultData$2(this)).doOnKTFail(new CouponPayResultFragment$requestPayResultData$3(this)).doOnKTFinish(new CouponPayResultFragment$requestPayResultData$4(this));
        } else {
            gotoLogin();
        }
    }

    /* access modifiers changed from: private */
    public final void returnAnotherShow(RecommendListMo recommendListMo) {
        ArrayList<JSONObject> result;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105454608")) {
            ipChange.ipc$dispatch("-105454608", new Object[]{this, recommendListMo});
        } else if (recommendListMo != null && (result = recommendListMo.getResult()) != null) {
            if (result.size() > 0) {
                PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
                payResultDataHolder.setType(1);
                this.mGaiaXList.add(payResultDataHolder);
            }
            int size = result.size();
            for (int i = 0; i < size; i++) {
                PayResultDataHolder payResultDataHolder2 = new PayResultDataHolder();
                payResultDataHolder2.setMRecommendResponse(result.get(i));
                payResultDataHolder2.setType(2);
                this.mGaiaXList.add(payResultDataHolder2);
            }
            CouponPayResultAdapter couponPayResultAdapter = this.mGaiaXAdapter;
            if (couponPayResultAdapter != null) {
                couponPayResultAdapter.a(this.mGaiaXList);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void returnAnotherShowError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845513312")) {
            ipChange.ipc$dispatch("-1845513312", new Object[]{this, str, str2});
        }
    }

    @NotNull
    public final DmCouponPaySuccessBean createPayResultErrorMsg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073347796")) {
            return (DmCouponPaySuccessBean) ipChange.ipc$dispatch("1073347796", new Object[]{this});
        }
        DmCouponPaySuccessBean dmCouponPaySuccessBean = new DmCouponPaySuccessBean();
        dmCouponPaySuccessBean.isPaid = "false";
        dmCouponPaySuccessBean.orderId = this.orderId;
        dmCouponPaySuccessBean.resultDesc = "支付结果处理中";
        dmCouponPaySuccessBean.render = new ArrayList();
        DmCouponPaySuccessBean.GaiaxRender gaiaxRender = new DmCouponPaySuccessBean.GaiaxRender();
        gaiaxRender.type = "gaiax";
        gaiaxRender.url = "damai://gaiax?templateId=damai_script_play_pay_result_item&templateVersion=99&bizId=damai";
        dmCouponPaySuccessBean.render.add(gaiaxRender);
        dmCouponPaySuccessBean.buttons = new ArrayList();
        DmCouponPaySuccessBean.DmPayButtonBean dmPayButtonBean = new DmCouponPaySuccessBean.DmPayButtonBean();
        dmPayButtonBean.buttonText = "返回首页";
        dmPayButtonBean.buttonType = "1";
        dmPayButtonBean.nativeUrl = pp2.SCHEME_HOMEPAGE;
        DmCouponPaySuccessBean.DmPayButtonBean dmPayButtonBean2 = new DmCouponPaySuccessBean.DmPayButtonBean();
        dmPayButtonBean2.buttonText = "查看订单详情";
        dmPayButtonBean2.buttonType = "2";
        dmPayButtonBean2.nativeUrl = "damai://V1/CouponOrderDetail?orderId=" + this.orderId + "&payResult=false";
        dmCouponPaySuccessBean.buttons.add(dmPayButtonBean);
        dmCouponPaySuccessBean.buttons.add(dmPayButtonBean2);
        return dmCouponPaySuccessBean;
    }

    @Nullable
    public final String getCityID() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-5853770")) {
            return this.cityID;
        }
        return (String) ipChange.ipc$dispatch("-5853770", new Object[]{this});
    }

    @NotNull
    public final IRecyclerView getMGaiaXRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232546802")) {
            return (IRecyclerView) ipChange.ipc$dispatch("1232546802", new Object[]{this});
        }
        IRecyclerView iRecyclerView = this.mGaiaXRecyclerView;
        if (iRecyclerView != null) {
            return iRecyclerView;
        }
        k21.A("mGaiaXRecyclerView");
        return null;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1635400241")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("-1635400241", new Object[]{this});
    }

    @Nullable
    public final PayResultUtListener getPayResultUtListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2067465395")) {
            return this.payResultUtListener;
        }
        return (PayResultUtListener) ipChange.ipc$dispatch("2067465395", new Object[]{this});
    }

    @NotNull
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096801003")) {
            return (View) ipChange.ipc$dispatch("1096801003", new Object[]{this});
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        k21.A("rootView");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193120106")) {
            ipChange.ipc$dispatch("-193120106", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i2 == -1 && i == 2008) {
            requestPayResultData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285591701")) {
            ipChange.ipc$dispatch("-285591701", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.orderId = arguments != null ? arguments.getString("orderId") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("cityId");
        }
        this.cityID = str;
        String str2 = this.orderId;
        if (str2 != null) {
            boolean unused = o.y(str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960655559")) {
            return (View) ipChange.ipc$dispatch("-960655559", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.bricks_coupon_pay_result_fragment, viewGroup, false);
        k21.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        setRootView(inflate);
        initView();
        return getRootView();
    }

    public final void queryAnotherShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785499220")) {
            ipChange.ipc$dispatch("-785499220", new Object[]{this});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.setCityId(this.cityID);
        eb0.a(recommendRequest).doOnKTSuccess(new CouponPayResultFragment$queryAnotherShow$2(this)).doOnKTFail(new CouponPayResultFragment$queryAnotherShow$3(this));
    }

    public final void setCityID(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576558872")) {
            ipChange.ipc$dispatch("-1576558872", new Object[]{this, str});
            return;
        }
        this.cityID = str;
    }

    public final void setMGaiaXRecyclerView(@NotNull IRecyclerView iRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080639382")) {
            ipChange.ipc$dispatch("2080639382", new Object[]{this, iRecyclerView});
            return;
        }
        k21.i(iRecyclerView, "<set-?>");
        this.mGaiaXRecyclerView = iRecyclerView;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774053497")) {
            ipChange.ipc$dispatch("-774053497", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }

    public final void setPayResultUtListener(@Nullable PayResultUtListener payResultUtListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756607565")) {
            ipChange.ipc$dispatch("-1756607565", new Object[]{this, payResultUtListener2});
            return;
        }
        this.payResultUtListener = payResultUtListener2;
    }

    public final void setRootView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394776917")) {
            ipChange.ipc$dispatch("1394776917", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.rootView = view;
    }

    public final void setUtListener(@NotNull PayResultUtListener payResultUtListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467482672")) {
            ipChange.ipc$dispatch("467482672", new Object[]{this, payResultUtListener2});
            return;
        }
        k21.i(payResultUtListener2, "utListener");
        this.payResultUtListener = payResultUtListener2;
    }
}
