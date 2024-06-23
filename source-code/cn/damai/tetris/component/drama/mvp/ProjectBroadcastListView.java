package cn.damai.tetris.component.drama.mvp;

import android.app.Application;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.ProjectListBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.ProjectBroadcastHorAdapter;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.tf;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class ProjectBroadcastListView extends AbsView<ProjectBroadcastListContract.Presenter> implements ProjectBroadcastListContract.View<ProjectBroadcastListContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isShowNumSwiped = false;
    private ProjectBroadcastHorAdapter mAdapter;
    private ProjectListBean mBean;
    private int mEdgePadding;
    private int mItemOffset;
    private TextView mNowTv;
    private View mNumSwipeV;
    private tf mPanel;
    private RecyclerView mRecyclerView;
    private View mTitleLayout;
    private TextView mTotalTv;

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<ProjectShowBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, ProjectShowBean projectShowBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-227964975")) {
                ipChange.ipc$dispatch("-227964975", new Object[]{this, view, projectShowBean, Integer.valueOf(i)});
                return;
            }
            String str = null;
            if (!(ProjectBroadcastListView.this.mBean == null || ProjectBroadcastListView.this.mBean.mTitleBean == null)) {
                str = ProjectBroadcastListView.this.mBean.mTitleBean.title;
            }
            ((ProjectBroadcastListContract.Presenter) ProjectBroadcastListView.this.getPresenter()).exposeItem(view, projectShowBean, i, str);
        }

        /* renamed from: b */
        public void onItemClick(ProjectShowBean projectShowBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1938394362")) {
                ipChange.ipc$dispatch("-1938394362", new Object[]{this, projectShowBean, Integer.valueOf(i)});
                return;
            }
            ((ProjectBroadcastListContract.Presenter) ProjectBroadcastListView.this.getPresenter()).itemClick(ProjectBroadcastListView.this, projectShowBean, i);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "314397374")) {
                ipChange.ipc$dispatch("314397374", new Object[]{this, view});
                return;
            }
            ((ProjectBroadcastListContract.Presenter) ProjectBroadcastListView.this.getPresenter()).allClick(ProjectBroadcastListView.this, this.a);
        }
    }

    public ProjectBroadcastListView(View view) {
        super(view);
        Application a2 = xs0.a();
        this.mEdgePadding = n42.a(a2, 21.0f);
        this.mItemOffset = n42.a(a2, 12.0f);
        this.mNowTv = (TextView) view.findViewById(R$id.item_now_tv);
        this.mTotalTv = (TextView) view.findViewById(R$id.item_total_tv);
        this.mTitleLayout = view.findViewById(R$id.card_title_layout);
        this.mNumSwipeV = view.findViewById(R$id.item_count_tip_layout);
        this.mPanel = new tf(this.mTitleLayout);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.project_broadcast_recycler);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(a2, 0, false));
        this.mAdapter = new ProjectBroadcastHorAdapter(new a());
        this.mRecyclerView.setItemViewCacheSize(-1);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1474629975")) {
                    ipChange.ipc$dispatch("1474629975", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                ProjectBroadcastListView.this.dispatchScrollX(recyclerView, i);
            }
        });
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "-1788898431")) {
                    ipChange.ipc$dispatch("-1788898431", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null && adapter.getItemCount() > 0) {
                    if (childAdapterPosition != adapter.getItemCount() - 1) {
                        z = false;
                    }
                    if (childAdapterPosition == 0) {
                        rect.left = ProjectBroadcastListView.this.mEdgePadding;
                    } else {
                        rect.left = 0;
                    }
                    if (z) {
                        rect.right = ProjectBroadcastListView.this.mEdgePadding;
                    } else {
                        rect.right = ProjectBroadcastListView.this.mItemOffset;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchScrollX(RecyclerView recyclerView, int i) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267667672")) {
            ipChange.ipc$dispatch("-267667672", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (i != 0 && this.isShowNumSwiped) {
            int childCount = recyclerView.getChildCount();
            if (childCount == 1) {
                this.mNowTv.setText("1");
            } else if (childCount > 1 && (childAt = recyclerView.getChildAt(childCount - 1)) != null) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAt.getRight() > this.mRecyclerView.getMeasuredWidth()) {
                    childAdapterPosition--;
                }
                this.mNowTv.setText((childAdapterPosition + 1) + "");
            }
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.View
    public void setData(ProjectListBean projectListBean, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1983952304")) {
            ipChange.ipc$dispatch("1983952304", new Object[]{this, projectListBean, Integer.valueOf(i)});
        } else if (projectListBean != null) {
            this.mBean = projectListBean;
            int e = xf2.e(projectListBean.result);
            this.mAdapter.d(projectListBean.result);
            CardTitleBean cardTitleBean = projectListBean.mTitleBean;
            this.mPanel.h(cardTitleBean);
            if (cardTitleBean == null || !cardTitleBean.hasUrl()) {
                this.mPanel.a(null);
            } else {
                this.mPanel.a(new b(cardTitleBean.url));
            }
            if ((cardTitleBean != null && cardTitleBean.showAll) || e < 2) {
                z = false;
            }
            this.isShowNumSwiped = z;
            if (z) {
                this.mTotalTv.setText("/" + e);
                this.mRecyclerView.post(new Runnable() {
                    /* class cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.AnonymousClass5 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "205447121")) {
                            ipChange.ipc$dispatch("205447121", new Object[]{this});
                            return;
                        }
                        ProjectBroadcastListView projectBroadcastListView = ProjectBroadcastListView.this;
                        projectBroadcastListView.dispatchScrollX(projectBroadcastListView.mRecyclerView, -1);
                    }
                });
            }
            View view = this.mNumSwipeV;
            if (!this.isShowNumSwiped) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }
}
