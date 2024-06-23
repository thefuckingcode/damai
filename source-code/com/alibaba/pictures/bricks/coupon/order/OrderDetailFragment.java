package com.alibaba.pictures.bricks.coupon.order;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ACache;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.bean.CouponRuleBean;
import com.alibaba.pictures.bricks.coupon.fragment.NoticeFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.ButtonStatus;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo;
import com.alibaba.pictures.bricks.coupon.order.request.CouponOrderDetailRequest;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alibaba.pictures.bricks.view.LinearPullToRefreshView;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.JvmField;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.dm1;
import tb.em1;
import tb.fm1;
import tb.gm1;
import tb.hm1;
import tb.im1;
import tb.jm1;
import tb.k21;
import tb.km1;
import tb.lm1;
import tb.ln2;
import tb.m40;
import tb.o81;
import tb.qm1;
import tb.ta0;
import tb.tc;

/* compiled from: Taobao */
public final class OrderDetailFragment extends BricksBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int LOGIN_RESULT = 2001;
    @NotNull
    public static final String ORDER_ID = "orderId";
    @JvmField
    public static boolean isOnResumeRefresh = true;
    @JvmField
    @Nullable
    public static String mPayResultOrderId;
    @JvmField
    public static boolean mPayResultState;
    @Nullable
    private OrderDetailAdapter adapter;
    @Nullable
    private LinearLayout bottonLayout;
    @Nullable
    private TextView cancelOrder;
    @Nullable
    private TextView commentDesTv;
    @Nullable
    private TextView commentTv;
    @Nullable
    private RecyclerView irc;
    @Nullable
    private String itemId;
    @Nullable
    private OrderDetailListener listener;
    @Nullable
    private LinearLayout llTipsContainer;
    @NotNull
    private final StringBuilder mBuilder = new StringBuilder();
    @Nullable
    private OrderDetail mData;
    @Nullable
    private b mTimeHandler;
    @Nullable
    private Timer mTimer;
    @Nullable
    private TimerTask mTimerTask;
    @Nullable
    private String orderId;
    @Nullable
    private DigitTextView payAmountTv;
    @Nullable
    private ConstraintLayout payCardCl;
    @Nullable
    private TextView payDesTv;
    @Nullable
    private TextView payStatusTv;
    @Nullable
    private TextView paySymbolTv;
    @Nullable
    private TextView payTv;
    @Nullable
    private LinearPullToRefreshView refreshView;
    @Nullable
    private View rootView;
    @Nullable
    private NoticeFragment showNoticeFragment;
    @Nullable
    private ImageView tipsIconTv;
    @Nullable
    private TextView tipsTitleTv;
    @Nullable
    private TextView useTv;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final int[] a(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "770541087")) {
                return (int[]) ipChange.ipc$dispatch("770541087", new Object[]{this, Long.valueOf(j)});
            }
            int[] iArr = new int[3];
            if (j >= 3600) {
                iArr[0] = (int) (j / ((long) ACache.TIME_HOUR));
                int i = (int) (j - ((long) (iArr[0] * ACache.TIME_HOUR)));
                iArr[1] = i / 60;
                iArr[2] = i % 60;
            } else {
                iArr[0] = 0;
                long j2 = (long) 60;
                iArr[1] = (int) (j / j2);
                iArr[2] = (int) (j % j2);
            }
            return iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private WeakReference<OrderDetailFragment> a;

        public b(@NotNull WeakReference<OrderDetailFragment> weakReference) {
            k21.i(weakReference, "reference");
            this.a = weakReference;
        }

        public void handleMessage(@NotNull Message message) {
            OrderDetail mData;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1169884601")) {
                ipChange.ipc$dispatch("-1169884601", new Object[]{this, message});
                return;
            }
            k21.i(message, "msg");
            OrderDetailFragment orderDetailFragment = this.a.get();
            if (message.what == 0 && orderDetailFragment != null && (mData = orderDetailFragment.getMData()) != null) {
                CouponOrderInfoBean orderInfoVO = mData.getOrderInfoVO();
                Long l = null;
                if (k21.d(orderInfoVO != null ? orderInfoVO.getOrderId() : null, orderDetailFragment.getOrderId())) {
                    StatusInfo statusInfo = mData.getStatusInfo();
                    Long closeTime = statusInfo != null ? statusInfo.getCloseTime() : null;
                    if (statusInfo != null) {
                        l = statusInfo.getCurrentTime();
                    }
                    if (closeTime != null && l != null) {
                        int[] a2 = OrderDetailFragment.Companion.a(statusInfo.getOverdueTime());
                        String orderTips = statusInfo.getOrderTips();
                        if (a2.length == 3 && orderTips != null) {
                            orderDetailFragment.updateTimerShow(orderTips, a2[0], a2[1], a2[2], "");
                            statusInfo.setOverdueTime(statusInfo.getOverdueTime() - 1);
                            if (statusInfo.getOverdueTime() <= -1) {
                                orderDetailFragment.refresh();
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements OnItemListener<CouponRuleBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailFragment a;

        c(OrderDetailFragment orderDetailFragment) {
            this.a = orderDetailFragment;
        }

        /* access modifiers changed from: private */
        public static final void c(OrderDetailFragment orderDetailFragment, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2033234028")) {
                ipChange.ipc$dispatch("2033234028", new Object[]{orderDetailFragment, view});
                return;
            }
            k21.i(orderDetailFragment, "this$0");
            orderDetailFragment.dismissPopLayer();
        }

        /* renamed from: b */
        public void onItemClick(@NotNull CouponRuleBean couponRuleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1919670194")) {
                ipChange.ipc$dispatch("-1919670194", new Object[]{this, couponRuleBean, Integer.valueOf(i)});
                return;
            }
            k21.i(couponRuleBean, "bean");
            NoticeFragment.a aVar = NoticeFragment.Companion;
            FragmentManager childFragmentManager = this.a.getChildFragmentManager();
            k21.h(childFragmentManager, "childFragmentManager");
            NoticeFragment d = aVar.d(childFragmentManager, R$id.id_container_order_detail, couponRuleBean.getOrderInfo());
            if (d != null) {
                OrderDetailFragment orderDetailFragment = this.a;
                orderDetailFragment.setShowNoticeFragment(d);
                d.setMCloseListener(new km1(orderDetailFragment));
            }
        }

        /* renamed from: d */
        public void onItemExpose(@NotNull View view, @NotNull CouponRuleBean couponRuleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343997086")) {
                ipChange.ipc$dispatch("-343997086", new Object[]{this, view, couponRuleBean, Integer.valueOf(i)});
                return;
            }
            k21.i(view, "itemView");
            k21.i(couponRuleBean, "bean");
        }
    }

    /* compiled from: Taobao */
    public static final class d implements OnItemListener<Notice> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailFragment a;

        d(OrderDetailFragment orderDetailFragment) {
            this.a = orderDetailFragment;
        }

        /* access modifiers changed from: private */
        public static final void c(OrderDetailFragment orderDetailFragment, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-975250963")) {
                ipChange.ipc$dispatch("-975250963", new Object[]{orderDetailFragment, view});
                return;
            }
            k21.i(orderDetailFragment, "this$0");
            orderDetailFragment.dismissPopLayer();
        }

        /* renamed from: b */
        public void onItemClick(@NotNull Notice notice, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1510823385")) {
                ipChange.ipc$dispatch("-1510823385", new Object[]{this, notice, Integer.valueOf(i)});
                return;
            }
            k21.i(notice, "bean");
            NoticeFragment.a aVar = NoticeFragment.Companion;
            FragmentManager childFragmentManager = this.a.getChildFragmentManager();
            k21.h(childFragmentManager, "childFragmentManager");
            NoticeFragment c = aVar.c(childFragmentManager, R$id.id_container_order_detail, notice);
            if (c != null) {
                OrderDetailFragment orderDetailFragment = this.a;
                orderDetailFragment.setShowNoticeFragment(c);
                c.setMCloseListener(new lm1(orderDetailFragment));
            }
        }

        /* renamed from: d */
        public void onItemExpose(@NotNull View view, @NotNull Notice notice, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-905294061")) {
                ipChange.ipc$dispatch("-905294061", new Object[]{this, view, notice, Integer.valueOf(i)});
                return;
            }
            k21.i(view, "itemView");
            k21.i(notice, "bean");
        }
    }

    /* compiled from: Taobao */
    public static final class e implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailFragment a;

        e(OrderDetailFragment orderDetailFragment) {
            this.a = orderDetailFragment;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
            if ((r7 != null && !r7.canScrollVertically(-1)) != false) goto L_0x003f;
         */
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(@Nullable AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "2090090328")) {
                ipChange.ipc$dispatch("2090090328", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            LinearPullToRefreshView refreshView = this.a.getRefreshView();
            if (refreshView != null) {
                if (i == 0) {
                    RecyclerView irc = this.a.getIrc();
                }
                z = false;
                refreshView.setPullToRefreshEnabled(z);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void bottomViewRender(OrderDetail orderDetail, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1269692401")) {
            ipChange.ipc$dispatch("1269692401", new Object[]{this, orderDetail, Boolean.valueOf(z)});
        } else if (z) {
            LinearLayout linearLayout = this.bottonLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            LinearLayout linearLayout2 = this.bottonLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView = this.cancelOrder;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.payTv;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.useTv;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.commentDesTv;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.commentTv;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            String buttonStatus = orderDetail.getButtonStatus();
            if (k21.d(buttonStatus, ButtonStatus.NULL.getStatus())) {
                LinearLayout linearLayout3 = this.bottonLayout;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            } else if (k21.d(buttonStatus, ButtonStatus.GONE.getStatus())) {
                LinearLayout linearLayout4 = this.bottonLayout;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
            } else if (k21.d(buttonStatus, ButtonStatus.CANCEL_PAY.getStatus())) {
                TextView textView6 = this.cancelOrder;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.payTv;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                TextView textView8 = this.cancelOrder;
                if (textView8 != null) {
                    qm1.INSTANCE.b(textView8, getCreate(new TrackInfo()));
                }
                TextView textView9 = this.cancelOrder;
                if (textView9 != null) {
                    textView9.setOnClickListener(new dm1(this, orderDetail));
                }
                TextView textView10 = this.payTv;
                if (textView10 != null) {
                    qm1.INSTANCE.i(textView10, getCreate(new TrackInfo()));
                }
                TextView textView11 = this.payTv;
                if (textView11 != null) {
                    textView11.setOnClickListener(new em1(this, orderDetail));
                }
            } else {
                Resources.Theme theme = null;
                if (k21.d(buttonStatus, ButtonStatus.USE_UN_CLICK.getStatus())) {
                    TextView textView12 = this.useTv;
                    if (textView12 != null) {
                        textView12.setVisibility(0);
                    }
                    TextView textView13 = this.useTv;
                    if (textView13 != null) {
                        Resources resources = getResources();
                        int i = R$drawable.bricks_confirm_pay_bg_unclick;
                        Context context = getContext();
                        if (context != null) {
                            theme = context.getTheme();
                        }
                        textView13.setBackground(ResourcesCompat.getDrawable(resources, i, theme));
                    }
                    TextView textView14 = this.useTv;
                    if (textView14 != null) {
                        textView14.setText("到店使用");
                    }
                    TextView textView15 = this.useTv;
                    if (textView15 != null) {
                        qm1.INSTANCE.u(textView15, getCreate(new TrackInfo()), true);
                    }
                    TextView textView16 = this.useTv;
                    if (textView16 != null) {
                        textView16.setOnClickListener(new im1(orderDetail, this));
                    }
                } else if (k21.d(buttonStatus, ButtonStatus.USE_CLICK.getStatus())) {
                    TextView textView17 = this.useTv;
                    if (textView17 != null) {
                        textView17.setVisibility(0);
                    }
                    TextView textView18 = this.useTv;
                    if (textView18 != null) {
                        Resources resources2 = getResources();
                        int i2 = R$drawable.bricks_confirm_pay_bg;
                        Context context2 = getContext();
                        if (context2 != null) {
                            theme = context2.getTheme();
                        }
                        textView18.setBackground(ResourcesCompat.getDrawable(resources2, i2, theme));
                    }
                    TextView textView19 = this.useTv;
                    if (textView19 != null) {
                        textView19.setText("到店使用");
                    }
                    TextView textView20 = this.useTv;
                    if (textView20 != null) {
                        qm1.INSTANCE.u(textView20, getCreate(new TrackInfo()), true);
                    }
                    TextView textView21 = this.useTv;
                    if (textView21 != null) {
                        textView21.setOnClickListener(new gm1(this, orderDetail));
                    }
                } else if (k21.d(buttonStatus, ButtonStatus.COMMENT.getStatus())) {
                    TextView textView22 = this.commentDesTv;
                    if (textView22 != null) {
                        textView22.setVisibility(0);
                    }
                    TextView textView23 = this.commentTv;
                    if (textView23 != null) {
                        textView23.setVisibility(0);
                    }
                    TextView textView24 = this.commentTv;
                    if (textView24 != null) {
                        qm1.INSTANCE.s(textView24, getCreate(new TrackInfo()));
                    }
                    TextView textView25 = this.commentTv;
                    if (textView25 != null) {
                        textView25.setOnClickListener(new hm1(this, orderDetail));
                    }
                } else if (k21.d(buttonStatus, ButtonStatus.SEE_COMMENT.getStatus())) {
                    TextView textView26 = this.useTv;
                    if (textView26 != null) {
                        textView26.setVisibility(0);
                    }
                    TextView textView27 = this.useTv;
                    if (textView27 != null) {
                        Resources resources3 = getResources();
                        int i3 = R$drawable.bricks_confirm_pay_bg;
                        Context context3 = getContext();
                        if (context3 != null) {
                            theme = context3.getTheme();
                        }
                        textView27.setBackground(ResourcesCompat.getDrawable(resources3, i3, theme));
                    }
                    TextView textView28 = this.useTv;
                    if (textView28 != null) {
                        textView28.setText("看评价");
                    }
                    TextView textView29 = this.useTv;
                    if (textView29 != null) {
                        qm1.INSTANCE.n(textView29, getCreate(new TrackInfo()));
                    }
                    TextView textView30 = this.useTv;
                    if (textView30 != null) {
                        textView30.setOnClickListener(new fm1(this, orderDetail));
                    }
                } else {
                    LinearLayout linearLayout5 = this.bottonLayout;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-11  reason: not valid java name */
    public static final void m151bottomViewRender$lambda11(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236129869")) {
            ipChange.ipc$dispatch("-236129869", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        k21.i(orderDetail, "$data");
        qm1 qm1 = qm1.INSTANCE;
        k21.h(view, AdvanceSetting.NETWORK_TYPE);
        qm1.t(view, orderDetailFragment.getCreate(new TrackInfo()), true);
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-13  reason: not valid java name */
    public static final void m152bottomViewRender$lambda13(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102157681")) {
            ipChange.ipc$dispatch("102157681", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        k21.i(orderDetail, "$data");
        qm1 qm1 = qm1.INSTANCE;
        k21.h(view, AdvanceSetting.NETWORK_TYPE);
        qm1.r(view, orderDetailFragment.getCreate(new TrackInfo()));
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-15  reason: not valid java name */
    public static final void m153bottomViewRender$lambda15(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440445231")) {
            ipChange.ipc$dispatch("440445231", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        k21.i(orderDetail, "$data");
        qm1 qm1 = qm1.INSTANCE;
        k21.h(view, AdvanceSetting.NETWORK_TYPE);
        qm1.m(view, orderDetailFragment.getCreate(new TrackInfo()));
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-5  reason: not valid java name */
    public static final void m154bottomViewRender$lambda5(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563212772")) {
            ipChange.ipc$dispatch("-563212772", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        k21.i(orderDetail, "$data");
        qm1 qm1 = qm1.INSTANCE;
        k21.h(view, AdvanceSetting.NETWORK_TYPE);
        qm1.a(view, orderDetailFragment.getCreate(new TrackInfo()));
        EventBus.getDefault().post(new Event("scriptOrderRefresh", "pay"));
        OrderDetailListener orderDetailListener = orderDetailFragment.listener;
        if (orderDetailListener != null) {
            orderDetailListener.cancelOrder(orderDetail);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-7  reason: not valid java name */
    public static final void m155bottomViewRender$lambda7(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224925222")) {
            ipChange.ipc$dispatch("-224925222", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        k21.i(orderDetail, "$data");
        qm1 qm1 = qm1.INSTANCE;
        k21.h(view, AdvanceSetting.NETWORK_TYPE);
        qm1.j(view, orderDetailFragment.getCreate(new TrackInfo()));
        EventBus.getDefault().post(new Event("scriptOrderRefresh", "pay"));
        OrderDetailListener orderDetailListener = orderDetailFragment.listener;
        if (orderDetailListener != null) {
            orderDetailListener.gotoPay(orderDetail);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-9  reason: not valid java name */
    public static final void m156bottomViewRender$lambda9(OrderDetail orderDetail, OrderDetailFragment orderDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1266844660")) {
            ipChange.ipc$dispatch("-1266844660", new Object[]{orderDetail, orderDetailFragment, view});
            return;
        }
        k21.i(orderDetail, "$data");
        k21.i(orderDetailFragment, "this$0");
        String yellowTips = orderDetail.getYellowTips();
        if (!(yellowTips == null || yellowTips.length() == 0)) {
            z = false;
        }
        if (!z) {
            Toast.makeText(orderDetailFragment.getActivity(), orderDetail.getYellowTips(), 0).show();
        } else {
            Toast.makeText(orderDetailFragment.getActivity(), "出码需要一定时间，稍等一下哦", 0).show();
        }
    }

    /* access modifiers changed from: private */
    public final TrackInfo getCreate(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263125476")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1263125476", new Object[]{this, trackInfo});
        }
        trackInfo.setSpma(tc.INSTANCE.a());
        trackInfo.setSpmb(ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE);
        trackInfo.setArgs(new HashMap<>());
        trackInfo.getArgs().put("item_id", this.itemId);
        trackInfo.getArgs().put("orderid", this.orderId);
        return trackInfo;
    }

    /* access modifiers changed from: private */
    public final void headerViewRender(OrderDetail orderDetail, boolean z) {
        String totalAmount;
        String orderStatusStr;
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-885584433")) {
            ipChange.ipc$dispatch("-885584433", new Object[]{this, orderDetail, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            LinearLayout linearLayout = this.llTipsContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView2 = this.tipsTitleTv;
            if (textView2 != null) {
                textView2.setText("支付结果处理中，请稍等一下哦");
            }
        } else {
            String yellowTips = orderDetail.getYellowTips();
            if (!(yellowTips == null || yellowTips.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                LinearLayout linearLayout2 = this.llTipsContainer;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView3 = this.tipsTitleTv;
                if (textView3 != null) {
                    textView3.setText(orderDetail.getYellowTips());
                }
                String yellowTipsIcon = orderDetail.getYellowTipsIcon();
                if (yellowTipsIcon != null) {
                    ImageLoaderProviderProxy.getProxy().loadinto(yellowTipsIcon, this.tipsIconTv);
                }
            } else {
                LinearLayout linearLayout3 = this.llTipsContainer;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            }
        }
        StatusInfo statusInfo = orderDetail.getStatusInfo();
        if (statusInfo != null) {
            if (!k21.d(statusInfo.getShowStatus(), "1") || z) {
                ConstraintLayout constraintLayout = this.payCardCl;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
            } else {
                ConstraintLayout constraintLayout2 = this.payCardCl;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
            }
        }
        StatusInfo statusInfo2 = orderDetail.getStatusInfo();
        if (!(statusInfo2 == null || (orderStatusStr = statusInfo2.getOrderStatusStr()) == null || (textView = this.payStatusTv) == null)) {
            textView.setText(orderStatusStr);
        }
        StatusInfo statusInfo3 = orderDetail.getStatusInfo();
        if (!(statusInfo3 == null || (totalAmount = statusInfo3.getTotalAmount()) == null)) {
            DigitTextView digitTextView = this.payAmountTv;
            if (digitTextView != null) {
                digitTextView.setText(totalAmount);
            }
            DigitTextView digitTextView2 = this.payAmountTv;
            if (digitTextView2 != null) {
                digitTextView2.setVisibility(0);
            }
            TextView textView4 = this.paySymbolTv;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        StatusInfo statusInfo4 = orderDetail.getStatusInfo();
        if ((statusInfo4 != null ? statusInfo4.getTotalAmount() : null) == null) {
            DigitTextView digitTextView3 = this.payAmountTv;
            if (digitTextView3 != null) {
                digitTextView3.setVisibility(8);
            }
            TextView textView5 = this.paySymbolTv;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        StatusInfo statusInfo5 = orderDetail.getStatusInfo();
        if (statusInfo5 != null && statusInfo5.getOverdueTime() > 0) {
            startTimer(0);
        }
    }

    private final void initBottomView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099059966")) {
            ipChange.ipc$dispatch("1099059966", new Object[]{this});
            return;
        }
        View view = this.rootView;
        TextView textView = null;
        this.bottonLayout = view != null ? (LinearLayout) view.findViewById(R$id.order_detail_bottom) : null;
        View view2 = this.rootView;
        this.cancelOrder = view2 != null ? (TextView) view2.findViewById(R$id.tv_cancel_action) : null;
        View view3 = this.rootView;
        this.payTv = view3 != null ? (TextView) view3.findViewById(R$id.tv_pay_action) : null;
        View view4 = this.rootView;
        this.useTv = view4 != null ? (TextView) view4.findViewById(R$id.tv_use_action) : null;
        View view5 = this.rootView;
        this.commentDesTv = view5 != null ? (TextView) view5.findViewById(R$id.tv_comment_des) : null;
        View view6 = this.rootView;
        if (view6 != null) {
            textView = (TextView) view6.findViewById(R$id.tv_comment_action);
        }
        this.commentTv = textView;
    }

    private final void initHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993160796")) {
            ipChange.ipc$dispatch("1993160796", new Object[]{this});
            return;
        }
        View view = this.rootView;
        TextView textView = null;
        this.llTipsContainer = view != null ? (LinearLayout) view.findViewById(R$id.ll_tips_container) : null;
        View view2 = this.rootView;
        this.tipsIconTv = view2 != null ? (ImageView) view2.findViewById(R$id.iv_tips_icon) : null;
        View view3 = this.rootView;
        this.tipsTitleTv = view3 != null ? (TextView) view3.findViewById(R$id.tv_tips_title) : null;
        View view4 = this.rootView;
        this.payCardCl = view4 != null ? (ConstraintLayout) view4.findViewById(R$id.cl_pay_card) : null;
        View view5 = this.rootView;
        this.payStatusTv = view5 != null ? (TextView) view5.findViewById(R$id.tv_pay_status) : null;
        View view6 = this.rootView;
        this.paySymbolTv = view6 != null ? (TextView) view6.findViewById(R$id.tv_pay_symbol) : null;
        View view7 = this.rootView;
        this.payAmountTv = view7 != null ? (DigitTextView) view7.findViewById(R$id.tv_pay_amount) : null;
        View view8 = this.rootView;
        if (view8 != null) {
            textView = (TextView) view8.findViewById(R$id.tv_order_state_des);
        }
        this.payDesTv = textView;
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539130473")) {
            ipChange.ipc$dispatch("539130473", new Object[]{this});
            return;
        }
        View view = this.rootView;
        AppBarLayout appBarLayout = null;
        this.irc = view != null ? (RecyclerView) view.findViewById(R$id.irc) : null;
        View view2 = this.rootView;
        LinearPullToRefreshView linearPullToRefreshView = view2 != null ? (LinearPullToRefreshView) view2.findViewById(R$id.lin_refresh_layout) : null;
        this.refreshView = linearPullToRefreshView;
        if (linearPullToRefreshView != null) {
            linearPullToRefreshView.setVisibility(8);
        }
        LinearPullToRefreshView linearPullToRefreshView2 = this.refreshView;
        if (linearPullToRefreshView2 != null) {
            linearPullToRefreshView2.setPullToRefreshEnabled(true);
        }
        LinearPullToRefreshView linearPullToRefreshView3 = this.refreshView;
        if (linearPullToRefreshView3 != null) {
            linearPullToRefreshView3.setOnRefreshListener(new jm1(this));
        }
        initHeaderView();
        initBottomView();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(activity);
            orderDetailAdapter.e(new c(this));
            orderDetailAdapter.d(new d(this));
            orderDetailAdapter.b(this);
            this.adapter = orderDetailAdapter;
            RecyclerView recyclerView = this.irc;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(new OrderDetailFragment$initView$2$2(activity));
            }
            RecyclerView recyclerView2 = this.irc;
            if (recyclerView2 != null) {
                recyclerView2.addOnScrollListener(new OrderDetailFragment$initView$2$3(this));
            }
            View view3 = this.rootView;
            if (view3 != null) {
                appBarLayout = (AppBarLayout) view3.findViewById(R$id.appbar_layout);
            }
            if (appBarLayout != null) {
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            }
            RecyclerView recyclerView3 = this.irc;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(this.adapter);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            linearLayoutManager.setOrientation(1);
            RecyclerView recyclerView4 = this.irc;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(linearLayoutManager);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m157initView$lambda0(OrderDetailFragment orderDetailFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906555143")) {
            ipChange.ipc$dispatch("-906555143", new Object[]{orderDetailFragment});
            return;
        }
        k21.i(orderDetailFragment, "this$0");
        orderDetailFragment.refresh();
    }

    private final void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411957353")) {
            ipChange.ipc$dispatch("1411957353", new Object[]{this});
            return;
        }
        Timer timer = this.mTimer;
        if (timer != null && this.mTimerTask != null) {
            k21.f(timer);
            timer.cancel();
            TimerTask timerTask = this.mTimerTask;
            k21.f(timerTask);
            timerTask.cancel();
            this.mTimer = null;
            this.mTimerTask = null;
        }
    }

    private final void updateOrderStateMessage(String str) {
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "899791931")) {
            ipChange.ipc$dispatch("899791931", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            TextView textView2 = this.payDesTv;
            if (textView2 != null) {
                textView2.setText(str);
            }
            TextView textView3 = this.payDesTv;
            if (textView3 == null || textView3.getVisibility() != 0) {
                z = false;
            }
            if (!z && (textView = this.payDesTv) != null) {
                textView.setVisibility(0);
            }
        }
    }

    public final void dismissPopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845130242")) {
            ipChange.ipc$dispatch("845130242", new Object[]{this});
            return;
        }
        NoticeFragment.Companion.a(getChildFragmentManager(), this.showNoticeFragment);
        this.showNoticeFragment = null;
    }

    @Nullable
    public final OrderDetailAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "453405792")) {
            return this.adapter;
        }
        return (OrderDetailAdapter) ipChange.ipc$dispatch("453405792", new Object[]{this});
    }

    @Nullable
    public final LinearLayout getBottonLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1496970071")) {
            return this.bottonLayout;
        }
        return (LinearLayout) ipChange.ipc$dispatch("1496970071", new Object[]{this});
    }

    @Nullable
    public final TextView getCancelOrder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1263330412")) {
            return this.cancelOrder;
        }
        return (TextView) ipChange.ipc$dispatch("-1263330412", new Object[]{this});
    }

    @Nullable
    public final TextView getCommentDesTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1339647883")) {
            return this.commentDesTv;
        }
        return (TextView) ipChange.ipc$dispatch("-1339647883", new Object[]{this});
    }

    @Nullable
    public final TextView getCommentTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-323725593")) {
            return this.commentTv;
        }
        return (TextView) ipChange.ipc$dispatch("-323725593", new Object[]{this});
    }

    @Nullable
    public final RecyclerView getIrc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1577498273")) {
            return this.irc;
        }
        return (RecyclerView) ipChange.ipc$dispatch("1577498273", new Object[]{this});
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-255572744")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("-255572744", new Object[]{this});
    }

    @Nullable
    public final OrderDetailListener getListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-641705738")) {
            return this.listener;
        }
        return (OrderDetailListener) ipChange.ipc$dispatch("-641705738", new Object[]{this});
    }

    @Nullable
    public final LinearLayout getLlTipsContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "87495874")) {
            return this.llTipsContainer;
        }
        return (LinearLayout) ipChange.ipc$dispatch("87495874", new Object[]{this});
    }

    @Nullable
    public final OrderDetail getMData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1141661208")) {
            return this.mData;
        }
        return (OrderDetail) ipChange.ipc$dispatch("-1141661208", new Object[]{this});
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "588120469")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("588120469", new Object[]{this});
    }

    @Nullable
    public final DigitTextView getPayAmountTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1195231302")) {
            return this.payAmountTv;
        }
        return (DigitTextView) ipChange.ipc$dispatch("-1195231302", new Object[]{this});
    }

    @Nullable
    public final ConstraintLayout getPayCardCl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "29555636")) {
            return this.payCardCl;
        }
        return (ConstraintLayout) ipChange.ipc$dispatch("29555636", new Object[]{this});
    }

    @Nullable
    public final TextView getPayDesTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-391184578")) {
            return this.payDesTv;
        }
        return (TextView) ipChange.ipc$dispatch("-391184578", new Object[]{this});
    }

    @Nullable
    public final TextView getPayStatusTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1617919148")) {
            return this.payStatusTv;
        }
        return (TextView) ipChange.ipc$dispatch("1617919148", new Object[]{this});
    }

    @Nullable
    public final TextView getPaySymbolTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1654210758")) {
            return this.paySymbolTv;
        }
        return (TextView) ipChange.ipc$dispatch("1654210758", new Object[]{this});
    }

    @Nullable
    public final TextView getPayTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1594199230")) {
            return this.payTv;
        }
        return (TextView) ipChange.ipc$dispatch("1594199230", new Object[]{this});
    }

    @Nullable
    public final LinearPullToRefreshView getRefreshView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "365135132")) {
            return this.refreshView;
        }
        return (LinearPullToRefreshView) ipChange.ipc$dispatch("365135132", new Object[]{this});
    }

    @Nullable
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-993510095")) {
            return this.rootView;
        }
        return (View) ipChange.ipc$dispatch("-993510095", new Object[]{this});
    }

    @Nullable
    public final NoticeFragment getShowNoticeFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "725163250")) {
            return this.showNoticeFragment;
        }
        return (NoticeFragment) ipChange.ipc$dispatch("725163250", new Object[]{this});
    }

    @Nullable
    public final ImageView getTipsIconTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-707637875")) {
            return this.tipsIconTv;
        }
        return (ImageView) ipChange.ipc$dispatch("-707637875", new Object[]{this});
    }

    @Nullable
    public final TextView getTipsTitleTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-855869658")) {
            return this.tipsTitleTv;
        }
        return (TextView) ipChange.ipc$dispatch("-855869658", new Object[]{this});
    }

    @Nullable
    public final TextView getUseTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1926723647")) {
            return this.useTv;
        }
        return (TextView) ipChange.ipc$dispatch("1926723647", new Object[]{this});
    }

    public final boolean isPopLayerShowing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811715381")) {
            return ((Boolean) ipChange.ipc$dispatch("1811715381", new Object[]{this})).booleanValue();
        }
        NoticeFragment noticeFragment = this.showNoticeFragment;
        if (noticeFragment == null) {
            return false;
        }
        k21.f(noticeFragment);
        return noticeFragment.isAdded();
    }

    public final void jumpAction(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1136230628")) {
            ipChange.ipc$dispatch("1136230628", new Object[]{this, str});
            return;
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (!z) {
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(str);
            NavProviderProxy.getProxy().toUri(getContext(), action);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937929009")) {
            ipChange.ipc$dispatch("1937929009", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("orderId") : null;
        this.orderId = string;
        if (string != null) {
            boolean unused = o.y(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385663411")) {
            return (View) ipChange.ipc$dispatch("1385663411", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        this.rootView = layoutInflater.inflate(R$layout.bricks_coupon_order_detail_fragment, viewGroup, false);
        initView();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1786991797")) {
            ipChange.ipc$dispatch("1786991797", new Object[]{this});
            return;
        }
        super.onPause();
        stopTimer();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1209957362")) {
            ipChange.ipc$dispatch("1209957362", new Object[]{this});
            return;
        }
        super.onResume();
        refresh();
    }

    public final void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716477617")) {
            ipChange.ipc$dispatch("1716477617", new Object[]{this});
            return;
        }
        stopTimer();
        showLoading(new String[0]);
        if (DoloresLoginHandler.Companion.a().c()) {
            ta0.a aVar = ta0.Companion;
            CouponOrderDetailRequest couponOrderDetailRequest = new CouponOrderDetailRequest();
            couponOrderDetailRequest.setOrderId(this.orderId);
            o81 o81 = o81.INSTANCE;
            AMapLocation lastKnownLocation = o81.c().getLastKnownLocation();
            Double d2 = null;
            couponOrderDetailRequest.setLatitude(String.valueOf(lastKnownLocation != null ? Double.valueOf(lastKnownLocation.getLatitude()) : null));
            AMapLocation lastKnownLocation2 = o81.c().getLastKnownLocation();
            if (lastKnownLocation2 != null) {
                d2 = Double.valueOf(lastKnownLocation2.getLongitude());
            }
            couponOrderDetailRequest.setLongitude(String.valueOf(d2));
            aVar.b(couponOrderDetailRequest).c(getContext()).a().doOnKTSuccess(new OrderDetailFragment$refresh$2(this)).doOnKTFail(new OrderDetailFragment$refresh$3(this)).doOnKTFinish(new OrderDetailFragment$refresh$4(this));
            return;
        }
        ca1.Companion.d(this, 2001);
    }

    public final void setAdapter(@Nullable OrderDetailAdapter orderDetailAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889237306")) {
            ipChange.ipc$dispatch("889237306", new Object[]{this, orderDetailAdapter});
            return;
        }
        this.adapter = orderDetailAdapter;
    }

    public final void setBottonLayout(@Nullable LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023058957")) {
            ipChange.ipc$dispatch("-2023058957", new Object[]{this, linearLayout});
            return;
        }
        this.bottonLayout = linearLayout;
    }

    public final void setCancelOrder(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534719336")) {
            ipChange.ipc$dispatch("-534719336", new Object[]{this, textView});
            return;
        }
        this.cancelOrder = textView;
    }

    public final void setCommentDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183864977")) {
            ipChange.ipc$dispatch("-1183864977", new Object[]{this, textView});
            return;
        }
        this.commentDesTv = textView;
    }

    public final void setCommentTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693438117")) {
            ipChange.ipc$dispatch("1693438117", new Object[]{this, textView});
            return;
        }
        this.commentTv = textView;
    }

    public final void setIrc(@Nullable RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994933327")) {
            ipChange.ipc$dispatch("-1994933327", new Object[]{this, recyclerView});
            return;
        }
        this.irc = recyclerView;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727912474")) {
            ipChange.ipc$dispatch("-727912474", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setListener(@Nullable OrderDetailListener orderDetailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019628200")) {
            ipChange.ipc$dispatch("-1019628200", new Object[]{this, orderDetailListener});
            return;
        }
        this.listener = orderDetailListener;
    }

    public final void setLlTipsContainer(@Nullable LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759929936")) {
            ipChange.ipc$dispatch("759929936", new Object[]{this, linearLayout});
            return;
        }
        this.llTipsContainer = linearLayout;
    }

    public final void setMData(@Nullable OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561307986")) {
            ipChange.ipc$dispatch("1561307986", new Object[]{this, orderDetail});
            return;
        }
        this.mData = orderDetail;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-564388223")) {
            ipChange.ipc$dispatch("-564388223", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }

    public final void setPayAmountTv(@Nullable DigitTextView digitTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196989076")) {
            ipChange.ipc$dispatch("1196989076", new Object[]{this, digitTextView});
            return;
        }
        this.payAmountTv = digitTextView;
    }

    public final void setPayCardCl(@Nullable ConstraintLayout constraintLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870915278")) {
            ipChange.ipc$dispatch("-1870915278", new Object[]{this, constraintLayout});
            return;
        }
        this.payCardCl = constraintLayout;
    }

    public final void setPayDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055817670")) {
            ipChange.ipc$dispatch("1055817670", new Object[]{this, textView});
            return;
        }
        this.payDesTv = textView;
    }

    public final void setPayStatusTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410296192")) {
            ipChange.ipc$dispatch("-1410296192", new Object[]{this, textView});
            return;
        }
        this.payStatusTv = textView;
    }

    public final void setPaySymbolTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285256282")) {
            ipChange.ipc$dispatch("-285256282", new Object[]{this, textView});
            return;
        }
        this.paySymbolTv = textView;
    }

    public final void setPayTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705726034")) {
            ipChange.ipc$dispatch("-1705726034", new Object[]{this, textView});
            return;
        }
        this.payTv = textView;
    }

    public final void setRefreshView(@Nullable LinearPullToRefreshView linearPullToRefreshView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1289274298")) {
            ipChange.ipc$dispatch("1289274298", new Object[]{this, linearPullToRefreshView});
            return;
        }
        this.refreshView = linearPullToRefreshView;
    }

    public final void setRootView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019642319")) {
            ipChange.ipc$dispatch("1019642319", new Object[]{this, view});
            return;
        }
        this.rootView = view;
    }

    public final void setShowNoticeFragment(@Nullable NoticeFragment noticeFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428747758")) {
            ipChange.ipc$dispatch("-428747758", new Object[]{this, noticeFragment});
            return;
        }
        this.showNoticeFragment = noticeFragment;
    }

    public final void setTipsIconTv(@Nullable ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206125871")) {
            ipChange.ipc$dispatch("-1206125871", new Object[]{this, imageView});
            return;
        }
        this.tipsIconTv = imageView;
    }

    public final void setTipsTitleTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788337850")) {
            ipChange.ipc$dispatch("-788337850", new Object[]{this, textView});
            return;
        }
        this.tipsTitleTv = textView;
    }

    public final void setUseTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12596301")) {
            ipChange.ipc$dispatch("12596301", new Object[]{this, textView});
            return;
        }
        this.useTv = textView;
    }

    public final void startTimer(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3506472")) {
            ipChange.ipc$dispatch("3506472", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            this.mTimeHandler = new b(new WeakReference(this));
        }
        if (this.mTimerTask == null) {
            OrderDetailFragment$startTimer$1 orderDetailFragment$startTimer$1 = new OrderDetailFragment$startTimer$1(this, i);
            this.mTimerTask = orderDetailFragment$startTimer$1;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.schedule(orderDetailFragment$startTimer$1, 0, 1000);
            }
        }
    }

    public final void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518936366")) {
            ipChange.ipc$dispatch("-1518936366", new Object[]{this});
            return;
        }
        hideLoading();
        LinearPullToRefreshView linearPullToRefreshView = this.refreshView;
        if (linearPullToRefreshView != null && linearPullToRefreshView != null) {
            linearPullToRefreshView.onRefreshComplete();
        }
    }

    public final void updateTimerShow(@Nullable String str, int i, int i2, int i3, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463118320")) {
            ipChange.ipc$dispatch("-1463118320", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
            return;
        }
        StringBuilder sb = this.mBuilder;
        sb.delete(0, sb.length());
        if (!TextUtils.isEmpty(str)) {
            this.mBuilder.append(str);
        }
        if (i > 0) {
            StringBuilder sb2 = this.mBuilder;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i);
            sb3.append((char) 26102);
            sb2.append(sb3.toString());
        }
        StringBuilder sb4 = this.mBuilder;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i2);
        sb5.append((char) 20998);
        sb4.append(sb5.toString());
        StringBuilder sb6 = this.mBuilder;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(i3);
        sb7.append((char) 31186);
        sb6.append(sb7.toString());
        if (!TextUtils.isEmpty(str2)) {
            this.mBuilder.append(str2);
        }
        String sb8 = this.mBuilder.toString();
        k21.h(sb8, "mBuilder.toString()");
        updateOrderStateMessage(sb8);
    }
}
