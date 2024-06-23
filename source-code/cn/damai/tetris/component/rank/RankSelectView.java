package cn.damai.tetris.component.rank;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.adapter.RankSelectAdapter;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i42;
import tb.k21;
import tb.m42;
import tb.xs0;

/* compiled from: Taobao */
public final class RankSelectView extends AbsView<RankSelectPresenter> implements RankSelectContract.View<RankSelectPresenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RankSelectAdapter mAdapter;
    @NotNull
    private final TUrlImageView mBack;
    private final int mEdgePadding = m42.a(xs0.a(), 12.0f);
    private int mPos;
    private final int mRightSize = m42.a(xs0.a(), 6.0f);

    /* compiled from: Taobao */
    public static final class a implements OnItemBindListener<RankSelectItemBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankSelectView a;

        a(RankSelectView rankSelectView) {
            this.a = rankSelectView;
        }

        /* renamed from: a */
        public void exposeItem(@Nullable View view, @NotNull RankSelectItemBean rankSelectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1876557740")) {
                ipChange.ipc$dispatch("1876557740", new Object[]{this, view, rankSelectItemBean, Integer.valueOf(i)});
                return;
            }
            k21.i(rankSelectItemBean, "bean");
            IPresenter presenter = this.a.getPresenter();
            k21.f(presenter);
            ((RankSelectPresenter) presenter).expose(view, rankSelectItemBean, i);
        }

        /* renamed from: b */
        public void onItemClick(@Nullable RankSelectItemBean rankSelectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1865292897")) {
                ipChange.ipc$dispatch("1865292897", new Object[]{this, rankSelectItemBean, Integer.valueOf(i)});
                return;
            }
            IPresenter presenter = this.a.getPresenter();
            k21.f(presenter);
            ((RankSelectPresenter) presenter).itemClick(this.a, rankSelectItemBean, i);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RankSelectView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        View findViewById = view.findViewById(R$id.rank_select_recycler);
        k21.h(findViewById, "view.findViewById(R.id.rank_select_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R$id.rank_bg_img);
        k21.h(findViewById2, "view.findViewById(R.id.rank_bg_img)");
        TUrlImageView tUrlImageView = (TUrlImageView) findViewById2;
        this.mBack = tUrlImageView;
        tUrlImageView.setImageUrl(i42.p("bg_rank_square_apng.png"));
        recyclerView.setLayoutManager(new LinearLayoutManager(xs0.a(), 0, false));
        RankSelectAdapter rankSelectAdapter = new RankSelectAdapter(new a(this));
        this.mAdapter = rankSelectAdapter;
        recyclerView.setAdapter(rankSelectAdapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(this) {
            /* class cn.damai.tetris.component.rank.RankSelectView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ RankSelectView a;

            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1437442051")) {
                    ipChange.ipc$dispatch("1437442051", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                k21.i(rect, "outRect");
                k21.i(view, "view");
                k21.i(recyclerView, "parent");
                k21.i(state, "state");
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0) {
                    rect.left = this.a.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == this.a.mAdapter.getItemCount() - 1) {
                    rect.right = this.a.mEdgePadding;
                } else {
                    rect.right = this.a.mRightSize;
                }
            }
        });
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.View
    public void setData(@Nullable RankSelectBean rankSelectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867434953")) {
            ipChange.ipc$dispatch("-1867434953", new Object[]{this, rankSelectBean, Integer.valueOf(i)});
        } else if (rankSelectBean != null) {
            this.mPos = i;
            this.mAdapter.d(rankSelectBean.result);
        }
    }
}
