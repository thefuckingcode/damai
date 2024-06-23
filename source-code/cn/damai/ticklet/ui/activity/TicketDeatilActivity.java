package cn.damai.ticklet.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.util.PriorityTask;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.h5container.WebViewFragment;
import cn.damai.h5container.WebViewUtil;
import cn.damai.member.R$dimen;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.message.observer.Action;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TicketExtMapBean;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.bean.TickletForgetCardResult;
import cn.damai.ticklet.bean.TickletStatusNotice;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletDetailCallback;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.net.TickletDetailRequest;
import cn.damai.ticklet.net.TickletForgetCardRequest;
import cn.damai.ticklet.ui.detailholder.TicketDetailPerformViewHolder;
import cn.damai.ticklet.ui.fragment.NotificationFragment;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.ui.fragment.TickletDetailInterface;
import cn.damai.ticklet.ui.fragment.TickletDialogShowFragment;
import cn.damai.ticklet.ui.fragment.TickletForgetCardFragment;
import cn.damai.ticklet.ui.fragment.TickletScreenCapture;
import cn.damai.ticklet.ui.observer.ObserverTicket;
import cn.damai.ticklet.utils.UTTimeUtils;
import cn.damai.ticklet.view.TickletAnimWindow;
import cn.damai.ticklet.view.TickletDetailHeader;
import cn.damai.ticklet.view.TickletDetailViewPager;
import cn.damai.ticklet.view.TickletNFTTicketItemView;
import cn.damai.ticklet.view.TickletPerformCancelView;
import cn.damai.ticklet.view.TickletTicketItemDigitalTicketsView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.b30;
import tb.d20;
import tb.dr;
import tb.f4;
import tb.fl2;
import tb.g91;
import tb.gl2;
import tb.hl2;
import tb.il2;
import tb.k42;
import tb.lw2;
import tb.ns1;
import tb.pl2;
import tb.qb0;
import tb.sl2;
import tb.vl2;
import tb.yf2;

