package cn.damai.homepage.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.a;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomePageData;
import cn.damai.homepage.bean.HomePageWaterFlowRecommend;
import cn.damai.homepage.request.HomeConfigRequest;
import cn.damai.homepage.request.HomePageExhibitionRequest;
import cn.damai.homepage.request.HomePageGuessRequest;
import cn.damai.homepage.request.HomeParams;
import cn.damai.homepage.request.IHomeFeedReq;
import cn.damai.homepage.ui.adapter.GuessAdapter;
import cn.damai.homepage.ui.listener.HomeGetPageListener;
import cn.damai.homepage.ui.listener.HomeGoTopOrRecommendListener;
import cn.damai.homepage.ui.listener.HomeRefreshListener;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.listener.IsRefreshListener;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV3;
import cn.damai.tetris.page.WrappedVirtualLayoutManager;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import java.util.ArrayList;
import java.util.List;
import tb.ax0;
import tb.br;
import tb.cs;
import tb.d20;
import tb.f92;
import tb.gr;
import tb.hp1;
import tb.jx0;
import tb.k20;
import tb.lp1;
import tb.ml;
import tb.n42;
import tb.oz0;
import tb.rx0;
import tb.s71;
import tb.vw0;
import tb.wl;
import tb.ww0;
import tb.xs0;
import tb.yw0;

