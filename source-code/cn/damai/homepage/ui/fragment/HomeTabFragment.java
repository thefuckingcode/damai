package cn.damai.homepage.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.DamaiConstants;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.request.CategoryCalendarRequest;
import cn.damai.commonbusiness.home.bean.HeadLottieBean;
import cn.damai.commonbusiness.home.bean.HeadLottieStyleBean;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.helper.HomePageTopLottieHelper;
import cn.damai.homepage.request.HomeTabRequest;
import cn.damai.homepage.ui.adapter.TabPagerAdapter;
import cn.damai.homepage.ui.listener.HomeGetPageListener;
import cn.damai.homepage.ui.listener.HomeGoTopOrRecommendListener;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.listener.IsRefreshListener;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.uikit.tag.DMCertInfoTagView;
import com.airbnb.lottie.LottieAnimationView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.resource.widget.YKActionSheet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.ax0;
import tb.br;
import tb.d20;
import tb.f92;
import tb.fw0;
import tb.gi;
import tb.gr;
import tb.hp1;
import tb.ix0;
import tb.jx0;
import tb.kr1;
import tb.lp1;
import tb.n42;
import tb.ne2;
import tb.s71;
import tb.v50;
import tb.ve;
import tb.xs0;
import tb.yp;

/* compiled from: Taobao */
public class HomeTabFragment extends DamaiBaseMvpFragment implements HomeFragmentAgent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DM_MSGBOX = "DM_MSGBOX";
    public static final String EXTRA = "extra_key";
    private static final int REQUEST_CODE_OPEN_MESSAGE_CENTER = 111;
    private DMCertInfoTagView certInfoView;
    int lastTy = -2;
    private MainActivity mActivity;
    private yp mBadgManager;
    private DMBadgeListener mBadgeListener = new h();
    public int mCurIndex = 0;
    private String mCurrentCity;
    private HomeData mData;
    private ImageView mHeaderbgImage;
    private IsRefreshListener mHomeIsRefreshListener = new c();
    private List<HomeTabBean> mHomeTabBeanList;
    private HomeTopBgListener mHomeTopBgListener = new b();
    private boolean mIsHasBg = false;
    private boolean mIsPageTop = true;
    private boolean mIsRefresh = false;
    private boolean mIsScrollCurPage = true;
    private LottieAnimationView mLottieTopView;
    private FrameLayout mMessage;
    private DMIconFontTextView mMessageIcon;
    private TextView mMessageTip;
    private int mOldPosition = -1;
    public HomeTabBean mOldSelectTab;
    private TabPagerAdapter mPagerAdapter;
    private DMIconFontTextView mScan;
    private HomeTabScrollView mScrollView;
    private TextView mSearchText;
    private LinearLayout mSearchView;
    private TextView mSelectCity;
    private DMIconFontTextView mSelectCityIcon;
    private LinearLayout mSelectCityLayout;
    public HomeTabBean mSelectTab;
    public HomeTabBean mSelectTab2;
    private OnTabClickListener mTabClickListener;
    private TabExtra mTabExtra;
    private List<ScrollTitleBean> mTabList = new ArrayList();
    private View mTitleBar;
    private View mTopBgLayout;
    private View mTopBgView;
    private int mUpdateHeaderInt = -1;
    private ViewPager mViewPager;
    List<String> rootNodes = new ArrayList() {
        /* class cn.damai.homepage.ui.fragment.HomeTabFragment.AnonymousClass18 */

        {
            add(HomeTabFragment.DM_MSGBOX);
            add(yp.f);
        }
    };

    /* compiled from: Taobao */
    public interface OnTabClickListener {
        void onTabSelect(int i);
    }

    /* compiled from: Taobao */
    public class a implements PageUtExecutor.UTKeyBuilderProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.UTKeyBuilderProvider
        public a.b get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-27392381")) {
                return (a.b) ipChange.ipc$dispatch("-27392381", new Object[]{this, Integer.valueOf(i)});
            } else if (HomeTabFragment.this.mTabList == null) {
                return null;
            } else {
                ScrollTitleBean scrollTitleBean = (ScrollTitleBean) f92.b(HomeTabFragment.this.mTabList, i);
                if (scrollTitleBean instanceof HomeTabBean) {
                    return new a.b().i(((HomeTabBean) scrollTitleBean).spmb).a(d20.d());
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements HomeTopBgListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.homepage.ui.listener.HomeTopBgListener
        public void onUpdateBg(HomeHeaderBg homeHeaderBg) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1951930807")) {
                ipChange.ipc$dispatch("1951930807", new Object[]{this, homeHeaderBg});
            } else if (homeHeaderBg != null) {
                HomeTabFragment.this.saveTopBg(homeHeaderBg);
                if (HomeTabFragment.this.checkIsCurTab(homeHeaderBg)) {
                    HomeTabFragment.this.mIsHasBg = false;
                    HomeTabFragment.this.setTopAllBg(homeHeaderBg);
                }
            }
        }

        @Override // cn.damai.homepage.ui.listener.HomeTopBgListener
        @SuppressLint({"NewApi"})
        public void scrollY(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1273249443")) {
                ipChange.ipc$dispatch("1273249443", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            HomeTabFragment.this.setTopBgTranslationY(i);
            HomeTabFragment.this.updateHeaderColor();
        }
    }

    /* compiled from: Taobao */
    public class c implements IsRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.tetris.listener.IsRefreshListener
        public void isRrefresh(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "468942888")) {
                ipChange.ipc$dispatch("468942888", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            HomeTabFragment.this.mIsRefresh = z;
        }
    }

    /* compiled from: Taobao */
    public class d implements HomePageTopLottieHelper.OnLoadResultListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeHeaderBg a;

        d(HomeHeaderBg homeHeaderBg) {
            this.a = homeHeaderBg;
        }

        @Override // cn.damai.homepage.helper.HomePageTopLottieHelper.OnLoadResultListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1663946436")) {
                ipChange.ipc$dispatch("1663946436", new Object[]{this});
                return;
            }
            HomeTabFragment homeTabFragment = HomeTabFragment.this;
            HomeHeaderBg homeHeaderBg = this.a;
            homeTabFragment.setTopBg(homeHeaderBg.headBackgroudPic, homeHeaderBg.headColor);
            if (HomeTabFragment.this.mCurIndex == 0) {
                br.c("showNullView", null);
            }
        }

        @Override // cn.damai.homepage.helper.HomePageTopLottieHelper.OnLoadResultListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1254768282")) {
                ipChange.ipc$dispatch("-1254768282", new Object[]{this});
                return;
            }
            HomeTabFragment.this.mIsHasBg = true;
            HomeTabFragment.this.updateHeaderColor();
        }

        @Override // cn.damai.homepage.helper.HomePageTopLottieHelper.OnLoadResultListener
        public void onUpdateStyle(HeadLottieStyleBean headLottieStyleBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1250517578")) {
                ipChange.ipc$dispatch("-1250517578", new Object[]{this, headLottieStyleBean});
            } else if (HomeTabFragment.this.mCurIndex == 0) {
                br.c("showNullView", headLottieStyleBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "519264932")) {
                ipChange.ipc$dispatch("519264932", new Object[]{this, dVar});
                return;
            }
            HomeTabFragment.this.updateTopColor(this.a);
        }
    }

    /* compiled from: Taobao */
    public class f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        @SuppressLint({"NewApi"})
        public void onSuccess(DMImageCreator.e eVar) {
            int i;
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1054228167")) {
                ipChange.ipc$dispatch("-1054228167", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
                HomeTabFragment.this.mHeaderbgImage.setImageBitmap(bitmap);
            } else {
                Drawable drawable = eVar.a;
                i2 = drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                HomeTabFragment.this.mHeaderbgImage.setBackground(drawable);
                i = intrinsicWidth;
            }
            ViewGroup.LayoutParams layoutParams = HomeTabFragment.this.mHeaderbgImage.getLayoutParams();
            if (layoutParams.height == -2 && i > 0) {
                layoutParams.height = (int) (((float) DisplayMetrics.getwidthPixels(n42.b(xs0.a()))) * (((float) i2) / ((float) i)));
                HomeTabFragment.this.mHeaderbgImage.requestLayout();
            }
            HomeTabFragment.this.mIsHasBg = true;
            HomeTabFragment.this.updateHeaderColor();
        }
    }

    /* compiled from: Taobao */
    public class g implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1688009839")) {
                ipChange.ipc$dispatch("1688009839", new Object[]{this, str});
                return;
            }
            HomeTabFragment.this.mSearchText.setText(str);
            HomeTabFragment.this.mSearchText.getPaint().setShader(new LinearGradient(0.0f, 0.0f, (float) HomeTabFragment.this.mSearchText.getWidth(), 0.0f, Color.parseColor("#ffa7c4"), Color.parseColor("#bf9cff"), Shader.TileMode.CLAMP));
            ax0.I().Z(HomeTabFragment.this.mSearchView, str);
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
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1850295169")) {
                ipChange.ipc$dispatch("-1850295169", new Object[]{this, str, badgeNodeItem});
                return;
            }
            HomeTabFragment.this.mBadgManager.i(str, HomeTabFragment.this.mBadgeListener);
            int count = badgeNodeItem.getCount();
            HomeTabFragment.this.mMessageTip.setText(count > 9 ? "9+" : String.valueOf(count));
            TextView textView = HomeTabFragment.this.mMessageTip;
            if (count <= 0) {
                i = 8;
            }
            textView.setVisibility(i);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(List<String> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-272940921")) {
                ipChange.ipc$dispatch("-272940921", new Object[]{this, list, str, str2});
                return;
            }
            HomeTabFragment.this.mBadgManager.j(list, HomeTabFragment.this.mBadgeListener);
        }
    }

    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1727432407")) {
                ipChange.ipc$dispatch("1727432407", new Object[]{this, view});
                return;
            }
            DMNav.from(HomeTabFragment.this.getActivity()).toUri("https://p.damai.cn/wow/act/act/license");
        }
    }

    /* compiled from: Taobao */
    public class j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-456244520")) {
                ipChange.ipc$dispatch("-456244520", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ax0.I().A());
            Bundle bundle = new Bundle();
            bundle.putString("data", "home");
            bundle.putBoolean(MonitorType.SKIP, true);
            DMNav.from(HomeTabFragment.this.getActivity()).withExtras(bundle).forResult(78).toUri(NavUri.b("home_cityselect"));
        }
    }

    /* compiled from: Taobao */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        public void onClick(View view) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1655045849")) {
                ipChange.ipc$dispatch("1655045849", new Object[]{this, view});
                return;
            }
            if (HomeTabFragment.this.mSearchText != null) {
                try {
                    str = HomeTabFragment.this.mSearchText.getText().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cn.damai.common.user.c.e().x(ax0.I().F(str, null));
                Bundle bundle = new Bundle();
                bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
                bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
                DMNav.from(HomeTabFragment.this.getActivity()).withExtras(bundle).toUri(NavUri.b(gr.o));
            }
            str = "";
            cn.damai.common.user.c.e().x(ax0.I().F(str, null));
            Bundle bundle2 = new Bundle();
            bundle2.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
            bundle2.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
            DMNav.from(HomeTabFragment.this.getActivity()).withExtras(bundle2).toUri(NavUri.b(gr.o));
        }
    }

    /* compiled from: Taobao */
    public class l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements OnGrantListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1008331256")) {
                    ipChange.ipc$dispatch("1008331256", new Object[]{this});
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(MonitorType.SKIP, true);
                DMNav.from(HomeTabFragment.this.getActivity()).withExtras(bundle).toUri(NavUri.b("home_scan"));
            }
        }

        l() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-528631078")) {
                ipChange.ipc$dispatch("-528631078", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ax0.I().D());
            hp1.c(HomeTabFragment.this, false, lp1.CAMERA, "才能扫码～", new a());
        }
    }

    /* compiled from: Taobao */
    public class m implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1582659291")) {
                ipChange.ipc$dispatch("1582659291", new Object[]{this, view});
            } else if (LoginManager.k().q()) {
                DMNav.from(HomeTabFragment.this.getActivity()).toUri(NavUri.b(gr.x));
            } else {
                LoginManager.k().y(HomeTabFragment.this, new Intent(), 111);
            }
        }
    }

    /* compiled from: Taobao */
    public class n implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1436330775")) {
                ipChange.ipc$dispatch("-1436330775", new Object[]{this, obj});
                return;
            }
            kr1.Companion.a().p(d20.c());
            HomeTabFragment.this.updateShowCity();
            HomeTabFragment.this.scrollToTop();
            ((MainActivity) HomeTabFragment.this.getActivity()).getTabbarManager().h().h();
        }
    }

    /* compiled from: Taobao */
    public class o implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1437886175")) {
                ipChange.ipc$dispatch("1437886175", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && HomeTabFragment.this.mViewPager != null && f92.g(HomeTabFragment.this.mTabList)) {
                try {
                    HomeTabFragment homeTabFragment = HomeTabFragment.this;
                    homeTabFragment.mSelectTab2 = (HomeTabBean) homeTabFragment.mTabList.get(scrollTitleBean.index);
                    HomeTabFragment.this.mViewPager.setCurrentItem(scrollTitleBean.index);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CMSTAB", "TabClick error " + e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changePage(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175691945")) {
            ipChange.ipc$dispatch("175691945", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.mOldPosition != i2) {
            this.mOldPosition = i2;
            OnTabClickListener onTabClickListener = this.mTabClickListener;
            if (onTabClickListener != null) {
                onTabClickListener.onTabSelect(i2);
            }
            this.mScrollView.selectTitle(i2);
            this.mOldSelectTab = this.mSelectTab;
            this.mSelectTab = (HomeTabBean) this.mTabList.get(i2);
            this.mSelectTab2 = (HomeTabBean) this.mTabList.get(i2);
            if (this.mSelectTab != null) {
                this.mCurIndex = i2;
                resetHeader();
                utBuilder();
                cn.damai.common.user.c.e().x(ix0.g().h(this.mCurIndex, this.mSelectTab.name));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkIsCurTab(HomeHeaderBg homeHeaderBg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452283092")) {
            return ((Boolean) ipChange.ipc$dispatch("452283092", new Object[]{this, homeHeaderBg})).booleanValue();
        } else if (this.mSelectTab2 == null) {
            return true;
        } else {
            if (TextUtils.isEmpty(homeHeaderBg.categoryId) || TextUtils.isEmpty(this.mSelectTab2.categoryId)) {
                if (homeHeaderBg.type == this.mSelectTab2.type) {
                    return true;
                }
            } else if (homeHeaderBg.categoryId.equals(this.mSelectTab2.categoryId)) {
                return true;
            }
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631618201")) {
            ipChange.ipc$dispatch("-631618201", new Object[]{this});
        } else if (getArguments() != null) {
            this.mTabExtra = (TabExtra) getArguments().getParcelable("extra_key");
        }
    }

    private void initStatuBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905993015")) {
            ipChange.ipc$dispatch("905993015", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(getActivity());
                findViewById.setVisibility(0);
                this.mData.titleLayoutHeight = v50.a(getActivity(), 45.0f) + ne2.a(getActivity());
            }
            ne2.f(getActivity(), true, R$color.black);
            ne2.d(true, getActivity());
            return;
        }
        ne2.f(getActivity(), false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.mData.titleLayoutHeight = v50.a(getActivity(), 45.0f);
    }

    private void initTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592462708")) {
            ipChange.ipc$dispatch("-1592462708", new Object[]{this});
            return;
        }
        this.mScrollView = (HomeTabScrollView) this.rootView.findViewById(R$id.horScrollView);
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.viewpager);
    }

    @SuppressLint({"NewApi"})
    private void initTitleBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083944018")) {
            ipChange.ipc$dispatch("-1083944018", new Object[]{this});
            return;
        }
        this.mHeaderbgImage = (ImageView) this.rootView.findViewById(R$id.top_bg_image);
        this.mTopBgLayout = this.rootView.findViewById(R$id.layout_top_bg);
        this.mTopBgView = this.rootView.findViewById(R$id.view_top_bg);
        this.mLottieTopView = (LottieAnimationView) this.rootView.findViewById(R$id.lottie_top_view);
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mLottieTopView.getLayoutParams().height = n42.a(this.mActivity, (float) ((int) ((((float) ((int) (((float) DisplayMetrics.getwidthPixels(displayMetrics)) / displayMetrics.density))) / 392.0f) * 420.0f)));
        this.mTitleBar = this.rootView.findViewById(R$id.homepage_title_bar);
        this.mSelectCityLayout = (LinearLayout) this.rootView.findViewById(R$id.homepage_title_select_city_layout);
        this.mSelectCity = (TextView) this.rootView.findViewById(R$id.homepage_title_select_city);
        this.mSelectCityIcon = (DMIconFontTextView) this.rootView.findViewById(R$id.homepage_title_select_city_icon);
        this.mSearchView = (LinearLayout) this.rootView.findViewById(R$id.homepage_title_search_layout);
        setSearchBackground(getContext(), this.mSearchView, false);
        this.mSearchText = (TextView) this.rootView.findViewById(R$id.homepage_title_search);
        this.mScan = (DMIconFontTextView) this.rootView.findViewById(R$id.homepage_title_scan);
        this.mMessage = (FrameLayout) this.rootView.findViewById(R$id.homepage_title_message_layout);
        this.certInfoView = (DMCertInfoTagView) this.rootView.findViewById(R$id.homepage_title_cert_info);
        this.mMessageIcon = (DMIconFontTextView) this.rootView.findViewById(R$id.homepage_title_message);
        this.mMessageTip = (TextView) this.rootView.findViewById(R$id.homepage_title_message_tip_point);
        String d2 = d20.d();
        this.mCurrentCity = d2;
        this.mSelectCity.setText(d2);
        this.mSearchText.setText("搜索明星 演出 赛事 场馆");
        this.certInfoView.setOnClickListener(new i());
        this.mSelectCityLayout.setOnClickListener(new j());
        this.mSearchView.setOnClickListener(new k());
        this.mScan.setOnClickListener(new l());
        this.mMessage.setOnClickListener(new m());
    }

    private boolean isShowTransBg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-803001713")) {
            return this.mIsPageTop && this.mIsHasBg && this.mIsScrollCurPage;
        }
        return ((Boolean) ipChange.ipc$dispatch("-803001713", new Object[]{this})).booleanValue();
    }

    private void loadUnReadMsgCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780934154")) {
            ipChange.ipc$dispatch("-780934154", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (this.mBadgManager == null) {
                this.mBadgManager = yp.a();
            }
            this.mBadgManager.g(DM_MSGBOX, this.mBadgeListener);
            this.mBadgManager.d(this.rootNodes);
        }
    }

    private void registerCityChangeReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1711483180")) {
            ipChange.ipc$dispatch("1711483180", new Object[]{this});
            return;
        }
        this.mDMMessage.b(DamaiConstants.CITY_CHANGED, new n());
    }

    private void registerSearchWord() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144549788")) {
            ipChange.ipc$dispatch("-144549788", new Object[]{this});
            return;
        }
        this.mDMMessage.b(HomeMessage.SEARCH_WORD, new g());
    }

    public static void requestCalendarData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734523526")) {
            ipChange.ipc$dispatch("-734523526", new Object[0]);
            return;
        }
        CategoryCalendarRequest categoryCalendarRequest = new CategoryCalendarRequest();
        categoryCalendarRequest.damaiID = d20.c();
        categoryCalendarRequest.startDate = ve.l();
        categoryCalendarRequest.endDate = ve.a();
        categoryCalendarRequest.request(new DMMtopRequestListener<CalendarBean>(CalendarBean.class) {
            /* class cn.damai.homepage.ui.fragment.HomeTabFragment.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1545678660")) {
                    ipChange.ipc$dispatch("1545678660", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CalendarBean calendarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1284934237")) {
                    ipChange.ipc$dispatch("-1284934237", new Object[]{this, calendarBean});
                    return;
                }
                d20.T(HomeMessage.CALENDAR_DATA, JSON.toJSONString(calendarBean));
            }
        });
    }

    @SuppressLint({"NewApi"})
    private void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438868779")) {
            ipChange.ipc$dispatch("-438868779", new Object[]{this});
            return;
        }
        this.mIsHasBg = false;
        Fragment curFragment = getCurFragment();
        int distance = (curFragment == null || !(curFragment instanceof HomeGetPageListener)) ? 0 : ((HomeGetPageListener) curFragment).getDistance();
        if (this.mCurIndex == 0 && this.mPagerAdapter.b() != null) {
            distance = this.mPagerAdapter.b().getDistance();
        }
        if (distance > v50.a(getActivity(), 5.0f)) {
            this.mIsPageTop = false;
        } else {
            this.mIsPageTop = true;
        }
        if (distance >= 0) {
            this.mHeaderbgImage.setTranslationY((float) (-distance));
            setBgTy(distance);
        }
        this.mTopBgLayout.setVisibility(8);
        this.mHeaderbgImage.setVisibility(8);
        setTopAllBg(this.mSelectTab.homeHeaderBg);
        updateHeaderColor();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveTopBg(HomeHeaderBg homeHeaderBg) {
        int i2;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111074758")) {
            ipChange.ipc$dispatch("-1111074758", new Object[]{this, homeHeaderBg});
            return;
        }
        for (int i3 = 0; i3 < this.mTabList.size(); i3++) {
            HomeTabBean homeTabBean = (HomeTabBean) this.mTabList.get(i3);
            if (homeTabBean != null && (i2 = homeTabBean.type) == homeHeaderBg.type) {
                if (i2 == 999 || i2 == 4 || i2 == 5 || i2 == 6) {
                    homeTabBean.homeHeaderBg = homeHeaderBg;
                } else {
                    String str2 = homeTabBean.categoryId;
                    if (!(str2 == null || (str = homeHeaderBg.categoryId) == null || !str2.equals(str))) {
                        homeTabBean.homeHeaderBg = homeHeaderBg;
                    }
                }
            }
        }
    }

    private void setBgTy(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459267778")) {
            ipChange.ipc$dispatch("-1459267778", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        int i3 = this.lastTy;
        if (i2 != i3) {
            this.lastTy = i2;
            this.mTopBgLayout.setTranslationY((float) (-i2));
            if (!this.mLottieTopView.isAnimating() && this.lastTy < n42.a(this.mActivity, 1000.0f)) {
                this.mLottieTopView.playAnimation();
            }
        } else if (i3 == n42.a(this.mActivity, 1000.0f) && this.mLottieTopView.isAnimating()) {
            this.mLottieTopView.pauseAnimation();
        }
    }

    private void setLottieBg(HomeHeaderBg homeHeaderBg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715942097")) {
            ipChange.ipc$dispatch("715942097", new Object[]{this, homeHeaderBg});
            return;
        }
        this.mTopBgLayout.setVisibility(0);
        this.mHeaderbgImage.setVisibility(8);
        HomePageTopLottieHelper.n().r(getActivity(), homeHeaderBg.headLottie, homeHeaderBg.weiyiId, this.mTopBgView, this.mLottieTopView, new d(homeHeaderBg));
    }

    private void setSearchBackground(Context context, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942472721")) {
            ipChange.ipc$dispatch("942472721", new Object[]{this, context, view, Boolean.valueOf(z)});
        } else if (z) {
            view.setBackground(context.getResources().getDrawable(R$drawable.home_top_search_bg_white));
        } else {
            view.setBackground(context.getResources().getDrawable(R$drawable.home_top_search_bg));
            ((TextView) view.findViewById(R$id.homepage_title_search_icon)).setTextColor(context.getResources().getColor(R$color.color_ffa7c4));
            ((TextView) view.findViewById(R$id.homepage_title_scan)).setTextColor(context.getResources().getColor(R$color.color_bf9cff));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTopAllBg(HomeHeaderBg homeHeaderBg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "250977924")) {
            ipChange.ipc$dispatch("250977924", new Object[]{this, homeHeaderBg});
            return;
        }
        HomePageTopLottieHelper.n().v();
        if (homeHeaderBg != null) {
            HeadLottieBean headLottieBean = homeHeaderBg.headLottie;
            if (headLottieBean == null || TextUtils.isEmpty(headLottieBean.zipUrl) || s71.a(homeHeaderBg.headLottie.style)) {
                if (this.mCurIndex == 0) {
                    br.c("showNullView", null);
                }
                setTopBg(homeHeaderBg.headBackgroudPic, homeHeaderBg.headColor);
                return;
            }
            setLottieBg(homeHeaderBg);
        } else if (this.mCurIndex == 0) {
            br.c("showNullView", null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTopBg(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694506421")) {
            ipChange.ipc$dispatch("1694506421", new Object[]{this, str, str2});
            return;
        }
        this.mTopBgLayout.setVisibility(8);
        this.mHeaderbgImage.setVisibility(0);
        this.mHeaderbgImage.setImageBitmap(null);
        this.mHeaderbgImage.setBackgroundColor(this.mActivity.getResources().getColor(R$color.color_00000000));
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.mHeaderbgImage.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            if (!TextUtils.isEmpty(str)) {
                cn.damai.common.image.a.b().c(str).n(new f()).e(new e(str2)).f();
            } else {
                updateTopColor(str2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void setTopBgTranslationY(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149313514")) {
            ipChange.ipc$dispatch("149313514", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        if (i2 > v50.a(getActivity(), 5.0f)) {
            this.mIsPageTop = false;
        } else {
            this.mIsPageTop = true;
        }
        if (i2 >= 0) {
            this.mHeaderbgImage.setTranslationY((float) (-i2));
        }
        setBgTy(i2);
    }

    private void setViewPaperItem(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111146718")) {
            ipChange.ipc$dispatch("-111146718", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        try {
            Field declaredField = Class.forName("android.support.v4.view.ViewPager").getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this.mViewPager, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void tabExposure() {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330954795")) {
            ipChange.ipc$dispatch("-1330954795", new Object[]{this});
            return;
        }
        try {
            HomeTabScrollView homeTabScrollView = this.mScrollView;
            if (!(homeTabScrollView == null || (linearLayout = (LinearLayout) homeTabScrollView.getChildAt(0)) == null)) {
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    View childAt = linearLayout.getChildAt(i2);
                    if (childAt != null) {
                        List<ScrollTitleBean> list = this.mTabList;
                        if (list != null && list.size() > i2) {
                            ix0.g().j(childAt, "home", i2, ((HomeTabBean) this.mTabList.get(i2)).name);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void updateHeaderColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824248996")) {
            ipChange.ipc$dispatch("824248996", new Object[]{this});
        } else if (getActivity() != null) {
            boolean isShowTransBg = isShowTransBg();
            int i2 = !isShowTransBg;
            int i3 = this.mUpdateHeaderInt;
            if (i3 == -1 || i2 != i3) {
                this.mUpdateHeaderInt = i2;
                if (Build.VERSION.SDK_INT < 23) {
                    ne2.f(getActivity(), false, R$color.black);
                } else if (isShowTransBg != 0) {
                    ne2.e(getActivity());
                } else {
                    ne2.f(getActivity(), true, R$color.black);
                    ne2.d(true, getActivity());
                }
                if (isShowTransBg != 0) {
                    this.mSelectCity.setTextColor(-1);
                    this.mSelectCityIcon.setTextColor(-1);
                    setSearchBackground(getActivity(), this.mSearchView, true);
                    this.mMessageIcon.setTextColor(-1);
                    this.certInfoView.setWhiteMode(true);
                } else {
                    this.mSelectCity.setTextColor(-16777216);
                    DMIconFontTextView dMIconFontTextView = this.mSelectCityIcon;
                    Resources resources = getResources();
                    int i4 = R$color.color_3C3F44;
                    dMIconFontTextView.setTextColor(resources.getColor(i4));
                    setSearchBackground(getActivity(), this.mSearchView, false);
                    this.mMessageIcon.setTextColor(getResources().getColor(i4));
                    this.certInfoView.setWhiteMode(false);
                }
                if (isShowTransBg != 0) {
                    View view = this.mTitleBar;
                    Resources resources2 = getResources();
                    int i5 = R$drawable.transparent_bg;
                    view.setBackground(resources2.getDrawable(i5));
                    this.mTitleBar.findViewById(R$id.homepage_title_subll).setBackground(getResources().getDrawable(i5));
                    this.mScrollView.setBackground(getResources().getDrawable(i5));
                    this.mScrollView.enableWhite();
                    this.mScrollView.updateColor(R$color.color_ffffff, R$color.color_99FFFFFF);
                } else {
                    this.mTitleBar.setBackground(getResources().getDrawable(R$drawable.home_top_default_bg));
                    this.mTitleBar.findViewById(R$id.homepage_title_subll).setBackground(getResources().getDrawable(R$drawable.home_top_default_bg_whitecover));
                    this.mScrollView.setBackgroundColor(getResources().getColor(R$color.color_white));
                    this.mScrollView.enableColor();
                    this.mScrollView.updateColor(R$color.color_000000, R$color.color_9C9CA5);
                }
                this.mTitleBar.getLayoutParams().height = this.mData.titleLayoutHeight;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateShowCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993617608")) {
            ipChange.ipc$dispatch("993617608", new Object[]{this});
            return;
        }
        String d2 = d20.d();
        this.mCurrentCity = d2;
        TextView textView = this.mSelectCity;
        if (textView != null) {
            textView.setText(d2);
            this.mSelectCity.setTextSize(1, TextUtils.getTrimmedLength(this.mCurrentCity) >= 3 ? 16.0f : 20.0f);
        }
        TextView textView2 = this.mSearchText;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTab(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722820681")) {
            ipChange.ipc$dispatch("722820681", new Object[]{this, homeTabListBean});
        } else if (jx0.i(homeTabListBean)) {
            this.mTabList.clear();
            List<HomeTabBean> c2 = jx0.c(homeTabListBean);
            this.mHomeTabBeanList = c2;
            this.mCurIndex = jx0.e(this.mTabExtra, c2);
            for (int i2 = 0; i2 < this.mHomeTabBeanList.size(); i2++) {
                this.mTabList.add(this.mHomeTabBeanList.get(i2));
            }
            this.mScrollView.setFontColor(R$color.color_000000, R$color.color_9C9CA5).setFontSize(16, 20).setTitle(this.mTabList).setHeight(44).setDefaultPadding(11).setOnTitleClickListener(new o()).commit();
            this.mScrollView.selectTitle(this.mCurIndex);
            this.mSelectTab = (HomeTabBean) this.mTabList.get(this.mCurIndex);
            updateViewPager(this.mHomeTabBeanList);
            tabExposure();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTopColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974633804")) {
            ipChange.ipc$dispatch("1974633804", new Object[]{this, str});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mIsHasBg = true;
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = String.format("%s%s", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, str);
            }
            this.mHeaderbgImage.setBackgroundColor(Color.parseColor(str));
            this.mHeaderbgImage.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mData.titleLayoutHeight + ScreenUtil.dip2px(this.mActivity, 120.0f)));
        } else {
            this.mIsHasBg = false;
        }
        updateHeaderColor();
    }

    private void updateViewPager(List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813740173")) {
            ipChange.ipc$dispatch("813740173", new Object[]{this, list});
        } else if (!s71.a(list)) {
            TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
            if (!(tabPagerAdapter == null || tabPagerAdapter.b() == null)) {
                getChildFragmentManager().beginTransaction().remove(this.mPagerAdapter.b()).commit();
            }
            setViewPaperItem(this.mCurIndex);
            TabPagerAdapter tabPagerAdapter2 = new TabPagerAdapter(getChildFragmentManager(), list, this.mHomeTopBgListener, this.mHomeIsRefreshListener);
            this.mPagerAdapter = tabPagerAdapter2;
            this.mViewPager.setAdapter(tabPagerAdapter2);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class cn.damai.homepage.ui.fragment.HomeTabFragment.AnonymousClass10 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1171375803")) {
                        ipChange.ipc$dispatch("-1171375803", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                @SuppressLint({"NewApi"})
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "526441188")) {
                        ipChange.ipc$dispatch("526441188", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                        return;
                    }
                    if (HomeTabFragment.this.mTopBgLayout.getVisibility() != 0) {
                        HomeTabFragment.this.mIsScrollCurPage = true;
                    }
                    HomeTabFragment.this.mTopBgLayout.setTranslationX((float) (-i2));
                    if (i2 > 0) {
                        HomeTabFragment.this.mIsScrollCurPage = false;
                    } else {
                        HomeTabFragment.this.mIsScrollCurPage = true;
                    }
                    HomeTabFragment.this.updateHeaderColor();
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-442303792")) {
                        ipChange.ipc$dispatch("-442303792", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    HomeTabFragment.this.changePage(i);
                }
            });
            this.mViewPager.setCurrentItem(this.mCurIndex);
            PageUtExecutor pageUtExecutor = new PageUtExecutor(this.mActivity, new a());
            this.mViewPager.addOnPageChangeListener(pageUtExecutor);
            pageUtExecutor.a();
        }
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public Fragment getCurFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045630065")) {
            return (Fragment) ipChange.ipc$dispatch("-2045630065", new Object[]{this});
        }
        TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
        if (tabPagerAdapter != null) {
            return tabPagerAdapter.a();
        }
        return null;
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public int getCurIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "221781532")) {
            return this.mCurIndex;
        }
        return ((Integer) ipChange.ipc$dispatch("221781532", new Object[]{this})).intValue();
    }

    public HomeCmsFragment getHomeFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404966963")) {
            return (HomeCmsFragment) ipChange.ipc$dispatch("-1404966963", new Object[]{this});
        }
        TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
        if (tabPagerAdapter != null) {
            return tabPagerAdapter.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1015722762")) {
            return R$layout.homepage_tab_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-1015722762", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929748178")) {
            ipChange.ipc$dispatch("1929748178", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063512473")) {
            ipChange.ipc$dispatch("1063512473", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112541340")) {
            ipChange.ipc$dispatch("-112541340", new Object[]{this});
            return;
        }
        this.mActivity = (MainActivity) getActivity();
        initStatuBar();
        initTitleBar();
        registerCityChangeReceiver();
        initTab();
        updateTab(null);
        requestTabData();
        requestCalendarData();
        gi.a(getActivity());
        registerSearchWord();
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void logoutRefreshUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526509396")) {
            ipChange.ipc$dispatch("-526509396", new Object[]{this});
        } else if (this.mMessageTip.getVisibility() == 0) {
            this.mMessageTip.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912340405")) {
            ipChange.ipc$dispatch("-1912340405", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 111) {
            DMNav.from(getActivity()).toUri(NavUri.b(gr.x));
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468329910")) {
            ipChange.ipc$dispatch("-468329910", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674386286")) {
            return (View) ipChange.ipc$dispatch("674386286", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mActivity = mainActivity;
        this.mData = mainActivity.getData();
        initBundle();
        fw0 fw0 = fw0.INSTANCE;
        if (fw0.f()) {
            ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
            aBTestProvider.n(fw0.d(), Long.valueOf(fw0.c()));
            aBTestProvider.j(fw0.d(), Long.valueOf(fw0.c()), fw0.a, Boolean.TRUE);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145459990")) {
            ipChange.ipc$dispatch("2145459990", new Object[]{this});
            return;
        }
        super.onDestroy();
        HomePageTopLottieHelper.n().B();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449726062")) {
            ipChange.ipc$dispatch("1449726062", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        updateHeaderColor();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113355174")) {
            ipChange.ipc$dispatch("-2113355174", new Object[]{this});
            return;
        }
        super.onPause();
        HomePageTopLottieHelper.n().v();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558285549")) {
            ipChange.ipc$dispatch("558285549", new Object[]{this});
            return;
        }
        super.onResume();
        loadUnReadMsgCount();
        if (this.mIsHasBg) {
            HomePageTopLottieHelper.n().A();
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354849123")) {
            ipChange.ipc$dispatch("1354849123", new Object[]{this});
            return;
        }
        TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
        if (tabPagerAdapter != null) {
            tabPagerAdapter.c(true);
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshHomeFragment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598082643")) {
            ipChange.ipc$dispatch("-598082643", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HomeCmsFragment homeFragment = getHomeFragment();
        if (homeFragment != null && homeFragment.isAdded()) {
            homeFragment.refreshData();
        }
    }

    public void requestTabData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516614903")) {
            ipChange.ipc$dispatch("-516614903", new Object[]{this});
            return;
        }
        startProgressDialog();
        new HomeTabRequest().request(new DMMtopRequestListener<HomeTabListBean>(HomeTabListBean.class) {
            /* class cn.damai.homepage.ui.fragment.HomeTabFragment.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1553438019")) {
                    ipChange.ipc$dispatch("1553438019", new Object[]{this, str, str2});
                    return;
                }
                HomeTabFragment.this.stopProgressDialog();
            }

            public void onSuccess(HomeTabListBean homeTabListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-47250882")) {
                    ipChange.ipc$dispatch("-47250882", new Object[]{this, homeTabListBean});
                    return;
                }
                HomeTabFragment.this.stopProgressDialog();
                HomeTabFragment.this.updateTab(homeTabListBean);
            }
        });
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToRecommend() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057956893")) {
            ipChange.ipc$dispatch("2057956893", new Object[]{this});
        } else if (!this.mIsRefresh) {
            Fragment curFragment = getCurFragment();
            if (curFragment instanceof HomeGoTopOrRecommendListener) {
                ((HomeGoTopOrRecommendListener) curFragment).goTop(false);
            }
            if (this.mCurIndex == 0) {
                this.mIsPageTop = false;
                updateHeaderColor();
            }
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819837468")) {
            ipChange.ipc$dispatch("-819837468", new Object[]{this});
            return;
        }
        Fragment curFragment = getCurFragment();
        if (curFragment instanceof HomeGoTopOrRecommendListener) {
            ((HomeGoTopOrRecommendListener) curFragment).goTop(true);
        }
        if (this.mCurIndex == 0) {
            this.mIsPageTop = true;
            updateHeaderColor();
        }
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public Fragment self() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "760055777")) {
            return this;
        }
        return (Fragment) ipChange.ipc$dispatch("760055777", new Object[]{this});
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825536246")) {
            ipChange.ipc$dispatch("-825536246", new Object[]{this, onTabClickListener});
            return;
        }
        this.mTabClickListener = onTabClickListener;
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public void setSelectTab(TabExtra tabExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866162731")) {
            ipChange.ipc$dispatch("1866162731", new Object[]{this, tabExtra});
            return;
        }
        this.mTabExtra = tabExtra;
        int e2 = jx0.e(tabExtra, this.mHomeTabBeanList);
        this.mScrollView.selectTitle(e2);
        this.mViewPager.setCurrentItem(e2);
    }

    public void utBuilder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196838763")) {
            ipChange.ipc$dispatch("-1196838763", new Object[]{this});
        } else if (this.mSelectTab != null && this.mOldSelectTab != null) {
            cn.damai.common.user.c.e().x(ix0.g().i(this.mOldSelectTab.spmb, this.mCurIndex, this.mSelectTab.name));
        }
    }
}
