package cn.damai.category.category.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.CategoryStarBean;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.StarBaseBean;
import cn.damai.category.category.bean.StarBean;
import cn.damai.category.category.bean.ToursBean;
import cn.damai.category.category.bean.ToursCityBean;
import cn.damai.category.category.model.CategoryModel;
import cn.damai.category.category.request.StarRequest;
import cn.damai.category.category.ui.adapter.StarListAdapter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ce2;
import tb.d20;
import tb.gr;
import tb.kg;
import tb.tb2;
import tb.u71;
import tb.v50;
import tb.wz1;

/* compiled from: Taobao */
public class StarFragment extends Fragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_FOLLOW = "follow";
    public static final int REQUEST_CODE = 1006;
    public Daojishi daojishi = new Daojishi();
    private boolean hasFollowData = false;
    private DamaiBaseActivity mActivity;
    private StarListAdapter mAdapter;
    private View.OnClickListener mCityProjectClickListener = new g();
    private View mEmptyFoot;
    private TextView mEmptyTip;
    private View mEmptyView;
    private ResponseErrorPage mErrorPage;
    private int mFirstVisibleItemCount;
    private int mFirstVisibleItems = -1;
    private int mFollowIndex = 0;
    private View.OnClickListener mFollowListener = new e();
    private View mGoTopView;
    private boolean mHasNextPage = true;
    private boolean mIsFirst = true;
    private boolean mIsFollow = false;
    private FrameLayout mLayout;
    private View mLineView;
    private LinearLayoutManager mLinearLayoutManager;
    private CategoryModel mModel;
    private ResponseErrorPage mNoLoginLayout;
    private View.OnClickListener mProjectItemListener = new f();
    private IRecyclerView mRecyclerView;
    private View.OnClickListener mStarItemListener = new d();
    public StarRequest mStarRequest = new StarRequest();
    private String mType = "推荐";
    private View mView;

    /* compiled from: Taobao */
    public class a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-638269673")) {
                ipChange.ipc$dispatch("-638269673", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            StarFragment.this.mActivity.startProgressDialog();
            StarFragment.this.getRequest();
        }
    }

    /* compiled from: Taobao */
    public class b implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1790179075")) {
                ipChange.ipc$dispatch("-1790179075", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            LoginManager.k().x(StarFragment.this.mActivity, new Intent(), 1006);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2124081865")) {
                ipChange.ipc$dispatch("-2124081865", new Object[]{this, view});
                return;
            }
            StarFragment.this.mRecyclerView.smoothScrollToPosition(0);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            StarBean starBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-12791496")) {
                ipChange.ipc$dispatch("-12791496", new Object[]{this, view});
                return;
            }
            try {
                StarAndBrandItem starAndBrandItem = (StarAndBrandItem) view.getTag();
                if (starAndBrandItem != null && (starBean = starAndBrandItem.starBean) != null) {
                    if (starBean.type == 5) {
                        Bundle bundle = new Bundle();
                        bundle.putString(RepertoireDetailFragment.REPERTOIREID, starAndBrandItem.starBean.damaiId);
                        DMNav.from(StarFragment.this.mActivity).withExtras(bundle).toUri(NavUri.b(wz1.REPERTOITE));
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(FeedsViewModel.ARG_USERID, starAndBrandItem.starBean.damaiId);
                        bundle2.putString("usertype", starAndBrandItem.starBean.type + "");
                        DMNav.from(StarFragment.this.mActivity).withExtras(bundle2).toUri(NavUri.b(gr.ARTISTID_THEME));
                    }
                    ce2.h(StarFragment.this.mIsFollow, starAndBrandItem.index, d20.E(), starAndBrandItem.starBean.damaiId, StarFragment.this.mType);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2098498873")) {
                ipChange.ipc$dispatch("2098498873", new Object[]{this, view});
                return;
            }
            try {
                StarAndBrandItem starAndBrandItem = (StarAndBrandItem) view.getTag();
                if (starAndBrandItem != null && starAndBrandItem.starBean != null) {
                    StarFragment.this.mFollowIndex = starAndBrandItem.position;
                    StarFragment.this.mActivity.startProgressDialog();
                    CategoryModel categoryModel = StarFragment.this.mModel;
                    String str = starAndBrandItem.starBean.damaiId;
                    categoryModel.followRequest("1", str, starAndBrandItem.starBean.type + "");
                    ce2.f(StarFragment.this.mIsFollow, starAndBrandItem.index, d20.E(), starAndBrandItem.starBean.damaiId, "1");
                }
            } catch (Exception unused) {
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
            if (AndroidInstantRuntime.support(ipChange, "-85178054")) {
                ipChange.ipc$dispatch("-85178054", new Object[]{this, view});
                return;
            }
            try {
                StarAndBrandItem starAndBrandItem = (StarAndBrandItem) view.getTag();
                if (starAndBrandItem != null && starAndBrandItem.projectItemBean != null) {
                    ce2.g(StarFragment.this.mIsFollow, starAndBrandItem.index, d20.E(), starAndBrandItem.projectItemBean.id, StarFragment.this.mType);
                    DamaiBaseActivity damaiBaseActivity = StarFragment.this.mActivity;
                    ProjectItemBean projectItemBean = starAndBrandItem.projectItemBean;
                    tb2.b(damaiBaseActivity, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2026112315")) {
                ipChange.ipc$dispatch("2026112315", new Object[]{this, view});
                return;
            }
            try {
                ToursCityBean toursCityBean = (ToursCityBean) view.getTag();
                if (toursCityBean != null && !TextUtils.isEmpty(toursCityBean.projectId)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(IssueConstants.ProjectID, toursCityBean.projectId);
                    tb2.a(StarFragment.this.mActivity, toursCityBean.schema, bundle);
                    ce2.i(StarFragment.this.mIsFollow, toursCityBean.cardIndex, toursCityBean.index, d20.E(), toursCityBean.projectId, StarFragment.this.mType);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<StarAndBrandItem> getAllList(CategoryStarBean categoryStarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687483890")) {
            return (List) ipChange.ipc$dispatch("-687483890", new Object[]{this, categoryStarBean});
        }
        List<StarBaseBean> list = categoryStarBean.combines;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            StarBaseBean starBaseBean = list.get(i);
            if (starBaseBean != null) {
                if (starBaseBean.artistVO != null) {
                    StarAndBrandItem starAndBrandItem = new StarAndBrandItem();
                    starAndBrandItem.index = i;
                    starAndBrandItem.starBean = starBaseBean.artistVO;
                    starAndBrandItem.type = 2;
                    arrayList.add(starAndBrandItem);
                }
                if (!u71.a(starBaseBean.performanceInfo)) {
                    ProjectItemBean projectItemBean = starBaseBean.performanceInfo.get(0);
                    if (projectItemBean != null) {
                        StarAndBrandItem starAndBrandItem2 = new StarAndBrandItem();
                        starAndBrandItem2.index = i;
                        if (!u71.a(projectItemBean.videos)) {
                            starAndBrandItem2.type = 11;
                        } else {
                            starAndBrandItem2.type = 4;
                        }
                        starAndBrandItem2.projectItemBean = projectItemBean;
                        arrayList.add(starAndBrandItem2);
                    }
                }
                ToursBean toursBean = starBaseBean.tourVo;
                if (toursBean != null && !u71.a(toursBean.tourProjects)) {
                    StarAndBrandItem starAndBrandItem3 = new StarAndBrandItem();
                    starAndBrandItem3.type = 12;
                    starAndBrandItem3.index = i;
                    starAndBrandItem3.toursBean = starBaseBean.tourVo;
                    if (!u71.a(starBaseBean.performanceInfo)) {
                        starAndBrandItem3.projectItemBean = starBaseBean.performanceInfo.get(0);
                    }
                    arrayList.add(starAndBrandItem3);
                }
            }
        }
        return arrayList;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804561821")) {
            ipChange.ipc$dispatch("804561821", new Object[]{this});
            return;
        }
        CategoryModel categoryModel = new CategoryModel(this.mActivity);
        this.mModel = categoryModel;
        categoryModel.getCategoryStarBean().observe(this, new Observer<CategoryStarBean>() {
            /* class cn.damai.category.category.ui.StarFragment.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable CategoryStarBean categoryStarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1090996459")) {
                    ipChange.ipc$dispatch("-1090996459", new Object[]{this, categoryStarBean});
                    return;
                }
                StarFragment.this.mActivity.stopProgressDialog();
                StarFragment.this.mRecyclerView.setRefreshing(false);
                StarFragment.this.stopBottomProgress();
                if (categoryStarBean == null) {
                    StarRequest starRequest = StarFragment.this.mStarRequest;
                    if (starRequest != null) {
                        kg.c(JSON.toJSONString(starRequest));
                    }
                    StarFragment.this.onResponseError();
                    return;
                }
                Daojishi daojishi = StarFragment.this.daojishi;
                if (daojishi != null && daojishi.serverTime == 0) {
                    daojishi.setServiceTimeAndDiff(categoryStarBean.currentTime);
                }
                StarFragment.this.onResponseSuccess();
                if (StarFragment.this.mIsFollow) {
                    StarFragment.this.hasFollowData = true;
                }
                StarFragment.this.mHasNextPage = categoryStarBean.hasNext;
                if (StarFragment.this.mIsFirst) {
                    if (u71.a(categoryStarBean.combines)) {
                        StarFragment.this.setEmptyTip();
                        StarFragment.this.mAdapter.b(null, StarFragment.this.daojishi);
                        return;
                    }
                    StarFragment.this.mAdapter.c(true);
                    StarFragment.this.mAdapter.b(StarFragment.this.getAllList(categoryStarBean), StarFragment.this.daojishi);
                    StarFragment.this.mRecyclerView.postDelayed(new Runnable() {
                        /* class cn.damai.category.category.ui.StarFragment.AnonymousClass8.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-956036985")) {
                                ipChange.ipc$dispatch("-956036985", new Object[]{this});
                            } else if (StarFragment.this.isAdded() && !StarFragment.this.mActivity.isFinishing()) {
                                StarFragment.this.mAdapter.c(false);
                            }
                        }
                    }, 500);
                    StarFragment.this.mIsFirst = false;
                } else if (!u71.a(categoryStarBean.combines)) {
                    StarFragment.this.mAdapter.a(StarFragment.this.getAllList(categoryStarBean));
                }
                StarFragment.this.startTimer();
                StarFragment.this.mEmptyView.setVisibility(8);
            }
        });
        this.mModel.getFollowDataBean().observe(this, new Observer<FollowDataBean>() {
            /* class cn.damai.category.category.ui.StarFragment.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2121822348")) {
                    ipChange.ipc$dispatch("2121822348", new Object[]{this, followDataBean});
                    return;
                }
                StarFragment.this.mActivity.stopProgressDialog();
                if (followDataBean == null || followDataBean.getStatus() != 1) {
                    ToastUtil.f("关注失败");
                    return;
                }
                ToastUtil.f("关注成功");
                StarFragment.this.mAdapter.d(StarFragment.this.mFollowIndex);
            }
        });
        getRequest();
    }

    private void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889644484")) {
            ipChange.ipc$dispatch("1889644484", new Object[]{this});
            return;
        }
        this.mFirstVisibleItems = -1;
        this.mFirstVisibleItemCount = 0;
        this.mStarRequest = new StarRequest();
        this.mIsFirst = true;
        this.mIsFollow = false;
        this.mHasNextPage = true;
        this.mFollowIndex = 0;
        this.mType = "推荐";
    }

    private void resetPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985812683")) {
            ipChange.ipc$dispatch("-1985812683", new Object[]{this});
            return;
        }
        this.mStarRequest.pageNumber = 1;
        this.mIsFirst = true;
        this.mHasNextPage = true;
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEmptyTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "681738339")) {
            ipChange.ipc$dispatch("681738339", new Object[]{this});
            return;
        }
        this.mEmptyView.setVisibility(0);
        if (this.mIsFollow) {
            this.mEmptyTip.setText("你还没有关注的大咖哦(-.-)");
        } else {
            this.mEmptyTip.setText("这里空空如也(-.-)");
        }
    }

    public void getFollowRequestIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625216516")) {
            ipChange.ipc$dispatch("-1625216516", new Object[]{this});
        } else if (!this.hasFollowData) {
            getRequest();
        }
    }

    public void getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308030658")) {
            ipChange.ipc$dispatch("-1308030658", new Object[]{this});
        } else if (!this.mIsFollow) {
            requestStar();
        } else if (!LoginManager.k().q()) {
            showNoLogin();
        } else {
            requestStar();
        }
    }

    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184405310")) {
            ipChange.ipc$dispatch("-184405310", new Object[]{this});
            return;
        }
        this.mLayout = (FrameLayout) this.mView.findViewById(R$id.layout_star);
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.mActivity, 7, "", "", "");
        this.mNoLoginLayout = responseErrorPage;
        responseErrorPage.setLeftBtnVisibility(8);
        this.mLayout.addView(this.mNoLoginLayout);
        this.mNoLoginLayout.setRefreshListener(new b());
        this.mLineView = this.mView.findViewById(R$id.view_line);
        this.mEmptyView = this.mView.findViewById(R$id.ll_empty);
        this.mEmptyTip = (TextView) this.mView.findViewById(R$id.tv_empty_tip);
        this.mAdapter = new StarListAdapter(this.mIsFollow, this.mActivity, this.mType, this.mStarItemListener, this.mFollowListener, this.mProjectItemListener, this.mCityProjectClickListener);
        this.mEmptyFoot = LayoutInflater.from(this.mActivity).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(this.mActivity, 110.0f)));
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView = (IRecyclerView) this.mView.findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this.mActivity, 100, false, R$color.color_ffffff));
        this.mRecyclerView.addFooterView(this.mEmptyFoot);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.category.category.ui.StarFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1585978653")) {
                    ipChange.ipc$dispatch("1585978653", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                int findFirstVisibleItemPosition = StarFragment.this.mLinearLayoutManager.findFirstVisibleItemPosition();
                if (StarFragment.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    StarFragment.this.mLineView.setVisibility(8);
                } else {
                    StarFragment.this.mLineView.setVisibility(0);
                }
                if (StarFragment.this.mFirstVisibleItems < 0) {
                    StarFragment.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                    StarFragment starFragment = StarFragment.this;
                    starFragment.mFirstVisibleItemCount = starFragment.mLinearLayoutManager.getChildCount();
                }
                if (findFirstVisibleItemPosition >= StarFragment.this.mFirstVisibleItemCount) {
                    StarFragment.this.mGoTopView.setVisibility(0);
                } else {
                    StarFragment.this.mGoTopView.setVisibility(8);
                }
            }
        });
        View findViewById = this.mView.findViewById(R$id.image_gotop);
        this.mGoTopView = findViewById;
        findViewById.setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647207860")) {
            return (View) ipChange.ipc$dispatch("-1647207860", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.category_star_fragment, (ViewGroup) null);
        this.mActivity = (DamaiBaseActivity) getActivity();
        reset();
        if (getArguments() != null) {
            boolean z = getArguments().getBoolean(KEY_FOLLOW, false);
            this.mIsFollow = z;
            if (!z) {
                this.mType = "推荐";
            } else {
                this.mType = "我关注的";
            }
        }
        initView();
        initData();
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-82323080")) {
            ipChange.ipc$dispatch("-82323080", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mLayout = null;
        this.mView = null;
        this.mEmptyView = null;
        IRecyclerView iRecyclerView = this.mRecyclerView;
        if (iRecyclerView != null) {
            iRecyclerView.clearOnScrollListeners();
            this.mRecyclerView.setOnRefreshListener(null);
            this.mRecyclerView.setOnLoadMoreListener(null);
            this.mRecyclerView = null;
        }
        this.mAdapter.b(null, null);
        this.mAdapter = null;
        this.mModel = null;
        Daojishi daojishi2 = this.daojishi;
        if (daojishi2 != null) {
            daojishi2.stopTimer();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170826731")) {
            ipChange.ipc$dispatch("-1170826731", new Object[]{this, view});
        } else if (this.mHasNextPage) {
            showBottomLoadMore();
            this.mStarRequest.pageNumber++;
            getRequest();
        } else {
            showBottonEmpty();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864241417")) {
            ipChange.ipc$dispatch("-1864241417", new Object[]{this});
            return;
        }
        resetPage();
        getRequest();
    }

    /* access modifiers changed from: protected */
    public void onResponseError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2066713163")) {
            ipChange.ipc$dispatch("2066713163", new Object[]{this});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this.mActivity, null, null, null);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new a());
            this.mLayout.addView(this.mErrorPage);
        }
    }

    /* access modifiers changed from: protected */
    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480373008")) {
            ipChange.ipc$dispatch("-480373008", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mLayout.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void requestStar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861123118")) {
            ipChange.ipc$dispatch("-1861123118", new Object[]{this});
            return;
        }
        this.mNoLoginLayout.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mActivity.startProgressDialog();
        StarRequest starRequest = this.mStarRequest;
        starRequest.hasFollowed = this.mIsFollow;
        starRequest.sourceId = d20.E();
        this.mModel.getStarRequest(this.mStarRequest);
    }

    public void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544702548")) {
            ipChange.ipc$dispatch("544702548", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542468655")) {
            ipChange.ipc$dispatch("1542468655", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
        this.mHasNextPage = false;
    }

    public void showNoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921845080")) {
            ipChange.ipc$dispatch("-1921845080", new Object[]{this});
            return;
        }
        this.mNoLoginLayout.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
    }

    public void startTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298210644")) {
            ipChange.ipc$dispatch("1298210644", new Object[]{this});
            return;
        }
        Daojishi daojishi2 = this.daojishi;
        if (daojishi2 != null) {
            daojishi2.startTimer();
        }
    }

    public void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1272208419")) {
            ipChange.ipc$dispatch("-1272208419", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }
}