/* compiled from: Taobao */
public class TicketDeatilActivity extends DamaiMapBaseActivity implements TickletDetailCallback, TickletPerformCallBack, TickletTicketCallback, TickletDetailInterface, TickletDialogShowFragment.OnClickCloseListener, ObserverTicket, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_REQUEST_BIND_FACE = 1000;
    public static final int CODE_REQUEST_CLOSE_FRAGMENT = 100;
    public static final int CODE_REQUEST_FIRST_REQUEST_CODE = 200;
    public static final int CODE_REQUEST_PERFORM_CANCEL = 1001;
    public static final int FIRST_REQUEST_DELAY_MILLIS = 3;
    public static String FROM_ACCEPT_TICKET = "acceptTicket";
    public static String FROM_HOME_ALERT = "homeAlert";
    public static String FROM_LIST = "0";
    public static String FROM_MEMBER = "1";
    public static String FROM_OTHER = "h5";
    public static String FROM_PUSH = "push";
    private static final String TAG = TicketDeatilActivity.class.getSimpleName();
    private int barStatusBarHeight;
    private TickletPerformCancelView cancelView;
    private TicketDetailExtFragment detailExtFragment;
    il2 detailServer;
    private TickletDialogShowFragment dialogShowFragment;
    private WebViewFragment downH5Fragment;
    LinearLayout errorPageView;
    FrameLayout flScreen;
    private FragmentManager fm;
    private TickletForgetCardFragment forgetCardFragment;
    private String from;
    TextureMapView gd_map;
    private e hanlder;
    private Boolean history;
    private Boolean isCloseLocal;
    private boolean isFirstLoadData;
    private boolean isPulling;
    private Boolean isResfresh;
    private boolean isShowAddTips;
    TicketNftExtAttr mNftAttr;
    private FrameLayout mTickletDialogContainer;
    private TickletScreenCapture mTickletScreenFragment;
    private TickletAnimWindow mapAppWindow;
    private int movedDistance;
    private NotificationFragment noticeFragemnt;
    public String orderId = "";
    private int page;
    public String performId;
    public String productSystemId = "";
    private int rendererTime;
    private FrameLayout rlPerformCancelView;
    private Bundle savedInstanceState;
    ScreenShotDetector.IScreenShotExtraListener screenShotExtraListener;
    pl2 server;
    TickletDetailHeader td_header;
    TicketDeatilResult ticketDeatilResult;
    RelativeLayout ticklet_detail_ll;
    private int titleHeight;
    private FragmentTransaction transaction;
    UTTimeUtils utTimeUtils;
    TicketExtMapBean venueViewBean;
    private TickletDetailViewPager viewPager;

    /* compiled from: Taobao */
    public class a implements ScreenShotDetector.IScreenShotExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public void onDetected(String str, Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-41626808")) {
                ipChange.ipc$dispatch("-41626808", new Object[]{this, str, activity});
                return;
            }
            TicketDeatilActivity.this.showDetectView(str);
        }
    }

    /* compiled from: Taobao */
    public class b implements WebViewFragment.LoadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.h5container.WebViewFragment.LoadListener
        public void onLoadFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1109511415")) {
                ipChange.ipc$dispatch("1109511415", new Object[]{this});
                return;
            }
            TicketDeatilActivity.this.stopProgressDialog();
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<TicketNftExtAttr> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void call(TicketNftExtAttr ticketNftExtAttr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1531058164")) {
                ipChange.ipc$dispatch("-1531058164", new Object[]{this, ticketNftExtAttr});
                return;
            }
            TicketDeatilActivity ticketDeatilActivity = TicketDeatilActivity.this;
            ticketDeatilActivity.mNftAttr = ticketNftExtAttr;
            ticketDeatilActivity.requestDetailData();
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<Boolean> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        /* renamed from: a */
        public void call(Boolean bool) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2143137722")) {
                ipChange.ipc$dispatch("2143137722", new Object[]{this, bool});
            } else if (bool == null) {
            } else {
                if (bool.booleanValue()) {
                    TicketDeatilActivity.this.startProgressDialog();
                } else {
                    TicketDeatilActivity.this.stopProgressDialog();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class e extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1743470314")) {
                ipChange.ipc$dispatch("-1743470314", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            int i = message.what;
            if (i == 100) {
                if (TicketDeatilActivity.this.mTickletDialogContainer != null) {
                    TicketDeatilActivity.this.mTickletDialogContainer.setVisibility(8);
                    TicketDeatilActivity.this.mTickletDialogContainer.setBackgroundColor(Color.parseColor("#E0000000"));
                }
                ScreenShotDetector.k().x(TicketDeatilActivity.this.screenShotExtraListener);
            } else if (i == 200) {
                TicketDeatilActivity.this.requestDetailData();
            }
        }
    }

    public TicketDeatilActivity() {
        Boolean bool = Boolean.FALSE;
        this.isCloseLocal = bool;
        this.isFirstLoadData = true;
        this.isResfresh = bool;
        this.history = bool;
        this.isShowAddTips = true;
        this.page = 1;
        this.utTimeUtils = new UTTimeUtils(UTTimeUtils.p);
        this.rendererTime = 0;
        this.hanlder = new e();
        this.titleHeight = 0;
        this.screenShotExtraListener = new a();
        this.barStatusBarHeight = 0;
        this.isPulling = false;
        this.movedDistance = 0;
    }

    static /* synthetic */ int access$308(TicketDeatilActivity ticketDeatilActivity) {
        int i = ticketDeatilActivity.rendererTime;
        ticketDeatilActivity.rendererTime = i + 1;
        return i;
    }

    private void addContentFragment(TicketDeatilResult ticketDeatilResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015635180")) {
            ipChange.ipc$dispatch("-2015635180", new Object[]{this, ticketDeatilResult2});
            return;
        }
        TicketDetailExtFragment ticketDetailExtFragment = this.detailExtFragment;
        if (ticketDetailExtFragment == null) {
            this.detailExtFragment = new TicketDetailExtFragment();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, getProductSystemId());
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, getPerformId());
            bundle.putString("projectId", getProjectId());
            bundle.putString("orderId", this.orderId);
            bundle.putSerializable(TicketDetailPerformViewHolder.PERFORM_TICKET_DATA, ticketDeatilResult2);
            this.detailExtFragment.setArguments(bundle);
            beginTransaction.add(R$id.onearch_fragment_container, this.detailExtFragment);
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        ticketDetailExtFragment.updateTicketDetailResult(ticketDeatilResult2);
    }

    private void alarm(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086702253")) {
            ipChange.ipc$dispatch("1086702253", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TicketDetailExtFragment.PERFORM_ID, this.performId);
        hashMap.put("orderId", this.orderId);
        hashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, this.productSystemId);
        hashMap.put("from", this.from);
        hashMap.put("usercode", d20.i());
        dr.INSTANCE.a().a("mtop.damai.wireless.ticklet2.perform.detail.get").c(str).d(str2).e(hashMap).g("票详情页面").j(sl2.TICKLET_DETAIL_PAGE).f(false).b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void forgetCardGetErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033332609")) {
            ipChange.ipc$dispatch("-1033332609", new Object[]{this, str, str2});
            return;
        }
        vl2.d(vl2.f(vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FORGET_CARD, "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, "performId:" + this.performId), vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE, str, vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG);
    }

    private void gotoVenuePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184105391")) {
            ipChange.ipc$dispatch("1184105391", new Object[]{this});
            return;
        }
        TicketExtMapBean ticketExtMapBean = this.venueViewBean;
        if (ticketExtMapBean != null && ticketExtMapBean != null && !"1".equals(ticketExtMapBean.pdfVoucher)) {
            HashMap hashMap = new HashMap();
            TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
            if (ticketDeatilResult2 != null) {
                hashMap.put("screening_id", ticketDeatilResult2.getPerformId());
                hashMap.put("item_id", this.ticketDeatilResult.getProjectId());
            }
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "venue_info", "venue_map_pic", hashMap, Boolean.TRUE));
            lw2 f = lw2.f();
            String performId2 = getPerformId();
            String productSystemId2 = getProductSystemId();
            TicketExtMapBean ticketExtMapBean2 = this.venueViewBean;
            f.o(this, performId2, productSystemId2, ticketExtMapBean2.lat, ticketExtMapBean2.lng, ticketExtMapBean2.title, 0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void historyPerformDetailErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534323344")) {
            ipChange.ipc$dispatch("-534323344", new Object[]{this, str, str2});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_DETAIL_REQUEST_POINT, vl2.f(vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_HISTORY_DETAIL, "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, "performId:" + this.performId), vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE, vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG);
    }

    private void initViewUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666815543")) {
            ipChange.ipc$dispatch("666815543", new Object[]{this});
            return;
        }
        this.detailServer = new il2();
        this.ticklet_detail_ll = (RelativeLayout) findViewById(R$id.ticklet_detail_ll);
        this.td_header = (TickletDetailHeader) findViewById(R$id.td_header);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        this.flScreen = (FrameLayout) findViewById(R$id.ticklet_screen_container);
        this.rlPerformCancelView = (FrameLayout) findViewById(R$id.ticklet_detail_fr_perform_cancel);
        this.cancelView = (TickletPerformCancelView) findViewById(R$id.ticklet_detail_perform_cancel);
        this.detailServer.registerObserver(this.td_header);
        this.td_header.setBackgroundColor(Color.parseColor("#965BBD"));
        pl2 a2 = pl2.a();
        this.server = a2;
        a2.registerObserver(this);
        this.flScreen.setOnClickListener(this);
        this.mDMMessage.b(TickletNFTTicketItemView.NFT_RECEIVE_ACTION, new c());
        this.mDMMessage.b(TickletNFTTicketItemView.NFT_LOADING_ACTION, new d());
    }

    private void isShowHttpErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702805868")) {
            ipChange.ipc$dispatch("702805868", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
    }

    private void isShowRightView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1108588080")) {
            ipChange.ipc$dispatch("1108588080", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void judgeNftState(TicketDeatilResult ticketDeatilResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776999866")) {
            ipChange.ipc$dispatch("776999866", new Object[]{this, ticketDeatilResult2});
            return;
        }
        try {
            String str = ticketDeatilResult2.getUserPerformVO().getUserTicketVOList().get(this.mNftAttr.position).getExtAttr().nftAttr.nftStatus;
            if (!this.mNftAttr.nftStatus.equals(str)) {
                vl2.c(vl2.f(vl2.TICKLET_NFT_RECEIVE_STATE_ERROR_MSG, "mtop.damai.wireless.ticklet2.nft.prepareIssue", "", "", " uniqueId:" + this.mNftAttr.uniqueId + " , ycCode:" + this.mNftAttr.acSn + " , currentStatus:" + str), vl2.TICKLET_NFT_RECEIVE_STATE_ERROR_CODE, vl2.TICKLET_NFT_RECEIVE_STATE_ERROR_MSG);
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    private void onRefreshDetail() {
        TicketDeatilResult ticketDeatilResult2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322015037")) {
            ipChange.ipc$dispatch("1322015037", new Object[]{this});
            return;
        }
        this.rendererTime = 0;
        if (!this.isFirstLoadData || (ticketDeatilResult2 = this.ticketDeatilResult) == null) {
            this.utTimeUtils.k();
            requestLocalDetailData();
            requestDetailData();
            return;
        }
        this.isFirstLoadData = false;
        resetTickletDetailUI(ticketDeatilResult2, Boolean.TRUE);
        if (this.hanlder == null) {
            this.hanlder = new e();
        }
        this.hanlder.sendEmptyMessageDelayed(200, 3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void performDetailErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113258746")) {
            ipChange.ipc$dispatch("-113258746", new Object[]{this, str, str2});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_DETAIL_REQUEST_POINT, vl2.f("场次详情", "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, "performId:" + this.performId), vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE, vl2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG);
    }

    private void renderErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550916802")) {
            ipChange.ipc$dispatch("550916802", new Object[]{this, str, str2, str3});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_DETAIL_RENDER_POINT, vl2.f("票夹场次详情渲染失败", "", str, str2, "performId:" + str3), vl2.TICKLET_PERFORM_DETAIL_RENDER_ERROR_CODE, "票夹场次详情渲染失败");
    }

    private void renderHistoryErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446497596")) {
            ipChange.ipc$dispatch("-446497596", new Object[]{this, str, str2, str3});
            return;
        }
        vl2.a(vl2.TICKLET_PERFORM_DETAIL_RENDER_POINT, vl2.f(vl2.TICKLET_PERFORM_DETAIL_HISTORY_RENDER_FAIL, "", str, str2, "performId:" + str3), vl2.TICKLET_PERFORM_DETAIL_RENDER_ERROR_CODE, "票夹场次详情渲染失败");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestDetailData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914986176")) {
            ipChange.ipc$dispatch("1914986176", new Object[]{this});
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.isCloseLocal.booleanValue()) {
            startProgressDialog();
        }
        TickletDetailRequest tickletDetailRequest = new TickletDetailRequest();
        tickletDetailRequest.performId = this.performId;
        tickletDetailRequest.orderId = this.orderId;
        tickletDetailRequest.productSystemId = this.productSystemId;
        tickletDetailRequest.request(new DMMtopRequestListener<TicketDeatilResult>(TicketDeatilResult.class) {
            /* class cn.damai.ticklet.ui.activity.TicketDeatilActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-207603414")) {
                    ipChange.ipc$dispatch("-207603414", new Object[]{this, str, str2});
                    return;
                }
                TicketDeatilActivity.this.stopProgressDialog();
                if (!TicketDeatilActivity.this.history.booleanValue()) {
                    TicketDeatilActivity.this.performDetailErrorXFlushMonitor(str, str2);
                } else {
                    TicketDeatilActivity.this.historyPerformDetailErrorXFlushMonitor(str, str2);
                }
                TicketDeatilActivity.this.returnDetailDataError(str2, str);
            }

            public void onSuccess(TicketDeatilResult ticketDeatilResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1720370929")) {
                    ipChange.ipc$dispatch("-1720370929", new Object[]{this, ticketDeatilResult});
                    return;
                }
                TicketDeatilActivity.this.stopProgressDialog();
                long currentTimeMillis = System.currentTimeMillis();
                if (ticketDeatilResult != null) {
                    ticketDeatilResult.setLoadTime(currentTimeMillis - currentTimeMillis);
                    if (!(ticketDeatilResult.getServerTimestamp() == null || 0 == ticketDeatilResult.getServerTimestamp().longValue())) {
                        b30.d(ticketDeatilResult.getServerTimestamp().longValue());
                    }
                    if (!TicketDeatilActivity.this.isCloseLocal.booleanValue()) {
                        DataHelper.getInstance().saveOrUpdateTicketDetailResult(ticketDeatilResult, gl2.d);
                    }
                }
                TicketDeatilActivity.access$308(TicketDeatilActivity.this);
                TicketDeatilActivity.this.resetTickletDetailUI(ticketDeatilResult, Boolean.FALSE);
                TicketDeatilActivity ticketDeatilActivity = TicketDeatilActivity.this;
                if (ticketDeatilActivity.mNftAttr != null) {
                    ticketDeatilActivity.judgeNftState(ticketDeatilResult);
                }
                vl2.b(vl2.TICKLET_PERFORM_DETAIL_REQUEST_POINT, "mtop.damai.wireless.ticklet2.perform.detail.get");
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void returnDetailDataError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170971041")) {
            ipChange.ipc$dispatch("1170971041", new Object[]{this, str, str2});
            return;
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        if (ticketDeatilResult2 == null || ticketDeatilResult2.getTicketInfoList() == null) {
            onResponseError(str, str2, "mtop.damai.wireless.ticklet2.perform.detail.get", this.errorPageView, true);
            isShowHttpErrorView();
            alarm(str2, str);
        }
        if (!yf2.c(str)) {
            ToastUtil.f(str);
        }
    }

    private void setTitleBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429573336")) {
            ipChange.ipc$dispatch("1429573336", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.td_header.setBackgroundColor(i);
    }

    private void showCapture(final UserTicketTable userTicketTable, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40091130")) {
            ipChange.ipc$dispatch("-40091130", new Object[]{this, userTicketTable, str});
            return;
        }
        new Handler(getMainLooper()).post(new Runnable() {
            /* class cn.damai.ticklet.ui.activity.TicketDeatilActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-274654767")) {
                    ipChange.ipc$dispatch("-274654767", new Object[]{this});
                    return;
                }
                TicketDeatilActivity.this.showScreenTicklet(userTicketTable, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showScreenTicklet(UserTicketTable userTicketTable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81146770")) {
            ipChange.ipc$dispatch("81146770", new Object[]{this, userTicketTable, str});
        } else if (!isFinishing() && this.ticketDeatilResult != null) {
            try {
                TickletScreenCapture tickletScreenCapture = new TickletScreenCapture();
                this.mTickletScreenFragment = tickletScreenCapture;
                tickletScreenCapture.setTickletDetailInterface(this);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", userTicketTable);
                bundle.putString(TicketDetailExtFragment.PERFORM_ID, this.performId);
                bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, this.productSystemId);
                bundle.putString("projectId", this.ticketDeatilResult.getProjectId());
                bundle.putInt("souvenirState", this.ticketDeatilResult.getEsouvenirEnable());
                bundle.putString("from", TickletScreenCapture.CAPTURE_FROM_DETAIL);
                bundle.putString("imagePath", str);
                this.mTickletScreenFragment.setArguments(bundle);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                this.fm = supportFragmentManager;
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                this.transaction = beginTransaction;
                beginTransaction.replace(R$id.ticklet_screen_container, this.mTickletScreenFragment);
                if (!this.fm.isDestroyed()) {
                    this.transaction.commitAllowingStateLoss();
                    this.flScreen.setVisibility(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void updatePageUT(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497909385")) {
            ipChange.ipc$dispatch("1497909385", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        HashMap hashMap = new HashMap();
        String str = "1";
        hashMap.put("type", z ? str : "0");
        if (!z2) {
            str = "0";
        }
        hashMap.put("nft_type", str);
        hashMap.put("item_id", getProjectId());
        hashMap.put("screening_id", getPerformId());
        a.b bVar = new a.b();
        bVar.i(sl2.TICKLET_DETAIL_PAGE).j(hashMap);
        cn.damai.common.user.c.e().l(this, bVar);
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void captureGoTransferManagePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923075037")) {
            ipChange.ipc$dispatch("923075037", new Object[]{this});
            return;
        }
        lw2.f().j(this, this.performId, this.productSystemId, 101);
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void cardCorrespondingNumRequest(String str, String str2, final String str3, final String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727382118")) {
            ipChange.ipc$dispatch("1727382118", new Object[]{this, str, str2, str3, str4});
            return;
        }
        if (this.ticketDeatilResult != null) {
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "ticket_info", "nocardbtn", sl2.j().s(getProjectId(), str2), Boolean.FALSE));
        }
        TickletForgetCardRequest tickletForgetCardRequest = new TickletForgetCardRequest();
        tickletForgetCardRequest.voucherUniqueKey = str;
        startProgressDialog();
        tickletForgetCardRequest.request(new DMMtopRequestListener<TickletForgetCardResult>(TickletForgetCardResult.class) {
            /* class cn.damai.ticklet.ui.activity.TicketDeatilActivity.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-215362773")) {
                    ipChange.ipc$dispatch("-215362773", new Object[]{this, str, str2});
                    return;
                }
                TicketDeatilActivity.this.stopProgressDialog();
                if ("FORGOT_ERROR_CARD_EXCHANGE_NO_DATA".equals(str)) {
                    new f4(TicketDeatilActivity.this).i(TicketDeatilActivity.this.getResources().getString(R$string.ticklet_ticket_dialog_fail_title)).c(false).g(str2, null).h(TicketDeatilActivity.this.getResources().getString(R$string.ticklet_know), null).j();
                } else {
                    ToastUtil.a().e(TicketDeatilActivity.this, str2);
                }
                TicketDeatilActivity.this.forgetCardGetErrorXFlushMonitor(str, str2);
            }

            public void onSuccess(TickletForgetCardResult tickletForgetCardResult) {
                ArrayList<TickletForgetCardResult.TickletForgetCardData> arrayList;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-49948470")) {
                    ipChange.ipc$dispatch("-49948470", new Object[]{this, tickletForgetCardResult});
                    return;
                }
                TicketDeatilActivity.this.stopProgressDialog();
                if (tickletForgetCardResult != null && (arrayList = tickletForgetCardResult.forgotCardInfos) != null && arrayList.size() > 0) {
                    TicketDeatilActivity.this.showTickletForgetCard(tickletForgetCardResult, str3, str4);
                }
            }
        });
    }

    @Override // cn.damai.ticklet.inteface.TickletPerformCallBack
    public void closeNotice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113856166")) {
            ipChange.ipc$dispatch("-2113856166", new Object[]{this});
            return;
        }
        NotificationFragment notificationFragment = this.noticeFragemnt;
        if (notificationFragment != null && notificationFragment.isVisible()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.noticeFragemnt);
            beginTransaction.commitAllowingStateLoss();
            this.noticeFragemnt = null;
            if (this.hanlder == null) {
                this.hanlder = new e();
            }
            this.hanlder.sendEmptyMessageDelayed(100, 350);
        }
    }

    public void closeTickletDialog(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72075313")) {
            ipChange.ipc$dispatch("72075313", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TickletDialogShowFragment tickletDialogShowFragment = this.dialogShowFragment;
        if (tickletDialogShowFragment != null && tickletDialogShowFragment.isVisible()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.dialogShowFragment);
            beginTransaction.commitAllowingStateLoss();
            k42.b(this, k42.a(this));
            if (this.hanlder == null) {
                this.hanlder = new e();
            }
            this.hanlder.sendEmptyMessageDelayed(100, 350);
        }
        TickletTicketItemDigitalTicketsView.SHOW_TYPE = 1;
        viewPageSlide(i);
        viewPageViewType(1);
    }

    @Override // cn.damai.ticklet.inteface.TickletDetailCallback
    public void closeTickletForgetCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422999837")) {
            ipChange.ipc$dispatch("1422999837", new Object[]{this});
            return;
        }
        TickletForgetCardFragment tickletForgetCardFragment = this.forgetCardFragment;
        if (tickletForgetCardFragment != null && tickletForgetCardFragment.isVisible()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.forgetCardFragment);
            beginTransaction.commitAllowingStateLoss();
            this.forgetCardFragment = null;
            if (this.hanlder == null) {
                this.hanlder = new e();
            }
            this.hanlder.sendEmptyMessageDelayed(100, 350);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444509672")) {
            ipChange.ipc$dispatch("1444509672", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void getAllExtras() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129270738")) {
            ipChange.ipc$dispatch("2129270738", new Object[]{this});
        } else if (getIntent() != null) {
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.orderId = getIntent().getStringExtra("orderId");
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
            this.history = Boolean.valueOf(getIntent().getBooleanExtra("history", false));
            if (!yf2.c(this.orderId) || this.history.booleanValue() || !hl2.a().booleanValue()) {
                this.isCloseLocal = Boolean.TRUE;
            }
            this.from = getIntent().getStringExtra("from");
            this.ticketDeatilResult = (TicketDeatilResult) getIntent().getSerializableExtra("ticketDeatilResult");
        }
    }

    public int getBarStatusBarHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-767808654")) {
            return this.barStatusBarHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("-767808654", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1478076674")) {
            return R$layout.activity_ticklet_deatil;
        }
        return ((Integer) ipChange.ipc$dispatch("1478076674", new Object[]{this})).intValue();
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757424634")) {
            return (String) ipChange.ipc$dispatch("-1757424634", new Object[]{this});
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        return (ticketDeatilResult2 == null || TextUtils.isEmpty(ticketDeatilResult2.getPerformId())) ? "" : this.ticketDeatilResult.getPerformId();
    }

    public String getProductSystemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878887331")) {
            return (String) ipChange.ipc$dispatch("878887331", new Object[]{this});
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        return (ticketDeatilResult2 == null || ticketDeatilResult2.getUserPerformVO() == null) ? "" : this.ticketDeatilResult.getUserPerformVO().productSystemId;
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185947070")) {
            return (String) ipChange.ipc$dispatch("1185947070", new Object[]{this});
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        return (ticketDeatilResult2 == null || TextUtils.isEmpty(ticketDeatilResult2.getProjectId())) ? "" : this.ticketDeatilResult.getProjectId();
    }

    public int getTitleHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "63829866")) {
            return this.titleHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("63829866", new Object[]{this})).intValue();
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466976700")) {
            return (String) ipChange.ipc$dispatch("-1466976700", new Object[]{this});
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        return (ticketDeatilResult2 == null || TextUtils.isEmpty(ticketDeatilResult2.getVenueName())) ? "" : this.ticketDeatilResult.getVenueName();
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void goFeedBackPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244566766")) {
            ipChange.ipc$dispatch("244566766", new Object[]{this, str});
            return;
        }
        onFeedbackClick(getDetectBean(str), this);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008705209")) {
            ipChange.ipc$dispatch("1008705209", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        startProgressDialog();
        onRefresh();
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void hideTickletShowAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005091192")) {
            ipChange.ipc$dispatch("-2005091192", new Object[]{this});
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fm = supportFragmentManager;
        if (supportFragmentManager == null) {
            this.mTickletScreenFragment = null;
            this.flScreen.setVisibility(8);
            return;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        this.transaction = beginTransaction;
        beginTransaction.remove(this.mTickletScreenFragment);
        this.transaction.commitAllowingStateLoss();
        this.mTickletScreenFragment = null;
        this.flScreen.setVisibility(8);
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity
    public void initMap(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179079926")) {
            ipChange.ipc$dispatch("1179079926", new Object[]{this, bundle});
            return;
        }
        this.savedInstanceState = bundle;
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719015790")) {
            ipChange.ipc$dispatch("-1719015790", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletDetailCallback
    public void initVenueMap(TextureMapView textureMapView, TicketExtMapBean ticketExtMapBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006976364")) {
            ipChange.ipc$dispatch("-1006976364", new Object[]{this, textureMapView, ticketExtMapBean});
            return;
        }
        this.gd_map = textureMapView;
        if (ticketExtMapBean != null) {
            this.venueViewBean = ticketExtMapBean;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934726859")) {
            ipChange.ipc$dispatch("934726859", new Object[]{this});
            return;
        }
        fl2.a();
        getAllExtras();
        hideBaseLayout();
        initViewUI();
        String b2 = qb0.b();
        if (!TextUtils.isEmpty(b2)) {
            setTitleBackgroundColor(Color.parseColor("#ffffff"));
            this.td_header.fixStatusBar(true);
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            hashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, this.productSystemId);
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, this.performId);
            hashMap.put("orderId", this.orderId);
            bundle.putString("url", WebViewUtil.appendQueryParameter(b2, hashMap));
            WebViewFragment webViewFragment = new WebViewFragment();
            this.downH5Fragment = webViewFragment;
            webViewFragment.setArguments(bundle);
            this.downH5Fragment.setListener(new b());
            getSupportFragmentManager().beginTransaction().replace(R$id.onearch_fragment_container, this.downH5Fragment).commitAllowingStateLoss();
        } else {
            onRefreshDetail();
        }
        this.titleHeight = Math.round(getResources().getDimension(R$dimen.ticklet_list_title_height));
    }

    public boolean isDialogShowFragmentHide() {
        TickletDialogShowFragment tickletDialogShowFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371153245")) {
            return ((Boolean) ipChange.ipc$dispatch("-1371153245", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.mTickletDialogContainer;
        if (frameLayout == null || frameLayout.getVisibility() != 8 || (tickletDialogShowFragment = this.dialogShowFragment) == null || tickletDialogShowFragment.isVisible()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488476174")) {
            ipChange.ipc$dispatch("-488476174", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        WebViewFragment webViewFragment = this.downH5Fragment;
        if (webViewFragment != null) {
            webViewFragment.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            g91.b("ticket_detail", "RESULT_OK");
            if (i == 100) {
                il2 il2 = this.detailServer;
                if (il2 != null) {
                    il2.a(this.td_header);
                }
            } else if (i == 101) {
                onRefresh();
            } else if (i == 1000) {
                if (intent != null) {
                    intent.getBooleanExtra("faceSettingSuccess", false);
                    onRefresh();
                }
            } else if (i == 1000) {
                g91.b("ticket_detail", "客服登录");
            } else if (i == 1001) {
                onRefresh();
            }
        } else {
            g91.b("ticket_detail", "RESULT_OK_no");
        }
    }

    public void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203366890")) {
            ipChange.ipc$dispatch("1203366890", new Object[]{this});
            return;
        }
        WebViewFragment webViewFragment = this.downH5Fragment;
        if (webViewFragment != null && webViewFragment.backPressed()) {
            return;
        }
        if (FROM_PUSH.equals(this.from) || FROM_OTHER.equals(this.from) || FROM_ACCEPT_TICKET.equals(this.from) || FROM_HOME_ALERT.equals(this.from)) {
            Intent intent = new Intent();
            intent.setClass(this, TickletListActivity.class);
            startActivity(intent);
            finish();
            if (Build.VERSION.SDK_INT >= 5) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247301647")) {
            ipChange.ipc$dispatch("-247301647", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.ticklet_container) {
            TickletForgetCardFragment tickletForgetCardFragment = this.forgetCardFragment;
            if (tickletForgetCardFragment == null || !tickletForgetCardFragment.isVisible()) {
                NotificationFragment notificationFragment = this.noticeFragemnt;
                if (notificationFragment == null || !notificationFragment.isVisible()) {
                    TickletDialogShowFragment tickletDialogShowFragment = this.dialogShowFragment;
                    if (tickletDialogShowFragment != null) {
                        closeTickletDialog(tickletDialogShowFragment.getCurrentItemPos());
                    } else {
                        closeTickletDialog(0);
                    }
                } else {
                    closeNotice();
                }
            } else {
                closeTickletForgetCard();
            }
        }
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
    public void onClose(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354109358")) {
            ipChange.ipc$dispatch("-1354109358", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        closeTickletDialog(i);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846342031")) {
            ipChange.ipc$dispatch("1846342031", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(sl2.j().k(sl2.TICKLET_DETAIL_PAGE));
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.ticklet_container);
        this.mTickletDialogContainer = frameLayout;
        frameLayout.setOnClickListener(this);
        cn.damai.common.user.c.e().K(this);
        TickletTicketItemDigitalTicketsView.SHOW_TYPE = -1;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, androidx.fragment.app.FragmentActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251035791")) {
            ipChange.ipc$dispatch("251035791", new Object[]{this});
            return;
        }
        super.onDestroy();
        il2 il2 = this.detailServer;
        if (il2 != null) {
            il2.c();
        }
        pl2 pl2 = this.server;
        if (pl2 != null) {
            pl2.removeObserver(this);
        }
        TickletDetailViewPager tickletDetailViewPager = this.viewPager;
        if (tickletDetailViewPager != null) {
            tickletDetailViewPager.onDestory();
        }
        e eVar = this.hanlder;
        if (eVar != null) {
            eVar.removeCallbacks(null);
            this.hanlder = null;
        }
        TickletAnimWindow tickletAnimWindow = this.mapAppWindow;
        if (tickletAnimWindow != null) {
            tickletAnimWindow.onDestory();
            this.mapAppWindow = null;
        }
        TextureMapView textureMapView = this.gd_map;
        if (textureMapView != null) {
            textureMapView.onDestroy();
        }
        this.downH5Fragment = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192047077")) {
            return ((Boolean) ipChange.ipc$dispatch("1192047077", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            TickletDialogShowFragment tickletDialogShowFragment = this.dialogShowFragment;
            if (tickletDialogShowFragment == null || !tickletDialogShowFragment.isVisible() || this.mTickletDialogContainer.getVisibility() != 0) {
                TickletForgetCardFragment tickletForgetCardFragment = this.forgetCardFragment;
                if (tickletForgetCardFragment == null || !tickletForgetCardFragment.isVisible() || this.mTickletDialogContainer.getVisibility() != 0) {
                    onBackPresss();
                } else {
                    closeTickletForgetCard();
                    return true;
                }
            } else {
                closeTickletDialog(this.dialogShowFragment.getCurrentItemPos());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043711512")) {
            ipChange.ipc$dispatch("-2043711512", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "486133676")) {
            ipChange.ipc$dispatch("486133676", new Object[]{this, view});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400458029")) {
            ipChange.ipc$dispatch("400458029", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity
    public void onLoginSuccessBus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541092163")) {
            ipChange.ipc$dispatch("541092163", new Object[]{this});
            return;
        }
        onRefresh();
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener, cn.damai.ticklet.ui.activity.DamaiMapBaseActivity
    public void onMapClick(LatLng latLng) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254935419")) {
            ipChange.ipc$dispatch("254935419", new Object[]{this, latLng});
            return;
        }
        gotoVenuePage();
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener, cn.damai.ticklet.ui.activity.DamaiMapBaseActivity
    public boolean onMarkerClick(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865497391")) {
            return ((Boolean) ipChange.ipc$dispatch("-1865497391", new Object[]{this, marker})).booleanValue();
        }
        gotoVenuePage();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076847635")) {
            ipChange.ipc$dispatch("2076847635", new Object[]{this});
            return;
        }
        super.onPause();
        TextureMapView textureMapView = this.gd_map;
        if (textureMapView != null) {
            textureMapView.onPause();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530882546")) {
            ipChange.ipc$dispatch("-1530882546", new Object[]{this});
            return;
        }
        onRefreshDetail();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605553748")) {
            ipChange.ipc$dispatch("1605553748", new Object[]{this});
            return;
        }
        super.onResume();
        setmDetectActivityShow(false);
        ScreenShotDetector.k().x(this.screenShotExtraListener);
        if (TickletNFTTicketItemView.jumpToAuth) {
            requestDetailData();
            TickletNFTTicketItemView.jumpToAuth = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, androidx.activity.ComponentActivity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684248662")) {
            ipChange.ipc$dispatch("-684248662", new Object[]{this, bundle});
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletPerformCallBack
    public void performCancel(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822717243")) {
            ipChange.ipc$dispatch("-1822717243", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        lw2.D(this.rlPerformCancelView, z);
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void renderFailXflush(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "332504842")) {
            ipChange.ipc$dispatch("332504842", new Object[]{this, str});
        } else if (this.isCloseLocal.booleanValue()) {
            if (this.rendererTime == 1) {
                if (!this.history.booleanValue()) {
                    renderErrorXFlushMonitor("", str, this.performId);
                } else {
                    renderHistoryErrorXFlushMonitor("", str, this.performId);
                }
                alarm("关闭本地化情况", str);
            }
        } else if (this.rendererTime == 2) {
            if (!this.history.booleanValue()) {
                renderErrorXFlushMonitor("", str, this.performId);
            } else {
                renderHistoryErrorXFlushMonitor("", str, this.performId);
            }
            alarm("开启本地化情况", str);
        }
    }

    public void requestLocalDetailData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982312265")) {
            ipChange.ipc$dispatch("1982312265", new Object[]{this});
        } else if (!this.isCloseLocal.booleanValue()) {
            startProgressDialog();
            ns1.a(new PriorityTask("DETAIL_DB_GET_DATA", this) {
                /* class cn.damai.ticklet.ui.activity.TicketDeatilActivity.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "562130082")) {
                        ipChange.ipc$dispatch("562130082", new Object[]{this});
                        return;
                    }
                    DataHelper instance = DataHelper.getInstance();
                    int i = TicketDeatilActivity.this.page;
                    TicketDeatilActivity ticketDeatilActivity = TicketDeatilActivity.this;
                    final TicketDeatilResult deatilList = instance.getDeatilList(i, ticketDeatilActivity.performId, ticketDeatilActivity.productSystemId);
                    if (deatilList != null && deatilList.getUserPerformVO() != null) {
                        TicketDeatilActivity.this.runOnUiThread(new Runnable() {
                            /* class cn.damai.ticklet.ui.activity.TicketDeatilActivity.AnonymousClass6.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "207371936")) {
                                    ipChange.ipc$dispatch("207371936", new Object[]{this});
                                } else if (deatilList != null) {
                                    TicketDeatilActivity.this.stopProgressDialog();
                                    TicketDeatilActivity.access$308(TicketDeatilActivity.this);
                                    TicketDeatilActivity.this.resetTickletDetailUI(deatilList, Boolean.TRUE);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void resetTickletDetailUI(TicketDeatilResult ticketDeatilResult2, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049520709")) {
            ipChange.ipc$dispatch("2049520709", new Object[]{this, ticketDeatilResult2, bool});
        } else if (ticketDeatilResult2 != null && ticketDeatilResult2.getUserPerformVO() != null) {
            updatePageUT(ticketDeatilResult2.isLivePerform(), ticketDeatilResult2.isNftPerform());
            if (!bool.booleanValue()) {
                this.utTimeUtils.q(ticketDeatilResult2.loadTime);
            } else {
                this.utTimeUtils.m(ticketDeatilResult2.loadTime);
            }
            this.ticketDeatilResult = ticketDeatilResult2;
            if ((!yf2.c(this.orderId) && yf2.c(this.performId)) || (!TextUtils.isEmpty(ticketDeatilResult2.getPerformId()) && !ticketDeatilResult2.getPerformId().equals(this.performId))) {
                this.performId = ticketDeatilResult2.getPerformId();
                this.productSystemId = ticketDeatilResult2.getUserPerformVO().productSystemId;
            }
            ticketDeatilResult2.getMainColorFun();
            ticketDeatilResult2.setBgGradientColors(lw2.f().c(ticketDeatilResult2.getColor(), ticketDeatilResult2.getPerformExtAttr() != null ? ticketDeatilResult2.getPerformExtAttr().bgColor : null));
            ticketDeatilResult2.setBgGradientPostions(lw2.f().h(ticketDeatilResult2.isNftPerform(), ticketDeatilResult2.getBgGradientColors()));
            this.utTimeUtils.l();
            isShowRightView();
            this.detailServer.b(ticketDeatilResult2);
            addContentFragment(ticketDeatilResult2);
            setTitleBackgroundColor(ticketDeatilResult2.getColor());
            if (!bool.booleanValue()) {
                if (!TextUtils.isEmpty(ticketDeatilResult2.getTransferBackDesc())) {
                    this.rlPerformCancelView.setVisibility(0);
                    this.cancelView.setVisibility(0);
                    this.cancelView.setCallback(this);
                    this.rlPerformCancelView.setOnClickListener(null);
                    this.cancelView.update(ticketDeatilResult2.getTransferBackDesc(), ticketDeatilResult2.getTransferBackUrl(), this.performId, getProjectId());
                } else {
                    this.rlPerformCancelView.setVisibility(8);
                    this.cancelView.setVisibility(8);
                }
            }
            this.utTimeUtils.p(getWindow().getDecorView());
            vl2.b(vl2.TICKLET_PERFORM_DETAIL_RENDER_POINT, "mtop.damai.wireless.ticklet2.perform.detail.get");
        } else if (ticketDeatilResult2 == null || ticketDeatilResult2.getEmptyDataVO() == null) {
            renderFailXflush(vl2.TICKLET_PERFORM_DETAIL_RENDER_DATA_FAIL_MSG);
        } else {
            returnDetailDataError(ticketDeatilResult2.getEmptyDataVO().emptyDataMsg, "");
        }
    }

    public void setBarStatusBarHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483910288")) {
            ipChange.ipc$dispatch("-1483910288", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.barStatusBarHeight = i;
    }

    @Override // cn.damai.ticklet.inteface.TickletPerformCallBack
    public void setDetailViewPager(TickletDetailViewPager tickletDetailViewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593352201")) {
            ipChange.ipc$dispatch("-1593352201", new Object[]{this, tickletDetailViewPager});
            return;
        }
        this.viewPager = tickletDetailViewPager;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1978049526")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1978049526", new Object[]{this});
    }

    public void showDetectView(String str) {
        List<UserTicketTable> g;
        UserTicketTable userTicketTable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30425947")) {
            ipChange.ipc$dispatch("-30425947", new Object[]{this, str});
            return;
        }
        TickletDetailViewPager tickletDetailViewPager = this.viewPager;
        if (tickletDetailViewPager != null && tickletDetailViewPager.getPagerAdapter() != null && (g = this.viewPager.getPagerAdapter().g()) != null && g.size() > 0 && (userTicketTable = g.get(this.viewPager.getCurrentItem())) != null) {
            if (userTicketTable.isLiveTicket() && "1".equals(this.ticketDeatilResult.getLiveType())) {
                lw2.f().m(this, userTicketTable.performId, userTicketTable.getProductSystemId(), true, this.ticketDeatilResult.getProjectImage(), this.ticketDeatilResult.getItemId(), this.ticketDeatilResult.getProjectName(), b30.h(this.ticketDeatilResult.getBeginTime(), "yyyy.MM.dd | HH:mm"), this.ticketDeatilResult.getLiveH5Url(), "截图已保存至相册", false);
            } else if (userTicketTable.isPaperTicket()) {
                showCapture(userTicketTable, str);
            } else {
                showCapture(userTicketTable, str);
            }
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletPerformCallBack
    public void showNotice(TickletStatusNotice tickletStatusNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577466305")) {
            ipChange.ipc$dispatch("577466305", new Object[]{this, tickletStatusNotice});
            return;
        }
        FrameLayout frameLayout = this.mTickletDialogContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.mTickletDialogContainer.setBackgroundColor(Color.parseColor("#99000000"));
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            NotificationFragment newInstance = NotificationFragment.newInstance(tickletStatusNotice);
            this.noticeFragemnt = newInstance;
            newInstance.setCallBack(this);
            beginTransaction.replace(R$id.ticklet_container, this.noticeFragemnt);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void showTickletDialog(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498549048")) {
            ipChange.ipc$dispatch("498549048", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", str);
        TicketDeatilResult ticketDeatilResult2 = this.ticketDeatilResult;
        if (ticketDeatilResult2 != null) {
            hashMap.put("item_id", ticketDeatilResult2.getProjectId());
            hashMap.put("titlelabel", i + "");
        }
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "ticket_info", sl2.TICKLET_VOUCHER, hashMap, Boolean.TRUE));
        FrameLayout frameLayout = this.mTickletDialogContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            TickletDialogShowFragment instance = TickletDialogShowFragment.getInstance(str, this.orderId, this.productSystemId, this.ticketDeatilResult, i, TickletDialogShowFragment.SHOW_TICKLET_FROM_DETAIL);
            this.dialogShowFragment = instance;
            instance.setOnClickCloseListener(this);
            beginTransaction.replace(R$id.ticklet_container, this.dialogShowFragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletDetailCallback
    public void showTickletForgetCard(TickletForgetCardResult tickletForgetCardResult, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1129582332")) {
            ipChange.ipc$dispatch("-1129582332", new Object[]{this, tickletForgetCardResult, str, str2});
            return;
        }
        FrameLayout frameLayout = this.mTickletDialogContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            TickletForgetCardFragment instance = TickletForgetCardFragment.getInstance(tickletForgetCardResult, str, str2, this.performId);
            this.forgetCardFragment = instance;
            instance.setOnClickCloseListener(this);
            beginTransaction.replace(R$id.ticklet_container, this.forgetCardFragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // cn.damai.ticklet.ui.observer.ObserverTicket
    public void update(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452394362")) {
            ipChange.ipc$dispatch("-1452394362", new Object[]{this, userTicketTable});
            return;
        }
        updateTicketSate(userTicketTable);
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
    public void updateTicketSate(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202318801")) {
            ipChange.ipc$dispatch("202318801", new Object[]{this, userTicketTable});
            return;
        }
        TickletDetailViewPager tickletDetailViewPager = this.viewPager;
        if (tickletDetailViewPager != null) {
            tickletDetailViewPager.updateTicket(userTicketTable);
        }
        TickletForgetCardFragment tickletForgetCardFragment = this.forgetCardFragment;
        if (tickletForgetCardFragment != null && tickletForgetCardFragment.isVisible() && this.mTickletDialogContainer.getVisibility() == 0) {
            this.forgetCardFragment.notifyData(userTicketTable);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void viewPageSlide(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287421942")) {
            ipChange.ipc$dispatch("1287421942", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TickletDetailViewPager tickletDetailViewPager = this.viewPager;
        if (tickletDetailViewPager != null) {
            tickletDetailViewPager.setCurrentItem(i);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void viewPageViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997555146")) {
            ipChange.ipc$dispatch("-1997555146", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
