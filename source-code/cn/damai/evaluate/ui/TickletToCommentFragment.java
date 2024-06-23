package cn.damai.evaluate.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.evaluate.adapter.TickletToEvaluateAdapter;
import cn.damai.evaluate.request.CommentListRequest;
import cn.damai.evaluate.request.ToCommentListRequest;
import cn.damai.issue.net.ToEvaListResponse;
import cn.damai.message.observer.Action;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.p21;
import tb.sl2;
import tb.v50;
import tb.wl2;
import tb.yz2;

/* compiled from: Taobao */
public class TickletToCommentFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int hasMore;
    private View headerView;
    private ImageView imgeGift;
    private IRecyclerView irc;
    private boolean isHttpRequestFinish = true;
    private boolean isImageLoadSuccess = false;
    private LinearLayout mErrorPageView;
    private String mPagingKey;
    private TickletToEvaluateAdapter mTickletToEvaluateAdapter;

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2099126398")) {
                ipChange.ipc$dispatch("2099126398", new Object[]{this, obj});
                return;
            }
            TickletToCommentFragment.this.onRefresh();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ToEvaListResponse a;

        b(ToEvaListResponse toEvaListResponse) {
            this.a = toEvaListResponse;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1883594740")) {
                ipChange.ipc$dispatch("1883594740", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a.commentGiftLink) && TickletToCommentFragment.this.mActivity != null) {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a.commentGiftLink);
                DMNav.from(TickletToCommentFragment.this.mActivity).withExtras(bundle).toUri(NavUri.b(a.c.d));
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "423118759")) {
                ipChange.ipc$dispatch("423118759", new Object[]{this, dVar});
                return;
            }
            TickletToCommentFragment.this.imgeGift.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1141137412")) {
                ipChange.ipc$dispatch("-1141137412", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
                TickletToCommentFragment.this.imgeGift.setVisibility(8);
            } else {
                TickletToCommentFragment.this.imgeGift.setVisibility(0);
                TickletToCommentFragment.this.imgeGift.setImageBitmap(eVar.b);
                TickletToCommentFragment.this.isImageLoadSuccess = true;
            }
        }
    }

    private void fetchNewCommentListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024772970")) {
            ipChange.ipc$dispatch("-1024772970", new Object[]{this});
            return;
        }
        CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.targetType = "0";
        commentListRequest.commentType = "32";
        commentListRequest.onTop = "true";
        commentListRequest.pageIndex = "1";
        commentListRequest.pageSize = "10";
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) {
            /* class cn.damai.evaluate.ui.TickletToCommentFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "764370521")) {
                    ipChange.ipc$dispatch("764370521", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1490451390")) {
                    ipChange.ipc$dispatch("1490451390", new Object[]{this, commentsResultBean});
                    return;
                }
                TickletToCommentFragment.this.refreshHeaderView(commentsResultBean);
            }
        });
    }

    private void fetchToCommentListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605388703")) {
            ipChange.ipc$dispatch("-605388703", new Object[]{this});
            return;
        }
        if (getUserVisibleHint()) {
            startProgressDialog();
        }
        ToCommentListRequest toCommentListRequest = new ToCommentListRequest();
        toCommentListRequest.pagingKey = this.mPagingKey;
        this.isHttpRequestFinish = false;
        toCommentListRequest.request(new DMMtopRequestListener<ToEvaListResponse>(ToEvaListResponse.class) {
            /* class cn.damai.evaluate.ui.TickletToCommentFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "772129880")) {
                    ipChange.ipc$dispatch("772129880", new Object[]{this, str, str2});
                    return;
                }
                TickletToCommentFragment.this.stopProgressDialog();
                TickletToCommentFragment.this.isHttpRequestFinish = true;
                TickletToCommentFragment.this.mTickletToEvaluateAdapter.clear();
                TickletToCommentFragment.this.irc.setVisibility(8);
                TickletToCommentFragment.this.mErrorPageView.setVisibility(0);
                TickletToCommentFragment tickletToCommentFragment = TickletToCommentFragment.this;
                tickletToCommentFragment.onResponseError(str2, str, "mtop.damai.wireless.ticklet.comment.get", tickletToCommentFragment.mErrorPageView, true);
                TickletToCommentFragment.this.toCommentListErrorXFlushMonitor(str, str2);
            }

            public void onSuccess(ToEvaListResponse toEvaListResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "369295907")) {
                    ipChange.ipc$dispatch("369295907", new Object[]{this, toEvaListResponse});
                    return;
                }
                TickletToCommentFragment.this.stopProgressDialog();
                TickletToCommentFragment.this.mErrorPageView.setVisibility(8);
                TickletToCommentFragment.this.irc.setVisibility(0);
                TickletToCommentFragment.this.refreshUI(toEvaListResponse);
            }
        });
    }

    public static TickletToCommentFragment getInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818220197")) {
            return (TickletToCommentFragment) ipChange.ipc$dispatch("-818220197", new Object[]{str, str2});
        }
        TickletToCommentFragment tickletToCommentFragment = new TickletToCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putString(p21.ISSUE_PARAM_IPID, str2);
        tickletToCommentFragment.setArguments(bundle);
        return tickletToCommentFragment;
    }

    private void giftImageLoad(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768431280")) {
            ipChange.ipc$dispatch("-768431280", new Object[]{this, str});
            return;
        }
        cn.damai.common.image.a.b().e(str).n(new d()).e(new c()).f();
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606799546")) {
            ipChange.ipc$dispatch("1606799546", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.ticklet_history_list_irecyclerview);
        TickletToEvaluateAdapter tickletToEvaluateAdapter = new TickletToEvaluateAdapter(this.mActivity);
        this.mTickletToEvaluateAdapter = tickletToEvaluateAdapter;
        this.irc.setAdapter(tickletToEvaluateAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(linearLayoutManager);
        this.irc.setRefreshEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnRefreshListener(this);
        this.irc.setOnLoadMoreListener(this);
        this.irc.setLoadMoreEnabled(true);
        this.irc.getLoadMoreFooterView().setVisibility(8);
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.ticklet_tocomment_topflipper, (ViewGroup) null);
        this.headerView = inflate;
        this.irc.addHeaderView(this.headerView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((FrameLayout) inflate.findViewById(R$id.tocomment_topflipper_container)).getLayoutParams();
        layoutParams.leftMargin = v50.a(this.mActivity, 21.0f);
        layoutParams.rightMargin = v50.a(this.mActivity, 21.0f);
        this.irc.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this.mActivity));
    }

    private void initPageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772237039")) {
            ipChange.ipc$dispatch("772237039", new Object[]{this});
            return;
        }
        this.mErrorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
        this.imgeGift = (ImageView) this.rootView.findViewById(R$id.ticklet_tocomment_gift);
    }

    private void onListenerCommentPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289701513")) {
            ipChange.ipc$dispatch("-1289701513", new Object[]{this});
            return;
        }
        this.mDMMessage.b("comment_publish_success", new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshHeaderView(CommentsResultBean commentsResultBean) {
        List<CommentsItemBean> data;
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763876188")) {
            ipChange.ipc$dispatch("-763876188", new Object[]{this, commentsResultBean});
            return;
        }
        ViewFlipper viewFlipper = (ViewFlipper) this.headerView.findViewById(R$id.viewflipper);
        if (!(commentsResultBean == null || (data = commentsResultBean.getData()) == null || data.size() <= 0)) {
            viewFlipper.removeAllViews();
            for (CommentsItemBean commentsItemBean : data) {
                View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.ticklet_tocomment_viewflipper_layout, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.ticklet_comment_header);
                TextView textView = (TextView) inflate.findViewById(R$id.ticklet_comment_content);
                CommentUserDoBean userDO = commentsItemBean.getUserDO();
                if (userDO != null && !TextUtils.isEmpty(userDO.getHeaderImage())) {
                    cn.damai.common.image.a.b().c(userDO.getHeaderImage()).g(imageView);
                }
                List<CommentTextDoBean> textDOList = commentsItemBean.getTextDOList();
                if (textDOList != null && textDOList.size() > 0 && (commentTextDoBean = textDOList.get(0)) != null && !TextUtils.isEmpty(commentTextDoBean.getValue())) {
                    textView.setText(commentTextDoBean.getValue());
                }
                viewFlipper.addView(inflate);
            }
            viewFlipper.startFlipping();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshUI(ToEvaListResponse toEvaListResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487104954")) {
            ipChange.ipc$dispatch("-487104954", new Object[]{this, toEvaListResponse});
            return;
        }
        this.irc.setRefreshing(false);
        if (toEvaListResponse != null) {
            this.mPagingKey = toEvaListResponse.getPagingKey();
            List<ToEvaListResponse.EvaluateInfo> performCardInfoList = toEvaListResponse.getPerformCardInfoList();
            if (performCardInfoList == null || performCardInfoList.size() <= 0) {
                if (TextUtils.isEmpty(this.mPagingKey)) {
                    this.mTickletToEvaluateAdapter.clear();
                }
                this.isHttpRequestFinish = true;
                this.mErrorPageView.setVisibility(0);
                onResponseError(3, getString(R$string.ticklet_tocomment_list_empty_tips), "", "", this.mErrorPageView, true);
            } else {
                this.mErrorPageView.setVisibility(8);
                if (this.hasMore == 1) {
                    this.mTickletToEvaluateAdapter.c(performCardInfoList);
                } else {
                    this.mTickletToEvaluateAdapter.setData(performCardInfoList);
                }
                this.hasMore = Integer.parseInt(toEvaListResponse.getHasMore());
                this.isHttpRequestFinish = true;
            }
            if (!TextUtils.isEmpty(toEvaListResponse.commentGiftIcon) && !this.isImageLoadSuccess) {
                giftImageLoad(toEvaListResponse.commentGiftIcon);
                ((RelativeLayout.LayoutParams) this.imgeGift.getLayoutParams()).bottomMargin = (DisplayMetrics.getheightPixels(v50.b(this.mActivity)) * 40) / 100;
                this.imgeGift.setOnClickListener(new b(toEvaListResponse));
                return;
            }
            return;
        }
        this.isHttpRequestFinish = true;
        this.mErrorPageView.setVisibility(0);
        onResponseError(3, getString(R$string.ticklet_tocomment_list_empty_tips), "", "", this.mErrorPageView, true);
    }

    private void resetPageState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636582240")) {
            ipChange.ipc$dispatch("636582240", new Object[]{this});
            return;
        }
        this.mPagingKey = "";
        this.hasMore = 0;
        this.imgeGift.setVisibility(8);
        this.isImageLoadSuccess = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toCommentListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361571683")) {
            ipChange.ipc$dispatch("1361571683", new Object[]{this, str, str2});
        } else if (!"FAIL_SYS_SESSION_EXPIRED".equals(str)) {
            yz2.a(wl2.a("mtop.damai.wireless.ticklet.comment.get", str, str2), "-5830", "票夹待评价列表加载失败");
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1052890140")) {
            return R$layout.ticklet_tocomment_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1052890140", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215922668")) {
            ipChange.ipc$dispatch("215922668", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        resetPageState();
        fetchToCommentListData();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525470785")) {
            ipChange.ipc$dispatch("-525470785", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1350535298")) {
            ipChange.ipc$dispatch("-1350535298", new Object[]{this});
            return;
        }
        if (this.mActivity == null) {
            this.mActivity = getActivity();
        }
        setDamaiUTKeyBuilder(new a.b().j(new HashMap()).i(sl2.TICKLET_MYCOMMENT_LIST_PAGE));
        initPageView();
        initIRecyclerView();
        fetchToCommentListData();
        fetchNewCommentListData();
        onListenerCommentPublishSuccess();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540881892")) {
            ipChange.ipc$dispatch("1540881892", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782571737")) {
            ipChange.ipc$dispatch("1782571737", new Object[]{this, view});
        } else if (this.hasMore == 1 && this.isHttpRequestFinish) {
            fetchToCommentListData();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640434619")) {
            ipChange.ipc$dispatch("640434619", new Object[]{this});
        } else if (this.isHttpRequestFinish) {
            resetPageState();
            fetchToCommentListData();
        }
    }
}
