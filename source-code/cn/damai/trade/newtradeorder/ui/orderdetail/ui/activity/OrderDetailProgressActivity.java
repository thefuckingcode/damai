package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAllProgressBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressType;
import cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailProgressViewModel;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.OrderProgressAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ln2;
import tb.mm1;
import tb.ne2;
import tb.om1;
import tb.xf2;
import tb.xj1;

/* compiled from: Taobao */
public class OrderDetailProgressActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int PROGRESS_TYPE_CHOOSE_SEAT = 4;
    private final int PROGRESS_TYPE_DELIVERY_TIP = 3;
    private final int PROGRESS_TYPE_ROW = 1;
    private final int PROGRESS_TYPE_SEAT_TIP = 2;
    private final int PROGRESS_TYPE_SEE_TICKET = 5;
    private SeatPrepare4Order chooseSeat;
    View.OnClickListener eventListener = new d();
    private OrderProgressAdapter mAdapter;
    private OrderDetailAllProgressBean mAllProgressBean;
    private LinearLayout mBtnContainer;
    private View mBtnLine;
    private IRecyclerView mIRecyclerView;
    private ImageView mMohuImageBg;
    private Observer<OrderDetailAllProgressBean> mOrderProgressObserver = new Observer<OrderDetailAllProgressBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailProgressActivity.AnonymousClass4 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable OrderDetailAllProgressBean orderDetailAllProgressBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1213736049")) {
                ipChange.ipc$dispatch("1213736049", new Object[]{this, orderDetailAllProgressBean});
            } else if (orderDetailAllProgressBean != null) {
                OrderDetailProgressActivity.this.mAllProgressBean = orderDetailAllProgressBean;
                OrderDetailProgressActivity.this.stopProgressDialog();
                OrderDetailProgressActivity orderDetailProgressActivity = OrderDetailProgressActivity.this;
                orderDetailProgressActivity.onResponseSuccess(orderDetailProgressActivity.mProgressRoot);
                if (orderDetailAllProgressBean.requestState) {
                    OrderDetailProgressActivity.this.loadHeadStateData(orderDetailAllProgressBean.progressSummary, orderDetailAllProgressBean.progressDesc, orderDetailAllProgressBean.buttonTypeList);
                    OrderDetailProgressActivity.this.mOrderProgrssDatas.clear();
                    int e = xf2.e(orderDetailAllProgressBean.progressList);
                    int i = 0;
                    while (i < e) {
                        om1 om1 = new om1(0);
                        om1.b = orderDetailAllProgressBean.progressList.get(i);
                        int i2 = e - 1;
                        om1.c = i == i2;
                        OrderDetailProgressActivity.this.mOrderProgrssDatas.add(om1);
                        if (i == i2) {
                            OrderDetailProgressActivity.this.mOrderProgrssDatas.add(new om1(1));
                        }
                        i++;
                    }
                    if (OrderDetailProgressActivity.this.mAdapter != null) {
                        OrderDetailProgressActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                OrderDetailProgressActivity orderDetailProgressActivity2 = OrderDetailProgressActivity.this;
                orderDetailProgressActivity2.onResponseError(orderDetailAllProgressBean.errorMsg, orderDetailAllProgressBean.errorCode, OrderDetailConstantsApi.API_ORDER_DETAIL_PROGRESS, orderDetailProgressActivity2.mProgressRoot, true);
            }
        }
    };
    private List<om1> mOrderProgrssDatas = new ArrayList();
    private LinearLayout mProgressRoot;
    private TextView mTvOrderState;
    private TextView mTvOrderStateDesc;
    private OrderDetailProgressViewModel mViewModel;
    private View statusBar;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615923601")) {
                ipChange.ipc$dispatch("1615923601", new Object[]{this, view});
                return;
            }
            OrderDetailProgressActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-291793980")) {
                ipChange.ipc$dispatch("-291793980", new Object[]{this, dVar});
                return;
            }
            OrderDetailProgressActivity.this.mMohuImageBg.setBackgroundColor(ContextCompat.getColor(OrderDetailProgressActivity.this, R$color.color_274B93));
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "315269721")) {
                ipChange.ipc$dispatch("315269721", new Object[]{this, eVar});
            } else if (eVar != null) {
                Bitmap bitmap = eVar.b;
                if (bitmap != null) {
                    OrderDetailProgressActivity.this.mMohuImageBg.setBackgroundColor(DMRGBUtil.e(0.7f, bitmap));
                    return;
                }
                OrderDetailProgressActivity.this.mMohuImageBg.setBackgroundColor(ContextCompat.getColor(OrderDetailProgressActivity.this, R$color.color_274B93));
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements SeatPrepare4Order.OnLoadListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onLoadStateChanged(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "562194539")) {
                    ipChange.ipc$dispatch("562194539", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    OrderDetailProgressActivity.this.startProgressDialog();
                } else {
                    OrderDetailProgressActivity.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onSeatActivityOpen(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1742793104")) {
                    ipChange.ipc$dispatch("1742793104", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                cn.damai.common.user.c.e().x(ln2.r().v1(this.a));
            }
        }

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1471150485")) {
                ipChange.ipc$dispatch("1471150485", new Object[]{this, view});
                return;
            }
            OrderDetailProgressType orderDetailProgressType = (OrderDetailProgressType) view.getTag();
            if (orderDetailProgressType != null) {
                String orderId = OrderDetailProgressActivity.this.mViewModel != null ? OrderDetailProgressActivity.this.mViewModel.getOrderId() : "";
                int i = orderDetailProgressType.buttonType;
                if (i == 1) {
                    cn.damai.common.user.c.e().x(ln2.r().x1(orderId));
                    mm1.k(OrderDetailProgressActivity.this.mContext, orderDetailProgressType.url);
                } else if (i == 2) {
                    cn.damai.common.user.c.e().x(ln2.r().y1(orderId));
                    mm1.l(OrderDetailProgressActivity.this);
                    if (OrderDetailProgressActivity.this.mViewModel != null && xj1.b(OrderDetailProgressActivity.this)) {
                        OrderDetailProgressActivity.this.mViewModel.requestOrderDeliveryRemind();
                    }
                } else if (i != 3) {
                    if (i != 4) {
                        if (i == 5 && OrderDetailProgressActivity.this.mViewModel != null) {
                            cn.damai.common.user.c.e().x(ln2.r().z1(orderId));
                            OrderDetailProgressActivity orderDetailProgressActivity = OrderDetailProgressActivity.this;
                            mm1.j(orderDetailProgressActivity, orderDetailProgressActivity.mViewModel.getOrderId());
                        }
                    } else if (OrderDetailProgressActivity.this.mAllProgressBean != null) {
                        OrderDetailProgressActivity.this.chooseSeat.g(OrderDetailProgressActivity.this.mAllProgressBean.projectName, OrderDetailProgressActivity.this.mAllProgressBean.performName, OrderDetailProgressActivity.this.mAllProgressBean.orderId, OrderDetailProgressActivity.this.mAllProgressBean.itemId, OrderDetailProgressActivity.this.mAllProgressBean.performId, OrderDetailProgressActivity.this.mAllProgressBean.showCityId, new a(orderId));
                    }
                } else if (!TextUtils.isEmpty(orderDetailProgressType.toast)) {
                    cn.damai.common.user.c.e().x(ln2.r().w1(orderId));
                    ToastUtil.i(orderDetailProgressType.toast);
                    if (OrderDetailProgressActivity.this.mViewModel != null) {
                        OrderDetailProgressActivity.this.mViewModel.requestOrderChooseSeatRemind();
                    }
                }
            }
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537529337")) {
            ipChange.ipc$dispatch("1537529337", new Object[]{this});
            return;
        }
        this.chooseSeat = new SeatPrepare4Order(this, 0);
        OrderDetailProgressViewModel orderDetailProgressViewModel = (OrderDetailProgressViewModel) ViewModelProviders.of(this).get(OrderDetailProgressViewModel.class);
        this.mViewModel = orderDetailProgressViewModel;
        orderDetailProgressViewModel.getOrderProgressLiveData().observe(this, this.mOrderProgressObserver);
        this.mViewModel.initParam(getIntent());
        loadMohuImageBg(this.mViewModel.getImageUrl());
        startRequest();
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112713185")) {
            ipChange.ipc$dispatch("112713185", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar);
        this.statusBar = findViewById;
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                this.statusBar.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            ne2.e(this);
            return;
        }
        ne2.f(this, false, R$color.black);
        View view = this.statusBar;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055999343")) {
            ipChange.ipc$dispatch("1055999343", new Object[]{this});
            return;
        }
        findViewById(R$id.tv_goback).setOnClickListener(new a());
        ((TextView) findViewById(R$id.tv_title_name)).setText("订单进度");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadHeadStateData(String str, String str2, List<OrderDetailProgressType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659553767")) {
            ipChange.ipc$dispatch("659553767", new Object[]{this, str, str2, list});
            return;
        }
        this.mTvOrderState.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            this.mTvOrderStateDesc.setText(str2);
            this.mTvOrderStateDesc.setVisibility(0);
        } else {
            this.mTvOrderStateDesc.setVisibility(8);
        }
        int e = xf2.e(list);
        if (e <= 0) {
            this.mBtnLine.setVisibility(8);
            this.mBtnContainer.setVisibility(8);
            return;
        }
        this.mBtnLine.setVisibility(0);
        this.mBtnContainer.setVisibility(0);
        this.mBtnContainer.removeAllViews();
        for (int i = 0; i < e; i++) {
            View inflate = LayoutInflater.from(this).inflate(R$layout.order_detail_progress_btn, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_button)).setText(list.get(i).buttonName);
            inflate.setTag(list.get(i));
            inflate.setOnClickListener(this.eventListener);
            this.mBtnContainer.addView(inflate);
        }
    }

    private void loadMohuImageBg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513881610")) {
            ipChange.ipc$dispatch("-513881610", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            cn.damai.common.image.a.b().c(str).n(new c()).e(new b()).f();
        }
    }

    private void startRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253745882")) {
            ipChange.ipc$dispatch("-1253745882", new Object[]{this});
        } else if (this.mViewModel != null) {
            startProgressDialog();
            this.mViewModel.requestOrderDetailProgress();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-830682161")) {
            return R$layout.activity_order_progress;
        }
        return ((Integer) ipChange.ipc$dispatch("-830682161", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843341940")) {
            ipChange.ipc$dispatch("-1843341940", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.handleError(i);
        startRequest();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548562206")) {
            ipChange.ipc$dispatch("548562206", new Object[]{this});
            return;
        }
        super.initView();
        initStateBar();
        initTitle();
        this.mMohuImageBg = (ImageView) findViewById(R$id.iv_project_mohu_image);
        this.mProgressRoot = (LinearLayout) findViewById(R$id.ll_progress_root);
        this.mTvOrderState = (TextView) findViewById(R$id.tv_order_progress_state);
        this.mTvOrderStateDesc = (TextView) findViewById(R$id.tv_order_progress_desc);
        this.mBtnLine = findViewById(R$id.line_progress_btn);
        this.mBtnContainer = (LinearLayout) findViewById(R$id.ll_progress_btn);
        IRecyclerView iRecyclerView = (IRecyclerView) findViewById(R$id.recycler);
        this.mIRecyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrderProgressAdapter orderProgressAdapter = new OrderProgressAdapter(this, this.mOrderProgrssDatas);
        this.mAdapter = orderProgressAdapter;
        this.mIRecyclerView.setAdapter(orderProgressAdapter);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-437069220")) {
            ipChange.ipc$dispatch("-437069220", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        hideBaseLayout();
        initData();
        OrderDetailProgressViewModel orderDetailProgressViewModel = this.mViewModel;
        setDamaiUTKeyBuilder(ln2.r().W(orderDetailProgressViewModel != null ? orderDetailProgressViewModel.getOrderId() : ""));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1680188413")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-1680188413", new Object[]{this});
    }
}
