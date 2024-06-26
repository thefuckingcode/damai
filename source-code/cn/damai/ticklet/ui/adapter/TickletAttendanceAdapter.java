package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletContractResponse;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.lw2;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class TickletAttendanceAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<TickletContractResponse.IdInfosEntity> a = new ArrayList<>();
    private Context b;
    private OnSelectIdTypeChanged c;

    /* compiled from: Taobao */
    public interface OnSelectIdTypeChanged {
        void onChanged(int i);
    }

    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        DMIconFontTextView d;

        public ViewHolder(TickletAttendanceAdapter tickletAttendanceAdapter, View view) {
            super(view);
        }
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
            if (AndroidInstantRuntime.support(ipChange, "2007987338")) {
                ipChange.ipc$dispatch("2007987338", new Object[]{this, view});
            } else if (TickletAttendanceAdapter.this.c != null) {
                TickletAttendanceAdapter.this.c.onChanged(this.a);
            }
        }
    }

    public TickletAttendanceAdapter(Context context, ArrayList<TickletContractResponse.IdInfosEntity> arrayList) {
        this.b = context;
        this.a = arrayList;
    }

    /* renamed from: b */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367227553")) {
            ipChange.ipc$dispatch("-1367227553", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TickletContractResponse.IdInfosEntity idInfosEntity = this.a.get(i);
        if (idInfosEntity != null) {
            if (i == 0) {
                viewHolder.itemView.setPadding(0, v50.a(this.b, 26.0f), 0, v50.a(this.b, 26.0f));
            } else {
                viewHolder.itemView.setPadding(0, 0, 0, v50.a(this.b, 26.0f));
            }
            lw2.E(viewHolder.a, idInfosEntity.getMaskedName());
            lw2.E(viewHolder.c, idInfosEntity.getIdentityTypeName());
            lw2.E(viewHolder.b, idInfosEntity.getMaskedIdentityNo());
            if (idInfosEntity.isSelected()) {
                viewHolder.d.setText(this.b.getString(R$string.iconfont_gouxuan));
                viewHolder.d.setTextColor(this.b.getResources().getColor(R$color.color_FF2D79));
            } else {
                viewHolder.d.setText(this.b.getString(R$string.iconfont_weigouxuan));
                viewHolder.d.setTextColor(this.b.getResources().getColor(R$color.color_999999));
            }
            viewHolder.itemView.setOnClickListener(new a(i));
        }
    }

    /* renamed from: c */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714504247")) {
            return (ViewHolder) ipChange.ipc$dispatch("714504247", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_create_contacts_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (TextView) inflate.findViewById(R$id.ticklet_contacts_name);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_contacts_id_number);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_contacts_id_card_type);
        viewHolder.d = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_info_choose_btn);
        return viewHolder;
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308290479")) {
            ipChange.ipc$dispatch("-1308290479", new Object[]{this});
        } else if (xf2.e(this.a) > 0) {
            this.a.clear();
            notifyDataSetChanged();
        }
    }

    public void d(OnSelectIdTypeChanged onSelectIdTypeChanged) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706338978")) {
            ipChange.ipc$dispatch("1706338978", new Object[]{this, onSelectIdTypeChanged});
            return;
        }
        this.c = onSelectIdTypeChanged;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-425489863")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-425489863", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1191242749")) {
            return 0;
        }
        return ((Long) ipChange.ipc$dispatch("1191242749", new Object[]{this, Integer.valueOf(i)})).longValue();
    }
}
