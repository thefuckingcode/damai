package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.StarBean;
import cn.damai.category.category.ui.viewholder.StarHolder;
import cn.damai.category.category.ui.viewholder.ToursHolder;
import cn.damai.category.category.ui.viewholder.VideoStarHolder;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ce2;
import tb.d20;
import tb.xf2;

/* compiled from: Taobao */
public class StarListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private View.OnClickListener e;
    private List<StarAndBrandItem> f = new ArrayList();
    private String g;
    private Daojishi h;
    private boolean i;
    private boolean j;

    public StarListAdapter(boolean z, Context context, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.a = context;
        this.g = str;
        this.d = onClickListener;
        this.c = onClickListener2;
        this.b = onClickListener3;
        this.e = onClickListener4;
        this.j = z;
    }

    public void a(List<StarAndBrandItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006393228")) {
            ipChange.ipc$dispatch("-1006393228", new Object[]{this, list});
        } else if (xf2.e(list) > 0) {
            this.f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(List<StarAndBrandItem> list, Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641111411")) {
            ipChange.ipc$dispatch("-1641111411", new Object[]{this, list, daojishi});
        } else if (xf2.e(list) > 0) {
            this.h = daojishi;
            this.f.clear();
            a(list);
        } else {
            this.f.clear();
            notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755004040")) {
            ipChange.ipc$dispatch("1755004040", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.i = z;
    }

    public void d(int i2) {
        StarAndBrandItem starAndBrandItem;
        StarBean starBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297975329")) {
            ipChange.ipc$dispatch("297975329", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.f != null) {
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                if (!(i3 != i2 || (starAndBrandItem = this.f.get(i3)) == null || (starBean = starAndBrandItem.starBean) == null)) {
                    starBean.followStatus = 1;
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "336745577")) {
            return xf2.e(this.f);
        }
        return ((Integer) ipChange.ipc$dispatch("336745577", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1565724016")) {
            return this.f.get(i2).type;
        }
        return ((Integer) ipChange.ipc$dispatch("-1565724016", new Object[]{this, Integer.valueOf(i2)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457797872")) {
            ipChange.ipc$dispatch("1457797872", new Object[]{this, viewHolder, Integer.valueOf(i2)});
        } else if (viewHolder != null) {
            StarAndBrandItem starAndBrandItem = this.f.get(i2);
            starAndBrandItem.position = i2;
            int i3 = starAndBrandItem.type;
            if (i3 == 2) {
                ((StarHolder) viewHolder).a(starAndBrandItem, i2, this.c);
                if (this.d != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.d);
                }
                if (starAndBrandItem.starBean != null) {
                    ce2.j(this.j, viewHolder.itemView, starAndBrandItem.index, d20.E(), starAndBrandItem.starBean.damaiId, this.g);
                }
            } else if (i3 == 4) {
                ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
                projectItemViewHolder.u(this.h);
                projectItemViewHolder.k(starAndBrandItem.projectItemBean);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
                if (starAndBrandItem.projectItemBean != null) {
                    ce2.k(this.j, viewHolder.itemView, starAndBrandItem.index, d20.E(), starAndBrandItem.projectItemBean.id, this.g);
                }
            } else if (i3 == 11) {
                ((VideoStarHolder) viewHolder).b(starAndBrandItem, this.h);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
            } else if (i3 == 12) {
                ((ToursHolder) viewHolder).a(starAndBrandItem, i2, this.i);
                if (this.b != null) {
                    viewHolder.itemView.setTag(starAndBrandItem);
                    viewHolder.itemView.setOnClickListener(this.b);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76222714")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-76222714", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i2 == 2) {
            return new StarHolder(from);
        }
        if (i2 == 4) {
            return new ProjectItemViewHolder(this.a, from);
        }
        if (i2 == 11) {
            return new VideoStarHolder(from);
        }
        if (i2 != 12) {
            return null;
        }
        return new ToursHolder(LayoutInflater.from(this.a).inflate(R$layout.category_star_jour_container_layout, viewGroup, false), this.g, this.e);
    }
}
