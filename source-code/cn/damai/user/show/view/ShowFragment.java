package cn.damai.user.show.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.user.show.adapter.ShowAdapter;
import cn.damai.user.show.bean.ShowDataHolder;
import cn.damai.user.show.bean.ShowRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.p81;
import tb.tb2;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class ShowFragment extends BaseFragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ID = "id";
    public static final String TYPE = "type";
    private ShowAdapter mAdapter;
    private List<ShowDataHolder> mDataHolderList = new ArrayList();
    private View mEmptyFoot;
    private View mEmptyView;
    private String mId = "";
    private View.OnClickListener mItemClick = new a();
    private LinearLayoutManager mLinearLayoutManager;
    private int mPageIndex = 1;
    private int mPageSize = 15;
    private int mProjectAllSize = 0;
    private int mProjectSize = 0;
    private IRecyclerView mRecyclerView;
    private int mType = -1;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            ShowDataHolder showDataHolder;
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1101654142")) {
                ipChange.ipc$dispatch("-1101654142", new Object[]{this, view});
            } else if (view.getTag() != null) {
                try {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (intValue >= 0 && intValue < ShowFragment.this.mAdapter.getItemCount() && (showDataHolder = ShowFragment.this.mAdapter.getData().get(intValue)) != null && showDataHolder.mType == 0 && (projectItemBean = showDataHolder.mProjectItem) != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                        bundle.putString("projectName", projectItemBean.name);
                        bundle.putString("projectImage", projectItemBean.verticalPic);
                        bundle.putString("projectPrice", ShowFragment.this.getProjectPrice(projectItemBean.formattedPriceStr, projectItemBean.promotionPrice, projectItemBean.displayStatus));
                        tb2.a(ShowFragment.this.getActivity(), projectItemBean.schema, bundle);
                        HashMap hashMap = new HashMap();
                        hashMap.put("usercode", d20.E());
                        hashMap.put("biz_id", ShowFragment.this.mId);
                        hashMap.put("biz_type", ShowFragment.this.mType + "");
                        b bVar = new b();
                        c.e().x(bVar.e("business_homepage", "detials", "project_list_" + intValue, hashMap, Boolean.TRUE));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    static /* synthetic */ int access$010(ShowFragment showFragment) {
        int i = showFragment.mPageIndex;
        showFragment.mPageIndex = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getProjectPrice(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490975967")) {
            return (String) ipChange.ipc$dispatch("-490975967", new Object[]{this, str, str2, str3});
        } else if (!TextUtils.isEmpty(str3)) {
            return "";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                return String.format("%1$s%2$s", "¥", str2);
            }
            return String.format("%1$s%2$s", "¥", str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774827187")) {
            ipChange.ipc$dispatch("1774827187", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
    }

    public void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467900935")) {
            ipChange.ipc$dispatch("467900935", new Object[]{this});
            return;
        }
        ShowRequest showRequest = new ShowRequest();
        int i = this.mType;
        if (i == 2) {
            showRequest.artistId = this.mId;
        } else if (i == 3) {
            showRequest.venueId = this.mId;
        } else if (i == 4) {
            showRequest.brandId = this.mId;
        } else if (i == 5) {
            showRequest.repertoireId = this.mId;
        } else if (i == 9) {
            showRequest.categoryId = this.mId;
        }
        showRequest.distanceCityId = d20.c();
        showRequest.pageIndex = String.valueOf(this.mPageIndex);
        showRequest.pageSize = String.valueOf(this.mPageSize);
        double[] b = p81.b();
        if (b != null) {
            showRequest.longitude = String.valueOf(b[0]);
            showRequest.latitude = String.valueOf(b[1]);
        }
        showRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.user.show.view.ShowFragment.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2020918809")) {
                    ipChange.ipc$dispatch("-2020918809", new Object[]{this, str, str2});
                } else if (ShowFragment.this.mPageIndex > 1) {
                    ShowFragment.access$010(ShowFragment.this);
                } else {
                    ShowFragment.this.setEmptyView();
                }
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1588099695")) {
                    ipChange.ipc$dispatch("1588099695", new Object[]{this, searchResultBean});
                } else if (searchResultBean != null) {
                    int e = xf2.e(searchResultBean.projectInfo);
                    ShowFragment.this.mProjectSize += e;
                    if (ShowFragment.this.mPageIndex == 1 && ShowFragment.this.mProjectSize == 0) {
                        ShowFragment.this.setEmptyView();
                        return;
                    }
                    ShowFragment.this.mProjectAllSize = searchResultBean.total;
                    for (int i = 0; i < e; i++) {
                        ShowDataHolder showDataHolder = new ShowDataHolder(0);
                        showDataHolder.mProjectItem = searchResultBean.projectInfo.get(i);
                        showDataHolder.isRecommendProject = false;
                        ShowFragment.this.mDataHolderList.add(showDataHolder);
                    }
                    ShowFragment.this.mAdapter.notifyDataSetChanged();
                } else if (ShowFragment.this.mPageIndex == 1) {
                    ShowFragment.this.setEmptyView();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-918307188")) {
            return R$layout.fragment_show;
        }
        return ((Integer) ipChange.ipc$dispatch("-918307188", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165243345")) {
            ipChange.ipc$dispatch("-165243345", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471331058")) {
            ipChange.ipc$dispatch("-471331058", new Object[]{this});
            return;
        }
        if (getArguments() != null) {
            this.mType = getArguments().getInt("type", 0);
            this.mId = getArguments().getString("id", "");
        }
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        ShowAdapter showAdapter = new ShowAdapter(getContext(), this.mDataHolderList, this.mItemClick);
        this.mAdapter = showAdapter;
        this.mRecyclerView.setAdapter(showAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mEmptyFoot = LayoutInflater.from(getContext()).inflate(R$layout.feeds_footer_empty, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(getActivity(), 110.0f)));
        this.mRecyclerView.addFooterView(this.mEmptyFoot);
        this.mEmptyFoot.setVisibility(8);
        this.mEmptyView = this.rootView.findViewById(R$id.user_empty_view);
        this.mPageIndex = 1;
        getData();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335466868")) {
            ipChange.ipc$dispatch("335466868", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485153609")) {
            ipChange.ipc$dispatch("1485153609", new Object[]{this, view});
        } else if (this.mProjectAllSize > this.mProjectSize) {
            this.mEmptyFoot.setVisibility(8);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.mPageIndex++;
            getData();
        } else {
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            this.mEmptyFoot.setVisibility(0);
        }
    }
}
