package cn.damai.category.venue.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.TabLine;
import cn.damai.category.venue.adapter.VenueItemAdapter;
import cn.damai.category.venue.bean.VenueQueryResponse;
import cn.damai.category.venue.viewmodel.VenueViewModel;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.uikit.view.ScrollLineView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.jg;
import tb.n42;
import tb.ne2;
import tb.y6;

/* compiled from: Taobao */
public class VenueActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isLoading = false;
    private boolean loadingMore = true;
    private VenueItemAdapter mAdapter;
    private String mCityId;
    private String mCityName;
    private int mCurrentTab = 1;
    protected ResponseErrorPage mErrorPage;
    private int mFirstVisibleItemCount;
    private int mFirstVisibleItems = -1;
    private ScrollLineView mLineTab;
    private LinearLayoutManager mLinearLayoutManager;
    private int mPageNo = 1;
    private RecyclerView mSiteListRecyclerview;
    private View mSliptView;
    private TextView mTabFirstTv;
    private List<TabLine> mTabLineList = new ArrayList();
    private TextView mTabSecondTv;
    private TextView mTitleTV;
    private int mTopAnimValueY;
    private ImageView mTopIv;
    private String mVenueId;
    private VenueViewModel mVenueViewModel;
    private RelativeLayout mllVenuelayout;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "635711335")) {
                ipChange.ipc$dispatch("635711335", new Object[]{this, view});
                return;
            }
            VenueActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1547965592")) {
                ipChange.ipc$dispatch("-1547965592", new Object[]{this, view});
            } else if (VenueActivity.this.mSiteListRecyclerview == null) {
            } else {
                if (VenueActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition() > 50) {
                    jg.e(VenueActivity.this.mTopIv, VenueActivity.this.mTopAnimValueY);
                    VenueActivity.this.mLinearLayoutManager.scrollToPosition(0);
                    return;
                }
                VenueActivity.this.mSiteListRecyclerview.smoothScrollToPosition(0);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2041446835")) {
                ipChange.ipc$dispatch("2041446835", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (VenueActivity.this.mCurrentTab != 1) {
                VenueActivity.this.mVenueViewModel.setQueryRequest(VenueActivity.this.mPageNo, VenueActivity.this.mCityId, VenueActivity.this.mCityName, VenueActivity.this.mVenueId, 0);
            } else {
                VenueActivity.this.mVenueViewModel.setQueryRequest(VenueActivity.this.mPageNo, VenueActivity.this.mCityId, VenueActivity.this.mCityName, VenueActivity.this.mVenueId, 1);
            }
            VenueActivity.this.startProgressDialog();
        }
    }

    static /* synthetic */ int access$908(VenueActivity venueActivity) {
        int i = venueActivity.mPageNo;
        venueActivity.mPageNo = i + 1;
        return i;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427244849")) {
            ipChange.ipc$dispatch("-427244849", new Object[]{this});
            return;
        }
        startProgressDialog();
        setRequest(1);
        this.mVenueViewModel.getToastEvent().observe(this, new Observer<String>() {
            /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-402939962")) {
                    ipChange.ipc$dispatch("-402939962", new Object[]{this, str});
                    return;
                }
                VenueActivity.this.stopProgressDialog();
                if (VenueActivity.this.mPageNo == 1) {
                    VenueActivity.this.onResponseError(str, str, "mtop.damai.wireless.search.venue.search");
                }
                VenueActivity.this.stopProgressDialog();
            }
        });
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578594123")) {
            ipChange.ipc$dispatch("-1578594123", new Object[]{this});
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mSiteListRecyclerview.setLayoutManager(this.mLinearLayoutManager);
        VenueItemAdapter venueItemAdapter = new VenueItemAdapter(getApplicationContext());
        this.mAdapter = venueItemAdapter;
        this.mSiteListRecyclerview.setAdapter(venueItemAdapter);
    }

    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1876164839")) {
            return recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange();
        }
        return ((Boolean) ipChange.ipc$dispatch("1876164839", new Object[]{recyclerView})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setLineRed(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585445714")) {
            ipChange.ipc$dispatch("-585445714", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        startLineAnim(i2, i);
        if (i == 1) {
            this.mTabFirstTv.setTextColor(getResources().getColor(R$color.color_000000));
            this.mTabSecondTv.setTextColor(getResources().getColor(R$color.color_999999));
        } else if (i == 2) {
            this.mTabFirstTv.setTextColor(getResources().getColor(R$color.color_999999));
            this.mTabSecondTv.setTextColor(getResources().getColor(R$color.color_000000));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRequest(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77086855")) {
            ipChange.ipc$dispatch("77086855", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        VenueViewModel venueViewModel = new VenueViewModel(this);
        this.mVenueViewModel = venueViewModel;
        venueViewModel.setQueryRequest(this.mPageNo, this.mCityId, this.mCityName, this.mVenueId, i);
        this.mVenueViewModel.getQueryBean().observe(this, new Observer<VenueQueryResponse>() {
            /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable VenueQueryResponse venueQueryResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1900765478")) {
                    ipChange.ipc$dispatch("1900765478", new Object[]{this, venueQueryResponse});
                    return;
                }
                if (venueQueryResponse != null) {
                    VenueActivity.this.onResponseSuccess();
                    if (venueQueryResponse.venuesVoList.size() > 0) {
                        VenueActivity.this.loadingMore = Integer.parseInt(venueQueryResponse.total) > VenueActivity.this.mPageNo * 20;
                        if (VenueActivity.this.mPageNo != 1) {
                            VenueActivity.this.mAdapter.e(venueQueryResponse.venuesVoList, VenueActivity.this.mVenueId, VenueActivity.this.mCityName, VenueActivity.this.mCurrentTab);
                        } else {
                            VenueActivity.this.mAdapter.h(venueQueryResponse.venuesVoList, VenueActivity.this.mVenueId, VenueActivity.this.mCityName, VenueActivity.this.mCurrentTab);
                        }
                        VenueActivity.this.stopProgressDialog();
                    } else {
                        VenueActivity.this.stopProgressDialog();
                    }
                } else {
                    VenueActivity.this.isLoading = false;
                    VenueActivity.this.stopProgressDialog();
                }
                VenueActivity.this.isLoading = false;
                VenueActivity.this.mSiteListRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass8.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2138043705")) {
                            ipChange.ipc$dispatch("-2138043705", new Object[]{this, recyclerView, Integer.valueOf(i)});
                            return;
                        }
                        super.onScrollStateChanged(recyclerView, i);
                        if (recyclerView.canScrollVertically(-1)) {
                            VenueActivity.this.mSliptView.setVisibility(0);
                        } else {
                            VenueActivity.this.mSliptView.setVisibility(8);
                        }
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        if (i == 0 && VenueActivity.isSlideToBottom(recyclerView) && !VenueActivity.this.isLoading && VenueActivity.this.loadingMore) {
                            VenueActivity.access$908(VenueActivity.this);
                            VenueActivity.this.mVenueViewModel.setQueryRequest(VenueActivity.this.mPageNo, VenueActivity.this.mCityId, VenueActivity.this.mCityName, VenueActivity.this.mVenueId, i);
                            VenueActivity.this.isLoading = true;
                        }
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-230203016")) {
                            ipChange.ipc$dispatch("-230203016", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                            return;
                        }
                        super.onScrolled(recyclerView, i, i2);
                        int findFirstVisibleItemPosition = VenueActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition();
                        VenueActivity.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                        if (VenueActivity.this.mFirstVisibleItems < 0) {
                            VenueActivity.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                            VenueActivity venueActivity = VenueActivity.this;
                            venueActivity.mFirstVisibleItemCount = venueActivity.mLinearLayoutManager.getChildCount();
                        }
                        VenueActivity.this.setTopVisible(findFirstVisibleItemPosition);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTopVisible(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1288255873")) {
            ipChange.ipc$dispatch("1288255873", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= this.mFirstVisibleItemCount) {
            if (this.mTopIv.getVisibility() != 0) {
                jg.d(this.mTopIv, this.mTopAnimValueY);
            }
        } else if (this.mTopIv.getVisibility() != 8) {
            jg.e(this.mTopIv, this.mTopAnimValueY);
        }
    }

    private void startLineAnim(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258943142")) {
            ipChange.ipc$dispatch("-258943142", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        TabLine tabLine = this.mTabLineList.get(i - 1);
        TabLine tabLine2 = this.mTabLineList.get(i2 - 1);
        this.mLineTab.startAnim((float) tabLine.left, (float) tabLine.right, (float) tabLine2.left, (float) tabLine2.right);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1604147399")) {
            return R$layout.category_venue_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-1604147399", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50960542")) {
            ipChange.ipc$dispatch("-50960542", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mCurrentTab != 1) {
            this.mVenueViewModel.setQueryRequest(this.mPageNo, this.mCityId, this.mCityName, this.mVenueId, 0);
        } else {
            this.mVenueViewModel.setQueryRequest(this.mPageNo, this.mCityId, this.mCityName, this.mVenueId, 1);
        }
        startProgressDialog();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416211980")) {
            ipChange.ipc$dispatch("-1416211980", new Object[]{this});
            return;
        }
        super.initView();
        removeHeadTitleView();
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
            ne2.f(this, true, R$color.black);
        } else {
            ne2.f(this, false, R$color.black);
            findViewById.setVisibility(8);
        }
        findViewById(R$id.btn_left).setOnClickListener(new a());
        setDamaiUTKeyBuilder(new a.b().i("venue"));
        Intent intent = getIntent();
        if (intent != null) {
            this.mCityId = intent.getStringExtra("cityId");
            this.mVenueId = intent.getStringExtra(VenueDetailFragment.VENUE_ID);
            this.mCityName = intent.getStringExtra(RankSquareCMSActivity.PRESET_CITY_NAME);
        }
        this.mSiteListRecyclerview = (RecyclerView) findViewById(R$id.venue_list_recyclerview);
        this.mllVenuelayout = (RelativeLayout) findViewById(R$id.ll_venue_layout);
        this.mTopIv = (ImageView) findViewById(R$id.iv_top);
        this.mLineTab = (ScrollLineView) findViewById(R$id.line_tab);
        TextView textView = (TextView) findViewById(R$id.tv_title);
        this.mTitleTV = textView;
        textView.setText(ErrControlViewInfo.TYPE_VENUE);
        this.mTabFirstTv = (TextView) findViewById(R$id.tv_tab_first);
        this.mTabSecondTv = (TextView) findViewById(R$id.tv_tab_second);
        this.mTabFirstTv.setOnClickListener(this);
        this.mTabSecondTv.setOnClickListener(this);
        this.mTopIv.setOnClickListener(new b());
        this.mTopAnimValueY = n42.a(this, 20.0f);
        initData();
        initRecyclerView();
        this.mTabFirstTv.post(new Runnable() {
            /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-578797977")) {
                    ipChange.ipc$dispatch("-578797977", new Object[]{this});
                    return;
                }
                VenueActivity.this.mTabLineList.add(new TabLine(VenueActivity.this.mTabFirstTv.getLeft(), VenueActivity.this.mTabFirstTv.getRight()));
                VenueActivity.this.mTabLineList.add(new TabLine(VenueActivity.this.mTabSecondTv.getLeft(), VenueActivity.this.mTabSecondTv.getRight()));
                VenueActivity.this.mCurrentTab = 1;
                VenueActivity venueActivity = VenueActivity.this;
                venueActivity.setLineRed(venueActivity.mCurrentTab, VenueActivity.this.mCurrentTab);
            }
        });
        this.mSliptView = findViewById(R$id.view_slipt);
        if (!TextUtils.isEmpty(y6.a())) {
            y6.d(findViewById(R$id.venue_activity_title));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081370330")) {
            ipChange.ipc$dispatch("1081370330", new Object[]{this, view});
        } else if (view.getId() == R$id.tv_tab_first) {
            int i = this.mCurrentTab;
            if (i != 1) {
                setLineRed(1, i);
                this.mCurrentTab = 1;
                this.mPageNo = 1;
                new Handler().postDelayed(new Runnable() {
                    /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass6 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1168338492")) {
                            ipChange.ipc$dispatch("-1168338492", new Object[]{this});
                            return;
                        }
                        VenueActivity.this.setRequest(1);
                        VenueActivity.this.startProgressDialog();
                    }
                }, 400);
                HashMap hashMap = new HashMap();
                hashMap.put("city", this.mCityName);
                cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e("venue", "venuetab", "nearbybtn", hashMap, Boolean.FALSE));
            }
        } else if (view.getId() == R$id.tv_tab_second) {
            setLineRed(2, this.mCurrentTab);
            this.mCurrentTab = 2;
            this.mPageNo = 1;
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.category.venue.activity.VenueActivity.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1364851997")) {
                        ipChange.ipc$dispatch("-1364851997", new Object[]{this});
                        return;
                    }
                    VenueActivity.this.setRequest(0);
                    VenueActivity.this.startProgressDialog();
                }
            }, 400);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("city", this.mCityName);
            cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e("venue", "venuetab", "hotbtn", hashMap2, Boolean.FALSE));
        }
    }

    /* access modifiers changed from: protected */
    public void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127571977")) {
            ipChange.ipc$dispatch("-2127571977", new Object[]{this, str, str2, str3});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new c());
            if (this.mllVenuelayout instanceof ViewGroup) {
                this.mllVenuelayout.addView(this.mErrorPage, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296423426")) {
            ipChange.ipc$dispatch("-296423426", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                RelativeLayout relativeLayout = this.mllVenuelayout;
                if (relativeLayout instanceof ViewGroup) {
                    relativeLayout.removeView(this.mErrorPage);
                }
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1581320723")) {
            return ErrControlViewInfo.TYPE_VENUE;
        }
        return (String) ipChange.ipc$dispatch("-1581320723", new Object[]{this});
    }
}
