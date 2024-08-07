package cn.damai.mine.userinfo.fragment;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.coupondialog.CouponDialogHelper;
import cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.mine.activity.MineMainActivity;
import cn.damai.mine.bean.VipCardInfoWrap;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import cn.damai.mine.userinfo.bean.UserPerformFileVip;
import cn.damai.mine.userinfo.help.MineUserCenterBadeListener;
import cn.damai.mine.userinfo.model.MineUserCenterViewModel;
import cn.damai.mine.view.MineUserCenterTitleNewView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.user.userhome.adapter.UserHomePagerAdapter;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import cn.damai.user.userhome.fragment.MineDynamicFragment;
import cn.damai.user.userhome.model.UserHomeDataRequest;
import cn.damai.user.userhome.view.usercenter.ModeEmpty;
import cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.ae1;
import tb.be1;
import tb.br;
import tb.ce1;
import tb.d20;
import tb.de1;
import tb.dr;
import tb.ee1;
import tb.et2;
import tb.gr;
import tb.h03;
import tb.lt2;
import tb.m42;
import tb.r3;
import tb.v50;
import tb.wd1;
import tb.xf2;
import tb.yd1;
import tb.yp;
import tb.zd1;

/* compiled from: Taobao */
public class MineUserCenterFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DM_MSGBOX = "DM_MSGBOX";
    private List<String> badgeNodes = new ArrayList();
    private MineDynamicFragment dynamicFragment;
    private boolean isResume = false;
    private DMBadgeListener listenerBadge = new h();
    private LinearLayout ll_member_authorithize;
    private AppBarLayout mAppBar;
    private boolean mHasRegisterRedPacketMsg;
    private et2 mHeaderPanel = new et2();
    private HorScrollView mHorScrollView;
    private int mImageHeight;
    private int mLoginHeight;
    ILoginListener mLoginListener = new a();
    private ae1 mLogisticsPanel;
    private be1 mOlympicPanel;
    private List<Fragment> mPageList = new ArrayList();
    private UserHomePagerAdapter mPagerAdapter;
    private int mScreenHeight;
    private ScrollTitleBean mSelectTitle;
    private View mServiceMaskView;
    private ce1 mServicePanel;
    private MinepublishCheckBean mTemp;
    private int mTitleBarHeight;
    private List<ScrollTitleBean> mTitleList;
    private MineUserCenterTitleNewView mTitleView;
    private CollapsingToolbarLayout mToolBarLayout;
    private UserCenterDataBean mUserCenterData;
    private MineUserCenterViewModel mViewModel;
    private ViewPager mViewPager;
    private de1 mVipPanel;
    private MineMainActivity mainActivity;
    private yp manager;
    private List<String> messageNodes = new ArrayList();
    VipCardInfoWrap noLoginData;
    private Wanna2SeeFragment seeFragment;
    private TextView tv_member_authorithize_action;
    private DMIconFontTextView tv_member_authorithize_close;
    private TextView tv_member_authorithize_desc;
    private String type = "-1";

    /* compiled from: Taobao */
    public class a extends r3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1563306135")) {
                ipChange.ipc$dispatch("1563306135", new Object[]{this});
                return;
            }
            super.onLoginCancel();
            MineUserCenterFragment.this.loadListView(0);
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1403097546")) {
                ipChange.ipc$dispatch("-1403097546", new Object[]{this});
                return;
            }
            super.onLoginSuccess();
            MineUserCenterFragment.this.loadListView(0);
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLogout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1890624698")) {
                ipChange.ipc$dispatch("-1890624698", new Object[]{this});
                return;
            }
            super.onLogout();
            MineUserCenterFragment.this.loadListView(0);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "881822625")) {
                ipChange.ipc$dispatch("881822625", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().A(MineUserCenterFragment.this.type));
            MineUserCenterFragment.this.ll_member_authorithize.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1301854302")) {
                ipChange.ipc$dispatch("-1301854302", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().z(MineUserCenterFragment.this.type));
            if (LoginManager.k().q()) {
                DMNav.from(MineUserCenterFragment.this.mActivity).toUri(h03.j());
            } else {
                DMNav.from(MineUserCenterFragment.this.mActivity).withExtras(new Bundle()).toUri(gr.f());
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements MemberAuthPopWindow.ICustomDialogEventListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
            public void dialogItemEvent(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1882082122")) {
                    ipChange.ipc$dispatch("-1882082122", new Object[]{this, str});
                } else if ("success".equals(str)) {
                    MineUserCenterFragment.this.requestUserCenterDataReq();
                }
            }
        }

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809436067")) {
                ipChange.ipc$dispatch("809436067", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yd1.x().z(MineUserCenterFragment.this.type));
            h03.g(MineUserCenterFragment.this.getContext(), MineUserCenterFragment.this.mActivity, yd1.MY_PAGE, new a());
        }
    }

    /* compiled from: Taobao */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "817067344")) {
                ipChange.ipc$dispatch("817067344", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = ((float) Math.abs(i)) / ((float) (MineUserCenterFragment.this.mTitleBarHeight + MineUserCenterFragment.this.mLoginHeight));
            if (MineUserCenterFragment.this.mTitleView != null) {
                String str = null;
                VipCardInfoWrap vipCardInfoWrap = MineUserCenterFragment.this.noLoginData;
                if (vipCardInfoWrap != null) {
                    str = vipCardInfoWrap.getMyHeadAreaBgImg();
                }
                MineUserCenterFragment.this.mTitleView.setBackGroundAlpha(abs, str);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements MineUserCenterBadeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.mine.userinfo.help.MineUserCenterBadeListener
        public void markBadgeData(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1066332544")) {
                ipChange.ipc$dispatch("1066332544", new Object[]{this, str});
            } else if (zd1.d() && MineUserCenterFragment.this.mServicePanel != null) {
                if ("DM_USER_MY_EVALUATE".equals(str) && !MineUserCenterFragment.this.mServicePanel.m()) {
                    return;
                }
                if (!"DM_USER_MY_COUPON".equals(str) || MineUserCenterFragment.this.mServicePanel.l()) {
                    MineUserCenterFragment.this.markNode(str);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1446627418")) {
                ipChange.ipc$dispatch("-1446627418", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null) {
                MineUserCenterFragment.this.mSelectTitle = scrollTitleBean;
                if (MineUserCenterFragment.this.mViewPager != null && scrollTitleBean.index < xf2.e(MineUserCenterFragment.this.mPageList)) {
                    MineUserCenterFragment.this.mViewPager.setCurrentItem(scrollTitleBean.index);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements DMBadgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeChanged(String str, BadgeNodeItem badgeNodeItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-242345935")) {
                ipChange.ipc$dispatch("-242345935", new Object[]{this, str, badgeNodeItem});
                return;
            }
            int count = badgeNodeItem.getCount();
            if (MineUserCenterFragment.DM_MSGBOX.equals(str)) {
                if (MineUserCenterFragment.this.mTitleView != null) {
                    MineUserCenterFragment.this.mTitleView.updateMessageCount(count);
                }
            } else if ("DM_USER_MY_COUPON".equals(str)) {
                if (MineUserCenterFragment.this.mServicePanel != null) {
                    MineUserCenterFragment.this.mServicePanel.s(count);
                }
            } else if ("DM_USER_MY_EVALUATE".equals(str)) {
                if (MineUserCenterFragment.this.mServicePanel != null) {
                    MineUserCenterFragment.this.mServicePanel.w(count);
                }
            } else if ("DM_USER_MY".equals(str)) {
                br.c(wd1.NOTIFY_UPDATE_BADGE_DATA, Integer.valueOf(count));
            }
            if (MineUserCenterFragment.this.manager != null) {
                MineUserCenterFragment.this.manager.i(str, MineUserCenterFragment.this.listenerBadge);
            }
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(List<String> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1818610105")) {
                ipChange.ipc$dispatch("1818610105", new Object[]{this, list, str, str2});
                return;
            }
            MineUserCenterFragment.this.manager.h(MineUserCenterFragment.this.badgeNodes, MineUserCenterFragment.this.listenerBadge);
            MineUserCenterFragment.this.manager.f(MineUserCenterFragment.this.badgeNodes);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void alarm(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701265141")) {
            ipChange.ipc$dispatch("-701265141", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.i());
        dr.INSTANCE.a().a(new UserHomeDataRequest().getApiName()).c(str).d(str2).e(hashMap).g("我的页面").j(yd1.MY_PAGE).f(false).b();
    }

    private void bindLoginListener(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165352212")) {
            ipChange.ipc$dispatch("-165352212", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            LoginManager.k().c(this.mLoginListener);
        } else {
            LoginManager.k().C(this.mLoginListener);
        }
    }

    private PtrChildHandler findChildPtrHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078321873")) {
            return (PtrChildHandler) ipChange.ipc$dispatch("-1078321873", new Object[]{this});
        }
        UserHomePagerAdapter userHomePagerAdapter = this.mPagerAdapter;
        if (userHomePagerAdapter == null) {
            return null;
        }
        Fragment a2 = userHomePagerAdapter.a();
        if (a2 instanceof PtrChildHandler) {
            return (PtrChildHandler) a2;
        }
        return null;
    }

    private void initAuthView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1858613403")) {
            ipChange.ipc$dispatch("-1858613403", new Object[]{this});
            return;
        }
        this.ll_member_authorithize = (LinearLayout) this.rootView.findViewById(R$id.ll_member_authorithize);
        this.tv_member_authorithize_close = (DMIconFontTextView) this.rootView.findViewById(R$id.tv_member_authorithize_close);
        this.tv_member_authorithize_desc = (TextView) this.rootView.findViewById(R$id.tv_member_authorithize_desc);
        this.tv_member_authorithize_action = (TextView) this.rootView.findViewById(R$id.tv_member_authorithize_action);
    }

    private void initBadgeData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933471093")) {
            ipChange.ipc$dispatch("-1933471093", new Object[]{this});
            return;
        }
        this.messageNodes.add(DM_MSGBOX);
        this.badgeNodes.add("DM_USER_MY");
        this.badgeNodes.add("DM_USER_MY_COUPON");
        this.badgeNodes.add("DM_USER_MY_EVALUATE");
    }

    private void initContainerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63213970")) {
            ipChange.ipc$dispatch("63213970", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.ll_mine_order_container);
        ae1 ae1 = new ae1(this.mainActivity, findViewById);
        this.mLogisticsPanel = ae1;
        ae1.f();
        this.mVipPanel = new de1(this.mainActivity, findViewById);
        be1 be1 = new be1(this.mainActivity, findViewById);
        this.mOlympicPanel = be1;
        be1.g();
        ce1 ce1 = new ce1(getActivity(), this.rootView);
        this.mServicePanel = ce1;
        ce1.i();
        this.mServicePanel.q(new f());
    }

    private void initHeadUserInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997266900")) {
            ipChange.ipc$dispatch("997266900", new Object[]{this});
            return;
        }
        this.mHeaderPanel.a(new UserCenterHeaderPanel(getActivity(), this.rootView, true, new ee1()));
    }

    private void initListView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840705105")) {
            ipChange.ipc$dispatch("-840705105", new Object[]{this});
            return;
        }
        this.mHorScrollView = (HorScrollView) this.rootView.findViewById(R$id.layout_horscroll);
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.view_pager);
        this.mHorScrollView.setVisibility(8);
        this.mViewPager.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        this.mTitleList = arrayList;
        arrayList.clear();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean("0", "动态", 0);
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean("1", "想看&想玩", 1);
        this.mTitleList.add(scrollTitleBean);
        this.mTitleList.add(scrollTitleBean2);
        this.mHorScrollView.setTitle(this.mTitleList).setLineType(2).setFontColor(R$color.color_000000, R$color.color_333333).setHeight(35).setSpace(10).setFontSize(16, 18).commit();
        this.mHorScrollView.setOnTitleClickListener(new g());
        this.mPageList.clear();
        MineDynamicFragment newInstance = MineDynamicFragment.newInstance(d20.i(), yd1.MY_PAGE);
        this.dynamicFragment = newInstance;
        newInstance.setDynamicUt(new lt2());
        this.seeFragment = Wanna2SeeFragment.newInstance(true, d20.i(), yd1.MY_PAGE, false);
        this.mPageList.add(this.dynamicFragment);
        this.mPageList.add(this.seeFragment);
        UserHomePagerAdapter userHomePagerAdapter = new UserHomePagerAdapter(getActivity().getSupportFragmentManager(), this.mPageList);
        this.mPagerAdapter = userHomePagerAdapter;
        this.mViewPager.setAdapter(userHomePagerAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.mine.userinfo.fragment.MineUserCenterFragment.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1237640907")) {
                    ipChange.ipc$dispatch("1237640907", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1100452246")) {
                    ipChange.ipc$dispatch("-1100452246", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1436174378")) {
                    ipChange.ipc$dispatch("-1436174378", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                MineUserCenterFragment mineUserCenterFragment = MineUserCenterFragment.this;
                mineUserCenterFragment.mSelectTitle = (ScrollTitleBean) mineUserCenterFragment.mTitleList.get(i);
                MineUserCenterFragment.this.mHorScrollView.selectTitle(i);
                if (MineUserCenterFragment.this.mSelectTitle != null) {
                    cn.damai.common.user.c.e().x(yd1.x().e0(MineUserCenterFragment.this.mSelectTitle.index, MineUserCenterFragment.this.mSelectTitle.name));
                }
            }
        });
        if (getArguments() != null && !TextUtils.isEmpty(getArguments().getString("pageName"))) {
            if ("WantedPage".equals(getArguments().getString("pageName"))) {
                this.mViewPager.setCurrentItem(1);
                this.mHorScrollView.selectTitle(1);
                this.mSelectTitle = this.mTitleList.get(1);
                if (getArguments() != null && getArguments().getInt(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX) > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX, getArguments().getInt(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX));
                    this.seeFragment.setArguments(bundle);
                }
            } else {
                this.mViewPager.setCurrentItem(0);
                this.mHorScrollView.selectTitle(0);
                this.mSelectTitle = this.mTitleList.get(0);
            }
            getArguments().putString("pageName", "");
            this.mAppBar.setExpanded(false, true);
        } else {
            this.mHorScrollView.selectTitle(0);
            this.mSelectTitle = this.mTitleList.get(0);
            this.mViewPager.setCurrentItem(0);
        }
        this.mViewPager.setOffscreenPageLimit(xf2.e(this.mPageList));
    }

    private void initSubmitView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129716149")) {
            ipChange.ipc$dispatch("2129716149", new Object[]{this});
        }
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386244773")) {
            ipChange.ipc$dispatch("-1386244773", new Object[]{this});
            return;
        }
        this.mLoginHeight = v50.a(getActivity(), 88.0f);
        MineUserCenterTitleNewView mineUserCenterTitleNewView = (MineUserCenterTitleNewView) this.rootView.findViewById(R$id.ll_mine_user_center_title);
        this.mTitleView = mineUserCenterTitleNewView;
        this.mTitleBarHeight = mineUserCenterTitleNewView.getTitleHeight();
        this.mScreenHeight = DisplayMetrics.getheightPixels(m42.b(getActivity()));
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.rootView.findViewById(R$id.layout_toolbar);
        this.mToolBarLayout = collapsingToolbarLayout;
        collapsingToolbarLayout.setMinimumHeight(this.mTitleBarHeight);
        AppBarLayout appBarLayout = (AppBarLayout) this.rootView.findViewById(R$id.appbar);
        this.mAppBar = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e());
    }

    private boolean isPicImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20353963")) {
            return ((Boolean) ipChange.ipc$dispatch("-20353963", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            String upperCase = str.toUpperCase();
            return upperCase.contains(".PNG") || upperCase.contains(".JPG");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadListView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167093238")) {
            ipChange.ipc$dispatch("-167093238", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mViewPager != null) {
            if (!zd1.d()) {
                this.mHorScrollView.setVisibility(8);
                this.mViewPager.setVisibility(8);
                updateToolBarMinHeight(false);
                return;
            }
            this.mHorScrollView.setVisibility(0);
            this.mViewPager.setVisibility(0);
            updateToolBarMinHeight(true);
            HorScrollView horScrollView = this.mHorScrollView;
            if (horScrollView != null) {
                horScrollView.selectTitle(i);
            }
            PtrChildHandler findChildPtrHandler = findChildPtrHandler();
            if (findChildPtrHandler != null) {
                findChildPtrHandler.onRefreshBegin(null, null);
            }
        }
    }

    private void loadUnReadMsgCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840244225")) {
            ipChange.ipc$dispatch("-840244225", new Object[]{this});
        } else if (zd1.d()) {
            query();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void markNode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020923101")) {
            ipChange.ipc$dispatch("2020923101", new Object[]{this, str});
            return;
        }
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.badgeNodes, this.listenerBadge);
        this.manager.c(str);
    }

    private void pauseRedPacket() {
        MineMainActivity mineMainActivity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162331425")) {
            ipChange.ipc$dispatch("-162331425", new Object[]{this});
        } else if (this.mHasRegisterRedPacketMsg && (mineMainActivity = this.mainActivity) != null && !mineMainActivity.isActivityFinsihed()) {
            CouponDialogHelper.l(getContext()).n();
        }
    }

    private void query() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401995360")) {
            ipChange.ipc$dispatch("-1401995360", new Object[]{this});
            return;
        }
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.messageNodes, this.listenerBadge);
        this.manager.h(this.badgeNodes, this.listenerBadge);
        this.manager.d(this.messageNodes);
        this.manager.d(this.badgeNodes);
    }

    private void refreshUserCenterData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897037763")) {
            ipChange.ipc$dispatch("897037763", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (!this.isResume) {
                setLoginUserInfoByCache();
            }
            requestUserCenterDataReq();
        } else {
            setNoLoginInfoView();
            requestNoLoginInfo();
        }
    }

    private void registerRedPacketMessage() {
        MineMainActivity mineMainActivity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985466609")) {
            ipChange.ipc$dispatch("985466609", new Object[]{this});
            return;
        }
        if (!this.mHasRegisterRedPacketMsg && (mineMainActivity = this.mainActivity) != null && !mineMainActivity.isActivityFinsihed()) {
            this.mHasRegisterRedPacketMsg = true;
            CouponDialogHelper.l(getContext()).r(this.mDMMessage);
        }
        resumeRedPacket();
    }

    private void requestNoLoginInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718456859")) {
            ipChange.ipc$dispatch("1718456859", new Object[]{this});
            return;
        }
        this.mViewModel.requestUnLoginVipInfo(new DMMtopRequestListener<VipCardInfoWrap>(VipCardInfoWrap.class) {
            /* class cn.damai.mine.userinfo.fragment.MineUserCenterFragment.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1147687723")) {
                    ipChange.ipc$dispatch("1147687723", new Object[]{this, str, str2});
                } else if (MineUserCenterFragment.this.mVipPanel != null) {
                    MineUserCenterFragment.this.mVipPanel.a();
                }
            }

            public void onSuccess(VipCardInfoWrap vipCardInfoWrap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1312664282")) {
                    ipChange.ipc$dispatch("1312664282", new Object[]{this, vipCardInfoWrap});
                    return;
                }
                MineUserCenterFragment mineUserCenterFragment = MineUserCenterFragment.this;
                mineUserCenterFragment.noLoginData = vipCardInfoWrap;
                if (vipCardInfoWrap != null) {
                    if (mineUserCenterFragment.mVipPanel != null) {
                        MineUserCenterFragment.this.mVipPanel.b(null, "成为会员", "0");
                    }
                    if (MineUserCenterFragment.this.mServicePanel != null) {
                        MineUserCenterFragment.this.mServicePanel.v(0, 0);
                        MineUserCenterFragment.this.mServicePanel.u(vipCardInfoWrap.getDynamicMenu());
                    }
                    MineUserCenterFragment.this.mHeaderPanel.setBGAtmosphereUrl(vipCardInfoWrap.getMyHeadAreaBgImg());
                    MineUserCenterFragment.this.updatePublicSubmit(vipCardInfoWrap.getPublishCheckInfo());
                    return;
                }
                onFail(null, null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestUserCenterDataReq() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710081315")) {
            ipChange.ipc$dispatch("-1710081315", new Object[]{this});
            return;
        }
        this.mViewModel.requestMineUserCenterData(new DMMtopRequestListener<UserCenterDataBean>(UserCenterDataBean.class) {
            /* class cn.damai.mine.userinfo.fragment.MineUserCenterFragment.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1155447082")) {
                    ipChange.ipc$dispatch("1155447082", new Object[]{this, str, str2});
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    ToastUtil.i(str2);
                }
                MineUserCenterFragment.this.alarm(str, str2);
                MineUserCenterFragment.this.sendTickletSyncBroadcast();
            }

            public void onSuccess(UserCenterDataBean userCenterDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1059994370")) {
                    ipChange.ipc$dispatch("-1059994370", new Object[]{this, userCenterDataBean});
                    return;
                }
                if (userCenterDataBean != null) {
                    MineUserCenterFragment.this.mUserCenterData = userCenterDataBean;
                    zd1.e(userCenterDataBean);
                    MineUserCenterFragment mineUserCenterFragment = MineUserCenterFragment.this;
                    mineUserCenterFragment.updateUserInfoData(mineUserCenterFragment.mUserCenterData);
                    if (MineUserCenterFragment.this.mLogisticsPanel != null) {
                        MineUserCenterFragment.this.mLogisticsPanel.m(MineUserCenterFragment.this.mUserCenterData.getLogistics());
                        MineUserCenterFragment.this.mLogisticsPanel.l(MineUserCenterFragment.this.mUserCenterData.getNotice());
                    }
                    MineUserCenterFragment.this.updatePublicSubmit(userCenterDataBean.getPublishCheckInfo());
                    MineUserCenterFragment.this.updateMemberUserGuide(userCenterDataBean.getUserGuide());
                }
                MineUserCenterFragment.this.sendTickletSyncBroadcast();
            }
        });
    }

    private void resumeRedPacket() {
        MineMainActivity mineMainActivity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630365020")) {
            ipChange.ipc$dispatch("630365020", new Object[]{this});
        } else if (this.mHasRegisterRedPacketMsg && (mineMainActivity = this.mainActivity) != null && !mineMainActivity.isActivityFinsihed()) {
            CouponDialogHelper.l(getContext()).o();
            CouponDialogHelper.l(getContext()).A(yd1.MY_PAGE);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendTickletSyncBroadcast() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202536622")) {
            ipChange.ipc$dispatch("-1202536622", new Object[]{this});
        } else if (LoginManager.k().q()) {
            zd1.f(getActivity());
        }
    }

    private void setLoginNoDataView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516026069")) {
            ipChange.ipc$dispatch("-1516026069", new Object[]{this});
            return;
        }
        MineUserCenterTitleNewView mineUserCenterTitleNewView = this.mTitleView;
        if (mineUserCenterTitleNewView != null) {
            mineUserCenterTitleNewView.updateUserInfo(null, null);
        }
        this.mHeaderPanel.showEmptyHeadView(ModeEmpty.MINE_TAB_NONE_CACHE);
        de1 de1 = this.mVipPanel;
        if (de1 != null) {
            de1.a();
        }
        ae1 ae1 = this.mLogisticsPanel;
        if (ae1 != null) {
            ae1.f();
        }
        be1 be1 = this.mOlympicPanel;
        if (be1 != null) {
            be1.g();
        }
        ce1 ce1 = this.mServicePanel;
        if (ce1 != null) {
            ce1.v(0, 0);
            this.mServicePanel.u(null);
        }
        updatePublicSubmit(null);
    }

    private void setLoginUserInfoByCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306508253")) {
            ipChange.ipc$dispatch("306508253", new Object[]{this});
            return;
        }
        UserCenterDataBean b2 = zd1.b();
        if (b2 != null) {
            updateUserInfoData(b2);
            this.mHeaderPanel.hideRealNameAuthView();
            ae1 ae1 = this.mLogisticsPanel;
            if (ae1 != null) {
                ae1.f();
            }
            be1 be1 = this.mOlympicPanel;
            if (be1 != null) {
                be1.g();
            }
            updatePublicSubmit(null);
            return;
        }
        setLoginNoDataView();
    }

    private void setNoLoginInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432176585")) {
            ipChange.ipc$dispatch("1432176585", new Object[]{this});
            return;
        }
        MineUserCenterTitleNewView mineUserCenterTitleNewView = this.mTitleView;
        if (mineUserCenterTitleNewView != null) {
            mineUserCenterTitleNewView.updateUserInfo(null, null);
        }
        this.mHeaderPanel.showEmptyHeadView(ModeEmpty.NONE_LOGIN);
        de1 de1 = this.mVipPanel;
        if (de1 != null) {
            de1.a();
        }
        ae1 ae1 = this.mLogisticsPanel;
        if (ae1 != null) {
            ae1.f();
        }
        be1 be1 = this.mOlympicPanel;
        if (be1 != null) {
            be1.g();
        }
        ce1 ce1 = this.mServicePanel;
        if (ce1 != null) {
            ce1.v(0, 0);
            this.mServicePanel.u(null);
        }
        updatePublicSubmit(null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateMemberUserGuide(UserCenterDataBean.UserGuideBean userGuideBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792768296")) {
            ipChange.ipc$dispatch("792768296", new Object[]{this, userGuideBean});
        } else if (userGuideBean == null || TextUtils.isEmpty(userGuideBean.content)) {
            this.ll_member_authorithize.setVisibility(8);
        } else {
            this.tv_member_authorithize_close.setOnClickListener(new b());
            this.ll_member_authorithize.setVisibility(0);
            this.tv_member_authorithize_desc.setText(userGuideBean.content);
            if (userGuideBean.isUnbind()) {
                if (userGuideBean.memberThreshold) {
                    this.type = "1";
                } else {
                    this.type = "3";
                }
                this.tv_member_authorithize_action.setText("立即绑定");
                this.ll_member_authorithize.setOnClickListener(new c());
            } else if (userGuideBean.isbindNotAuth()) {
                if (userGuideBean.memberThreshold) {
                    this.type = "2";
                } else {
                    this.type = "4";
                }
                this.tv_member_authorithize_action.setText("立即授权");
                this.ll_member_authorithize.setOnClickListener(new d());
            } else {
                this.ll_member_authorithize.setVisibility(8);
            }
            yd1.x().o0(this.ll_member_authorithize, this.type);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updatePublicSubmit(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379816264")) {
            ipChange.ipc$dispatch("379816264", new Object[]{this, minepublishCheckBean});
        } else if (this.dynamicFragment != null) {
            String str = null;
            if (LoginManager.k().q()) {
                if (this.mTemp == null) {
                    this.mTemp = new MinepublishCheckBean();
                }
                MinepublishCheckBean minepublishCheckBean2 = this.mTemp;
                if (minepublishCheckBean != null) {
                    str = minepublishCheckBean.appPublishHint;
                }
                minepublishCheckBean2.appPublishHint = str;
            } else {
                this.mTemp = null;
            }
            this.dynamicFragment.showPublishItemView(this.mTemp);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUserInfoData(UserCenterDataBean userCenterDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058358943")) {
            ipChange.ipc$dispatch("-1058358943", new Object[]{this, userCenterDataBean});
        } else if (userCenterDataBean != null) {
            String str = "0";
            if (userCenterDataBean.getUserInfo() != null) {
                UserInfoBean userInfo = userCenterDataBean.getUserInfo();
                MineUserCenterTitleNewView mineUserCenterTitleNewView = this.mTitleView;
                if (mineUserCenterTitleNewView != null) {
                    mineUserCenterTitleNewView.updateUserInfo(userInfo, userCenterDataBean.getMyHeadAreaBgImg());
                }
                if (!(userInfo == null || userInfo.getPerformFilmVipDO() == null)) {
                    str = userInfo.getPerformFilmVipDO().memberFlag;
                }
                zd1.g(userInfo);
            }
            this.mHeaderPanel.update(userCenterDataBean, userCenterDataBean.getCertificateInfo());
            if (this.mVipPanel != null) {
                UserPerformFileVip performFilmVip = userCenterDataBean.getPerformFilmVip();
                if (performFilmVip != null) {
                    this.mVipPanel.b(performFilmVip.getWillScore(), performFilmVip.title, str);
                } else {
                    this.mVipPanel.a();
                }
            }
            if (this.mOlympicPanel != null && xf2.e(userCenterDataBean.getBanner()) > 0) {
                this.mOlympicPanel.i(userCenterDataBean.getBanner().get(0));
            }
            ce1 ce1 = this.mServicePanel;
            if (ce1 != null) {
                ce1.v(userCenterDataBean.getCommentCount(), userCenterDataBean.getCouponCount());
                this.mServicePanel.u(userCenterDataBean.getDynamicMenu());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1987467315")) {
            return R$layout.mine_user_center_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-1987467315", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419483547")) {
            ipChange.ipc$dispatch("1419483547", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869789200")) {
            ipChange.ipc$dispatch("-1869789200", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754761389")) {
            ipChange.ipc$dispatch("1754761389", new Object[]{this});
            return;
        }
        this.mainActivity = (MineMainActivity) getActivity();
        this.mViewModel = (MineUserCenterViewModel) ViewModelProviders.of(getActivity()).get(MineUserCenterViewModel.class);
        this.mServiceMaskView = this.rootView.findViewById(R$id.bottom_service_mask);
        initBadgeData();
        initTitleView();
        initHeadUserInfoView();
        initContainerView();
        initSubmitView();
        initAuthView();
        registerRedPacketMessage();
        initListView();
        loadListView(this.mHorScrollView.getCurrentIndex());
        bindLoginListener(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494661734")) {
            ipChange.ipc$dispatch("494661734", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(yd1.x().B());
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342914221")) {
            ipChange.ipc$dispatch("-1342914221", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640504312")) {
            ipChange.ipc$dispatch("-1640504312", new Object[]{this});
            return;
        }
        super.onDestroyView();
        yp ypVar = this.manager;
        if (ypVar != null) {
            ypVar.j(this.messageNodes, this.listenerBadge);
            this.manager.j(this.badgeNodes, this.listenerBadge);
        }
        bindLoginListener(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272016369")) {
            ipChange.ipc$dispatch("1272016369", new Object[]{this});
            return;
        }
        super.onPause();
        this.isResume = true;
        pauseRedPacket();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869379018")) {
            ipChange.ipc$dispatch("-1869379018", new Object[]{this});
            return;
        }
        super.onResume();
        Bundle arguments = getArguments();
        if (!(arguments == null || TextUtils.isEmpty(arguments.getString("pageName")) || this.mViewPager == null || this.mHorScrollView == null || this.mSelectTitle == null || this.mAppBar == null)) {
            if ("WantedPage".equals(getArguments().getString("pageName"))) {
                this.mViewPager.setCurrentItem(1);
                this.mHorScrollView.selectTitle(1);
                this.mSelectTitle = this.mTitleList.get(1);
            } else {
                this.mViewPager.setCurrentItem(0);
                this.mHorScrollView.selectTitle(0);
                this.mSelectTitle = this.mTitleList.get(0);
            }
            this.mAppBar.setExpanded(false, true);
            getArguments().putString("pageName", "");
        }
        refreshUserCenterData();
        loadUnReadMsgCount();
        resumeRedPacket();
    }

    public void updateToolBarMinHeight(boolean z) {
        View view;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "680829337")) {
            ipChange.ipc$dispatch("680829337", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mToolBarLayout != null && (view = this.mServiceMaskView) != null) {
            view.setVisibility(z ? 0 : 8);
            if (z) {
                if (Build.VERSION.SDK_INT >= 16) {
                    i = this.mToolBarLayout.getMinimumHeight();
                }
                int i2 = this.mTitleBarHeight;
                if (i != i2) {
                    this.mToolBarLayout.setMinimumHeight(i2);
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i = this.mToolBarLayout.getMinimumHeight();
            }
            int i3 = this.mScreenHeight;
            if (i != i3) {
                this.mToolBarLayout.setMinimumHeight(i3);
            }
        }
    }
}
