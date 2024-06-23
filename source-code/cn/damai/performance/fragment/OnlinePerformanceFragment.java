package cn.damai.performance.fragment;

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
import cn.damai.message.observer.Action;
import cn.damai.performance.bean.HeadAtmosphere;
import cn.damai.performance.bean.HeadResult;
import cn.damai.performance.model.OnlinePerformanceParams;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
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
import tb.s71;

/* compiled from: Taobao */
public class OnlinePerformanceFragment extends AbsFragmentV2 implements OnCityChangedListener {
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
            if (AndroidInstantRuntime.support(ipChange, "866131408")) {
                ipChange.ipc$dispatch("866131408", new Object[]{this, obj});
                return;
            }
            OnlinePerformanceFragment.this.request(false);
        }
    }

    static /* synthetic */ int access$312(OnlinePerformanceFragment onlinePerformanceFragment, int i) {
        int i2 = onlinePerformanceFragment.mScrollDistance + i;
        onlinePerformanceFragment.mScrollDistance = i2;
        return i2;
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2210627")) {
            ipChange.ipc$dispatch("2210627", new Object[]{this});
            return;
        }
        this.mScrollDistance = 0;
        updateScrollDistance();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.performance.fragment.OnlinePerformanceFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1688388498")) {
                    ipChange.ipc$dispatch("-1688388498", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                OnlinePerformanceFragment.access$312(OnlinePerformanceFragment.this, i2);
                if (OnlinePerformanceFragment.this.mScrollDistance < 0) {
                    OnlinePerformanceFragment.this.mScrollDistance = 0;
                }
                OnlinePerformanceFragment.this.updateScrollDistance();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HeadAtmosphere getAtmosphere(BaseResponse baseResponse) {
        HeadResult headResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962903994")) {
            return (HeadAtmosphere) ipChange.ipc$dispatch("-962903994", new Object[]{this, baseResponse});
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
                                if (TextUtils.equals("live_perform_online_star", baseSection.getComponentId())) {
                                    NodeData item = baseSection.getItem();
                                    if (!(item == null || (headResult = (HeadResult) JSON.parseObject(item.toJSONString(), HeadResult.class)) == null || s71.a(headResult.result) || headResult.result.get(0) == null)) {
                                        return headResult.result.get(0);
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

    public static OnlinePerformanceFragment getInstance(HomeTabBean homeTabBean, HomeTopBgListener homeTopBgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149014392")) {
            return (OnlinePerformanceFragment) ipChange.ipc$dispatch("-149014392", new Object[]{homeTabBean, homeTopBgListener});
        }
        OnlinePerformanceFragment onlinePerformanceFragment = new OnlinePerformanceFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        onlinePerformanceFragment.setArguments(bundle);
        onlinePerformanceFragment.mTopBgListener = homeTopBgListener;
        return onlinePerformanceFragment;
    }

    private boolean isVisibleToUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254338949")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254338949", new Object[]{this})).booleanValue();
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

    private void reloadIfCityChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671414542")) {
            ipChange.ipc$dispatch("-671414542", new Object[]{this});
        } else if (isVisibleToUser() && !TextUtils.isEmpty(this.mChangedCityId)) {
            this.mChangedCityId = null;
            request(false);
        }
    }

    private void setContainerArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091635831")) {
            ipChange.ipc$dispatch("-2091635831", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mArgs = (HomeTabBean) arguments.getSerializable(KEY_TAB);
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
        if (AndroidInstantRuntime.support(ipChange, "1845956510")) {
            ipChange.ipc$dispatch("1845956510", new Object[]{this});
            return;
        }
        View loadMoreFooterView = this.mRecyclerView.getLoadMoreFooterView();
        if (loadMoreFooterView != null) {
            loadMoreFooterView.setBackgroundColor(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateHomeAtmosphere(HeadAtmosphere headAtmosphere) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183675741")) {
            ipChange.ipc$dispatch("-183675741", new Object[]{this, headAtmosphere});
        } else if (headAtmosphere != null) {
            HomeHeaderBg homeHeaderBg = new HomeHeaderBg(null, 5, headAtmosphere.bgPicture, null);
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
        if (AndroidInstantRuntime.support(ipChange, "1910697434")) {
            ipChange.ipc$dispatch("1910697434", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1487031285")) {
            ipChange.ipc$dispatch("-1487031285", new Object[]{this});
            return;
        }
        request(false);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313214602")) {
            ipChange.ipc$dispatch("-313214602", new Object[]{this});
            return;
        }
        this.mChangedCityId = d20.c();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943491798")) {
            ipChange.ipc$dispatch("-943491798", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-496932665")) {
            ipChange.ipc$dispatch("-496932665", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105495810")) {
            ipChange.ipc$dispatch("1105495810", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521040530")) {
            ipChange.ipc$dispatch("-521040530", new Object[]{this});
            return;
        }
        super.onPause();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569557161")) {
            ipChange.ipc$dispatch("1569557161", new Object[]{this});
            return;
        }
        request(false);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619568039")) {
            ipChange.ipc$dispatch("-1619568039", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319513219")) {
            ipChange.ipc$dispatch("319513219", new Object[]{this, view, bundle});
            return;
        }
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
        if (AndroidInstantRuntime.support(ipChange, "1379102302")) {
            ipChange.ipc$dispatch("1379102302", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mChangedCityId = null;
        if (z) {
            startProgressDialog();
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new OnlinePerformanceParams(1));
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.performance.fragment.OnlinePerformanceFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.performance.fragment.OnlinePerformanceFragment$2$a */
            /* compiled from: Taobao */
            public class a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1101996257")) {
                        ipChange.ipc$dispatch("1101996257", new Object[]{this});
                        return;
                    }
                    OnlinePerformanceFragment.this.request(true);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "285333554")) {
                    ipChange.ipc$dispatch("285333554", new Object[]{this, str, str2});
                    return;
                }
                if (z) {
                    OnlinePerformanceFragment.this.stopProgressDialog();
                }
                OnlinePerformanceFragment.this.refreshFinish();
                OnlinePerformanceFragment.this.showErrorViewV2(str, str2, new a());
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-911993396")) {
                    ipChange.ipc$dispatch("-911993396", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    OnlinePerformanceFragment.this.stopProgressDialog();
                }
                OnlinePerformanceFragment.this.hideErrorViewV2();
                OnlinePerformanceFragment.this.refreshFinish();
                OnlinePerformanceFragment.this.stopProgressDialog();
                fm2.a = SystemClock.elapsedRealtime();
                if (baseResponse != null) {
                    fm2.b = baseResponse.serverTime;
                }
                OnlinePerformanceFragment.this.setData(baseResponse);
                OnlinePerformanceFragment.this.mBaseResponse = baseResponse;
                OnlinePerformanceFragment onlinePerformanceFragment = OnlinePerformanceFragment.this;
                onlinePerformanceFragment.updateHomeAtmosphere(onlinePerformanceFragment.getAtmosphere(baseResponse));
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026343621")) {
            ipChange.ipc$dispatch("-1026343621", new Object[]{this, Boolean.valueOf(z)});
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
