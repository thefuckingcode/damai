package cn.damai.search.v2.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.ui.viewholder.SearchEggRecommendViewHolderV2;
import cn.damai.search.ui.viewholder.SearchTipViewHolder;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class EggAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SearchDataHolder> a = new ArrayList();
    private Context b;
    private SearchEggRecommendViewHolderV2.OnEggListener c;
    private OnProjectClickListener d;
    private String e;
    public Daojishi f = new Daojishi(true);

    /* compiled from: Taobao */
    public interface OnProjectClickListener {
        void onProjectClick(SearchEggs searchEggs, View view, ProjectItemBean projectItemBean, int i);

        void onProjectExpose(View view, ProjectItemBean projectItemBean, int i);
    }

    /* compiled from: Taobao */
    public class a implements SearchTipViewHolder.OnLoadMoreClick {
        private static transient /* synthetic */ IpChange $ipChange;

        a(EggAdapter eggAdapter) {
        }

        @Override // cn.damai.search.ui.viewholder.SearchTipViewHolder.OnLoadMoreClick
        public void onLoadMoreBtnClick(@Nullable List<SearchDataHolder> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "817606982")) {
                ipChange.ipc$dispatch("817606982", new Object[]{this, list});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SearchEggs a;
        final /* synthetic */ ProjectItemViewHolder b;
        final /* synthetic */ ProjectItemBean c;
        final /* synthetic */ int d;

        b(SearchEggs searchEggs, ProjectItemViewHolder projectItemViewHolder, ProjectItemBean projectItemBean, int i) {
            this.a = searchEggs;
            this.b = projectItemViewHolder;
            this.c = projectItemBean;
            this.d = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1134299917")) {
                ipChange.ipc$dispatch("1134299917", new Object[]{this, view});
            } else if (EggAdapter.this.d != null) {
                EggAdapter.this.d.onProjectClick(this.a, this.b.itemView, this.c, this.d);
            }
        }
    }

    public EggAdapter(Context context) {
        this.b = context;
    }

    private void d(ProjectItemBean projectItemBean, boolean z, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072509185")) {
            ipChange.ipc$dispatch("-2072509185", new Object[]{this, projectItemBean, Boolean.valueOf(z), view, Integer.valueOf(i)});
        } else if (projectItemBean != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", projectItemBean.id);
            hashMap.put("keyword", this.e);
            hashMap.put("contentlable", projectItemBean.name);
            if (!TextUtils.isEmpty(projectItemBean.alg)) {
                hashMap.put("alg", projectItemBean.alg);
            }
            if (!z) {
                c e2 = c.e();
                e2.G(view, "item_" + i, "list", "search", hashMap);
                return;
            }
            c e3 = c.e();
            e3.G(view, "item_" + i, "keywordother", "search", hashMap);
        }
    }

    public void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21437648")) {
            ipChange.ipc$dispatch("21437648", new Object[]{this, str});
            return;
        }
        this.e = str;
    }

    public void c(SearchEggRecommendViewHolderV2.OnEggListener onEggListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "203847956")) {
            ipChange.ipc$dispatch("203847956", new Object[]{this, onEggListener});
            return;
        }
        this.c = onEggListener;
    }

    public void e(OnProjectClickListener onProjectClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430770115")) {
            ipChange.ipc$dispatch("-1430770115", new Object[]{this, onProjectClickListener});
            return;
        }
        this.d = onProjectClickListener;
    }

    public void f(List<SearchDataHolder> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555638742")) {
            ipChange.ipc$dispatch("1555638742", new Object[]{this, list});
            return;
        }
        this.a.clear();
        if (!f92.d(list)) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1301174085")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1301174085", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1647981086")) {
            return this.a.get(i).mType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1647981086", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659401378")) {
            ipChange.ipc$dispatch("-1659401378", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        SearchDataHolder searchDataHolder = this.a.get(i);
        int i2 = searchDataHolder.mType;
        if (i2 == 0) {
            ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
            ProjectItemBean projectItemBean = searchDataHolder.mProjectItem;
            SearchEggs searchEggs = searchDataHolder.mSearchEggs;
            projectItemViewHolder.u(this.f);
            projectItemViewHolder.l(projectItemBean, BricksProjectViewHolder.PageType.SEARCH_PAGE);
            projectItemViewHolder.itemView.setOnClickListener(new b(searchEggs, projectItemViewHolder, projectItemBean, i));
            OnProjectClickListener onProjectClickListener = this.d;
            if (onProjectClickListener != null) {
                onProjectClickListener.onProjectExpose(projectItemViewHolder.itemView, projectItemBean, i);
            }
            d(projectItemBean, searchDataHolder.isRecommendProject, projectItemViewHolder.itemView, i);
        } else if (i2 == 4) {
            ((SearchTipViewHolder) viewHolder).a(searchDataHolder);
        } else if (i2 == 11) {
            ((SearchEggRecommendViewHolderV2) viewHolder).d(searchDataHolder.mSearchEggs);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174579624")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1174579624", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 0) {
            return new ProjectItemViewHolder(this.b, from);
        }
        if (i == 4) {
            return new SearchTipViewHolder(this.b, from, new a(this));
        }
        if (i != 11) {
            return null;
        }
        SearchEggRecommendViewHolderV2 searchEggRecommendViewHolderV2 = new SearchEggRecommendViewHolderV2(this.b, from);
        searchEggRecommendViewHolderV2.f(this.c);
        return searchEggRecommendViewHolderV2;
    }
}
