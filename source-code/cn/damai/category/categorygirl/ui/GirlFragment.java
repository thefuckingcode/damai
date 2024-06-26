package cn.damai.category.categorygirl.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import cn.damai.category.category.bean.ConditionEntity;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.ui.CategoryActivity;
import cn.damai.category.categorygirl.request.SearchListRequest;
import cn.damai.category.categorygirl.request.ShowGirlRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
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
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.d20;
import tb.ig;
import tb.kv2;
import tb.tb2;
import tb.w9;

@Deprecated
/* compiled from: Taobao */
public class GirlFragment extends AbsFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CITY = "city";
    public static final String KEY_TITLE = "title";
    Map<String, String> arg;
    private CategoryActivity mActivity;
    private String mBdian = "xiannv_tab";
    private a.b mBuilder;
    private CategoryRepository mData;
    private boolean mFirstList = true;
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
            if (AndroidInstantRuntime.support(ipChange, "1675956379")) {
                ipChange.ipc$dispatch("1675956379", new Object[]{this, view});
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
                tb2.a(GirlFragment.this.mActivity, projectItemBean.schema, bundle);
                c.e().x(ig.m().r(projectItemBean.pos, "仙女推荐", projectItemBean.id));
            }
        }
    }

    static /* synthetic */ int access$308(GirlFragment girlFragment) {
        int i = girlFragment.pageIndex;
        girlFragment.pageIndex = i + 1;
        return i;
    }

    private void clearList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271433118")) {
            ipChange.ipc$dispatch("-271433118", new Object[]{this});
            return;
        }
        this.mFirstList = true;
        this.pageIndex = 1;
    }

    private void fetchGirlListData() {
        ConditionEntity conditionEntity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118066703")) {
            ipChange.ipc$dispatch("2118066703", new Object[]{this});
            return;
        }
        startProgressDialog();
        ShowGirlRequest showGirlRequest = new ShowGirlRequest();
        CategoryGirlParam categoryGirlParam = new CategoryGirlParam();
        CategoryRepository categoryRepository = this.mData;
        if (categoryRepository == null || (conditionEntity = categoryRepository.conditionEntity) == null) {
            categoryGirlParam.cityId = d20.c();
        } else {
            categoryGirlParam.cityId = conditionEntity.currentCityId;
        }
        categoryGirlParam.comboDamaiCityId = categoryGirlParam.cityId;
        showGirlRequest.args = JSON.toJSONString(categoryGirlParam);
        showGirlRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.category.categorygirl.ui.GirlFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1765519107")) {
                    ipChange.ipc$dispatch("1765519107", new Object[]{this, str, str2});
                    return;
                }
                GirlFragment.this.stopProgressDialog();
                GirlFragment.this.showErrorView();
                Toast.makeText(GirlFragment.this.getBaseContext().getActivity(), str2, 0).show();
            }

            public void onSuccess(BaseResponse baseResponse) {
                String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1831340763")) {
                    ipChange.ipc$dispatch("-1831340763", new Object[]{this, baseResponse});
                    return;
                }
                GirlFragment.this.stopProgressDialog();
                GlobalConfig globalConfig = baseResponse.globalConfig;
                if (globalConfig != null) {
                    str = globalConfig.pageName;
                    GirlFragment.this.updateSpmB(str, globalConfig.abBuckets);
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
                            if (!(GirlFragment.this.mData == null || GirlFragment.this.mData.conditionEntity == null)) {
                                trackInfo.put("cityId", (Object) GirlFragment.this.mData.conditionEntity.currentCityId);
                            }
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
        if (AndroidInstantRuntime.support(ipChange, "1861019502")) {
            return (TrackInfo) ipChange.ipc$dispatch("1861019502", new Object[]{this, str, baseLayer, trackInfo});
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

    public static GirlFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043015141")) {
            return (GirlFragment) ipChange.ipc$dispatch("-2043015141", new Object[]{str});
        }
        GirlFragment girlFragment = new GirlFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        girlFragment.setArguments(bundle);
        return girlFragment;
    }

    private void requestProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417884499")) {
            ipChange.ipc$dispatch("417884499", new Object[]{this});
            return;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.pageIndex = this.pageIndex;
        searchListRequest.groupId = "1|2|3|4|5";
        searchListRequest.distanceCityId = this.mData.conditionEntity.currentCityId;
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.category.categorygirl.ui.GirlFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1773278466")) {
                    ipChange.ipc$dispatch("1773278466", new Object[]{this, str, str2});
                    return;
                }
                GirlFragment.this.hideLoadMore();
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                List<ProjectItemBean> list;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "117648948")) {
                    ipChange.ipc$dispatch("117648948", new Object[]{this, searchResultBean});
                    return;
                }
                GirlFragment.this.hideLoadMore();
                if (searchResultBean != null && (list = searchResultBean.projectInfo) != null && list.size() > 0 && GirlFragment.this.mSearchAdapter != null) {
                    if (GirlFragment.this.mFirstList) {
                        GirlFragment.this.mSearchAdapter.setData(searchResultBean.projectInfo);
                        GirlFragment.this.mFirstList = false;
                    } else {
                        GirlFragment.this.mSearchAdapter.a(searchResultBean.projectInfo);
                    }
                    GirlFragment girlFragment = GirlFragment.this;
                    girlFragment.setExAdapter(girlFragment.mSearchAdapter);
                    GirlFragment.access$308(GirlFragment.this);
                    if (GirlFragment.this.mSearchAdapter.getItemCount() == searchResultBean.total) {
                        GirlFragment.this.disableLoadMore();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSpmB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339989836")) {
            ipChange.ipc$dispatch("-339989836", new Object[]{this, str, jSONArray});
        } else if (getActivity() != null && (getActivity() instanceof DamaiBaseActivity)) {
            HashMap hashMap = new HashMap();
            this.arg = hashMap;
            if (jSONArray != null) {
                hashMap.put("current_ab", jSONArray.toJSONString());
            }
            CategoryRepository categoryRepository = this.mData;
            if (categoryRepository != null) {
                categoryRepository.mXiannvBdian = str;
            }
            if (getUserVisibleHint()) {
                c.e().L(getActivity(), str);
                c.e().l(getActivity(), new a.b().i(str).j(this.arg));
            }
            this.mUTBuilder = new a.b().i(str).j(this.arg);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public AbsAdapter getAdapter(w9 w9Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "907727529")) {
            return new VerticalAdapter(w9Var, new kv2());
        }
        return (AbsAdapter) ipChange.ipc$dispatch("907727529", new Object[]{this, w9Var});
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445308878")) {
            return (View) ipChange.ipc$dispatch("-1445308878", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        this.mActivity = categoryActivity;
        this.mData = categoryActivity.getData();
        if (getArguments() != null) {
            this.mTitle = getArguments().getString("title", "");
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577741457")) {
            ipChange.ipc$dispatch("-1577741457", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "793536346")) {
            ipChange.ipc$dispatch("793536346", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1) {
            ToastUtil a2 = ToastUtil.a();
            FragmentActivity activity = getActivity();
            a2.e(activity, "frag demo: " + obj.toString());
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705797295")) {
            ipChange.ipc$dispatch("-1705797295", new Object[]{this});
            return;
        }
        fetchGirlListData();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877006001")) {
            ipChange.ipc$dispatch("1877006001", new Object[]{this});
            return;
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36772092")) {
            ipChange.ipc$dispatch("36772092", new Object[]{this});
            return;
        }
        super.onStop();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11493589")) {
            ipChange.ipc$dispatch("-11493589", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        fetchGirlListData();
        this.mUTBuilder = new a.b().i(this.mBdian);
    }

    public void pageUtBuild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439058611")) {
            ipChange.ipc$dispatch("-439058611", new Object[]{this});
        } else if (this.mUTBuilder != null) {
            if (this.arg == null) {
                this.arg = new HashMap();
            }
            c.e().o(this, this.mUTBuilder.j(this.arg));
        }
    }

    public void setUTBuilder(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115158940")) {
            ipChange.ipc$dispatch("-115158940", new Object[]{this, bVar});
            return;
        }
        this.mUTBuilder = bVar;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        CategoryRepository categoryRepository;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012551651")) {
            ipChange.ipc$dispatch("2012551651", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z && this.mActivity != null && (categoryRepository = this.mData) != null && categoryRepository.isChangeCondition) {
            if (categoryRepository.isAizhe) {
                fetchGirlListData();
                clearList();
                requestProject();
                this.mData.isAizhe = false;
            }
            this.mData.isChangeCondition = false;
        }
    }
}
