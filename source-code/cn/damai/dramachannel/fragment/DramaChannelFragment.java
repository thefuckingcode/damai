package cn.damai.dramachannel.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.dramachannel.bean.DramaParams;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.d20;
import tb.dr;
import tb.g91;
import tb.oz0;
import tb.vz2;
import tb.wf;
import tb.xk2;

/* compiled from: Taobao */
public class DramaChannelFragment extends AbsFragmentV2 implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TAB = "tab";
    private boolean isNeedReloadByCityChanged = false;
    private boolean isViewCreated;
    private boolean isVisibleToUser;
    private ContainerArg mContainerArg;
    private HomeTabBean mTabBean;
    private String requestErrorCode = "";
    private String requestErrorMsg = "";

    /* compiled from: Taobao */
    public class a implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1928203235")) {
                ipChange.ipc$dispatch("1928203235", new Object[]{this});
                return;
            }
            DramaChannelFragment.this.loadPage(true);
        }
    }

    public static DramaChannelFragment getInstance(HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393359010")) {
            return (DramaChannelFragment) ipChange.ipc$dispatch("393359010", new Object[]{homeTabBean});
        }
        DramaChannelFragment dramaChannelFragment = new DramaChannelFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        dramaChannelFragment.setArguments(bundle);
        return dramaChannelFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadPage(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583376601")) {
            ipChange.ipc$dispatch("583376601", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        this.isNeedReloadByCityChanged = false;
        final TetrisRequest tetrisRequest = new TetrisRequest(new DramaParams());
        TetrisRequest.overrideParams(tetrisRequest, this.mContainerArg);
        if (d20.g()) {
            requestCdn(tetrisRequest.patternName, tetrisRequest.patternVersion, d20.c());
        } else {
            tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
                /* class cn.damai.dramachannel.fragment.DramaChannelFragment.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.tetris.DMMtopWarningListener
                public void onFailWithWarning(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "254381608")) {
                        ipChange.ipc$dispatch("254381608", new Object[]{this, str, str2});
                        return;
                    }
                    if (z) {
                        DramaChannelFragment.this.stopProgressDialog();
                    }
                    DramaChannelFragment.this.refreshFinish();
                    DramaChannelFragment.this.requestErrorCode = str;
                    DramaChannelFragment.this.requestErrorMsg = str2;
                    DramaChannelFragment dramaChannelFragment = DramaChannelFragment.this;
                    TetrisRequest tetrisRequest = tetrisRequest;
                    dramaChannelFragment.requestCdn(tetrisRequest.patternName, tetrisRequest.patternVersion, d20.c());
                }

                public void onSuccessWithWarning(BaseResponse baseResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-390602986")) {
                        ipChange.ipc$dispatch("-390602986", new Object[]{this, baseResponse});
                        return;
                    }
                    if (z) {
                        DramaChannelFragment.this.stopProgressDialog();
                    }
                    DramaChannelFragment.this.hideErrorViewV2();
                    DramaChannelFragment.this.refreshFinish();
                    DramaChannelFragment.this.readResponse(baseResponse);
                }
            });
        }
    }

    private void obtainArgument() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19806706")) {
            ipChange.ipc$dispatch("-19806706", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mTabBean = (HomeTabBean) arguments.getSerializable(KEY_TAB);
        }
        HomeTabBean homeTabBean = this.mTabBean;
        if (homeTabBean == null) {
            this.mContainerArg = ContainerArg.defaultDramaChannelArg();
        } else {
            this.mContainerArg = new ContainerArg(homeTabBean.patternName, homeTabBean.patternVersion, homeTabBean.args);
        }
    }

    private void pageAlarm(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130233100")) {
            ipChange.ipc$dispatch("2130233100", new Object[]{this, str, str2});
            return;
        }
        dr.INSTANCE.a().a("mtop.damai.mec.aristotle.get").g("演出类目页").d(str2).c(str).h(this.mTabBean.patternName).i(this.mTabBean.patternVersion).j(this.mTabBean.spmb).f(false).b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void readResponse(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796309412")) {
            ipChange.ipc$dispatch("1796309412", new Object[]{this, baseResponse});
            return;
        }
        if (wf.b(baseResponse)) {
            CategoryItemListInfo a2 = wf.a(baseResponse);
            if (a2.isCanRequestNextPage(true, 1)) {
                loadMoreResetV2(true);
            } else if (a2.hasListSize()) {
                showNoMoreV2();
            } else {
                showNoMoreV2("没有找到相关演出，换个筛选条件试试吧");
            }
        }
        setData(baseResponse);
    }

    private void reloadIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138229956")) {
            ipChange.ipc$dispatch("138229956", new Object[]{this});
        } else if (this.isNeedReloadByCityChanged && this.isVisibleToUser && this.isViewCreated) {
            if (this.mRecyclerView.getChildCount() > 0) {
                this.mRecyclerView.scrollToPosition(0);
            }
            loadPage(true);
        }
    }

    private void setContainerArg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190019971")) {
            ipChange.ipc$dispatch("1190019971", new Object[]{this});
            return;
        }
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(this.mContainerArg);
        }
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754524076")) {
            ipChange.ipc$dispatch("-754524076", new Object[]{this, str, str2});
            return;
        }
        String str3 = this.requestErrorCode;
        String str4 = this.requestErrorMsg;
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str4 = this.requestErrorMsg + AltriaXLaunchTime.SPACE + str2;
        }
        pageAlarm(str3, str4);
        showErrorViewV2(str, str2, new a());
        if (!oz0.b().c(str)) {
            vz2.c("mtop.damai.mec.aristotle.get", str, "首屏加载失败:" + str2 + " ");
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-659275946")) {
            ipChange.ipc$dispatch("-659275946", new Object[]{this});
            return;
        }
        if (isVisible() && this.isVisibleToUser) {
            z = true;
        }
        loadPage(z);
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onCdnResponse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1382641099")) {
            ipChange.ipc$dispatch("-1382641099", new Object[]{this, str});
            return;
        }
        super.onCdnResponse(str);
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            showErrorPage(str2, "cdn返回数据json是null");
            return;
        }
        BaseResponse baseResponse = null;
        try {
            baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            str2 = xk2.a(e);
        }
        if (baseResponse == null) {
            showErrorPage("cdn_parse_error", "cdn返回数据解析后数据为null  " + str2);
            return;
        }
        readResponse(baseResponse);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637086155")) {
            ipChange.ipc$dispatch("1637086155", new Object[]{this});
            return;
        }
        g91.c("CityChanged", "CityChanged");
        this.isNeedReloadByCityChanged = true;
        reloadIfNeed();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995668826")) {
            ipChange.ipc$dispatch("1995668826", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.isViewCreated = false;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139291228")) {
            ipChange.ipc$dispatch("139291228", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710377165")) {
            ipChange.ipc$dispatch("710377165", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460168894")) {
            ipChange.ipc$dispatch("1460168894", new Object[]{this});
            return;
        }
        loadPage(false);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791812700")) {
            ipChange.ipc$dispatch("-791812700", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfNeed();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544134744")) {
            ipChange.ipc$dispatch("544134744", new Object[]{this, view, bundle});
            return;
        }
        obtainArgument();
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        setContainerArg();
        enableDividerLine(false);
        enableRefresh();
        enableLoadMore();
        this.mEmptyFoot.findViewById(R$id.id_foot_normal).setBackgroundColor(Color.parseColor("#F5F6F7"));
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.page.AbsFragmentV2, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898843920")) {
            ipChange.ipc$dispatch("898843920", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        this.isVisibleToUser = z;
        if (isLazyLoaded) {
            reloadIfNeed();
        }
    }
}
