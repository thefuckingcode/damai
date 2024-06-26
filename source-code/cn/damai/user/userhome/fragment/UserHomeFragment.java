package cn.damai.user.userhome.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.bean.FollowEvent;
import cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.userhome.adapter.UserHomePagerAdapter;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import cn.damai.user.userhome.model.UserHomeViewModel;
import cn.damai.user.userhome.view.UserHomeTitleView;
import cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.List;
import tb.aj0;
import tb.en1;
import tb.et2;
import tb.gt2;
import tb.mt2;
import tb.tu0;
import tb.v50;

/* compiled from: Taobao */
public class UserHomeFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_LOGIN_ON_ATTENTION = 101;
    public static final int REQUEST_CODE_LOGIN_ON_SUBMIT = 100;
    private MineDynamicFragment dynamicFragment;
    private boolean isRequesting = false;
    private AppBarLayout mAppBar;
    private boolean mAutoFollowOnDataLoad;
    private MinepublishCheckBean mCheckInfo;
    private et2 mHeaderPanel = new et2();
    private HorScrollView mHorScrollView;
    private UserHomePagerAdapter mPagerAdapter;
    private ScrollTitleBean mSelectTitle;
    private int mTitleBarHeight;
    private List<ScrollTitleBean> mTitleList;
    private UserHomeTitleView mTitleView;
    private int mUserInfoHeight;
    private UserHomeViewModel mViewModel;
    private ViewPager mViewPager;
    boolean myself = false;
    private Wanna2SeeFragment seeFragment;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1732190768")) {
                ipChange.ipc$dispatch("1732190768", new Object[]{this, view});
                return;
            }
            Activity activity = UserHomeFragment.this.mActivity;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1445589694")) {
                ipChange.ipc$dispatch("1445589694", new Object[]{this, obj});
            } else if (obj != null && (obj instanceof Boolean)) {
                if (((Boolean) obj).booleanValue()) {
                    ToastUtil.i("关注成功啦～");
                } else {
                    ToastUtil.i("取消关注成功啦～");
                }
                UserHomeFragment.this.request(false, true);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "431355650")) {
                ipChange.ipc$dispatch("431355650", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = ((float) Math.abs(i)) / ((float) (UserHomeFragment.this.mTitleBarHeight + UserHomeFragment.this.mUserInfoHeight));
            if (UserHomeFragment.this.mTitleView != null) {
                UserHomeFragment.this.mTitleView.setBackGroundAlpha(abs);
                if (abs >= 1.0f) {
                    UserHomeFragment userHomeFragment = UserHomeFragment.this;
                    if (!userHomeFragment.myself) {
                        userHomeFragment.mTitleView.getAttentionView().setVisibility(0);
                        return;
                    }
                }
                UserHomeFragment.this.mTitleView.getAttentionView().setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AttentionView a;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a(d dVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-964303889")) {
                    ipChange.ipc$dispatch("-964303889", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "5277134")) {
                    ipChange.ipc$dispatch("5277134", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else if (UserHomeFragment.this.mTitleView != null && UserHomeFragment.this.mTitleView.getAttentionView() != null) {
                    UserHomeFragment.this.mTitleView.getAttentionView().getRelationUpdateAndLogin();
                }
            }
        }

        d(AttentionView attentionView) {
            this.a = attentionView;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-523872717")) {
                ipChange.ipc$dispatch("-523872717", new Object[]{this, view});
                return;
            }
            FragmentActivity activity = UserHomeFragment.this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                if (!LoginManager.k().q()) {
                    LoginManager.k().y(UserHomeFragment.this, new Intent(), 101);
                    return;
                }
                int state = this.a.getState();
                if (state == 1 || state == 2) {
                    DMDialog dMDialog = new DMDialog(activity);
                    dMDialog.o(false).q("确认不在关注TA了？");
                    dMDialog.i("取消", new a(this));
                    dMDialog.n(PurchaseConstants.CONFIRM, new b()).show();
                } else if (UserHomeFragment.this.mTitleView != null && UserHomeFragment.this.mTitleView.getAttentionView() != null) {
                    UserHomeFragment.this.mTitleView.getAttentionView().getRelationUpdateAndLogin();
                }
            }
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
            if (AndroidInstantRuntime.support(ipChange, "-92142529")) {
                return ((Boolean) ipChange.ipc$dispatch("-92142529", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
            }
            PtrChildHandler findChildPtrHandler = UserHomeFragment.this.findChildPtrHandler();
            if (findChildPtrHandler == null || UserHomeFragment.this.mAppBar.getTop() < 0 || !findChildPtrHandler.checkCanDoRefresh(ptrFrameLayout, view, view2)) {
                return false;
            }
            return true;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1946632206")) {
                ipChange.ipc$dispatch("-1946632206", new Object[]{this, ptrFrameLayout});
                return;
            }
            PtrChildHandler findChildPtrHandler = UserHomeFragment.this.findChildPtrHandler();
            if (findChildPtrHandler != null) {
                UserHomeFragment.this.request(false, false);
                findChildPtrHandler.onRefreshBegin(ptrFrameLayout, null);
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
            if (AndroidInstantRuntime.support(ipChange, "1515031094")) {
                ipChange.ipc$dispatch("1515031094", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null) {
                UserHomeFragment.this.mSelectTitle = scrollTitleBean;
                UserHomeFragment.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void afterDataLoadSuccess(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131257027")) {
            ipChange.ipc$dispatch("131257027", new Object[]{this, userHomeDataBean});
        } else if (userHomeDataBean != null && this.mAutoFollowOnDataLoad && !userHomeDataBean.isMySelf() && userHomeDataBean.getFollowStatus() == 0) {
            this.mTitleView.getAttentionView().getRelationUpdateAndLogin();
            this.mAutoFollowOnDataLoad = false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private PtrChildHandler findChildPtrHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256476001")) {
            return (PtrChildHandler) ipChange.ipc$dispatch("-256476001", new Object[]{this});
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getUserId(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391863519")) {
            return (String) ipChange.ipc$dispatch("-1391863519", new Object[]{this, userInfoBean});
        }
        String str = null;
        if (userInfoBean != null) {
            str = userInfoBean.havanaIdStr;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        UserHomeViewModel userHomeViewModel = this.mViewModel;
        return userHomeViewModel != null ? userHomeViewModel.getUserId() : "";
    }

    private void initHeadUserInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981731228")) {
            ipChange.ipc$dispatch("-981731228", new Object[]{this});
            return;
        }
        this.mHeaderPanel.a(new UserCenterHeaderPanel(getActivity(), this.rootView, false, new en1()));
    }

    private void initPtr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1136299110")) {
            ipChange.ipc$dispatch("-1136299110", new Object[]{this});
            return;
        }
        PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) this.rootView.findViewById(R$id.ll_refresh_layout);
        PtrUiHeader ptrUiHeader = new PtrUiHeader(getActivity());
        ptrFrameLayout.setHeaderView(ptrUiHeader);
        ptrFrameLayout.addPtrUIHandler(ptrUiHeader);
        ptrFrameLayout.setPtrIndicator(new aj0(150, getContext()));
        ptrFrameLayout.setResistance(1.7f);
        ptrFrameLayout.setPtrHandler(new e());
        ptrFrameLayout.disableWhenHorizontalMove(true);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152007883")) {
            ipChange.ipc$dispatch("152007883", new Object[]{this});
            return;
        }
        this.mUserInfoHeight = v50.a(getActivity(), 88.0f);
        UserHomeTitleView userHomeTitleView = (UserHomeTitleView) this.rootView.findViewById(R$id.ll_user_center_title);
        this.mTitleView = userHomeTitleView;
        userHomeTitleView.setBackListener(new a());
        this.mDMMessage.b(FollowEvent.LIVE_FOLLOW_EVENT, new b());
        this.mTitleBarHeight = this.mTitleView.getTitleHeight();
        this.rootView.findViewById(R$id.layout_toolbar).setMinimumHeight(this.mTitleBarHeight);
        AppBarLayout appBarLayout = (AppBarLayout) this.rootView.findViewById(R$id.appbar);
        this.mAppBar = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new c());
        initPtr();
        AttentionView attentionView = this.mTitleView.getAttentionView();
        cn.damai.commonbusiness.view.AttentionView attentionView2 = this.mHeaderPanel.getAttentionView();
        d dVar = new d(attentionView);
        if (attentionView2 != null) {
            attentionView.addAttentionView(attentionView2);
            attentionView2.setOnAttentionClickDelegate(dVar);
        }
        attentionView.setOnAttentionClickDelegate(dVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadListData(boolean z, String str) {
        boolean z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655656038")) {
            ipChange.ipc$dispatch("-655656038", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.mHorScrollView = (HorScrollView) this.rootView.findViewById(R$id.layout_horscroll);
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.view_pager);
        this.mHorScrollView.setVisibility(0);
        this.mViewPager.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        this.mTitleList = arrayList;
        arrayList.clear();
        this.mTitleList.add(new ScrollTitleBean("0", "动态", 0));
        if (z) {
            this.mTitleList.add(new ScrollTitleBean("1", "想看&想玩", 1));
            z2 = true;
        } else {
            z2 = false;
        }
        this.mHorScrollView.setTitle(this.mTitleList).setLineType(2).setFontColor(R$color.color_000000, R$color.color_333333).setHeight(35).setSpace(10).setFontSize(16, 18).setLineShow(z2).commit();
        this.mHorScrollView.setOnTitleClickListener(new f());
        this.mHorScrollView.selectTitle(0);
        this.mSelectTitle = this.mTitleList.get(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        if (this.dynamicFragment == null) {
            MineDynamicFragment newInstance = MineDynamicFragment.newInstance(str);
            this.dynamicFragment = newInstance;
            newInstance.setDynamicUt(new mt2());
        }
        arrayList2.add(this.dynamicFragment);
        if (z) {
            if (this.seeFragment == null) {
                this.seeFragment = Wanna2SeeFragment.newInstance(false, str, gt2.USER_HOME_PAGE, false);
            }
            arrayList2.add(this.seeFragment);
        }
        UserHomePagerAdapter userHomePagerAdapter = new UserHomePagerAdapter(getActivity().getSupportFragmentManager(), arrayList2);
        this.mPagerAdapter = userHomePagerAdapter;
        this.mViewPager.setAdapter(userHomePagerAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.user.userhome.fragment.UserHomeFragment.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2025914939")) {
                    ipChange.ipc$dispatch("2025914939", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "221182426")) {
                    ipChange.ipc$dispatch("221182426", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-482844858")) {
                    ipChange.ipc$dispatch("-482844858", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                UserHomeFragment.this.mHorScrollView.selectTitle(i);
                UserHomeFragment userHomeFragment = UserHomeFragment.this;
                userHomeFragment.mSelectTitle = (ScrollTitleBean) userHomeFragment.mTitleList.get(i);
                if (UserHomeFragment.this.mSelectTitle != null) {
                    cn.damai.common.user.c.e().x(gt2.j().l(UserHomeFragment.this.mSelectTitle.index, UserHomeFragment.this.mSelectTitle.name));
                }
            }
        });
        this.mViewPager.setCurrentItem(0);
        if (z) {
            this.mViewPager.setOffscreenPageLimit(2);
        } else {
            this.mViewPager.setOffscreenPageLimit(1);
        }
        this.dynamicFragment.showPublishItemView(this.mCheckInfo);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void request(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418589033")) {
            ipChange.ipc$dispatch("1418589033", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (!this.isRequesting) {
            this.isRequesting = true;
            startProgressDialog();
            requestUserData(z, z2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1286205802")) {
            ipChange.ipc$dispatch("-1286205802", new Object[]{this});
            return;
        }
        this.isRequesting = false;
        stopProgressDialog();
    }

    private void requestUserData(final boolean z, final boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998863788")) {
            ipChange.ipc$dispatch("-1998863788", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mViewModel.requestMineUserCenterData(new DMMtopRequestListener<UserHomeDataBean>(UserHomeDataBean.class) {
            /* class cn.damai.user.userhome.fragment.UserHomeFragment.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1311849317")) {
                    ipChange.ipc$dispatch("-1311849317", new Object[]{this, str, str2});
                    return;
                }
                UserHomeFragment.this.requestFinish();
                if (!z2) {
                    UserHomeFragment userHomeFragment = UserHomeFragment.this;
                    userHomeFragment.onResponseError(str2, str, "mtop.damai.wireless.user.my.content.get", ((BaseFragment) userHomeFragment).rootView.findViewById(R$id.main_view), false);
                }
            }

            public void onSuccess(UserHomeDataBean userHomeDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "281785866")) {
                    ipChange.ipc$dispatch("281785866", new Object[]{this, userHomeDataBean});
                    return;
                }
                UserHomeFragment.this.requestFinish();
                UserHomeFragment userHomeFragment = UserHomeFragment.this;
                userHomeFragment.onResponseSuccess(((BaseFragment) userHomeFragment).rootView.findViewById(R$id.main_view));
                if (userHomeDataBean != null) {
                    tu0.a(userHomeDataBean);
                    UserHomeFragment.this.updateUserInfoData(userHomeDataBean);
                    if (z) {
                        UserHomeFragment.this.loadListData(userHomeDataBean.isShowWantLabel(), UserHomeFragment.this.getUserId(userHomeDataBean.getUserInfo()));
                    }
                    UserHomeFragment.this.afterDataLoadSuccess(userHomeDataBean);
                } else if (!z2) {
                    onFail("", "网络异常，请稍后重试");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUserInfoData(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601480590")) {
            ipChange.ipc$dispatch("601480590", new Object[]{this, userHomeDataBean});
        } else if (userHomeDataBean != null) {
            String str = null;
            if (userHomeDataBean.getUserInfo() != null) {
                UserInfoBean userInfo = userHomeDataBean.getUserInfo();
                this.myself = userHomeDataBean.isMySelf();
                this.mHeaderPanel.update(userHomeDataBean, null);
                if (this.mTitleView != null) {
                    UserHomeViewModel userHomeViewModel = this.mViewModel;
                    this.mTitleView.updateUserInfo(userInfo, userHomeDataBean.isMySelf(), userHomeDataBean.getFollowStatus(), userHomeViewModel != null ? userHomeViewModel.getUserId() : "0");
                }
            }
            if (this.myself) {
                MinepublishCheckBean publishCheckInfo = userHomeDataBean.getPublishCheckInfo();
                MinepublishCheckBean minepublishCheckBean = new MinepublishCheckBean();
                this.mCheckInfo = minepublishCheckBean;
                if (publishCheckInfo != null) {
                    str = publishCheckInfo.appPublishHint;
                }
                minepublishCheckBean.appPublishHint = str;
                return;
            }
            this.mCheckInfo = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1034137795")) {
            return R$layout.fragment_user_home;
        }
        return ((Integer) ipChange.ipc$dispatch("-1034137795", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54916053")) {
            ipChange.ipc$dispatch("-54916053", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        request(true, false);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331536544")) {
            ipChange.ipc$dispatch("-331536544", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160054467")) {
            ipChange.ipc$dispatch("-160054467", new Object[]{this});
            return;
        }
        UserHomeViewModel userHomeViewModel = (UserHomeViewModel) ViewModelProviders.of(getActivity()).get(UserHomeViewModel.class);
        this.mViewModel = userHomeViewModel;
        userHomeViewModel.initParams(getActivity().getIntent());
        initHeadUserInfoView();
        initTitleView();
        request(true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031531036")) {
            ipChange.ipc$dispatch("-2031531036", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                request(false, false);
            }
        } else if (i == 101 && i2 == -1) {
            this.mAutoFollowOnDataLoad = true;
            request(false, false);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206534627")) {
            ipChange.ipc$dispatch("206534627", new Object[]{this, view});
        }
    }
}
