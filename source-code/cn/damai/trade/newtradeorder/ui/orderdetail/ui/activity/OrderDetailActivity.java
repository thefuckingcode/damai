package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.bean.DmPickupAddressBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.notice.NoticeDetailFragment;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.message.observer.Action;
import cn.damai.pay.AliPayActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailButtonBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailCanResellBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailDeliveryInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailMecItemInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgress;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressBtn;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundPopWindowBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailShareBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailStatusBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketService;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.PurchaseNotice;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.OrderDetailAdapter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.uikit.view.NoticeEllipsisTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import tb.an1;
import tb.bk2;
import tb.cm1;
import tb.d20;
import tb.f92;
import tb.g91;
import tb.gr;
import tb.ln2;
import tb.mm1;
import tb.n42;
import tb.ne2;
import tb.nm1;
import tb.ou1;
import tb.xf2;
import tb.xj1;

/* compiled from: Taobao */
public class OrderDetailActivity extends DamaiBaseActivity<OrderDetailPresenter, OrderDetailContract.Model> implements OrderDetailContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String REFUND_POPWINDPW = "refund_popwindow";
    private final int BACK_FROM_PAGE = 3;
    private final String ERROR_CODE_ORDER_HAS_PAY = "MAPIE98087";
    private final String ERROR_CODE_ORDER_NO_CANCEL = "MAPIE98096";
    private final int FROM_HN_CREATE_ORDER = 1;
    private final int FROM_ORDER_LIST = 0;
    private final int FROM_PUSH = 2;
    boolean RequestOrderPaying = false;
    private final int TYPE_SEAT = 4;
    private final int TYPE_TICKET = 5;
    int alpha;
    NoticeDetailFragment detailFragment;
    private OrderDetailPayFragment dialogFragment;
    private int distance = 0;
    private boolean firstInto = true;
    private Handler handler;
    private String imageUrl;
    private boolean isHouNiaoOrder = true;
    private boolean isNeedRefreshList;
    private boolean isSeatProject;
    private LinearLayout llRefundPop;
    private OrderDetailAdapter mAdapter;
    private DMDialog mAddInvoiceDialog;
    private LinearLayout mBottomBtnContainer;
    private View mBottomLineView;
    private LinearLayout mBtnHeaderContainer;
    private StringBuilder mBuilder = new StringBuilder();
    private View.OnClickListener mButtonListener = new k();
    private DMDialog mCanResellDialog;
    private DMDialog mCancelOrderDialog;
    private boolean mCheckAddInvoice;
    private boolean mCheckModifyResult;
    private List<cm1> mDataHolderList = new ArrayList();
    private int mFromPage = 0;
    private String mHeadOrderStateContent;
    private DMIconFontTextView mIconHeadProgress;
    private cm1 mLineDataHolder = new cm1(11);
    private LinearLayoutManager mLinearLayoutManager;
    private NoticeEllipsisTextView mNoticeContentTv;
    private View mNoticeView;
    private DMDialog mOrderAddressDialog;
    private SeatPrepare4Order mOrderChooseSeat;
    private OrderDetailBean mOrderDetailBean;
    boolean mOrderDetailRequesting = false;
    private String mOrderId;
    private int mOrderState = -1;
    private String mOrderStateStr = "";
    private LinearLayout mParHeadBar;
    private String mProjectId;
    private String mProjectName;
    private RecyclerView mRecyclerView;
    private LinearPullToRefreshView mRefreshView;
    private Handler mTimeHandler = new o();
    private Timer mTimer;
    private TimerTask mTimerTask;
    private TextView mTvHeadFirstPayNum;
    private TextView mTvHeadOrderState;
    private TextView mTvHeadOrderStateDesc;
    private TextView mTvHeadPayTip;
    private boolean markAppNotifyHeight = false;
    int pullOffsetOld = 0;
    boolean requesting = false;
    private String resellAgreementUrl;
    private View statusBar;
    private ou1 ticketServiceFragment;
    private TextView tvRefundPop;
    int verticalOffsetOld = 0;
    private boolean visAppNotify = false;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "706743136")) {
                ipChange.ipc$dispatch("706743136", new Object[]{this, view});
                return;
            }
            StatusNotice statusNotice = new StatusNotice();
            statusNotice.setPopupContent(this.a);
            statusNotice.imageUrl = this.b;
            Bundle bundle = new Bundle();
            bundle.putParcelable("status_notice", statusNotice);
            DMNav.from(OrderDetailActivity.this).withExtras(bundle).toUri(NavUri.b("order_detail_notice"));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ OrderDetailProgress b;

        b(String str, OrderDetailProgress orderDetailProgress) {
            this.a = str;
            this.b = orderDetailProgress;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1476933791")) {
                ipChange.ipc$dispatch("-1476933791", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().m1(OrderDetailActivity.this.mProjectId, OrderDetailActivity.this.mOrderId, this.a));
            if (this.b.supportJumpProgressPage()) {
                OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                mm1.f(orderDetailActivity, orderDetailActivity.mOrderId, OrderDetailActivity.this.imageUrl);
            } else if (this.b.supportJumpWebPage()) {
                mm1.k(OrderDetailActivity.this, this.b.url);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailProgressBtn a;
        final /* synthetic */ OrderDetailProgress b;

        /* compiled from: Taobao */
        public class a implements SeatPrepare4Order.OnLoadListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onLoadStateChanged(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "50147966")) {
                    ipChange.ipc$dispatch("50147966", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    OrderDetailActivity.this.startProgressDialog();
                } else {
                    OrderDetailActivity.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onSeatActivityOpen(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1230746531")) {
                    ipChange.ipc$dispatch("1230746531", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                cn.damai.common.user.c.e().x(ln2.r().H(OrderDetailActivity.this.mOrderId));
            }
        }

        c(OrderDetailProgressBtn orderDetailProgressBtn, OrderDetailProgress orderDetailProgress) {
            this.a = orderDetailProgressBtn;
            this.b = orderDetailProgress;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "634356578")) {
                ipChange.ipc$dispatch("634356578", new Object[]{this, view});
                return;
            }
            OrderDetailProgressBtn orderDetailProgressBtn = this.a;
            int i = orderDetailProgressBtn.buttonType;
            if (i != 1) {
                if (i == 2) {
                    cn.damai.common.user.c.e().x(ln2.r().G(OrderDetailActivity.this.mOrderId));
                    mm1.l(OrderDetailActivity.this);
                    if (xj1.b(OrderDetailActivity.this)) {
                        OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                        ((OrderDetailPresenter) orderDetailActivity.mPresenter).orderDetailChooseSeatRemind(orderDetailActivity.mOrderId);
                    }
                } else if (i == 3) {
                    cn.damai.common.user.c.e().x(ln2.r().l1(OrderDetailActivity.this.mProjectId, OrderDetailActivity.this.mOrderId));
                    ToastUtil.a();
                    ToastUtil.f(this.a.toast);
                    OrderDetailActivity orderDetailActivity2 = OrderDetailActivity.this;
                    ((OrderDetailPresenter) orderDetailActivity2.mPresenter).orderDetailDeliveryRemind(orderDetailActivity2.mOrderId);
                } else if (i == 4) {
                    if (OrderDetailActivity.this.mOrderChooseSeat == null || this.b == null) {
                        OrderDetailActivity orderDetailActivity3 = OrderDetailActivity.this;
                        orderDetailActivity3.mOrderChooseSeat = new SeatPrepare4Order(orderDetailActivity3, 0);
                    }
                    SeatPrepare4Order seatPrepare4Order = OrderDetailActivity.this.mOrderChooseSeat;
                    String str = OrderDetailActivity.this.mProjectName;
                    String str2 = this.b.performName;
                    String str3 = OrderDetailActivity.this.mOrderId;
                    String str4 = OrderDetailActivity.this.mProjectId;
                    OrderDetailProgress orderDetailProgress = this.b;
                    seatPrepare4Order.h(str, str2, str3, str4, orderDetailProgress.performId, orderDetailProgress.showCityId, orderDetailProgress.priceInfoList, new a());
                } else if (i == 5) {
                    OrderDetailActivity orderDetailActivity4 = OrderDetailActivity.this;
                    mm1.j(orderDetailActivity4, orderDetailActivity4.mOrderId);
                }
            } else if (!TextUtils.isEmpty(orderDetailProgressBtn.url)) {
                cn.damai.common.user.c.e().x(ln2.r().E(OrderDetailActivity.this.mOrderId));
                mm1.k(OrderDetailActivity.this, this.a.url);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1549320349")) {
                ipChange.ipc$dispatch("-1549320349", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(OrderDetailActivity.this.resellAgreementUrl)) {
                Bundle bundle = new Bundle();
                bundle.putString("url", OrderDetailActivity.this.resellAgreementUrl);
                DMNav.from(OrderDetailActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CheckBox a;
        final /* synthetic */ OrderDetailCanResellBean b;

        e(CheckBox checkBox, OrderDetailCanResellBean orderDetailCanResellBean) {
            this.a = checkBox;
            this.b = orderDetailCanResellBean;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "119697547")) {
                ipChange.ipc$dispatch("119697547", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (!this.a.isChecked()) {
                ToastUtil.a().j(OrderDetailActivity.this.mContext, "请您认真阅读《票品转卖服务协议》,接受后可开始使用我们的服务。");
            } else {
                d20.R();
                cn.damai.common.user.c.e().x(ln2.r().q1(OrderDetailActivity.this.mOrderId));
                OrderDetailActivity.this.jumpCanResellPage(this.b.resellUrl);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CheckBox a;

        f(CheckBox checkBox) {
            this.a = checkBox;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1089278570")) {
                ipChange.ipc$dispatch("1089278570", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            this.a.setChecked(false);
            cn.damai.common.user.c.e().x(ln2.r().s1(OrderDetailActivity.this.mOrderId));
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2058859593")) {
                ipChange.ipc$dispatch("2058859593", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            HavanaProxy.v().p(OrderDetailActivity.this);
        }
    }

    /* compiled from: Taobao */
    public class h implements HavanaProxy.UccTrustLoginListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
        public void onFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-656427719")) {
                ipChange.ipc$dispatch("-656427719", new Object[]{this});
            }
        }

        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-150040656")) {
                ipChange.ipc$dispatch("-150040656", new Object[]{this});
                return;
            }
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            if (orderDetailActivity.isXiaoYuAppInstalled(orderDetailActivity)) {
                OrderDetailActivity.this.jumpXianyuApp(this.a);
            } else if (!TextUtils.isEmpty(this.a)) {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a);
                DMNav.from(OrderDetailActivity.this).withExtras(bundle).toUri(NavUri.b(gr.t));
            }
        }
    }

    /* compiled from: Taobao */
    public class i implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i(OrderDetailActivity orderDetailActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-296945657")) {
                ipChange.ipc$dispatch("-296945657", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class j implements OnCompleteListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // cn.damai.commonbusiness.servicenotice.OnCompleteListener
        public void onComplete(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "139427523")) {
                ipChange.ipc$dispatch("139427523", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            OrderDetailActivity.this.disTicketServiceFragment();
        }
    }

    /* compiled from: Taobao */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1732235135")) {
                ipChange.ipc$dispatch("1732235135", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 0) {
                OrderDetailActivity.this.cancelOrderDialog(true);
            } else if (intValue == 1) {
                OrderDetailActivity.this.gotoPay(true);
            } else if (intValue == 2) {
                OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                mm1.j(orderDetailActivity, orderDetailActivity.mOrderId);
            } else if (intValue == 3) {
                OrderDetailActivity orderDetailActivity2 = OrderDetailActivity.this;
                mm1.d(orderDetailActivity2, orderDetailActivity2.mOrderId, true);
            } else if (intValue == 4) {
                mm1.c = false;
                mm1.i(OrderDetailActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    public class l implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1498162415")) {
                ipChange.ipc$dispatch("1498162415", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            OrderDetailActivity.this.requestCancelOrder();
        }
    }

    /* compiled from: Taobao */
    public class m implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1827223858")) {
                ipChange.ipc$dispatch("-1827223858", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            OrderDetailActivity.this.requestOrderDetail(true);
        }
    }

    /* compiled from: Taobao */
    public class n implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-857642835")) {
                ipChange.ipc$dispatch("-857642835", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            OrderDetailActivity.this.requestOrderDetail(true);
        }
    }

    /* compiled from: Taobao */
    public class o extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1408077804")) {
                ipChange.ipc$dispatch("1408077804", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i == 1 && OrderDetailActivity.this.mOrderDetailBean != null && OrderDetailActivity.this.mOrderDetailBean.statusInfo != null && OrderDetailActivity.this.mOrderDetailBean.statusInfo.headProgress != null && OrderDetailActivity.this.mOrderDetailBean.id.equals(OrderDetailActivity.this.mOrderId)) {
                    long j = (OrderDetailActivity.this.mOrderDetailBean.statusInfo.headProgress.chooseSeatTime - OrderDetailActivity.this.mOrderDetailBean.currentTime) / 1000;
                    if (j / 86400 <= 0) {
                        int[] b = mm1.b(j);
                        if (b.length == 3) {
                            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                            orderDetailActivity.updateTimerShow(orderDetailActivity.mOrderDetailBean.statusInfo.headProgress.countDownDescPrefix, (long) b[0], (long) b[1], (long) b[2], OrderDetailActivity.this.mOrderDetailBean.statusInfo.headProgress.countDownDescSuffix);
                        }
                    }
                    OrderDetailActivity.this.mOrderDetailBean.currentTime += 1000;
                    if (j <= 0) {
                        OrderDetailActivity.this.requestOrderDetail(true);
                    }
                }
            } else if (OrderDetailActivity.this.mOrderDetailBean != null && OrderDetailActivity.this.mOrderDetailBean.id.equals(OrderDetailActivity.this.mOrderId)) {
                int[] b2 = mm1.b(OrderDetailActivity.this.mOrderDetailBean.overdueTime);
                if (b2.length == 3) {
                    OrderDetailActivity.this.updateTimerShow((OrderDetailActivity.this.mOrderDetailBean == null || OrderDetailActivity.this.mOrderDetailBean.statusInfo == null) ? "" : OrderDetailActivity.this.mOrderDetailBean.statusInfo.statusMessage, (long) b2[0], (long) b2[1], (long) b2[2], "");
                    OrderDetailActivity.this.mOrderDetailBean.overdueTime--;
                    if (OrderDetailActivity.this.mOrderDetailBean.overdueTime <= -1) {
                        OrderDetailActivity.this.requestOrderDetail(true);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class p implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TextView a;

        p(TextView textView) {
            this.a = textView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1618725967")) {
                ipChange.ipc$dispatch("1618725967", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            if (i < 0) {
                OrderDetailActivity.this.mRefreshView.setPullToRefreshEnabled(false);
            } else {
                OrderDetailActivity.this.mRefreshView.setPullToRefreshEnabled(true);
            }
            int height = appBarLayout.getHeight();
            OrderDetailActivity.this.markAppNotifyHeight = false;
            if (OrderDetailActivity.this.visAppNotify && !OrderDetailActivity.this.markAppNotifyHeight) {
                OrderDetailActivity.this.markAppNotifyHeight = true;
                int a2 = n42.a(OrderDetailActivity.this, 36.0f);
                if (height > a2) {
                    height -= a2;
                }
            }
            OrderDetailActivity.this.alpha = (Math.abs(i) * 255) / height;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            if (orderDetailActivity.alpha > 126) {
                this.a.setText(orderDetailActivity.mHeadOrderStateContent);
            } else {
                this.a.setText("订单详情");
            }
            OrderDetailActivity orderDetailActivity2 = OrderDetailActivity.this;
            OrderDetailActivity.access$012(orderDetailActivity2, i - orderDetailActivity2.verticalOffsetOld);
            OrderDetailActivity.this.verticalOffsetOld = i;
            g91.b("OrderDetailRefundView", "showPop verticalOffset= " + i + "  verticalOffsetOld = " + OrderDetailActivity.this.verticalOffsetOld + "  差值 = " + (i - OrderDetailActivity.this.verticalOffsetOld) + "  distance = " + OrderDetailActivity.this.distance);
            OrderDetailActivity orderDetailActivity3 = OrderDetailActivity.this;
            orderDetailActivity3.setRefundPopLayoutParam(orderDetailActivity3.distance);
        }
    }

    /* compiled from: Taobao */
    public class q implements PullToRefreshHeaderView.PullToRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        q() {
        }

        @Override // cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView.PullToRefreshListener
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "164685917")) {
                ipChange.ipc$dispatch("164685917", new Object[]{this});
            }
        }

        @Override // cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView.PullToRefreshListener
        public void onMove(boolean z, boolean z2, int i, boolean z3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2031316854")) {
                ipChange.ipc$dispatch("2031316854", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3)});
                return;
            }
            g91.b("OrderDetailRefundView", "onMove moved= ");
            OrderDetailActivity.this.hideRefundView();
        }
    }

    /* compiled from: Taobao */
    public class r implements LinearPullToRefreshView.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        r() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1532828744")) {
                ipChange.ipc$dispatch("-1532828744", new Object[]{this});
                return;
            }
            OrderDetailActivity.this.hideRefundView();
            OrderDetailActivity.this.requestOrderDetail(false);
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.LinearPullToRefreshView.OnRefreshListener
        public void pullEventMove(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-292901874")) {
                ipChange.ipc$dispatch("-292901874", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (i == 2) {
                OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                OrderDetailActivity.access$020(orderDetailActivity, i2 - orderDetailActivity.pullOffsetOld);
                OrderDetailActivity.this.pullOffsetOld = i2;
                g91.b("OrderDetailRefundView", "pullEvent height= " + i2 + "  distance= " + OrderDetailActivity.this.distance);
                OrderDetailActivity orderDetailActivity2 = OrderDetailActivity.this;
                orderDetailActivity2.setRefundPopLayoutParam(orderDetailActivity2.distance);
            } else if (i == 1) {
                OrderDetailActivity.this.hideRefundView();
            }
        }
    }

    /* compiled from: Taobao */
    public class s implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        s() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1499181448")) {
                ipChange.ipc$dispatch("1499181448", new Object[]{this, view});
                return;
            }
            OrderDetailActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class t implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        t() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-684495479")) {
                ipChange.ipc$dispatch("-684495479", new Object[]{this, view});
                return;
            }
            OrderDetailActivity.this.disMissNoticeFragment();
        }
    }

    /* compiled from: Taobao */
    public class u implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        u() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1426794890")) {
                ipChange.ipc$dispatch("1426794890", new Object[]{this, view});
                return;
            }
            OrderDetailActivity.this.disMissNoticeFragment();
        }
    }

    /* compiled from: Taobao */
    public class v implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-756882037")) {
                ipChange.ipc$dispatch("-756882037", new Object[]{this, view});
                return;
            }
            OrderDetailActivity.this.cancelOrderDialog(false);
        }
    }

    /* compiled from: Taobao */
    public class w implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        w() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1354408332")) {
                ipChange.ipc$dispatch("1354408332", new Object[]{this, view});
                return;
            }
            OrderDetailActivity.this.gotoPay(false);
        }
    }

    static /* synthetic */ int access$012(OrderDetailActivity orderDetailActivity, int i2) {
        int i3 = orderDetailActivity.distance + i2;
        orderDetailActivity.distance = i3;
        return i3;
    }

    static /* synthetic */ int access$020(OrderDetailActivity orderDetailActivity, int i2) {
        int i3 = orderDetailActivity.distance - i2;
        orderDetailActivity.distance = i3;
        return i3;
    }

    private void addHeaderView(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201874770")) {
            ipChange.ipc$dispatch("1201874770", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        View inflate = this.mInflater.inflate(R$layout.order_detail_button_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_button);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_button);
        if (i2 == 3) {
            linearLayout.setBackgroundResource(R$drawable.bg_order_head_btn);
            inflate.findViewById(R$id.icon_button).setVisibility(8);
            textView.setText("查看物流");
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_white));
        } else if (i2 == 2) {
            linearLayout.setBackgroundResource(R$drawable.bg_order_head_pay);
            inflate.findViewById(R$id.icon_button).setVisibility(0);
            textView.setText("查看票夹");
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_FF2869));
        } else if (i2 == 4) {
            linearLayout.setBackgroundResource(R$drawable.bg_order_head_btn);
            inflate.findViewById(R$id.icon_button).setVisibility(8);
            textView.setText("修改配送地址");
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_white));
        }
        this.mBtnHeaderContainer.addView(inflate);
        if (this.mBtnHeaderContainer.getVisibility() != 0) {
            this.mBtnHeaderContainer.setVisibility(0);
        }
        inflate.setTag(Integer.valueOf(i2));
        inflate.setOnClickListener(this.mButtonListener);
    }

    private void backOrderListPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564091632")) {
            ipChange.ipc$dispatch("1564091632", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("refresh", this.isNeedRefreshList);
        setResult(-1, intent);
        finish();
    }

    private void backUpHeadButtonView(OrderDetailButtonBean orderDetailButtonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215631686")) {
            ipChange.ipc$dispatch("-215631686", new Object[]{this, orderDetailButtonBean, Boolean.valueOf(z)});
        } else if (orderDetailButtonBean != null) {
            if (orderDetailButtonBean.logisticsButton) {
                addHeaderView(3);
            }
            if (orderDetailButtonBean.elTicketButton) {
                addHeaderView(2);
            }
            if (z) {
                addHeaderView(4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cancelOrderDialog(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186943188")) {
            ipChange.ipc$dispatch("-1186943188", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        cn.damai.common.user.c.e().x(ln2.r().x(this.mProjectId, this.mOrderId, z));
        DMDialog dMDialog = new DMDialog(this);
        this.mCancelOrderDialog = dMDialog;
        dMDialog.v("取消订单");
        this.mCancelOrderDialog.q("订单取消后将自动关闭，确定取消?");
        this.mCancelOrderDialog.i("取消", null);
        this.mCancelOrderDialog.n("确定", new l());
        this.mCancelOrderDialog.show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void disMissNoticeFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083251762")) {
            ipChange.ipc$dispatch("2083251762", new Object[]{this});
        } else if (!isFinishing() && this.detailFragment.isVisible()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.detailFragment);
            beginTransaction.commitAllowingStateLoss();
            int i2 = R$id.trade_project_detail_popup_layer_container_flv;
            findViewById(i2).setVisibility(8);
            findViewById(i2).setOnClickListener(null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void disTicketServiceFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-455880933")) {
            ipChange.ipc$dispatch("-455880933", new Object[]{this});
        } else if (this.ticketServiceFragment != null) {
            cn.damai.common.user.c.e().x(ln2.r().k1(this.mProjectId, this.mOrderId));
            this.ticketServiceFragment.dismissAllowingStateLoss();
            this.ticketServiceFragment = null;
        }
    }

    private void dissDialogFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631249559")) {
            ipChange.ipc$dispatch("-631249559", new Object[]{this});
            return;
        }
        OrderDetailPayFragment orderDetailPayFragment = this.dialogFragment;
        if (orderDetailPayFragment != null) {
            orderDetailPayFragment.dismissAllowingStateLoss();
            this.dialogFragment = null;
        }
        disTicketServiceFragment();
    }

    private boolean fillButtonView(OrderDetailButtonBean orderDetailButtonBean, boolean z) {
        boolean z2;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1808618529")) {
            return ((Boolean) ipChange.ipc$dispatch("-1808618529", new Object[]{this, orderDetailButtonBean, Boolean.valueOf(z)})).booleanValue();
        } else if (orderDetailButtonBean == null) {
            setBottomBtnVis(false);
            return false;
        } else {
            this.mBottomBtnContainer.removeAllViews();
            if (orderDetailButtonBean.cancelButton) {
                updateBottomButtonView(0, false);
                z2 = true;
            } else {
                z2 = false;
            }
            if (orderDetailButtonBean.goPayButton) {
                updateBottomButtonView(1, true);
                z2 = true;
            }
            if (orderDetailButtonBean.logisticsButton) {
                updateBottomButtonView(3, false);
                z2 = true;
            }
            if (orderDetailButtonBean.elTicketButton) {
                updateBottomButtonView(2, false);
                z2 = true;
            }
            if (z) {
                updateBottomButtonView(4, false);
            } else {
                z3 = z2;
            }
            setBottomBtnVis(z3);
            return z3;
        }
    }

    private void fillHeadButtonView(OrderDetailProgress orderDetailProgress) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "742758862")) {
            ipChange.ipc$dispatch("742758862", new Object[]{this, orderDetailProgress});
        } else if (orderDetailProgress != null) {
            int e2 = xf2.e(orderDetailProgress.buttonList);
            for (int i3 = 0; i3 < e2; i3++) {
                OrderDetailProgressBtn orderDetailProgressBtn = orderDetailProgress.buttonList.get(i3);
                if (orderDetailProgressBtn != null) {
                    View inflate = this.mInflater.inflate(R$layout.order_detail_button_item, (ViewGroup) null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_button);
                    DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) inflate.findViewById(R$id.icon_button);
                    dMIconFontTextView.setVisibility(8);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_button);
                    textView.setText(orderDetailProgressBtn.buttonName);
                    int i4 = orderDetailProgressBtn.buttonType;
                    if (i4 == 4) {
                        linearLayout.setBackgroundResource(R$drawable.bg_order_head_pay);
                        textView.setTextColor(ContextCompat.getColor(this, R$color.color_FF2869));
                    } else if (i4 == 5) {
                        dMIconFontTextView.setVisibility(0);
                        linearLayout.setBackgroundResource(R$drawable.bg_order_head_pay);
                        textView.setTextColor(ContextCompat.getColor(this, R$color.color_FF2869));
                    } else {
                        linearLayout.setBackgroundResource(R$drawable.bg_order_head_btn);
                        textView.setTextColor(ContextCompat.getColor(this, R$color.color_white));
                    }
                    this.mBtnHeaderContainer.addView(inflate);
                    linearLayout.setOnClickListener(new c(orderDetailProgressBtn, orderDetailProgress));
                }
            }
            LinearLayout linearLayout2 = this.mBtnHeaderContainer;
            if (e2 <= 0) {
                i2 = 8;
            }
            linearLayout2.setVisibility(i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoPay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037040341")) {
            ipChange.ipc$dispatch("2037040341", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        OrderDetailBean orderDetailBean = this.mOrderDetailBean;
        int e2 = orderDetailBean != null ? xf2.e(orderDetailBean.paymentInfoList) : 0;
        if (e2 == 0) {
            cn.damai.common.user.c.e().x(ln2.r().B(this.mProjectId, this.mOrderId, z));
            OrderDetailBean orderDetailBean2 = this.mOrderDetailBean;
            String str = (orderDetailBean2 == null || TextUtils.isEmpty(orderDetailBean2.dialogTips)) ? "当前订单不支持此渠道支付，请前往下单渠道完成支付" : this.mOrderDetailBean.dialogTips;
            DMDialog dMDialog = new DMDialog(this);
            dMDialog.q(str);
            dMDialog.n("我知道了", new i(this));
            dMDialog.show();
        } else if (e2 == 1) {
            OrderDetailPayInfo orderDetailPayInfo = this.mOrderDetailBean.paymentInfoList.get(0);
            cn.damai.common.user.c.e().x(ln2.r().z(this.mProjectId, this.mOrderId, orderDetailPayInfo.payName, z));
            requestOrderPay(orderDetailPayInfo.payCode, orderDetailPayInfo.paymentInfoExt, orderDetailPayInfo.payTypeId);
        } else {
            cn.damai.common.user.c.e().x(ln2.r().D(this.mProjectId, this.mOrderId, z));
            Intent intent = new Intent();
            intent.putExtra("payList", (ArrayList) this.mOrderDetailBean.paymentInfoList);
            intent.putExtra("isHouNiaoOrder", this.isHouNiaoOrder);
            intent.putExtra("amount", this.mOrderDetailBean.pricesInfo.displayAmount);
            intent.putExtra("orderId", this.mOrderId);
            intent.putExtra("projectId", this.mProjectId);
            intent.putExtra("isSeat", this.isSeatProject);
            if (this.dialogFragment == null) {
                OrderDetailPayFragment orderDetailPayFragment = new OrderDetailPayFragment();
                this.dialogFragment = orderDetailPayFragment;
                orderDetailPayFragment.l(this, intent);
            }
            try {
                if (!this.dialogFragment.isAdded()) {
                    this.dialogFragment.a(getFragmentManager());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @RequiresApi(api = 12)
    private void handleIntent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442207906")) {
            ipChange.ipc$dispatch("442207906", new Object[]{this});
        } else if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
                    this.mOrderId = extras.getString(DamaiConstants.PUSH_MSG_SUMMARY);
                    this.mFromPage = 2;
                } else if (extras.containsKey("backPage")) {
                    this.mOrderId = extras.getString("orderId", "");
                    this.mFromPage = 3;
                } else {
                    this.mOrderId = extras.getString("orderId", "");
                    this.mFromPage = 0;
                    if (extras.containsKey(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE)) {
                        if (extras.getString(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, "false").equals("true")) {
                            this.mFromPage = 1;
                        } else if (extras.getBoolean(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, false)) {
                            this.mFromPage = 1;
                        }
                    }
                    if (extras.containsKey("payResult")) {
                        mm1.b = extras.getBoolean("payResult", false);
                        mm1.a = this.mOrderId;
                    }
                }
            }
            if (xf2.j(this.mOrderId)) {
                finish();
                return;
            }
            this.mCheckModifyResult = false;
            this.mCheckAddInvoice = false;
        }
    }

    private void hideBaseTitleLayout(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805023871")) {
            ipChange.ipc$dispatch("805023871", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            hideBaseLayout();
        } else {
            this.bese_head_view.setVisibility(0);
            setTitleContent("订单详情");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideRefundView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909086137")) {
            ipChange.ipc$dispatch("-909086137", new Object[]{this});
            return;
        }
        this.llRefundPop.setVisibility(8);
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    private void initAppBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246426716")) {
            ipChange.ipc$dispatch("-1246426716", new Object[]{this});
            return;
        }
        ((AppBarLayout) findViewById(R$id.appbar_layout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new p((TextView) findViewById(R$id.tv_title_name)));
        this.mRefreshView.getHeaderLayout().setPullToRefreshListener(new q());
        this.mRefreshView.setOnRefreshListener(new r());
        findViewById(R$id.tv_goback).setOnClickListener(new s());
    }

    private void initHeadView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105264929")) {
            ipChange.ipc$dispatch("2105264929", new Object[]{this, view});
            return;
        }
        this.mTvHeadOrderState = (TextView) view.findViewById(R$id.tv_order_state);
        this.mTvHeadOrderStateDesc = (TextView) view.findViewById(R$id.tv_order_state_des);
        this.mIconHeadProgress = (DMIconFontTextView) view.findViewById(R$id.icon_progress);
        this.mTvHeadFirstPayNum = (TextView) view.findViewById(R$id.tv_pay_after_num);
        this.mTvHeadPayTip = (TextView) view.findViewById(R$id.tv_pay_tip);
        this.mBtnHeaderContainer = (LinearLayout) view.findViewById(R$id.ll_order_head_button);
        initHeadViewHide();
        initNoticeView(view);
    }

    private void initHeadViewHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957812079")) {
            ipChange.ipc$dispatch("1957812079", new Object[]{this});
            return;
        }
        this.mParHeadBar.setClickable(false);
        this.mIconHeadProgress.setVisibility(8);
        this.mTvHeadOrderStateDesc.setVisibility(8);
        this.mTvHeadFirstPayNum.setVisibility(8);
        this.mTvHeadPayTip.setVisibility(8);
        this.mBtnHeaderContainer.setVisibility(8);
        this.mBtnHeaderContainer.removeAllViews();
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62189127")) {
            ipChange.ipc$dispatch("62189127", new Object[]{this});
            return;
        }
        this.mRecyclerView = (RecyclerView) findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(this.mContext, this.mDataHolderList);
        this.mAdapter = orderDetailAdapter;
        this.mRecyclerView.setAdapter(orderDetailAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1422633328")) {
                    ipChange.ipc$dispatch("-1422633328", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2066874481")) {
                    ipChange.ipc$dispatch("-2066874481", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                OrderDetailActivity.access$020(OrderDetailActivity.this, i2);
                g91.b("OrderDetailRefundView", "showPop dy= " + i2 + "  distance = " + OrderDetailActivity.this.distance);
                OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                orderDetailActivity.setRefundPopLayoutParam(orderDetailActivity.distance);
            }
        });
    }

    private void initNoticeView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352365479")) {
            ipChange.ipc$dispatch("-1352365479", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.ll_notice);
        this.mNoticeView = findViewById;
        this.mNoticeContentTv = (NoticeEllipsisTextView) findViewById.findViewById(R$id.project_header_notice_content);
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067801132")) {
            ipChange.ipc$dispatch("-2067801132", new Object[]{this});
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isXiaoYuAppInstalled(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449895332")) {
            return ((Boolean) ipChange.ipc$dispatch("1449895332", new Object[]{this, context})).booleanValue();
        }
        try {
            return context.getPackageManager().getPackageInfo("com.taobao.idlefish", 64) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void jumpXianyuApp(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559275851")) {
            ipChange.ipc$dispatch("-1559275851", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse("fleamarket://webview?decode=true&url=" + mm1.m(str));
                if (parse != null) {
                    Intent intent = new Intent();
                    intent.setData(parse);
                    intent.setFlags(268435456);
                    startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void loadHeaderStateInfo(OrderDetailStatusBean orderDetailStatusBean, long j2, long j3, String str, String str2, String str3, String str4, OrderDetailButtonBean orderDetailButtonBean, boolean z) {
        boolean z2;
        boolean z3;
        String str5;
        IpChange ipChange = $ipChange;
        boolean z4 = true;
        if (AndroidInstantRuntime.support(ipChange, "-338470054")) {
            ipChange.ipc$dispatch("-338470054", new Object[]{this, orderDetailStatusBean, Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, str4, orderDetailButtonBean, Boolean.valueOf(z)});
        } else if (orderDetailStatusBean != null) {
            mm1.c = false;
            initHeadViewHide();
            String str6 = orderDetailStatusBean.orderStatusStr;
            this.mHeadOrderStateContent = str6;
            if (orderDetailButtonBean != null) {
                z3 = orderDetailButtonBean.goPayButton;
                z2 = orderDetailButtonBean.cancelButton;
            } else {
                z3 = false;
                z2 = false;
            }
            if (!z3) {
                this.mTvHeadOrderState.setText(str6);
            } else {
                TextView textView = this.mTvHeadOrderState;
                textView.setText(orderDetailStatusBean.orderStatusStr + " ¥" + str4);
            }
            updateOrderStateMessage(orderDetailStatusBean.statusMessage);
            updatePaymentInfoTips(str);
            updateAppNotify(str2, str3);
            if (mm1.b && orderDetailStatusBean.payStatus < 2 && (str5 = mm1.a) != null && str5.equals(this.mOrderId)) {
                updateOrderStateMessage("支付结果处理中，请稍后刷新查看…");
                z4 = false;
            } else if (orderDetailStatusBean.orderStatus != 1 || j2 <= 0) {
                mm1.c = true;
                OrderDetailProgress orderDetailProgress = orderDetailStatusBean.headProgress;
                if (orderDetailProgress != null) {
                    updateOrderProgress(orderDetailProgress, j3, orderDetailStatusBean.orderStatusStr);
                } else if (orderDetailButtonBean != null) {
                    backUpHeadButtonView(orderDetailButtonBean, z);
                }
            } else {
                mm1.c = true;
                startTimer(0);
            }
            if (z2) {
                updateHeaderCanncelButton();
            }
            if (z3) {
                updateHeaderPayButton(z4);
            }
        }
    }

    private void orderDetailCancelXflush(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1867765197")) {
            ipChange.ipc$dispatch("-1867765197", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str) || !"FCADE0002".equals(str)) {
            z = true;
        }
        if (z) {
            an1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_CANCEL_ORDER, str, str2, this.mOrderId, "订单取消按钮接口失败");
        }
    }

    private void registerRefundPopWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410559646")) {
            ipChange.ipc$dispatch("410559646", new Object[]{this});
            return;
        }
        this.mDMMessage.b(REFUND_POPWINDPW, new Action<OrderDetailRefundPopWindowBean>() {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity.AnonymousClass26 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: a */
            public void call(OrderDetailRefundPopWindowBean orderDetailRefundPopWindowBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-660641582")) {
                    ipChange.ipc$dispatch("-660641582", new Object[]{this, orderDetailRefundPopWindowBean});
                } else if (orderDetailRefundPopWindowBean != null) {
                    OrderDetailActivity.this.llRefundPop.setVisibility(0);
                    OrderDetailActivity.this.tvRefundPop.setText(orderDetailRefundPopWindowBean.content);
                    OrderDetailActivity.this.distance = orderDetailRefundPopWindowBean.ylocation;
                    OrderDetailActivity.this.setRefundPopLayoutParam(orderDetailRefundPopWindowBean.ylocation);
                    if (OrderDetailActivity.this.handler == null) {
                        OrderDetailActivity.this.handler = new Handler();
                    }
                    OrderDetailActivity.this.handler.postDelayed(new Runnable() {
                        /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity.AnonymousClass26.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "290068126")) {
                                ipChange.ipc$dispatch("290068126", new Object[]{this});
                                return;
                            }
                            OrderDetailActivity.this.hideRefundView();
                        }
                    }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestCancelOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681661887")) {
            ipChange.ipc$dispatch("-681661887", new Object[]{this});
            return;
        }
        showLoading("");
        ((OrderDetailPresenter) this.mPresenter).cancelOrderDetail(this.mOrderId);
    }

    private void requestOrderPay(String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007370028")) {
            ipChange.ipc$dispatch("-2007370028", new Object[]{this, str, str2, Integer.valueOf(i2)});
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.i("你当前没有选择支付方式");
        } else if (!this.RequestOrderPaying) {
            showLoading("");
            this.RequestOrderPaying = true;
            if (this.isHouNiaoOrder) {
                ((OrderDetailPresenter) this.mPresenter).orderDetailPay(this.mOrderId, str, str2, i2);
            } else {
                ((OrderDetailPresenter) this.mPresenter).orderWolfDetailPay(this.mOrderId, str);
            }
        }
    }

    private void setAddInvoiceErrorTipDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289326683")) {
            ipChange.ipc$dispatch("-289326683", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            DMDialog dMDialog = new DMDialog(this);
            this.mAddInvoiceDialog = dMDialog;
            dMDialog.v("温馨提示");
            this.mAddInvoiceDialog.q(str);
            this.mAddInvoiceDialog.n("我知道了", new n());
            this.mAddInvoiceDialog.show();
        }
    }

    private void setBottomBtnVis(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160620865")) {
            ipChange.ipc$dispatch("160620865", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mBottomBtnContainer.setVisibility(0);
            this.mBottomLineView.setVisibility(0);
        } else {
            this.mBottomBtnContainer.setVisibility(8);
            this.mBottomLineView.setVisibility(8);
        }
    }

    private void setErrorTipDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736016687")) {
            ipChange.ipc$dispatch("-1736016687", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            DMDialog dMDialog = new DMDialog(this);
            this.mOrderAddressDialog = dMDialog;
            dMDialog.v("温馨提示");
            this.mOrderAddressDialog.q(str);
            this.mOrderAddressDialog.n("我知道了", new m());
            this.mOrderAddressDialog.show();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRefundPopLayoutParam(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91354315")) {
            ipChange.ipc$dispatch("91354315", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.llRefundPop.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.llRefundPop.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
            this.llRefundPop.setLayoutParams(layoutParams);
        }
    }

    private void showTicketServiceFragment(ArrayList<OrderDetailTicketService> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758451678")) {
            ipChange.ipc$dispatch("-758451678", new Object[]{this, arrayList});
            return;
        }
        List<ServiceNote> a2 = mm1.a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (!f92.d(a2)) {
            arrayList2.addAll(a2);
        }
        if (!f92.d(arrayList2)) {
            if (this.ticketServiceFragment == null) {
                ou1 c2 = ou1.c(arrayList2);
                this.ticketServiceFragment = c2;
                c2.d(new j());
            }
            if (!this.ticketServiceFragment.isAdded()) {
                cn.damai.common.user.c.e().x(ln2.r().n1(this.mProjectId, this.mOrderId));
                this.ticketServiceFragment.e(getFragmentManager());
            }
        }
    }

    private void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47108799")) {
            ipChange.ipc$dispatch("-47108799", new Object[]{this});
            return;
        }
        Timer timer = this.mTimer;
        if (timer != null && this.mTimerTask != null) {
            timer.cancel();
            this.mTimerTask.cancel();
            this.mTimer = null;
            this.mTimerTask = null;
        }
    }

    private void updateAppNotify(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566927561")) {
            ipChange.ipc$dispatch("-566927561", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str)) {
            this.visAppNotify = false;
            this.mNoticeView.setVisibility(8);
            this.mNoticeView.setOnClickListener(null);
        } else {
            this.visAppNotify = true;
            this.mNoticeContentTv.setText(str);
            this.mNoticeView.setVisibility(0);
            this.mNoticeView.setOnClickListener(new a(str, str2));
        }
    }

    private void updateBottomButtonView(int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278011412")) {
            ipChange.ipc$dispatch("-1278011412", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        View inflate = this.mInflater.inflate(R$layout.order_detail_bottom_button, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_button);
        this.mBottomBtnContainer.addView(inflate);
        if (i2 == 0) {
            textView.setText("取消订单");
        } else if (i2 == 1) {
            textView.setText("立即付款");
        } else if (i2 == 2) {
            textView.setText("查看票夹");
        } else if (i2 == 3) {
            textView.setText("查看物流");
        } else if (i2 == 4) {
            textView.setText("修改配送地址");
        }
        if (z) {
            textView.setBackgroundResource(R$drawable.bg_border_corner_pay);
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_FF2D79));
        } else {
            textView.setBackgroundResource(R$drawable.bg_border_corner_ccc_20);
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_000000));
        }
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this.mButtonListener);
    }

    private void updateHeaderCanncelButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988925276")) {
            ipChange.ipc$dispatch("1988925276", new Object[]{this});
            return;
        }
        View inflate = this.mInflater.inflate(R$layout.order_detail_button_item, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R$id.ll_button)).setBackgroundResource(R$drawable.bg_order_head_btn);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_button);
        textView.setText("取消订单");
        textView.setTextColor(ContextCompat.getColor(this, R$color.color_white));
        inflate.setOnClickListener(new v());
        this.mBtnHeaderContainer.addView(inflate);
        if (this.mBtnHeaderContainer.getVisibility() != 0) {
            this.mBtnHeaderContainer.setVisibility(0);
        }
    }

    private void updateHeaderPayButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141018828")) {
            ipChange.ipc$dispatch("-141018828", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View inflate = this.mInflater.inflate(R$layout.order_detail_button_item, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R$id.ll_button)).setBackgroundResource(R$drawable.bg_order_head_pay);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_button);
        textView.setText("立即付款");
        if (z) {
            textView.setTextColor(ContextCompat.getColor(this, R$color.color_FF2869));
            inflate.setTag(1);
            inflate.setOnClickListener(new w());
        } else {
            textView.setTextColor(ContextCompat.getColor(this, R$color.mask_white_40));
            inflate.setOnClickListener(null);
        }
        this.mBtnHeaderContainer.addView(inflate);
        if (this.mBtnHeaderContainer.getVisibility() != 0) {
            this.mBtnHeaderContainer.setVisibility(0);
        }
    }

    private void updateOrderProgress(OrderDetailProgress orderDetailProgress, long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907490874")) {
            ipChange.ipc$dispatch("1907490874", new Object[]{this, orderDetailProgress, Long.valueOf(j2), str});
        } else if (orderDetailProgress != null) {
            this.mParHeadBar.setClickable(true);
            this.mParHeadBar.setOnClickListener(new b(str, orderDetailProgress));
            if (orderDetailProgress.supportJumpPage()) {
                this.mIconHeadProgress.setVisibility(0);
            }
            if (j2 > 0) {
                long j3 = orderDetailProgress.chooseSeatTime;
                if (j3 > 0 && j3 > j2) {
                    long j4 = (j3 - j2) / 1000;
                    if (j4 < 86400) {
                        int[] b2 = mm1.b(j4);
                        if (b2.length == 3) {
                            updateTimerShow(orderDetailProgress.countDownDescPrefix, (long) b2[0], (long) b2[1], (long) b2[2], orderDetailProgress.countDownDescSuffix);
                        }
                        startTimer(1);
                    }
                }
            }
            if (!TextUtils.isEmpty(orderDetailProgress.rowNoDesc) && !TextUtils.isEmpty(orderDetailProgress.rowNo)) {
                TextView textView = this.mTvHeadFirstPayNum;
                textView.setText(orderDetailProgress.rowNoDesc + orderDetailProgress.rowNo);
                this.mTvHeadFirstPayNum.setVisibility(0);
            }
            fillHeadButtonView(orderDetailProgress);
        }
    }

    private void updateOrderStateMessage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082705683")) {
            ipChange.ipc$dispatch("1082705683", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mTvHeadOrderStateDesc.setText(str);
            if (this.mTvHeadOrderStateDesc.getVisibility() != 0) {
                this.mTvHeadOrderStateDesc.setVisibility(0);
            }
        }
    }

    private void updatePaymentInfoTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "779360651")) {
            ipChange.ipc$dispatch("779360651", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.mTvHeadPayTip.setVisibility(8);
        } else {
            this.mTvHeadPayTip.setText(str);
            this.mTvHeadPayTip.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447817298")) {
            ipChange.ipc$dispatch("-447817298", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 10003 || i2 == 10001) {
            onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-346832004")) {
            return R$layout.activity_hn_order_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-346832004", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271111039")) {
            ipChange.ipc$dispatch("271111039", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        requestOrderDetail(true);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185368716")) {
            ipChange.ipc$dispatch("1185368716", new Object[]{this});
            return;
        }
        ((OrderDetailPresenter) this.mPresenter).setVM(this, (OrderDetailContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586146159")) {
            ipChange.ipc$dispatch("-1586146159", new Object[]{this});
            return;
        }
        this.mInflater = LayoutInflater.from(this);
        LinearPullToRefreshView linearPullToRefreshView = (LinearPullToRefreshView) findViewById(R$id.lin_refresh_layout);
        this.mRefreshView = linearPullToRefreshView;
        linearPullToRefreshView.setVisibility(8);
        this.mBottomBtnContainer = (LinearLayout) findViewById(R$id.ll_button_container);
        this.mBottomLineView = findViewById(R$id.bottom_line);
        this.llRefundPop = (LinearLayout) findViewById(R$id.trade_detail_ll_pop);
        this.tvRefundPop = (TextView) findViewById(R$id.trade_detail_pop_tip_content);
        this.mParHeadBar = (LinearLayout) findViewById(R$id.head_bar);
        initStateBar();
        initIRecycleView();
        initAppBar();
        initHeadView(this.mParHeadBar);
    }

    public void jumpCanResellPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374026616")) {
            ipChange.ipc$dispatch("374026616", new Object[]{this, str});
        } else if (!HavanaProxy.v().A()) {
            new DMThemeDialog(this).r(DMThemeDialog.DMDialogTheme.THEME_TAOBAO_LOGIN).o("淘宝授权 登录大麦账号").f(false).i("手机淘宝登录", new g()).g(true, null).show();
        } else {
            HavanaProxy.v().P(this, new h(str));
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void jumpTicketServicePage(ArrayList<OrderDetailTicketService> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930649040")) {
            ipChange.ipc$dispatch("1930649040", new Object[]{this, arrayList});
            return;
        }
        showTicketServiceFragment(arrayList);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean booleanExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904103992")) {
            ipChange.ipc$dispatch("904103992", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2000) {
            if (intent != null && (booleanExtra = intent.getBooleanExtra("payResult", false))) {
                mm1.b = booleanExtra;
                mm1.a = this.mOrderId;
            }
            if (this.mOrderDetailBean != null && !mm1.c) {
                requestOrderDetail(true);
            }
        } else if (i3 != -1) {
        } else {
            if (i2 == 1002) {
                AddressBean addressBean = (AddressBean) intent.getParcelableExtra("added_address");
                if (addressBean != null) {
                    mm1.e(this, this.mOrderId, this.mProjectId, addressBean.getAddressId());
                }
            } else if (i2 == 1001) {
                this.mCheckModifyResult = true;
                if (!mm1.c) {
                    requestOrderDetail(true);
                }
            } else if (i2 == 1005) {
                this.mCheckAddInvoice = true;
                if (!mm1.c) {
                    requestOrderDetail(true);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542908328")) {
            ipChange.ipc$dispatch("1542908328", new Object[]{this});
            return;
        }
        dissDialogFragment();
        NoticeDetailFragment noticeDetailFragment = this.detailFragment;
        if (noticeDetailFragment == null || !noticeDetailFragment.isVisible()) {
            int i2 = this.mFromPage;
            if (i2 == 0) {
                backOrderListPage();
            } else if (i2 == 1) {
                DMNav.from(this).toUri(NavUri.b(gr.f));
                finish();
            } else if (i2 == 2) {
                DMNav.from(this).toUri(NavUri.b(gr.n));
                finish();
            } else if (i2 != 3) {
                backOrderListPage();
            } else {
                finish();
            }
        } else {
            disMissNoticeFragment();
        }
    }

    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257067827")) {
            ipChange.ipc$dispatch("1257067827", new Object[]{this, bundle, persistableBundle});
            return;
        }
        super.onCreate(bundle, persistableBundle);
        this.mOrderChooseSeat = new SeatPrepare4Order(this, 0);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586616439")) {
            ipChange.ipc$dispatch("-586616439", new Object[]{this});
            return;
        }
        SeatPrepare4Order seatPrepare4Order = this.mOrderChooseSeat;
        if (seatPrepare4Order != null) {
            seatPrepare4Order.c();
            this.mOrderChooseSeat = null;
        }
        hideRefundView();
        super.onDestroy();
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1329912698")) {
            ipChange.ipc$dispatch("1329912698", new Object[]{this, str, str2, str3});
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = bk2.b(this, R$string.damai_base_net_toast);
        }
        ToastUtil.i(str2);
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989684481")) {
            ipChange.ipc$dispatch("989684481", new Object[]{this});
            return;
        }
        onResponseSuccess(findViewById(R$id.ll_error_page));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960508196")) {
            ipChange.ipc$dispatch("960508196", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent();
        setDamaiUTKeyBuilder(ln2.r().q(this.mOrderId));
        this.mOrderDetailBean = null;
        requestOrderDetail(true);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "332961165")) {
            ipChange.ipc$dispatch("332961165", new Object[]{this});
            return;
        }
        super.onPause();
        stopTimer();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915319270")) {
            ipChange.ipc$dispatch("-915319270", new Object[]{this});
            return;
        }
        super.onResume();
        if (!mm1.c) {
            mm1.c = true;
        } else if (LoginManager.k().q()) {
            requestOrderDetail(true);
        } else if (!this.firstInto) {
            ToastUtil.i("你当前未登录，请先登录");
            onBackPressed();
        } else {
            LoginManager.k().w(this, getIntent());
        }
        this.firstInto = false;
        registerRefundPopWindow();
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void openNoticePop(ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928889515")) {
            ipChange.ipc$dispatch("-1928889515", new Object[]{this, arrayList});
            return;
        }
        NoticeDetailFragment instance = NoticeDetailFragment.instance(arrayList, this.mProjectId + "");
        this.detailFragment = instance;
        instance.setClose(new t());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R$id.trade_project_detail_popup_layer_container_flv;
        beginTransaction.replace(i2, this.detailFragment);
        beginTransaction.commitAllowingStateLoss();
        findViewById(i2).setVisibility(0);
        findViewById(i2).setOnClickListener(new u());
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.mProjectId);
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(ln2.ORDER_DETAL_PAGE, "show", "showchange", hashMap, Boolean.FALSE));
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void refundCheckResult(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "378221201")) {
            ipChange.ipc$dispatch("378221201", new Object[]{this, Boolean.valueOf(z), str, str2});
            return;
        }
        this.requesting = false;
        stopProgressDialog();
        if (z) {
            mm1.k(this, str2);
        } else if (!TextUtils.isEmpty(str)) {
            ToastUtil.i(str);
        } else {
            mm1.k(this, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void requestCanReSellRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406230587")) {
            ipChange.ipc$dispatch("1406230587", new Object[]{this});
        } else if (!this.requesting) {
            startProgressDialog();
            this.requesting = true;
            ((OrderDetailPresenter) this.mPresenter).orderDetailCanResell(this.mOrderId);
        }
    }

    public void requestOrderDetail(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649616766")) {
            ipChange.ipc$dispatch("1649616766", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        dissDialogFragment();
        this.distance = 0;
        this.mOrderDetailRequesting = true;
        if (z) {
            showLoading("");
        }
        stopTimer();
        ((OrderDetailPresenter) this.mPresenter).getOrderDetailData(this.mOrderId, this.mCheckModifyResult, this.mCheckAddInvoice);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void requestRefundCheckRequest(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880356064")) {
            ipChange.ipc$dispatch("-1880356064", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(this.mOrderId) && !this.requesting) {
            startProgressDialog();
            this.requesting = true;
            ((OrderDetailPresenter) this.mPresenter).orderDetailRefundCheck(this.mOrderId, str);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnCanResellData(OrderDetailCanResellBean orderDetailCanResellBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788841517")) {
            ipChange.ipc$dispatch("788841517", new Object[]{this, orderDetailCanResellBean, Boolean.valueOf(z)});
            return;
        }
        this.requesting = false;
        stopProgressDialog();
        if (orderDetailCanResellBean != null) {
            if (!z) {
                if (TextUtils.isEmpty(orderDetailCanResellBean.errorMsg)) {
                    orderDetailCanResellBean.errorMsg = "网络异常，请稍后重试";
                }
                ToastUtil.i(orderDetailCanResellBean.errorMsg);
            } else if (orderDetailCanResellBean.isCanResell()) {
                DMDialog dMDialog = this.mCanResellDialog;
                if (dMDialog == null) {
                    DMDialog dMDialog2 = new DMDialog(this);
                    this.mCanResellDialog = dMDialog2;
                    dMDialog2.v("是否同意并授权票品转卖");
                    View inflate = this.mInflater.inflate(R$layout.order_detail_canresell_content, (ViewGroup) null);
                    inflate.findViewById(R$id.damai_dialog_tip_content).setOnClickListener(new d());
                    CheckBox checkBox = (CheckBox) inflate.findViewById(R$id.order_resell_checkbox);
                    this.mCanResellDialog.u(inflate);
                    this.mCanResellDialog.b(false);
                    this.mCanResellDialog.n("去转卖", new e(checkBox, orderDetailCanResellBean));
                    this.mCanResellDialog.i("不同意", new f(checkBox));
                    this.mCanResellDialog.j(false);
                    this.mCanResellDialog.show();
                    return;
                }
                dMDialog.show();
            } else {
                ToastUtil.i(orderDetailCanResellBean.errorMsg);
                requestOrderDetail(true);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737846363")) {
            ipChange.ipc$dispatch("737846363", new Object[]{this});
            return;
        }
        requestOrderDetail(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailCancelFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475301361")) {
            ipChange.ipc$dispatch("1475301361", new Object[]{this, str, str2});
            return;
        }
        orderDetailCancelXflush(str, str2);
        if (str == null || !"MAPIE98096".equals(str)) {
            onNetError(str, str2, "");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "该订单状态已经生效，无法操作取消~";
        }
        ToastUtil.i(str2);
        requestOrderDetail(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailData(OrderDetailBean orderDetailBean) {
        OrderDetailMecItemInfo orderDetailMecItemInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484946774")) {
            ipChange.ipc$dispatch("-1484946774", new Object[]{this, orderDetailBean});
            return;
        }
        hideBaseTitleLayout(true);
        this.mRefreshView.setVisibility(0);
        this.mCheckModifyResult = false;
        this.mCheckAddInvoice = false;
        if (orderDetailBean != null && orderDetailBean.statusInfo != null && orderDetailBean.pricesInfo != null && orderDetailBean.mecItemInfo != null && orderDetailBean.deliveryMethodInfo != null) {
            this.mOrderDetailBean = orderDetailBean;
            this.isHouNiaoOrder = orderDetailBean.isHouNiaoOrder();
            OrderDetailStatusBean orderDetailStatusBean = orderDetailBean.statusInfo;
            OrderDetailMecItemInfo orderDetailMecItemInfo2 = orderDetailBean.mecItemInfo;
            OrderDetailDeliveryInfo orderDetailDeliveryInfo = orderDetailBean.deliveryMethodInfo;
            if (orderDetailMecItemInfo2 != null) {
                this.mProjectId = orderDetailMecItemInfo2.itemId;
                this.mProjectName = orderDetailMecItemInfo2.projectName;
                if (this.mOrderState == -1) {
                    this.mOrderState = orderDetailStatusBean.orderStatus;
                }
                if (TextUtils.isEmpty(this.mOrderStateStr)) {
                    this.mOrderStateStr = orderDetailStatusBean.orderStatusStr;
                }
                boolean z = orderDetailStatusBean.orderStatus != this.mOrderState;
                this.isNeedRefreshList = z;
                if (!z && !TextUtils.isEmpty(orderDetailStatusBean.orderStatusStr)) {
                    this.isNeedRefreshList = !orderDetailStatusBean.orderStatusStr.equals(this.mOrderStateStr);
                }
                boolean z2 = orderDetailDeliveryInfo.deliveryId == 1;
                boolean z3 = z2 ? orderDetailBean.consigneeAddress.modify : false;
                loadHeaderStateInfo(orderDetailStatusBean, orderDetailBean.overdueTime, orderDetailBean.currentTime, orderDetailBean.paymentInfoTips, orderDetailBean.reservedDesc, orderDetailBean.announcementImgUrl, orderDetailBean.pricesInfo.displayAmount, orderDetailBean.buttonList, z3);
                boolean fillButtonView = fillButtonView(orderDetailBean.buttonList, z3);
                this.mDataHolderList.clear();
                if (!TextUtils.isEmpty(orderDetailStatusBean.logisticsDesc) && !TextUtils.isEmpty(orderDetailStatusBean.logisticsTimeStr)) {
                    cm1 cm1 = new cm1(0);
                    cm1.d = orderDetailStatusBean;
                    cm1.b = orderDetailBean.id;
                    this.mDataHolderList.add(cm1);
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                if (z2) {
                    cm1 cm12 = new cm1(1);
                    cm12.s = orderDetailBean.consigneeAddress;
                    this.mDataHolderList.add(cm12);
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                DmPickupAddressBean dmPickupAddressBean = orderDetailBean.dmPickupAddress;
                if (dmPickupAddressBean != null && xf2.e(dmPickupAddressBean.dmPickupAddressEntryList) > 0) {
                    cm1 cm13 = new cm1(2);
                    cm13.t = orderDetailBean.dmPickupAddress;
                    this.mDataHolderList.add(cm13);
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                if (xf2.e(orderDetailBean.ruleContexts) > 0) {
                    cm1 cm14 = new cm1(3);
                    cm14.e = orderDetailBean.ruleContexts;
                    this.mDataHolderList.add(cm14);
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                OrderDetailShareBean orderDetailShareBean = orderDetailBean.orderShareDTO;
                if (orderDetailShareBean == null || !orderDetailShareBean.isShowShare()) {
                    orderDetailMecItemInfo = orderDetailMecItemInfo2;
                } else {
                    OrderDetailShareBean orderDetailShareBean2 = orderDetailBean.orderShareDTO;
                    orderDetailShareBean2.projectId = this.mProjectId;
                    orderDetailShareBean2.projectName = this.mProjectName;
                    orderDetailMecItemInfo = orderDetailMecItemInfo2;
                    orderDetailShareBean2.projectImage = orderDetailMecItemInfo.performImageUrl;
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(orderDetailMecItemInfo.projectCityName)) {
                        sb.append(orderDetailMecItemInfo.projectCityName);
                        sb.append(" | ");
                    }
                    if (!TextUtils.isEmpty(orderDetailMecItemInfo.showTimeStr)) {
                        sb.append(orderDetailMecItemInfo.showTimeStr);
                    }
                    orderDetailShareBean2.cityAndTime = sb.toString();
                    cm1 cm15 = new cm1(12);
                    cm15.f = orderDetailShareBean2;
                    this.mDataHolderList.add(cm15);
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                cm1 cm16 = new cm1(4);
                cm16.b = orderDetailBean.id;
                OrderDetailMecItemInfo orderDetailMecItemInfo3 = orderDetailBean.mecItemInfo;
                cm16.g = orderDetailMecItemInfo3;
                cm16.d = orderDetailStatusBean;
                cm16.G = orderDetailBean.orderSource == 3 && "true".equals(orderDetailMecItemInfo3.isNewItem);
                if (xf2.e(orderDetailMecItemInfo.seatList) > 0) {
                    this.isSeatProject = true;
                } else {
                    this.isSeatProject = false;
                }
                this.imageUrl = orderDetailBean.mecItemInfo.performImageUrl;
                cm16.q = orderDetailBean.amountDetailList;
                PurchaseNotice purchaseNotice = orderDetailBean.purchaseNotice;
                if (purchaseNotice != null) {
                    purchaseNotice.itemId = this.mProjectId;
                    purchaseNotice.orderId = this.mOrderId;
                    cm16.i = purchaseNotice;
                }
                OrderDetailButtonBean orderDetailButtonBean = orderDetailBean.buttonList;
                if (orderDetailButtonBean != null) {
                    cm16.j = orderDetailButtonBean.refundButton;
                    cm16.k = orderDetailButtonBean.refundButtonLink;
                    if (!TextUtils.isEmpty(orderDetailButtonBean.refundButtonDesc)) {
                        cm16.m = orderDetailBean.buttonList.refundButtonDesc;
                    } else {
                        cm16.m = "申请退票";
                    }
                    OrderDetailButtonBean orderDetailButtonBean2 = orderDetailBean.buttonList;
                    cm16.l = orderDetailButtonBean2.refundGuidBubble;
                    cm16.n = orderDetailButtonBean2.checkCanApplyRefund;
                    cm16.o = orderDetailButtonBean2.canResell;
                    cm16.p = orderDetailButtonBean2.resellDetailUrl;
                    this.resellAgreementUrl = orderDetailButtonBean2.resellAgreementUrl;
                }
                this.mDataHolderList.add(cm16);
                cm1 cm17 = new cm1(5);
                cm17.h = orderDetailBean.pricesInfo;
                cm17.q = orderDetailBean.amountDetailList;
                this.mDataHolderList.add(cm17);
                cm1 cm18 = new cm1(6);
                cm18.b = this.mOrderId;
                cm18.r = orderDetailBean.deliveryMethodInfo;
                cm18.s = orderDetailBean.consigneeAddress;
                if (xf2.e(orderDetailBean.audiences) > 0) {
                    cm18.u = orderDetailBean.audiences;
                }
                this.mDataHolderList.add(this.mLineDataHolder);
                this.mDataHolderList.add(cm18);
                cm1 cm19 = new cm1(7);
                cm19.b = this.mOrderId;
                cm19.c = this.mProjectId;
                cm19.E = orderDetailBean.faqItems;
                cm19.F = orderDetailBean.serviceOrderInfo;
                this.mDataHolderList.add(this.mLineDataHolder);
                this.mDataHolderList.add(cm19);
                if (orderDetailBean.statusInfo.invoiceStatus != 0) {
                    cm1 cm110 = new cm1(8);
                    OrderDetailStatusBean orderDetailStatusBean2 = orderDetailBean.statusInfo;
                    cm110.v = orderDetailStatusBean2.invoiceStatus;
                    cm110.w = orderDetailStatusBean2.invoiceStatusStr;
                    cm110.x = orderDetailStatusBean2.invoiceDesc;
                    cm110.b = this.mOrderId;
                    cm110.c = this.mProjectId;
                    this.mDataHolderList.add(this.mLineDataHolder);
                    this.mDataHolderList.add(cm110);
                }
                cm1 cm111 = new cm1(9);
                cm111.b = orderDetailBean.id;
                cm111.y = orderDetailBean.createTimeStr;
                cm111.z = orderDetailBean.payTimeStr;
                cm111.D = orderDetailBean.payWayName;
                cm111.C = orderDetailBean.aliPayTradeNo;
                cm111.A = orderDetailBean.shipmentsTimeStr;
                cm111.B = orderDetailBean.bargainOnTimeStr;
                this.mDataHolderList.add(this.mLineDataHolder);
                this.mDataHolderList.add(cm111);
                cm1 cm112 = new cm1(10);
                cm112.b = orderDetailBean.id;
                cm112.c = this.mProjectId;
                this.mDataHolderList.add(cm112);
                if (fillButtonView) {
                    this.mDataHolderList.add(this.mLineDataHolder);
                }
                OrderDetailAdapter orderDetailAdapter = this.mAdapter;
                if (orderDetailAdapter != null) {
                    orderDetailAdapter.notifyDataSetChanged();
                }
                if (!TextUtils.isEmpty(orderDetailBean.modifyAddressToast)) {
                    setErrorTipDialog(orderDetailBean.modifyAddressToast);
                }
                if (!TextUtils.isEmpty(orderDetailBean.applyInvoiceToast)) {
                    setAddInvoiceErrorTipDialog(orderDetailBean.applyInvoiceToast);
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailFail(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540459989")) {
            ipChange.ipc$dispatch("540459989", new Object[]{this, str, str2, str3});
            return;
        }
        hideBaseTitleLayout(true);
        an1.c(str3, str, str2, this.mOrderId);
        onResponseError(str2, str, str3, findViewById(R$id.ll_error_page), true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailPay(OrderPayDTO orderPayDTO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345290102")) {
            ipChange.ipc$dispatch("1345290102", new Object[]{this, orderPayDTO});
            return;
        }
        this.RequestOrderPaying = false;
        cn.damai.common.user.c.e().A(ln2.r().M(this.mProjectId, this.mOrderId, this.isSeatProject), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
        nm1.b(this, orderPayDTO);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailPayFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720131011")) {
            ipChange.ipc$dispatch("1720131011", new Object[]{this, str, str2});
            return;
        }
        this.RequestOrderPaying = false;
        cn.damai.common.user.c.e().A(ln2.r().K(this.mProjectId, this.mOrderId, str2, this.isSeatProject), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
        an1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_PAY_ORDER, str, str2, this.mOrderId, "订单支付按钮接口失败");
        if (str == null || !"MAPIE98087".equals(str)) {
            onNetError(str, str2, "");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "该订单已经付款，请勿重复支付~";
        }
        ToastUtil.i(str2);
        requestOrderDetail(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.View
    public void returnOrderDetailWolfPay(OrderParmasResult orderParmasResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840173534")) {
            ipChange.ipc$dispatch("-1840173534", new Object[]{this, orderParmasResult});
            return;
        }
        this.RequestOrderPaying = false;
        cn.damai.common.user.c.e().A(ln2.r().M(this.mProjectId, this.mOrderId, this.isSeatProject), ln2.CUSTOM_ORDER, ln2.ORDER_DETAL_PAGE);
        nm1.c(this, orderParmasResult, this.mOrderId);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-151265040")) {
            return getResources().getString(R$string.order_detail);
        }
        return (String) ipChange.ipc$dispatch("-151265040", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41754161")) {
            ipChange.ipc$dispatch("-41754161", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100571445")) {
            ipChange.ipc$dispatch("-2100571445", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598628719")) {
            ipChange.ipc$dispatch("1598628719", new Object[]{this, str});
            return;
        }
        startProgressDialog();
    }

    public void startTimer(final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999727104")) {
            ipChange.ipc$dispatch("-1999727104", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.mTimerTask == null) {
            AnonymousClass25 r2 = new TimerTask() {
                /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity.AnonymousClass25 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-899863380")) {
                        ipChange.ipc$dispatch("-899863380", new Object[]{this});
                        return;
                    }
                    OrderDetailActivity.this.mTimeHandler.sendEmptyMessage(i2);
                }
            };
            this.mTimerTask = r2;
            this.mTimer.schedule(r2, 0, 1000);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772797354")) {
            ipChange.ipc$dispatch("772797354", new Object[]{this});
            return;
        }
        this.mOrderDetailRequesting = false;
        LinearPullToRefreshView linearPullToRefreshView = this.mRefreshView;
        if (linearPullToRefreshView != null) {
            linearPullToRefreshView.onRefreshComplete();
        }
        stopProgressDialog();
    }

    public void updateTimerShow(String str, long j2, long j3, long j4, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409586791")) {
            ipChange.ipc$dispatch("-409586791", new Object[]{this, str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str2});
            return;
        }
        StringBuilder sb = this.mBuilder;
        sb.delete(0, sb.length());
        if (!TextUtils.isEmpty(str)) {
            this.mBuilder.append(str);
        }
        if (j2 > 0) {
            StringBuilder sb2 = this.mBuilder;
            sb2.append(j2 + "时");
        }
        StringBuilder sb3 = this.mBuilder;
        sb3.append(j3 + "分");
        StringBuilder sb4 = this.mBuilder;
        sb4.append(j4 + "秒");
        if (!TextUtils.isEmpty(str2)) {
            this.mBuilder.append(str2);
        }
        updateOrderStateMessage(this.mBuilder.toString());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20522999")) {
            ipChange.ipc$dispatch("-20522999", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        mm1.c = true;
        hideBaseLayout();
        handleIntent();
        setDamaiUTKeyBuilder(ln2.r().q(this.mOrderId));
        cn.damai.common.user.c.e().K(this);
        this.mOrderDetailBean = null;
    }
}
