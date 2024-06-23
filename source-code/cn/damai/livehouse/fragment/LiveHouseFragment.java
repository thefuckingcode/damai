package cn.damai.livehouse.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.livehouse.model.LiveHouseParams;
import cn.damai.message.observer.Action;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere;
import cn.damai.tetris.component.livehouse.bean.AritstHeadResult;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.d20;
import tb.f92;
import tb.fm2;
import tb.g91;

/* compiled from: Taobao */
public class LiveHouseFragment extends AbsFragmentV2 implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TAB = "tab";
    private boolean isViewCreated = false;
    private HomeTabBean mArgs;
    private BaseResponse mBaseResponse;
    private String mChangedCityId;
    private int mScrollDistance;
    private HomeTopBgListener mTopBgListener;

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1998663677")) {
                ipChange.ipc$dispatch("-1998663677", new Object[]{this, obj});
                return;
            }
            LiveHouseFragment.this.request(false);
        }
    }

    static /* synthetic */ int access$512(LiveHouseFragment liveHouseFragment, int i) {
        int i2 = liveHouseFragment.mScrollDistance + i;
        liveHouseFragment.mScrollDistance = i2;
        return i2;
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018692208")) {
            ipChange.ipc$dispatch("2018692208", new Object[]{this});
            return;
        }
        this.mScrollDistance = 0;
        updateScrollDistance();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.livehouse.fragment.LiveHouseFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1450124133")) {
                    ipChange.ipc$dispatch("-1450124133", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                LiveHouseFragment.access$512(LiveHouseFragment.this, i2);
                if (LiveHouseFragment.this.mScrollDistance < 0) {
                    LiveHouseFragment.this.mScrollDistance = 0;
                }
                LiveHouseFragment.this.updateScrollDistance();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AritstHeadAtmosphere getAtmosphere(BaseResponse baseResponse) {
        AritstHeadResult aritstHeadResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691712832")) {
            return (AritstHeadAtmosphere) ipChange.ipc$dispatch("-691712832", new Object[]{this, baseResponse});
        }
        if (baseResponse != null) {
            try {
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (!f92.d(arrayList)) {
                    Iterator<BaseLayer> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        List<BaseSection> sections = it.next().getSections();
                        if (!f92.d(sections)) {
                            for (BaseSection baseSection : sections) {
                                if (TextUtils.equals("dm_header_video", baseSection.getComponentId())) {
                                    NodeData item = baseSection.getItem();
                                    if (item != null && (aritstHeadResult = (AritstHeadResult) JSON.parseObject(item.toJSONString(), AritstHeadResult.class)) != null) {
                                        AritstHeadAtmosphere aritstHeadAtmosphere = aritstHeadResult.atmosphere;
                                        if (aritstHeadAtmosphere.bgImg != null) {
                                            return aritstHeadAtmosphere;
                                        }
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static LiveHouseFragment getInstance(HomeTabBean homeTabBean, HomeTopBgListener homeTopBgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1552931614")) {
            return (LiveHouseFragment) ipChange.ipc$dispatch("-1552931614", new Object[]{homeTabBean, homeTopBgListener});
        }
        LiveHouseFragment liveHouseFragment = new LiveHouseFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        liveHouseFragment.setArguments(bundle);
        liveHouseFragment.mTopBgListener = homeTopBgListener;
        liveHouseFragment.mArgs = homeTabBean;
        return liveHouseFragment;
    }

    private boolean isVisibleToUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487995672")) {
            return ((Boolean) ipChange.ipc$dispatch("-487995672", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        boolean userVisibleHint = getUserVisibleHint();
        boolean z = this.isViewCreated;
        if (!userVisibleHint || !z) {
            return false;
        }
        return true;
    }

    private void obtainBundleArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71078004")) {
            ipChange.ipc$dispatch("71078004", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable(KEY_TAB) != null) {
            this.mArgs = (HomeTabBean) arguments.getSerializable(KEY_TAB);
        }
    }

    private void reloadIfCityChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137134303")) {
            ipChange.ipc$dispatch("137134303", new Object[]{this});
        } else if (isVisibleToUser() && !TextUtils.isEmpty(this.mChangedCityId)) {
            this.mChangedCityId = null;
            request(false);
        }
    }

    private void setContainerArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190169276")) {
            ipChange.ipc$dispatch("190169276", new Object[]{this});
            return;
        }
        ContainerArg containerArg = null;
        HomeTabBean homeTabBean = this.mArgs;
        if (homeTabBean != null) {
            containerArg = new ContainerArg(homeTabBean.patternName, homeTabBean.patternVersion, homeTabBean.args);
        }
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(containerArg);
        }
    }

    private void setLoadMoreViewColourless() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063345205")) {
            ipChange.ipc$dispatch("-1063345205", new Object[]{this});
            return;
        }
        View loadMoreFooterView = this.mRecyclerView.getLoadMoreFooterView();
        if (loadMoreFooterView != null) {
            loadMoreFooterView.setBackgroundColor(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateHomeAtmosphere(AritstHeadAtmosphere aritstHeadAtmosphere) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569509053")) {
            ipChange.ipc$dispatch("1569509053", new Object[]{this, aritstHeadAtmosphere});
        } else if (aritstHeadAtmosphere != null) {
            HomeHeaderBg homeHeaderBg = new HomeHeaderBg(null, 6, aritstHeadAtmosphere.bgImg, null);
            HomeTopBgListener homeTopBgListener = this.mTopBgListener;
            if (homeTopBgListener != null) {
                homeTopBgListener.onUpdateBg(homeHeaderBg);
                updateScrollDistance();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateScrollDistance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205907853")) {
            ipChange.ipc$dispatch("1205907853", new Object[]{this});
            return;
        }
        HomeTopBgListener homeTopBgListener = this.mTopBgListener;
        if (homeTopBgListener != null) {
            homeTopBgListener.scrollY(this.mScrollDistance);
            g91.c("HomeDis", "updateScrollDistance =" + this.mScrollDistance);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659215298")) {
            ipChange.ipc$dispatch("-659215298", new Object[]{this});
            return;
        }
        request(false);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453128675")) {
            ipChange.ipc$dispatch("453128675", new Object[]{this});
            return;
        }
        this.mChangedCityId = d20.c();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050999977")) {
            ipChange.ipc$dispatch("-1050999977", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.isViewCreated = false;
        this.mScrollDistance = 0;
        this.mChangedCityId = null;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965287540")) {
            ipChange.ipc$dispatch("965287540", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756829771")) {
            ipChange.ipc$dispatch("-1756829771", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048526117")) {
            ipChange.ipc$dispatch("-1048526117", new Object[]{this});
            return;
        }
        super.onPause();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462048982")) {
            ipChange.ipc$dispatch("1462048982", new Object[]{this});
            return;
        }
        request(false);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791752052")) {
            ipChange.ipc$dispatch("-791752052", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210980240")) {
            ipChange.ipc$dispatch("-1210980240", new Object[]{this, view, bundle});
            return;
        }
        obtainBundleArgs();
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        this.mDMMessage.b("refreshData", new a());
        enableDividerLine(false);
        enableRefresh();
        addScrollListener();
        enableLoadMore();
        setLoadMoreViewColourless();
        setContainerArgs();
    }

    public void request(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088049007")) {
            ipChange.ipc$dispatch("-2088049007", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mChangedCityId = null;
        if (z) {
            startProgressDialog();
        }
        LiveHouseParams liveHouseParams = new LiveHouseParams(1);
        HomeTabBean homeTabBean = this.mArgs;
        if (homeTabBean != null) {
            liveHouseParams.outPatternName = homeTabBean.patternName;
            liveHouseParams.outPatternVersion = homeTabBean.patternVersion;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(liveHouseParams);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.livehouse.fragment.LiveHouseFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.livehouse.fragment.LiveHouseFragment$2$a */
            /* compiled from: Taobao */
            public class a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "865851342")) {
                        ipChange.ipc$dispatch("865851342", new Object[]{this});
                        return;
                    }
                    LiveHouseFragment.this.request(true);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1107926943")) {
                    ipChange.ipc$dispatch("1107926943", new Object[]{this, str, str2});
                    return;
                }
                if (z) {
                    LiveHouseFragment.this.stopProgressDialog();
                }
                LiveHouseFragment.this.refreshFinish();
                LiveHouseFragment.this.showErrorViewV2(str, str2, new a());
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-142702145")) {
                    ipChange.ipc$dispatch("-142702145", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    LiveHouseFragment.this.stopProgressDialog();
                }
                LiveHouseFragment.this.hideErrorViewV2();
                LiveHouseFragment.this.refreshFinish();
                LiveHouseFragment.this.stopProgressDialog();
                fm2.a = SystemClock.elapsedRealtime();
                if (baseResponse != null) {
                    fm2.b = baseResponse.serverTime;
                }
                LiveHouseFragment.this.setData(baseResponse);
                LiveHouseFragment.this.mBaseResponse = baseResponse;
                if (((AbsFragment) LiveHouseFragment.this).mRecyclerView != null) {
                    ((AbsFragment) LiveHouseFragment.this).mRecyclerView.scrollToPosition(0);
                }
                LiveHouseFragment liveHouseFragment = LiveHouseFragment.this;
                liveHouseFragment.updateHomeAtmosphere(liveHouseFragment.getAtmosphere(baseResponse));
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217794776")) {
            ipChange.ipc$dispatch("-217794776", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        if (isLazyLoaded) {
            reloadIfCityChanged();
        }
        if (z) {
            updateHomeAtmosphere(getAtmosphere(this.mBaseResponse));
        }
    }
}