/* compiled from: Taobao */
public class HomeCmsFragment extends AbsFragmentV3 implements OnCityChangedListener, HomeGetPageListener, HomeGoTopOrRecommendListener, HomeRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAB_BUCKET = "ABTrackInfo";
    private static final int REQUEST_CODE_OPEN_MESSAGE_CENTER = 111;
    public static final int SCROLLY_DIS_H = 1000;
    HomePageData[] exhibitionDataCache;
    int feedsShowTabIndex = 0;
    HomePageData guessDataCache;
    private int guessIndex = 0;
    private boolean isLastPage = false;
    private boolean isLoad = false;
    public boolean isRequest = false;
    private MainActivity mActivity;
    private BaseResponse mBaseResponse;
    private HomeData mData;
    private int mDistance = 0;
    private GuessAdapter mGuessAdapter;
    private List<ml> mGuessData = new ArrayList();
    private boolean mHasAddGuessTitle = false;
    private HomeHeaderBg mHomeHeaderBg;
    private boolean mIsCreateView;
    private boolean mIsNeedRequest;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass5 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int itemCount;
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1663595429")) {
                ipChange.ipc$dispatch("-1663595429", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                HomeCmsFragment.this.isLoad = false;
            }
            if (i == 0) {
                if (!HomeCmsFragment.this.isLoad) {
                    HomeCmsFragment.this.handleScrollY();
                }
                if (((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager != null) {
                    int findFirstVisibleItemPosition = ((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager.findFirstVisibleItemPosition();
                    int i3 = -1;
                    int d = wl.c(xs0.a()).d("dm_home_weinituijian_title");
                    RecyclerView.Adapter adapter = ((AbsFragment) HomeCmsFragment.this).mRecyclerView.getAdapter();
                    if (adapter != null && (itemCount = adapter.getItemCount()) > 0) {
                        while (true) {
                            if (i2 >= itemCount) {
                                break;
                            } else if (adapter.getItemViewType(i2) == d) {
                                i3 = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (i3 <= 0) {
                        return;
                    }
                    if (findFirstVisibleItemPosition >= i3) {
                        ((MainActivity) HomeCmsFragment.this.getActivity()).getTabbarManager().h().i();
                    } else {
                        ((MainActivity) HomeCmsFragment.this.getActivity()).getTabbarManager().h().h();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1853879964")) {
                ipChange.ipc$dispatch("-1853879964", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            if (!HomeCmsFragment.this.isLoad) {
                ((AbsFragmentV3) HomeCmsFragment.this).mScrollY += i2;
                Log.d("mScrollY", ((AbsFragmentV3) HomeCmsFragment.this).mScrollY + "         dy" + i2 + "");
                if (!((AbsFragmentV3) HomeCmsFragment.this).mIsRefreshDown) {
                    HomeCmsFragment.this.handleScrollY();
                }
            } else if (((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager != null) {
                ((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager.scrollToPositionWithOffset(0, 0);
            }
        }
    };
    private List<HomeTitleBean.Title> mainTitles;
    private String mainTitlestr = null;
    private String module;
    private String offset = "";
    private int pageNum = 1;
    IHomeFeedReq request = new HomePageGuessRequest();

    static /* synthetic */ int access$1412(HomeCmsFragment homeCmsFragment, int i) {
        int i2 = homeCmsFragment.pageNum + i;
        homeCmsFragment.pageNum = i2;
        return i2;
    }

    private void addGradientBackground() {
        View findViewById;
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673619330")) {
            ipChange.ipc$dispatch("-673619330", new Object[]{this});
            return;
        }
        View view = getView();
        if (view != null && (findViewById = view.findViewById(R$id.tetris_root_container)) != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable = xs0.a().getDrawable(R$drawable.homepage_shape_home_bg);
            } else {
                drawable = xs0.a().getResources().getDrawable(R$drawable.homepage_shape_home_bg);
            }
            findViewById.setBackground(drawable);
        }
    }

    private void addTitleTab(HomePageWaterFlowRecommend homePageWaterFlowRecommend) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859434300")) {
            ipChange.ipc$dispatch("-1859434300", new Object[]{this, homePageWaterFlowRecommend});
        } else if (this.pageNum <= 1) {
            if (homePageWaterFlowRecommend == null) {
                homePageWaterFlowRecommend = new HomePageWaterFlowRecommend();
            }
            if (homePageWaterFlowRecommend.mainTitles == null) {
                homePageWaterFlowRecommend.mainTitles = new ArrayList();
            }
            ax0.I().c0(this.feedsShowTabIndex);
            if (this.feedsShowTabIndex == 0) {
                this.mainTitlestr = JSON.toJSONString(homePageWaterFlowRecommend.mainTitles);
                this.mainTitles = homePageWaterFlowRecommend.mainTitles;
                ax0.I().d0(this.mainTitles);
            }
            try {
                if (!this.mHasAddGuessTitle) {
                    this.exhibitionDataCache = new HomePageData[this.mainTitles.size()];
                    addComponent(this.mBaseResponse, k20.e(this.mainTitlestr));
                    this.mHasAddGuessTitle = true;
                    setData(this.mBaseResponse);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cache2Response(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775770366")) {
            ipChange.ipc$dispatch("-775770366", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = yw0.b(yw0.HOMEPAGE_GET, "", getContext());
            if (TextUtils.isEmpty(str)) {
                str = a.n(xs0.a().getResources().openRawResource(R$raw.default_home_cms));
                z = false;
            } else {
                z = true;
            }
        }
        try {
            BaseResponse baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
            this.mBaseResponse = baseResponse;
            if (z) {
                this.mBaseResponse = k20.a(baseResponse);
            }
            this.mHasAddGuessTitle = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateHomePage();
    }

    private HomePageExhibitionRequest genFeedRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486422575")) {
            return (HomePageExhibitionRequest) ipChange.ipc$dispatch("-486422575", new Object[]{this});
        }
        HomePageExhibitionRequest homePageExhibitionRequest = new HomePageExhibitionRequest();
        List<HomeTitleBean.Title> list = this.mainTitles;
        if (!(list == null || this.feedsShowTabIndex >= list.size() || this.mainTitles.get(this.feedsShowTabIndex) == null)) {
            homePageExhibitionRequest.groupId = this.mainTitles.get(this.feedsShowTabIndex).groupId;
            homePageExhibitionRequest.dispatchCardCode = this.mainTitles.get(this.feedsShowTabIndex).dispatchCardCode;
        }
        return homePageExhibitionRequest;
    }

    private String getTitle(List<HomeTitleBean.Title> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644609276")) {
            return (String) ipChange.ipc$dispatch("-1644609276", new Object[]{this, list});
        } else if (list == null || this.feedsShowTabIndex >= list.size() || list.get(this.feedsShowTabIndex) == null) {
            return null;
        } else {
            return list.get(this.feedsShowTabIndex).name;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleScrollY() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1969299321")) {
            ipChange.ipc$dispatch("1969299321", new Object[]{this});
            return;
        }
        WrappedVirtualLayoutManager wrappedVirtualLayoutManager = this.mLayoutManager;
        if (wrappedVirtualLayoutManager != null) {
            int findFirstVisibleItemPosition = wrappedVirtualLayoutManager.findFirstVisibleItemPosition();
            View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            this.mDistance = 0;
            if (findFirstVisibleItemPosition <= 2) {
                if (findViewByPosition != null) {
                    i = Math.abs(findViewByPosition.getTop());
                }
                this.mDistance = i;
            } else {
                this.mDistance = n42.a(this.mActivity, 1000.0f);
            }
            HomeTopBgListener homeTopBgListener = this.mHomeTopBgListener;
            if (homeTopBgListener != null) {
                homeTopBgListener.scrollY(this.mDistance);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean hasHomePageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395321841")) {
            return ((Boolean) ipChange.ipc$dispatch("-395321841", new Object[]{this})).booleanValue();
        }
        BaseResponse baseResponse = this.mBaseResponse;
        return baseResponse != null && !f92.d(baseResponse.layers);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133782739")) {
            ipChange.ipc$dispatch("133782739", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BaseResponse baseResponse = this.mBaseResponse;
        if (baseResponse != null && !s71.a(baseResponse.layers) && !z) {
            updateHomePage();
        } else if (z) {
            HomeParams homeParams = new HomeParams();
            requestCdn(homeParams.getPatternName(), homeParams.getVersion(), d20.c());
        } else {
            cache2Response(false, null);
        }
    }

    public static HomeCmsFragment newInstance(HomeTopBgListener homeTopBgListener, IsRefreshListener isRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141749317")) {
            return (HomeCmsFragment) ipChange.ipc$dispatch("-1141749317", new Object[]{homeTopBgListener, isRefreshListener});
        }
        HomeCmsFragment homeCmsFragment = new HomeCmsFragment();
        homeCmsFragment.setArguments(new Bundle());
        homeCmsFragment.mHomeTopBgListener = homeTopBgListener;
        homeCmsFragment.mIsRefreshListener = isRefreshListener;
        return homeCmsFragment;
    }

    private void requestConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787595380")) {
            ipChange.ipc$dispatch("-1787595380", new Object[]{this});
            return;
        }
        new HomeConfigRequest().request(new DMMtopRequestListener<HomeConfigBean>(HomeConfigBean.class) {
            /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1625400819")) {
                    ipChange.ipc$dispatch("1625400819", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(HomeConfigBean homeConfigBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2137924237")) {
                    ipChange.ipc$dispatch("2137924237", new Object[]{this, homeConfigBean});
                } else if (HomeCmsFragment.this.isVisible()) {
                    if (homeConfigBean == null) {
                        onFail("", "");
                        return;
                    }
                    HomeConfigBean k = jx0.k();
                    if (k != null) {
                        homeConfigBean = k;
                    }
                    String d = k20.d(homeConfigBean);
                    if (!TextUtils.isEmpty(d)) {
                        br.c(HomeMessage.SEARCH_WORD, d);
                    }
                    HomeCmsFragment.this.mHomeHeaderBg = k20.c(homeConfigBean);
                    HomeCmsFragment homeCmsFragment = HomeCmsFragment.this;
                    if (!(homeCmsFragment.mHomeTopBgListener == null || homeCmsFragment.mHomeHeaderBg == null)) {
                        HomeCmsFragment homeCmsFragment2 = HomeCmsFragment.this;
                        homeCmsFragment2.mHomeTopBgListener.onUpdateBg(homeCmsFragment2.mHomeHeaderBg);
                    }
                    k20.g(homeConfigBean);
                    if (homeConfigBean.pop != null) {
                        HomeCmsFragment.this.mData.lottieType = homeConfigBean.pop.iconType;
                        vw0.d().i(homeConfigBean);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestGuess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030269307")) {
            ipChange.ipc$dispatch("-1030269307", new Object[]{this});
            return;
        }
        requestConfig();
        if (d20.K()) {
            IHomeFeedReq homePageGuessRequest = this.feedsShowTabIndex == 0 ? new HomePageGuessRequest() : genFeedRequest();
            this.request = homePageGuessRequest;
            requestHomePageGuessData(1, homePageGuessRequest);
        }
    }

    private void requestHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943005937")) {
            ipChange.ipc$dispatch("-1943005937", new Object[]{this});
            return;
        }
        HomeParams homeParams = new HomeParams();
        homeParams.comboDamaiCityId = d20.c();
        final TetrisRequest tetrisRequest = new TetrisRequest(homeParams);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void dispatchStringResult(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1845564157")) {
                    ipChange.ipc$dispatch("1845564157", new Object[]{this, str});
                } else if (!TextUtils.isEmpty(str)) {
                    yw0.c(yw0.HOMEPAGE_GET, str, xs0.a());
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-734538774")) {
                    ipChange.ipc$dispatch("-734538774", new Object[]{this, str, str2});
                    return;
                }
                ((AbsFragmentV3) HomeCmsFragment.this).mRefreshLayout.refreshComplete();
                rx0.d(tetrisRequest.getApiName(), str, str2, d20.c());
                HomeCmsFragment.this.loadCache(true);
                if (HomeCmsFragment.this.hasHomePageData()) {
                    HomeCmsFragment.this.requestGuess();
                }
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1638267668")) {
                    ipChange.ipc$dispatch("1638267668", new Object[]{this, baseResponse});
                } else if (HomeCmsFragment.this.isVisible()) {
                    ((AbsFragmentV3) HomeCmsFragment.this).mRefreshLayout.refreshComplete();
                    HomeCmsFragment.this.mIsNeedRequest = false;
                    if (baseResponse == null || s71.a(baseResponse.layers)) {
                        onFail("", "");
                        return;
                    }
                    HomeCmsFragment.this.mBaseResponse = k20.a(baseResponse);
                    HomeCmsFragment.this.mHasAddGuessTitle = false;
                    HomeCmsFragment.this.mData.feedIndex = k20.b(HomeCmsFragment.this.mBaseResponse);
                    HomeCmsFragment.this.updateHomePage();
                    HomeCmsFragment.this.requestGuess();
                }
            }
        });
    }

    private void requestHomePageGuessData(final int i, final IHomeFeedReq iHomeFeedReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978910485")) {
            ipChange.ipc$dispatch("-978910485", new Object[]{this, Integer.valueOf(i), iHomeFeedReq});
            return;
        }
        showLoading(null);
        this.request = iHomeFeedReq;
        iHomeFeedReq.setCityId(String.valueOf(d20.c()));
        if (hp1.i(lp1.LOCATION)) {
            IHomeFeedReq iHomeFeedReq2 = this.request;
            iHomeFeedReq2.setLatitude(d20.n() + "");
            IHomeFeedReq iHomeFeedReq3 = this.request;
            iHomeFeedReq3.setLongitude(d20.o() + "");
        }
        this.request.setPageNum(i == -1 ? this.pageNum : i);
        if (this.pageNum == 1) {
            this.offset = "";
            this.isLastPage = false;
        }
        this.request.setOffset(this.offset);
        ((DMBaseMtopRequest) this.request).request(new DMMtopRequestListener<HomePageData>(HomePageData.class) {
            /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1617641460")) {
                    ipChange.ipc$dispatch("1617641460", new Object[]{this, str, str2});
                    return;
                }
                if (!oz0.b().c(str)) {
                    rx0.a("mtop.damai.wireless.home.guess.get", str, str2, d20.c());
                }
                if (HomeCmsFragment.this.isVisible()) {
                    HomeCmsFragment.this.showLoadError(null);
                    HomeCmsFragment.this.showEmptyList(iHomeFeedReq);
                }
            }

            public void onSuccess(HomePageData homePageData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2128455769")) {
                    ipChange.ipc$dispatch("-2128455769", new Object[]{this, homePageData});
                } else if (HomeCmsFragment.this.isVisible()) {
                    if (i <= 1) {
                        HomeCmsFragment.this.resetIndex();
                    }
                    if (HomeCmsFragment.this.updateGuess(homePageData)) {
                        if (HomeCmsFragment.this.pageNum == 1) {
                            if (iHomeFeedReq instanceof HomePageGuessRequest) {
                                HomeCmsFragment.this.guessDataCache = homePageData;
                            } else {
                                HomeCmsFragment homeCmsFragment = HomeCmsFragment.this;
                                homeCmsFragment.exhibitionDataCache[homeCmsFragment.feedsShowTabIndex] = homePageData;
                            }
                        }
                        HomeCmsFragment.access$1412(HomeCmsFragment.this, 1);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582635414")) {
            ipChange.ipc$dispatch("-1582635414", new Object[]{this});
            return;
        }
        this.mGuessData.clear();
        GuessAdapter guessAdapter = this.mGuessAdapter;
        if (guessAdapter != null) {
            guessAdapter.b();
        }
        this.pageNum = 1;
        this.guessIndex = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showEmptyList(IHomeFeedReq iHomeFeedReq) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722254208")) {
            ipChange.ipc$dispatch("-722254208", new Object[]{this, iHomeFeedReq});
        } else if (this.pageNum == 1) {
            this.mGuessData.clear();
            GuessAdapter guessAdapter = this.mGuessAdapter;
            if (guessAdapter != null) {
                guessAdapter.b();
                this.mGuessAdapter.notifyDataSetChanged();
            }
            if (iHomeFeedReq instanceof HomePageGuessRequest) {
                this.guessDataCache = null;
                return;
            }
            HomePageData[] homePageDataArr = this.exhibitionDataCache;
            if (homePageDataArr != null && (i = this.feedsShowTabIndex) < homePageDataArr.length) {
                homePageDataArr[i] = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean updateGuess(HomePageData homePageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652795269")) {
            return ((Boolean) ipChange.ipc$dispatch("652795269", new Object[]{this, homePageData})).booleanValue();
        }
        showLoadInit(null);
        HomePageWaterFlowRecommend b = ww0.b(homePageData);
        if (b == null || s71.a(b.content)) {
            showEmptyList(this.request);
            showLoadEnd(null);
            addTitleTab(b);
            return false;
        }
        this.offset = b.offset;
        List<ml> a = ww0.a(this.pageNum, this.guessIndex, b.content);
        if (s71.a(a)) {
            showLoadEnd(null);
            addTitleTab(b);
            return false;
        }
        if (this.pageNum == 1) {
            addTitleTab(b);
            this.mGuessData.addAll(a);
            this.mGuessAdapter.a(true, getTitle(b.mainTitles), this.mGuessData);
        } else {
            this.mGuessData.addAll(a);
            this.mGuessAdapter.a(false, getTitle(b.mainTitles), a);
        }
        this.guessIndex = this.mGuessData.size() - 1;
        if (!TextUtils.isEmpty(b.isLast) && "1".equals(b.isLast)) {
            this.isLastPage = true;
        }
        if (this.isLastPage) {
            showLoadEnd(b.lastPage);
        }
        return true;
    }

    private void updateHomeAB() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089372164")) {
            ipChange.ipc$dispatch("1089372164", new Object[]{this});
        } else if (getProperties() != null) {
            c.e().O(getActivity(), getProperties());
            Log.e("abtest", "  home updateHomeAB updatePageProperties size: " + getProperties().size());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289712822")) {
            ipChange.ipc$dispatch("289712822", new Object[]{this});
            return;
        }
        BaseResponse baseResponse = this.mBaseResponse;
        if (baseResponse != null && !s71.a(baseResponse.layers)) {
            setData(this.mBaseResponse);
        }
    }

    @Override // cn.damai.homepage.ui.listener.HomeGetPageListener
    public int getDistance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1750527621")) {
            return this.mDistance;
        }
        return ((Integer) ipChange.ipc$dispatch("1750527621", new Object[]{this})).intValue();
    }

    @Override // cn.damai.homepage.ui.listener.HomeGoTopOrRecommendListener
    public void goTop(boolean z) {
        int itemCount;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2022216036")) {
            ipChange.ipc$dispatch("2022216036", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mLayoutManager != null && isVisible()) {
            if (z) {
                this.mLayoutManager.scrollToPositionWithOffset(0, 0);
            } else if (this.mRecyclerView != null) {
                int i2 = this.mData.feedIndex;
                int d = wl.c(xs0.a()).d("dm_home_weinituijian_title");
                RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
                if (adapter != null && (itemCount = adapter.getItemCount()) > 0) {
                    while (true) {
                        if (i >= itemCount) {
                            break;
                        } else if (adapter.getItemViewType(i) == d) {
                            i2 = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                this.mLayoutManager.scrollToPositionWithOffset(i2, 5);
            }
        }
    }

    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711324915")) {
            ipChange.ipc$dispatch("711324915", new Object[]{this});
        } else if (d20.l()) {
            HomeParams homeParams = new HomeParams();
            requestCdn(homeParams.getPatternName(), homeParams.getVersion(), d20.c());
        } else {
            requestHome();
        }
    }

    public void loadCacheAndRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632181629")) {
            ipChange.ipc$dispatch("632181629", new Object[]{this});
        } else if (isVisible() && this.mRefreshLayout != null) {
            DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
            if (damaiRootRecyclerView != null) {
                damaiRootRecyclerView.scrollToPosition(0);
            }
            loadCache(false);
            this.mRefreshLayout.autoRefresh();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948051969")) {
            ipChange.ipc$dispatch("-1948051969", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 111) {
            DMNav.from(getActivity()).toUri(NavUri.b(gr.x));
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onCdnResponse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028190312")) {
            ipChange.ipc$dispatch("-2028190312", new Object[]{this, str});
            return;
        }
        super.onCdnResponse(str);
        cache2Response(false, str);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406506798")) {
            ipChange.ipc$dispatch("406506798", new Object[]{this});
            return;
        }
        this.mIsNeedRequest = true;
        loadCacheAndRefresh();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322300130")) {
            ipChange.ipc$dispatch("1322300130", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mIsCreateView = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060249822")) {
            ipChange.ipc$dispatch("-1060249822", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        Log.e("abtest", "  home onHiddenChanged : " + z);
        if (z) {
            cs.d().n();
        } else {
            cs.d().g();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513893761")) {
            ipChange.ipc$dispatch("-513893761", new Object[]{this, view});
        } else if (d20.K()) {
            IHomeFeedReq homePageGuessRequest = this.feedsShowTabIndex == 0 ? new HomePageGuessRequest() : genFeedRequest();
            this.request = homePageGuessRequest;
            requestHomePageGuessData(this.pageNum, homePageGuessRequest);
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243496010")) {
            ipChange.ipc$dispatch("1243496010", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1 && (obj instanceof ScrollTitleBean)) {
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) obj;
            resetIndex();
            int i2 = scrollTitleBean.index;
            this.feedsShowTabIndex = i2;
            if (i2 == 0) {
                HomePageData homePageData = this.guessDataCache;
                if (homePageData == null) {
                    requestHomePageGuessData(1, new HomePageGuessRequest());
                } else if (updateGuess(homePageData)) {
                    this.pageNum++;
                }
            } else {
                HomePageData[] homePageDataArr = this.exhibitionDataCache;
                if (homePageDataArr == null || homePageDataArr[i2] == null) {
                    requestHomePageGuessData(1, genFeedRequest());
                } else if (updateGuess(homePageDataArr[i2])) {
                    this.pageNum++;
                }
            }
            ax0.I().P(scrollTitleBean.name, scrollTitleBean.index);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790812966")) {
            ipChange.ipc$dispatch("790812966", new Object[]{this});
            return;
        }
        super.onPause();
        Log.e("abtest", "  home onResume");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459618207")) {
            ipChange.ipc$dispatch("-459618207", new Object[]{this});
            return;
        }
        showLoadInit(null);
        this.mGuessData.clear();
        this.guessDataCache = null;
        HomePageData[] homePageDataArr = this.exhibitionDataCache;
        if (homePageDataArr != null) {
            this.exhibitionDataCache = new HomePageData[homePageDataArr.length];
        }
        GuessAdapter guessAdapter = this.mGuessAdapter;
        if (guessAdapter != null) {
            guessAdapter.b();
        }
        this.pageNum = 1;
        this.guessIndex = 0;
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && d20.j()) {
            d20.l0(false);
        }
        initData();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393184673")) {
            ipChange.ipc$dispatch("393184673", new Object[]{this});
            return;
        }
        super.onResume();
        this.isRequest = false;
        Log.e("abtest", "  home onResume :" + getUserVisibleHint());
        if (getProperties() != null) {
            c.e().O(getActivity(), getProperties());
            Log.e("abtest", "abs onResume updatePageProperties : size : " + getProperties().size());
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833917754")) {
            ipChange.ipc$dispatch("833917754", new Object[]{this});
            return;
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038512660")) {
            ipChange.ipc$dispatch("-2038512660", new Object[]{this});
            return;
        }
        super.onStop();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV3, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666633669")) {
            ipChange.ipc$dispatch("-666633669", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.isLoad = true;
        this.mIsCreateView = true;
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mActivity = mainActivity;
        this.mData = mainActivity.getData();
        disAbleToTop();
        enableDividerLine(false);
        this.mLoadMoreView.setBackgroundColor(Color.parseColor("#f3f4f5"));
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        this.mGuessAdapter = new GuessAdapter(this.mActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mGuessAdapter);
        this.mPageContainer.addSubAdapters(arrayList);
        this.module = "bizTypeHome";
        DTemplateManager.q("bizTypeHome").p(DTemplateManager.CacheStrategy.STRATEGY_DEFAULT);
        loadCacheAndRefresh();
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1661600635")) {
                    ipChange.ipc$dispatch("-1661600635", new Object[]{this});
                    return;
                }
                HomeCmsFragment.this.isLoad = false;
            }
        }, 600);
    }

    @Override // cn.damai.homepage.ui.listener.HomeRefreshListener
    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355426664")) {
            ipChange.ipc$dispatch("-1355426664", new Object[]{this});
            return;
        }
        this.mIsNeedRequest = true;
        loadCacheAndRefresh();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546878707")) {
            ipChange.ipc$dispatch("546878707", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.e("abtest", "  home setUserVisibleHint : " + z);
        if (z) {
            this.isLoad = false;
        } else {
            updateHomeAB();
        }
    }

    public void showExhibitionTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184610316")) {
            ipChange.ipc$dispatch("-184610316", new Object[]{this});
        } else if (this.mLayoutManager != null && isVisible()) {
            goTop(false);
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1650799136")) {
                        ipChange.ipc$dispatch("1650799136", new Object[]{this});
                        return;
                    }
                    HomeCmsFragment.this.sendMsg(new Message(2, 1));
                    new Handler().postDelayed(new Runnable() {
                        /* class cn.damai.homepage.ui.fragment.HomeCmsFragment.AnonymousClass6.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1078662733")) {
                                ipChange.ipc$dispatch("-1078662733", new Object[]{this});
                                return;
                            }
                            HomeCmsFragment.this.goTop(false);
                        }
                    }, 500);
                }
            }, 800);
        }
    }
}
