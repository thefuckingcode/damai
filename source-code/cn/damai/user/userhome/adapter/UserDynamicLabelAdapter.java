package cn.damai.user.userhome.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.user.userhome.bean.UserDynamicContentBean;
import cn.damai.user.userhome.view.UserDynamicLabelViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class UserDynamicLabelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private View.OnClickListener a;
    private List<UserDynamicContentBean> b;

    public UserDynamicLabelAdapter(View.OnClickListener onClickListener, List<UserDynamicContentBean> list) {
        this.a = onClickListener;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1506094997")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("1506094997", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-806987844")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-806987844", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584171964")) {
            ipChange.ipc$dispatch("-1584171964", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ((UserDynamicLabelViewHolder) viewHolder).a(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1032381390")) {
            return new UserDynamicLabelViewHolder(viewGroup.getContext(), this.a);
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1032381390", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
