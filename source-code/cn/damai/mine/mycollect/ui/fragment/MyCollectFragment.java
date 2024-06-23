package cn.damai.mine.mycollect.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.mycollect.bean.MyCollectDataHolder;
import cn.damai.mine.mycollect.bean.MyCollectFollowResponse;
import cn.damai.mine.mycollect.bean.MyCollectResponse;
import cn.damai.mine.mycollect.net.MyCollectApi;
import cn.damai.mine.mycollect.net.MyCollectViewModel;
import cn.damai.mine.mycollect.ui.adapter.MyCollectAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.gr;
import tb.ig1;
import tb.xf2;

/* compiled from: Taobao */
public class MyCollectFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String NET_MSG = "网络不稳定 辛苦稍后重试";
    private MyCollectDataHolder bottomDataHolder = new MyCollectDataHolder(1);
    Observer<MyCollectFollowResponse> cancelFollowObserver = new Observer<MyCollectFollowResponse>() {
        /* class cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable MyCollectFollowResponse myCollectFollowResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1765132675")) {
                ipChange.ipc$dispatch("-1765132675", new Object[]{this, myCollectFollowResponse});
                return;
            }
            MyCollectFragment.this.stopProgressDialog();
            if (MyCollectFragment.this.isPageFinish() || myCollectFollowResponse == null) {
                return;
            }
            if (myCollectFollowResponse.requestSuccess) {
                ToastUtil.f(MyCollectFragment.this.getString(R$string.damai_mycollect_delete_success));
                if (MyCollectFragment.this.mDeletePos > -1 && MyCollectFragment.this.mDeletePos < MyCollectFragment.this.mDataHolderList.size()) {
                    MyCollectFragment.this.mDataHolderList.remove(MyCollectFragment.this.mDeletePos);
                    if (MyCollectFragment.this.mAdapter != null) {
                        MyCollectFragment.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(myCollectFollowResponse.errorMsg)) {
                myCollectFollowResponse.errorMsg = "网络不稳定 辛苦稍后重试";
            }
            ToastUtil.i(myCollectFollowResponse.errorMsg);
        }
    };
    private Observer<MyCollectResponse> collectDataChangeObserver = new Observer<MyCollectResponse>() {
        /* class cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable MyCollectResponse myCollectResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "212639823")) {
                ipChange.ipc$dispatch("212639823", new Object[]{this, myCollectResponse});
                return;
            }
            MyCollectFragment.this.stopLoading();
            if (MyCollectFragment.this.isPageFinish() || myCollectResponse == null) {
                return;
            }
            if (myCollectResponse.requestSuccess) {
                MyCollectFragment myCollectFragment = MyCollectFragment.this;
                myCollectFragment.onResponseSuccess(((BaseFragment) myCollectFragment).rootView);
                MyCollectFragment.this.loadCollectData(myCollectResponse);
            } else if (MyCollectFragment.this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                MyCollectFragment myCollectFragment2 = MyCollectFragment.this;
                String str = myCollectResponse.errorMsg;
                myCollectFragment2.onResponseError(str, str, MyCollectApi.MY_COLLECT_API, ((BaseFragment) myCollectFragment2).rootView, true);
            } else {
                if (TextUtils.isEmpty(myCollectResponse.errorMsg)) {
                    myCollectResponse.errorMsg = "网络不稳定 辛苦稍后重试";
                }
                ToastUtil.i(myCollectResponse.errorMsg);
            }
        }
    };
    private boolean isVisibleToUser;
    private MyCollectAdapter mAdapter;
    private List<MyCollectDataHolder> mDataHolderList = new ArrayList();
    private int mDeletePos = -1;
    private boolean mHasNext;
    private int mIndex = 0;
    private boolean mIsLoadFinish;
    View.OnClickListener mItemClickListener = new b();
    View.OnLongClickListener mItemLongListener = new a();
    private IRecyclerView mRecyclerView;
    private MyCollectViewModel mViewModel;
    private Observer<Integer> pageChangeObserver = new Observer<Integer>() {
        /* class cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onChanged(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1395528604")) {
                ipChange.ipc$dispatch("-1395528604", new Object[]{this, num});
                return;
            }
            MyCollectFragment.this.pageChangeListener();
        }
    };
    private boolean showLoading;

    /* compiled from: Taobao */
    public class a implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.mine.mycollect.ui.fragment.MyCollectFragment$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class DialogInterface$OnClickListenerC0029a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ProjectItemBean a;
            final /* synthetic */ int b;

            DialogInterface$OnClickListenerC0029a(ProjectItemBean projectItemBean, int i) {
                this.a = projectItemBean;
                this.b = i;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "968226412")) {
                    ipChange.ipc$dispatch("968226412", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                MyCollectFragment myCollectFragment = MyCollectFragment.this;
                ProjectItemBean projectItemBean = this.a;
                myCollectFragment.requestCancelFollow(projectItemBean.id, projectItemBean.isNewItem == 1 ? 7 : 6, this.b);
            }
        }

        a() {
        }

        public boolean onLongClick(View view) {
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-799635074")) {
                return ((Boolean) ipChange.ipc$dispatch("-799635074", new Object[]{this, view})).booleanValue();
            }
            int intValue = ((Integer) view.getTag()).intValue();
            MyCollectDataHolder myCollectDataHolder = intValue < MyCollectFragment.this.mDataHolderList.size() ? (MyCollectDataHolder) MyCollectFragment.this.mDataHolderList.get(intValue) : null;
            if (myCollectDataHolder == null || (projectItemBean = myCollectDataHolder.mProjectItemBean) == null) {
                return false;
            }
            DMDialog dMDialog = new DMDialog(MyCollectFragment.this.getActivity());
            dMDialog.v("是否取消想看?");
            dMDialog.i("否", null);
            dMDialog.n("是", new DialogInterface$OnClickListenerC0029a(projectItemBean, intValue));
            dMDialog.show();
            return true;
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1844535831")) {
                ipChange.ipc$dispatch("1844535831", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            MyCollectDataHolder myCollectDataHolder = null;
            if (intValue < MyCollectFragment.this.mDataHolderList.size()) {
                myCollectDataHolder = (MyCollectDataHolder) MyCollectFragment.this.mDataHolderList.get(intValue);
            }
            if (myCollectDataHolder != null && (projectItemBean = myCollectDataHolder.mProjectItemBean) != null) {
                c e = c.e();
                ig1 m = ig1.m();
                e.x(m.l(projectItemBean.id + "&6", intValue));
                if (TextUtils.isEmpty(projectItemBean.schema)) {
                    DMNav.from(MyCollectFragment.this.getActivity()).withExtras(MyCollectFragment.this.getProjectPrice(projectItemBean)).forResult(1001).toUri(NavUri.b(gr.b));
                } else {
                    DMNav.from(MyCollectFragment.this.getActivity()).forResult(1001).toUri(projectItemBean.schema);
                }
            }
        }
    }

    private void emptyDataPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958697777")) {
            ipChange.ipc$dispatch("-1958697777", new Object[]{this});
            return;
        }
        onResponseError(3, "你还未收藏过演出哦(-.-)", "0", MyCollectApi.MY_COLLECT_API, this.rootView, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bundle getProjectPrice(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317922747")) {
            return (Bundle) ipChange.ipc$dispatch("317922747", new Object[]{this, projectItemBean});
        }
        Bundle bundle = new Bundle();
        if (projectItemBean != null) {
            bundle.putString("projectId", projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
        }
        return bundle;
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826570081")) {
            ipChange.ipc$dispatch("826570081", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyCollectAdapter myCollectAdapter = new MyCollectAdapter(getActivity(), this.mDataHolderList);
        this.mAdapter = myCollectAdapter;
        myCollectAdapter.a(this.mItemClickListener, this.mItemLongListener);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1429370445")) {
            return getActivity() == null || getActivity().isFinishing() || isDetached();
        }
        return ((Boolean) ipChange.ipc$dispatch("1429370445", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadCollectData(MyCollectResponse myCollectResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714345380")) {
            ipChange.ipc$dispatch("714345380", new Object[]{this, myCollectResponse});
        } else if (myCollectResponse == null) {
            emptyDataPage();
        } else {
            int e = xf2.e(myCollectResponse.items);
            this.mHasNext = myCollectResponse.hasNext;
            int i = this.mIndex + 1;
            this.mIndex = i;
            if (i == 1) {
                this.mDataHolderList.clear();
            }
            if (e != 0) {
                for (int i2 = 0; i2 < e; i2++) {
                    ProjectItemBean projectItemBean = myCollectResponse.items.get(i2);
                    if (projectItemBean != null) {
                        MyCollectDataHolder myCollectDataHolder = new MyCollectDataHolder(0);
                        myCollectDataHolder.mProjectItemBean = projectItemBean;
                        this.mDataHolderList.add(myCollectDataHolder);
                    }
                }
                if (!this.mHasNext) {
                    this.mDataHolderList.add(this.bottomDataHolder);
                }
            } else if (this.mIndex != 1) {
                this.mHasNext = false;
                this.mDataHolderList.add(this.bottomDataHolder);
            }
            MyCollectAdapter myCollectAdapter = this.mAdapter;
            if (myCollectAdapter != null) {
                myCollectAdapter.notifyDataSetChanged();
            }
            if (xf2.e(this.mDataHolderList) == 0) {
                emptyDataPage();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pageChangeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090224446")) {
            ipChange.ipc$dispatch("-2090224446", new Object[]{this});
        } else if (isAdded()) {
            if (this.showLoading && this.isVisibleToUser) {
                startProgressDialog();
            }
            this.mIsLoadFinish = false;
            this.mViewModel.getCollectData().observe(this, this.collectDataChangeObserver);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestCancelFollow(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444389189")) {
            ipChange.ipc$dispatch("444389189", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mViewModel != null) {
            startProgressDialog();
            this.mDeletePos = i2;
            this.mViewModel.cancelFollowData(str, String.valueOf(i)).observe(this, this.cancelFollowObserver);
            c e = c.e();
            ig1 m = ig1.m();
            e.x(m.k(str + "&" + i, i2));
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1969483974")) {
            return R$layout.layout_collect;
        }
        return ((Integer) ipChange.ipc$dispatch("-1969483974", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50888178")) {
            ipChange.ipc$dispatch("-50888178", new Object[]{this, Integer.valueOf(i)});
        } else if (isAdded()) {
            this.showLoading = true;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206672419")) {
            ipChange.ipc$dispatch("-206672419", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068292256")) {
            ipChange.ipc$dispatch("2068292256", new Object[]{this});
            return;
        }
        initRecyclerView();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391158406")) {
            ipChange.ipc$dispatch("1391158406", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098996122")) {
            ipChange.ipc$dispatch("1098996122", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        MyCollectViewModel myCollectViewModel = (MyCollectViewModel) ViewModelProviders.of(this).get(MyCollectViewModel.class);
        this.mViewModel = myCollectViewModel;
        myCollectViewModel.getPageIndex().observe(this, this.pageChangeObserver);
        refreshData();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453746441")) {
            ipChange.ipc$dispatch("-453746441", new Object[]{this, view});
        } else if (this.mIsLoadFinish && this.mHasNext) {
            this.showLoading = false;
            this.mViewModel.getPageIndex().setValue(Integer.valueOf(this.mIndex + 1));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750093607")) {
            ipChange.ipc$dispatch("-750093607", new Object[]{this});
        } else if (isAdded()) {
            this.showLoading = false;
            this.mIndex = 0;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329411824")) {
            ipChange.ipc$dispatch("-1329411824", new Object[]{this});
            return;
        }
        if (this.isVisibleToUser) {
            this.showLoading = true;
        }
        MyCollectViewModel myCollectViewModel = this.mViewModel;
        if (myCollectViewModel != null && myCollectViewModel.getPageIndex() != null) {
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878675093")) {
            ipChange.ipc$dispatch("-1878675093", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isVisibleToUser = z;
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316599611")) {
            ipChange.ipc$dispatch("1316599611", new Object[]{this});
        } else if (!isPageFinish()) {
            stopProgressDialog();
            if (this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                this.mRecyclerView.setRefreshing(false);
            }
            this.mIsLoadFinish = true;
        }
    }
}
