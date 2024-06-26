package cn.damai.discover.main.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.bean.FollowEvent;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.wannasee.adapter.MultiAdapter;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.commonbusiness.wannasee.view.NestScrollErrResView;
import cn.damai.discover.main.bean.FollowBean;
import cn.damai.discover.main.bean.FollowUserInfoBean;
import cn.damai.discover.main.request.FollowPeopleRequest;
import cn.damai.discover.main.request.FollowRequest;
import cn.damai.discover.main.ui.adapter.FollowAdapter;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.HashMap;
import tb.br;
import tb.d20;
import tb.dr;
import tb.f81;
import tb.gr;
import tb.n42;
import tb.r3;
import tb.t3;
import tb.tm0;
import tb.v3;
import tb.v50;
import tb.za;

/* compiled from: Taobao */
public class FollowFragment extends Fragment implements PtrChildHandler, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CODE_LOGIN = 4472;
    private boolean isRequest4FirstPage;
    private boolean isViewCreated = false;
    private TabLiveActivity mActivity;
    private View mEmptyFoot;
    private boolean mFirstRequest = true;
    private FollowAdapter mFollowAdapter;
    private View.OnClickListener mFollowClickListener = new h();
    private View.OnClickListener mFollowItemClickListener = new i();
    private DMMtopRequestListener mFollowListener;
    private br mFollowMessage = new br();
    private DMMtopRequestListener mFollowPeopleListener;
    private FollowRequest mFollowRequest = new FollowRequest();
    private FollowUserInfoBean mFollowUserInfoBean;
    private StaggeredGridLayoutManager mGridLayoutManager;
    private tm0 mHeaderView;
    private boolean mIsFollowChanged = false;
    private RecyclerView.ItemDecoration mItemDecoration = new RecyclerView.ItemDecoration() {
        /* class cn.damai.discover.main.ui.FollowFragment.AnonymousClass7 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "312403214")) {
                ipChange.ipc$dispatch("312403214", new Object[]{this, rect, view, recyclerView, state});
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int a2 = n42.a(FollowFragment.this.mActivity, 6.0f);
            int a3 = n42.a(FollowFragment.this.mActivity, 10.0f);
            if (layoutParams instanceof RecyclerView.LayoutParams) {
                int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
                if (viewAdapterPosition > 1) {
                    rect.set(a2, a2, a2, a2);
                } else if (viewAdapterPosition == 0) {
                    rect.set(0, a3, 0, 0);
                }
            }
        }
    };
    private LinearLayoutManager mLinearLayoutManager;
    private r3 mLoginListener = new a();
    private FrameLayout mMainView;
    private MultiAdapter mMultiAdapter;
    private OnBizListener<FollowBean> mOnceListener;
    private NestScrollErrResView mResView;
    private DamaiRootRecyclerView mRlView;
    private View mView;

    /* compiled from: Taobao */
    public class a extends r3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "725448950")) {
                ipChange.ipc$dispatch("725448950", new Object[]{this});
                return;
            }
            FollowFragment.this.request(true);
        }
    }

    /* compiled from: Taobao */
    public class b implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1180662063")) {
                ipChange.ipc$dispatch("-1180662063", new Object[]{this});
            } else if (FollowFragment.this.mActivity != null && !FollowFragment.this.mActivity.isFinishing()) {
                LoginManager.k().x(FollowFragment.this.mActivity, new Intent(), FollowFragment.REQUEST_CODE_LOGIN);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1686220688")) {
                ipChange.ipc$dispatch("-1686220688", new Object[]{this});
                return;
            }
            FollowFragment.this.request(true);
        }
    }

    /* compiled from: Taobao */
    public class d implements OnBizListener<FollowBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PtrFrameLayout a;

        d(FollowFragment followFragment, PtrFrameLayout ptrFrameLayout) {
            this.a = ptrFrameLayout;
        }

        /* renamed from: a */
        public void onBizSuccess(FollowBean followBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "890411389")) {
                ipChange.ipc$dispatch("890411389", new Object[]{this, followBean});
                return;
            }
            this.a.refreshComplete();
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2099871302")) {
                ipChange.ipc$dispatch("-2099871302", new Object[]{this, str, str2});
                return;
            }
            this.a.refreshComplete();
        }
    }

    /* compiled from: Taobao */
    public class e implements Action<Boolean> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        /* renamed from: a */
        public void call(Boolean bool) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1823707848")) {
                ipChange.ipc$dispatch("-1823707848", new Object[]{this, bool});
                return;
            }
            FollowFragment.this.mIsFollowChanged = true;
        }
    }

    /* compiled from: Taobao */
    public class f extends v3 {
        private static transient /* synthetic */ IpChange $ipChange;

        f(FollowFragment followFragment) {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utNoteClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1097607586")) {
                ipChange.ipc$dispatch("-1097607586", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            za.j(f81.u().t(i, noteBean.id));
        }
    }

    /* compiled from: Taobao */
    public class g extends MultiAdapter.f {
        private static transient /* synthetic */ IpChange $ipChange;

        g(FollowFragment followFragment) {
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureNote(View view, NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "526626695")) {
                ipChange.ipc$dispatch("526626695", new Object[]{this, view, noteBean, Integer.valueOf(i)});
                return;
            }
            f81.n(view, noteBean.id, i);
        }
    }

    /* compiled from: Taobao */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "865359499")) {
                ipChange.ipc$dispatch("865359499", new Object[]{this, view});
                return;
            }
            FollowFragment.this.mFollowUserInfoBean = (FollowUserInfoBean) view.getTag();
            if (FollowFragment.this.mFollowUserInfoBean != null) {
                int i = !FollowFragment.this.mFollowUserInfoBean.focus ? 1 : 0;
                if (FollowFragment.this.mFollowUserInfoBean.havanaId != 0) {
                    FollowFragment followFragment = FollowFragment.this;
                    followFragment.followRequest(i, String.valueOf(followFragment.mFollowUserInfoBean.havanaId), FollowFragment.this.mFollowUserInfoBean.targetType);
                } else {
                    FollowFragment followFragment2 = FollowFragment.this;
                    followFragment2.followRequest(i, followFragment2.mFollowUserInfoBean.id, FollowFragment.this.mFollowUserInfoBean.targetType);
                }
                cn.damai.common.user.c.e().x(f81.u().r(FollowFragment.this.mFollowUserInfoBean.index, FollowFragment.this.mFollowUserInfoBean.id, i));
            }
        }
    }

    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1318317428")) {
                ipChange.ipc$dispatch("-1318317428", new Object[]{this, view});
                return;
            }
            FollowUserInfoBean followUserInfoBean = (FollowUserInfoBean) view.getTag();
            if (followUserInfoBean != null) {
                Bundle bundle = new Bundle();
                long j = followUserInfoBean.havanaId;
                if (j != 0) {
                    bundle.putString(FeedsViewModel.ARG_USERID, String.valueOf(j));
                } else {
                    bundle.putString(FeedsViewModel.ARG_USERID, followUserInfoBean.id);
                }
                bundle.putString("usertype", followUserInfoBean.targetType);
                DMNav.from(FollowFragment.this.mActivity).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
                cn.damai.common.user.c.e().x(f81.u().s(followUserInfoBean.index, followUserInfoBean.id));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void alarm(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058615463")) {
            ipChange.ipc$dispatch("2058615463", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.i());
        hashMap.put("city", d20.d());
        dr.INSTANCE.a().a(this.mFollowRequest.getApiName()).c(str).d(str2).e(hashMap).g("现场主页关注").j("live").f(false).b();
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055489940")) {
            ipChange.ipc$dispatch("-2055489940", new Object[]{this});
            return;
        }
        this.mFollowListener = new DMMtopRequestListener<FollowBean>(FollowBean.class) {
            /* class cn.damai.discover.main.ui.FollowFragment.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1699812078")) {
                    ipChange.ipc$dispatch("1699812078", new Object[]{this, str, str2});
                    return;
                }
                if (FollowFragment.this.mOnceListener != null) {
                    FollowFragment.this.mOnceListener.onBizFail(str, str2);
                }
                FollowFragment.this.mOnceListener = null;
                FollowFragment.this.showErrorView();
                FollowFragment.this.alarm(str, str2);
            }

            public void onSuccess(FollowBean followBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "427820489")) {
                    ipChange.ipc$dispatch("427820489", new Object[]{this, followBean});
                    return;
                }
                if (FollowFragment.this.mOnceListener != null) {
                    FollowFragment.this.mOnceListener.onBizSuccess(followBean);
                }
                FollowFragment.this.mOnceListener = null;
                FollowFragment.this.stopBottomProgress();
                if (followBean == null) {
                    onFail("", "");
                    return;
                }
                FollowFragment.this.showSuccessView();
                if (FollowFragment.this.mFirstRequest) {
                    FollowFragment.this.refreshView(followBean);
                } else {
                    FollowFragment.this.refreshView(followBean);
                }
                FollowFragment.this.mFollowRequest.dataType = followBean.dataType;
                FollowFragment.this.mFollowRequest.startRow = followBean.nextRow;
                FollowFragment.this.mFirstRequest = false;
            }
        };
        request(true);
        this.mFollowPeopleListener = new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.discover.main.ui.FollowFragment.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1692052719")) {
                    ipChange.ipc$dispatch("1692052719", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1259159953")) {
                    ipChange.ipc$dispatch("1259159953", new Object[]{this, followDataBean});
                    return;
                }
                FollowFragment.this.mActivity.stopProgressDialog();
                if (followDataBean != null) {
                    if (followDataBean.getStatus() == 1) {
                        if (FollowFragment.this.mFollowUserInfoBean != null) {
                            FollowFragment.this.mFollowAdapter.b(FollowFragment.this.mFollowUserInfoBean.index, !FollowFragment.this.mFollowUserInfoBean.focus);
                            return;
                        }
                    } else if (followDataBean.getStatus() == 0 && FollowFragment.this.mFollowUserInfoBean != null) {
                        FollowFragment.this.mFollowAdapter.b(FollowFragment.this.mFollowUserInfoBean.index, false);
                        return;
                    }
                }
                onFail("", "");
            }
        };
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250510225")) {
            ipChange.ipc$dispatch("1250510225", new Object[]{this});
            return;
        }
        this.mMainView = (FrameLayout) this.mView.findViewById(R$id.layout_main);
        NestScrollErrResView nestScrollErrResView = new NestScrollErrResView(getActivity());
        this.mResView = nestScrollErrResView;
        this.mMainView.addView(nestScrollErrResView, -1, -1);
        this.mResView.setVisibility(8);
        this.mRlView = (DamaiRootRecyclerView) this.mView.findViewById(R$id.recycler_view);
        this.mGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
        this.mRlView.setRefreshEnabled(false);
        this.mRlView.setLoadMoreEnabled(true);
        this.mRlView.setOnLoadMoreListener(this);
        this.mRlView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot = LayoutInflater.from(this.mActivity).inflate(R$layout.live_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(this.mActivity, 110.0f)));
        this.mEmptyFoot.setVisibility(8);
        this.mRlView.addFooterView(this.mEmptyFoot);
        UpLoadMorePanel.b(this.mRlView);
        this.mRlView.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            /* class cn.damai.discover.main.ui.FollowFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1715691986")) {
                    ipChange.ipc$dispatch("-1715691986", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        });
        this.mFollowAdapter = new FollowAdapter(getContext(), this.mFollowClickListener, this.mFollowItemClickListener);
        MultiAdapter multiAdapter = new MultiAdapter(getContext(), new t3(this.mActivity, new f(this)));
        this.mMultiAdapter = multiAdapter;
        multiAdapter.i(new g(this));
        this.mHeaderView = new tm0(LayoutInflater.from(getContext()).inflate(R$layout.live_follow_people_layout, (ViewGroup) null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshView(FollowBean followBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872667138")) {
            ipChange.ipc$dispatch("-1872667138", new Object[]{this, followBean});
            return;
        }
        if (this.mRlView.getItemDecorationCount() == 0) {
            this.mRlView.addItemDecoration(this.mItemDecoration);
        }
        int i2 = followBean.dataType;
        if (i2 == 1) {
            int a2 = n42.a(this.mActivity, 15.0f);
            this.mRlView.setPadding(a2, 0, a2, 0);
            if (this.mFirstRequest) {
                if (this.mRlView.getHeaderContainer() != null) {
                    this.mRlView.getHeaderContainer().removeAllViews();
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
                this.mGridLayoutManager = staggeredGridLayoutManager;
                this.mRlView.setLayoutManager(staggeredGridLayoutManager);
                this.mRlView.setAdapter(this.mMultiAdapter);
                this.mMultiAdapter.j(followBean.contentList);
                return;
            }
            this.mMultiAdapter.e(followBean.contentList);
        } else if (i2 == 2) {
            int a3 = n42.a(this.mActivity, 15.0f);
            this.mRlView.setPadding(a3, 0, a3, 0);
            if (this.mFirstRequest) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
                this.mLinearLayoutManager = linearLayoutManager;
                this.mRlView.setLayoutManager(linearLayoutManager);
                this.mRlView.setAdapter(this.mFollowAdapter);
                if (this.mHeaderView != null) {
                    if (this.mRlView.getHeaderContainer() != null) {
                        this.mRlView.getHeaderContainer().removeAllViews();
                    }
                    this.mRlView.addHeaderView(this.mHeaderView.a());
                    this.mHeaderView.b(followBean.focusUserInfo);
                }
                this.mFollowAdapter.setData(followBean.recommendUserLists);
                return;
            }
            this.mFollowAdapter.a(followBean.recommendUserLists);
        }
    }

    private void showBottomEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350548351")) {
            ipChange.ipc$dispatch("1350548351", new Object[]{this});
            return;
        }
        this.mRlView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRlView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
    }

    private void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222520221")) {
            ipChange.ipc$dispatch("-222520221", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRlView.getLoadMoreFooterView().setVisibility(0);
        this.mRlView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1556712372")) {
            ipChange.ipc$dispatch("1556712372", new Object[]{this});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showErrorView("", "", new c());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSuccessView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292706393")) {
            ipChange.ipc$dispatch("1292706393", new Object[]{this});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039431188")) {
            ipChange.ipc$dispatch("-2039431188", new Object[]{this});
            return;
        }
        this.mRlView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRlView.getLoadMoreFooterView().setVisibility(8);
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "150965020")) {
            return LoginManager.k().q() && this.isViewCreated && isAdded();
        }
        return ((Boolean) ipChange.ipc$dispatch("150965020", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
    }

    public boolean checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635614615")) {
            return ((Boolean) ipChange.ipc$dispatch("-635614615", new Object[]{this})).booleanValue();
        } else if (LoginManager.k().q()) {
            NestScrollErrResView nestScrollErrResView = this.mResView;
            if (nestScrollErrResView != null) {
                nestScrollErrResView.setVisibility(8);
            }
            return true;
        } else {
            NestScrollErrResView nestScrollErrResView2 = this.mResView;
            if (nestScrollErrResView2 != null) {
                nestScrollErrResView2.showLoginView(new b());
            }
            return false;
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399716457")) {
            ipChange.ipc$dispatch("-1399716457", new Object[]{this});
            return;
        }
        FollowRequest followRequest = this.mFollowRequest;
        followRequest.dataType = 0;
        followRequest.startRow = null;
        this.mFirstRequest = true;
    }

    public void followRequest(int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986684751")) {
            ipChange.ipc$dispatch("-1986684751", new Object[]{this, Integer.valueOf(i2), str, str2});
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mActivity.startProgressDialog();
            FollowPeopleRequest followPeopleRequest = new FollowPeopleRequest();
            followPeopleRequest.operateType = i2;
            followPeopleRequest.targetId = str;
            followPeopleRequest.targetType = str2;
            followPeopleRequest.request(this.mFollowPeopleListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106739959")) {
            ipChange.ipc$dispatch("-106739959", new Object[]{this, bundle});
            return;
        }
        LoginManager.k().c(this.mLoginListener);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771364133")) {
            return (View) ipChange.ipc$dispatch("-1771364133", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.live_follow_fragment, (ViewGroup) null);
        this.mActivity = (TabLiveActivity) getActivity();
        initView();
        this.mFollowMessage.b(FollowEvent.LIVE_FOLLOW_EVENT, new e());
        initData();
        this.isViewCreated = true;
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450385545")) {
            ipChange.ipc$dispatch("1450385545", new Object[]{this});
            return;
        }
        LoginManager.k().C(this.mLoginListener);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626565212")) {
            ipChange.ipc$dispatch("-1626565212", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        super.onDestroyView();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475049638")) {
            ipChange.ipc$dispatch("475049638", new Object[]{this, view});
        } else if (this.mFollowRequest.startRow != null) {
            showBottomLoadMore();
            request(false);
        } else if (!this.isRequest4FirstPage) {
            showBottomEmpty();
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992440605")) {
            ipChange.ipc$dispatch("1992440605", new Object[]{this, ptrFrameLayout, refreshCallBack});
            return;
        }
        this.mOnceListener = new d(this, ptrFrameLayout);
        request(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921337114")) {
            ipChange.ipc$dispatch("1921337114", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mIsFollowChanged) {
            this.mIsFollowChanged = false;
            request(true);
        }
    }

    public void request(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625040159")) {
            ipChange.ipc$dispatch("625040159", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            clear();
        }
        this.isRequest4FirstPage = z;
        if (LoginManager.k().q()) {
            this.mFollowRequest.request(this.mFollowListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117931482")) {
            ipChange.ipc$dispatch("117931482", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z) {
            checkLogin();
        }
    }
}
