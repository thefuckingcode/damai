package cn.damai.user.userhome.fragment;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.wannasee.adapter.IPublishView;
import cn.damai.commonbusiness.wannasee.adapter.NoteFeedAdapter;
import cn.damai.commonbusiness.wannasee.bean.FeedBean;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.commonbusiness.wannasee.view.NestScrollErrResView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.observer.Action;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.RefreshHeaderLayout;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.user.userhome.adapter.UserDynamicLabelAdapter;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.bean.UserDynamicBean;
import cn.damai.user.userhome.bean.UserDynamicContentBean;
import cn.damai.user.userhome.model.UserDynamicRequest;
import cn.damai.user.userhome.ut.UtForDynamic;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.br;
import tb.d20;
import tb.dr;
import tb.gt2;
import tb.hj1;
import tb.ib;
import tb.jl1;
import tb.m42;
import tb.q3;
import tb.qv1;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.xv1;
import tb.yd1;

/* compiled from: Taobao */
public class MineDynamicFragment extends Fragment implements IPublishView, PtrChildHandler, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int DefaultPage = 1;
    private int currentPage = 1;
    private boolean isFirstPageEmpty = false;
    private boolean isNextPage = false;
    private boolean isViewCreated = false;
    private Activity mActivity;
    private TextView mBottomEndTv;
    private MinepublishCheckBean mCheckBean;
    private List<UserDynamicContentBean> mContentLabelInfo = new ArrayList();
    private int mCurrentLabelIndex;
    private String mCurrentLabelName;
    private String mCurrentLabelType;
    private br mDMMessage = new br();
    private DMMtopRequestListener mDynamicListener;
    private hj1 mDynamicUt = new hj1();
    private View mEmptyFoot;
    private boolean mFirstRequest = true;
    private qv1 mHandler = new f(this);
    private boolean mIsCardChanged = false;
    private UserDynamicLabelAdapter mLabelAdapter;
    private FrameLayout mMainView;
    private NoteFeedAdapter mMultiAdapter;
    private OnBizListener<UserDynamicBean> mOnceListener;
    private NestScrollErrResView mResView;
    private DamaiRootRecyclerView mRlCardView;
    private RecyclerView mRvLableView;
    private String mUserId;
    private String mUtPageName = gt2.USER_HOME_PAGE;
    private View mView;
    private boolean requesting = false;

    /* compiled from: Taobao */
    public class a extends xv1 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Activity activity, int i) {
            super(activity, i);
        }

        @Override // tb.xv1
        /* renamed from: b */
        public void onItemClick(MinepublishCheckBean minepublishCheckBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1967244222")) {
                ipChange.ipc$dispatch("-1967244222", new Object[]{this, minepublishCheckBean, Integer.valueOf(i)});
                return;
            }
            super.b(minepublishCheckBean, i);
            MineDynamicFragment.this.mDynamicUt.onUt4PublishClick(minepublishCheckBean);
        }
    }

    /* compiled from: Taobao */
    public class b extends ib {
        private static transient /* synthetic */ IpChange $ipChange;

        b(Activity activity) {
            super(activity);
        }

        @Override // tb.ib
        /* renamed from: b */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "805191957")) {
                ipChange.ipc$dispatch("805191957", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            super.b(noteBean, i);
            cn.damai.common.user.c.e().x(gt2.j().h(MineDynamicFragment.this.mUtPageName, MineDynamicFragment.this.mCurrentLabelIndex, i, MineDynamicFragment.this.mCurrentLabelName));
        }

        @Override // tb.ib
        /* renamed from: c */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "775043692")) {
                ipChange.ipc$dispatch("775043692", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            super.c(noteBean, i);
            cn.damai.common.user.c.e().x(gt2.j().g(MineDynamicFragment.this.mUtPageName, MineDynamicFragment.this.mCurrentLabelIndex, i, MineDynamicFragment.this.mCurrentLabelName));
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1422900503")) {
                ipChange.ipc$dispatch("1422900503", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (tag != null && (tag instanceof UserDynamicContentBean)) {
                UserDynamicContentBean userDynamicContentBean = (UserDynamicContentBean) tag;
                MineDynamicFragment.this.updateSelectLabelData(userDynamicContentBean.pos);
                if (MineDynamicFragment.this.mLabelAdapter != null) {
                    MineDynamicFragment.this.mLabelAdapter.notifyDataSetChanged();
                }
                MineDynamicFragment.this.mCurrentLabelIndex = userDynamicContentBean.pos;
                MineDynamicFragment.this.mCurrentLabelName = userDynamicContentBean.labelName;
                MineDynamicFragment mineDynamicFragment = MineDynamicFragment.this;
                mineDynamicFragment.mCurrentLabelType = jl1.ARRAY_START_STR + userDynamicContentBean.labelType + jl1.ARRAY_END_STR;
                MineDynamicFragment.this.request(null);
                cn.damai.common.user.c.e().x(gt2.j().i(MineDynamicFragment.this.mUtPageName, MineDynamicFragment.this.mCurrentLabelIndex, MineDynamicFragment.this.mCurrentLabelName));
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1008599642")) {
                ipChange.ipc$dispatch("-1008599642", new Object[]{this, obj});
                return;
            }
            MineDynamicFragment.this.mIsCardChanged = true;
        }
    }

    /* compiled from: Taobao */
    public class e implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1917082808")) {
                ipChange.ipc$dispatch("1917082808", new Object[]{this});
                return;
            }
            MineDynamicFragment.this.request(null);
        }
    }

    /* compiled from: Taobao */
    public class f extends qv1 {
        private static transient /* synthetic */ IpChange $ipChange;

        f(MineDynamicFragment mineDynamicFragment) {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-669676967")) {
                ipChange.ipc$dispatch("-669676967", new Object[]{this, ptrFrameLayout});
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements OnBizListener<UserDynamicBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PtrFrameLayout a;

        g(MineDynamicFragment mineDynamicFragment, PtrFrameLayout ptrFrameLayout) {
            this.a = ptrFrameLayout;
        }

        /* renamed from: a */
        public void onBizSuccess(UserDynamicBean userDynamicBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1366752540")) {
                ipChange.ipc$dispatch("-1366752540", new Object[]{this, userDynamicBean});
                return;
            }
            PtrFrameLayout ptrFrameLayout = this.a;
            if (ptrFrameLayout != null) {
                ptrFrameLayout.refreshComplete();
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-690900383")) {
                ipChange.ipc$dispatch("-690900383", new Object[]{this, str, str2});
                return;
            }
            PtrFrameLayout ptrFrameLayout = this.a;
            if (ptrFrameLayout != null) {
                ptrFrameLayout.refreshComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void alarm(String str, String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987155991")) {
            ipChange.ipc$dispatch("987155991", new Object[]{this, str, str2});
            return;
        }
        if (gt2.USER_HOME_PAGE.equals(this.mUtPageName)) {
            str3 = "个人主页动态";
        } else if (yd1.MY_PAGE.equals(this.mUtPageName)) {
            str3 = "我的页面动态";
        } else {
            str3 = this.mUtPageName;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("publisherId", this.mUserId);
        hashMap.put("contentLabelList", this.mCurrentLabelType);
        hashMap.put("usercode", d20.i());
        dr.INSTANCE.a().a(new UserDynamicRequest().getApiName()).c(str).d(str2).e(hashMap).g(str3).j(this.mUtPageName).f(false).b();
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669584132")) {
            ipChange.ipc$dispatch("-669584132", new Object[]{this});
            return;
        }
        resetLabelData();
        if (getArguments() != null) {
            this.mUserId = getArguments().getString("userId", null);
            this.mUtPageName = getArguments().getString("utPageName", gt2.USER_HOME_PAGE);
        }
        this.mDynamicListener = new DMMtopRequestListener<UserDynamicBean>(UserDynamicBean.class) {
            /* class cn.damai.user.userhome.fragment.MineDynamicFragment.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2047625598")) {
                    ipChange.ipc$dispatch("2047625598", new Object[]{this, str, str2});
                    return;
                }
                MineDynamicFragment.this.requesting = false;
                if (MineDynamicFragment.this.mOnceListener != null) {
                    MineDynamicFragment.this.mOnceListener.onBizFail(str, str2);
                }
                MineDynamicFragment.this.mOnceListener = null;
                if (MineDynamicFragment.this.currentPage == 1) {
                    MineDynamicFragment.this.showErrorView(str, str2);
                    MineDynamicFragment.this.alarm(str, str2);
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "网络异常，请稍后重试";
                }
                ToastUtil.i(str2);
            }

            public void onSuccess(UserDynamicBean userDynamicBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1737435519")) {
                    ipChange.ipc$dispatch("-1737435519", new Object[]{this, userDynamicBean});
                    return;
                }
                MineDynamicFragment.this.requesting = false;
                if (MineDynamicFragment.this.mOnceListener != null) {
                    MineDynamicFragment.this.mOnceListener.onBizSuccess(userDynamicBean);
                }
                MineDynamicFragment.this.mOnceListener = null;
                MineDynamicFragment.this.stopBottomProgress();
                MineDynamicFragment.this.isFirstPageEmpty = false;
                if (userDynamicBean == null) {
                    MineDynamicFragment.this.showEmptyView();
                    return;
                }
                MineDynamicFragment.this.isNextPage = userDynamicBean.hasNext;
                if (MineDynamicFragment.this.mFirstRequest) {
                    if (TextUtils.isEmpty(MineDynamicFragment.this.mCurrentLabelType)) {
                        if (xf2.e(userDynamicBean.contentLabelInfo) > 0) {
                            MineDynamicFragment.this.mContentLabelInfo.clear();
                            MineDynamicFragment.this.mContentLabelInfo.addAll(userDynamicBean.contentLabelInfo);
                            MineDynamicFragment.this.mRvLableView.setVisibility(0);
                            MineDynamicFragment.this.updateSelectLabelData(0);
                            MineDynamicFragment.this.mRvLableView.setAdapter(MineDynamicFragment.this.mLabelAdapter);
                        } else {
                            MineDynamicFragment.this.mRvLableView.setVisibility(8);
                        }
                    }
                    if (xf2.e(userDynamicBean.card) == 0) {
                        MineDynamicFragment.this.showEmptyView();
                        return;
                    }
                    if (MineDynamicFragment.this.mRlCardView.getHeaderContainer() != null) {
                        MineDynamicFragment.this.mRlCardView.getHeaderContainer().removeAllViews();
                    }
                    MineDynamicFragment.this.mMultiAdapter.d(FeedBean.transfer(userDynamicBean.card), true);
                } else {
                    MineDynamicFragment.this.mMultiAdapter.d(FeedBean.transfer(userDynamicBean.card), false);
                }
                MineDynamicFragment.this.showSuccessView();
                MineDynamicFragment.this.mFirstRequest = false;
            }
        };
        this.mDMMessage.b("comment_publish_success", new d());
    }

    private void initView() {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658551263")) {
            ipChange.ipc$dispatch("-1658551263", new Object[]{this});
            return;
        }
        this.mMainView = (FrameLayout) this.mView.findViewById(R$id.layout_main);
        NestScrollErrResView nestScrollErrResView = new NestScrollErrResView(this.mActivity);
        this.mResView = nestScrollErrResView;
        this.mMainView.addView(nestScrollErrResView, -1, -1);
        this.mResView.setVisibility(8);
        setlabelView();
        DamaiRootRecyclerView damaiRootRecyclerView = (DamaiRootRecyclerView) this.mView.findViewById(R$id.recycler_view);
        this.mRlCardView = damaiRootRecyclerView;
        damaiRootRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.mRlCardView.setRefreshEnabled(false);
        this.mRlCardView.setLoadMoreEnabled(true);
        this.mRlCardView.setOnLoadMoreListener(this);
        this.mRlCardView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot = LayoutInflater.from(this.mActivity).inflate(R$layout.layout_empty_view, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(this.mActivity, 110.0f)));
        this.mEmptyFoot.setVisibility(8);
        this.mBottomEndTv = (TextView) this.mEmptyFoot.findViewById(R$id.id_bottom_end_tip);
        this.mRlCardView.addFooterView(this.mEmptyFoot);
        UpLoadMorePanel.b(this.mRlCardView);
        Activity activity = this.mActivity;
        NoteFeedAdapter noteFeedAdapter = new NoteFeedAdapter(activity, new q3(new a(activity, 100), new b(this.mActivity)));
        this.mMultiAdapter = noteFeedAdapter;
        this.mRlCardView.setAdapter(noteFeedAdapter);
        RefreshHeaderLayout refreshHeaderLayout = this.mRlCardView.mRefreshHeaderContainer;
        if (!(refreshHeaderLayout == null || (layoutParams = refreshHeaderLayout.getLayoutParams()) == null)) {
            layoutParams.height = 1;
        }
        showPublishItemView(this.mCheckBean);
    }

    private boolean isSelf() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1890192124")) {
            return TextUtils.isEmpty(this.mUserId) || this.mUserId.equals(d20.i());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1890192124", new Object[]{this})).booleanValue();
    }

    private void loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589233883")) {
            ipChange.ipc$dispatch("1589233883", new Object[]{this});
        } else if (!this.requesting) {
            this.currentPage++;
            this.requesting = true;
            UserDynamicRequest userDynamicRequest = new UserDynamicRequest();
            userDynamicRequest.pageIndex = this.currentPage;
            if (TextUtils.isEmpty(this.mUserId)) {
                this.mUserId = d20.i();
            }
            userDynamicRequest.publisherId = this.mUserId;
            userDynamicRequest.contentLabelList = this.mCurrentLabelType;
            userDynamicRequest.request(this.mDynamicListener);
        }
    }

    public static MineDynamicFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941295297")) {
            return (MineDynamicFragment) ipChange.ipc$dispatch("1941295297", new Object[]{str});
        }
        MineDynamicFragment mineDynamicFragment = new MineDynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        mineDynamicFragment.setArguments(bundle);
        return mineDynamicFragment;
    }

    private void resetLabelData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395241671")) {
            ipChange.ipc$dispatch("395241671", new Object[]{this});
            return;
        }
        this.mCurrentLabelType = "";
        this.mCurrentLabelIndex = 0;
        this.mCurrentLabelName = "全部";
    }

    private void setlabelView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974551199")) {
            ipChange.ipc$dispatch("1974551199", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.mView.findViewById(R$id.rv_label);
        this.mRvLableView = recyclerView;
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.user.userhome.fragment.MineDynamicFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-1386716006")) {
                    ipChange.ipc$dispatch("-1386716006", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (MineDynamicFragment.this.mLabelAdapter == null || MineDynamicFragment.this.mLabelAdapter.getItemCount() - 1 != childAdapterPosition) {
                    z = false;
                }
                float f = 12.0f;
                if (childAdapterPosition == 0) {
                    i = m42.a(xs0.a(), 12.0f);
                }
                rect.left = i;
                Application a2 = xs0.a();
                if (!z) {
                    f = 9.0f;
                }
                rect.right = m42.a(a2, f);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        this.mRvLableView.setLayoutManager(linearLayoutManager);
        this.mLabelAdapter = new UserDynamicLabelAdapter(new c(), this.mContentLabelInfo);
    }

    private void showBottomEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519308561")) {
            ipChange.ipc$dispatch("-519308561", new Object[]{this});
            return;
        }
        this.mRlCardView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRlCardView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
        if (isSelf()) {
            this.mBottomEndTv.setText("哎呀 只有这么多了 赶快去发布吧");
        } else {
            this.mBottomEndTv.setText("哎呀 只有这么多了");
        }
    }

    private void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596043507")) {
            ipChange.ipc$dispatch("596043507", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRlCardView.getLoadMoreFooterView().setVisibility(0);
        this.mRlCardView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548596799")) {
            ipChange.ipc$dispatch("548596799", new Object[]{this});
            return;
        }
        this.isFirstPageEmpty = true;
        NoteFeedAdapter noteFeedAdapter = this.mMultiAdapter;
        if (noteFeedAdapter != null) {
            noteFeedAdapter.c("这里空空的呢～");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showErrorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913936440")) {
            ipChange.ipc$dispatch("1913936440", new Object[]{this, str, str2});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showSmallErrorView(str, str2, new e());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSuccessView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577150519")) {
            ipChange.ipc$dispatch("-577150519", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1220867460")) {
            ipChange.ipc$dispatch("-1220867460", new Object[]{this});
            return;
        }
        this.mRlCardView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRlCardView.getLoadMoreFooterView().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSelectLabelData(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498509736")) {
            ipChange.ipc$dispatch("498509736", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int e2 = xf2.e(this.mContentLabelInfo);
        if (e2 > 0) {
            for (int i2 = 0; i2 < e2; i2++) {
                if (i2 == i) {
                    this.mContentLabelInfo.get(i2).isSelect = true;
                } else {
                    this.mContentLabelInfo.get(i2).isSelect = false;
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1295291764")) {
            return this.isViewCreated && isAdded() && this.mHandler.checkCanDoRefresh(ptrFrameLayout, this.mRlCardView, view2);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1295291764", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86375573")) {
            return (View) ipChange.ipc$dispatch("-86375573", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.fragment_user_dynamic, (ViewGroup) null);
        this.mActivity = getActivity();
        this.isViewCreated = true;
        initView();
        initData();
        request(null);
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005004564")) {
            ipChange.ipc$dispatch("2005004564", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.isViewCreated = false;
        br brVar = this.mDMMessage;
        if (brVar != null) {
            brVar.a();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385952278")) {
            ipChange.ipc$dispatch("385952278", new Object[]{this, view});
        } else if (this.isNextPage) {
            showBottomLoadMore();
            loadMore();
        } else if (!this.isFirstPageEmpty) {
            showBottomEmpty();
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914415987")) {
            ipChange.ipc$dispatch("-914415987", new Object[]{this, ptrFrameLayout, refreshCallBack});
            return;
        }
        request(new g(this, ptrFrameLayout));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987724374")) {
            ipChange.ipc$dispatch("-987724374", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mIsCardChanged) {
            this.mIsCardChanged = false;
            request(null);
        }
    }

    public void request(@Nullable OnBizListener<UserDynamicBean> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859864347")) {
            ipChange.ipc$dispatch("-1859864347", new Object[]{this, onBizListener});
            return;
        }
        this.currentPage = 1;
        this.mFirstRequest = true;
        if (!this.requesting) {
            this.requesting = true;
            if (onBizListener != null) {
                resetLabelData();
            }
            this.mOnceListener = onBizListener;
            UserDynamicRequest userDynamicRequest = new UserDynamicRequest();
            userDynamicRequest.pageIndex = this.currentPage;
            if (TextUtils.isEmpty(this.mUserId)) {
                this.mUserId = d20.i();
            }
            userDynamicRequest.publisherId = this.mUserId;
            userDynamicRequest.contentLabelList = this.mCurrentLabelType;
            userDynamicRequest.request(this.mDynamicListener);
        }
    }

    public void setDynamicUt(UtForDynamic utForDynamic) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294489536")) {
            ipChange.ipc$dispatch("-1294489536", new Object[]{this, utForDynamic});
            return;
        }
        this.mDynamicUt.a(utForDynamic);
    }

    @Override // cn.damai.commonbusiness.wannasee.adapter.IPublishView
    public void showPublishItemView(@Nullable MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765651430")) {
            ipChange.ipc$dispatch("-765651430", new Object[]{this, minepublishCheckBean});
            return;
        }
        this.mCheckBean = minepublishCheckBean;
        NoteFeedAdapter noteFeedAdapter = this.mMultiAdapter;
        if (noteFeedAdapter != null && this.mActivity != null) {
            noteFeedAdapter.showPublishItemView(minepublishCheckBean);
        }
    }

    public static MineDynamicFragment newInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616254645")) {
            return (MineDynamicFragment) ipChange.ipc$dispatch("-1616254645", new Object[]{str, str2});
        }
        MineDynamicFragment mineDynamicFragment = new MineDynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("utPageName", str2);
        mineDynamicFragment.setArguments(bundle);
        return mineDynamicFragment;
    }
}
