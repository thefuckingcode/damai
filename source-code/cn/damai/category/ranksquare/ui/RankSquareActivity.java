package cn.damai.category.ranksquare.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranksquare.bean.RankSquareBean;
import cn.damai.category.ranksquare.bean.RankSquareDataHolder;
import cn.damai.category.ranksquare.bean.RankSquareGroupItemBean;
import cn.damai.category.ranksquare.bean.RankSquareListItemBean;
import cn.damai.category.ranksquare.bean.RankSquareMoreBean;
import cn.damai.category.ranksquare.bean.RankSquareResponse;
import cn.damai.category.ranksquare.model.RankSquareModel;
import cn.damai.category.ranksquare.ui.adapter.RankSquareAdapter;
import cn.damai.category.ranksquare.ui.adapter.RankSquareNewAdapter;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cx1;
import tb.m42;
import tb.ne2;
import tb.tz0;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class RankSquareActivity extends SimpleBaseActivity implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    StringBuilder builder = new StringBuilder();
    long dyValue;
    private RankSquareAdapter mAdapter;
    private List<RankSquareDataHolder> mDataHolderList = new ArrayList();
    private int mEdgeContentPadding = 0;
    private int mEdgePadding = 0;
    private LinearLayoutManager mLayoutManager;
    private RankSquareMoreBean mMoreRankSquareBean;
    private RankSquareBean mRankSquareBean;
    private RankSquareNewAdapter mRankSquareNewAdapter;
    private int mRankTotalNum;
    private IRecyclerView mRecyclerView;
    private int mRequsetRankNum;
    private int mRightSize = 0;
    private String mShareLocalImageUrl;
    private String mShareUrl;
    private RecyclerView mSquareListRecyclerView;
    private View mTitleLine;
    private TextView mTvShare;
    private RankSquareModel mViewModel;
    Observer<Integer> moreRankPageChangeObserver = new Observer<Integer>() {
        /* class cn.damai.category.ranksquare.ui.RankSquareActivity.AnonymousClass4 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1534488874")) {
                ipChange.ipc$dispatch("1534488874", new Object[]{this, num});
            } else if (RankSquareActivity.this.mViewModel != null) {
                MutableLiveData<RankSquareResponse> moreRankSquareData = RankSquareActivity.this.mViewModel.getMoreRankSquareData();
                RankSquareActivity rankSquareActivity = RankSquareActivity.this;
                moreRankSquareData.observe(rankSquareActivity, rankSquareActivity.moreRankSquareObserver);
            }
        }
    };
    Observer<RankSquareResponse> moreRankSquareObserver = new Observer<RankSquareResponse>() {
        /* class cn.damai.category.ranksquare.ui.RankSquareActivity.AnonymousClass5 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable RankSquareResponse rankSquareResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1557721794")) {
                ipChange.ipc$dispatch("1557721794", new Object[]{this, rankSquareResponse});
                return;
            }
            RankSquareActivity.this.stopMoreRankProgress();
            if (rankSquareResponse != null && RankSquareActivity.this.mViewModel != null) {
                if (RankSquareActivity.this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                    if (rankSquareResponse.requestSuccess) {
                        RankSquareActivity.this.mMoreRankSquareBean = rankSquareResponse.mRankSquareMoreBean;
                        RankSquareActivity.this.updateRankSquareData();
                        return;
                    }
                    RankSquareActivity.this.error(rankSquareResponse.errorCode, rankSquareResponse.errorMsg, "mtop.damai.wireless.search.rankinglist.query");
                } else if (rankSquareResponse.requestSuccess) {
                    RankSquareActivity.this.returnMoreRankData(rankSquareResponse.mRankSquareMoreBean);
                } else {
                    ToastUtil.i(rankSquareResponse.errorMsg);
                }
            }
        }
    };
    Observer<RankSquareResponse> rankSquareObserver = new Observer<RankSquareResponse>() {
        /* class cn.damai.category.ranksquare.ui.RankSquareActivity.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable RankSquareResponse rankSquareResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-350735996")) {
                ipChange.ipc$dispatch("-350735996", new Object[]{this, rankSquareResponse});
                return;
            }
            RankSquareActivity.this.stopRankProgress();
            if (rankSquareResponse != null) {
                if (rankSquareResponse.requestSuccess) {
                    RankSquareActivity.this.returnRankSquareData(rankSquareResponse.mRankSquareBean);
                } else {
                    RankSquareActivity.this.error(rankSquareResponse.errorCode, rankSquareResponse.errorMsg, "mtop.damai.wireless.search.rankinglist.all.get");
                }
            }
        }
    };
    private boolean requestMoreRanking = false;
    private boolean requestRanking = false;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void error(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-505695032")) {
            ipChange.ipc$dispatch("-505695032", new Object[]{this, str, str2, str3});
            return;
        }
        onResponseError(str2, str, str3, findViewById(R$id.ll_root), true);
    }

    private void errorEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863451460")) {
            ipChange.ipc$dispatch("863451460", new Object[]{this});
            return;
        }
        onResponseError(3, "这里空空如也(-.-)", "0", "mtop.damai.wireless.search.rankinglist.all.get", findViewById(R$id.ll_root), true);
    }

    private void initStateBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1539588204")) {
            ipChange.ipc$dispatch("1539588204", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                view.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private void loadPicDownLoad(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410838928")) {
            ipChange.ipc$dispatch("-1410838928", new Object[]{this, str});
            return;
        }
        this.mShareLocalImageUrl = tz0.c(str, this.mContext);
    }

    private void requestRankData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012353287")) {
            ipChange.ipc$dispatch("2012353287", new Object[]{this, Boolean.valueOf(z)});
        } else if (!this.requestRanking && !this.requestMoreRanking) {
            this.requestRanking = true;
            this.requestMoreRanking = true;
            if (z) {
                startProgressDialog();
            }
            this.mViewModel.getRankSquareListData().observe(this, this.rankSquareObserver);
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void returnMoreRankData(RankSquareMoreBean rankSquareMoreBean) {
        int e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118890481")) {
            ipChange.ipc$dispatch("-118890481", new Object[]{this, rankSquareMoreBean});
        } else if (rankSquareMoreBean != null && (e = xf2.e(rankSquareMoreBean.list)) > 0) {
            this.mRequsetRankNum += e;
            RankSquareDataHolder rankSquareDataHolder = new RankSquareDataHolder(3);
            rankSquareDataHolder.mLocalItemBeans = rankSquareMoreBean.list;
            this.mDataHolderList.add(rankSquareDataHolder);
            int i = this.mRankTotalNum;
            if (i > 0 && i <= this.mRequsetRankNum) {
                this.mDataHolderList.add(new RankSquareDataHolder(4));
            }
            RankSquareAdapter rankSquareAdapter = this.mAdapter;
            if (rankSquareAdapter != null) {
                rankSquareAdapter.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void returnRankSquareData(RankSquareBean rankSquareBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306009116")) {
            ipChange.ipc$dispatch("306009116", new Object[]{this, rankSquareBean});
            return;
        }
        this.mRankSquareBean = rankSquareBean;
        updateRankSquareData();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopMoreRankProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61126472")) {
            ipChange.ipc$dispatch("61126472", new Object[]{this});
            return;
        }
        this.requestMoreRanking = false;
        RankSquareModel rankSquareModel = this.mViewModel;
        if (rankSquareModel != null && rankSquareModel.getPageIndex().getValue().intValue() == 1) {
            onResponseSuccess(findViewById(R$id.ll_root));
            stopRecyclerRefresh();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopRankProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "990025693")) {
            ipChange.ipc$dispatch("990025693", new Object[]{this});
            return;
        }
        this.requestRanking = false;
        onResponseSuccess(findViewById(R$id.ll_root));
        stopProgressDialog();
        stopRecyclerRefresh();
    }

    private void stopRecyclerRefresh() {
        IRecyclerView iRecyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991941432")) {
            ipChange.ipc$dispatch("991941432", new Object[]{this});
        } else if (!this.requestMoreRanking && !this.requestRanking && (iRecyclerView = this.mRecyclerView) != null) {
            iRecyclerView.setRefreshing(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateRankSquareData() {
        RankSquareGroupItemBean rankSquareGroupItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894463620")) {
            ipChange.ipc$dispatch("-894463620", new Object[]{this});
        } else if (this.mRankSquareBean != null) {
            this.mDataHolderList.clear();
            this.mRequsetRankNum = 0;
            String str = "";
            RankSquareNewAdapter rankSquareNewAdapter = new RankSquareNewAdapter(this.mContext, this.mRankSquareBean.list);
            this.mRankSquareNewAdapter = rankSquareNewAdapter;
            this.mSquareListRecyclerView.setAdapter(rankSquareNewAdapter);
            if (xf2.e(this.mRankSquareBean.localList) > 0) {
                RankSquareDataHolder rankSquareDataHolder = new RankSquareDataHolder(2);
                rankSquareDataHolder.rankSquareName = "本地精选榜";
                this.mDataHolderList.add(rankSquareDataHolder);
                RankSquareDataHolder rankSquareDataHolder2 = new RankSquareDataHolder(3);
                rankSquareDataHolder2.mLocalItemBeans = this.mRankSquareBean.localList;
                rankSquareDataHolder2.mLocalRank = true;
                this.mDataHolderList.add(rankSquareDataHolder2);
                if (TextUtils.isEmpty(str) && (rankSquareGroupItemBean = this.mRankSquareBean.localList.get(0)) != null) {
                    if (xf2.e(rankSquareGroupItemBean.verticalPicList) > 0) {
                        str = rankSquareGroupItemBean.verticalPicList.get(0);
                    }
                    loadPicDownLoad(str);
                    updateShare(this.mRankSquareBean.shareUrl, rankSquareGroupItemBean);
                }
            }
            RankSquareMoreBean rankSquareMoreBean = this.mMoreRankSquareBean;
            if (rankSquareMoreBean != null) {
                this.mRankTotalNum = rankSquareMoreBean.total;
                int e = xf2.e(rankSquareMoreBean.list);
                this.mRequsetRankNum = e;
                if (e > 0) {
                    RankSquareDataHolder rankSquareDataHolder3 = new RankSquareDataHolder(2);
                    rankSquareDataHolder3.rankSquareName = "更多榜单";
                    this.mDataHolderList.add(rankSquareDataHolder3);
                    RankSquareDataHolder rankSquareDataHolder4 = new RankSquareDataHolder(3);
                    rankSquareDataHolder4.mLocalItemBeans = this.mMoreRankSquareBean.list;
                    rankSquareDataHolder4.mLocalRank = false;
                    this.mDataHolderList.add(rankSquareDataHolder4);
                }
                int i = this.mRankTotalNum;
                if (i > 0 && i <= this.mRequsetRankNum) {
                    this.mDataHolderList.add(new RankSquareDataHolder(4));
                }
            }
            RankSquareAdapter rankSquareAdapter = this.mAdapter;
            if (rankSquareAdapter != null) {
                rankSquareAdapter.notifyDataSetChanged();
            }
            if (xf2.e(this.mDataHolderList) == 0 && !this.requestRanking && !this.requestMoreRanking) {
                errorEmptyPage();
            }
        }
    }

    private void updateShare(String str, RankSquareListItemBean rankSquareListItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175491844")) {
            ipChange.ipc$dispatch("-175491844", new Object[]{this, str, rankSquareListItemBean});
        } else if (!TextUtils.isEmpty(str)) {
            this.mShareUrl = str;
            this.mTvShare.setVisibility(0);
            this.mTvShare.setTag(rankSquareListItemBean);
        } else {
            this.mTvShare.setVisibility(8);
            this.mTvShare.setTag(null);
        }
    }

    private void updateShareContent(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414147795")) {
            ipChange.ipc$dispatch("1414147795", new Object[]{this, str, str2, str3});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("projectName", str);
        bundle.putString("message", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString("imageurl", str3);
            bundle.putString("projectImage", str3);
        }
        if (!TextUtils.isEmpty(this.mShareLocalImageUrl)) {
            bundle.putString("sinaSharePath", this.mShareLocalImageUrl);
        }
        bundle.putString("producturl", this.mShareUrl);
        bundle.putBoolean("showGenerateImage", true);
        bundle.putString("shareType", "chat_h5");
        bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_RANKING_IMAGE);
        ShareManager.E().O(this, bundle, R$layout.rank_activity);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2047230570")) {
            return R$layout.rank_square_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("2047230570", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472606801")) {
            ipChange.ipc$dispatch("1472606801", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.handleError(i);
        requestRankData(true);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311173731")) {
            ipChange.ipc$dispatch("1311173731", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mRightSize = m42.a(xs0.a(), 1.0f);
        this.mEdgePadding = m42.a(xs0.a(), 0.0f);
        this.mEdgeContentPadding = m42.a(xs0.a(), 15.0f);
        View findViewById = findViewById(R$id.line);
        this.mTitleLine = findViewById;
        findViewById.setVisibility(8);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.rand_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        RankSquareAdapter rankSquareAdapter = new RankSquareAdapter(this.mContext, this.mDataHolderList);
        this.mAdapter = rankSquareAdapter;
        this.mRecyclerView.setAdapter(rankSquareAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        View inflate = LayoutInflater.from(this).inflate(R$layout.square_list_sub, (ViewGroup) null);
        this.mSquareListRecyclerView = (RecyclerView) inflate.findViewById(R$id.square_list_recycler);
        this.mRecyclerView.addHeaderView(inflate);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this, 100, false, R$color.color_ffffff));
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        TextView textView = (TextView) findViewById(R$id.tv_share);
        this.mTvShare = textView;
        textView.setVisibility(8);
        this.mTvShare.setOnClickListener(this);
        findViewById(R$id.btn_left).setOnClickListener(this);
        initStateBar(findViewById(R$id.status_bar));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.category.ranksquare.ui.RankSquareActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-645061662")) {
                    ipChange.ipc$dispatch("-645061662", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2107404803")) {
                    ipChange.ipc$dispatch("-2107404803", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                RankSquareActivity rankSquareActivity = RankSquareActivity.this;
                long j = rankSquareActivity.dyValue + ((long) i2);
                rankSquareActivity.dyValue = j;
                if (j <= 18) {
                    rankSquareActivity.mTitleLine.setVisibility(8);
                } else if (rankSquareActivity.mTitleLine.getVisibility() != 0) {
                    RankSquareActivity.this.mTitleLine.setVisibility(0);
                }
            }
        });
        this.mSquareListRecyclerView.setLayoutManager(new LinearLayoutManager(xs0.a(), 0, false));
        this.mSquareListRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.category.ranksquare.ui.RankSquareActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-482078565")) {
                    ipChange.ipc$dispatch("-482078565", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0) {
                    rect.left = RankSquareActivity.this.mEdgeContentPadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == RankSquareActivity.this.mAdapter.getItemCount() - 1) {
                    rect.right = RankSquareActivity.this.mEdgeContentPadding;
                } else {
                    rect.right = RankSquareActivity.this.mRightSize;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388532854")) {
            ipChange.ipc$dispatch("-1388532854", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        Object tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179495817")) {
            ipChange.ipc$dispatch("179495817", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.btn_left) {
            finish();
        } else if (id == R$id.tv_share && (tag = view.getTag()) != null) {
            c.e().x(cx1.f().q());
            if (tag instanceof RankSquareListItemBean) {
                RankSquareListItemBean rankSquareListItemBean = (RankSquareListItemBean) tag;
                updateShareContent(rankSquareListItemBean.name, rankSquareListItemBean.subHead, rankSquareListItemBean.headPic);
            } else if (tag instanceof RankSquareGroupItemBean) {
                RankSquareGroupItemBean rankSquareGroupItemBean = (RankSquareGroupItemBean) tag;
                updateShareContent(rankSquareGroupItemBean.shortName, rankSquareGroupItemBean.shortDesc, xf2.e(rankSquareGroupItemBean.verticalPicList) > 0 ? rankSquareGroupItemBean.verticalPicList.get(0) : "");
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2102805769")) {
            ipChange.ipc$dispatch("-2102805769", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        RankSquareModel rankSquareModel = (RankSquareModel) ViewModelProviders.of(this).get(RankSquareModel.class);
        this.mViewModel = rankSquareModel;
        rankSquareModel.getPageIndex().observe(this, this.moreRankPageChangeObserver);
        setDamaiUTKeyBuilder(cx1.f().g());
        c.e().K(this);
        requestRankData(true);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        RankSquareModel rankSquareModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106187540")) {
            ipChange.ipc$dispatch("2106187540", new Object[]{this, view});
            return;
        }
        int i = this.mRankTotalNum;
        if (i > 0 && this.mRequsetRankNum < i && !this.requestRanking && !this.requestMoreRanking && (rankSquareModel = this.mViewModel) != null) {
            int intValue = rankSquareModel.getPageIndex().getValue().intValue();
            this.requestMoreRanking = true;
            this.mViewModel.getPageIndex().setValue(Integer.valueOf(intValue + 1));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549035894")) {
            ipChange.ipc$dispatch("1549035894", new Object[]{this});
            return;
        }
        requestRankData(false);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1853269854")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1853269854", new Object[]{this});
    }

    private void updateShare(String str, RankSquareGroupItemBean rankSquareGroupItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117304527")) {
            ipChange.ipc$dispatch("-117304527", new Object[]{this, str, rankSquareGroupItemBean});
        } else if (!TextUtils.isEmpty(str)) {
            this.mShareUrl = str;
            this.mTvShare.setVisibility(0);
            this.mTvShare.setTag(rankSquareGroupItemBean);
        } else {
            this.mTvShare.setVisibility(8);
            this.mTvShare.setTag(null);
        }
    }
}
