package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ProjectListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ProjectClickListener b;
    private Exposure c;
    private List<ProjectItemBean> d;

    /* compiled from: Taobao */
    public interface Exposure {
        void exposureProject(View view, ProjectItemBean projectItemBean, int i);
    }

    /* compiled from: Taobao */
    public interface ProjectClickListener {
        void onClick(int i, ProjectItemBean projectItemBean);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1110915163")) {
                ipChange.ipc$dispatch("1110915163", new Object[]{this, view});
                return;
            }
            ProjectListAdapter.this.b.onClick(this.a, (ProjectItemBean) ProjectListAdapter.this.d.get(this.a));
        }
    }

    public ProjectListAdapter(Context context, ProjectClickListener projectClickListener) {
        this.a = context;
        this.b = projectClickListener;
    }

    public void c(Exposure exposure) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649249734")) {
            ipChange.ipc$dispatch("-649249734", new Object[]{this, exposure});
            return;
        }
        this.c = exposure;
    }

    public void d(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907012574")) {
            ipChange.ipc$dispatch("1907012574", new Object[]{this, list});
            return;
        }
        this.d = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64548854")) {
            return ((Integer) ipChange.ipc$dispatch("-64548854", new Object[]{this})).intValue();
        }
        List<ProjectItemBean> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1261898319")) {
            return super.getItemViewType(i);
        }
        return ((Integer) ipChange.ipc$dispatch("-1261898319", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532576593")) {
            ipChange.ipc$dispatch("-532576593", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ((ProjectItemViewHolder) viewHolder).l(this.d.get(i), BricksProjectViewHolder.PageType.SEARCH_PAGE);
        if (this.b != null) {
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setOnClickListener(new a(i));
        }
        this.c.exposureProject(viewHolder.itemView, this.d.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784922585")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-784922585", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        return new ProjectItemViewHolder(this.a, LayoutInflater.from(this.a));
    }
}
