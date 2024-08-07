package cn.damai.discover.main.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.DamaiConstants;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.param.LiveHeaderParamsV2;
import cn.damai.discover.main.ui.RecommendFragment;
import cn.damai.discover.main.ui.adapter.LivePagerAdapter;
import cn.damai.discover.main.ui.model.PublishModel;
import cn.damai.homepage.R$anim;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.aj0;
import tb.br;
import tb.d20;
import tb.dr;
import tb.f81;
import tb.gr;
import tb.hf1;
import tb.n42;
import tb.ne2;
import tb.r3;
import tb.u80;
import tb.vv2;
import tb.wj2;
import tb.xs0;

/* compiled from: Taobao */
public class TabLiveActivity extends SimpleBaseActivity implements RefreshCallBack {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_LOGIN = 56;
    private static final int REQUEST_USER_PUBLISH = 888;
    protected i cdnReqHandler = new i(this);
    private String errorCode;
    private String errorMsg;
    private AppBarLayout mAppBar;
    private Runnable mDelayPublishShowAction = new Runnable() {
        /* class cn.damai.discover.main.ui.TabLiveActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1476652885")) {
                ipChange.ipc$dispatch("1476652885", new Object[]{this});
            } else if (!TabLiveActivity.this.isFinishing()) {
                TabLiveActivity.this.mSubmitBtn.setVisibility(0);
                u80.b(TabLiveActivity.this.mSubmitBtn, true, n42.a(xs0.a(), 52.0f));
                TabLiveActivity.this.showPublishTipIfNeed();
            }
        }
    };
    private LinearLayout mHeaderView;
    private HorScrollView mHorScrollView;
    private boolean mIsRequesting = false;
    private List<Fragment> mList = new ArrayList();
    private ILoginListener mLoginListener;
    private FrameLayout mMainView;
    private LivePagerAdapter mPagerAdapter;
    private TextView mPtrTip;
    private PublishModel mPublishModel = new PublishModel();
    private View mPublishTip;
    private TetrisRequest mRequest;
    private DMMtopRequestListener<BaseResponse> mRequestListener;
    private ScrollTitleBean mSelectTitle;
    private View mSubmitBtn;
    private DamaiTabbarManager mTabBarManager;
    private List<ScrollTitleBean> mTitleList;
    private RoundImageView mUserAvatar;
    private vv2 mViewCreator;
    private ViewPager mViewPager;
    private String pageName = "live";

    /* compiled from: Taobao */
    public class ReqRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private WeakReference<i> reference;

        public ReqRunnable(i iVar) {
            this.reference = new WeakReference<>(iVar);
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1237043957")) {
                ipChange.ipc$dispatch("-1237043957", new Object[]{this});
                return;
            }
            Message message = new Message();
            message.what = 0;
            LiveHeaderParamsV2 liveHeaderParamsV2 = new LiveHeaderParamsV2();
            message.obj = TabLiveActivity.this.getJsonFromCDN(new cn.damai.tetris.page.a(liveHeaderParamsV2.getPatternName(), liveHeaderParamsV2.getVersion(), d20.c()));
            if (this.reference.get() != null) {
                this.reference.get().sendMessage(message);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements OnBizListener<PublishStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        /* renamed from: a */
        public void onBizSuccess(PublishStateBean publishStateBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "477262194")) {
                ipChange.ipc$dispatch("477262194", new Object[]{this, publishStateBean});
            } else if (publishStateBean.isNeedShowPublishBtn()) {
                TabLiveActivity.this.mSubmitBtn.setTag(publishStateBean);
                long j = this.a ? 20 : 600;
                TabLiveActivity.this.mSubmitBtn.removeCallbacks(TabLiveActivity.this.mDelayPublishShowAction);
                TabLiveActivity.this.mSubmitBtn.postDelayed(TabLiveActivity.this.mDelayPublishShowAction, j);
            } else {
                TabLiveActivity.this.mSubmitBtn.setVisibility(8);
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2040269140")) {
                ipChange.ipc$dispatch("2040269140", new Object[]{this, str, str2});
                return;
            }
            TabLiveActivity.this.mSubmitBtn.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b implements TabbarLayout.TabBarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-521736589")) {
                ipChange.ipc$dispatch("-521736589", new Object[]{this, tabItem});
            } else if (tabItem != null && !DamaiConstants.TAB_FIND.equals(tabItem)) {
                TabLiveActivity.this.finish();
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabLongClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "442183127")) {
                ipChange.ipc$dispatch("442183127", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabReselected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1725922736")) {
                ipChange.ipc$dispatch("1725922736", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabSelected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1612534845")) {
                ipChange.ipc$dispatch("1612534845", new Object[]{this, tabItem});
            }
        }
    }

    /* compiled from: Taobao */
    public class c extends r3 {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834399529")) {
                ipChange.ipc$dispatch("-1834399529", new Object[]{this});
                return;
            }
            TabLiveActivity.this.setUpLoginUserIcon();
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1069543250")) {
                ipChange.ipc$dispatch("1069543250", new Object[]{this});
                return;
            }
            TabLiveActivity.this.setUpLoginUserIcon();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-619953475")) {
                ipChange.ipc$dispatch("-619953475", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(f81.u().w());
            if (LoginManager.k().q()) {
                String i = d20.i();
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, i);
                DMNav.from(TabLiveActivity.this).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                return;
            }
            LoginManager.k().x(TabLiveActivity.this, new Intent(), 0);
        }
    }

    /* compiled from: Taobao */
    public class e implements PtrHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-849105419")) {
                return ((Boolean) ipChange.ipc$dispatch("-849105419", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
            }
            PtrChildHandler findChildPtrHandler = TabLiveActivity.this.findChildPtrHandler();
            if (findChildPtrHandler == null || TabLiveActivity.this.mAppBar.getTop() < 0 || !findChildPtrHandler.checkCanDoRefresh(ptrFrameLayout, view, view2)) {
                return false;
            }
            return true;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "141941116")) {
                ipChange.ipc$dispatch("141941116", new Object[]{this, ptrFrameLayout});
                return;
            }
            PtrChildHandler findChildPtrHandler = TabLiveActivity.this.findChildPtrHandler();
            if (findChildPtrHandler != null) {
                findChildPtrHandler.onRefreshBegin(ptrFrameLayout, TabLiveActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692340033")) {
                ipChange.ipc$dispatch("-692340033", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null) {
                TabLiveActivity.this.mSelectTitle = scrollTitleBean;
                TabLiveActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements RecommendFragment.OnOverPageListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g(TabLiveActivity tabLiveActivity) {
        }

        @Override // cn.damai.discover.main.ui.RecommendFragment.OnOverPageListener
        public void onOverPage(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1914228889")) {
                ipChange.ipc$dispatch("-1914228889", new Object[]{this, Boolean.valueOf(z)});
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1902786805")) {
                ipChange.ipc$dispatch("-1902786805", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            TabLiveActivity.this.request();
        }
    }

    /* compiled from: Taobao */
    public static class i extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<TabLiveActivity> a;

        public i(TabLiveActivity tabLiveActivity) {
            this.a = new WeakReference<>(tabLiveActivity);
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1829247033")) {
                ipChange.ipc$dispatch("1829247033", new Object[]{this, message});
            } else if (message.what == 0 && this.a.get() != null) {
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.get().showTopView((BaseResponse) JSON.parseObject(str, BaseResponse.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.a.get().showTopErrorView();
                    }
                } else {
                    this.a.get().showTopErrorView();
                }
            }
        }
    }

    private void alarm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572927164")) {
            ipChange.ipc$dispatch("572927164", new Object[]{this});
        } else if (this.mRequest != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.i());
            hashMap.put("city", d20.d());
            dr.INSTANCE.a().a(this.mRequest.getApiName()).c(this.errorCode).d(this.errorMsg).e(hashMap).h(this.mRequest.patternName).i(this.mRequest.patternVersion).g("现场主页头部").j("live").f(false).b();
        }
    }

    private void bindLoginListener(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319226425")) {
            ipChange.ipc$dispatch("-319226425", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mLoginListener = new c();
            LoginManager.k().c(this.mLoginListener);
        } else if (this.mLoginListener != null) {
            LoginManager.k().C(this.mLoginListener);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private PtrChildHandler findChildPtrHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698677388")) {
            return (PtrChildHandler) ipChange.ipc$dispatch("-698677388", new Object[]{this});
        }
        LivePagerAdapter livePagerAdapter = this.mPagerAdapter;
        if (livePagerAdapter == null) {
            return null;
        }
        Fragment a2 = livePagerAdapter.a();
        if (a2 instanceof PtrChildHandler) {
            return (PtrChildHandler) a2;
        }
        return null;
    }

    private void gotoHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003704052")) {
            ipChange.ipc$dispatch("-2003704052", new Object[]{this});
            return;
        }
        DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
        finish();
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713797707")) {
            ipChange.ipc$dispatch("1713797707", new Object[]{this});
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426160093")) {
            ipChange.ipc$dispatch("-426160093", new Object[]{this});
            return;
        }
        this.mRequest = new TetrisRequest(new LiveHeaderParamsV2());
        this.mRequestListener = new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.discover.main.ui.TabLiveActivity.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1796527320")) {
                    ipChange.ipc$dispatch("-1796527320", new Object[]{this, str, str2});
                    return;
                }
                TabLiveActivity.this.stopProgressDialog();
                TabLiveActivity.this.errorCode = str;
                TabLiveActivity.this.errorMsg = str2;
                TabLiveActivity tabLiveActivity = TabLiveActivity.this;
                new Thread(new ReqRunnable(tabLiveActivity.cdnReqHandler)).start();
                TabLiveActivity.this.mIsRequesting = false;
            }

            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-913279648")) {
                    ipChange.ipc$dispatch("-913279648", new Object[]{this, baseResponse});
                    return;
                }
                TabLiveActivity.this.stopProgressDialog();
                TabLiveActivity tabLiveActivity = TabLiveActivity.this;
                tabLiveActivity.onResponseSuccess(tabLiveActivity.mMainView);
                TabLiveActivity.this.showTopView(baseResponse);
                TabLiveActivity.this.mIsRequesting = false;
            }
        };
        loadPublish(false);
    }

    private void initList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687389521")) {
            ipChange.ipc$dispatch("-1687389521", new Object[]{this});
            return;
        }
        this.mMainView = (FrameLayout) findViewById(R$id.main_view);
        this.mAppBar = (AppBarLayout) findViewById(R$id.appbar);
        this.mHeaderView = (LinearLayout) findViewById(R$id.header_view);
        this.mViewCreator = new vv2(this);
        this.mHorScrollView = (HorScrollView) findViewById(R$id.layout_horscroll);
        this.mTitleList = new ArrayList();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean("0", "推荐", 0);
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean("1", "想看&想玩", 1);
        ScrollTitleBean scrollTitleBean3 = new ScrollTitleBean("2", "关注", 2);
        this.mTitleList.add(scrollTitleBean);
        this.mTitleList.add(scrollTitleBean2);
        this.mTitleList.add(scrollTitleBean3);
        this.mHorScrollView.setTitle(this.mTitleList).setLineType(2).setFontColor(R$color.color_000000, R$color.color_9C9CA5).setHeight(35).setSpace(10).setFontSize(16, 18).commit();
        this.mHorScrollView.setOnTitleClickListener(new f());
        this.mHorScrollView.selectTitle(0);
        this.mSelectTitle = this.mTitleList.get(0);
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mList.clear();
        RecommendFragment recommendFragment = new RecommendFragment();
        recommendFragment.setOverPageListener(new g(this));
        Wanna2SeeFragment newInstance = Wanna2SeeFragment.newInstance();
        FollowFragment followFragment = new FollowFragment();
        this.mList.add(recommendFragment);
        this.mList.add(newInstance);
        this.mList.add(followFragment);
        LivePagerAdapter livePagerAdapter = new LivePagerAdapter(supportFragmentManager, this.mList);
        this.mPagerAdapter = livePagerAdapter;
        this.mViewPager.setAdapter(livePagerAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.discover.main.ui.TabLiveActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-886678415")) {
                    ipChange.ipc$dispatch("-886678415", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1508578800")) {
                    ipChange.ipc$dispatch("-1508578800", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1982391548")) {
                    ipChange.ipc$dispatch("1982391548", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TabLiveActivity tabLiveActivity = TabLiveActivity.this;
                tabLiveActivity.mSelectTitle = (ScrollTitleBean) tabLiveActivity.mTitleList.get(i);
                TabLiveActivity.this.mHorScrollView.selectTitle(i);
                if (TabLiveActivity.this.mSelectTitle != null) {
                    cn.damai.common.user.c.e().x(f81.u().y(TabLiveActivity.this.mSelectTitle.index, TabLiveActivity.this.mSelectTitle.name));
                }
            }
        });
        this.mViewPager.setCurrentItem(0);
        this.mViewPager.setOffscreenPageLimit(3);
    }

    private void initPtr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009803311")) {
            ipChange.ipc$dispatch("2009803311", new Object[]{this});
            return;
        }
        PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) findViewById(R$id.live_ptr);
        PtrUiHeader ptrUiHeader = new PtrUiHeader(this);
        ptrFrameLayout.setHeaderView(ptrUiHeader);
        ptrFrameLayout.addPtrUIHandler(ptrUiHeader);
        ptrFrameLayout.setPtrIndicator(new aj0(100, this));
        ptrFrameLayout.setResistance(1.7f);
        ptrFrameLayout.setPtrHandler(new e());
        ptrFrameLayout.disableWhenHorizontalMove(true);
    }

    private void initTabbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915748079")) {
            ipChange.ipc$dispatch("915748079", new Object[]{this});
            return;
        }
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, (TabbarLayout) findViewById(R$id.live_activity_bottomsheet_container), new b());
        this.mTabBarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_FIND);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311169157")) {
            ipChange.ipc$dispatch("311169157", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        View findViewById = findViewById(R$id.status_bar_space);
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

    private void loadPublish(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673212560")) {
            ipChange.ipc$dispatch("1673212560", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mSubmitBtn.setVisibility(8);
        this.mPublishModel.loadPublish(new a(z));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void request() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873835454")) {
            ipChange.ipc$dispatch("1873835454", new Object[]{this});
        } else if (this.mIsRequesting) {
        } else {
            if (d20.C()) {
                new Thread(new ReqRunnable(this.cdnReqHandler)).start();
                return;
            }
            startProgressDialog();
            this.mRequest.request(this.mRequestListener);
            this.mIsRequesting = true;
        }
    }

    private void setTrackInfo(ArrayList<BaseLayer> arrayList) {
        List<BaseSection> sections;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423319580")) {
            ipChange.ipc$dispatch("-423319580", new Object[]{this, arrayList});
        } else if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                BaseLayer baseLayer = arrayList.get(i2);
                if (!(baseLayer == null || (sections = baseLayer.getSections()) == null || sections.size() == 0)) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection != null && !TextUtils.isEmpty(baseSection.getComponentId())) {
                            String componentId = baseSection.getComponentId();
                            if ("dicovery_cid_home_head_pic".equals(componentId)) {
                                TrackInfo trackInfo = new TrackInfo();
                                trackInfo.trackB = this.pageName;
                                trackInfo.trackC = "top";
                                if (baseSection.getTrackInfo() != null && !TextUtils.isEmpty(baseSection.getTrackInfo().getString("spmc"))) {
                                    trackInfo.trackC = baseSection.getTrackInfo().getString("spmc");
                                }
                                trackInfo.put("usercode", (Object) d20.E());
                                trackInfo.put("city", (Object) d20.d());
                                baseSection.setTrackInfoBeta(trackInfo);
                            }
                            if ("dicovery_cid_home_head_banner".equals(componentId)) {
                                TrackInfo trackInfo2 = new TrackInfo();
                                trackInfo2.trackB = this.pageName;
                                trackInfo2.trackC = hf1.MODULE_BANNER;
                                if (baseSection.getTrackInfo() != null && !TextUtils.isEmpty(baseSection.getTrackInfo().getString("spmc"))) {
                                    trackInfo2.trackC = baseSection.getTrackInfo().getString("spmc");
                                }
                                trackInfo2.put("usercode", (Object) d20.E());
                                trackInfo2.put("city", (Object) d20.d());
                                baseSection.setTrackInfoBeta(trackInfo2);
                            }
                            if (TextUtils.equals(wj2.dm_discover_head_banner_cid, componentId)) {
                                updateTrackInfoIfNeed(baseSection, this.pageName, "top_banner");
                            }
                            if (TextUtils.equals(wj2.dm_discover_head_fixed_cid, componentId)) {
                                updateTrackInfoIfNeed(baseSection, this.pageName, "top_module");
                            }
                            if (TextUtils.equals(wj2.dm_discover_hot_theme_cid, componentId)) {
                                updateTrackInfoIfNeed(baseSection, this.pageName, "HotQuanzi");
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUpLoginUserIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493577363")) {
            ipChange.ipc$dispatch("-1493577363", new Object[]{this});
        } else if (!isFinishing()) {
            this.mUserAvatar.setOnClickListener(new d());
            if (LoginManager.k().q()) {
                String d2 = u80.d();
                if (TextUtils.isEmpty(d2)) {
                    this.mUserAvatar.setBackgroundResource(R$drawable.mine_account_default_1);
                    return;
                }
                int a2 = n42.a(this, 30.0f);
                DMImageCreator f2 = cn.damai.common.image.a.b().f(d2, a2, a2);
                int i2 = R$drawable.mine_account_default_1;
                f2.i(i2).c(i2).g(this.mUserAvatar);
                return;
            }
            this.mUserAvatar.setBackgroundResource(R$drawable.mine_account_default_1);
        }
    }

    private void showPublishSuccessAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593485210")) {
            ipChange.ipc$dispatch("1593485210", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.discover.main.ui.TabLiveActivity.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2023253028")) {
                    ipChange.ipc$dispatch("2023253028", new Object[]{this});
                } else if (!TabLiveActivity.this.isFinishing() && TabLiveActivity.this.isActivityForeground()) {
                    View decorView = TabLiveActivity.this.getWindow().getDecorView();
                    if (decorView instanceof FrameLayout) {
                        u80.o((FrameLayout) decorView);
                    }
                }
            }
        }, 50);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPublishTipIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255627999")) {
            ipChange.ipc$dispatch("-255627999", new Object[]{this});
        } else if (!u80.f()) {
            u80.n();
            this.mPublishTip.setVisibility(0);
            this.mPublishTip.postDelayed(new Runnable() {
                /* class cn.damai.discover.main.ui.TabLiveActivity.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1878687258")) {
                        ipChange.ipc$dispatch("-1878687258", new Object[]{this});
                        return;
                    }
                    TabLiveActivity.this.mPublishTip.setVisibility(8);
                }
            }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTopErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809223304")) {
            ipChange.ipc$dispatch("809223304", new Object[]{this});
            return;
        }
        onResponseError("", "", "", this.mMainView, true);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            responseErrorPage.setRefreshListener(new h());
        }
        alarm();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTopView(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327888101")) {
            ipChange.ipc$dispatch("-1327888101", new Object[]{this, baseResponse});
            return;
        }
        GlobalConfig globalConfig = baseResponse.globalConfig;
        if (globalConfig != null) {
            if (!TextUtils.isEmpty(globalConfig.pageName)) {
                this.pageName = baseResponse.globalConfig.pageName;
            }
            updateB(this.pageName, baseResponse.globalConfig.abBuckets);
        }
        if (!u80.g(baseResponse.layers)) {
            setTrackInfo(baseResponse.layers);
            LinearLayout c2 = this.mViewCreator.c(baseResponse.layers, this.mHeaderView);
            if (c2 != null) {
                this.mHeaderView.removeAllViews();
                this.mHeaderView.addView(c2);
                return;
            }
            return;
        }
        this.mHeaderView.removeAllViews();
    }

    private void updateB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136369510")) {
            ipChange.ipc$dispatch("2136369510", new Object[]{this, str, jSONArray});
            return;
        }
        HashMap hashMap = new HashMap();
        if (jSONArray != null) {
            hashMap.put("current_ab", jSONArray.toJSONString());
        }
        this.mBuilder.i(str).j(hashMap);
        cn.damai.common.user.c.e().l(this, this.mBuilder);
    }

    private static void updateTrackInfoIfNeed(BaseSection baseSection, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692647122")) {
            ipChange.ipc$dispatch("-1692647122", new Object[]{baseSection, str, str2});
            return;
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.trackB = str;
        trackInfo.trackC = str2;
        TrackInfo trackInfo2 = baseSection.getTrackInfo();
        if (trackInfo2 != null) {
            String string = trackInfo2.getString("spmc");
            if (!TextUtils.isEmpty(string)) {
                trackInfo.trackC = string;
            }
        }
        baseSection.setTrackInfoBeta(trackInfo);
    }

    public String getJsonFromCDN(cn.damai.tetris.page.a aVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1436124800")) {
            return aVar.c();
        }
        return (String) ipChange.ipc$dispatch("1436124800", new Object[]{this, aVar});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "647047525")) {
            return R$layout.live_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("647047525", new Object[]{this})).intValue();
    }

    public RecommendFragment getRecommendFragment() {
        LivePagerAdapter livePagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781742108")) {
            return (RecommendFragment) ipChange.ipc$dispatch("1781742108", new Object[]{this});
        }
        if (this.mSelectTitle == null || (livePagerAdapter = this.mPagerAdapter) == null) {
            return null;
        }
        Fragment a2 = livePagerAdapter.a();
        if (a2 instanceof RecommendFragment) {
            return (RecommendFragment) a2;
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1415127224")) {
            ipChange.ipc$dispatch("-1415127224", new Object[]{this});
            return;
        }
        super.initView();
        View findViewById = findViewById(R$id.submit_btn);
        this.mSubmitBtn = findViewById;
        findViewById.setOnClickListener(this);
        this.mSubmitBtn.setVisibility(8);
        this.mUserAvatar = (RoundImageView) findViewById(R$id.live_to_my_img);
        this.mPtrTip = (TextView) findViewById(R$id.live_ptr_refresh_tip);
        this.mPublishTip = findViewById(R$id.live_guide_publish_tip);
        setUpLoginUserIcon();
        initPtr();
        initBundle();
        initTitle();
        initList();
        initData();
        initTabbar();
        bindLoginListener(true);
        setDamaiUTKeyBuilder(f81.u().v(d20.E(), d20.d()));
        cn.damai.common.user.c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-802970321")) {
            ipChange.ipc$dispatch("-802970321", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 56) {
            if (i3 == -1) {
                loadPublish(true);
            }
        } else if (i2 == REQUEST_USER_PUBLISH && i3 == -1 && intent != null && intent.getBooleanExtra("needRefresh", false)) {
            showPublishSuccessAnimation();
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116571311")) {
            ipChange.ipc$dispatch("-1116571311", new Object[]{this});
            return;
        }
        gotoHomePage();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337735378")) {
            ipChange.ipc$dispatch("-1337735378", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.submit_btn) {
            if (LoginManager.k().q()) {
                PublishStateBean stateBean = this.mPublishModel.getStateBean();
                if (stateBean != null && stateBean.isNeedShowPublishBtn()) {
                    u80.k(this, stateBean, REQUEST_USER_PUBLISH);
                }
            } else {
                LoginManager.k().x(this, new Intent(), 56);
            }
            cn.damai.common.user.c.e().x(f81.u().x());
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420003250")) {
            ipChange.ipc$dispatch("420003250", new Object[]{this});
            return;
        }
        if (this.mViewCreator != null) {
            br.c(this.mViewCreator.b(), new cn.damai.tetris.core.msg.Message(6, null));
        }
        bindLoginListener(false);
        DamaiTabbarManager damaiTabbarManager = this.mTabBarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.p();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735357965")) {
            ipChange.ipc$dispatch("735357965", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        finish();
        startActivity(new Intent(this, TabLiveActivity.class));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585403894")) {
            ipChange.ipc$dispatch("1585403894", new Object[]{this});
            return;
        }
        if (this.mViewCreator != null) {
            br.c(this.mViewCreator.b(), new cn.damai.tetris.core.msg.Message(4, null));
        }
        super.onPause();
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.RefreshCallBack
    public void onRefreshFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699111731")) {
            ipChange.ipc$dispatch("699111731", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.RefreshCallBack
    public void onRefreshSuccess(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789472845")) {
            ipChange.ipc$dispatch("1789472845", new Object[]{this, Integer.valueOf(i2)});
        } else if (!isFinishing()) {
            this.mPtrTip.setText("为您更新了" + i2 + "条内容");
            this.mPtrTip.clearAnimation();
            this.mPtrTip.startAnimation(AnimationUtils.loadAnimation(this, R$anim.anim_discover_refresh_tip));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744300335")) {
            ipChange.ipc$dispatch("-744300335", new Object[]{this});
            return;
        }
        if (this.mViewCreator != null) {
            br.c(this.mViewCreator.b(), new cn.damai.tetris.core.msg.Message(3, null));
        }
        if (this.mRequest != null) {
            request();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1659356391")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1659356391", new Object[]{this});
    }
}
