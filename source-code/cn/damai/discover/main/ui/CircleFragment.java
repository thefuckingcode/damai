package cn.damai.discover.main.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.discover.bean.ThemeBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.discover.main.bean.ThemeShare;
import cn.damai.discover.main.request.CircleRequest;
import cn.damai.discover.main.ui.listener.OnShareListener;
import cn.damai.discover.main.ui.listener.ScrollTitleCircleAlphaListener;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.player.DMVideoPlayer;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.common.CommonErrorContract;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.d20;
import tb.g91;
import tb.kk2;
import tb.p21;
import tb.s41;
import tb.u80;
import tb.v50;
import tb.za;

/* compiled from: Taobao */
public class CircleFragment extends AbsFragmentV2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String Default_PAGE = "hotquanzi";
    public static final String TAG = "CircleFragment";
    private ThemeShare bean;
    private int firstLoadMoreHeight = 0;
    private AtomicBoolean mHasDone = new AtomicBoolean(false);
    private kk2 mUt = new kk2();
    private String pageB = Default_PAGE;
    ViewGroup parent;
    int refreshType = 0;
    private FrameLayout root_fl;
    ScrollTitleCircleAlphaListener scrollAlphaListener;
    private ThemeBean themeBean;
    public String themeId;
    private String themeName;
    int totalDy = 0;
    DMVideoPlayer videoPlayer;

    /* compiled from: Taobao */
    public class a implements OnShareListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void openShareView(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1897108106")) {
                ipChange.ipc$dispatch("-1897108106", new Object[]{this, bundle});
            } else if (!CircleFragment.this.getActivity().isFinishing()) {
                ShareManager.E().P(CircleFragment.this.getActivity(), bundle, CircleFragment.this.root_fl);
            }
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678025787")) {
                ipChange.ipc$dispatch("1678025787", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                CircleFragment.this.startProgressDialog();
            } else {
                CircleFragment.this.stopProgressDialog();
            }
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void toast(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-859524133")) {
                ipChange.ipc$dispatch("-859524133", new Object[]{this, str});
                return;
            }
            ToastUtil.i(str);
        }
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827910307")) {
            ipChange.ipc$dispatch("1827910307", new Object[]{this});
            return;
        }
        this.mRecyclerView.getLayoutManager();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.discover.main.ui.CircleFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ScrollTitleCircleAlphaListener scrollTitleCircleAlphaListener;
                ScrollTitleCircleAlphaListener scrollTitleCircleAlphaListener2;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1757172686")) {
                    ipChange.ipc$dispatch("1757172686", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CircleFragment.this.totalDy -= i2;
                g91.g("addScrollListener totalDy=", CircleFragment.this.totalDy + "  dy=" + i2);
                if (i2 < 0 && CircleFragment.this.isOverOneItem(recyclerView)) {
                    CircleFragment.this.totalDy = 0;
                }
                CircleFragment circleFragment = CircleFragment.this;
                int i3 = circleFragment.totalDy;
                if (i3 >= 0 && (scrollTitleCircleAlphaListener2 = circleFragment.scrollAlphaListener) != null) {
                    scrollTitleCircleAlphaListener2.onAlphaChanged(0.0f);
                } else if (i3 < 0 && (scrollTitleCircleAlphaListener = circleFragment.scrollAlphaListener) != null) {
                    scrollTitleCircleAlphaListener.onAlphaChanged(1.0f);
                }
                boolean z = i2 < 0;
                if (!CircleFragment.this.isRecyclerViewOverPage(recyclerView) || z) {
                    CircleFragment.this.scrollAlphaListener.onPublishChanged(true);
                } else {
                    CircleFragment.this.scrollAlphaListener.onPublishChanged(false);
                }
            }
        });
    }

    private boolean getParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308693710")) {
            return ((Boolean) ipChange.ipc$dispatch("-1308693710", new Object[]{this})).booleanValue();
        } else if (getArguments() == null) {
            return true;
        } else {
            try {
                this.themeId = getArguments().getString("themeId");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getTitleBean(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449989346")) {
            ipChange.ipc$dispatch("-449989346", new Object[]{this, baseResponse});
            return;
        }
        for (int i = 0; i < baseResponse.layers.size(); i++) {
            if (!(baseResponse.layers.get(i) == null || baseResponse.layers.get(i).getSections() == null)) {
                for (int i2 = 0; i2 < baseResponse.layers.get(i).getSections().size(); i2++) {
                    if (baseResponse.layers.get(i).getSections().get(i2) != null && "dm_clique_head".equals(baseResponse.layers.get(i).getSections().get(i2).getComponentId()) && baseResponse.layers.get(i).getSections().get(i2).getItem() != null) {
                        Object obj = baseResponse.layers.get(i).getSections().get(i2).getItem().get("share");
                        this.bean = obj != null ? (ThemeShare) s41.a(JSON.toJSONString(obj), ThemeShare.class) : null;
                        if (baseResponse.layers.get(i).getSections().get(i2).getItem().get("theme") != null) {
                            try {
                                JSONObject parseObject = JSON.parseObject(s41.e(baseResponse.layers.get(i).getSections().get(i2).getItem().get("theme")));
                                if (parseObject != null) {
                                    this.themeBean = (ThemeBean) JSON.parseObject(s41.e(baseResponse.layers.get(i).getSections().get(i2).getItem().get("theme")), ThemeBean.class);
                                }
                                if (parseObject.containsKey(p21.ISSUE_PARAM_LIVE_THEME_NAME)) {
                                    this.themeName = parseObject.get(p21.ISSUE_PARAM_LIVE_THEME_NAME).toString();
                                    return;
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                continue;
            }
        }
    }

    public static CircleFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106693659")) {
            return (CircleFragment) ipChange.ipc$dispatch("106693659", new Object[]{str});
        }
        CircleFragment circleFragment = new CircleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("themeId", str);
        circleFragment.setArguments(bundle);
        return circleFragment;
    }

    public String getCircleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1569679532")) {
            return this.themeName;
        }
        return (String) ipChange.ipc$dispatch("1569679532", new Object[]{this});
    }

    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1791175602")) {
            return this.mRecyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("1791175602", new Object[]{this});
    }

    public ThemeShare getShare() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1854585633")) {
            return this.bean;
        }
        return (ThemeShare) ipChange.ipc$dispatch("-1854585633", new Object[]{this});
    }

    public ThemeBean getTheme() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1170680500")) {
            return this.themeBean;
        }
        return (ThemeBean) ipChange.ipc$dispatch("-1170680500", new Object[]{this});
    }

    public String getThemeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1927304217")) {
            return this.themeName;
        }
        return (String) ipChange.ipc$dispatch("1927304217", new Object[]{this});
    }

    public boolean isOverOneItem(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536385487")) {
            return ((Boolean) ipChange.ipc$dispatch("-536385487", new Object[]{this, recyclerView})).booleanValue();
        }
        if (recyclerView != null) {
            try {
                View childAt = recyclerView.getChildAt(0);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (childAt == null || layoutManager == null || layoutManager.getPosition(childAt) != 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607353174")) {
            ipChange.ipc$dispatch("1607353174", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881121158")) {
            return (View) ipChange.ipc$dispatch("-881121158", new Object[]{this, layoutInflater, viewGroup, bundle});
        } else if (getParam()) {
            return null;
        } else {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.fragment_theme_circle, viewGroup, false);
            viewGroup2.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), 0);
            this.root_fl = (FrameLayout) viewGroup2.findViewById(R$id.root_fl);
            this.mUt.F(this.themeId);
            return viewGroup2;
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942853258")) {
            ipChange.ipc$dispatch("942853258", new Object[]{this});
            return;
        }
        this.scrollAlphaListener = null;
        this.videoPlayer = null;
        this.parent = null;
        this.mBottomView = null;
        super.onDestroy();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048610343")) {
            ipChange.ipc$dispatch("2048610343", new Object[]{this, view});
            return;
        }
        showNoMoreV3("哎呀 只有这么多了", R$drawable.circle_load_more_icon);
        g91.g("addScrollListener totalDy=", this.totalDy + "  heightPixels=" + DisplayMetrics.getheightPixels(v50.b(getContext())));
        if (this.mHasDone.compareAndSet(false, true)) {
            this.firstLoadMoreHeight = this.totalDy;
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583336542")) {
            ipChange.ipc$dispatch("-1583336542", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 7001) {
            ScrollTitleCircleAlphaListener scrollTitleCircleAlphaListener = this.scrollAlphaListener;
            if (scrollTitleCircleAlphaListener != null) {
                scrollTitleCircleAlphaListener.onAlphaChanged(0.0f);
                this.totalDy = 0;
            }
        } else if (i == 7002) {
            ThemeShare themeShare = this.bean;
            if (themeShare != null && themeShare.isValid()) {
                za.j(this.mUt.p(this.themeId));
                u80.q(new a(), this.bean);
            }
        } else if (i == 8001) {
            requestTetris(false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571423950")) {
            ipChange.ipc$dispatch("571423950", new Object[]{this});
            return;
        }
        super.onPause();
        Log.d("onHiddenChanged", getId() + " : onPause: ");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839065079")) {
            ipChange.ipc$dispatch("-839065079", new Object[]{this});
        } else if (getUserVisibleHint()) {
            startProgressDialog();
            requestTetris();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112907527")) {
            ipChange.ipc$dispatch("-2112907527", new Object[]{this});
            return;
        }
        super.onResume();
        Log.d("onHiddenChanged", getId() + " : onResume: ");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108901405")) {
            ipChange.ipc$dispatch("-1108901405", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        enableDividerLine(false);
        enableRefresh();
        enableLoadMore();
        disAbleToTop();
        addScrollListener();
        this.firstLoadMoreHeight = -DisplayMetrics.getheightPixels(v50.b(getContext()));
        CircleRequest circleRequest = new CircleRequest();
        circleRequest.themeId = this.themeId;
        String patternName = circleRequest.getPatternName();
        String version = circleRequest.getVersion();
        ContainerArg containerArg = new ContainerArg(patternName, version, "{\"themeId\":\"" + this.themeId + "\"}");
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(containerArg);
        }
        refreshByType(0);
    }

    public void refreshByType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247840522")) {
            ipChange.ipc$dispatch("1247840522", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.refreshType = i;
        onRefresh();
    }

    public void requestTetris() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096817923")) {
            ipChange.ipc$dispatch("-2096817923", new Object[]{this});
            return;
        }
        requestTetris(true);
    }

    public void setScrollAlphaListener(ScrollTitleCircleAlphaListener scrollTitleCircleAlphaListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032068995")) {
            ipChange.ipc$dispatch("-2032068995", new Object[]{this, scrollTitleCircleAlphaListener});
            return;
        }
        this.scrollAlphaListener = scrollTitleCircleAlphaListener;
    }

    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876033350")) {
            ipChange.ipc$dispatch("1876033350", new Object[]{this});
            return;
        }
        sendMsg(new Message(AbsFragment.TETRIS_BIZ_CODE_SHARE, null));
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.v2.componentplugin.ComponentPageUi
    public void showNoMoreV2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372756640")) {
            ipChange.ipc$dispatch("-372756640", new Object[]{this, str});
            return;
        }
        showNoMoreV3("哎呀 只有这么多了", R$drawable.circle_load_more_icon);
    }

    public void requestTetris(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576800393")) {
            ipChange.ipc$dispatch("-576800393", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        CircleRequest circleRequest = new CircleRequest();
        circleRequest.themeId = this.themeId;
        TetrisRequest tetrisRequest = new TetrisRequest(circleRequest);
        tetrisRequest.patternVersion = "2.0";
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.discover.main.ui.CircleFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            private void addEmptyView(BaseResponse baseResponse) {
                BaseLayer baseLayer;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1793636685")) {
                    ipChange.ipc$dispatch("1793636685", new Object[]{this, baseResponse});
                    return;
                }
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList != null && arrayList.size() > 0 && (baseLayer = baseResponse.layers.get(0)) != null && baseLayer.getSections() != null && baseLayer.getSections().size() == 1) {
                    BaseSection baseSection = new BaseSection();
                    baseSection.setComponentId(CommonErrorContract.CID);
                    baseSection.setSectionId(CommonErrorContract.CID);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errorMsg", (Object) "暂时还没有演出哦");
                    baseSection.setItem(jSONObject);
                    baseLayer.getSections().add(baseSection);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1476442222")) {
                    ipChange.ipc$dispatch("-1476442222", new Object[]{this, str, str2});
                    return;
                }
                CircleFragment.this.stopProgressDialog();
                CircleFragment.this.refreshFinish();
                CircleFragment.this.onResponseError(str, str2, "");
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                ArrayList<BaseLayer> arrayList;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1659673196")) {
                    ipChange.ipc$dispatch("1659673196", new Object[]{this, baseResponse});
                    return;
                }
                CircleFragment.this.stopProgressDialog();
                CircleFragment.this.refreshFinish();
                CircleFragment circleFragment = CircleFragment.this;
                ScrollTitleCircleAlphaListener scrollTitleCircleAlphaListener = circleFragment.scrollAlphaListener;
                if (scrollTitleCircleAlphaListener != null && z) {
                    int i = circleFragment.refreshType;
                    if (i == 0) {
                        scrollTitleCircleAlphaListener.onAlphaChanged(0.0f);
                    } else if (i == 1 && circleFragment.totalDy <= circleFragment.firstLoadMoreHeight) {
                        ((AbsFragment) CircleFragment.this).mRecyclerView.scrollToPosition(0);
                        CircleFragment.this.scrollAlphaListener.onAlphaChanged(0.0f);
                        CircleFragment.this.totalDy = 0;
                        g91.g("addScrollListener totalDy=", CircleFragment.this.totalDy + "  firstLoadMoreHeight=" + CircleFragment.this.firstLoadMoreHeight);
                    }
                }
                if (baseResponse == null || (arrayList = baseResponse.layers) == null || arrayList.size() == 0) {
                    CircleFragment.this.onResponseError("", "", "");
                    return;
                }
                CircleFragment.this.getTitleBean(baseResponse);
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", d20.E());
                hashMap.put("city", d20.d());
                hashMap.put(za.CNT_CONTENT_TYPE, "theme");
                hashMap.put(za.CNT_CONTENT_ID, CircleFragment.this.themeId);
                hashMap.put("cnt_content_name", CircleFragment.this.themeName);
                hashMap.put("type", "圈子");
                baseResponse.globalConfig.putBuzUTMap(hashMap);
                if (baseResponse.globalConfig != null) {
                    CircleFragment circleFragment2 = CircleFragment.this;
                    circleFragment2.updateB((CircleFragment) circleFragment2.pageB, (String) baseResponse.globalConfig);
                    GlobalConfig globalConfig = baseResponse.globalConfig;
                    if (globalConfig.extraInfo == null) {
                        globalConfig.extraInfo = new JSONObject();
                    }
                }
                CircleFragment.this.onResponseSuccess();
                CircleFragment.this.setData(baseResponse);
            }
        });
    }
}
