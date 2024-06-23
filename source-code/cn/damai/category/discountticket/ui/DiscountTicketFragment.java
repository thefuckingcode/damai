package cn.damai.category.discountticket.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.contract.DiscountTicketContract;
import cn.damai.category.discountticket.model.DtProxyModel;
import cn.damai.category.discountticket.presenter.DiscountTicketPresenter;
import cn.damai.category.discountticket.util.CityListener;
import cn.damai.category.discountticket.widget.UpLoadMorePanel;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.banner.sub.BannerItem;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import tb.aj0;
import tb.d20;
import tb.hi;
import tb.ig;
import tb.kt2;
import tb.n42;
import tb.ne2;
import tb.qv1;
import tb.rv1;
import tb.s72;
import tb.tb2;

/* compiled from: Taobao */
public class DiscountTicketFragment extends CompatBaseFragment<DiscountTicketPresenter, DtProxyModel> implements DiscountTicketContract.DtView, OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String EXTRA = "extra_data";
    private static final int HEAD_HEIGHT_DP = 212;
    private static final int HEAD_WIDTH_DP = 375;
    private static final int TITLE_BAR_HEIGHT_DP = 44;
    private boolean isViewCreated = false;
    private boolean isVisibleToUser = false;
    private CityListener listener = new a();
    private FragmentActivity mActivity;
    private AppBarLayout mAppBar;
    private TextView mBackBtn;
    private TextView mBgHeaderDescTv;
    private TextView mBgHeaderTitleTv;
    private ImageView mBgImg;
    private String mChangedCityId;
    private View mDividerLine;
    private View mHeader;
    private UpLoadMorePanel mLoadMorePanel;
    private ViewGroup mMainView;
    private DtParams mParams;
    private PtrFrameLayout mPtr;
    private IRecyclerView mRecyclerView;
    private View mRootView;
    private TextView mShareBtn;
    private View mStatusBarSpace;
    private DiscountTicketAdapter mTicketAdapter;
    private View mTitleBar;
    private View mTitleBgLayout;
    private TextView mTitleTv;
    private kt2 mUt;

    /* compiled from: Taobao */
    public class a implements CityListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.category.discountticket.util.CityListener
        public void onCityChanged(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1113643900")) {
                ipChange.ipc$dispatch("1113643900", new Object[]{this, str});
                return;
            }
            DiscountTicketFragment.this.mChangedCityId = str;
        }
    }

    /* compiled from: Taobao */
    public class b extends qv1 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // tb.qv1, in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1989793742")) {
                return ((Boolean) ipChange.ipc$dispatch("-1989793742", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
            }
            RecyclerView.LayoutManager layoutManager = DiscountTicketFragment.this.mRecyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return false;
            }
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            View childAt = DiscountTicketFragment.this.mRecyclerView.getChildAt(0);
            if (findFirstVisibleItemPosition != -1 && (childAt == null || childAt.getTop() < DiscountTicketFragment.this.mRecyclerView.getPaddingTop())) {
                z = false;
            }
            return z;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1220296033")) {
                ipChange.ipc$dispatch("-1220296033", new Object[]{this, ptrFrameLayout});
                return;
            }
            ((DiscountTicketPresenter) DiscountTicketFragment.this.mPresenter).load(false);
        }
    }

    /* compiled from: Taobao */
    public class c implements PtrHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1371819217")) {
                return DiscountTicketFragment.this.mAppBar.getTop() >= 0;
            }
            return ((Boolean) ipChange.ipc$dispatch("1371819217", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1907974944")) {
                ipChange.ipc$dispatch("1907974944", new Object[]{this, ptrFrameLayout});
                return;
            }
            ((DiscountTicketPresenter) DiscountTicketFragment.this.mPresenter).load(false);
        }
    }

    /* compiled from: Taobao */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1554514288")) {
                ipChange.ipc$dispatch("-1554514288", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = ((float) Math.abs(i)) / ((float) appBarLayout.getHeight());
            if (abs > 0.5f) {
                DiscountTicketFragment.this.mBackBtn.setTextColor(-16777216);
                DiscountTicketFragment.this.mShareBtn.setBackgroundResource(R$drawable.bg_share_pink);
                DiscountTicketFragment.this.mShareBtn.setTextColor(Color.parseColor("#FF2869"));
            } else {
                DiscountTicketFragment.this.mBackBtn.setTextColor(-1);
                DiscountTicketFragment.this.mShareBtn.setBackgroundResource(R$drawable.bg_share_white);
                DiscountTicketFragment.this.mShareBtn.setTextColor(-1);
            }
            if (abs > 1.0f) {
                abs = 1.0f;
            }
            DiscountTicketFragment.this.mTitleBgLayout.setAlpha(abs);
            DiscountTicketFragment.this.mStatusBarSpace.setAlpha(abs);
            DiscountTicketFragment.this.mTitleTv.setAlpha(abs);
            DiscountTicketFragment.this.mHeader.scrollTo(0, -i);
            if (appBarLayout.getHeight() != Math.abs(i)) {
                z = false;
            }
            DiscountTicketFragment.this.mRecyclerView.setBackgroundResource(z ? R$drawable.bg_white : R$drawable.discount_lv_bg);
        }
    }

    /* compiled from: Taobao */
    public class e implements DiscountTicketAdapter.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onBannerClick(BannerItem bannerItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1694562268")) {
                ipChange.ipc$dispatch("-1694562268", new Object[]{this, bannerItem, Integer.valueOf(i)});
            } else if (bannerItem != null) {
                kt2.g(DiscountTicketFragment.this.mUt.f(bannerItem, i));
                DMNav.from(DiscountTicketFragment.this.mActivity).toUri(bannerItem.bannerUrl());
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onGetCouponClick(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "660583225")) {
                ipChange.ipc$dispatch("660583225", new Object[]{this, headerCouponBean, couponActivityBean});
            } else if (!s72.c()) {
                if (couponActivityBean.isCanApply()) {
                    kt2.g(DiscountTicketFragment.this.mUt.h(headerCouponBean.pos(couponActivityBean), couponActivityBean.id));
                    ((DiscountTicketPresenter) DiscountTicketFragment.this.mPresenter).applyCoupon(headerCouponBean, couponActivityBean);
                } else if (couponActivityBean.isGotCoupon()) {
                    DiscountTicketFragment.this.showErrorTip("已领过啦");
                } else {
                    String unapplicableCause = couponActivityBean.getUnapplicableCause();
                    if (!TextUtils.isEmpty(unapplicableCause)) {
                        DiscountTicketFragment.this.showErrorTip(unapplicableCause);
                    }
                }
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onProjectItemClick(ProjectItemBean projectItemBean, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2042754681")) {
                ipChange.ipc$dispatch("-2042754681", new Object[]{this, projectItemBean, Boolean.valueOf(z)});
            } else if (!s72.c()) {
                DiscountTicketFragment.this.openProjectActivity(projectItemBean, z);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onTipLinkClick(HeaderCouponBean headerCouponBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-338504933")) {
                ipChange.ipc$dispatch("-338504933", new Object[]{this, headerCouponBean});
            } else if (headerCouponBean != null && !TextUtils.isEmpty(headerCouponBean.h5Url)) {
                DMNav.from(DiscountTicketFragment.this.mActivity).toUri(headerCouponBean.h5Url);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onViewMoreClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "82481927")) {
                ipChange.ipc$dispatch("82481927", new Object[]{this});
            } else if (!s72.c()) {
                kt2.g(DiscountTicketFragment.this.mUt.t());
                ((DiscountTicketPresenter) DiscountTicketFragment.this.mPresenter).openMoreActivity();
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements UpLoadMorePanel.LoadMoreEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.category.discountticket.widget.UpLoadMorePanel.LoadMoreEventListener
        public void startLoadMore() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-361098888")) {
                ipChange.ipc$dispatch("-361098888", new Object[]{this});
                return;
            }
            ((DiscountTicketPresenter) DiscountTicketFragment.this.mPresenter).loadMore();
        }
    }

    public DiscountTicketFragment() {
        hi.c().b(this.listener);
    }

    private void adjustAppBar() {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196635808")) {
            ipChange.ipc$dispatch("196635808", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            int a2 = (n42.a(this.mActivity, 200.0f) - ne2.a(this.mActivity)) - n42.a(this.mActivity, 44.0f);
            AppBarLayout appBarLayout = this.mAppBar;
            if (appBarLayout != null && (layoutParams = appBarLayout.getLayoutParams()) != null) {
                layoutParams.height = a2;
            }
        }
    }

    private void findViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384923956")) {
            ipChange.ipc$dispatch("1384923956", new Object[]{this});
            return;
        }
        this.mRootView = findViewById(R$id.discount_root);
        this.mStatusBarSpace = findViewById(R$id.title_bar_space);
        this.mTitleBar = findViewById(R$id.discount_ticket_title_layout);
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.discount_ticket_recycler);
        this.mAppBar = (AppBarLayout) findViewById(R$id.discount_ticket_appbar);
        this.mBgHeaderDescTv = (TextView) findViewById(R$id.bg_header_desc);
        this.mBgHeaderTitleTv = (TextView) findViewById(R$id.bg_header_title);
        this.mHeader = findViewById(R$id.discount_ticket_header);
        this.mBgImg = (ImageView) findViewById(R$id.discount_ticket_bg_image);
        this.mTitleBgLayout = findViewById(R$id.title_bg_layout);
        this.mTitleTv = (TextView) findViewById(R$id.title_tv);
        this.mBackBtn = (TextView) findViewById(R$id.title_back_btn);
        this.mShareBtn = (TextView) findViewById(R$id.title_share_btn);
        this.mPtr = (PtrFrameLayout) findViewById(R$id.discount_ticket_ptr);
        this.mDividerLine = findViewById(R$id.view_line);
    }

    public static DiscountTicketFragment instance(@NonNull DtParams dtParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931422781")) {
            return (DiscountTicketFragment) ipChange.ipc$dispatch("-931422781", new Object[]{dtParams});
        }
        DiscountTicketFragment discountTicketFragment = new DiscountTicketFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA, dtParams);
        discountTicketFragment.setArguments(bundle);
        return discountTicketFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openProjectActivity(ProjectItemBean projectItemBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447651257")) {
            ipChange.ipc$dispatch("447651257", new Object[]{this, projectItemBean, Boolean.valueOf(z)});
        } else if (projectItemBean != null) {
            if (z) {
                kt2.g(this.mUt.p(projectItemBean.pos, projectItemBean.id));
            } else {
                kt2.g(this.mUt.s(projectItemBean.pos, projectItemBean.id));
            }
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
            tb2.a(this.mActivity, projectItemBean.schema, bundle);
        }
    }

    private void reloadIfNeed() {
        DtParams dtParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610070763")) {
            ipChange.ipc$dispatch("-1610070763", new Object[]{this});
        } else if (this.isViewCreated && this.isVisibleToUser && (dtParams = this.mParams) != null && dtParams.isTypeFormCategoryFragment() && !TextUtils.isEmpty(this.mChangedCityId) && this.mPresenter != null) {
            scrollToTop();
            ((DiscountTicketPresenter) this.mPresenter).changeCity(this.mChangedCityId);
            this.mChangedCityId = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1865857426")) {
            return R$layout.activity_discount_ticket;
        }
        return ((Integer) ipChange.ipc$dispatch("-1865857426", new Object[]{this})).intValue();
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2097036768")) {
            return this.mMainView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("2097036768", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891330799")) {
            ipChange.ipc$dispatch("-891330799", new Object[]{this});
            return;
        }
        ((DiscountTicketPresenter) this.mPresenter).setVM(this, (DiscountTicketContract.DtModel) this.mModel);
    }

    @Override // cn.damai.category.discountticket.ui.CompatBaseFragment, cn.damai.common.app.base.BaseFragment
    public void initView() {
        PtrHandler ptrHandler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133920020")) {
            ipChange.ipc$dispatch("-1133920020", new Object[]{this});
            return;
        }
        super.initView();
        findViews();
        PtrUiHeader ptrUiHeader = new PtrUiHeader(this.mActivity);
        this.mPtr.setHeaderView(ptrUiHeader);
        this.mPtr.addPtrUIHandler(ptrUiHeader);
        this.mPtr.setPtrIndicator(new aj0(100, this.mActivity));
        this.mPtr.setResistance(1.7f);
        if (this.mParams.isTypeFormCategoryFragment()) {
            this.mStatusBarSpace.setVisibility(8);
            this.mTitleBar.setVisibility(8);
            this.mAppBar.setVisibility(8);
            this.mHeader.setVisibility(8);
            this.mRecyclerView.setBackgroundResource(R$drawable.bg_white);
            this.mRecyclerView.setNestedScrollingEnabled(false);
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class cn.damai.category.discountticket.ui.DiscountTicketFragment.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "234590259")) {
                        ipChange.ipc$dispatch("234590259", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    RecyclerView.LayoutManager layoutManager = DiscountTicketFragment.this.mRecyclerView.getLayoutManager();
                    if (!(layoutManager instanceof LinearLayoutManager)) {
                        return;
                    }
                    if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                        DiscountTicketFragment.this.mDividerLine.setVisibility(8);
                    } else {
                        DiscountTicketFragment.this.mDividerLine.setVisibility(0);
                    }
                }
            });
            ptrHandler = new b();
        } else {
            this.mBackBtn.setOnClickListener(this);
            this.mShareBtn.setOnClickListener(this);
            adjustAppBar();
            ptrHandler = new c();
            this.mPtr.addPtrUIHandler(new PtrClassicDefaultHeader(this.mActivity) {
                /* class cn.damai.category.discountticket.ui.DiscountTicketFragment.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // in.srain.cube.views.ptr.PtrClassicDefaultHeader, in.srain.cube.views.ptr.PtrUIHandler
                public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "643901998")) {
                        ipChange.ipc$dispatch("643901998", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b), rv1});
                        return;
                    }
                    super.onUIPositionChange(ptrFrameLayout, z, b, rv1);
                    int d = rv1.d();
                    ViewGroup.LayoutParams layoutParams = DiscountTicketFragment.this.mBgImg.getLayoutParams();
                    int a = n42.a(getContext(), 212.0f);
                    int abs = Math.abs(d) + a;
                    layoutParams.height = abs;
                    DiscountTicketFragment.this.mBgImg.setPivotX(((float) DiscountTicketFragment.this.mBgImg.getWidth()) / 2.0f);
                    DiscountTicketFragment.this.mBgImg.setScaleX(((float) abs) / ((float) a));
                    DiscountTicketFragment.this.mBgImg.setLayoutParams(layoutParams);
                }
            });
            this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d());
        }
        this.mPtr.setPtrHandler(ptrHandler);
        this.mPtr.disableWhenHorizontalMove(true);
        this.mTicketAdapter = new DiscountTicketAdapter(this.mUt, this.mActivity, new e());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mRecyclerView.setAdapter(this.mTicketAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        UpLoadMorePanel upLoadMorePanel = new UpLoadMorePanel(this.mActivity, this.mRecyclerView, new f());
        this.mLoadMorePanel = upLoadMorePanel;
        upLoadMorePanel.b();
        ((DtProxyModel) this.mModel).prepare(this.mParams);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330556377")) {
            ipChange.ipc$dispatch("-330556377", new Object[]{this});
            return;
        }
        ((DiscountTicketPresenter) this.mPresenter).load(true);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216202278")) {
            ipChange.ipc$dispatch("-1216202278", new Object[]{this});
            return;
        }
        this.mChangedCityId = d20.c();
        reloadIfNeed();
    }

    @Override // cn.damai.category.discountticket.ui.CompatBaseFragment
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435961298")) {
            ipChange.ipc$dispatch("1435961298", new Object[]{this, view});
        } else if (!s72.c()) {
            int id = view.getId();
            if (id == R$id.title_back_btn) {
                this.mActivity.finish();
            } else if (id == R$id.title_share_btn) {
                kt2.g(this.mUt.r());
                T t = this.mPresenter;
                if (t != null) {
                    ((DiscountTicketPresenter) t).share();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1807081522")) {
            ipChange.ipc$dispatch("-1807081522", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mActivity = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mParams = (DtParams) arguments.getParcelable(EXTRA);
        }
        if (this.mParams == null) {
            this.mParams = new DtParams(6);
        }
        DtParams dtParams = this.mParams;
        this.mUt = new kt2(dtParams.type, dtParams.specBPageName);
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843186954")) {
            return (View) ipChange.ipc$dispatch("-1843186954", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (this.mParams.isTypeFormCategoryFragment() && !TextUtils.isEmpty(this.mChangedCityId)) {
            this.mParams.cityId = this.mChangedCityId;
            this.mChangedCityId = null;
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.isViewCreated = true;
        this.mChangedCityId = null;
        if (this.mParams.type == 8) {
            this.mUTBuilder = ig.m().h("zhekou");
        }
        return onCreateView;
    }

    @Override // cn.damai.common.app.base.BaseFragment, cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662045911")) {
            ipChange.ipc$dispatch("-662045911", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        super.onDestroyView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463093131")) {
            ipChange.ipc$dispatch("-463093131", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfNeed();
    }

    public void scrollToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131198812")) {
            ipChange.ipc$dispatch("1131198812", new Object[]{this});
        } else if (this.isViewCreated && this.mRecyclerView.getChildCount() > 0) {
            this.mRecyclerView.scrollToPosition(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        DtParams dtParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077810273")) {
            ipChange.ipc$dispatch("-1077810273", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isVisibleToUser = z;
        reloadIfNeed();
        if (z && (dtParams = this.mParams) != null && dtParams.type == 8) {
            setDamaiUTKeyBuilder(ig.m().h("zhekou"));
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtView
    public void showFirstPage(FirstPageData firstPageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066133696")) {
            ipChange.ipc$dispatch("-2066133696", new Object[]{this, firstPageData});
            return;
        }
        hideErrorView();
        if (firstPageData.hasMore) {
            this.mLoadMorePanel.b();
        } else {
            this.mLoadMorePanel.c();
        }
        this.mPtr.refreshComplete();
        HeaderData headerData = firstPageData.headerData;
        if (headerData != null) {
            cn.damai.common.image.a.b().f(headerData.bgPic, n42.a(this.mActivity, 375.0f), n42.a(this.mActivity, 212.0f)).g(this.mBgImg);
            this.mBgHeaderTitleTv.setText(headerData.title);
            this.mBgHeaderDescTv.setText(headerData.subtitle);
            this.mTitleTv.setText(headerData.title);
        }
        this.mTicketAdapter.d(true, firstPageData.data);
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtView
    public void showMorePage(MorePageData morePageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597660434")) {
            ipChange.ipc$dispatch("1597660434", new Object[]{this, morePageData});
        } else if (morePageData.success) {
            if (morePageData.hasMore) {
                this.mLoadMorePanel.b();
            } else {
                this.mLoadMorePanel.c();
            }
            this.mTicketAdapter.d(false, morePageData.data);
        } else {
            this.mLoadMorePanel.b();
            showErrorTip("加载失败");
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtView
    public void showShareView(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519626258")) {
            ipChange.ipc$dispatch("519626258", new Object[]{this, bundle});
        } else if (bundle != null && !this.mActivity.isFinishing()) {
            ShareManager.E().P(this.mActivity, bundle, this.mRootView);
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtView
    public void updateRecyclerViewItem(Object obj) {
        DiscountTicketAdapter discountTicketAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980919843")) {
            ipChange.ipc$dispatch("-980919843", new Object[]{this, obj});
        } else if (obj != null && (discountTicketAdapter = this.mTicketAdapter) != null) {
            discountTicketAdapter.c(obj);
        }
    }
}
