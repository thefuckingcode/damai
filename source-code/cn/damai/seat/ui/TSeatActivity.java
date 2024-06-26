package cn.damai.seat.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.contract.TbSeatContract;
import cn.damai.seat.helper.AnimatorHelper;
import cn.damai.seat.helper.SeatListLayerPanel;
import cn.damai.seat.helper.SeatListV2Panel;
import cn.damai.seat.helper.SeatLoadingPanel;
import cn.damai.seat.helper.SeatPriceListPanel;
import cn.damai.seat.helper.SeatVrTipPanel;
import cn.damai.seat.listener.OnSeatRemoveListener;
import cn.damai.seat.model.TSeatModel2;
import cn.damai.seat.presenter.TSeatPresenter;
import cn.damai.seat.view.RegionSeatView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.monitor.procedure.ViewToken;
import java.util.List;
import tb.bd;
import tb.e72;
import tb.gr;
import tb.h72;
import tb.kf1;
import tb.p72;
import tb.t72;
import tb.u72;
import tb.v62;
import tb.wn1;
import tb.xs0;

/* compiled from: Taobao */
public class TSeatActivity extends BaseSeatActivity<TSeatPresenter, TSeatModel2> implements TbSeatContract.TbSeatView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isFirst = true;
    private View mBack2VenueBtn;
    private View mBack2VenueTag;
    private TextView mBack2VenueText;
    private v62 mBottomPanel;
    private e72 mDiffRowPanel;
    private ViewGroup mFgContainer;
    private SeatLoadingPanel mLoadingPanel;
    private ViewGroup mMainView;
    private kf1 mMonitor;
    private TbParams mParams;
    private SeatListLayerPanel mPriceDetailPopUpPanel;
    private SeatListV2Panel mSeatListV2HolScrollPanel;
    private RegionSeatView mSeatView;
    private SeatVrTipPanel mVRTipPanel;
    private FrameLayout mViewContainer;
    private long start;

    /* compiled from: Taobao */
    public class a extends v62 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Activity activity, View view) {
            super(activity, view);
        }

        @Override // tb.v62
        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315943913")) {
                ipChange.ipc$dispatch("-1315943913", new Object[]{this});
                return;
            }
            ((TSeatPresenter) TSeatActivity.this.mPresenter).onConfirmClick();
        }

        @Override // tb.v62
        public void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-753600851")) {
                ipChange.ipc$dispatch("-753600851", new Object[]{this});
                return;
            }
            TSeatActivity.this.mPriceDetailPopUpPanel.h(!TSeatActivity.this.mPriceDetailPopUpPanel.d());
        }
    }

    /* compiled from: Taobao */
    public class b implements SeatListLayerPanel.OnPanelStateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.seat.helper.SeatListLayerPanel.OnPanelStateListener
        public void onExpandChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169971396")) {
                ipChange.ipc$dispatch("1169971396", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                cn.damai.common.user.c.e().x(p72.l().n(TSeatActivity.this.mParams.itemId + "", TSeatActivity.this.mParams.performId + ""));
            }
            TSeatActivity.this.mBottomPanel.d(!z);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnSeatRemoveListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.seat.listener.OnSeatRemoveListener
        public void onSeatRemove(SeatNew seatNew) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1782571549")) {
                ipChange.ipc$dispatch("1782571549", new Object[]{this, seatNew});
                return;
            }
            ((TSeatPresenter) TSeatActivity.this.mPresenter).onSeatChanged(seatNew, false);
        }
    }

    /* compiled from: Taobao */
    public class d extends SeatVrTipPanel {
        private static transient /* synthetic */ IpChange $ipChange;

        d(Activity activity, View view) {
            super(activity, view);
        }

        @Override // cn.damai.seat.helper.SeatVrTipPanel
        public void k() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1243179784")) {
                ipChange.ipc$dispatch("1243179784", new Object[]{this});
                return;
            }
            if (TSeatActivity.this.mParams != null) {
                cn.damai.common.user.c.e().x(p72.l().k(TSeatActivity.this.mParams.itemId + "", TSeatActivity.this.mParams.performId + ""));
            }
            ((TSeatPresenter) TSeatActivity.this.mPresenter).onVRInfoClick();
        }
    }

    /* compiled from: Taobao */
    public class e implements SeatVrTipPanel.VrThumbViewEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.seat.helper.SeatVrTipPanel.VrThumbViewEventListener
        public void onVrThumbViewHide() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1449820326")) {
                ipChange.ipc$dispatch("1449820326", new Object[]{this});
            } else if (TSeatActivity.this.mSeatView != null) {
                TSeatActivity.this.mSeatView.isShowOverView(true);
            }
        }

        @Override // cn.damai.seat.helper.SeatVrTipPanel.VrThumbViewEventListener
        public void onVrThumbViewShown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-863042191")) {
                ipChange.ipc$dispatch("-863042191", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements RegionSeatView.OnSeatViewListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a extends AnimatorListenerAdapter {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "504126935")) {
                    ipChange.ipc$dispatch("504126935", new Object[]{this, animator});
                    return;
                }
                TSeatActivity.this.mBack2VenueTag.setVisibility(0);
                TSeatActivity.this.mBack2VenueText.setVisibility(0);
                TSeatActivity.this.mBack2VenueBtn.setBackgroundResource(R$drawable.bg_gray_corner_back);
            }
        }

        f() {
        }

        @Override // cn.damai.seat.view.RegionSeatView.OnSeatViewListener
        public void onSeatSelectChanged(SeatNew seatNew, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1077202482")) {
                ipChange.ipc$dispatch("1077202482", new Object[]{this, seatNew, Boolean.valueOf(z)});
                return;
            }
            ((TSeatPresenter) TSeatActivity.this.mPresenter).onSeatChanged(seatNew, z);
        }

        @Override // cn.damai.seat.view.RegionSeatView.OnSeatViewListener
        public void onShowBack2Venue(boolean z, boolean z2, boolean z3, Bitmap bitmap, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1261956349")) {
                ipChange.ipc$dispatch("1261956349", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (!z2) {
                TSeatActivity.this.mBack2VenueBtn.setVisibility(8);
            } else if (TSeatActivity.this.mBack2VenueBtn.getVisibility() != 0) {
                int dip2px = ScreenUtil.dip2px(xs0.a(), 124.0f);
                int dip2px2 = ScreenUtil.dip2px(xs0.a(), 30.0f);
                if (!z3 || bitmap == null || i <= 0 || i2 <= 0) {
                    TSeatActivity.this.mBack2VenueTag.setVisibility(0);
                    TSeatActivity.this.mBack2VenueText.setVisibility(0);
                    TSeatActivity.this.mBack2VenueBtn.setVisibility(0);
                    return;
                }
                TSeatActivity.this.mBack2VenueBtn.setBackgroundDrawable(new BitmapDrawable(bitmap));
                TSeatActivity.this.mBack2VenueBtn.setVisibility(0);
                TSeatActivity.this.mBack2VenueTag.setVisibility(4);
                TSeatActivity.this.mBack2VenueText.setVisibility(4);
                AnimatorHelper.b(TSeatActivity.this.mBack2VenueBtn, i, dip2px, i2, dip2px2, new a());
            }
        }

        @Override // cn.damai.seat.view.RegionSeatView.OnSeatViewListener
        public void onVenueModeChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586388018")) {
                ipChange.ipc$dispatch("586388018", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            TSeatActivity.this.mBottomPanel.a(z);
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1585442919")) {
                ipChange.ipc$dispatch("-1585442919", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            TSeatActivity.this.setResult(-1);
            TSeatActivity.this.finish();
        }
    }

    private void commitUiShowTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307697596")) {
            ipChange.ipc$dispatch("1307697596", new Object[]{this});
            return;
        }
        kf1 kf1 = this.mMonitor;
        if (kf1 != null && !kf1.h()) {
            new Handler().post(new Runnable() {
                /* class cn.damai.seat.ui.TSeatActivity.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-286469829")) {
                        ipChange.ipc$dispatch("-286469829", new Object[]{this});
                    } else if (TSeatActivity.this.mMonitor != null && !TSeatActivity.this.isFinishing()) {
                        if (AppConfig.v()) {
                            long currentTimeMillis = System.currentTimeMillis() - TSeatActivity.this.start;
                            Log.i("APMLogger", "页面加载耗时" + currentTimeMillis + "ms");
                        }
                        TSeatActivity.this.mMonitor.c(kf1.TYPE_QL_SVG_ACTIVITY_SHOW, 0);
                    }
                }
            });
        }
    }

    private void showTestViewInDebugMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932551204")) {
            ipChange.ipc$dispatch("-1932551204", new Object[]{this});
        } else if (AppConfig.v()) {
            TextView textView = (TextView) findViewById(R$id.seat_test);
            textView.setOnClickListener(this);
            boolean z = RegionSeatView.isShowSvgRegionBound;
            TbParams tbParams = this.mParams;
            boolean c2 = u72.c(tbParams == null ? 0 : tbParams.itemId, true);
            boolean g2 = bd.g(bd.BUFFER_GROUP_1);
            textView.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append("bound-");
            String str = "1";
            sb.append(z ? str : "0");
            sb.append(" hw-");
            if (!c2) {
                str = "0";
            }
            sb.append(str);
            sb.append(g2 ? " apipre-1" : " apipre-0");
            textView.setText(sb.toString());
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void dismissVRInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "988916421")) {
            ipChange.ipc$dispatch("988916421", new Object[]{this});
            return;
        }
        this.mVRTipPanel.g();
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getFragmentContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1541575679")) {
            return this.mFgContainer;
        }
        return (ViewGroup) ipChange.ipc$dispatch("1541575679", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2030349423")) {
            return R$layout.activity_seat;
        }
        return ((Integer) ipChange.ipc$dispatch("-2030349423", new Object[]{this})).intValue();
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "488572304")) {
            return this.mMainView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("488572304", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1767167647")) {
            ipChange.ipc$dispatch("-1767167647", new Object[]{this});
            return;
        }
        ((TSeatPresenter) this.mPresenter).setVM(this, (TbSeatContract.TbSeatModel) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.seat.ui.BaseSeatActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688419172")) {
            ipChange.ipc$dispatch("-1688419172", new Object[]{this});
            return;
        }
        super.initView();
        this.mBack2VenueBtn = findViewById(R$id.zw_back_2_venue_tv);
        this.mBack2VenueTag = findViewById(R$id.zw_back_2_venue_tag);
        this.mBack2VenueText = (TextView) findViewById(R$id.zw_back_2_venue_text);
        this.mBack2VenueBtn.setOnClickListener(this);
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mFgContainer = (ViewGroup) findViewById(R$id.promotion_container);
        this.mViewContainer = (FrameLayout) findViewById(R$id.seat_view_container);
        this.mFgContainer.setOnClickListener(this);
        View findViewById = findViewById(R$id.seat_jpg_bottom_bar);
        View findViewById2 = findViewById(R$id.seat_select_container);
        View findViewById3 = findViewById(R$id.bottom_bar_top_divide_line);
        this.mBottomPanel = new a(this, findViewById);
        this.mPriceDetailPopUpPanel = new SeatListLayerPanel(this, (ViewStub) findViewById(R$id.seat_selected_list_new_layer_stub), new b());
        this.mSeatListV2HolScrollPanel = new SeatListV2Panel(this, findViewById2, findViewById3, new c());
        this.mDiffRowPanel = new e72(this, (ViewStub) findViewById(R$id.diff_row_tip_stub));
        this.mLoadingPanel = new SeatLoadingPanel((ViewStub) findViewById(R$id.loading_layer_stub));
        d dVar = new d(this, findViewById(R$id.layout_vr_thumb));
        this.mVRTipPanel = dVar;
        dVar.l(new e());
        this.mParams = (TbParams) obtainExtra();
        showTestViewInDebugMode();
        TbParams tbParams = this.mParams;
        if (tbParams != null) {
            ((TSeatPresenter) this.mPresenter).start(tbParams);
            this.mSeatListV2HolScrollPanel.i(this.mParams);
            setDamaiUTKeyBuilder(p72.l().s(this.mParams.itemId, true));
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void invalidateSeatView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265580852")) {
            ipChange.ipc$dispatch("-265580852", new Object[]{this});
            return;
        }
        RegionSeatView regionSeatView = this.mSeatView;
        if (regionSeatView != null) {
            regionSeatView.invalidate();
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409628035")) {
            ipChange.ipc$dispatch("-1409628035", new Object[]{this});
            return;
        }
        SeatListLayerPanel seatListLayerPanel = this.mPriceDetailPopUpPanel;
        if (seatListLayerPanel != null && seatListLayerPanel.d()) {
            this.mPriceDetailPopUpPanel.h(false);
        } else if (!dismissFragment(this.mFragment, this.mFgContainer)) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502104190")) {
            ipChange.ipc$dispatch("-502104190", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.header_promotion_desc) {
            ((TSeatPresenter) this.mPresenter).onPromotionClick();
        } else if (id == R$id.promotion_container) {
            dismissFragment(this.mFragment, this.mFgContainer);
        } else if (id == R$id.zw_back_2_venue_tv) {
            this.mBack2VenueBtn.setVisibility(8);
            if (this.mSeatView != null) {
                cn.damai.common.user.c.e().x(p72.l().j(this.mParams.itemId + "", this.mParams.performId + ""));
                this.mSeatView.zoom2FullViewMode();
            }
        } else if (id == R$id.seat_test) {
            RegionSeatView.isShowSvgRegionBound = !RegionSeatView.isShowSvgRegionBound;
            showTestViewInDebugMode();
            RegionSeatView regionSeatView = this.mSeatView;
            if (regionSeatView != null) {
                regionSeatView.invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757569506")) {
            ipChange.ipc$dispatch("-1757569506", new Object[]{this, bundle});
            return;
        }
        this.start = System.currentTimeMillis();
        this.mMonitor = new kf1(true);
        super.onCreate(bundle);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void onOpenPurchaseActivity(Bundle bundle) {
        TbParams tbParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968141564")) {
            ipChange.ipc$dispatch("968141564", new Object[]{this, bundle});
        } else if (bundle != null && (tbParams = this.mParams) != null) {
            wn1.a(this, bundle, tbParams.isUseNewUltron);
        }
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onSeatPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422787830")) {
            ipChange.ipc$dispatch("-422787830", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        ((TSeatPresenter) this.mPresenter).onPriceClick(priceLevel, i);
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onUIResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "412765905")) {
            ipChange.ipc$dispatch("412765905", new Object[]{this});
            return;
        }
        ((TSeatPresenter) this.mPresenter).refresh();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void openOrderDetailActivity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221047265")) {
            ipChange.ipc$dispatch("-1221047265", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", str);
        setResult(-1);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b(gr.h));
        finish();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showBottomBar(PriceBarInfo priceBarInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865885739")) {
            ipChange.ipc$dispatch("1865885739", new Object[]{this, priceBarInfo});
            return;
        }
        this.mBottomPanel.e(priceBarInfo);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showDiffRowView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272815816")) {
            ipChange.ipc$dispatch("-272815816", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mDiffRowPanel.b(z);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showLoadingLayer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102647179")) {
            ipChange.ipc$dispatch("-1102647179", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mLoadingPanel.d(z);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showPriceChanged(PriceLevel priceLevel, Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123860279")) {
            ipChange.ipc$dispatch("-1123860279", new Object[]{this, priceLevel, picture});
            return;
        }
        if (priceLevel != null) {
            this.mBack2VenueBtn.setVisibility(8);
        }
        SeatPriceListPanel seatPriceListPanel = this.mListPanel;
        if (seatPriceListPanel != null) {
            seatPriceListPanel.n(priceLevel);
        }
        RegionSeatView regionSeatView = this.mSeatView;
        if (regionSeatView != null) {
            regionSeatView.setSVGVenueLayerPicture(picture);
            this.mSeatView.zoomWhenSeatPriceChanged(priceLevel);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showSeatUiList(h72 h72, List<ItemSeatV2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010697793")) {
            ipChange.ipc$dispatch("-2010697793", new Object[]{this, h72, list});
            return;
        }
        this.mSeatListV2HolScrollPanel.n(h72, list);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showSeatView(t72 t72, PriceLevel priceLevel, Picture picture, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53622770")) {
            ipChange.ipc$dispatch("-53622770", new Object[]{this, t72, priceLevel, picture, Boolean.valueOf(z)});
            return;
        }
        if (this.mSeatView == null) {
            RegionSeatView regionSeatView = new RegionSeatView(this, t72.i, t72.h, this.mParams);
            this.mSeatView = regionSeatView;
            regionSeatView.setListener(new f());
            this.mViewContainer.addView(this.mSeatView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mSeatView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
        this.mSeatView.setSvgRegionLocations(t72.e);
        this.mSeatView.setRegionBounds(t72.f);
        this.mSeatView.setSvgScale(t72.g);
        this.mSeatView.setRegionPictureData(t72.c);
        this.mSeatView.setRegionInitialPictureData(t72.d);
        this.mSeatView.setSeatRequestChecker(t72.a);
        this.mSeatView.setSeatData(t72.b);
        this.mSeatView.setSelectPrice(priceLevel);
        this.mSeatView.setSVGVenueLayerPicture(picture);
        this.mSeatView.setRegions(t72.j);
        if (z) {
            this.mSeatView.invalidate();
            showLoading(false);
            if (this.isFirst) {
                this.isFirst = false;
                this.mSeatView.zoom2AdaptSeatPrice();
            }
            commitUiShowTime();
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void showTipDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318439971")) {
            ipChange.ipc$dispatch("-318439971", new Object[]{this, str});
        } else if (!isFinishing()) {
            new DMDialog(this).o(false).q(str).n(getString(R$string.confirm), new g()).show();
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void updatePromotionTags(List<ShortTag> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955382819")) {
            ipChange.ipc$dispatch("-1955382819", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        SeatListV2Panel seatListV2Panel = this.mSeatListV2HolScrollPanel;
        if (seatListV2Panel != null) {
            seatListV2Panel.m(list, z);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void updateSeatListV2Panel(List<TicketMainUiModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796930094")) {
            ipChange.ipc$dispatch("1796930094", new Object[]{this, list});
            return;
        }
        this.mPriceDetailPopUpPanel.i(list);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatView
    public void updateVRInfo(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155510135")) {
            ipChange.ipc$dispatch("1155510135", new Object[]{this, seatNew});
        } else if (seatNew != null && seatNew.vr3DImg != null) {
            RegionSeatView regionSeatView = this.mSeatView;
            if (regionSeatView != null) {
                regionSeatView.isShowOverView(false);
                this.mSeatView.invalidate();
            }
            this.mBack2VenueTag.setVisibility(0);
            this.mBack2VenueText.setVisibility(0);
            this.mBack2VenueBtn.setBackgroundResource(R$drawable.bg_gray_corner_back);
            this.mBack2VenueBtn.setVisibility(0);
            this.mVRTipPanel.n(seatNew, seatNew.vr3DImg.getThumb());
        }
    }
}
