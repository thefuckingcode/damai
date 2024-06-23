package cn.damai.user.show.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.user.show.bean.ShowDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ShowDataHolder> a;
    private Context b;
    private View.OnClickListener c;
    HashMap<String, String> d = new HashMap<>();

    public ShowAdapter(Context context, List<ShowDataHolder> list, View.OnClickListener onClickListener) {
        this.b = context;
        this.a = list;
        this.c = onClickListener;
    }

    public List<ShowDataHolder> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1613296357")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("-1613296357", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-914906965")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-914906965", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1345211858")) {
            return this.a.get(i).mType;
        }
        return ((Integer) ipChange.ipc$dispatch("1345211858", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807342958")) {
            ipChange.ipc$dispatch("1807342958", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ShowDataHolder showDataHolder = this.a.get(i);
            if (showDataHolder.mType == 0) {
                ((ProjectItemViewHolder) viewHolder).k(showDataHolder.mProjectItem);
                if (this.c != null) {
                    viewHolder.itemView.setTag(Integer.valueOf(i));
                    viewHolder.itemView.setOnClickListener(this.c);
                }
                if (showDataHolder.mProjectItem != null) {
                    this.d.clear();
                    this.d.put("item_id", showDataHolder.mProjectItem.id);
                    this.d.put("contentlable", showDataHolder.mProjectItem.name);
                    if (!TextUtils.isEmpty(showDataHolder.mProjectItem.alg)) {
                        this.d.put("alg", showDataHolder.mProjectItem.alg);
                    }
                    if (!showDataHolder.isRecommendProject) {
                        c e = c.e();
                        View view = viewHolder.itemView;
                        e.G(view, "item_" + i, "list", "search", this.d);
                        return;
                    }
                    c e2 = c.e();
                    View view2 = viewHolder.itemView;
                    e2.G(view2, "item_" + i, "keywordother", "search", this.d);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3115448")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-3115448", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i != 0) {
            return null;
        }
        return new ProjectItemViewHolder(this.b, from);
    }
}
