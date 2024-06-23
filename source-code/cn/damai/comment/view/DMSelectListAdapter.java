package cn.damai.comment.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.DmInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class DMSelectListAdapter extends RecyclerView.Adapter<PublishDMSelectViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemClickListener a;
    @Nullable
    private DmInfo b;
    @Nullable
    private List<DmInfo> c;

    /* compiled from: Taobao */
    public static final class a implements OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMSelectListAdapter a;

        a(DMSelectListAdapter dMSelectListAdapter) {
            this.a = dMSelectListAdapter;
        }

        @Override // cn.damai.comment.view.OnItemClickListener
        public void onItemClick(@NotNull View view, int i, @Nullable DmInfo dmInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1283084188")) {
                ipChange.ipc$dispatch("-1283084188", new Object[]{this, view, Integer.valueOf(i), dmInfo});
                return;
            }
            k21.i(view, "itemView");
            DMSelectListAdapter dMSelectListAdapter = this.a;
            Long dmId = dmInfo != null ? dmInfo.getDmId() : null;
            DmInfo b = this.a.b();
            if (k21.d(dmId, b != null ? b.getDmId() : null)) {
                dmInfo = null;
            }
            dMSelectListAdapter.g(dmInfo);
            DMSelectListAdapter dMSelectListAdapter2 = this.a;
            dMSelectListAdapter2.notifyItemRangeChanged(0, dMSelectListAdapter2.getItemCount());
            OnItemClickListener a2 = this.a.a();
            if (a2 != null) {
                a2.onItemClick(view, i, this.a.b());
            }
        }
    }

    public DMSelectListAdapter(@Nullable OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
    }

    @Nullable
    public final OnItemClickListener a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1089802941")) {
            return this.a;
        }
        return (OnItemClickListener) ipChange.ipc$dispatch("1089802941", new Object[]{this});
    }

    @Nullable
    public final DmInfo b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1359936364")) {
            return this.b;
        }
        return (DmInfo) ipChange.ipc$dispatch("-1359936364", new Object[]{this});
    }

    /* renamed from: c */
    public void onBindViewHolder(@NotNull PublishDMSelectViewHolder publishDMSelectViewHolder, int i) {
        DmInfo dmInfo;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1320471803")) {
            ipChange.ipc$dispatch("-1320471803", new Object[]{this, publishDMSelectViewHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(publishDMSelectViewHolder, "viewHolder");
        List<DmInfo> list = this.c;
        if (list != null && (dmInfo = list.get(i)) != null) {
            Long dmId = dmInfo.getDmId();
            if (dmId != null) {
                DmInfo dmInfo2 = this.b;
                z = dmId.equals(dmInfo2 != null ? dmInfo2.getDmId() : null);
            }
            publishDMSelectViewHolder.c(dmInfo, z);
        }
    }

    @NotNull
    /* renamed from: d */
    public PublishDMSelectViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683793583")) {
            return (PublishDMSelectViewHolder) ipChange.ipc$dispatch("-683793583", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.view_dm_select_item_view, viewGroup, false);
        k21.h(inflate, "from(parent.context)\n   …item_view, parent, false)");
        return new PublishDMSelectViewHolder(inflate, new a(this));
    }

    public final void e(@Nullable List<DmInfo> list, @Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175959433")) {
            ipChange.ipc$dispatch("1175959433", new Object[]{this, list, dmInfo});
            return;
        }
        this.b = dmInfo;
        this.c = list;
        notifyDataSetChanged();
    }

    public final void f(@Nullable OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634722035")) {
            ipChange.ipc$dispatch("634722035", new Object[]{this, onItemClickListener});
            return;
        }
        this.a = onItemClickListener;
    }

    public final void g(@Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144689666")) {
            ipChange.ipc$dispatch("-144689666", new Object[]{this, dmInfo});
            return;
        }
        this.b = dmInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83774071")) {
            return ((Integer) ipChange.ipc$dispatch("83774071", new Object[]{this})).intValue();
        }
        List<DmInfo> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
