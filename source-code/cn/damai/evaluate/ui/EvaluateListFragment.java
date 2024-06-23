package cn.damai.evaluate.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentContentLabelBean;
import cn.damai.comment.bean.CommentPerformInfoBean;
import cn.damai.comment.bean.CommentProjectInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.EvaluateParams;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.evaluate.contract.EvaluateListContract;
import cn.damai.evaluate.presenter.EvaluateListPresenter;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.view.DMEvaluateListHeadView;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeeGuideTips;
import cn.damai.rank.view.WantSeeIconUpdate;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.view.DMActionButtonBgView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.fk;
import tb.ik;
import tb.jl1;
import tb.jy2;
import tb.n42;
import tb.p21;
import tb.re0;
import tb.v50;

/* compiled from: Taobao */
public class EvaluateListFragment extends DamaiBaseMvpFragment<EvaluateListPresenter, EvaluateListContract.Model> implements EvaluateListContract.View, OnRefreshListener, OnLoadMoreListener, EvaluateListCallBack {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int EVALUATELIST_ALLREADY = 2;
    public static int EVALUATELIST_REPERTOIRE = 1;
    private CommentContentLabelBean chooseLabel = new CommentContentLabelBean();
    private LinearLayout errorPageView;
    private int fromWhere;
    private DMEvaluateListHeadView headView;
    private IRecyclerView irc;
    private boolean isAllowShowWantSeeGuide;
    private boolean isResumeNow = false;
    private RelativeLayout labelHorizontalscrol;
    private FlowLayout labelLayout;
    LinearLayoutManager layoutManager;
    private View line;
    private ImageView mBack2Top;
    private EvaluateListAdapter mEvaluateListAdapter;
    private long mItemId;
    private int mScrollDistance;
    private ShowWantSeeGuideTask mSeeGuideTask = null;
    private boolean mShowEmptyView;
    private EvaluateItemDataBinder.EvaluateItemUTReportListener mUtDataConfiger;
    private WantSeePosterTips mWantSeePosterTips;
    private DMActionButtonBgView myEvaluateEntry;
    private int sceneType;
    private String selectId;
    private String selectLabel;
    private String selectLabelId;
    private String selectLabelType;
    TextView tvEmptyLabelTip;

    /* compiled from: Taobao */
    public class ShowWantSeeGuideTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        public boolean isFinishShowOneTime = false;

        /* compiled from: Taobao */
        public class a implements WantSeePosterTips.ActionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ CommentProjectInfoBean a;

            a(ShowWantSeeGuideTask showWantSeeGuideTask, CommentProjectInfoBean commentProjectInfoBean) {
                this.a = commentProjectInfoBean;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
            public void click() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1466237000")) {
                    ipChange.ipc$dispatch("1466237000", new Object[]{this});
                }
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
            public void hide(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1215418996")) {
                    ipChange.ipc$dispatch("-1215418996", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                ik.f(this.a.getProjectId(), j);
            }
        }

