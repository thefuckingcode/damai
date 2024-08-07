package cn.damai.homepage.girl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.homepage.girl.request.SearchListRequest;
import cn.damai.homepage.girl.request.ShowGirlRequest;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.girl.bean.CategoryGirlParam;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.adapter.AbsAdapter;
import cn.damai.tetris.core.adapter.VerticalAdapter;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.impl.adapter.SearchAdapter;
import cn.damai.tetris.page.AbsFragment;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.d20;
import tb.kv2;
import tb.os0;
import tb.w9;
import tb.wk;

/* compiled from: Taobao */
public class GirlFragment extends AbsFragment implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_BDIAN = "bdian";
    public static final String KEY_TITLE = "title";
    Map<String, String> arg;
    private String mBdian = "xiannv_tab";
    private boolean mFirstList = true;
    private boolean mIsChangeCity;
    private boolean mIsCreateView;
    private SearchAdapter mSearchAdapter;
    private String mTitle;
    public a.b mUTBuilder;
    private int pageIndex = 1;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1731584756")) {
                ipChange.ipc$dispatch("1731584756", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = null;
            try {
                projectItemBean = (ProjectItemBean) view.getTag();
            } catch (Exception unused) {
            }
            if (projectItemBean != null) {
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                bundle.putString("projectName", projectItemBean.name);
                bundle.putString("projectImage", projectItemBean.verticalPic);
                DMNav.from(GirlFragment.this.getActivity()).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
                c.e().x(os0.f().g(projectItemBean.pos, "仙女推荐", projectItemBean.id));
            }
        }
    }

    static /* synthetic */ int access$208(GirlFragment girlFragment) {
        int i = girlFragment.pageIndex;
        girlFragment.pageIndex = i + 1;
        return i;
    }

    private void clearList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818633559")) {
            ipChange.ipc$dispatch("-818633559", new Object[]{this});
            return;
        }
        this.mFirstList = true;
        this.pageIndex = 1;
    }

    private void fetchGirlListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756698454")) {
            ipChange.ipc$dispatch("756698454", new Object[]{this});
            return;
        }
        startProgressDialog();
        ShowGirlRequest showGirlRequest = new ShowGirlRequest();
        CategoryGirlParam categoryGirlParam = new CategoryGirlParam();
        categoryGirlParam.cityId = d20.c();
        showGirlRequest.args = JSON.toJSONString(categoryGirlParam);
        showGirlRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.homepage.girl.GirlFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "800501596")) {
                    ipChange.ipc$dispatch("800501596", new Object[]{this, str, str2});
                    return;
                }
                GirlFragment.this.stopProgressDialog();
                GirlFragment.this.showErrorView();
                Toast.makeText(GirlFragment.this.getBaseContext().getActivity(), str2, 0).show();
            }

            public void onSuccess(BaseResponse baseResponse) {
                String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1186623828")) {
                    ipChange.ipc$dispatch("-1186623828", new Object[]{this, baseResponse});
                    return;
                }
                GirlFragment.this.mIsChangeCity = false;
                GirlFragment.this.stopProgressDialog();
                GlobalConfig globalConfig = baseResponse.globalConfig;
                if (globalConfig != null) {
                    str = globalConfig.pageName;
                    GirlFragment.this.updateB(baseResponse);
                } else {
                    str = "";
                }
                GirlFragment.this.refreshFinish();
                GirlFragment.this.hideErrorView();
                BaseLayer baseLayer = new BaseLayer();
                NodeData nodeData = new NodeData();
                nodeData.put("title", (Object) "为仙女你推荐");
                baseLayer.setNodeData(nodeData);
                baseResponse.layers.add(baseLayer);
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i = 0; i < baseResponse.layers.size(); i++) {
                        if (baseResponse.layers.get(i).getFirstSection() != null) {
                            BaseLayer baseLayer2 = baseResponse.layers.get(i);
                            TrackInfo trackInfo = GirlFragment.this.getTrackInfo(str, baseLayer2, new TrackInfo());
                            if ("category_banner".equals(baseLayer2.getFirstSection().getComponentId())) {
                                trackInfo.put("title", (Object) GirlFragment.this.mTitle);
                            }
                            trackInfo.put("cityId", (Object) d20.c());
                            baseLayer2.getFirstSection().setTrackInfo(trackInfo);
                        }
                    }
                    GirlFragment.this.setData(baseResponse.layers);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private TrackInfo getTrackInfo(String str, BaseLayer baseLayer, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1585460171")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1585460171", new Object[]{this, str, baseLayer, trackInfo});
        }
        if (baseLayer.getFirstSection().getTrackInfo() != null) {
            trackInfo = baseLayer.getFirstSection().getTrackInfo();
        }
        trackInfo.trackB = str;
        if (!TextUtils.isEmpty(trackInfo.getString("spmc"))) {
            trackInfo.trackC = trackInfo.getString("spmc");
        }
        return trackInfo;
    }

    public static GirlFragment newInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477497461")) {
            return (GirlFragment) ipChange.ipc$dispatch("-477497461", new Object[]{str, str2});
        }
        GirlFragment girlFragment = new GirlFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString(KEY_BDIAN, str2);
        girlFragment.setArguments(bundle);
        return girlFragment;
    }

    private void requestProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987454316")) {
            ipChange.ipc$dispatch("987454316", new Object[]{this});
            return;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.pageIndex = this.pageIndex;
        searchListRequest.groupId = "1|2|3|4|5";
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.homepage.girl.GirlFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "808260955")) {
                    ipChange.ipc$dispatch("808260955", new Object[]{this, str, str2});
                    return;
                }
                GirlFragment.this.hideLoadMore();
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                List<ProjectItemBean> list;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1877348219")) {
                    ipChange.ipc$dispatch("1877348219", new Object[]{this, searchResultBean});
                    return;
                }
                GirlFragment.this.hideLoadMore();
                if (searchResultBean != null && (list = searchResultBean.projectInfo) != null && list.size() > 0) {
                    if (GirlFragment.this.mFirstList) {
                        GirlFragment.this.mSearchAdapter.setData(searchResultBean.projectInfo);
                        GirlFragment.this.mFirstList = false;
                    } else {
                        GirlFragment.this.mSearchAdapter.a(searchResultBean.projectInfo);
                    }
                    GirlFragment girlFragment = GirlFragment.this;
                    girlFragment.setExAdapter(girlFragment.mSearchAdapter);
                    GirlFragment.access$208(GirlFragment.this);
                    if (GirlFragment.this.mSearchAdapter.getItemCount() == searchResultBean.total) {
                        GirlFragment.this.disableLoadMore();
                    }
                }
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public AbsAdapter getAdapter(w9 w9Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1991981566")) {
            return new VerticalAdapter(w9Var, new kv2());
        }
        return (AbsAdapter) ipChange.ipc$dispatch("-1991981566", new Object[]{this, w9Var});
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130438460")) {
            ipChange.ipc$dispatch("2130438460", new Object[]{this});
            return;
        }
        fetchGirlListData();
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750760229")) {
            ipChange.ipc$dispatch("1750760229", new Object[]{this});
            return;
        }
        this.mIsChangeCity = true;
        if (isVisible()) {
            fetchGirlListData();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "533300555")) {
            return (View) ipChange.ipc$dispatch("533300555", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mIsCreateView = true;
        if (getArguments() != null) {
            this.mTitle = getArguments().getString("title", "");
            String string = getArguments().getString(KEY_BDIAN, "xiannv_tab");
            this.mBdian = string;
            os0.b = string;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471079399")) {
            ipChange.ipc$dispatch("-471079399", new Object[]{this});
            return;
        }
        this.mIsCreateView = false;
        super.onDestroy();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146738230")) {
            ipChange.ipc$dispatch("146738230", new Object[]{this, view});
            return;
        }
        showLoadMore();
        if (this.mSearchAdapter == null) {
            this.mSearchAdapter = new SearchAdapter(getActivity());
            TrackInfo trackInfo = new TrackInfo();
            trackInfo.trackB = this.mBdian;
            trackInfo.trackC = "xiannv_mustsee";
            trackInfo.trackD = "item_";
            trackInfo.put("titlelabel", (Object) "仙女推荐");
            this.mSearchAdapter.f(trackInfo);
            this.mSearchAdapter.d(new a());
        }
        requestProject();
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.page.AbsFragment
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849164723")) {
            ipChange.ipc$dispatch("849164723", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1) {
            ToastUtil a2 = ToastUtil.a();
            FragmentActivity activity = getActivity();
            a2.e(activity, "frag demo: " + obj.toString());
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041969560")) {
            ipChange.ipc$dispatch("2041969560", new Object[]{this});
            return;
        }
        fetchGirlListData();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997901706")) {
            ipChange.ipc$dispatch("1997901706", new Object[]{this});
            return;
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891644437")) {
            ipChange.ipc$dispatch("1891644437", new Object[]{this});
            return;
        }
        super.onStop();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633223346")) {
            ipChange.ipc$dispatch("633223346", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.mUTBuilder = new a.b().i(this.mBdian);
    }

    public void pageUtBuild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982294996")) {
            ipChange.ipc$dispatch("1982294996", new Object[]{this});
        } else if (this.mUTBuilder != null) {
            if (this.arg == null) {
                this.arg = new HashMap();
            }
            c.e().o(this, this.mUTBuilder.j(this.arg));
        }
    }

    public void setUTBuilder(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982524971")) {
            ipChange.ipc$dispatch("982524971", new Object[]{this, bVar});
            return;
        }
        this.mUTBuilder = bVar;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592277654")) {
            ipChange.ipc$dispatch("-592277654", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        if (isLazyLoaded && z && this.mIsChangeCity && this.mIsCreateView) {
            fetchGirlListData();
        }
    }
}
