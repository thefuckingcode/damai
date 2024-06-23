package cn.damai.tetris.component.drama.mvp;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.DramaList;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract;
import cn.damai.tetris.component.drama.viewholder.DramaListV2RecyAdapter;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m42;
import tb.tf;
import tb.xs0;

/* compiled from: Taobao */
public class DramaWorthSeeView extends AbsView<DramaWorthSeeContract.Presenter> implements DramaWorthSeeContract.View<DramaWorthSeeContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DramaListV2RecyAdapter mAdapter;
    private final int mEdgePadding = m42.a(xs0.a(), 21.0f);
    private final tf mPanel;
    private int mPos;
    private final int mRightSize = m42.a(xs0.a(), 12.0f);

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<DramaV2Bean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, DramaV2Bean dramaV2Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-476949965")) {
                ipChange.ipc$dispatch("-476949965", new Object[]{this, view, dramaV2Bean, Integer.valueOf(i)});
                return;
            }
            ((DramaWorthSeeContract.Presenter) DramaWorthSeeView.this.getPresenter()).expose(view, dramaV2Bean, i);
        }

        /* renamed from: b */
        public void onItemClick(DramaV2Bean dramaV2Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1467570984")) {
                ipChange.ipc$dispatch("1467570984", new Object[]{this, dramaV2Bean, Integer.valueOf(i)});
                return;
            }
            ((DramaWorthSeeContract.Presenter) DramaWorthSeeView.this.getPresenter()).itemClick(DramaWorthSeeView.this, dramaV2Bean, i);
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
            if (AndroidInstantRuntime.support(ipChange, "301267537")) {
                ipChange.ipc$dispatch("301267537", new Object[]{this, view});
                return;
            }
            DramaWorthSeeView dramaWorthSeeView = DramaWorthSeeView.this;
            ((DramaWorthSeeContract.Presenter) DramaWorthSeeView.this.getPresenter()).itemAllClick(dramaWorthSeeView, this.a, dramaWorthSeeView.mPos);
        }
    }

    public DramaWorthSeeView(View view) {
        super(view);
        this.mPanel = new tf(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.drama_worth_recycler);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.tetris.component.drama.mvp.DramaWorthSeeView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-468650861")) {
                    ipChange.ipc$dispatch("-468650861", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0) {
                    rect.left = DramaWorthSeeView.this.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == DramaWorthSeeView.this.mAdapter.getItemCount() - 1) {
                    rect.right = DramaWorthSeeView.this.mEdgePadding;
                } else {
                    rect.right = DramaWorthSeeView.this.mRightSize;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(xs0.a(), 0, false));
        DramaListV2RecyAdapter dramaListV2RecyAdapter = new DramaListV2RecyAdapter(new a());
        this.mAdapter = dramaListV2RecyAdapter;
        recyclerView.setAdapter(dramaListV2RecyAdapter);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract.View
    public void setData(DramaList dramaList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187960126")) {
            ipChange.ipc$dispatch("-1187960126", new Object[]{this, dramaList, Integer.valueOf(i)});
        } else if (dramaList != null) {
            this.mPos = i;
            this.mAdapter.d(dramaList.result);
            CardTitleBean cardTitleBean = dramaList.mTitleBean;
            if (cardTitleBean != null) {
                this.mPanel.g(true);
                this.mPanel.f(cardTitleBean.title);
                this.mPanel.d(true);
                this.mPanel.e("全部");
                if (cardTitleBean.hasUrl()) {
                    this.mPanel.a(new b(cardTitleBean.url));
                    return;
                }
                this.mPanel.a(null);
                return;
            }
            this.mPanel.g(false);
        }
    }
}
