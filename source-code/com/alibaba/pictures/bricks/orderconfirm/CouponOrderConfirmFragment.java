package com.alibaba.pictures.bricks.orderconfirm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.alibaba.pictures.bricks.orderconfirm.bean.OrderCreateBean;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponOrderRenderRequest;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponSubmitOrderRequest;
import com.alibaba.pictures.bricks.orderconfirm.view.OrderConfirmDetailView;
import com.alibaba.pictures.bricks.util.PaymentService;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.eb0;
import tb.go;
import tb.ho;
import tb.io;
import tb.k21;
import tb.m40;
import tb.ta0;
import tb.vl1;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment extends BricksBaseFragment implements OnEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_PAY_TYPE = "pay_type";
    @NotNull
    public static final String ITEM_ID = "itemId";
    public static final int LOGIN_RESULT = 2000;
    @NotNull
    public static final String SKU_ID = "skuId";
    public OrderConfirmAdapter adapter;
    public ImageView bottomArrow;
    public LinearLayout bottomLayout;
    public DigitTextView bottomPriceTotal;
    private int buyAmount = 1;
    private OrderConfirmDetailView detailPopView;
    public ViewGroup errContainer;
    public RecyclerView irc;
    @Nullable
    private String itemId;
    @Nullable
    private String payType;
    @Nullable
    private PaymentService paymentService;
    @Nullable
    private CouponOrderRenderBean.PriceInfo priceInfo;
    @Nullable
    private CouponOrderRenderBean.BaseRequestData requestData;
    public View rootView;
    @Nullable
    private String skuId;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void bottomViewRender(CouponOrderRenderBean.PriceInfo priceInfo2) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577112654")) {
            ipChange.ipc$dispatch("1577112654", new Object[]{this, priceInfo2});
            return;
        }
        this.priceInfo = priceInfo2;
        if (priceInfo2 != null && (str = priceInfo2.totalPriceTxt) != null) {
            getBottomPriceTotal().setText(str);
        }
    }

    private final void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27786566")) {
            ipChange.ipc$dispatch("27786566", new Object[]{this});
            return;
        }
        ca1.Companion.d(this, 2000);
    }

    private final void initIrc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103890722")) {
            ipChange.ipc$dispatch("103890722", new Object[]{this});
            return;
        }
        Context context = getContext();
        if (context != null) {
            setAdapter(new OrderConfirmAdapter(context, this));
            getIrc().setAdapter(getAdapter());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            getIrc().setLayoutManager(linearLayoutManager);
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619794249")) {
            ipChange.ipc$dispatch("1619794249", new Object[]{this});
            return;
        }
        View findViewById = getRootView().findViewById(R$id.irc);
        k21.h(findViewById, "rootView.findViewById(R.id.irc)");
        setIrc((RecyclerView) findViewById);
        View findViewById2 = getRootView().findViewById(R$id.bottom_total_price);
        k21.h(findViewById2, "rootView.findViewById(R.id.bottom_total_price)");
        setBottomPriceTotal((DigitTextView) findViewById2);
        View findViewById3 = getRootView().findViewById(R$id.order_render_bottom);
        k21.h(findViewById3, "rootView.findViewById(R.id.order_render_bottom)");
        setBottomLayout((LinearLayout) findViewById3);
        View findViewById4 = getRootView().findViewById(R$id.bottom_price_down_arrow);
        k21.g(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        setBottomArrow((ImageView) findViewById4);
        vl1 vl1 = vl1.INSTANCE;
        vl1.e(getBottomArrow(), this.itemId);
        getBottomArrow().setOnClickListener(new ho(this));
        View findViewById5 = getRootView().findViewById(R$id.error_container);
        k21.h(findViewById5, "rootView.findViewById(R.id.error_container)");
        setErrContainer((ViewGroup) findViewById5);
        getRootView().findViewById(R$id.bottom_price_detail_desc).setOnClickListener(new go(this));
        View findViewById6 = getRootView().findViewById(R$id.bottom_submit_order);
        k21.h(findViewById6, "submitOrder");
        vl1.i(findViewById6, this.itemId);
        findViewById6.setOnClickListener(new io(this, findViewById6));
        View findViewById7 = getRootView().findViewById(R$id.order_detail_pop);
        k21.h(findViewById7, "rootView.findViewById(R.id.order_detail_pop)");
        OrderConfirmDetailView orderConfirmDetailView = (OrderConfirmDetailView) findViewById7;
        this.detailPopView = orderConfirmDetailView;
        OrderConfirmDetailView orderConfirmDetailView2 = null;
        if (orderConfirmDetailView == null) {
            k21.A("detailPopView");
            orderConfirmDetailView = null;
        }
        orderConfirmDetailView.setShowListener(new CouponOrderConfirmFragment$initView$4(this));
        OrderConfirmDetailView orderConfirmDetailView3 = this.detailPopView;
        if (orderConfirmDetailView3 == null) {
            k21.A("detailPopView");
        } else {
            orderConfirmDetailView2 = orderConfirmDetailView3;
        }
        orderConfirmDetailView2.setDismissListener(new CouponOrderConfirmFragment$initView$5(this));
        initIrc();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m165initView$lambda0(CouponOrderConfirmFragment couponOrderConfirmFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284286267")) {
            ipChange.ipc$dispatch("-284286267", new Object[]{couponOrderConfirmFragment, view});
            return;
        }
        k21.i(couponOrderConfirmFragment, "this$0");
        couponOrderConfirmFragment.purchaseDetails();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m166initView$lambda1(CouponOrderConfirmFragment couponOrderConfirmFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298536412")) {
            ipChange.ipc$dispatch("-298536412", new Object[]{couponOrderConfirmFragment, view});
            return;
        }
        k21.i(couponOrderConfirmFragment, "this$0");
        couponOrderConfirmFragment.purchaseDetails();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m167initView$lambda2(CouponOrderConfirmFragment couponOrderConfirmFragment, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346205073")) {
            ipChange.ipc$dispatch("-1346205073", new Object[]{couponOrderConfirmFragment, view, view2});
            return;
        }
        k21.i(couponOrderConfirmFragment, "this$0");
        if (couponOrderConfirmFragment.payType == null) {
            BricksToastUtil.INSTANCE.b("请选择支付方式");
            return;
        }
        vl1 vl1 = vl1.INSTANCE;
        k21.h(view, "submitOrder");
        vl1.h(view, couponOrderConfirmFragment.itemId);
        String valueOf = String.valueOf(couponOrderConfirmFragment.buyAmount);
        CouponOrderRenderBean.PriceInfo priceInfo2 = couponOrderConfirmFragment.priceInfo;
        couponOrderConfirmFragment.submitOrder(valueOf, priceInfo2 != null ? priceInfo2.totalPrice : null, couponOrderConfirmFragment.payType);
    }

    /* access modifiers changed from: private */
    public final void parsePayType(CouponOrderRenderBean couponOrderRenderBean) {
        List<OrderCreateBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663011990")) {
            ipChange.ipc$dispatch("-663011990", new Object[]{this, couponOrderRenderBean});
        } else if (this.payType == null && (list = couponOrderRenderBean.dataList) != null) {
            for (T t : list) {
                if (k21.d(t.templateId, "damai_script_play_payment_method")) {
                    try {
                        this.payType = t.data.getJSONArray("payToolList").getJSONObject(0).getString("code");
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private final void purchaseDetails() {
        List<CouponOrderRenderBean.PriceDetailBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467977195")) {
            ipChange.ipc$dispatch("467977195", new Object[]{this});
            return;
        }
        vl1.INSTANCE.d(getBottomArrow(), this.itemId);
        OrderConfirmDetailView orderConfirmDetailView = this.detailPopView;
        OrderConfirmDetailView orderConfirmDetailView2 = null;
        if (orderConfirmDetailView == null) {
            k21.A("detailPopView");
            orderConfirmDetailView = null;
        }
        if (orderConfirmDetailView.isShow()) {
            OrderConfirmDetailView orderConfirmDetailView3 = this.detailPopView;
            if (orderConfirmDetailView3 == null) {
                k21.A("detailPopView");
            } else {
                orderConfirmDetailView2 = orderConfirmDetailView3;
            }
            orderConfirmDetailView2.dismiss();
            return;
        }
        CouponOrderRenderBean.PriceInfo priceInfo2 = this.priceInfo;
        if (priceInfo2 != null && (list = priceInfo2.priceDetailList) != null) {
            OrderConfirmDetailView orderConfirmDetailView4 = this.detailPopView;
            if (orderConfirmDetailView4 == null) {
                k21.A("detailPopView");
                orderConfirmDetailView4 = null;
            }
            orderConfirmDetailView4.updateContent(list);
            OrderConfirmDetailView orderConfirmDetailView5 = this.detailPopView;
            if (orderConfirmDetailView5 == null) {
                k21.A("detailPopView");
            } else {
                orderConfirmDetailView2 = orderConfirmDetailView5;
            }
            orderConfirmDetailView2.show();
        }
    }

    /* access modifiers changed from: private */
    public final void requestOrderRender() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212541801")) {
            ipChange.ipc$dispatch("212541801", new Object[]{this});
            return;
        }
        showLoading("");
        if (DoloresLoginHandler.Companion.a().c()) {
            ta0.a aVar = ta0.Companion;
            CouponOrderRenderRequest couponOrderRenderRequest = new CouponOrderRenderRequest();
            couponOrderRenderRequest.setItemId(this.itemId);
            couponOrderRenderRequest.setSkuId(this.skuId);
            couponOrderRenderRequest.setBuyAmount(this.buyAmount);
            aVar.b(couponOrderRenderRequest).c(getContext()).a().doOnKTSuccess(new CouponOrderConfirmFragment$requestOrderRender$2(this)).doOnKTFail(new CouponOrderConfirmFragment$requestOrderRender$3(this)).doOnKTFinish(new CouponOrderConfirmFragment$requestOrderRender$4(this));
            return;
        }
        gotoLogin();
    }

    private final void submitOrder(String str, String str2, String str3) {
        String str4;
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769696620")) {
            ipChange.ipc$dispatch("-769696620", new Object[]{this, str, str2, str3});
            return;
        }
        showLoadingDialog("");
        CouponSubmitOrderRequest couponSubmitOrderRequest = new CouponSubmitOrderRequest();
        CouponOrderRenderBean.BaseRequestData baseRequestData = this.requestData;
        if (baseRequestData == null || (str4 = baseRequestData.itemId) == null) {
            str4 = this.itemId;
        }
        couponSubmitOrderRequest.setItemId(str4);
        CouponOrderRenderBean.BaseRequestData baseRequestData2 = this.requestData;
        if (baseRequestData2 == null || (str5 = baseRequestData2.skuId) == null) {
            str5 = this.skuId;
        }
        couponSubmitOrderRequest.setSkuId(str5);
        CouponOrderRenderBean.BaseRequestData baseRequestData3 = this.requestData;
        String str6 = null;
        couponSubmitOrderRequest.setBuyAmount(baseRequestData3 != null ? Integer.valueOf(baseRequestData3.buyAmount).toString() : null);
        CouponOrderRenderBean.BaseRequestData baseRequestData4 = this.requestData;
        if (baseRequestData4 != null) {
            str6 = baseRequestData4.itemType;
        }
        couponSubmitOrderRequest.setItemType(str6);
        couponSubmitOrderRequest.setTotalPrice(str2);
        couponSubmitOrderRequest.setPayTypeCode(str3);
        eb0.a(couponSubmitOrderRequest).doOnKTSuccess(new CouponOrderConfirmFragment$submitOrder$2(str3, this)).doOnKTFail(new CouponOrderConfirmFragment$submitOrder$3(this, str3)).doOnKTFinish(new CouponOrderConfirmFragment$submitOrder$4(this));
    }

    @NotNull
    public final OrderConfirmAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120389532")) {
            return (OrderConfirmAdapter) ipChange.ipc$dispatch("120389532", new Object[]{this});
        }
        OrderConfirmAdapter orderConfirmAdapter = this.adapter;
        if (orderConfirmAdapter != null) {
            return orderConfirmAdapter;
        }
        k21.A("adapter");
        return null;
    }

    @NotNull
    public final ImageView getBottomArrow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232938042")) {
            return (ImageView) ipChange.ipc$dispatch("232938042", new Object[]{this});
        }
        ImageView imageView = this.bottomArrow;
        if (imageView != null) {
            return imageView;
        }
        k21.A("bottomArrow");
        return null;
    }

    @NotNull
    public final LinearLayout getBottomLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829090344")) {
            return (LinearLayout) ipChange.ipc$dispatch("-1829090344", new Object[]{this});
        }
        LinearLayout linearLayout = this.bottomLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        k21.A("bottomLayout");
        return null;
    }

    @NotNull
    public final DigitTextView getBottomPriceTotal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938092932")) {
            return (DigitTextView) ipChange.ipc$dispatch("-938092932", new Object[]{this});
        }
        DigitTextView digitTextView = this.bottomPriceTotal;
        if (digitTextView != null) {
            return digitTextView;
        }
        k21.A("bottomPriceTotal");
        return null;
    }

    public final int getBuyAmount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1278738409")) {
            return this.buyAmount;
        }
        return ((Integer) ipChange.ipc$dispatch("1278738409", new Object[]{this})).intValue();
    }

    @NotNull
    public final ViewGroup getErrContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587601509")) {
            return (ViewGroup) ipChange.ipc$dispatch("-1587601509", new Object[]{this});
        }
        ViewGroup viewGroup = this.errContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        k21.A("errContainer");
        return null;
    }

    @NotNull
    public final RecyclerView getIrc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673183105")) {
            return (RecyclerView) ipChange.ipc$dispatch("673183105", new Object[]{this});
        }
        RecyclerView recyclerView = this.irc;
        if (recyclerView != null) {
            return recyclerView;
        }
        k21.A("irc");
        return null;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1717038040")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("1717038040", new Object[]{this});
    }

    @Nullable
    public final String getPayType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "671165230")) {
            return this.payType;
        }
        return (String) ipChange.ipc$dispatch("671165230", new Object[]{this});
    }

    @Nullable
    public final PaymentService getPaymentService() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1445111648")) {
            return this.paymentService;
        }
        return (PaymentService) ipChange.ipc$dispatch("1445111648", new Object[]{this});
    }

    @Nullable
    public final CouponOrderRenderBean.PriceInfo getPriceInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-974986477")) {
            return this.priceInfo;
        }
        return (CouponOrderRenderBean.PriceInfo) ipChange.ipc$dispatch("-974986477", new Object[]{this});
    }

    @Nullable
    public final CouponOrderRenderBean.BaseRequestData getRequestData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1359753984")) {
            return this.requestData;
        }
        return (CouponOrderRenderBean.BaseRequestData) ipChange.ipc$dispatch("-1359753984", new Object[]{this});
    }

    @NotNull
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311812177")) {
            return (View) ipChange.ipc$dispatch("1311812177", new Object[]{this});
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        k21.A("rootView");
        return null;
    }

    @Nullable
    public final String getSkuId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2080982140")) {
            return this.skuId;
        }
        return (String) ipChange.ipc$dispatch("-2080982140", new Object[]{this});
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091368194")) {
            ipChange.ipc$dispatch("2091368194", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "itemId", (Object) this.itemId);
        OrderConfirmAdapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.b(jSONObject);
        }
        requestOrderRender();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911349520")) {
            ipChange.ipc$dispatch("-1911349520", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i2 == -1 && i == 2000) {
            requestOrderRender();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1335646127")) {
            ipChange.ipc$dispatch("-1335646127", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str2 = null;
        this.itemId = arguments != null ? arguments.getString("itemId") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString(SKU_ID);
        }
        this.skuId = str2;
        String str3 = this.itemId;
        if (str3 != null && !(o.y(str3))) {
            z = false;
        }
        if (!z && (str = this.skuId) != null) {
            boolean unused = o.y(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040470893")) {
            return (View) ipChange.ipc$dispatch("-2040470893", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.bricks_coupon_order_confirm_fragment, viewGroup, false);
        k21.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        setRootView(inflate);
        initView();
        return getRootView();
    }

    @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
    public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541417261")) {
            ipChange.ipc$dispatch("-1541417261", new Object[]{this, str, view, obj});
            return;
        }
        k21.i(str, "eventId");
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        String str2 = null;
        switch (str.hashCode()) {
            case 756293611:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_PLUS)) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    int intValue = num != null ? num.intValue() : this.buyAmount;
                    this.buyAmount = intValue;
                    this.buyAmount = intValue + 1;
                    requestOrderRender();
                    return;
                }
                return;
            case 1370210417:
                if (str.equals(EVENT_PAY_TYPE)) {
                    JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                    if (jSONObject != null) {
                        Object obj2 = jSONObject.get("payType");
                        if (obj2 != null) {
                            str2 = obj2.toString();
                        }
                        this.payType = str2;
                        return;
                    }
                    return;
                }
                return;
            case 1963855769:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_INPUT)) {
                    if (obj instanceof Integer) {
                        num3 = (Integer) obj;
                    }
                    this.buyAmount = num3 != null ? num3.intValue() : this.buyAmount;
                    requestOrderRender();
                    return;
                }
                return;
            case 1967398975:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_MINUS)) {
                    if (obj instanceof Integer) {
                        num2 = (Integer) obj;
                    }
                    int intValue2 = num2 != null ? num2.intValue() : this.buyAmount;
                    this.buyAmount = intValue2;
                    this.buyAmount = intValue2 - 1;
                    requestOrderRender();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setAdapter(@NotNull OrderConfirmAdapter orderConfirmAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110690748")) {
            ipChange.ipc$dispatch("1110690748", new Object[]{this, orderConfirmAdapter});
            return;
        }
        k21.i(orderConfirmAdapter, "<set-?>");
        this.adapter = orderConfirmAdapter;
    }

    public final void setBottomArrow(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396347556")) {
            ipChange.ipc$dispatch("-396347556", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "<set-?>");
        this.bottomArrow = imageView;
    }

    public final void setBottomLayout(@NotNull LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051716718")) {
            ipChange.ipc$dispatch("-2051716718", new Object[]{this, linearLayout});
            return;
        }
        k21.i(linearLayout, "<set-?>");
        this.bottomLayout = linearLayout;
    }

    public final void setBottomPriceTotal(@NotNull DigitTextView digitTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671333242")) {
            ipChange.ipc$dispatch("671333242", new Object[]{this, digitTextView});
            return;
        }
        k21.i(digitTextView, "<set-?>");
        this.bottomPriceTotal = digitTextView;
    }

    public final void setBuyAmount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845227967")) {
            ipChange.ipc$dispatch("-845227967", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.buyAmount = i;
    }

    public final void setErrContainer(@NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074465517")) {
            ipChange.ipc$dispatch("2074465517", new Object[]{this, viewGroup});
            return;
        }
        k21.i(viewGroup, "<set-?>");
        this.errContainer = viewGroup;
    }

    public final void setIrc(@NotNull RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36067537")) {
            ipChange.ipc$dispatch("36067537", new Object[]{this, recyclerView});
            return;
        }
        k21.i(recyclerView, "<set-?>");
        this.irc = recyclerView;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293479686")) {
            ipChange.ipc$dispatch("293479686", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setPayType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009999368")) {
            ipChange.ipc$dispatch("2009999368", new Object[]{this, str});
            return;
        }
        this.payType = str;
    }

    public final void setPaymentService(@Nullable PaymentService paymentService2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1867303950")) {
            ipChange.ipc$dispatch("1867303950", new Object[]{this, paymentService2});
            return;
        }
        this.paymentService = paymentService2;
    }

    public final void setPriceInfo(@Nullable CouponOrderRenderBean.PriceInfo priceInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069298627")) {
            ipChange.ipc$dispatch("-1069298627", new Object[]{this, priceInfo2});
            return;
        }
        this.priceInfo = priceInfo2;
    }

    public final void setRequestData(@Nullable CouponOrderRenderBean.BaseRequestData baseRequestData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101012974")) {
            ipChange.ipc$dispatch("101012974", new Object[]{this, baseRequestData});
            return;
        }
        this.requestData = baseRequestData;
    }

    public final void setRootView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529811281")) {
            ipChange.ipc$dispatch("-529811281", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.rootView = view;
    }

    public final void setSkuId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889536654")) {
            ipChange.ipc$dispatch("-1889536654", new Object[]{this, str});
            return;
        }
        this.skuId = str;
    }
}