        public ShowWantSeeGuideTask() {
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-299212782")) {
                ipChange.ipc$dispatch("-299212782", new Object[]{this});
            } else if (!this.isFinishShowOneTime && EvaluateListFragment.this.isConditionAllowShowWantSee() && EvaluateListFragment.this.isResumeNow) {
                this.isFinishShowOneTime = true;
                CommentProjectInfoBean projectInfoBean = ((EvaluateListPresenter) EvaluateListFragment.this.mPresenter).getProjectInfoBean();
                EvaluateListFragment.this.updateWantSeeTips(projectInfoBean, false);
                EvaluateListFragment.this.mWantSeePosterTips.setListener(new a(this, projectInfoBean));
                EvaluateListFragment.this.mWantSeePosterTips.showAnim();
                WantSeeGuideTips.Companion.b(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements EvaluateItemDataBinder.SimpleItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(EvaluateListFragment evaluateListFragment) {
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.SimpleItemClickListener
        public void onSingleItemClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "902164427")) {
                ipChange.ipc$dispatch("902164427", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b(EvaluateListFragment evaluateListFragment) {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "442089969")) {
                ipChange.ipc$dispatch("442089969", new Object[]{this, obj});
                return;
            }
            CommentsItemBean commentsItemBean = (CommentsItemBean) obj;
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1135191666")) {
                ipChange.ipc$dispatch("1135191666", new Object[]{this, obj});
                return;
            }
            EvaluateListFragment.this.onRefresh();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ CommentProjectInfoBean b;

        d(boolean z, CommentProjectInfoBean commentProjectInfoBean) {
            this.a = z;
            this.b = commentProjectInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1564824550")) {
                ipChange.ipc$dispatch("1564824550", new Object[]{this, view});
                return;
            }
            EvaluateListFragment.this.mWantSeePosterTips.stopTimer();
            int i = !this.a ? 1 : 0;
            String projectId = this.b.getProjectId();
            ik.Q(this.a ? 1 : 0, projectId);
            EvaluateListFragment.this.requestFollow(i, projectId);
        }
    }

    static /* synthetic */ int access$212(EvaluateListFragment evaluateListFragment, int i) {
        int i2 = evaluateListFragment.mScrollDistance + i;
        evaluateListFragment.mScrollDistance = i2;
        return i2;
    }

    private void addEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704134957")) {
            ipChange.ipc$dispatch("-1704134957", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.damai_comment_empty_layout, (ViewGroup) null);
        this.tvEmptyLabelTip = (TextView) inflate.findViewById(R$id.tv_tip);
        inflate.setVisibility(8);
        this.irc.addHeaderView(inflate);
    }

    public static EvaluateListFragment getInstance(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791580797")) {
            return (EvaluateListFragment) ipChange.ipc$dispatch("-791580797", new Object[]{str, str2, str3});
        }
        EvaluateListFragment evaluateListFragment = new EvaluateListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putString(p21.ISSUE_PARAM_IPID, str2);
        bundle.putString("tourId", str3);
        evaluateListFragment.setArguments(bundle);
        return evaluateListFragment;
    }

    private int getScene(EvaluateParams evaluateParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265160093")) {
            return ((Integer) ipChange.ipc$dispatch("1265160093", new Object[]{this, evaluateParams})).intValue();
        } else if (evaluateParams.scriptId != null) {
            return 2;
        } else {
            return evaluateParams.storeId != null ? 1 : 0;
        }
    }

    private void initExtras() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32000433")) {
            ipChange.ipc$dispatch("32000433", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("projectId")) {
                try {
                    this.mItemId = Long.parseLong(arguments.getString("projectId"));
                } catch (Throwable unused) {
                }
            } else {
                this.mItemId = arguments.getLong("itemId");
            }
            this.isAllowShowWantSeeGuide = arguments.getBoolean(NewEvaluateListActivity.IS_ALLOW_SHOW_WANT_GUIDE, false);
            this.selectLabel = arguments.getString("labelName");
            this.selectLabelType = arguments.getString("labelType");
            this.selectLabelId = arguments.getString("labelId");
            this.selectId = arguments.getString("contentId");
            this.fromWhere = arguments.getInt("fromWhere", 0);
            EvaluateParams formBundle = EvaluateParams.formBundle(arguments);
            this.sceneType = getScene(formBundle);
            ((EvaluateListPresenter) this.mPresenter).initExtras(formBundle);
            if (!TextUtils.isEmpty(this.selectLabel) && !TextUtils.isEmpty(this.selectLabelType)) {
                ((EvaluateListPresenter) this.mPresenter).setContentLabelList(jl1.ARRAY_START_STR + this.selectLabelType + jl1.ARRAY_END_STR);
                ((EvaluateListPresenter) this.mPresenter).setContentLabelId(this.selectLabelId);
            }
        }
    }

    private void initRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283887742")) {
            ipChange.ipc$dispatch("283887742", new Object[]{this});
        } else if (this.irc == null) {
            this.mWantSeePosterTips = (WantSeePosterTips) this.rootView.findViewById(R$id.evaluate_list_want_see_guide);
            this.irc = (IRecyclerView) this.rootView.findViewById(R$id.evaluate_recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
            this.layoutManager = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.irc.setLayoutManager(this.layoutManager);
            this.irc.setLoadMoreEnabled(true);
            this.irc.setIsAutoToDefault(false);
            this.irc.setOnRefreshListener(this);
            this.irc.setOnLoadMoreListener(this);
            EvaluateListAdapter evaluateListAdapter = new EvaluateListAdapter((DamaiBaseActivity) this.mActivity, this.mItemId + "", this.sceneType);
            this.mEvaluateListAdapter = evaluateListAdapter;
            evaluateListAdapter.c(this.mUtDataConfiger);
            this.mEvaluateListAdapter.b(this);
            this.mEvaluateListAdapter.d(new a(this));
            this.irc.setAdapter(this.mEvaluateListAdapter);
            this.irc.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
            this.irc.getLoadMoreFooterView().setVisibility(8);
            ImageView imageView = (ImageView) this.rootView.findViewById(R$id.evaluate_back_to_top);
            this.mBack2Top = imageView;
            imageView.setOnClickListener(this);
            this.irc.addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class cn.damai.evaluate.ui.EvaluateListFragment.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-967117393")) {
                        ipChange.ipc$dispatch("-967117393", new Object[]{this, recyclerView, Integer.valueOf(i)});
                        return;
                    }
                    super.onScrollStateChanged(recyclerView, i);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    IpChange ipChange = $ipChange;
                    boolean z = false;
                    if (AndroidInstantRuntime.support(ipChange, "-1379593840")) {
                        ipChange.ipc$dispatch("-1379593840", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    super.onScrolled(recyclerView, i, i2);
                    if (EvaluateListFragment.this.layoutManager.findFirstVisibleItemPosition() <= 1 || EvaluateListFragment.this.labelLayout.getChildCount() <= 0) {
                        EvaluateListFragment.this.labelHorizontalscrol.setVisibility(8);
                    } else {
                        EvaluateListFragment.this.labelHorizontalscrol.setVisibility(0);
                    }
                    EvaluateListFragment.access$212(EvaluateListFragment.this, i2);
                    int i3 = DisplayMetrics.getheightPixels(v50.b(EvaluateListFragment.this.getActivity()));
                    int a2 = n42.a(EvaluateListFragment.this.getActivity(), 42.0f);
                    if (EvaluateListFragment.this.mScrollDistance > i3) {
                        z = true;
                    }
                    if (z) {
                        EvaluateListFragment.this.postWantSeeDelayTaskIfNeed();
                    }
                    re0.b(EvaluateListFragment.this.mBack2Top, z, a2);
                }
            });
            if (this.fromWhere == EVALUATELIST_REPERTOIRE) {
                this.irc.setRefreshEnabled(false);
            } else {
                this.irc.setRefreshEnabled(true);
                initScoreHeaderView();
            }
            addEmptyView();
        }
    }

    private void initScoreHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346887342")) {
            ipChange.ipc$dispatch("-1346887342", new Object[]{this});
            return;
        }
        this.headView = new DMEvaluateListHeadView(getActivity());
        if (!TextUtils.isEmpty(this.selectLabel) && !TextUtils.isEmpty(this.selectLabelType)) {
            this.headView.setInitSelectLabel(this.selectLabel, this.selectLabelType, this.selectLabelId);
        }
        this.irc.addHeaderView(this.headView);
    }

    private void initViewData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88206107")) {
            ipChange.ipc$dispatch("-88206107", new Object[]{this});
            return;
        }
        this.errorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
        this.labelHorizontalscrol = (RelativeLayout) this.rootView.findViewById(R$id.evaluate_label_horizontalscrol);
        this.labelLayout = (FlowLayout) this.rootView.findViewById(R$id.evaluate_label_layout);
        this.line = this.rootView.findViewById(R$id.evaluate_my_line);
        DMActionButtonBgView dMActionButtonBgView = (DMActionButtonBgView) this.rootView.findViewById(R$id.evaluate_my_action);
        this.myEvaluateEntry = dMActionButtonBgView;
        dMActionButtonBgView.setOnClickListener(this);
        this.myEvaluateEntry.update(getResources().getString(R$string.evaluate_my_entry));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isConditionAllowShowWantSee() {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677885788")) {
            return ((Boolean) ipChange.ipc$dispatch("1677885788", new Object[]{this})).booleanValue();
        }
        if (this.mWantSeePosterTips == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (!this.isAllowShowWantSeeGuide || activity == null || activity.isFinishing() || !jy2.INSTANCE.b() || (t = this.mPresenter) == null || !((EvaluateListPresenter) t).isProjectSupportWantSee()) {
            return false;
        }
        return true;
    }

    private void onListenerCommentPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744926694")) {
            ipChange.ipc$dispatch("744926694", new Object[]{this});
            return;
        }
        this.mDMMessage.b("comment_publish_success", new c());
    }

    private void onPraiseViewOnClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722381757")) {
            ipChange.ipc$dispatch("722381757", new Object[]{this});
            return;
        }
        this.mDMMessage.b("evaluate_praise", new b(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postWantSeeDelayTaskIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734743020")) {
            ipChange.ipc$dispatch("1734743020", new Object[]{this});
        } else if (!WantSeeGuideTips.Companion.a() && this.mSeeGuideTask == null && isConditionAllowShowWantSee()) {
            ShowWantSeeGuideTask showWantSeeGuideTask = new ShowWantSeeGuideTask();
            this.mSeeGuideTask = showWantSeeGuideTask;
            showWantSeeGuideTask.run();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestFollow(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279898361")) {
            ipChange.ipc$dispatch("-1279898361", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        startProgressDialog();
        AnonymousClass6 r0 = new FollowRequest() {
            /* class cn.damai.evaluate.ui.EvaluateListFragment.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.search.request.FollowRequest, cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
            public boolean getNeedEcode() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-120713260")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("-120713260", new Object[]{this})).booleanValue();
            }
        };
        r0.operateType = String.valueOf(i);
        r0.targetId = str;
        r0.targetType = "7";
        r0.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.evaluate.ui.EvaluateListFragment.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1183187890")) {
                    ipChange.ipc$dispatch("-1183187890", new Object[]{this, str, str2});
                    return;
                }
                EvaluateListFragment.this.stopProgressDialog();
                if (EvaluateListFragment.this.mWantSeePosterTips != null) {
                    EvaluateListFragment.this.mWantSeePosterTips.resumeTimer();
                }
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "-2109464622")) {
                    ipChange.ipc$dispatch("-2109464622", new Object[]{this, followDataBean});
                    return;
                }
                EvaluateListFragment.this.stopProgressDialog();
                if (EvaluateListFragment.this.mWantSeePosterTips != null) {
                    EvaluateListFragment.this.mWantSeePosterTips.resumeTimer();
                }
                T t = EvaluateListFragment.this.mPresenter;
                if (t != null && ((EvaluateListPresenter) t).getProjectInfoBean() != null) {
                    CommentProjectInfoBean projectInfoBean = ((EvaluateListPresenter) EvaluateListFragment.this.mPresenter).getProjectInfoBean();
                    if (followDataBean.getStatus() > 0) {
                        z = true;
                    }
                    projectInfoBean.wantSee = z;
                    EvaluateListFragment.this.updateWantSeeTips(projectInfoBean, true);
                }
            }
        });
    }

    private void setLabelDefault() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615127145")) {
            ipChange.ipc$dispatch("-1615127145", new Object[]{this});
            return;
        }
        CommentContentLabelBean commentContentLabelBean = new CommentContentLabelBean();
        commentContentLabelBean.setLabelName("全部");
        commentContentLabelBean.setPos(0);
        setChooseLabel(commentContentLabelBean);
    }

    private void setLabelStatusUpdate(int i, CommentContentLabelBean commentContentLabelBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951426593")) {
            ipChange.ipc$dispatch("-1951426593", new Object[]{this, Integer.valueOf(i), commentContentLabelBean});
            return;
        }
        FlowLayout flowLayout = this.labelLayout;
        if (flowLayout != null && flowLayout.getChildCount() > 0 && this.headView.getLabelList() != null && this.headView.getLabelList().getChildCount() > 0 && this.labelLayout.getChildAt(i) != null && (this.labelLayout.getChildAt(i) instanceof LinearLayout) && ((LinearLayout) this.labelLayout.getChildAt(i)).getChildCount() > 0 && this.headView.getLabelList().getChildAt(i) != null && (this.headView.getLabelList().getChildAt(i) instanceof LinearLayout) && ((LinearLayout) this.headView.getLabelList().getChildAt(i)).getChildCount() > 0 && (((LinearLayout) this.labelLayout.getChildAt(i)).getChildAt(0) instanceof TextView) && (((LinearLayout) this.headView.getLabelList().getChildAt(i)).getChildAt(0) instanceof TextView)) {
            TextView textView = (TextView) ((LinearLayout) this.labelLayout.getChildAt(i)).getChildAt(0);
            TextView textView2 = (TextView) ((LinearLayout) this.headView.getLabelList().getChildAt(i)).getChildAt(0);
            CommentContentLabelBean commentContentLabelBean2 = this.headView.getContentLabelInfo().get(i);
            if (commentContentLabelBean == null || !commentContentLabelBean.isStatusChoose()) {
                commentContentLabelBean2.setStatus("1");
            } else {
                commentContentLabelBean2.setStatus("0");
            }
            this.headView.setStyle(textView, commentContentLabelBean2.isStatusChoose(), commentContentLabelBean2.getLabelType());
            this.headView.setStyle(textView2, commentContentLabelBean2.isStatusChoose(), commentContentLabelBean2.getLabelType());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateWantSeeTips(CommentProjectInfoBean commentProjectInfoBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685833699")) {
            ipChange.ipc$dispatch("-1685833699", new Object[]{this, commentProjectInfoBean, Boolean.valueOf(z)});
            return;
        }
        String shortOptName = commentProjectInfoBean.getShortOptName();
        boolean z2 = commentProjectInfoBean.wantSee;
        String str = z2 ? "抢手热卖中，别忘了及时购票哦～" : "标「想看」，订阅更多演出信息～";
        WantSeePosterTips.b.a aVar = WantSeePosterTips.b.a.INSTANCE;
        aVar.s(new WantSeeIconUpdate(true, z2, z, new d(z2, commentProjectInfoBean)));
        aVar.u(shortOptName);
        aVar.r(commentProjectInfoBean.getProjectPoster());
        aVar.t(str);
        this.mWantSeePosterTips.setPageSource(aVar);
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void addDataAndRefresh(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562921768")) {
            ipChange.ipc$dispatch("1562921768", new Object[]{this, list});
            return;
        }
        this.mEvaluateListAdapter.a(list);
    }

    public CommentContentLabelBean getChooseLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-707162120")) {
            return this.chooseLabel;
        }
        return (CommentContentLabelBean) ipChange.ipc$dispatch("-707162120", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1399662795")) {
            return R$layout.evaluate_list_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1399662795", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504637405")) {
            ipChange.ipc$dispatch("1504637405", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        T t = this.mPresenter;
        if (t != null) {
            ((EvaluateListPresenter) t).resume();
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void hideEmptyView() {
        IRecyclerView iRecyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328815094")) {
            ipChange.ipc$dispatch("328815094", new Object[]{this});
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            this.errorPageView.setVisibility(8);
            if (this.mShowEmptyView && (iRecyclerView = this.irc) != null && iRecyclerView.getHeaderContainer() != null) {
                LinearLayout headerContainer = this.irc.getHeaderContainer();
                headerContainer.getChildAt(headerContainer.getChildCount() - 1).setVisibility(8);
                this.mShowEmptyView = false;
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769980398")) {
            ipChange.ipc$dispatch("769980398", new Object[]{this});
            return;
        }
        ((EvaluateListPresenter) this.mPresenter).setVM(this, (EvaluateListContract.Model) this.mModel);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612009967")) {
            ipChange.ipc$dispatch("1612009967", new Object[]{this});
            return;
        }
        initExtras();
        initRecycleView();
        initViewData();
        setLabelDefault();
        ((EvaluateListPresenter) this.mPresenter).create();
        onPraiseViewOnClick();
        T t = this.mPresenter;
        if (t != null) {
            ((EvaluateListPresenter) t).refresh(1);
        }
        onListenerCommentPublishSuccess();
    }

    @Override // cn.damai.evaluate.ui.EvaluateListCallBack
    public void labelClick(CommentContentLabelBean commentContentLabelBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1769124475")) {
            ipChange.ipc$dispatch("1769124475", new Object[]{this, commentContentLabelBean});
        } else if (!commentContentLabelBean.isStatusChoose()) {
            setLabelStatusUpdate(this.chooseLabel.getPos(), this.chooseLabel);
            setLabelStatusUpdate(commentContentLabelBean.getPos(), commentContentLabelBean);
            cn.damai.common.user.c.e().x(ik.I().D(commentContentLabelBean.getLabelName(), ((EvaluateListPresenter) this.mPresenter).getScriptId(), commentContentLabelBean.getPos()));
            setChooseLabel(commentContentLabelBean);
            this.headView.setInitSelectLabel(commentContentLabelBean.getLabelName(), commentContentLabelBean.getLabelType(), commentContentLabelBean.getLabelId());
            ((EvaluateListPresenter) this.mPresenter).setContentLabelList(jl1.ARRAY_START_STR + commentContentLabelBean.getLabelType() + jl1.ARRAY_END_STR);
            ((EvaluateListPresenter) this.mPresenter).setContentLabelId(commentContentLabelBean.getLabelId());
            ((EvaluateListPresenter) this.mPresenter).refresh(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005196120")) {
            ipChange.ipc$dispatch("-2005196120", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135499112")) {
            ipChange.ipc$dispatch("2135499112", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        this.mActivity = getActivity();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860140565")) {
            ipChange.ipc$dispatch("1860140565", new Object[]{this, view});
        } else if (view.getId() == R$id.evaluate_my_action) {
            if (((EvaluateListPresenter) this.mPresenter).getPerformInfo() != null && ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean() != null) {
                cn.damai.common.user.c.e().x(ik.I().P("1", String.valueOf(this.mItemId)));
                CommentItemMoreUtil.g(this.mActivity, ((EvaluateListPresenter) this.mPresenter).getPerformInfo().getPerformId(), ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getProjectId(), ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getProjectName(), ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getProjectPoster(), ((EvaluateListPresenter) this.mPresenter).getPerformInfo().getPerformValidTime(), CommentItemMoreUtil.n(((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getCityName(), ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getShowTime(), ((EvaluateListPresenter) this.mPresenter).getProjectInfoBean().getVenueName()));
            }
        } else if (view.getId() == R$id.evaluate_back_to_top) {
            this.irc.smoothScrollToPosition(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228024341")) {
            ipChange.ipc$dispatch("-228024341", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534861560")) {
            ipChange.ipc$dispatch("-534861560", new Object[]{this, view});
            return;
        }
        ((EvaluateListPresenter) this.mPresenter).loadMoreData();
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1104861480")) {
            ipChange.ipc$dispatch("-1104861480", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071756449")) {
            ipChange.ipc$dispatch("-2071756449", new Object[]{this});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256609169")) {
            ipChange.ipc$dispatch("-256609169", new Object[]{this});
            return;
        }
        super.onPause();
        this.isResumeNow = false;
        if (this.mSeeGuideTask != null && this.mWantSeePosterTips.isShowing()) {
            this.mWantSeePosterTips.stopTimer();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009942678")) {
            ipChange.ipc$dispatch("-2009942678", new Object[]{this});
            return;
        }
        ((EvaluateListPresenter) this.mPresenter).refresh(0);
        this.headView.setInitSelectLabel(null, null, null);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012130440")) {
            ipChange.ipc$dispatch("-2012130440", new Object[]{this});
            return;
        }
        super.onResume();
        this.isResumeNow = true;
        if (this.mSeeGuideTask != null && this.mWantSeePosterTips.isShowing()) {
            this.mWantSeePosterTips.resumeTimer();
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void refreshCommentStateScoreHeader(CommentsResultBean commentsResultBean, int i) {
        DMEvaluateListHeadView dMEvaluateListHeadView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1938374167")) {
            ipChange.ipc$dispatch("1938374167", new Object[]{this, commentsResultBean, Integer.valueOf(i)});
            return;
        }
        int i2 = this.fromWhere;
        if (i2 == EVALUATELIST_REPERTOIRE || i2 == EVALUATELIST_ALLREADY || (dMEvaluateListHeadView = this.headView) == null) {
            DMEvaluateListHeadView dMEvaluateListHeadView2 = this.headView;
            if (dMEvaluateListHeadView2 != null) {
                dMEvaluateListHeadView2.setVisibility(8);
                return;
            }
            return;
        }
        dMEvaluateListHeadView.setCallBack(this);
        this.headView.setData(commentsResultBean, i, this.labelHorizontalscrol, this.labelLayout);
    }

    @Override // cn.damai.evaluate.ui.EvaluateListCallBack
    public void resetLabel(CommentContentLabelBean commentContentLabelBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295765548")) {
            ipChange.ipc$dispatch("1295765548", new Object[]{this, commentContentLabelBean});
            return;
        }
        setLabelStatusUpdate(commentContentLabelBean.getPos(), commentContentLabelBean);
        setChooseLabel(commentContentLabelBean);
        this.headView.setInitSelectLabel(commentContentLabelBean.getLabelName(), commentContentLabelBean.getLabelType(), commentContentLabelBean.getLabelId());
        ((EvaluateListPresenter) this.mPresenter).setContentLabelList(jl1.ARRAY_START_STR + commentContentLabelBean.getLabelType() + jl1.ARRAY_END_STR);
        ((EvaluateListPresenter) this.mPresenter).setContentLabelId(commentContentLabelBean.getLabelId());
        ((EvaluateListPresenter) this.mPresenter).refresh(1);
    }

    @Override // cn.damai.evaluate.ui.EvaluateListCallBack
    public void setChooseLabel(CommentContentLabelBean commentContentLabelBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042592094")) {
            ipChange.ipc$dispatch("-2042592094", new Object[]{this, commentContentLabelBean});
            return;
        }
        this.chooseLabel = commentContentLabelBean;
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void setCommentHeaderLabel(CommentsResultBean commentsResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119188298")) {
            ipChange.ipc$dispatch("-2119188298", new Object[]{this, commentsResultBean});
            return;
        }
        this.headView.setCallBack(this);
        this.headView.setHeaderLabel(commentsResultBean, this.labelHorizontalscrol, this.labelLayout);
    }

    public void setEvalutateItemClickUTData(EvaluateItemDataBinder.EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434550391")) {
            ipChange.ipc$dispatch("-1434550391", new Object[]{this, evaluateItemUTReportListener});
            return;
        }
        this.mUtDataConfiger = evaluateItemUTReportListener;
    }

    @Override // cn.damai.evaluate.ui.EvaluateListCallBack
    public void setItemExposure(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257600613")) {
            ipChange.ipc$dispatch("1257600613", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("evaluate_id", str);
            hashMap.put("usercode", d20.E());
        }
        cn.damai.common.user.c.e().G(view, "item_" + i, "evaluate_tab_" + getChooseLabel().getPos(), ik.EVALUATE_LIST_PAGE, hashMap);
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457142479")) {
            ipChange.ipc$dispatch("-457142479", new Object[]{this});
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            if (!TextUtils.isEmpty(((EvaluateListPresenter) this.mPresenter).getContentLabelList())) {
                LinearLayout headerContainer = this.irc.getHeaderContainer();
                headerContainer.getChildAt(headerContainer.getChildCount() - 1).setVisibility(0);
                if (this.chooseLabel != null) {
                    TextView textView = this.tvEmptyLabelTip;
                    textView.setText("暂时还没有" + this.chooseLabel.getLabelName() + "的评价");
                }
                this.mShowEmptyView = true;
                return;
            }
            this.errorPageView.setVisibility(0);
            onResponseError(3, this.fromWhere == EVALUATELIST_ALLREADY ? "你还没有评价过演出哦" : "暂时没有评价哦", "", "", this.errorPageView, true);
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void showEntryView(CommentPerformInfoBean commentPerformInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480854407")) {
            ipChange.ipc$dispatch("1480854407", new Object[]{this, commentPerformInfoBean});
        } else if (commentPerformInfoBean != null) {
            this.line.setVisibility(0);
            this.myEvaluateEntry.setVisibility(0);
        } else {
            this.line.setVisibility(8);
            this.myEvaluateEntry.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737039443")) {
            ipChange.ipc$dispatch("-737039443", new Object[]{this, str});
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(str)) {
            ToastUtil.a().e(this.mActivity, str);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661402415")) {
            ipChange.ipc$dispatch("-661402415", new Object[]{this, str});
            return;
        }
        startProgressDialog();
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void showTip(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762139932")) {
            ipChange.ipc$dispatch("1762139932", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        onResponseError(str2, str, "mtop.damai.wireless.comment.list.get", this.errorPageView, true);
        ToastUtil.a().e(this.mActivity, str2);
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void startRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639622051")) {
            ipChange.ipc$dispatch("-639622051", new Object[]{this});
            return;
        }
        IRecyclerView iRecyclerView = this.irc;
        if (iRecyclerView != null) {
            iRecyclerView.setRefreshing(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782419852")) {
            ipChange.ipc$dispatch("1782419852", new Object[]{this});
            return;
        }
        stopProgressDialog();
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void stopRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063509307")) {
            ipChange.ipc$dispatch("1063509307", new Object[]{this});
            return;
        }
        IRecyclerView iRecyclerView = this.irc;
        if (iRecyclerView != null) {
            iRecyclerView.setRefreshing(false);
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.View
    public void updateData(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13445154")) {
            ipChange.ipc$dispatch("13445154", new Object[]{this, list});
            return;
        }
        this.mEvaluateListAdapter.setData(list);
    }
}
