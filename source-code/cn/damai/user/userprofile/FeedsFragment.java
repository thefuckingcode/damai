package cn.damai.user.userprofile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FeedsData;
import cn.damai.user.userprofile.bean.FeedsRequest;
import cn.damai.user.userprofile.bean.FeedsResponse;
import cn.damai.user.userprofile.bean.UserData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class FeedsFragment extends BaseFragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    UserIndexViewModel activityViewModel;
    FeedsAdapter adapter;
    View emptyFoot;
    TextView emptyTv;
    View emptyView;
    FeedsResponse feedsData;
    Observer<FeedsResponse> feedsObserver;
    FeedsRequest feedsRequest;
    IRecyclerView recyclerview;
    boolean singlePage = false;
    int utType = 0;
    FeedsViewModel viewModel;

    /* compiled from: Taobao */
    public class OnVerticalScrollListener extends RecyclerView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        OnVerticalScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1361508286")) {
                ipChange.ipc$dispatch("1361508286", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            Log.d("scroll", " 滑动 dy ： " + i2);
            if (i2 < 0) {
                Log.d("scroll", " 滑动显示： " + i2);
                FeedsFragment.this.activityViewModel.getClickEvent().setValue(13);
            } else if (i2 > 0) {
                Log.d("scroll", " 滑动隐藏： " + i2);
                FeedsFragment.this.activityViewModel.getClickEvent().setValue(14);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.irecycler.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "635253881")) {
                ipChange.ipc$dispatch("635253881", new Object[]{this});
                return;
            }
            FeedsFragment feedsFragment = FeedsFragment.this;
            feedsFragment.feedsRequest = null;
            feedsFragment.feedsData = null;
            feedsFragment.recyclerview.setRefreshing(true);
            FeedsFragment.this.requestFeeds();
        }
    }

    public static FeedsFragment newInstance(int i, String str, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819968155")) {
            return (FeedsFragment) ipChange.ipc$dispatch("-819968155", new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Integer.valueOf(i2)});
        }
        FeedsFragment feedsFragment = new FeedsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("targetType", i);
        bundle.putInt("feedType", i2);
        bundle.putString(FeedsViewModel.ARG_USERID, str);
        bundle.putLong("bid", j);
        feedsFragment.setArguments(bundle);
        return feedsFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestFeeds() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422616478")) {
            ipChange.ipc$dispatch("-422616478", new Object[]{this});
            return;
        }
        if (this.feedsRequest == null) {
            FeedsRequest feedsRequest2 = new FeedsRequest();
            this.feedsRequest = feedsRequest2;
            feedsRequest2.bizTypeList = FeedsRequest.BIZ_TYPE_USER;
        }
        if (this.feedsObserver == null) {
            this.feedsObserver = new Observer<FeedsResponse>() {
                /* class cn.damai.user.userprofile.FeedsFragment.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onChanged(@Nullable FeedsResponse feedsResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-521211075")) {
                        ipChange.ipc$dispatch("-521211075", new Object[]{this, feedsResponse});
                        return;
                    }
                    FeedsFragment.this.recyclerview.setRefreshing(false);
                    if (feedsResponse != null && !xf2.j(feedsResponse.errorMsg)) {
                        ToastUtil.i(feedsResponse.errorMsg);
                        FeedsFragment.this.stopProgressDialog();
                        FeedsFragment.this.setEmptyView();
                    } else if (feedsResponse != null) {
                        FeedsFragment.this.updateFeedsList(feedsResponse);
                    }
                }
            };
        }
        this.viewModel.getFeeds(this.feedsRequest).observe(this, this.feedsObserver);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74441752")) {
            ipChange.ipc$dispatch("74441752", new Object[]{this});
            return;
        }
        this.emptyView.setVisibility(0);
        FeedsRequest feedsRequest2 = this.feedsRequest;
        if (feedsRequest2 == null) {
            return;
        }
        if (feedsRequest2.feedType == FeedsRequest.FEED_TYPE_QUANZI) {
            this.emptyTv.setText("这里好安静啊，快来说点啥吧～");
        } else {
            this.emptyTv.setText("ta还没有发表动态哦～");
        }
    }

    private FeedsData setFeedsResponse(FeedsResponse feedsResponse, FeedsResponse feedsResponse2) {
        List<FeedMergeDataDO> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202981317")) {
            return (FeedsData) ipChange.ipc$dispatch("-202981317", new Object[]{this, feedsResponse, feedsResponse2});
        }
        if (feedsResponse2 != null) {
            FeedsData feedsData2 = feedsResponse.data;
            if (!(feedsData2 == null || (list = feedsData2.feedMergeDataList) == null || list == null)) {
                feedsResponse2.data.feedMergeDataList.addAll(0, list);
            }
            feedsResponse = feedsResponse2;
        }
        return feedsResponse.data;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1556817991")) {
            return R$layout.fragment_usertab;
        }
        return ((Integer) ipChange.ipc$dispatch("1556817991", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337584278")) {
            ipChange.ipc$dispatch("-1337584278", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194950899")) {
            ipChange.ipc$dispatch("194950899", new Object[]{this});
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425929241")) {
            ipChange.ipc$dispatch("425929241", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241663079")) {
            ipChange.ipc$dispatch("1241663079", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.viewModel = (FeedsViewModel) ViewModelProviders.of(this).get(FeedsViewModel.class);
        if (getArguments() != null) {
            this.viewModel.initParams(getArguments());
        }
    }

    @Override // androidx.fragment.app.Fragment, cn.damai.common.app.base.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1241606845")) {
            return layoutInflater.inflate(R$layout.fragment_usertab, viewGroup, false);
        }
        return (View) ipChange.ipc$dispatch("1241606845", new Object[]{this, layoutInflater, viewGroup, bundle});
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789754236")) {
            ipChange.ipc$dispatch("-789754236", new Object[]{this, view});
        } else if (this.feedsRequest.startRow == null) {
            this.recyclerview.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.recyclerview.getLoadMoreFooterView().setVisibility(8);
        } else {
            this.recyclerview.getLoadMoreFooterView().setVisibility(0);
            this.recyclerview.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.viewModel.getFeeds(this.feedsRequest);
        }
    }

    @Override // androidx.fragment.app.Fragment, cn.damai.common.app.base.BaseFragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603214720")) {
            ipChange.ipc$dispatch("-603214720", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        IRecyclerView iRecyclerView = (IRecyclerView) view.findViewById(R$id.listview);
        this.recyclerview = iRecyclerView;
        iRecyclerView.setHasFixedSize(true);
        this.recyclerview.setLayoutManager(new FullyLinearLayoutManager(getContext()));
        this.recyclerview.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
        this.recyclerview.setOnRefreshListener(new a());
        this.emptyView = view.findViewById(R$id.user_empty_view);
        this.emptyTv = (TextView) view.findViewById(R$id.user_empty_tv);
        FeedsAdapter feedsAdapter = new FeedsAdapter(getActivity(), new FeedsResponse(), view, "");
        this.adapter = feedsAdapter;
        this.recyclerview.setAdapter(feedsAdapter);
        this.recyclerview.setRefreshEnabled(false);
        this.recyclerview.setLoadMoreEnabled(true);
        this.recyclerview.setOnLoadMoreListener(this);
        this.recyclerview.addOnScrollListener(new OnVerticalScrollListener());
        this.adapter.i(this.singlePage, this.utType);
        this.emptyFoot = LayoutInflater.from(getContext()).inflate(R$layout.feeds_footer_empty, (ViewGroup) null);
        this.emptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(getActivity(), 110.0f)));
        FeedsRequest feedsRequest2 = new FeedsRequest();
        this.feedsRequest = feedsRequest2;
        feedsRequest2.bizTypeList = FeedsRequest.BIZ_TYPE_USER;
        this.activityViewModel = (UserIndexViewModel) ViewModelProviders.of(getActivity()).get(UserIndexViewModel.class);
        requestFeeds();
    }

    public void setSinglePage(boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981694648")) {
            ipChange.ipc$dispatch("981694648", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        this.singlePage = true;
        this.utType = i;
    }

    public void updateFeedsList(FeedsResponse feedsResponse) {
        FeedsData feedsData2;
        String str;
        String str2;
        boolean z;
        FeedsData feedsData3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400237046")) {
            ipChange.ipc$dispatch("400237046", new Object[]{this, feedsResponse});
            return;
        }
        stopProgressDialog();
        if (!(feedsResponse == null || (feedsData3 = feedsResponse.data) == null || this.feedsRequest.feedType != FeedsRequest.FEED_TYPE_QUANZI)) {
            UserIndexViewModel userIndexViewModel = this.activityViewModel;
            userIndexViewModel.circleId = feedsData3.circleId;
            userIndexViewModel.circleName = feedsData3.circleName;
        }
        if (feedsResponse == null || (feedsData2 = feedsResponse.data) == null || feedsData2.feedMergeDataList == null) {
            setEmptyView();
            return;
        }
        this.feedsRequest.startRow = feedsData2.nextRow;
        FeedsResponse feedsResponse2 = this.feedsData;
        if (feedsResponse2 == null) {
            this.feedsData = feedsResponse;
        } else {
            setFeedsResponse(feedsResponse2, feedsResponse);
            this.feedsData = feedsResponse;
        }
        if (feedsResponse.data.feedMergeDataList.size() == 0) {
            setEmptyView();
        }
        if (this.activityViewModel.getUserInfoValue() != null) {
            UserData userInfoValue = this.activityViewModel.getUserInfoValue();
            boolean z2 = userInfoValue.mySelf;
            String str3 = userInfoValue.nickname;
            str = userInfoValue.headImg;
            z = z2;
            str2 = str3;
        } else {
            str2 = "";
            str = str2;
            z = false;
        }
        this.adapter.h(this.feedsRequest.refreshHeader);
        this.adapter.j(feedsResponse, this.feedsRequest.feedType == FeedsRequest.FEED_TYPE_QUANZI, z, str2, str);
    }
}
